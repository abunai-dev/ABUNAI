package dev.abunai.confidentiality.analysis.pcm;

import java.util.*;

import dev.abunai.confidentiality.analysis.core.UncertaintySourceManager;
import dev.abunai.confidentiality.analysis.core.UncertaintySourceType;
import dev.abunai.confidentiality.analysis.core.UncertaintyUtils;
import dev.abunai.confidentiality.analysis.dfd.DFDQueryHelper;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDUncertaintySource;
import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.core.AbstractVertex;
import org.dataflowanalysis.analysis.dfd.core.DFDVertex;
import org.dataflowanalysis.analysis.pcm.core.AbstractPCMVertex;
import org.dataflowanalysis.analysis.pcm.core.PCMTransposeFlowGraph;
import org.dataflowanalysis.analysis.pcm.resource.PCMResourceProvider;
import org.dataflowanalysis.analysis.resource.ResourceProvider;

import dev.abunai.confidentiality.analysis.core.UncertainTransposeFlowGraph;
import dev.abunai.confidentiality.analysis.UncertaintyResourceProvider;
import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMUncertaintySource;

public class PCMUncertainTransposeFlowGraph extends PCMTransposeFlowGraph implements UncertainTransposeFlowGraph {
	private final Logger logger = Logger.getLogger(PCMUncertainTransposeFlowGraph.class);
	private final Optional<UncertainState> uncertainState;
	private final List<? extends UncertaintySource> relevantUncertaintySources;


	public PCMUncertainTransposeFlowGraph(AbstractVertex<?> sink,
										  List<? extends UncertaintySource> relevantUncertaintySources) {
		super(sink);
		this.uncertainState = Optional.empty();
		this.relevantUncertaintySources = relevantUncertaintySources;
	}
	
	public PCMUncertainTransposeFlowGraph(AbstractVertex<?> sink,
										  List<? extends UncertaintySource> relevantUncertaintySources, UncertainState uncertainState) {
		super(sink);
		this.uncertainState = Optional.of(uncertainState);
		this.relevantUncertaintySources = relevantUncertaintySources;
	}

	@Override
	public List<? extends AbstractPCMVertex<?>> getImpactSet(ResourceProvider resourceProvider) {
		return this.getVertices().stream()
				.filter(it -> it instanceof AbstractPCMVertex<?>)
				.map(it -> (AbstractPCMVertex<?>) it)
				.filter(it -> this.affectedByUncertainty(it, (PCMResourceProvider) resourceProvider)).toList();
	}

	private boolean affectedByUncertainty(AbstractVertex<?> vertex, PCMResourceProvider resourceProvider) {
		PCMQueryHelper pcmQueryHelper = new PCMQueryHelper(List.of(vertex), resourceProvider);
		if (this.relevantUncertaintySources.stream().anyMatch(it -> pcmQueryHelper.hasTargetNode((PCMUncertaintySource) it))) {
			return true;
		}
		return vertex.getPreviousElements().stream().anyMatch(it -> this.affectedByUncertainty(it, resourceProvider));
	}

