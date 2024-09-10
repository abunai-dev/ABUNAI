package dev.abunai.confidentiality.analysis.evaluation.result;

import dev.abunai.confidentiality.analysis.core.UncertainFlowGraphCollection;

import java.io.Serializable;

public class ScalibilityParameter implements Serializable, Comparable<ScalibilityParameter> {
	private static final long serialVersionUID = 1L;
	
	private int scenarioAwareComplexity;
	private int graphAwareComplexity;
	private int impactAwareComplexity;
	private final int modelSize;
	private final String testName;
	
	public ScalibilityParameter(int modelSize, String testName) {
		this.modelSize = modelSize;
		this.testName = testName;
	}

	public void setResults(UncertainFlowGraphCollection uncertainFlowGraphCollection) {
		this.scenarioAwareComplexity = uncertainFlowGraphCollection.getScenarioAwareComplexity();
		this.graphAwareComplexity = uncertainFlowGraphCollection.getGraphAwareComplexity();
		this.impactAwareComplexity = uncertainFlowGraphCollection.getImpactAwareComplexity();
	}

	public int getScenarioAwareComplexity() {
		return scenarioAwareComplexity;
	}

	public int getGraphAwareComplexity() {
		return graphAwareComplexity;
	}

	public int getImpactAwareComplexity() {
		return impactAwareComplexity;
	}

	public int getModelSize() {
		return modelSize;
	}
	
	public String getTestName() {
		return testName;
	}

	@Override
	public int compareTo(ScalibilityParameter other) {
		return Integer.compare(modelSize, other.getModelSize());
	}
}
