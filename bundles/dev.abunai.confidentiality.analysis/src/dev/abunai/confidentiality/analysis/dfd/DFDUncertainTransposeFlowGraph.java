package dev.abunai.confidentiality.analysis.dfd;

import java.util.*;

import dev.abunai.confidentiality.analysis.core.UncertaintySourceManager;
import dev.abunai.confidentiality.analysis.core.UncertaintySourceType;
import dev.abunai.confidentiality.analysis.core.UncertaintyUtils;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;
import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.core.AbstractTransposeFlowGraph;
import org.dataflowanalysis.analysis.core.AbstractVertex;
import org.dataflowanalysis.analysis.dfd.core.DFDTransposeFlowGraph;
import org.dataflowanalysis.analysis.dfd.core.DFDVertex;
import org.dataflowanalysis.analysis.resource.ResourceProvider;

import dev.abunai.confidentiality.analysis.core.UncertainTransposeFlowGraph;
import dev.abunai.confidentiality.analysis.UncertaintyResourceProvider;
import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDUncertaintySource;

/**
 * This class represents a dfd transpose flow graph with uncertainties.
 * The relevant uncertainty sources for the uncertain transpose flow graph are contained in {@link #getRelevantUncertaintySources()}.
 * After the uncertainty scenarios were selected from the uncertainty sources with {@link #determineAlternativeTransposeFlowGraphs(UncertaintyResourceProvider)}
 * the uncertain state of the transpose flow graph is accessible with {@link #getUncertainState()}
 */
public class DFDUncertainTransposeFlowGraph extends DFDTransposeFlowGraph implements UncertainTransposeFlowGraph {
	private final Logger logger = Logger.getLogger(DFDUncertainTransposeFlowGraph.class);
	private final Optional<UncertainState> uncertainState;
	private List<? extends UncertaintySource> relevantUncertaintySources;

	/**
	 * Create a new dfd uncertain transpose flow graph with the given sink and relevant uncertainty sources.
	 * The uncertain state of the transpose flow graph will be empty
	 * @param sink Sink of the dfd uncertain transpose flow graph
	 * @param relevantUncertaintySources Relevant uncertainty sources of the uncertain transpose flow graph
	 */
	public DFDUncertainTransposeFlowGraph(AbstractVertex<?> sink,
										  List<? extends UncertaintySource> relevantUncertaintySources) {
		super(sink);
		this.uncertainState = Optional.empty();
		this.relevantUncertaintySources = relevantUncertaintySources;
	}

	/**
	 * Create a new dfd uncertain transpose flow graph with the given sink and relevant uncertainty sources.
	 * Furthermore, an uncertain state has been selected from the relevant uncertainty sources
	 * @param sink Sink of the dfd uncertain transpose flow graph
	 * @param relevantUncertaintySources Relevant uncertainty sources of the uncertain transpose flow graph
	 * @param uncertainState Uncertain state of the transpose flow graph
	 */
	public DFDUncertainTransposeFlowGraph(AbstractVertex<?> sink,
										  List<? extends UncertaintySource> relevantUncertaintySources, UncertainState uncertainState) {
		super(sink);
		this.uncertainState = Optional.of(uncertainState);
		this.relevantUncertaintySources = relevantUncertaintySources;
	}

	@Override
	public List<? extends DFDVertex> getImpactSet(ResourceProvider resourceProvider) {
		if (this.uncertainState.isEmpty()) {
			logger.error("Impact set cannot be calculated without calculating alternate transpose flow graphs first");
			throw new IllegalStateException();
		}
		if (!this.containsDefaultScenario()) {
			logger.error("Impact set can only be caluclated on uncertain transpose flow graphs that model the default scenario");
			throw new IllegalStateException();
		}
		return this.getVertices().stream()
				.filter(DFDVertex.class::isInstance)
				.map(DFDVertex.class::cast)
				.filter(this::affectedByUncertainty).toList();
	}

	/**
	 * Determines whether a vertex is affected by the list of relevant uncertainty sources
	 * @param vertex Given vertex that should be checked
	 * @return Returns true, if the vertex is affected by an uncertainty. Otherwise, the method returns false
	 */
	private boolean affectedByUncertainty(AbstractVertex<?> vertex) {
		DFDQueryHelper dfdQueryHelper = new DFDQueryHelper(List.of(vertex));
		if (this.relevantUncertaintySources.stream().anyMatch(it -> dfdQueryHelper.hasTargetNode((DFDUncertaintySource) it))) {
			return true;
		}
		return vertex.getPreviousElements().stream().anyMatch(this::affectedByUncertainty);
	}

