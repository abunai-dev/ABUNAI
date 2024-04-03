package dev.abunai.confidentiality.analysis.pcm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.core.AbstractPartialFlowGraph;
import org.dataflowanalysis.analysis.core.AbstractVertex;
import org.dataflowanalysis.analysis.core.FlowGraph;
import org.dataflowanalysis.analysis.pcm.PCMDataFlowConfidentialityAnalysis;
import org.eclipse.core.runtime.Plugin;

import dev.abunai.confidentiality.analysis.UncertaintyAwareConfidentialityAnalysis;
import dev.abunai.confidentiality.analysis.core.UncertainPartialFlowGraph;
import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.core.UncertaintySourceManager;
import dev.abunai.confidentiality.analysis.core.UncertaintySourceType;
import dev.abunai.confidentiality.analysis.dfd.DFDUncertainFlowGraph;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;

public class PCMUncertaintyAwareConfidentialityAnalysis extends PCMDataFlowConfidentialityAnalysis
		implements UncertaintyAwareConfidentialityAnalysis {

	private final Logger logger = Logger.getLogger(PCMUncertaintyAwareConfidentialityAnalysis.class);
	private UncertaintySourceManager uncertaintySourceManager;

	public PCMUncertaintyAwareConfidentialityAnalysis(PCMUncertaintyResourceProvider resourceProvider,
			Optional<Class<? extends Plugin>> modelProjectActivator, String modelProjectName) {
		super(resourceProvider, modelProjectName, modelProjectActivator);
	}

	@Override
	public PCMUncertaintyResourceProvider getResourceProvider() {
		return (PCMUncertaintyResourceProvider) resourceProvider;
	}

	@Override
	public List<UncertaintySource> getUncertaintySources() {
		return this.uncertaintySourceManager.getUncertaintySources();
	}

	@Override
	public void initializeAnalysis() {
		super.initializeAnalysis();
		this.uncertaintySourceManager = new UncertaintySourceManager(
					this.getResourceProvider().getUncertaintySourceCollection(), UncertaintySourceType.PCM);
	}
	
	@Override
	public PCMUncertainFlowGraph findFlowGraph() {
		return new PCMUncertainFlowGraph(this.getResourceProvider());
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
