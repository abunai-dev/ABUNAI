package dev.abunai.confidentiality.analysis.tests.dfd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.dataflowanalysis.analysis.dfd.core.DFDVertex;
import org.junit.jupiter.api.Test;

import dev.abunai.confidentiality.analysis.core.UncertainConstraintViolation;
import dev.abunai.confidentiality.analysis.dfd.DFDUncertainFlowGraphCollection;
import dev.abunai.confidentiality.analysis.tests.DFDTestBase;

public class ConnectorUncertaintyTest extends DFDTestBase {
	@Override
	protected String getFolderName() {
		return "DFDConnectorUncertainty";
	}

	@Override
	protected String getFilesName() {
		return "default";
	}

	
	@Test
	public void testResults() {
		DFDUncertainFlowGraphCollection flowGraphs = (DFDUncertainFlowGraphCollection) analysis.findFlowGraph();
		DFDUncertainFlowGraphCollection uncertainFlowGraphs = flowGraphs.createUncertainFlows();
		uncertainFlowGraphs.evaluate();
		
		List<UncertainConstraintViolation> result = analysis.queryUncertainDataFlow(uncertainFlowGraphs, it -> {
			return this.retrieveNodeLabels(it).contains("nonEU") && this.retrieveDataLabels(it).contains("Personal");
		});
		
		assertEquals(2, uncertainFlowGraphs.getTransposeFlowGraphs().size());
		assertEquals(1, result.size());
		assertEquals(1, result.get(0).uncertainState().getSelectedUncertaintyScenarios().size());
		assertEquals(1, result.get(0).violations().size());
		assertTrue(result.get(0).violations().get(0) instanceof DFDVertex);

		assertEquals("Default Scenario", result.get(0).uncertainState().getSelectedUncertaintyScenarios().get(0).getEntityName());
		assertEquals("nonEUDatabase", ((DFDVertex) result.get(0).violations().get(0)).getReferencedElement().getEntityName());
	}
}
