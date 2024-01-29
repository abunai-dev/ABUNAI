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
	 * Returns a new object of class '<em>PCM External Uncertainty Source In Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCM External Uncertainty Source In Resource</em>'.
	 * @generated
	 */
	PCMExternalUncertaintySourceInResource createPCMExternalUncertaintySourceInResource();

	/**
	 * Returns a new object of class '<em>PCM External Uncertainty Source In Usage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCM External Uncertainty Source In Usage</em>'.
	 * @generated
	 */
	PCMExternalUncertaintySourceInUsage createPCMExternalUncertaintySourceInUsage();

	/**
	 * Returns a new object of class '<em>PCM External Uncertainty Scenario In Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCM External Uncertainty Scenario In Resource</em>'.
	 * @generated
	 */
	PCMExternalUncertaintyScenarioInResource createPCMExternalUncertaintyScenarioInResource();

	/**
	 * Returns a new object of class '<em>PCM External Uncertainty Scenario In Usage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCM External Uncertainty Scenario In Usage</em>'.
	 * @generated
	 */
	PCMExternalUncertaintyScenarioInUsage createPCMExternalUncertaintyScenarioInUsage();

	/**
	 * Returns a new object of class '<em>PCM Behavior Uncertainty Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCM Behavior Uncertainty Source</em>'.
	 * @generated
	 */
	PCMBehaviorUncertaintySource createPCMBehaviorUncertaintySource();

	/**
	 * Returns a new object of class '<em>PCM Behavior Uncertainty Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCM Behavior Uncertainty Scenario</em>'.
	 * @generated
	 */
	PCMBehaviorUncertaintyScenario createPCMBehaviorUncertaintyScenario();

	/**
	 * Returns a new object of class '<em>PCM Interface Uncertainty Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCM Interface Uncertainty Source</em>'.
	 * @generated
	 */
	PCMInterfaceUncertaintySource createPCMInterfaceUncertaintySource();

	/**
	 * Returns a new object of class '<em>PCM Interface Uncertainty Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCM Interface Uncertainty Scenario</em>'.
	 * @generated
	 */
	PCMInterfaceUncertaintyScenario createPCMInterfaceUncertaintyScenario();

	/**
	 * Returns a new object of class '<em>PCM Connector Uncertainty Source In External Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCM Connector Uncertainty Source In External Call</em>'.
	 * @generated
	 */
	PCMConnectorUncertaintySourceInExternalCall createPCMConnectorUncertaintySourceInExternalCall();

	/**
	 * Returns a new object of class '<em>PCM Connector Uncertainty Source In Entry Level System Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCM Connector Uncertainty Source In Entry Level System Call</em>'.
	 * @generated
	 */
	PCMConnectorUncertaintySourceInEntryLevelSystemCall createPCMConnectorUncertaintySourceInEntryLevelSystemCall();

	/**
	 * Returns a new object of class '<em>PCM Connector Uncertainty Scenario In External Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCM Connector Uncertainty Scenario In External Call</em>'.
	 * @generated
	 */
	PCMConnectorUncertaintyScenarioInExternalCall createPCMConnectorUncertaintyScenarioInExternalCall();

	/**
	 * Returns a new object of class '<em>PCM Connector Uncertainty Scenario In Entry Level System Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCM Connector Uncertainty Scenario In Entry Level System Call</em>'.
	 * @generated
	 */
	PCMConnectorUncertaintyScenarioInEntryLevelSystemCall createPCMConnectorUncertaintyScenarioInEntryLevelSystemCall();

	/**
	 * Returns a new object of class '<em>PCM Component Uncertainty Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCM Component Uncertainty Source</em>'.
	 * @generated
	 */
	PCMComponentUncertaintySource createPCMComponentUncertaintySource();

	/**
	 * Returns a new object of class '<em>PCM Component Uncertainty Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCM Component Uncertainty Scenario</em>'.
	 * @generated
	 */
	PCMComponentUncertaintyScenario createPCMComponentUncertaintyScenario();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PcmPackage getPcmPackage();

} //PcmFactory
