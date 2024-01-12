package dev.abunai.confidentiality.analysis.tests.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dataflowanalysis.pcm.extension.model.confidentiality.characteristics.EnumCharacteristic;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.NodeCharacteristicsPackage;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.RessourceAssignee;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.UsageAssignee;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.junit.jupiter.api.Test;
import org.palladiosimulator.pcm.repository.CompositeDataType;
import org.palladiosimulator.pcm.repository.OperationSignature;
import org.palladiosimulator.pcm.repository.Parameter;
import org.palladiosimulator.pcm.repository.PrimitiveDataType;
import org.palladiosimulator.pcm.repository.RepositoryPackage;
import org.palladiosimulator.pcm.repository.Signature;
import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF;
import org.palladiosimulator.pcm.seff.SeffPackage;
import org.palladiosimulator.pcm.seff.SetVariableAction;

import dev.abunai.confidentiality.analysis.tests.TestBase;

public class ElementLookupHelper extends TestBase {
	@Override
	protected String getFolderName() {
		return "BranchingOnlineShop";
	}

	@Override
	protected String getFilesName() {
		return "default";
	}

	@Test
	public void printAllRelevantElements() {
		printDivider("Node Characteristics Assignees", "External Uncertainty");
		printNodeCharacteristicsAssignees();

		printDivider("Set Variable Actions", "Behavior Uncertainty");
		printSetVariableActions();

		printDivider("Operation Signatures", "Interface Uncertainty");
		printOperationSignatures();

	}

	private void printDivider(String elementType, String uncertatintyType) {
		System.out.println("\n######################### %s (target of %s) #########################"
				.formatted(elementType.toUpperCase(), uncertatintyType.toLowerCase()));
	}

	private void printNodeCharacteristicsAssignees() {
		var resourceAssignees = findAllElementsOfType(NodeCharacteristicsPackage.eINSTANCE.getRessourceAssignee(),
				RessourceAssignee.class);
		var usageAssignees = findAllElementsOfType(NodeCharacteristicsPackage.eINSTANCE.getUsageAssignee(),
				UsageAssignee.class);

		for (var assignee : resourceAssignees) {
			System.out.println("%s - %s, %s (%s), [%s]".formatted(assignee.getId(), "Resource Assignee",
					assignee.getResourcecontainer().getEntityName(), assignee.getResourcecontainer().getId(),
					prettyPrintCharacteristics(assignee.getCharacteristics())));
		}

		for (var assignee : usageAssignees) {
			System.out.println("%s - %s, %s (%s), [%s]".formatted(assignee.getId(), "Usage Assignee",
					assignee.getUsagescenario().getEntityName(), assignee.getUsagescenario().getId(),
					prettyPrintCharacteristics(assignee.getCharacteristics())));
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

	private void printSetVariableActions() {
		var setVariableActions = findAllElementsOfType(SeffPackage.eINSTANCE.getSetVariableAction(),
				SetVariableAction.class);

		for (var action : setVariableActions) {
			var seff = findSEFFOfAction(action);
			System.out.println("%s - %s, %s.%s".formatted(action.getId(), action.getEntityName(),
					seff.getBasicComponent_ServiceEffectSpecification().getEntityName(),
					prettyPrintSignature(seff.getDescribedService__SEFF())));
		}

	}

	private ResourceDemandingSEFF findSEFFOfAction(SetVariableAction action) {
		EObject container = action.eContainer();

		while (container != null) {
			if (container instanceof ResourceDemandingSEFF seff) {
				return seff;
			} else {
				container = container.eContainer();
			}
		}
		
		return null;
	}
	
	private void printOperationSignatures() {
		var operationSignatures = findAllElementsOfType(RepositoryPackage.eINSTANCE.getOperationSignature(),
				OperationSignature.class);
		
		for (var signature : operationSignatures) {
			System.out.println("%s - %s.%s(%s)".formatted(signature.getId(), signature.getInterface__OperationSignature().getEntityName(), signature.getEntityName(), prettyPrintParameters(signature)));
		}
	}
	
	private String prettyPrintParameters(OperationSignature signature) {
		var result = new ArrayList<String>();
		
		for(var parameter : signature.getParameters__OperationSignature()) {
			var dataType = parameter.getDataType__Parameter();
			
			if(dataType instanceof CompositeDataType comp) {
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
