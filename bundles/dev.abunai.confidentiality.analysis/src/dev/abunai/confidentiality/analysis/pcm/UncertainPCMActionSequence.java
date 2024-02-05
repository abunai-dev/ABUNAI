package dev.abunai.confidentiality.analysis.pcm;

import java.util.List;
import java.util.Map;

import org.dataflowanalysis.analysis.core.ActionSequence;
import org.dataflowanalysis.analysis.pcm.core.PCMActionSequence;

import dev.abunai.confidentiality.analysis.core.UncertainActionSequence;
import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMUncertaintySource;

public class UncertainPCMActionSequence extends UncertainActionSequence {

	public UncertainPCMActionSequence(PCMActionSequence originalActionSequence,
			List<? extends PCMUncertaintySource> uncertaintySources) {
		super(originalActionSequence, uncertaintySources);
	}

	@Override
	protected List<? extends PCMUncertaintySource> filterRelevantUncertaintySources(
			List<? extends UncertaintySource> uncertaintySources) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Map<UncertainState, PCMActionSequence> createAlternativeActionSequences(
			ActionSequence originalActionSequence, List<? extends UncertaintySource> relevantUncertaintySources) {
		// TODO Auto-generated method stub
		return null;
	}

}
