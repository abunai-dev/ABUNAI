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
import org.dataflowanalysis.analysis.pcm.core.PCMTransposeFlowGraph;
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
import org.palladiosimulator.pcm.usagemodel.Start;
import org.palladiosimulator.pcm.usagemodel.UsagemodelFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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

    public List<PCMUncertainTransposeFlowGraph> applyUncertaintyScenario(UncertaintyScenario uncertaintyScenario, UncertainState uncertainState, PCMUncertainTransposeFlowGraph currentTransposeFlowGraph) {
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

        List<? extends AbstractPCMVertex<?>> callsIntoContext = affectedVertices.stream()
                    .filter(it -> it.getPreviousElements().stream().noneMatch(affectedVertices::contains))
                    .toList();

        List<ResourceDemandingSEFF> calledSEFFs = new ArrayList<>();
        calledSEFFs.addAll(callsIntoContext.stream()
            		.flatMap(it -> it.getPreviousElements().stream())
                    .filter(CallingUserPCMVertex.class::isInstance)
                    .map(CallingUserPCMVertex.class::cast)
                    .map(it -> {
                        var providedRole = it.getReferencedElement().getProvidedRole_EntryLevelSystemCall();
                        var signature = it.getReferencedElement().getOperationSignature__EntryLevelSystemCall();
                        var calledSEFF = PCMQueryUtils.findCalledSEFF(providedRole, signature, it.getContext()).orElseThrow();
                        return calledSEFF.seff();
                    }).toList());
        calledSEFFs.addAll(callsIntoContext.stream()
            		.flatMap(it -> it.getPreviousElements().stream())
                    .filter(CallingSEFFPCMVertex.class::isInstance)
                    .map(CallingSEFFPCMVertex.class::cast)
                    .map(it -> {
                        var requiredRole = it.getReferencedElement().getRole_ExternalService();
                        var signature = it.getReferencedElement().getCalledService_ExternalService();
                        var calledSEFF = PCMQueryUtils.findCalledSEFF(requiredRole, signature, it.getContext()).orElseThrow();
                        return calledSEFF.seff();
                    }).toList());
        if (calledSEFFs.isEmpty()) {
            logger.error("Component Uncertainty: No called SEFFs!");
            return List.of(currentTransposeFlowGraph);
        }

        List<PCMUncertainTransposeFlowGraph> result = new ArrayList<>();
        result.add(currentTransposeFlowGraph);
        for (int i = 0; i < calledSEFFs.size(); i++) {
            ResourceDemandingSEFF seff = calledSEFFs.get(i);
            StartAction startAction = PCMQueryUtils.getFirstStartActionInActionList(seff.getSteps_Behaviour()).get();
            StopAction stopAction = PCMQueryUtils.getFirstStopActionInActionList(seff.getSteps_Behaviour()).get();
            AbstractPCMVertex<?> call = result.stream()
                    .map(PCMUncertainTransposeFlowGraph::getVertices)
                    .flatMap(List::stream)
                    .filter(it -> it instanceof AbstractPCMVertex<?>)
                    .map(it -> (AbstractPCMVertex<?>) it)
                    .filter(it -> it.getReferencedElement().equals(startAction))
                    .findFirst().orElseThrow().copy(new IdentityHashMap<>());
            AbstractPCMVertex<?> returningVertex = result.stream()
                    .map(PCMUncertainTransposeFlowGraph::getVertices)
                    .flatMap(List::stream)
                    .filter(it -> it instanceof AbstractPCMVertex<?>)
                    .map(it -> (AbstractPCMVertex<?>) it)
                    .filter(it -> it.getReferencedElement().equals(stopAction))
                    .findFirst().orElseThrow().copy(new IdentityHashMap<>());

            PCMTransposeFlowGraphFinder finder = new PCMTransposeFlowGraphFinder(this.resourceProvider);
            List<PCMUncertainTransposeFlowGraph> replacements = finder.findTransposeFlowGraphs(List.of(stopAction), List.of(startAction)).stream()
                    .map(it -> new PCMUncertainTransposeFlowGraph(it.getSink(), this.relevantUncertaintySources, uncertainState))
                    .toList();
            replacements.stream()
                    .map(PCMTransposeFlowGraph::getVertices)
                    .flatMap(Collection::stream)
                    .filter(it -> it instanceof SEFFPCMVertex<?>)
                    .map(it -> (SEFFPCMVertex<?>) it)
                    .forEach(it -> {
                    	it.getContext().clear();
                        it.getContext().push(replacement);
                        it.getParameter().clear();
                        it.getParameter().addAll(((OperationSignature) seff.getDescribedService__SEFF()).getParameters__OperationSignature());
                    });
            List<PCMUncertainTransposeFlowGraph> replacementsWhole = result.stream().map(tfg -> {
                AbstractPCMVertex<?> callReplacement = replacements.stream()
                        .map(PCMUncertainTransposeFlowGraph::getVertices)
                        .flatMap(List::stream)
                        .filter(it -> it instanceof AbstractPCMVertex<?>)
                        .map(it -> (AbstractPCMVertex<?>) it)
                        .filter(it -> it.getReferencedElement().equals(startAction))
                        .findFirst().orElseThrow();
                callReplacement.setPreviousElements(call.getPreviousElements().stream().map(it -> it.copy(new HashMap<>())).toList());
                AbstractPCMVertex<?> returnReplacement = replacements.stream()
                        .map(PCMUncertainTransposeFlowGraph::getVertices)
                        .flatMap(List::stream)
                        .filter(it -> it instanceof AbstractPCMVertex<?>)
                        .map(it -> (AbstractPCMVertex<?>) it)
                        .filter(it -> it.getReferencedElement().equals(stopAction))
                        .findFirst().orElseThrow();
                Map<AbstractPCMVertex<?>, AbstractPCMVertex<?>> mapping = new HashMap<>();
                mapping.put(call, callReplacement);
                mapping.put(returningVertex, returnReplacement);
                return tfg.copy(mapping, uncertainState);
            }).toList();
            result = replacementsWhole;
        }
        return result;
    }

    public List<PCMUncertainTransposeFlowGraph> applyConnectorUncertaintyScenarioInEntryLevelSystemCall(PCMConnectorUncertaintyScenarioInEntryLevelSystemCall uncertaintyScenario, UncertainState uncertainState, PCMUncertainTransposeFlowGraph currentTransposeFlowGraph) {
        PCMConnectorUncertaintySourceInEntryLevelSystemCall uncertaintySource = (PCMConnectorUncertaintySourceInEntryLevelSystemCall) uncertaintyScenario.eContainer();
        EntryLevelSystemCall target = uncertaintySource.getTarget();
        EntryLevelSystemCall replacement = uncertaintyScenario.getTarget();

        Optional<CallingUserPCMVertex> commonCallingVertex = currentTransposeFlowGraph.getVertices().stream()
                .filter(CallingUserPCMVertex.class::isInstance)
                .map(CallingUserPCMVertex.class::cast)
                .filter(it -> it.getReferencedElement().equals(target))
                .filter(CallReturnBehavior::isCalling)
                .findAny();

        Optional<CallingUserPCMVertex> commonReturningVertex = currentTransposeFlowGraph.getVertices().stream()
                .filter(CallingUserPCMVertex.class::isInstance)
                .map(CallingUserPCMVertex.class::cast)
                .filter(it -> it.getReferencedElement().equals(target))
                .filter(CallReturnBehavior::isReturning)
                .findAny();


        if (commonCallingVertex.isEmpty() || commonReturningVertex.isEmpty()) {
            return List.of(currentTransposeFlowGraph.copy(new IdentityHashMap<>(), uncertainState));
        }

        var providedRole = replacement.getProvidedRole_EntryLevelSystemCall();
        var signature = replacement.getOperationSignature__EntryLevelSystemCall();
        var calledSEFF = PCMQueryUtils.findCalledSEFF(providedRole, signature, commonCallingVertex.get().getContext()).orElseThrow();

        StartAction startAction = PCMQueryUtils.getFirstStartActionInActionList(calledSEFF.seff().getSteps_Behaviour()).get();
        StopAction stopAction = PCMQueryUtils.getFirstStopActionInActionList(calledSEFF.seff().getSteps_Behaviour()).get();
        PCMTransposeFlowGraphFinder finder = new PCMTransposeFlowGraphFinder(this.resourceProvider);
        List<PCMUncertainTransposeFlowGraph> replacements = finder.findTransposeFlowGraphs(List.of(stopAction), List.of(startAction)).stream()
                .map(it -> new PCMUncertainTransposeFlowGraph(it.getSink(), this.relevantUncertaintySources, uncertainState))
                .toList();
        replacements.stream()
                .map(PCMUncertainTransposeFlowGraph::getVertices)
                .flatMap(Collection::stream)
                .filter(it -> it instanceof SEFFPCMVertex<?>)
                .map(it -> (SEFFPCMVertex<?>) it)
                .forEach(it -> {
                    it.getContext().clear();
                    it.getContext().addAll(calledSEFF.context());
                    it.getParameter().clear();
                    it.getParameter().addAll(((OperationSignature) calledSEFF.seff().getDescribedService__SEFF()).getParameters__OperationSignature());
                });
        List<PCMUncertainTransposeFlowGraph> results = new ArrayList<>();
        replacements.forEach(tfg -> {
            SEFFPCMVertex<?> startActionVertex = tfg.stream()
                    .filter(it -> it instanceof SEFFPCMVertex<?>)
                    .map(it -> (SEFFPCMVertex<?>) it)
                    .filter(it -> it.getReferencedElement().equals(startAction))
                    .findFirst().orElseThrow();
            AbstractPCMVertex<?> callReplacement = new CallingUserPCMVertex(replacement, commonCallingVertex.get().getPreviousElements(), true, this.resourceProvider);
            startActionVertex.setPreviousElements(List.of(callReplacement));
            AbstractPCMVertex<?> returnReplacement = new CallingUserPCMVertex(replacement, List.of(callReplacement, tfg.getSink()), false, this.resourceProvider);
            Map<AbstractPCMVertex<?>, AbstractPCMVertex<?>> mapping = new HashMap<>();
            mapping.put(commonCallingVertex.get(), callReplacement);
            mapping.put(commonReturningVertex.get(), returnReplacement);
            results.add(currentTransposeFlowGraph.copy(mapping, uncertainState));
        });
        return results;
    }
    public List<PCMUncertainTransposeFlowGraph> applyConnectorUncertaintyScenarioInExternalCall(PCMConnectorUncertaintyScenarioInExternalCall uncertaintyScenario, UncertainState uncertainState, PCMUncertainTransposeFlowGraph currentTransposeFlowGraph) {
        PCMConnectorUncertaintySourceInExternalCall uncertaintySource = (PCMConnectorUncertaintySourceInExternalCall) uncertaintyScenario.eContainer();
        ExternalCallAction target = uncertaintySource.getTarget();
        ExternalCallAction replacement = uncertaintyScenario.getTarget();

        Optional<CallingSEFFPCMVertex> commonCallingVertex = currentTransposeFlowGraph.getVertices().stream()
                .filter(CallingSEFFPCMVertex.class::isInstance)
                .map(CallingSEFFPCMVertex.class::cast)
                .filter(it -> it.getReferencedElement().equals(target))
                .filter(CallReturnBehavior::isCalling)
                .findAny();

        Optional<CallingSEFFPCMVertex> commonReturningVertex = currentTransposeFlowGraph.getVertices().stream()
                .filter(CallingSEFFPCMVertex.class::isInstance)
                .map(CallingSEFFPCMVertex.class::cast)
                .filter(it -> it.getReferencedElement().equals(target))
                .filter(CallReturnBehavior::isReturning)
                .findAny();
        
        if (commonCallingVertex.isEmpty() || commonReturningVertex.isEmpty()) {
        	return List.of(currentTransposeFlowGraph.copy(new IdentityHashMap<>(), uncertainState));
        }

        var requiredRole = replacement.getRole_ExternalService();
        var signature = replacement.getCalledService_ExternalService();
        var calledSEFF = PCMQueryUtils.findCalledSEFF(requiredRole, signature, commonCallingVertex.get().getContext()).orElseThrow();

        StartAction startAction = PCMQueryUtils.getFirstStartActionInActionList(calledSEFF.seff().getSteps_Behaviour()).get();
        StopAction stopAction = PCMQueryUtils.getFirstStopActionInActionList(calledSEFF.seff().getSteps_Behaviour()).get();
        PCMTransposeFlowGraphFinder finder = new PCMTransposeFlowGraphFinder(this.resourceProvider);
        List<PCMUncertainTransposeFlowGraph> replacements = finder.findTransposeFlowGraphs(List.of(stopAction), List.of(startAction)).stream()
                .map(it -> new PCMUncertainTransposeFlowGraph(it.getSink(), this.relevantUncertaintySources, uncertainState))
                .toList();
        replacements.stream()
                .map(PCMUncertainTransposeFlowGraph::getVertices)
                .flatMap(Collection::stream)
                .filter(it -> it instanceof SEFFPCMVertex<?>)
                .map(it -> (SEFFPCMVertex<?>) it)
                .forEach(it -> {
                    it.getContext().clear();
                    it.getContext().addAll(calledSEFF.context());
                    it.getParameter().clear();
                    it.getParameter().addAll(((OperationSignature) calledSEFF.seff().getDescribedService__SEFF()).getParameters__OperationSignature());
                });
        List<PCMUncertainTransposeFlowGraph> results = new ArrayList<>();
        replacements.forEach(tfg -> {
            SEFFPCMVertex<?> startActionVertex = tfg.stream()
                    .filter(it -> it instanceof SEFFPCMVertex<?>)
                    .map(it -> (SEFFPCMVertex<?>) it)
                    .filter(it -> it.getReferencedElement().equals(startAction))
                    .findFirst().orElseThrow();
            AbstractPCMVertex<?> callReplacement = new CallingSEFFPCMVertex(replacement, commonCallingVertex.get().getPreviousElements(), commonCallingVertex.get().getContext(), commonCallingVertex.get().getParameter(), true, this.resourceProvider);
            startActionVertex.setPreviousElements(List.of(callReplacement));
            AbstractPCMVertex<?> returnReplacement = new CallingSEFFPCMVertex(replacement, List.of(callReplacement, tfg.getSink()), commonReturningVertex.get().getContext(), commonReturningVertex.get().getParameter(), false, this.resourceProvider);
            Map<AbstractPCMVertex<?>, AbstractPCMVertex<?>> mapping = new HashMap<>();
            mapping.put(commonCallingVertex.get(), callReplacement);
            mapping.put(commonReturningVertex.get(), returnReplacement);
            results.add(currentTransposeFlowGraph.copy(mapping, uncertainState));
        });
        return results;
    }

    public PCMUncertainTransposeFlowGraph applyExternalUncertaintyScenarioInResource(PCMExternalUncertaintyScenarioInResource uncertaintyScenario, UncertainState uncertainState, PCMUncertainTransposeFlowGraph currentTransposeFlowGraph) {
        PCMExternalUncertaintySourceInResource uncertaintySource = (PCMExternalUncertaintySourceInResource) uncertaintyScenario.eContainer();
        ResourceAssignee target = uncertaintySource.getTarget();
        ResourceAssignee replacement = uncertaintyScenario.getTarget();
        AbstractPCMVertex<?> newSink = this.copyWithProxies(new HashMap<>(), currentTransposeFlowGraph.getSink(), target ,replacement);
        return new PCMUncertainTransposeFlowGraph(newSink, this.relevantUncertaintySources, uncertainState);
    }

    public PCMUncertainTransposeFlowGraph applyExternalUncertaintyScenarioInUsage(PCMExternalUncertaintyScenarioInUsage uncertaintyScenario, UncertainState uncertainState, PCMUncertainTransposeFlowGraph currentTransposeFlowGraph) {
        PCMExternalUncertaintySourceInUsage uncertaintySource = (PCMExternalUncertaintySourceInUsage) uncertaintyScenario.eContainer();
        UsageAssignee target = uncertaintySource.getTarget();
        UsageAssignee replacement = uncertaintyScenario.getTarget();
        AbstractPCMVertex<?> newSink = this.copyWithProxies(new HashMap<>(), currentTransposeFlowGraph.getSink(), target ,replacement);
        return new PCMUncertainTransposeFlowGraph(newSink, this.relevantUncertaintySources, uncertainState);
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

    private AbstractPCMVertex<?> copyWithProxies(Map<AbstractPCMVertex<?>, AbstractPCMVertex<?>> mapping, AbstractPCMVertex<?> vertex, AbstractAssignee target, AbstractAssignee replacement) {
        if (mapping.containsKey(vertex)) {
            return mapping.get(vertex);
        }
        List<? extends AbstractPCMVertex<?>> previousVertices = vertex.getPreviousElements().stream()
                .map(it -> copyWithProxies(mapping, it, target, replacement))
               .toList();

        if (vertex instanceof CallingUserPCMVertex callingUserVertex) {
            UncertainCallingUserPCMVertex replacingVertex = new UncertainCallingUserPCMVertex(callingUserVertex.getReferencedElement(), previousVertices, callingUserVertex.isCalling(), callingUserVertex.getResourceProvider(), Map.of(target, replacement));
            mapping.put(vertex, replacingVertex);
            return replacingVertex;
        } else if (vertex instanceof UserPCMVertex<?> userVertex) {
            UncertainUserPCMVertex<?> replacingVertex = new UncertainUserPCMVertex<AbstractUserAction>(userVertex.getReferencedElement(), previousVertices, userVertex.getResourceProvider(), Map.of(target, replacement));
            mapping.put(vertex, replacingVertex);
            return replacingVertex;
        } else if (vertex instanceof CallingSEFFPCMVertex callingSEFFVertex) {
            UncertainCallingSEFFPCMVertex replacingVertex = new UncertainCallingSEFFPCMVertex(callingSEFFVertex.getReferencedElement(), previousVertices, callingSEFFVertex.getContext(), callingSEFFVertex.getParameter(), callingSEFFVertex.isCalling(), callingSEFFVertex.getResourceProvider(), Map.of(target, replacement));
            mapping.put(vertex, replacingVertex);
            return replacingVertex;
        } else if (vertex instanceof SEFFPCMVertex<?> seffVertex) {
            UncertainSEFFPCMVertex<?> replacingVertex = new UncertainSEFFPCMVertex<AbstractAction>(seffVertex.getReferencedElement(), previousVertices, seffVertex.getContext(), seffVertex.getParameter(), seffVertex.getResourceProvider(), Map.of(target, replacement));
            mapping.put(vertex, replacingVertex);
            return replacingVertex;
        } else {
            throw new IllegalArgumentException("Unknown vertex type encountered");
        }
    }
}
