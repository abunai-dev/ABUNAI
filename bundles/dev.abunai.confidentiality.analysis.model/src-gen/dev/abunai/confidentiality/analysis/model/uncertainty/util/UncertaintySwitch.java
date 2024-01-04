/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.util;

import dev.abunai.confidentiality.analysis.model.uncertainty.*;

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
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage
 * @generated
 */
public class UncertaintySwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UncertaintyPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UncertaintySwitch() {
		if (modelPackage == null) {
			modelPackage = UncertaintyPackage.eINSTANCE;
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
			case UncertaintyPackage.UNCERTAINTY_SOURCE_COLLECTION: {
				UncertaintySourceCollection uncertaintySourceCollection = (UncertaintySourceCollection)theEObject;
				T result = caseUncertaintySourceCollection(uncertaintySourceCollection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UncertaintyPackage.UNCERTAINTY_SOURCE: {
				UncertaintySource uncertaintySource = (UncertaintySource)theEObject;
				T result = caseUncertaintySource(uncertaintySource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UncertaintyPackage.UNCERTAINTY_SCENARIO: {
				UncertaintyScenario uncertaintyScenario = (UncertaintyScenario)theEObject;
				T result = caseUncertaintyScenario(uncertaintyScenario);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UncertaintyPackage.BEHAVIOR_UNCERTAINTY_SOURCE: {
				BehaviorUncertaintySource behaviorUncertaintySource = (BehaviorUncertaintySource)theEObject;
				T result = caseBehaviorUncertaintySource(behaviorUncertaintySource);
				if (result == null) result = caseUncertaintySource(behaviorUncertaintySource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UncertaintyPackage.BEHAVIOR_UNCERTAINTY_SCENARIO: {
				BehaviorUncertaintyScenario behaviorUncertaintyScenario = (BehaviorUncertaintyScenario)theEObject;
				T result = caseBehaviorUncertaintyScenario(behaviorUncertaintyScenario);
				if (result == null) result = caseUncertaintyScenario(behaviorUncertaintyScenario);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UncertaintyPackage.EXTERNAL_UNCERTAINTY_SOURCE: {
				ExternalUncertaintySource externalUncertaintySource = (ExternalUncertaintySource)theEObject;
				T result = caseExternalUncertaintySource(externalUncertaintySource);
				if (result == null) result = caseUncertaintySource(externalUncertaintySource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UncertaintyPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE: {
				ExternalUncertaintySourceInResource externalUncertaintySourceInResource = (ExternalUncertaintySourceInResource)theEObject;
				T result = caseExternalUncertaintySourceInResource(externalUncertaintySourceInResource);
				if (result == null) result = caseExternalUncertaintySource(externalUncertaintySourceInResource);
				if (result == null) result = caseUncertaintySource(externalUncertaintySourceInResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UncertaintyPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE: {
				ExternalUncertaintySourceInUsage externalUncertaintySourceInUsage = (ExternalUncertaintySourceInUsage)theEObject;
				T result = caseExternalUncertaintySourceInUsage(externalUncertaintySourceInUsage);
				if (result == null) result = caseExternalUncertaintySource(externalUncertaintySourceInUsage);
				if (result == null) result = caseUncertaintySource(externalUncertaintySourceInUsage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UncertaintyPackage.EXTERNAL_UNCERTAINTY_IN_RESOURCE_SCENARIO: {
				ExternalUncertaintyInResourceScenario externalUncertaintyInResourceScenario = (ExternalUncertaintyInResourceScenario)theEObject;
				T result = caseExternalUncertaintyInResourceScenario(externalUncertaintyInResourceScenario);
				if (result == null) result = caseUncertaintyScenario(externalUncertaintyInResourceScenario);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UncertaintyPackage.EXTERNAL_UNCERTAINTY_IN_USAGE_SCENARIO: {
				ExternalUncertaintyInUsageScenario externalUncertaintyInUsageScenario = (ExternalUncertaintyInUsageScenario)theEObject;
				T result = caseExternalUncertaintyInUsageScenario(externalUncertaintyInUsageScenario);
				if (result == null) result = caseUncertaintyScenario(externalUncertaintyInUsageScenario);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source Collection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source Collection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUncertaintySourceCollection(UncertaintySourceCollection object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Behavior Uncertainty Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Behavior Uncertainty Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBehaviorUncertaintySource(BehaviorUncertaintySource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Behavior Uncertainty Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Behavior Uncertainty Scenario</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBehaviorUncertaintyScenario(BehaviorUncertaintyScenario object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Uncertainty Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Uncertainty Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternalUncertaintySource(ExternalUncertaintySource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Uncertainty Source In Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Uncertainty Source In Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternalUncertaintySourceInResource(ExternalUncertaintySourceInResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Uncertainty Source In Usage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Uncertainty Source In Usage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternalUncertaintySourceInUsage(ExternalUncertaintySourceInUsage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Uncertainty In Resource Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Uncertainty In Resource Scenario</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternalUncertaintyInResourceScenario(ExternalUncertaintyInResourceScenario object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Uncertainty In Usage Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Uncertainty In Usage Scenario</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternalUncertaintyInUsageScenario(ExternalUncertaintyInUsageScenario object) {
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

} //UncertaintySwitch
