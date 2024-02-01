package dev.abunai.confidentiality.analysis.pcm;

import java.util.List;
import java.util.Optional;

import org.dataflowanalysis.analysis.core.DataCharacteristicsCalculatorFactory;
import org.dataflowanalysis.analysis.core.NodeCharacteristicsCalculator;
import org.dataflowanalysis.analysis.pcm.PCMDataFlowConfidentialityAnalysis;
import org.eclipse.core.runtime.Plugin;

import dev.abunai.confidentiality.analysis.UncertaintyAwareConfidentialityAnalysis;
import dev.abunai.confidentiality.analysis.core.UncertaintySourceManager;
import dev.abunai.confidentiality.analysis.core.UncertaintySourceType;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;

public class PCMUncertaintyAwareConfidentialityAnalysis extends PCMDataFlowConfidentialityAnalysis
		implements UncertaintyAwareConfidentialityAnalysis {

	private UncertaintySourceManager uncertaintySourceManager;

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

	@Override
	public List<UncertaintySource> getUncertaintySources() {
		return this.uncertaintySourceManager.getUncertaintySources();
	}

	@Override
	public boolean initializeAnalysis() {
		if (!super.initializeAnalysis()) {
			return false;
		} else {
			this.uncertaintySourceManager = new UncertaintySourceManager(
					this.getResourceProvider().getUncertaintySourceCollection(), UncertaintySourceType.PCM);
			return true;
		}
	}
}
