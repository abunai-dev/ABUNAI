/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty;

import java.util.List;

import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.RessourceAssignee;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Uncertainty Source In Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintySourceInResource#getTarget <em>Target</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintySourceInResource#getScenarios <em>Scenarios</em>}</li>
 * </ul>
 *
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage#getExternalUncertaintySourceInResource()
 * @model
 * @generated
 */
public interface ExternalUncertaintySourceInResource extends ExternalUncertaintySource {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(RessourceAssignee)
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage#getExternalUncertaintySourceInResource_Target()
	 * @model required="true"
	 * @generated
	 */
	RessourceAssignee getTarget();

	/**
	 * Sets the value of the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintySourceInResource#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(RessourceAssignee value);

	/**
	 * Returns the value of the '<em><b>Scenarios</b></em>' containment reference list.
	 * The list contents are of type {@link dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintyScenarioInResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scenarios</em>' containment reference list.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage#getExternalUncertaintySourceInResource_Scenarios()
	 * @model containment="true"
	 * @generated
	 */
	List<ExternalUncertaintyScenarioInResource> getScenarios();

} // ExternalUncertaintySourceInResource
