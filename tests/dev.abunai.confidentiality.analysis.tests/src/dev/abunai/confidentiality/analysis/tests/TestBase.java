package dev.abunai.confidentiality.analysis.tests;

import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import dev.abunai.confidentiality.analysis.PCMUncertaintyAwareConfidentialityAnalysis;
import dev.abunai.confidentiality.analysis.PCMUncertaintyAwareConfidentialityAnalysisBuilder;
import dev.abunai.confidentiality.analysis.testmodels.Activator;

public abstract class TestBase {

	public static final String TEST_MODEL_PROJECT_NAME = "dev.abunai.confidentiality.analysis.testmodels";
	protected PCMUncertaintyAwareConfidentialityAnalysis analysis = null;

	protected abstract String getFolderName();

	protected abstract String getFilesName();

	protected String getBaseFolder() {
		return "models";
	}

	@BeforeEach
	public void setup() {
		final var usageModelPath = Paths.get(getBaseFolder(), getFolderName(), getFilesName() + ".usagemodel")
				.toString();
		final var allocationPath = Paths.get(getBaseFolder(), getFolderName(), getFilesName() + ".allocation")
				.toString();
		final var nodeCharacteristicsPath = Paths
				.get(getBaseFolder(), getFolderName(), getFilesName() + ".nodecharacteristics").toString();
		final var uncertaintyPath = Paths.get(getBaseFolder(), getFolderName(), getFilesName() + ".uncertainty")
				.toString();

		var builder = new PCMUncertaintyAwareConfidentialityAnalysisBuilder().standalone()
				.modelProjectName(TEST_MODEL_PROJECT_NAME).usePluginActivator(Activator.class)
				.useUsageModel(usageModelPath).useAllocationModel(allocationPath).useUncertaintyModel(uncertaintyPath)
				.useNodeCharacteristicsModel(nodeCharacteristicsPath);

		var analysis = builder.build();
		analysis.initializeAnalysis();

		this.analysis = analysis;
	}
}
