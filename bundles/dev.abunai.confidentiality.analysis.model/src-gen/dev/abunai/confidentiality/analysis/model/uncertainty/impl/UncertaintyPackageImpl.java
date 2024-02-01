/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.impl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;

import de.uka.ipd.sdq.stoex.StoexPackage;

import de.uka.ipd.sdq.units.UnitsPackage;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyFactory;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySourceCollection;

import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage;

import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl;

import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl;

import org.dataflowanalysis.dfd.datadictionary.datadictionaryPackage;

import org.dataflowanalysis.dfd.dataflowdiagram.dataflowdiagramPackage;

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
		tools.mdsd.modelingfoundations.identifier.IdentifierPackage.eINSTANCE.eClass();
		datadictionaryPackage.eINSTANCE.eClass();
		dataflowdiagramPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage.eNS_URI);
		PcmPackageImpl thePcmPackage_1 = (PcmPackageImpl)(registeredPackage instanceof PcmPackageImpl ? registeredPackage : dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(DfdPackage.eNS_URI);
		DfdPackageImpl theDfdPackage = (DfdPackageImpl)(registeredPackage instanceof DfdPackageImpl ? registeredPackage : DfdPackage.eINSTANCE);

		// Create package meta-data objects
		theUncertaintyPackage.createPackageContents();
		thePcmPackage_1.createPackageContents();
		theDfdPackage.createPackageContents();

		// Initialize created meta-data
		theUncertaintyPackage.initializePackageContents();
		thePcmPackage_1.initializePackageContents();
		theDfdPackage.initializePackageContents();

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
		dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage thePcmPackage_1 = (dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage)EPackage.Registry.INSTANCE.getEPackage(dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage.eNS_URI);
		DfdPackage theDfdPackage = (DfdPackage)EPackage.Registry.INSTANCE.getEPackage(DfdPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(thePcmPackage_1);
		getESubpackages().add(theDfdPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(uncertaintySourceCollectionEClass, UncertaintySourceCollection.class, "UncertaintySourceCollection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUncertaintySourceCollection_Sources(), this.getUncertaintySource(), null, "sources", null, 0, -1, UncertaintySourceCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(uncertaintySourceEClass, UncertaintySource.class, "UncertaintySource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(uncertaintyScenarioEClass, UncertaintyScenario.class, "UncertaintyScenario", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUncertaintyScenario_Probability(), ecorePackage.getEDouble(), "probability", "-1.0", 1, 1, UncertaintyScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //UncertaintyPackageImpl
