package dev.abunai.confidentiality.analysis.pcm;

import java.util.ArrayList;
import java.util.List;

import org.dataflowanalysis.analysis.core.AbstractPartialFlowGraph;
import org.dataflowanalysis.analysis.core.AbstractVertex;
import org.dataflowanalysis.analysis.pcm.core.AbstractPCMVertex;
import org.dataflowanalysis.analysis.pcm.resource.PCMResourceProvider;
import org.dataflowanalysis.analysis.resource.ResourceProvider;

import dev.abunai.confidentiality.analysis.core.UncertainPartialFlowGraph;
import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.core.UncertaintyUtils;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMBehaviorUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMComponentUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintyScenarioInEntryLevelSystemCall;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintyScenarioInExternalCall;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintyScenarioInResource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintyScenarioInUsage;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMInterfaceUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMUncertaintySource;

public class PCMUncertainPartialFlowGraph extends UncertainPartialFlowGraph {
	public PCMUncertainPartialFlowGraph(AbstractVertex<?> sink,
			List<? extends UncertaintySource> relevantUncertaintySources) {
		super(sink, relevantUncertaintySources);
	}
	
	public PCMUncertainPartialFlowGraph(AbstractVertex<?> sink,
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
	public AbstractPartialFlowGraph evaluate() {
        this.getSink().evaluateDataFlow();
        return this;
	}
	
	@Override
	public List<PCMUncertainPartialFlowGraph> determineAlternativePartialFlowGraphs() {
		List<UncertainState> states = UncertainState.createAllUncertainStates(this.relevantUncertaintySources);
		List<PCMUncertainPartialFlowGraph> alternatePartialFlowGraphs = new ArrayList<>();
		
		for (UncertainState state : states) {
			alternatePartialFlowGraphs.addAll(this.applyUncertaintyScenarios(state));
		}
		return alternatePartialFlowGraphs;
	}
	
	private List<PCMUncertainPartialFlowGraph> applyUncertaintyScenarios(UncertainState state) {
		List<PCMUncertainPartialFlowGraph> uncertainPartialFlowGraphs = new ArrayList<>();
		for (UncertaintyScenario uncertaintyScenario : state.getSelectedUncertaintyScenarios()) {
			uncertainPartialFlowGraphs.add(this.applyUncertaintyScenario(uncertaintyScenario, state));
		}
		return uncertainPartialFlowGraphs;
	}

	private PCMUncertainPartialFlowGraph applyUncertaintyScenario(UncertaintyScenario uncertaintyScenario, UncertainState uncertainState) {
		if (uncertaintyScenario instanceof PCMBehaviorUncertaintyScenario castedScenario) {
			return null;
		} else if (uncertaintyScenario instanceof PCMComponentUncertaintyScenario castedScenario) {
			return null;
		} else if (uncertaintyScenario instanceof PCMConnectorUncertaintyScenarioInEntryLevelSystemCall castedScenario) {
			return null;
		} else if (uncertaintyScenario instanceof PCMConnectorUncertaintyScenarioInExternalCall castedScenario) {
			return null;
		} else if (uncertaintyScenario instanceof PCMExternalUncertaintyScenarioInResource castedScenario) {
			return null;
		} else if(uncertainState instanceof PCMExternalUncertaintyScenarioInUsage castedScenario) {
			return null;
		} else if (uncertainState instanceof PCMInterfaceUncertaintyScenario castedScenaro) {
			return null;
		} else {
			throw new IllegalArgumentException("Unexpected DFD uncertainty scenario: %s"
					.formatted(UncertaintyUtils.getUncertaintyScenarioName(uncertaintyScenario)));
		}
	}
}
