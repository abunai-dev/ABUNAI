/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.dfd;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;

import java.util.List;

import org.dataflowanalysis.dfd.datadictionary.AbstractAssignment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DFD Behavior Uncertainty Scenario</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDBehaviorUncertaintyScenario#getTargetAssignments <em>Target Assignments</em>}</li>
 * </ul>
 *
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage#getDFDBehaviorUncertaintyScenario()
 * @model
 * @generated
 */
public interface DFDBehaviorUncertaintyScenario extends UncertaintyScenario {
	/**
	 * Returns the value of the '<em><b>Target Assignments</b></em>' reference list.
	 * The list contents are of type {@link org.dataflowanalysis.dfd.datadictionary.AbstractAssignment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Assignments</em>' reference list.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage#getDFDBehaviorUncertaintyScenario_TargetAssignments()
	 * @model
	 * @generated
	 */
	List<AbstractAssignment> getTargetAssignments();

} // DFDBehaviorUncertaintyScenario
