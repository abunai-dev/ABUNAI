package dev.abunai.confidentiality.analysis;

import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.pcm.PCMDataFlowConfidentialityAnalysisBuilder;
import org.dataflowanalysis.analysis.pcm.core.PCMDataCharacteristicsCalculatorFactory;
import org.dataflowanalysis.analysis.pcm.core.PCMNodeCharacteristicsCalculator;
import org.dataflowanalysis.analysis.pcm.resource.PCMResourceProvider;
import org.dataflowanalysis.analysis.utils.ResourceUtils;
import org.eclipse.core.runtime.Plugin;

public class PCMUncertaintyAwareConfidentialityAnalysisBuilder extends PCMDataFlowConfidentialityAnalysisBuilder {

	private final Logger logger = Logger.getLogger(PCMUncertaintyAwareConfidentialityAnalysisBuilder.class);

	private String relativeUncertaintyModelPath;

	@Override
	public PCMUncertaintyAwareConfidentialityAnalysisBuilder standalone() {
		super.standalone();
		return this;
	}

	@Override
	public PCMUncertaintyAwareConfidentialityAnalysisBuilder modelProjectName(String modelProjectName) {
		super.modelProjectName(modelProjectName);
		return this;
	}

	@Override
	public PCMUncertaintyAwareConfidentialityAnalysisBuilder usePluginActivator(
			Class<? extends Plugin> pluginActivator) {
		super.usePluginActivator(pluginActivator);
		return this;
	}

	@Override
	public PCMUncertaintyAwareConfidentialityAnalysisBuilder useUsageModel(String relativeUsageModelPath) {
		super.useUsageModel(relativeUsageModelPath);
		return this;
	}

	@Override
	public PCMUncertaintyAwareConfidentialityAnalysisBuilder useAllocationModel(String relativeAllocationModelPath) {
		super.useAllocationModel(relativeAllocationModelPath);
		return this;
	}

	@Override
	public PCMDataFlowConfidentialityAnalysisBuilder useCustomResourceProvider(PCMResourceProvider resourceProvider) {
		logger.error("Custom resource providers are not supported by the uncertainty-aware confidentiality analysis.");
		return this;
	}

	@Override
	public PCMUncertaintyAwareConfidentialityAnalysisBuilder useNodeCharacteristicsModel(
			String relativeNodeCharacteristicsModelPath) {
		super.useNodeCharacteristicsModel(relativeNodeCharacteristicsModelPath);
		return this;
	}

	public PCMUncertaintyAwareConfidentialityAnalysisBuilder useUncertaintyModel(String relativeUncertaintyModelPath) {
		this.relativeUncertaintyModelPath = relativeUncertaintyModelPath;
		return this;
	}

	@Override
	public void validate() {
		super.validate();

		if (this.relativeUncertaintyModelPath == null || this.relativeUncertaintyModelPath.isEmpty()) {
			logger.warn(
					"Uncertainty model missing. Only confidentiality analysis without considering uncertainty will be possible");
		}
	}

	@Override
	public PCMUncertaintyAwareConfidentialityAnalysis build() {
		this.validate();

		PCMUncertaintyResourceProvider resourceProvider = new PCMUncertaintyResourceProvider(
				ResourceUtils.createRelativePluginURI(this.relativeUsageModelPath, modelProjectName),
				ResourceUtils.createRelativePluginURI(this.relativeAllocationModelPath, modelProjectName),
				ResourceUtils.createRelativePluginURI(this.relativeNodeCharacteristicsPath, modelProjectName),
				ResourceUtils.createRelativePluginURI(this.relativeUncertaintyModelPath, modelProjectName));

		return new PCMUncertaintyAwareConfidentialityAnalysis(new PCMNodeCharacteristicsCalculator(resourceProvider),
				new PCMDataCharacteristicsCalculatorFactory(resourceProvider), resourceProvider, modelProjectName,
				pluginActivator);
	}
}
