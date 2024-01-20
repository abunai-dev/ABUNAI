/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.pcm;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage
 * @generated
 */
public interface PcmFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PcmFactory eINSTANCE = dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PcmFactoryImpl.init();

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
	 * Returns a new object of class '<em>External Uncertainty Scenario In Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>External Uncertainty Scenario In Resource</em>'.
	 * @generated
	 */
	ExternalUncertaintyScenarioInResource createExternalUncertaintyScenarioInResource();

	/**
	 * Returns a new object of class '<em>External Uncertainty Scenario In Usage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>External Uncertainty Scenario In Usage</em>'.
	 * @generated
	 */
	ExternalUncertaintyScenarioInUsage createExternalUncertaintyScenarioInUsage();

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
	 * Returns a new object of class '<em>Connector Uncertainty Source In External Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connector Uncertainty Source In External Call</em>'.
	 * @generated
	 */
	ConnectorUncertaintySourceInExternalCall createConnectorUncertaintySourceInExternalCall();

	/**
	 * Returns a new object of class '<em>Connector Uncertainty Source In Entry Level System Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connector Uncertainty Source In Entry Level System Call</em>'.
	 * @generated
	 */
	ConnectorUncertaintySourceInEntryLevelSystemCall createConnectorUncertaintySourceInEntryLevelSystemCall();

	/**
	 * Returns a new object of class '<em>Connector Uncertainty Scenario In External Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connector Uncertainty Scenario In External Call</em>'.
	 * @generated
	 */
	ConnectorUncertaintyScenarioInExternalCall createConnectorUncertaintyScenarioInExternalCall();

	/**
	 * Returns a new object of class '<em>Connector Uncertainty Scenario In Entry Level System Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connector Uncertainty Scenario In Entry Level System Call</em>'.
	 * @generated
	 */
	ConnectorUncertaintyScenarioInEntryLevelSystemCall createConnectorUncertaintyScenarioInEntryLevelSystemCall();

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
	PcmPackage getPcmPackage();

} //PcmFactory
