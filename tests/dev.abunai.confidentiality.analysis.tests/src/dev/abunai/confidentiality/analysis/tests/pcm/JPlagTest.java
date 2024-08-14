package dev.abunai.confidentiality.analysis.tests.pcm;

import dev.abunai.confidentiality.analysis.core.UncertainConstraintViolation;
import dev.abunai.confidentiality.analysis.pcm.PCMUncertainFlowGraphCollection;
import org.junit.jupiter.api.Test;

import dev.abunai.confidentiality.analysis.tests.PCMTestBase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JPlagTest extends PCMTestBase {

	@Override
	protected String getFolderName() {
		return "CaseStudy-JPlag";
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
	void testJPlag() {
		PCMUncertainFlowGraphCollection flowGraphs = (PCMUncertainFlowGraphCollection) analysis.findFlowGraph();
		PCMUncertainFlowGraphCollection uncertainFlowGraphs = flowGraphs.createUncertainFlows();
		assertTrue(flowGraphs.getTransposeFlowGraphs().size() < uncertainFlowGraphs.getTransposeFlowGraphs().size());
		
		uncertainFlowGraphs.evaluate();

		List<UncertainConstraintViolation> illegalEvaluation = analysis.queryUncertainDataFlow(uncertainFlowGraphs, it -> {
			return it.getDataCharacteristicNamesMap("Status").values().stream().anyMatch(vars -> vars.stream().anyMatch(cv -> cv.equals("Evaluated")));
		});
		assertTrue(illegalEvaluation.size() > 0);
		
		List<UncertainConstraintViolation> sensitiveDataInTheCloud = analysis.queryUncertainDataFlow(uncertainFlowGraphs, it -> {
			return it.getVertexCharacteristicNames("Location").contains("Cloud") 
					&& 
					it.getDataCharacteristicNamesMap("Status").values().stream().flatMap(List::stream).anyMatch(cv -> cv.equals("Sensitive"));
		});
		assertTrue(sensitiveDataInTheCloud.size() > 0);
	}

}
