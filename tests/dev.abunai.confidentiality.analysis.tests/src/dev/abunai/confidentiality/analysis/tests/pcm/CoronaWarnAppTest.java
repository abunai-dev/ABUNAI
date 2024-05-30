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
		PCMUncertainFlowGraphCollection flowGraphs = (PCMUncertainFlowGraphCollection) analysis.findFlowGraph();
		PCMUncertainFlowGraphCollection uncertainFlowGraphs = flowGraphs.createUncertainFlows();
		assertTrue(flowGraphs.getTransposeFlowGraphs().size() < uncertainFlowGraphs.getTransposeFlowGraphs().size());
		
		uncertainFlowGraphs.evaluate();

		List<UncertainConstraintViolation> illegalLocations = analysis.queryUncertainDataFlow(uncertainFlowGraphs, it -> {
			return it.getVertexCharacteristicNames("Location").contains("IllegalLocation");
		});
		assertTrue(illegalLocations.size() > 0);
		
		List<UncertainConstraintViolation> leaks = analysis.queryUncertainDataFlow(uncertainFlowGraphs, it -> {
			return it.getVertexCharacteristicNames("Status").contains("Leaked");
		});
		assertTrue(leaks.size() > 0);
	}

}
