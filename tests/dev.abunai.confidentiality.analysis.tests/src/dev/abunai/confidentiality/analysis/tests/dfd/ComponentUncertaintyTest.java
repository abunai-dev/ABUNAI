package dev.abunai.confidentiality.analysis.tests.dfd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.dataflowanalysis.analysis.dfd.core.DFDVertex;
import org.junit.jupiter.api.Test;

import dev.abunai.confidentiality.analysis.core.UncertainConstraintViolation;
import dev.abunai.confidentiality.analysis.dfd.DFDUncertainFlowGraphCollection;
import dev.abunai.confidentiality.analysis.tests.DFDTestBase;

public class ComponentUncertaintyTest extends DFDTestBase {
	@Override
	protected String getFolderName() {
		return "ComponentUncertainty";
	}

	@Override
	protected String getFilesName() {
		return "default";
	}

	@Override
	protected String getBaseFolder() {
		return "models";
	}
	
	@Test
	public void testResults() {
		DFDUncertainFlowGraphCollection flowGraphs = (DFDUncertainFlowGraphCollection) analysis.findFlowGraph();
		DFDUncertainFlowGraphCollection uncertainFlowGraphs = flowGraphs.createUncertainFlows();
		uncertainFlowGraphs.evaluate();
		
		List<UncertainConstraintViolation> result = analysis.queryUncertainDataFlow(uncertainFlowGraphs, it -> {
			return this.retrieveNodeLabels(it).contains("nonEU") && this.retrieveDataLabels(it).contains("Personal");
		});
		
		assertEquals(1, result.size());
		assertEquals(1, result.get(0).getUncertainState().getSelectedUncertaintyScenarios().size());
		assertEquals(1, result.get(0).getViolations().size());
		assertTrue(result.get(0).getViolations().get(0) instanceof DFDVertex);

		assertEquals("Default Scenario", result.get(0).getUncertainState().getSelectedUncertaintyScenarios().get(0).getEntityName());
		assertEquals("nonEUDatabase", ((DFDVertex) result.get(0).getViolations().get(0)).getReferencedElement().getEntityName());
	}
}
