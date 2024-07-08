package dev.abunai.confidentiality.analysis.evaluation.factory.builder.node;

import java.io.IOException;

import org.dataflowanalysis.pcm.extension.model.confidentiality.characteristics.EnumCharacteristic;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.pcm.usagemodel.UsageScenario;

public interface NodeCharacteristicBuilder {
	public void setup();
	
	public void addCharacteristic(ResourceContainer container, EnumCharacteristic characteristic);
	public void addCharacteristic(UsageScenario scenario, EnumCharacteristic characteristic);
	public void addCharacteristic(AssemblyContext assemblyContext, EnumCharacteristic characteristic);
	
	public void save() throws IOException;
}
