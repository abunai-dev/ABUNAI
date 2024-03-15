package dev.abunai.confidentiality.analysis;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.dataflowanalysis.analysis.core.AbstractVertex;
import org.dataflowanalysis.analysis.resource.ResourceProvider;

import dev.abunai.confidentiality.analysis.core.UncertainFlowGraph;
import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;

public interface UncertaintyAwareConfidentialityAnalysis {
	void initializeAnalysis();
	
	List<UncertaintySource> getUncertaintySources();

	ResourceProvider getResourceProvider();

	UncertainFlowGraph findFlowGraph();
	
	UncertainFlowGraph evaluateUncertainDataFlows(UncertainFlowGraph flowGraph);
	
	Map<UncertainState, List<? extends AbstractVertex<?>>> queryUncertainDataFlow(UncertainFlowGraph flowGraph,
			Predicate<? super AbstractVertex<?>> condition);
}
