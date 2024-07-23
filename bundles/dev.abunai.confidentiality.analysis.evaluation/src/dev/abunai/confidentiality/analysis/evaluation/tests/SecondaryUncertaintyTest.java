package dev.abunai.confidentiality.analysis.evaluation.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.utils.ResourceUtils;
import org.dataflowanalysis.pcm.extension.dictionary.characterized.DataDictionaryCharacterized.EnumCharacteristicType;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.repository.Interface;
import org.palladiosimulator.pcm.repository.OperationInterface;
import org.palladiosimulator.pcm.repository.OperationProvidedRole;
import org.palladiosimulator.pcm.repository.OperationSignature;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.pcm.seff.ExternalCallAction;
import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF;
import org.palladiosimulator.pcm.seff.SetVariableAction;

import dev.abunai.confidentiality.analysis.evaluation.AnalysisExecutor;
import dev.abunai.confidentiality.analysis.evaluation.AnalysisUtils;
import dev.abunai.confidentiality.analysis.evaluation.factory.PCMModelFactory;
import dev.abunai.confidentiality.analysis.evaluation.factory.builder.AssemblyAllocationBuilder;
import dev.abunai.confidentiality.analysis.evaluation.factory.builder.CharacteristicBuilder;
import dev.abunai.confidentiality.analysis.evaluation.factory.builder.ComponentBuilder;
import dev.abunai.confidentiality.analysis.evaluation.factory.builder.InterfaceBuilder;
import dev.abunai.confidentiality.analysis.evaluation.factory.builder.dataflow.SEFFBuilder;
import dev.abunai.confidentiality.analysis.evaluation.factory.builder.dataflow.SEFFCharacteristicsBuilder;
import dev.abunai.confidentiality.analysis.evaluation.factory.builder.dataflow.UsageBuilder;
import dev.abunai.confidentiality.analysis.evaluation.factory.builder.dataflow.UsageCallBuilder;
import dev.abunai.confidentiality.analysis.evaluation.result.ScalibilityParameter;
import dev.abunai.confidentiality.analysis.evaluation.result.ScalibilityTest;
import dev.abunai.confidentiality.analysis.evaluation.testmodels.Activator;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintyScenarioInExternalCall;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInExternalCall;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMInterfaceUncertaintySource;

public class SecondaryUncertaintyTest extends ScalibilityTest {
private Logger logger = Logger.getLogger(SecondaryUncertaintyTest.class);
	
	@Override
	public void run(ScalibilityParameter parameter, AnalysisExecutor analysisExecutor) {
		PCMModelFactory factory = new PCMModelFactory(
				ResourceUtils.createRelativePluginURI("models/CoronaWarnApp/default.usagemodel", "dev.abunai.confidentiality.analysis.evaluation.testmodels"),
				ResourceUtils.createRelativePluginURI("models/CoronaWarnApp/default.allocation", "dev.abunai.confidentiality.analysis.evaluation.testmodels"),
				ResourceUtils.createRelativePluginURI("models/CoronaWarnApp/default.nodecharacteristics", "dev.abunai.confidentiality.analysis.evaluation.testmodels"),
				ResourceUtils.createRelativePluginURI("models/CoronaWarnApp/default.uncertainty", "dev.abunai.confidentiality.analysis.evaluation.testmodels")
				);
		List<List<ExternalCallAction>> uncertaintyElements = new ArrayList<>(parameter.getModelSize());
		BasicComponent targetComponent = factory.getRepository().getComponents__Repository().stream()
				.filter(BasicComponent.class::isInstance)
				.map(BasicComponent.class::cast)
				.filter(it -> it.getEntityName().equals("CoronaWarnAppServer"))
				.findFirst().orElseThrow();
		ResourceDemandingSEFF targetSEFF = targetComponent.getServiceEffectSpecifications__BasicComponent().stream()
				.filter(ResourceDemandingSEFF.class::isInstance)
				.map(ResourceDemandingSEFF.class::cast)
				.filter(it -> it.getId().equals("_zNxa8LLIEe2Y1pKtbIeM6Q"))
				.findFirst().orElseThrow();
		ExternalCallAction targetElement = targetSEFF.getSteps_Behaviour().stream()
				.filter(ExternalCallAction.class::isInstance)
				.map(ExternalCallAction.class::cast)
				.filter(it -> it.getId().equals("_zqW-0LmjEe2dIMSi7oNVYQ"))
				.findFirst().orElseThrow();
		uncertaintyElements.add(0, new ArrayList<>());
		uncertaintyElements.get(0).add(targetElement);
		OperationInterface targetInterface = factory.getRepository().getInterfaces__Repository().stream()
				.filter(OperationInterface.class::isInstance)
				.map(OperationInterface.class::cast)
				.filter(it -> it.getEntityName().equals("VerificationCWAServerInterface"))
				.findAny().orElseThrow();
		OperationSignature replacementSignature = targetInterface.getSignatures__OperationInterface().stream()
				.filter(it -> it.getEntityName().equals("brokenVerifyTAN"))
				.findAny().orElseThrow();
		ExternalCallAction targetReplacement = EcoreUtil.copy(targetElement);
		targetReplacement.setId(String.valueOf(UUID.randomUUID()));
		targetReplacement.setCalledService_ExternalService(replacementSignature);
		uncertaintyElements.get(0).add(targetReplacement);
		
		AbstractAction lastElement = targetElement;
		AbstractAction followingElement = targetElement.getSuccessor_AbstractAction();
		for (int i = 1; i < parameter.getModelSize(); i++) {
			ExternalCallAction newTargetElement = EcoreUtil.copy(targetElement);
			newTargetElement.setId(String.valueOf(UUID.randomUUID()));
			lastElement.setSuccessor_AbstractAction(newTargetElement);
			newTargetElement.setPredecessor_AbstractAction(lastElement);
			newTargetElement.setSuccessor_AbstractAction(followingElement);
			followingElement.setPredecessor_AbstractAction(newTargetElement);
			lastElement = newTargetElement;
			uncertaintyElements.add(i, new ArrayList<>());
			uncertaintyElements.get(i).add(newTargetElement);
			
			ExternalCallAction newReplacementElement = EcoreUtil.copy(targetReplacement);
			newReplacementElement.setId(String.valueOf(UUID.randomUUID()));
			uncertaintyElements.get(i).add(newReplacementElement);
		}
		
		for(int i = 0; i < parameter.getModelSize(); i++) {
			PCMConnectorUncertaintySourceInExternalCall uncertaintySource = factory.createConnectorUncertainty(uncertaintyElements.get(i).get(0), "generatedDefault", uncertaintyElements.get(i).subList(1, uncertaintyElements.get(i).size()), List.of("generatedAlternative"));
		}
		super.runAnalysis(factory, parameter, analysisExecutor);	
		try {
			factory.saveModel();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getModelSize(int currentIndex) {
		if (currentIndex == 0) {
			return 1;
		}
		return 10 * currentIndex;
	}

	@Override
	public String getTestName() {
		return "SecondaryUncertaintyTest";
	}
}
