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
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.BehaviorUncertaintySourceImpl <em>Behavior Uncertainty Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.BehaviorUncertaintySourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getBehaviorUncertaintySource()
	 * @generated
	 */
	int BEHAVIOR_UNCERTAINTY_SOURCE = 2;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_UNCERTAINTY_SOURCE__TARGET = UncertaintyPackage.UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Assignments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_UNCERTAINTY_SOURCE__TARGET_ASSIGNMENTS = UncertaintyPackage.UNCERTAINTY_SOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_UNCERTAINTY_SOURCE__SCENARIOS = UncertaintyPackage.UNCERTAINTY_SOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Behavior Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_UNCERTAINTY_SOURCE_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SOURCE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Behavior Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_UNCERTAINTY_SOURCE_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.BehaviorUncertaintyScenarioImpl <em>Behavior Uncertainty Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.BehaviorUncertaintyScenarioImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getBehaviorUncertaintyScenario()
	 * @generated
	 */
	int BEHAVIOR_UNCERTAINTY_SCENARIO = 3;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_UNCERTAINTY_SCENARIO__PROBABILITY = UncertaintyPackage.UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target Assignments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_UNCERTAINTY_SCENARIO__TARGET_ASSIGNMENTS = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Behavior Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_UNCERTAINTY_SCENARIO_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Behavior Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_UNCERTAINTY_SCENARIO_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.InterfaceUncertaintySourceImpl <em>Interface Uncertainty Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.InterfaceUncertaintySourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getInterfaceUncertaintySource()
	 * @generated
	 */
	int INTERFACE_UNCERTAINTY_SOURCE = 4;

	/**
	 * The feature id for the '<em><b>Target In Pin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_UNCERTAINTY_SOURCE__TARGET_IN_PIN = UncertaintyPackage.UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_UNCERTAINTY_SOURCE__TARGET_FLOW = UncertaintyPackage.UNCERTAINTY_SOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_UNCERTAINTY_SOURCE__SCENARIOS = UncertaintyPackage.UNCERTAINTY_SOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Interface Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_UNCERTAINTY_SOURCE_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SOURCE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Interface Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_UNCERTAINTY_SOURCE_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.InterfaceUncertaintyScenarioImpl <em>Interface Uncertainty Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.InterfaceUncertaintyScenarioImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getInterfaceUncertaintyScenario()
	 * @generated
	 */
	int INTERFACE_UNCERTAINTY_SCENARIO = 5;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_UNCERTAINTY_SCENARIO__PROBABILITY = UncertaintyPackage.UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target In Pin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_UNCERTAINTY_SCENARIO__TARGET_IN_PIN = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_UNCERTAINTY_SCENARIO__TARGET_FLOW = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Interface Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_UNCERTAINTY_SCENARIO_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Interface Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_UNCERTAINTY_SCENARIO_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.ConnectorUncertaintySourceImpl <em>Connector Uncertainty Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.ConnectorUncertaintySourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getConnectorUncertaintySource()
	 * @generated
	 */
	int CONNECTOR_UNCERTAINTY_SOURCE = 6;

	/**
	 * The feature id for the '<em><b>Target Assignement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SOURCE__TARGET_ASSIGNEMENT = UncertaintyPackage.UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SOURCE__TARGET_FLOW = UncertaintyPackage.UNCERTAINTY_SOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SOURCE__SCENARIOS = UncertaintyPackage.UNCERTAINTY_SOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Connector Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SOURCE_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SOURCE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Connector Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SOURCE_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.ConnectorUncertaintyScenarioImpl <em>Connector Uncertainty Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.ConnectorUncertaintyScenarioImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getConnectorUncertaintyScenario()
	 * @generated
	 */
	int CONNECTOR_UNCERTAINTY_SCENARIO = 7;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SCENARIO__PROBABILITY = UncertaintyPackage.UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target Assignment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_ASSIGNMENT = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_FLOW = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Connector Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SCENARIO_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Connector Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SCENARIO_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.ComponentUncertaintySourceImpl <em>Component Uncertainty Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.ComponentUncertaintySourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getComponentUncertaintySource()
	 * @generated
	 */
	int COMPONENT_UNCERTAINTY_SOURCE = 8;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_UNCERTAINTY_SOURCE__TARGET = UncertaintyPackage.UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_UNCERTAINTY_SOURCE__SCENARIOS = UncertaintyPackage.UNCERTAINTY_SOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Component Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_UNCERTAINTY_SOURCE_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Component Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_UNCERTAINTY_SOURCE_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.ComponentUncertaintyScenarioImpl <em>Component Uncertainty Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.ComponentUncertaintyScenarioImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getComponentUncertaintyScenario()
	 * @generated
	 */
	int COMPONENT_UNCERTAINTY_SCENARIO = 9;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_UNCERTAINTY_SCENARIO__PROBABILITY = UncertaintyPackage.UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_UNCERTAINTY_SCENARIO__TARGET = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Component Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_UNCERTAINTY_SCENARIO_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Component Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_UNCERTAINTY_SCENARIO_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_OPERATION_COUNT + 0;


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
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.BehaviorUncertaintySource <em>Behavior Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior Uncertainty Source</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.BehaviorUncertaintySource
	 * @generated
	 */
	EClass getBehaviorUncertaintySource();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.BehaviorUncertaintySource#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.BehaviorUncertaintySource#getTarget()
	 * @see #getBehaviorUncertaintySource()
	 * @generated
	 */
	EReference getBehaviorUncertaintySource_Target();

	/**
	 * Returns the meta object for the reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.BehaviorUncertaintySource#getTargetAssignments <em>Target Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target Assignments</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.BehaviorUncertaintySource#getTargetAssignments()
	 * @see #getBehaviorUncertaintySource()
	 * @generated
	 */
	EReference getBehaviorUncertaintySource_TargetAssignments();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.BehaviorUncertaintySource#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenarios</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.BehaviorUncertaintySource#getScenarios()
	 * @see #getBehaviorUncertaintySource()
	 * @generated
	 */
	EReference getBehaviorUncertaintySource_Scenarios();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.BehaviorUncertaintyScenario <em>Behavior Uncertainty Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior Uncertainty Scenario</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.BehaviorUncertaintyScenario
	 * @generated
	 */
	EClass getBehaviorUncertaintyScenario();

	/**
	 * Returns the meta object for the reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.BehaviorUncertaintyScenario#getTargetAssignments <em>Target Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target Assignments</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.BehaviorUncertaintyScenario#getTargetAssignments()
	 * @see #getBehaviorUncertaintyScenario()
	 * @generated
	 */
	EReference getBehaviorUncertaintyScenario_TargetAssignments();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.InterfaceUncertaintySource <em>Interface Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Uncertainty Source</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.InterfaceUncertaintySource
	 * @generated
	 */
	EClass getInterfaceUncertaintySource();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.InterfaceUncertaintySource#getTargetInPin <em>Target In Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target In Pin</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.InterfaceUncertaintySource#getTargetInPin()
	 * @see #getInterfaceUncertaintySource()
	 * @generated
	 */
	EReference getInterfaceUncertaintySource_TargetInPin();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.InterfaceUncertaintySource#getTargetFlow <em>Target Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Flow</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.InterfaceUncertaintySource#getTargetFlow()
	 * @see #getInterfaceUncertaintySource()
	 * @generated
	 */
	EReference getInterfaceUncertaintySource_TargetFlow();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.InterfaceUncertaintySource#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenarios</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.InterfaceUncertaintySource#getScenarios()
	 * @see #getInterfaceUncertaintySource()
	 * @generated
	 */
	EReference getInterfaceUncertaintySource_Scenarios();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.InterfaceUncertaintyScenario <em>Interface Uncertainty Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Uncertainty Scenario</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.InterfaceUncertaintyScenario
	 * @generated
	 */
	EClass getInterfaceUncertaintyScenario();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.InterfaceUncertaintyScenario#getTargetInPin <em>Target In Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target In Pin</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.InterfaceUncertaintyScenario#getTargetInPin()
	 * @see #getInterfaceUncertaintyScenario()
	 * @generated
	 */
	EReference getInterfaceUncertaintyScenario_TargetInPin();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.InterfaceUncertaintyScenario#getTargetFlow <em>Target Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Flow</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.InterfaceUncertaintyScenario#getTargetFlow()
	 * @see #getInterfaceUncertaintyScenario()
	 * @generated
	 */
	EReference getInterfaceUncertaintyScenario_TargetFlow();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ConnectorUncertaintySource <em>Connector Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector Uncertainty Source</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ConnectorUncertaintySource
	 * @generated
	 */
	EClass getConnectorUncertaintySource();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ConnectorUncertaintySource#getTargetAssignement <em>Target Assignement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Assignement</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ConnectorUncertaintySource#getTargetAssignement()
	 * @see #getConnectorUncertaintySource()
	 * @generated
	 */
	EReference getConnectorUncertaintySource_TargetAssignement();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ConnectorUncertaintySource#getTargetFlow <em>Target Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Flow</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ConnectorUncertaintySource#getTargetFlow()
	 * @see #getConnectorUncertaintySource()
	 * @generated
	 */
	EReference getConnectorUncertaintySource_TargetFlow();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ConnectorUncertaintySource#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenarios</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ConnectorUncertaintySource#getScenarios()
	 * @see #getConnectorUncertaintySource()
	 * @generated
	 */
	EReference getConnectorUncertaintySource_Scenarios();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ConnectorUncertaintyScenario <em>Connector Uncertainty Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector Uncertainty Scenario</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ConnectorUncertaintyScenario
	 * @generated
	 */
	EClass getConnectorUncertaintyScenario();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ConnectorUncertaintyScenario#getTargetAssignment <em>Target Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Assignment</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ConnectorUncertaintyScenario#getTargetAssignment()
	 * @see #getConnectorUncertaintyScenario()
	 * @generated
	 */
	EReference getConnectorUncertaintyScenario_TargetAssignment();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ConnectorUncertaintyScenario#getTargetFlow <em>Target Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Flow</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ConnectorUncertaintyScenario#getTargetFlow()
	 * @see #getConnectorUncertaintyScenario()
	 * @generated
	 */
	EReference getConnectorUncertaintyScenario_TargetFlow();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ComponentUncertaintySource <em>Component Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Uncertainty Source</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ComponentUncertaintySource
	 * @generated
	 */
	EClass getComponentUncertaintySource();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ComponentUncertaintySource#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ComponentUncertaintySource#getTarget()
	 * @see #getComponentUncertaintySource()
	 * @generated
	 */
	EReference getComponentUncertaintySource_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ComponentUncertaintySource#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenarios</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ComponentUncertaintySource#getScenarios()
	 * @see #getComponentUncertaintySource()
	 * @generated
	 */
	EReference getComponentUncertaintySource_Scenarios();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ComponentUncertaintyScenario <em>Component Uncertainty Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Uncertainty Scenario</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ComponentUncertaintyScenario
	 * @generated
	 */
	EClass getComponentUncertaintyScenario();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ComponentUncertaintyScenario#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ComponentUncertaintyScenario#getTarget()
	 * @see #getComponentUncertaintyScenario()
	 * @generated
	 */
	EReference getComponentUncertaintyScenario_Target();

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

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.BehaviorUncertaintySourceImpl <em>Behavior Uncertainty Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.BehaviorUncertaintySourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getBehaviorUncertaintySource()
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
		 * The meta object literal for the '<em><b>Target Assignments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_UNCERTAINTY_SOURCE__TARGET_ASSIGNMENTS = eINSTANCE.getBehaviorUncertaintySource_TargetAssignments();

		/**
		 * The meta object literal for the '<em><b>Scenarios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_UNCERTAINTY_SOURCE__SCENARIOS = eINSTANCE.getBehaviorUncertaintySource_Scenarios();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.BehaviorUncertaintyScenarioImpl <em>Behavior Uncertainty Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.BehaviorUncertaintyScenarioImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getBehaviorUncertaintyScenario()
		 * @generated
		 */
		EClass BEHAVIOR_UNCERTAINTY_SCENARIO = eINSTANCE.getBehaviorUncertaintyScenario();

		/**
		 * The meta object literal for the '<em><b>Target Assignments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_UNCERTAINTY_SCENARIO__TARGET_ASSIGNMENTS = eINSTANCE.getBehaviorUncertaintyScenario_TargetAssignments();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.InterfaceUncertaintySourceImpl <em>Interface Uncertainty Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.InterfaceUncertaintySourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getInterfaceUncertaintySource()
		 * @generated
		 */
		EClass INTERFACE_UNCERTAINTY_SOURCE = eINSTANCE.getInterfaceUncertaintySource();

		/**
		 * The meta object literal for the '<em><b>Target In Pin</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_UNCERTAINTY_SOURCE__TARGET_IN_PIN = eINSTANCE.getInterfaceUncertaintySource_TargetInPin();

		/**
		 * The meta object literal for the '<em><b>Target Flow</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_UNCERTAINTY_SOURCE__TARGET_FLOW = eINSTANCE.getInterfaceUncertaintySource_TargetFlow();

		/**
		 * The meta object literal for the '<em><b>Scenarios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_UNCERTAINTY_SOURCE__SCENARIOS = eINSTANCE.getInterfaceUncertaintySource_Scenarios();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.InterfaceUncertaintyScenarioImpl <em>Interface Uncertainty Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.InterfaceUncertaintyScenarioImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getInterfaceUncertaintyScenario()
		 * @generated
		 */
		EClass INTERFACE_UNCERTAINTY_SCENARIO = eINSTANCE.getInterfaceUncertaintyScenario();

		/**
		 * The meta object literal for the '<em><b>Target In Pin</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_UNCERTAINTY_SCENARIO__TARGET_IN_PIN = eINSTANCE.getInterfaceUncertaintyScenario_TargetInPin();

		/**
		 * The meta object literal for the '<em><b>Target Flow</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_UNCERTAINTY_SCENARIO__TARGET_FLOW = eINSTANCE.getInterfaceUncertaintyScenario_TargetFlow();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.ConnectorUncertaintySourceImpl <em>Connector Uncertainty Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.ConnectorUncertaintySourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getConnectorUncertaintySource()
		 * @generated
		 */
		EClass CONNECTOR_UNCERTAINTY_SOURCE = eINSTANCE.getConnectorUncertaintySource();

		/**
		 * The meta object literal for the '<em><b>Target Assignement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR_UNCERTAINTY_SOURCE__TARGET_ASSIGNEMENT = eINSTANCE.getConnectorUncertaintySource_TargetAssignement();

		/**
		 * The meta object literal for the '<em><b>Target Flow</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR_UNCERTAINTY_SOURCE__TARGET_FLOW = eINSTANCE.getConnectorUncertaintySource_TargetFlow();

		/**
		 * The meta object literal for the '<em><b>Scenarios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR_UNCERTAINTY_SOURCE__SCENARIOS = eINSTANCE.getConnectorUncertaintySource_Scenarios();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.ConnectorUncertaintyScenarioImpl <em>Connector Uncertainty Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.ConnectorUncertaintyScenarioImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getConnectorUncertaintyScenario()
		 * @generated
		 */
		EClass CONNECTOR_UNCERTAINTY_SCENARIO = eINSTANCE.getConnectorUncertaintyScenario();

		/**
		 * The meta object literal for the '<em><b>Target Assignment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_ASSIGNMENT = eINSTANCE.getConnectorUncertaintyScenario_TargetAssignment();

		/**
		 * The meta object literal for the '<em><b>Target Flow</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_FLOW = eINSTANCE.getConnectorUncertaintyScenario_TargetFlow();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.ComponentUncertaintySourceImpl <em>Component Uncertainty Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.ComponentUncertaintySourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getComponentUncertaintySource()
		 * @generated
		 */
		EClass COMPONENT_UNCERTAINTY_SOURCE = eINSTANCE.getComponentUncertaintySource();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_UNCERTAINTY_SOURCE__TARGET = eINSTANCE.getComponentUncertaintySource_Target();

		/**
		 * The meta object literal for the '<em><b>Scenarios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_UNCERTAINTY_SOURCE__SCENARIOS = eINSTANCE.getComponentUncertaintySource_Scenarios();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.ComponentUncertaintyScenarioImpl <em>Component Uncertainty Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.ComponentUncertaintyScenarioImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getComponentUncertaintyScenario()
		 * @generated
		 */
		EClass COMPONENT_UNCERTAINTY_SCENARIO = eINSTANCE.getComponentUncertaintyScenario();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_UNCERTAINTY_SCENARIO__TARGET = eINSTANCE.getComponentUncertaintyScenario_Target();

	}

} //DfdPackage
