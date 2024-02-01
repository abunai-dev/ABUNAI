package dev.abunai.confidentiality.analysis.dfd;

import java.util.List;
import java.util.Optional;
import org.dataflowanalysis.analysis.dfd.DFDConfidentialityAnalysis;
import org.eclipse.core.runtime.Plugin;
import dev.abunai.confidentiality.analysis.UncertaintyAwareConfidentialityAnalysis;
import dev.abunai.confidentiality.analysis.core.UncertaintySourceManager;
import dev.abunai.confidentiality.analysis.core.UncertaintySourceType;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;

public class DFDUncertaintyAwareConfidentialityAnalysis extends DFDConfidentialityAnalysis
		implements UncertaintyAwareConfidentialityAnalysis {

	private UncertaintySourceManager uncertaintySourceManager;

	public DFDUncertaintyAwareConfidentialityAnalysis(DFDUncertaintyResourceProvider resourceProvider,
			Optional<Class<? extends Plugin>> modelProjectActivator, String modelProjectName) {
		super(resourceProvider, modelProjectActivator, modelProjectName);
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
	public boolean initializeAnalysis() {
		if (!super.initializeAnalysis()) {
			return false;
		} else {
			this.uncertaintySourceManager = new UncertaintySourceManager(
					this.getResourceProvider().getUncertaintySourceCollection(), UncertaintySourceType.DFD);
			return true;
		}
	}
}
