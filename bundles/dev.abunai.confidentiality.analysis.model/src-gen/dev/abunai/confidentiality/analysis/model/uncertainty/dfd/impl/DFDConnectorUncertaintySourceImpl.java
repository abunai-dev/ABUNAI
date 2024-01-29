/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl;

import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage;

import java.util.Collection;
import java.util.List;

import org.dataflowanalysis.dfd.datadictionary.AbstractAssignment;

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
 * An implementation of the model object '<em><b>DFD Connector Uncertainty Source</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDConnectorUncertaintySourceImpl#getTargetAssignement <em>Target Assignement</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDConnectorUncertaintySourceImpl#getTargetFlow <em>Target Flow</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDConnectorUncertaintySourceImpl#getScenarios <em>Scenarios</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DFDConnectorUncertaintySourceImpl extends DFDUncertaintySourceImpl implements DFDConnectorUncertaintySource {
	/**
	 * The cached value of the '{@link #getTargetAssignement() <em>Target Assignement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetAssignement()
	 * @generated
	 * @ordered
	 */
	protected AbstractAssignment targetAssignement;

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
	protected EList<DFDConnectorUncertaintyScenario> scenarios;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DFDConnectorUncertaintySourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DfdPackage.Literals.DFD_CONNECTOR_UNCERTAINTY_SOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractAssignment getTargetAssignement() {
		if (targetAssignement != null && targetAssignement.eIsProxy()) {
			InternalEObject oldTargetAssignement = (InternalEObject)targetAssignement;
			targetAssignement = (AbstractAssignment)eResolveProxy(oldTargetAssignement);
			if (targetAssignement != oldTargetAssignement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SOURCE__TARGET_ASSIGNEMENT, oldTargetAssignement, targetAssignement));
			}
		}
		return targetAssignement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractAssignment basicGetTargetAssignement() {
		return targetAssignement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetAssignement(AbstractAssignment newTargetAssignement) {
		AbstractAssignment oldTargetAssignement = targetAssignement;
		targetAssignement = newTargetAssignement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SOURCE__TARGET_ASSIGNEMENT, oldTargetAssignement, targetAssignement));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SOURCE__TARGET_FLOW, oldTargetFlow, targetFlow));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SOURCE__TARGET_FLOW, oldTargetFlow, targetFlow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<DFDConnectorUncertaintyScenario> getScenarios() {
		if (scenarios == null) {
			scenarios = new EObjectContainmentEList<DFDConnectorUncertaintyScenario>(DFDConnectorUncertaintyScenario.class, this, DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SOURCE__SCENARIOS);
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
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SOURCE__SCENARIOS:
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
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SOURCE__TARGET_ASSIGNEMENT:
				if (resolve) return getTargetAssignement();
				return basicGetTargetAssignement();
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SOURCE__TARGET_FLOW:
				if (resolve) return getTargetFlow();
				return basicGetTargetFlow();
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SOURCE__SCENARIOS:
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
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SOURCE__TARGET_ASSIGNEMENT:
				setTargetAssignement((AbstractAssignment)newValue);
				return;
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SOURCE__TARGET_FLOW:
				setTargetFlow((Flow)newValue);
				return;
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SOURCE__SCENARIOS:
				getScenarios().clear();
				getScenarios().addAll((Collection<? extends DFDConnectorUncertaintyScenario>)newValue);
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
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SOURCE__TARGET_ASSIGNEMENT:
				setTargetAssignement((AbstractAssignment)null);
				return;
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SOURCE__TARGET_FLOW:
				setTargetFlow((Flow)null);
				return;
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SOURCE__SCENARIOS:
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
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SOURCE__TARGET_ASSIGNEMENT:
				return targetAssignement != null;
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SOURCE__TARGET_FLOW:
				return targetFlow != null;
			case DfdPackage.DFD_CONNECTOR_UNCERTAINTY_SOURCE__SCENARIOS:
				return scenarios != null && !scenarios.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DFDConnectorUncertaintySourceImpl
