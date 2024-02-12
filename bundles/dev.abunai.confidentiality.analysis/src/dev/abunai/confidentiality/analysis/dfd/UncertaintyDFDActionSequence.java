package dev.abunai.confidentiality.analysis.dfd;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dataflowanalysis.analysis.core.ActionSequence;
import org.dataflowanalysis.analysis.dfd.core.DFDActionSequence;
import org.dataflowanalysis.analysis.dfd.core.DFDActionSequenceElement;
import org.dataflowanalysis.dfd.datadictionary.AbstractAssignment;
import org.dataflowanalysis.dfd.datadictionary.Behaviour;
import org.dataflowanalysis.dfd.datadictionary.Pin;
import org.dataflowanalysis.dfd.dataflowdiagram.Node;

import dev.abunai.confidentiality.analysis.core.UncertainActionSequence;
import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.core.UncertaintyUtils;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDBehaviorUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDComponentUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDUncertaintySource;

public class UncertaintyDFDActionSequence extends UncertainActionSequence {

	public UncertaintyDFDActionSequence(DFDActionSequence originalActionSequence,
			List<? extends DFDUncertaintySource> uncertaintySources) {
		super(originalActionSequence, uncertaintySources);
	}

	@Override
	protected List<UncertaintySource> filterRelevantUncertaintySources(
			List<? extends UncertaintySource> uncertaintySources) {

		List<UncertaintySource> listOfRelevantSources = new ArrayList<>();

		// TODO: Restructure this using a DFDNodeFinder that yields candidate nodes of
		// an ActionSequence given an uncertainty source (then, get impact set is
		// straight forward)
		for (UncertaintySource source : uncertaintySources) {
			if (source instanceof DFDExternalUncertaintySource castedSource) {
				// TODO: Add equals comparison for properties
				Node target = castedSource.getTarget();
				List<Node> candidates = this.getOriginalActionSequence().getElements().stream()
						.map(DFDActionSequenceElement.class::cast).map(DFDActionSequenceElement::getNode)
						.filter(it -> it.equals(target)).toList();

				if (!candidates.isEmpty()) {
					listOfRelevantSources.add(castedSource);
				}

			} else if (source instanceof DFDBehaviorUncertaintySource castedSource) {
				// TODO: Add equals comparison for ...
				Behaviour target = castedSource.getTarget();
				List<Behaviour> candidates = this.getOriginalActionSequence().getElements().stream()
						.map(DFDActionSequenceElement.class::cast).map(DFDActionSequenceElement::getNode)
						.map(Node::getBehaviour).filter(it -> it.equals(target)).toList();

				if (!candidates.isEmpty()) {
					listOfRelevantSources.add(castedSource);
				}

			} else if (source instanceof DFDInterfaceUncertaintySource castedSource) {
				// TODO: Add equals comparison for flows to make sure that the node really is
				// correct
				Pin target = castedSource.getTargetInPin();
				List<Pin> candidates = this.getOriginalActionSequence().getElements().stream()
						.map(DFDActionSequenceElement.class::cast).map(DFDActionSequenceElement::getNode)
						.map(Node::getBehaviour).map(Behaviour::getInPin).flatMap(List::stream)
						.filter(it -> it.equals(target)).toList();

				if (!candidates.isEmpty()) {
					listOfRelevantSources.add(castedSource);
				}

			} else if (source instanceof DFDConnectorUncertaintySource castedSource) {
				// TODO: Add equals comparison for ...
				AbstractAssignment target = castedSource.getTargetAssignement(); // TODO: Fix typo

				List<AbstractAssignment> candidates = this.getOriginalActionSequence().getElements().stream()
						.map(DFDActionSequenceElement.class::cast).map(DFDActionSequenceElement::getNode)
						.map(Node::getBehaviour).map(Behaviour::getAssignment).flatMap(List::stream)
						.filter(it -> it.equals(target)).toList();

				if (!candidates.isEmpty()) {
					listOfRelevantSources.add(castedSource);
				}

			} else if (source instanceof DFDComponentUncertaintySource castedSource) {
				// TODO: Remove code duplication once this method (and its PCM counterpart) get
				// restructured
				Node target = castedSource.getTarget();
				List<Node> candidates = this.getOriginalActionSequence().getElements().stream()
						.map(DFDActionSequenceElement.class::cast).map(DFDActionSequenceElement::getNode)
						.filter(it -> it.equals(target)).toList();

				if (!candidates.isEmpty()) {
					listOfRelevantSources.add(castedSource);
				}

			} else {
				throw new IllegalArgumentException("Unsupported uncertainty source: %s."
						.formatted(UncertaintyUtils.getUncertaintySourceName(source)));
			}
		}

		return listOfRelevantSources;
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
