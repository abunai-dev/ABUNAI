package dev.abunai.confidentiality.analysis.core;

import java.util.List;
import org.eclipse.emf.ecore.EStructuralFeature;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDBehaviorUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDBehaviorUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDComponentUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDComponentUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdFactory;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMBehaviorUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMComponentUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInEntryLevelSystemCall;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInExternalCall;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySourceInResource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySourceInUsage;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMInterfaceUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmFactory;
import tools.mdsd.modelingfoundations.identifier.Entity;

public class UncertaintyUtils {

	@SuppressWarnings("unchecked")
	public static List<? extends UncertaintyScenario> getUncertaintyScenarios(UncertaintySource uncertaintySource) {

		String scenariosFeatureName = "scenarios";
		Object scenarios = uncertaintySource
				.eGet(uncertaintySource.eClass().getEStructuralFeature(scenariosFeatureName));

		if (scenarios instanceof List<?> scenarioList
				&& scenarioList.stream().allMatch(it -> it instanceof UncertaintyScenario)) {
			return (List<? extends UncertaintyScenario>) scenarios;
		} else {
			throw new IllegalStateException(
					"Meta model problem: All non-abstract uncertainty sources are expected to have a scenarios field.");
		}
	}

	public static String getUncertaintySourceName(UncertaintySource uncertaintySource) {
		return tryToGetNameOfTypeAndTarget(uncertaintySource);
	}

	public static String getUncertaintyScenarioName(UncertaintyScenario uncertaintyScenario) {
		return tryToGetNameOfTypeAndTarget(uncertaintyScenario);
	}

	private static String tryToGetNameOfTypeAndTarget(Entity entity) {
		String entityClassName = entity.getClass().getSimpleName().replace("Impl", "");

		String defaultEntityName = "aName";
		String entityTypeAndName = "";
		if (entity.getEntityName().equals(defaultEntityName)) {
			entityTypeAndName = "%s %s".formatted(entityClassName, entity.getId());
		} else {
			entityTypeAndName = "%s \"%s\"".formatted(entityClassName, entity.getEntityName());
		}

		String targetFeatureName = "target";
		EStructuralFeature feature = entity.eClass().getEStructuralFeature(targetFeatureName);

		if (feature != null
				&& entity.eGet(feature) instanceof org.palladiosimulator.pcm.core.entity.Entity targetFeature) {
			return "%s @ \"%s\"".formatted(entityTypeAndName, targetFeature.getEntityName());
		} else if (feature != null
				&& entity.eGet(feature) instanceof tools.mdsd.modelingfoundations.identifier.Entity targetFeature) {
			return "%s @ \"%s\"".formatted(entityTypeAndName, targetFeature.getEntityName());
		} else {
			// No try-harding at this point, YAGNI.
			return entityTypeAndName;
		}
	}

	public static boolean isDefaultScenario(UncertaintySource uncertaintySource,
			UncertaintyScenario uncertaintyScenario) {
		if (uncertaintySource instanceof PCMUncertaintySource) {
			String targetFeatureName = "target";

			Object sourceTarget = uncertaintySource
					.eGet(uncertaintySource.eClass().getEStructuralFeature(targetFeatureName));
			Object scenarioTarget = uncertaintyScenario
					.eGet(uncertaintyScenario.eClass().getEStructuralFeature(targetFeatureName));

			if (sourceTarget == null || scenarioTarget == null) {
				throw new IllegalStateException(
						"Meta model problem: All PCM uncertainty sources and scenarios are expected to have a target field.");
			}

			return sourceTarget.equals(scenarioTarget);
		} else if (uncertaintySource instanceof DFDExternalUncertaintySource source
				&& uncertaintyScenario instanceof DFDExternalUncertaintyScenario scenario) {
			return source.getTargetProperties().equals(scenario.getTargetProperties());

		} else if (uncertaintySource instanceof DFDBehaviorUncertaintySource source
				&& uncertaintyScenario instanceof DFDBehaviorUncertaintyScenario scenario) {
			return source.getTargetAssignments().equals(scenario.getTargetAssignments());

		} else if (uncertaintySource instanceof DFDInterfaceUncertaintySource source
				&& uncertaintyScenario instanceof DFDInterfaceUncertaintyScenario scenario) {
			return source.getTargetInPin().equals(scenario.getTargetInPin())
					&& source.getTargetFlow().equals(scenario.getTargetFlow());

		} else if (uncertaintySource instanceof DFDConnectorUncertaintySource source
				&& uncertaintyScenario instanceof DFDConnectorUncertaintyScenario scenario) {
			return source.getTargetAssignement().equals(scenario.getTargetAssignment())
					&& source.getTargetFlow().equals(scenario.getTargetFlow());

		} else if (uncertaintySource instanceof DFDComponentUncertaintySource source
				&& uncertaintyScenario instanceof DFDComponentUncertaintyScenario scenario) {
			return source.getTarget().equals(scenario.getTarget());

		} else {
			throw new IllegalArgumentException(
					"Unsupported uncertainty source: %s.".formatted(getUncertaintySourceName(uncertaintySource)));
		}
	}

