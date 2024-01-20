/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl;

import dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintySourceImpl;

import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connector Uncertainty Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ConnectorUncertaintySourceImpl extends UncertaintySourceImpl implements ConnectorUncertaintySource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectorUncertaintySourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PcmPackage.Literals.CONNECTOR_UNCERTAINTY_SOURCE;
	}

} //ConnectorUncertaintySourceImpl
