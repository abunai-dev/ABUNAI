package dev.abunai.confidentiality.analysis.dfd;

import java.util.List;

import dev.abunai.confidentiality.analysis.core.UncertainFlowGraphCollection;
import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.core.AbstractTransposeFlowGraph;
import org.dataflowanalysis.analysis.dfd.core.DFDFlowGraphCollection;
import org.dataflowanalysis.analysis.dfd.core.DFDTransposeFlowGraph;
import org.dataflowanalysis.analysis.dfd.core.DFDTransposeFlowGraphFinder;
import org.dataflowanalysis.analysis.dfd.resource.DFDResourceProvider;

import dev.abunai.confidentiality.analysis.core.UncertaintySourceManager;
import dev.abunai.confidentiality.analysis.core.UncertaintySourceType;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDUncertaintySource;

/**
 * This class contains a collection of uncertain transpose flow graphs of a dfd model
 */
public class DFDUncertainFlowGraphCollection extends DFDFlowGraphCollection implements UncertainFlowGraphCollection {
	private final Logger logger = Logger.getLogger(DFDUncertainFlowGraphCollection.class);

	public DFDUncertainFlowGraphCollection(DFDResourceProvider resourceProvider) {
		super(resourceProvider);
		if (!(this.resourceProvider instanceof DFDUncertaintyResourceProvider dfdResourceProvider)) {
            logger.error("Cannot find partial flow graphs for non-dfd resource provider");
            throw new IllegalArgumentException();
		}
	}
	
	public DFDUncertainFlowGraphCollection(List<? extends AbstractTransposeFlowGraph> transposeFlowGraphs, DFDResourceProvider resourceProvider) {
		super(resourceProvider, transposeFlowGraphs);
		if (!(this.resourceProvider instanceof DFDUncertaintyResourceProvider dfdResourceProvider)) {
            logger.error("Cannot find partial flow graphs for non-dfd resource provider");
            throw new IllegalArgumentException();
		}
	}

	
	public DFDUncertainFlowGraphCollection createUncertainFlows() {
		List<DFDUncertainTransposeFlowGraph> uncertainPartialFlows = this.getTransposeFlowGraphs().stream()
				.map(DFDUncertainTransposeFlowGraph.class::cast)
				.flatMap(it -> it.determineAlternativeTransposeFlowGraphs((DFDUncertaintyResourceProvider) this.resourceProvider).stream())
				.toList();
		return new DFDUncertainFlowGraphCollection(uncertainPartialFlows, (DFDUncertaintyResourceProvider) resourceProvider);
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
