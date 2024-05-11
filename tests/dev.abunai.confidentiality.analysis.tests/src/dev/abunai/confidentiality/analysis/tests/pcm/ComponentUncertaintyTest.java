package dev.abunai.confidentiality.analysis.tests.pcm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.List;

import org.dataflowanalysis.analysis.core.CharacteristicValue;
import org.dataflowanalysis.analysis.pcm.core.seff.SEFFPCMVertex;
import org.junit.jupiter.api.Test;

import dev.abunai.confidentiality.analysis.core.UncertainConstraintViolation;
import dev.abunai.confidentiality.analysis.pcm.PCMUncertainFlowGraphCollection;
import dev.abunai.confidentiality.analysis.pcm.PCMUncertainTransposeFlowGraph;
import dev.abunai.confidentiality.analysis.tests.PCMTestBase;

public class ComponentUncertaintyTest extends PCMTestBase {
	@Override
    protected String getFolderName() {
        return "PCMComponentUncertainty";
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

        List<UncertainConstraintViolation> result = analysis.queryUncertainDataFlow(uncertainFlowGraphs, node -> {
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

            return dataSensitivity.stream()
                    .anyMatch(l -> l.equals("Personal"))
                    && serverLocation.stream()
                            .anyMatch(l -> l.equals("nonEU"));
        });

        assertEquals(4, uncertainFlowGraphs.getTransposeFlowGraphs().size());
        assertEquals(2, result.size());
        PCMUncertainTransposeFlowGraph resultOne = (PCMUncertainTransposeFlowGraph) result.get(0).transposeFlowGraph();
        PCMUncertainTransposeFlowGraph resultTwo = (PCMUncertainTransposeFlowGraph) result.get(1).transposeFlowGraph();
        assertTrue(resultOne.getVertices().get(6) instanceof SEFFPCMVertex<?>);
        assertTrue(resultTwo.getVertices().get(6) instanceof SEFFPCMVertex<?>);
        assertEquals("Leaky return inventory", ((SEFFPCMVertex<?>) resultOne.getVertices().get(6)).getReferencedElement().getEntityName());
        assertEquals("Leaky return inventory", ((SEFFPCMVertex<?>) resultTwo.getVertices().get(6)).getReferencedElement().getEntityName());
    }
}
