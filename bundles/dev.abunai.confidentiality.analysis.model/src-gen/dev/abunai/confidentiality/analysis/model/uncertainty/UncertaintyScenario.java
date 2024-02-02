/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty;

import tools.mdsd.modelingfoundations.identifier.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scenario</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario#getProbability <em>Probability</em>}</li>
 * </ul>
 *
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage#getUncertaintyScenario()
 * @model abstract="true"
 * @generated
 */
public interface UncertaintyScenario extends Entity {
	/**
	 * Returns the value of the '<em><b>Probability</b></em>' attribute.
	 * The default value is <code>"-1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Probability</em>' attribute.
	 * @see #setProbability(double)
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage#getUncertaintyScenario_Probability()
	 * @model default="-1.0" required="true"
	 * @generated
	 */
	double getProbability();

	/**
	 * Sets the value of the '{@link dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario#getProbability <em>Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Probability</em>' attribute.
	 * @see #getProbability()
	 * @generated
	 */
	void setProbability(double value);

} // UncertaintyScenario
