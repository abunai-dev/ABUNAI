/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl;

import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintyScenarioInExternalCall;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.ConnectorUncertaintySourceInExternalCall;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.palladiosimulator.pcm.seff.ExternalCallAction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connector Uncertainty Source In External Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ConnectorUncertaintySourceInExternalCallImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.ConnectorUncertaintySourceInExternalCallImpl#getScenarios <em>Scenarios</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConnectorUncertaintySourceInExternalCallImpl extends ConnectorUncertaintySourceImpl implements ConnectorUncertaintySourceInExternalCall {
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected ExternalCallAction target;

	/**
	 * The cached value of the '{@link #getScenarios() <em>Scenarios</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScenarios()
	 * @generated
	 * @ordered
	 */
	protected EList<ConnectorUncertaintyScenarioInExternalCall> scenarios;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectorUncertaintySourceInExternalCallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PcmPackage.Literals.CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalCallAction getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (ExternalCallAction)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PcmPackage.CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalCallAction basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(ExternalCallAction newTarget) {
		ExternalCallAction oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PcmPackage.CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<ConnectorUncertaintyScenarioInExternalCall> getScenarios() {
		if (scenarios == null) {
			scenarios = new EObjectContainmentEList<ConnectorUncertaintyScenarioInExternalCall>(ConnectorUncertaintyScenarioInExternalCall.class, this, PcmPackage.CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL__SCENARIOS);
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
			case PcmPackage.CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL__SCENARIOS:
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
			case PcmPackage.CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case PcmPackage.CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL__SCENARIOS:
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
			case PcmPackage.CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL__TARGET:
				setTarget((ExternalCallAction)newValue);
				return;
			case PcmPackage.CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL__SCENARIOS:
				getScenarios().clear();
				getScenarios().addAll((Collection<? extends ConnectorUncertaintyScenarioInExternalCall>)newValue);
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
			case PcmPackage.CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL__TARGET:
				setTarget((ExternalCallAction)null);
				return;
			case PcmPackage.CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL__SCENARIOS:
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
			case PcmPackage.CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL__TARGET:
				return target != null;
			case PcmPackage.CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL__SCENARIOS:
				return scenarios != null && !scenarios.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConnectorUncertaintySourceInExternalCallImpl
