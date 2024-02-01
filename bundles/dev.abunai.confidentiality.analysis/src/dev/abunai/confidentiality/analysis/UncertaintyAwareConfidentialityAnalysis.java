package dev.abunai.confidentiality.analysis;

import java.util.List;

import org.dataflowanalysis.analysis.DataFlowConfidentialityAnalysis;
import org.dataflowanalysis.analysis.resource.ResourceProvider;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;

public interface UncertaintyAwareConfidentialityAnalysis extends DataFlowConfidentialityAnalysis {
	List<UncertaintySource> getUncertaintySources();

	ResourceProvider getResourceProvider();
}
