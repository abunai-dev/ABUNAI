/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.pcm;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;

import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PCM Connector Uncertainty Scenario In Entry Level System Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintyScenarioInEntryLevelSystemCall#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage#getPCMConnectorUncertaintyScenarioInEntryLevelSystemCall()
 * @model
 * @generated
 */
public interface PCMConnectorUncertaintyScenarioInEntryLevelSystemCall extends UncertaintyScenario {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(EntryLevelSystemCall)
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage#getPCMConnectorUncertaintyScenarioInEntryLevelSystemCall_Target()
	 * @model required="true"
	 * @generated
	 */
	EntryLevelSystemCall getTarget();

	/**
	 * Sets the value of the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintyScenarioInEntryLevelSystemCall#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EntryLevelSystemCall value);

} // PCMConnectorUncertaintyScenarioInEntryLevelSystemCall
