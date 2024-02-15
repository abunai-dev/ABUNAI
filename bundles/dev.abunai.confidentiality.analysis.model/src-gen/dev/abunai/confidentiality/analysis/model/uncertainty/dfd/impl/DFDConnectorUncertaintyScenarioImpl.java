/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl;

import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage;

import dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyScenarioImpl;

import java.util.Collection;
import java.util.List;

import org.dataflowanalysis.dfd.datadictionary.AbstractAssignment;

import org.dataflowanalysis.dfd.dataflowdiagram.Flow;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DFD Connector Uncertainty Scenario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDConnectorUncertaintyScenarioImpl#getTargetAssignments <em>Target Assignments</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDConnectorUncertaintyScenarioImpl#getTargetFlow <em>Target Flow</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DFDConnectorUncertaintyScenarioImpl extends UncertaintyScenarioImpl implements DFDConnectorUncertaintyScenario {
	/**
	 * The cached value of the '{@link #getTargetAssignments() <em>Target Assignments</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetAssignments()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractAssignment> targetAssignments;

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
	protected DFDConnectorUncertaintyScenarioImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DfdPackage.Literals.DFD_CONNECTOR_UNCERTAINTY_SCENARIO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<AbstractAssignment> getTargetAssignments() {
		if (targetAssignments == null) {
			targetAssignments = new EObjectResolvingEList<AbstractAssignment>(AbstractAssignment.class, this, DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_ASSIGNMENTS);
		}
		return targetAssignments;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_FLOW, oldTargetFlow, targetFlow));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_FLOW, oldTargetFlow, targetFlow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_ASSIGNMENTS:
				return getTargetAssignments();
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_FLOW:
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_ASSIGNMENTS:
				getTargetAssignments().clear();
				getTargetAssignments().addAll((Collection<? extends AbstractAssignment>)newValue);
				return;
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_FLOW:
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
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_ASSIGNMENTS:
				getTargetAssignments().clear();
				return;
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_FLOW:
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
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_ASSIGNMENTS:
				return targetAssignments != null && !targetAssignments.isEmpty();
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_FLOW:
				return targetFlow != null;
		}
		return super.eIsSet(featureID);
	}

} //DFDConnectorUncertaintyScenarioImpl
