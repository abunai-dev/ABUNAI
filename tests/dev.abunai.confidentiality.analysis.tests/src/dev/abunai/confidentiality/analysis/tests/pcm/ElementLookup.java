package dev.abunai.confidentiality.analysis.tests.pcm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dataflowanalysis.analysis.pcm.utils.PCMQueryUtils;
import org.dataflowanalysis.pcm.extension.model.confidentiality.characteristics.EnumCharacteristic;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.NodeCharacteristicsPackage;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.ResourceAssignee;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.UsageAssignee;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.CompositionPackage;
import org.palladiosimulator.pcm.repository.CompositeDataType;
import org.palladiosimulator.pcm.repository.OperationProvidedRole;
import org.palladiosimulator.pcm.repository.OperationSignature;
import org.palladiosimulator.pcm.repository.Parameter;
import org.palladiosimulator.pcm.repository.PrimitiveDataType;
import org.palladiosimulator.pcm.repository.RepositoryPackage;
import org.palladiosimulator.pcm.repository.Signature;
import org.palladiosimulator.pcm.seff.ExternalCallAction;
import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF;
import org.palladiosimulator.pcm.seff.SeffPackage;
import org.palladiosimulator.pcm.seff.SetVariableAction;
import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;
import org.palladiosimulator.pcm.usagemodel.UsageScenario;
import org.palladiosimulator.pcm.usagemodel.UsagemodelPackage;

import dev.abunai.confidentiality.analysis.tests.PCMTestBase;

public class ElementLookup extends PCMTestBase {
	@Override
	protected String getFolderName() {
		return "CoronaWarnApp";
	}

	@Override
	protected String getFilesName() {
		return "default";
	}

	@Override
	protected String getBaseFolder() {
		return "casestudies/CaseStudy-CoronaWarnApp";
	}

	@Disabled("Test case needs to be repaired")
	@Test
	public void printAllRelevantElements() {
		printDivider("Node Characteristics Assignees", "External Uncertainty");
		printNodeCharacteristicsAssignees();

		printDivider("Set Variable Actions", "Behavior Uncertainty");
		printSetVariableActions();

		printDivider("Operation Signatures", "Interface Uncertainty");
		printOperationSignatures();

		printDivider("External Calls and Entry Level System Calls", "Connector Uncertainty");
		printExternalCallsAndEntryLevelSystemCalls();

		printDivider("Assembly Contexts", "Component Uncertainty");
		printAssemblyContexts();
	}

	private void printDivider(String elementType, String uncertatintyType) {
		System.out.println("\n######################### %s (annotatable with %s) #########################"
				.formatted(elementType.toUpperCase(), uncertatintyType.toLowerCase()));
	}

	private void printNodeCharacteristicsAssignees() {
		var resourceAssignees = findAllElementsOfType(NodeCharacteristicsPackage.eINSTANCE.getResourceAssignee(),
				ResourceAssignee.class);
		var usageAssignees = findAllElementsOfType(NodeCharacteristicsPackage.eINSTANCE.getUsageAssignee(),
				UsageAssignee.class);

		for (var assignee : resourceAssignees) {
			System.out.println("%s - %s, %s, [%s]".formatted(assignee.getId(), "Resource Assignee",
					assignee.getResourcecontainer().getEntityName(),
					prettyPrintCharacteristics(assignee.getCharacteristics())));
		}

		for (var assignee : usageAssignees) {
			System.out.println("%s - %s, %s, [%s]".formatted(assignee.getId(), "Usage Assignee",
					assignee.getUsagescenario().getEntityName(),
					prettyPrintCharacteristics(assignee.getCharacteristics())));
		}
	}

	private void printSetVariableActions() {
		var setVariableActions = findAllElementsOfType(SeffPackage.eINSTANCE.getSetVariableAction(),
				SetVariableAction.class);

		for (var action : setVariableActions) {
			var seff = PCMQueryUtils.findParentOfType(action, ResourceDemandingSEFF.class, false).get();
			System.out.println("%s - %s, %s.%s".formatted(action.getId(), action.getEntityName(),
					seff.getBasicComponent_ServiceEffectSpecification().getEntityName(),
					prettyPrintSignature(seff.getDescribedService__SEFF())));
		}

	}

	private void printOperationSignatures() {
		var operationSignatures = findAllElementsOfType(RepositoryPackage.eINSTANCE.getOperationSignature(),
				OperationSignature.class);

		for (var signature : operationSignatures) {
			System.out.println("%s - %s.%s(%s)".formatted(signature.getId(),
					signature.getInterface__OperationSignature().getEntityName(), signature.getEntityName(),
					prettyPrintParameters(signature)));
		}
	}