	@Override
	public AbstractTransposeFlowGraph evaluate() {
		if (this.uncertainState.isEmpty()) {
			logger.error("Uncertain DFD Transpose flow graphs should only be evaluated if they contain an uncertain state");
			throw new IllegalStateException("Uncertain DFD Transpose flow graphs should only be evaluated if they contain an uncertain state");
		}
		if (!(this.sink instanceof DFDVertex dfdSink)) {
			logger.error("Stored sink of DFD Transpose flow graph is not a DFDVertex");
			throw new IllegalStateException("Stored sink of DFD Transpose flow graph is not a DFD Vertex");
		}
        DFDVertex newSink = dfdSink.copy(new IdentityHashMap<>());
        newSink.unify(new HashSet<>());
        newSink.evaluateDataFlow();
        return new DFDUncertainTransposeFlowGraph(newSink,relevantUncertaintySources, uncertainState.get());
	}

	@Override
	public List<DFDUncertainTransposeFlowGraph> determineAlternativeTransposeFlowGraphs(UncertaintyResourceProvider resourceProvider) {
		if (this.uncertainState.isPresent()) {
			logger.error("Tried to determine alternative transpose flow graphs on a flow graph with an uncertain state");
			logger.error("This is most likely caused by calling determineAlternativeFlowGraphs on a transpose flow graph that was already an alternative flow graph");
			throw new IllegalStateException();
		}
		if (!(resourceProvider instanceof DFDUncertaintyResourceProvider dfdUncertaintyResourceProvider)) {
			logger.error("Provided uncertainty resource provider cannot be used for dfd models! Please provide a dfd uncertainty resource provider");
			throw new IllegalStateException();
		}

		DFDUncertaintyCalculator calculator = new DFDUncertaintyCalculator(dfdUncertaintyResourceProvider);
		UncertaintySourceManager uncertaintySourceManager = new UncertaintySourceManager(dfdUncertaintyResourceProvider.getUncertaintySourceCollection(), UncertaintySourceType.DFD);

		List<DFDUncertainTransposeFlowGraph> alternateTransposeFlowGraphs = new ArrayList<>();
		Deque<DFDUncertainTransposeFlowGraph> currentTransposeFlowGraphs = new ArrayDeque<>();
		List<UncertaintySource> relevantUncertaintySources = new ArrayList<>();

		currentTransposeFlowGraphs.push(this);
		while(!currentTransposeFlowGraphs.isEmpty()) {
			DFDUncertainTransposeFlowGraph currentPartialFlowGraph = currentTransposeFlowGraphs.pop();
            Optional<? extends UncertaintySource> uncertaintySource = getFirstUncertaintySource(currentPartialFlowGraph, relevantUncertaintySources, uncertaintySourceManager, dfdUncertaintyResourceProvider);
			if (uncertaintySource.isEmpty()) {
				alternateTransposeFlowGraphs.add(currentPartialFlowGraph);
				continue;
			}
			relevantUncertaintySources.add(uncertaintySource.get());
			currentTransposeFlowGraphs.addAll(this.applyUncertaintySource(uncertaintySource.get(), currentPartialFlowGraph, calculator));
		}
		alternateTransposeFlowGraphs.forEach(it -> it.setRelevantUncertaintySources(relevantUncertaintySources));
		return alternateTransposeFlowGraphs;
	}

	/**
	 * Determines the first encountered uncertainty source that should be applied to the transpose flow graph that has not been applied yet
	 * @param currentPartialFlowGraph Current partial flow graph of which the next applied uncertainty source should be calculated
	 * @param relevantUncertaintySources List of uncertainty sources that were already applied
	 * @param uncertaintySourceManager Uncertainty source manager providing uncertainty sources
	 * @param dfdUncertaintyResourceProvider Resource provider providing access to the model
	 * @return Returns an Optional containing the first encountered uncertainty source
	 */
	private Optional<? extends UncertaintySource> getFirstUncertaintySource(DFDUncertainTransposeFlowGraph currentPartialFlowGraph, List<UncertaintySource> relevantUncertaintySources, UncertaintySourceManager uncertaintySourceManager, DFDUncertaintyResourceProvider dfdUncertaintyResourceProvider) {
		return this.determineRelevantUncertaintySources(currentPartialFlowGraph.getVertices(), uncertaintySourceManager).stream()
				.filter(it -> !relevantUncertaintySources.contains(it))
				.min(((o1, o2) -> UncertaintyUtils.compareApplicationOrder(currentPartialFlowGraph, dfdUncertaintyResourceProvider, o1, o2)));
	}

