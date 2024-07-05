package dev.abunai.confidentiality.analysis.core;

import org.apache.log4j.Logger;

/**
 * This interface represents a {@link org.dataflowanalysis.analysis.core.FlowGraphCollection} that contains uncertain transpose flow graphs.
 * Uncertain flows may be created with {@link UncertainFlowGraphCollection#createUncertainFlows()}
 */
public interface UncertainFlowGraphCollection {
	String NUMBER_MESSAGE = "ScenarioAware: %d, GraphAware: %d, ImpactAware: %d";

	/**
	 * Create an {@link UncertainFlowGraphCollection} with uncertain transpose flow graphs that were created by the stored uncertainty scenarios
	 * @return Returns a new {@link UncertainFlowGraphCollection} with newly created uncertain transpose flow graphs
	 */
	UncertainFlowGraphCollection createUncertainFlows();

	int getScenarioAwareComplexity();

	int getGraphAwareComplexity();

	int getImpactAwareComplexity();

	default void printUncertaintyMessage(Logger logger) {
		logger.info(NUMBER_MESSAGE.formatted(this.getScenarioAwareComplexity(), this.getGraphAwareComplexity(), this.getImpactAwareComplexity()));
	}
}
