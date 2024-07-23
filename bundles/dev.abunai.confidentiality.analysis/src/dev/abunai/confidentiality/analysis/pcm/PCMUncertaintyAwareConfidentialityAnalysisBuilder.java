package dev.abunai.confidentiality.analysis.pcm;

import dev.abunai.confidentiality.analysis.UncertaintyResourceProvider;
import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.pcm.PCMDataFlowConfidentialityAnalysisBuilder;
import org.dataflowanalysis.analysis.pcm.resource.PCMResourceProvider;
import org.dataflowanalysis.analysis.utils.ResourceUtils;
import org.eclipse.core.runtime.Plugin;

import java.util.List;
import java.util.Optional;

public class PCMUncertaintyAwareConfidentialityAnalysisBuilder extends PCMDataFlowConfidentialityAnalysisBuilder {

	private final Logger logger = Logger.getLogger(PCMUncertaintyAwareConfidentialityAnalysisBuilder.class);

	private String relativeUncertaintyModelPath;
	private Optional<String> stringFilter = Optional.empty();
	private Optional<List<Integer>> indicesFilter = Optional.empty();
	private Optional<PCMUncertaintyResourceProvider> resourceProvider = Optional.empty();

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

	public PCMUncertaintyAwareConfidentialityAnalysisBuilder useCustomResourceProvider(PCMUncertaintyResourceProvider resourceProvider) {
		this.resourceProvider = Optional.of(resourceProvider);
		this.customResourceProvider = Optional.of(resourceProvider);
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

	public PCMUncertaintyAwareConfidentialityAnalysisBuilder useFilter(String nameFilter) {
		this.stringFilter = Optional.of(nameFilter);
		return this;
	}

	public PCMUncertaintyAwareConfidentialityAnalysisBuilder useFilter(List<Integer> indicesFilter) {
		this.indicesFilter = Optional.of(indicesFilter);
		return this;
	}

	@Override
	public void validate() {
		super.validate();

		if (this.customResourceProvider.isEmpty() && (this.relativeUncertaintyModelPath == null || this.relativeUncertaintyModelPath.isEmpty())) {
			logger.warn(
					"Uncertainty model missing. Only confidentiality analysis without considering uncertainty will be possible.");
		}
	}

	@Override
	public PCMUncertaintyAwareConfidentialityAnalysis build() {
		this.validate();

		PCMUncertaintyResourceProvider resourceProvider;
        resourceProvider = this.resourceProvider.orElseGet(() -> new PCMUncertaintyResourceProvider(
                ResourceUtils.createRelativePluginURI(this.relativeUsageModelPath, modelProjectName),
                ResourceUtils.createRelativePluginURI(this.relativeAllocationModelPath, modelProjectName),
                ResourceUtils.createRelativePluginURI(this.relativeNodeCharacteristicsPath, modelProjectName),
                ResourceUtils.createRelativePluginURI(this.relativeUncertaintyModelPath, modelProjectName)));
		return new PCMUncertaintyAwareConfidentialityAnalysis(resourceProvider, pluginActivator, modelProjectName, this.stringFilter, this.indicesFilter);
	}
}
