/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.pcm;

import java.util.List;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PCM Component Uncertainty Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMComponentUncertaintySource#getTarget <em>Target</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMComponentUncertaintySource#getScenarios <em>Scenarios</em>}</li>
 * </ul>
 *
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage#getPCMComponentUncertaintySource()
 * @model
 * @generated
 */
public interface PCMComponentUncertaintySource extends PCMUncertaintySource {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(AssemblyContext)
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage#getPCMComponentUncertaintySource_Target()
	 * @model required="true"
	 * @generated
	 */
	AssemblyContext getTarget();

	/**
	 * Sets the value of the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMComponentUncertaintySource#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(AssemblyContext value);

	/**
	 * Returns the value of the '<em><b>Scenarios</b></em>' containment reference list.
	 * The list contents are of type {@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMComponentUncertaintyScenario}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scenarios</em>' containment reference list.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage#getPCMComponentUncertaintySource_Scenarios()
	 * @model containment="true"
	 * @generated
	 */
	List<PCMComponentUncertaintyScenario> getScenarios();

} // PCMComponentUncertaintySource
