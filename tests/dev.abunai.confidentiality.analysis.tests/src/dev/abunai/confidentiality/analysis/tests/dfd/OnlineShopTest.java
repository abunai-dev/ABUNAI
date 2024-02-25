package dev.abunai.confidentiality.analysis.tests.dfd;

import java.util.List;

import org.dataflowanalysis.analysis.core.AbstractActionSequenceElement;
import org.dataflowanalysis.analysis.core.DataFlowVariable;
import org.dataflowanalysis.analysis.dfd.core.DFDActionSequence;
import org.dataflowanalysis.analysis.dfd.core.DFDCharacteristicValue;
import org.junit.jupiter.api.Test;

import dev.abunai.confidentiality.analysis.core.UncertainActionSequence;
import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.core.UncertaintyUtils;
import dev.abunai.confidentiality.analysis.dfd.UncertainDFDActionSequence;
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

		List<? extends UncertainActionSequence> uncertaintySequences = analysis.findAllUncertainSequences();

		var requiredStateCount = 0;
		for (var seq : uncertaintySequences) {
			var selectedSources = seq.getRelevantUncertaintySources();
			var stateCount = UncertainState.calculateNumberOfAllUncertainStates(selectedSources);
			requiredStateCount += stateCount;
		}

		System.out.println(
				"-> All states: %d".formatted(UncertainState.calculateNumberOfAllUncertainStates(sourceCollection)));
		System.out.println("-> Actually required states: %d".formatted(requiredStateCount));

		System.out.println("All action sequences lenght: %s"
				.formatted(evaluatedSequences.stream().map(it -> it.getElements().size()).toList()));

		System.out.println("Impact set: %s"
				.formatted(uncertaintySequences.stream().map(it -> it.getImpactSet().getElements().size()).toList()));

		var evaluatedFlows = analysis.evaluateUncertainDataFlows(uncertaintySequences);
		System.out.println(evaluatedFlows);

		for (var flow : evaluatedFlows) {
			var violations = analysis.queryUncertainDataFlow(flow, it -> {
				var nodeLabels = retrieveNodeLabels(it);
				var dataLabels = retrieveDataLabels(it);

				return nodeLabels.contains("nonEU") && dataLabels.contains("Personal");
			});

			System.out.println(violations);
		}

	}

	// Copied from the original dfd test case
	private List<String> retrieveNodeLabels(AbstractActionSequenceElement<?> vertex) {
		return vertex.getAllNodeCharacteristics().stream().map(DFDCharacteristicValue.class::cast)
				.map(DFDCharacteristicValue::getValueName).toList();
	}

	private List<String> retrieveDataLabels(AbstractActionSequenceElement<?> vertex) {
		return vertex.getAllDataFlowVariables().stream().map(DataFlowVariable::getAllCharacteristics)
				.flatMap(List::stream).map(DFDCharacteristicValue.class::cast).map(DFDCharacteristicValue::getValueName)
				.toList();
	}

}
