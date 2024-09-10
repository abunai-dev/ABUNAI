package dev.abunai.confidentiality.analysis.tests.evaluation;

import dev.abunai.confidentiality.analysis.core.UncertainConstraintViolation;
import dev.abunai.confidentiality.analysis.pcm.PCMUncertainFlowGraphCollection;

import org.junit.jupiter.api.Test;

import dev.abunai.confidentiality.analysis.tests.PCMTestBase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DistanceTrackerTest extends PCMTestBase {

	@Override
	protected String getFolderName() {
		return "DistanceTracker";
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
	void testDistanceTracker() {
		PCMUncertainFlowGraphCollection flowGraphs = (PCMUncertainFlowGraphCollection) analysis.findFlowGraph();
		PCMUncertainFlowGraphCollection uncertainFlowGraphs = flowGraphs.createUncertainFlows();
		assertTrue(flowGraphs.getTransposeFlowGraphs().size() < uncertainFlowGraphs.getTransposeFlowGraphs().size());
		
		uncertainFlowGraphs.evaluate();

		List<UncertainConstraintViolation> accessViolations = analysis.queryUncertainDataFlow(uncertainFlowGraphs, node -> {
	        List<String> ownedRoles = node.getVertexCharacteristicNames("OwnedRoles");
	        Collection<List<String>> allowedRoles = node.getDataCharacteristicNamesMap("AllowedRoles").values();
			return !ownedRoles.contains("User") 
	        		&& !allowedRoles.stream().allMatch(var -> var.stream().anyMatch(role -> ownedRoles.contains(role)));
		});
		assertTrue(accessViolations.size() > 0);

		List<UncertainConstraintViolation> violations = new ArrayList<>();
		violations.addAll(accessViolations);
		printMetrics("DistanceTracker", analysis.getResourceProvider(), flowGraphs, uncertainFlowGraphs, violations);
	}

}
