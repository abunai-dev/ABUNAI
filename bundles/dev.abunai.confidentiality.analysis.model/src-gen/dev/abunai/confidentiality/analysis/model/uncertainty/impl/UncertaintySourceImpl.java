/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.impl;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;

import org.eclipse.emf.ecore.EClass;

import tools.mdsd.modelingfoundations.identifier.impl.EntityImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class UncertaintySourceImpl extends EntityImpl implements UncertaintySource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UncertaintySourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UncertaintyPackage.Literals.UNCERTAINTY_SOURCE;
	}

} //UncertaintySourceImpl
