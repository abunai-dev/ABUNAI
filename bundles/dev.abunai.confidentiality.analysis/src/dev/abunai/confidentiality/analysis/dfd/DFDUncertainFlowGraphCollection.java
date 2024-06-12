package dev.abunai.confidentiality.analysis.dfd;

import java.util.List;
import java.util.stream.Collectors;

import dev.abunai.confidentiality.analysis.core.UncertainFlowGraphCollection;
import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.core.UncertainTransposeFlowGraph;
import dev.abunai.confidentiality.analysis.core.UncertaintyUtils;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;
import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.core.AbstractTransposeFlowGraph;
import org.dataflowanalysis.analysis.dfd.core.DFDFlowGraphCollection;
import org.dataflowanalysis.analysis.dfd.core.DFDTransposeFlowGraph;
import org.dataflowanalysis.analysis.dfd.core.DFDTransposeFlowGraphFinder;

import dev.abunai.confidentiality.analysis.core.UncertaintySourceManager;
import dev.abunai.confidentiality.analysis.core.UncertaintySourceType;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDUncertaintySource;

/**
 * This class contains a collection of uncertain transpose flow graphs of a dfd model
 */
public class DFDUncertainFlowGraphCollection extends DFDFlowGraphCollection implements UncertainFlowGraphCollection {
	private final Logger logger = Logger.getLogger(DFDUncertainFlowGraphCollection.class);
	protected final DFDUncertaintyResourceProvider resourceProvider;

	/**
	 * Creates a new dfd uncertain flow graph collection with flow graphs calculated by {@link #findTransposeFlowGraphs()}
	 * @param resourceProvider Resource provider used to find transpose flow graphs
	 */
	public DFDUncertainFlowGraphCollection(DFDUncertaintyResourceProvider resourceProvider) {
		super(resourceProvider);
		this.resourceProvider = resourceProvider;
	}

	/**
	 * Initializes a new dfd uncertain flow graph collection with the list of transpose flow graphs and
	 * the given resource provider
	 * @param transposeFlowGraphs Transpose flow graphs that are saved in the flow graph collection
	 * @param resourceProvider Resource provider used to find transpose flow graphs and create uncertain flows
	 */
	public DFDUncertainFlowGraphCollection(List<? extends AbstractTransposeFlowGraph> transposeFlowGraphs, DFDUncertaintyResourceProvider resourceProvider) {
		super(resourceProvider, transposeFlowGraphs);
		this.resourceProvider = resourceProvider;
	}

	@Override
	public DFDUncertainFlowGraphCollection createUncertainFlows() {
		List<DFDUncertainTransposeFlowGraph> uncertainPartialFlows = this.getTransposeFlowGraphs().stream()
				.map(DFDUncertainTransposeFlowGraph.class::cast)
				.flatMap(it -> it.determineAlternativeTransposeFlowGraphs(this.resourceProvider).stream())
				.toList();
		DFDUncertainFlowGraphCollection result = new DFDUncertainFlowGraphCollection(uncertainPartialFlows, resourceProvider);
		result.printUncertaintyMessage(this.logger);
		return result;
	}

	@Override
	public List<? extends AbstractTransposeFlowGraph> findTransposeFlowGraphs() {
		if (!(super.resourceProvider instanceof DFDUncertaintyResourceProvider uncertaintyResourceProvider)) {
			logger.error("Cannot determine transpose flow graphs without dfd uncertainty resource provider");
			throw new IllegalStateException();
		}
		UncertaintySourceManager uncertaintySourceManager = new UncertaintySourceManager(uncertaintyResourceProvider.getUncertaintySourceCollection(), UncertaintySourceType.DFD);
		
		return new DFDTransposeFlowGraphFinder(uncertaintyResourceProvider).findTransposeFlowGraphs().stream()
				.map(DFDTransposeFlowGraph.class::cast)
				.map(it -> new DFDUncertainTransposeFlowGraph(it.getSink(), this.determineRelevantUncertaintySource(it, uncertaintySourceManager)))
				.toList();
	}

	/**
	 * Determines the relevant uncertainty sources for the given transpose flow graph with the given uncertainty source manager
	 * @param transposeFlowGraph Transpose flow graph of which the relevant uncertainty sources should be determined
	 * @param uncertaintySourceManager Uncertainty source manager containing the uncertainty sources
	 * @return Returns a list of uncertainty sources that are relevant for the given transpose flow graph
	 */
	private List<? extends DFDUncertaintySource> determineRelevantUncertaintySource(DFDTransposeFlowGraph transposeFlowGraph, UncertaintySourceManager uncertaintySourceManager) {
		DFDQueryHelper dfdQueryHelper = new DFDQueryHelper(transposeFlowGraph.getVertices());
		
		return uncertaintySourceManager.getUncertaintySources().stream()
				.map(DFDUncertaintySource.class::cast)
				.filter(dfdQueryHelper::hasTargetNode)
				.toList();
	}

	@Override
	public int getUncertaintyAmountGlobal() {
		List<UncertainState> allStates = UncertainState.createAllUncertainStates(this.resourceProvider.getUncertaintySourceCollection().getSources());
		return this.getTransposeFlowGraphs().size() * allStates.size();
	}

	@Override
	public int getUncertaintyAmountTFG() {
		int result = 0;
		for(AbstractTransposeFlowGraph transposeFlowGraph : this.getTransposeFlowGraphs()) {
			UncertainTransposeFlowGraph uncertainTransposeFlowGraph = (UncertainTransposeFlowGraph) transposeFlowGraph;
			List<? extends UncertaintyScenario> uncertaintyScenarios = uncertainTransposeFlowGraph.getRelevantUncertaintySources().stream()
					.map(UncertaintyUtils::getUncertaintyScenarios)
					.flatMap(List::stream)
					.toList();
			result += uncertaintyScenarios.size();
		}
		return result;
	}

	@Override
	public int getUncertaintyAmountUncertainTFG() {
		int result = 0;
		for(AbstractTransposeFlowGraph transposeFlowGraph : this.getTransposeFlowGraphs()) {
			UncertainTransposeFlowGraph uncertainTransposeFlowGraph = (UncertainTransposeFlowGraph) transposeFlowGraph;
			if (uncertainTransposeFlowGraph.getSelectedUncertaintyScenarios().isEmpty()) {
				result += 1;
			} else {
				result += uncertainTransposeFlowGraph.getSelectedUncertaintyScenarios().size();
			}
		}
		return result;
	}
}
