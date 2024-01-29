/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl;

import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PcmFactoryImpl extends EFactoryImpl implements PcmFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PcmFactory init() {
		try {
			PcmFactory thePcmFactory = (PcmFactory)EPackage.Registry.INSTANCE.getEFactory(PcmPackage.eNS_URI);
			if (thePcmFactory != null) {
				return thePcmFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PcmFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PcmFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case PcmPackage.PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE: return createPCMExternalUncertaintySourceInResource();
			case PcmPackage.PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE: return createPCMExternalUncertaintySourceInUsage();
			case PcmPackage.PCM_EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE: return createPCMExternalUncertaintyScenarioInResource();
			case PcmPackage.PCM_EXTERNAL_UNCERTAINTY_SCENARIO_IN_USAGE: return createPCMExternalUncertaintyScenarioInUsage();
			case PcmPackage.PCM_BEHAVIOR_UNCERTAINTY_SOURCE: return createPCMBehaviorUncertaintySource();
			case PcmPackage.PCM_BEHAVIOR_UNCERTAINTY_SCENARIO: return createPCMBehaviorUncertaintyScenario();
			case PcmPackage.PCM_INTERFACE_UNCERTAINTY_SOURCE: return createPCMInterfaceUncertaintySource();
			case PcmPackage.PCM_INTERFACE_UNCERTAINTY_SCENARIO: return createPCMInterfaceUncertaintyScenario();
			case PcmPackage.PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL: return createPCMConnectorUncertaintySourceInExternalCall();
			case PcmPackage.PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL: return createPCMConnectorUncertaintySourceInEntryLevelSystemCall();
			case PcmPackage.PCM_CONNECTOR_UNCERTAINTY_SCENARIO_IN_EXTERNAL_CALL: return createPCMConnectorUncertaintyScenarioInExternalCall();
			case PcmPackage.PCM_CONNECTOR_UNCERTAINTY_SCENARIO_IN_ENTRY_LEVEL_SYSTEM_CALL: return createPCMConnectorUncertaintyScenarioInEntryLevelSystemCall();
			case PcmPackage.PCM_COMPONENT_UNCERTAINTY_SOURCE: return createPCMComponentUncertaintySource();
			case PcmPackage.PCM_COMPONENT_UNCERTAINTY_SCENARIO: return createPCMComponentUncertaintyScenario();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMExternalUncertaintySourceInResource createPCMExternalUncertaintySourceInResource() {
		PCMExternalUncertaintySourceInResourceImpl pcmExternalUncertaintySourceInResource = new PCMExternalUncertaintySourceInResourceImpl();
		return pcmExternalUncertaintySourceInResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMExternalUncertaintySourceInUsage createPCMExternalUncertaintySourceInUsage() {
		PCMExternalUncertaintySourceInUsageImpl pcmExternalUncertaintySourceInUsage = new PCMExternalUncertaintySourceInUsageImpl();
		return pcmExternalUncertaintySourceInUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMExternalUncertaintyScenarioInResource createPCMExternalUncertaintyScenarioInResource() {
		PCMExternalUncertaintyScenarioInResourceImpl pcmExternalUncertaintyScenarioInResource = new PCMExternalUncertaintyScenarioInResourceImpl();
		return pcmExternalUncertaintyScenarioInResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMExternalUncertaintyScenarioInUsage createPCMExternalUncertaintyScenarioInUsage() {
		PCMExternalUncertaintyScenarioInUsageImpl pcmExternalUncertaintyScenarioInUsage = new PCMExternalUncertaintyScenarioInUsageImpl();
		return pcmExternalUncertaintyScenarioInUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMBehaviorUncertaintySource createPCMBehaviorUncertaintySource() {
		PCMBehaviorUncertaintySourceImpl pcmBehaviorUncertaintySource = new PCMBehaviorUncertaintySourceImpl();
		return pcmBehaviorUncertaintySource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMBehaviorUncertaintyScenario createPCMBehaviorUncertaintyScenario() {
		PCMBehaviorUncertaintyScenarioImpl pcmBehaviorUncertaintyScenario = new PCMBehaviorUncertaintyScenarioImpl();
		return pcmBehaviorUncertaintyScenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMInterfaceUncertaintySource createPCMInterfaceUncertaintySource() {
		PCMInterfaceUncertaintySourceImpl pcmInterfaceUncertaintySource = new PCMInterfaceUncertaintySourceImpl();
		return pcmInterfaceUncertaintySource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMInterfaceUncertaintyScenario createPCMInterfaceUncertaintyScenario() {
		PCMInterfaceUncertaintyScenarioImpl pcmInterfaceUncertaintyScenario = new PCMInterfaceUncertaintyScenarioImpl();
		return pcmInterfaceUncertaintyScenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMConnectorUncertaintySourceInExternalCall createPCMConnectorUncertaintySourceInExternalCall() {
		PCMConnectorUncertaintySourceInExternalCallImpl pcmConnectorUncertaintySourceInExternalCall = new PCMConnectorUncertaintySourceInExternalCallImpl();
		return pcmConnectorUncertaintySourceInExternalCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMConnectorUncertaintySourceInEntryLevelSystemCall createPCMConnectorUncertaintySourceInEntryLevelSystemCall() {
		PCMConnectorUncertaintySourceInEntryLevelSystemCallImpl pcmConnectorUncertaintySourceInEntryLevelSystemCall = new PCMConnectorUncertaintySourceInEntryLevelSystemCallImpl();
		return pcmConnectorUncertaintySourceInEntryLevelSystemCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMConnectorUncertaintyScenarioInExternalCall createPCMConnectorUncertaintyScenarioInExternalCall() {
		PCMConnectorUncertaintyScenarioInExternalCallImpl pcmConnectorUncertaintyScenarioInExternalCall = new PCMConnectorUncertaintyScenarioInExternalCallImpl();
		return pcmConnectorUncertaintyScenarioInExternalCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMConnectorUncertaintyScenarioInEntryLevelSystemCall createPCMConnectorUncertaintyScenarioInEntryLevelSystemCall() {
		PCMConnectorUncertaintyScenarioInEntryLevelSystemCallImpl pcmConnectorUncertaintyScenarioInEntryLevelSystemCall = new PCMConnectorUncertaintyScenarioInEntryLevelSystemCallImpl();
		return pcmConnectorUncertaintyScenarioInEntryLevelSystemCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMComponentUncertaintySource createPCMComponentUncertaintySource() {
		PCMComponentUncertaintySourceImpl pcmComponentUncertaintySource = new PCMComponentUncertaintySourceImpl();
		return pcmComponentUncertaintySource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMComponentUncertaintyScenario createPCMComponentUncertaintyScenario() {
		PCMComponentUncertaintyScenarioImpl pcmComponentUncertaintyScenario = new PCMComponentUncertaintyScenarioImpl();
		return pcmComponentUncertaintyScenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PcmPackage getPcmPackage() {
		return (PcmPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PcmPackage getPackage() {
		return PcmPackage.eINSTANCE;
	}

} //PcmFactoryImpl
