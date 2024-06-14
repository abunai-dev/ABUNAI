package dev.abunai.confidentiality.analysis.pcm;

import java.util.List;

import dev.abunai.confidentiality.analysis.core.UncertainFlowGraphCollection;
import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.core.UncertainTransposeFlowGraph;
import dev.abunai.confidentiality.analysis.core.UncertaintyUtils;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;
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
	private final UncertaintySourceManager uncertaintySourceManager;

	public PCMUncertainFlowGraphCollection(PCMResourceProvider resourceProvider, UncertaintySourceManager uncertaintySourceManager) {
		super();
		this.uncertaintySourceManager = uncertaintySourceManager;
		super.initialize(resourceProvider);
	}
	
	public PCMUncertainFlowGraphCollection(List<PCMUncertainTransposeFlowGraph> partialFlowGraphs, PCMResourceProvider resourceProvider, UncertaintySourceManager uncertaintySourceManager) {
		super(partialFlowGraphs, resourceProvider);
		this.uncertaintySourceManager = uncertaintySourceManager;
	}

	
	public PCMUncertainFlowGraphCollection createUncertainFlows() {
		List<PCMUncertainTransposeFlowGraph> uncertainPartialFlows = this.getTransposeFlowGraphs().stream()
				.map(PCMUncertainTransposeFlowGraph.class::cast)
				.flatMap(it -> it.determineAlternativeTransposeFlowGraphs((PCMUncertaintyResourceProvider) this.resourceProvider).stream())
				.toList();
		PCMUncertainFlowGraphCollection result = new PCMUncertainFlowGraphCollection(uncertainPartialFlows, (PCMUncertaintyResourceProvider) resourceProvider, uncertaintySourceManager);
		result.printUncertaintyMessage(this.logger);
		return result;
	}

	@Override
	public List<? extends AbstractTransposeFlowGraph> findTransposeFlowGraphs() {
		if (!(this.resourceProvider instanceof PCMUncertaintyResourceProvider pcmResourceProvider)) {
            logger.error("Cannot find partial flow graphs for non-dfd resource provider");
            throw new IllegalArgumentException();
		}
		return new PCMTransposeFlowGraphFinder(pcmResourceProvider).findTransposeFlowGraphs().stream()
				.map(PCMTransposeFlowGraph.class::cast)
				.map(it -> new PCMUncertainTransposeFlowGraph(it.getSink(), this.determineRelevantUncertaintySource(it, uncertaintySourceManager, pcmResourceProvider), uncertaintySourceManager))
				.toList();
	}

	public List<? extends PCMUncertaintySource> determineRelevantUncertaintySource(PCMTransposeFlowGraph partialFlowGraph, UncertaintySourceManager uncertaintySourceManager, PCMResourceProvider resourceProvider) {
		PCMQueryHelper pcmQueryHelper = new PCMQueryHelper(partialFlowGraph.getVertices(), resourceProvider);
		
		return uncertaintySourceManager.getUncertaintySources().stream()
				.map(PCMUncertaintySource.class::cast)
				.filter(pcmQueryHelper::hasTargetNode)
				.toList();
	}

	@Override
	public int getUncertaintyAmountGlobal() {
		if (!(resourceProvider instanceof PCMUncertaintyResourceProvider pcmUncertaintyResourceProvider)) {
			logger.error("Resource provider is not an pcm uncertainty resource provider");
			throw new IllegalStateException();
		}
		List<UncertainState> allStates = UncertainState.createAllUncertainStates(pcmUncertaintyResourceProvider.getUncertaintySourceCollection().getSources());
		return this.getTransposeFlowGraphs().size() * allStates.size();
	}

	@Override
	public int getUncertaintyAmountTFG() {
		int result = 0;
		for(AbstractTransposeFlowGraph transposeFlowGraph : this.getTransposeFlowGraphs()) {
			UncertainTransposeFlowGraph uncertainTransposeFlowGraph = (UncertainTransposeFlowGraph) transposeFlowGraph;
			List<? extends UncertaintyScenario> uncertaintyScenarios = uncertainTransposeFlowGraph.getRelevantUncertaintySources().stream()
					.map(UncertaintyUtils::getUncertaintyScenarios)
					.flatMap(List::stream)
					.toList();
			result += uncertaintyScenarios.size();
		}
		return result;
	}

	@Override
	public int getUncertaintyAmountUncertainTFG() {
		int result = 0;
		for(AbstractTransposeFlowGraph transposeFlowGraph : this.getTransposeFlowGraphs()) {
			UncertainTransposeFlowGraph uncertainTransposeFlowGraph = (UncertainTransposeFlowGraph) transposeFlowGraph;
			result += uncertainTransposeFlowGraph.getSelectedUncertaintyScenarios().size();
		}
		return result;
	}
}
