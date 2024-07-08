package dev.abunai.confidentiality.analysis.evaluation;

import dev.abunai.confidentiality.analysis.evaluation.factory.PCMModelFactory;
import dev.abunai.confidentiality.analysis.evaluation.result.ScalibilityParameter;

public interface AnalysisExecutor {
	public void executeAnalysis(ScalibilityParameter scalibilityParameter, PCMModelFactory modelFactory);
	
	public String getPrefix();

}
