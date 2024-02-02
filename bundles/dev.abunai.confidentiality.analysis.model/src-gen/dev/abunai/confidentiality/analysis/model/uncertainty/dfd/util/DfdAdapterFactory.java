/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.dfd.util;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;

import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import tools.mdsd.modelingfoundations.identifier.Entity;
import tools.mdsd.modelingfoundations.identifier.Identifier;
import tools.mdsd.modelingfoundations.identifier.NamedElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage
 * @generated
 */
public class DfdAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DfdPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DfdAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DfdPackage.eINSTANCE;
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
	protected DfdSwitch<Adapter> modelSwitch =
		new DfdSwitch<Adapter>() {
			@Override
			public Adapter caseDFDUncertaintySource(DFDUncertaintySource object) {
				return createDFDUncertaintySourceAdapter();
			}
			@Override
			public Adapter caseDFDExternalUncertaintySource(DFDExternalUncertaintySource object) {
				return createDFDExternalUncertaintySourceAdapter();
			}
			@Override
			public Adapter caseDFDExternalUncertaintyScenario(DFDExternalUncertaintyScenario object) {
				return createDFDExternalUncertaintyScenarioAdapter();
			}
			@Override
			public Adapter caseDFDBehaviorUncertaintySource(DFDBehaviorUncertaintySource object) {
				return createDFDBehaviorUncertaintySourceAdapter();
			}
			@Override
			public Adapter caseDFDBehaviorUncertaintyScenario(DFDBehaviorUncertaintyScenario object) {
				return createDFDBehaviorUncertaintyScenarioAdapter();
			}
			@Override
			public Adapter caseDFDInterfaceUncertaintySource(DFDInterfaceUncertaintySource object) {
				return createDFDInterfaceUncertaintySourceAdapter();
			}
			@Override
			public Adapter caseDFDInterfaceUncertaintyScenario(DFDInterfaceUncertaintyScenario object) {
				return createDFDInterfaceUncertaintyScenarioAdapter();
			}
			@Override
			public Adapter caseDFDConnectorUncertaintySource(DFDConnectorUncertaintySource object) {
				return createDFDConnectorUncertaintySourceAdapter();
			}
			@Override
			public Adapter caseDFDConnectorUncertaintyScenario(DFDConnectorUncertaintyScenario object) {
				return createDFDConnectorUncertaintyScenarioAdapter();
			}
			@Override
			public Adapter caseDFDComponentUncertaintySource(DFDComponentUncertaintySource object) {
				return createDFDComponentUncertaintySourceAdapter();
			}
			@Override
			public Adapter caseDFDComponentUncertaintyScenario(DFDComponentUncertaintyScenario object) {
				return createDFDComponentUncertaintyScenarioAdapter();
			}
			@Override
			public Adapter caseIdentifier(Identifier object) {
				return createIdentifierAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseEntity(Entity object) {
				return createEntityAdapter();
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
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDUncertaintySource <em>DFD Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDUncertaintySource
	 * @generated
	 */
	public Adapter createDFDUncertaintySourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintySource <em>DFD External Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintySource
	 * @generated
	 */
	public Adapter createDFDExternalUncertaintySourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintyScenario <em>DFD External Uncertainty Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintyScenario
	 * @generated
	 */
	public Adapter createDFDExternalUncertaintyScenarioAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDBehaviorUncertaintySource <em>DFD Behavior Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDBehaviorUncertaintySource
	 * @generated
	 */
	public Adapter createDFDBehaviorUncertaintySourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDBehaviorUncertaintyScenario <em>DFD Behavior Uncertainty Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDBehaviorUncertaintyScenario
	 * @generated
	 */
	public Adapter createDFDBehaviorUncertaintyScenarioAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintySource <em>DFD Interface Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintySource
	 * @generated
	 */
	public Adapter createDFDInterfaceUncertaintySourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintyScenario <em>DFD Interface Uncertainty Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintyScenario
	 * @generated
	 */
	public Adapter createDFDInterfaceUncertaintyScenarioAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintySource <em>DFD Connector Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintySource
	 * @generated
	 */
	public Adapter createDFDConnectorUncertaintySourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintyScenario <em>DFD Connector Uncertainty Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintyScenario
	 * @generated
	 */
	public Adapter createDFDConnectorUncertaintyScenarioAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDComponentUncertaintySource <em>DFD Component Uncertainty Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDComponentUncertaintySource
	 * @generated
	 */
	public Adapter createDFDComponentUncertaintySourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDComponentUncertaintyScenario <em>DFD Component Uncertainty Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDComponentUncertaintyScenario
	 * @generated
	 */
	public Adapter createDFDComponentUncertaintyScenarioAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tools.mdsd.modelingfoundations.identifier.Identifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.mdsd.modelingfoundations.identifier.Identifier
	 * @generated
	 */
	public Adapter createIdentifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tools.mdsd.modelingfoundations.identifier.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.mdsd.modelingfoundations.identifier.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tools.mdsd.modelingfoundations.identifier.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.mdsd.modelingfoundations.identifier.Entity
	 * @generated
	 */
	public Adapter createEntityAdapter() {
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

} //DfdAdapterFactory
