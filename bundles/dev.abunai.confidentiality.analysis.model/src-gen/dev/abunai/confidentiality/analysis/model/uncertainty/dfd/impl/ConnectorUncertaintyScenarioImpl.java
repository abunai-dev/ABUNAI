/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl;

import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.ConnectorUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage;

import dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyScenarioImpl;

import org.dataflowanalysis.dfd.datadictionary.AbstractAssignment;

import org.dataflowanalysis.dfd.dataflowdiagram.Flow;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connector Uncertainty Scenario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.ConnectorUncertaintyScenarioImpl#getTargetAssignment <em>Target Assignment</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.ConnectorUncertaintyScenarioImpl#getTargetFlow <em>Target Flow</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConnectorUncertaintyScenarioImpl extends UncertaintyScenarioImpl implements ConnectorUncertaintyScenario {
	/**
	 * The cached value of the '{@link #getTargetAssignment() <em>Target Assignment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetAssignment()
	 * @generated
	 * @ordered
	 */
	protected AbstractAssignment targetAssignment;

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
	protected ConnectorUncertaintyScenarioImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DfdPackage.Literals.CONNECTOR_UNCERTAINTY_SCENARIO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractAssignment getTargetAssignment() {
		if (targetAssignment != null && targetAssignment.eIsProxy()) {
			InternalEObject oldTargetAssignment = (InternalEObject)targetAssignment;
			targetAssignment = (AbstractAssignment)eResolveProxy(oldTargetAssignment);
			if (targetAssignment != oldTargetAssignment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DfdPackage.CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_ASSIGNMENT, oldTargetAssignment, targetAssignment));
			}
		}
		return targetAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractAssignment basicGetTargetAssignment() {
		return targetAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetAssignment(AbstractAssignment newTargetAssignment) {
		AbstractAssignment oldTargetAssignment = targetAssignment;
		targetAssignment = newTargetAssignment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DfdPackage.CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_ASSIGNMENT, oldTargetAssignment, targetAssignment));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DfdPackage.CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_FLOW, oldTargetFlow, targetFlow));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DfdPackage.CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_FLOW, oldTargetFlow, targetFlow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DfdPackage.CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_ASSIGNMENT:
				if (resolve) return getTargetAssignment();
				return basicGetTargetAssignment();
			case DfdPackage.CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_FLOW:
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
			case DfdPackage.CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_ASSIGNMENT:
				setTargetAssignment((AbstractAssignment)newValue);
				return;
			case DfdPackage.CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_FLOW:
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
			case DfdPackage.CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_ASSIGNMENT:
				setTargetAssignment((AbstractAssignment)null);
				return;
			case DfdPackage.CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_FLOW:
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
			case DfdPackage.CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_ASSIGNMENT:
				return targetAssignment != null;
			case DfdPackage.CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_FLOW:
				return targetFlow != null;
		}
		return super.eIsSet(featureID);
	}

} //ConnectorUncertaintyScenarioImpl
