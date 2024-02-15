package dev.abunai.confidentiality.analysis.tests.dfd;

import org.dataflowanalysis.analysis.dfd.core.DFDActionSequence;
import org.junit.jupiter.api.Test;

import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.core.UncertaintyUtils;
import dev.abunai.confidentiality.analysis.dfd.UncertaintyDFDActionSequence;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDUncertaintySource;
import dev.abunai.confidentiality.analysis.tests.DFDTestBase;

public class OnlineShopTest extends DFDTestBase {

	@Override
	protected String getFolderName() {
		return "UncertainOnlineShopDFDsimple";
	}

	@Override
	protected String getFilesName() {
		return "onlineshop";
	}

	@Override
	protected String getBaseFolder() {
		return "models";
	}

	@Test
	void testAnalysis() {
		var sourceCollection = analysis.getUncertaintySources();
		System.out.println(sourceCollection.size());

		sourceCollection.forEach(source -> System.out.println(source.getClass().getSimpleName()));

		var evaluatedSequences = analysis.evaluateDataFlows(analysis.findAllSequences());
		System.out.println(evaluatedSequences.size());
		System.out.println(UncertaintyUtils.getUncertaintySourceName(sourceCollection.get(0)));

		var allStates = UncertainState.createAllUncertainStates(sourceCollection);
		System.out.println(allStates.size());
		System.out.println(UncertainState.calculateNumberOfAllUncertainStates(sourceCollection));
		allStates.forEach(it -> System.out.println(it));

		var uncertaintySequences = analysis.findAllSequences().stream()
				.map(it -> new UncertaintyDFDActionSequence((DFDActionSequence) it,
						sourceCollection.stream().map(DFDUncertaintySource.class::cast).toList()))
				.toList();

		var requiredStateCount = 0;
		for (var seq : uncertaintySequences) {
			var selectedSources = seq.getRelevantUncertaintySources();
			var stateCount = UncertainState.calculateNumberOfAllUncertainStates(selectedSources);
			requiredStateCount += stateCount;
		}

		System.out.println(
				"-> All states: %d".formatted(UncertainState.calculateNumberOfAllUncertainStates(sourceCollection)));
		System.out.println("-> Actually required states: %d".formatted(requiredStateCount));
	}

}
