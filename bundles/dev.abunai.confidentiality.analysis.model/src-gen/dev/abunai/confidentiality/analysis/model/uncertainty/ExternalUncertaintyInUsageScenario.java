/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty;

import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.UsageAsignee;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Uncertainty In Usage Scenario</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintyInUsageScenario#getTargetd <em>Targetd</em>}</li>
 * </ul>
 *
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage#getExternalUncertaintyInUsageScenario()
 * @model
 * @generated
 */
public interface ExternalUncertaintyInUsageScenario extends UncertaintyScenario {
	/**
	 * Returns the value of the '<em><b>Targetd</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Targetd</em>' reference.
	 * @see #setTargetd(UsageAsignee)
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage#getExternalUncertaintyInUsageScenario_Targetd()
	 * @model required="true"
	 * @generated
	 */
	UsageAsignee getTargetd();

	/**
	 * Sets the value of the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintyInUsageScenario#getTargetd <em>Targetd</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Targetd</em>' reference.
	 * @see #getTargetd()
	 * @generated
	 */
	void setTargetd(UsageAsignee value);

} // ExternalUncertaintyInUsageScenario
