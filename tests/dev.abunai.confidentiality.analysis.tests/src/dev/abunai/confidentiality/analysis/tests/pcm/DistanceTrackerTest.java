package dev.abunai.confidentiality.analysis.tests.pcm;

import dev.abunai.confidentiality.analysis.core.UncertainConstraintViolation;
import dev.abunai.confidentiality.analysis.pcm.PCMUncertainFlowGraphCollection;

import org.dataflowanalysis.analysis.core.CharacteristicValue;
import org.junit.jupiter.api.Test;

import dev.abunai.confidentiality.analysis.tests.PCMTestBase;

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

		/*
		List<UncertainConstraintViolation> accessViolations = analysis.queryUncertainDataFlow(uncertainFlowGraphs, node -> {
			List<String> ownedRoles = node.getVertexCharacteristics("OwnedRoles")
	                .stream()
	                .map(CharacteristicValue::getValueName)
	                .toList();
	        Collection<List<CharacteristicValue>> allowedRoles = node.getDataCharacteristicMap("AllowedRoles")
	                .values();

	        for (List<CharacteristicValue> dataFlowCharacteristics : allowedRoles) {
	            if (!dataFlowCharacteristics.isEmpty() && dataFlowCharacteristics.stream()
	                    .distinct()
	                    .map(CharacteristicValue::getValueName)
	                    .noneMatch(ownedRoles::contains)) {
	                return true;
	            }
	        }
	        return false;
		});
		assertTrue(accessViolations.size() > 0);
		*/
		
		List<UncertainConstraintViolation> leaks = analysis.queryUncertainDataFlow(uncertainFlowGraphs, it -> {
			return it.getDataCharacteristicNamesMap("DataOrigin").values().stream().anyMatch(vars -> vars.stream().anyMatch(cv -> cv.equals("Leaked")));
		});
		assertTrue(leaks.size() > 0);
	}

}
