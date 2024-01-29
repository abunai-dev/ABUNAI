/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl;

import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage;

import dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyScenarioImpl;

import org.dataflowanalysis.dfd.datadictionary.Pin;

import org.dataflowanalysis.dfd.dataflowdiagram.Flow;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DFD Interface Uncertainty Scenario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDInterfaceUncertaintyScenarioImpl#getTargetInPin <em>Target In Pin</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDInterfaceUncertaintyScenarioImpl#getTargetFlow <em>Target Flow</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DFDInterfaceUncertaintyScenarioImpl extends UncertaintyScenarioImpl implements DFDInterfaceUncertaintyScenario {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DFDInterfaceUncertaintyScenarioImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DfdPackage.Literals.DFD_INTERFACE_UNCERTAINTY_SCENARIO;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DfdPackage.DFD_INTERFACE_UNCERTAINTY_SCENARIO__TARGET_IN_PIN, oldTargetInPin, targetInPin));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DfdPackage.DFD_INTERFACE_UNCERTAINTY_SCENARIO__TARGET_IN_PIN, oldTargetInPin, targetInPin));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DfdPackage.DFD_INTERFACE_UNCERTAINTY_SCENARIO__TARGET_FLOW, oldTargetFlow, targetFlow));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DfdPackage.DFD_INTERFACE_UNCERTAINTY_SCENARIO__TARGET_FLOW, oldTargetFlow, targetFlow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DfdPackage.DFD_INTERFACE_UNCERTAINTY_SCENARIO__TARGET_IN_PIN:
				if (resolve) return getTargetInPin();
				return basicGetTargetInPin();
			case DfdPackage.DFD_INTERFACE_UNCERTAINTY_SCENARIO__TARGET_FLOW:
				if (resolve) return getTargetFlow();
				return basicGetTargetFlow();
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
			case DfdPackage.DFD_INTERFACE_UNCERTAINTY_SCENARIO__TARGET_IN_PIN:
				setTargetInPin((Pin)newValue);
				return;
			case DfdPackage.DFD_INTERFACE_UNCERTAINTY_SCENARIO__TARGET_FLOW:
				setTargetFlow((Flow)newValue);
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
			case DfdPackage.DFD_INTERFACE_UNCERTAINTY_SCENARIO__TARGET_IN_PIN:
				setTargetInPin((Pin)null);
				return;
			case DfdPackage.DFD_INTERFACE_UNCERTAINTY_SCENARIO__TARGET_FLOW:
				setTargetFlow((Flow)null);
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
			case DfdPackage.DFD_INTERFACE_UNCERTAINTY_SCENARIO__TARGET_IN_PIN:
				return targetInPin != null;
			case DfdPackage.DFD_INTERFACE_UNCERTAINTY_SCENARIO__TARGET_FLOW:
				return targetFlow != null;
		}
		return super.eIsSet(featureID);
	}

} //DFDInterfaceUncertaintyScenarioImpl
