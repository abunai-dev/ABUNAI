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
			public Adapter casePCMUncertaintySource(PCMUncertaintySource object) {
				return createPCMUncertaintySourceAdapter();
			}
			@Override
			public Adapter casePCMExternalUncertaintySource(PCMExternalUncertaintySource object) {
				return createPCMExternalUncertaintySourceAdapter();
			}
			@Override
			public Adapter casePCMExternalUncertaintySourceInResource(PCMExternalUncertaintySourceInResource object) {
				return createPCMExternalUncertaintySourceInResourceAdapter();
			}
			@Override
			public Adapter casePCMExternalUncertaintySourceInUsage(PCMExternalUncertaintySourceInUsage object) {
				return createPCMExternalUncertaintySourceInUsageAdapter();
			}
			@Override
			public Adapter casePCMExternalUncertaintyScenarioInResource(PCMExternalUncertaintyScenarioInResource object) {
				return createPCMExternalUncertaintyScenarioInResourceAdapter();
			}
			@Override
			public Adapter casePCMExternalUncertaintyScenarioInUsage(PCMExternalUncertaintyScenarioInUsage object) {
				return createPCMExternalUncertaintyScenarioInUsageAdapter();
			}
			@Override
			public Adapter casePCMBehaviorUncertaintySource(PCMBehaviorUncertaintySource object) {
				return createPCMBehaviorUncertaintySourceAdapter();
			}
			@Override
			public Adapter casePCMBehaviorUncertaintyScenario(PCMBehaviorUncertaintyScenario object) {
				return createPCMBehaviorUncertaintyScenarioAdapter();
			}
			@Override
			public Adapter casePCMInterfaceUncertaintySource(PCMInterfaceUncertaintySource object) {
				return createPCMInterfaceUncertaintySourceAdapter();
			}
			@Override
			public Adapter casePCMInterfaceUncertaintyScenario(PCMInterfaceUncertaintyScenario object) {
				return createPCMInterfaceUncertaintyScenarioAdapter();
			}
			@Override
			public Adapter casePCMConnectorUncertaintySource(PCMConnectorUncertaintySource object) {
				return createPCMConnectorUncertaintySourceAdapter();
			}
			@Override
			public Adapter casePCMConnectorUncertaintySourceInExternalCall(PCMConnectorUncertaintySourceInExternalCall object) {
				return createPCMConnectorUncertaintySourceInExternalCallAdapter();
			}
			@Override
			public Adapter casePCMConnectorUncertaintySourceInEntryLevelSystemCall(PCMConnectorUncertaintySourceInEntryLevelSystemCall object) {
				return createPCMConnectorUncertaintySourceInEntryLevelSystemCallAdapter();
			}
			@Override
			public Adapter casePCMConnectorUncertaintyScenarioInExternalCall(PCMConnectorUncertaintyScenarioInExternalCall object) {
				return createPCMConnectorUncertaintyScenarioInExternalCallAdapter();
			}
			@Override
			public Adapter casePCMConnectorUncertaintyScenarioInEntryLevelSystemCall(PCMConnectorUncertaintyScenarioInEntryLevelSystemCall object) {
				return createPCMConnectorUncertaintyScenarioInEntryLevelSystemCallAdapter();
			}
			@Override
			public Adapter casePCMComponentUncertaintySource(PCMComponentUncertaintySource object) {
				return createPCMComponentUncertaintySourceAdapter();
			}
			@Override
			public Adapter casePCMComponentUncertaintyScenario(PCMComponentUncertaintyScenario object) {
				return createPCMComponentUncertaintyScenarioAdapter();
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
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMUncertaintySource <em>PCM Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMUncertaintySource
	 * @generated
	 */
	public Adapter createPCMUncertaintySourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySource <em>PCM External Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySource
	 * @generated
	 */
	public Adapter createPCMExternalUncertaintySourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySourceInResource <em>PCM External Uncertainty Source In Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySourceInResource
	 * @generated
	 */
	public Adapter createPCMExternalUncertaintySourceInResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySourceInUsage <em>PCM External Uncertainty Source In Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySourceInUsage
	 * @generated
	 */
	public Adapter createPCMExternalUncertaintySourceInUsageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintyScenarioInResource <em>PCM External Uncertainty Scenario In Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintyScenarioInResource
	 * @generated
	 */
	public Adapter createPCMExternalUncertaintyScenarioInResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintyScenarioInUsage <em>PCM External Uncertainty Scenario In Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintyScenarioInUsage
	 * @generated
	 */
	public Adapter createPCMExternalUncertaintyScenarioInUsageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMBehaviorUncertaintySource <em>PCM Behavior Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMBehaviorUncertaintySource
	 * @generated
	 */
	public Adapter createPCMBehaviorUncertaintySourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMBehaviorUncertaintyScenario <em>PCM Behavior Uncertainty Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMBehaviorUncertaintyScenario
	 * @generated
	 */
	public Adapter createPCMBehaviorUncertaintyScenarioAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMInterfaceUncertaintySource <em>PCM Interface Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMInterfaceUncertaintySource
	 * @generated
	 */
	public Adapter createPCMInterfaceUncertaintySourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMInterfaceUncertaintyScenario <em>PCM Interface Uncertainty Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMInterfaceUncertaintyScenario
	 * @generated
	 */
	public Adapter createPCMInterfaceUncertaintyScenarioAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySource <em>PCM Connector Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySource
	 * @generated
	 */
	public Adapter createPCMConnectorUncertaintySourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInExternalCall <em>PCM Connector Uncertainty Source In External Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInExternalCall
	 * @generated
	 */
	public Adapter createPCMConnectorUncertaintySourceInExternalCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInEntryLevelSystemCall <em>PCM Connector Uncertainty Source In Entry Level System Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInEntryLevelSystemCall
	 * @generated
	 */
	public Adapter createPCMConnectorUncertaintySourceInEntryLevelSystemCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintyScenarioInExternalCall <em>PCM Connector Uncertainty Scenario In External Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintyScenarioInExternalCall
	 * @generated
	 */
	public Adapter createPCMConnectorUncertaintyScenarioInExternalCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintyScenarioInEntryLevelSystemCall <em>PCM Connector Uncertainty Scenario In Entry Level System Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintyScenarioInEntryLevelSystemCall
	 * @generated
	 */
	public Adapter createPCMConnectorUncertaintyScenarioInEntryLevelSystemCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMComponentUncertaintySource <em>PCM Component Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMComponentUncertaintySource
	 * @generated
	 */
	public Adapter createPCMComponentUncertaintySourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMComponentUncertaintyScenario <em>PCM Component Uncertainty Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMComponentUncertaintyScenario
	 * @generated
	 */
	public Adapter createPCMComponentUncertaintyScenarioAdapter() {
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
