/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.impl;

import dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintyScenarioInUsage;
import dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintySourceInUsage;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage;

import java.util.Collection;
import java.util.List;

import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.UsageAssignee;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Uncertainty Source In Usage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintySourceInUsageImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintySourceInUsageImpl#getScenarios <em>Scenarios</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExternalUncertaintySourceInUsageImpl extends ExternalUncertaintySourceImpl implements ExternalUncertaintySourceInUsage {
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
	protected EList<ExternalUncertaintyScenarioInUsage> scenarios;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalUncertaintySourceInUsageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UncertaintyPackage.Literals.EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsageAssignee getTarget() {
		if (target != null && ((EObject)target).eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (UsageAssignee)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UncertaintyPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__TARGET, oldTarget, target));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UncertaintyPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<ExternalUncertaintyScenarioInUsage> getScenarios() {
		if (scenarios == null) {
			scenarios = new EObjectContainmentEList<ExternalUncertaintyScenarioInUsage>(ExternalUncertaintyScenarioInUsage.class, this, UncertaintyPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__SCENARIOS);
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
			case UncertaintyPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__SCENARIOS:
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
			case UncertaintyPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case UncertaintyPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__SCENARIOS:
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
			case UncertaintyPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__TARGET:
				setTarget((UsageAssignee)newValue);
				return;
			case UncertaintyPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__SCENARIOS:
				getScenarios().clear();
				getScenarios().addAll((Collection<? extends ExternalUncertaintyScenarioInUsage>)newValue);
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
			case UncertaintyPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__TARGET:
				setTarget((UsageAssignee)null);
				return;
			case UncertaintyPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__SCENARIOS:
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
			case UncertaintyPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__TARGET:
				return target != null;
			case UncertaintyPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__SCENARIOS:
				return scenarios != null && !scenarios.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ExternalUncertaintySourceInUsageImpl