	/**
	 * Applies the given uncertainty source on the transpose flow graph
	 * @param uncertaintySource Uncertainty source that is applied to the transpose flow graph
	 * @param transposeFlowGraph Transpose flow graph that the uncertainty source is applied to
	 * @param calculator Uncertainty calculator used to resolve the applied uncertainty source
	 * @return Returns a list of all resulting transpose flow graphs that result from the uncertainty source
	 */
	private List<DFDUncertainTransposeFlowGraph> applyUncertaintySource(UncertaintySource uncertaintySource, DFDUncertainTransposeFlowGraph transposeFlowGraph, DFDUncertaintyCalculator calculator) {
		List<? extends UncertaintyScenario> uncertaintyScenarios = UncertaintyUtils.getUncertaintyScenarios(uncertaintySource);
		List<DFDUncertainTransposeFlowGraph> results = new ArrayList<>();
		for (UncertaintyScenario uncertaintyScenario : uncertaintyScenarios) {
			UncertainState uncertainState = transposeFlowGraph.uncertainState.orElseGet(UncertainState::new);
			uncertainState.addSelectedScenario(uncertaintyScenario);
			results.addAll(calculator.applyUncertaintyScenario(uncertaintyScenario, uncertainState, transposeFlowGraph));
		}
		return results;
	}

	/**
	 * Determines the relevant uncertainty sources for a given list of vertices and uncertainty sources
	 * @param vertices Given list of vertices of which the relevant uncertainty sources are calculated
	 * @param uncertaintySourceManager Uncertainty source manager used to get all uncertainty sources
	 * @return Returns a list of all uncertainty sources relevant to the given list of vertices
	 */
	private List<? extends DFDUncertaintySource> determineRelevantUncertaintySources(List<? extends AbstractVertex<?>> vertices, UncertaintySourceManager uncertaintySourceManager) {
		DFDQueryHelper dfdQueryHelper = new DFDQueryHelper(vertices);

		return uncertaintySourceManager.getUncertaintySources().stream()
				.map(DFDUncertaintySource.class::cast)
				.filter(dfdQueryHelper::hasTargetNode)
				.toList();
	}

	@Override
	public AbstractTransposeFlowGraph copy(Map<DFDVertex, DFDVertex> mapping) {
		DFDVertex copiedSink = mapping.getOrDefault((DFDVertex) sink, ((DFDVertex) sink).copy(mapping));
		copiedSink.unify(new HashSet<>());
		return this.uncertainState.map(state -> new DFDUncertainTransposeFlowGraph(copiedSink, this.relevantUncertaintySources, state))
				.orElseGet(() -> new DFDUncertainTransposeFlowGraph(copiedSink, this.relevantUncertaintySources));
	}

	/**
	 * Copies the dfd uncertain transpose flow graph with the given mapping and uncertain state
	 * @param mapping Mapping which is used to map old vertices to new ones
	 * @param uncertainState Uncertain state of the copied dfd uncertain transpose flow graph
	 * @return Returns a new dfd uncertain transpose flow graph with a copy of all vertices
	 */
	public DFDUncertainTransposeFlowGraph copy(Map<DFDVertex, DFDVertex> mapping, UncertainState uncertainState) {
		DFDVertex copiedSink = mapping.getOrDefault((DFDVertex) sink, ((DFDVertex) sink).copy(mapping));
		copiedSink.unify(new HashSet<>());
		return new DFDUncertainTransposeFlowGraph(copiedSink, this.relevantUncertaintySources, uncertainState);
	}

	@Override
	public List<? extends UncertaintySource> getRelevantUncertaintySources() {
		return this.relevantUncertaintySources;
	}

	public void setRelevantUncertaintySources(List<? extends UncertaintySource> relevantUncertaintySources) {
		this.relevantUncertaintySources = relevantUncertaintySources;
	}

	@Override
	public UncertainState getUncertainState() {
		return this.uncertainState.orElseThrow();
	}
}
