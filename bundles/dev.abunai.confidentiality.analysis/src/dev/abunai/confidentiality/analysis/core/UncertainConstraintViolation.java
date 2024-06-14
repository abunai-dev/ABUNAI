package dev.abunai.confidentiality.analysis.core;

import java.util.List;
import java.util.function.Predicate;

import org.dataflowanalysis.analysis.core.AbstractTransposeFlowGraph;
import org.dataflowanalysis.analysis.core.AbstractVertex;

/**
 * This class models a constraint violation of an transpose flow graph in an uncertain state.
 * @param uncertainState Contains the uncertain state of the violating transpose flow graph
 * @param transposeFlowGraph Contains a reference to the transpose flow graph that has violations
 * @param violations    Contains the vertices of the transpose flow graph that violated the constraint.
 *                      The results contained are equal to the results produced by {@link org.dataflowanalysis.analysis.DataFlowConfidentialityAnalysis#queryDataFlow(AbstractTransposeFlowGraph, Predicate)}
 */
public record UncertainConstraintViolation(UncertainState uncertainState, UncertainTransposeFlowGraph transposeFlowGraph,
                                           List<? extends AbstractVertex<?>> violations) {

    @Override
    public String toString() {
        return String.format("""
        Violation in flow graph %s
        Uncertain state: %s
        Violating nodes: %s
        """, this.transposeFlowGraph,this.uncertainState, this.violations);
    }
}
