package dev.abunai.confidentiality.analysis.tests.pcm;

import static org.junit.jupiter.api.Assertions.assertEquals;


import dev.abunai.confidentiality.analysis.core.UncertainConstraintViolation;
import dev.abunai.confidentiality.analysis.pcm.PCMUncertainFlowGraphCollection;
import dev.abunai.confidentiality.analysis.pcm.PCMUncertainTransposeFlowGraph;
import dev.abunai.confidentiality.analysis.tests.PCMTestBase;
import org.dataflowanalysis.analysis.core.CharacteristicValue;
import org.dataflowanalysis.analysis.pcm.core.seff.SEFFPCMVertex;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

/**
 * The atomic connector uncertainty test replaces the {@code StoreUserDataCall} in {@code OnlineShop.buy()} with {@code EncryptedStoreUserDataCall}.
 * The violation occurs in the default scenario of the uncertainty starting at the StoreUserDataCall
 */
public class ConnectorUncertaintyTest extends PCMTestBase {
    @Override
    protected String getFolderName() {
        return "PCMConnectorUncertainty";
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
            List<String> encryption = node.getDataCharacteristicMap("Encryption")
                    .values()
                    .stream()
                    .flatMap(Collection::stream)
                    .map(CharacteristicValue::getValueName)
                    .toList();

            return dataSensitivity.stream()
                    .anyMatch(l -> l.equals("Personal"))
                    && serverLocation.stream()
                    .anyMatch(l -> l.equals("nonEU"))
                    && encryption.stream().noneMatch(l -> l.equals("Encrypted"));
        });

        assertEquals(1, result.size());
        assertEquals(3, result.get(0).violations().size());
        assertEquals("StoreUserDataCall", ((SEFFPCMVertex<?>)((PCMUncertainTransposeFlowGraph) result.get(0).transposeFlowGraph()).getVertices().get(14)).getReferencedElement().getEntityName());
    }
}
