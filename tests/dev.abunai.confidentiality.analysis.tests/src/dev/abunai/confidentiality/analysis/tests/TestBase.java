package dev.abunai.confidentiality.analysis.tests;

import dev.abunai.confidentiality.analysis.UncertaintyAwareConfidentialityAnalysis;

public abstract class TestBase {

	public static final String TEST_MODEL_PROJECT_NAME = "dev.abunai.confidentiality.analysis.testmodels";
	protected UncertaintyAwareConfidentialityAnalysis analysis = null;

	protected abstract String getFolderName();

	protected abstract String getFilesName();

	protected String getBaseFolder() {
		return "models";
	}
	
}
