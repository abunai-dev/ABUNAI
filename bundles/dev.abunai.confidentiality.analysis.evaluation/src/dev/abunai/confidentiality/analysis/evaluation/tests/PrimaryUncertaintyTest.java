package dev.abunai.confidentiality.analysis.evaluation.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.dataflowanalysis.analysis.utils.ResourceUtils;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF;
import org.palladiosimulator.pcm.seff.SetVariableAction;

import dev.abunai.confidentiality.analysis.evaluation.AnalysisExecutor;
import dev.abunai.confidentiality.analysis.evaluation.factory.PCMModelFactory;
import dev.abunai.confidentiality.analysis.evaluation.result.ScalibilityParameter;
import dev.abunai.confidentiality.analysis.evaluation.result.ScalibilityTest;

public class PrimaryUncertaintyTest extends ScalibilityTest {
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
		
		List<SetVariableAction> targets = seffs.stream()
				.map(ResourceDemandingSEFF::getSteps_Behaviour)
				.flatMap(List::stream)
				.filter(SetVariableAction.class::isInstance)
				.map(SetVariableAction.class::cast)
				.toList();
		
		int elements = Math.min(targets.size(), parameter.getModelSize());
		Map<SetVariableAction, SetVariableAction> mapping = new HashMap<>(elements);
		List<Integer> indexMapping = new ArrayList<>(targets.size());
		for (int i = 0; i < targets.size(); i++) {
			indexMapping.add(i);
		}
		Collections.shuffle(indexMapping, new Random(1337L));
		for (int i = 0; i < elements; i++) {
			SetVariableAction target = targets.get(indexMapping.get(i));
			
			SetVariableAction replacement = EcoreUtil.copy(target);
			replacement.setId(String.valueOf(UUID.randomUUID()));
			replacement.setPredecessor_AbstractAction(null);
			replacement.setSuccessor_AbstractAction(null);
			replacement.getLocalVariableUsages_SetVariableAction().clear();
			target.getResourceDemandingBehaviour_AbstractAction().getSteps_Behaviour().add(replacement);
			
			mapping.put(target, replacement);
		}
		
		for(var entry : mapping.entrySet()) {
			factory.createBehaviorUncertainty(entry.getKey(), "generated", List.of(entry.getValue()), List.of("generatedAlternative"));
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
		return 5 * currentIndex;
	}

	@Override
	public String getTestName() {
		return "PrimaryUncertaintyTest";
	}
}
