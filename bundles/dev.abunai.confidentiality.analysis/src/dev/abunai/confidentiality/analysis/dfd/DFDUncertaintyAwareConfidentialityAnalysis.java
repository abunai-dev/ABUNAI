package dev.abunai.confidentiality.analysis.dfd;

import java.util.*;

import dev.abunai.confidentiality.analysis.core.*;
import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.core.FlowGraphCollection;
import org.dataflowanalysis.analysis.dfd.DFDConfidentialityAnalysis;
import org.eclipse.core.runtime.Plugin;
import dev.abunai.confidentiality.analysis.UncertaintyAwareConfidentialityAnalysis;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;

/**
 * This class represents an uncertainty aware confidentiality analysis for the dfd metamodel.
 * The method {@link #evaluateUncertainDataFlows(FlowGraphCollection)} must be called to create uncertain data flows
 */
public class DFDUncertaintyAwareConfidentialityAnalysis extends DFDConfidentialityAnalysis implements UncertaintyAwareConfidentialityAnalysis {
	private final Logger logger = Logger.getLogger(DFDUncertaintyAwareConfidentialityAnalysis.class);
	private UncertaintySourceManager uncertaintySourceManager;
	private final Optional<String> stringFilter;
	private final Optional<List<Integer>> indicesFilter;

	public DFDUncertaintyAwareConfidentialityAnalysis(DFDUncertaintyResourceProvider resourceProvider,
			Optional<Class<? extends Plugin>> modelProjectActivator, String modelProjectName, Optional<String> stringFilter, Optional<List<Integer>> indicesFilter) {
		super(resourceProvider, modelProjectActivator, modelProjectName);
		this.stringFilter = stringFilter;
		this.indicesFilter = indicesFilter;
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
					this.getResourceProvider().getUncertaintySourceCollection(), UncertaintySourceType.DFD, stringFilter, indicesFilter);
	}
	
	@Override
	public DFDUncertainFlowGraphCollection findFlowGraph() {
		return new DFDUncertainFlowGraphCollection(this.getResourceProvider(), this.uncertaintySourceManager);
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
