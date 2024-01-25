package dev.abunai.confidentiality.analysis.pcm;

import java.util.Optional;

import org.dataflowanalysis.analysis.core.DataCharacteristicsCalculatorFactory;
import org.dataflowanalysis.analysis.core.NodeCharacteristicsCalculator;
import org.dataflowanalysis.analysis.pcm.PCMDataFlowConfidentialityAnalysis;
import org.eclipse.core.runtime.Plugin;

import dev.abunai.confidentiality.analysis.UncertaintyAwareConfidentialityAnalysis;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySourceCollection;

public class PCMUncertaintyAwareConfidentialityAnalysis extends PCMDataFlowConfidentialityAnalysis implements UncertaintyAwareConfidentialityAnalysis {
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
	
	public UncertaintySourceCollection getUncertaintySourceCollection() {
		return this.getResourceProvider().getUncertaintySourceCollection();
	}
}
