/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.impl;

import dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintyInUsageScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage;

import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.UsageAsignee;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Uncertainty In Usage Scenario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintyInUsageScenarioImpl#getTargetd <em>Targetd</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExternalUncertaintyInUsageScenarioImpl extends UncertaintyScenarioImpl implements ExternalUncertaintyInUsageScenario {
	/**
	 * The cached value of the '{@link #getTargetd() <em>Targetd</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetd()
	 * @generated
	 * @ordered
	 */
	protected UsageAsignee targetd;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalUncertaintyInUsageScenarioImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UncertaintyPackage.Literals.EXTERNAL_UNCERTAINTY_IN_USAGE_SCENARIO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsageAsignee getTargetd() {
		if (targetd != null && ((EObject)targetd).eIsProxy()) {
			InternalEObject oldTargetd = (InternalEObject)targetd;
			targetd = (UsageAsignee)eResolveProxy(oldTargetd);
			if (targetd != oldTargetd) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UncertaintyPackage.EXTERNAL_UNCERTAINTY_IN_USAGE_SCENARIO__TARGETD, oldTargetd, targetd));
			}
		}
		return targetd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsageAsignee basicGetTargetd() {
		return targetd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetd(UsageAsignee newTargetd) {
		UsageAsignee oldTargetd = targetd;
		targetd = newTargetd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UncertaintyPackage.EXTERNAL_UNCERTAINTY_IN_USAGE_SCENARIO__TARGETD, oldTargetd, targetd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UncertaintyPackage.EXTERNAL_UNCERTAINTY_IN_USAGE_SCENARIO__TARGETD:
				if (resolve) return getTargetd();
				return basicGetTargetd();
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
			case UncertaintyPackage.EXTERNAL_UNCERTAINTY_IN_USAGE_SCENARIO__TARGETD:
				setTargetd((UsageAsignee)newValue);
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
			case UncertaintyPackage.EXTERNAL_UNCERTAINTY_IN_USAGE_SCENARIO__TARGETD:
				setTargetd((UsageAsignee)null);
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
			case UncertaintyPackage.EXTERNAL_UNCERTAINTY_IN_USAGE_SCENARIO__TARGETD:
				return targetd != null;
		}
		return super.eIsSet(featureID);
	}

} //ExternalUncertaintyInUsageScenarioImpl
