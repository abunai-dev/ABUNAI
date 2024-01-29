package dev.abunai.confidentiality.analysis.dfd;

import java.util.Optional;

import org.dataflowanalysis.analysis.dfd.DFDConfidentialityAnalysis;
import org.eclipse.core.runtime.Plugin;

import dev.abunai.confidentiality.analysis.UncertaintyAwareConfidentialityAnalysis;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySourceCollection;

public class DFDUncertaintyAwareConfidentialityAnalysis extends DFDConfidentialityAnalysis
		implements UncertaintyAwareConfidentialityAnalysis {

	public DFDUncertaintyAwareConfidentialityAnalysis(DFDUncertaintyResourceProvider resourceProvider,
			Optional<Class<? extends Plugin>> modelProjectActivator, String modelProjectName) {
		super(resourceProvider, modelProjectActivator, modelProjectName);
	}

	@Override
	public UncertaintySourceCollection getUncertaintySourceCollection() {
		return this.getResourceProvider().getUncertaintySourceCollection();
	}

	@Override
	public DFDUncertaintyResourceProvider getResourceProvider() {
		return (DFDUncertaintyResourceProvider) resourceProvider;
	}

}
