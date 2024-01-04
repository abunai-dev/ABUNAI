/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage
 * @generated
 */
public interface UncertaintyFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UncertaintyFactory eINSTANCE = dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Source Collection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Source Collection</em>'.
	 * @generated
	 */
	UncertaintySourceCollection createUncertaintySourceCollection();

	/**
	 * Returns a new object of class '<em>Behavior Uncertainty Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Behavior Uncertainty Source</em>'.
	 * @generated
	 */
	BehaviorUncertaintySource createBehaviorUncertaintySource();

	/**
	 * Returns a new object of class '<em>Behavior Uncertainty Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Behavior Uncertainty Scenario</em>'.
	 * @generated
	 */
	BehaviorUncertaintyScenario createBehaviorUncertaintyScenario();

	/**
	 * Returns a new object of class '<em>External Uncertainty Source In Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>External Uncertainty Source In Resource</em>'.
	 * @generated
	 */
	ExternalUncertaintySourceInResource createExternalUncertaintySourceInResource();

	/**
	 * Returns a new object of class '<em>External Uncertainty Source In Usage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>External Uncertainty Source In Usage</em>'.
	 * @generated
	 */
	ExternalUncertaintySourceInUsage createExternalUncertaintySourceInUsage();

	/**
	 * Returns a new object of class '<em>External Uncertainty In Resource Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>External Uncertainty In Resource Scenario</em>'.
	 * @generated
	 */
	ExternalUncertaintyInResourceScenario createExternalUncertaintyInResourceScenario();

	/**
	 * Returns a new object of class '<em>External Uncertainty In Usage Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>External Uncertainty In Usage Scenario</em>'.
	 * @generated
	 */
	ExternalUncertaintyInUsageScenario createExternalUncertaintyInUsageScenario();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	UncertaintyPackage getUncertaintyPackage();

} //UncertaintyFactory
