package dev.abunai.confidentiality.analysis.tests.pcm;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import dev.abunai.confidentiality.analysis.core.UncertainState;
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

	@Disabled("Test case needs to be repaired")
	@Test
	void testUncertaintyModel() {
		var sourceCollection = analysis.getUncertaintySources();
		var scenarios = UncertaintyUtils.getUncertaintyScenarios(sourceCollection.get(0));
		System.out.println(scenarios.size());
		
		var allStates = UncertainState.createAllUncertainStates(sourceCollection);
		System.out.println(allStates.size());
		System.out.println(UncertainState.calculateNumberOfAllUncertainStates(sourceCollection));
		//allStates.forEach(it -> System.out.println(it));
		
//		var someStates = UncertainState.createAllUncertainStates(sourceCollection.subList(0, 2));
//		var filledStates = someStates.stream().map(it -> it.fillWithDefaultScenarios(sourceCollection)).toList();
//		System.out.println(filledStates.size());
//		filledStates.forEach(it -> System.out.println(it));
	}

}
