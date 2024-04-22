package dev.abunai.confidentiality.analysis.pcm;

import java.util.*;

import org.dataflowanalysis.analysis.core.AbstractTransposeFlowGraph;
import org.dataflowanalysis.analysis.core.AbstractVertex;
import org.dataflowanalysis.analysis.pcm.core.AbstractPCMVertex;
import org.dataflowanalysis.analysis.pcm.core.PCMTransposeFlowGraph;
import org.dataflowanalysis.analysis.pcm.core.seff.SEFFPCMVertex;
import org.dataflowanalysis.analysis.pcm.resource.PCMResourceProvider;
import org.dataflowanalysis.analysis.resource.ResourceProvider;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.ResourceAssignee;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.UsageAssignee;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.OperationSignature;
import org.palladiosimulator.pcm.seff.ExternalCallAction;
import org.palladiosimulator.pcm.seff.SetVariableAction;

import dev.abunai.confidentiality.analysis.core.UncertainTransposeFlowGraph;
import dev.abunai.confidentiality.analysis.UncertaintyResourceProvider;
import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.core.UncertaintyUtils;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMBehaviorUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMBehaviorUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMComponentUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMComponentUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintyScenarioInEntryLevelSystemCall;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintyScenarioInExternalCall;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInEntryLevelSystemCall;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInExternalCall;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintyScenarioInResource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintyScenarioInUsage;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySourceInResource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySourceInUsage;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMInterfaceUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMInterfaceUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMUncertaintySource;
import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;

public class PCMUncertainTransposeFlowGraph extends PCMTransposeFlowGraph implements UncertainTransposeFlowGraph {
	private final Optional<UncertainState> uncertainState;
	private final List<? extends UncertaintySource> relevantUncertaintySources;


	public PCMUncertainTransposeFlowGraph(AbstractVertex<?> sink,
										  List<? extends UncertaintySource> relevantUncertaintySources) {
		super(sink);
		this.uncertainState = Optional.empty();
		this.relevantUncertaintySources = relevantUncertaintySources;
	}
	
	public PCMUncertainTransposeFlowGraph(AbstractVertex<?> sink,
										  List<? extends UncertaintySource> relevantUncertaintySources, UncertainState uncertainState) {
		super(sink);
		this.uncertainState = Optional.of(uncertainState);
		this.relevantUncertaintySources = relevantUncertaintySources;
	}

	@Override
	public List<? extends AbstractPCMVertex<?>> getImpactSet(ResourceProvider resourceProvider) {
		if (!(resourceProvider instanceof PCMResourceProvider pcmResourceProvider)) {
			throw new IllegalArgumentException();
		}
		PCMQueryHelper pcmQueryHelper = new PCMQueryHelper(this.getVertices(), pcmResourceProvider);
		
		List<? extends AbstractPCMVertex<?>> targetNodes = this.relevantUncertaintySources.stream()
				.map(it -> pcmQueryHelper.findTargetNodes((PCMUncertaintySource) it))
				.flatMap(List::stream)
				.toList();

		List<? extends AbstractPCMVertex<?>> longestAffectedElementList = super.getVertices().stream()
				.map(it -> (AbstractPCMVertex<?>) it)
				.dropWhile(it -> !targetNodes.contains(it.getReferencedElement()))
				.toList();
		// OLD CODE: new DFDActionSequence((List<AbstractActionSequenceElement<?>>) longestAffectedElementList);
		return longestAffectedElementList;
	}

    @Override
	public List<PCMUncertainTransposeFlowGraph> determineAlternativeTransposeFlowGraphs(UncertaintyResourceProvider resourceProvider) {
		List<UncertainState> states = UncertainState.createAllUncertainStates(this.relevantUncertaintySources);
		List<PCMUncertainTransposeFlowGraph> alternatePartialFlowGraphs = new ArrayList<>();
		
		for (UncertainState state : states) {
			alternatePartialFlowGraphs.add(this.applyUncertaintyScenarios(state));
		}
		return alternatePartialFlowGraphs;
	}
	
	private PCMUncertainTransposeFlowGraph applyUncertaintyScenarios(UncertainState state) {
		PCMUncertainTransposeFlowGraph currentTransposeFlowGraph = this;
		for (UncertaintyScenario uncertaintyScenario : state.getSelectedUncertaintyScenarios()) {
			currentTransposeFlowGraph = this.applyUncertaintyScenario(uncertaintyScenario, state, currentTransposeFlowGraph);
		}
		return currentTransposeFlowGraph;
	}

