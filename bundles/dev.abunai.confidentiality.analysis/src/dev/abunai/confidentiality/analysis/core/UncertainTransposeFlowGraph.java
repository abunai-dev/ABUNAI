package dev.abunai.confidentiality.analysis.core;

import java.util.List;

import dev.abunai.confidentiality.analysis.dfd.DFDUncertainTransposeFlowGraph;
import org.dataflowanalysis.analysis.core.AbstractTransposeFlowGraph;
import org.dataflowanalysis.analysis.core.AbstractVertex;
import org.dataflowanalysis.analysis.resource.ResourceProvider;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;

public interface UncertainTransposeFlowGraph {
	
	List<? extends UncertainTransposeFlowGraph> determineAlternativePartialFlowGraphs(List<? extends AbstractTransposeFlowGraph> defaultTransposeFlowGraphs);
	
	List<? extends AbstractVertex<?>> getImpactSet(ResourceProvider resourceProvider);

	UncertainState getUncertainState();
	
	List<? extends UncertaintySource> getRelevantUncertaintySources();
}
