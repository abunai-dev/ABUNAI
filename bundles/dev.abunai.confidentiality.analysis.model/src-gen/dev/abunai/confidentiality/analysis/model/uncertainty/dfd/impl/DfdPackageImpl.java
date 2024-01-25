/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;

import de.uka.ipd.sdq.stoex.StoexPackage;

import de.uka.ipd.sdq.units.UnitsPackage;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage;

import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.BehaviorUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.BehaviorUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ComponentUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ComponentUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ConnectorUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ConnectorUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdFactory;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ExternalUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ExternalUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.InterfaceUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.InterfaceUncertaintySource;

import dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl;

import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl;

import org.dataflowanalysis.dfd.datadictionary.datadictionaryPackage;

import org.dataflowanalysis.dfd.dataflowdiagram.dataflowdiagramPackage;

import org.dataflowanalysis.pcm.extension.dictionary.DataDictionary.DataDictionaryPackage;

import org.dataflowanalysis.pcm.extension.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage;

import org.dataflowanalysis.pcm.extension.model.confidentiality.ConfidentialityPackage;

import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.NodeCharacteristicsPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.palladiosimulator.pcm.PcmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DfdPackageImpl extends EPackageImpl implements DfdPackage {
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
	private EClass externalUncertaintyScenarioEClass = null;

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
	private EClass connectorUncertaintyScenarioEClass = null;

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
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DfdPackageImpl() {
		super(eNS_URI, DfdFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DfdPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DfdPackage init() {
		if (isInited) return (DfdPackage)EPackage.Registry.INSTANCE.getEPackage(DfdPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredDfdPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		DfdPackageImpl theDfdPackage = registeredDfdPackage instanceof DfdPackageImpl ? (DfdPackageImpl)registeredDfdPackage : new DfdPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		DataDictionaryPackage.eINSTANCE.eClass();
		DataDictionaryCharacterizedPackage.eINSTANCE.eClass();
		ConfidentialityPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		IdentifierPackage.eINSTANCE.eClass();
		NodeCharacteristicsPackage.eINSTANCE.eClass();
		PcmPackage.eINSTANCE.eClass();
		ProbfunctionPackage.eINSTANCE.eClass();
		StoexPackage.eINSTANCE.eClass();
		UnitsPackage.eINSTANCE.eClass();
		tools.mdsd.modelingfoundations.identifier.IdentifierPackage.eINSTANCE.eClass();
		datadictionaryPackage.eINSTANCE.eClass();
		dataflowdiagramPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(UncertaintyPackage.eNS_URI);
		UncertaintyPackageImpl theUncertaintyPackage = (UncertaintyPackageImpl)(registeredPackage instanceof UncertaintyPackageImpl ? registeredPackage : UncertaintyPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage.eNS_URI);
		PcmPackageImpl thePcmPackage_1 = (PcmPackageImpl)(registeredPackage instanceof PcmPackageImpl ? registeredPackage : dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage.eINSTANCE);

		// Create package meta-data objects
		theDfdPackage.createPackageContents();
		theUncertaintyPackage.createPackageContents();
		thePcmPackage_1.createPackageContents();

		// Initialize created meta-data
		theDfdPackage.initializePackageContents();
		theUncertaintyPackage.initializePackageContents();
		thePcmPackage_1.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDfdPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DfdPackage.eNS_URI, theDfdPackage);
		return theDfdPackage;
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
	public EReference getExternalUncertaintySource_Target() {
		return (EReference)externalUncertaintySourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExternalUncertaintySource_TargetProperties() {
		return (EReference)externalUncertaintySourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExternalUncertaintySource_Scenarios() {
		return (EReference)externalUncertaintySourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalUncertaintyScenario() {
		return externalUncertaintyScenarioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExternalUncertaintyScenario_TargetProperties() {
		return (EReference)externalUncertaintyScenarioEClass.getEStructuralFeatures().get(0);
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
	public EReference getBehaviorUncertaintySource_TargetAssignments() {
		return (EReference)behaviorUncertaintySourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorUncertaintySource_Scenarios() {
		return (EReference)behaviorUncertaintySourceEClass.getEStructuralFeatures().get(2);
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
	public EReference getBehaviorUncertaintyScenario_TargetAssignments() {
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
	public EReference getInterfaceUncertaintySource_TargetInPin() {
		return (EReference)interfaceUncertaintySourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceUncertaintySource_TargetFlow() {
		return (EReference)interfaceUncertaintySourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceUncertaintySource_Scenarios() {
		return (EReference)interfaceUncertaintySourceEClass.getEStructuralFeatures().get(2);
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
	public EReference getInterfaceUncertaintyScenario_TargetInPin() {
		return (EReference)interfaceUncertaintyScenarioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceUncertaintyScenario_TargetFlow() {
		return (EReference)interfaceUncertaintyScenarioEClass.getEStructuralFeatures().get(1);
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
	public EReference getConnectorUncertaintySource_TargetAssignement() {
		return (EReference)connectorUncertaintySourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectorUncertaintySource_TargetFlow() {
		return (EReference)connectorUncertaintySourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectorUncertaintySource_Scenarios() {
		return (EReference)connectorUncertaintySourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectorUncertaintyScenario() {
		return connectorUncertaintyScenarioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectorUncertaintyScenario_TargetAssignment() {
		return (EReference)connectorUncertaintyScenarioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectorUncertaintyScenario_TargetFlow() {
		return (EReference)connectorUncertaintyScenarioEClass.getEStructuralFeatures().get(1);
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
	public DfdFactory getDfdFactory() {
		return (DfdFactory)getEFactoryInstance();
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
		createEReference(externalUncertaintySourceEClass, EXTERNAL_UNCERTAINTY_SOURCE__TARGET);
		createEReference(externalUncertaintySourceEClass, EXTERNAL_UNCERTAINTY_SOURCE__TARGET_PROPERTIES);
		createEReference(externalUncertaintySourceEClass, EXTERNAL_UNCERTAINTY_SOURCE__SCENARIOS);

		externalUncertaintyScenarioEClass = createEClass(EXTERNAL_UNCERTAINTY_SCENARIO);
		createEReference(externalUncertaintyScenarioEClass, EXTERNAL_UNCERTAINTY_SCENARIO__TARGET_PROPERTIES);

		behaviorUncertaintySourceEClass = createEClass(BEHAVIOR_UNCERTAINTY_SOURCE);
		createEReference(behaviorUncertaintySourceEClass, BEHAVIOR_UNCERTAINTY_SOURCE__TARGET);
		createEReference(behaviorUncertaintySourceEClass, BEHAVIOR_UNCERTAINTY_SOURCE__TARGET_ASSIGNMENTS);
		createEReference(behaviorUncertaintySourceEClass, BEHAVIOR_UNCERTAINTY_SOURCE__SCENARIOS);

		behaviorUncertaintyScenarioEClass = createEClass(BEHAVIOR_UNCERTAINTY_SCENARIO);
		createEReference(behaviorUncertaintyScenarioEClass, BEHAVIOR_UNCERTAINTY_SCENARIO__TARGET_ASSIGNMENTS);

		interfaceUncertaintySourceEClass = createEClass(INTERFACE_UNCERTAINTY_SOURCE);
		createEReference(interfaceUncertaintySourceEClass, INTERFACE_UNCERTAINTY_SOURCE__TARGET_IN_PIN);
		createEReference(interfaceUncertaintySourceEClass, INTERFACE_UNCERTAINTY_SOURCE__TARGET_FLOW);
		createEReference(interfaceUncertaintySourceEClass, INTERFACE_UNCERTAINTY_SOURCE__SCENARIOS);

		interfaceUncertaintyScenarioEClass = createEClass(INTERFACE_UNCERTAINTY_SCENARIO);
		createEReference(interfaceUncertaintyScenarioEClass, INTERFACE_UNCERTAINTY_SCENARIO__TARGET_IN_PIN);
		createEReference(interfaceUncertaintyScenarioEClass, INTERFACE_UNCERTAINTY_SCENARIO__TARGET_FLOW);

		connectorUncertaintySourceEClass = createEClass(CONNECTOR_UNCERTAINTY_SOURCE);
		createEReference(connectorUncertaintySourceEClass, CONNECTOR_UNCERTAINTY_SOURCE__TARGET_ASSIGNEMENT);
		createEReference(connectorUncertaintySourceEClass, CONNECTOR_UNCERTAINTY_SOURCE__TARGET_FLOW);
		createEReference(connectorUncertaintySourceEClass, CONNECTOR_UNCERTAINTY_SOURCE__SCENARIOS);

		connectorUncertaintyScenarioEClass = createEClass(CONNECTOR_UNCERTAINTY_SCENARIO);
		createEReference(connectorUncertaintyScenarioEClass, CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_ASSIGNMENT);
		createEReference(connectorUncertaintyScenarioEClass, CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_FLOW);

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
		dataflowdiagramPackage thedataflowdiagramPackage = (dataflowdiagramPackage)EPackage.Registry.INSTANCE.getEPackage(dataflowdiagramPackage.eNS_URI);
		datadictionaryPackage thedatadictionaryPackage = (datadictionaryPackage)EPackage.Registry.INSTANCE.getEPackage(datadictionaryPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		externalUncertaintySourceEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintySource());
		externalUncertaintyScenarioEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintyScenario());
		behaviorUncertaintySourceEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintySource());
		behaviorUncertaintyScenarioEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintyScenario());
		interfaceUncertaintySourceEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintySource());
		interfaceUncertaintyScenarioEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintyScenario());
		connectorUncertaintySourceEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintySource());
		connectorUncertaintyScenarioEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintyScenario());
		componentUncertaintySourceEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintySource());
		componentUncertaintyScenarioEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintyScenario());

		// Initialize classes, features, and operations; add parameters
		initEClass(externalUncertaintySourceEClass, ExternalUncertaintySource.class, "ExternalUncertaintySource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExternalUncertaintySource_Target(), thedataflowdiagramPackage.getNode(), null, "target", null, 1, 1, ExternalUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExternalUncertaintySource_TargetProperties(), thedatadictionaryPackage.getLabel(), null, "targetProperties", null, 1, -1, ExternalUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExternalUncertaintySource_Scenarios(), this.getExternalUncertaintyScenario(), null, "scenarios", null, 0, -1, ExternalUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(externalUncertaintyScenarioEClass, ExternalUncertaintyScenario.class, "ExternalUncertaintyScenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExternalUncertaintyScenario_TargetProperties(), thedatadictionaryPackage.getLabel(), null, "targetProperties", null, 0, -1, ExternalUncertaintyScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(behaviorUncertaintySourceEClass, BehaviorUncertaintySource.class, "BehaviorUncertaintySource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBehaviorUncertaintySource_Target(), thedatadictionaryPackage.getBehaviour(), null, "target", null, 1, 1, BehaviorUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorUncertaintySource_TargetAssignments(), thedatadictionaryPackage.getAbstractAssignment(), null, "targetAssignments", null, 1, -1, BehaviorUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBehaviorUncertaintySource_Scenarios(), this.getBehaviorUncertaintyScenario(), null, "scenarios", null, 0, -1, BehaviorUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(behaviorUncertaintyScenarioEClass, BehaviorUncertaintyScenario.class, "BehaviorUncertaintyScenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBehaviorUncertaintyScenario_TargetAssignments(), thedatadictionaryPackage.getAbstractAssignment(), null, "targetAssignments", null, 0, -1, BehaviorUncertaintyScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceUncertaintySourceEClass, InterfaceUncertaintySource.class, "InterfaceUncertaintySource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterfaceUncertaintySource_TargetInPin(), thedatadictionaryPackage.getPin(), null, "targetInPin", null, 1, 1, InterfaceUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterfaceUncertaintySource_TargetFlow(), thedataflowdiagramPackage.getFlow(), null, "targetFlow", null, 1, 1, InterfaceUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterfaceUncertaintySource_Scenarios(), this.getInterfaceUncertaintyScenario(), null, "scenarios", null, 0, -1, InterfaceUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceUncertaintyScenarioEClass, InterfaceUncertaintyScenario.class, "InterfaceUncertaintyScenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterfaceUncertaintyScenario_TargetInPin(), thedatadictionaryPackage.getPin(), null, "targetInPin", null, 1, 1, InterfaceUncertaintyScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterfaceUncertaintyScenario_TargetFlow(), thedataflowdiagramPackage.getFlow(), null, "targetFlow", null, 1, 1, InterfaceUncertaintyScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectorUncertaintySourceEClass, ConnectorUncertaintySource.class, "ConnectorUncertaintySource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnectorUncertaintySource_TargetAssignement(), thedatadictionaryPackage.getAbstractAssignment(), null, "targetAssignement", null, 1, 1, ConnectorUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectorUncertaintySource_TargetFlow(), thedataflowdiagramPackage.getFlow(), null, "targetFlow", null, 1, 1, ConnectorUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectorUncertaintySource_Scenarios(), this.getConnectorUncertaintyScenario(), null, "scenarios", null, 0, -1, ConnectorUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectorUncertaintyScenarioEClass, ConnectorUncertaintyScenario.class, "ConnectorUncertaintyScenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnectorUncertaintyScenario_TargetAssignment(), thedatadictionaryPackage.getAbstractAssignment(), null, "targetAssignment", null, 1, 1, ConnectorUncertaintyScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectorUncertaintyScenario_TargetFlow(), thedataflowdiagramPackage.getFlow(), null, "targetFlow", null, 1, 1, ConnectorUncertaintyScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(componentUncertaintySourceEClass, ComponentUncertaintySource.class, "ComponentUncertaintySource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentUncertaintySource_Target(), thedataflowdiagramPackage.getNode(), null, "target", null, 1, 1, ComponentUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentUncertaintySource_Scenarios(), this.getComponentUncertaintyScenario(), null, "scenarios", null, 0, -1, ComponentUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(componentUncertaintyScenarioEClass, ComponentUncertaintyScenario.class, "ComponentUncertaintyScenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentUncertaintyScenario_Target(), thedataflowdiagramPackage.getNode(), null, "target", null, 1, 1, ComponentUncertaintyScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //DfdPackageImpl
