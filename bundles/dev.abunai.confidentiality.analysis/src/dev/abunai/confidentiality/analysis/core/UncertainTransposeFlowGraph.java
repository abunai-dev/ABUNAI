package dev.abunai.confidentiality.analysis.core;

import java.util.List;

import org.dataflowanalysis.analysis.core.AbstractVertex;
import org.dataflowanalysis.analysis.resource.ResourceProvider;

import dev.abunai.confidentiality.analysis.UncertaintyResourceProvider;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;

public interface UncertainTransposeFlowGraph {
	
	List<? extends UncertainTransposeFlowGraph> determineAlternativePartialFlowGraphs(UncertaintyResourceProvider resourceProvider);
	
	List<? extends AbstractVertex<?>> getImpactSet(ResourceProvider resourceProvider);

	UncertainState getUncertainState();
	
	List<? extends UncertaintySource> getRelevantUncertaintySources();
}
