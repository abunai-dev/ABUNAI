package dev.abunai.confidentiality.analysis.dfd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dataflowanalysis.analysis.core.AbstractActionSequenceElement;
import org.dataflowanalysis.analysis.core.ActionSequence;
import org.dataflowanalysis.analysis.dfd.core.DFDActionSequence;
import org.dataflowanalysis.analysis.dfd.core.DFDActionSequenceElement;
import org.dataflowanalysis.dfd.datadictionary.Label;
import org.dataflowanalysis.dfd.dataflowdiagram.External;
import org.dataflowanalysis.dfd.dataflowdiagram.Node;
import org.dataflowanalysis.dfd.dataflowdiagram.Store;
import org.dataflowanalysis.dfd.dataflowdiagram.dataflowdiagramFactory;

import com.google.common.collect.Streams;

import dev.abunai.confidentiality.analysis.core.UncertainActionSequence;
import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.core.UncertaintyUtils;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDBehaviorUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDComponentUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDUncertaintySource;

public class UncertainDFDActionSequence extends UncertainActionSequence {

	private final DFDQueryHelper dfdQueryHelper;

	public UncertainDFDActionSequence(DFDActionSequence originalActionSequence,
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
	}

	@SuppressWarnings("unchecked") // FIXME: Will be solved after updating to v2 of the data flow analysis
	@Override
	public ActionSequence getImpactSet() {
		List<Node> targetNodes = this.relevantUncertaintySources.stream()
				.map(it -> dfdQueryHelper.findTargetNodes((DFDUncertaintySource) it)).flatMap(List::stream).toList();

		List<? extends AbstractActionSequenceElement<?>> longestAffectedElementList = this.getOriginalActionSequence()
				.getElements().stream().map(DFDActionSequenceElement.class::cast)
				.dropWhile(it -> !targetNodes.contains(it.getNode())).map(it -> (AbstractActionSequenceElement<?>) it)
				.toList();

		return new DFDActionSequence((List<AbstractActionSequenceElement<?>>) longestAffectedElementList);
	}

	@Override
	protected Map<UncertainState, ? extends DFDActionSequence> createAlternativeActionSequences(
			ActionSequence originalActionSequence, List<? extends UncertaintySource> relevantUncertaintySources) {

		List<UncertainState> allStates = UncertainState.createAllUncertainStates(relevantUncertaintySources);

		Map<UncertainState, DFDActionSequence> result = new HashMap<>();

		for (UncertainState state : allStates) {
			result.put(state, applyUncertaintyScenarios((DFDActionSequence) originalActionSequence,
					state.getSelectedUncertaintyScenarios()));
		}

		return result;
	}

	private DFDActionSequence applyUncertaintyScenarios(DFDActionSequence originalActionSequence,
			List<? extends UncertaintyScenario> uncertaintyScenarios) {
		DFDActionSequence processedActionSequence = originalActionSequence;

		for (UncertaintyScenario uncertaintyScenario : uncertaintyScenarios) {
			processedActionSequence = applyUncertaintyScenario(processedActionSequence, uncertaintyScenario);
		}

		return processedActionSequence;
	}

	private DFDActionSequence applyUncertaintyScenario(DFDActionSequence actionSequence,
			UncertaintyScenario uncertaintyScenario) {
		if (uncertaintyScenario instanceof DFDExternalUncertaintyScenario castedScenario) {
			return applyExternalUncertaintyScenario(actionSequence, castedScenario);
		} else if (uncertaintyScenario instanceof DFDBehaviorUncertaintyScenario castedScenario) {
			return applyBehaviorUncertaintyScenario(actionSequence, castedScenario);
		} else if (uncertaintyScenario instanceof DFDInterfaceUncertaintyScenario castedScenario) {
			return applyInterfaceUncertaintyScenario(actionSequence, castedScenario);
		} else if (uncertaintyScenario instanceof DFDConnectorUncertaintyScenario castedScenario) {
			return applyConnectorUncertaintyScenario(actionSequence, castedScenario);
		} else if (uncertaintyScenario instanceof DFDComponentUncertaintyScenario castedScenario) {
			return applyComponentUncertaintyScenario(actionSequence, castedScenario);
		} else {
			throw new IllegalArgumentException("Unexpected DFD uncertainty scenario: %s"
					.formatted(UncertaintyUtils.getUncertaintyScenarioName(uncertaintyScenario)));
		}
	}

	private DFDActionSequence applyExternalUncertaintyScenario(DFDActionSequence actionSequence,
			DFDExternalUncertaintyScenario uncertaintyScenario) {

		DFDExternalUncertaintySource uncertaintySource = (DFDExternalUncertaintySource) uncertaintyScenario
				.eContainer();
		Node target = uncertaintySource.getTarget();
		Node targetCopy;

		if (target instanceof External) {
			targetCopy = dataflowdiagramFactory.eINSTANCE.createExternal();
		} else if (target instanceof Process) {
			targetCopy = dataflowdiagramFactory.eINSTANCE.createProcess();
		} else if (target instanceof Store) {
			targetCopy = dataflowdiagramFactory.eINSTANCE.createStore();
		} else {
			throw new IllegalArgumentException("Unexpected DFD node type.");
		}

		targetCopy.setEntityName(target.getEntityName());
		targetCopy.setBehaviour(target.getBehaviour());

		List<Label> filteredOldProperties = target.getProperties().stream()
				.filter(it -> uncertaintySource.getTargetProperties().contains(it)).toList();
		List<Label> newPropertiesToAdd = uncertaintyScenario.getTargetProperties();
		targetCopy.getProperties()
				.addAll(Streams.concat(filteredOldProperties.stream(), newPropertiesToAdd.stream()).toList());

		List<AbstractActionSequenceElement<?>> newElements = actionSequence.getElements().stream().map(it -> {
			if (it instanceof DFDActionSequenceElement castedElement && castedElement.getNode().equals(target)) {
				return new DFDActionSequenceElement(it.getAllDataFlowVariables(), it.getAllNodeCharacteristics(),
						castedElement.getName(), targetCopy, castedElement.getPreviousNode(), castedElement.getFlow());
			} else {
				return it;
			}
		}).toList();

		return new DFDActionSequence(newElements);
	}

	private DFDActionSequence applyBehaviorUncertaintyScenario(DFDActionSequence actionSequence,
			DFDBehaviorUncertaintyScenario uncertaintyScenario) {
		// TODO Auto-generated method stub
		throw new IllegalStateException("Not yet supported uncertainty type.");
	}

	private DFDActionSequence applyInterfaceUncertaintyScenario(DFDActionSequence actionSequence,
			DFDInterfaceUncertaintyScenario uncertaintyScenario) {
		// TODO Auto-generated method stub
		throw new IllegalStateException("Not yet supported uncertainty type.");
	}

	private DFDActionSequence applyConnectorUncertaintyScenario(DFDActionSequence actionSequence,
			DFDConnectorUncertaintyScenario uncertaintyScenario) {
		// TODO Auto-generated method stub
		throw new IllegalStateException("Not yet supported uncertainty type.");
	}

	private DFDActionSequence applyComponentUncertaintyScenario(DFDActionSequence actionSequence,
			DFDComponentUncertaintyScenario uncertaintyScenario) {
		// TODO Auto-generated method stub
		throw new IllegalStateException("Not yet supported uncertainty type.");
	}

}
