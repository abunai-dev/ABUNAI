package dev.abunai.confidentiality.analysis.core;

import java.util.List;
import java.util.Map;

import org.dataflowanalysis.analysis.core.ActionSequence;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;

public abstract class UncertainActionSequence {

	protected final List<? extends UncertaintySource> relevantUncertaintySources;
	protected final ActionSequence originalActionSequence;
	protected final Map<UncertainState, ? extends ActionSequence> alternatieActionSequenceMapping;

	public UncertainActionSequence(ActionSequence originalActionSequence, List<? extends UncertaintySource> uncertaintySources) {
		this.originalActionSequence = originalActionSequence;
		this.relevantUncertaintySources = filterRelevantUncertaintySources(uncertaintySources);
		this.alternatieActionSequenceMapping = createAlternativeActionSequences(this.originalActionSequence,
				this.relevantUncertaintySources);
	}

	protected abstract List<? extends UncertaintySource> filterRelevantUncertaintySources(
	List<? extends UncertaintySource> uncertaintySources);

	protected abstract Map<UncertainState, ? extends ActionSequence> createAlternativeActionSequences(
			ActionSequence originalActionSequence, List<? extends UncertaintySource> relevantUncertaintySources);

	public List<? extends UncertaintySource> getRelevantUncertaintySources() {
		return relevantUncertaintySources;
	}

	public ActionSequence getOriginalActionSequence() {
		return this.originalActionSequence;
	}

	public List<? extends ActionSequence> getAlternativeActionSequences() {
		return this.alternatieActionSequenceMapping.values().stream().toList();
	}

	public Map<UncertainState, ? extends ActionSequence> getScenarioToActionSequenceMapping() {
		return alternatieActionSequenceMapping;
	}
}
