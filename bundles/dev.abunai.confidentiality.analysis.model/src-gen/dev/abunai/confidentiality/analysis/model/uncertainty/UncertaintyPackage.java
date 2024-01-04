/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty;

import org.eclipse.emf.ecore.EAttribute;
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
	 * The feature id for the '<em><b>Sources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCERTAINTY_SOURCE_COLLECTION__SOURCES = 0;

	/**
	 * The number of structural features of the '<em>Source Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCERTAINTY_SOURCE_COLLECTION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Source Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCERTAINTY_SOURCE_COLLECTION_OPERATION_COUNT = 0;

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
	 * The number of structural features of the '<em>Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCERTAINTY_SOURCE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCERTAINTY_SOURCE_OPERATION_COUNT = 0;

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
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCERTAINTY_SCENARIO__PROBABILITY = 0;

	/**
	 * The number of structural features of the '<em>Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCERTAINTY_SCENARIO_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCERTAINTY_SCENARIO_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.BehaviorUncertaintySourceImpl <em>Behavior Uncertainty Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.BehaviorUncertaintySourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getBehaviorUncertaintySource()
	 * @generated
	 */
	int BEHAVIOR_UNCERTAINTY_SOURCE = 3;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_UNCERTAINTY_SOURCE__TARGET = UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_UNCERTAINTY_SOURCE__SCENARIOS = UNCERTAINTY_SOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Behavior Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_UNCERTAINTY_SOURCE_FEATURE_COUNT = UNCERTAINTY_SOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Behavior Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_UNCERTAINTY_SOURCE_OPERATION_COUNT = UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.BehaviorUncertaintyScenarioImpl <em>Behavior Uncertainty Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.BehaviorUncertaintyScenarioImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getBehaviorUncertaintyScenario()
	 * @generated
	 */
	int BEHAVIOR_UNCERTAINTY_SCENARIO = 4;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_UNCERTAINTY_SCENARIO__PROBABILITY = UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_UNCERTAINTY_SCENARIO__TARGET = UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Behavior Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_UNCERTAINTY_SCENARIO_FEATURE_COUNT = UNCERTAINTY_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Behavior Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_UNCERTAINTY_SCENARIO_OPERATION_COUNT = UNCERTAINTY_SCENARIO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintySourceImpl <em>External Uncertainty Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintySourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getExternalUncertaintySource()
	 * @generated
	 */
	int EXTERNAL_UNCERTAINTY_SOURCE = 5;

	/**
	 * The number of structural features of the '<em>External Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SOURCE_FEATURE_COUNT = UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>External Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SOURCE_OPERATION_COUNT = UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintySourceInResourceImpl <em>External Uncertainty Source In Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintySourceInResourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getExternalUncertaintySourceInResource()
	 * @generated
	 */
	int EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE = 6;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE__TARGET = EXTERNAL_UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE__SCENARIOS = EXTERNAL_UNCERTAINTY_SOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>External Uncertainty Source In Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE_FEATURE_COUNT = EXTERNAL_UNCERTAINTY_SOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>External Uncertainty Source In Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE_OPERATION_COUNT = EXTERNAL_UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintySourceInUsageImpl <em>External Uncertainty Source In Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintySourceInUsageImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getExternalUncertaintySourceInUsage()
	 * @generated
	 */
	int EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE = 7;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__TARGET = EXTERNAL_UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__SCENARIOS = EXTERNAL_UNCERTAINTY_SOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>External Uncertainty Source In Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE_FEATURE_COUNT = EXTERNAL_UNCERTAINTY_SOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>External Uncertainty Source In Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE_OPERATION_COUNT = EXTERNAL_UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintyInResourceScenarioImpl <em>External Uncertainty In Resource Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintyInResourceScenarioImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getExternalUncertaintyInResourceScenario()
	 * @generated
	 */
	int EXTERNAL_UNCERTAINTY_IN_RESOURCE_SCENARIO = 8;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_IN_RESOURCE_SCENARIO__PROBABILITY = UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_IN_RESOURCE_SCENARIO__TARGET = UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>External Uncertainty In Resource Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_IN_RESOURCE_SCENARIO_FEATURE_COUNT = UNCERTAINTY_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>External Uncertainty In Resource Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_IN_RESOURCE_SCENARIO_OPERATION_COUNT = UNCERTAINTY_SCENARIO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintyInUsageScenarioImpl <em>External Uncertainty In Usage Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintyInUsageScenarioImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getExternalUncertaintyInUsageScenario()
	 * @generated
	 */
	int EXTERNAL_UNCERTAINTY_IN_USAGE_SCENARIO = 9;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_IN_USAGE_SCENARIO__PROBABILITY = UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Targetd</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_IN_USAGE_SCENARIO__TARGETD = UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>External Uncertainty In Usage Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_IN_USAGE_SCENARIO_FEATURE_COUNT = UNCERTAINTY_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>External Uncertainty In Usage Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_IN_USAGE_SCENARIO_OPERATION_COUNT = UNCERTAINTY_SCENARIO_OPERATION_COUNT + 0;


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
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.BehaviorUncertaintySource <em>Behavior Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior Uncertainty Source</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.BehaviorUncertaintySource
	 * @generated
	 */
	EClass getBehaviorUncertaintySource();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.BehaviorUncertaintySource#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.BehaviorUncertaintySource#getTarget()
	 * @see #getBehaviorUncertaintySource()
	 * @generated
	 */
	EReference getBehaviorUncertaintySource_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.BehaviorUncertaintySource#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenarios</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.BehaviorUncertaintySource#getScenarios()
	 * @see #getBehaviorUncertaintySource()
	 * @generated
	 */
	EReference getBehaviorUncertaintySource_Scenarios();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.BehaviorUncertaintyScenario <em>Behavior Uncertainty Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior Uncertainty Scenario</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.BehaviorUncertaintyScenario
	 * @generated
	 */
	EClass getBehaviorUncertaintyScenario();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.BehaviorUncertaintyScenario#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.BehaviorUncertaintyScenario#getTarget()
	 * @see #getBehaviorUncertaintyScenario()
	 * @generated
	 */
	EReference getBehaviorUncertaintyScenario_Target();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintySource <em>External Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Uncertainty Source</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintySource
	 * @generated
	 */
	EClass getExternalUncertaintySource();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintySourceInResource <em>External Uncertainty Source In Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Uncertainty Source In Resource</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintySourceInResource
	 * @generated
	 */
	EClass getExternalUncertaintySourceInResource();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintySourceInResource#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintySourceInResource#getTarget()
	 * @see #getExternalUncertaintySourceInResource()
	 * @generated
	 */
	EReference getExternalUncertaintySourceInResource_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintySourceInResource#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenarios</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintySourceInResource#getScenarios()
	 * @see #getExternalUncertaintySourceInResource()
	 * @generated
	 */
	EReference getExternalUncertaintySourceInResource_Scenarios();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintySourceInUsage <em>External Uncertainty Source In Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Uncertainty Source In Usage</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintySourceInUsage
	 * @generated
	 */
	EClass getExternalUncertaintySourceInUsage();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintySourceInUsage#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintySourceInUsage#getTarget()
	 * @see #getExternalUncertaintySourceInUsage()
	 * @generated
	 */
	EReference getExternalUncertaintySourceInUsage_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintySourceInUsage#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenarios</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintySourceInUsage#getScenarios()
	 * @see #getExternalUncertaintySourceInUsage()
	 * @generated
	 */
	EReference getExternalUncertaintySourceInUsage_Scenarios();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintyInResourceScenario <em>External Uncertainty In Resource Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Uncertainty In Resource Scenario</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintyInResourceScenario
	 * @generated
	 */
	EClass getExternalUncertaintyInResourceScenario();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintyInResourceScenario#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintyInResourceScenario#getTarget()
	 * @see #getExternalUncertaintyInResourceScenario()
	 * @generated
	 */
	EReference getExternalUncertaintyInResourceScenario_Target();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintyInUsageScenario <em>External Uncertainty In Usage Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Uncertainty In Usage Scenario</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintyInUsageScenario
	 * @generated
	 */
	EClass getExternalUncertaintyInUsageScenario();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintyInUsageScenario#getTargetd <em>Targetd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Targetd</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintyInUsageScenario#getTargetd()
	 * @see #getExternalUncertaintyInUsageScenario()
	 * @generated
	 */
	EReference getExternalUncertaintyInUsageScenario_Targetd();

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

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.BehaviorUncertaintySourceImpl <em>Behavior Uncertainty Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.BehaviorUncertaintySourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getBehaviorUncertaintySource()
		 * @generated
		 */
		EClass BEHAVIOR_UNCERTAINTY_SOURCE = eINSTANCE.getBehaviorUncertaintySource();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_UNCERTAINTY_SOURCE__TARGET = eINSTANCE.getBehaviorUncertaintySource_Target();

		/**
		 * The meta object literal for the '<em><b>Scenarios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_UNCERTAINTY_SOURCE__SCENARIOS = eINSTANCE.getBehaviorUncertaintySource_Scenarios();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.BehaviorUncertaintyScenarioImpl <em>Behavior Uncertainty Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.BehaviorUncertaintyScenarioImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getBehaviorUncertaintyScenario()
		 * @generated
		 */
		EClass BEHAVIOR_UNCERTAINTY_SCENARIO = eINSTANCE.getBehaviorUncertaintyScenario();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_UNCERTAINTY_SCENARIO__TARGET = eINSTANCE.getBehaviorUncertaintyScenario_Target();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintySourceImpl <em>External Uncertainty Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintySourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getExternalUncertaintySource()
		 * @generated
		 */
		EClass EXTERNAL_UNCERTAINTY_SOURCE = eINSTANCE.getExternalUncertaintySource();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintySourceInResourceImpl <em>External Uncertainty Source In Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintySourceInResourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getExternalUncertaintySourceInResource()
		 * @generated
		 */
		EClass EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE = eINSTANCE.getExternalUncertaintySourceInResource();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE__TARGET = eINSTANCE.getExternalUncertaintySourceInResource_Target();

		/**
		 * The meta object literal for the '<em><b>Scenarios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE__SCENARIOS = eINSTANCE.getExternalUncertaintySourceInResource_Scenarios();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintySourceInUsageImpl <em>External Uncertainty Source In Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintySourceInUsageImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getExternalUncertaintySourceInUsage()
		 * @generated
		 */
		EClass EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE = eINSTANCE.getExternalUncertaintySourceInUsage();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__TARGET = eINSTANCE.getExternalUncertaintySourceInUsage_Target();

		/**
		 * The meta object literal for the '<em><b>Scenarios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__SCENARIOS = eINSTANCE.getExternalUncertaintySourceInUsage_Scenarios();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintyInResourceScenarioImpl <em>External Uncertainty In Resource Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintyInResourceScenarioImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getExternalUncertaintyInResourceScenario()
		 * @generated
		 */
		EClass EXTERNAL_UNCERTAINTY_IN_RESOURCE_SCENARIO = eINSTANCE.getExternalUncertaintyInResourceScenario();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_UNCERTAINTY_IN_RESOURCE_SCENARIO__TARGET = eINSTANCE.getExternalUncertaintyInResourceScenario_Target();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintyInUsageScenarioImpl <em>External Uncertainty In Usage Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintyInUsageScenarioImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getExternalUncertaintyInUsageScenario()
		 * @generated
		 */
		EClass EXTERNAL_UNCERTAINTY_IN_USAGE_SCENARIO = eINSTANCE.getExternalUncertaintyInUsageScenario();

		/**
		 * The meta object literal for the '<em><b>Targetd</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_UNCERTAINTY_IN_USAGE_SCENARIO__TARGETD = eINSTANCE.getExternalUncertaintyInUsageScenario_Targetd();

	}

} //UncertaintyPackage
