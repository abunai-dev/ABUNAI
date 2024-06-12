package dev.abunai.confidentiality.analysis.tests.dfd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.core.AbstractTransposeFlowGraph;
import org.dataflowanalysis.analysis.dfd.core.DFDVertex;
import org.junit.jupiter.api.Test;

import dev.abunai.confidentiality.analysis.core.UncertainTransposeFlowGraph;
import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.dfd.DFDUncertainFlowGraphCollection;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;
import dev.abunai.confidentiality.analysis.tests.DFDTestBase;

public class SimpleOnlineShopTest extends DFDTestBase {
	private final Logger logger = Logger.getLogger(SimpleOnlineShopTest.class);

	@Override
	protected String getFolderName() {
		return "UncertainOnlineShopDFDsimple";
	}

	@Override
	protected String getFilesName() {
		return "onlineshop";
	}

	
	@Test
	public void testSourceLoading() {
		List<UncertaintySource> sourceCollection = analysis.getUncertaintySources();
		logger.info(String.format("Loaded %d uncertainty sources", sourceCollection.size()));
		sourceCollection.forEach(source -> logger.info(String.format("UncertaintySource: %s", source.getClass().getSimpleName())));
		assertEquals(1, sourceCollection.size(), "Expected one uncertainty source from online shop model");
	}
	
	@Test
	public void testFlowGraphSizeWithoutUncertainties() {
		DFDUncertainFlowGraphCollection flowGraph = (DFDUncertainFlowGraphCollection) analysis.findFlowGraph();
		logger.info(String.format("Flow graph size (without uncertainties): %d", flowGraph.getTransposeFlowGraphs().size()));
		assertEquals(2, flowGraph.getTransposeFlowGraphs().size(), "Online shop model should contain two flow graphs");
	}
	
	@Test
	public void testFlowGraphSizeWithUncertainties() {
		DFDUncertainFlowGraphCollection flowGraph = (DFDUncertainFlowGraphCollection) analysis.findFlowGraph();
		DFDUncertainFlowGraphCollection uncertainFlowGraph = (DFDUncertainFlowGraphCollection) analysis.evaluateUncertainDataFlows(flowGraph);
		logger.info(String.format("Flow graph size (with uncertainties): %d", uncertainFlowGraph.getTransposeFlowGraphs().size()));
		assertEquals(4, uncertainFlowGraph.getTransposeFlowGraphs().size(), "Online shop model should contain two flow graphs");
	}
	
	@Test
	public void testUncertainStateAmount() {
		List<UncertaintySource> sourceCollection = analysis.getUncertaintySources();
		List<UncertainState> allStates = UncertainState.createAllUncertainStates(sourceCollection);
		
		allStates.forEach(it -> logger.info(String.format("Found uncertain state %s", it)));
		
		assertEquals(2, allStates.size(), "Online shop model should contain two uncertain states");
		assertEquals(2, UncertainState.calculateNumberOfAllUncertainStates(sourceCollection), "Online shop model should contain two uncertain states");
	}
	
	@Test
	public void testTransposeFlowGraphLength() {
		DFDUncertainFlowGraphCollection flowGraph = (DFDUncertainFlowGraphCollection) analysis.findFlowGraph();		
		DFDUncertainFlowGraphCollection uncertainFlowGraph = (DFDUncertainFlowGraphCollection) analysis.evaluateUncertainDataFlows(flowGraph);
		
		assertEquals(4, uncertainFlowGraph.getTransposeFlowGraphs().size(), "Online shop model should contain four uncertain transpose flow graphs");
		assertEquals(7, uncertainFlowGraph.getTransposeFlowGraphs().get(0).getVertices().size(), "First transpose flow graph should have seven elements");
		assertEquals(7, uncertainFlowGraph.getTransposeFlowGraphs().get(1).getVertices().size(), "Second transpose flow graph should have seven elements");
		assertEquals(3, uncertainFlowGraph.getTransposeFlowGraphs().get(2).getVertices().size(), "Third transpose flow graph should have three elements");
		assertEquals(3, uncertainFlowGraph.getTransposeFlowGraphs().get(3).getVertices().size(), "Fourth transpose flow graph should have three elements");

	}

	@Test
	void testAnalysis() {
		DFDUncertainFlowGraphCollection flowGraph = (DFDUncertainFlowGraphCollection) analysis.findFlowGraph();		
		DFDUncertainFlowGraphCollection uncertainFlowGraph = (DFDUncertainFlowGraphCollection) analysis.evaluateUncertainDataFlows(flowGraph);
		uncertainFlowGraph.evaluate();
		
		logger.info("Flows: --------------");
		for (AbstractTransposeFlowGraph flow : uncertainFlowGraph.getTransposeFlowGraphs()) {
			if (!(flow instanceof UncertainTransposeFlowGraph uncertainTransposeFlowGraph)) {
				logger.error(String.format("Found uncertain transpose flow graph with class type %s", flow.getClass().getSimpleName()));
				fail("Uncertain flow graph collection contains a transpose flow graph that is not uncertain");
				break;
			}
			
			var stateDesc = uncertainTransposeFlowGraph.getUncertainState().toString();
			var flowDesc = flow.getVertices().stream()
					.map(DFDVertex.class::cast)
					.map(it -> it.getName() + ": "
								+ it.getAllVertexCharacteristics().stream().map(x -> x.getValueName()).toList())
					.collect(Collectors.joining("\n"));
			logger.info("STATE %s:\n%s".formatted(stateDesc, flowDesc));
			logger.info("---------------");
		}

		var violations = analysis.queryUncertainDataFlow(uncertainFlowGraph, it -> {
			var nodeLabels = retrieveNodeLabels(it);
			var dataLabels = retrieveDataLabels(it);
			if (((DFDVertex) it).getName().equals("Database"))
				logger.info(
						"%s: %s, %s".formatted(((DFDVertex) it).getName(), nodeLabels, dataLabels));
			return nodeLabels.contains("nonEU") && dataLabels.contains("Personal");
		});
		
		logger.info(String.format("Found %d violations", violations.size()));
		violations.forEach((violation) -> logger.info(violation));
		assertEquals(1, violations.size(), "Online shop model should contain one transpose flow graph with violations");
		assertEquals(1, violations.get(0).violations().size(), "Transpose flow graph with violation should contain one vertex with violations");
		assertEquals("Default Scenario", violations.get(0).uncertainState().getSelectedUncertaintyScenarios().get(0).getEntityName(), "Violation should occur in default scenario");
		assertEquals("Database", ((DFDVertex) violations.get(0).violations().get(0)).getReferencedElement().getEntityName(), "Violation should occur in Database");
	}
}