	private void printExternalCallsAndEntryLevelSystemCalls() {
		var externalCalls = findAllElementsOfType(SeffPackage.eINSTANCE.getExternalCallAction(),
				ExternalCallAction.class);
		var entryLevelSystemCalls = findAllElementsOfType(UsagemodelPackage.eINSTANCE.getEntryLevelSystemCall(),
				EntryLevelSystemCall.class);

		for (var externalCall : externalCalls) {
			var seff = PCMQueryUtils.findParentOfType(externalCall, ResourceDemandingSEFF.class, false).get();
			var calledSignature = externalCall.getCalledService_ExternalService();
			System.out.println("%s - ExternalCallAction, %s, %s.%s -> %s.%s(%s)".formatted(externalCall.getId(),
					externalCall.getEntityName(), seff.getBasicComponent_ServiceEffectSpecification().getEntityName(),
					prettyPrintSignature(seff.getDescribedService__SEFF()),
					calledSignature.getInterface__OperationSignature().getEntityName(), calledSignature.getEntityName(),
					calledSignature.getParameters__OperationSignature().stream().map(Parameter::getParameterName)
							.collect(Collectors.joining(", "))));
		}

		for (var entryLevelCall : entryLevelSystemCalls) {
			var scenario = PCMQueryUtils.findParentOfType(entryLevelCall, UsageScenario.class, false).get();
			var calledSignature = entryLevelCall.getOperationSignature__EntryLevelSystemCall();
			System.out.println("%s - EntryLevelSystemCall, %s, %s -> %s.%s(%s)".formatted(entryLevelCall.getId(),
					entryLevelCall.getEntityName(), scenario.getEntityName(),
					calledSignature.getInterface__OperationSignature().getEntityName(), calledSignature.getEntityName(),
					calledSignature.getParameters__OperationSignature().stream().map(Parameter::getParameterName)
							.collect(Collectors.joining(", "))));
		}
	}

	private void printAssemblyContexts() {
		var contexts = findAllElementsOfType(CompositionPackage.eINSTANCE.getAssemblyContext(), AssemblyContext.class);

		for (var context : contexts) {
			var component = context.getEncapsulatedComponent__AssemblyContext();
			System.out.println("%s - %s, %s -> [%s]".formatted(context.getId(), context.getEntityName(),
					component.getEntityName(),
					component.getProvidedRoles_InterfaceProvidingEntity().stream()
							.filter(OperationProvidedRole.class::isInstance).map(OperationProvidedRole.class::cast)
							.map(it -> it.getProvidedInterface__OperationProvidedRole().getEntityName())
							.collect(Collectors.joining(", "))));
		}
	}

	private String prettyPrintCharacteristics(List<EnumCharacteristic> characteristics) {
		var result = new ArrayList<String>();

		for (var characteristic : characteristics) {
			for (var value : characteristic.getValues()) {
				result.add("%s.%s".formatted(characteristic.getType().getName(), value.getName()));
			}
		}

		return String.join(", ", result);
	}

	private String prettyPrintParameters(OperationSignature signature) {
		var result = new ArrayList<String>();

		for (var parameter : signature.getParameters__OperationSignature()) {
			var dataType = parameter.getDataType__Parameter();

			if (dataType instanceof CompositeDataType comp) {
				result.add("%s %s".formatted(comp.getEntityName(), parameter.getParameterName()));
			} else if (dataType instanceof PrimitiveDataType prim) {
				result.add("%s %s".formatted(prim.getType().getName(), parameter.getParameterName()));
			} else {
				result.add(parameter.getParameterName());
			}
		}

		return String.join(", ", result);
	}

	private String prettyPrintSignature(Signature signature) {
		if (signature instanceof OperationSignature opSignature) {
			return "%s(%s)".formatted(opSignature.getEntityName(), opSignature.getParameters__OperationSignature()
					.stream().map(Parameter::getParameterName).collect(Collectors.joining(", ")));
		} else {
			return "%s()".formatted(signature.getEntityName());
		}
	}

	private <T> List<T> findAllElementsOfType(EClass targetType, Class<T> targetClass) {
		ArrayList<EObject> result = new ArrayList<EObject>();

		// This has a cubic runtime but it is also not part of the actual analysis :)
		while (true) {
			var element = analysis.getResourceProvider()
					.lookupElementWithCondition(it -> it.eClass().equals(targetType) && !result.contains(it));

			if (element.isPresent()) {
				result.add(element.get());
			} else {
				break;
			}
		}

		return result.stream().filter(targetClass::isInstance).map(targetClass::cast).toList();
	}
}
