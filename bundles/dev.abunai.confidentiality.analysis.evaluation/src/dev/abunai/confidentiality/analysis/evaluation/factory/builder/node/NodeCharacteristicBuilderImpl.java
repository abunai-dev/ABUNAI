package dev.abunai.confidentiality.analysis.evaluation.factory.builder.node;


import java.io.IOException;
import java.util.Map;

import org.dataflowanalysis.pcm.extension.model.confidentiality.characteristics.EnumCharacteristic;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.AssemblyAssignee;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.Assignments;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.NodeCharacteristicsFactory;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.ResourceAssignee;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.UsageAssignee;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.pcm.usagemodel.UsageScenario;

public class NodeCharacteristicBuilderImpl implements NodeCharacteristicBuilder {
	private Resource resource;
	private Assignments assignments;
	
	public NodeCharacteristicBuilderImpl(URI uri) {
		this.resource = new XMLResourceImpl(uri);
	}
	
	@Override
	public void setup() {
		this.assignments = NodeCharacteristicsFactory.eINSTANCE.createAssignments();
		this.resource.getContents().add(this.assignments);
	}
	
	@Override
	public void save() throws IOException {
		this.resource.save(Map.of());
	}

	@Override
	public void addCharacteristic(ResourceContainer container, EnumCharacteristic characteristic) {
		ResourceAssignee assignee = NodeCharacteristicsFactory.eINSTANCE.createResourceAssignee();
		assignee.setResourcecontainer(container);
		assignee.getCharacteristics().add(characteristic);
		assignments.getAssignee().add(assignee);
	}

	@Override
	public void addCharacteristic(UsageScenario scenario, EnumCharacteristic characteristic) {
		UsageAssignee assignee = NodeCharacteristicsFactory.eINSTANCE.createUsageAssignee();
		assignee.setUsagescenario(scenario);
		assignee.getCharacteristics().add(characteristic);
		assignments.getAssignee().add(assignee);
	}

	@Override
	public void addCharacteristic(AssemblyContext assemblyContext, EnumCharacteristic characteristic) {
		AssemblyAssignee assignee = NodeCharacteristicsFactory.eINSTANCE.createAssemblyAssignee();
		assignee.setAssemblycontext(assemblyContext);
		assignee.getCharacteristics().add(characteristic);
		assignments.getAssignee().add(assignee);
	}
}
