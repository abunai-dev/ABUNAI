package dev.abunai.confidentiality.analysis.evaluation.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import dev.abunai.confidentiality.analysis.evaluation.AnalysisExecutor;
import dev.abunai.confidentiality.analysis.evaluation.AnalysisUtils;
import dev.abunai.confidentiality.analysis.evaluation.factory.PCMModelFactory;
import dev.abunai.confidentiality.analysis.evaluation.factory.builder.AssemblyAllocationBuilder;
import dev.abunai.confidentiality.analysis.evaluation.factory.builder.CharacteristicBuilder;
import dev.abunai.confidentiality.analysis.evaluation.factory.builder.ComponentBuilder;
import dev.abunai.confidentiality.analysis.evaluation.factory.builder.InterfaceBuilder;
import dev.abunai.confidentiality.analysis.evaluation.factory.builder.dataflow.SEFFBranchBuilder;
import dev.abunai.confidentiality.analysis.evaluation.factory.builder.dataflow.SEFFBuilder;
import dev.abunai.confidentiality.analysis.evaluation.factory.builder.dataflow.UsageBuilder;
import dev.abunai.confidentiality.analysis.evaluation.factory.builder.dataflow.UsageCallBuilder;
import dev.abunai.confidentiality.analysis.evaluation.result.ScalibilityParameter;
import dev.abunai.confidentiality.analysis.evaluation.result.ScalibilityTest;
import dev.abunai.confidentiality.analysis.evaluation.testmodels.Activator;
import org.apache.log4j.Logger;
import org.dataflowanalysis.pcm.extension.dictionary.characterized.DataDictionaryCharacterized.EnumCharacteristicType;
import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.repository.DataType;
import org.palladiosimulator.pcm.repository.OperationInterface;
import org.palladiosimulator.pcm.repository.OperationProvidedRole;
import org.palladiosimulator.pcm.repository.OperationSignature;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;

public class BranchCountTest extends ScalibilityTest {
	private Logger logger = Logger.getLogger(BranchCountTest.class);

	@Override
	public void run(ScalibilityParameter parameter, AnalysisExecutor analysisExecutor) {
		PCMModelFactory factory;
		try {
			factory = new PCMModelFactory("./BranchCountTest",
					Activator.class, AnalysisUtils.TEST_MODEL_PROJECT_NAME);
		} catch (IOException e) {
			logger.error("Unable to create model factory", e);
			return;
		}
		ResourceContainer resourceContainer = factory.addResourceContainer("BranchServer");
		DataType dataType = factory.addDataType("BranchDataType");
		InterfaceBuilder interfaceBuilder = InterfaceBuilder.builder(factory.getRepository())
				.setName("BranchInterface");
		Map<String, DataType> parameters = new HashMap<>(parameter.getModelSize());
		parameters.put("param", dataType);
		OperationSignature operationSignature = interfaceBuilder
				.addOperation("call", parameters);
		OperationInterface operationInterface = interfaceBuilder.build();
		BasicComponent component = (BasicComponent) ComponentBuilder.basicComponent(factory.getRepository())
				.setName("BranchComponent")
				.provideInterface(operationInterface, "CallProvider")
				.build();
		CharacteristicBuilder characteristicBuilder = CharacteristicBuilder.builder(factory.getDictionary())
				.setName("BranchEnum");
		characteristicBuilder = characteristicBuilder.addCharacteristicValue("Set");
		characteristicBuilder = characteristicBuilder.addCharacteristicValue("NotSet");
		EnumCharacteristicType characteristic = characteristicBuilder.build();
		AssemblyAllocationBuilder assemblyAllocation =
				factory.addAssemblyContext("BranchAssembly", component)
				.addAllocation("BranchAllocation", resourceContainer);
		OperationProvidedRole providedRole = 
				assemblyAllocation.addSystemProvidedRole("BranchProvider", operationInterface);
		SEFFBuilder seffBuilder = SEFFBuilder.builder(component, operationSignature);
		List<SEFFBuilder> currentLayer = new ArrayList<>();
		currentLayer.add(seffBuilder);
		for(int i = 0; i < parameter.getModelSize(); i++) {
			List<SEFFBuilder> newLayer = new ArrayList<>();
			for (SEFFBuilder builder : currentLayer) {
				SEFFBranchBuilder branchBuilder = builder.addBranch("BranchLayer" + i);
				newLayer.add(branchBuilder.left());
				newLayer.add(branchBuilder.right());
				builder.build();
			}
			currentLayer = newLayer;
		}
		currentLayer.forEach(it -> it.build());
		UsageBuilder builder = UsageBuilder.builder(factory.getUsageModel(), factory.getNodeCharacteristicBuilder());
		builder.addCharacteristic(characteristic, "Set");
		UsageCallBuilder callBuilder = builder.addCall("EntryLevelSystemCall")
				.setCallee(providedRole, operationSignature);
		callBuilder = callBuilder.addInputCharacteristic("param", characteristic, Optional.of("Set"));
		builder = callBuilder.addDefaultReturn("param")
				.buildCall();
		builder.build();
		try {
			factory.saveModel();
		} catch (IOException e) {
			e.printStackTrace();
		}
		super.runAnalysis(factory, parameter, analysisExecutor);
	}

	@Override
	public int getModelSize(int currentIndex) {
		return (int) Math.pow(10, currentIndex);
	}

	@Override
	public String getTestName() {
		return "BranchCountTest";
	}

}
