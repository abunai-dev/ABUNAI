package dev.abunai.confidentiality.analysis.pcm;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.dataflowanalysis.analysis.core.ActionSequence;
import org.dataflowanalysis.analysis.pcm.core.AbstractPCMActionSequenceElement;
import org.dataflowanalysis.analysis.pcm.core.PCMActionSequence;
import org.dataflowanalysis.analysis.pcm.core.seff.SEFFActionSequenceElement;
import org.dataflowanalysis.analysis.pcm.resource.PCMResourceProvider;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.OperationSignature;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.pcm.seff.ExternalCallAction;
import org.palladiosimulator.pcm.seff.SetVariableAction;
import org.palladiosimulator.pcm.seff.StartAction;
import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;
import org.palladiosimulator.pcm.usagemodel.UsageScenario;

import dev.abunai.confidentiality.analysis.core.UncertainActionSequence;
import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.core.UncertaintyUtils;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMBehaviorUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMComponentUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInEntryLevelSystemCall;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInExternalCall;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySourceInResource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySourceInUsage;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMInterfaceUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMUncertaintySource;
import dev.abunai.impact.analysis.util.PropagationHelper;

public class UncertainPCMActionSequence extends UncertainActionSequence {

	private final PropagationHelper propagationHelper;

	public UncertainPCMActionSequence(PCMActionSequence originalActionSequence,
			List<PCMUncertaintySource> uncertaintySources, PCMResourceProvider resourceProvider) {
		super();
		this.originalActionSequence = originalActionSequence;
		this.propagationHelper = new PropagationHelper(List.of(this.originalActionSequence), resourceProvider);
		this.relevantUncertaintySources = filterRelevantUncertaintySources(uncertaintySources);
		this.alternativeActionSequenceMapping = createAlternativeActionSequences(this.originalActionSequence,
				this.relevantUncertaintySources);
	}

	@Override
	protected List<UncertaintySource> filterRelevantUncertaintySources(
			List<? extends UncertaintySource> uncertaintySources) {

		List<UncertaintySource> listOfRelevantSources = new ArrayList<>();

		for (UncertaintySource source : uncertaintySources) {
			if (source instanceof PCMExternalUncertaintySourceInResource castedSource) {
				ResourceContainer target = castedSource.getTarget().getResourcecontainer();
				List<? extends AbstractPCMActionSequenceElement<?>> candidates = propagationHelper
						.findProcessesThatRepresentResourceContainerOrUsageScenario(target);

				if (!candidates.isEmpty()) {
					listOfRelevantSources.add(castedSource);
				}

			} else if (source instanceof PCMExternalUncertaintySourceInUsage castedSource) {
				UsageScenario target = castedSource.getTarget().getUsagescenario();
				List<? extends AbstractPCMActionSequenceElement<?>> candidates = propagationHelper
						.findProcessesThatRepresentResourceContainerOrUsageScenario(target);

				if (!candidates.isEmpty()) {
					listOfRelevantSources.add(castedSource);
				}

			} else if (source instanceof PCMBehaviorUncertaintySource castedSource) {
				SetVariableAction target = castedSource.getTarget();
				List<? extends AbstractPCMActionSequenceElement<?>> candidates = propagationHelper
						.findProccessesWithAction(target);

				if (!candidates.isEmpty()) {
					listOfRelevantSources.add(castedSource);
				}

			} else if (source instanceof PCMInterfaceUncertaintySource castedSource) {
				OperationSignature target = castedSource.getTarget();
				List<SEFFActionSequenceElement<StartAction>> candidates = propagationHelper
						.findStartActionsOfSEFFsThatImplement(target);

				if (!candidates.isEmpty()) {
					listOfRelevantSources.add(castedSource);
				}

			} else if (source instanceof PCMConnectorUncertaintySourceInExternalCall castedSource) {
				ExternalCallAction target = castedSource.getTarget();
				List<? extends AbstractPCMActionSequenceElement<?>> candidates = propagationHelper
						.findProccessesWithAction(target);

				if (!candidates.isEmpty()) {
					listOfRelevantSources.add(castedSource);
				}

			} else if (source instanceof PCMConnectorUncertaintySourceInEntryLevelSystemCall castedSource) {
				EntryLevelSystemCall target = castedSource.getTarget();
				List<? extends AbstractPCMActionSequenceElement<?>> candidates = propagationHelper
						.findProccessesWithAction(target);

				if (!candidates.isEmpty()) {
					listOfRelevantSources.add(castedSource);
				}

			} else if (source instanceof PCMComponentUncertaintySource castedSource) {
				AssemblyContext target = castedSource.getTarget();
				var candidates = propagationHelper.findStartActionsOfAssemblyContext(target);

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
	protected Map<UncertainState, PCMActionSequence> createAlternativeActionSequences(
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
