package dev.abunai.confidentiality.analysis.dfd;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.dfd.DFDConfidentialityAnalysis;
import org.eclipse.core.runtime.Plugin;

import dev.abunai.confidentiality.analysis.UncertaintyAwareConfidentialityAnalysis;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySourceCollection;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDUncertaintySource;

public class DFDUncertaintyAwareConfidentialityAnalysis extends DFDConfidentialityAnalysis
		implements UncertaintyAwareConfidentialityAnalysis {

	private final Logger logger = Logger.getLogger(DFDUncertaintyAwareConfidentialityAnalysis.class);

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

	private boolean validateUncertaintySourceType() {
		return this.getUncertaintySourceCollection().getSources().stream().allMatch(it -> it instanceof DFDUncertaintySource);
	}

	@Override
	public boolean initializeAnalysis() {
		if (!super.initializeAnalysis()) {
			return false;
		} else if (!this.validateUncertaintySourceType()) {
			logger.error(
					"Mixed uncertainty source types. Only use DFD uncertainty sources in an uncertainty-aware DFD analysis.");
			return false;
		} else {
			return true;
		}
	}

}
