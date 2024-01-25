/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl;

import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.BehaviorUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage;

import dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyScenarioImpl;

import java.util.Collection;
import java.util.List;

import org.dataflowanalysis.dfd.datadictionary.AbstractAssignment;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Uncertainty Scenario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.BehaviorUncertaintyScenarioImpl#getTargetAssignments <em>Target Assignments</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BehaviorUncertaintyScenarioImpl extends UncertaintyScenarioImpl implements BehaviorUncertaintyScenario {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BehaviorUncertaintyScenarioImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DfdPackage.Literals.BEHAVIOR_UNCERTAINTY_SCENARIO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<AbstractAssignment> getTargetAssignments() {
		if (targetAssignments == null) {
			targetAssignments = new EObjectResolvingEList<AbstractAssignment>(AbstractAssignment.class, this, DfdPackage.BEHAVIOR_UNCERTAINTY_SCENARIO__TARGET_ASSIGNMENTS);
		}
		return targetAssignments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DfdPackage.BEHAVIOR_UNCERTAINTY_SCENARIO__TARGET_ASSIGNMENTS:
				return getTargetAssignments();
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
			case DfdPackage.BEHAVIOR_UNCERTAINTY_SCENARIO__TARGET_ASSIGNMENTS:
				getTargetAssignments().clear();
				getTargetAssignments().addAll((Collection<? extends AbstractAssignment>)newValue);
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
			case DfdPackage.BEHAVIOR_UNCERTAINTY_SCENARIO__TARGET_ASSIGNMENTS:
				getTargetAssignments().clear();
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
			case DfdPackage.BEHAVIOR_UNCERTAINTY_SCENARIO__TARGET_ASSIGNMENTS:
				return targetAssignments != null && !targetAssignments.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BehaviorUncertaintyScenarioImpl
