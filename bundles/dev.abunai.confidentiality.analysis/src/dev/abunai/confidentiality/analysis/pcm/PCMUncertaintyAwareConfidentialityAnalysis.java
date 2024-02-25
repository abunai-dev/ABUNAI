package dev.abunai.confidentiality.analysis.pcm;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import org.dataflowanalysis.analysis.core.AbstractActionSequenceElement;
import org.dataflowanalysis.analysis.core.DataCharacteristicsCalculatorFactory;
import org.dataflowanalysis.analysis.core.NodeCharacteristicsCalculator;
import org.dataflowanalysis.analysis.pcm.PCMDataFlowConfidentialityAnalysis;
import org.eclipse.core.runtime.Plugin;

import dev.abunai.confidentiality.analysis.UncertaintyAwareConfidentialityAnalysis;
import dev.abunai.confidentiality.analysis.core.UncertainActionSequence;
import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.core.UncertaintySourceManager;
import dev.abunai.confidentiality.analysis.core.UncertaintySourceType;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;

public class PCMUncertaintyAwareConfidentialityAnalysis extends PCMDataFlowConfidentialityAnalysis
		implements UncertaintyAwareConfidentialityAnalysis {

	private UncertaintySourceManager uncertaintySourceManager;

	public PCMUncertaintyAwareConfidentialityAnalysis(NodeCharacteristicsCalculator nodeCharacteristicsCalculator,
			DataCharacteristicsCalculatorFactory dataCharacteristicsCalculatorFactory,
			PCMUncertaintyResourceProvider resourceProvider, String modelProjectName,
			Optional<Class<? extends Plugin>> modelProjectActivator) {
		super(nodeCharacteristicsCalculator, dataCharacteristicsCalculatorFactory, resourceProvider, modelProjectName,
				modelProjectActivator);
	}

	@Override
	public PCMUncertaintyResourceProvider getResourceProvider() {
		return (PCMUncertaintyResourceProvider) resourceProvider;
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
					this.getResourceProvider().getUncertaintySourceCollection(), UncertaintySourceType.PCM);
			return true;
		}
	}

	@Override
	public List<? extends UncertainActionSequence> findAllUncertainSequences() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends UncertainActionSequence> evaluateUncertainDataFlows(
			List<? extends UncertainActionSequence> sequences) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<UncertainState, List<AbstractActionSequenceElement<?>>> queryUncertainDataFlow(
			UncertainActionSequence sequence, Predicate<? super AbstractActionSequenceElement<?>> condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
