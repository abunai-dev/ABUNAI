/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl;

import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.BehaviorUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.BehaviorUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage;

import dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintySourceImpl;

import java.util.Collection;
import java.util.List;

import org.dataflowanalysis.dfd.datadictionary.AbstractAssignment;
import org.dataflowanalysis.dfd.datadictionary.Behaviour;

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
 * An implementation of the model object '<em><b>Behavior Uncertainty Source</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.BehaviorUncertaintySourceImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.BehaviorUncertaintySourceImpl#getTargetAssignments <em>Target Assignments</em>}</li>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.BehaviorUncertaintySourceImpl#getScenarios <em>Scenarios</em>}</li>
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
	protected Behaviour target;

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
		return DfdPackage.Literals.BEHAVIOR_UNCERTAINTY_SOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Behaviour getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (Behaviour)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DfdPackage.BEHAVIOR_UNCERTAINTY_SOURCE__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Behaviour basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Behaviour newTarget) {
		Behaviour oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DfdPackage.BEHAVIOR_UNCERTAINTY_SOURCE__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<AbstractAssignment> getTargetAssignments() {
		if (targetAssignments == null) {
			targetAssignments = new EObjectResolvingEList<AbstractAssignment>(AbstractAssignment.class, this, DfdPackage.BEHAVIOR_UNCERTAINTY_SOURCE__TARGET_ASSIGNMENTS);
		}
		return targetAssignments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<BehaviorUncertaintyScenario> getScenarios() {
		if (scenarios == null) {
			scenarios = new EObjectContainmentEList<BehaviorUncertaintyScenario>(BehaviorUncertaintyScenario.class, this, DfdPackage.BEHAVIOR_UNCERTAINTY_SOURCE__SCENARIOS);
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
			case DfdPackage.BEHAVIOR_UNCERTAINTY_SOURCE__SCENARIOS:
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
			case DfdPackage.BEHAVIOR_UNCERTAINTY_SOURCE__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case DfdPackage.BEHAVIOR_UNCERTAINTY_SOURCE__TARGET_ASSIGNMENTS:
				return getTargetAssignments();
			case DfdPackage.BEHAVIOR_UNCERTAINTY_SOURCE__SCENARIOS:
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
			case DfdPackage.BEHAVIOR_UNCERTAINTY_SOURCE__TARGET:
				setTarget((Behaviour)newValue);
				return;
			case DfdPackage.BEHAVIOR_UNCERTAINTY_SOURCE__TARGET_ASSIGNMENTS:
				getTargetAssignments().clear();
				getTargetAssignments().addAll((Collection<? extends AbstractAssignment>)newValue);
				return;
			case DfdPackage.BEHAVIOR_UNCERTAINTY_SOURCE__SCENARIOS:
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
			case DfdPackage.BEHAVIOR_UNCERTAINTY_SOURCE__TARGET:
				setTarget((Behaviour)null);
				return;
			case DfdPackage.BEHAVIOR_UNCERTAINTY_SOURCE__TARGET_ASSIGNMENTS:
				getTargetAssignments().clear();
				return;
			case DfdPackage.BEHAVIOR_UNCERTAINTY_SOURCE__SCENARIOS:
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
			case DfdPackage.BEHAVIOR_UNCERTAINTY_SOURCE__TARGET:
				return target != null;
			case DfdPackage.BEHAVIOR_UNCERTAINTY_SOURCE__TARGET_ASSIGNMENTS:
				return targetAssignments != null && !targetAssignments.isEmpty();
			case DfdPackage.BEHAVIOR_UNCERTAINTY_SOURCE__SCENARIOS:
				return scenarios != null && !scenarios.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BehaviorUncertaintySourceImpl
