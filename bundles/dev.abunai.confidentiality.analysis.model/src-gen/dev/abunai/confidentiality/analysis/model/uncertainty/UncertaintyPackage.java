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
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintySourceImpl <em>External Uncertainty Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintySourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getExternalUncertaintySource()
	 * @generated
	 */
	int EXTERNAL_UNCERTAINTY_SOURCE = 3;

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
	int EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE = 4;

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
	int EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE = 5;

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
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintyScenarioInResourceImpl <em>External Uncertainty Scenario In Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintyScenarioInResourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getExternalUncertaintyScenarioInResource()
	 * @generated
	 */
	int EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE = 6;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE__PROBABILITY = UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE__TARGET = UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>External Uncertainty Scenario In Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE_FEATURE_COUNT = UNCERTAINTY_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>External Uncertainty Scenario In Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE_OPERATION_COUNT = UNCERTAINTY_SCENARIO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintyScenarioInUsageImpl <em>External Uncertainty Scenario In Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintyScenarioInUsageImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getExternalUncertaintyScenarioInUsage()
	 * @generated
	 */
	int EXTERNAL_UNCERTAINTY_SCENARIO_IN_USAGE = 7;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SCENARIO_IN_USAGE__PROBABILITY = UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SCENARIO_IN_USAGE__TARGET = UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>External Uncertainty Scenario In Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SCENARIO_IN_USAGE_FEATURE_COUNT = UNCERTAINTY_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>External Uncertainty Scenario In Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SCENARIO_IN_USAGE_OPERATION_COUNT = UNCERTAINTY_SCENARIO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.BehaviorUncertaintySourceImpl <em>Behavior Uncertainty Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.BehaviorUncertaintySourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getBehaviorUncertaintySource()
	 * @generated
	 */
	int BEHAVIOR_UNCERTAINTY_SOURCE = 8;

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
	int BEHAVIOR_UNCERTAINTY_SCENARIO = 9;

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
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.InterfaceUncertaintySourceImpl <em>Interface Uncertainty Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.InterfaceUncertaintySourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getInterfaceUncertaintySource()
	 * @generated
	 */
	int INTERFACE_UNCERTAINTY_SOURCE = 10;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_UNCERTAINTY_SOURCE__TARGET = UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_UNCERTAINTY_SOURCE__SCENARIOS = UNCERTAINTY_SOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Interface Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_UNCERTAINTY_SOURCE_FEATURE_COUNT = UNCERTAINTY_SOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Interface Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_UNCERTAINTY_SOURCE_OPERATION_COUNT = UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.InterfaceUncertaintyScenarioImpl <em>Interface Uncertainty Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.InterfaceUncertaintyScenarioImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getInterfaceUncertaintyScenario()
	 * @generated
	 */
	int INTERFACE_UNCERTAINTY_SCENARIO = 11;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_UNCERTAINTY_SCENARIO__PROBABILITY = UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_UNCERTAINTY_SCENARIO__TARGET = UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Interface Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_UNCERTAINTY_SCENARIO_FEATURE_COUNT = UNCERTAINTY_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Interface Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_UNCERTAINTY_SCENARIO_OPERATION_COUNT = UNCERTAINTY_SCENARIO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ConnectorUncertaintySourceImpl <em>Connector Uncertainty Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.ConnectorUncertaintySourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getConnectorUncertaintySource()
	 * @generated
	 */
	int CONNECTOR_UNCERTAINTY_SOURCE = 12;

	/**
	 * The number of structural features of the '<em>Connector Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SOURCE_FEATURE_COUNT = UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Connector Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SOURCE_OPERATION_COUNT = UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ConnectorUncertaintySourceInExternalCallImpl <em>Connector Uncertainty Source In External Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.ConnectorUncertaintySourceInExternalCallImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getConnectorUncertaintySourceInExternalCall()
	 * @generated
	 */
	int CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL = 13;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL__TARGET = CONNECTOR_UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL__SCENARIOS = CONNECTOR_UNCERTAINTY_SOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Connector Uncertainty Source In External Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL_FEATURE_COUNT = CONNECTOR_UNCERTAINTY_SOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Connector Uncertainty Source In External Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL_OPERATION_COUNT = CONNECTOR_UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ConnectorUncertaintySourceInEntryLevelSystemCallImpl <em>Connector Uncertainty Source In Entry Level System Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.ConnectorUncertaintySourceInEntryLevelSystemCallImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getConnectorUncertaintySourceInEntryLevelSystemCall()
	 * @generated
	 */
	int CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL = 14;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL__TARGET = CONNECTOR_UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Connector Uncertainty Source In Entry Level System Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL_FEATURE_COUNT = CONNECTOR_UNCERTAINTY_SOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Connector Uncertainty Source In Entry Level System Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL_OPERATION_COUNT = CONNECTOR_UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ConnectorUncertaintyScenarioInExternalCallImpl <em>Connector Uncertainty Scenario In External Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.ConnectorUncertaintyScenarioInExternalCallImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getConnectorUncertaintyScenarioInExternalCall()
	 * @generated
	 */
	int CONNECTOR_UNCERTAINTY_SCENARIO_IN_EXTERNAL_CALL = 15;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SCENARIO_IN_EXTERNAL_CALL__PROBABILITY = UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SCENARIO_IN_EXTERNAL_CALL__TARGET = UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SCENARIO_IN_EXTERNAL_CALL__SCENARIOS = UNCERTAINTY_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Connector Uncertainty Scenario In External Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SCENARIO_IN_EXTERNAL_CALL_FEATURE_COUNT = UNCERTAINTY_SCENARIO_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Connector Uncertainty Scenario In External Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SCENARIO_IN_EXTERNAL_CALL_OPERATION_COUNT = UNCERTAINTY_SCENARIO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ConnectorUncertaintyScenarioInEntryLevelSystemCallImpl <em>Connector Uncertainty Scenario In Entry Level System Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.ConnectorUncertaintyScenarioInEntryLevelSystemCallImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getConnectorUncertaintyScenarioInEntryLevelSystemCall()
	 * @generated
	 */
	int CONNECTOR_UNCERTAINTY_SCENARIO_IN_ENTRY_LEVEL_SYSTEM_CALL = 16;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SCENARIO_IN_ENTRY_LEVEL_SYSTEM_CALL__PROBABILITY = UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SCENARIO_IN_ENTRY_LEVEL_SYSTEM_CALL__TARGET = UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Connector Uncertainty Scenario In Entry Level System Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SCENARIO_IN_ENTRY_LEVEL_SYSTEM_CALL_FEATURE_COUNT = UNCERTAINTY_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Connector Uncertainty Scenario In Entry Level System Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SCENARIO_IN_ENTRY_LEVEL_SYSTEM_CALL_OPERATION_COUNT = UNCERTAINTY_SCENARIO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ComponentUncertaintySourceImpl <em>Component Uncertainty Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.ComponentUncertaintySourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getComponentUncertaintySource()
	 * @generated
	 */
	int COMPONENT_UNCERTAINTY_SOURCE = 17;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_UNCERTAINTY_SOURCE__TARGET = UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_UNCERTAINTY_SOURCE__SCENARIOS = UNCERTAINTY_SOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Component Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_UNCERTAINTY_SOURCE_FEATURE_COUNT = UNCERTAINTY_SOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Component Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_UNCERTAINTY_SOURCE_OPERATION_COUNT = UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ComponentUncertaintyScenarioImpl <em>Component Uncertainty Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.ComponentUncertaintyScenarioImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getComponentUncertaintyScenario()
	 * @generated
	 */
	int COMPONENT_UNCERTAINTY_SCENARIO = 18;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_UNCERTAINTY_SCENARIO__PROBABILITY = UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_UNCERTAINTY_SCENARIO__TARGET = UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Component Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_UNCERTAINTY_SCENARIO_FEATURE_COUNT = UNCERTAINTY_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Component Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_UNCERTAINTY_SCENARIO_OPERATION_COUNT = UNCERTAINTY_SCENARIO_OPERATION_COUNT + 0;


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
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintyScenarioInResource <em>External Uncertainty Scenario In Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Uncertainty Scenario In Resource</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintyScenarioInResource
	 * @generated
	 */
	EClass getExternalUncertaintyScenarioInResource();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintyScenarioInResource#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintyScenarioInResource#getTarget()
	 * @see #getExternalUncertaintyScenarioInResource()
	 * @generated
	 */
	EReference getExternalUncertaintyScenarioInResource_Target();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintyScenarioInUsage <em>External Uncertainty Scenario In Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Uncertainty Scenario In Usage</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintyScenarioInUsage
	 * @generated
	 */
	EClass getExternalUncertaintyScenarioInUsage();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintyScenarioInUsage#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintyScenarioInUsage#getTarget()
	 * @see #getExternalUncertaintyScenarioInUsage()
	 * @generated
	 */
	EReference getExternalUncertaintyScenarioInUsage_Target();

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
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.InterfaceUncertaintySource <em>Interface Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Uncertainty Source</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.InterfaceUncertaintySource
	 * @generated
	 */
	EClass getInterfaceUncertaintySource();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.InterfaceUncertaintySource#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.InterfaceUncertaintySource#getTarget()
	 * @see #getInterfaceUncertaintySource()
	 * @generated
	 */
	EReference getInterfaceUncertaintySource_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.InterfaceUncertaintySource#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenarios</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.InterfaceUncertaintySource#getScenarios()
	 * @see #getInterfaceUncertaintySource()
	 * @generated
	 */
	EReference getInterfaceUncertaintySource_Scenarios();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.InterfaceUncertaintyScenario <em>Interface Uncertainty Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Uncertainty Scenario</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.InterfaceUncertaintyScenario
	 * @generated
	 */
	EClass getInterfaceUncertaintyScenario();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.InterfaceUncertaintyScenario#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.InterfaceUncertaintyScenario#getTarget()
	 * @see #getInterfaceUncertaintyScenario()
	 * @generated
	 */
	EReference getInterfaceUncertaintyScenario_Target();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ConnectorUncertaintySource <em>Connector Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector Uncertainty Source</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.ConnectorUncertaintySource
	 * @generated
	 */
	EClass getConnectorUncertaintySource();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ConnectorUncertaintySourceInExternalCall <em>Connector Uncertainty Source In External Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector Uncertainty Source In External Call</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.ConnectorUncertaintySourceInExternalCall
	 * @generated
	 */
	EClass getConnectorUncertaintySourceInExternalCall();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ConnectorUncertaintySourceInExternalCall#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.ConnectorUncertaintySourceInExternalCall#getTarget()
	 * @see #getConnectorUncertaintySourceInExternalCall()
	 * @generated
	 */
	EReference getConnectorUncertaintySourceInExternalCall_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ConnectorUncertaintySourceInExternalCall#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenarios</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.ConnectorUncertaintySourceInExternalCall#getScenarios()
	 * @see #getConnectorUncertaintySourceInExternalCall()
	 * @generated
	 */
	EReference getConnectorUncertaintySourceInExternalCall_Scenarios();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ConnectorUncertaintySourceInEntryLevelSystemCall <em>Connector Uncertainty Source In Entry Level System Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector Uncertainty Source In Entry Level System Call</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.ConnectorUncertaintySourceInEntryLevelSystemCall
	 * @generated
	 */
	EClass getConnectorUncertaintySourceInEntryLevelSystemCall();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ConnectorUncertaintySourceInEntryLevelSystemCall#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.ConnectorUncertaintySourceInEntryLevelSystemCall#getTarget()
	 * @see #getConnectorUncertaintySourceInEntryLevelSystemCall()
	 * @generated
	 */
	EReference getConnectorUncertaintySourceInEntryLevelSystemCall_Target();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ConnectorUncertaintyScenarioInExternalCall <em>Connector Uncertainty Scenario In External Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector Uncertainty Scenario In External Call</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.ConnectorUncertaintyScenarioInExternalCall
	 * @generated
	 */
	EClass getConnectorUncertaintyScenarioInExternalCall();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ConnectorUncertaintyScenarioInExternalCall#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.ConnectorUncertaintyScenarioInExternalCall#getTarget()
	 * @see #getConnectorUncertaintyScenarioInExternalCall()
	 * @generated
	 */
	EReference getConnectorUncertaintyScenarioInExternalCall_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ConnectorUncertaintyScenarioInExternalCall#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenarios</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.ConnectorUncertaintyScenarioInExternalCall#getScenarios()
	 * @see #getConnectorUncertaintyScenarioInExternalCall()
	 * @generated
	 */
	EReference getConnectorUncertaintyScenarioInExternalCall_Scenarios();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ConnectorUncertaintyScenarioInEntryLevelSystemCall <em>Connector Uncertainty Scenario In Entry Level System Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector Uncertainty Scenario In Entry Level System Call</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.ConnectorUncertaintyScenarioInEntryLevelSystemCall
	 * @generated
	 */
	EClass getConnectorUncertaintyScenarioInEntryLevelSystemCall();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ConnectorUncertaintyScenarioInEntryLevelSystemCall#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.ConnectorUncertaintyScenarioInEntryLevelSystemCall#getTarget()
	 * @see #getConnectorUncertaintyScenarioInEntryLevelSystemCall()
	 * @generated
	 */
	EReference getConnectorUncertaintyScenarioInEntryLevelSystemCall_Target();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ComponentUncertaintySource <em>Component Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Uncertainty Source</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.ComponentUncertaintySource
	 * @generated
	 */
	EClass getComponentUncertaintySource();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ComponentUncertaintySource#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.ComponentUncertaintySource#getTarget()
	 * @see #getComponentUncertaintySource()
	 * @generated
	 */
	EReference getComponentUncertaintySource_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ComponentUncertaintySource#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenarios</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.ComponentUncertaintySource#getScenarios()
	 * @see #getComponentUncertaintySource()
	 * @generated
	 */
	EReference getComponentUncertaintySource_Scenarios();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ComponentUncertaintyScenario <em>Component Uncertainty Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Uncertainty Scenario</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.ComponentUncertaintyScenario
	 * @generated
	 */
	EClass getComponentUncertaintyScenario();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ComponentUncertaintyScenario#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.ComponentUncertaintyScenario#getTarget()
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
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintyScenarioInResourceImpl <em>External Uncertainty Scenario In Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintyScenarioInResourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getExternalUncertaintyScenarioInResource()
		 * @generated
		 */
		EClass EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE = eINSTANCE.getExternalUncertaintyScenarioInResource();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE__TARGET = eINSTANCE.getExternalUncertaintyScenarioInResource_Target();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintyScenarioInUsageImpl <em>External Uncertainty Scenario In Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintyScenarioInUsageImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getExternalUncertaintyScenarioInUsage()
		 * @generated
		 */
		EClass EXTERNAL_UNCERTAINTY_SCENARIO_IN_USAGE = eINSTANCE.getExternalUncertaintyScenarioInUsage();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_UNCERTAINTY_SCENARIO_IN_USAGE__TARGET = eINSTANCE.getExternalUncertaintyScenarioInUsage_Target();

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
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.InterfaceUncertaintySourceImpl <em>Interface Uncertainty Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.InterfaceUncertaintySourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getInterfaceUncertaintySource()
		 * @generated
		 */
		EClass INTERFACE_UNCERTAINTY_SOURCE = eINSTANCE.getInterfaceUncertaintySource();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_UNCERTAINTY_SOURCE__TARGET = eINSTANCE.getInterfaceUncertaintySource_Target();

		/**
		 * The meta object literal for the '<em><b>Scenarios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_UNCERTAINTY_SOURCE__SCENARIOS = eINSTANCE.getInterfaceUncertaintySource_Scenarios();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.InterfaceUncertaintyScenarioImpl <em>Interface Uncertainty Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.InterfaceUncertaintyScenarioImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getInterfaceUncertaintyScenario()
		 * @generated
		 */
		EClass INTERFACE_UNCERTAINTY_SCENARIO = eINSTANCE.getInterfaceUncertaintyScenario();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_UNCERTAINTY_SCENARIO__TARGET = eINSTANCE.getInterfaceUncertaintyScenario_Target();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ConnectorUncertaintySourceImpl <em>Connector Uncertainty Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.ConnectorUncertaintySourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getConnectorUncertaintySource()
		 * @generated
		 */
		EClass CONNECTOR_UNCERTAINTY_SOURCE = eINSTANCE.getConnectorUncertaintySource();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ConnectorUncertaintySourceInExternalCallImpl <em>Connector Uncertainty Source In External Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.ConnectorUncertaintySourceInExternalCallImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getConnectorUncertaintySourceInExternalCall()
		 * @generated
		 */
		EClass CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL = eINSTANCE.getConnectorUncertaintySourceInExternalCall();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL__TARGET = eINSTANCE.getConnectorUncertaintySourceInExternalCall_Target();

		/**
		 * The meta object literal for the '<em><b>Scenarios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL__SCENARIOS = eINSTANCE.getConnectorUncertaintySourceInExternalCall_Scenarios();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ConnectorUncertaintySourceInEntryLevelSystemCallImpl <em>Connector Uncertainty Source In Entry Level System Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.ConnectorUncertaintySourceInEntryLevelSystemCallImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getConnectorUncertaintySourceInEntryLevelSystemCall()
		 * @generated
		 */
		EClass CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL = eINSTANCE.getConnectorUncertaintySourceInEntryLevelSystemCall();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL__TARGET = eINSTANCE.getConnectorUncertaintySourceInEntryLevelSystemCall_Target();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ConnectorUncertaintyScenarioInExternalCallImpl <em>Connector Uncertainty Scenario In External Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.ConnectorUncertaintyScenarioInExternalCallImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getConnectorUncertaintyScenarioInExternalCall()
		 * @generated
		 */
		EClass CONNECTOR_UNCERTAINTY_SCENARIO_IN_EXTERNAL_CALL = eINSTANCE.getConnectorUncertaintyScenarioInExternalCall();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR_UNCERTAINTY_SCENARIO_IN_EXTERNAL_CALL__TARGET = eINSTANCE.getConnectorUncertaintyScenarioInExternalCall_Target();

		/**
		 * The meta object literal for the '<em><b>Scenarios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR_UNCERTAINTY_SCENARIO_IN_EXTERNAL_CALL__SCENARIOS = eINSTANCE.getConnectorUncertaintyScenarioInExternalCall_Scenarios();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ConnectorUncertaintyScenarioInEntryLevelSystemCallImpl <em>Connector Uncertainty Scenario In Entry Level System Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.ConnectorUncertaintyScenarioInEntryLevelSystemCallImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getConnectorUncertaintyScenarioInEntryLevelSystemCall()
		 * @generated
		 */
		EClass CONNECTOR_UNCERTAINTY_SCENARIO_IN_ENTRY_LEVEL_SYSTEM_CALL = eINSTANCE.getConnectorUncertaintyScenarioInEntryLevelSystemCall();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR_UNCERTAINTY_SCENARIO_IN_ENTRY_LEVEL_SYSTEM_CALL__TARGET = eINSTANCE.getConnectorUncertaintyScenarioInEntryLevelSystemCall_Target();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ComponentUncertaintySourceImpl <em>Component Uncertainty Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.ComponentUncertaintySourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getComponentUncertaintySource()
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
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ComponentUncertaintyScenarioImpl <em>Component Uncertainty Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.ComponentUncertaintyScenarioImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl#getComponentUncertaintyScenario()
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

} //UncertaintyPackage
