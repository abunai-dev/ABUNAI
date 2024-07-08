package dev.abunai.confidentiality.analysis.evaluation.tests;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import dev.abunai.confidentiality.analysis.evaluation.testmodels.Activator;
import org.apache.log4j.Logger;
import org.dataflowanalysis.pcm.extension.dictionary.characterized.DataDictionaryCharacterized.EnumCharacteristicType;
import dev.abunai.confidentiality.analysis.evaluation.AnalysisExecutor;
import dev.abunai.confidentiality.analysis.evaluation.AnalysisUtils;
import dev.abunai.confidentiality.analysis.evaluation.factory.PCMModelFactory;
import dev.abunai.confidentiality.analysis.evaluation.factory.builder.AssemblyAllocationBuilder;
import dev.abunai.confidentiality.analysis.evaluation.factory.builder.CharacteristicBuilder;
import dev.abunai.confidentiality.analysis.evaluation.factory.builder.ComponentBuilder;
import dev.abunai.confidentiality.analysis.evaluation.factory.builder.InterfaceBuilder;
import dev.abunai.confidentiality.analysis.evaluation.factory.builder.dataflow.SEFFBuilder;
import dev.abunai.confidentiality.analysis.evaluation.factory.builder.dataflow.UsageBuilder;
import dev.abunai.confidentiality.analysis.evaluation.result.ScalibilityParameter;
import dev.abunai.confidentiality.analysis.evaluation.result.ScalibilityTest;
import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.repository.DataType;
import org.palladiosimulator.pcm.repository.OperationInterface;
import org.palladiosimulator.pcm.repository.OperationProvidedRole;
import org.palladiosimulator.pcm.repository.OperationSignature;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;

public class VariableActionsTest extends ScalibilityTest {
	private final Logger logger = Logger.getLogger(VariableActionsTest.class);

	@Override
	public void run(ScalibilityParameter parameter, AnalysisExecutor analysisExecutor) {
		PCMModelFactory factory;
		try {
			factory = new PCMModelFactory("./VariableActionsTest",
					Activator.class, AnalysisUtils.TEST_MODEL_PROJECT_NAME);
		} catch (IOException e) {
			logger.error("Unable to create model factory", e);
			return;
		}
		ResourceContainer resourceContainer = factory.addResourceContainer("VariableServer");
		DataType dataType = factory.addDataType("VariableDataType");
		InterfaceBuilder interfaceBuilder = InterfaceBuilder.builder(factory.getRepository())
				.setName("VariableInterface");
		OperationSignature operationSignature = interfaceBuilder
				.addOperation("call", Map.of("param", dataType));
		OperationInterface operationInterface = interfaceBuilder.build();
		BasicComponent component = (BasicComponent) ComponentBuilder.basicComponent(factory.getRepository())
				.setName("VariableComponent")
				.provideInterface(operationInterface, "CallProvider")
				.build();
		CharacteristicBuilder characteristicBuilder = CharacteristicBuilder.builder(factory.getDictionary())
				.setName("VariableEnum");
		characteristicBuilder = characteristicBuilder.addCharacteristicValue("Set");
		characteristicBuilder = characteristicBuilder.addCharacteristicValue("NotSet");
		EnumCharacteristicType characteristic = characteristicBuilder.build();
		AssemblyAllocationBuilder assemblyAllocation = 
				factory.addAssemblyContext("VariableAssembly", component)
				.addAllocation("VariableAllocation", resourceContainer);
		OperationProvidedRole providedRole = 
				assemblyAllocation.addSystemProvidedRole("VariableProvider", operationInterface);
		SEFFBuilder seffBuilder = SEFFBuilder.builder(component, operationSignature);
		for(int i = 0; i < parameter.getModelSize(); i++) {
			seffBuilder = seffBuilder.addVariableAction("SetVariableAction" + i);
		}
		seffBuilder.build();
		UsageBuilder builder = UsageBuilder.builder(factory.getUsageModel(), factory.getNodeCharacteristicBuilder());
		builder = builder.addCall("EntryLevelSystemCall")
				.setCallee(providedRole, operationSignature)
				.addInputCharacteristic("param" ,characteristic, Optional.of("Set"))
				.addDefaultReturn("param")
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
		return "VariableActionsTest";
	}

}
