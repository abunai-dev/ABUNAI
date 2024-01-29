/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl;

import dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyScenarioImpl;

import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMInterfaceUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.palladiosimulator.pcm.repository.OperationSignature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PCM Interface Uncertainty Scenario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMInterfaceUncertaintyScenarioImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PCMInterfaceUncertaintyScenarioImpl extends UncertaintyScenarioImpl implements PCMInterfaceUncertaintyScenario {
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected OperationSignature target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PCMInterfaceUncertaintyScenarioImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PcmPackage.Literals.PCM_INTERFACE_UNCERTAINTY_SCENARIO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationSignature getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (OperationSignature)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PcmPackage.PCM_INTERFACE_UNCERTAINTY_SCENARIO__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationSignature basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(OperationSignature newTarget) {
		OperationSignature oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PcmPackage.PCM_INTERFACE_UNCERTAINTY_SCENARIO__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PcmPackage.PCM_INTERFACE_UNCERTAINTY_SCENARIO__TARGET:
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
			case PcmPackage.PCM_INTERFACE_UNCERTAINTY_SCENARIO__TARGET:
				setTarget((OperationSignature)newValue);
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
			case PcmPackage.PCM_INTERFACE_UNCERTAINTY_SCENARIO__TARGET:
				setTarget((OperationSignature)null);
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
			case PcmPackage.PCM_INTERFACE_UNCERTAINTY_SCENARIO__TARGET:
				return target != null;
		}
		return super.eIsSet(featureID);
	}

} //PCMInterfaceUncertaintyScenarioImpl