	private PCMUncertainTransposeFlowGraph applyUncertaintyScenario(UncertaintyScenario uncertaintyScenario, UncertainState uncertainState, AbstractTransposeFlowGraph currentTransposeFlowGraph) {
		if (uncertaintyScenario instanceof PCMBehaviorUncertaintyScenario castedScenario) {
			return applyBehaviourUncertaintyScenario(castedScenario, uncertainState, currentTransposeFlowGraph);
		} else if (uncertaintyScenario instanceof PCMComponentUncertaintyScenario castedScenario) {
			return applyComponentUncertaintyScenario(castedScenario, uncertainState, currentTransposeFlowGraph);
		} else if (uncertaintyScenario instanceof PCMConnectorUncertaintyScenarioInEntryLevelSystemCall castedScenario) {
			return applyConnectorUncertaintyScenarioInEntryLevelSystemCall(castedScenario, uncertainState, currentTransposeFlowGraph);
		} else if (uncertaintyScenario instanceof PCMConnectorUncertaintyScenarioInExternalCall castedScenario) {
			return applyConnectorUncertaintyScenarioInExternalCall(castedScenario, uncertainState, currentTransposeFlowGraph);
		} else if (uncertaintyScenario instanceof PCMExternalUncertaintyScenarioInResource castedScenario) {
			return applyExternalUncertaintyScenarioInResource(castedScenario, uncertainState, currentTransposeFlowGraph);
		} else if(uncertainState instanceof PCMExternalUncertaintyScenarioInUsage castedScenario) {
			return applyExternalUncertaintyScenarioInUsage(castedScenario, uncertainState, currentTransposeFlowGraph);
		} else if (uncertainState instanceof PCMInterfaceUncertaintyScenario castedScenario) {
			return applyInterfaceUncertaintyScenario(castedScenario, uncertainState, currentTransposeFlowGraph);
		} else {
			throw new IllegalArgumentException("Unexpected DFD uncertainty scenario: %s"
					.formatted(UncertaintyUtils.getUncertaintyScenarioName(uncertaintyScenario)));
		}
	}

	private PCMUncertainTransposeFlowGraph applyBehaviourUncertaintyScenario(
			PCMBehaviorUncertaintyScenario uncertaintyScenario, UncertainState uncertainState, AbstractTransposeFlowGraph currentTransposeFlowGraph) {
		PCMBehaviorUncertaintySource uncertaintySource = (PCMBehaviorUncertaintySource) uncertaintyScenario.eContainer();
		SetVariableAction target = uncertaintySource.getTarget();
		SetVariableAction replacement = uncertaintyScenario.getTarget();

		SEFFPCMVertex<?> targetVertex = this.getVertices().stream()
				.filter(it -> (it instanceof SEFFPCMVertex<?>))
				.map(it -> (SEFFPCMVertex<?>) it)
				.filter(it -> it.getReferencedElement().equals(target))
				.findFirst().orElseThrow();
		AbstractPCMVertex<?> replacementVertex = new SEFFPCMVertex<>(replacement, targetVertex.getPreviousElements(), targetVertex.getContext(), targetVertex.getParameter(), targetVertex.getResourceProvider());

		Map<AbstractPCMVertex<?>, AbstractPCMVertex<?>> mapping = new IdentityHashMap<>();
		mapping.put(targetVertex, replacementVertex);

		return this.copyWithState(mapping, uncertainState);
	}

	/*
	1. Find all calls in and out of old assembly context
	2. Perform sequence finding to find replacing part of transpose flow graph
	3. Splice together
	 */
	public PCMUncertainTransposeFlowGraph applyComponentUncertaintyScenario(PCMComponentUncertaintyScenario uncertaintyScenario, UncertainState uncertainState, AbstractTransposeFlowGraph currentTransposeFlowGraph) {
		PCMComponentUncertaintySource uncertaintySource = (PCMComponentUncertaintySource) uncertaintyScenario.eContainer();
		AssemblyContext target = uncertaintySource.getTarget();
		AssemblyContext replacement = uncertaintyScenario.getTarget();
		return this.copyWithState(null, uncertainState);
	}

