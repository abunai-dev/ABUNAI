/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl;

import dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintySourceImpl;

import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PCM Uncertainty Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class PCMUncertaintySourceImpl extends UncertaintySourceImpl implements PCMUncertaintySource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PCMUncertaintySourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PcmPackage.Literals.PCM_UNCERTAINTY_SOURCE;
	}

} //PCMUncertaintySourceImpl
