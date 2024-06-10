/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;

import de.uka.ipd.sdq.stoex.StoexPackage;

import de.uka.ipd.sdq.units.UnitsPackage;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage;

import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDBehaviorUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDBehaviorUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDComponentUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDComponentUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdFactory;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage;

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
	private EClass dfdUncertaintySourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dfdExternalUncertaintySourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dfdExternalUncertaintyScenarioEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dfdBehaviorUncertaintySourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dfdBehaviorUncertaintyScenarioEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dfdInterfaceUncertaintySourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dfdInterfaceUncertaintyScenarioEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dfdConnectorUncertaintySourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dfdConnectorUncertaintyScenarioEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dfdComponentUncertaintySourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dfdComponentUncertaintyScenarioEClass = null;

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
	public EClass getDFDUncertaintySource() {
		return dfdUncertaintySourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDFDExternalUncertaintySource() {
		return dfdExternalUncertaintySourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDFDExternalUncertaintySource_Target() {
		return (EReference)dfdExternalUncertaintySourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDFDExternalUncertaintySource_TargetProperties() {
		return (EReference)dfdExternalUncertaintySourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDFDExternalUncertaintySource_Scenarios() {
		return (EReference)dfdExternalUncertaintySourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDFDExternalUncertaintyScenario() {
		return dfdExternalUncertaintyScenarioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDFDExternalUncertaintyScenario_TargetProperties() {
		return (EReference)dfdExternalUncertaintyScenarioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDFDBehaviorUncertaintySource() {
		return dfdBehaviorUncertaintySourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDFDBehaviorUncertaintySource_Target() {
		return (EReference)dfdBehaviorUncertaintySourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDFDBehaviorUncertaintySource_TargetAssignments() {
		return (EReference)dfdBehaviorUncertaintySourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDFDBehaviorUncertaintySource_Scenarios() {
		return (EReference)dfdBehaviorUncertaintySourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDFDBehaviorUncertaintyScenario() {
		return dfdBehaviorUncertaintyScenarioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDFDBehaviorUncertaintyScenario_TargetAssignments() {
		return (EReference)dfdBehaviorUncertaintyScenarioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDFDInterfaceUncertaintySource() {
		return dfdInterfaceUncertaintySourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDFDInterfaceUncertaintySource_TargetFlow() {
		return (EReference)dfdInterfaceUncertaintySourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDFDInterfaceUncertaintySource_Scenarios() {
		return (EReference)dfdInterfaceUncertaintySourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDFDInterfaceUncertaintyScenario() {
		return dfdInterfaceUncertaintyScenarioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDFDInterfaceUncertaintyScenario_TargetInPin() {
		return (EReference)dfdInterfaceUncertaintyScenarioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDFDInterfaceUncertaintyScenario_TargetNode() {
		return (EReference)dfdInterfaceUncertaintyScenarioEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDFDConnectorUncertaintySource() {
		return dfdConnectorUncertaintySourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDFDConnectorUncertaintySource_TargetAssignments() {
		return (EReference)dfdConnectorUncertaintySourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDFDConnectorUncertaintySource_TargetFlow() {
		return (EReference)dfdConnectorUncertaintySourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDFDConnectorUncertaintySource_Scenarios() {
		return (EReference)dfdConnectorUncertaintySourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDFDConnectorUncertaintyScenario() {
		return dfdConnectorUncertaintyScenarioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDFDConnectorUncertaintyScenario_TargetAssignments() {
		return (EReference)dfdConnectorUncertaintyScenarioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDFDConnectorUncertaintyScenario_TargetPin() {
		return (EReference)dfdConnectorUncertaintyScenarioEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDFDConnectorUncertaintyScenario_TargetNode() {
		return (EReference)dfdConnectorUncertaintyScenarioEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDFDComponentUncertaintySource() {
		return dfdComponentUncertaintySourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDFDComponentUncertaintySource_Target() {
		return (EReference)dfdComponentUncertaintySourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDFDComponentUncertaintySource_Scenarios() {
		return (EReference)dfdComponentUncertaintySourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDFDComponentUncertaintyScenario() {
		return dfdComponentUncertaintyScenarioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDFDComponentUncertaintyScenario_Target() {
		return (EReference)dfdComponentUncertaintyScenarioEClass.getEStructuralFeatures().get(0);
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
		dfdUncertaintySourceEClass = createEClass(DFD_UNCERTAINTY_SOURCE);

		dfdExternalUncertaintySourceEClass = createEClass(DFD_EXTERNAL_UNCERTAINTY_SOURCE);
		createEReference(dfdExternalUncertaintySourceEClass, DFD_EXTERNAL_UNCERTAINTY_SOURCE__TARGET);
		createEReference(dfdExternalUncertaintySourceEClass, DFD_EXTERNAL_UNCERTAINTY_SOURCE__TARGET_PROPERTIES);
		createEReference(dfdExternalUncertaintySourceEClass, DFD_EXTERNAL_UNCERTAINTY_SOURCE__SCENARIOS);

		dfdExternalUncertaintyScenarioEClass = createEClass(DFD_EXTERNAL_UNCERTAINTY_SCENARIO);
		createEReference(dfdExternalUncertaintyScenarioEClass, DFD_EXTERNAL_UNCERTAINTY_SCENARIO__TARGET_PROPERTIES);

		dfdBehaviorUncertaintySourceEClass = createEClass(DFD_BEHAVIOR_UNCERTAINTY_SOURCE);
		createEReference(dfdBehaviorUncertaintySourceEClass, DFD_BEHAVIOR_UNCERTAINTY_SOURCE__TARGET);
		createEReference(dfdBehaviorUncertaintySourceEClass, DFD_BEHAVIOR_UNCERTAINTY_SOURCE__TARGET_ASSIGNMENTS);
		createEReference(dfdBehaviorUncertaintySourceEClass, DFD_BEHAVIOR_UNCERTAINTY_SOURCE__SCENARIOS);

		dfdBehaviorUncertaintyScenarioEClass = createEClass(DFD_BEHAVIOR_UNCERTAINTY_SCENARIO);
		createEReference(dfdBehaviorUncertaintyScenarioEClass, DFD_BEHAVIOR_UNCERTAINTY_SCENARIO__TARGET_ASSIGNMENTS);

		dfdInterfaceUncertaintySourceEClass = createEClass(DFD_INTERFACE_UNCERTAINTY_SOURCE);
		createEReference(dfdInterfaceUncertaintySourceEClass, DFD_INTERFACE_UNCERTAINTY_SOURCE__TARGET_FLOW);
		createEReference(dfdInterfaceUncertaintySourceEClass, DFD_INTERFACE_UNCERTAINTY_SOURCE__SCENARIOS);

		dfdInterfaceUncertaintyScenarioEClass = createEClass(DFD_INTERFACE_UNCERTAINTY_SCENARIO);
		createEReference(dfdInterfaceUncertaintyScenarioEClass, DFD_INTERFACE_UNCERTAINTY_SCENARIO__TARGET_IN_PIN);
		createEReference(dfdInterfaceUncertaintyScenarioEClass, DFD_INTERFACE_UNCERTAINTY_SCENARIO__TARGET_NODE);

		dfdConnectorUncertaintySourceEClass = createEClass(DFD_CONNECTOR_UNCERTAINTY_SOURCE);
		createEReference(dfdConnectorUncertaintySourceEClass, DFD_CONNECTOR_UNCERTAINTY_SOURCE__TARGET_ASSIGNMENTS);
		createEReference(dfdConnectorUncertaintySourceEClass, DFD_CONNECTOR_UNCERTAINTY_SOURCE__TARGET_FLOW);
		createEReference(dfdConnectorUncertaintySourceEClass, DFD_CONNECTOR_UNCERTAINTY_SOURCE__SCENARIOS);

		dfdConnectorUncertaintyScenarioEClass = createEClass(DFD_CONNECTOR_UNCERTAINTY_SCENARIO);
		createEReference(dfdConnectorUncertaintyScenarioEClass, DFD_CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_ASSIGNMENTS);
		createEReference(dfdConnectorUncertaintyScenarioEClass, DFD_CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_PIN);
		createEReference(dfdConnectorUncertaintyScenarioEClass, DFD_CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_NODE);

		dfdComponentUncertaintySourceEClass = createEClass(DFD_COMPONENT_UNCERTAINTY_SOURCE);
		createEReference(dfdComponentUncertaintySourceEClass, DFD_COMPONENT_UNCERTAINTY_SOURCE__TARGET);
		createEReference(dfdComponentUncertaintySourceEClass, DFD_COMPONENT_UNCERTAINTY_SOURCE__SCENARIOS);

		dfdComponentUncertaintyScenarioEClass = createEClass(DFD_COMPONENT_UNCERTAINTY_SCENARIO);
		createEReference(dfdComponentUncertaintyScenarioEClass, DFD_COMPONENT_UNCERTAINTY_SCENARIO__TARGET);
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
		dfdUncertaintySourceEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintySource());
		dfdExternalUncertaintySourceEClass.getESuperTypes().add(this.getDFDUncertaintySource());
		dfdExternalUncertaintyScenarioEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintyScenario());
		dfdBehaviorUncertaintySourceEClass.getESuperTypes().add(this.getDFDUncertaintySource());
		dfdBehaviorUncertaintyScenarioEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintyScenario());
		dfdInterfaceUncertaintySourceEClass.getESuperTypes().add(this.getDFDUncertaintySource());
		dfdInterfaceUncertaintyScenarioEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintyScenario());
		dfdConnectorUncertaintySourceEClass.getESuperTypes().add(this.getDFDUncertaintySource());
		dfdConnectorUncertaintyScenarioEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintyScenario());
		dfdComponentUncertaintySourceEClass.getESuperTypes().add(this.getDFDUncertaintySource());
		dfdComponentUncertaintyScenarioEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintyScenario());

		// Initialize classes, features, and operations; add parameters
		initEClass(dfdUncertaintySourceEClass, DFDUncertaintySource.class, "DFDUncertaintySource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dfdExternalUncertaintySourceEClass, DFDExternalUncertaintySource.class, "DFDExternalUncertaintySource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDFDExternalUncertaintySource_Target(), thedataflowdiagramPackage.getNode(), null, "target", null, 1, 1, DFDExternalUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDFDExternalUncertaintySource_TargetProperties(), thedatadictionaryPackage.getLabel(), null, "targetProperties", null, 0, -1, DFDExternalUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDFDExternalUncertaintySource_Scenarios(), this.getDFDExternalUncertaintyScenario(), null, "scenarios", null, 0, -1, DFDExternalUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dfdExternalUncertaintyScenarioEClass, DFDExternalUncertaintyScenario.class, "DFDExternalUncertaintyScenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDFDExternalUncertaintyScenario_TargetProperties(), thedatadictionaryPackage.getLabel(), null, "targetProperties", null, 0, -1, DFDExternalUncertaintyScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dfdBehaviorUncertaintySourceEClass, DFDBehaviorUncertaintySource.class, "DFDBehaviorUncertaintySource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDFDBehaviorUncertaintySource_Target(), thedatadictionaryPackage.getBehaviour(), null, "target", null, 1, 1, DFDBehaviorUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDFDBehaviorUncertaintySource_TargetAssignments(), thedatadictionaryPackage.getAbstractAssignment(), null, "targetAssignments", null, 0, -1, DFDBehaviorUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDFDBehaviorUncertaintySource_Scenarios(), this.getDFDBehaviorUncertaintyScenario(), null, "scenarios", null, 0, -1, DFDBehaviorUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dfdBehaviorUncertaintyScenarioEClass, DFDBehaviorUncertaintyScenario.class, "DFDBehaviorUncertaintyScenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDFDBehaviorUncertaintyScenario_TargetAssignments(), thedatadictionaryPackage.getAbstractAssignment(), null, "targetAssignments", null, 0, -1, DFDBehaviorUncertaintyScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dfdInterfaceUncertaintySourceEClass, DFDInterfaceUncertaintySource.class, "DFDInterfaceUncertaintySource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDFDInterfaceUncertaintySource_TargetFlow(), thedataflowdiagramPackage.getFlow(), null, "targetFlow", null, 1, 1, DFDInterfaceUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDFDInterfaceUncertaintySource_Scenarios(), this.getDFDInterfaceUncertaintyScenario(), null, "scenarios", null, 0, -1, DFDInterfaceUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dfdInterfaceUncertaintyScenarioEClass, DFDInterfaceUncertaintyScenario.class, "DFDInterfaceUncertaintyScenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDFDInterfaceUncertaintyScenario_TargetInPin(), thedatadictionaryPackage.getPin(), null, "targetInPin", null, 1, 1, DFDInterfaceUncertaintyScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDFDInterfaceUncertaintyScenario_TargetNode(), thedataflowdiagramPackage.getNode(), null, "targetNode", null, 1, 1, DFDInterfaceUncertaintyScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dfdConnectorUncertaintySourceEClass, DFDConnectorUncertaintySource.class, "DFDConnectorUncertaintySource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDFDConnectorUncertaintySource_TargetAssignments(), thedatadictionaryPackage.getAbstractAssignment(), null, "targetAssignments", null, 0, -1, DFDConnectorUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDFDConnectorUncertaintySource_TargetFlow(), thedataflowdiagramPackage.getFlow(), null, "targetFlow", null, 1, 1, DFDConnectorUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDFDConnectorUncertaintySource_Scenarios(), this.getDFDConnectorUncertaintyScenario(), null, "scenarios", null, 0, -1, DFDConnectorUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dfdConnectorUncertaintyScenarioEClass, DFDConnectorUncertaintyScenario.class, "DFDConnectorUncertaintyScenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDFDConnectorUncertaintyScenario_TargetAssignments(), thedatadictionaryPackage.getAbstractAssignment(), null, "targetAssignments", null, 0, -1, DFDConnectorUncertaintyScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDFDConnectorUncertaintyScenario_TargetPin(), thedatadictionaryPackage.getPin(), null, "targetPin", null, 1, 1, DFDConnectorUncertaintyScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDFDConnectorUncertaintyScenario_TargetNode(), thedataflowdiagramPackage.getNode(), null, "targetNode", null, 1, 1, DFDConnectorUncertaintyScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dfdComponentUncertaintySourceEClass, DFDComponentUncertaintySource.class, "DFDComponentUncertaintySource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDFDComponentUncertaintySource_Target(), thedataflowdiagramPackage.getNode(), null, "target", null, 1, 1, DFDComponentUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDFDComponentUncertaintySource_Scenarios(), this.getDFDComponentUncertaintyScenario(), null, "scenarios", null, 0, -1, DFDComponentUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dfdComponentUncertaintyScenarioEClass, DFDComponentUncertaintyScenario.class, "DFDComponentUncertaintyScenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDFDComponentUncertaintyScenario_Target(), thedataflowdiagramPackage.getNode(), null, "target", null, 1, 1, DFDComponentUncertaintyScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //DfdPackageImpl
