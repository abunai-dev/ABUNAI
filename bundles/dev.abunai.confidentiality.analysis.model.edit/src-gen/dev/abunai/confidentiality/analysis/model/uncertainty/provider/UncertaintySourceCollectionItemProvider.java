/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.provider;


import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySourceCollection;

import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdFactory;

import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmFactory;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import tools.mdsd.modelingfoundations.identifier.provider.EntityItemProvider;

/**
 * This is the item provider adapter for a {@link dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySourceCollection} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class UncertaintySourceCollectionItemProvider extends EntityItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UncertaintySourceCollectionItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(UncertaintyPackage.Literals.UNCERTAINTY_SOURCE_COLLECTION__SOURCES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns UncertaintySourceCollection.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/UncertaintySourceCollection"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((UncertaintySourceCollection)object).getEntityName();
		return label == null || label.length() == 0 ?
			getString("_UI_UncertaintySourceCollection_type") :
			getString("_UI_UncertaintySourceCollection_type") + " " + label;
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

		switch (notification.getFeatureID(UncertaintySourceCollection.class)) {
			case UncertaintyPackage.UNCERTAINTY_SOURCE_COLLECTION__SOURCES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
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

		newChildDescriptors.add
			(createChildParameter
				(UncertaintyPackage.Literals.UNCERTAINTY_SOURCE_COLLECTION__SOURCES,
				 PcmFactory.eINSTANCE.createPCMExternalUncertaintySourceInResource()));

		newChildDescriptors.add
			(createChildParameter
				(UncertaintyPackage.Literals.UNCERTAINTY_SOURCE_COLLECTION__SOURCES,
				 PcmFactory.eINSTANCE.createPCMExternalUncertaintySourceInUsage()));

		newChildDescriptors.add
			(createChildParameter
				(UncertaintyPackage.Literals.UNCERTAINTY_SOURCE_COLLECTION__SOURCES,
				 PcmFactory.eINSTANCE.createPCMBehaviorUncertaintySource()));

		newChildDescriptors.add
			(createChildParameter
				(UncertaintyPackage.Literals.UNCERTAINTY_SOURCE_COLLECTION__SOURCES,
				 PcmFactory.eINSTANCE.createPCMInterfaceUncertaintySource()));

		newChildDescriptors.add
			(createChildParameter
				(UncertaintyPackage.Literals.UNCERTAINTY_SOURCE_COLLECTION__SOURCES,
				 PcmFactory.eINSTANCE.createPCMConnectorUncertaintySourceInExternalCall()));

		newChildDescriptors.add
			(createChildParameter
				(UncertaintyPackage.Literals.UNCERTAINTY_SOURCE_COLLECTION__SOURCES,
				 PcmFactory.eINSTANCE.createPCMConnectorUncertaintySourceInEntryLevelSystemCall()));

		newChildDescriptors.add
			(createChildParameter
				(UncertaintyPackage.Literals.UNCERTAINTY_SOURCE_COLLECTION__SOURCES,
				 PcmFactory.eINSTANCE.createPCMComponentUncertaintySource()));

		newChildDescriptors.add
			(createChildParameter
				(UncertaintyPackage.Literals.UNCERTAINTY_SOURCE_COLLECTION__SOURCES,
				 DfdFactory.eINSTANCE.createDFDExternalUncertaintySource()));

		newChildDescriptors.add
			(createChildParameter
				(UncertaintyPackage.Literals.UNCERTAINTY_SOURCE_COLLECTION__SOURCES,
				 DfdFactory.eINSTANCE.createDFDBehaviorUncertaintySource()));

		newChildDescriptors.add
			(createChildParameter
				(UncertaintyPackage.Literals.UNCERTAINTY_SOURCE_COLLECTION__SOURCES,
				 DfdFactory.eINSTANCE.createDFDInterfaceUncertaintySource()));

		newChildDescriptors.add
			(createChildParameter
				(UncertaintyPackage.Literals.UNCERTAINTY_SOURCE_COLLECTION__SOURCES,
				 DfdFactory.eINSTANCE.createDFDConnectorUncertaintySource()));

		newChildDescriptors.add
			(createChildParameter
				(UncertaintyPackage.Literals.UNCERTAINTY_SOURCE_COLLECTION__SOURCES,
				 DfdFactory.eINSTANCE.createDFDComponentUncertaintySource()));
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
