/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;

import de.uka.ipd.sdq.stoex.StoexPackage;

import de.uka.ipd.sdq.units.UnitsPackage;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage;

import dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl;

import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.BehaviorUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.BehaviorUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ComponentUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ComponentUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintyScenarioInEntryLevelSystemCall;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintyScenarioInExternalCall;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintySourceInEntryLevelSystemCall;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintySourceInExternalCall;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintyScenarioInResource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintyScenarioInUsage;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintySourceInResource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintySourceInUsage;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.InterfaceUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.InterfaceUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmFactory;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage;

import org.dataflowanalysis.pcm.extension.dictionary.DataDictionary.DataDictionaryPackage;

import org.dataflowanalysis.pcm.extension.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage;

import org.dataflowanalysis.pcm.extension.model.confidentiality.ConfidentialityPackage;

import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.NodeCharacteristicsPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.palladiosimulator.pcm.core.composition.CompositionPackage;

import org.palladiosimulator.pcm.repository.RepositoryPackage;

import org.palladiosimulator.pcm.seff.SeffPackage;

import org.palladiosimulator.pcm.usagemodel.UsagemodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PcmPackageImpl extends EPackageImpl implements PcmPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalUncertaintySourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalUncertaintySourceInResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalUncertaintySourceInUsageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalUncertaintyScenarioInResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalUncertaintyScenarioInUsageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorUncertaintySourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorUncertaintyScenarioEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceUncertaintySourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceUncertaintyScenarioEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectorUncertaintySourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectorUncertaintySourceInExternalCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectorUncertaintySourceInEntryLevelSystemCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectorUncertaintyScenarioInExternalCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectorUncertaintyScenarioInEntryLevelSystemCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentUncertaintySourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentUncertaintyScenarioEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PcmPackageImpl() {
		super(eNS_URI, PcmFactory.eINSTANCE);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link PcmPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PcmPackage init() {
		if (isInited) return (PcmPackage)EPackage.Registry.INSTANCE.getEPackage(PcmPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredPcmPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		PcmPackageImpl thePcmPackage = registeredPcmPackage instanceof PcmPackageImpl ? (PcmPackageImpl)registeredPcmPackage : new PcmPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		DataDictionaryPackage.eINSTANCE.eClass();
		DataDictionaryCharacterizedPackage.eINSTANCE.eClass();
		ConfidentialityPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		IdentifierPackage.eINSTANCE.eClass();
		NodeCharacteristicsPackage.eINSTANCE.eClass();
		org.palladiosimulator.pcm.PcmPackage.eINSTANCE.eClass();
		ProbfunctionPackage.eINSTANCE.eClass();
		StoexPackage.eINSTANCE.eClass();
		UnitsPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(UncertaintyPackage.eNS_URI);
		UncertaintyPackageImpl theUncertaintyPackage = (UncertaintyPackageImpl)(registeredPackage instanceof UncertaintyPackageImpl ? registeredPackage : UncertaintyPackage.eINSTANCE);

		// Create package meta-data objects
		thePcmPackage.createPackageContents();
		theUncertaintyPackage.createPackageContents();

		// Initialize created meta-data
		thePcmPackage.initializePackageContents();
		theUncertaintyPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePcmPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PcmPackage.eNS_URI, thePcmPackage);
		return thePcmPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalUncertaintySource() {
		return externalUncertaintySourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalUncertaintySourceInResource() {
		return externalUncertaintySourceInResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExternalUncertaintySourceInResource_Target() {
		return (EReference)externalUncertaintySourceInResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExternalUncertaintySourceInResource_Scenarios() {
		return (EReference)externalUncertaintySourceInResourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalUncertaintySourceInUsage() {
		return externalUncertaintySourceInUsageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExternalUncertaintySourceInUsage_Target() {
		return (EReference)externalUncertaintySourceInUsageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExternalUncertaintySourceInUsage_Scenarios() {
		return (EReference)externalUncertaintySourceInUsageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalUncertaintyScenarioInResource() {
		return externalUncertaintyScenarioInResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExternalUncertaintyScenarioInResource_Target() {
		return (EReference)externalUncertaintyScenarioInResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalUncertaintyScenarioInUsage() {
		return externalUncertaintyScenarioInUsageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExternalUncertaintyScenarioInUsage_Target() {
		return (EReference)externalUncertaintyScenarioInUsageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorUncertaintySource() {
		return behaviorUncertaintySourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorUncertaintySource_Target() {
		return (EReference)behaviorUncertaintySourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorUncertaintySource_Scenarios() {
		return (EReference)behaviorUncertaintySourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorUncertaintyScenario() {
		return behaviorUncertaintyScenarioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorUncertaintyScenario_Target() {
		return (EReference)behaviorUncertaintyScenarioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterfaceUncertaintySource() {
		return interfaceUncertaintySourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceUncertaintySource_Target() {
		return (EReference)interfaceUncertaintySourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceUncertaintySource_Scenarios() {
		return (EReference)interfaceUncertaintySourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterfaceUncertaintyScenario() {
		return interfaceUncertaintyScenarioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceUncertaintyScenario_Target() {
		return (EReference)interfaceUncertaintyScenarioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectorUncertaintySource() {
		return connectorUncertaintySourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectorUncertaintySourceInExternalCall() {
		return connectorUncertaintySourceInExternalCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectorUncertaintySourceInExternalCall_Target() {
		return (EReference)connectorUncertaintySourceInExternalCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectorUncertaintySourceInExternalCall_Scenarios() {
		return (EReference)connectorUncertaintySourceInExternalCallEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectorUncertaintySourceInEntryLevelSystemCall() {
		return connectorUncertaintySourceInEntryLevelSystemCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectorUncertaintySourceInEntryLevelSystemCall_Target() {
		return (EReference)connectorUncertaintySourceInEntryLevelSystemCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectorUncertaintySourceInEntryLevelSystemCall_Scenarios() {
		return (EReference)connectorUncertaintySourceInEntryLevelSystemCallEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectorUncertaintyScenarioInExternalCall() {
		return connectorUncertaintyScenarioInExternalCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectorUncertaintyScenarioInExternalCall_Target() {
		return (EReference)connectorUncertaintyScenarioInExternalCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectorUncertaintyScenarioInEntryLevelSystemCall() {
		return connectorUncertaintyScenarioInEntryLevelSystemCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectorUncertaintyScenarioInEntryLevelSystemCall_Target() {
		return (EReference)connectorUncertaintyScenarioInEntryLevelSystemCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentUncertaintySource() {
		return componentUncertaintySourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentUncertaintySource_Target() {
		return (EReference)componentUncertaintySourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentUncertaintySource_Scenarios() {
		return (EReference)componentUncertaintySourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentUncertaintyScenario() {
		return componentUncertaintyScenarioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentUncertaintyScenario_Target() {
		return (EReference)componentUncertaintyScenarioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PcmFactory getPcmFactory() {
		return (PcmFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		externalUncertaintySourceEClass = createEClass(EXTERNAL_UNCERTAINTY_SOURCE);

		externalUncertaintySourceInResourceEClass = createEClass(EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE);
		createEReference(externalUncertaintySourceInResourceEClass, EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE__TARGET);
		createEReference(externalUncertaintySourceInResourceEClass, EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE__SCENARIOS);

		externalUncertaintySourceInUsageEClass = createEClass(EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE);
		createEReference(externalUncertaintySourceInUsageEClass, EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__TARGET);
		createEReference(externalUncertaintySourceInUsageEClass, EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__SCENARIOS);

		externalUncertaintyScenarioInResourceEClass = createEClass(EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE);
		createEReference(externalUncertaintyScenarioInResourceEClass, EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE__TARGET);

		externalUncertaintyScenarioInUsageEClass = createEClass(EXTERNAL_UNCERTAINTY_SCENARIO_IN_USAGE);
		createEReference(externalUncertaintyScenarioInUsageEClass, EXTERNAL_UNCERTAINTY_SCENARIO_IN_USAGE__TARGET);

		behaviorUncertaintySourceEClass = createEClass(BEHAVIOR_UNCERTAINTY_SOURCE);
		createEReference(behaviorUncertaintySourceEClass, BEHAVIOR_UNCERTAINTY_SOURCE__TARGET);
		createEReference(behaviorUncertaintySourceEClass, BEHAVIOR_UNCERTAINTY_SOURCE__SCENARIOS);

		behaviorUncertaintyScenarioEClass = createEClass(BEHAVIOR_UNCERTAINTY_SCENARIO);
		createEReference(behaviorUncertaintyScenarioEClass, BEHAVIOR_UNCERTAINTY_SCENARIO__TARGET);

		interfaceUncertaintySourceEClass = createEClass(INTERFACE_UNCERTAINTY_SOURCE);
		createEReference(interfaceUncertaintySourceEClass, INTERFACE_UNCERTAINTY_SOURCE__TARGET);
		createEReference(interfaceUncertaintySourceEClass, INTERFACE_UNCERTAINTY_SOURCE__SCENARIOS);

		interfaceUncertaintyScenarioEClass = createEClass(INTERFACE_UNCERTAINTY_SCENARIO);
		createEReference(interfaceUncertaintyScenarioEClass, INTERFACE_UNCERTAINTY_SCENARIO__TARGET);

		connectorUncertaintySourceEClass = createEClass(CONNECTOR_UNCERTAINTY_SOURCE);

		connectorUncertaintySourceInExternalCallEClass = createEClass(CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL);
		createEReference(connectorUncertaintySourceInExternalCallEClass, CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL__TARGET);
		createEReference(connectorUncertaintySourceInExternalCallEClass, CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL__SCENARIOS);

		connectorUncertaintySourceInEntryLevelSystemCallEClass = createEClass(CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL);
		createEReference(connectorUncertaintySourceInEntryLevelSystemCallEClass, CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL__TARGET);
		createEReference(connectorUncertaintySourceInEntryLevelSystemCallEClass, CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL__SCENARIOS);

		connectorUncertaintyScenarioInExternalCallEClass = createEClass(CONNECTOR_UNCERTAINTY_SCENARIO_IN_EXTERNAL_CALL);
		createEReference(connectorUncertaintyScenarioInExternalCallEClass, CONNECTOR_UNCERTAINTY_SCENARIO_IN_EXTERNAL_CALL__TARGET);

		connectorUncertaintyScenarioInEntryLevelSystemCallEClass = createEClass(CONNECTOR_UNCERTAINTY_SCENARIO_IN_ENTRY_LEVEL_SYSTEM_CALL);
		createEReference(connectorUncertaintyScenarioInEntryLevelSystemCallEClass, CONNECTOR_UNCERTAINTY_SCENARIO_IN_ENTRY_LEVEL_SYSTEM_CALL__TARGET);

		componentUncertaintySourceEClass = createEClass(COMPONENT_UNCERTAINTY_SOURCE);
		createEReference(componentUncertaintySourceEClass, COMPONENT_UNCERTAINTY_SOURCE__TARGET);
		createEReference(componentUncertaintySourceEClass, COMPONENT_UNCERTAINTY_SOURCE__SCENARIOS);

		componentUncertaintyScenarioEClass = createEClass(COMPONENT_UNCERTAINTY_SCENARIO);
		createEReference(componentUncertaintyScenarioEClass, COMPONENT_UNCERTAINTY_SCENARIO__TARGET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		UncertaintyPackage theUncertaintyPackage = (UncertaintyPackage)EPackage.Registry.INSTANCE.getEPackage(UncertaintyPackage.eNS_URI);
		NodeCharacteristicsPackage theNodeCharacteristicsPackage = (NodeCharacteristicsPackage)EPackage.Registry.INSTANCE.getEPackage(NodeCharacteristicsPackage.eNS_URI);
		SeffPackage theSeffPackage = (SeffPackage)EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI);
		RepositoryPackage theRepositoryPackage = (RepositoryPackage)EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI);
		UsagemodelPackage theUsagemodelPackage = (UsagemodelPackage)EPackage.Registry.INSTANCE.getEPackage(UsagemodelPackage.eNS_URI);
		CompositionPackage theCompositionPackage = (CompositionPackage)EPackage.Registry.INSTANCE.getEPackage(CompositionPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		externalUncertaintySourceEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintySource());
		externalUncertaintySourceInResourceEClass.getESuperTypes().add(this.getExternalUncertaintySource());
		externalUncertaintySourceInUsageEClass.getESuperTypes().add(this.getExternalUncertaintySource());
		externalUncertaintyScenarioInResourceEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintyScenario());
		externalUncertaintyScenarioInUsageEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintyScenario());
		behaviorUncertaintySourceEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintySource());
		behaviorUncertaintyScenarioEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintyScenario());
		interfaceUncertaintySourceEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintySource());
		interfaceUncertaintyScenarioEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintyScenario());
		connectorUncertaintySourceEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintySource());
		connectorUncertaintySourceInExternalCallEClass.getESuperTypes().add(this.getConnectorUncertaintySource());
		connectorUncertaintySourceInEntryLevelSystemCallEClass.getESuperTypes().add(this.getConnectorUncertaintySource());
		connectorUncertaintyScenarioInExternalCallEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintyScenario());
		connectorUncertaintyScenarioInEntryLevelSystemCallEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintyScenario());
		componentUncertaintySourceEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintySource());
		componentUncertaintyScenarioEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintyScenario());

		// Initialize classes, features, and operations; add parameters
		initEClass(externalUncertaintySourceEClass, ExternalUncertaintySource.class, "ExternalUncertaintySource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(externalUncertaintySourceInResourceEClass, ExternalUncertaintySourceInResource.class, "ExternalUncertaintySourceInResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExternalUncertaintySourceInResource_Target(), theNodeCharacteristicsPackage.getResourceAssignee(), null, "target", null, 1, 1, ExternalUncertaintySourceInResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExternalUncertaintySourceInResource_Scenarios(), this.getExternalUncertaintyScenarioInResource(), null, "scenarios", null, 0, -1, ExternalUncertaintySourceInResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(externalUncertaintySourceInUsageEClass, ExternalUncertaintySourceInUsage.class, "ExternalUncertaintySourceInUsage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExternalUncertaintySourceInUsage_Target(), theNodeCharacteristicsPackage.getUsageAssignee(), null, "target", null, 1, 1, ExternalUncertaintySourceInUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExternalUncertaintySourceInUsage_Scenarios(), this.getExternalUncertaintyScenarioInUsage(), null, "scenarios", null, 0, -1, ExternalUncertaintySourceInUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(externalUncertaintyScenarioInResourceEClass, ExternalUncertaintyScenarioInResource.class, "ExternalUncertaintyScenarioInResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExternalUncertaintyScenarioInResource_Target(), theNodeCharacteristicsPackage.getResourceAssignee(), null, "target", null, 1, 1, ExternalUncertaintyScenarioInResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(externalUncertaintyScenarioInUsageEClass, ExternalUncertaintyScenarioInUsage.class, "ExternalUncertaintyScenarioInUsage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExternalUncertaintyScenarioInUsage_Target(), theNodeCharacteristicsPackage.getUsageAssignee(), null, "target", null, 1, 1, ExternalUncertaintyScenarioInUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(behaviorUncertaintySourceEClass, BehaviorUncertaintySource.class, "BehaviorUncertaintySource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBehaviorUncertaintySource_Target(), theSeffPackage.getSetVariableAction(), null, "target", null, 1, 1, BehaviorUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorUncertaintySource_Scenarios(), this.getBehaviorUncertaintyScenario(), null, "scenarios", null, 0, -1, BehaviorUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(behaviorUncertaintyScenarioEClass, BehaviorUncertaintyScenario.class, "BehaviorUncertaintyScenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBehaviorUncertaintyScenario_Target(), theSeffPackage.getSetVariableAction(), null, "target", null, 1, 1, BehaviorUncertaintyScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceUncertaintySourceEClass, InterfaceUncertaintySource.class, "InterfaceUncertaintySource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterfaceUncertaintySource_Target(), theRepositoryPackage.getOperationSignature(), null, "target", null, 1, 1, InterfaceUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterfaceUncertaintySource_Scenarios(), this.getInterfaceUncertaintyScenario(), null, "scenarios", null, 0, -1, InterfaceUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceUncertaintyScenarioEClass, InterfaceUncertaintyScenario.class, "InterfaceUncertaintyScenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterfaceUncertaintyScenario_Target(), theRepositoryPackage.getOperationSignature(), null, "target", null, 1, 1, InterfaceUncertaintyScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectorUncertaintySourceEClass, ConnectorUncertaintySource.class, "ConnectorUncertaintySource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(connectorUncertaintySourceInExternalCallEClass, ConnectorUncertaintySourceInExternalCall.class, "ConnectorUncertaintySourceInExternalCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnectorUncertaintySourceInExternalCall_Target(), theSeffPackage.getExternalCallAction(), null, "target", null, 1, 1, ConnectorUncertaintySourceInExternalCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectorUncertaintySourceInExternalCall_Scenarios(), this.getConnectorUncertaintyScenarioInExternalCall(), null, "scenarios", null, 0, -1, ConnectorUncertaintySourceInExternalCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectorUncertaintySourceInEntryLevelSystemCallEClass, ConnectorUncertaintySourceInEntryLevelSystemCall.class, "ConnectorUncertaintySourceInEntryLevelSystemCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnectorUncertaintySourceInEntryLevelSystemCall_Target(), theUsagemodelPackage.getEntryLevelSystemCall(), null, "target", null, 1, 1, ConnectorUncertaintySourceInEntryLevelSystemCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectorUncertaintySourceInEntryLevelSystemCall_Scenarios(), this.getConnectorUncertaintyScenarioInEntryLevelSystemCall(), null, "scenarios", null, 0, -1, ConnectorUncertaintySourceInEntryLevelSystemCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectorUncertaintyScenarioInExternalCallEClass, ConnectorUncertaintyScenarioInExternalCall.class, "ConnectorUncertaintyScenarioInExternalCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnectorUncertaintyScenarioInExternalCall_Target(), theSeffPackage.getExternalCallAction(), null, "target", null, 1, 1, ConnectorUncertaintyScenarioInExternalCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectorUncertaintyScenarioInEntryLevelSystemCallEClass, ConnectorUncertaintyScenarioInEntryLevelSystemCall.class, "ConnectorUncertaintyScenarioInEntryLevelSystemCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnectorUncertaintyScenarioInEntryLevelSystemCall_Target(), theUsagemodelPackage.getEntryLevelSystemCall(), null, "target", null, 1, 1, ConnectorUncertaintyScenarioInEntryLevelSystemCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(componentUncertaintySourceEClass, ComponentUncertaintySource.class, "ComponentUncertaintySource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentUncertaintySource_Target(), theCompositionPackage.getAssemblyContext(), null, "target", null, 1, 1, ComponentUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentUncertaintySource_Scenarios(), this.getComponentUncertaintyScenario(), null, "scenarios", null, 0, -1, ComponentUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(componentUncertaintyScenarioEClass, ComponentUncertaintyScenario.class, "ComponentUncertaintyScenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentUncertaintyScenario_Target(), theCompositionPackage.getAssemblyContext(), null, "target", null, 1, 1, ComponentUncertaintyScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //PcmPackageImpl
