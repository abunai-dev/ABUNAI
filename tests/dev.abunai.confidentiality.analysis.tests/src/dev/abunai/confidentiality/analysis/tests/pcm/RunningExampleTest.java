package dev.abunai.confidentiality.analysis.tests.pcm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import dev.abunai.confidentiality.analysis.core.UncertainConstraintViolation;
import dev.abunai.confidentiality.analysis.pcm.PCMUncertainFlowGraphCollection;
import dev.abunai.confidentiality.analysis.tests.PCMTestBase;

public class RunningExampleTest extends PCMTestBase {

	@Override
	protected String getFolderName() {
		return "OnlineShopRunningExample";
	}

	@Override
	protected String getFilesName() {
		return "default";
	}

	@Test
	public void testRunningExample() {
		PCMUncertainFlowGraphCollection flowGraphs = (PCMUncertainFlowGraphCollection) analysis.findFlowGraph();
        PCMUncertainFlowGraphCollection uncertainFlowGraphs = flowGraphs.createUncertainFlows();
        uncertainFlowGraphs.evaluate();

        List<UncertainConstraintViolation> result = analysis.queryUncertainDataFlow(uncertainFlowGraphs, node -> {
            return false;
        });
        assertEquals(3, flowGraphs.getTransposeFlowGraphs().size(), "Running example contains 3 TFGs");
        assertEquals(40, uncertainFlowGraphs.getTransposeFlowGraphs().size(), "Running example contains 40 Uncertain TFGs");
        assertEquals(3*(3*4*2*2), uncertainFlowGraphs.getScenarioAwareComplexity(), "Scenario Aware Complexity is 144");
        assertEquals(1+4+48, uncertainFlowGraphs.getDataFlowAwareComplexity(), "Scenario Aware Complexity is 53");
        assertEquals((1)+(1+2)+(12+24), uncertainFlowGraphs.getImpactAwareComplexity(), "Impact Aware Complexity is 40");
	}
}
