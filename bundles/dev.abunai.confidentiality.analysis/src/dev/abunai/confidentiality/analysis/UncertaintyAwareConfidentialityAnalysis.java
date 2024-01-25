package dev.abunai.confidentiality.analysis;

import org.dataflowanalysis.analysis.DataFlowConfidentialityAnalysis;
import org.dataflowanalysis.analysis.resource.ResourceProvider;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySourceCollection;

public interface UncertaintyAwareConfidentialityAnalysis extends DataFlowConfidentialityAnalysis {
	UncertaintySourceCollection getUncertaintySourceCollection();
	ResourceProvider getResourceProvider();
}
