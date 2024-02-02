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
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMUncertaintySourceImpl <em>PCM Uncertainty Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMUncertaintySourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMUncertaintySource()
	 * @generated
	 */
	int PCM_UNCERTAINTY_SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_UNCERTAINTY_SOURCE__ID = UncertaintyPackage.UNCERTAINTY_SOURCE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_UNCERTAINTY_SOURCE__ENTITY_NAME = UncertaintyPackage.UNCERTAINTY_SOURCE__ENTITY_NAME;

	/**
	 * The number of structural features of the '<em>PCM Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_UNCERTAINTY_SOURCE_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>PCM Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_UNCERTAINTY_SOURCE_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMExternalUncertaintySourceImpl <em>PCM External Uncertainty Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMExternalUncertaintySourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMExternalUncertaintySource()
	 * @generated
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SOURCE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SOURCE__ID = PCM_UNCERTAINTY_SOURCE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SOURCE__ENTITY_NAME = PCM_UNCERTAINTY_SOURCE__ENTITY_NAME;

	/**
	 * The number of structural features of the '<em>PCM External Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SOURCE_FEATURE_COUNT = PCM_UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>PCM External Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SOURCE_OPERATION_COUNT = PCM_UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMExternalUncertaintySourceInResourceImpl <em>PCM External Uncertainty Source In Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMExternalUncertaintySourceInResourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMExternalUncertaintySourceInResource()
	 * @generated
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE__ID = PCM_EXTERNAL_UNCERTAINTY_SOURCE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE__ENTITY_NAME = PCM_EXTERNAL_UNCERTAINTY_SOURCE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE__TARGET = PCM_EXTERNAL_UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE__SCENARIOS = PCM_EXTERNAL_UNCERTAINTY_SOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>PCM External Uncertainty Source In Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE_FEATURE_COUNT = PCM_EXTERNAL_UNCERTAINTY_SOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>PCM External Uncertainty Source In Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE_OPERATION_COUNT = PCM_EXTERNAL_UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMExternalUncertaintySourceInUsageImpl <em>PCM External Uncertainty Source In Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMExternalUncertaintySourceInUsageImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMExternalUncertaintySourceInUsage()
	 * @generated
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__ID = PCM_EXTERNAL_UNCERTAINTY_SOURCE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__ENTITY_NAME = PCM_EXTERNAL_UNCERTAINTY_SOURCE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__TARGET = PCM_EXTERNAL_UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__SCENARIOS = PCM_EXTERNAL_UNCERTAINTY_SOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>PCM External Uncertainty Source In Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE_FEATURE_COUNT = PCM_EXTERNAL_UNCERTAINTY_SOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>PCM External Uncertainty Source In Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE_OPERATION_COUNT = PCM_EXTERNAL_UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMExternalUncertaintyScenarioInResourceImpl <em>PCM External Uncertainty Scenario In Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMExternalUncertaintyScenarioInResourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMExternalUncertaintyScenarioInResource()
	 * @generated
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE__ID = UncertaintyPackage.UNCERTAINTY_SCENARIO__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE__ENTITY_NAME = UncertaintyPackage.UNCERTAINTY_SCENARIO__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE__PROBABILITY = UncertaintyPackage.UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE__TARGET = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>PCM External Uncertainty Scenario In Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>PCM External Uncertainty Scenario In Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMExternalUncertaintyScenarioInUsageImpl <em>PCM External Uncertainty Scenario In Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMExternalUncertaintyScenarioInUsageImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMExternalUncertaintyScenarioInUsage()
	 * @generated
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SCENARIO_IN_USAGE = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SCENARIO_IN_USAGE__ID = UncertaintyPackage.UNCERTAINTY_SCENARIO__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SCENARIO_IN_USAGE__ENTITY_NAME = UncertaintyPackage.UNCERTAINTY_SCENARIO__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SCENARIO_IN_USAGE__PROBABILITY = UncertaintyPackage.UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SCENARIO_IN_USAGE__TARGET = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>PCM External Uncertainty Scenario In Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SCENARIO_IN_USAGE_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>PCM External Uncertainty Scenario In Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_EXTERNAL_UNCERTAINTY_SCENARIO_IN_USAGE_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMBehaviorUncertaintySourceImpl <em>PCM Behavior Uncertainty Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMBehaviorUncertaintySourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMBehaviorUncertaintySource()
	 * @generated
	 */
	int PCM_BEHAVIOR_UNCERTAINTY_SOURCE = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_BEHAVIOR_UNCERTAINTY_SOURCE__ID = PCM_UNCERTAINTY_SOURCE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_BEHAVIOR_UNCERTAINTY_SOURCE__ENTITY_NAME = PCM_UNCERTAINTY_SOURCE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_BEHAVIOR_UNCERTAINTY_SOURCE__TARGET = PCM_UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_BEHAVIOR_UNCERTAINTY_SOURCE__SCENARIOS = PCM_UNCERTAINTY_SOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>PCM Behavior Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_BEHAVIOR_UNCERTAINTY_SOURCE_FEATURE_COUNT = PCM_UNCERTAINTY_SOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>PCM Behavior Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_BEHAVIOR_UNCERTAINTY_SOURCE_OPERATION_COUNT = PCM_UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMBehaviorUncertaintyScenarioImpl <em>PCM Behavior Uncertainty Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMBehaviorUncertaintyScenarioImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMBehaviorUncertaintyScenario()
	 * @generated
	 */
	int PCM_BEHAVIOR_UNCERTAINTY_SCENARIO = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_BEHAVIOR_UNCERTAINTY_SCENARIO__ID = UncertaintyPackage.UNCERTAINTY_SCENARIO__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_BEHAVIOR_UNCERTAINTY_SCENARIO__ENTITY_NAME = UncertaintyPackage.UNCERTAINTY_SCENARIO__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_BEHAVIOR_UNCERTAINTY_SCENARIO__PROBABILITY = UncertaintyPackage.UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_BEHAVIOR_UNCERTAINTY_SCENARIO__TARGET = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>PCM Behavior Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_BEHAVIOR_UNCERTAINTY_SCENARIO_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>PCM Behavior Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_BEHAVIOR_UNCERTAINTY_SCENARIO_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMInterfaceUncertaintySourceImpl <em>PCM Interface Uncertainty Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMInterfaceUncertaintySourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMInterfaceUncertaintySource()
	 * @generated
	 */
	int PCM_INTERFACE_UNCERTAINTY_SOURCE = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_INTERFACE_UNCERTAINTY_SOURCE__ID = PCM_UNCERTAINTY_SOURCE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_INTERFACE_UNCERTAINTY_SOURCE__ENTITY_NAME = PCM_UNCERTAINTY_SOURCE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_INTERFACE_UNCERTAINTY_SOURCE__TARGET = PCM_UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_INTERFACE_UNCERTAINTY_SOURCE__SCENARIOS = PCM_UNCERTAINTY_SOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>PCM Interface Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_INTERFACE_UNCERTAINTY_SOURCE_FEATURE_COUNT = PCM_UNCERTAINTY_SOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>PCM Interface Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_INTERFACE_UNCERTAINTY_SOURCE_OPERATION_COUNT = PCM_UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMInterfaceUncertaintyScenarioImpl <em>PCM Interface Uncertainty Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMInterfaceUncertaintyScenarioImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMInterfaceUncertaintyScenario()
	 * @generated
	 */
	int PCM_INTERFACE_UNCERTAINTY_SCENARIO = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_INTERFACE_UNCERTAINTY_SCENARIO__ID = UncertaintyPackage.UNCERTAINTY_SCENARIO__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_INTERFACE_UNCERTAINTY_SCENARIO__ENTITY_NAME = UncertaintyPackage.UNCERTAINTY_SCENARIO__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_INTERFACE_UNCERTAINTY_SCENARIO__PROBABILITY = UncertaintyPackage.UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_INTERFACE_UNCERTAINTY_SCENARIO__TARGET = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>PCM Interface Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_INTERFACE_UNCERTAINTY_SCENARIO_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>PCM Interface Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_INTERFACE_UNCERTAINTY_SCENARIO_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMConnectorUncertaintySourceImpl <em>PCM Connector Uncertainty Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMConnectorUncertaintySourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMConnectorUncertaintySource()
	 * @generated
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SOURCE = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SOURCE__ID = PCM_UNCERTAINTY_SOURCE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SOURCE__ENTITY_NAME = PCM_UNCERTAINTY_SOURCE__ENTITY_NAME;

	/**
	 * The number of structural features of the '<em>PCM Connector Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SOURCE_FEATURE_COUNT = PCM_UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>PCM Connector Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SOURCE_OPERATION_COUNT = PCM_UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMConnectorUncertaintySourceInExternalCallImpl <em>PCM Connector Uncertainty Source In External Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMConnectorUncertaintySourceInExternalCallImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMConnectorUncertaintySourceInExternalCall()
	 * @generated
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL__ID = PCM_CONNECTOR_UNCERTAINTY_SOURCE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL__ENTITY_NAME = PCM_CONNECTOR_UNCERTAINTY_SOURCE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL__TARGET = PCM_CONNECTOR_UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL__SCENARIOS = PCM_CONNECTOR_UNCERTAINTY_SOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>PCM Connector Uncertainty Source In External Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL_FEATURE_COUNT = PCM_CONNECTOR_UNCERTAINTY_SOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>PCM Connector Uncertainty Source In External Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL_OPERATION_COUNT = PCM_CONNECTOR_UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMConnectorUncertaintySourceInEntryLevelSystemCallImpl <em>PCM Connector Uncertainty Source In Entry Level System Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMConnectorUncertaintySourceInEntryLevelSystemCallImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMConnectorUncertaintySourceInEntryLevelSystemCall()
	 * @generated
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL = 12;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL__ID = PCM_CONNECTOR_UNCERTAINTY_SOURCE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL__ENTITY_NAME = PCM_CONNECTOR_UNCERTAINTY_SOURCE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL__TARGET = PCM_CONNECTOR_UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL__SCENARIOS = PCM_CONNECTOR_UNCERTAINTY_SOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>PCM Connector Uncertainty Source In Entry Level System Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL_FEATURE_COUNT = PCM_CONNECTOR_UNCERTAINTY_SOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>PCM Connector Uncertainty Source In Entry Level System Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL_OPERATION_COUNT = PCM_CONNECTOR_UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMConnectorUncertaintyScenarioInExternalCallImpl <em>PCM Connector Uncertainty Scenario In External Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMConnectorUncertaintyScenarioInExternalCallImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMConnectorUncertaintyScenarioInExternalCall()
	 * @generated
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SCENARIO_IN_EXTERNAL_CALL = 13;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SCENARIO_IN_EXTERNAL_CALL__ID = UncertaintyPackage.UNCERTAINTY_SCENARIO__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SCENARIO_IN_EXTERNAL_CALL__ENTITY_NAME = UncertaintyPackage.UNCERTAINTY_SCENARIO__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SCENARIO_IN_EXTERNAL_CALL__PROBABILITY = UncertaintyPackage.UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SCENARIO_IN_EXTERNAL_CALL__TARGET = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>PCM Connector Uncertainty Scenario In External Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SCENARIO_IN_EXTERNAL_CALL_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>PCM Connector Uncertainty Scenario In External Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SCENARIO_IN_EXTERNAL_CALL_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMConnectorUncertaintyScenarioInEntryLevelSystemCallImpl <em>PCM Connector Uncertainty Scenario In Entry Level System Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMConnectorUncertaintyScenarioInEntryLevelSystemCallImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMConnectorUncertaintyScenarioInEntryLevelSystemCall()
	 * @generated
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SCENARIO_IN_ENTRY_LEVEL_SYSTEM_CALL = 14;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SCENARIO_IN_ENTRY_LEVEL_SYSTEM_CALL__ID = UncertaintyPackage.UNCERTAINTY_SCENARIO__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SCENARIO_IN_ENTRY_LEVEL_SYSTEM_CALL__ENTITY_NAME = UncertaintyPackage.UNCERTAINTY_SCENARIO__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SCENARIO_IN_ENTRY_LEVEL_SYSTEM_CALL__PROBABILITY = UncertaintyPackage.UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SCENARIO_IN_ENTRY_LEVEL_SYSTEM_CALL__TARGET = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>PCM Connector Uncertainty Scenario In Entry Level System Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SCENARIO_IN_ENTRY_LEVEL_SYSTEM_CALL_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>PCM Connector Uncertainty Scenario In Entry Level System Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_CONNECTOR_UNCERTAINTY_SCENARIO_IN_ENTRY_LEVEL_SYSTEM_CALL_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMComponentUncertaintySourceImpl <em>PCM Component Uncertainty Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMComponentUncertaintySourceImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMComponentUncertaintySource()
	 * @generated
	 */
	int PCM_COMPONENT_UNCERTAINTY_SOURCE = 15;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_COMPONENT_UNCERTAINTY_SOURCE__ID = PCM_UNCERTAINTY_SOURCE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_COMPONENT_UNCERTAINTY_SOURCE__ENTITY_NAME = PCM_UNCERTAINTY_SOURCE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_COMPONENT_UNCERTAINTY_SOURCE__TARGET = PCM_UNCERTAINTY_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_COMPONENT_UNCERTAINTY_SOURCE__SCENARIOS = PCM_UNCERTAINTY_SOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>PCM Component Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_COMPONENT_UNCERTAINTY_SOURCE_FEATURE_COUNT = PCM_UNCERTAINTY_SOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>PCM Component Uncertainty Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_COMPONENT_UNCERTAINTY_SOURCE_OPERATION_COUNT = PCM_UNCERTAINTY_SOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMComponentUncertaintyScenarioImpl <em>PCM Component Uncertainty Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMComponentUncertaintyScenarioImpl
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMComponentUncertaintyScenario()
	 * @generated
	 */
	int PCM_COMPONENT_UNCERTAINTY_SCENARIO = 16;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_COMPONENT_UNCERTAINTY_SCENARIO__ID = UncertaintyPackage.UNCERTAINTY_SCENARIO__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_COMPONENT_UNCERTAINTY_SCENARIO__ENTITY_NAME = UncertaintyPackage.UNCERTAINTY_SCENARIO__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_COMPONENT_UNCERTAINTY_SCENARIO__PROBABILITY = UncertaintyPackage.UNCERTAINTY_SCENARIO__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_COMPONENT_UNCERTAINTY_SCENARIO__TARGET = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>PCM Component Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_COMPONENT_UNCERTAINTY_SCENARIO_FEATURE_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>PCM Component Uncertainty Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_COMPONENT_UNCERTAINTY_SCENARIO_OPERATION_COUNT = UncertaintyPackage.UNCERTAINTY_SCENARIO_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMUncertaintySource <em>PCM Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PCM Uncertainty Source</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMUncertaintySource
	 * @generated
	 */
	EClass getPCMUncertaintySource();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySource <em>PCM External Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PCM External Uncertainty Source</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySource
	 * @generated
	 */
	EClass getPCMExternalUncertaintySource();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySourceInResource <em>PCM External Uncertainty Source In Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PCM External Uncertainty Source In Resource</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySourceInResource
	 * @generated
	 */
	EClass getPCMExternalUncertaintySourceInResource();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySourceInResource#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySourceInResource#getTarget()
	 * @see #getPCMExternalUncertaintySourceInResource()
	 * @generated
	 */
	EReference getPCMExternalUncertaintySourceInResource_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySourceInResource#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenarios</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySourceInResource#getScenarios()
	 * @see #getPCMExternalUncertaintySourceInResource()
	 * @generated
	 */
	EReference getPCMExternalUncertaintySourceInResource_Scenarios();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySourceInUsage <em>PCM External Uncertainty Source In Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PCM External Uncertainty Source In Usage</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySourceInUsage
	 * @generated
	 */
	EClass getPCMExternalUncertaintySourceInUsage();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySourceInUsage#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySourceInUsage#getTarget()
	 * @see #getPCMExternalUncertaintySourceInUsage()
	 * @generated
	 */
	EReference getPCMExternalUncertaintySourceInUsage_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySourceInUsage#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenarios</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySourceInUsage#getScenarios()
	 * @see #getPCMExternalUncertaintySourceInUsage()
	 * @generated
	 */
	EReference getPCMExternalUncertaintySourceInUsage_Scenarios();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintyScenarioInResource <em>PCM External Uncertainty Scenario In Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PCM External Uncertainty Scenario In Resource</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintyScenarioInResource
	 * @generated
	 */
	EClass getPCMExternalUncertaintyScenarioInResource();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintyScenarioInResource#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintyScenarioInResource#getTarget()
	 * @see #getPCMExternalUncertaintyScenarioInResource()
	 * @generated
	 */
	EReference getPCMExternalUncertaintyScenarioInResource_Target();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintyScenarioInUsage <em>PCM External Uncertainty Scenario In Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PCM External Uncertainty Scenario In Usage</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintyScenarioInUsage
	 * @generated
	 */
	EClass getPCMExternalUncertaintyScenarioInUsage();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintyScenarioInUsage#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintyScenarioInUsage#getTarget()
	 * @see #getPCMExternalUncertaintyScenarioInUsage()
	 * @generated
	 */
	EReference getPCMExternalUncertaintyScenarioInUsage_Target();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMBehaviorUncertaintySource <em>PCM Behavior Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PCM Behavior Uncertainty Source</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMBehaviorUncertaintySource
	 * @generated
	 */
	EClass getPCMBehaviorUncertaintySource();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMBehaviorUncertaintySource#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMBehaviorUncertaintySource#getTarget()
	 * @see #getPCMBehaviorUncertaintySource()
	 * @generated
	 */
	EReference getPCMBehaviorUncertaintySource_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMBehaviorUncertaintySource#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenarios</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMBehaviorUncertaintySource#getScenarios()
	 * @see #getPCMBehaviorUncertaintySource()
	 * @generated
	 */
	EReference getPCMBehaviorUncertaintySource_Scenarios();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMBehaviorUncertaintyScenario <em>PCM Behavior Uncertainty Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PCM Behavior Uncertainty Scenario</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMBehaviorUncertaintyScenario
	 * @generated
	 */
	EClass getPCMBehaviorUncertaintyScenario();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMBehaviorUncertaintyScenario#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMBehaviorUncertaintyScenario#getTarget()
	 * @see #getPCMBehaviorUncertaintyScenario()
	 * @generated
	 */
	EReference getPCMBehaviorUncertaintyScenario_Target();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMInterfaceUncertaintySource <em>PCM Interface Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PCM Interface Uncertainty Source</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMInterfaceUncertaintySource
	 * @generated
	 */
	EClass getPCMInterfaceUncertaintySource();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMInterfaceUncertaintySource#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMInterfaceUncertaintySource#getTarget()
	 * @see #getPCMInterfaceUncertaintySource()
	 * @generated
	 */
	EReference getPCMInterfaceUncertaintySource_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMInterfaceUncertaintySource#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenarios</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMInterfaceUncertaintySource#getScenarios()
	 * @see #getPCMInterfaceUncertaintySource()
	 * @generated
	 */
	EReference getPCMInterfaceUncertaintySource_Scenarios();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMInterfaceUncertaintyScenario <em>PCM Interface Uncertainty Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PCM Interface Uncertainty Scenario</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMInterfaceUncertaintyScenario
	 * @generated
	 */
	EClass getPCMInterfaceUncertaintyScenario();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMInterfaceUncertaintyScenario#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMInterfaceUncertaintyScenario#getTarget()
	 * @see #getPCMInterfaceUncertaintyScenario()
	 * @generated
	 */
	EReference getPCMInterfaceUncertaintyScenario_Target();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySource <em>PCM Connector Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PCM Connector Uncertainty Source</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySource
	 * @generated
	 */
	EClass getPCMConnectorUncertaintySource();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInExternalCall <em>PCM Connector Uncertainty Source In External Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PCM Connector Uncertainty Source In External Call</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInExternalCall
	 * @generated
	 */
	EClass getPCMConnectorUncertaintySourceInExternalCall();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInExternalCall#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInExternalCall#getTarget()
	 * @see #getPCMConnectorUncertaintySourceInExternalCall()
	 * @generated
	 */
	EReference getPCMConnectorUncertaintySourceInExternalCall_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInExternalCall#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenarios</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInExternalCall#getScenarios()
	 * @see #getPCMConnectorUncertaintySourceInExternalCall()
	 * @generated
	 */
	EReference getPCMConnectorUncertaintySourceInExternalCall_Scenarios();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInEntryLevelSystemCall <em>PCM Connector Uncertainty Source In Entry Level System Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PCM Connector Uncertainty Source In Entry Level System Call</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInEntryLevelSystemCall
	 * @generated
	 */
	EClass getPCMConnectorUncertaintySourceInEntryLevelSystemCall();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInEntryLevelSystemCall#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInEntryLevelSystemCall#getTarget()
	 * @see #getPCMConnectorUncertaintySourceInEntryLevelSystemCall()
	 * @generated
	 */
	EReference getPCMConnectorUncertaintySourceInEntryLevelSystemCall_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInEntryLevelSystemCall#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenarios</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInEntryLevelSystemCall#getScenarios()
	 * @see #getPCMConnectorUncertaintySourceInEntryLevelSystemCall()
	 * @generated
	 */
	EReference getPCMConnectorUncertaintySourceInEntryLevelSystemCall_Scenarios();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintyScenarioInExternalCall <em>PCM Connector Uncertainty Scenario In External Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PCM Connector Uncertainty Scenario In External Call</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintyScenarioInExternalCall
	 * @generated
	 */
	EClass getPCMConnectorUncertaintyScenarioInExternalCall();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintyScenarioInExternalCall#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintyScenarioInExternalCall#getTarget()
	 * @see #getPCMConnectorUncertaintyScenarioInExternalCall()
	 * @generated
	 */
	EReference getPCMConnectorUncertaintyScenarioInExternalCall_Target();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintyScenarioInEntryLevelSystemCall <em>PCM Connector Uncertainty Scenario In Entry Level System Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PCM Connector Uncertainty Scenario In Entry Level System Call</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintyScenarioInEntryLevelSystemCall
	 * @generated
	 */
	EClass getPCMConnectorUncertaintyScenarioInEntryLevelSystemCall();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintyScenarioInEntryLevelSystemCall#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintyScenarioInEntryLevelSystemCall#getTarget()
	 * @see #getPCMConnectorUncertaintyScenarioInEntryLevelSystemCall()
	 * @generated
	 */
	EReference getPCMConnectorUncertaintyScenarioInEntryLevelSystemCall_Target();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMComponentUncertaintySource <em>PCM Component Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PCM Component Uncertainty Source</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMComponentUncertaintySource
	 * @generated
	 */
	EClass getPCMComponentUncertaintySource();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMComponentUncertaintySource#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMComponentUncertaintySource#getTarget()
	 * @see #getPCMComponentUncertaintySource()
	 * @generated
	 */
	EReference getPCMComponentUncertaintySource_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMComponentUncertaintySource#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scenarios</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMComponentUncertaintySource#getScenarios()
	 * @see #getPCMComponentUncertaintySource()
	 * @generated
	 */
	EReference getPCMComponentUncertaintySource_Scenarios();

	/**
	 * Returns the meta object for class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMComponentUncertaintyScenario <em>PCM Component Uncertainty Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PCM Component Uncertainty Scenario</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMComponentUncertaintyScenario
	 * @generated
	 */
	EClass getPCMComponentUncertaintyScenario();

	/**
	 * Returns the meta object for the reference '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMComponentUncertaintyScenario#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMComponentUncertaintyScenario#getTarget()
	 * @see #getPCMComponentUncertaintyScenario()
	 * @generated
	 */
	EReference getPCMComponentUncertaintyScenario_Target();

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
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMUncertaintySourceImpl <em>PCM Uncertainty Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMUncertaintySourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMUncertaintySource()
		 * @generated
		 */
		EClass PCM_UNCERTAINTY_SOURCE = eINSTANCE.getPCMUncertaintySource();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMExternalUncertaintySourceImpl <em>PCM External Uncertainty Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMExternalUncertaintySourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMExternalUncertaintySource()
		 * @generated
		 */
		EClass PCM_EXTERNAL_UNCERTAINTY_SOURCE = eINSTANCE.getPCMExternalUncertaintySource();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMExternalUncertaintySourceInResourceImpl <em>PCM External Uncertainty Source In Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMExternalUncertaintySourceInResourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMExternalUncertaintySourceInResource()
		 * @generated
		 */
		EClass PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE = eINSTANCE.getPCMExternalUncertaintySourceInResource();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE__TARGET = eINSTANCE.getPCMExternalUncertaintySourceInResource_Target();

		/**
		 * The meta object literal for the '<em><b>Scenarios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE__SCENARIOS = eINSTANCE.getPCMExternalUncertaintySourceInResource_Scenarios();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMExternalUncertaintySourceInUsageImpl <em>PCM External Uncertainty Source In Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMExternalUncertaintySourceInUsageImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMExternalUncertaintySourceInUsage()
		 * @generated
		 */
		EClass PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE = eINSTANCE.getPCMExternalUncertaintySourceInUsage();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__TARGET = eINSTANCE.getPCMExternalUncertaintySourceInUsage_Target();

		/**
		 * The meta object literal for the '<em><b>Scenarios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__SCENARIOS = eINSTANCE.getPCMExternalUncertaintySourceInUsage_Scenarios();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMExternalUncertaintyScenarioInResourceImpl <em>PCM External Uncertainty Scenario In Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMExternalUncertaintyScenarioInResourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMExternalUncertaintyScenarioInResource()
		 * @generated
		 */
		EClass PCM_EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE = eINSTANCE.getPCMExternalUncertaintyScenarioInResource();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE__TARGET = eINSTANCE.getPCMExternalUncertaintyScenarioInResource_Target();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMExternalUncertaintyScenarioInUsageImpl <em>PCM External Uncertainty Scenario In Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMExternalUncertaintyScenarioInUsageImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMExternalUncertaintyScenarioInUsage()
		 * @generated
		 */
		EClass PCM_EXTERNAL_UNCERTAINTY_SCENARIO_IN_USAGE = eINSTANCE.getPCMExternalUncertaintyScenarioInUsage();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_EXTERNAL_UNCERTAINTY_SCENARIO_IN_USAGE__TARGET = eINSTANCE.getPCMExternalUncertaintyScenarioInUsage_Target();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMBehaviorUncertaintySourceImpl <em>PCM Behavior Uncertainty Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMBehaviorUncertaintySourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMBehaviorUncertaintySource()
		 * @generated
		 */
		EClass PCM_BEHAVIOR_UNCERTAINTY_SOURCE = eINSTANCE.getPCMBehaviorUncertaintySource();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_BEHAVIOR_UNCERTAINTY_SOURCE__TARGET = eINSTANCE.getPCMBehaviorUncertaintySource_Target();

		/**
		 * The meta object literal for the '<em><b>Scenarios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_BEHAVIOR_UNCERTAINTY_SOURCE__SCENARIOS = eINSTANCE.getPCMBehaviorUncertaintySource_Scenarios();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMBehaviorUncertaintyScenarioImpl <em>PCM Behavior Uncertainty Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMBehaviorUncertaintyScenarioImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMBehaviorUncertaintyScenario()
		 * @generated
		 */
		EClass PCM_BEHAVIOR_UNCERTAINTY_SCENARIO = eINSTANCE.getPCMBehaviorUncertaintyScenario();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_BEHAVIOR_UNCERTAINTY_SCENARIO__TARGET = eINSTANCE.getPCMBehaviorUncertaintyScenario_Target();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMInterfaceUncertaintySourceImpl <em>PCM Interface Uncertainty Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMInterfaceUncertaintySourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMInterfaceUncertaintySource()
		 * @generated
		 */
		EClass PCM_INTERFACE_UNCERTAINTY_SOURCE = eINSTANCE.getPCMInterfaceUncertaintySource();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_INTERFACE_UNCERTAINTY_SOURCE__TARGET = eINSTANCE.getPCMInterfaceUncertaintySource_Target();

		/**
		 * The meta object literal for the '<em><b>Scenarios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_INTERFACE_UNCERTAINTY_SOURCE__SCENARIOS = eINSTANCE.getPCMInterfaceUncertaintySource_Scenarios();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMInterfaceUncertaintyScenarioImpl <em>PCM Interface Uncertainty Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMInterfaceUncertaintyScenarioImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMInterfaceUncertaintyScenario()
		 * @generated
		 */
		EClass PCM_INTERFACE_UNCERTAINTY_SCENARIO = eINSTANCE.getPCMInterfaceUncertaintyScenario();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_INTERFACE_UNCERTAINTY_SCENARIO__TARGET = eINSTANCE.getPCMInterfaceUncertaintyScenario_Target();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMConnectorUncertaintySourceImpl <em>PCM Connector Uncertainty Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMConnectorUncertaintySourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMConnectorUncertaintySource()
		 * @generated
		 */
		EClass PCM_CONNECTOR_UNCERTAINTY_SOURCE = eINSTANCE.getPCMConnectorUncertaintySource();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMConnectorUncertaintySourceInExternalCallImpl <em>PCM Connector Uncertainty Source In External Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMConnectorUncertaintySourceInExternalCallImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMConnectorUncertaintySourceInExternalCall()
		 * @generated
		 */
		EClass PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL = eINSTANCE.getPCMConnectorUncertaintySourceInExternalCall();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL__TARGET = eINSTANCE.getPCMConnectorUncertaintySourceInExternalCall_Target();

		/**
		 * The meta object literal for the '<em><b>Scenarios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL__SCENARIOS = eINSTANCE.getPCMConnectorUncertaintySourceInExternalCall_Scenarios();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMConnectorUncertaintySourceInEntryLevelSystemCallImpl <em>PCM Connector Uncertainty Source In Entry Level System Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMConnectorUncertaintySourceInEntryLevelSystemCallImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMConnectorUncertaintySourceInEntryLevelSystemCall()
		 * @generated
		 */
		EClass PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL = eINSTANCE.getPCMConnectorUncertaintySourceInEntryLevelSystemCall();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL__TARGET = eINSTANCE.getPCMConnectorUncertaintySourceInEntryLevelSystemCall_Target();

		/**
		 * The meta object literal for the '<em><b>Scenarios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL__SCENARIOS = eINSTANCE.getPCMConnectorUncertaintySourceInEntryLevelSystemCall_Scenarios();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMConnectorUncertaintyScenarioInExternalCallImpl <em>PCM Connector Uncertainty Scenario In External Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMConnectorUncertaintyScenarioInExternalCallImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMConnectorUncertaintyScenarioInExternalCall()
		 * @generated
		 */
		EClass PCM_CONNECTOR_UNCERTAINTY_SCENARIO_IN_EXTERNAL_CALL = eINSTANCE.getPCMConnectorUncertaintyScenarioInExternalCall();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_CONNECTOR_UNCERTAINTY_SCENARIO_IN_EXTERNAL_CALL__TARGET = eINSTANCE.getPCMConnectorUncertaintyScenarioInExternalCall_Target();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMConnectorUncertaintyScenarioInEntryLevelSystemCallImpl <em>PCM Connector Uncertainty Scenario In Entry Level System Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMConnectorUncertaintyScenarioInEntryLevelSystemCallImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMConnectorUncertaintyScenarioInEntryLevelSystemCall()
		 * @generated
		 */
		EClass PCM_CONNECTOR_UNCERTAINTY_SCENARIO_IN_ENTRY_LEVEL_SYSTEM_CALL = eINSTANCE.getPCMConnectorUncertaintyScenarioInEntryLevelSystemCall();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_CONNECTOR_UNCERTAINTY_SCENARIO_IN_ENTRY_LEVEL_SYSTEM_CALL__TARGET = eINSTANCE.getPCMConnectorUncertaintyScenarioInEntryLevelSystemCall_Target();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMComponentUncertaintySourceImpl <em>PCM Component Uncertainty Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMComponentUncertaintySourceImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMComponentUncertaintySource()
		 * @generated
		 */
		EClass PCM_COMPONENT_UNCERTAINTY_SOURCE = eINSTANCE.getPCMComponentUncertaintySource();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_COMPONENT_UNCERTAINTY_SOURCE__TARGET = eINSTANCE.getPCMComponentUncertaintySource_Target();

		/**
		 * The meta object literal for the '<em><b>Scenarios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_COMPONENT_UNCERTAINTY_SOURCE__SCENARIOS = eINSTANCE.getPCMComponentUncertaintySource_Scenarios();

		/**
		 * The meta object literal for the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMComponentUncertaintyScenarioImpl <em>PCM Component Uncertainty Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMComponentUncertaintyScenarioImpl
		 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmPackageImpl#getPCMComponentUncertaintyScenario()
		 * @generated
		 */
		EClass PCM_COMPONENT_UNCERTAINTY_SCENARIO = eINSTANCE.getPCMComponentUncertaintyScenario();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCM_COMPONENT_UNCERTAINTY_SCENARIO__TARGET = eINSTANCE.getPCMComponentUncertaintyScenario_Target();

	}

} //PcmPackage
