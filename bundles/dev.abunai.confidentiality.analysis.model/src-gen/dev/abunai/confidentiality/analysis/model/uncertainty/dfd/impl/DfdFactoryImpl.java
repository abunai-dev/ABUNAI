/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl;

import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.*;

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
public class DfdFactoryImpl extends EFactoryImpl implements DfdFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DfdFactory init() {
		try {
			DfdFactory theDfdFactory = (DfdFactory)EPackage.Registry.INSTANCE.getEFactory(DfdPackage.eNS_URI);
			if (theDfdFactory != null) {
				return theDfdFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DfdFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DfdFactoryImpl() {
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
			case DfdPackage.EXTERNAL_UNCERTAINTY_SOURCE: return createExternalUncertaintySource();
			case DfdPackage.EXTERNAL_UNCERTAINTY_SCENARIO: return createExternalUncertaintyScenario();
			case DfdPackage.BEHAVIOR_UNCERTAINTY_SOURCE: return createBehaviorUncertaintySource();
			case DfdPackage.BEHAVIOR_UNCERTAINTY_SCENARIO: return createBehaviorUncertaintyScenario();
			case DfdPackage.INTERFACE_UNCERTAINTY_SOURCE: return createInterfaceUncertaintySource();
			case DfdPackage.INTERFACE_UNCERTAINTY_SCENARIO: return createInterfaceUncertaintyScenario();
			case DfdPackage.CONNECTOR_UNCERTAINTY_SOURCE: return createConnectorUncertaintySource();
			case DfdPackage.CONNECTOR_UNCERTAINTY_SCENARIO: return createConnectorUncertaintyScenario();
			case DfdPackage.COMPONENT_UNCERTAINTY_SOURCE: return createComponentUncertaintySource();
			case DfdPackage.COMPONENT_UNCERTAINTY_SCENARIO: return createComponentUncertaintyScenario();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalUncertaintySource createExternalUncertaintySource() {
		ExternalUncertaintySourceImpl externalUncertaintySource = new ExternalUncertaintySourceImpl();
		return externalUncertaintySource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalUncertaintyScenario createExternalUncertaintyScenario() {
		ExternalUncertaintyScenarioImpl externalUncertaintyScenario = new ExternalUncertaintyScenarioImpl();
		return externalUncertaintyScenario;
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
	public ConnectorUncertaintySource createConnectorUncertaintySource() {
		ConnectorUncertaintySourceImpl connectorUncertaintySource = new ConnectorUncertaintySourceImpl();
		return connectorUncertaintySource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectorUncertaintyScenario createConnectorUncertaintyScenario() {
		ConnectorUncertaintyScenarioImpl connectorUncertaintyScenario = new ConnectorUncertaintyScenarioImpl();
		return connectorUncertaintyScenario;
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
	public DfdPackage getDfdPackage() {
		return (DfdPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DfdPackage getPackage() {
		return DfdPackage.eINSTANCE;
	}

} //DfdFactoryImpl
