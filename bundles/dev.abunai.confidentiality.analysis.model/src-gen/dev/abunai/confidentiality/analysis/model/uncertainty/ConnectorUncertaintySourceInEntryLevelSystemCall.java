/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty;

import java.util.List;

import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connector Uncertainty Source In Entry Level System Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.ConnectorUncertaintySourceInEntryLevelSystemCall#getTarget <em>Target</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.ConnectorUncertaintySourceInEntryLevelSystemCall#getScenarios <em>Scenarios</em>}</li>
 * </ul>
 *
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage#getConnectorUncertaintySourceInEntryLevelSystemCall()
 * @model
 * @generated
 */
public interface ConnectorUncertaintySourceInEntryLevelSystemCall extends ConnectorUncertaintySource {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(EntryLevelSystemCall)
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage#getConnectorUncertaintySourceInEntryLevelSystemCall_Target()
	 * @model required="true"
	 * @generated
	 */
	EntryLevelSystemCall getTarget();

	/**
	 * Sets the value of the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.ConnectorUncertaintySourceInEntryLevelSystemCall#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EntryLevelSystemCall value);

	/**
	 * Returns the value of the '<em><b>Scenarios</b></em>' containment reference list.
	 * The list contents are of type {@link dev.abunai.confidentiality.analysis.model.uncertainty.ConnectorUncertaintyScenarioInEntryLevelSystemCall}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scenarios</em>' containment reference list.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage#getConnectorUncertaintySourceInEntryLevelSystemCall_Scenarios()
	 * @model containment="true"
	 * @generated
	 */
	List<ConnectorUncertaintyScenarioInEntryLevelSystemCall> getScenarios();

} // ConnectorUncertaintySourceInEntryLevelSystemCall