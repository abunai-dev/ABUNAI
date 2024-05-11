package dev.abunai.confidentiality.analysis.tests.pcm;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.core.UncertaintyUtils;
import dev.abunai.confidentiality.analysis.tests.PCMTestBase;

@Disabled
public class CoronaWarnAppTest extends PCMTestBase {

	@Override
	protected String getFolderName() {
		return "CoronaWarnApp";
	}

	@Override
	protected String getFilesName() {
		return "default";
	}

	@Override
	protected String getBaseFolder() {
		return "casestudies/CaseStudy-CoronaWarnApp";
	}

	@Disabled("Test case needs to be repaired")
	@Test
	void testCWA() {
		var sourceCollection = analysis.getUncertaintySources();
		var scenarios = UncertaintyUtils.getUncertaintyScenarios(sourceCollection.get(0));
		System.out.println(scenarios.size());

		// All states
		System.out.println(
				"-> All states: %d".formatted(UncertainState.calculateNumberOfAllUncertainStates(sourceCollection)));
	}

}
