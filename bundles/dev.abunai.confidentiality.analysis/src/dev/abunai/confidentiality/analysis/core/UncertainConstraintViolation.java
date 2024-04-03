package dev.abunai.confidentiality.analysis.core;

import java.util.List;

import org.dataflowanalysis.analysis.core.AbstractVertex;

public class UncertainConstraintViolation {
	private final UncertainState uncertainState;
	private final UncertainPartialFlowGraph partialFlowGraph;
	private final List<? extends AbstractVertex<?>> violations;

    public UncertainConstraintViolation(UncertainState uncertainState, UncertainPartialFlowGraph partialFlowGraph, List<? extends AbstractVertex<?>> violations) {
        this.uncertainState = uncertainState;
        this.partialFlowGraph = partialFlowGraph;
        this.violations = violations;
    }

    public UncertainState getUncertainState() {
        return uncertainState;
    }

    public UncertainPartialFlowGraph getPartialFlowGraph() {
        return partialFlowGraph;
    }

    public List<? extends AbstractVertex<?>> getViolations() {
        return violations;
    }

    @Override
    public String toString() {
        return String.format("Violation in flow graph %s with uncertain state %s: %s", this.partialFlowGraph, this.uncertainState, this.violations);
    }
}
