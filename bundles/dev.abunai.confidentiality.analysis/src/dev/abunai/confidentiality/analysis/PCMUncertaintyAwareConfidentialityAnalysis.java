package dev.abunai.confidentiality.analysis;

import java.util.Optional;

import org.dataflowanalysis.analysis.core.DataCharacteristicsCalculatorFactory;
import org.dataflowanalysis.analysis.core.NodeCharacteristicsCalculator;
import org.dataflowanalysis.analysis.pcm.PCMDataFlowConfidentialityAnalysis;
import org.eclipse.core.runtime.Plugin;

public class PCMUncertaintyAwareConfidentialityAnalysis extends PCMDataFlowConfidentialityAnalysis {
	public PCMUncertaintyAwareConfidentialityAnalysis(NodeCharacteristicsCalculator nodeCharacteristicsCalculator,
			DataCharacteristicsCalculatorFactory dataCharacteristicsCalculatorFactory,
			PCMUncertaintyResourceProvider resourceProvider, String modelProjectName,
			Optional<Class<? extends Plugin>> modelProjectActivator) {
		super(nodeCharacteristicsCalculator, dataCharacteristicsCalculatorFactory, resourceProvider, modelProjectName,
				modelProjectActivator);
	}

	@Override
	public PCMUncertaintyResourceProvider getResourceProvider() {
		return (PCMUncertaintyResourceProvider) resourceProvider;
	}
}
