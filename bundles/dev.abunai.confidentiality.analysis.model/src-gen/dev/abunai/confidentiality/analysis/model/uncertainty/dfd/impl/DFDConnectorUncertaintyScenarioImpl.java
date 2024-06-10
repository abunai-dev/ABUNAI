/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl;

import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage;

import dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyScenarioImpl;

import java.util.Collection;
import java.util.List;

import org.dataflowanalysis.dfd.datadictionary.AbstractAssignment;

import org.dataflowanalysis.dfd.datadictionary.Pin;
import org.dataflowanalysis.dfd.dataflowdiagram.Node;
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
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDConnectorUncertaintyScenarioImpl#getTargetPin <em>Target Pin</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDConnectorUncertaintyScenarioImpl#getTargetNode <em>Target Node</em>}</li>
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
	 * The cached value of the '{@link #getTargetPin() <em>Target Pin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetPin()
	 * @generated
	 * @ordered
	 */
	protected Pin targetPin;

	/**
	 * The cached value of the '{@link #getTargetNode() <em>Target Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetNode()
	 * @generated
	 * @ordered
	 */
	protected Node targetNode;

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
	public Pin getTargetPin() {
		if (targetPin != null && targetPin.eIsProxy()) {
			InternalEObject oldTargetPin = (InternalEObject)targetPin;
			targetPin = (Pin)eResolveProxy(oldTargetPin);
			if (targetPin != oldTargetPin) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_PIN, oldTargetPin, targetPin));
			}
		}
		return targetPin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pin basicGetTargetPin() {
		return targetPin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetPin(Pin newTargetPin) {
		Pin oldTargetPin = targetPin;
		targetPin = newTargetPin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_PIN, oldTargetPin, targetPin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getTargetNode() {
		if (targetNode != null && targetNode.eIsProxy()) {
			InternalEObject oldTargetNode = (InternalEObject)targetNode;
			targetNode = (Node)eResolveProxy(oldTargetNode);
			if (targetNode != oldTargetNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_NODE, oldTargetNode, targetNode));
			}
		}
		return targetNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetTargetNode() {
		return targetNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetNode(Node newTargetNode) {
		Node oldTargetNode = targetNode;
		targetNode = newTargetNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_NODE, oldTargetNode, targetNode));
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
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_PIN:
				if (resolve) return getTargetPin();
				return basicGetTargetPin();
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_NODE:
				if (resolve) return getTargetNode();
				return basicGetTargetNode();
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
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_PIN:
				setTargetPin((Pin)newValue);
				return;
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_NODE:
				setTargetNode((Node)newValue);
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
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_PIN:
				setTargetPin((Pin)null);
				return;
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_NODE:
				setTargetNode((Node)null);
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
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_PIN:
				return targetPin != null;
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SCENARIO__TARGET_NODE:
				return targetNode != null;
		}
		return super.eIsSet(featureID);
	}

} //DFDConnectorUncertaintyScenarioImpl
