package dev.abunai.confidentiality.analysis;

import org.dataflowanalysis.analysis.pcm.PCMDataFlowConfidentialityAnalysisBuilder;


public class PCMUncertaintyAwareConfidentialityAnalysisBuilder extends PCMDataFlowConfidentialityAnalysisBuilder {
		
		@Override
		public PCMUncertaintyAwareConfidentialityAnalysis build() {
			return new PCMUncertaintyAwareConfidentialityAnalysis(this.createAnalysisData(), modelProjectName, pluginActivator);
		}
}
