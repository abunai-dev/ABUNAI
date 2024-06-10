package dev.abunai.confidentiality.analysis.core;

/**
 * This interface represents a {@link org.dataflowanalysis.analysis.core.FlowGraphCollection} that contains uncertain transpose flow graphs.
 * Uncertain flows may be created with {@link UncertainFlowGraphCollection#createUncertainFlows()}
 */
public interface UncertainFlowGraphCollection {
	/**
	 * Create an {@link UncertainFlowGraphCollection} with uncertain transpose flow graphs that were created by the stored uncertainty scenarios
	 * @return Returns a new {@link UncertainFlowGraphCollection} with newly created uncertain transpose flow graphs
	 */
	UncertainFlowGraphCollection createUncertainFlows();
}
