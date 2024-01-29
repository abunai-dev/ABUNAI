/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl;

import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintyScenarioInEntryLevelSystemCall;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInEntryLevelSystemCall;
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

import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PCM Connector Uncertainty Source In Entry Level System Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMConnectorUncertaintySourceInEntryLevelSystemCallImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl.PCMConnectorUncertaintySourceInEntryLevelSystemCallImpl#getScenarios <em>Scenarios</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PCMConnectorUncertaintySourceInEntryLevelSystemCallImpl extends PCMConnectorUncertaintySourceImpl implements PCMConnectorUncertaintySourceInEntryLevelSystemCall {
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected EntryLevelSystemCall target;

	/**
	 * The cached value of the '{@link #getScenarios() <em>Scenarios</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScenarios()
	 * @generated
	 * @ordered
	 */
	protected EList<PCMConnectorUncertaintyScenarioInEntryLevelSystemCall> scenarios;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PCMConnectorUncertaintySourceInEntryLevelSystemCallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PcmPackage.Literals.PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryLevelSystemCall getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (EntryLevelSystemCall)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PcmPackage.PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryLevelSystemCall basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(EntryLevelSystemCall newTarget) {
		EntryLevelSystemCall oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PcmPackage.PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<PCMConnectorUncertaintyScenarioInEntryLevelSystemCall> getScenarios() {
		if (scenarios == null) {
			scenarios = new EObjectContainmentEList<PCMConnectorUncertaintyScenarioInEntryLevelSystemCall>(PCMConnectorUncertaintyScenarioInEntryLevelSystemCall.class, this, PcmPackage.PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL__SCENARIOS);
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
			case PcmPackage.PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL__SCENARIOS:
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
			case PcmPackage.PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case PcmPackage.PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL__SCENARIOS:
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
			case PcmPackage.PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL__TARGET:
				setTarget((EntryLevelSystemCall)newValue);
				return;
			case PcmPackage.PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL__SCENARIOS:
				getScenarios().clear();
				getScenarios().addAll((Collection<? extends PCMConnectorUncertaintyScenarioInEntryLevelSystemCall>)newValue);
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
			case PcmPackage.PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL__TARGET:
				setTarget((EntryLevelSystemCall)null);
				return;
			case PcmPackage.PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL__SCENARIOS:
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
			case PcmPackage.PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL__TARGET:
				return target != null;
			case PcmPackage.PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL__SCENARIOS:
				return scenarios != null && !scenarios.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PCMConnectorUncertaintySourceInEntryLevelSystemCallImpl
