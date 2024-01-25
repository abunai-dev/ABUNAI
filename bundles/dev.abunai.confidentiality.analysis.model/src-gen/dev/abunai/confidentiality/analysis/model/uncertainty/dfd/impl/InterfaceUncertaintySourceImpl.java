/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl;

import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.InterfaceUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.InterfaceUncertaintySource;

import dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintySourceImpl;

import java.util.Collection;
import java.util.List;

import org.dataflowanalysis.dfd.datadictionary.Pin;

import org.dataflowanalysis.dfd.dataflowdiagram.Flow;

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
 * An implementation of the model object '<em><b>Interface Uncertainty Source</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.InterfaceUncertaintySourceImpl#getTargetInPin <em>Target In Pin</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.InterfaceUncertaintySourceImpl#getTargetFlow <em>Target Flow</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.InterfaceUncertaintySourceImpl#getScenarios <em>Scenarios</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InterfaceUncertaintySourceImpl extends UncertaintySourceImpl implements InterfaceUncertaintySource {
	/**
	 * The cached value of the '{@link #getTargetInPin() <em>Target In Pin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetInPin()
	 * @generated
	 * @ordered
	 */
	protected Pin targetInPin;

	/**
	 * The cached value of the '{@link #getTargetFlow() <em>Target Flow</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetFlow()
	 * @generated
	 * @ordered
	 */
	protected Flow targetFlow;

	/**
	 * The cached value of the '{@link #getScenarios() <em>Scenarios</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScenarios()
	 * @generated
	 * @ordered
	 */
	protected EList<InterfaceUncertaintyScenario> scenarios;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterfaceUncertaintySourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DfdPackage.Literals.INTERFACE_UNCERTAINTY_SOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pin getTargetInPin() {
		if (targetInPin != null && targetInPin.eIsProxy()) {
			InternalEObject oldTargetInPin = (InternalEObject)targetInPin;
			targetInPin = (Pin)eResolveProxy(oldTargetInPin);
			if (targetInPin != oldTargetInPin) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DfdPackage.INTERFACE_UNCERTAINTY_SOURCE__TARGET_IN_PIN, oldTargetInPin, targetInPin));
			}
		}
		return targetInPin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pin basicGetTargetInPin() {
		return targetInPin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetInPin(Pin newTargetInPin) {
		Pin oldTargetInPin = targetInPin;
		targetInPin = newTargetInPin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DfdPackage.INTERFACE_UNCERTAINTY_SOURCE__TARGET_IN_PIN, oldTargetInPin, targetInPin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Flow getTargetFlow() {
		if (targetFlow != null && targetFlow.eIsProxy()) {
			InternalEObject oldTargetFlow = (InternalEObject)targetFlow;
			targetFlow = (Flow)eResolveProxy(oldTargetFlow);
			if (targetFlow != oldTargetFlow) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DfdPackage.INTERFACE_UNCERTAINTY_SOURCE__TARGET_FLOW, oldTargetFlow, targetFlow));
			}
		}
		return targetFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Flow basicGetTargetFlow() {
		return targetFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetFlow(Flow newTargetFlow) {
		Flow oldTargetFlow = targetFlow;
		targetFlow = newTargetFlow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DfdPackage.INTERFACE_UNCERTAINTY_SOURCE__TARGET_FLOW, oldTargetFlow, targetFlow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<InterfaceUncertaintyScenario> getScenarios() {
		if (scenarios == null) {
			scenarios = new EObjectContainmentEList<InterfaceUncertaintyScenario>(InterfaceUncertaintyScenario.class, this, DfdPackage.INTERFACE_UNCERTAINTY_SOURCE__SCENARIOS);
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
			case DfdPackage.INTERFACE_UNCERTAINTY_SOURCE__SCENARIOS:
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
			case DfdPackage.INTERFACE_UNCERTAINTY_SOURCE__TARGET_IN_PIN:
				if (resolve) return getTargetInPin();
				return basicGetTargetInPin();
			case DfdPackage.INTERFACE_UNCERTAINTY_SOURCE__TARGET_FLOW:
				if (resolve) return getTargetFlow();
				return basicGetTargetFlow();
			case DfdPackage.INTERFACE_UNCERTAINTY_SOURCE__SCENARIOS:
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
			case DfdPackage.INTERFACE_UNCERTAINTY_SOURCE__TARGET_IN_PIN:
				setTargetInPin((Pin)newValue);
				return;
			case DfdPackage.INTERFACE_UNCERTAINTY_SOURCE__TARGET_FLOW:
				setTargetFlow((Flow)newValue);
				return;
			case DfdPackage.INTERFACE_UNCERTAINTY_SOURCE__SCENARIOS:
				getScenarios().clear();
				getScenarios().addAll((Collection<? extends InterfaceUncertaintyScenario>)newValue);
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
			case DfdPackage.INTERFACE_UNCERTAINTY_SOURCE__TARGET_IN_PIN:
				setTargetInPin((Pin)null);
				return;
			case DfdPackage.INTERFACE_UNCERTAINTY_SOURCE__TARGET_FLOW:
				setTargetFlow((Flow)null);
				return;
			case DfdPackage.INTERFACE_UNCERTAINTY_SOURCE__SCENARIOS:
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
			case DfdPackage.INTERFACE_UNCERTAINTY_SOURCE__TARGET_IN_PIN:
				return targetInPin != null;
			case DfdPackage.INTERFACE_UNCERTAINTY_SOURCE__TARGET_FLOW:
				return targetFlow != null;
			case DfdPackage.INTERFACE_UNCERTAINTY_SOURCE__SCENARIOS:
				return scenarios != null && !scenarios.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InterfaceUncertaintySourceImpl
