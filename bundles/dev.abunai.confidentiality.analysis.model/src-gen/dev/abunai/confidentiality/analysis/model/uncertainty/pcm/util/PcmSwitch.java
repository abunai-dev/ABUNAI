/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.pcm.util;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;

import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.*;

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
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage
 * @generated
 */
public class PcmSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PcmPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PcmSwitch() {
		if (modelPackage == null) {
			modelPackage = PcmPackage.eINSTANCE;
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
			case PcmPackage.EXTERNAL_UNCERTAINTY_SOURCE: {
				ExternalUncertaintySource externalUncertaintySource = (ExternalUncertaintySource)theEObject;
				T result = caseExternalUncertaintySource(externalUncertaintySource);
				if (result == null) result = caseUncertaintySource(externalUncertaintySource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PcmPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE: {
				ExternalUncertaintySourceInResource externalUncertaintySourceInResource = (ExternalUncertaintySourceInResource)theEObject;
				T result = caseExternalUncertaintySourceInResource(externalUncertaintySourceInResource);
				if (result == null) result = caseExternalUncertaintySource(externalUncertaintySourceInResource);
				if (result == null) result = caseUncertaintySource(externalUncertaintySourceInResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PcmPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE: {
				ExternalUncertaintySourceInUsage externalUncertaintySourceInUsage = (ExternalUncertaintySourceInUsage)theEObject;
				T result = caseExternalUncertaintySourceInUsage(externalUncertaintySourceInUsage);
				if (result == null) result = caseExternalUncertaintySource(externalUncertaintySourceInUsage);
				if (result == null) result = caseUncertaintySource(externalUncertaintySourceInUsage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PcmPackage.EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE: {
				ExternalUncertaintyScenarioInResource externalUncertaintyScenarioInResource = (ExternalUncertaintyScenarioInResource)theEObject;
				T result = caseExternalUncertaintyScenarioInResource(externalUncertaintyScenarioInResource);
				if (result == null) result = caseUncertaintyScenario(externalUncertaintyScenarioInResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PcmPackage.EXTERNAL_UNCERTAINTY_SCENARIO_IN_USAGE: {
				ExternalUncertaintyScenarioInUsage externalUncertaintyScenarioInUsage = (ExternalUncertaintyScenarioInUsage)theEObject;
				T result = caseExternalUncertaintyScenarioInUsage(externalUncertaintyScenarioInUsage);
				if (result == null) result = caseUncertaintyScenario(externalUncertaintyScenarioInUsage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PcmPackage.BEHAVIOR_UNCERTAINTY_SOURCE: {
				BehaviorUncertaintySource behaviorUncertaintySource = (BehaviorUncertaintySource)theEObject;
				T result = caseBehaviorUncertaintySource(behaviorUncertaintySource);
				if (result == null) result = caseUncertaintySource(behaviorUncertaintySource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PcmPackage.BEHAVIOR_UNCERTAINTY_SCENARIO: {
				BehaviorUncertaintyScenario behaviorUncertaintyScenario = (BehaviorUncertaintyScenario)theEObject;
				T result = caseBehaviorUncertaintyScenario(behaviorUncertaintyScenario);
				if (result == null) result = caseUncertaintyScenario(behaviorUncertaintyScenario);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PcmPackage.INTERFACE_UNCERTAINTY_SOURCE: {
				InterfaceUncertaintySource interfaceUncertaintySource = (InterfaceUncertaintySource)theEObject;
				T result = caseInterfaceUncertaintySource(interfaceUncertaintySource);
				if (result == null) result = caseUncertaintySource(interfaceUncertaintySource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PcmPackage.INTERFACE_UNCERTAINTY_SCENARIO: {
				InterfaceUncertaintyScenario interfaceUncertaintyScenario = (InterfaceUncertaintyScenario)theEObject;
				T result = caseInterfaceUncertaintyScenario(interfaceUncertaintyScenario);
				if (result == null) result = caseUncertaintyScenario(interfaceUncertaintyScenario);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PcmPackage.CONNECTOR_UNCERTAINTY_SOURCE: {
				ConnectorUncertaintySource connectorUncertaintySource = (ConnectorUncertaintySource)theEObject;
				T result = caseConnectorUncertaintySource(connectorUncertaintySource);
				if (result == null) result = caseUncertaintySource(connectorUncertaintySource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PcmPackage.CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL: {
				ConnectorUncertaintySourceInExternalCall connectorUncertaintySourceInExternalCall = (ConnectorUncertaintySourceInExternalCall)theEObject;
				T result = caseConnectorUncertaintySourceInExternalCall(connectorUncertaintySourceInExternalCall);
				if (result == null) result = caseConnectorUncertaintySource(connectorUncertaintySourceInExternalCall);
				if (result == null) result = caseUncertaintySource(connectorUncertaintySourceInExternalCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PcmPackage.CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL: {
				ConnectorUncertaintySourceInEntryLevelSystemCall connectorUncertaintySourceInEntryLevelSystemCall = (ConnectorUncertaintySourceInEntryLevelSystemCall)theEObject;
				T result = caseConnectorUncertaintySourceInEntryLevelSystemCall(connectorUncertaintySourceInEntryLevelSystemCall);
				if (result == null) result = caseConnectorUncertaintySource(connectorUncertaintySourceInEntryLevelSystemCall);
				if (result == null) result = caseUncertaintySource(connectorUncertaintySourceInEntryLevelSystemCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PcmPackage.CONNECTOR_UNCERTAINTY_SCENARIO_IN_EXTERNAL_CALL: {
				ConnectorUncertaintyScenarioInExternalCall connectorUncertaintyScenarioInExternalCall = (ConnectorUncertaintyScenarioInExternalCall)theEObject;
				T result = caseConnectorUncertaintyScenarioInExternalCall(connectorUncertaintyScenarioInExternalCall);
				if (result == null) result = caseUncertaintyScenario(connectorUncertaintyScenarioInExternalCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PcmPackage.CONNECTOR_UNCERTAINTY_SCENARIO_IN_ENTRY_LEVEL_SYSTEM_CALL: {
				ConnectorUncertaintyScenarioInEntryLevelSystemCall connectorUncertaintyScenarioInEntryLevelSystemCall = (ConnectorUncertaintyScenarioInEntryLevelSystemCall)theEObject;
				T result = caseConnectorUncertaintyScenarioInEntryLevelSystemCall(connectorUncertaintyScenarioInEntryLevelSystemCall);
				if (result == null) result = caseUncertaintyScenario(connectorUncertaintyScenarioInEntryLevelSystemCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PcmPackage.COMPONENT_UNCERTAINTY_SOURCE: {
				ComponentUncertaintySource componentUncertaintySource = (ComponentUncertaintySource)theEObject;
				T result = caseComponentUncertaintySource(componentUncertaintySource);
				if (result == null) result = caseUncertaintySource(componentUncertaintySource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PcmPackage.COMPONENT_UNCERTAINTY_SCENARIO: {
				ComponentUncertaintyScenario componentUncertaintyScenario = (ComponentUncertaintyScenario)theEObject;
				T result = caseComponentUncertaintyScenario(componentUncertaintyScenario);
				if (result == null) result = caseUncertaintyScenario(componentUncertaintyScenario);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
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
	 * Returns the result of interpreting the object as an instance of '<em>External Uncertainty Scenario In Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Uncertainty Scenario In Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternalUncertaintyScenarioInResource(ExternalUncertaintyScenarioInResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Uncertainty Scenario In Usage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Uncertainty Scenario In Usage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternalUncertaintyScenarioInUsage(ExternalUncertaintyScenarioInUsage object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Interface Uncertainty Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface Uncertainty Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterfaceUncertaintySource(InterfaceUncertaintySource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface Uncertainty Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface Uncertainty Scenario</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterfaceUncertaintyScenario(InterfaceUncertaintyScenario object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector Uncertainty Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector Uncertainty Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectorUncertaintySource(ConnectorUncertaintySource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector Uncertainty Source In External Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector Uncertainty Source In External Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectorUncertaintySourceInExternalCall(ConnectorUncertaintySourceInExternalCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector Uncertainty Source In Entry Level System Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector Uncertainty Source In Entry Level System Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectorUncertaintySourceInEntryLevelSystemCall(ConnectorUncertaintySourceInEntryLevelSystemCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector Uncertainty Scenario In External Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector Uncertainty Scenario In External Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectorUncertaintyScenarioInExternalCall(ConnectorUncertaintyScenarioInExternalCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector Uncertainty Scenario In Entry Level System Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector Uncertainty Scenario In Entry Level System Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectorUncertaintyScenarioInEntryLevelSystemCall(ConnectorUncertaintyScenarioInEntryLevelSystemCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Uncertainty Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Uncertainty Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentUncertaintySource(ComponentUncertaintySource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Uncertainty Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Uncertainty Scenario</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentUncertaintyScenario(ComponentUncertaintyScenario object) {
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

} //PcmSwitch
