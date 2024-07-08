package dev.abunai.confidentiality.analysis.evaluation.factory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import dev.abunai.confidentiality.analysis.evaluation.factory.builder.AssemblyAllocationBuilder;
import dev.abunai.confidentiality.analysis.evaluation.factory.builder.node.NodeCharacteristicBuilder;
import dev.abunai.confidentiality.analysis.evaluation.factory.builder.node.NodeCharacteristicBuilderImpl;
import org.dataflowanalysis.analysis.utils.ResourceUtils;
import org.dataflowanalysis.pcm.extension.dddsl.DDDslStandaloneSetup;
import org.dataflowanalysis.pcm.extension.dictionary.characterized.DataDictionaryCharacterized.EnumCharacteristicType;
import org.dataflowanalysis.pcm.extension.dictionary.characterized.DataDictionaryCharacterized.Literal;
import org.dataflowanalysis.pcm.extension.model.confidentiality.characteristics.CharacteristicsFactory;
import org.dataflowanalysis.pcm.extension.model.confidentiality.characteristics.EnumCharacteristic;
import org.dataflowanalysis.pcm.extension.model.confidentiality.dictionary.DictionaryFactory;
import org.dataflowanalysis.pcm.extension.model.confidentiality.dictionary.PCMDataDictionary;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.allocation.AllocationFactory;
import org.palladiosimulator.pcm.allocation.util.AllocationResourceImpl;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.CompositionFactory;
import org.palladiosimulator.pcm.repository.CompositeDataType;
import org.palladiosimulator.pcm.repository.DataType;
import org.palladiosimulator.pcm.repository.Repository;
import org.palladiosimulator.pcm.repository.RepositoryComponent;
import org.palladiosimulator.pcm.repository.RepositoryFactory;
import org.palladiosimulator.pcm.repository.util.RepositoryResourceImpl;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.pcm.resourceenvironment.ResourceEnvironment;
import org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentFactory;
import org.palladiosimulator.pcm.resourceenvironment.util.ResourceenvironmentResourceImpl;
import org.palladiosimulator.pcm.system.System;
import org.palladiosimulator.pcm.system.SystemFactory;
import org.palladiosimulator.pcm.system.util.SystemResourceImpl;
import org.palladiosimulator.pcm.usagemodel.UsageModel;
import org.palladiosimulator.pcm.usagemodel.UsagemodelFactory;
import org.palladiosimulator.pcm.usagemodel.util.UsagemodelResourceImpl;

import com.google.inject.Injector;

public class PCMModelFactory {
	private static final String MODEL_PROJECT_NAME = "dev.abunai.confidentiality.analysis.evaluation.testmodels";
	private static final String BASE_PATH = "testmodels/";

	private List<Resource> resources;
	
	private System system;
	private Allocation allocation;
	private Repository repository;
	private ResourceEnvironment resourceEnvironment;
	private UsageModel usageModel;
	private PCMDataDictionary dictionary;
	
	private NodeCharacteristicBuilder nodeCharacteristicBuilder;
	
