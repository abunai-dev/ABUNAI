/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.dfd;

import java.util.List;

import org.dataflowanalysis.dfd.datadictionary.Label;

import org.dataflowanalysis.dfd.dataflowdiagram.Node;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DFD External Uncertainty Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintySource#getTarget <em>Target</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintySource#getTargetProperties <em>Target Properties</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintySource#getScenarios <em>Scenarios</em>}</li>
 * </ul>
 *
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage#getDFDExternalUncertaintySource()
 * @model
 * @generated
 */
public interface DFDExternalUncertaintySource extends DFDUncertaintySource {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Node)
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage#getDFDExternalUncertaintySource_Target()
	 * @model required="true"
	 * @generated
	 */
	Node getTarget();

	/**
	 * Sets the value of the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintySource#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Node value);

	/**
	 * Returns the value of the '<em><b>Target Properties</b></em>' reference list.
	 * The list contents are of type {@link org.dataflowanalysis.dfd.datadictionary.Label}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Properties</em>' reference list.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage#getDFDExternalUncertaintySource_TargetProperties()
	 * @model required="true"
	 * @generated
	 */
	List<Label> getTargetProperties();

	/**
	 * Returns the value of the '<em><b>Scenarios</b></em>' containment reference list.
	 * The list contents are of type {@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintyScenario}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scenarios</em>' containment reference list.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage#getDFDExternalUncertaintySource_Scenarios()
	 * @model containment="true"
	 * @generated
	 */
	List<DFDExternalUncertaintyScenario> getScenarios();

} // DFDExternalUncertaintySource
