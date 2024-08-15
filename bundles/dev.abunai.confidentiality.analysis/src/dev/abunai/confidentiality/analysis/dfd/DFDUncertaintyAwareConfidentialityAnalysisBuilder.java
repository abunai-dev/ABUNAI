package dev.abunai.confidentiality.analysis.dfd;

import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.dfd.DFDDataFlowAnalysisBuilder;
import org.dataflowanalysis.analysis.dfd.resource.DFDResourceProvider;
import org.dataflowanalysis.analysis.utils.ResourceUtils;
import org.eclipse.core.runtime.Plugin;

import java.util.List;
import java.util.Optional;

/**
 * Builder class of {@link DFDUncertaintyAwareConfidentialityAnalysis}
 */
public class DFDUncertaintyAwareConfidentialityAnalysisBuilder extends DFDDataFlowAnalysisBuilder {

	private final Logger logger = Logger.getLogger(DFDUncertaintyAwareConfidentialityAnalysisBuilder.class);

	private String relativeUncertaintyModelPath;
	private Optional<String> stringFilter = Optional.empty();
	private Optional<List<Integer>> indicesFilter = Optional.empty();

	/**
	 * Sets the path the uncertainty model is located
	 * @param relativeUncertaintyModelPath Relative path to the uncertainty model
	 * @return Returns builder object of the analysis
	 */
	public DFDUncertaintyAwareConfidentialityAnalysisBuilder useUncertaintyModel(String relativeUncertaintyModelPath) {
		this.relativeUncertaintyModelPath = relativeUncertaintyModelPath;
		return this;
	}

	@Override
	public DFDUncertaintyAwareConfidentialityAnalysisBuilder standalone() {
		super.standalone();
		return this;
	}

	@Override
	public DFDUncertaintyAwareConfidentialityAnalysisBuilder modelProjectName(String modelProjectName) {
		super.modelProjectName(modelProjectName);
		return this;
	}

	@Override
	public DFDUncertaintyAwareConfidentialityAnalysisBuilder usePluginActivator(
			Class<? extends Plugin> pluginActivator) {
		super.usePluginActivator(pluginActivator);
		return this;
	}

	@Override
	public DFDUncertaintyAwareConfidentialityAnalysisBuilder useDataDictionary(String dataDictionaryPath) {
		super.useDataDictionary(dataDictionaryPath);
		return this;
	}

	@Override
	public DFDUncertaintyAwareConfidentialityAnalysisBuilder useDataFlowDiagram(String dataFlowDiagramPath) {
		super.useDataFlowDiagram(dataFlowDiagramPath);
		return this;
	}

	@Override
	public DFDUncertaintyAwareConfidentialityAnalysisBuilder useCustomResourceProvider(DFDResourceProvider resourceProvider) {
		logger.error("Custom resource providers are not supported by the uncertainty-aware confidentiality analysis.");
		return this;
	}

	public DFDUncertaintyAwareConfidentialityAnalysisBuilder useFilter(String nameFilter) {
		this.stringFilter = Optional.of(nameFilter);
		return this;
	}

	public DFDUncertaintyAwareConfidentialityAnalysisBuilder useFilter(List<Integer> indicesFilter) {
		this.indicesFilter = Optional.of(indicesFilter);
		return this;
	}

	@Override
	public void validate() {
		super.validate();

		if (this.relativeUncertaintyModelPath == null || this.relativeUncertaintyModelPath.isEmpty()) {
			logger.warn(
					"Uncertainty model missing. Only confidentiality analysis without considering uncertainty will be possible.");
		}
	}

	@Override
	public DFDUncertaintyAwareConfidentialityAnalysis build() {
		this.validate();

		DFDUncertaintyResourceProvider resourceProvider = new DFDUncertaintyResourceProvider(
				ResourceUtils.createRelativePluginURI(this.dataFlowDiagramPath, this.modelProjectName),
				ResourceUtils.createRelativePluginURI(this.dataDictionaryPath, this.modelProjectName),
				ResourceUtils.createRelativePluginURI(this.relativeUncertaintyModelPath, modelProjectName));

		return new DFDUncertaintyAwareConfidentialityAnalysis(resourceProvider, this.pluginActivator,
				this.modelProjectName, this.stringFilter, this.indicesFilter);
	}

}
