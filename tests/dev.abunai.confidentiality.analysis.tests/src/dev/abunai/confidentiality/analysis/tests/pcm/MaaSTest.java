package dev.abunai.confidentiality.analysis.tests.pcm;

import dev.abunai.confidentiality.analysis.core.UncertainConstraintViolation;
import dev.abunai.confidentiality.analysis.pcm.PCMUncertainFlowGraphCollection;
import org.junit.jupiter.api.Test;

import dev.abunai.confidentiality.analysis.tests.PCMTestBase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MaaSTest extends PCMTestBase {

	@Override
	protected String getFolderName() {
		return "MaaS_Ticket_System_base";
	}

	@Override
	protected String getFilesName() {
		return "MaaS";
	}

	@Override
	protected String getBaseFolder() {
		return "casestudies";
	}

	@Test
	void testMaaS() {
		PCMUncertainFlowGraphCollection flowGraphs = (PCMUncertainFlowGraphCollection) analysis.findFlowGraph();
		PCMUncertainFlowGraphCollection uncertainFlowGraphs = flowGraphs.createUncertainFlows();
		assertTrue(flowGraphs.getTransposeFlowGraphs().size() < uncertainFlowGraphs.getTransposeFlowGraphs().size());
		
		uncertainFlowGraphs.evaluate();

		List<UncertainConstraintViolation> illegalLocations = analysis.queryUncertainDataFlow(uncertainFlowGraphs, it -> {
			return it.getVertexCharacteristicNames("Role").contains("MaliciousActor");
		});
		assertTrue(illegalLocations.size() > 0);
		
		List<UncertainConstraintViolation> leakedCredentials = analysis.queryUncertainDataFlow(uncertainFlowGraphs, it -> {
			return it.getVertexCharacteristicNames("Role").contains("Customer") 
					&& 
					it.getDataCharacteristicNamesMap("DataType").values().stream().flatMap(List::stream).anyMatch(cv -> cv.equals("LoginData"));
		});
		assertTrue(leakedCredentials.size() > 0);
		
		List<UncertainConstraintViolation> leaks = analysis.queryUncertainDataFlow(uncertainFlowGraphs, it -> {
			return it.getVertexCharacteristicNames("Role").contains("Customer") 
					&& 
					it.getDataCharacteristicNamesMap("DataType").values().stream().anyMatch(vars -> vars.stream().anyMatch(cv -> cv.equals("LoginData")));
		});
		assertTrue(leaks.size() > 0);
	}

}
