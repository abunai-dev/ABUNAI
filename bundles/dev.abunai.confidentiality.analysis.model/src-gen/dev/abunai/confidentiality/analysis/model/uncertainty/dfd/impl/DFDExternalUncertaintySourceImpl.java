/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl;

import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage;

import java.util.Collection;
import java.util.List;

import org.dataflowanalysis.dfd.datadictionary.Label;

import org.dataflowanalysis.dfd.dataflowdiagram.Node;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DFD External Uncertainty Source</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDExternalUncertaintySourceImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDExternalUncertaintySourceImpl#getTargetProperties <em>Target Properties</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DFDExternalUncertaintySourceImpl#getScenarios <em>Scenarios</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DFDExternalUncertaintySourceImpl extends DFDUncertaintySourceImpl implements DFDExternalUncertaintySource {
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Node target;

	/**
	 * The cached value of the '{@link #getTargetProperties() <em>Target Properties</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Label> targetProperties;

	/**
	 * The cached value of the '{@link #getScenarios() <em>Scenarios</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScenarios()
	 * @generated
	 * @ordered
	 */
	protected EList<DFDExternalUncertaintyScenario> scenarios;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DFDExternalUncertaintySourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DfdPackage.Literals.DFD_EXTERNAL_UNCERTAINTY_SOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (Node)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DfdPackage.DFD_EXTERNAL_UNCERTAINTY_SOURCE__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Node newTarget) {
		Node oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DfdPackage.DFD_EXTERNAL_UNCERTAINTY_SOURCE__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Label> getTargetProperties() {
		if (targetProperties == null) {
			targetProperties = new EObjectResolvingEList<Label>(Label.class, this, DfdPackage.DFD_EXTERNAL_UNCERTAINTY_SOURCE__TARGET_PROPERTIES);
		}
		return targetProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<DFDExternalUncertaintyScenario> getScenarios() {
		if (scenarios == null) {
			scenarios = new EObjectContainmentEList<DFDExternalUncertaintyScenario>(DFDExternalUncertaintyScenario.class, this, DfdPackage.DFD_EXTERNAL_UNCERTAINTY_SOURCE__SCENARIOS);
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
			case DfdPackage.DFD_EXTERNAL_UNCERTAINTY_SOURCE__SCENARIOS:
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
			case DfdPackage.DFD_EXTERNAL_UNCERTAINTY_SOURCE__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case DfdPackage.DFD_EXTERNAL_UNCERTAINTY_SOURCE__TARGET_PROPERTIES:
				return getTargetProperties();
			case DfdPackage.DFD_EXTERNAL_UNCERTAINTY_SOURCE__SCENARIOS:
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
			case DfdPackage.DFD_EXTERNAL_UNCERTAINTY_SOURCE__TARGET:
				setTarget((Node)newValue);
				return;
			case DfdPackage.DFD_EXTERNAL_UNCERTAINTY_SOURCE__TARGET_PROPERTIES:
				getTargetProperties().clear();
				getTargetProperties().addAll((Collection<? extends Label>)newValue);
				return;
			case DfdPackage.DFD_EXTERNAL_UNCERTAINTY_SOURCE__SCENARIOS:
				getScenarios().clear();
				getScenarios().addAll((Collection<? extends DFDExternalUncertaintyScenario>)newValue);
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
			case DfdPackage.DFD_EXTERNAL_UNCERTAINTY_SOURCE__TARGET:
				setTarget((Node)null);
				return;
			case DfdPackage.DFD_EXTERNAL_UNCERTAINTY_SOURCE__TARGET_PROPERTIES:
				getTargetProperties().clear();
				return;
			case DfdPackage.DFD_EXTERNAL_UNCERTAINTY_SOURCE__SCENARIOS:
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
			case DfdPackage.DFD_EXTERNAL_UNCERTAINTY_SOURCE__TARGET:
				return target != null;
			case DfdPackage.DFD_EXTERNAL_UNCERTAINTY_SOURCE__TARGET_PROPERTIES:
				return targetProperties != null && !targetProperties.isEmpty();
			case DfdPackage.DFD_EXTERNAL_UNCERTAINTY_SOURCE__SCENARIOS:
				return scenarios != null && !scenarios.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DFDExternalUncertaintySourceImpl
