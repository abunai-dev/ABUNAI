package dev.abunai.confidentiality.analysis.dfd;

import java.util.List;

import dev.abunai.confidentiality.analysis.core.UncertainFlowGraph;
import dev.abunai.confidentiality.analysis.core.UncertainTransposeFlowGraph;
import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.core.AbstractTransposeFlowGraph;
import org.dataflowanalysis.analysis.dfd.core.DFDFlowGraph;
import org.dataflowanalysis.analysis.dfd.core.DFDTransposeFlowGraph;
import org.dataflowanalysis.analysis.dfd.core.DFDTransposeFlowGraphFinder;
import org.dataflowanalysis.analysis.dfd.resource.DFDResourceProvider;

import dev.abunai.confidentiality.analysis.core.UncertaintySourceManager;
import dev.abunai.confidentiality.analysis.core.UncertaintySourceType;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDUncertaintySource;

public class DFDUncertainFlowGraph extends DFDFlowGraph implements UncertainFlowGraph {
	private final Logger logger = Logger.getLogger(DFDUncertainFlowGraph.class);

	public DFDUncertainFlowGraph(DFDResourceProvider resourceProvider) {
		super(resourceProvider);
		if (!(this.resourceProvider instanceof DFDUncertaintyResourceProvider dfdResourceProvider)) {
            logger.error("Cannot find partial flow graphs for non-dfd resource provider");
            throw new IllegalArgumentException();
		}
	}
	
	public DFDUncertainFlowGraph(List<? extends AbstractTransposeFlowGraph> partialFlowGraphs, DFDResourceProvider resourceProvider) {
		super(resourceProvider, partialFlowGraphs);
		if (!(this.resourceProvider instanceof DFDUncertaintyResourceProvider dfdResourceProvider)) {
            logger.error("Cannot find partial flow graphs for non-dfd resource provider");
            throw new IllegalArgumentException();
		}
	}

	
	public DFDUncertainFlowGraph createUncertainFlows() {
		List<DFDUncertainTransposeFlowGraph> uncertainPartialFlows = this.getTransposeFlowGraphs().stream()
				.map(DFDUncertainTransposeFlowGraph.class::cast)
				.flatMap(it -> it.determineAlternativePartialFlowGraphs(this.getTransposeFlowGraphs()).stream())
				.toList();
		return new DFDUncertainFlowGraph(uncertainPartialFlows, (DFDUncertaintyResourceProvider) resourceProvider);
	}

	@Override
	public List<? extends AbstractTransposeFlowGraph> findTransposeFlowGraphs() {
		if (!(this.resourceProvider instanceof DFDUncertaintyResourceProvider dfdResourceProvider)) {
            logger.error("Cannot find partial flow graphs for non-dfd resource provider");
            throw new IllegalArgumentException();
		}
		UncertaintySourceManager uncertaintySourceManager = new UncertaintySourceManager(dfdResourceProvider.getUncertaintySourceCollection(), UncertaintySourceType.DFD);
		
		return new DFDTransposeFlowGraphFinder(dfdResourceProvider).findTransposeFlowGraphs().stream()
				.map(DFDTransposeFlowGraph.class::cast)
				.map(it -> new DFDUncertainTransposeFlowGraph(it.getSink(), this.determineRelevantUncertaintySource(it, uncertaintySourceManager)))
				.toList();
	}

	public List<? extends DFDUncertaintySource> determineRelevantUncertaintySource(DFDTransposeFlowGraph partialFlowGraph, UncertaintySourceManager uncertaintySourceManager) {
		DFDQueryHelper dfdQueryHelper = new DFDQueryHelper(partialFlowGraph.getVertices());
		
		return uncertaintySourceManager.getUncertaintySources().stream()
				.map(DFDUncertaintySource.class::cast)
				.filter(dfdQueryHelper::hasTargetNode)
				.toList();
	}
}
