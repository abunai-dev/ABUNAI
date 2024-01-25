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
	 * Returns a new object of class '<em>Interface Uncertainty Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interface Uncertainty Source</em>'.
	 * @generated
	 */
	InterfaceUncertaintySource createInterfaceUncertaintySource();

	/**
	 * Returns a new object of class '<em>Interface Uncertainty Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interface Uncertainty Scenario</em>'.
	 * @generated
	 */
	InterfaceUncertaintyScenario createInterfaceUncertaintyScenario();

	/**
	 * Returns a new object of class '<em>Connector Uncertainty Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connector Uncertainty Source</em>'.
	 * @generated
	 */
	ConnectorUncertaintySource createConnectorUncertaintySource();

	/**
	 * Returns a new object of class '<em>Connector Uncertainty Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connector Uncertainty Scenario</em>'.
	 * @generated
	 */
	ConnectorUncertaintyScenario createConnectorUncertaintyScenario();

	/**
	 * Returns a new object of class '<em>Component Uncertainty Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Uncertainty Source</em>'.
	 * @generated
	 */
	ComponentUncertaintySource createComponentUncertaintySource();

	/**
	 * Returns a new object of class '<em>Component Uncertainty Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Uncertainty Scenario</em>'.
	 * @generated
	 */
	ComponentUncertaintyScenario createComponentUncertaintyScenario();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DfdPackage getDfdPackage();

} //DfdFactory
