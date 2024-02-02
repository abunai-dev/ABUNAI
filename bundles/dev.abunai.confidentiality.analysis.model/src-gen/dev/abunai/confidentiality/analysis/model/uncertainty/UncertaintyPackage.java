/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import tools.mdsd.modelingfoundations.identifier.IdentifierPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyFactory
 * @model kind="package"
 * @generated
 */
public interface UncertaintyPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "uncertainty";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://abunai.dev/uncertainty";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "uncertainty";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UncertaintyPackage eINSTANCE = dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl.init();

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintySourceCollectionImpl <em>Source Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintySourceCollectionImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getUncertaintySourceCollection()
	 * @generated
	 */
	int UNCERTAINTY_SOURCE_COLLECTION = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCERTAINTY_SOURCE_COLLECTION__ID = IdentifierPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCERTAINTY_SOURCE_COLLECTION__ENTITY_NAME = IdentifierPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCERTAINTY_SOURCE_COLLECTION__SOURCES = IdentifierPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Source Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCERTAINTY_SOURCE_COLLECTION_FEATURE_COUNT = IdentifierPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Source Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCERTAINTY_SOURCE_COLLECTION_OPERATION_COUNT = IdentifierPackage.ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintySourceImpl <em>Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintySourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getUncertaintySource()
	 * @generated
	 */
	int UNCERTAINTY_SOURCE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCERTAINTY_SOURCE__ID = IdentifierPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCERTAINTY_SOURCE__ENTITY_NAME = IdentifierPackage.ENTITY__ENTITY_NAME;

	/**
	 * The number of structural features of the '<em>Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCERTAINTY_SOURCE_FEATURE_COUNT = IdentifierPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCERTAINTY_SOURCE_OPERATION_COUNT = IdentifierPackage.ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyScenarioImpl <em>Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyScenarioImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getUncertaintyScenario()
	 * @generated
	 */
	int UNCERTAINTY_SCENARIO = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCERTAINTY_SCENARIO__ID = IdentifierPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCERTAINTY_SCENARIO__ENTITY_NAME = IdentifierPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCERTAINTY_SCENARIO__PROBABILITY = IdentifierPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCERTAINTY_SCENARIO_FEATURE_COUNT = IdentifierPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCERTAINTY_SCENARIO_OPERATION_COUNT = IdentifierPackage.ENTITY_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySourceCollection <em>Source Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source Collection</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySourceCollection
	 * @generated
	 */
	EClass getUncertaintySourceCollection();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySourceCollection#getSources <em>Sources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sources</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySourceCollection#getSources()
	 * @see #getUncertaintySourceCollection()
	 * @generated
	 */
	EReference getUncertaintySourceCollection_Sources();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource
	 * @generated
	 */
	EClass getUncertaintySource();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario <em>Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scenario</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario
	 * @generated
	 */
	EClass getUncertaintyScenario();

	/**
	 * Returns the meta object for the attribute '{@link dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario#getProbability <em>Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Probability</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario#getProbability()
	 * @see #getUncertaintyScenario()
	 * @generated
	 */
	EAttribute getUncertaintyScenario_Probability();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UncertaintyFactory getUncertaintyFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintySourceCollectionImpl <em>Source Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintySourceCollectionImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getUncertaintySourceCollection()
		 * @generated
		 */
		EClass UNCERTAINTY_SOURCE_COLLECTION = eINSTANCE.getUncertaintySourceCollection();

		/**
		 * The meta object literal for the '<em><b>Sources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNCERTAINTY_SOURCE_COLLECTION__SOURCES = eINSTANCE.getUncertaintySourceCollection_Sources();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintySourceImpl <em>Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintySourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getUncertaintySource()
		 * @generated
		 */
		EClass UNCERTAINTY_SOURCE = eINSTANCE.getUncertaintySource();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyScenarioImpl <em>Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyScenarioImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getUncertaintyScenario()
		 * @generated
		 */
		EClass UNCERTAINTY_SCENARIO = eINSTANCE.getUncertaintyScenario();

		/**
		 * The meta object literal for the '<em><b>Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNCERTAINTY_SCENARIO__PROBABILITY = eINSTANCE.getUncertaintyScenario_Probability();

	}

} //UncertaintyPackage
