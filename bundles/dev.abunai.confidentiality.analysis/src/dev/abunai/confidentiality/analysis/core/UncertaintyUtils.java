package dev.abunai.confidentiality.analysis.core;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.List;

import dev.abunai.confidentiality.analysis.dfd.DFDQueryHelper;
import dev.abunai.confidentiality.analysis.dfd.DFDUncertainTransposeFlowGraph;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.*;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.*;
import dev.abunai.confidentiality.analysis.pcm.PCMQueryHelper;
import org.dataflowanalysis.analysis.core.AbstractTransposeFlowGraph;
import org.dataflowanalysis.analysis.dfd.core.DFDVertex;
import org.dataflowanalysis.analysis.pcm.core.AbstractPCMVertex;
import org.dataflowanalysis.analysis.pcm.core.seff.SEFFPCMVertex;
import org.dataflowanalysis.analysis.pcm.resource.PCMResourceProvider;
import org.dataflowanalysis.analysis.resource.ResourceProvider;
import org.dataflowanalysis.dfd.dataflowdiagram.Node;
import org.eclipse.emf.ecore.EStructuralFeature;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;
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
		String entityTypeAndName;
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
			return source.getTargetFlow().getDestinationPin().equals(scenario.getTargetInPin())
					&& source.getTargetFlow().getDestinationNode().equals(scenario.getTargetNode())
					&& source.getTargetFlow().getDestinationPin().equals(scenario.getTargetInPin());

		} else if (uncertaintySource instanceof DFDConnectorUncertaintySource source
				&& uncertaintyScenario instanceof DFDConnectorUncertaintyScenario scenario) {
			return source.getTargetAssignments().equals(scenario.getTargetAssignments())
					&& source.getTargetFlow().getDestinationNode().equals(scenario.getTargetNode())
					&& source.getTargetFlow().getDestinationPin().equals(scenario.getTargetPin());

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
		double sumOfAllProbabilities = scenarios.stream().mapToDouble(UncertaintyScenario::getProbability).sum();
		double probabilityOfDefaultScenario = 1.0 - sumOfAllProbabilities;

		if (sumOfAllProbabilities < 0) {
			probabilityOfDefaultScenario = -1.0;
		}


		String defaultScenarioEntityName = "Default Scenario";
		createDefaultScenario(uncertaintySource, probabilityOfDefaultScenario, defaultScenarioEntityName);
	}

	/**
	 * Creates the default scenario for an uncertainty source with the given probability and name
	 * <p/>
	 * If someone finds this source code and wonders whether I heard of OO: I do.
	 * But EMF-based MDSD is different. I prefer messy instance-of collections over
	 * dealing with injecting custom logic into EMF-generated code.
	 */
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
			scenario.setTargetNode(source.getTargetFlow().getDestinationNode());
			scenario.setTargetInPin(source.getTargetFlow().getDestinationPin());
			scenario.setProbability(probability);
			scenario.setEntityName(name);
			source.getScenarios().add(scenario);

		} else if (uncertaintySource instanceof DFDConnectorUncertaintySource source) {
			var scenario = DfdFactory.eINSTANCE.createDFDConnectorUncertaintyScenario();
			scenario.getTargetAssignments().addAll(source.getTargetAssignments());
			scenario.setTargetNode(source.getTargetFlow().getDestinationNode());
			scenario.setTargetPin(source.getTargetFlow().getDestinationPin());
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

	public static int compareApplicationOrder(AbstractTransposeFlowGraph transposeFlowGraph, ResourceProvider resourceProvider, UncertaintySource o1, UncertaintySource o2) {
		if (UncertaintyUtils.compareOrder(transposeFlowGraph, resourceProvider, o1, o2) != 0) {
			return UncertaintyUtils.compareOrder(transposeFlowGraph, resourceProvider, o1, o2);
		} else {
			return UncertaintyUtils.compareApplicationPrecedence(o1, o2);
		}
	}

	public static int compareOrder(AbstractTransposeFlowGraph transposeFlowGraph, ResourceProvider resourceProvider, UncertaintySource o1, UncertaintySource o2) {
		if (transposeFlowGraph instanceof DFDUncertainTransposeFlowGraph) {
			return UncertaintyUtils.compareOrderDFD(transposeFlowGraph, o1, o2);
		} else {
			return UncertaintyUtils.compareOrderPCM(transposeFlowGraph, (PCMResourceProvider) resourceProvider, o1, o2);
		}
	}

	public static int compareOrderDFD(AbstractTransposeFlowGraph transposeFlowGraph, UncertaintySource o1, UncertaintySource o2) {
		DFDQueryHelper dfdQueryHelper = new DFDQueryHelper(transposeFlowGraph.getVertices());

		List<DFDVertex> verticesO1 = getVerticesDFD(transposeFlowGraph, dfdQueryHelper, (DFDUncertaintySource) o1);
		List<DFDVertex> verticesO2 = getVerticesDFD(transposeFlowGraph, dfdQueryHelper, (DFDUncertaintySource) o2);

		DFDVertex min01 = verticesO1.get(0);
		for(DFDVertex dfdVertex : verticesO1) {
			if (dfdVertex.isSource()) {
				return 1;
			}
			if (getAllPredecessorsDFD(min01).contains(dfdVertex)) {
				min01 = dfdVertex;
			}
		}

		DFDVertex minO2 = verticesO2.get(0);
		for(DFDVertex dfdVertex : verticesO2) {
			if (dfdVertex.isSource()) {
				return -1;
			}
			if (getAllPredecessorsDFD(minO2).contains(dfdVertex)) {
				minO2 = dfdVertex;
			}
		}
		if(getAllPredecessorsDFD(min01).contains(minO2)) {
			return 1;
		} else {
			return -1;
		}
	}

	private static List<DFDVertex> getAllPredecessorsDFD(DFDVertex vertex) {
		List<DFDVertex> result = new ArrayList<>();
		Deque<DFDVertex> currentVertices = new ArrayDeque<>();
		currentVertices.push(vertex);
		while (!currentVertices.isEmpty()) {
			DFDVertex currentVertex = currentVertices.pop();
			result.addAll(currentVertex.getPinDFDVertexMap().values());
			currentVertices.addAll(currentVertex.getPinDFDVertexMap().values());
		}
		return result;
	}

	private static List<DFDVertex> getVerticesDFD(AbstractTransposeFlowGraph transposeFlowGraph, DFDQueryHelper dfdQueryHelper, DFDUncertaintySource uncertaintySource) {
		List<Node> nodes = dfdQueryHelper.findTargetNodes(uncertaintySource);
		return transposeFlowGraph.getVertices().stream()
				.filter(DFDVertex.class::isInstance)
				.map(DFDVertex.class::cast)
				.filter(it -> nodes.contains(it.getReferencedElement()))
				.toList();
	}

	public static int compareOrderPCM(AbstractTransposeFlowGraph transposeFlowGraph, PCMResourceProvider resourceProvider, UncertaintySource o1, UncertaintySource o2) {
		PCMQueryHelper pcmQueryHelper = new PCMQueryHelper(transposeFlowGraph.getVertices(), resourceProvider);

		List<? extends AbstractPCMVertex<?>> verticesO1 = getVerticesPCM(transposeFlowGraph, pcmQueryHelper, (PCMUncertaintySource) o1);
		List<? extends AbstractPCMVertex<?>> verticesO2 = getVerticesPCM(transposeFlowGraph, pcmQueryHelper, (PCMUncertaintySource) o2);

		AbstractPCMVertex<?> min01 = verticesO1.get(0);
		for(AbstractPCMVertex<?> pcmVertex : verticesO1) {
			if (pcmVertex.isSource()) {
				return 1;
			}
			if (getAllPredecessorsPCM(min01).contains(pcmVertex)) {
				min01 = pcmVertex;
			}
		}

		AbstractPCMVertex<?> minO2 = verticesO2.get(0);
		for(AbstractPCMVertex<?> pcmVertex : verticesO2) {
			if (pcmVertex.isSource()) {
				return -1;
			}
			if (getAllPredecessorsPCM(minO2).contains(pcmVertex)) {
				minO2 = pcmVertex;
			}
		}
		if(getAllPredecessorsPCM(min01).contains(minO2)) {
			return 1;
		} else {
			return -1;
		}
	}

	private static List<AbstractPCMVertex<?>> getAllPredecessorsPCM(AbstractPCMVertex<?> vertex) {
		List<AbstractPCMVertex<?>> result = new ArrayList<>();
		AbstractPCMVertex<?> currentVertex = vertex;
		while (!currentVertex.isSource()) {
			if (currentVertex.getPreviousElements().size() > 1) {
				currentVertex = currentVertex.getPreviousElements().stream()
						.filter(it -> it instanceof SEFFPCMVertex<?>)
						.findFirst().orElseThrow();
			} else {
				currentVertex = currentVertex.getPreviousElements().get(0);
			}
			result.add(currentVertex);
		}
		return result;
	}

	private static List<? extends AbstractPCMVertex<?>> getVerticesPCM(AbstractTransposeFlowGraph transposeFlowGraph, PCMQueryHelper pcmQueryHelper, PCMUncertaintySource uncertaintySource) {
		return pcmQueryHelper.findTargetNodes(uncertaintySource);
	}

	public static int compareApplicationPrecedence(UncertaintySource o1, UncertaintySource o2) {
		if (o1 instanceof DFDBehaviorUncertaintySource || o1 instanceof PCMBehaviorUncertaintySource) {
			return -1;
		} else if (o1 instanceof DFDExternalUncertaintySource || o1 instanceof PCMExternalUncertaintySource) {
			return -1;
		} else if(o1 instanceof DFDInterfaceUncertaintySource || o1 instanceof PCMInterfaceUncertaintySource) {
			if (o2 instanceof DFDBehaviorUncertaintySource || o2 instanceof PCMBehaviorUncertaintySource) {
				return 1;
			} else if(o2 instanceof DFDExternalUncertaintySource || o2 instanceof PCMExternalUncertaintySource) {
				return 1;
			} else {
				return -1;
			}
		} else if(o1 instanceof DFDConnectorUncertaintySource || o1 instanceof PCMConnectorUncertaintySource) {
			if (o2 instanceof DFDComponentUncertaintySource || o2 instanceof PCMComponentUncertaintySource) {
				return -1;
			} else {
				return 1;
			}
		} else {
			return 1;
		}
	}
}
