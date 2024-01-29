/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.dfd;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;

import org.dataflowanalysis.dfd.dataflowdiagram.Node;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DFD Component Uncertainty Scenario</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDComponentUncertaintyScenario#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage#getDFDComponentUncertaintyScenario()
 * @model
 * @generated
 */
public interface DFDComponentUncertaintyScenario extends UncertaintyScenario {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Node)
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage#getDFDComponentUncertaintyScenario_Target()
	 * @model required="true"
	 * @generated
	 */
	Node getTarget();

	/**
	 * Sets the value of the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDComponentUncertaintyScenario#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Node value);

} // DFDComponentUncertaintyScenario
