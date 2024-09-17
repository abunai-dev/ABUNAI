package dev.abunai.confidentiality.analysis;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import dev.abunai.confidentiality.analysis.core.UncertainConstraintViolation;
import dev.abunai.confidentiality.analysis.core.UncertainTransposeFlowGraph;
import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.core.AbstractTransposeFlowGraph;
import org.dataflowanalysis.analysis.core.AbstractVertex;
import org.dataflowanalysis.analysis.core.FlowGraphCollection;
import org.dataflowanalysis.analysis.resource.ResourceProvider;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;

public interface UncertaintyAwareConfidentialityAnalysis {
	void initializeAnalysis();
	
	List<UncertaintySource> getUncertaintySources();

	ResourceProvider getResourceProvider();

	FlowGraphCollection findFlowGraph();
	
	FlowGraphCollection evaluateUncertainDataFlows(FlowGraphCollection flowGraph);

	/**
	 * Returns a list of constraint violations that contain the violations contained in the flow graph collection.
	 * If a transpose flow graph does not contain a violation, no constraint violation object will be created
	 * @param flowGraph Flow graph collection that contains the transpose flow graphs
	 * @param condition Predicate that determines whether a vertex is a violation
	 * @return Returns a list of constraint violations contained in the flow graph collection
	 */
	default List<UncertainConstraintViolation> queryUncertainDataFlow(FlowGraphCollection flowGraph,
															  Predicate<? super AbstractVertex<?>> condition) {
		List<UncertainConstraintViolation> result = new ArrayList<>();

		for (AbstractTransposeFlowGraph transposeFlowGraph : flowGraph.getTransposeFlowGraphs()) {
			if(!(transposeFlowGraph instanceof UncertainTransposeFlowGraph uncertainTransposeFlowGraph)) {
				this.getLogger().error("Found incompatible transpose flow graph in uncertain flow graph");
				throw new IllegalArgumentException();
			}
			List<? extends AbstractVertex<?>> violations = transposeFlowGraph.getVertices().stream()
					.filter(condition)
					.toList();
			if (!violations.isEmpty()) {
				result.add(new UncertainConstraintViolation(uncertainTransposeFlowGraph.getUncertainState(), uncertainTransposeFlowGraph, violations));
			}
		}

		return result;
	}
	
	default List<UncertainConstraintViolation> queryUncertainDataNodes(FlowGraphCollection flowGraph,
                                                                String condition) {
	    List<UncertainConstraintViolation> result = new ArrayList<>();

	    for (AbstractTransposeFlowGraph transposeFlowGraph : flowGraph.getTransposeFlowGraphs()) {
	        if(!(transposeFlowGraph instanceof UncertainTransposeFlowGraph uncertainTransposeFlowGraph)) {
	            this.getLogger().error("Found incompatible transpose flow graph in uncertain flow graph");
	            throw new IllegalArgumentException();
	        }
	        Boolean violations = transposeFlowGraph.getVertices()
	                .contains(condition);
	        Boolean hasNode = false;
	        for (var vertex: transposeFlowGraph.getVertices()) {
	            hasNode = vertex.getAllVertexCharacteristics().contains(condition)|| hasNode;
	        }
	        
	        
	        if (!hasNode) {
	            result.add(new UncertainConstraintViolation(uncertainTransposeFlowGraph.getUncertainState(), uncertainTransposeFlowGraph, transposeFlowGraph.getVertices()));
	        }
	    }

	    return result;
}
	

	Logger getLogger();
}
