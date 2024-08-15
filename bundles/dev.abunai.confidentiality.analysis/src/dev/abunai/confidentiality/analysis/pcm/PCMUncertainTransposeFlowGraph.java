package dev.abunai.confidentiality.analysis.pcm;

import java.util.*;

import dev.abunai.confidentiality.analysis.core.UncertaintySourceManager;
import dev.abunai.confidentiality.analysis.core.UncertaintyUtils;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;

import org.apache.log4j.Logger;

import org.dataflowanalysis.analysis.core.AbstractVertex;
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
	private final UncertaintySourceManager uncertaintySourceManager;
	private List<? extends UncertaintySource> relevantUncertaintySources;


	public PCMUncertainTransposeFlowGraph(AbstractVertex<?> sink,
										  List<? extends UncertaintySource> relevantUncertaintySources, UncertaintySourceManager uncertaintySourceManager) {
		super(sink);
		this.uncertainState = Optional.empty();
		this.relevantUncertaintySources = relevantUncertaintySources;
		this.uncertaintySourceManager = uncertaintySourceManager;
	}
	
	public PCMUncertainTransposeFlowGraph(AbstractVertex<?> sink,
										  List<? extends UncertaintySource> relevantUncertaintySources, UncertainState uncertainState, UncertaintySourceManager uncertaintySourceManager) {
		super(sink);
		this.uncertainState = Optional.of(uncertainState);
		this.relevantUncertaintySources = relevantUncertaintySources;
		this.uncertaintySourceManager = uncertaintySourceManager;
	}

	@Override
	public List<? extends AbstractPCMVertex<?>> getImpactSet(ResourceProvider resourceProvider) {
		if (this.uncertainState.isEmpty()) {
			logger.error("Impact set cannot be calculated without calculating alternate transpose flow graphs first");
			throw new IllegalStateException();
		}
		if (!this.containsDefaultScenario()) {
			logger.error("Impact set can only be caluclated on uncertain transpose flow graphs that model the default scenario");
			throw new IllegalStateException();
		}
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

		List<PCMUncertainTransposeFlowGraph> alternateTransposeFlowGraphs = new ArrayList<>();
		Deque<PCMUncertainTransposeFlowGraph> currentTransposeFlowGraphs = new ArrayDeque<>();
		List<PCMUncertaintySource> relevantUncertaintySources = new ArrayList<>();

		currentTransposeFlowGraphs.push(this);
		while(!currentTransposeFlowGraphs.isEmpty()) {
			PCMUncertainTransposeFlowGraph currentTransposeFlowGraph = currentTransposeFlowGraphs.pop();
			Optional<? extends PCMUncertaintySource> uncertaintySource = this.getFirstUncertaintySource(currentTransposeFlowGraph, relevantUncertaintySources, uncertaintySourceManager, pcmUncertaintyResourceProvider);
			if (uncertaintySource.isEmpty()) {
				if (currentTransposeFlowGraph.uncertainState.isEmpty()) {
					alternateTransposeFlowGraphs.add(currentTransposeFlowGraph.copy(new HashMap<>(), new UncertainState()));
				} else {
					alternateTransposeFlowGraphs.add(currentTransposeFlowGraph);
				}
				continue;
			}
			if (!relevantUncertaintySources.contains(uncertaintySource.get())){
				relevantUncertaintySources.add(uncertaintySource.get());
			}
			currentTransposeFlowGraphs.addAll(this.applyUncertaintySource(uncertaintySource.get(), currentTransposeFlowGraph, calculator));
		}
		alternateTransposeFlowGraphs.forEach(it -> it.setRelevantUncertaintySources(relevantUncertaintySources));
		return alternateTransposeFlowGraphs;
	}
    
    /**
	 * Determines the first encountered uncertainty source that should be applied to the transpose flow graph that has not been applied yet
	 * @param currentPartialFlowGraph Current partial flow graph of which the next applied uncertainty source should be calculated
	 * @param relevantUncertaintySources List of uncertainty sources that were already applied
	 * @param uncertaintySourceManager Uncertainty source manager providing uncertainty sources
	 * @param pcmUncertaintyResourceProvider Resource provider providing access to the model
	 * @return Returns an Optional containing the first encountered uncertainty source
	 */
	private Optional<? extends PCMUncertaintySource> getFirstUncertaintySource(PCMUncertainTransposeFlowGraph currentPartialFlowGraph, List<PCMUncertaintySource> relevantUncertaintySources, UncertaintySourceManager uncertaintySourceManager, PCMUncertaintyResourceProvider pcmUncertaintyResourceProvider) {
		return this.determineRelevantUncertaintySources(currentPartialFlowGraph.getVertices(), pcmUncertaintyResourceProvider,  uncertaintySourceManager).stream()
				.filter(it -> !currentPartialFlowGraph.uncertainState.orElseGet(UncertainState::new).getUncertaintySources().contains(it))
				.min(((o1, o2) -> UncertaintyUtils.compareApplicationOrder(currentPartialFlowGraph, pcmUncertaintyResourceProvider, o1, o2)));
	}

	private List<? extends PCMUncertaintySource> determineRelevantUncertaintySources(List<? extends AbstractVertex<?>> vertices, PCMResourceProvider resourceProvider, UncertaintySourceManager uncertaintySourceManager) {
		PCMQueryHelper pcmQueryHelper = new PCMQueryHelper(vertices, resourceProvider);

		return uncertaintySourceManager.getUncertaintySources().stream()
				.map(PCMUncertaintySource.class::cast)
				.filter(pcmQueryHelper::hasTargetNode)
				.toList();
	}
	
	private List<PCMUncertainTransposeFlowGraph> applyUncertaintySource(UncertaintySource uncertaintySource, PCMUncertainTransposeFlowGraph currentTransposeFlowGraph, PCMUncertaintyCalculator calculator) {
		List<? extends UncertaintyScenario> uncertaintyScenarios = UncertaintyUtils.getUncertaintyScenarios(uncertaintySource);
		List<PCMUncertainTransposeFlowGraph> results = new ArrayList<>();
		for (UncertaintyScenario uncertaintyScenario : uncertaintyScenarios) {
			UncertainState uncertainState = new UncertainState(currentTransposeFlowGraph.uncertainState.orElseGet(UncertainState::new).getSelectedUncertaintyScenarios());
			uncertainState.addSelectedScenario(uncertaintyScenario);
			results.addAll(calculator.applyUncertaintyScenario(uncertaintyScenario, uncertainState, currentTransposeFlowGraph));
		}
		return results;
	}

	@Override
	public PCMTransposeFlowGraph copy(Map<AbstractPCMVertex<?>, AbstractPCMVertex<?>> mapping) {
		AbstractPCMVertex<?> pcmSink = (AbstractPCMVertex<?>) this.sink;
		AbstractPCMVertex<?> clonedSink = pcmSink.copy(mapping);

		return new PCMUncertainTransposeFlowGraph(clonedSink, this.relevantUncertaintySources, this.uncertaintySourceManager);
	}

	public PCMUncertainTransposeFlowGraph copy(Map<AbstractPCMVertex<?>, AbstractPCMVertex<?>> mapping, UncertainState uncertainState) {
		AbstractPCMVertex<?> pcmSink = (AbstractPCMVertex<?>) this.sink;
		AbstractPCMVertex<?> clonedSink = pcmSink.copy(mapping);

		return new PCMUncertainTransposeFlowGraph(clonedSink, this.relevantUncertaintySources, uncertainState, this.uncertaintySourceManager);
	}

	@Override
	public List<? extends UncertaintySource> getRelevantUncertaintySources() {
		return this.relevantUncertaintySources;
	}

	@Override
	public List<? extends UncertaintyScenario> getSelectedUncertaintyScenarios() {
		if (this.uncertainState.isEmpty()) {
			return List.of();
		}
		return this.uncertainState.get().getSelectedUncertaintyScenarios();
	}

	public void setRelevantUncertaintySources(List<? extends UncertaintySource> relevantUncertaintySources) {
		this.relevantUncertaintySources = relevantUncertaintySources;
	}

	@Override
	public UncertainState getUncertainState() {
		return this.uncertainState.orElseThrow();
	}

	public UncertaintySourceManager getUncertaintySourceManager() {
		return uncertaintySourceManager;
	}
}
