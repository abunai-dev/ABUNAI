package dev.abunai.confidentiality.analysis.tests.pcm;

import dev.abunai.confidentiality.analysis.core.UncertainConstraintViolation;
import dev.abunai.confidentiality.analysis.pcm.PCMUncertainFlowGraphCollection;
import org.junit.jupiter.api.Test;

import dev.abunai.confidentiality.analysis.tests.PCMTestBase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoronaWarnAppTest extends PCMTestBase {

	@Override
	protected String getFolderName() {
		return "CaseStudy-CoronaWarnApp";
	}

	@Override
	protected String getFilesName() {
		return "default";
	}

	@Override
	protected String getBaseFolder() {
		return "casestudies";
	}

	@Test
	void testCWA() {
		PCMUncertainFlowGraphCollection flowGraphs = (PCMUncertainFlowGraphCollection) analysis.findFlowGraph();
		PCMUncertainFlowGraphCollection uncertainFlowGraphs = flowGraphs.createUncertainFlows();
		uncertainFlowGraphs.evaluate();

		List<UncertainConstraintViolation> result = analysis.queryUncertainDataFlow(uncertainFlowGraphs, it -> {
			return false;
		});
		assertTrue(flowGraphs.getTransposeFlowGraphs().size() < uncertainFlowGraphs.getTransposeFlowGraphs().size());
	}

}
