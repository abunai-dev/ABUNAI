package dev.abunai.confidentiality.analysis;

import java.util.Optional;

import org.dataflowanalysis.analysis.AnalysisData;
import org.dataflowanalysis.analysis.pcm.PCMDataFlowConfidentialityAnalysis;
import org.eclipse.core.runtime.Plugin;

public class PCMUncertaintyAwareConfidentialityAnalysis  extends PCMDataFlowConfidentialityAnalysis {
		public PCMUncertaintyAwareConfidentialityAnalysis(AnalysisData analysisData, String modelProjectName, Optional<Class<? extends Plugin>> modelProjectActivator) {
		super(analysisData, modelProjectName, modelProjectActivator);
	}
}
