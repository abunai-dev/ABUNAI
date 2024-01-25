/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.dfd;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;

import java.util.List;

import org.dataflowanalysis.dfd.dataflowdiagram.Node;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Uncertainty Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ComponentUncertaintySource#getTarget <em>Target</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ComponentUncertaintySource#getScenarios <em>Scenarios</em>}</li>
 * </ul>
 *
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage#getComponentUncertaintySource()
 * @model
 * @generated
 */
public interface ComponentUncertaintySource extends UncertaintySource {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Node)
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage#getComponentUncertaintySource_Target()
	 * @model required="true"
	 * @generated
	 */
	Node getTarget();

	/**
	 * Sets the value of the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ComponentUncertaintySource#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Node value);

	/**
	 * Returns the value of the '<em><b>Scenarios</b></em>' containment reference list.
	 * The list contents are of type {@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ComponentUncertaintyScenario}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scenarios</em>' containment reference list.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage#getComponentUncertaintySource_Scenarios()
	 * @model containment="true"
	 * @generated
	 */
	List<ComponentUncertaintyScenario> getScenarios();

} // ComponentUncertaintySource
