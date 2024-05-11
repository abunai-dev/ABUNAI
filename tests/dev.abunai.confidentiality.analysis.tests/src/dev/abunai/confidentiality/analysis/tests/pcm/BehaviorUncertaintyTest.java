package dev.abunai.confidentiality.analysis.tests.pcm;

import dev.abunai.confidentiality.analysis.core.UncertainConstraintViolation;
import dev.abunai.confidentiality.analysis.pcm.PCMUncertainFlowGraphCollection;
import dev.abunai.confidentiality.analysis.pcm.PCMUncertainTransposeFlowGraph;
import dev.abunai.confidentiality.analysis.tests.PCMTestBase;

import org.dataflowanalysis.analysis.core.CharacteristicValue;
import org.dataflowanalysis.analysis.pcm.core.seff.SEFFPCMVertex;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BehaviorUncertaintyTest extends PCMTestBase {
    @Override
    protected String getFolderName() {
        return "PCMBehaviorUncertainty";
    }

    @Override
    protected String getFilesName() {
        return "default";
    }

    @Test
    public void testResults() {
    	PCMUncertainFlowGraphCollection flowGraphs = (PCMUncertainFlowGraphCollection) analysis.findFlowGraph();
        PCMUncertainFlowGraphCollection uncertainFlowGraphs = flowGraphs.createUncertainFlows();
        uncertainFlowGraphs.evaluate();

        List<UncertainConstraintViolation> result = analysis.queryUncertainDataFlow(uncertainFlowGraphs, it -> {
        	if(it.getAllDataCharacteristics().stream().noneMatch(node -> node.getVariableName().equals("inventory"))) {
        		return false;
        	}
        	List<String> dataSensitivity = it.getDataCharacteristicMap("DataSensitivity")
        			.getOrDefault("inventory", List.of())
                    .stream()
                    .map(CharacteristicValue::getValueName)
                    .toList();
           return dataSensitivity.contains("Personal");
        });

        assertEquals(4, uncertainFlowGraphs.getTransposeFlowGraphs().size());
        assertEquals(2, result.size());
        PCMUncertainTransposeFlowGraph resultOne = (PCMUncertainTransposeFlowGraph) result.get(0).transposeFlowGraph();
        PCMUncertainTransposeFlowGraph resultTwo = (PCMUncertainTransposeFlowGraph) result.get(1).transposeFlowGraph();
        assertTrue(resultOne.getVertices().get(5) instanceof SEFFPCMVertex<?>);
        assertTrue(resultTwo.getVertices().get(5) instanceof SEFFPCMVertex<?>);
        assertEquals("Leaky return inventory", ((SEFFPCMVertex<?>) resultOne.getVertices().get(5)).getReferencedElement().getEntityName());
        assertEquals("Leaky return inventory", ((SEFFPCMVertex<?>) resultTwo.getVertices().get(5)).getReferencedElement().getEntityName());
    }
}
