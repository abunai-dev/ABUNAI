package dev.abunai.confidentiality.analysis.tests.dfd;

import java.util.List;
import java.util.stream.Collectors;

import org.dataflowanalysis.analysis.core.AbstractPartialFlowGraph;
import org.dataflowanalysis.analysis.core.AbstractVertex;
import org.dataflowanalysis.analysis.core.DataFlowVariable;
import org.dataflowanalysis.analysis.dfd.core.DFDCharacteristicValue;
import org.dataflowanalysis.analysis.dfd.core.DFDVertex;
import org.junit.jupiter.api.Test;

import dev.abunai.confidentiality.analysis.core.UncertainPartialFlowGraph;
import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.core.UncertaintyUtils;
import dev.abunai.confidentiality.analysis.dfd.DFDUncertainFlowGraph;
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
		
		DFDUncertainFlowGraph flowGraph = (DFDUncertainFlowGraph) analysis.findFlowGraph();
		System.out.println("Flow graph size (without uncertainties): " + flowGraph.getPartialFlowGraphs().size());
		
		DFDUncertainFlowGraph uncertainFlowGraph = (DFDUncertainFlowGraph) analysis.evaluateUncertainDataFlows(flowGraph);
		System.out.println("Flow graph size (with uncertainties): " + uncertainFlowGraph.getPartialFlowGraphs().size());

		System.out.println(UncertaintyUtils.getUncertaintySourceName(sourceCollection.get(0)));

		var allStates = UncertainState.createAllUncertainStates(sourceCollection);
		System.out.println(allStates.size());
		System.out.println(UncertainState.calculateNumberOfAllUncertainStates(sourceCollection));
		allStates.forEach(it -> System.out.println(it));

		List<? extends UncertainPartialFlowGraph> partialFlowGraphs = uncertainFlowGraph.getPartialFlowGraphs().stream()
				.map(UncertainPartialFlowGraph.class::cast)
				.toList();

		var requiredStateCount = 0;
		for (var pfg : partialFlowGraphs) {
			var selectedSources = pfg.getRelevantUncertaintySources();
			var stateCount = UncertainState.calculateNumberOfAllUncertainStates(selectedSources);
			requiredStateCount += stateCount;
		}

		System.out.println(
				"-> All states: %d".formatted(UncertainState.calculateNumberOfAllUncertainStates(sourceCollection)));
		System.out.println("-> Actually required states: %d".formatted(requiredStateCount));

		System.out.println("All action sequences length: %s"
				.formatted(uncertainFlowGraph.getPartialFlowGraphs().stream().map(it -> it.getVertices().size()).toList()));

		System.out.println("Impact set: %s"
				.formatted(uncertainFlowGraph.getPartialFlowGraphs().stream()
						.map(UncertainPartialFlowGraph.class::cast)
						.map(it -> it.getImpactSet(analysis.getResourceProvider()).size()).toList()));

		uncertainFlowGraph.evaluate();
		System.out.println("Flows: --------------");

		for (AbstractPartialFlowGraph flow : uncertainFlowGraph.getPartialFlowGraphs()) {
			if (!(flow instanceof UncertainPartialFlowGraph uncertainPartialFlowGraph)) {
				System.out.println("Did not find uncertain partial flow graph");
				continue;
			}
			
			var stateDesc = uncertainPartialFlowGraph.getUncertainState().toString();
			var flowDesc = flow.getVertices().stream()
					.map(DFDVertex.class::cast)
					.map(it -> it.getName() + ": "
								+ it.getAllNodeCharacteristics().stream().map(x -> x.getValueName()).toList())
					.collect(Collectors.joining("\n"));
			System.out.println("STATE %s:\n%s".formatted(stateDesc, flowDesc));
			System.out.println("---------------");
		}

		var violations = analysis.queryUncertainDataFlow(uncertainFlowGraph, it -> {
			var nodeLabels = retrieveNodeLabels(it);
			var dataLabels = retrieveDataLabels(it);

			if (((DFDVertex) it).getName().equals("Database"))
				System.out.println(
						"%s: %s, %s".formatted(((DFDVertex) it).getName(), nodeLabels, dataLabels));

			// TODO: Not working yet as label propagation is broken again, waiting for v2
			return nodeLabels.contains("nonEU") && dataLabels.contains("Personal");
		});
		violations.forEach((violation) -> System.out.println(violation));
	}

	// Copied from the original dfd test case
	private List<String> retrieveNodeLabels(AbstractVertex<?> vertex) {
		return vertex.getAllNodeCharacteristics().stream().map(DFDCharacteristicValue.class::cast)
				.map(DFDCharacteristicValue::getValueName).toList();
	}

	private List<String> retrieveDataLabels(AbstractVertex<?> vertex) {
		return vertex.getAllDataFlowVariables().stream().map(DataFlowVariable::getAllCharacteristics)
				.flatMap(List::stream).map(DFDCharacteristicValue.class::cast).map(DFDCharacteristicValue::getValueName)
				.toList();
	}

}
