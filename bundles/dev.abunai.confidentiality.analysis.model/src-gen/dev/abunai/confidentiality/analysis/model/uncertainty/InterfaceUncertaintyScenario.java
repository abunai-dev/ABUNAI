/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty;

import org.palladiosimulator.pcm.repository.OperationSignature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface Uncertainty Scenario</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.InterfaceUncertaintyScenario#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage#getInterfaceUncertaintyScenario()
 * @model
 * @generated
 */
public interface InterfaceUncertaintyScenario extends UncertaintyScenario {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(OperationSignature)
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage#getInterfaceUncertaintyScenario_Target()
	 * @model required="true"
	 * @generated
	 */
	OperationSignature getTarget();

	/**
	 * Sets the value of the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.InterfaceUncertaintyScenario#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(OperationSignature value);

} // InterfaceUncertaintyScenario