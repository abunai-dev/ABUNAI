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

	private final DFDQueryHelper dfdQueryHelper;

	public UncertaintyDFDActionSequence(DFDActionSequence originalActionSequence,
			List<? extends DFDUncertaintySource> uncertaintySources) {
		super();

		this.originalActionSequence = originalActionSequence;
		this.dfdQueryHelper = new DFDQueryHelper(originalActionSequence);
		this.relevantUncertaintySources = filterRelevantUncertaintySources(uncertaintySources);
		this.alternativeActionSequenceMapping = createAlternativeActionSequences(this.originalActionSequence,
				this.relevantUncertaintySources);
	}

	@Override
	protected List<DFDUncertaintySource> filterRelevantUncertaintySources(
			List<? extends UncertaintySource> uncertaintySources) {

		return uncertaintySources.stream().map(DFDUncertaintySource.class::cast)
				.filter(it -> dfdQueryHelper.hasTargetNode(it)).toList();

		// TODO: Fix typo in DFDConnectorUncertaintySource.getTargetAssignement
	}

	@Override
	protected Map<UncertainState, ? extends DFDActionSequence> createAlternativeActionSequences(
			ActionSequence originalActionSequence, List<? extends UncertaintySource> relevantUncertaintySources) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionSequence getImpactSet() {
		// TODO: using DFDQueryHelper that yields candidate nodes of
		// an ActionSequence given an uncertainty source (then, get impact set is
		// straight forward)
		return null;
	}

}
