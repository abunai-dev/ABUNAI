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
			case DfdPackage.DFD_EXTERNAL_UNCERTAINTY_SOURCE: return createDFDExternalUncertaintySource();
			case DfdPackage.DFD_EXTERNAL_UNCERTAINTY_SCENARIO: return createDFDExternalUncertaintyScenario();
			case DfdPackage.DFD_BEHAVIOR_UNCERTAINTY_SOURCE: return createDFDBehaviorUncertaintySource();
			case DfdPackage.DFD_BEHAVIOR_UNCERTAINTY_SCENARIO: return createDFDBehaviorUncertaintyScenario();
			case DfdPackage.DFD_INTERFACE_UNCERTAINTY_SOURCE: return createDFDInterfaceUncertaintySource();
			case DfdPackage.DFD_INTERFACE_UNCERTAINTY_SCENARIO: return createDFDInterfaceUncertaintyScenario();
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SOURCE: return createDFDConnectorUncertaintySource();
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SCENARIO: return createDFDConnectorUncertaintyScenario();
			case DfdPackage.DFD_COMPONENT_UNCERTAINTY_SOURCE: return createDFDComponentUncertaintySource();
			case DfdPackage.DFD_COMPONENT_UNCERTAINTY_SCENARIO: return createDFDComponentUncertaintyScenario();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DFDExternalUncertaintySource createDFDExternalUncertaintySource() {
		DFDExternalUncertaintySourceImpl dfdExternalUncertaintySource = new DFDExternalUncertaintySourceImpl();
		return dfdExternalUncertaintySource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DFDExternalUncertaintyScenario createDFDExternalUncertaintyScenario() {
		DFDExternalUncertaintyScenarioImpl dfdExternalUncertaintyScenario = new DFDExternalUncertaintyScenarioImpl();
		return dfdExternalUncertaintyScenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DFDBehaviorUncertaintySource createDFDBehaviorUncertaintySource() {
		DFDBehaviorUncertaintySourceImpl dfdBehaviorUncertaintySource = new DFDBehaviorUncertaintySourceImpl();
		return dfdBehaviorUncertaintySource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DFDBehaviorUncertaintyScenario createDFDBehaviorUncertaintyScenario() {
		DFDBehaviorUncertaintyScenarioImpl dfdBehaviorUncertaintyScenario = new DFDBehaviorUncertaintyScenarioImpl();
		return dfdBehaviorUncertaintyScenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DFDInterfaceUncertaintySource createDFDInterfaceUncertaintySource() {
		DFDInterfaceUncertaintySourceImpl dfdInterfaceUncertaintySource = new DFDInterfaceUncertaintySourceImpl();
		return dfdInterfaceUncertaintySource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DFDInterfaceUncertaintyScenario createDFDInterfaceUncertaintyScenario() {
		DFDInterfaceUncertaintyScenarioImpl dfdInterfaceUncertaintyScenario = new DFDInterfaceUncertaintyScenarioImpl();
		return dfdInterfaceUncertaintyScenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DFDConnectorUncertaintySource createDFDConnectorUncertaintySource() {
		DFDConnectorUncertaintySourceImpl dfdConnectorUncertaintySource = new DFDConnectorUncertaintySourceImpl();
		return dfdConnectorUncertaintySource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DFDConnectorUncertaintyScenario createDFDConnectorUncertaintyScenario() {
		DFDConnectorUncertaintyScenarioImpl dfdConnectorUncertaintyScenario = new DFDConnectorUncertaintyScenarioImpl();
		return dfdConnectorUncertaintyScenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DFDComponentUncertaintySource createDFDComponentUncertaintySource() {
		DFDComponentUncertaintySourceImpl dfdComponentUncertaintySource = new DFDComponentUncertaintySourceImpl();
		return dfdComponentUncertaintySource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DFDComponentUncertaintyScenario createDFDComponentUncertaintyScenario() {
		DFDComponentUncertaintyScenarioImpl dfdComponentUncertaintyScenario = new DFDComponentUncertaintyScenarioImpl();
		return dfdComponentUncertaintyScenario;
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
