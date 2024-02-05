package dev.abunai.confidentiality.analysis.dfd;

import java.util.List;
import java.util.Map;

import org.dataflowanalysis.analysis.core.ActionSequence;
import org.dataflowanalysis.analysis.dfd.core.DFDActionSequence;

import dev.abunai.confidentiality.analysis.core.UncertainActionSequence;
import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDUncertaintySource;

public class UncertaintyDFDActionSequence extends UncertainActionSequence {

	public UncertaintyDFDActionSequence(DFDActionSequence originalActionSequence,
			List<? extends DFDUncertaintySource> uncertaintySources) {
		super(originalActionSequence, uncertaintySources);
	}

	@Override
	protected List<? extends DFDUncertaintySource> filterRelevantUncertaintySources(
			List<? extends UncertaintySource> uncertaintySources) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Map<UncertainState, ? extends DFDActionSequence> createAlternativeActionSequences(
			ActionSequence originalActionSequence, List<? extends UncertaintySource> relevantUncertaintySources) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionSequence getImpactSet() {
		// TODO Auto-generated method stub
		return null;
	}

}
