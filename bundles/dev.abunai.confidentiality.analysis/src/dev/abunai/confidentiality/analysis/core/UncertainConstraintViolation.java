package dev.abunai.confidentiality.analysis.core;

import java.util.List;

import org.dataflowanalysis.analysis.core.AbstractVertex;

/**
 * This class models a constraint violation of an uncertain transpose flow graph with a given uncertain state.
 * It also contains a list of vertices which violated the constraint
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
