/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.dfd;

import java.util.List;

import org.dataflowanalysis.dfd.datadictionary.Pin;

import org.dataflowanalysis.dfd.dataflowdiagram.Flow;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DFD Interface Uncertainty Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintySource#getTargetInPin <em>Target In Pin</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintySource#getTargetFlow <em>Target Flow</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintySource#getScenarios <em>Scenarios</em>}</li>
 * </ul>
 *
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage#getDFDInterfaceUncertaintySource()
 * @model
 * @generated
 */
public interface DFDInterfaceUncertaintySource extends DFDUncertaintySource {
	/**
	 * Returns the value of the '<em><b>Target In Pin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target In Pin</em>' reference.
	 * @see #setTargetInPin(Pin)
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage#getDFDInterfaceUncertaintySource_TargetInPin()
	 * @model required="true"
	 * @generated
	 */
	Pin getTargetInPin();

	/**
	 * Sets the value of the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintySource#getTargetInPin <em>Target In Pin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target In Pin</em>' reference.
	 * @see #getTargetInPin()
	 * @generated
	 */
	void setTargetInPin(Pin value);

	/**
	 * Returns the value of the '<em><b>Target Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Flow</em>' reference.
	 * @see #setTargetFlow(Flow)
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage#getDFDInterfaceUncertaintySource_TargetFlow()
	 * @model required="true"
	 * @generated
	 */
	Flow getTargetFlow();

	/**
	 * Sets the value of the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintySource#getTargetFlow <em>Target Flow</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Flow</em>' reference.
	 * @see #getTargetFlow()
	 * @generated
	 */
	void setTargetFlow(Flow value);

	/**
	 * Returns the value of the '<em><b>Scenarios</b></em>' containment reference list.
	 * The list contents are of type {@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintyScenario}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scenarios</em>' containment reference list.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage#getDFDInterfaceUncertaintySource_Scenarios()
	 * @model containment="true"
	 * @generated
	 */
	List<DFDInterfaceUncertaintyScenario> getScenarios();

} // DFDInterfaceUncertaintySource
