/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.dfd.provider;


import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.InterfaceUncertaintyScenario;

import dev.abunai.confidentiality.analysis.model.uncertainty.provider.UncertaintyEditPlugin;
import dev.abunai.confidentiality.analysis.model.uncertainty.provider.UncertaintyScenarioItemProvider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

/**
 * This is the item provider adapter for a {@link dev.abunai.confidentiality.analysis.model.uncertainty.dfd.InterfaceUncertaintyScenario} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class InterfaceUncertaintyScenarioItemProvider extends UncertaintyScenarioItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceUncertaintyScenarioItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addTargetInPinPropertyDescriptor(object);
			addTargetFlowPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Target In Pin feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetInPinPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InterfaceUncertaintyScenario_targetInPin_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InterfaceUncertaintyScenario_targetInPin_feature", "_UI_InterfaceUncertaintyScenario_type"),
				 DfdPackage.Literals.INTERFACE_UNCERTAINTY_SCENARIO__TARGET_IN_PIN,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Target Flow feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetFlowPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InterfaceUncertaintyScenario_targetFlow_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InterfaceUncertaintyScenario_targetFlow_feature", "_UI_InterfaceUncertaintyScenario_type"),
				 DfdPackage.Literals.INTERFACE_UNCERTAINTY_SCENARIO__TARGET_FLOW,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns InterfaceUncertaintyScenario.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/InterfaceUncertaintyScenario"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		InterfaceUncertaintyScenario interfaceUncertaintyScenario = (InterfaceUncertaintyScenario)object;
		return getString("_UI_InterfaceUncertaintyScenario_type") + " " + interfaceUncertaintyScenario.getProbability();
	}


	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return UncertaintyEditPlugin.INSTANCE;
	}

}
