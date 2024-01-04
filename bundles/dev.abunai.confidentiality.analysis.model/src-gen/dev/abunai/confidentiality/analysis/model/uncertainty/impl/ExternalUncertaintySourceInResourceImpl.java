/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.impl;

import dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintyScenarioInResource;
import dev.abunai.confidentiality.analysis.model.uncertainty.ExternalUncertaintySourceInResource;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage;

import java.util.Collection;

import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.RessourceAssignee;

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
 * An implementation of the model object '<em><b>External Uncertainty Source In Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintySourceInResourceImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.ExternalUncertaintySourceInResourceImpl#getScenarios <em>Scenarios</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExternalUncertaintySourceInResourceImpl extends ExternalUncertaintySourceImpl implements ExternalUncertaintySourceInResource {
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
	 * The cached value of the '{@link #getScenarios() <em>Scenarios</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScenarios()
	 * @generated
	 * @ordered
	 */
	protected EList<ExternalUncertaintyScenarioInResource> scenarios;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalUncertaintySourceInResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UncertaintyPackage.Literals.EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UncertaintyPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE__TARGET, oldTarget, target));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UncertaintyPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExternalUncertaintyScenarioInResource> getScenarios() {
		if (scenarios == null) {
			scenarios = new EObjectContainmentEList<ExternalUncertaintyScenarioInResource>(ExternalUncertaintyScenarioInResource.class, this, UncertaintyPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE__SCENARIOS);
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
			case UncertaintyPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE__SCENARIOS:
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
			case UncertaintyPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case UncertaintyPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE__SCENARIOS:
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
			case UncertaintyPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE__TARGET:
				setTarget((RessourceAssignee)newValue);
				return;
			case UncertaintyPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE__SCENARIOS:
				getScenarios().clear();
				getScenarios().addAll((Collection<? extends ExternalUncertaintyScenarioInResource>)newValue);
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
			case UncertaintyPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE__TARGET:
				setTarget((RessourceAssignee)null);
				return;
			case UncertaintyPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE__SCENARIOS:
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
			case UncertaintyPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE__TARGET:
				return target != null;
			case UncertaintyPackage.EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE__SCENARIOS:
				return scenarios != null && !scenarios.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ExternalUncertaintySourceInResourceImpl
