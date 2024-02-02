/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.pcm.util;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;

import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import tools.mdsd.modelingfoundations.identifier.Entity;
import tools.mdsd.modelingfoundations.identifier.Identifier;
import tools.mdsd.modelingfoundations.identifier.NamedElement;

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
			case PcmPackage.PCM_UNCERTAINTY_SOURCE: {
				PCMUncertaintySource pcmUncertaintySource = (PCMUncertaintySource)theEObject;
				T result = casePCMUncertaintySource(pcmUncertaintySource);
				if (result == null) result = caseUncertaintySource(pcmUncertaintySource);
				if (result == null) result = caseEntity(pcmUncertaintySource);
				if (result == null) result = caseIdentifier(pcmUncertaintySource);
				if (result == null) result = caseNamedElement(pcmUncertaintySource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PcmPackage.PCM_EXTERNAL_UNCERTAINTY_SOURCE: {
				PCMExternalUncertaintySource pcmExternalUncertaintySource = (PCMExternalUncertaintySource)theEObject;
				T result = casePCMExternalUncertaintySource(pcmExternalUncertaintySource);
				if (result == null) result = casePCMUncertaintySource(pcmExternalUncertaintySource);
				if (result == null) result = caseUncertaintySource(pcmExternalUncertaintySource);
				if (result == null) result = caseEntity(pcmExternalUncertaintySource);
				if (result == null) result = caseIdentifier(pcmExternalUncertaintySource);
				if (result == null) result = caseNamedElement(pcmExternalUncertaintySource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PcmPackage.PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE: {
				PCMExternalUncertaintySourceInResource pcmExternalUncertaintySourceInResource = (PCMExternalUncertaintySourceInResource)theEObject;
				T result = casePCMExternalUncertaintySourceInResource(pcmExternalUncertaintySourceInResource);
				if (result == null) result = casePCMExternalUncertaintySource(pcmExternalUncertaintySourceInResource);
				if (result == null) result = casePCMUncertaintySource(pcmExternalUncertaintySourceInResource);
				if (result == null) result = caseUncertaintySource(pcmExternalUncertaintySourceInResource);
				if (result == null) result = caseEntity(pcmExternalUncertaintySourceInResource);
				if (result == null) result = caseIdentifier(pcmExternalUncertaintySourceInResource);
				if (result == null) result = caseNamedElement(pcmExternalUncertaintySourceInResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PcmPackage.PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE: {
				PCMExternalUncertaintySourceInUsage pcmExternalUncertaintySourceInUsage = (PCMExternalUncertaintySourceInUsage)theEObject;
				T result = casePCMExternalUncertaintySourceInUsage(pcmExternalUncertaintySourceInUsage);
				if (result == null) result = casePCMExternalUncertaintySource(pcmExternalUncertaintySourceInUsage);
				if (result == null) result = casePCMUncertaintySource(pcmExternalUncertaintySourceInUsage);
				if (result == null) result = caseUncertaintySource(pcmExternalUncertaintySourceInUsage);
				if (result == null) result = caseEntity(pcmExternalUncertaintySourceInUsage);
				if (result == null) result = caseIdentifier(pcmExternalUncertaintySourceInUsage);
				if (result == null) result = caseNamedElement(pcmExternalUncertaintySourceInUsage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PcmPackage.PCM_EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE: {
				PCMExternalUncertaintyScenarioInResource pcmExternalUncertaintyScenarioInResource = (PCMExternalUncertaintyScenarioInResource)theEObject;
				T result = casePCMExternalUncertaintyScenarioInResource(pcmExternalUncertaintyScenarioInResource);
				if (result == null) result = caseUncertaintyScenario(pcmExternalUncertaintyScenarioInResource);
				if (result == null) result = caseEntity(pcmExternalUncertaintyScenarioInResource);
				if (result == null) result = caseIdentifier(pcmExternalUncertaintyScenarioInResource);
				if (result == null) result = caseNamedElement(pcmExternalUncertaintyScenarioInResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PcmPackage.PCM_EXTERNAL_UNCERTAINTY_SCENARIO_IN_USAGE: {
				PCMExternalUncertaintyScenarioInUsage pcmExternalUncertaintyScenarioInUsage = (PCMExternalUncertaintyScenarioInUsage)theEObject;
				T result = casePCMExternalUncertaintyScenarioInUsage(pcmExternalUncertaintyScenarioInUsage);
				if (result == null) result = caseUncertaintyScenario(pcmExternalUncertaintyScenarioInUsage);
				if (result == null) result = caseEntity(pcmExternalUncertaintyScenarioInUsage);
				if (result == null) result = caseIdentifier(pcmExternalUncertaintyScenarioInUsage);
				if (result == null) result = caseNamedElement(pcmExternalUncertaintyScenarioInUsage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PcmPackage.PCM_BEHAVIOR_UNCERTAINTY_SOURCE: {
				PCMBehaviorUncertaintySource pcmBehaviorUncertaintySource = (PCMBehaviorUncertaintySource)theEObject;
				T result = casePCMBehaviorUncertaintySource(pcmBehaviorUncertaintySource);
				if (result == null) result = casePCMUncertaintySource(pcmBehaviorUncertaintySource);
				if (result == null) result = caseUncertaintySource(pcmBehaviorUncertaintySource);
				if (result == null) result = caseEntity(pcmBehaviorUncertaintySource);
				if (result == null) result = caseIdentifier(pcmBehaviorUncertaintySource);
				if (result == null) result = caseNamedElement(pcmBehaviorUncertaintySource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PcmPackage.PCM_BEHAVIOR_UNCERTAINTY_SCENARIO: {
				PCMBehaviorUncertaintyScenario pcmBehaviorUncertaintyScenario = (PCMBehaviorUncertaintyScenario)theEObject;
				T result = casePCMBehaviorUncertaintyScenario(pcmBehaviorUncertaintyScenario);
				if (result == null) result = caseUncertaintyScenario(pcmBehaviorUncertaintyScenario);
				if (result == null) result = caseEntity(pcmBehaviorUncertaintyScenario);
				if (result == null) result = caseIdentifier(pcmBehaviorUncertaintyScenario);
				if (result == null) result = caseNamedElement(pcmBehaviorUncertaintyScenario);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PcmPackage.PCM_INTERFACE_UNCERTAINTY_SOURCE: {
				PCMInterfaceUncertaintySource pcmInterfaceUncertaintySource = (PCMInterfaceUncertaintySource)theEObject;
				T result = casePCMInterfaceUncertaintySource(pcmInterfaceUncertaintySource);
				if (result == null) result = casePCMUncertaintySource(pcmInterfaceUncertaintySource);
				if (result == null) result = caseUncertaintySource(pcmInterfaceUncertaintySource);
				if (result == null) result = caseEntity(pcmInterfaceUncertaintySource);
				if (result == null) result = caseIdentifier(pcmInterfaceUncertaintySource);
				if (result == null) result = caseNamedElement(pcmInterfaceUncertaintySource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PcmPackage.PCM_INTERFACE_UNCERTAINTY_SCENARIO: {
				PCMInterfaceUncertaintyScenario pcmInterfaceUncertaintyScenario = (PCMInterfaceUncertaintyScenario)theEObject;
				T result = casePCMInterfaceUncertaintyScenario(pcmInterfaceUncertaintyScenario);
				if (result == null) result = caseUncertaintyScenario(pcmInterfaceUncertaintyScenario);
				if (result == null) result = caseEntity(pcmInterfaceUncertaintyScenario);
				if (result == null) result = caseIdentifier(pcmInterfaceUncertaintyScenario);
				if (result == null) result = caseNamedElement(pcmInterfaceUncertaintyScenario);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PcmPackage.PCM_CONNECTOR_UNCERTAINTY_SOURCE: {
				PCMConnectorUncertaintySource pcmConnectorUncertaintySource = (PCMConnectorUncertaintySource)theEObject;
				T result = casePCMConnectorUncertaintySource(pcmConnectorUncertaintySource);
				if (result == null) result = casePCMUncertaintySource(pcmConnectorUncertaintySource);
				if (result == null) result = caseUncertaintySource(pcmConnectorUncertaintySource);
				if (result == null) result = caseEntity(pcmConnectorUncertaintySource);
				if (result == null) result = caseIdentifier(pcmConnectorUncertaintySource);
				if (result == null) result = caseNamedElement(pcmConnectorUncertaintySource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PcmPackage.PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL: {
				PCMConnectorUncertaintySourceInExternalCall pcmConnectorUncertaintySourceInExternalCall = (PCMConnectorUncertaintySourceInExternalCall)theEObject;
				T result = casePCMConnectorUncertaintySourceInExternalCall(pcmConnectorUncertaintySourceInExternalCall);
				if (result == null) result = casePCMConnectorUncertaintySource(pcmConnectorUncertaintySourceInExternalCall);
				if (result == null) result = casePCMUncertaintySource(pcmConnectorUncertaintySourceInExternalCall);
				if (result == null) result = caseUncertaintySource(pcmConnectorUncertaintySourceInExternalCall);
				if (result == null) result = caseEntity(pcmConnectorUncertaintySourceInExternalCall);
				if (result == null) result = caseIdentifier(pcmConnectorUncertaintySourceInExternalCall);
				if (result == null) result = caseNamedElement(pcmConnectorUncertaintySourceInExternalCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PcmPackage.PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL: {
				PCMConnectorUncertaintySourceInEntryLevelSystemCall pcmConnectorUncertaintySourceInEntryLevelSystemCall = (PCMConnectorUncertaintySourceInEntryLevelSystemCall)theEObject;
				T result = casePCMConnectorUncertaintySourceInEntryLevelSystemCall(pcmConnectorUncertaintySourceInEntryLevelSystemCall);
				if (result == null) result = casePCMConnectorUncertaintySource(pcmConnectorUncertaintySourceInEntryLevelSystemCall);
				if (result == null) result = casePCMUncertaintySource(pcmConnectorUncertaintySourceInEntryLevelSystemCall);
				if (result == null) result = caseUncertaintySource(pcmConnectorUncertaintySourceInEntryLevelSystemCall);
				if (result == null) result = caseEntity(pcmConnectorUncertaintySourceInEntryLevelSystemCall);
				if (result == null) result = caseIdentifier(pcmConnectorUncertaintySourceInEntryLevelSystemCall);
				if (result == null) result = caseNamedElement(pcmConnectorUncertaintySourceInEntryLevelSystemCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PcmPackage.PCM_CONNECTOR_UNCERTAINTY_SCENARIO_IN_EXTERNAL_CALL: {
				PCMConnectorUncertaintyScenarioInExternalCall pcmConnectorUncertaintyScenarioInExternalCall = (PCMConnectorUncertaintyScenarioInExternalCall)theEObject;
				T result = casePCMConnectorUncertaintyScenarioInExternalCall(pcmConnectorUncertaintyScenarioInExternalCall);
				if (result == null) result = caseUncertaintyScenario(pcmConnectorUncertaintyScenarioInExternalCall);
				if (result == null) result = caseEntity(pcmConnectorUncertaintyScenarioInExternalCall);
				if (result == null) result = caseIdentifier(pcmConnectorUncertaintyScenarioInExternalCall);
				if (result == null) result = caseNamedElement(pcmConnectorUncertaintyScenarioInExternalCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PcmPackage.PCM_CONNECTOR_UNCERTAINTY_SCENARIO_IN_ENTRY_LEVEL_SYSTEM_CALL: {
				PCMConnectorUncertaintyScenarioInEntryLevelSystemCall pcmConnectorUncertaintyScenarioInEntryLevelSystemCall = (PCMConnectorUncertaintyScenarioInEntryLevelSystemCall)theEObject;
				T result = casePCMConnectorUncertaintyScenarioInEntryLevelSystemCall(pcmConnectorUncertaintyScenarioInEntryLevelSystemCall);
				if (result == null) result = caseUncertaintyScenario(pcmConnectorUncertaintyScenarioInEntryLevelSystemCall);
				if (result == null) result = caseEntity(pcmConnectorUncertaintyScenarioInEntryLevelSystemCall);
				if (result == null) result = caseIdentifier(pcmConnectorUncertaintyScenarioInEntryLevelSystemCall);
				if (result == null) result = caseNamedElement(pcmConnectorUncertaintyScenarioInEntryLevelSystemCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PcmPackage.PCM_COMPONENT_UNCERTAINTY_SOURCE: {
				PCMComponentUncertaintySource pcmComponentUncertaintySource = (PCMComponentUncertaintySource)theEObject;
				T result = casePCMComponentUncertaintySource(pcmComponentUncertaintySource);
				if (result == null) result = casePCMUncertaintySource(pcmComponentUncertaintySource);
				if (result == null) result = caseUncertaintySource(pcmComponentUncertaintySource);
				if (result == null) result = caseEntity(pcmComponentUncertaintySource);
				if (result == null) result = caseIdentifier(pcmComponentUncertaintySource);
				if (result == null) result = caseNamedElement(pcmComponentUncertaintySource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PcmPackage.PCM_COMPONENT_UNCERTAINTY_SCENARIO: {
				PCMComponentUncertaintyScenario pcmComponentUncertaintyScenario = (PCMComponentUncertaintyScenario)theEObject;
				T result = casePCMComponentUncertaintyScenario(pcmComponentUncertaintyScenario);
				if (result == null) result = caseUncertaintyScenario(pcmComponentUncertaintyScenario);
				if (result == null) result = caseEntity(pcmComponentUncertaintyScenario);
				if (result == null) result = caseIdentifier(pcmComponentUncertaintyScenario);
				if (result == null) result = caseNamedElement(pcmComponentUncertaintyScenario);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PCM Uncertainty Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PCM Uncertainty Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePCMUncertaintySource(PCMUncertaintySource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PCM External Uncertainty Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PCM External Uncertainty Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePCMExternalUncertaintySource(PCMExternalUncertaintySource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PCM External Uncertainty Source In Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PCM External Uncertainty Source In Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePCMExternalUncertaintySourceInResource(PCMExternalUncertaintySourceInResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PCM External Uncertainty Source In Usage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PCM External Uncertainty Source In Usage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePCMExternalUncertaintySourceInUsage(PCMExternalUncertaintySourceInUsage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PCM External Uncertainty Scenario In Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PCM External Uncertainty Scenario In Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePCMExternalUncertaintyScenarioInResource(PCMExternalUncertaintyScenarioInResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PCM External Uncertainty Scenario In Usage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PCM External Uncertainty Scenario In Usage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePCMExternalUncertaintyScenarioInUsage(PCMExternalUncertaintyScenarioInUsage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PCM Behavior Uncertainty Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PCM Behavior Uncertainty Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePCMBehaviorUncertaintySource(PCMBehaviorUncertaintySource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PCM Behavior Uncertainty Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PCM Behavior Uncertainty Scenario</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePCMBehaviorUncertaintyScenario(PCMBehaviorUncertaintyScenario object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PCM Interface Uncertainty Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PCM Interface Uncertainty Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePCMInterfaceUncertaintySource(PCMInterfaceUncertaintySource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PCM Interface Uncertainty Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PCM Interface Uncertainty Scenario</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePCMInterfaceUncertaintyScenario(PCMInterfaceUncertaintyScenario object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PCM Connector Uncertainty Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PCM Connector Uncertainty Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePCMConnectorUncertaintySource(PCMConnectorUncertaintySource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PCM Connector Uncertainty Source In External Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PCM Connector Uncertainty Source In External Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePCMConnectorUncertaintySourceInExternalCall(PCMConnectorUncertaintySourceInExternalCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PCM Connector Uncertainty Source In Entry Level System Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PCM Connector Uncertainty Source In Entry Level System Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePCMConnectorUncertaintySourceInEntryLevelSystemCall(PCMConnectorUncertaintySourceInEntryLevelSystemCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PCM Connector Uncertainty Scenario In External Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PCM Connector Uncertainty Scenario In External Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePCMConnectorUncertaintyScenarioInExternalCall(PCMConnectorUncertaintyScenarioInExternalCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PCM Connector Uncertainty Scenario In Entry Level System Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PCM Connector Uncertainty Scenario In Entry Level System Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePCMConnectorUncertaintyScenarioInEntryLevelSystemCall(PCMConnectorUncertaintyScenarioInEntryLevelSystemCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PCM Component Uncertainty Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PCM Component Uncertainty Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePCMComponentUncertaintySource(PCMComponentUncertaintySource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PCM Component Uncertainty Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PCM Component Uncertainty Scenario</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePCMComponentUncertaintyScenario(PCMComponentUncertaintyScenario object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifier(Identifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntity(Entity object) {
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