	public static void addDefaultScenario(UncertaintySource uncertaintySource) {
		List<? extends UncertaintyScenario> scenarios = getUncertaintyScenarios(uncertaintySource);
		Double sumOfAllProbabilities = scenarios.stream().mapToDouble(UncertaintyScenario::getProbability).sum();
		Double probabilityOfDefaultScenario = 1.0 - sumOfAllProbabilities;

		if (sumOfAllProbabilities < 0) {
			probabilityOfDefaultScenario = -1.0;
		}

		// If someone finds this source code and wonders whether I heard of OO: I do.
		// But EMF-based MDSD is different. I prefer messy instance-of collections over
		// dealing with injecting custom logic into EMF-generated code.
		createDefaultScenario(uncertaintySource, probabilityOfDefaultScenario, "Default Scenario");
	}

	private static void createDefaultScenario(UncertaintySource uncertaintySource, Double probability, String name) {
		if (uncertaintySource instanceof PCMExternalUncertaintySourceInResource source) {
			var scenario = PcmFactory.eINSTANCE.createPCMExternalUncertaintyScenarioInResource();
			scenario.setTarget(source.getTarget());
			scenario.setProbability(probability);
			scenario.setEntityName(name);
			source.getScenarios().add(scenario);

		} else if (uncertaintySource instanceof PCMExternalUncertaintySourceInUsage source) {
			var scenario = PcmFactory.eINSTANCE.createPCMExternalUncertaintyScenarioInUsage();
			scenario.setTarget(source.getTarget());
			scenario.setProbability(probability);
			scenario.setEntityName(name);
			source.getScenarios().add(scenario);

		} else if (uncertaintySource instanceof PCMBehaviorUncertaintySource source) {
			var scenario = PcmFactory.eINSTANCE.createPCMBehaviorUncertaintyScenario();
			scenario.setTarget(source.getTarget());
			scenario.setProbability(probability);
			scenario.setEntityName(name);
			scenario.setEntityName(name);
			source.getScenarios().add(scenario);

		} else if (uncertaintySource instanceof PCMInterfaceUncertaintySource source) {
			var scenario = PcmFactory.eINSTANCE.createPCMInterfaceUncertaintyScenario();
			scenario.setTarget(source.getTarget());
			scenario.setProbability(probability);
			scenario.setEntityName(name);
			source.getScenarios().add(scenario);

		} else if (uncertaintySource instanceof PCMConnectorUncertaintySourceInExternalCall source) {
			var scenario = PcmFactory.eINSTANCE.createPCMConnectorUncertaintyScenarioInExternalCall();
			scenario.setTarget(source.getTarget());
			scenario.setProbability(probability);
			scenario.setEntityName(name);
			source.getScenarios().add(scenario);

		} else if (uncertaintySource instanceof PCMConnectorUncertaintySourceInEntryLevelSystemCall source) {
			var scenario = PcmFactory.eINSTANCE.createPCMConnectorUncertaintyScenarioInEntryLevelSystemCall();
			scenario.setTarget(source.getTarget());
			scenario.setProbability(probability);
			scenario.setEntityName(name);
			source.getScenarios().add(scenario);

		} else if (uncertaintySource instanceof PCMComponentUncertaintySource source) {
			var scenario = PcmFactory.eINSTANCE.createPCMComponentUncertaintyScenario();
			scenario.setTarget(source.getTarget());
			scenario.setProbability(probability);
			scenario.setEntityName(name);
			source.getScenarios().add(scenario);

		} else if (uncertaintySource instanceof DFDExternalUncertaintySource source) {
			var scenario = DfdFactory.eINSTANCE.createDFDExternalUncertaintyScenario();
			scenario.getTargetProperties().addAll(source.getTargetProperties());
			scenario.setProbability(probability);
			scenario.setEntityName(name);
			source.getScenarios().add(scenario);

		} else if (uncertaintySource instanceof DFDBehaviorUncertaintySource source) {
			var scenario = DfdFactory.eINSTANCE.createDFDBehaviorUncertaintyScenario();
			scenario.getTargetAssignments().addAll(source.getTargetAssignments());
			scenario.setProbability(probability);
			scenario.setEntityName(name);
			source.getScenarios().add(scenario);

		} else if (uncertaintySource instanceof DFDInterfaceUncertaintySource source) {
			var scenario = DfdFactory.eINSTANCE.createDFDInterfaceUncertaintyScenario();
			scenario.setTargetFlow(source.getTargetFlow());
			scenario.setTargetInPin(source.getTargetInPin());
			scenario.setProbability(probability);
			scenario.setEntityName(name);
			source.getScenarios().add(scenario);

		} else if (uncertaintySource instanceof DFDConnectorUncertaintySource source) {
			var scenario = DfdFactory.eINSTANCE.createDFDConnectorUncertaintyScenario();
			scenario.setTargetAssignment(source.getTargetAssignement());
			scenario.setTargetFlow(source.getTargetFlow());
			scenario.setProbability(probability);
			scenario.setEntityName(name);
			source.getScenarios().add(scenario);

		} else if (uncertaintySource instanceof DFDComponentUncertaintySource source) {
			var scenario = DfdFactory.eINSTANCE.createDFDComponentUncertaintyScenario();
			scenario.setTarget(source.getTarget());
			scenario.setProbability(probability);
			scenario.setEntityName(name);
			source.getScenarios().add(scenario);

		}
	}

}
