/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty;

import java.util.List;

import tools.mdsd.modelingfoundations.identifier.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySourceCollection#getSources <em>Sources</em>}</li>
 * </ul>
 *
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage#getUncertaintySourceCollection()
 * @model
 * @generated
 */
public interface UncertaintySourceCollection extends Entity {
	/**
	 * Returns the value of the '<em><b>Sources</b></em>' containment reference list.
	 * The list contents are of type {@link dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sources</em>' containment reference list.
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage#getUncertaintySourceCollection_Sources()
	 * @model containment="true"
	 * @generated
	 */
	List<UncertaintySource> getSources();

} // UncertaintySourceCollection
