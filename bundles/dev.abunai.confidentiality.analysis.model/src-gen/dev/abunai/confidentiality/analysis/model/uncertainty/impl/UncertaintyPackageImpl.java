/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.impl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;

import de.uka.ipd.sdq.stoex.StoexPackage;

import de.uka.ipd.sdq.units.UnitsPackage;

import dev.abunai.confidentiality.analysis.model.uncertainty.BehaviorUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.BehaviorUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintyInResourceScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintyInUsageScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintySourceInResource;
import dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintySourceInUsage;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyFactory;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySourceCollection;

import org.dataflowanalysis.pcm.extension.dictionary.DataDictionary.DataDictionaryPackage;

import org.dataflowanalysis.pcm.extension.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage;

import org.dataflowanalysis.pcm.extension.model.confidentiality.ConfidentialityPackage;

import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.NodeCharacteristicsPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.palladiosimulator.pcm.PcmPackage;

import org.palladiosimulator.pcm.seff.SeffPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UncertaintyPackageImpl extends EPackageImpl implements UncertaintyPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uncertaintySourceCollectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uncertaintySourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uncertaintyScenarioEClass = null;

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
	private EClass externalUncertaintyInResourceScenarioEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalUncertaintyInUsageScenarioEClass = null;

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
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UncertaintyPackageImpl() {
		super(eNS_URI, UncertaintyFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link UncertaintyPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UncertaintyPackage init() {
		if (isInited) return (UncertaintyPackage)EPackage.Registry.INSTANCE.getEPackage(UncertaintyPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredUncertaintyPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		UncertaintyPackageImpl theUncertaintyPackage = registeredUncertaintyPackage instanceof UncertaintyPackageImpl ? (UncertaintyPackageImpl)registeredUncertaintyPackage : new UncertaintyPackageImpl();

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

		// Create package meta-data objects
		theUncertaintyPackage.createPackageContents();

		// Initialize created meta-data
		theUncertaintyPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUncertaintyPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UncertaintyPackage.eNS_URI, theUncertaintyPackage);
		return theUncertaintyPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUncertaintySourceCollection() {
		return uncertaintySourceCollectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUncertaintySourceCollection_Sources() {
		return (EReference)uncertaintySourceCollectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUncertaintySource() {
		return uncertaintySourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUncertaintyScenario() {
		return uncertaintyScenarioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUncertaintyScenario_Probability() {
		return (EAttribute)uncertaintyScenarioEClass.getEStructuralFeatures().get(0);
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
	public EClass getExternalUncertaintyInResourceScenario() {
		return externalUncertaintyInResourceScenarioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExternalUncertaintyInResourceScenario_Target() {
		return (EReference)externalUncertaintyInResourceScenarioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalUncertaintyInUsageScenario() {
		return externalUncertaintyInUsageScenarioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExternalUncertaintyInUsageScenario_Targetd() {
		return (EReference)externalUncertaintyInUsageScenarioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UncertaintyFactory getUncertaintyFactory() {
		return (UncertaintyFactory)getEFactoryInstance();
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
		uncertaintySourceCollectionEClass = createEClass(UNCERTAINTY_SOURCE_COLLECTION);
		createEReference(uncertaintySourceCollectionEClass, UNCERTAINTY_SOURCE_COLLECTION__SOURCES);

		uncertaintySourceEClass = createEClass(UNCERTAINTY_SOURCE);

		uncertaintyScenarioEClass = createEClass(UNCERTAINTY_SCENARIO);
		createEAttribute(uncertaintyScenarioEClass, UNCERTAINTY_SCENARIO__PROBABILITY);

		behaviorUncertaintySourceEClass = createEClass(BEHAVIOR_UNCERTAINTY_SOURCE);
		createEReference(behaviorUncertaintySourceEClass, BEHAVIOR_UNCERTAINTY_SOURCE__TARGET);
		createEReference(behaviorUncertaintySourceEClass, BEHAVIOR_UNCERTAINTY_SOURCE__SCENARIOS);

		behaviorUncertaintyScenarioEClass = createEClass(BEHAVIOR_UNCERTAINTY_SCENARIO);
		createEReference(behaviorUncertaintyScenarioEClass, BEHAVIOR_UNCERTAINTY_SCENARIO__TARGET);

		externalUncertaintySourceEClass = createEClass(EXTERNAL_UNCERTAINTY_SOURCE);

		externalUncertaintySourceInResourceEClass = createEClass(EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE);
		createEReference(externalUncertaintySourceInResourceEClass, EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE__TARGET);
		createEReference(externalUncertaintySourceInResourceEClass, EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE__SCENARIOS);

		externalUncertaintySourceInUsageEClass = createEClass(EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE);
		createEReference(externalUncertaintySourceInUsageEClass, EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__TARGET);
		createEReference(externalUncertaintySourceInUsageEClass, EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__SCENARIOS);

		externalUncertaintyInResourceScenarioEClass = createEClass(EXTERNAL_UNCERTAINTY_IN_RESOURCE_SCENARIO);
		createEReference(externalUncertaintyInResourceScenarioEClass, EXTERNAL_UNCERTAINTY_IN_RESOURCE_SCENARIO__TARGET);

		externalUncertaintyInUsageScenarioEClass = createEClass(EXTERNAL_UNCERTAINTY_IN_USAGE_SCENARIO);
		createEReference(externalUncertaintyInUsageScenarioEClass, EXTERNAL_UNCERTAINTY_IN_USAGE_SCENARIO__TARGETD);
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
		SeffPackage theSeffPackage = (SeffPackage)EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI);
		NodeCharacteristicsPackage theNodeCharacteristicsPackage = (NodeCharacteristicsPackage)EPackage.Registry.INSTANCE.getEPackage(NodeCharacteristicsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		behaviorUncertaintySourceEClass.getESuperTypes().add(this.getUncertaintySource());
		behaviorUncertaintyScenarioEClass.getESuperTypes().add(this.getUncertaintyScenario());
		externalUncertaintySourceEClass.getESuperTypes().add(this.getUncertaintySource());
		externalUncertaintySourceInResourceEClass.getESuperTypes().add(this.getExternalUncertaintySource());
		externalUncertaintySourceInUsageEClass.getESuperTypes().add(this.getExternalUncertaintySource());
		externalUncertaintyInResourceScenarioEClass.getESuperTypes().add(this.getUncertaintyScenario());
		externalUncertaintyInUsageScenarioEClass.getESuperTypes().add(this.getUncertaintyScenario());

		// Initialize classes, features, and operations; add parameters
		initEClass(uncertaintySourceCollectionEClass, UncertaintySourceCollection.class, "UncertaintySourceCollection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUncertaintySourceCollection_Sources(), this.getUncertaintySource(), null, "sources", null, 0, -1, UncertaintySourceCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(uncertaintySourceEClass, UncertaintySource.class, "UncertaintySource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(uncertaintyScenarioEClass, UncertaintyScenario.class, "UncertaintyScenario", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUncertaintyScenario_Probability(), ecorePackage.getEDouble(), "probability", null, 0, 1, UncertaintyScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(behaviorUncertaintySourceEClass, BehaviorUncertaintySource.class, "BehaviorUncertaintySource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBehaviorUncertaintySource_Target(), theSeffPackage.getSetVariableAction(), null, "target", null, 1, 1, BehaviorUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorUncertaintySource_Scenarios(), this.getBehaviorUncertaintyScenario(), null, "scenarios", null, 0, -1, BehaviorUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(behaviorUncertaintyScenarioEClass, BehaviorUncertaintyScenario.class, "BehaviorUncertaintyScenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBehaviorUncertaintyScenario_Target(), theSeffPackage.getSetVariableAction(), null, "target", null, 1, 1, BehaviorUncertaintyScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(externalUncertaintySourceEClass, ExternalUncertaintySource.class, "ExternalUncertaintySource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(externalUncertaintySourceInResourceEClass, ExternalUncertaintySourceInResource.class, "ExternalUncertaintySourceInResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExternalUncertaintySourceInResource_Target(), theNodeCharacteristicsPackage.getRessourceAssignee(), null, "target", null, 1, 1, ExternalUncertaintySourceInResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExternalUncertaintySourceInResource_Scenarios(), this.getExternalUncertaintyInResourceScenario(), null, "scenarios", null, 0, -1, ExternalUncertaintySourceInResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(externalUncertaintySourceInUsageEClass, ExternalUncertaintySourceInUsage.class, "ExternalUncertaintySourceInUsage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExternalUncertaintySourceInUsage_Target(), theNodeCharacteristicsPackage.getUsageAsignee(), null, "target", null, 1, 1, ExternalUncertaintySourceInUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExternalUncertaintySourceInUsage_Scenarios(), this.getExternalUncertaintyInUsageScenario(), null, "scenarios", null, 0, -1, ExternalUncertaintySourceInUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(externalUncertaintyInResourceScenarioEClass, ExternalUncertaintyInResourceScenario.class, "ExternalUncertaintyInResourceScenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExternalUncertaintyInResourceScenario_Target(), theNodeCharacteristicsPackage.getRessourceAssignee(), null, "target", null, 1, 1, ExternalUncertaintyInResourceScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(externalUncertaintyInUsageScenarioEClass, ExternalUncertaintyInUsageScenario.class, "ExternalUncertaintyInUsageScenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExternalUncertaintyInUsageScenario_Targetd(), theNodeCharacteristicsPackage.getUsageAsignee(), null, "targetd", null, 1, 1, ExternalUncertaintyInUsageScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //UncertaintyPackageImpl
