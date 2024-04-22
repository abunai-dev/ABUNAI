package dev.abunai.confidentiality.analysis.pcm;

import java.util.*;

import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.core.AbstractVertex;
import org.dataflowanalysis.analysis.pcm.core.AbstractPCMVertex;
import org.dataflowanalysis.analysis.pcm.core.PCMTransposeFlowGraph;
import org.dataflowanalysis.analysis.pcm.resource.PCMResourceProvider;
import org.dataflowanalysis.analysis.resource.ResourceProvider;

import dev.abunai.confidentiality.analysis.core.UncertainTransposeFlowGraph;
import dev.abunai.confidentiality.analysis.UncertaintyResourceProvider;
import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMUncertaintySource;

public class PCMUncertainTransposeFlowGraph extends PCMTransposeFlowGraph implements UncertainTransposeFlowGraph {
	private final Logger logger = Logger.getLogger(PCMUncertainTransposeFlowGraph.class);
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
		if (this.uncertainState.isPresent()) {
			logger.error("Tried to determine alternative transpose flow graphs on a flow graph with an uncertain state");
			logger.error("This is most likely caused by calling determineAlternativeFlowGraphs on a transpose flow graph that was already an alternative flow graph");
			throw new IllegalStateException();
		}

		List<UncertainState> states = UncertainState.createAllUncertainStates(this.relevantUncertaintySources);
		List<PCMUncertainTransposeFlowGraph> alternatePartialFlowGraphs = new ArrayList<>();
		PCMUncertaintyCalculator calculator = new PCMUncertaintyCalculator(this.relevantUncertaintySources, (PCMUncertaintyResourceProvider) resourceProvider);
		for (UncertainState state : states) {
			alternatePartialFlowGraphs.addAll(calculator.determineAlternativePartialFlowGraphs(state, this));
		}
		return alternatePartialFlowGraphs;
	}

	@Override
	public PCMTransposeFlowGraph copy(Map<AbstractPCMVertex<?>, AbstractPCMVertex<?>> mapping) {
		AbstractPCMVertex<?> pcmSink = (AbstractPCMVertex<?>) this.sink;
		AbstractPCMVertex<?> clonedSink = pcmSink.copy(mapping);

		return new PCMUncertainTransposeFlowGraph(clonedSink, this.relevantUncertaintySources);
	}

	public PCMUncertainTransposeFlowGraph copy(Map<AbstractPCMVertex<?>, AbstractPCMVertex<?>> mapping, UncertainState uncertainState) {
		AbstractPCMVertex<?> pcmSink = (AbstractPCMVertex<?>) this.sink;
		AbstractPCMVertex<?> clonedSink = pcmSink.copy(mapping);

		return new PCMUncertainTransposeFlowGraph(clonedSink, this.relevantUncertaintySources, uncertainState);
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
