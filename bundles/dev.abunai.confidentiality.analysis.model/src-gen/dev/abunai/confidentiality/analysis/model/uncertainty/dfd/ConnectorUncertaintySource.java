/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.dfd;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;

import java.util.List;

import org.dataflowanalysis.dfd.datadictionary.AbstractAssignment;

import org.dataflowanalysis.dfd.dataflowdiagram.Flow;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connector Uncertainty Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ConnectorUncertaintySource#getTargetAssignement <em>Target Assignement</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ConnectorUncertaintySource#getTargetFlow <em>Target Flow</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ConnectorUncertaintySource#getScenarios <em>Scenarios</em>}</li>
 * </ul>
 *
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage#getConnectorUncertaintySource()
 * @model
 * @generated
 */
public interface ConnectorUncertaintySource extends UncertaintySource {
	/**
	 * Returns the value of the '<em><b>Target Assignement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Assignement</em>' reference.
	 * @see #setTargetAssignement(AbstractAssignment)
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage#getConnectorUncertaintySource_TargetAssignement()
	 * @model required="true"
	 * @generated
	 */
	AbstractAssignment getTargetAssignement();

	/**
	 * Sets the value of the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ConnectorUncertaintySource#getTargetAssignement <em>Target Assignement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Assignement</em>' reference.
	 * @see #getTargetAssignement()
	 * @generated
	 */
	void setTargetAssignement(AbstractAssignment value);

	/**
	 * Returns the value of the '<em><b>Target Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Flow</em>' reference.
	 * @see #setTargetFlow(Flow)
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage#getConnectorUncertaintySource_TargetFlow()
	 * @model required="true"
	 * @generated
	 */
	Flow getTargetFlow();

	/**
	 * Sets the value of the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ConnectorUncertaintySource#getTargetFlow <em>Target Flow</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Flow</em>' reference.
	 * @see #getTargetFlow()
	 * @generated
	 */
	void setTargetFlow(Flow value);

	/**
	 * Returns the value of the '<em><b>Scenarios</b></em>' containment reference list.
	 * The list contents are of type {@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ConnectorUncertaintyScenario}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scenarios</em>' containment reference list.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage#getConnectorUncertaintySource_Scenarios()
	 * @model containment="true"
	 * @generated
	 */
	List<ConnectorUncertaintyScenario> getScenarios();

} // ConnectorUncertaintySource
