package dev.abunai.confidentiality.analysis.core;

import java.util.List;

import org.dataflowanalysis.analysis.core.FlowGraph;
import org.dataflowanalysis.analysis.resource.ResourceProvider;

public interface UncertainFlowGraph {
	UncertainFlowGraph createUncertainFlows();
}
