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
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDUncertaintySourceImpl <em>DFD Uncertainty Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDUncertaintySourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getDFDUncertaintySource()
	 * @generated
	 */
	int DFD_UNCERTAINTY_SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_UNCERTAINTY_SOURCE__ID = UncertaintyPackage.UNCERTAINTY_SOURCE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_UNCERTAINTY_SOURCE__ENTITY_NAME = UncertaintyPackage.UNCERTAINTY_SOURCE__ENTITY_NAME;

	/**
	 * The number of structural features of the '<em>DFD Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_UNCERTAINTY_SOURCE_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>DFD Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_UNCERTAINTY_SOURCE_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDExternalUncertaintySourceImpl <em>DFD External Uncertainty Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDExternalUncertaintySourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getDFDExternalUncertaintySource()
	 * @generated
	 */
	int DFD_EXTERNAL_UNCERTAINTY_SOURCE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_EXTERNAL_UNCERTAINTY_SOURCE__ID = DFD_UNCERTAINTY_SOURCE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_EXTERNAL_UNCERTAINTY_SOURCE__ENTITY_NAME = DFD_UNCERTAINTY_SOURCE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_EXTERNAL_UNCERTAINTY_SOURCE__TARGET = DFD_UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_EXTERNAL_UNCERTAINTY_SOURCE__TARGET_PROPERTIES = DFD_UNCERTAINTY_SOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_EXTERNAL_UNCERTAINTY_SOURCE__SCENARIOS = DFD_UNCERTAINTY_SOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>DFD External Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_EXTERNAL_UNCERTAINTY_SOURCE_FEATURE_COUNT = DFD_UNCERTAINTY_SOURCE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>DFD External Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_EXTERNAL_UNCERTAINTY_SOURCE_OPERATION_COUNT = DFD_UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDExternalUncertaintyScenarioImpl <em>DFD External Uncertainty Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDExternalUncertaintyScenarioImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getDFDExternalUncertaintyScenario()
	 * @generated
	 */
	int DFD_EXTERNAL_UNCERTAINTY_SCENARIO = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_EXTERNAL_UNCERTAINTY_SCENARIO__ID = UncertaintyPackage.UNCERTAINTY_SCENARIO__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_EXTERNAL_UNCERTAINTY_SCENARIO__ENTITY_NAME = UncertaintyPackage.UNCERTAINTY_SCENARIO__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_EXTERNAL_UNCERTAINTY_SCENARIO__PROBABILITY = UncertaintyPackage.UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_EXTERNAL_UNCERTAINTY_SCENARIO__TARGET_PROPERTIES = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>DFD External Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_EXTERNAL_UNCERTAINTY_SCENARIO_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>DFD External Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_EXTERNAL_UNCERTAINTY_SCENARIO_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDBehaviorUncertaintySourceImpl <em>DFD Behavior Uncertainty Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDBehaviorUncertaintySourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getDFDBehaviorUncertaintySource()
	 * @generated
	 */
	int DFD_BEHAVIOR_UNCERTAINTY_SOURCE = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_BEHAVIOR_UNCERTAINTY_SOURCE__ID = DFD_UNCERTAINTY_SOURCE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_BEHAVIOR_UNCERTAINTY_SOURCE__ENTITY_NAME = DFD_UNCERTAINTY_SOURCE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_BEHAVIOR_UNCERTAINTY_SOURCE__TARGET = DFD_UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Assignments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_BEHAVIOR_UNCERTAINTY_SOURCE__TARGET_ASSIGNMENTS = DFD_UNCERTAINTY_SOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_BEHAVIOR_UNCERTAINTY_SOURCE__SCENARIOS = DFD_UNCERTAINTY_SOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>DFD Behavior Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_BEHAVIOR_UNCERTAINTY_SOURCE_FEATURE_COUNT = DFD_UNCERTAINTY_SOURCE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>DFD Behavior Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_BEHAVIOR_UNCERTAINTY_SOURCE_OPERATION_COUNT = DFD_UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDBehaviorUncertaintyScenarioImpl <em>DFD Behavior Uncertainty Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDBehaviorUncertaintyScenarioImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getDFDBehaviorUncertaintyScenario()
	 * @generated
	 */
	int DFD_BEHAVIOR_UNCERTAINTY_SCENARIO = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_BEHAVIOR_UNCERTAINTY_SCENARIO__ID = UncertaintyPackage.UNCERTAINTY_SCENARIO__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_BEHAVIOR_UNCERTAINTY_SCENARIO__ENTITY_NAME = UncertaintyPackage.UNCERTAINTY_SCENARIO__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_BEHAVIOR_UNCERTAINTY_SCENARIO__PROBABILITY = UncertaintyPackage.UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target Assignments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_BEHAVIOR_UNCERTAINTY_SCENARIO__TARGET_ASSIGNMENTS = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>DFD Behavior Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_BEHAVIOR_UNCERTAINTY_SCENARIO_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>DFD Behavior Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_BEHAVIOR_UNCERTAINTY_SCENARIO_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDInterfaceUncertaintySourceImpl <em>DFD Interface Uncertainty Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDInterfaceUncertaintySourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getDFDInterfaceUncertaintySource()
	 * @generated
	 */
	int DFD_INTERFACE_UNCERTAINTY_SOURCE = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_INTERFACE_UNCERTAINTY_SOURCE__ID = DFD_UNCERTAINTY_SOURCE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_INTERFACE_UNCERTAINTY_SOURCE__ENTITY_NAME = DFD_UNCERTAINTY_SOURCE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Target In Pin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_INTERFACE_UNCERTAINTY_SOURCE__TARGET_IN_PIN = DFD_UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_INTERFACE_UNCERTAINTY_SOURCE__TARGET_FLOW = DFD_UNCERTAINTY_SOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_INTERFACE_UNCERTAINTY_SOURCE__SCENARIOS = DFD_UNCERTAINTY_SOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>DFD Interface Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_INTERFACE_UNCERTAINTY_SOURCE_FEATURE_COUNT = DFD_UNCERTAINTY_SOURCE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>DFD Interface Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_INTERFACE_UNCERTAINTY_SOURCE_OPERATION_COUNT = DFD_UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDInterfaceUncertaintyScenarioImpl <em>DFD Interface Uncertainty Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDInterfaceUncertaintyScenarioImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getDFDInterfaceUncertaintyScenario()
	 * @generated
	 */
	int DFD_INTERFACE_UNCERTAINTY_SCENARIO = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_INTERFACE_UNCERTAINTY_SCENARIO__ID = UncertaintyPackage.UNCERTAINTY_SCENARIO__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_INTERFACE_UNCERTAINTY_SCENARIO__ENTITY_NAME = UncertaintyPackage.UNCERTAINTY_SCENARIO__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_INTERFACE_UNCERTAINTY_SCENARIO__PROBABILITY = UncertaintyPackage.UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target In Pin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_INTERFACE_UNCERTAINTY_SCENARIO__TARGET_IN_PIN = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_INTERFACE_UNCERTAINTY_SCENARIO__TARGET_FLOW = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>DFD Interface Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_INTERFACE_UNCERTAINTY_SCENARIO_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>DFD Interface Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_INTERFACE_UNCERTAINTY_SCENARIO_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDConnectorUncertaintySourceImpl <em>DFD Connector Uncertainty Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDConnectorUncertaintySourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getDFDConnectorUncertaintySource()
	 * @generated
	 */
	int DFD_CONNECTOR_UNCERTAINTY_SOURCE = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_CONNECTOR_UNCERTAINTY_SOURCE__ID = DFD_UNCERTAINTY_SOURCE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_CONNECTOR_UNCERTAINTY_SOURCE__ENTITY_NAME = DFD_UNCERTAINTY_SOURCE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Target Assignments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_CONNECTOR_UNCERTAINTY_SOURCE__TARGET_ASSIGNMENTS = DFD_UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_CONNECTOR_UNCERTAINTY_SOURCE__TARGET_FLOW = DFD_UNCERTAINTY_SOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_CONNECTOR_UNCERTAINTY_SOURCE__SCENARIOS = DFD_UNCERTAINTY_SOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>DFD Connector Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_CONNECTOR_UNCERTAINTY_SOURCE_FEATURE_COUNT = DFD_UNCERTAINTY_SOURCE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>DFD Connector Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_CONNECTOR_UNCERTAINTY_SOURCE_OPERATION_COUNT = DFD_UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDConnectorUncertaintyScenarioImpl <em>DFD Connector Uncertainty Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDConnectorUncertaintyScenarioImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getDFDConnectorUncertaintyScenario()
	 * @generated
	 */
	int DFD_CONNECTOR_UNCERTAINTY_SCENARIO = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_CONNECTOR_UNCERTAINTY_SCENARIO__ID = UncertaintyPackage.UNCERTAINTY_SCENARIO__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_CONNECTOR_UNCERTAINTY_SCENARIO__ENTITY_NAME = UncertaintyPackage.UNCERTAINTY_SCENARIO__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_CONNECTOR_UNCERTAINTY_SCENARIO__PROBABILITY = UncertaintyPackage.UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target Assignments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_ASSIGNMENTS = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_FLOW = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>DFD Connector Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_CONNECTOR_UNCERTAINTY_SCENARIO_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>DFD Connector Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_CONNECTOR_UNCERTAINTY_SCENARIO_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDComponentUncertaintySourceImpl <em>DFD Component Uncertainty Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDComponentUncertaintySourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getDFDComponentUncertaintySource()
	 * @generated
	 */
	int DFD_COMPONENT_UNCERTAINTY_SOURCE = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_COMPONENT_UNCERTAINTY_SOURCE__ID = DFD_UNCERTAINTY_SOURCE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_COMPONENT_UNCERTAINTY_SOURCE__ENTITY_NAME = DFD_UNCERTAINTY_SOURCE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_COMPONENT_UNCERTAINTY_SOURCE__TARGET = DFD_UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_COMPONENT_UNCERTAINTY_SOURCE__SCENARIOS = DFD_UNCERTAINTY_SOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>DFD Component Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_COMPONENT_UNCERTAINTY_SOURCE_FEATURE_COUNT = DFD_UNCERTAINTY_SOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>DFD Component Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_COMPONENT_UNCERTAINTY_SOURCE_OPERATION_COUNT = DFD_UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDComponentUncertaintyScenarioImpl <em>DFD Component Uncertainty Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDComponentUncertaintyScenarioImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getDFDComponentUncertaintyScenario()
	 * @generated
	 */
	int DFD_COMPONENT_UNCERTAINTY_SCENARIO = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_COMPONENT_UNCERTAINTY_SCENARIO__ID = UncertaintyPackage.UNCERTAINTY_SCENARIO__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_COMPONENT_UNCERTAINTY_SCENARIO__ENTITY_NAME = UncertaintyPackage.UNCERTAINTY_SCENARIO__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_COMPONENT_UNCERTAINTY_SCENARIO__PROBABILITY = UncertaintyPackage.UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_COMPONENT_UNCERTAINTY_SCENARIO__TARGET = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>DFD Component Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_COMPONENT_UNCERTAINTY_SCENARIO_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>DFD Component Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFD_COMPONENT_UNCERTAINTY_SCENARIO_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDUncertaintySource <em>DFD Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DFD Uncertainty Source</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDUncertaintySource
	 * @generated
	 */
	EClass getDFDUncertaintySource();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintySource <em>DFD External Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DFD External Uncertainty Source</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintySource
	 * @generated
	 */
	EClass getDFDExternalUncertaintySource();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintySource#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintySource#getTarget()
	 * @see #getDFDExternalUncertaintySource()
	 * @generated
	 */
	EReference getDFDExternalUncertaintySource_Target();

	/**
	 * Returns the meta object for the reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintySource#getTargetProperties <em>Target Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target Properties</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintySource#getTargetProperties()
	 * @see #getDFDExternalUncertaintySource()
	 * @generated
	 */
	EReference getDFDExternalUncertaintySource_TargetProperties();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintySource#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenarios</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintySource#getScenarios()
	 * @see #getDFDExternalUncertaintySource()
	 * @generated
	 */
	EReference getDFDExternalUncertaintySource_Scenarios();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintyScenario <em>DFD External Uncertainty Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DFD External Uncertainty Scenario</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintyScenario
	 * @generated
	 */
	EClass getDFDExternalUncertaintyScenario();

	/**
	 * Returns the meta object for the reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintyScenario#getTargetProperties <em>Target Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target Properties</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintyScenario#getTargetProperties()
	 * @see #getDFDExternalUncertaintyScenario()
	 * @generated
	 */
	EReference getDFDExternalUncertaintyScenario_TargetProperties();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDBehaviorUncertaintySource <em>DFD Behavior Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DFD Behavior Uncertainty Source</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDBehaviorUncertaintySource
	 * @generated
	 */
	EClass getDFDBehaviorUncertaintySource();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDBehaviorUncertaintySource#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDBehaviorUncertaintySource#getTarget()
	 * @see #getDFDBehaviorUncertaintySource()
	 * @generated
	 */
	EReference getDFDBehaviorUncertaintySource_Target();

	/**
	 * Returns the meta object for the reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDBehaviorUncertaintySource#getTargetAssignments <em>Target Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target Assignments</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDBehaviorUncertaintySource#getTargetAssignments()
	 * @see #getDFDBehaviorUncertaintySource()
	 * @generated
	 */
	EReference getDFDBehaviorUncertaintySource_TargetAssignments();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDBehaviorUncertaintySource#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenarios</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDBehaviorUncertaintySource#getScenarios()
	 * @see #getDFDBehaviorUncertaintySource()
	 * @generated
	 */
	EReference getDFDBehaviorUncertaintySource_Scenarios();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDBehaviorUncertaintyScenario <em>DFD Behavior Uncertainty Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DFD Behavior Uncertainty Scenario</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDBehaviorUncertaintyScenario
	 * @generated
	 */
	EClass getDFDBehaviorUncertaintyScenario();

	/**
	 * Returns the meta object for the reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDBehaviorUncertaintyScenario#getTargetAssignments <em>Target Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target Assignments</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDBehaviorUncertaintyScenario#getTargetAssignments()
	 * @see #getDFDBehaviorUncertaintyScenario()
	 * @generated
	 */
	EReference getDFDBehaviorUncertaintyScenario_TargetAssignments();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintySource <em>DFD Interface Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DFD Interface Uncertainty Source</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintySource
	 * @generated
	 */
	EClass getDFDInterfaceUncertaintySource();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintySource#getTargetInPin <em>Target In Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target In Pin</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintySource#getTargetInPin()
	 * @see #getDFDInterfaceUncertaintySource()
	 * @generated
	 */
	EReference getDFDInterfaceUncertaintySource_TargetInPin();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintySource#getTargetFlow <em>Target Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Flow</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintySource#getTargetFlow()
	 * @see #getDFDInterfaceUncertaintySource()
	 * @generated
	 */
	EReference getDFDInterfaceUncertaintySource_TargetFlow();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintySource#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenarios</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintySource#getScenarios()
	 * @see #getDFDInterfaceUncertaintySource()
	 * @generated
	 */
	EReference getDFDInterfaceUncertaintySource_Scenarios();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintyScenario <em>DFD Interface Uncertainty Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DFD Interface Uncertainty Scenario</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintyScenario
	 * @generated
	 */
	EClass getDFDInterfaceUncertaintyScenario();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintyScenario#getTargetInPin <em>Target In Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target In Pin</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintyScenario#getTargetInPin()
	 * @see #getDFDInterfaceUncertaintyScenario()
	 * @generated
	 */
	EReference getDFDInterfaceUncertaintyScenario_TargetInPin();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintyScenario#getTargetFlow <em>Target Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Flow</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintyScenario#getTargetFlow()
	 * @see #getDFDInterfaceUncertaintyScenario()
	 * @generated
	 */
	EReference getDFDInterfaceUncertaintyScenario_TargetFlow();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintySource <em>DFD Connector Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DFD Connector Uncertainty Source</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintySource
	 * @generated
	 */
	EClass getDFDConnectorUncertaintySource();

	/**
	 * Returns the meta object for the reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintySource#getTargetAssignments <em>Target Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target Assignments</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintySource#getTargetAssignments()
	 * @see #getDFDConnectorUncertaintySource()
	 * @generated
	 */
	EReference getDFDConnectorUncertaintySource_TargetAssignments();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintySource#getTargetFlow <em>Target Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Flow</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintySource#getTargetFlow()
	 * @see #getDFDConnectorUncertaintySource()
	 * @generated
	 */
	EReference getDFDConnectorUncertaintySource_TargetFlow();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintySource#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenarios</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintySource#getScenarios()
	 * @see #getDFDConnectorUncertaintySource()
	 * @generated
	 */
	EReference getDFDConnectorUncertaintySource_Scenarios();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintyScenario <em>DFD Connector Uncertainty Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DFD Connector Uncertainty Scenario</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintyScenario
	 * @generated
	 */
	EClass getDFDConnectorUncertaintyScenario();

	/**
	 * Returns the meta object for the reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintyScenario#getTargetAssignments <em>Target Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target Assignments</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintyScenario#getTargetAssignments()
	 * @see #getDFDConnectorUncertaintyScenario()
	 * @generated
	 */
	EReference getDFDConnectorUncertaintyScenario_TargetAssignments();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintyScenario#getTargetFlow <em>Target Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Flow</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintyScenario#getTargetFlow()
	 * @see #getDFDConnectorUncertaintyScenario()
	 * @generated
	 */
	EReference getDFDConnectorUncertaintyScenario_TargetFlow();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDComponentUncertaintySource <em>DFD Component Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DFD Component Uncertainty Source</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDComponentUncertaintySource
	 * @generated
	 */
	EClass getDFDComponentUncertaintySource();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDComponentUncertaintySource#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDComponentUncertaintySource#getTarget()
	 * @see #getDFDComponentUncertaintySource()
	 * @generated
	 */
	EReference getDFDComponentUncertaintySource_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDComponentUncertaintySource#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenarios</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDComponentUncertaintySource#getScenarios()
	 * @see #getDFDComponentUncertaintySource()
	 * @generated
	 */
	EReference getDFDComponentUncertaintySource_Scenarios();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDComponentUncertaintyScenario <em>DFD Component Uncertainty Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DFD Component Uncertainty Scenario</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDComponentUncertaintyScenario
	 * @generated
	 */
	EClass getDFDComponentUncertaintyScenario();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDComponentUncertaintyScenario#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDComponentUncertaintyScenario#getTarget()
	 * @see #getDFDComponentUncertaintyScenario()
	 * @generated
	 */
	EReference getDFDComponentUncertaintyScenario_Target();

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
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDUncertaintySourceImpl <em>DFD Uncertainty Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDUncertaintySourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getDFDUncertaintySource()
		 * @generated
		 */
		EClass DFD_UNCERTAINTY_SOURCE = eINSTANCE.getDFDUncertaintySource();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDExternalUncertaintySourceImpl <em>DFD External Uncertainty Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDExternalUncertaintySourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getDFDExternalUncertaintySource()
		 * @generated
		 */
		EClass DFD_EXTERNAL_UNCERTAINTY_SOURCE = eINSTANCE.getDFDExternalUncertaintySource();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFD_EXTERNAL_UNCERTAINTY_SOURCE__TARGET = eINSTANCE.getDFDExternalUncertaintySource_Target();

		/**
		 * The meta object literal for the '<em><b>Target Properties</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFD_EXTERNAL_UNCERTAINTY_SOURCE__TARGET_PROPERTIES = eINSTANCE.getDFDExternalUncertaintySource_TargetProperties();

		/**
		 * The meta object literal for the '<em><b>Scenarios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFD_EXTERNAL_UNCERTAINTY_SOURCE__SCENARIOS = eINSTANCE.getDFDExternalUncertaintySource_Scenarios();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDExternalUncertaintyScenarioImpl <em>DFD External Uncertainty Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDExternalUncertaintyScenarioImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getDFDExternalUncertaintyScenario()
		 * @generated
		 */
		EClass DFD_EXTERNAL_UNCERTAINTY_SCENARIO = eINSTANCE.getDFDExternalUncertaintyScenario();

		/**
		 * The meta object literal for the '<em><b>Target Properties</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFD_EXTERNAL_UNCERTAINTY_SCENARIO__TARGET_PROPERTIES = eINSTANCE.getDFDExternalUncertaintyScenario_TargetProperties();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDBehaviorUncertaintySourceImpl <em>DFD Behavior Uncertainty Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDBehaviorUncertaintySourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getDFDBehaviorUncertaintySource()
		 * @generated
		 */
		EClass DFD_BEHAVIOR_UNCERTAINTY_SOURCE = eINSTANCE.getDFDBehaviorUncertaintySource();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFD_BEHAVIOR_UNCERTAINTY_SOURCE__TARGET = eINSTANCE.getDFDBehaviorUncertaintySource_Target();

		/**
		 * The meta object literal for the '<em><b>Target Assignments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFD_BEHAVIOR_UNCERTAINTY_SOURCE__TARGET_ASSIGNMENTS = eINSTANCE.getDFDBehaviorUncertaintySource_TargetAssignments();

		/**
		 * The meta object literal for the '<em><b>Scenarios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFD_BEHAVIOR_UNCERTAINTY_SOURCE__SCENARIOS = eINSTANCE.getDFDBehaviorUncertaintySource_Scenarios();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDBehaviorUncertaintyScenarioImpl <em>DFD Behavior Uncertainty Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDBehaviorUncertaintyScenarioImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getDFDBehaviorUncertaintyScenario()
		 * @generated
		 */
		EClass DFD_BEHAVIOR_UNCERTAINTY_SCENARIO = eINSTANCE.getDFDBehaviorUncertaintyScenario();

		/**
		 * The meta object literal for the '<em><b>Target Assignments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFD_BEHAVIOR_UNCERTAINTY_SCENARIO__TARGET_ASSIGNMENTS = eINSTANCE.getDFDBehaviorUncertaintyScenario_TargetAssignments();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDInterfaceUncertaintySourceImpl <em>DFD Interface Uncertainty Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDInterfaceUncertaintySourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getDFDInterfaceUncertaintySource()
		 * @generated
		 */
		EClass DFD_INTERFACE_UNCERTAINTY_SOURCE = eINSTANCE.getDFDInterfaceUncertaintySource();

		/**
		 * The meta object literal for the '<em><b>Target In Pin</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFD_INTERFACE_UNCERTAINTY_SOURCE__TARGET_IN_PIN = eINSTANCE.getDFDInterfaceUncertaintySource_TargetInPin();

		/**
		 * The meta object literal for the '<em><b>Target Flow</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFD_INTERFACE_UNCERTAINTY_SOURCE__TARGET_FLOW = eINSTANCE.getDFDInterfaceUncertaintySource_TargetFlow();

		/**
		 * The meta object literal for the '<em><b>Scenarios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFD_INTERFACE_UNCERTAINTY_SOURCE__SCENARIOS = eINSTANCE.getDFDInterfaceUncertaintySource_Scenarios();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDInterfaceUncertaintyScenarioImpl <em>DFD Interface Uncertainty Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDInterfaceUncertaintyScenarioImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getDFDInterfaceUncertaintyScenario()
		 * @generated
		 */
		EClass DFD_INTERFACE_UNCERTAINTY_SCENARIO = eINSTANCE.getDFDInterfaceUncertaintyScenario();

		/**
		 * The meta object literal for the '<em><b>Target In Pin</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFD_INTERFACE_UNCERTAINTY_SCENARIO__TARGET_IN_PIN = eINSTANCE.getDFDInterfaceUncertaintyScenario_TargetInPin();

		/**
		 * The meta object literal for the '<em><b>Target Flow</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFD_INTERFACE_UNCERTAINTY_SCENARIO__TARGET_FLOW = eINSTANCE.getDFDInterfaceUncertaintyScenario_TargetFlow();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDConnectorUncertaintySourceImpl <em>DFD Connector Uncertainty Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDConnectorUncertaintySourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getDFDConnectorUncertaintySource()
		 * @generated
		 */
		EClass DFD_CONNECTOR_UNCERTAINTY_SOURCE = eINSTANCE.getDFDConnectorUncertaintySource();

		/**
		 * The meta object literal for the '<em><b>Target Assignments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFD_CONNECTOR_UNCERTAINTY_SOURCE__TARGET_ASSIGNMENTS = eINSTANCE.getDFDConnectorUncertaintySource_TargetAssignments();

		/**
		 * The meta object literal for the '<em><b>Target Flow</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFD_CONNECTOR_UNCERTAINTY_SOURCE__TARGET_FLOW = eINSTANCE.getDFDConnectorUncertaintySource_TargetFlow();

		/**
		 * The meta object literal for the '<em><b>Scenarios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFD_CONNECTOR_UNCERTAINTY_SOURCE__SCENARIOS = eINSTANCE.getDFDConnectorUncertaintySource_Scenarios();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDConnectorUncertaintyScenarioImpl <em>DFD Connector Uncertainty Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDConnectorUncertaintyScenarioImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getDFDConnectorUncertaintyScenario()
		 * @generated
		 */
		EClass DFD_CONNECTOR_UNCERTAINTY_SCENARIO = eINSTANCE.getDFDConnectorUncertaintyScenario();

		/**
		 * The meta object literal for the '<em><b>Target Assignments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFD_CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_ASSIGNMENTS = eINSTANCE.getDFDConnectorUncertaintyScenario_TargetAssignments();

		/**
		 * The meta object literal for the '<em><b>Target Flow</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFD_CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_FLOW = eINSTANCE.getDFDConnectorUncertaintyScenario_TargetFlow();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDComponentUncertaintySourceImpl <em>DFD Component Uncertainty Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDComponentUncertaintySourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getDFDComponentUncertaintySource()
		 * @generated
		 */
		EClass DFD_COMPONENT_UNCERTAINTY_SOURCE = eINSTANCE.getDFDComponentUncertaintySource();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFD_COMPONENT_UNCERTAINTY_SOURCE__TARGET = eINSTANCE.getDFDComponentUncertaintySource_Target();

		/**
		 * The meta object literal for the '<em><b>Scenarios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFD_COMPONENT_UNCERTAINTY_SOURCE__SCENARIOS = eINSTANCE.getDFDComponentUncertaintySource_Scenarios();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDComponentUncertaintyScenarioImpl <em>DFD Component Uncertainty Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDComponentUncertaintyScenarioImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl#getDFDComponentUncertaintyScenario()
		 * @generated
		 */
		EClass DFD_COMPONENT_UNCERTAINTY_SCENARIO = eINSTANCE.getDFDComponentUncertaintyScenario();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFD_COMPONENT_UNCERTAINTY_SCENARIO__TARGET = eINSTANCE.getDFDComponentUncertaintyScenario_Target();

	}

} //DfdPackage
