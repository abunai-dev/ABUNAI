package dev.abunai.confidentiality.analysis.tests.pcm;

import dev.abunai.confidentiality.analysis.core.UncertainConstraintViolation;
import dev.abunai.confidentiality.analysis.pcm.PCMUncertainFlowGraphCollection;
import dev.abunai.confidentiality.analysis.tests.PCMTestBase;
import org.dataflowanalysis.analysis.core.CharacteristicValue;
import org.dataflowanalysis.analysis.pcm.core.seff.SEFFPCMVertex;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

/**
 * The atomic interface uncertainty test replaces the interface {@code UserDatabaseInterface} with {@code SecureUserDataInterface} that is implemented within the EU.
 * The violation occurs in the default scenario of the uncertainty starting at the save data action
 */
public class InterfaceUncertaintyTest extends PCMTestBase {
    @Override
    protected String getFolderName() {
        return "PCMInterfaceUncertainty";
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

        assertEquals(3, uncertainFlowGraphs.getTransposeFlowGraphs().size());
        assertEquals(1, result.size());
        assertEquals(3, result.get(0).violations().size());
        assertInstanceOf(SEFFPCMVertex.class, result.get(0).violations().get(1));
        assertEquals("save data", ((SEFFPCMVertex<?>) result.get(0).violations().get(1)).getReferencedElement().getEntityName());
    }
}
