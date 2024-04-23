package dev.abunai.confidentiality.analysis.pcm;

import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.core.UncertaintyUtils;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.*;
import dev.abunai.confidentiality.analysis.pcm.proxy.UncertainCallingSEFFPCMVertex;
import dev.abunai.confidentiality.analysis.pcm.proxy.UncertainCallingUserPCMVertex;
import dev.abunai.confidentiality.analysis.pcm.proxy.UncertainSEFFPCMVertex;
import dev.abunai.confidentiality.analysis.pcm.proxy.UncertainUserPCMVertex;
import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.core.AbstractVertex;
import org.dataflowanalysis.analysis.pcm.core.AbstractPCMVertex;
import org.dataflowanalysis.analysis.pcm.core.CallReturnBehavior;
import org.dataflowanalysis.analysis.pcm.core.finder.PCMTransposeFlowGraphFinder;
import org.dataflowanalysis.analysis.pcm.core.seff.CallingSEFFPCMVertex;
import org.dataflowanalysis.analysis.pcm.core.seff.SEFFPCMVertex;
import org.dataflowanalysis.analysis.pcm.core.user.CallingUserPCMVertex;
import org.dataflowanalysis.analysis.pcm.core.user.UserPCMVertex;
import org.dataflowanalysis.analysis.pcm.utils.PCMQueryUtils;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.AbstractAssignee;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.ResourceAssignee;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.UsageAssignee;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.OperationRequiredRole;
import org.palladiosimulator.pcm.repository.OperationSignature;
import org.palladiosimulator.pcm.repository.Parameter;
import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.pcm.seff.ExternalCallAction;
import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF;
import org.palladiosimulator.pcm.seff.SeffFactory;
import org.palladiosimulator.pcm.seff.SetVariableAction;
import org.palladiosimulator.pcm.seff.StartAction;
import org.palladiosimulator.pcm.seff.StopAction;
import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;
import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;
import org.palladiosimulator.pcm.usagemodel.UsagemodelFactory;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PCMUncertaintyCalculator {
    private final Logger logger = Logger.getLogger(PCMUncertaintyCalculator.class);
    private final List<? extends UncertaintySource> relevantUncertaintySources;
    private final PCMUncertaintyResourceProvider resourceProvider;

    public PCMUncertaintyCalculator(List<? extends  UncertaintySource> relevantUncertaintySources, PCMUncertaintyResourceProvider resourceProvider) {
        this.relevantUncertaintySources = relevantUncertaintySources;
        this.resourceProvider = resourceProvider;
    }

    public List<PCMUncertainTransposeFlowGraph> determineAlternativePartialFlowGraphs(UncertainState state, PCMUncertainTransposeFlowGraph uncertainTransposeFlowGraph) {
        if (state.getSelectedUncertaintyScenarios().isEmpty()) {
            return List.of(uncertainTransposeFlowGraph.copy(new IdentityHashMap<>(), state));
        }

        List<PCMUncertainTransposeFlowGraph> currentTransposeFlowGraphs = List.of(uncertainTransposeFlowGraph);
        for (UncertaintyScenario uncertaintyScenario : state.getSelectedUncertaintyScenarios()) {
            currentTransposeFlowGraphs = currentTransposeFlowGraphs.stream()
                    .flatMap(it -> this.applyUncertaintyScenario(uncertaintyScenario, state, it).stream())
                    .toList();
        }
        return currentTransposeFlowGraphs;
    }

    private List<PCMUncertainTransposeFlowGraph> applyUncertaintyScenario(UncertaintyScenario uncertaintyScenario, UncertainState uncertainState, PCMUncertainTransposeFlowGraph currentTransposeFlowGraph) {
        if (uncertaintyScenario instanceof PCMBehaviorUncertaintyScenario castedScenario) {
            return List.of(applyBehaviourUncertaintyScenario(castedScenario, uncertainState, currentTransposeFlowGraph));
        } else if (uncertaintyScenario instanceof PCMComponentUncertaintyScenario castedScenario) {
            return applyComponentUncertaintyScenario(castedScenario, uncertainState, currentTransposeFlowGraph);
        } else if (uncertaintyScenario instanceof PCMConnectorUncertaintyScenarioInEntryLevelSystemCall castedScenario) {
            return applyConnectorUncertaintyScenarioInEntryLevelSystemCall(castedScenario, uncertainState, currentTransposeFlowGraph);
        } else if (uncertaintyScenario instanceof PCMConnectorUncertaintyScenarioInExternalCall castedScenario) {
            return applyConnectorUncertaintyScenarioInExternalCall(castedScenario, uncertainState, currentTransposeFlowGraph);
        } else if (uncertaintyScenario instanceof PCMExternalUncertaintyScenarioInResource castedScenario) {
            return List.of(applyExternalUncertaintyScenarioInResource(castedScenario, uncertainState, currentTransposeFlowGraph));
        } else if(uncertainState instanceof PCMExternalUncertaintyScenarioInUsage castedScenario) {
            return List.of(applyExternalUncertaintyScenarioInUsage(castedScenario, uncertainState, currentTransposeFlowGraph));
        } else if (uncertainState instanceof PCMInterfaceUncertaintyScenario castedScenario) {
            return List.of(applyInterfaceUncertaintyScenario(castedScenario, uncertainState, currentTransposeFlowGraph));
        } else {
            throw new IllegalArgumentException("Unexpected PCM uncertainty scenario: %s"
                    .formatted(UncertaintyUtils.getUncertaintyScenarioName(uncertaintyScenario)));
        }
    }

    private PCMUncertainTransposeFlowGraph applyBehaviourUncertaintyScenario(
            PCMBehaviorUncertaintyScenario uncertaintyScenario, UncertainState uncertainState, PCMUncertainTransposeFlowGraph currentTransposeFlowGraph) {
        PCMBehaviorUncertaintySource uncertaintySource = (PCMBehaviorUncertaintySource) uncertaintyScenario.eContainer();
        SetVariableAction target = uncertaintySource.getTarget();
        SetVariableAction replacement = uncertaintyScenario.getTarget();

        SEFFPCMVertex<?> targetVertex = currentTransposeFlowGraph.getVertices().stream()
                .filter(it -> (it instanceof SEFFPCMVertex<?>))
                .map(it -> (SEFFPCMVertex<?>) it)
                .filter(it -> it.getReferencedElement().equals(target))
                .findFirst().orElseThrow();
        AbstractPCMVertex<?> replacementVertex = new SEFFPCMVertex<>(replacement, targetVertex.getPreviousElements(), targetVertex.getContext(), targetVertex.getParameter(), targetVertex.getResourceProvider());

        Map<AbstractPCMVertex<?>, AbstractPCMVertex<?>> mapping = new IdentityHashMap<>();
        mapping.put(targetVertex, replacementVertex);

        return currentTransposeFlowGraph.copy(mapping, uncertainState);
    }


    public List<PCMUncertainTransposeFlowGraph> applyComponentUncertaintyScenario(PCMComponentUncertaintyScenario uncertaintyScenario, UncertainState uncertainState, PCMUncertainTransposeFlowGraph currentTransposeFlowGraph) {
        PCMComponentUncertaintySource uncertaintySource = (PCMComponentUncertaintySource) uncertaintyScenario.eContainer();
        AssemblyContext target = uncertaintySource.getTarget();
        AssemblyContext replacement = uncertaintyScenario.getTarget();

        List<? extends AbstractPCMVertex<?>> affectedVertices = currentTransposeFlowGraph.getVertices().stream()
                .filter(it -> it instanceof AbstractPCMVertex<?>)
                .map(it -> (AbstractPCMVertex<?>) it)
                .filter(it -> !it.getContext().isEmpty())
                .filter(it -> it.getContext().getFirst().equals(target))
                .toList();

        List<PCMUncertainTransposeFlowGraph> result = List.of(currentTransposeFlowGraph.copy(new IdentityHashMap<>(), uncertainState));
        while (!affectedVertices.isEmpty()) {
            List<? extends AbstractPCMVertex<?>> finalAffectedVertices = affectedVertices;
            List<? extends AbstractPCMVertex<?>> callsIntoContext = affectedVertices.stream()
                    .filter(it -> it.getPreviousElements().stream().noneMatch(finalAffectedVertices::contains))
                    .toList();

            List<ResourceDemandingSEFF> calledSEFFs = new ArrayList<>();
            calledSEFFs.addAll(callsIntoContext.stream()
                    .filter(CallingUserPCMVertex.class::isInstance)
                    .map(CallingUserPCMVertex.class::cast)
                    .map(it -> {
                        var providedRole = it.getReferencedElement().getProvidedRole_EntryLevelSystemCall();
                        var signature = it.getReferencedElement().getOperationSignature__EntryLevelSystemCall();
                        var modifiedContext = new ArrayDeque<>(it.getContext());
                        modifiedContext.pop();
                        modifiedContext.push(replacement);
                        var calledSEFF = PCMQueryUtils.findCalledSEFF(providedRole, signature, modifiedContext).orElseThrow();
                        return calledSEFF.seff();
                    }).toList());
            calledSEFFs.addAll(callsIntoContext.stream()
                    .filter(CallingSEFFPCMVertex.class::isInstance)
                    .map(CallingSEFFPCMVertex.class::cast)
                    .map(it -> {
                        var requiredRole = it.getReferencedElement().getRole_ExternalService();
                        var signature = it.getReferencedElement().getCalledService_ExternalService();
                        var modifiedContext = new ArrayDeque<>(it.getContext());
                        modifiedContext.pop();
                        modifiedContext.push(replacement);
                        var calledSEFF = PCMQueryUtils.findCalledSEFF(requiredRole, signature, modifiedContext).orElseThrow();
                        return calledSEFF.seff();
                    }).toList());
            if (calledSEFFs.isEmpty()) {
                break;
            }
            ResourceDemandingSEFF seff = calledSEFFs.get(0);
            AbstractPCMVertex<?> call = callsIntoContext.get(0);
            AbstractPCMVertex<?> returningVertex = result.stream()
                    .map(PCMUncertainTransposeFlowGraph::getVertices)
                    .flatMap(List::stream)
                    .filter(CallReturnBehavior.class::isInstance)
                    .map(CallReturnBehavior.class::cast)
                    .filter(CallReturnBehavior::isReturning)
                    .filter(it -> it instanceof AbstractPCMVertex<?>)
                    .map(it -> (AbstractPCMVertex<?>) it)
                    .filter(it -> it.getReferencedElement().equals(call.getReferencedElement()))
                    .findFirst().orElseThrow();
            result = this.determineFlowGraphsForSEFF(seff, call, returningVertex, uncertainState);

            affectedVertices = result.stream()
                    .map(PCMUncertainTransposeFlowGraph::getVertices)
                    .flatMap(List::stream)
                    .filter(it -> it instanceof AbstractPCMVertex<?>)
                    .map(it -> (AbstractPCMVertex<?>) it)
                    .filter(it -> !it.getContext().isEmpty())
                    .filter(it -> it.getContext().getFirst().equals(target))
                    .toList();
        }
        return result;
    }

    public List<PCMUncertainTransposeFlowGraph> applyConnectorUncertaintyScenarioInEntryLevelSystemCall(PCMConnectorUncertaintyScenarioInEntryLevelSystemCall uncertaintyScenario, UncertainState uncertainState, PCMUncertainTransposeFlowGraph currentTransposeFlowGraph) {
        PCMConnectorUncertaintySourceInEntryLevelSystemCall uncertaintySource = (PCMConnectorUncertaintySourceInEntryLevelSystemCall) uncertaintyScenario.eContainer();
        EntryLevelSystemCall target = uncertaintySource.getTarget();
        EntryLevelSystemCall replacement = uncertaintyScenario.getTarget();

        AbstractPCMVertex<?> commonCallingVertex = currentTransposeFlowGraph.getVertices().stream()
                .filter(CallingUserPCMVertex.class::isInstance)
                .map(CallingUserPCMVertex.class::cast)
                .filter(it -> it.getReferencedElement().equals(target))
                .filter(CallReturnBehavior::isCalling)
                .findAny().orElseThrow();

        AbstractPCMVertex<?> commonReturningVertex = currentTransposeFlowGraph.getVertices().stream()
                .filter(CallingUserPCMVertex.class::isInstance)
                .map(CallingUserPCMVertex.class::cast)
                .filter(it -> it.getReferencedElement().equals(target))
                .filter(CallReturnBehavior::isReturning)
                .findAny().orElseThrow();

        var providedRole = replacement.getProvidedRole_EntryLevelSystemCall();
        var signature = replacement.getOperationSignature__EntryLevelSystemCall();
        var calledSEFF = PCMQueryUtils.findCalledSEFF(providedRole, signature, commonCallingVertex.getContext()).orElseThrow();

        return this.determineFlowGraphsForSEFF(calledSEFF.seff(), commonCallingVertex, commonReturningVertex, uncertainState);
    }
    public List<PCMUncertainTransposeFlowGraph> applyConnectorUncertaintyScenarioInExternalCall(PCMConnectorUncertaintyScenarioInExternalCall uncertaintyScenario, UncertainState uncertainState, PCMUncertainTransposeFlowGraph currentTransposeFlowGraph) {
        PCMConnectorUncertaintySourceInExternalCall uncertaintySource = (PCMConnectorUncertaintySourceInExternalCall) uncertaintyScenario.eContainer();
        ExternalCallAction target = uncertaintySource.getTarget();
        ExternalCallAction replacement = uncertaintyScenario.getTarget();

        AbstractPCMVertex<?> commonCallingVertex = currentTransposeFlowGraph.getVertices().stream()
                .filter(CallingSEFFPCMVertex.class::isInstance)
                .map(CallingSEFFPCMVertex.class::cast)
                .filter(it -> it.getReferencedElement().equals(target))
                .filter(CallReturnBehavior::isCalling)
                .findAny().orElseThrow();

        AbstractPCMVertex<?> commonReturningVertex = currentTransposeFlowGraph.getVertices().stream()
                .filter(CallingSEFFPCMVertex.class::isInstance)
                .map(CallingSEFFPCMVertex.class::cast)
                .filter(it -> it.getReferencedElement().equals(target))
                .filter(CallReturnBehavior::isReturning)
                .findAny().orElseThrow();

        var requiredRole = replacement.getRole_ExternalService();
        var signature = replacement.getCalledService_ExternalService();
        var calledSEFF = PCMQueryUtils.findCalledSEFF(requiredRole, signature, commonCallingVertex.getContext()).orElseThrow();
        return this.determineFlowGraphsForSEFF(calledSEFF.seff(), commonCallingVertex, commonReturningVertex, uncertainState);
    }

    private List<PCMUncertainTransposeFlowGraph> determineFlowGraphsForSEFF(ResourceDemandingSEFF calledSEFF, AbstractPCMVertex<?> callingVertex, AbstractPCMVertex<?> returningVertex, UncertainState uncertainState) {
        StartAction startAction = PCMQueryUtils.getFirstStartActionInActionList(calledSEFF.getSteps_Behaviour())
                .orElseThrow();
        StopAction stopAction = calledSEFF.getSteps_Behaviour().stream()
                .filter(StopAction.class::isInstance)
                .map(StopAction.class::cast)
                .reduce((first, second) -> second)
                .orElseThrow();
        PCMTransposeFlowGraphFinder finder = new PCMTransposeFlowGraphFinder(this.resourceProvider);
        List<PCMUncertainTransposeFlowGraph> transposeFlowGraphs = finder.findTransposeFlowGraphs(List.of(stopAction), List.of(startAction)).stream()
                .map(it -> new PCMUncertainTransposeFlowGraph(it.getSink(), this.relevantUncertaintySources, uncertainState))
                .toList();
        transposeFlowGraphs
                .forEach(it -> it.getVertices().stream().filter(AbstractVertex::isSource).map(vertex -> (AbstractPCMVertex<?>) vertex).findFirst().orElseThrow().setPreviousElements(List.of(callingVertex.copy(new IdentityHashMap<>()))));
        transposeFlowGraphs
                .forEach(it -> returningVertex.setPreviousElements(List.of(it.getSink())));
        return transposeFlowGraphs;
    }

    public PCMUncertainTransposeFlowGraph applyExternalUncertaintyScenarioInResource(PCMExternalUncertaintyScenarioInResource uncertaintyScenario, UncertainState uncertainState, PCMUncertainTransposeFlowGraph currentTransposeFlowGraph) {
        PCMExternalUncertaintySourceInResource uncertaintySource = (PCMExternalUncertaintySourceInResource) uncertaintyScenario.eContainer();
        ResourceAssignee target = uncertaintySource.getTarget();
        ResourceAssignee replacement = uncertaintyScenario.getTarget();
        return currentTransposeFlowGraph.copy(this.createMappingForExternalUncertainty(currentTransposeFlowGraph, target, replacement), uncertainState);
    }

    public PCMUncertainTransposeFlowGraph applyExternalUncertaintyScenarioInUsage(PCMExternalUncertaintyScenarioInUsage uncertaintyScenario, UncertainState uncertainState, PCMUncertainTransposeFlowGraph currentTransposeFlowGraph) {
        PCMExternalUncertaintySourceInUsage uncertaintySource = (PCMExternalUncertaintySourceInUsage) uncertaintyScenario.eContainer();
        UsageAssignee target = uncertaintySource.getTarget();
        UsageAssignee replacement = uncertaintyScenario.getTarget();
        return currentTransposeFlowGraph.copy(this.createMappingForExternalUncertainty(currentTransposeFlowGraph, target, replacement), uncertainState);
    }

    public PCMUncertainTransposeFlowGraph applyInterfaceUncertaintyScenario(PCMInterfaceUncertaintyScenario uncertaintyScenario, UncertainState uncertainState, PCMUncertainTransposeFlowGraph currentTransposeFlowGraph) {
        PCMInterfaceUncertaintySource uncertaintySource = (PCMInterfaceUncertaintySource) uncertaintyScenario.eContainer();
        OperationSignature target = uncertaintySource.getTarget();
        OperationSignature replacement = uncertaintyScenario.getTarget();
        Map<AbstractPCMVertex<?>, AbstractPCMVertex<?>> mapping = new IdentityHashMap<>();

        var userVertices = currentTransposeFlowGraph.getVertices().stream()
                .filter(CallingUserPCMVertex.class::isInstance)
                .map(CallingUserPCMVertex.class::cast)
                .filter(CallingUserPCMVertex::isCalling)
                .filter(it -> it.getReferencedElement().getOperationSignature__EntryLevelSystemCall().equals(target))
                .toList();
        var seffVertices = currentTransposeFlowGraph.getVertices().stream()
                .filter(CallingSEFFPCMVertex.class::isInstance)
                .map(CallingSEFFPCMVertex.class::cast)
                .filter(CallingSEFFPCMVertex::isCalling)
                .filter(it -> it.getReferencedElement().getCalledService_ExternalService().equals(target))
                .toList();
        if (userVertices.isEmpty() && seffVertices.isEmpty()) {
            logger.error("PCM Interface uncertainty does not target any vertices in the current transpose flow graph");
            throw new IllegalStateException();
        }

        userVertices.forEach(vertex -> {
            EntryLevelSystemCall entryLevelSystemCall = UsagemodelFactory.eINSTANCE.createEntryLevelSystemCall();
            entryLevelSystemCall.setOperationSignature__EntryLevelSystemCall(replacement);
            entryLevelSystemCall.setProvidedRole_EntryLevelSystemCall(vertex.getReferencedElement().getProvidedRole_EntryLevelSystemCall());
            entryLevelSystemCall.setPredecessor(vertex.getReferencedElement().getPredecessor());
            entryLevelSystemCall.setEntityName(vertex.getReferencedElement().getEntityName());
            entryLevelSystemCall.setScenarioBehaviour_AbstractUserAction(vertex.getReferencedElement().getScenarioBehaviour_AbstractUserAction());
            entryLevelSystemCall.setSuccessor(vertex.getReferencedElement().getSuccessor());
            entryLevelSystemCall.getInputParameterUsages_EntryLevelSystemCall().addAll(vertex.getReferencedElement().getInputParameterUsages_EntryLevelSystemCall());
            entryLevelSystemCall.getOutputParameterUsages_EntryLevelSystemCall().addAll(vertex.getReferencedElement().getOutputParameterUsages_EntryLevelSystemCall());
            mapping.put(vertex, new CallingUserPCMVertex(entryLevelSystemCall, vertex.getPreviousElements(), vertex.isCalling(), vertex.getResourceProvider()));
        });

        seffVertices.forEach(vertex -> {
            ExternalCallAction externalCallAction = SeffFactory.eINSTANCE.createExternalCallAction();
            externalCallAction.setEntityName(vertex.getReferencedElement().getEntityName());
            externalCallAction.setCalledService_ExternalService(replacement);
            externalCallAction.setRole_ExternalService(vertex.getReferencedElement().getRole_ExternalService());
            externalCallAction.setPredecessor_AbstractAction(vertex.getReferencedElement().getPredecessor_AbstractAction());
            externalCallAction.setResourceDemandingBehaviour_AbstractAction(vertex.getReferencedElement().getResourceDemandingBehaviour_AbstractAction());
            externalCallAction.setSuccessor_AbstractAction(vertex.getReferencedElement().getSuccessor_AbstractAction());
            externalCallAction.getInputVariableUsages__CallAction().addAll(vertex.getReferencedElement().getInputVariableUsages__CallAction());
            externalCallAction.getReturnVariableUsage__CallReturnAction().addAll(vertex.getReferencedElement().getReturnVariableUsage__CallReturnAction());
            List<Parameter> parameters = replacement.getParameters__OperationSignature();
            mapping.put(vertex, new CallingSEFFPCMVertex(externalCallAction, vertex.getPreviousElements(), vertex.getContext(), parameters, vertex.isCalling(), vertex.getResourceProvider()));
        });

        return currentTransposeFlowGraph.copy(mapping, uncertainState);
    }

    private Map<AbstractPCMVertex<?>, AbstractPCMVertex<?>> createMappingForExternalUncertainty(PCMUncertainTransposeFlowGraph currentTransposeFlowGraph, AbstractAssignee target, AbstractAssignee replacement) {
        Map<AbstractPCMVertex<?>, AbstractPCMVertex<?>> mapping = new IdentityHashMap<>();
        currentTransposeFlowGraph.getVertices().stream()
                .filter(it -> it instanceof SEFFPCMVertex<?>)
                .map(it -> (SEFFPCMVertex<?>) it)
                .forEach(it -> mapping.put(it, new UncertainSEFFPCMVertex<AbstractAction>(it.getReferencedElement(), it.getPreviousElements(), it.getContext(), it.getParameter(), it.getResourceProvider(), Map.of(target, replacement))));
        currentTransposeFlowGraph.getVertices().stream()
                .filter(CallingSEFFPCMVertex.class::isInstance)
                .map(CallingSEFFPCMVertex.class::cast)
                .forEach(it -> mapping.put(it, new UncertainCallingSEFFPCMVertex(it.getReferencedElement(), it.getPreviousElements(), it.getContext(), it.getParameter(), it.isCalling(), it.getResourceProvider(), Map.of(target, replacement))));
        currentTransposeFlowGraph.getVertices().stream()
                .filter(it -> it instanceof UserPCMVertex<?>)
                .map(it -> (UserPCMVertex<?>) it)
                .forEach(it -> mapping.put(it, new UncertainUserPCMVertex<AbstractUserAction>(it.getReferencedElement(), it.getPreviousElements(), it.getResourceProvider(), Map.of(target, replacement))));
        currentTransposeFlowGraph.getVertices().stream()
                .filter(CallingUserPCMVertex.class::isInstance)
                .map(CallingUserPCMVertex.class::cast)
                .forEach(it -> mapping.put(it, new UncertainCallingUserPCMVertex(it.getReferencedElement(), it.getPreviousElements(), it.isCalling(), it.getResourceProvider(), Map.of(target, replacement))));
        return mapping;
    }
}
