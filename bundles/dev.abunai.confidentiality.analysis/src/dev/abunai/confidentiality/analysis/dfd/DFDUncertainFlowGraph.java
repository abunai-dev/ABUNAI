package dev.abunai.confidentiality.analysis.dfd;

import java.util.List;

import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.core.AbstractPartialFlowGraph;
import org.dataflowanalysis.analysis.dfd.core.DFDFlowGraph;
import org.dataflowanalysis.analysis.dfd.core.DFDPartialFlowGraph;
import org.dataflowanalysis.analysis.dfd.core.DFDPartialFlowGraphFinder;
import org.dataflowanalysis.analysis.dfd.resource.DFDResourceProvider;

import dev.abunai.confidentiality.analysis.core.UncertaintySourceManager;
import dev.abunai.confidentiality.analysis.core.UncertaintySourceType;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDUncertaintySource;

public class DFDUncertainFlowGraph extends DFDFlowGraph {
	private final Logger logger = Logger.getLogger(DFDUncertainFlowGraph.class);
	private final UncertaintySourceManager uncertaintySourceManager;

	public DFDUncertainFlowGraph(DFDResourceProvider resourceProvider) {
		super(resourceProvider);
		if (!(this.resourceProvider instanceof DFDUncertaintyResourceProvider dfdResourceProvider)) {
            logger.error("Cannot find partial flow graphs for non-dfd resource provider");
            throw new IllegalArgumentException();
		}
		this.uncertaintySourceManager = new UncertaintySourceManager(dfdResourceProvider.getUncertaintySourceCollection(), UncertaintySourceType.DFD);
	}
	
	public DFDUncertainFlowGraph(List<DFDUncertainPartialFlowGraph> partialFlowGraphs, DFDResourceProvider resourceProvider) {
		super(resourceProvider, partialFlowGraphs);
		if (!(this.resourceProvider instanceof DFDUncertaintyResourceProvider dfdResourceProvider)) {
            logger.error("Cannot find partial flow graphs for non-dfd resource provider");
            throw new IllegalArgumentException();
		}
		this.uncertaintySourceManager = new UncertaintySourceManager(dfdResourceProvider.getUncertaintySourceCollection(), UncertaintySourceType.DFD);
	}

	
	public DFDUncertainFlowGraph createUncertainFlows() {
		List<DFDUncertainPartialFlowGraph> uncertainPartialFlows = this.getPartialFlowGraphs().stream()
				.map(DFDUncertainPartialFlowGraph.class::cast)
				.flatMap(it -> it.determineAlternativePartialFlowGraphs().stream())
				.toList();
		return new DFDUncertainFlowGraph(uncertainPartialFlows, (DFDUncertaintyResourceProvider) resourceProvider);
	}

	@Override
	public List<? extends AbstractPartialFlowGraph> findPartialFlowGraphs() {
		if (!(this.resourceProvider instanceof DFDUncertaintyResourceProvider dfdResourceProvider)) {
            logger.error("Cannot find partial flow graphs for non-dfd resource provider");
            throw new IllegalArgumentException();
		}
		return new DFDPartialFlowGraphFinder(dfdResourceProvider).findPartialFlowGraphs().stream()
				.map(DFDPartialFlowGraph.class::cast)
				.map(it -> new DFDUncertainPartialFlowGraph(it.getSink(), this.determineRelevantUncertaintySource(it, dfdResourceProvider)))
				.toList();
	}

	public List<? extends DFDUncertaintySource> determineRelevantUncertaintySource(DFDPartialFlowGraph partialFlowGraph, DFDUncertaintyResourceProvider dfdResourceProvider) {
		DFDQueryHelper dfdQueryHelper = new DFDQueryHelper(partialFlowGraph.getVertices());
		
		return new UncertaintySourceManager(dfdResourceProvider.getUncertaintySourceCollection(), UncertaintySourceType.DFD).getUncertaintySources().stream()
				.map(DFDUncertaintySource.class::cast)
				.filter(dfdQueryHelper::hasTargetNode)
				.toList();
	}
}
