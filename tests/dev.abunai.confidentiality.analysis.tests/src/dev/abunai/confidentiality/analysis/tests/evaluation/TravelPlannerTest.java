package dev.abunai.confidentiality.analysis.tests.evaluation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.List;

import org.dataflowanalysis.analysis.core.AbstractVertex;
import org.dataflowanalysis.analysis.core.CharacteristicValue;
import org.junit.jupiter.api.Test;

import dev.abunai.confidentiality.analysis.core.UncertainConstraintViolation;
import dev.abunai.confidentiality.analysis.pcm.PCMUncertainFlowGraphCollection;
import dev.abunai.confidentiality.analysis.tests.PCMTestBase;

public class TravelPlannerTest extends PCMTestBase {

	@Override
	protected String getFolderName() {
		return "TravelPlanner";
	}

	@Override
	protected String getFilesName() {
		return "travelPlanner";
	}

	@Override
	protected String getBaseFolder() {
		return "casestudies";
	}

	private boolean travelPlannerCondition(AbstractVertex<?> node) {
        List<String> assignedRoles = node.getVertexCharacteristics("AssignedRoles")
                .stream()
                .map(CharacteristicValue::getValueName)
                .toList();
        Collection<List<CharacteristicValue>> grantedRoles = node.getDataCharacteristicMap("GrantedRoles")
                .values();

        for (List<CharacteristicValue> dataFlowCharacteristics : grantedRoles) {
            if (!dataFlowCharacteristics.isEmpty() && dataFlowCharacteristics.stream()
                    .distinct()
                    .map(CharacteristicValue::getValueName)
                    .noneMatch(assignedRoles::contains)) {
                return true;
            }
        }
        return false;
    }
	
	@Test
	void testTravelPlanner() {
		PCMUncertainFlowGraphCollection flowGraphs = (PCMUncertainFlowGraphCollection) analysis.findFlowGraph();
		PCMUncertainFlowGraphCollection uncertainFlowGraphs = flowGraphs.createUncertainFlows();
		assertTrue(flowGraphs.getTransposeFlowGraphs().size() < uncertainFlowGraphs.getTransposeFlowGraphs().size());
		
		uncertainFlowGraphs.evaluate();

		List<UncertainConstraintViolation> accessViolations = analysis.queryUncertainDataFlow(uncertainFlowGraphs, this::travelPlannerCondition);
		assertEquals(1, accessViolations.size());
		printMetrics("TravelPlanner", analysis.getResourceProvider(), uncertainFlowGraphs, accessViolations);
	}
}
