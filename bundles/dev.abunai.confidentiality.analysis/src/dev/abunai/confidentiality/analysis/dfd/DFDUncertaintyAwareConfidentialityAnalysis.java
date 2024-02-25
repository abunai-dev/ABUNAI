package dev.abunai.confidentiality.analysis.dfd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import org.dataflowanalysis.analysis.core.AbstractActionSequenceElement;
import org.dataflowanalysis.analysis.core.ActionSequence;
import org.dataflowanalysis.analysis.dfd.DFDConfidentialityAnalysis;
import org.dataflowanalysis.analysis.dfd.core.DFDActionSequence;
import org.dataflowanalysis.analysis.dfd.core.DFDCharacteristicsCalculator;
import org.eclipse.core.runtime.Plugin;
import dev.abunai.confidentiality.analysis.UncertaintyAwareConfidentialityAnalysis;
import dev.abunai.confidentiality.analysis.core.UncertainActionSequence;
import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.core.UncertaintySourceManager;
import dev.abunai.confidentiality.analysis.core.UncertaintySourceType;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDUncertaintySource;

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

	public List<UncertainDFDActionSequence> findAllUncertainSequences() {
		return this.findAllSequences().stream().map(it -> new UncertainDFDActionSequence((DFDActionSequence) it,
				this.getUncertaintySources().stream().map(DFDUncertaintySource.class::cast).toList())).toList();
	}

	@Override
	public List<UncertainDFDActionSequence> evaluateUncertainDataFlows(
			List<? extends UncertainActionSequence> sequences) {
		var castedSequences = sequences.stream().map(UncertainDFDActionSequence.class::cast).toList();

		for (var sequence : castedSequences) {
			Map<UncertainState, ? extends ActionSequence> mapping = sequence.getScenarioToActionSequenceMapping();
			Map<UncertainState, ActionSequence> evaluatedMapping = new HashMap<>();

			for (UncertainState state : mapping.keySet()) {
				ActionSequence dfdSequence = mapping.get(state);
				ActionSequence evaluatedDFDSequence = DFDCharacteristicsCalculator
						.fillDataFlowVariables((DFDActionSequence) dfdSequence);
				evaluatedMapping.put(state, evaluatedDFDSequence);
			}

			if (mapping.size() != evaluatedMapping.size()) {
				throw new IllegalStateException("Evaluated mapping differs in size.");
			}

			sequence.setScenarioToActionSequenceMapping(evaluatedMapping);
		}

		return castedSequences;
	}

	@Override
	public Map<UncertainState, List<AbstractActionSequenceElement<?>>> queryUncertainDataFlow(
			UncertainActionSequence sequence, Predicate<? super AbstractActionSequenceElement<?>> condition) {
		Map<UncertainState, List<AbstractActionSequenceElement<?>>> result = new HashMap<>();
		Map<UncertainState, ? extends ActionSequence> mapping = sequence.getScenarioToActionSequenceMapping();

		for (var state : mapping.keySet()) {
			ActionSequence dfdSequence = mapping.get(state);
			List<AbstractActionSequenceElement<?>> violations = this.queryDataFlow(dfdSequence, condition);
			result.put(state, violations);
		}

		return result;
	}

}
