package dev.abunai.confidentiality.analysis.tests.dfd;

import dev.abunai.confidentiality.analysis.core.UncertainConstraintViolation;
import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.core.UncertainTransposeFlowGraph;
import dev.abunai.confidentiality.analysis.dfd.DFDUncertainFlowGraphCollection;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;
import dev.abunai.confidentiality.analysis.tests.DFDTestBase;
import org.dataflowanalysis.analysis.core.AbstractTransposeFlowGraph;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

class OnlineShopTest extends DFDTestBase {
    @Override
    protected String getFolderName() {
        return "UncertainOnlineShopDFD";
    }

    @Override
    protected String getFilesName() {
        return "onlineshop";
    }

    @Override
    protected String getBaseFolder() {
        return "models";
    }

    @Test
    void testAnalysis() {
        DFDUncertainFlowGraphCollection flowGraphs = (DFDUncertainFlowGraphCollection) analysis.findFlowGraph();
        DFDUncertainFlowGraphCollection uncertainFlowGraphs = flowGraphs.createUncertainFlows();
        uncertainFlowGraphs.evaluate();

        List<UncertainConstraintViolation> violations = analysis.queryUncertainDataFlow(uncertainFlowGraphs, it -> {
            return this.retrieveNodeLabels(it).contains("nonEU") && this.retrieveDataLabels(it).contains("Personal");
        });
        // Smoke test
        assertFalse(violations.isEmpty());
    }

    @Test
    void testUncertaintyResolving() {
        DFDUncertainFlowGraphCollection flowGraphs = (DFDUncertainFlowGraphCollection) analysis.findFlowGraph();
        DFDUncertainFlowGraphCollection uncertainFlowGraphs = flowGraphs.createUncertainFlows();

        List<UncertaintySource> sourceCollection = analysis.getUncertaintySources();
        List<UncertainState> allStates = UncertainState.createAllUncertainStates(sourceCollection);

        for(AbstractTransposeFlowGraph transposeFlowGraph : uncertainFlowGraphs.getTransposeFlowGraphs()) {
            UncertainTransposeFlowGraph uncertainTransposeFlowGraph = (UncertainTransposeFlowGraph) transposeFlowGraph;

            assertTrue(allStates.size() >= uncertainTransposeFlowGraph.getRelevantUncertaintySources().size());
            assertTrue(uncertainTransposeFlowGraph.getRelevantUncertaintySources().size() >= uncertainTransposeFlowGraph.getUncertainState().getUncertaintySources().size());
        }
    }
}
