package dev.abunai.confidentiality.analysis.core;

import java.util.List;

import org.dataflowanalysis.analysis.core.AbstractVertex;
import org.dataflowanalysis.analysis.resource.ResourceProvider;

import dev.abunai.confidentiality.analysis.UncertaintyResourceProvider;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;

/**
 * Represents a {@link org.dataflowanalysis.analysis.core.AbstractTransposeFlowGraph} that is impacted by uncertainties.
 * The Alternative partial flow graphs created by the uncertainties can be retrieved with {@link #determineAlternativeTransposeFlowGraphs(UncertaintyResourceProvider)}.
 * The uncertain state of the uncertain transpose flow graph is returned by {@link #getUncertainState()}
 */
public interface UncertainTransposeFlowGraph {

	/**
	 * Determines all alternative transpose flow graphs that are created by the uncertain state of the transpose flow graph
	 * @param resourceProvider Uncertainty resource provider that provides PCM/DFD resources and uncertainty sources
	 * @return Returns a list of all uncertain transpose flow graphs that result from uncertainties applicable to the transpose flow graph
	 */
	List<? extends UncertainTransposeFlowGraph> determineAlternativeTransposeFlowGraphs(UncertaintyResourceProvider resourceProvider);

	/**
	 * Determines the impact set, the list of vertices affected by the uncertainties, of the transpose flow graph
	 * @param resourceProvider Resource provider providing model elements for determining the impact set
	 * @return List of vertices that are affected by the uncertainties of the transpose flow graph
	 */
	List<? extends AbstractVertex<?>> getImpactSet(ResourceProvider resourceProvider);

	/**
	 * Returns the uncertain state contained in the transpose flow graph
	 * @return Returns the uncertain state of the uncertain transpose flow graph
	 */
	UncertainState getUncertainState();

	/**
	 * Returns the list of uncertainty sources that are relevant for the uncertain transpose flow graph
	 * @return Returns a list of all relevant uncertainty sources to the transpose flow graph
	 */
	List<? extends UncertaintySource> getRelevantUncertaintySources();
}
