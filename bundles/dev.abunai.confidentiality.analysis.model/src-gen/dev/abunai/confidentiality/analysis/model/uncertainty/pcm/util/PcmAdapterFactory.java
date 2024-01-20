/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.pcm.util;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;

import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage
 * @generated
 */
public class PcmAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PcmPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PcmAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = PcmPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PcmSwitch<Adapter> modelSwitch =
		new PcmSwitch<Adapter>() {
			@Override
			public Adapter caseExternalUncertaintySource(ExternalUncertaintySource object) {
				return createExternalUncertaintySourceAdapter();
			}
			@Override
			public Adapter caseExternalUncertaintySourceInResource(ExternalUncertaintySourceInResource object) {
				return createExternalUncertaintySourceInResourceAdapter();
			}
			@Override
			public Adapter caseExternalUncertaintySourceInUsage(ExternalUncertaintySourceInUsage object) {
				return createExternalUncertaintySourceInUsageAdapter();
			}
			@Override
			public Adapter caseExternalUncertaintyScenarioInResource(ExternalUncertaintyScenarioInResource object) {
				return createExternalUncertaintyScenarioInResourceAdapter();
			}
			@Override
			public Adapter caseExternalUncertaintyScenarioInUsage(ExternalUncertaintyScenarioInUsage object) {
				return createExternalUncertaintyScenarioInUsageAdapter();
			}
			@Override
			public Adapter caseBehaviorUncertaintySource(BehaviorUncertaintySource object) {
				return createBehaviorUncertaintySourceAdapter();
			}
			@Override
			public Adapter caseBehaviorUncertaintyScenario(BehaviorUncertaintyScenario object) {
				return createBehaviorUncertaintyScenarioAdapter();
			}
			@Override
			public Adapter caseInterfaceUncertaintySource(InterfaceUncertaintySource object) {
				return createInterfaceUncertaintySourceAdapter();
			}
			@Override
			public Adapter caseInterfaceUncertaintyScenario(InterfaceUncertaintyScenario object) {
				return createInterfaceUncertaintyScenarioAdapter();
			}
			@Override
			public Adapter caseConnectorUncertaintySource(ConnectorUncertaintySource object) {
				return createConnectorUncertaintySourceAdapter();
			}
			@Override
			public Adapter caseConnectorUncertaintySourceInExternalCall(ConnectorUncertaintySourceInExternalCall object) {
				return createConnectorUncertaintySourceInExternalCallAdapter();
			}
			@Override
			public Adapter caseConnectorUncertaintySourceInEntryLevelSystemCall(ConnectorUncertaintySourceInEntryLevelSystemCall object) {
				return createConnectorUncertaintySourceInEntryLevelSystemCallAdapter();
			}
			@Override
			public Adapter caseConnectorUncertaintyScenarioInExternalCall(ConnectorUncertaintyScenarioInExternalCall object) {
				return createConnectorUncertaintyScenarioInExternalCallAdapter();
			}
			@Override
			public Adapter caseConnectorUncertaintyScenarioInEntryLevelSystemCall(ConnectorUncertaintyScenarioInEntryLevelSystemCall object) {
				return createConnectorUncertaintyScenarioInEntryLevelSystemCallAdapter();
			}
			@Override
			public Adapter caseComponentUncertaintySource(ComponentUncertaintySource object) {
				return createComponentUncertaintySourceAdapter();
			}
			@Override
			public Adapter caseComponentUncertaintyScenario(ComponentUncertaintyScenario object) {
				return createComponentUncertaintyScenarioAdapter();
			}
			@Override
			public Adapter caseUncertaintySource(UncertaintySource object) {
				return createUncertaintySourceAdapter();
			}
			@Override
			public Adapter caseUncertaintyScenario(UncertaintyScenario object) {
				return createUncertaintyScenarioAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintySource <em>External Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintySource
	 * @generated
	 */
	public Adapter createExternalUncertaintySourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintySourceInResource <em>External Uncertainty Source In Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintySourceInResource
	 * @generated
	 */
	public Adapter createExternalUncertaintySourceInResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintySourceInUsage <em>External Uncertainty Source In Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintySourceInUsage
	 * @generated
	 */
	public Adapter createExternalUncertaintySourceInUsageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintyScenarioInResource <em>External Uncertainty Scenario In Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintyScenarioInResource
	 * @generated
	 */
	public Adapter createExternalUncertaintyScenarioInResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintyScenarioInUsage <em>External Uncertainty Scenario In Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintyScenarioInUsage
	 * @generated
	 */
	public Adapter createExternalUncertaintyScenarioInUsageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.BehaviorUncertaintySource <em>Behavior Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.BehaviorUncertaintySource
	 * @generated
	 */
	public Adapter createBehaviorUncertaintySourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.BehaviorUncertaintyScenario <em>Behavior Uncertainty Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.BehaviorUncertaintyScenario
	 * @generated
	 */
	public Adapter createBehaviorUncertaintyScenarioAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.InterfaceUncertaintySource <em>Interface Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.InterfaceUncertaintySource
	 * @generated
	 */
	public Adapter createInterfaceUncertaintySourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.InterfaceUncertaintyScenario <em>Interface Uncertainty Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.InterfaceUncertaintyScenario
	 * @generated
	 */
	public Adapter createInterfaceUncertaintyScenarioAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintySource <em>Connector Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintySource
	 * @generated
	 */
	public Adapter createConnectorUncertaintySourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintySourceInExternalCall <em>Connector Uncertainty Source In External Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintySourceInExternalCall
	 * @generated
	 */
	public Adapter createConnectorUncertaintySourceInExternalCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintySourceInEntryLevelSystemCall <em>Connector Uncertainty Source In Entry Level System Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintySourceInEntryLevelSystemCall
	 * @generated
	 */
	public Adapter createConnectorUncertaintySourceInEntryLevelSystemCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintyScenarioInExternalCall <em>Connector Uncertainty Scenario In External Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintyScenarioInExternalCall
	 * @generated
	 */
	public Adapter createConnectorUncertaintyScenarioInExternalCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintyScenarioInEntryLevelSystemCall <em>Connector Uncertainty Scenario In Entry Level System Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintyScenarioInEntryLevelSystemCall
	 * @generated
	 */
	public Adapter createConnectorUncertaintyScenarioInEntryLevelSystemCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ComponentUncertaintySource <em>Component Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ComponentUncertaintySource
	 * @generated
	 */
	public Adapter createComponentUncertaintySourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ComponentUncertaintyScenario <em>Component Uncertainty Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ComponentUncertaintyScenario
	 * @generated
	 */
	public Adapter createComponentUncertaintyScenarioAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource
	 * @generated
	 */
	public Adapter createUncertaintySourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario <em>Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario
	 * @generated
	 */
	public Adapter createUncertaintyScenarioAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //PcmAdapterFactory
