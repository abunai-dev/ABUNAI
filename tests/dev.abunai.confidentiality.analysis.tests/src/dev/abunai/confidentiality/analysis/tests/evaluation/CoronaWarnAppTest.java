package dev.abunai.confidentiality.analysis.tests.evaluation;

import dev.abunai.confidentiality.analysis.core.UncertainConstraintViolation;
import dev.abunai.confidentiality.analysis.pcm.PCMUncertainFlowGraphCollection;
import dev.abunai.evaluationscenario.cwa.Activator;
import org.eclipse.core.runtime.Plugin;
import org.junit.jupiter.api.Test;

import dev.abunai.confidentiality.analysis.tests.PCMTestBase;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoronaWarnAppTest extends PCMTestBase {

	@Override
	protected String getFolderName() {
		return "CoronaWarnApp_UncertaintyModel";
	}

	@Override
	protected String getFilesName() {
		return "default";
	}

	@Override
	protected Class<? extends Plugin> getActivator() {
		return Activator.class;
	}

	@Override
	protected String getModelProjectName() {
		return "dev.abunai.evaluationscenario.cwa";
	}

	@Override
	protected String getBaseFolder() {
		return "";
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
			return !it.getDataCharacteristicNamesMap("Status").values().stream().flatMap(List::stream).anyMatch(cv -> cv.equals("Validated"));
		});
		assertTrue(validationFailures.size() > 0);
		
		//Scenario 4 Leaked Data		
		List<UncertainConstraintViolation> leaks = analysis.queryUncertainDataFlow(uncertainFlowGraphs, it -> {
			return it.getDataCharacteristicNamesMap("Status").values().stream().flatMap(List::stream).anyMatch(cv -> cv.equals("Leaked"));
		});
		assertTrue(leaks.size() > 0);
		
		List<UncertainConstraintViolation> violations = new ArrayList<>();
		violations.addAll(illegalLocations);
		violations.addAll(validationFailures);
		violations.addAll(leaks);
		printMetrics("CoronaWarnApp", analysis.getResourceProvider(), flowGraphs, uncertainFlowGraphs, violations);
	}

}
