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
			case PcmPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE: return createExternalUncertaintySourceInResource();
			case PcmPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE: return createExternalUncertaintySourceInUsage();
			case PcmPackage.EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE: return createExternalUncertaintyScenarioInResource();
			case PcmPackage.EXTERNAL_UNCERTAINTY_SCENARIO_IN_USAGE: return createExternalUncertaintyScenarioInUsage();
			case PcmPackage.BEHAVIOR_UNCERTAINTY_SOURCE: return createBehaviorUncertaintySource();
			case PcmPackage.BEHAVIOR_UNCERTAINTY_SCENARIO: return createBehaviorUncertaintyScenario();
			case PcmPackage.INTERFACE_UNCERTAINTY_SOURCE: return createInterfaceUncertaintySource();
			case PcmPackage.INTERFACE_UNCERTAINTY_SCENARIO: return createInterfaceUncertaintyScenario();
			case PcmPackage.CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL: return createConnectorUncertaintySourceInExternalCall();
			case PcmPackage.CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL: return createConnectorUncertaintySourceInEntryLevelSystemCall();
			case PcmPackage.CONNECTOR_UNCERTAINTY_SCENARIO_IN_EXTERNAL_CALL: return createConnectorUncertaintyScenarioInExternalCall();
			case PcmPackage.CONNECTOR_UNCERTAINTY_SCENARIO_IN_ENTRY_LEVEL_SYSTEM_CALL: return createConnectorUncertaintyScenarioInEntryLevelSystemCall();
			case PcmPackage.COMPONENT_UNCERTAINTY_SOURCE: return createComponentUncertaintySource();
			case PcmPackage.COMPONENT_UNCERTAINTY_SCENARIO: return createComponentUncertaintyScenario();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalUncertaintySourceInResource createExternalUncertaintySourceInResource() {
		ExternalUncertaintySourceInResourceImpl externalUncertaintySourceInResource = new ExternalUncertaintySourceInResourceImpl();
		return externalUncertaintySourceInResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalUncertaintySourceInUsage createExternalUncertaintySourceInUsage() {
		ExternalUncertaintySourceInUsageImpl externalUncertaintySourceInUsage = new ExternalUncertaintySourceInUsageImpl();
		return externalUncertaintySourceInUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalUncertaintyScenarioInResource createExternalUncertaintyScenarioInResource() {
		ExternalUncertaintyScenarioInResourceImpl externalUncertaintyScenarioInResource = new ExternalUncertaintyScenarioInResourceImpl();
		return externalUncertaintyScenarioInResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalUncertaintyScenarioInUsage createExternalUncertaintyScenarioInUsage() {
		ExternalUncertaintyScenarioInUsageImpl externalUncertaintyScenarioInUsage = new ExternalUncertaintyScenarioInUsageImpl();
		return externalUncertaintyScenarioInUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorUncertaintySource createBehaviorUncertaintySource() {
		BehaviorUncertaintySourceImpl behaviorUncertaintySource = new BehaviorUncertaintySourceImpl();
		return behaviorUncertaintySource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorUncertaintyScenario createBehaviorUncertaintyScenario() {
		BehaviorUncertaintyScenarioImpl behaviorUncertaintyScenario = new BehaviorUncertaintyScenarioImpl();
		return behaviorUncertaintyScenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceUncertaintySource createInterfaceUncertaintySource() {
		InterfaceUncertaintySourceImpl interfaceUncertaintySource = new InterfaceUncertaintySourceImpl();
		return interfaceUncertaintySource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceUncertaintyScenario createInterfaceUncertaintyScenario() {
		InterfaceUncertaintyScenarioImpl interfaceUncertaintyScenario = new InterfaceUncertaintyScenarioImpl();
		return interfaceUncertaintyScenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectorUncertaintySourceInExternalCall createConnectorUncertaintySourceInExternalCall() {
		ConnectorUncertaintySourceInExternalCallImpl connectorUncertaintySourceInExternalCall = new ConnectorUncertaintySourceInExternalCallImpl();
		return connectorUncertaintySourceInExternalCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectorUncertaintySourceInEntryLevelSystemCall createConnectorUncertaintySourceInEntryLevelSystemCall() {
		ConnectorUncertaintySourceInEntryLevelSystemCallImpl connectorUncertaintySourceInEntryLevelSystemCall = new ConnectorUncertaintySourceInEntryLevelSystemCallImpl();
		return connectorUncertaintySourceInEntryLevelSystemCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectorUncertaintyScenarioInExternalCall createConnectorUncertaintyScenarioInExternalCall() {
		ConnectorUncertaintyScenarioInExternalCallImpl connectorUncertaintyScenarioInExternalCall = new ConnectorUncertaintyScenarioInExternalCallImpl();
		return connectorUncertaintyScenarioInExternalCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectorUncertaintyScenarioInEntryLevelSystemCall createConnectorUncertaintyScenarioInEntryLevelSystemCall() {
		ConnectorUncertaintyScenarioInEntryLevelSystemCallImpl connectorUncertaintyScenarioInEntryLevelSystemCall = new ConnectorUncertaintyScenarioInEntryLevelSystemCallImpl();
		return connectorUncertaintyScenarioInEntryLevelSystemCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentUncertaintySource createComponentUncertaintySource() {
		ComponentUncertaintySourceImpl componentUncertaintySource = new ComponentUncertaintySourceImpl();
		return componentUncertaintySource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentUncertaintyScenario createComponentUncertaintyScenario() {
		ComponentUncertaintyScenarioImpl componentUncertaintyScenario = new ComponentUncertaintyScenarioImpl();
		return componentUncertaintyScenario;
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
