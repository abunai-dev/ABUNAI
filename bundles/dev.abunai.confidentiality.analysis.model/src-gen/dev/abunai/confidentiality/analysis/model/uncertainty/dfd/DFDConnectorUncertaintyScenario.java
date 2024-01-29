/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.dfd;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;

import org.dataflowanalysis.dfd.datadictionary.AbstractAssignment;

import org.dataflowanalysis.dfd.dataflowdiagram.Flow;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DFD Connector Uncertainty Scenario</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintyScenario#getTargetAssignment <em>Target Assignment</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintyScenario#getTargetFlow <em>Target Flow</em>}</li>
 * </ul>
 *
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage#getDFDConnectorUncertaintyScenario()
 * @model
 * @generated
 */
public interface DFDConnectorUncertaintyScenario extends UncertaintyScenario {
	/**
	 * Returns the value of the '<em><b>Target Assignment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Assignment</em>' reference.
	 * @see #setTargetAssignment(AbstractAssignment)
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage#getDFDConnectorUncertaintyScenario_TargetAssignment()
	 * @model required="true"
	 * @generated
	 */
	AbstractAssignment getTargetAssignment();

	/**
	 * Sets the value of the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintyScenario#getTargetAssignment <em>Target Assignment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Assignment</em>' reference.
	 * @see #getTargetAssignment()
	 * @generated
	 */
	void setTargetAssignment(AbstractAssignment value);

	/**
	 * Returns the value of the '<em><b>Target Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Flow</em>' reference.
	 * @see #setTargetFlow(Flow)
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage#getDFDConnectorUncertaintyScenario_TargetFlow()
	 * @model required="true"
	 * @generated
	 */
	Flow getTargetFlow();

	/**
	 * Sets the value of the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintyScenario#getTargetFlow <em>Target Flow</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Flow</em>' reference.
	 * @see #getTargetFlow()
	 * @generated
	 */
	void setTargetFlow(Flow value);

} // DFDConnectorUncertaintyScenario
