/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.pcm;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PCM Component Uncertainty Scenario</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMComponentUncertaintyScenario#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage#getPCMComponentUncertaintyScenario()
 * @model
 * @generated
 */
public interface PCMComponentUncertaintyScenario extends UncertaintyScenario {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(AssemblyContext)
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage#getPCMComponentUncertaintyScenario_Target()
	 * @model required="true"
	 * @generated
	 */
	AssemblyContext getTarget();

	/**
	 * Sets the value of the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMComponentUncertaintyScenario#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(AssemblyContext value);

} // PCMComponentUncertaintyScenario
