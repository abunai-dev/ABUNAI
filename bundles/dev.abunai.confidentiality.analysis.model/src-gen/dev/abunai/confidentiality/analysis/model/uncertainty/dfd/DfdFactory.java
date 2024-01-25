/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.dfd;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage
 * @generated
 */
public interface DfdFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DfdFactory eINSTANCE = dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>External Uncertainty Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>External Uncertainty Source</em>'.
	 * @generated
	 */
	ExternalUncertaintySource createExternalUncertaintySource();

	/**
	 * Returns a new object of class '<em>External Uncertainty Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>External Uncertainty Scenario</em>'.
	 * @generated
	 */
	ExternalUncertaintyScenario createExternalUncertaintyScenario();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DfdPackage getDfdPackage();

} //DfdFactory
