/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty;

import org.palladiosimulator.pcm.seff.ExternalCallAction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connector Uncertainty Scenario In External Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.ConnectorUncertaintyScenarioInExternalCall#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage#getConnectorUncertaintyScenarioInExternalCall()
 * @model
 * @generated
 */
public interface ConnectorUncertaintyScenarioInExternalCall extends UncertaintyScenario {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(ExternalCallAction)
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage#getConnectorUncertaintyScenarioInExternalCall_Target()
	 * @model required="true"
	 * @generated
	 */
	ExternalCallAction getTarget();

	/**
	 * Sets the value of the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ConnectorUncertaintyScenarioInExternalCall#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(ExternalCallAction value);

} // ConnectorUncertaintyScenarioInExternalCall
