package dev.abunai.confidentiality.analysis.pcm;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import org.dataflowanalysis.analysis.core.AbstractTransposeFlowGraph;
import org.dataflowanalysis.analysis.core.AbstractVertex;
import org.dataflowanalysis.analysis.pcm.core.AbstractPCMVertex;
import org.dataflowanalysis.analysis.pcm.core.seff.SEFFPCMVertex;
import org.dataflowanalysis.analysis.pcm.resource.PCMResourceProvider;
import org.dataflowanalysis.analysis.resource.ResourceProvider;
import org.palladiosimulator.pcm.seff.SetVariableAction;

import dev.abunai.confidentiality.analysis.core.UncertainTransposeFlowGraph;
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

public class PCMUncertainTransposeFlowGraph extends UncertainTransposeFlowGraph {
	public PCMUncertainTransposeFlowGraph(AbstractVertex<?> sink,
										  List<? extends UncertaintySource> relevantUncertaintySources) {
		super(sink, relevantUncertaintySources);
	}
	
	public PCMUncertainTransposeFlowGraph(AbstractVertex<?> sink,
										  List<? extends UncertaintySource> relevantUncertaintySources, UncertainState uncertainState) {
		super(sink, relevantUncertaintySources, uncertainState);
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
	public AbstractTransposeFlowGraph evaluate() {
        this.getSink().evaluateDataFlow();
        return this;
	}
	
	@Override
	public List<PCMUncertainTransposeFlowGraph> determineAlternativePartialFlowGraphs() {
		List<UncertainState> states = UncertainState.createAllUncertainStates(this.relevantUncertaintySources);
		List<PCMUncertainTransposeFlowGraph> alternatePartialFlowGraphs = new ArrayList<>();
		
		for (UncertainState state : states) {
			alternatePartialFlowGraphs.addAll(this.applyUncertaintyScenarios(state));
		}
		return alternatePartialFlowGraphs;
	}
	
	private List<PCMUncertainTransposeFlowGraph> applyUncertaintyScenarios(UncertainState state) {
		List<PCMUncertainTransposeFlowGraph> uncertainPartialFlowGraphs = new ArrayList<>();
		for (UncertaintyScenario uncertaintyScenario : state.getSelectedUncertaintyScenarios()) {
			uncertainPartialFlowGraphs.add(this.applyUncertaintyScenario(uncertaintyScenario, state));
		}
		return uncertainPartialFlowGraphs;
	}

	private PCMUncertainTransposeFlowGraph applyUncertaintyScenario(UncertaintyScenario uncertaintyScenario, UncertainState uncertainState) {
		if (uncertaintyScenario instanceof PCMBehaviorUncertaintyScenario castedScenario) {
			return applyBehaviourUncertaintyScenario(castedScenario, uncertainState);
		} else if (uncertaintyScenario instanceof PCMComponentUncertaintyScenario castedScenario) {
			return applyComponentUncertaintyScenario(castedScenario, uncertainState);
		} else if (uncertaintyScenario instanceof PCMConnectorUncertaintyScenarioInEntryLevelSystemCall castedScenario) {
			return applyConnectorUncertaintyScenarioInEntryLevelSystemCall(castedScenario, uncertainState);
		} else if (uncertaintyScenario instanceof PCMConnectorUncertaintyScenarioInExternalCall castedScenario) {
			return applyConnectorUncertaintyScenarioInExternalCall(castedScenario, uncertainState);
		} else if (uncertaintyScenario instanceof PCMExternalUncertaintyScenarioInResource castedScenario) {
			return applyExternalUncertaintyScenarioInResource(castedScenario, uncertainState);
		} else if(uncertainState instanceof PCMExternalUncertaintyScenarioInUsage castedScenario) {
			return applyExternalUncertaintyScenarioInUsage(castedScenario, uncertainState);
		} else if (uncertainState instanceof PCMInterfaceUncertaintyScenario castedScenaro) {
			return applyInterfaceUncertaintyScenario(castedScenaro, uncertainState);
		} else {
			throw new IllegalArgumentException("Unexpected DFD uncertainty scenario: %s"
					.formatted(UncertaintyUtils.getUncertaintyScenarioName(uncertaintyScenario)));
		}
	}

	private PCMUncertainTransposeFlowGraph applyBehaviourUncertaintyScenario(
			PCMBehaviorUncertaintyScenario uncertaintyScenario, UncertainState uncertainState) {
		PCMBehaviorUncertaintySource uncertaintySource = (PCMBehaviorUncertaintySource) uncertaintyScenario.eContainer();
		SetVariableAction target = uncertaintySource.getTarget();
		SetVariableAction replacement = uncertaintyScenario.getTarget();
		
		SEFFPCMVertex<?> targetVertex = this.getVertices().stream()
				.filter(it -> (it instanceof SEFFPCMVertex<?>))	
				.map(it -> (SEFFPCMVertex<?>) it)
				.filter(it -> it.getReferencedElement().equals(target))
				.findFirst().orElseThrow();
		AbstractPCMVertex<?> replacementVertex = new SEFFPCMVertex<SetVariableAction>(replacement, targetVertex.getPreviousElements(), targetVertex.getContext(), targetVertex.getParameter(), targetVertex.getResourceProvider());
		
		Map<AbstractPCMVertex<?>, AbstractPCMVertex<?>> mapping = new IdentityHashMap<>();
		mapping.put(targetVertex, replacementVertex);
		
		return this.deepCopy(mapping, uncertainState);
	}
	
	public PCMUncertainTransposeFlowGraph applyComponentUncertaintyScenario(PCMComponentUncertaintyScenario uncertaintyScenario, UncertainState uncertainState) {
		PCMComponentUncertaintySource uncertaintySource = (PCMComponentUncertaintySource) uncertaintyScenario.eContainer();
		var target = uncertaintySource.getTarget();
		var replacement = uncertaintyScenario.getTarget();
		
		return this.deepCopy(null, uncertainState);
	}
	
	public PCMUncertainTransposeFlowGraph applyConnectorUncertaintyScenarioInEntryLevelSystemCall(PCMConnectorUncertaintyScenarioInEntryLevelSystemCall uncertaintyScenario, UncertainState uncertainState) {
		PCMConnectorUncertaintySourceInEntryLevelSystemCall uncertaintySource = (PCMConnectorUncertaintySourceInEntryLevelSystemCall) uncertaintyScenario.eContainer();
		var target = uncertaintySource.getTarget();
		var replacement = uncertaintyScenario.getTarget();
		
		return this.deepCopy(null, uncertainState);
	}
	
	public PCMUncertainTransposeFlowGraph applyConnectorUncertaintyScenarioInExternalCall(PCMConnectorUncertaintyScenarioInExternalCall uncertaintyScenario, UncertainState uncertainState) {
		PCMConnectorUncertaintySourceInExternalCall uncertaintySource = (PCMConnectorUncertaintySourceInExternalCall) uncertaintyScenario.eContainer();
		var target = uncertaintySource.getTarget();
		var replacement = uncertaintyScenario.getTarget();
		
		return this.deepCopy(null, uncertainState);
	}
	
	public PCMUncertainTransposeFlowGraph applyExternalUncertaintyScenarioInResource(PCMExternalUncertaintyScenarioInResource uncertaintyScenario, UncertainState uncertainState) {
		PCMExternalUncertaintySourceInResource uncertaintySource = (PCMExternalUncertaintySourceInResource) uncertaintyScenario.eContainer();
		var target = uncertaintySource.getTarget();
		var replacement = uncertaintyScenario.getTarget();
		
		return this.deepCopy(null, uncertainState);
	}
	
	public PCMUncertainTransposeFlowGraph applyExternalUncertaintyScenarioInUsage(PCMExternalUncertaintyScenarioInUsage uncertaintyScenario, UncertainState uncertainState) {
		PCMExternalUncertaintySourceInUsage uncertaintySource = (PCMExternalUncertaintySourceInUsage) uncertaintyScenario.eContainer();
		var target = uncertaintySource.getTarget();
		var replacement = uncertaintyScenario.getTarget();
		
		return this.deepCopy(null, uncertainState);
	}
	
	public PCMUncertainTransposeFlowGraph applyInterfaceUncertaintyScenario(PCMInterfaceUncertaintyScenario uncertaintyScenario, UncertainState uncertainState) {
		PCMInterfaceUncertaintySource uncertaintySource = (PCMInterfaceUncertaintySource) uncertaintyScenario.eContainer();
		var target = uncertaintySource.getTarget();
		var replacement = uncertaintyScenario.getTarget();
		
		return this.deepCopy(null, uncertainState);
	}
	
	public PCMUncertainTransposeFlowGraph deepCopy(Map<AbstractPCMVertex<?>, AbstractPCMVertex<?>> vertexMapping, UncertainState uncertainState) {
        AbstractPCMVertex<?> pcmSink = (AbstractPCMVertex<?>) this.sink;
        AbstractPCMVertex<?> clonedSink = pcmSink.deepCopy(vertexMapping);
        return new PCMUncertainTransposeFlowGraph(clonedSink, this.getRelevantUncertaintySources(), uncertainState);
    }
}
