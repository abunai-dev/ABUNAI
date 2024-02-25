package dev.abunai.confidentiality.analysis;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.dataflowanalysis.analysis.DataFlowConfidentialityAnalysis;
import org.dataflowanalysis.analysis.core.AbstractActionSequenceElement;
import org.dataflowanalysis.analysis.resource.ResourceProvider;

import dev.abunai.confidentiality.analysis.core.UncertainActionSequence;
import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;

public interface UncertaintyAwareConfidentialityAnalysis extends DataFlowConfidentialityAnalysis {
	List<UncertaintySource> getUncertaintySources();

	ResourceProvider getResourceProvider();

	List<? extends UncertainActionSequence> findAllUncertainSequences();
	
	List<? extends UncertainActionSequence> evaluateUncertainDataFlows(List<? extends UncertainActionSequence> sequences);
	
	Map<UncertainState, List<AbstractActionSequenceElement<?>>> queryUncertainDataFlow(UncertainActionSequence sequence,
			Predicate<? super AbstractActionSequenceElement<?>> condition);
}
