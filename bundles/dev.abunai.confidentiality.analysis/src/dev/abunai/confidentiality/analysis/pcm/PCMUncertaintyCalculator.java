package dev.abunai.confidentiality.analysis.pcm;

import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.core.UncertainTransposeFlowGraph;
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
import org.dataflowanalysis.analysis.pcm.utils.SEFFWithContext;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.AbstractAssignee;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.ResourceAssignee;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.UsageAssignee;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.entity.Entity;
import org.palladiosimulator.pcm.parameter.VariableUsage;
import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.repository.OperationInterface;
import org.palladiosimulator.pcm.repository.OperationProvidedRole;
import org.palladiosimulator.pcm.repository.OperationRequiredRole;
import org.palladiosimulator.pcm.repository.OperationSignature;
import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.pcm.seff.ExternalCallAction;
import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF;
import org.palladiosimulator.pcm.seff.SeffFactory;
import org.palladiosimulator.pcm.seff.SetVariableAction;
import org.palladiosimulator.pcm.seff.StartAction;
import org.palladiosimulator.pcm.seff.StopAction;
import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;
import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *This class is used to calculate the impact of uncertainties in a PCM model
 */
public class PCMUncertaintyCalculator {
    private final Logger logger = Logger.getLogger(PCMUncertaintyCalculator.class);
    private final List<? extends UncertaintySource> relevantUncertaintySources;
    private final PCMUncertaintyResourceProvider resourceProvider;

    /**
     * Create a new uncertainty calculator with the given relevant uncertainty sources and resource provider
     * @param relevantUncertaintySources Relevant uncertainty sources
     * @param resourceProvider Resource provider
     */
    public PCMUncertaintyCalculator(List<? extends  UncertaintySource> relevantUncertaintySources, PCMUncertaintyResourceProvider resourceProvider) {
        this.relevantUncertaintySources = relevantUncertaintySources;
        this.resourceProvider = resourceProvider;
    }

