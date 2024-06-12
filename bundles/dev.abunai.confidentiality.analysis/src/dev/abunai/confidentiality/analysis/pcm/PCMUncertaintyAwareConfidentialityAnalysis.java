package dev.abunai.confidentiality.analysis.pcm;

import java.util.*;

import dev.abunai.confidentiality.analysis.core.*;
import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.core.FlowGraphCollection;
import org.dataflowanalysis.analysis.pcm.PCMDataFlowConfidentialityAnalysis;
import org.eclipse.core.runtime.Plugin;

import dev.abunai.confidentiality.analysis.UncertaintyAwareConfidentialityAnalysis;
import dev.abunai.confidentiality.analysis.dfd.DFDUncertainFlowGraphCollection;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;

public class PCMUncertaintyAwareConfidentialityAnalysis extends PCMDataFlowConfidentialityAnalysis
		implements UncertaintyAwareConfidentialityAnalysis {

	private final Logger logger = Logger.getLogger(PCMUncertaintyAwareConfidentialityAnalysis.class);
	private final Optional<String> nameFilter;
	private final Optional<List<Integer>> indicesFilter;
	private UncertaintySourceManager uncertaintySourceManager;

	public PCMUncertaintyAwareConfidentialityAnalysis(PCMUncertaintyResourceProvider resourceProvider,
			Optional<Class<? extends Plugin>> modelProjectActivator, String modelProjectName, Optional<String> nameFilter, Optional<List<Integer>> indicesFilter) {
		super(resourceProvider, modelProjectName, modelProjectActivator);
		this.nameFilter = nameFilter;
		this.indicesFilter = indicesFilter;
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
					this.getResourceProvider().getUncertaintySourceCollection(), UncertaintySourceType.PCM, this.nameFilter, this.indicesFilter);
	}
	
	@Override
	public PCMUncertainFlowGraphCollection findFlowGraph() {
		return new PCMUncertainFlowGraphCollection(this.getResourceProvider(), this.uncertaintySourceManager);
	}
	
	@Override
	public DFDUncertainFlowGraphCollection evaluateUncertainDataFlows(FlowGraphCollection flowGraph) {
		return ((DFDUncertainFlowGraphCollection) flowGraph).createUncertainFlows();
	}

	@Override
	public Logger getLogger() {
		return logger;
	}
}
