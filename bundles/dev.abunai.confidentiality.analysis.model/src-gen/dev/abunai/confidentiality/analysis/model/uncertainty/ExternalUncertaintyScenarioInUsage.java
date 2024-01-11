/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty;

import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.UsageAssignee;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Uncertainty Scenario In Usage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintyScenarioInUsage#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage#getExternalUncertaintyScenarioInUsage()
 * @model
 * @generated
 */
public interface ExternalUncertaintyScenarioInUsage extends UncertaintyScenario {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(UsageAssignee)
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage#getExternalUncertaintyScenarioInUsage_Target()
	 * @model required="true"
	 * @generated
	 */
	UsageAssignee getTarget();

	/**
	 * Sets the value of the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintyScenarioInUsage#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(UsageAssignee value);

} // ExternalUncertaintyScenarioInUsage
