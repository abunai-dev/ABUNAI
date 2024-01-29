/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl;

import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage;

import dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyScenarioImpl;

import java.util.Collection;
import java.util.List;

import org.dataflowanalysis.dfd.datadictionary.Label;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DFD External Uncertainty Scenario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDExternalUncertaintyScenarioImpl#getTargetProperties <em>Target Properties</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DFDExternalUncertaintyScenarioImpl extends UncertaintyScenarioImpl implements DFDExternalUncertaintyScenario {
	/**
	 * The cached value of the '{@link #getTargetProperties() <em>Target Properties</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Label> targetProperties;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DFDExternalUncertaintyScenarioImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DfdPackage.Literals.DFD_EXTERNAL_UNCERTAINTY_SCENARIO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Label> getTargetProperties() {
		if (targetProperties == null) {
			targetProperties = new EObjectResolvingEList<Label>(Label.class, this, DfdPackage.DFD_EXTERNAL_UNCERTAINTY_SCENARIO__TARGET_PROPERTIES);
		}
		return targetProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DfdPackage.DFD_EXTERNAL_UNCERTAINTY_SCENARIO__TARGET_PROPERTIES:
				return getTargetProperties();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DfdPackage.DFD_EXTERNAL_UNCERTAINTY_SCENARIO__TARGET_PROPERTIES:
				getTargetProperties().clear();
				getTargetProperties().addAll((Collection<? extends Label>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DfdPackage.DFD_EXTERNAL_UNCERTAINTY_SCENARIO__TARGET_PROPERTIES:
				getTargetProperties().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DfdPackage.DFD_EXTERNAL_UNCERTAINTY_SCENARIO__TARGET_PROPERTIES:
				return targetProperties != null && !targetProperties.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DFDExternalUncertaintyScenarioImpl
