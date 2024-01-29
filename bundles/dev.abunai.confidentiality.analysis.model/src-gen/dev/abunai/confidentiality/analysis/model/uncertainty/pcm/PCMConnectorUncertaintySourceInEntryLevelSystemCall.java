/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.pcm;

import java.util.List;

import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PCM Connector Uncertainty Source In Entry Level System Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInEntryLevelSystemCall#getTarget <em>Target</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInEntryLevelSystemCall#getScenarios <em>Scenarios</em>}</li>
 * </ul>
 *
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage#getPCMConnectorUncertaintySourceInEntryLevelSystemCall()
 * @model
 * @generated
 */
public interface PCMConnectorUncertaintySourceInEntryLevelSystemCall extends PCMConnectorUncertaintySource {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(EntryLevelSystemCall)
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage#getPCMConnectorUncertaintySourceInEntryLevelSystemCall_Target()
	 * @model required="true"
	 * @generated
	 */
	EntryLevelSystemCall getTarget();

	/**
	 * Sets the value of the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInEntryLevelSystemCall#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EntryLevelSystemCall value);

	/**
	 * Returns the value of the '<em><b>Scenarios</b></em>' containment reference list.
	 * The list contents are of type {@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintyScenarioInEntryLevelSystemCall}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scenarios</em>' containment reference list.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage#getPCMConnectorUncertaintySourceInEntryLevelSystemCall_Scenarios()
	 * @model containment="true"
	 * @generated
	 */
	List<PCMConnectorUncertaintyScenarioInEntryLevelSystemCall> getScenarios();

} // PCMConnectorUncertaintySourceInEntryLevelSystemCall
