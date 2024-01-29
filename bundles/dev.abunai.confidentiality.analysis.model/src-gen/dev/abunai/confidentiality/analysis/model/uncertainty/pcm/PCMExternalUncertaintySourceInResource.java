/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.pcm;

import java.util.List;

import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.ResourceAssignee;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PCM External Uncertainty Source In Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySourceInResource#getTarget <em>Target</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySourceInResource#getScenarios <em>Scenarios</em>}</li>
 * </ul>
 *
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage#getPCMExternalUncertaintySourceInResource()
 * @model
 * @generated
 */
public interface PCMExternalUncertaintySourceInResource extends PCMExternalUncertaintySource {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(ResourceAssignee)
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage#getPCMExternalUncertaintySourceInResource_Target()
	 * @model required="true"
	 * @generated
	 */
	ResourceAssignee getTarget();

	/**
	 * Sets the value of the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySourceInResource#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(ResourceAssignee value);

	/**
	 * Returns the value of the '<em><b>Scenarios</b></em>' containment reference list.
	 * The list contents are of type {@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintyScenarioInResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scenarios</em>' containment reference list.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage#getPCMExternalUncertaintySourceInResource_Scenarios()
	 * @model containment="true"
	 * @generated
	 */
	List<PCMExternalUncertaintyScenarioInResource> getScenarios();

} // PCMExternalUncertaintySourceInResource
