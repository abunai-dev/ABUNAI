package dev.abunai.confidentiality.analysis.evaluation.factory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import dev.abunai.confidentiality.analysis.evaluation.factory.builder.AssemblyAllocationBuilder;
import dev.abunai.confidentiality.analysis.evaluation.factory.builder.node.NodeCharacteristicBuilder;
import dev.abunai.confidentiality.analysis.evaluation.factory.builder.node.NodeCharacteristicBuilderImpl;
import dev.abunai.confidentiality.analysis.evaluation.testmodels.Activator;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyFactory;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySourceCollection;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMBehaviorUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMBehaviorUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintyScenarioInExternalCall;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInExternalCall;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintyScenarioInUsage;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySourceInUsage;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMInterfaceUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMInterfaceUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmFactoryImpl;
import tools.mdsd.library.standalone.initialization.StandaloneInitializationException;
import tools.mdsd.library.standalone.initialization.StandaloneInitializerBuilder;

import org.dataflowanalysis.analysis.DataFlowConfidentialityAnalysis;
import org.dataflowanalysis.analysis.pcm.PCMDataFlowConfidentialityAnalysis;
import org.dataflowanalysis.analysis.utils.ResourceUtils;
import org.dataflowanalysis.pcm.extension.dddsl.DDDslStandaloneSetup;
import org.dataflowanalysis.pcm.extension.dictionary.characterized.DataDictionaryCharacterized.EnumCharacteristicType;
import org.dataflowanalysis.pcm.extension.dictionary.characterized.DataDictionaryCharacterized.Literal;
import org.dataflowanalysis.pcm.extension.model.confidentiality.characteristics.CharacteristicsFactory;
import org.dataflowanalysis.pcm.extension.model.confidentiality.characteristics.EnumCharacteristic;
import org.dataflowanalysis.pcm.extension.model.confidentiality.dictionary.DictionaryFactory;
import org.dataflowanalysis.pcm.extension.model.confidentiality.dictionary.DictionaryPackage;
import org.dataflowanalysis.pcm.extension.model.confidentiality.dictionary.PCMDataDictionary;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.NodeCharacteristicsPackage;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.UsageAssignee;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.xtext.resource.XtextResource;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.allocation.AllocationFactory;
import org.palladiosimulator.pcm.allocation.util.AllocationResourceImpl;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.CompositionFactory;
import org.palladiosimulator.pcm.repository.CompositeDataType;
import org.palladiosimulator.pcm.repository.DataType;
import org.palladiosimulator.pcm.repository.OperationSignature;
import org.palladiosimulator.pcm.repository.Repository;
import org.palladiosimulator.pcm.repository.RepositoryComponent;
import org.palladiosimulator.pcm.repository.RepositoryFactory;
import org.palladiosimulator.pcm.repository.RepositoryPackage;
import org.palladiosimulator.pcm.repository.util.RepositoryResourceImpl;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.pcm.resourceenvironment.ResourceEnvironment;
import org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentFactory;
import org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentPackage;
import org.palladiosimulator.pcm.resourceenvironment.util.ResourceenvironmentResourceImpl;
import org.palladiosimulator.pcm.seff.ExternalCallAction;
import org.palladiosimulator.pcm.seff.SetVariableAction;
import org.palladiosimulator.pcm.system.System;
import org.palladiosimulator.pcm.system.SystemFactory;
import org.palladiosimulator.pcm.system.SystemPackage;
import org.palladiosimulator.pcm.system.util.SystemResourceImpl;
import org.palladiosimulator.pcm.usagemodel.UsageModel;
import org.palladiosimulator.pcm.usagemodel.UsagemodelFactory;
import org.palladiosimulator.pcm.usagemodel.util.UsagemodelResourceImpl;

import com.google.inject.Injector;

public class PCMModelFactory {
	private static final String MODEL_PROJECT_NAME = "dev.abunai.confidentiality.analysis.evaluation.testmodels";
	private static final String BASE_PATH = "testmodels/";

	private ResourceSet resources = new ResourceSetImpl();
	
	private System system;
	private Allocation allocation;
	private Repository repository;
	private ResourceEnvironment resourceEnvironment;
	private UsageModel usageModel;
	private PCMDataDictionary dictionary;
	private UncertaintySourceCollection uncertaintySources;
	
	private NodeCharacteristicBuilder nodeCharacteristicBuilder;
	
