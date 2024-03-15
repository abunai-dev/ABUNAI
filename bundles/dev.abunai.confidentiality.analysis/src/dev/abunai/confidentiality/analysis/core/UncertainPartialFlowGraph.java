package dev.abunai.confidentiality.analysis.core;

import java.util.List;
import java.util.Optional;

import org.dataflowanalysis.analysis.core.AbstractPartialFlowGraph;
import org.dataflowanalysis.analysis.core.AbstractVertex;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;

public abstract class UncertainPartialFlowGraph extends AbstractPartialFlowGraph {
	protected final List<? extends UncertaintySource> relevantUncertaintySources;
	protected final Optional<UncertainState> uncertainState;

	
	public UncertainPartialFlowGraph(AbstractVertex<?> sink, List<? extends UncertaintySource> relevantUncertaintySources) {
		super(sink);
		this.relevantUncertaintySources = relevantUncertaintySources;
		this.uncertainState = Optional.empty();
	}
	
	public UncertainPartialFlowGraph(AbstractVertex<?> sink, List<? extends UncertaintySource> relevantUncertaintySources, UncertainState uncertainState) {
		super(sink);
		this.relevantUncertaintySources = relevantUncertaintySources;
		this.uncertainState = Optional.of(uncertainState);
	}
	
	public abstract List<? extends UncertainPartialFlowGraph> determineAlternativePartialFlowGraphs();
	
	public abstract List<? extends AbstractVertex<?>> getImpactSet();

	public UncertainState getUncertainState() {
		return uncertainState.orElseThrow(() -> new IllegalStateException("Tried to access uncertain state of partial flow graph that has not been determined yet"));
	}
	
	public List<? extends UncertaintySource> getRelevantUncertaintySources() {
		return relevantUncertaintySources;
	}
}
