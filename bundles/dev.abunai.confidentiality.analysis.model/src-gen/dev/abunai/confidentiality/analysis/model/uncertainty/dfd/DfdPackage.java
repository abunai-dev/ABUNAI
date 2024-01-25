/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.dfd;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdFactory
 * @model kind="package"
 * @generated
 */
public interface DfdPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "dfd";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://abunai.dev/uncertainty/dfd";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "dfd";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DfdPackage eINSTANCE = dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl.init();

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.ExternalUncertaintySourceImpl <em>External Uncertainty Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.ExternalUncertaintySourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getExternalUncertaintySource()
	 * @generated
	 */
	int EXTERNAL_UNCERTAINTY_SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SOURCE__TARGET = UncertaintyPackage.UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SOURCE__TARGET_PROPERTIES = UncertaintyPackage.UNCERTAINTY_SOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SOURCE__SCENARIOS = UncertaintyPackage.UNCERTAINTY_SOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>External Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SOURCE_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SOURCE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>External Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SOURCE_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.ExternalUncertaintyScenarioImpl <em>External Uncertainty Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.ExternalUncertaintyScenarioImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getExternalUncertaintyScenario()
	 * @generated
	 */
	int EXTERNAL_UNCERTAINTY_SCENARIO = 1;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SCENARIO__PROBABILITY = UncertaintyPackage.UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SCENARIO__TARGET_PROPERTIES = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>External Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SCENARIO_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>External Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SCENARIO_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ExternalUncertaintySource <em>External Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Uncertainty Source</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ExternalUncertaintySource
	 * @generated
	 */
	EClass getExternalUncertaintySource();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ExternalUncertaintySource#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ExternalUncertaintySource#getTarget()
	 * @see #getExternalUncertaintySource()
	 * @generated
	 */
	EReference getExternalUncertaintySource_Target();

	/**
	 * Returns the meta object for the reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ExternalUncertaintySource#getTargetProperties <em>Target Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target Properties</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ExternalUncertaintySource#getTargetProperties()
	 * @see #getExternalUncertaintySource()
	 * @generated
	 */
	EReference getExternalUncertaintySource_TargetProperties();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ExternalUncertaintySource#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenarios</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ExternalUncertaintySource#getScenarios()
	 * @see #getExternalUncertaintySource()
	 * @generated
	 */
	EReference getExternalUncertaintySource_Scenarios();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ExternalUncertaintyScenario <em>External Uncertainty Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Uncertainty Scenario</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ExternalUncertaintyScenario
	 * @generated
	 */
	EClass getExternalUncertaintyScenario();

	/**
	 * Returns the meta object for the reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ExternalUncertaintyScenario#getTargetProperties <em>Target Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target Properties</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ExternalUncertaintyScenario#getTargetProperties()
	 * @see #getExternalUncertaintyScenario()
	 * @generated
	 */
	EReference getExternalUncertaintyScenario_TargetProperties();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DfdFactory getDfdFactory();

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
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.ExternalUncertaintySourceImpl <em>External Uncertainty Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.ExternalUncertaintySourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getExternalUncertaintySource()
		 * @generated
		 */
		EClass EXTERNAL_UNCERTAINTY_SOURCE = eINSTANCE.getExternalUncertaintySource();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_UNCERTAINTY_SOURCE__TARGET = eINSTANCE.getExternalUncertaintySource_Target();

		/**
		 * The meta object literal for the '<em><b>Target Properties</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_UNCERTAINTY_SOURCE__TARGET_PROPERTIES = eINSTANCE.getExternalUncertaintySource_TargetProperties();

		/**
		 * The meta object literal for the '<em><b>Scenarios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_UNCERTAINTY_SOURCE__SCENARIOS = eINSTANCE.getExternalUncertaintySource_Scenarios();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.ExternalUncertaintyScenarioImpl <em>External Uncertainty Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.ExternalUncertaintyScenarioImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getExternalUncertaintyScenario()
		 * @generated
		 */
		EClass EXTERNAL_UNCERTAINTY_SCENARIO = eINSTANCE.getExternalUncertaintyScenario();

		/**
		 * The meta object literal for the '<em><b>Target Properties</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_UNCERTAINTY_SCENARIO__TARGET_PROPERTIES = eINSTANCE.getExternalUncertaintyScenario_TargetProperties();

	}

} //DfdPackage
