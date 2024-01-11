/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.impl;

import dev.abunai.confidentiality.analysis.model.uncertainty.BehaviorUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.BehaviorUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage;

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

import org.palladiosimulator.pcm.seff.SetVariableAction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Uncertainty Source</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.BehaviorUncertaintySourceImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.impl.BehaviorUncertaintySourceImpl#getScenarios <em>Scenarios</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BehaviorUncertaintySourceImpl extends UncertaintySourceImpl implements BehaviorUncertaintySource {
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected SetVariableAction target;

	/**
	 * The cached value of the '{@link #getScenarios() <em>Scenarios</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScenarios()
	 * @generated
	 * @ordered
	 */
	protected EList<BehaviorUncertaintyScenario> scenarios;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BehaviorUncertaintySourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UncertaintyPackage.Literals.BEHAVIOR_UNCERTAINTY_SOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetVariableAction getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (SetVariableAction)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UncertaintyPackage.BEHAVIOR_UNCERTAINTY_SOURCE__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetVariableAction basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(SetVariableAction newTarget) {
		SetVariableAction oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UncertaintyPackage.BEHAVIOR_UNCERTAINTY_SOURCE__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<BehaviorUncertaintyScenario> getScenarios() {
		if (scenarios == null) {
			scenarios = new EObjectContainmentEList<BehaviorUncertaintyScenario>(BehaviorUncertaintyScenario.class, this, UncertaintyPackage.BEHAVIOR_UNCERTAINTY_SOURCE__SCENARIOS);
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
			case UncertaintyPackage.BEHAVIOR_UNCERTAINTY_SOURCE__SCENARIOS:
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
			case UncertaintyPackage.BEHAVIOR_UNCERTAINTY_SOURCE__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case UncertaintyPackage.BEHAVIOR_UNCERTAINTY_SOURCE__SCENARIOS:
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
			case UncertaintyPackage.BEHAVIOR_UNCERTAINTY_SOURCE__TARGET:
				setTarget((SetVariableAction)newValue);
				return;
			case UncertaintyPackage.BEHAVIOR_UNCERTAINTY_SOURCE__SCENARIOS:
				getScenarios().clear();
				getScenarios().addAll((Collection<? extends BehaviorUncertaintyScenario>)newValue);
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
			case UncertaintyPackage.BEHAVIOR_UNCERTAINTY_SOURCE__TARGET:
				setTarget((SetVariableAction)null);
				return;
			case UncertaintyPackage.BEHAVIOR_UNCERTAINTY_SOURCE__SCENARIOS:
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
			case UncertaintyPackage.BEHAVIOR_UNCERTAINTY_SOURCE__TARGET:
				return target != null;
			case UncertaintyPackage.BEHAVIOR_UNCERTAINTY_SOURCE__SCENARIOS:
				return scenarios != null && !scenarios.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BehaviorUncertaintySourceImpl
