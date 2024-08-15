package dev.abunai.confidentiality.analysis.dfd;

import java.util.List;

import dev.abunai.confidentiality.analysis.core.UncertainFlowGraphCollection;
import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.core.UncertainTransposeFlowGraph;
import dev.abunai.confidentiality.analysis.core.UncertaintyUtils;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;
import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.core.AbstractTransposeFlowGraph;
import org.dataflowanalysis.analysis.dfd.core.DFDCyclicTransposeFlowGraphFinder;
import org.dataflowanalysis.analysis.dfd.core.DFDFlowGraphCollection;
import org.dataflowanalysis.analysis.dfd.core.DFDTransposeFlowGraph;

import dev.abunai.confidentiality.analysis.core.UncertaintySourceManager;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDUncertaintySource;

/**
 * This class contains a collection of uncertain transpose flow graphs of a dfd model
 */
public class DFDUncertainFlowGraphCollection extends DFDFlowGraphCollection implements UncertainFlowGraphCollection {
	private final Logger logger = Logger.getLogger(DFDUncertainFlowGraphCollection.class);
	private final UncertaintySourceManager uncertaintySourceManager;
	protected final DFDUncertaintyResourceProvider resourceProvider;

	/**
	 * Creates a new dfd uncertain flow graph collection with flow graphs calculated by {@link #findTransposeFlowGraphs()}
	 * @param resourceProvider Resource provider used to find transpose flow graphs
	 */
	public DFDUncertainFlowGraphCollection(DFDUncertaintyResourceProvider resourceProvider, UncertaintySourceManager uncertaintySourceManager) {
		super();
		this.resourceProvider = resourceProvider;
		this.uncertaintySourceManager = uncertaintySourceManager;
		super.initialize(resourceProvider);
	}

	/**
	 * Initializes a new dfd uncertain flow graph collection with the list of transpose flow graphs and
	 * the given resource provider
	 * @param transposeFlowGraphs Transpose flow graphs that are saved in the flow graph collection
	 * @param resourceProvider Resource provider used to find transpose flow graphs and create uncertain flows
	 */
	public DFDUncertainFlowGraphCollection(List<? extends AbstractTransposeFlowGraph> transposeFlowGraphs, DFDUncertaintyResourceProvider resourceProvider, UncertaintySourceManager uncertaintySourceManager) {
		super(resourceProvider, transposeFlowGraphs);
		this.resourceProvider = resourceProvider;
		this.uncertaintySourceManager = uncertaintySourceManager;
	}

	@Override
	public DFDUncertainFlowGraphCollection createUncertainFlows() {
		List<DFDUncertainTransposeFlowGraph> uncertainPartialFlows = this.getTransposeFlowGraphs().stream()
				.map(DFDUncertainTransposeFlowGraph.class::cast)
				.flatMap(it -> it.determineAlternativeTransposeFlowGraphs(this.resourceProvider).stream())
				.toList();
		DFDUncertainFlowGraphCollection result = new DFDUncertainFlowGraphCollection(uncertainPartialFlows, resourceProvider, this.uncertaintySourceManager);
		result.printUncertaintyMessage(this.logger);
		return result;
	}

	@Override
	public List<? extends AbstractTransposeFlowGraph> findTransposeFlowGraphs() {
		if (!(super.resourceProvider instanceof DFDUncertaintyResourceProvider uncertaintyResourceProvider)) {
			logger.error("Cannot determine transpose flow graphs without dfd uncertainty resource provider");
			throw new IllegalStateException();
		}
		return new DFDCyclicTransposeFlowGraphFinder(uncertaintyResourceProvider).findTransposeFlowGraphs().stream()
				.map(DFDTransposeFlowGraph.class::cast)
				.map(it -> new DFDUncertainTransposeFlowGraph(it.getSink(), this.determineRelevantUncertaintySource(it), this.uncertaintySourceManager))
				.toList();
	}

	/**
	 * Determines the relevant uncertainty sources for the given transpose flow graph with the given uncertainty source manager
	 * @param transposeFlowGraph Transpose flow graph of which the relevant uncertainty sources should be determined
	 * @return Returns a list of uncertainty sources that are relevant for the given transpose flow graph
	 */
	private List<? extends DFDUncertaintySource> determineRelevantUncertaintySource(DFDTransposeFlowGraph transposeFlowGraph) {
		DFDQueryHelper dfdQueryHelper = new DFDQueryHelper(transposeFlowGraph.getVertices());
		
		return this.uncertaintySourceManager.getUncertaintySources().stream()
				.map(DFDUncertaintySource.class::cast)
				.filter(dfdQueryHelper::hasTargetNode)
				.toList();
	}

	@Override
	public int getScenarioAwareComplexity() {
		List<UncertainState> allStates = UncertainState.createAllUncertainStates(this.uncertaintySourceManager.getUncertaintySources());
		List<UncertainTransposeFlowGraph> originalFlowGraphs = this.getTransposeFlowGraphs().stream()
				.filter(UncertainTransposeFlowGraph.class::isInstance)
				.map(UncertainTransposeFlowGraph.class::cast)
				.filter(it -> it.getSelectedUncertaintyScenarios().stream().allMatch(us -> UncertaintyUtils.isDefaultScenario((UncertaintySource) us.eContainer(), us)))
				.toList();
		return originalFlowGraphs.size() * allStates.size();
	}

	@Override
	public int getGraphAwareComplexity() {
		int result = 0;
		for(AbstractTransposeFlowGraph transposeFlowGraph : this.getTransposeFlowGraphs()) {
			UncertainTransposeFlowGraph uncertainTransposeFlowGraph = (UncertainTransposeFlowGraph) transposeFlowGraph;
			if (!uncertainTransposeFlowGraph.getSelectedUncertaintyScenarios().stream().allMatch(it -> UncertaintyUtils.isDefaultScenario((UncertaintySource) it.eContainer(), it))) {
				continue;
			}
			List<UncertainState> states = UncertainState.createAllUncertainStates(uncertainTransposeFlowGraph.getRelevantUncertaintySources());
			result += states.size();
		}
		return result;
	}

	@Override
	public int getImpactAwareComplexity() {
		return this.getTransposeFlowGraphs().size();
	}
}
