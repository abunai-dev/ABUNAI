package dev.abunai.confidentiality.analysis.pcm;

import java.util.List;

import dev.abunai.confidentiality.analysis.core.UncertainFlowGraphCollection;
import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.core.AbstractTransposeFlowGraph;
import org.dataflowanalysis.analysis.pcm.core.PCMFlowGraphCollection;
import org.dataflowanalysis.analysis.pcm.core.PCMTransposeFlowGraph;
import org.dataflowanalysis.analysis.pcm.core.finder.PCMTransposeFlowGraphFinder;
import org.dataflowanalysis.analysis.pcm.resource.PCMResourceProvider;

import dev.abunai.confidentiality.analysis.core.UncertaintySourceManager;
import dev.abunai.confidentiality.analysis.core.UncertaintySourceType;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMUncertaintySource;

public class PCMUncertainFlowGraphCollection extends PCMFlowGraphCollection implements UncertainFlowGraphCollection {
	private final Logger logger = Logger.getLogger(PCMUncertainFlowGraphCollection.class);

	public PCMUncertainFlowGraphCollection(PCMResourceProvider resourceProvider) {
		super(resourceProvider);
		if (!(this.resourceProvider instanceof PCMResourceProvider pcmResourceProvder)) {
            logger.error("Cannot find partial flow graphs for non-pcm resource provider");
            throw new IllegalArgumentException();
		}
	}
	
	public PCMUncertainFlowGraphCollection(List<PCMUncertainTransposeFlowGraph> partialFlowGraphs, PCMResourceProvider resourceProvider) {
		super(partialFlowGraphs, resourceProvider);
		if (!(this.resourceProvider instanceof PCMResourceProvider pcmResourceProvider)) {
            logger.error("Cannot find partial flow graphs for non-pcm resource provider");
            throw new IllegalArgumentException();
		}
	}

	
	public PCMUncertainFlowGraphCollection createUncertainFlows() {
		List<PCMUncertainTransposeFlowGraph> uncertainPartialFlows = this.getTransposeFlowGraphs().stream()
				.map(PCMUncertainTransposeFlowGraph.class::cast)
				.flatMap(it -> it.determineAlternativePartialFlowGraphs((PCMUncertaintyResourceProvider) this.resourceProvider).stream())
				.toList();
		return new PCMUncertainFlowGraphCollection(uncertainPartialFlows, (PCMUncertaintyResourceProvider) resourceProvider);
	}

	@Override
	public List<? extends AbstractTransposeFlowGraph> findTransposeFlowGraphs() {
		if (!(this.resourceProvider instanceof PCMUncertaintyResourceProvider pcmResourceProvider)) {
            logger.error("Cannot find partial flow graphs for non-dfd resource provider");
            throw new IllegalArgumentException();
		}
		UncertaintySourceManager uncertaintySourceManager = new UncertaintySourceManager(pcmResourceProvider.getUncertaintySourceCollection(), UncertaintySourceType.PCM);
		
		return new PCMTransposeFlowGraphFinder(pcmResourceProvider).findTransposeFlowGraphs().stream()
				.map(PCMTransposeFlowGraph.class::cast)
				.map(it -> new PCMUncertainTransposeFlowGraph(it.getSink(), this.determineRelevantUncertaintySource(it, uncertaintySourceManager, pcmResourceProvider)))
				.toList();
	}

	public List<? extends PCMUncertaintySource> determineRelevantUncertaintySource(PCMTransposeFlowGraph partialFlowGraph, UncertaintySourceManager uncertaintySourceManager, PCMResourceProvider resourceProvider) {
		PCMQueryHelper pcmQueryHelper = new PCMQueryHelper(partialFlowGraph.getVertices(), resourceProvider);
		
		return uncertaintySourceManager.getUncertaintySources().stream()
				.map(PCMUncertaintySource.class::cast)
				.filter(pcmQueryHelper::hasTargetNode)
				.toList();
	}
}
