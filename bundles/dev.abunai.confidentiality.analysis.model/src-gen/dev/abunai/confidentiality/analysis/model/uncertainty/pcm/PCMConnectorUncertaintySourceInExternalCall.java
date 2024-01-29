/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.pcm;

import java.util.List;

import org.palladiosimulator.pcm.seff.ExternalCallAction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PCM Connector Uncertainty Source In External Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInExternalCall#getTarget <em>Target</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInExternalCall#getScenarios <em>Scenarios</em>}</li>
 * </ul>
 *
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage#getPCMConnectorUncertaintySourceInExternalCall()
 * @model
 * @generated
 */
public interface PCMConnectorUncertaintySourceInExternalCall extends PCMConnectorUncertaintySource {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(ExternalCallAction)
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage#getPCMConnectorUncertaintySourceInExternalCall_Target()
	 * @model required="true"
	 * @generated
	 */
	ExternalCallAction getTarget();

	/**
	 * Sets the value of the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInExternalCall#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(ExternalCallAction value);

	/**
	 * Returns the value of the '<em><b>Scenarios</b></em>' containment reference list.
	 * The list contents are of type {@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintyScenarioInExternalCall}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scenarios</em>' containment reference list.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage#getPCMConnectorUncertaintySourceInExternalCall_Scenarios()
	 * @model containment="true"
	 * @generated
	 */
	List<PCMConnectorUncertaintyScenarioInExternalCall> getScenarios();

} // PCMConnectorUncertaintySourceInExternalCall
