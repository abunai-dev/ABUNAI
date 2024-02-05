package dev.abunai.confidentiality.analysis.tests.pcm;

import org.dataflowanalysis.analysis.pcm.core.PCMActionSequence;
import org.dataflowanalysis.analysis.pcm.resource.PCMResourceProvider;
import org.junit.jupiter.api.Test;

import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.core.UncertaintyUtils;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMUncertaintySource;
import dev.abunai.confidentiality.analysis.pcm.UncertainPCMActionSequence;
import dev.abunai.confidentiality.analysis.tests.PCMTestBase;

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

	@Test
	void testCWA() {
		var sourceCollection = analysis.getUncertaintySources();
		var scenarios = UncertaintyUtils.getUncertaintyScenarios(sourceCollection.get(0));
		System.out.println(scenarios.size());

		// All states
		System.out.println(
				"-> All states: %d".formatted(UncertainState.calculateNumberOfAllUncertainStates(sourceCollection)));

		// Actually required states
		var uncertaintySequences = analysis.findAllSequences().stream()
				.map(it -> new UncertainPCMActionSequence((PCMActionSequence) it,
						sourceCollection.stream().map(PCMUncertaintySource.class::cast).toList(),
						(PCMResourceProvider) analysis.getResourceProvider()))
				.toList();

		var requiredStateCount = 0;
		for (var seq : uncertaintySequences) {
			var selectedSources = seq.getRelevantUncertaintySources();
			var stateCount = UncertainState.calculateNumberOfAllUncertainStates(selectedSources);
			requiredStateCount += stateCount;
		}

		System.out.println("-> Actually required states: %d".formatted(requiredStateCount));
	}

}
