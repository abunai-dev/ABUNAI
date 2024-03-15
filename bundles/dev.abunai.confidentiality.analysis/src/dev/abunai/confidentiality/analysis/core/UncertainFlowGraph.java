package dev.abunai.confidentiality.analysis.core;

import java.util.List;

import org.dataflowanalysis.analysis.core.FlowGraph;
import org.dataflowanalysis.analysis.resource.ResourceProvider;

public abstract class UncertainFlowGraph extends FlowGraph {

	public UncertainFlowGraph(ResourceProvider resourceProvider) {
		super(resourceProvider);
	}
	
	public UncertainFlowGraph(List<? extends UncertainPartialFlowGraph> partialFlowGraphs, ResourceProvider resourceProvider) {
		super(partialFlowGraphs, resourceProvider);
	}
	
	public abstract UncertainFlowGraph createUncertainFlows();

	// public List<AbstractPartialFlowGraph> findPartialFlowGraphs()

}
