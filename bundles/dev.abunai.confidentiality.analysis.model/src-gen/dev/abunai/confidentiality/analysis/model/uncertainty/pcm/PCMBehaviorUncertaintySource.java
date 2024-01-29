/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.pcm;

import java.util.List;

import org.palladiosimulator.pcm.seff.SetVariableAction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PCM Behavior Uncertainty Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMBehaviorUncertaintySource#getTarget <em>Target</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMBehaviorUncertaintySource#getScenarios <em>Scenarios</em>}</li>
 * </ul>
 *
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage#getPCMBehaviorUncertaintySource()
 * @model
 * @generated
 */
public interface PCMBehaviorUncertaintySource extends PCMUncertaintySource {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(SetVariableAction)
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage#getPCMBehaviorUncertaintySource_Target()
	 * @model required="true"
	 * @generated
	 */
	SetVariableAction getTarget();

	/**
	 * Sets the value of the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMBehaviorUncertaintySource#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(SetVariableAction value);

	/**
	 * Returns the value of the '<em><b>Scenarios</b></em>' containment reference list.
	 * The list contents are of type {@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMBehaviorUncertaintyScenario}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scenarios</em>' containment reference list.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage#getPCMBehaviorUncertaintySource_Scenarios()
	 * @model containment="true"
	 * @generated
	 */
	List<PCMBehaviorUncertaintyScenario> getScenarios();

} // PCMBehaviorUncertaintySource
