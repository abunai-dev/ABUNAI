package dev.abunai.confidentiality.analysis.dfd;

import java.util.*;
import java.util.function.Predicate;

import dev.abunai.confidentiality.analysis.core.*;
import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.core.AbstractTransposeFlowGraph;
import org.dataflowanalysis.analysis.core.AbstractVertex;
import org.dataflowanalysis.analysis.core.FlowGraph;
import org.dataflowanalysis.analysis.dfd.DFDConfidentialityAnalysis;
import org.eclipse.core.runtime.Plugin;
import dev.abunai.confidentiality.analysis.UncertaintyAwareConfidentialityAnalysis;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;

public class DFDUncertaintyAwareConfidentialityAnalysis extends DFDConfidentialityAnalysis implements UncertaintyAwareConfidentialityAnalysis {
	private final Logger logger = Logger.getLogger(DFDUncertaintyAwareConfidentialityAnalysis.class);
	private UncertaintySourceManager uncertaintySourceManager;

	public DFDUncertaintyAwareConfidentialityAnalysis(DFDUncertaintyResourceProvider resourceProvider,
			Optional<Class<? extends Plugin>> modelProjectActivator, String modelProjectName) {
		super(resourceProvider, modelProjectActivator, modelProjectName);
	}

	@Override
	public DFDUncertaintyResourceProvider getResourceProvider() {
		return (DFDUncertaintyResourceProvider) resourceProvider;
	}

	@Override
	public List<UncertaintySource> getUncertaintySources() {
		return this.uncertaintySourceManager.getUncertaintySources();
	}

	@Override
	public void initializeAnalysis() {
		super.initializeAnalysis();
		this.uncertaintySourceManager = new UncertaintySourceManager(
					this.getResourceProvider().getUncertaintySourceCollection(), UncertaintySourceType.DFD);
	}
	
	@Override
	public DFDUncertainFlowGraph findFlowGraph() {
		return new DFDUncertainFlowGraph(this.getResourceProvider());
	}
	
	@Override
	public DFDUncertainFlowGraph evaluateUncertainDataFlows(FlowGraph flowGraph) {
		return ((DFDUncertainFlowGraph) flowGraph).createUncertainFlows();
	}

	@Override
	public List<UncertainConstraintViolation> queryUncertainDataFlow(
			FlowGraph flowGraph, Predicate<? super AbstractVertex<?>> condition) {
		List<UncertainConstraintViolation> result = new ArrayList<>();
		
		for (AbstractTransposeFlowGraph transposeFlowGraph : flowGraph.getTransposeFlowGraphs()) {
			if(!(transposeFlowGraph instanceof UncertainTransposeFlowGraph uncertainTransposeFlowGraph)) {
				logger.error("Found incompatible transpose flow graph in uncertain flow graph");
				throw new IllegalArgumentException();
			}
			List<? extends AbstractVertex<?>> violations = uncertainTransposeFlowGraph.getVertices().stream()
					.filter(condition)
					.toList();
			if (!violations.isEmpty()) {
				result.add(new UncertainConstraintViolation(uncertainTransposeFlowGraph.getUncertainState(), uncertainTransposeFlowGraph, violations));
			}
		}

		return result;
	}
}
