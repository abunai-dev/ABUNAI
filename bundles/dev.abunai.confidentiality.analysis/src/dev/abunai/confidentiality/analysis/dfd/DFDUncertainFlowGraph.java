package dev.abunai.confidentiality.analysis.dfd;

import java.util.List;

import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.core.AbstractPartialFlowGraph;
import org.dataflowanalysis.analysis.dfd.core.DFDPartialFlowGraph;
import org.dataflowanalysis.analysis.dfd.core.DFDPartialFlowGraphFinder;
import org.dataflowanalysis.analysis.resource.ResourceProvider;

import dev.abunai.confidentiality.analysis.core.UncertainFlowGraph;
import dev.abunai.confidentiality.analysis.core.UncertaintySourceManager;
import dev.abunai.confidentiality.analysis.core.UncertaintySourceType;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDUncertaintySource;

public class DFDUncertainFlowGraph extends UncertainFlowGraph {
	private final Logger logger = Logger.getLogger(DFDUncertainFlowGraph.class);
	private final UncertaintySourceManager uncertaintySourceManager;

	public DFDUncertainFlowGraph(ResourceProvider resourceProvider) {
		super(resourceProvider);
		if (!(this.resourceProvider instanceof DFDUncertaintyResourceProvider dfdResourceProvider)) {
            logger.error("Cannot find partial flow graphs for non-dfd resource provider");
            throw new IllegalArgumentException();
		}
		uncertaintySourceManager = new UncertaintySourceManager(dfdResourceProvider.getUncertaintySourceCollection(), UncertaintySourceType.DFD);
	}
	
	public DFDUncertainFlowGraph(List<DFDUncertainPartialFlowGraph> partialFlowGraphs, ResourceProvider resourceProvider) {
		super(partialFlowGraphs, resourceProvider);
		if (!(this.resourceProvider instanceof DFDUncertaintyResourceProvider dfdResourceProvider)) {
            logger.error("Cannot find partial flow graphs for non-dfd resource provider");
            throw new IllegalArgumentException();
		}
		uncertaintySourceManager = new UncertaintySourceManager(dfdResourceProvider.getUncertaintySourceCollection(), UncertaintySourceType.DFD);
	}

	@Override
	public UncertainFlowGraph createUncertainFlows() {
		List<DFDUncertainPartialFlowGraph> uncertainPartialFlows = this.getPartialFlowGraphs().stream()
				.map(DFDUncertainPartialFlowGraph.class::cast)
				.flatMap(it -> it.determineAlternativePartialFlowGraphs().stream())
				.toList();
		return new DFDUncertainFlowGraph(uncertainPartialFlows, resourceProvider);
	}

	@Override
	public List<? extends AbstractPartialFlowGraph> findPartialFlowGraphs() {
		if (!(this.resourceProvider instanceof DFDUncertaintyResourceProvider dfdResourceProvider)) {
            logger.error("Cannot find partial flow graphs for non-dfd resource provider");
            throw new IllegalArgumentException();
		}
		
		return new DFDPartialFlowGraphFinder(dfdResourceProvider).findPartialFlowGraphs().stream()
				.map(DFDPartialFlowGraph.class::cast)
				.map(it -> new DFDUncertainPartialFlowGraph(it.getSink(), this.determineRelevantUncertaintySource(it)))
				.toList();
	}

	public List<? extends DFDUncertaintySource> determineRelevantUncertaintySource(DFDPartialFlowGraph partialFlowGraph) {
		DFDQueryHelper dfdQueryHelper = new DFDQueryHelper(partialFlowGraph.getVertices());
		
		return this.uncertaintySourceManager.getUncertaintySources().stream()
				.map(DFDUncertaintySource.class::cast)
				.filter(dfdQueryHelper::hasTargetNode)
				.toList();
	}
}
