package dev.abunai.confidentiality.analysis.tests.pcm;

import dev.abunai.confidentiality.analysis.core.UncertainConstraintViolation;
import dev.abunai.confidentiality.analysis.pcm.PCMUncertainFlowGraphCollection;
import org.junit.jupiter.api.Test;

import dev.abunai.confidentiality.analysis.tests.PCMTestBase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

		//Scenario 1 & 2 IllegalLocation
		List<UncertainConstraintViolation> illegalLocations = analysis.queryUncertainDataFlow(uncertainFlowGraphs, it -> {
			return it.getVertexCharacteristicNames("Location").contains("IllegalLocation");
		});
		assertTrue(illegalLocations.size() > 0);
		
		//Scenario 3 Tan Validation Failed
		List<UncertainConstraintViolation> validationFailures = analysis.queryUncertainDataFlow(uncertainFlowGraphs, it -> {
			return !it.getDataCharacteristicNames("Status").contains("Validated");
		});
		assertTrue(validationFailures.size() > 0);
		
		//Scenario 4 Leaked Data		
		List<UncertainConstraintViolation> leaks = analysis.queryUncertainDataFlow(uncertainFlowGraphs, it -> {
			return it.getDataCharacteristicNamesMap("Status").values().stream().flatMap(List::stream).anyMatch(cv -> cv.equals("Leaked"));
		});
		assertTrue(leaks.size() > 0);
	}

}
