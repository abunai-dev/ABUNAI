/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.dfd.util;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;

import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage
 * @generated
 */
public class DfdSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DfdPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DfdSwitch() {
		if (modelPackage == null) {
			modelPackage = DfdPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case DfdPackage.DFD_UNCERTAINTY_SOURCE: {
				DFDUncertaintySource dfdUncertaintySource = (DFDUncertaintySource)theEObject;
				T result = caseDFDUncertaintySource(dfdUncertaintySource);
				if (result == null) result = caseUncertaintySource(dfdUncertaintySource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DfdPackage.DFD_EXTERNAL_UNCERTAINTY_SOURCE: {
				DFDExternalUncertaintySource dfdExternalUncertaintySource = (DFDExternalUncertaintySource)theEObject;
				T result = caseDFDExternalUncertaintySource(dfdExternalUncertaintySource);
				if (result == null) result = caseDFDUncertaintySource(dfdExternalUncertaintySource);
				if (result == null) result = caseUncertaintySource(dfdExternalUncertaintySource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DfdPackage.DFD_EXTERNAL_UNCERTAINTY_SCENARIO: {
				DFDExternalUncertaintyScenario dfdExternalUncertaintyScenario = (DFDExternalUncertaintyScenario)theEObject;
				T result = caseDFDExternalUncertaintyScenario(dfdExternalUncertaintyScenario);
				if (result == null) result = caseUncertaintyScenario(dfdExternalUncertaintyScenario);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DfdPackage.DFD_BEHAVIOR_UNCERTAINTY_SOURCE: {
				DFDBehaviorUncertaintySource dfdBehaviorUncertaintySource = (DFDBehaviorUncertaintySource)theEObject;
				T result = caseDFDBehaviorUncertaintySource(dfdBehaviorUncertaintySource);
				if (result == null) result = caseDFDUncertaintySource(dfdBehaviorUncertaintySource);
				if (result == null) result = caseUncertaintySource(dfdBehaviorUncertaintySource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DfdPackage.DFD_BEHAVIOR_UNCERTAINTY_SCENARIO: {
				DFDBehaviorUncertaintyScenario dfdBehaviorUncertaintyScenario = (DFDBehaviorUncertaintyScenario)theEObject;
				T result = caseDFDBehaviorUncertaintyScenario(dfdBehaviorUncertaintyScenario);
				if (result == null) result = caseUncertaintyScenario(dfdBehaviorUncertaintyScenario);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DfdPackage.DFD_INTERFACE_UNCERTAINTY_SOURCE: {
				DFDInterfaceUncertaintySource dfdInterfaceUncertaintySource = (DFDInterfaceUncertaintySource)theEObject;
				T result = caseDFDInterfaceUncertaintySource(dfdInterfaceUncertaintySource);
				if (result == null) result = caseDFDUncertaintySource(dfdInterfaceUncertaintySource);
				if (result == null) result = caseUncertaintySource(dfdInterfaceUncertaintySource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DfdPackage.DFD_INTERFACE_UNCERTAINTY_SCENARIO: {
				DFDInterfaceUncertaintyScenario dfdInterfaceUncertaintyScenario = (DFDInterfaceUncertaintyScenario)theEObject;
				T result = caseDFDInterfaceUncertaintyScenario(dfdInterfaceUncertaintyScenario);
				if (result == null) result = caseUncertaintyScenario(dfdInterfaceUncertaintyScenario);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SOURCE: {
				DFDConnectorUncertaintySource dfdConnectorUncertaintySource = (DFDConnectorUncertaintySource)theEObject;
				T result = caseDFDConnectorUncertaintySource(dfdConnectorUncertaintySource);
				if (result == null) result = caseDFDUncertaintySource(dfdConnectorUncertaintySource);
				if (result == null) result = caseUncertaintySource(dfdConnectorUncertaintySource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SCENARIO: {
				DFDConnectorUncertaintyScenario dfdConnectorUncertaintyScenario = (DFDConnectorUncertaintyScenario)theEObject;
				T result = caseDFDConnectorUncertaintyScenario(dfdConnectorUncertaintyScenario);
				if (result == null) result = caseUncertaintyScenario(dfdConnectorUncertaintyScenario);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DfdPackage.DFD_COMPONENT_UNCERTAINTY_SOURCE: {
				DFDComponentUncertaintySource dfdComponentUncertaintySource = (DFDComponentUncertaintySource)theEObject;
				T result = caseDFDComponentUncertaintySource(dfdComponentUncertaintySource);
				if (result == null) result = caseDFDUncertaintySource(dfdComponentUncertaintySource);
				if (result == null) result = caseUncertaintySource(dfdComponentUncertaintySource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DfdPackage.DFD_COMPONENT_UNCERTAINTY_SCENARIO: {
				DFDComponentUncertaintyScenario dfdComponentUncertaintyScenario = (DFDComponentUncertaintyScenario)theEObject;
				T result = caseDFDComponentUncertaintyScenario(dfdComponentUncertaintyScenario);
				if (result == null) result = caseUncertaintyScenario(dfdComponentUncertaintyScenario);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DFD Uncertainty Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DFD Uncertainty Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDFDUncertaintySource(DFDUncertaintySource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DFD External Uncertainty Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DFD External Uncertainty Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDFDExternalUncertaintySource(DFDExternalUncertaintySource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DFD External Uncertainty Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DFD External Uncertainty Scenario</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDFDExternalUncertaintyScenario(DFDExternalUncertaintyScenario object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DFD Behavior Uncertainty Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DFD Behavior Uncertainty Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDFDBehaviorUncertaintySource(DFDBehaviorUncertaintySource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DFD Behavior Uncertainty Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DFD Behavior Uncertainty Scenario</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDFDBehaviorUncertaintyScenario(DFDBehaviorUncertaintyScenario object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DFD Interface Uncertainty Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DFD Interface Uncertainty Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDFDInterfaceUncertaintySource(DFDInterfaceUncertaintySource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DFD Interface Uncertainty Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DFD Interface Uncertainty Scenario</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDFDInterfaceUncertaintyScenario(DFDInterfaceUncertaintyScenario object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DFD Connector Uncertainty Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DFD Connector Uncertainty Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDFDConnectorUncertaintySource(DFDConnectorUncertaintySource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DFD Connector Uncertainty Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DFD Connector Uncertainty Scenario</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDFDConnectorUncertaintyScenario(DFDConnectorUncertaintyScenario object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DFD Component Uncertainty Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DFD Component Uncertainty Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDFDComponentUncertaintySource(DFDComponentUncertaintySource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DFD Component Uncertainty Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DFD Component Uncertainty Scenario</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDFDComponentUncertaintyScenario(DFDComponentUncertaintyScenario object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUncertaintySource(UncertaintySource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scenario</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUncertaintyScenario(UncertaintyScenario object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //DfdSwitch