	/*
	1. Find call
	2. Perform sequence finding on callee
	3. Splice together
	*/
	public PCMUncertainTransposeFlowGraph applyConnectorUncertaintyScenarioInEntryLevelSystemCall(PCMConnectorUncertaintyScenarioInEntryLevelSystemCall uncertaintyScenario, UncertainState uncertainState, AbstractTransposeFlowGraph currentTransposeFlowGraph) {
		PCMConnectorUncertaintySourceInEntryLevelSystemCall uncertaintySource = (PCMConnectorUncertaintySourceInEntryLevelSystemCall) uncertaintyScenario.eContainer();
		EntryLevelSystemCall target = uncertaintySource.getTarget();
		EntryLevelSystemCall replacement = uncertaintyScenario.getTarget();
		
		return this.copyWithState(null, uncertainState);
	}

	/*
	1. Find call
	2. Perform sequence finding
	3. Splice together
	 */
	public PCMUncertainTransposeFlowGraph applyConnectorUncertaintyScenarioInExternalCall(PCMConnectorUncertaintyScenarioInExternalCall uncertaintyScenario, UncertainState uncertainState, AbstractTransposeFlowGraph currentTransposeFlowGraph) {
		PCMConnectorUncertaintySourceInExternalCall uncertaintySource = (PCMConnectorUncertaintySourceInExternalCall) uncertaintyScenario.eContainer();
		ExternalCallAction target = uncertaintySource.getTarget();
		ExternalCallAction replacement = uncertaintyScenario.getTarget();
		
		return this.copyWithState(null, uncertainState);
	}

	// Solve this via proxy: Create a uncertain tfg with proxy set, then add node characteristics after evaluation
	public PCMUncertainTransposeFlowGraph applyExternalUncertaintyScenarioInResource(PCMExternalUncertaintyScenarioInResource uncertaintyScenario, UncertainState uncertainState, AbstractTransposeFlowGraph currentTransposeFlowGraph) {
		PCMExternalUncertaintySourceInResource uncertaintySource = (PCMExternalUncertaintySourceInResource) uncertaintyScenario.eContainer();
		ResourceAssignee target = uncertaintySource.getTarget();
		ResourceAssignee replacement = uncertaintyScenario.getTarget();
		PCMUncertainTransposeFlowGraph copy = this.copyWithState(new IdentityHashMap<>(), uncertainState);
		return copy;
	}

	// Same as above
	public PCMUncertainTransposeFlowGraph applyExternalUncertaintyScenarioInUsage(PCMExternalUncertaintyScenarioInUsage uncertaintyScenario, UncertainState uncertainState, AbstractTransposeFlowGraph currentTransposeFlowGraph) {
		PCMExternalUncertaintySourceInUsage uncertaintySource = (PCMExternalUncertaintySourceInUsage) uncertaintyScenario.eContainer();
		UsageAssignee target = uncertaintySource.getTarget();
		UsageAssignee replacement = uncertaintyScenario.getTarget();
		PCMUncertainTransposeFlowGraph copy = this.copyWithState(new IdentityHashMap<>(), uncertainState);
		return copy;
	}

	/*
	1. Find called signature and parameters
	2. Replace signature and parameters
	3. ???
	4. Profit
	 */
	public PCMUncertainTransposeFlowGraph applyInterfaceUncertaintyScenario(PCMInterfaceUncertaintyScenario uncertaintyScenario, UncertainState uncertainState, AbstractTransposeFlowGraph currentTransposeFlowGraph) {
		PCMInterfaceUncertaintySource uncertaintySource = (PCMInterfaceUncertaintySource) uncertaintyScenario.eContainer();
		OperationSignature target = uncertaintySource.getTarget();
		OperationSignature replacement = uncertaintyScenario.getTarget();
		
		return this.copyWithState(null, uncertainState);
	}

	public PCMUncertainTransposeFlowGraph copyWithState(Map<AbstractPCMVertex<?>, AbstractPCMVertex<?>> vertexMapping, UncertainState uncertainState) {
        AbstractPCMVertex<?> pcmSink = (AbstractPCMVertex<?>) this.sink;
        AbstractPCMVertex<?> clonedSink = pcmSink.copy(vertexMapping);
        return new PCMUncertainTransposeFlowGraph(clonedSink, this.getRelevantUncertaintySources(), uncertainState);
    }

	@Override
	public List<? extends UncertaintySource> getRelevantUncertaintySources() {
		return this.relevantUncertaintySources;
	}

	@Override
	public UncertainState getUncertainState() {
		return this.uncertainState.orElseThrow();
	}
}
