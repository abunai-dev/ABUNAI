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
import org.dataflowanalysis.dfd.dataflowdiagram.Node;

import dev.abunai.confidentiality.analysis.core.UncertainTransposeFlowGraph;
import dev.abunai.confidentiality.analysis.UncertaintyResourceProvider;
import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDUncertaintySource;

/**
 * This class represents an dfd transpose flow graph with uncertainties.
 * The relevant uncertainty sources for the uncertain transpose flow graph are contained in {@link #getRelevantUncertaintySources()}.
 * After the uncertainty scenarios were selected from the uncertainty sources with {@link #determineAlternativeTransposeFlowGraphs(UncertaintyResourceProvider)}
 * the uncertain state of the transpose flow graph is accessible with {@link #getUncertainState()}
 */
public class DFDUncertainTransposeFlowGraph extends DFDTransposeFlowGraph implements UncertainTransposeFlowGraph {
	private final Logger logger = Logger.getLogger(DFDUncertainTransposeFlowGraph.class);
	private final Optional<UncertainState> uncertainState;
	private final List<? extends UncertaintySource> relevantUncertaintySources;

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

	// TODO: Implement impact set, currently broken
	@Override
	public List<? extends DFDVertex> getImpactSet(ResourceProvider resourceProvider) {
		DFDQueryHelper dfdQueryHelper = new DFDQueryHelper(this.getVertices());
		
		List<Node> targetNodes = this.relevantUncertaintySources.stream()
				.map(it -> dfdQueryHelper.findTargetNodes((DFDUncertaintySource) it))
				.flatMap(List::stream)
				.toList();

		List<DFDVertex> longestAffectedElementList = this.getVertices().stream()
				.map(DFDVertex.class::cast)
				.dropWhile(it -> !targetNodes.contains(it.getReferencedElement()))
				.toList();
		return longestAffectedElementList;
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

		List<DFDUncertainTransposeFlowGraph> alternatePartialFlowGraphs = new ArrayList<>();
		Deque<DFDUncertainTransposeFlowGraph> currentPartialFlowGraphs = new ArrayDeque<>();
		List<DFDUncertaintySource> relevantUncertaintySources = new ArrayList<>();

		currentPartialFlowGraphs.push(this);
		while(!currentPartialFlowGraphs.isEmpty()) {
			DFDUncertainTransposeFlowGraph currentPartialFlowGraph = currentPartialFlowGraphs.pop();
            Optional<? extends DFDUncertaintySource> uncertaintySource = this.determineRelevantUncertaintySources(currentPartialFlowGraph.getVertices(), uncertaintySourceManager).stream()
                    .filter(it -> !relevantUncertaintySources.contains(it))
					.min(((o1, o2) -> UncertaintyUtils.compareApplicationOrder(currentPartialFlowGraph, o1, o2)));
			if (uncertaintySource.isEmpty()) {
				alternatePartialFlowGraphs.add(currentPartialFlowGraph);
				continue;
			}
			relevantUncertaintySources.add(uncertaintySource.get());
			List<? extends UncertaintyScenario> uncertaintyScenarios = UncertaintyUtils.getUncertaintyScenarios(uncertaintySource.get());
			for (UncertaintyScenario uncertaintyScenario : uncertaintyScenarios) {
				UncertainState uncertainState;
				if (currentPartialFlowGraph.uncertainState.isEmpty()) {
					uncertainState = new UncertainState();
				} else {
					uncertainState = new UncertainState(currentPartialFlowGraph.getUncertainState().getSelectedUncertaintyScenarios());

				}
				uncertainState.addSelectedScenario(uncertaintyScenario);
				currentPartialFlowGraphs.addAll(calculator.applyUncertaintyScenario(uncertaintyScenario, uncertainState, currentPartialFlowGraph));
			}
		}
		return alternatePartialFlowGraphs;
	}

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

	@Override
	public UncertainState getUncertainState() {
		return this.uncertainState.orElseThrow();
	}
}
