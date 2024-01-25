package dev.abunai.confidentiality.analysis.tests.util;

import org.junit.jupiter.api.Test;

import dev.abunai.confidentiality.analysis.tests.TestBase;

public class UncertaintyModelTest extends TestBase {

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
