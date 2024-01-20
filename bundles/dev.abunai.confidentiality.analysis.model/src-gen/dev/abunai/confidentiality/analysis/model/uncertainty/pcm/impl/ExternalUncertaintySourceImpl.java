/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl;

import dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintySourceImpl;

import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Uncertainty Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ExternalUncertaintySourceImpl extends UncertaintySourceImpl implements ExternalUncertaintySource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalUncertaintySourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PcmPackage.Literals.EXTERNAL_UNCERTAINTY_SOURCE;
	}

} //ExternalUncertaintySourceImpl
