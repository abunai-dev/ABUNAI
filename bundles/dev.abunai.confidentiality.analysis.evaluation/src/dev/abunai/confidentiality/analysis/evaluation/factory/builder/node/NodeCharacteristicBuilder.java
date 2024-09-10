package dev.abunai.confidentiality.analysis.evaluation.factory.builder.node;

import java.io.IOException;

import org.dataflowanalysis.pcm.extension.model.confidentiality.characteristics.EnumCharacteristic;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.AssemblyAssignee;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.ResourceAssignee;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.UsageAssignee;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.pcm.usagemodel.UsageScenario;

public interface NodeCharacteristicBuilder {
	public void setup();
	
	public ResourceAssignee addCharacteristic(ResourceContainer container, EnumCharacteristic characteristic);
	public UsageAssignee addCharacteristic(UsageScenario scenario, EnumCharacteristic characteristic);
	public AssemblyAssignee addCharacteristic(AssemblyContext assemblyContext, EnumCharacteristic characteristic);
	
	public void save() throws IOException;
}
