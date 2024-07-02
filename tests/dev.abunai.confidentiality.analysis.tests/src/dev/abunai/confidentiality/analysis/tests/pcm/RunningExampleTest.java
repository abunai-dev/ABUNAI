package dev.abunai.confidentiality.analysis.tests.pcm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.List;

import org.dataflowanalysis.analysis.core.CharacteristicValue;
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

        List<UncertainConstraintViolation> invalidData = analysis.queryUncertainDataFlow(uncertainFlowGraphs, node -> {
            List<String> dataType = node.getDataCharacteristicMap("DataType")
                    .values()
                    .stream()
                    .flatMap(Collection::stream)
                    .map(CharacteristicValue::getValueName)
                    .toList();
            List<String> dataValidation = node.getDataCharacteristicMap("DataValidation")
                    .values()
                    .stream()
                    .flatMap(Collection::stream)
                    .map(CharacteristicValue::getValueName)
                    .toList();

            return (dataType.stream()
                    .anyMatch(l -> l.equals("Invalid"))
                    && dataValidation.stream()
                    .noneMatch(l -> l.equals("Validated"))) || dataType.stream().anyMatch(it -> it.equals("Invalid"));
        });
        List<UncertainConstraintViolation> invalidStoring = analysis.queryUncertainDataFlow(uncertainFlowGraphs, node -> {
        	List<String> serverLocation = node.getVertexCharacteristics("ServerLocation")
                    .stream()
                    .map(CharacteristicValue::getValueName)
                    .toList();
            List<String> dataSensitivity = node.getDataCharacteristicMap("DataSensitivity")
                    .values()
                    .stream()
                    .flatMap(Collection::stream)
                    .map(CharacteristicValue::getValueName)
                    .toList();
            List<String> dataEncryption = node.getDataCharacteristicMap("DataEncryption")
                    .values()
                    .stream()
                    .flatMap(Collection::stream)
                    .map(CharacteristicValue::getValueName)
                    .toList();


            return dataSensitivity.stream()
                    .anyMatch(l -> l.equals("Personal"))
                    && serverLocation.stream()
                    .anyMatch(l -> l.equals("nonEU"))
                    && dataEncryption.stream()
                    .noneMatch(l -> l.equals("Encrypted"));
        });
        assertEquals(3, flowGraphs.getTransposeFlowGraphs().size(), "Running example contains 3 TFGs");
        assertEquals(40, uncertainFlowGraphs.getTransposeFlowGraphs().size(), "Running example contains 40 Uncertain TFGs");
        assertEquals(3*(3*4*2*2), uncertainFlowGraphs.getScenarioAwareComplexity(), "Scenario Aware Complexity is 144");
        assertEquals(1+4+48, uncertainFlowGraphs.getDataFlowAwareComplexity(), "Scenario Aware Complexity is 53");
        assertEquals((1)+(1+2)+(12+24), uncertainFlowGraphs.getImpactAwareComplexity(), "Impact Aware Complexity is 40");
        
        assertTrue(!invalidData.isEmpty());
        assertTrue(!invalidStoring.isEmpty());
	}
}
