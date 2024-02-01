package dev.abunai.confidentiality.analysis.tests.pcm;

import org.junit.jupiter.api.Test;
import dev.abunai.confidentiality.analysis.core.UncertaintyUtils;
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
		var sourceCollection = analysis.getUncertaintySources();
		var scenarios = UncertaintyUtils.getUncertaintyScenarios(sourceCollection.get(0));
		System.out.println(scenarios.size());
	}

}
