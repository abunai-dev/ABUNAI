package dev.abunai.confidentiality.analysis.evaluation.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.dataflowanalysis.analysis.utils.ResourceUtils;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.palladiosimulator.pcm.core.composition.AssemblyConnector;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.repository.OperationInterface;
import org.palladiosimulator.pcm.repository.OperationProvidedRole;
import org.palladiosimulator.pcm.repository.OperationSignature;
import org.palladiosimulator.pcm.seff.ExternalCallAction;
import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF;
import org.palladiosimulator.pcm.seff.SeffFactory;
import org.palladiosimulator.pcm.seff.SetVariableAction;
import org.palladiosimulator.pcm.seff.StartAction;
import org.palladiosimulator.pcm.seff.StopAction;

import dev.abunai.confidentiality.analysis.evaluation.AnalysisExecutor;
import dev.abunai.confidentiality.analysis.evaluation.factory.PCMModelFactory;
import dev.abunai.confidentiality.analysis.evaluation.result.ScalibilityParameter;
import dev.abunai.confidentiality.analysis.evaluation.result.ScalibilityTest;

public class CombinedUncertaintyTest extends ScalibilityTest {
	
	@Override
	public void run(ScalibilityParameter parameter, AnalysisExecutor analysisExecutor) {
		PCMModelFactory factory = new PCMModelFactory(
				ResourceUtils.createRelativePluginURI("models/CoronaWarnApp/default.usagemodel", "dev.abunai.confidentiality.analysis.evaluation.testmodels"),
				ResourceUtils.createRelativePluginURI("models/CoronaWarnApp/default.allocation", "dev.abunai.confidentiality.analysis.evaluation.testmodels"),
				ResourceUtils.createRelativePluginURI("models/CoronaWarnApp/default.nodecharacteristics", "dev.abunai.confidentiality.analysis.evaluation.testmodels"),
				ResourceUtils.createRelativePluginURI("models/CoronaWarnApp/default.uncertainty", "dev.abunai.confidentiality.analysis.evaluation.testmodels")
				);
		
		List<BasicComponent> components = factory.getRepository().getComponents__Repository().stream()
				.filter(BasicComponent.class::isInstance)
				.map(BasicComponent.class::cast)
				.toList();
		
		List<ResourceDemandingSEFF> seffs = components.stream()
				.map(BasicComponent::getServiceEffectSpecifications__BasicComponent)
				.flatMap(List::stream)
				.filter(ResourceDemandingSEFF.class::isInstance)
				.map(ResourceDemandingSEFF.class::cast)
				.toList();
		
		List<ExternalCallAction> targetCalls = seffs.stream()
				.map(ResourceDemandingSEFF::getSteps_Behaviour)
				.flatMap(List::stream)
				.filter(ExternalCallAction.class::isInstance)
				.map(ExternalCallAction.class::cast)
				.toList();
		
		List<SetVariableAction> targetActions = seffs.stream()
				.map(ResourceDemandingSEFF::getSteps_Behaviour)
				.flatMap(List::stream)
				.filter(SetVariableAction.class::isInstance)
				.map(SetVariableAction.class::cast)
				.toList();
		
		int elements = Math.min(targetCalls.size() + targetActions.size(), parameter.getModelSize());
		List<Integer> indexMapping = new ArrayList<>(targetCalls.size());
		for (int i = 0; i < targetCalls.size(); i++) {
			indexMapping.add(i);
		}
		Collections.shuffle(indexMapping, new Random(1337L));
		for (int i = 0; i < elements; i++) {
			int index = i / 2;
			if (i % 2 == 0) {
				this.handlePrimaryUncertainty(factory, index, indexMapping, targetActions);
			} else {
				this.handleSecondaryUncertainty(factory, index, indexMapping, targetCalls, components);
			}
		}
		super.runAnalysis(factory, parameter, analysisExecutor);	
		try {
			factory.saveModel();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void handlePrimaryUncertainty(PCMModelFactory factory,
			int index,
			List<Integer> indexMapping,
			List<SetVariableAction> targets) {
		SetVariableAction target = targets.get(indexMapping.get(index));
		
		SetVariableAction replacement = EcoreUtil.copy(target);
		replacement.setId(String.valueOf(UUID.randomUUID()));
		replacement.setPredecessor_AbstractAction(null);
		replacement.setSuccessor_AbstractAction(null);
		replacement.getLocalVariableUsages_SetVariableAction().clear();
		target.getResourceDemandingBehaviour_AbstractAction().getSteps_Behaviour().add(replacement);
		
		factory.createBehaviorUncertainty(target, "generated", List.of(replacement), List.of("generatedAlternative"));
	}
	
	private void handleSecondaryUncertainty(PCMModelFactory factory, 
			int index,
			List<Integer> indexMapping,
			List<ExternalCallAction> targetCalls, 
			List<BasicComponent> components) {
		ExternalCallAction target = targetCalls.get(indexMapping.get(index));
		OperationInterface targetInterface = target.getCalledService_ExternalService().getInterface__OperationSignature();
		BasicComponent callingComponent = (BasicComponent) target.eContainer().eContainer();
		AssemblyContext context = factory.getSystem().getConnectors__ComposedStructure().stream()
				.filter(AssemblyConnector.class::isInstance)
				.map(AssemblyConnector.class::cast)
				.filter(it -> it.getRequiringAssemblyContext_AssemblyConnector().getEncapsulatedComponent__AssemblyContext().equals(callingComponent))
				.filter(it -> it.getRequiredRole_AssemblyConnector().equals(target.getRole_ExternalService()))
				.map(it -> it.getProvidingAssemblyContext_AssemblyConnector())
				.findAny().orElseThrow();
		
		BasicComponent calledComponent = components.stream()
				.filter(it -> it.getServiceEffectSpecifications__BasicComponent().stream()
						.map(ResourceDemandingSEFF.class::cast)
						.anyMatch(seff -> seff.getDescribedService__SEFF().equals(target.getCalledService_ExternalService())))
				.filter(it -> it.getProvidedRoles_InterfaceProvidingEntity().stream()
						.map(OperationProvidedRole.class::cast)
						.anyMatch(pr -> pr.getProvidedInterface__OperationProvidedRole().equals(target.getRole_ExternalService().getRequiredInterface__OperationRequiredRole())))
				.filter(it -> context.getEncapsulatedComponent__AssemblyContext().equals(it))
				.findAny().orElseThrow();
		
		OperationSignature signature = EcoreUtil.copy(target.getCalledService_ExternalService());
		signature.setId(String.valueOf(UUID.randomUUID()));
		signature.setEntityName("Replacement" + signature.getEntityName());
		signature.setInterface__OperationSignature(targetInterface);
		targetInterface.getSignatures__OperationInterface().add(signature);
		
		ResourceDemandingSEFF replacementSEFF = SeffFactory.eINSTANCE.createResourceDemandingSEFF();
		replacementSEFF.setId(String.valueOf(UUID.randomUUID()));
		replacementSEFF.setBasicComponent_ServiceEffectSpecification(calledComponent);
		replacementSEFF.setDescribedService__SEFF(signature);
		calledComponent.getServiceEffectSpecifications__BasicComponent().add(replacementSEFF);
		
		StartAction start = SeffFactory.eINSTANCE.createStartAction();
		start.setId(String.valueOf(UUID.randomUUID()));
		replacementSEFF.getSteps_Behaviour().add(start);
		
		StopAction stop = SeffFactory.eINSTANCE.createStopAction();
		stop.setId(String.valueOf(UUID.randomUUID()));
		replacementSEFF.getSteps_Behaviour().add(stop);
		
		start.setSuccessor_AbstractAction(stop);
		stop.setPredecessor_AbstractAction(start);
		
		ExternalCallAction replacement = EcoreUtil.copy(target);
		replacement.setId(String.valueOf(UUID.randomUUID()));
		replacement.setPredecessor_AbstractAction(null);
		replacement.setSuccessor_AbstractAction(null);
		replacement.setCalledService_ExternalService(signature);
		replacement.setResourceDemandingBehaviour_AbstractAction(replacementSEFF);
		target.getResourceDemandingBehaviour_AbstractAction().getSteps_Behaviour().add(replacement);
		
		factory.createConnectorUncertainty(target, "generated", List.of(replacement), List.of("generatedAlternative"));
	}

	@Override
	public int getModelSize(int currentIndex) {
		if (currentIndex == 0) {
			return 1;
		}
		return 5 * currentIndex;
	}

	@Override
	public String getTestName() {
		return "SecondaryUncertaintyTest";
	}
}
