/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl;

import dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyScenarioImpl;

import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ExternalUncertaintyScenarioInResource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage;

import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.RessourceAssignee;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Uncertainty Scenario In Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ExternalUncertaintyScenarioInResourceImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExternalUncertaintyScenarioInResourceImpl extends UncertaintyScenarioImpl implements ExternalUncertaintyScenarioInResource {
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected RessourceAssignee target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalUncertaintyScenarioInResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PcmPackage.Literals.EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RessourceAssignee getTarget() {
		if (target != null && ((EObject)target).eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (RessourceAssignee)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PcmPackage.EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RessourceAssignee basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(RessourceAssignee newTarget) {
		RessourceAssignee oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PcmPackage.EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PcmPackage.EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PcmPackage.EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE__TARGET:
				setTarget((RessourceAssignee)newValue);
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
			case PcmPackage.EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE__TARGET:
				setTarget((RessourceAssignee)null);
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
			case PcmPackage.EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE__TARGET:
				return target != null;
		}
		return super.eIsSet(featureID);
	}

} //ExternalUncertaintyScenarioInResourceImpl
