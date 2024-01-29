/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.pcm;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;

import org.palladiosimulator.pcm.seff.SetVariableAction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PCM Behavior Uncertainty Scenario</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMBehaviorUncertaintyScenario#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage#getPCMBehaviorUncertaintyScenario()
 * @model
 * @generated
 */
public interface PCMBehaviorUncertaintyScenario extends UncertaintyScenario {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(SetVariableAction)
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage#getPCMBehaviorUncertaintyScenario_Target()
	 * @model required="true"
	 * @generated
	 */
	SetVariableAction getTarget();

	/**
	 * Sets the value of the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMBehaviorUncertaintyScenario#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(SetVariableAction value);

} // PCMBehaviorUncertaintyScenario
