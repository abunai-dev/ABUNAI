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
	 * Returns a new object of class '<em>DFD External Uncertainty Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DFD External Uncertainty Source</em>'.
	 * @generated
	 */
	DFDExternalUncertaintySource createDFDExternalUncertaintySource();

	/**
	 * Returns a new object of class '<em>DFD External Uncertainty Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DFD External Uncertainty Scenario</em>'.
	 * @generated
	 */
	DFDExternalUncertaintyScenario createDFDExternalUncertaintyScenario();

	/**
	 * Returns a new object of class '<em>DFD Behavior Uncertainty Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DFD Behavior Uncertainty Source</em>'.
	 * @generated
	 */
	DFDBehaviorUncertaintySource createDFDBehaviorUncertaintySource();

	/**
	 * Returns a new object of class '<em>DFD Behavior Uncertainty Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DFD Behavior Uncertainty Scenario</em>'.
	 * @generated
	 */
	DFDBehaviorUncertaintyScenario createDFDBehaviorUncertaintyScenario();

	/**
	 * Returns a new object of class '<em>DFD Interface Uncertainty Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DFD Interface Uncertainty Source</em>'.
	 * @generated
	 */
	DFDInterfaceUncertaintySource createDFDInterfaceUncertaintySource();

	/**
	 * Returns a new object of class '<em>DFD Interface Uncertainty Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DFD Interface Uncertainty Scenario</em>'.
	 * @generated
	 */
	DFDInterfaceUncertaintyScenario createDFDInterfaceUncertaintyScenario();

	/**
	 * Returns a new object of class '<em>DFD Connector Uncertainty Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DFD Connector Uncertainty Source</em>'.
	 * @generated
	 */
	DFDConnectorUncertaintySource createDFDConnectorUncertaintySource();

	/**
	 * Returns a new object of class '<em>DFD Connector Uncertainty Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DFD Connector Uncertainty Scenario</em>'.
	 * @generated
	 */
	DFDConnectorUncertaintyScenario createDFDConnectorUncertaintyScenario();

	/**
	 * Returns a new object of class '<em>DFD Component Uncertainty Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DFD Component Uncertainty Source</em>'.
	 * @generated
	 */
	DFDComponentUncertaintySource createDFDComponentUncertaintySource();

	/**
	 * Returns a new object of class '<em>DFD Component Uncertainty Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DFD Component Uncertainty Scenario</em>'.
	 * @generated
	 */
	DFDComponentUncertaintyScenario createDFDComponentUncertaintyScenario();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DfdPackage getDfdPackage();

} //DfdFactory
