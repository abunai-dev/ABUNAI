package dev.abunai.confidentiality.analysis.dfd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.core.AbstractPartialFlowGraph;
import org.dataflowanalysis.analysis.core.AbstractVertex;
import org.dataflowanalysis.analysis.core.FlowGraph;
import org.dataflowanalysis.analysis.dfd.DFDConfidentialityAnalysis;
import org.eclipse.core.runtime.Plugin;
import dev.abunai.confidentiality.analysis.UncertaintyAwareConfidentialityAnalysis;
import dev.abunai.confidentiality.analysis.core.UncertainPartialFlowGraph;
import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.core.UncertaintySourceManager;
import dev.abunai.confidentiality.analysis.core.UncertaintySourceType;
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
	public Map<UncertainState, List<? extends AbstractVertex<?>>> queryUncertainDataFlow(
			FlowGraph flowGraph, Predicate<? super AbstractVertex<?>> condition) {
		Map<UncertainState, List<? extends AbstractVertex<?>>> result = new HashMap<>();
		
		for (AbstractPartialFlowGraph partialFlowGraph : flowGraph.getPartialFlowGraphs()) {
			if(!(partialFlowGraph instanceof UncertainPartialFlowGraph uncertainPartialFlowGraph)) {
				logger.error("Found imcompatible partial flow graph in uncertain flow graph");
				throw new IllegalArgumentException();
			}
			List<? extends AbstractVertex<?>> violations = uncertainPartialFlowGraph.getVertices().stream()
					.filter(condition)
					.toList();
			result.put(uncertainPartialFlowGraph.getUncertainState(), violations);
		}

		return result;
	}
}
