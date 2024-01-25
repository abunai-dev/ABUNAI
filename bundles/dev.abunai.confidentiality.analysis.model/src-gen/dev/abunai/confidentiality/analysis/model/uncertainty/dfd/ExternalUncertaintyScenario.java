/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.dfd;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;

import java.util.List;

import org.dataflowanalysis.dfd.datadictionary.Label;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Uncertainty Scenario</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ExternalUncertaintyScenario#getTargetProperties <em>Target Properties</em>}</li>
 * </ul>
 *
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage#getExternalUncertaintyScenario()
 * @model
 * @generated
 */
public interface ExternalUncertaintyScenario extends UncertaintyScenario {
	/**
	 * Returns the value of the '<em><b>Target Properties</b></em>' reference list.
	 * The list contents are of type {@link org.dataflowanalysis.dfd.datadictionary.Label}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Properties</em>' reference list.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage#getExternalUncertaintyScenario_TargetProperties()
	 * @model
	 * @generated
	 */
	List<Label> getTargetProperties();

} // ExternalUncertaintyScenario
