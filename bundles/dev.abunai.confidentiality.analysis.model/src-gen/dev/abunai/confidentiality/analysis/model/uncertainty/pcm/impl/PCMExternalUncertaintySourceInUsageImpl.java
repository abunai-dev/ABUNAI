/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl;

import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintyScenarioInUsage;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySourceInUsage;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage;

import java.util.Collection;
import java.util.List;

import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.UsageAssignee;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PCM External Uncertainty Source In Usage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMExternalUncertaintySourceInUsageImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMExternalUncertaintySourceInUsageImpl#getScenarios <em>Scenarios</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PCMExternalUncertaintySourceInUsageImpl extends PCMExternalUncertaintySourceImpl implements PCMExternalUncertaintySourceInUsage {
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected UsageAssignee target;

	/**
	 * The cached value of the '{@link #getScenarios() <em>Scenarios</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScenarios()
	 * @generated
	 * @ordered
	 */
	protected EList<PCMExternalUncertaintyScenarioInUsage> scenarios;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PCMExternalUncertaintySourceInUsageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PcmPackage.Literals.PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsageAssignee getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (UsageAssignee)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PcmPackage.PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsageAssignee basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(UsageAssignee newTarget) {
		UsageAssignee oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PcmPackage.PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<PCMExternalUncertaintyScenarioInUsage> getScenarios() {
		if (scenarios == null) {
			scenarios = new EObjectContainmentEList<PCMExternalUncertaintyScenarioInUsage>(PCMExternalUncertaintyScenarioInUsage.class, this, PcmPackage.PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__SCENARIOS);
		}
		return scenarios;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PcmPackage.PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__SCENARIOS:
				return ((InternalEList<?>)getScenarios()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PcmPackage.PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case PcmPackage.PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__SCENARIOS:
				return getScenarios();
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
			case PcmPackage.PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__TARGET:
				setTarget((UsageAssignee)newValue);
				return;
			case PcmPackage.PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__SCENARIOS:
				getScenarios().clear();
				getScenarios().addAll((Collection<? extends PCMExternalUncertaintyScenarioInUsage>)newValue);
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
			case PcmPackage.PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__TARGET:
				setTarget((UsageAssignee)null);
				return;
			case PcmPackage.PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__SCENARIOS:
				getScenarios().clear();
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
			case PcmPackage.PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__TARGET:
				return target != null;
			case PcmPackage.PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__SCENARIOS:
				return scenarios != null && !scenarios.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PCMExternalUncertaintySourceInUsageImpl
