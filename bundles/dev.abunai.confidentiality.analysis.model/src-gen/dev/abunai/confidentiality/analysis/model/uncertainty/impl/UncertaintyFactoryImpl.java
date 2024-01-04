/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.impl;

import dev.abunai.confidentiality.analysis.model.uncertainty.*;

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
public class UncertaintyFactoryImpl extends EFactoryImpl implements UncertaintyFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UncertaintyFactory init() {
		try {
			UncertaintyFactory theUncertaintyFactory = (UncertaintyFactory)EPackage.Registry.INSTANCE.getEFactory(UncertaintyPackage.eNS_URI);
			if (theUncertaintyFactory != null) {
				return theUncertaintyFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UncertaintyFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UncertaintyFactoryImpl() {
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
			case UncertaintyPackage.UNCERTAINTY_SOURCE_COLLECTION: return createUncertaintySourceCollection();
			case UncertaintyPackage.BEHAVIOR_UNCERTAINTY_SOURCE: return createBehaviorUncertaintySource();
			case UncertaintyPackage.BEHAVIOR_UNCERTAINTY_SCENARIO: return createBehaviorUncertaintyScenario();
			case UncertaintyPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE: return createExternalUncertaintySourceInResource();
			case UncertaintyPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE: return createExternalUncertaintySourceInUsage();
			case UncertaintyPackage.EXTERNAL_UNCERTAINTY_IN_RESOURCE_SCENARIO: return createExternalUncertaintyInResourceScenario();
			case UncertaintyPackage.EXTERNAL_UNCERTAINTY_IN_USAGE_SCENARIO: return createExternalUncertaintyInUsageScenario();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UncertaintySourceCollection createUncertaintySourceCollection() {
		UncertaintySourceCollectionImpl uncertaintySourceCollection = new UncertaintySourceCollectionImpl();
		return uncertaintySourceCollection;
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
	public ExternalUncertaintyInResourceScenario createExternalUncertaintyInResourceScenario() {
		ExternalUncertaintyInResourceScenarioImpl externalUncertaintyInResourceScenario = new ExternalUncertaintyInResourceScenarioImpl();
		return externalUncertaintyInResourceScenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalUncertaintyInUsageScenario createExternalUncertaintyInUsageScenario() {
		ExternalUncertaintyInUsageScenarioImpl externalUncertaintyInUsageScenario = new ExternalUncertaintyInUsageScenarioImpl();
		return externalUncertaintyInUsageScenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UncertaintyPackage getUncertaintyPackage() {
		return (UncertaintyPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UncertaintyPackage getPackage() {
		return UncertaintyPackage.eINSTANCE;
	}

} //UncertaintyFactoryImpl
