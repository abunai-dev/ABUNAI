package dev.abunai.confidentiality.analysis.dfd;

import java.util.*;

import org.dataflowanalysis.analysis.core.AbstractTransposeFlowGraph;
import org.dataflowanalysis.analysis.core.AbstractVertex;
import org.dataflowanalysis.analysis.dfd.core.DFDTransposeFlowGraph;
import org.dataflowanalysis.analysis.dfd.core.DFDVertex;
import org.dataflowanalysis.analysis.resource.ResourceProvider;
import org.dataflowanalysis.dfd.dataflowdiagram.Node;

import dev.abunai.confidentiality.analysis.core.UncertainTransposeFlowGraph;
import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDUncertaintySource;

public class DFDUncertainTransposeFlowGraph extends DFDTransposeFlowGraph implements UncertainTransposeFlowGraph {
	private final Optional<UncertainState> uncertainState;
	private final List<? extends UncertaintySource> relevantUncertaintySources;

	public DFDUncertainTransposeFlowGraph(AbstractVertex<?> sink,
										  List<? extends UncertaintySource> relevantUncertaintySources) {
		super(sink);
		this.uncertainState = Optional.empty();
		this.relevantUncertaintySources = relevantUncertaintySources;
	}
	
	public DFDUncertainTransposeFlowGraph(AbstractVertex<?> sink,
										  List<? extends UncertaintySource> relevantUncertaintySources, UncertainState uncertainState) {
		super(sink);
		this.uncertainState = Optional.ofNullable(uncertainState);
		this.relevantUncertaintySources = relevantUncertaintySources;
	}
	
	@Override
	public List<? extends DFDVertex> getImpactSet(ResourceProvider resourceProvider) {
		DFDQueryHelper dfdQueryHelper = new DFDQueryHelper(this.getVertices());
		
		List<Node> targetNodes = this.relevantUncertaintySources.stream()
				.map(it -> dfdQueryHelper.findTargetNodes((DFDUncertaintySource) it))
				.flatMap(List::stream)
				.toList();

		List<DFDVertex> longestAffectedElementList = super.getVertices().stream()
				.map(DFDVertex.class::cast)
				.dropWhile(it -> !targetNodes.contains(it.getReferencedElement()))
				.toList();
		// OLD CODE: new DFDActionSequence((List<AbstractActionSequenceElement<?>>) longestAffectedElementList);
		return longestAffectedElementList;
	}

	@Override
	public AbstractTransposeFlowGraph evaluate() {
        DFDVertex newSink = ((DFDVertex) sink).copy(new IdentityHashMap<>());
        newSink.unify(new HashSet<>());
        newSink.evaluateDataFlow();
        return new DFDUncertainTransposeFlowGraph(newSink,relevantUncertaintySources, uncertainState.get());
	}
	
	@Override
	public AbstractTransposeFlowGraph copy(Map<DFDVertex, DFDVertex> mapping) {
        DFDVertex copiedSink = mapping.getOrDefault((DFDVertex) sink, ((DFDVertex) sink).copy(mapping));
        copiedSink.unify(new HashSet<>());
        // TODO: This or else null is ugly
        return new DFDUncertainTransposeFlowGraph(copiedSink, this.relevantUncertaintySources, this.uncertainState.orElse(null));
    }
	
	public AbstractTransposeFlowGraph copy(Map<DFDVertex, DFDVertex> mapping, UncertainState uncertainState) {
        DFDVertex copiedSink = mapping.getOrDefault((DFDVertex) sink, ((DFDVertex) sink).copy(mapping));
        copiedSink.unify(new HashSet<>());
        return new DFDUncertainTransposeFlowGraph(copiedSink, this.relevantUncertaintySources, uncertainState);
    }
	
	@Override
	public List<DFDUncertainTransposeFlowGraph> determineAlternativePartialFlowGraphs() {
		List<UncertainState> states = UncertainState.createAllUncertainStates(this.relevantUncertaintySources);
		List<DFDUncertainTransposeFlowGraph> alternatePartialFlowGraphs = new ArrayList<>();
		DFDUncertainTransposeFlowGraphCalculator calculator = new DFDUncertainTransposeFlowGraphCalculator(this.relevantUncertaintySources);
		for (UncertainState state : states) {
			alternatePartialFlowGraphs.addAll(calculator.determineAlternativePartialFlowGraphs(state, this));
		}
		return alternatePartialFlowGraphs;
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
