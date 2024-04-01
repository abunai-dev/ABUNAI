package dev.abunai.confidentiality.analysis.pcm;

import java.util.List;

import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.core.AbstractPartialFlowGraph;
import org.dataflowanalysis.analysis.pcm.core.PCMFlowGraph;
import org.dataflowanalysis.analysis.pcm.core.PCMPartialFlowGraph;
import org.dataflowanalysis.analysis.pcm.core.finder.PCMPartialFlowGraphFinder;
import org.dataflowanalysis.analysis.pcm.resource.PCMResourceProvider;

import dev.abunai.confidentiality.analysis.core.UncertaintySourceManager;
import dev.abunai.confidentiality.analysis.core.UncertaintySourceType;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMUncertaintySource;

public class PCMUncertainFlowGraph extends PCMFlowGraph {
	private final Logger logger = Logger.getLogger(PCMUncertainFlowGraph.class);

	public PCMUncertainFlowGraph(PCMResourceProvider resourceProvider) {
		super(resourceProvider);
		if (!(this.resourceProvider instanceof PCMResourceProvider pcmResourceProvder)) {
            logger.error("Cannot find partial flow graphs for non-pcm resource provider");
            throw new IllegalArgumentException();
		}
	}
	
	public PCMUncertainFlowGraph(List<PCMUncertainPartialFlowGraph> partialFlowGraphs, PCMResourceProvider resourceProvider) {
		super(partialFlowGraphs, resourceProvider);
		if (!(this.resourceProvider instanceof PCMResourceProvider pcmResourceProvider)) {
            logger.error("Cannot find partial flow graphs for non-pcm resource provider");
            throw new IllegalArgumentException();
		}
	}

	
	public PCMUncertainFlowGraph createUncertainFlows() {
		List<PCMUncertainPartialFlowGraph> uncertainPartialFlows = this.getPartialFlowGraphs().stream()
				.map(PCMUncertainPartialFlowGraph.class::cast)
				.flatMap(it -> it.determineAlternativePartialFlowGraphs().stream())
				.toList();
		return new PCMUncertainFlowGraph(uncertainPartialFlows, (PCMUncertaintyResourceProvider) resourceProvider);
	}

	@Override
	public List<? extends AbstractPartialFlowGraph> findPartialFlowGraphs() {
		if (!(this.resourceProvider instanceof PCMUncertaintyResourceProvider pcmResourceProvider)) {
            logger.error("Cannot find partial flow graphs for non-dfd resource provider");
            throw new IllegalArgumentException();
		}
		UncertaintySourceManager uncertaintySourceManager = new UncertaintySourceManager(pcmResourceProvider.getUncertaintySourceCollection(), UncertaintySourceType.PCM);
		
		return new PCMPartialFlowGraphFinder(pcmResourceProvider).findPartialFlowGraphs().stream()
				.map(PCMPartialFlowGraph.class::cast)
				.map(it -> new PCMUncertainPartialFlowGraph(it.getSink(), this.determineRelevantUncertaintySource(it, uncertaintySourceManager, pcmResourceProvider)))
				.toList();
	}

	public List<? extends PCMUncertaintySource> determineRelevantUncertaintySource(PCMPartialFlowGraph partialFlowGraph, UncertaintySourceManager uncertaintySourceManager, PCMResourceProvider resourceProvider) {
		PCMQueryHelper pcmQueryHelper = new PCMQueryHelper(partialFlowGraph.getVertices(), resourceProvider);
		
		return uncertaintySourceManager.getUncertaintySources().stream()
				.map(PCMUncertaintySource.class::cast)
				.filter(pcmQueryHelper::hasTargetNode)
				.toList();
	}
}