    @Override
	public List<PCMUncertainTransposeFlowGraph> determineAlternativeTransposeFlowGraphs(UncertaintyResourceProvider resourceProvider) {
		if (this.uncertainState.isPresent()) {
			logger.error("Tried to determine alternative transpose flow graphs on a flow graph with an uncertain state");
			logger.error("This is most likely caused by calling determineAlternativeFlowGraphs on a transpose flow graph that was already an alternative flow graph");
			throw new IllegalStateException();
		}
		if (!(resourceProvider instanceof PCMUncertaintyResourceProvider pcmUncertaintyResourceProvider)) {
			logger.error("Provided uncertainty resource provider cannot be used for dfd models! Please provide a dfd uncertainty resource provider");
			throw new IllegalStateException();
		}

		PCMUncertaintyCalculator calculator = new PCMUncertaintyCalculator(pcmUncertaintyResourceProvider.getUncertaintySourceCollection().getSources(), pcmUncertaintyResourceProvider);
		UncertaintySourceManager uncertaintySourceManager = new UncertaintySourceManager(pcmUncertaintyResourceProvider.getUncertaintySourceCollection(), UncertaintySourceType.PCM);

		List<PCMUncertainTransposeFlowGraph> alternatePartialFlowGraphs = new ArrayList<>();
		Deque<PCMUncertainTransposeFlowGraph> currentPartialFlowGraphs = new ArrayDeque<>();
		List<PCMUncertaintySource> relevantUncertaintySources = new ArrayList<>();

		currentPartialFlowGraphs.push(this);
		while(!currentPartialFlowGraphs.isEmpty()) {
			PCMUncertainTransposeFlowGraph currentPartialFlowGraph = currentPartialFlowGraphs.pop();
			Optional<? extends PCMUncertaintySource> uncertaintySource = this.determineRelevantUncertaintySources(currentPartialFlowGraph.getVertices(), pcmUncertaintyResourceProvider, uncertaintySourceManager).stream()
					.filter(it -> !relevantUncertaintySources.contains(it))
					.min(((o1, o2) -> UncertaintyUtils.compareApplicationOrder(currentPartialFlowGraph, pcmUncertaintyResourceProvider, o1, o2)));
			if (uncertaintySource.isEmpty()) {
				alternatePartialFlowGraphs.add(currentPartialFlowGraph);
				continue;
			}
			relevantUncertaintySources.add(uncertaintySource.get());
			List<? extends UncertaintyScenario> uncertaintyScenarios = UncertaintyUtils.getUncertaintyScenarios(uncertaintySource.get());
			for (UncertaintyScenario uncertaintyScenario : uncertaintyScenarios) {
				UncertainState uncertainState = currentPartialFlowGraph.uncertainState.orElseGet(UncertainState::new);
				uncertainState.addSelectedScenario(uncertaintyScenario);
				currentPartialFlowGraphs.addAll(calculator.applyUncertaintyScenario(uncertaintyScenario, uncertainState, currentPartialFlowGraph));
			}
		}
		return alternatePartialFlowGraphs;
	}

	private List<? extends PCMUncertaintySource> determineRelevantUncertaintySources(List<? extends AbstractVertex<?>> vertices, PCMResourceProvider resourceProvider, UncertaintySourceManager uncertaintySourceManager) {
		PCMQueryHelper pcmQueryHelper = new PCMQueryHelper(vertices, resourceProvider);

		return uncertaintySourceManager.getUncertaintySources().stream()
				.map(PCMUncertaintySource.class::cast)
				.filter(pcmQueryHelper::hasTargetNode)
				.toList();
	}

	@Override
	public PCMTransposeFlowGraph copy(Map<AbstractPCMVertex<?>, AbstractPCMVertex<?>> mapping) {
		AbstractPCMVertex<?> pcmSink = (AbstractPCMVertex<?>) this.sink;
		AbstractPCMVertex<?> clonedSink = pcmSink.copy(mapping);

		return new PCMUncertainTransposeFlowGraph(clonedSink, this.relevantUncertaintySources);
	}

	public PCMUncertainTransposeFlowGraph copy(Map<AbstractPCMVertex<?>, AbstractPCMVertex<?>> mapping, UncertainState uncertainState) {
		AbstractPCMVertex<?> pcmSink = (AbstractPCMVertex<?>) this.sink;
		AbstractPCMVertex<?> clonedSink = pcmSink.copy(mapping);

		return new PCMUncertainTransposeFlowGraph(clonedSink, this.relevantUncertaintySources, uncertainState);
	}

	@Override
	public List<? extends UncertaintySource> getRelevantUncertaintySources() {
		return this.relevantUncertaintySources;
	}

	@Override
	public UncertainState getUncertainState() {
		return this.uncertainState.orElseThrow();
	}
}
