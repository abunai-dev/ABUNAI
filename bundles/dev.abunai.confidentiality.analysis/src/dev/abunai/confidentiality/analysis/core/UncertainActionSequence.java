package dev.abunai.confidentiality.analysis.core;

import java.util.List;
import java.util.Map;

import org.dataflowanalysis.analysis.core.ActionSequence;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;

public abstract class UncertainActionSequence {

	protected List<? extends UncertaintySource> relevantUncertaintySources;
	protected ActionSequence originalActionSequence;
	protected Map<UncertainState, ? extends ActionSequence> alternativeActionSequenceMapping;

	public UncertainActionSequence(ActionSequence originalActionSequence,
			List<? extends UncertaintySource> uncertaintySources) {
		this.originalActionSequence = originalActionSequence;
		this.relevantUncertaintySources = filterRelevantUncertaintySources(uncertaintySources);
		this.alternativeActionSequenceMapping = createAlternativeActionSequences(this.originalActionSequence,
				this.relevantUncertaintySources);
	}

	protected UncertainActionSequence() {
	}

	protected abstract List<? extends UncertaintySource> filterRelevantUncertaintySources(
			List<? extends UncertaintySource> uncertaintySources);

	protected abstract Map<UncertainState, ? extends ActionSequence> createAlternativeActionSequences(
			ActionSequence originalActionSequence, List<? extends UncertaintySource> relevantUncertaintySources);

	public abstract ActionSequence getImpactSet();

	public List<? extends UncertaintySource> getRelevantUncertaintySources() {
		return List.copyOf(relevantUncertaintySources);
	}

	public ActionSequence getOriginalActionSequence() {
		return this.originalActionSequence;
	}

	public List<? extends ActionSequence> getAlternativeActionSequences() {
		return this.alternativeActionSequenceMapping.values().stream().toList();
	}

	public Map<UncertainState, ? extends ActionSequence> getScenarioToActionSequenceMapping() {
		return Map.copyOf(alternativeActionSequenceMapping);
	}

	// FIXME: This violates the encapsulation but is required to use the DFA v1
	public void setScenarioToActionSequenceMapping(Map<UncertainState, ? extends ActionSequence> mapping) {
		this.alternativeActionSequenceMapping = mapping;
	}

}
