package dev.abunai.confidentiality.analysis.evaluation.result;

import dev.abunai.confidentiality.analysis.evaluation.AnalysisExecutor;
import dev.abunai.confidentiality.analysis.evaluation.factory.PCMModelFactory;

public abstract class ScalibilityTest {
	
	public abstract void run(ScalibilityParameter parameter, AnalysisExecutor analysisExecutor);
	
	public void runAnalysis(PCMModelFactory modelFactory, ScalibilityParameter scalibilityParameter, AnalysisExecutor analysisExecutor) {
		analysisExecutor.executeAnalysis(scalibilityParameter, modelFactory);
	}
	
	public abstract int getModelSize(int currentIndex);
	
	public abstract String getTestName();
}
