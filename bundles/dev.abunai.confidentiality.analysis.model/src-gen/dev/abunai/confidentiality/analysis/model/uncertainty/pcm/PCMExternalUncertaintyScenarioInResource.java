/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.pcm;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;

import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.ResourceAssignee;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PCM External Uncertainty Scenario In Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintyScenarioInResource#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage#getPCMExternalUncertaintyScenarioInResource()
 * @model
 * @generated
 */
public interface PCMExternalUncertaintyScenarioInResource extends UncertaintyScenario {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(ResourceAssignee)
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage#getPCMExternalUncertaintyScenarioInResource_Target()
	 * @model required="true"
	 * @generated
	 */
	ResourceAssignee getTarget();

	/**
	 * Sets the value of the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintyScenarioInResource#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(ResourceAssignee value);

} // PCMExternalUncertaintyScenarioInResource