	public PCMModelFactory(String filePath, Class<?> activator, String modelPath) throws IOException {
		resources = new ArrayList<>();
		
		system = SystemFactory.eINSTANCE.createSystem();
		Resource systemResource = new SystemResourceImpl(ResourceUtils.createRelativePluginURI(BASE_PATH + "generated.system", MODEL_PROJECT_NAME));
		systemResource.getContents().add(system);
		resources.add(systemResource);
		
		allocation = AllocationFactory.eINSTANCE.createAllocation();
		Resource allocationResource = new AllocationResourceImpl(ResourceUtils.createRelativePluginURI(BASE_PATH + "generated.allocation", MODEL_PROJECT_NAME));
		allocationResource.getContents().add(allocation);
		resources.add(allocationResource);
		
		repository = RepositoryFactory.eINSTANCE.createRepository();
		Resource repositoryResource = new RepositoryResourceImpl(ResourceUtils.createRelativePluginURI(BASE_PATH + "generated.repository", MODEL_PROJECT_NAME));
		repositoryResource.getContents().add(repository);
		resources.add(repositoryResource);
		
		resourceEnvironment = ResourceenvironmentFactory.eINSTANCE.createResourceEnvironment();
		Resource resourceEnvironmentResource = new ResourceenvironmentResourceImpl(ResourceUtils.createRelativePluginURI(BASE_PATH + "generated.resourceenvironment", MODEL_PROJECT_NAME));
		resourceEnvironmentResource.getContents().add(resourceEnvironment);
		resources.add(resourceEnvironmentResource);
		
		usageModel = UsagemodelFactory.eINSTANCE.createUsageModel();
		Resource usageResource = new UsagemodelResourceImpl(ResourceUtils.createRelativePluginURI(BASE_PATH + "generated.usagemodel", MODEL_PROJECT_NAME));
		usageResource.getContents().add(usageModel);
		resources.add(usageResource);
		
		dictionary = DictionaryFactory.eINSTANCE.createPCMDataDictionary();
		URI uri = ResourceUtils.createRelativePluginURI(BASE_PATH + "generated.pddc", MODEL_PROJECT_NAME);
		DDDslStandaloneSetup.doSetup();
		Injector injector = new DDDslStandaloneSetup().createInjectorAndDoEMFRegistration();
		XtextResource resource = injector.getInstance(XtextResource.class);
		resource.setURI(uri);
		resource.getContents().add(dictionary);
		resources.add(resource);
		
		this.nodeCharacteristicBuilder = new NodeCharacteristicBuilderImpl(ResourceUtils.createRelativePluginURI(BASE_PATH + "generated.nodecharacteristics", MODEL_PROJECT_NAME));
		this.nodeCharacteristicBuilder.setup();
	}
	
	public AssemblyAllocationBuilder addAssemblyContext(String name, RepositoryComponent repositoryComponent) {
		AssemblyContext assemblyContext = CompositionFactory.eINSTANCE.createAssemblyContext();
		assemblyContext.setId(UUID.randomUUID().toString());
		assemblyContext.setEntityName(name);
		assemblyContext.setEncapsulatedComponent__AssemblyContext(repositoryComponent);
		system.getAssemblyContexts__ComposedStructure().add(assemblyContext);
		return AssemblyAllocationBuilder.builder(system, allocation, assemblyContext, nodeCharacteristicBuilder);
	}
	
	public ResourceContainer addResourceContainer(String name) {
		ResourceContainer resourceContainer = ResourceenvironmentFactory.eINSTANCE.createResourceContainer();
		resourceContainer.setEntityName(name);
		resourceContainer.setResourceEnvironment_ResourceContainer(resourceEnvironment);
		resourceEnvironment.getResourceContainer_ResourceEnvironment().add(resourceContainer);
		return resourceContainer;
	}
	
	public void addCharacteristicResourceContainer(ResourceContainer container, EnumCharacteristicType characteristicType, String characteristicValue) {
		Literal literal = characteristicType.getType().getLiterals().stream()
					.filter(it -> it.getName().equalsIgnoreCase(characteristicValue))
					.findAny().orElseThrow(() -> new IllegalArgumentException("Unknown characteristic value"));
		EnumCharacteristic characteristic = CharacteristicsFactory.eINSTANCE.createEnumCharacteristic();
		characteristic.setType(characteristicType);
		characteristic.getValues().add(literal);
		nodeCharacteristicBuilder.addCharacteristic(container, characteristic);
	}
	
	public DataType addDataType(String name) {
		CompositeDataType dataType = RepositoryFactory.eINSTANCE.createCompositeDataType();
		dataType.setRepository__DataType(repository);
		dataType.setEntityName(name);
		return dataType;
	}
	
	public Repository getRepository() {
		return repository;
	}
	
	public UsageModel getUsageModel() {
		return usageModel;
	}
	
	public System getSystem() {
		return system;
	}
	
	public PCMDataDictionary getDictionary() {
		return this.dictionary;
	}
	
	public Allocation getAllocation() {
		return allocation;
	}
	
	public List<Resource> getResources() {
		return this.resources;
	}
	
	public NodeCharacteristicBuilder getNodeCharacteristicBuilder() {
		return nodeCharacteristicBuilder;
	}
	
	public void saveModel() throws IOException {
		for (Resource resource : this.resources) {
			resource.save(Map.of());
		}
		this.nodeCharacteristicBuilder.save();
	}
}
