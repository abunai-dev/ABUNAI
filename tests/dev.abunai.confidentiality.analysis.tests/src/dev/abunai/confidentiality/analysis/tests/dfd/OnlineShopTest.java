package dev.abunai.confidentiality.analysis.tests.dfd;

import dev.abunai.confidentiality.analysis.core.UncertainConstraintViolation;
import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.core.UncertainTransposeFlowGraph;
import dev.abunai.confidentiality.analysis.dfd.DFDUncertainFlowGraphCollection;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;
import dev.abunai.confidentiality.analysis.tests.DFDTestBase;
import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.core.AbstractTransposeFlowGraph;
import org.dataflowanalysis.analysis.dfd.core.DFDVertex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

class OnlineShopTest extends DFDTestBase {
    private final Logger logger = Logger.getLogger(SimpleOnlineShopTest.class);

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
        assertEquals(1, violations.size(), "Online shop model should contain one transpose flow graph with violations");
        assertEquals(1, violations.get(0).violations().size(), "Transpose flow graph with violation should contain one vertex with violations");
        assertEquals("Default Scenario", violations.get(0).uncertainState().getSelectedUncertaintyScenarios().get(0).getEntityName(), "Violation should occur in default scenario");
        assertEquals("Database", ((DFDVertex) violations.get(0).violations().get(0)).getReferencedElement().getEntityName(), "Violation should occur in Database");
    }

    @Test
    void testUncertaintyResolving() {
        DFDUncertainFlowGraphCollection flowGraphs = (DFDUncertainFlowGraphCollection) analysis.findFlowGraph();
        DFDUncertainFlowGraphCollection uncertainFlowGraphs = flowGraphs.createUncertainFlows();

        List<UncertaintySource> sourceCollection = analysis.getUncertaintySources();
        List<UncertainState> allStates = UncertainState.createAllUncertainStates(sourceCollection);

        for(AbstractTransposeFlowGraph transposeFlowGraph : uncertainFlowGraphs.getTransposeFlowGraphs()) {
            UncertainTransposeFlowGraph uncertainTransposeFlowGraph = (UncertainTransposeFlowGraph) transposeFlowGraph;

            assertTrue(allStates.size() > uncertainTransposeFlowGraph.getRelevantUncertaintySources().size());
            assertTrue(uncertainTransposeFlowGraph.getRelevantUncertaintySources().size() > uncertainTransposeFlowGraph.getUncertainState().getUncertaintySources().size());
        }
    }
}
