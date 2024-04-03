package dev.abunai.confidentiality.analysis;

import java.util.List;
import java.util.function.Predicate;

import dev.abunai.confidentiality.analysis.core.UncertainConstraintViolation;
import org.dataflowanalysis.analysis.core.AbstractVertex;
import org.dataflowanalysis.analysis.core.FlowGraphCollection;
import org.dataflowanalysis.analysis.resource.ResourceProvider;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;

public interface UncertaintyAwareConfidentialityAnalysis {
	void initializeAnalysis();
	
	List<UncertaintySource> getUncertaintySources();

	ResourceProvider getResourceProvider();

	FlowGraphCollection findFlowGraph();
	
	FlowGraphCollection evaluateUncertainDataFlows(FlowGraphCollection flowGraph);

	List<UncertainConstraintViolation> queryUncertainDataFlow(FlowGraphCollection flowGraph,
															  Predicate<? super AbstractVertex<?>> condition);
}
