package dev.abunai.confidentiality.analysis.tests.pcm;

import org.junit.jupiter.api.Test;

import dev.abunai.confidentiality.analysis.tests.PCMTestBase;

public class UncertaintyModelTest extends PCMTestBase {

	@Override
	protected String getFolderName() {
		return "BranchingOnlineSHop";
		// return "CoronaWarnApp";
	}

	@Override
	protected String getFilesName() {
		return "default";
	}

	@Override
	protected String getBaseFolder() {
		return "models";
		// return "casestudies/CaseStudy-CoronaWarnApp";
	}

	@Test
	void testUncertaintyModel() {
		var sourceCollection = analysis.getUncertaintySourceCollection();
		System.out.println(sourceCollection.getSources().size());
	}

}
