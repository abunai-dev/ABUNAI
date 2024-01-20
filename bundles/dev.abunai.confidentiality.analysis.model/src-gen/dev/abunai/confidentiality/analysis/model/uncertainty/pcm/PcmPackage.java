/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.pcm;

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
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmFactory
 * @model kind="package"
 * @generated
 */
public interface PcmPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "pcm";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://abunai.dev/uncertainty/pcm";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "pcm";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PcmPackage eINSTANCE = dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl.init();

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ExternalUncertaintySourceImpl <em>External Uncertainty Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ExternalUncertaintySourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getExternalUncertaintySource()
	 * @generated
	 */
	int EXTERNAL_UNCERTAINTY_SOURCE = 0;

	/**
	 * The number of structural features of the '<em>External Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SOURCE_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>External Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SOURCE_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ExternalUncertaintySourceInResourceImpl <em>External Uncertainty Source In Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ExternalUncertaintySourceInResourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getExternalUncertaintySourceInResource()
	 * @generated
	 */
	int EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE = 1;

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
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ExternalUncertaintySourceInUsageImpl <em>External Uncertainty Source In Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ExternalUncertaintySourceInUsageImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getExternalUncertaintySourceInUsage()
	 * @generated
	 */
	int EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE = 2;

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
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ExternalUncertaintyScenarioInResourceImpl <em>External Uncertainty Scenario In Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ExternalUncertaintyScenarioInResourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getExternalUncertaintyScenarioInResource()
	 * @generated
	 */
	int EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE = 3;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE__PROBABILITY = UncertaintyPackage.UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE__TARGET = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>External Uncertainty Scenario In Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>External Uncertainty Scenario In Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ExternalUncertaintyScenarioInUsageImpl <em>External Uncertainty Scenario In Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ExternalUncertaintyScenarioInUsageImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getExternalUncertaintyScenarioInUsage()
	 * @generated
	 */
	int EXTERNAL_UNCERTAINTY_SCENARIO_IN_USAGE = 4;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SCENARIO_IN_USAGE__PROBABILITY = UncertaintyPackage.UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SCENARIO_IN_USAGE__TARGET = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>External Uncertainty Scenario In Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SCENARIO_IN_USAGE_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>External Uncertainty Scenario In Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_UNCERTAINTY_SCENARIO_IN_USAGE_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.BehaviorUncertaintySourceImpl <em>Behavior Uncertainty Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.BehaviorUncertaintySourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getBehaviorUncertaintySource()
	 * @generated
	 */
	int BEHAVIOR_UNCERTAINTY_SOURCE = 5;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_UNCERTAINTY_SOURCE__TARGET = UncertaintyPackage.UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_UNCERTAINTY_SOURCE__SCENARIOS = UncertaintyPackage.UNCERTAINTY_SOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Behavior Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_UNCERTAINTY_SOURCE_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Behavior Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_UNCERTAINTY_SOURCE_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.BehaviorUncertaintyScenarioImpl <em>Behavior Uncertainty Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.BehaviorUncertaintyScenarioImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getBehaviorUncertaintyScenario()
	 * @generated
	 */
	int BEHAVIOR_UNCERTAINTY_SCENARIO = 6;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_UNCERTAINTY_SCENARIO__PROBABILITY = UncertaintyPackage.UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_UNCERTAINTY_SCENARIO__TARGET = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

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
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.InterfaceUncertaintySourceImpl <em>Interface Uncertainty Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.InterfaceUncertaintySourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getInterfaceUncertaintySource()
	 * @generated
	 */
	int INTERFACE_UNCERTAINTY_SOURCE = 7;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_UNCERTAINTY_SOURCE__TARGET = UncertaintyPackage.UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_UNCERTAINTY_SOURCE__SCENARIOS = UncertaintyPackage.UNCERTAINTY_SOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Interface Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_UNCERTAINTY_SOURCE_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Interface Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_UNCERTAINTY_SOURCE_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.InterfaceUncertaintyScenarioImpl <em>Interface Uncertainty Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.InterfaceUncertaintyScenarioImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getInterfaceUncertaintyScenario()
	 * @generated
	 */
	int INTERFACE_UNCERTAINTY_SCENARIO = 8;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_UNCERTAINTY_SCENARIO__PROBABILITY = UncertaintyPackage.UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_UNCERTAINTY_SCENARIO__TARGET = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Interface Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_UNCERTAINTY_SCENARIO_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Interface Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_UNCERTAINTY_SCENARIO_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ConnectorUncertaintySourceImpl <em>Connector Uncertainty Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ConnectorUncertaintySourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getConnectorUncertaintySource()
	 * @generated
	 */
	int CONNECTOR_UNCERTAINTY_SOURCE = 9;

	/**
	 * The number of structural features of the '<em>Connector Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SOURCE_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Connector Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SOURCE_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ConnectorUncertaintySourceInExternalCallImpl <em>Connector Uncertainty Source In External Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ConnectorUncertaintySourceInExternalCallImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getConnectorUncertaintySourceInExternalCall()
	 * @generated
	 */
	int CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL = 10;

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
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ConnectorUncertaintySourceInEntryLevelSystemCallImpl <em>Connector Uncertainty Source In Entry Level System Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ConnectorUncertaintySourceInEntryLevelSystemCallImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getConnectorUncertaintySourceInEntryLevelSystemCall()
	 * @generated
	 */
	int CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL = 11;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL__TARGET = CONNECTOR_UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL__SCENARIOS = CONNECTOR_UNCERTAINTY_SOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Connector Uncertainty Source In Entry Level System Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL_FEATURE_COUNT = CONNECTOR_UNCERTAINTY_SOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Connector Uncertainty Source In Entry Level System Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL_OPERATION_COUNT = CONNECTOR_UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ConnectorUncertaintyScenarioInExternalCallImpl <em>Connector Uncertainty Scenario In External Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ConnectorUncertaintyScenarioInExternalCallImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getConnectorUncertaintyScenarioInExternalCall()
	 * @generated
	 */
	int CONNECTOR_UNCERTAINTY_SCENARIO_IN_EXTERNAL_CALL = 12;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SCENARIO_IN_EXTERNAL_CALL__PROBABILITY = UncertaintyPackage.UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SCENARIO_IN_EXTERNAL_CALL__TARGET = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Connector Uncertainty Scenario In External Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SCENARIO_IN_EXTERNAL_CALL_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Connector Uncertainty Scenario In External Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SCENARIO_IN_EXTERNAL_CALL_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ConnectorUncertaintyScenarioInEntryLevelSystemCallImpl <em>Connector Uncertainty Scenario In Entry Level System Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ConnectorUncertaintyScenarioInEntryLevelSystemCallImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getConnectorUncertaintyScenarioInEntryLevelSystemCall()
	 * @generated
	 */
	int CONNECTOR_UNCERTAINTY_SCENARIO_IN_ENTRY_LEVEL_SYSTEM_CALL = 13;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SCENARIO_IN_ENTRY_LEVEL_SYSTEM_CALL__PROBABILITY = UncertaintyPackage.UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SCENARIO_IN_ENTRY_LEVEL_SYSTEM_CALL__TARGET = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Connector Uncertainty Scenario In Entry Level System Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SCENARIO_IN_ENTRY_LEVEL_SYSTEM_CALL_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Connector Uncertainty Scenario In Entry Level System Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_UNCERTAINTY_SCENARIO_IN_ENTRY_LEVEL_SYSTEM_CALL_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ComponentUncertaintySourceImpl <em>Component Uncertainty Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ComponentUncertaintySourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getComponentUncertaintySource()
	 * @generated
	 */
	int COMPONENT_UNCERTAINTY_SOURCE = 14;

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
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ComponentUncertaintyScenarioImpl <em>Component Uncertainty Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ComponentUncertaintyScenarioImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getComponentUncertaintyScenario()
	 * @generated
	 */
	int COMPONENT_UNCERTAINTY_SCENARIO = 15;

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
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintySource <em>External Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Uncertainty Source</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintySource
	 * @generated
	 */
	EClass getExternalUncertaintySource();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintySourceInResource <em>External Uncertainty Source In Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Uncertainty Source In Resource</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintySourceInResource
	 * @generated
	 */
	EClass getExternalUncertaintySourceInResource();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintySourceInResource#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintySourceInResource#getTarget()
	 * @see #getExternalUncertaintySourceInResource()
	 * @generated
	 */
	EReference getExternalUncertaintySourceInResource_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintySourceInResource#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenarios</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintySourceInResource#getScenarios()
	 * @see #getExternalUncertaintySourceInResource()
	 * @generated
	 */
	EReference getExternalUncertaintySourceInResource_Scenarios();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintySourceInUsage <em>External Uncertainty Source In Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Uncertainty Source In Usage</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintySourceInUsage
	 * @generated
	 */
	EClass getExternalUncertaintySourceInUsage();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintySourceInUsage#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintySourceInUsage#getTarget()
	 * @see #getExternalUncertaintySourceInUsage()
	 * @generated
	 */
	EReference getExternalUncertaintySourceInUsage_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintySourceInUsage#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenarios</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintySourceInUsage#getScenarios()
	 * @see #getExternalUncertaintySourceInUsage()
	 * @generated
	 */
	EReference getExternalUncertaintySourceInUsage_Scenarios();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintyScenarioInResource <em>External Uncertainty Scenario In Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Uncertainty Scenario In Resource</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintyScenarioInResource
	 * @generated
	 */
	EClass getExternalUncertaintyScenarioInResource();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintyScenarioInResource#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintyScenarioInResource#getTarget()
	 * @see #getExternalUncertaintyScenarioInResource()
	 * @generated
	 */
	EReference getExternalUncertaintyScenarioInResource_Target();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintyScenarioInUsage <em>External Uncertainty Scenario In Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Uncertainty Scenario In Usage</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintyScenarioInUsage
	 * @generated
	 */
	EClass getExternalUncertaintyScenarioInUsage();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintyScenarioInUsage#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintyScenarioInUsage#getTarget()
	 * @see #getExternalUncertaintyScenarioInUsage()
	 * @generated
	 */
	EReference getExternalUncertaintyScenarioInUsage_Target();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.BehaviorUncertaintySource <em>Behavior Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior Uncertainty Source</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.BehaviorUncertaintySource
	 * @generated
	 */
	EClass getBehaviorUncertaintySource();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.BehaviorUncertaintySource#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.BehaviorUncertaintySource#getTarget()
	 * @see #getBehaviorUncertaintySource()
	 * @generated
	 */
	EReference getBehaviorUncertaintySource_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.BehaviorUncertaintySource#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenarios</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.BehaviorUncertaintySource#getScenarios()
	 * @see #getBehaviorUncertaintySource()
	 * @generated
	 */
	EReference getBehaviorUncertaintySource_Scenarios();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.BehaviorUncertaintyScenario <em>Behavior Uncertainty Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior Uncertainty Scenario</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.BehaviorUncertaintyScenario
	 * @generated
	 */
	EClass getBehaviorUncertaintyScenario();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.BehaviorUncertaintyScenario#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.BehaviorUncertaintyScenario#getTarget()
	 * @see #getBehaviorUncertaintyScenario()
	 * @generated
	 */
	EReference getBehaviorUncertaintyScenario_Target();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.InterfaceUncertaintySource <em>Interface Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Uncertainty Source</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.InterfaceUncertaintySource
	 * @generated
	 */
	EClass getInterfaceUncertaintySource();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.InterfaceUncertaintySource#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.InterfaceUncertaintySource#getTarget()
	 * @see #getInterfaceUncertaintySource()
	 * @generated
	 */
	EReference getInterfaceUncertaintySource_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.InterfaceUncertaintySource#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenarios</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.InterfaceUncertaintySource#getScenarios()
	 * @see #getInterfaceUncertaintySource()
	 * @generated
	 */
	EReference getInterfaceUncertaintySource_Scenarios();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.InterfaceUncertaintyScenario <em>Interface Uncertainty Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Uncertainty Scenario</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.InterfaceUncertaintyScenario
	 * @generated
	 */
	EClass getInterfaceUncertaintyScenario();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.InterfaceUncertaintyScenario#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.InterfaceUncertaintyScenario#getTarget()
	 * @see #getInterfaceUncertaintyScenario()
	 * @generated
	 */
	EReference getInterfaceUncertaintyScenario_Target();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintySource <em>Connector Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector Uncertainty Source</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintySource
	 * @generated
	 */
	EClass getConnectorUncertaintySource();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintySourceInExternalCall <em>Connector Uncertainty Source In External Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector Uncertainty Source In External Call</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintySourceInExternalCall
	 * @generated
	 */
	EClass getConnectorUncertaintySourceInExternalCall();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintySourceInExternalCall#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintySourceInExternalCall#getTarget()
	 * @see #getConnectorUncertaintySourceInExternalCall()
	 * @generated
	 */
	EReference getConnectorUncertaintySourceInExternalCall_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintySourceInExternalCall#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenarios</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintySourceInExternalCall#getScenarios()
	 * @see #getConnectorUncertaintySourceInExternalCall()
	 * @generated
	 */
	EReference getConnectorUncertaintySourceInExternalCall_Scenarios();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintySourceInEntryLevelSystemCall <em>Connector Uncertainty Source In Entry Level System Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector Uncertainty Source In Entry Level System Call</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintySourceInEntryLevelSystemCall
	 * @generated
	 */
	EClass getConnectorUncertaintySourceInEntryLevelSystemCall();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintySourceInEntryLevelSystemCall#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintySourceInEntryLevelSystemCall#getTarget()
	 * @see #getConnectorUncertaintySourceInEntryLevelSystemCall()
	 * @generated
	 */
	EReference getConnectorUncertaintySourceInEntryLevelSystemCall_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintySourceInEntryLevelSystemCall#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenarios</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintySourceInEntryLevelSystemCall#getScenarios()
	 * @see #getConnectorUncertaintySourceInEntryLevelSystemCall()
	 * @generated
	 */
	EReference getConnectorUncertaintySourceInEntryLevelSystemCall_Scenarios();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintyScenarioInExternalCall <em>Connector Uncertainty Scenario In External Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector Uncertainty Scenario In External Call</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintyScenarioInExternalCall
	 * @generated
	 */
	EClass getConnectorUncertaintyScenarioInExternalCall();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintyScenarioInExternalCall#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintyScenarioInExternalCall#getTarget()
	 * @see #getConnectorUncertaintyScenarioInExternalCall()
	 * @generated
	 */
	EReference getConnectorUncertaintyScenarioInExternalCall_Target();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintyScenarioInEntryLevelSystemCall <em>Connector Uncertainty Scenario In Entry Level System Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector Uncertainty Scenario In Entry Level System Call</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintyScenarioInEntryLevelSystemCall
	 * @generated
	 */
	EClass getConnectorUncertaintyScenarioInEntryLevelSystemCall();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintyScenarioInEntryLevelSystemCall#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintyScenarioInEntryLevelSystemCall#getTarget()
	 * @see #getConnectorUncertaintyScenarioInEntryLevelSystemCall()
	 * @generated
	 */
	EReference getConnectorUncertaintyScenarioInEntryLevelSystemCall_Target();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ComponentUncertaintySource <em>Component Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Uncertainty Source</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ComponentUncertaintySource
	 * @generated
	 */
	EClass getComponentUncertaintySource();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ComponentUncertaintySource#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ComponentUncertaintySource#getTarget()
	 * @see #getComponentUncertaintySource()
	 * @generated
	 */
	EReference getComponentUncertaintySource_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ComponentUncertaintySource#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenarios</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ComponentUncertaintySource#getScenarios()
	 * @see #getComponentUncertaintySource()
	 * @generated
	 */
	EReference getComponentUncertaintySource_Scenarios();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ComponentUncertaintyScenario <em>Component Uncertainty Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Uncertainty Scenario</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ComponentUncertaintyScenario
	 * @generated
	 */
	EClass getComponentUncertaintyScenario();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ComponentUncertaintyScenario#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ComponentUncertaintyScenario#getTarget()
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
	PcmFactory getPcmFactory();

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
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ExternalUncertaintySourceImpl <em>External Uncertainty Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ExternalUncertaintySourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getExternalUncertaintySource()
		 * @generated
		 */
		EClass EXTERNAL_UNCERTAINTY_SOURCE = eINSTANCE.getExternalUncertaintySource();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ExternalUncertaintySourceInResourceImpl <em>External Uncertainty Source In Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ExternalUncertaintySourceInResourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getExternalUncertaintySourceInResource()
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
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ExternalUncertaintySourceInUsageImpl <em>External Uncertainty Source In Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ExternalUncertaintySourceInUsageImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getExternalUncertaintySourceInUsage()
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
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ExternalUncertaintyScenarioInResourceImpl <em>External Uncertainty Scenario In Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ExternalUncertaintyScenarioInResourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getExternalUncertaintyScenarioInResource()
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
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ExternalUncertaintyScenarioInUsageImpl <em>External Uncertainty Scenario In Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ExternalUncertaintyScenarioInUsageImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getExternalUncertaintyScenarioInUsage()
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
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.BehaviorUncertaintySourceImpl <em>Behavior Uncertainty Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.BehaviorUncertaintySourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getBehaviorUncertaintySource()
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
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.BehaviorUncertaintyScenarioImpl <em>Behavior Uncertainty Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.BehaviorUncertaintyScenarioImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getBehaviorUncertaintyScenario()
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
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.InterfaceUncertaintySourceImpl <em>Interface Uncertainty Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.InterfaceUncertaintySourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getInterfaceUncertaintySource()
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
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.InterfaceUncertaintyScenarioImpl <em>Interface Uncertainty Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.InterfaceUncertaintyScenarioImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getInterfaceUncertaintyScenario()
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
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ConnectorUncertaintySourceImpl <em>Connector Uncertainty Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ConnectorUncertaintySourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getConnectorUncertaintySource()
		 * @generated
		 */
		EClass CONNECTOR_UNCERTAINTY_SOURCE = eINSTANCE.getConnectorUncertaintySource();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ConnectorUncertaintySourceInExternalCallImpl <em>Connector Uncertainty Source In External Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ConnectorUncertaintySourceInExternalCallImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getConnectorUncertaintySourceInExternalCall()
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
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ConnectorUncertaintySourceInEntryLevelSystemCallImpl <em>Connector Uncertainty Source In Entry Level System Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ConnectorUncertaintySourceInEntryLevelSystemCallImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getConnectorUncertaintySourceInEntryLevelSystemCall()
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
		 * The meta object literal for the '<em><b>Scenarios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL__SCENARIOS = eINSTANCE.getConnectorUncertaintySourceInEntryLevelSystemCall_Scenarios();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ConnectorUncertaintyScenarioInExternalCallImpl <em>Connector Uncertainty Scenario In External Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ConnectorUncertaintyScenarioInExternalCallImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getConnectorUncertaintyScenarioInExternalCall()
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
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ConnectorUncertaintyScenarioInEntryLevelSystemCallImpl <em>Connector Uncertainty Scenario In Entry Level System Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ConnectorUncertaintyScenarioInEntryLevelSystemCallImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getConnectorUncertaintyScenarioInEntryLevelSystemCall()
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
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ComponentUncertaintySourceImpl <em>Component Uncertainty Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ComponentUncertaintySourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getComponentUncertaintySource()
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
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ComponentUncertaintyScenarioImpl <em>Component Uncertainty Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ComponentUncertaintyScenarioImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getComponentUncertaintyScenario()
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

} //PcmPackage