	public PCMModelFactory(String filePath, Class<?> activator, String modelPath) throws IOException {		
		system = SystemFactory.eINSTANCE.createSystem();
		Resource systemResource = new SystemResourceImpl(ResourceUtils.createRelativePluginURI(BASE_PATH + "generated.system", MODEL_PROJECT_NAME));
		systemResource.getContents().add(system);
		resources.getResources().add(systemResource);
		
		allocation = AllocationFactory.eINSTANCE.createAllocation();
		Resource allocationResource = new AllocationResourceImpl(ResourceUtils.createRelativePluginURI(BASE_PATH + "generated.allocation", MODEL_PROJECT_NAME));
		allocationResource.getContents().add(allocation);
		resources.getResources().add(allocationResource);
		
		repository = RepositoryFactory.eINSTANCE.createRepository();
		Resource repositoryResource = new RepositoryResourceImpl(ResourceUtils.createRelativePluginURI(BASE_PATH + "generated.repository", MODEL_PROJECT_NAME));
		repositoryResource.getContents().add(repository);
		resources.getResources().add(repositoryResource);
		
		resourceEnvironment = ResourceenvironmentFactory.eINSTANCE.createResourceEnvironment();
		Resource resourceEnvironmentResource = new ResourceenvironmentResourceImpl(ResourceUtils.createRelativePluginURI(BASE_PATH + "generated.resourceenvironment", MODEL_PROJECT_NAME));
		resourceEnvironmentResource.getContents().add(resourceEnvironment);
		resources.getResources().add(resourceEnvironmentResource);
		
		usageModel = UsagemodelFactory.eINSTANCE.createUsageModel();
		Resource usageResource = new UsagemodelResourceImpl(ResourceUtils.createRelativePluginURI(BASE_PATH + "generated.usagemodel", MODEL_PROJECT_NAME));
		usageResource.getContents().add(usageModel);
		resources.getResources().add(usageResource);
		
		uncertaintySources = UncertaintyFactory.eINSTANCE.createUncertaintySourceCollection();
		Resource uncertaintyResource = new XMIResourceImpl(ResourceUtils.createRelativePluginURI(BASE_PATH + "generated.uncertainty", MODEL_PROJECT_NAME));
		uncertaintyResource.getContents().add(uncertaintySources);
		resources.getResources().add(uncertaintyResource);
		
		dictionary = DictionaryFactory.eINSTANCE.createPCMDataDictionary();
		URI uri = ResourceUtils.createRelativePluginURI(BASE_PATH + "generated.datadictionary", MODEL_PROJECT_NAME);
		DDDslStandaloneSetup.doSetup();
		Injector injector = new DDDslStandaloneSetup().createInjectorAndDoEMFRegistration();
		XtextResource resource = injector.getInstance(XtextResource.class);
		resource.setURI(uri);
		//Resource resource = new ResourceImpl(uri);
		resource.getContents().add(dictionary);
		resources.getResources().add(resource);
		
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
	
	public PCMModelFactory(URI usageModelURI, URI allocationModelURI, URI nodeCharacteristicsURI,
			URI uncertaintyModelURI) {
		try {
            var initializationBuilder = StandaloneInitializerBuilder.builder()
                    .registerProjectURI(Activator.class, "dev.abunai.confidentiality.analysis.evaluation.testmodels");

            initializationBuilder.build()
                    .init();
        } catch (StandaloneInitializationException e) {
        	throw new IllegalStateException();
        }
		this.usageModel = (UsageModel) this.loadModelContent(usageModelURI);
        this.allocation = (Allocation) this.loadModelContent(allocationModelURI);
        List<Resource> loadedResources;
        do {
            loadedResources = new ArrayList<>(this.resources.getResources());
            loadedResources.forEach(EcoreUtil::resolveAll);
        } while (loadedResources.size() != this.resources.getResources()
                .size());
        this.repository = (Repository) this.lookupToplevelElement(RepositoryPackage.eINSTANCE.getRepository()).get(0);
        this.system = (System) this.lookupToplevelElement(SystemPackage.eINSTANCE.getSystem()).get(0);
        this.resourceEnvironment = (ResourceEnvironment) this.lookupToplevelElement(ResourceenvironmentPackage.eINSTANCE.getResourceEnvironment()).get(0);
		
        this.uncertaintySources = (UncertaintySourceCollection) this.loadModelContent(uncertaintyModelURI);
		
        this.loadModelContent(nodeCharacteristicsURI);
        this.nodeCharacteristicBuilder = new NodeCharacteristicBuilderImpl(this.resources.getResources().stream()
        		.filter(it -> this.isTargetInResource(NodeCharacteristicsPackage.eINSTANCE.getAssignments(), it))
        		.findAny().orElseThrow());
        
        //this.dictionary = (PCMDataDictionary) this.lookupToplevelElement(DictionaryPackage.eINSTANCE.getPCMDataDictionary()).get(0);
	}
	
	private EObject loadModelContent(URI modelURI) {
        Resource resource = this.resources.getResource(modelURI, true);
        if (resource == null) {
            throw new IllegalArgumentException(String.format("Model with URI %s could not be loaded", modelURI));
        } else if (resource.getContents()
                .isEmpty()) {
            throw new IllegalArgumentException(String.format("Model with URI %s is empty", modelURI));
        }
        return resource.getContents()
                .get(0);
    }
	
    private <T extends EObject> List<T> lookupToplevelElement(EClass targetType) {
        ArrayList<T> result = new ArrayList<>();
        for (Resource resource : this.resources.getResources()) {
            if (this.isTargetInResource(targetType, resource)) {
                result.addAll(EcoreUtil.getObjectsByType(resource.getContents(), targetType));
            }
        }
        return result;
    }
    
    private boolean isTargetInResource(EClass targetType, Resource resource) {
        if (resource != null) {
            for (EObject c : resource.getContents()) {
                if (targetType.isSuperTypeOf(c.eClass())) {
                    return true;
                }
            }
        }
        return false;
    }
	
	public DataType addDataType(String name) {
		CompositeDataType dataType = RepositoryFactory.eINSTANCE.createCompositeDataType();
		dataType.setRepository__DataType(repository);
		dataType.setEntityName(name);
		return dataType;
	}
	
	public PCMExternalUncertaintySourceInUsage createExternalUncertainty(UsageAssignee target, String sourceName, List<UsageAssignee> values, List<String> scenarioNames) {
		PCMExternalUncertaintySourceInUsage uncertaintySource = PcmFactoryImpl.eINSTANCE.createPCMExternalUncertaintySourceInUsage();
		uncertaintySource.setEntityName(BASE_PATH);
		uncertaintySource.setEntityName(sourceName);
		uncertaintySource.setTarget(target);
		for (int i = 0; i < values.size(); i++) {
			PCMExternalUncertaintyScenarioInUsage uncertaintyScenario = PcmFactoryImpl.eINSTANCE.createPCMExternalUncertaintyScenarioInUsage();
			uncertaintyScenario.setEntityName(scenarioNames.get(i));
			uncertaintyScenario.setTarget(values.get(i));
			uncertaintySource.getScenarios().add(uncertaintyScenario);
		}
		this.uncertaintySources.getSources().add(uncertaintySource);
		return uncertaintySource;
	}
	
	public PCMInterfaceUncertaintySource createInterfaceUncertainty(OperationSignature target, String sourceName, List<OperationSignature> values, List<String> scenarioNames) {
		PCMInterfaceUncertaintySource uncertaintySource = PcmFactoryImpl.eINSTANCE.createPCMInterfaceUncertaintySource();
		uncertaintySource.setEntityName(BASE_PATH);
		uncertaintySource.setEntityName(sourceName);
		uncertaintySource.setTarget(target);
		for (int i = 0; i < values.size(); i++) {
			PCMInterfaceUncertaintyScenario uncertaintyScenario = PcmFactoryImpl.eINSTANCE.createPCMInterfaceUncertaintyScenario();
			uncertaintyScenario.setEntityName(scenarioNames.get(i));
			uncertaintyScenario.setTarget(values.get(i));
			uncertaintySource.getScenarios().add(uncertaintyScenario);
		}
		this.uncertaintySources.getSources().add(uncertaintySource);
		return uncertaintySource;
	}
	
	public PCMConnectorUncertaintySourceInExternalCall createConnectorUncertainty(ExternalCallAction target, String sourceName, List<ExternalCallAction> values, List<String> scenarioNames) {
		PCMConnectorUncertaintySourceInExternalCall uncertaintySource = PcmFactoryImpl.eINSTANCE.createPCMConnectorUncertaintySourceInExternalCall();
		uncertaintySource.setEntityName(BASE_PATH);
		uncertaintySource.setEntityName(sourceName);
		uncertaintySource.setTarget(target);
		for (int i = 0; i < values.size(); i++) {
			PCMConnectorUncertaintyScenarioInExternalCall uncertaintyScenario = PcmFactoryImpl.eINSTANCE.createPCMConnectorUncertaintyScenarioInExternalCall();
			uncertaintyScenario.setEntityName(scenarioNames.get(i));
			uncertaintyScenario.setTarget(values.get(i));
			uncertaintySource.getScenarios().add(uncertaintyScenario);
		}
		this.uncertaintySources.getSources().add(uncertaintySource);
		return uncertaintySource;
	}
	
	public PCMBehaviorUncertaintySource createBehaviorUncertainty(SetVariableAction target, String sourceName, List<SetVariableAction> values, List<String> scenarioNames) {
		PCMBehaviorUncertaintySource uncertaintySource = PcmFactoryImpl.eINSTANCE.createPCMBehaviorUncertaintySource();
		uncertaintySource.setEntityName(BASE_PATH);
		uncertaintySource.setEntityName(sourceName);
		uncertaintySource.setTarget(target);
		for (int i = 0; i < values.size(); i++) {
			PCMBehaviorUncertaintyScenario uncertaintyScenario = PcmFactoryImpl.eINSTANCE.createPCMBehaviorUncertaintyScenario();
			uncertaintyScenario.setEntityName(scenarioNames.get(i));
			uncertaintyScenario.setTarget(values.get(i));
			uncertaintySource.getScenarios().add(uncertaintyScenario);
		}
		this.uncertaintySources.getSources().add(uncertaintySource);
		return uncertaintySource;
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
		return this.resources.getResources();
	}
	
	public NodeCharacteristicBuilder getNodeCharacteristicBuilder() {
		return nodeCharacteristicBuilder;
	}
	
	public void saveModel() throws IOException {
		for (Resource resource : this.resources.getResources()) {
			//if (resource.getContents().get(0) instanceof PCMDataDictionary) {
				// Save broken
				//continue;
			//}
			resource.save(Map.of());
		}
		this.nodeCharacteristicBuilder.save();
	}
}