    /**
     * Apply a given uncertainty scenario to the given transpose flow graph and add the given uncertain state
     * @param uncertaintyScenario Given uncertainty scenario which is applied
     * @param uncertainState Uncertain state that is applied to the resulting transpose flow graphs
     * @param currentTransposeFlowGraph Transpose flow graph to which the uncertainties are applied
     * @return Returns a list of transpose flow graph that have the uncertainty scenario and uncertain state applied
     */
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
        } else if(uncertaintyScenario instanceof PCMExternalUncertaintyScenarioInUsage castedScenario) {
            return List.of(applyExternalUncertaintyScenarioInUsage(castedScenario, uncertainState, currentTransposeFlowGraph));
        } else if (uncertaintyScenario instanceof PCMInterfaceUncertaintyScenario castedScenario) {
            return applyInterfaceUncertaintyScenario(castedScenario, uncertainState, currentTransposeFlowGraph);
        } else {
            throw new IllegalArgumentException("Unexpected PCM uncertainty scenario: %s"
                    .formatted(UncertaintyUtils.getUncertaintyScenarioName(uncertaintyScenario)));
        }
    }

    /**
     * Applies a behavior uncertainty to the given transpose flow graph and applies the uncertain state
     * @param uncertaintyScenario Behavior uncertainty that is applied
     * @param uncertainState Uncertain state of the resulting transpose flow graphs
     * @param currentTransposeFlowGraph Transpose flow graph to which the behavior is applied
     * @return Returns a transpose flow graph with the behavior uncertainty applied
     */
    private PCMUncertainTransposeFlowGraph applyBehaviourUncertaintyScenario(
            PCMBehaviorUncertaintyScenario uncertaintyScenario, UncertainState uncertainState, PCMUncertainTransposeFlowGraph currentTransposeFlowGraph) {
        PCMBehaviorUncertaintySource uncertaintySource = (PCMBehaviorUncertaintySource) uncertaintyScenario.eContainer();
        SetVariableAction target = uncertaintySource.getTarget();
        SetVariableAction replacement = uncertaintyScenario.getTarget();

        SEFFPCMVertex<?> targetVertex = this.getReferencedVertices(target, currentTransposeFlowGraph.getVertices(),
                it -> it instanceof SEFFPCMVertex<?>, it -> (SEFFPCMVertex<?>) it).orElseThrow();
        Map<AbstractPCMVertex<?>, AbstractPCMVertex<?>> mapping = new HashMap<>();
        AbstractPCMVertex<?> replacementVertex = new SEFFPCMVertex<>(replacement, targetVertex.getPreviousElements().stream().map(it -> it.copy(mapping)).toList(), targetVertex.getContext(), targetVertex.getParameter(), targetVertex.getResourceProvider());
        mapping.put(targetVertex, replacementVertex);

        return currentTransposeFlowGraph.copy(mapping, uncertainState);
    }


    /**
     * Applies a component uncertainty to the given transpose flow graph and applies the uncertain state
     * @param uncertaintyScenario Component uncertainty that is applied
     * @param uncertainState Uncertain state of the resulting transpose flow graphs
     * @param currentTransposeFlowGraph Transpose flow graph to which the behavior is applied
     * @return Returns transpose flow graphs with the component uncertainty applied
     */
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

        List<ResourceDemandingSEFF> calledSEFFs = getCalledSEFFs(callsIntoContext);
        if (calledSEFFs.isEmpty()) {
            logger.error("Component Uncertainty: No called SEFFs!");
            return List.of(currentTransposeFlowGraph);
        }

        AtomicReference<List<PCMUncertainTransposeFlowGraph>> result = new AtomicReference<>(new ArrayList<>());
        result.get().add(currentTransposeFlowGraph);
        calledSEFFs.forEach(seff -> getReplacementsForSEFFCall(uncertainState, seff, result, List.of(replacement), currentTransposeFlowGraph));
        return result.get();
    }

    /**
     * Returns transpose flow graph replacements for a seff given the already replaced flow graphs and assembly context replacement
     * @param uncertainState Uncertain state of the resulting transpose flow graphs
     * @param seff SEFF that is replaced
     * @param result Reference in which the results for the replacement should be placed
     * @param context Replacement assembly contexts
     */
    private void getReplacementsForSEFFCall(UncertainState uncertainState, ResourceDemandingSEFF seff, AtomicReference<List<PCMUncertainTransposeFlowGraph>> result, Collection<AssemblyContext> context, PCMUncertainTransposeFlowGraph uncertainTransposeFlowGraph) {
        StartAction startAction = PCMQueryUtils.getFirstStartActionInActionList(seff.getSteps_Behaviour()).orElseThrow();
        StopAction stopAction = PCMQueryUtils.getFirstStopActionInActionList(seff.getSteps_Behaviour()).orElseThrow();

        List<? extends AbstractVertex<?>> vertices = result.get().stream()
                .map(PCMUncertainTransposeFlowGraph::getVertices)
                .flatMap(List::stream)
                .toList();

        AbstractPCMVertex<?> call = this.getReferencedVertices(startAction, vertices).orElseThrow();
        AbstractPCMVertex<?> returningVertex = this.getReferencedVertices(stopAction, vertices).orElseThrow();

        OperationSignature signature = (OperationSignature) seff.getDescribedService__SEFF();
        PCMTransposeFlowGraphFinder finder = new PCMTransposeFlowGraphFinder(this.resourceProvider, context, signature.getParameters__OperationSignature());
        List<PCMUncertainTransposeFlowGraph> replacements = finder.findTransposeFlowGraphs(List.of(stopAction), List.of(startAction)).stream()
                .map(it -> new PCMUncertainTransposeFlowGraph(it.getSink(), this.relevantUncertaintySources, uncertainState, uncertainTransposeFlowGraph.getUncertaintySourceManager()))
                .toList();
        
        result.set(result.get().stream().map(tfg -> {
            List<? extends AbstractVertex<?>> replacementVertices = replacements.stream()
                    .map(PCMUncertainTransposeFlowGraph::getVertices)
                    .flatMap(List::stream)
                    .toList();
            AbstractPCMVertex<?> callReplacement = this.getReferencedVertices(startAction, replacementVertices).orElseThrow();
            Map<AbstractPCMVertex<?>, AbstractPCMVertex<?>> mapping = new HashMap<>();
            callReplacement.setPreviousElements(call.getPreviousElements().stream().map(it -> it.copy(mapping)).toList());
            AbstractPCMVertex<?> returnReplacement = this.getReferencedVertices(stopAction, replacementVertices).orElseThrow();
            mapping.put(call, callReplacement);
            mapping.put(returningVertex, returnReplacement);
            return tfg.copy(mapping, uncertainState);
        }).toList());
    }

    /**
     * Returns transpose flow graph replacements for a seff given the targets and replacements
     * @param uncertainState Uncertain state of the resulting transpose flow graphs
     * @param currentTransposeFlowGraph Transpose flow graph which is affected by the replacement
     * @param callReplacement Call vertex that will replace the target calling vertex
     * @param returnReplacement Returning vertex that will replace the target returning vertex
     * @param calledSEFF SEFF that is called
     * @param callTarget Call vertex that will be replaced by the replacement
     * @param returnTarget Returning vertex that will be replaced by the replacement
     * @return Returns a list of transpose flow graph, in which the SEFF has been replaced
     */
    private List<PCMUncertainTransposeFlowGraph> getSEFFReplacementStart(UncertainState uncertainState, PCMUncertainTransposeFlowGraph currentTransposeFlowGraph, AbstractPCMVertex<?> callReplacement, AbstractPCMVertex<?> returnReplacement, SEFFWithContext calledSEFF, AbstractPCMVertex<?> callTarget, AbstractPCMVertex<?> returnTarget, Map<AbstractPCMVertex<?>, AbstractPCMVertex<?>> mapping) {
        StartAction startAction = PCMQueryUtils.getFirstStartActionInActionList(calledSEFF.seff().getSteps_Behaviour()).orElseThrow();
        StopAction stopAction = PCMQueryUtils.getFirstStopActionInActionList(calledSEFF.seff().getSteps_Behaviour()).orElseThrow();

        OperationSignature signature =  (OperationSignature) calledSEFF.seff().getDescribedService__SEFF();
        PCMTransposeFlowGraphFinder finder = new PCMTransposeFlowGraphFinder(this.resourceProvider, calledSEFF.context(), signature.getParameters__OperationSignature());
        List<PCMUncertainTransposeFlowGraph> replacements = finder.findTransposeFlowGraphs(List.of(stopAction), List.of(startAction)).stream()
                .map(it -> new PCMUncertainTransposeFlowGraph(it.getSink(), this.relevantUncertaintySources, uncertainState, currentTransposeFlowGraph.getUncertaintySourceManager()))
                .toList();

        List<PCMUncertainTransposeFlowGraph> results = new ArrayList<>();
        replacements.forEach(tfg -> {
            SEFFPCMVertex<?> startActionVertex = this.getReferencedVertices(startAction, tfg.getVertices(),
                    it -> it instanceof SEFFPCMVertex<?>, it -> (SEFFPCMVertex<?>) it)
                    .orElseThrow();
            startActionVertex.setPreviousElements(List.of(callReplacement));
            returnReplacement.setPreviousElements(List.of(callReplacement, tfg.getSink()));
            mapping.put(callTarget, callReplacement);
            mapping.put(returnTarget, returnReplacement);
            results.add(currentTransposeFlowGraph.copy(mapping, uncertainState));
        });
        return results;
    }

    /**
     * Get all called SEFFs given a list of vertices that call into a given context
     * @param callsIntoContext List of vertices that call into a given context
     * @return Returns a list of all SEFFs with the given vertices as call
     */
    private List<ResourceDemandingSEFF> getCalledSEFFs(List<? extends AbstractPCMVertex<?>> callsIntoContext) {
        List<ResourceDemandingSEFF> calledSEFFs = new ArrayList<>();
        calledSEFFs.addAll(callsIntoContext.stream()
            		.flatMap(it -> it.getPreviousElements().stream())
                    .filter(CallingUserPCMVertex.class::isInstance)
                    .map(CallingUserPCMVertex.class::cast)
                    .map(it -> getCalledSEFF(it, it.getReferencedElement().getProvidedRole_EntryLevelSystemCall()))
                    .toList());
        calledSEFFs.addAll(callsIntoContext.stream()
            		.flatMap(it -> it.getPreviousElements().stream())
                    .filter(CallingSEFFPCMVertex.class::isInstance)
                    .map(CallingSEFFPCMVertex.class::cast)
                    .map(it -> getCalledSEFF(it, it.getReferencedElement().getRole_ExternalService()))
                .toList());
        return calledSEFFs;
    }

    /**
     * Returns the called seff of a vertex with the given provided role
     * @param vertex Vertex of the caller
     * @param providedRole  Provided role of the component
     * @return Returns a SEFF with the calling vertex and provided role
     */
    private ResourceDemandingSEFF getCalledSEFF(CallingUserPCMVertex vertex, OperationProvidedRole providedRole) {
        var signature = vertex.getReferencedElement().getOperationSignature__EntryLevelSystemCall();
        var calledSEFF = PCMQueryUtils.findCalledSEFF(providedRole, signature, vertex.getContext()).orElseThrow();
        return calledSEFF.seff();
    }

    /**
     * Returns the called seff of a vertex with the given required role
     * @param vertex Vertex of the caller
     * @param requiredRole Required required role
     * @return Returns a SEFF with the calling vertex and required role
     */
    private static ResourceDemandingSEFF getCalledSEFF(CallingSEFFPCMVertex vertex, OperationRequiredRole requiredRole) {
        var signature = vertex.getReferencedElement().getCalledService_ExternalService();
        var calledSEFF = PCMQueryUtils.findCalledSEFF(requiredRole, signature, vertex.getContext()).orElseThrow();
        return calledSEFF.seff();
    }

    /**
     * Applies a connector uncertainty in an entry level system call to the given transpose flow graph and applies the uncertain state
     * @param uncertaintyScenario Connector uncertainty that is applied
     * @param uncertainState Uncertain state of the resulting transpose flow graphs
     * @param currentTransposeFlowGraph Transpose flow graph to which the behavior is applied
     * @return Returns a transpose flow graph with the connector uncertainty applied
     */
    public List<PCMUncertainTransposeFlowGraph> applyConnectorUncertaintyScenarioInEntryLevelSystemCall(PCMConnectorUncertaintyScenarioInEntryLevelSystemCall uncertaintyScenario, UncertainState uncertainState, PCMUncertainTransposeFlowGraph currentTransposeFlowGraph) {
        PCMConnectorUncertaintySourceInEntryLevelSystemCall uncertaintySource = (PCMConnectorUncertaintySourceInEntryLevelSystemCall) uncertaintyScenario.eContainer();
        EntryLevelSystemCall target = uncertaintySource.getTarget();
        EntryLevelSystemCall replacement = uncertaintyScenario.getTarget();

        Optional<? extends CallingUserPCMVertex> commonCallingVertex = this.getReferencedVertices(target, currentTransposeFlowGraph.getVertices(),
                it -> it instanceof CallingUserPCMVertex vertex && vertex.isCalling(), CallingUserPCMVertex.class::cast);

        Optional<? extends CallingUserPCMVertex> commonReturningVertex = this.getReferencedVertices(target, currentTransposeFlowGraph.getVertices(),
                it -> it instanceof CallingUserPCMVertex vertex && vertex.isReturning(), CallingUserPCMVertex.class::cast);


        if (commonCallingVertex.isEmpty() || commonReturningVertex.isEmpty()) {
            return List.of(currentTransposeFlowGraph.copy(new IdentityHashMap<>(), uncertainState));
        }

        var providedRole = replacement.getProvidedRole_EntryLevelSystemCall();
        var signature = replacement.getOperationSignature__EntryLevelSystemCall();
        var calledSEFF = PCMQueryUtils.findCalledSEFF(providedRole, signature, commonCallingVertex.get().getContext()).orElseThrow();


        Map<AbstractPCMVertex<?>, AbstractPCMVertex<?>> mapping = new HashMap<>();
        AbstractPCMVertex<?> callReplacement = new CallingUserPCMVertex(replacement, commonCallingVertex.get().getPreviousElements().stream().map(it -> it.copy(mapping)).toList(), true, this.resourceProvider);
        AbstractPCMVertex<?> returnReplacement = new CallingUserPCMVertex(replacement, List.of(callReplacement), false, this.resourceProvider);
        return getSEFFReplacementStart(uncertainState, currentTransposeFlowGraph, callReplacement, returnReplacement, calledSEFF, commonCallingVertex.get(), commonReturningVertex.get(), mapping);
    }

    /**
     * Applies a connector uncertainty in an external call to the given transpose flow graph and applies the uncertain state
     * @param uncertaintyScenario Connector uncertainty that is applied
     * @param uncertainState Uncertain state of the resulting transpose flow graphs
     * @param currentTransposeFlowGraph Transpose flow graph to which the behavior is applied
     * @return Returns a transpose flow graph with the connector uncertainty applied
     */
    public List<PCMUncertainTransposeFlowGraph> applyConnectorUncertaintyScenarioInExternalCall(PCMConnectorUncertaintyScenarioInExternalCall uncertaintyScenario, UncertainState uncertainState, PCMUncertainTransposeFlowGraph currentTransposeFlowGraph) {
        PCMConnectorUncertaintySourceInExternalCall uncertaintySource = (PCMConnectorUncertaintySourceInExternalCall) uncertaintyScenario.eContainer();
        ExternalCallAction target = uncertaintySource.getTarget();
        ExternalCallAction replacement = uncertaintyScenario.getTarget();

        Optional<? extends CallingSEFFPCMVertex> commonCallingVertex = this.getReferencedVertices(target, currentTransposeFlowGraph.getVertices(),
                it -> it instanceof CallingSEFFPCMVertex vertex && vertex.isCalling(), CallingSEFFPCMVertex.class::cast);

        Optional<? extends CallingSEFFPCMVertex> commonReturningVertex = this.getReferencedVertices(target, currentTransposeFlowGraph.getVertices(),
                it -> it instanceof CallingSEFFPCMVertex vertex && vertex.isReturning(), CallingSEFFPCMVertex.class::cast);
        
        if (commonCallingVertex.isEmpty() || commonReturningVertex.isEmpty()) {
        	return List.of(currentTransposeFlowGraph.copy(new IdentityHashMap<>(), uncertainState));
        }

        var requiredRole = replacement.getRole_ExternalService();
        var signature = replacement.getCalledService_ExternalService();
        var calledSEFF = PCMQueryUtils.findCalledSEFF(requiredRole, signature, commonCallingVertex.get().getContext()).orElseThrow();

        Map<AbstractPCMVertex<?>, AbstractPCMVertex<?>> mapping = new HashMap<>();
        AbstractPCMVertex<?> callReplacement = new CallingSEFFPCMVertex(replacement, commonCallingVertex.get().getPreviousElements().stream().map(it -> it.copy(mapping)).toList(), commonCallingVertex.get().getContext(), commonCallingVertex.get().getParameter(), true, this.resourceProvider);
        AbstractPCMVertex<?> returnReplacement = new CallingSEFFPCMVertex(replacement, List.of(callReplacement), commonReturningVertex.get().getContext(), commonReturningVertex.get().getParameter(), false, this.resourceProvider);
        return getSEFFReplacementStart(uncertainState, currentTransposeFlowGraph, callReplacement, returnReplacement, calledSEFF, commonCallingVertex.get(), commonReturningVertex.get(), mapping);
    }

    /**
     * Applies an external uncertainty in a resource to the given transpose flow graph and applies the uncertain state
     * @param uncertaintyScenario External uncertainty that is applied
     * @param uncertainState Uncertain state of the resulting transpose flow graphs
     * @param currentTransposeFlowGraph Transpose flow graph to which the behavior is applied
     * @return Returns a transpose flow graph with the external uncertainty applied
     */
    public PCMUncertainTransposeFlowGraph applyExternalUncertaintyScenarioInResource(PCMExternalUncertaintyScenarioInResource uncertaintyScenario, UncertainState uncertainState, PCMUncertainTransposeFlowGraph currentTransposeFlowGraph) {
        PCMExternalUncertaintySourceInResource uncertaintySource = (PCMExternalUncertaintySourceInResource) uncertaintyScenario.eContainer();
        ResourceAssignee target = uncertaintySource.getTarget();
        ResourceAssignee replacement = uncertaintyScenario.getTarget();
        replacement.setResourcecontainer(target.getResourcecontainer());
        AbstractPCMVertex<?> newSink = this.copyWithProxies(new HashMap<>(), currentTransposeFlowGraph.getSink(), target ,replacement);
        return new PCMUncertainTransposeFlowGraph(newSink, this.relevantUncertaintySources, uncertainState, currentTransposeFlowGraph.getUncertaintySourceManager());
    }

    /**
     * Applies an external uncertainty in a usage model to the given transpose flow graph and applies the uncertain state
     * @param uncertaintyScenario External uncertainty that is applied
     * @param uncertainState Uncertain state of the resulting transpose flow graphs
     * @param currentTransposeFlowGraph Transpose flow graph to which the behavior is applied
     * @return Returns a transpose flow graph with the external uncertainty applied
     */
    public PCMUncertainTransposeFlowGraph applyExternalUncertaintyScenarioInUsage(PCMExternalUncertaintyScenarioInUsage uncertaintyScenario, UncertainState uncertainState, PCMUncertainTransposeFlowGraph currentTransposeFlowGraph) {
        PCMExternalUncertaintySourceInUsage uncertaintySource = (PCMExternalUncertaintySourceInUsage) uncertaintyScenario.eContainer();
        UsageAssignee target = uncertaintySource.getTarget();
        UsageAssignee replacement = uncertaintyScenario.getTarget();
        replacement.setUsagescenario(target.getUsagescenario());
        AbstractPCMVertex<?> newSink = this.copyWithProxies(new HashMap<>(), currentTransposeFlowGraph.getSink(), target ,replacement);
        return new PCMUncertainTransposeFlowGraph(newSink, this.relevantUncertaintySources, uncertainState, currentTransposeFlowGraph.getUncertaintySourceManager());
    }

    /**
     * Applies an interface uncertainty to the given transpose flow graph and applies the uncertain state
     * @param uncertaintyScenario External uncertainty that is applied
     * @param uncertainState Uncertain state of the resulting transpose flow graphs
     * @param currentTransposeFlowGraph Transpose flow graph to which the behavior is applied
     * @return Returns a transpose flow graph with the external uncertainty applied
     */
    public List<PCMUncertainTransposeFlowGraph> applyInterfaceUncertaintyScenario(PCMInterfaceUncertaintyScenario uncertaintyScenario, UncertainState uncertainState, PCMUncertainTransposeFlowGraph currentTransposeFlowGraph) {
        PCMInterfaceUncertaintySource uncertaintySource = (PCMInterfaceUncertaintySource) uncertaintyScenario.eContainer();
        OperationSignature target = uncertaintySource.getTarget();
        OperationSignature replacement = uncertaintyScenario.getTarget();


        Optional<CallingSEFFPCMVertex> commonCallingVertex = currentTransposeFlowGraph.getVertices().stream()
                .filter(CallingSEFFPCMVertex.class::isInstance)
                .map(CallingSEFFPCMVertex.class::cast)
                .filter(CallReturnBehavior::isCalling)
                .filter(it -> it.getReferencedElement().getCalledService_ExternalService().equals(target))
                .findAny();

        Optional<CallingSEFFPCMVertex> commonReturningVertex = currentTransposeFlowGraph.getVertices().stream()
                .filter(CallingSEFFPCMVertex.class::isInstance)
                .map(CallingSEFFPCMVertex.class::cast)
                .filter(CallReturnBehavior::isReturning)
                .filter(it -> it.getReferencedElement().getCalledService_ExternalService().equals(target))
                .findAny();


        if (commonCallingVertex.isEmpty() || commonReturningVertex.isEmpty()) {
            return List.of(currentTransposeFlowGraph.copy(new IdentityHashMap<>(), uncertainState));
        }

        Optional<OperationRequiredRole> requiredRole = this.getRequiredRoleForInterface(commonCallingVertex.get(), replacement);

        if (requiredRole.isEmpty()) {
        	logger.warn("Could not determine required role of new interface. Not applying uncertainty...");
            return List.of(currentTransposeFlowGraph.copy(new IdentityHashMap<>(), uncertainState));
        }

        ExternalCallAction replacementCallElement = SeffFactory.eINSTANCE.createExternalCallAction();
        replacementCallElement.setEntityName(commonCallingVertex.get().getReferencedElement().getEntityName());
        replacementCallElement.setCalledService_ExternalService(EcoreUtil.copy(replacement));
        replacementCallElement.setRole_ExternalService(requiredRole.get());
        replacementCallElement.setPredecessor_AbstractAction(commonCallingVertex.get().getReferencedElement().getPredecessor_AbstractAction());
        replacementCallElement.setSuccessor_AbstractAction(commonCallingVertex.get().getReferencedElement().getSuccessor_AbstractAction());
        replacementCallElement.getInputVariableUsages__CallAction().addAll(this.copyVariableUsages(commonCallingVertex.get().getReferencedElement().getInputVariableUsages__CallAction()));
        replacementCallElement.getReturnVariableUsage__CallReturnAction().addAll(this.copyVariableUsages(commonCallingVertex.get().getReferencedElement().getReturnVariableUsage__CallReturnAction()));

        var calledSEFF = PCMQueryUtils.findCalledSEFF(requiredRole.get(), replacement, commonCallingVertex.get().getContext()).orElseThrow();
        replacementCallElement.setResourceDemandingBehaviour_AbstractAction(calledSEFF.seff());

        Map<AbstractPCMVertex<?>, AbstractPCMVertex<?>> mapping = new HashMap<>();
        AbstractPCMVertex<?> callReplacement = new CallingSEFFPCMVertex(replacementCallElement, commonCallingVertex.get().getPreviousElements(), commonCallingVertex.get().getContext(), commonCallingVertex.get().getParameter(), true, this.resourceProvider);
        AbstractPCMVertex<?> returnReplacement = new CallingSEFFPCMVertex(replacementCallElement, List.of(callReplacement), commonCallingVertex.get().getContext(), commonCallingVertex.get().getParameter(),false, this.resourceProvider);
        return this.getSEFFReplacementStart(uncertainState, currentTransposeFlowGraph, callReplacement, returnReplacement, calledSEFF, commonCallingVertex.get(), commonReturningVertex.get(), mapping);
    }

    /**
     * Copies the list of variable usages into a list of new variable usages
     * @param variableUsages Given list of variable usages
     * @return Returns a list copied variable usages
     */
    private List<VariableUsage> copyVariableUsages(List<VariableUsage> variableUsages) {
        return variableUsages.stream().map(EcoreUtil::copy).toList();
    }

    /**
     * Returns a required role for the given element and signature
     * @param oldElement Element which determines the context of the interface
     * @param replacement Signature of the interface
     * @return Returns a required role, if one can be found.
     */
    private Optional<OperationRequiredRole> getRequiredRoleForInterface(CallingSEFFPCMVertex oldElement, OperationSignature replacement) {
        OperationInterface replacementInterface = replacement.getInterface__OperationSignature();
        BasicComponent component = PCMQueryUtils.findParentOfType(oldElement.getReferencedElement(), BasicComponent.class, false).orElseThrow();
        return component.getRequiredRoles_InterfaceRequiringEntity().stream()
                .filter(OperationRequiredRole.class::isInstance)
                .map(OperationRequiredRole.class::cast)
                .filter(it -> it.getRequiredInterface__OperationRequiredRole().equals(replacementInterface))
                .findFirst();
    }

    /**
     * Puts a mapping in the given map, which replaces the given vertex with an uncertain proxy replacing the target assignee with the replacement.
     * @param mapping Map in which the replacing vertex will be saved
     * @param vertex Vertex that should be replaced
     * @param target Target assignee which is replaced
     * @param replacement Replacement assignee which replaces the target assignee
     * @return Returns the vertex that replaces the given vertex
     */
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

    /**
     * Returns the first vertex references the given entity
     * @param entity Entity that is searched
     * @param vertices List of vertices which are searched
     * @return  Returns the first occurrence of a vertex referencing the entity.
     *          If none exist, the method returns an empty optional
     */
    private Optional<? extends AbstractPCMVertex<?>> getReferencedVertices(Entity entity, List<? extends AbstractVertex<?>> vertices) {
        return this.getReferencedVertices(entity, vertices, (it) -> true, (it) -> it);
    }

    /**
     * Returns the first vertex references the given entity
     * <p/>
     * In Addition, matching elements will be filtered given the filter and then mapped with the given function
     * @param <T> Type of the result
     * @param entity Entity that is searched
     * @param vertices List of vertices which are searched
     * @param filter Given filter for matched vertices
     * @param mapping Given mapping for matched vertices
     * @return  Returns the first occurrence of a vertex referencing the entity and matching the filter.
     *          If none exist, the method returns an empty optional
     */
    private <T> Optional<? extends T> getReferencedVertices(Entity entity, List<? extends AbstractVertex<?>> vertices, Predicate<AbstractPCMVertex<?>> filter, Function<AbstractPCMVertex<?>, T> mapping) {
        return vertices.stream()
                .filter(it -> it instanceof AbstractPCMVertex<?>)
                .map(it -> (AbstractPCMVertex<?>) it)
                .filter(it -> it.getReferencedElement().equals(entity))
                .filter(filter)
                .map(mapping)
                .findFirst();
    }
}
