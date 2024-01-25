/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.presentation;

import de.uka.ipd.sdq.identifier.provider.IdentifierEditPlugin;

import de.uka.ipd.sdq.probfunction.provider.ProbabilityFunctionEditPlugin;

import de.uka.ipd.sdq.stoex.provider.StoexEditPlugin;

import de.uka.ipd.sdq.units.provider.UnitsEditPlugin;

import org.dataflowanalysis.dfd.dataflowdiagram.provider.DataFlowDiagramEditPlugin;

import org.dataflowanalysis.pcm.extension.dictionary.DataDictionary.provider.DataDictionaryEditPlugin;

import org.dataflowanalysis.pcm.extension.dictionary.characterized.DataDictionaryCharacterized.provider.DataDictionaryCharacterizedEditPlugin;

import org.dataflowanalysis.pcm.extension.model.confidentiality.provider.DataFlowConfidentialityEditPlugin;

import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.provider.NodeCharacteristicsEditPlugin;

import org.eclipse.emf.common.EMFPlugin;

import org.eclipse.emf.common.ui.EclipseUIPlugin;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.provider.EcoreEditPlugin;

import org.palladiosimulator.pcm.core.provider.PalladioComponentModelEditPlugin;

import tools.mdsd.modelingfoundations.identifier.provider.ModelEditPlugin;

/**
 * This is the central singleton for the Uncertainty editor plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class UncertaintyEditorPlugin extends EMFPlugin {
	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final UncertaintyEditorPlugin INSTANCE = new UncertaintyEditorPlugin();
	
	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static Implementation plugin;

	/**
	 * Create the instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UncertaintyEditorPlugin() {
		super
			(new ResourceLocator [] {
				DataDictionaryEditPlugin.INSTANCE,
				DataDictionaryCharacterizedEditPlugin.INSTANCE,
				DataFlowConfidentialityEditPlugin.INSTANCE,
				EcoreEditPlugin.INSTANCE,
				IdentifierEditPlugin.INSTANCE,
				NodeCharacteristicsEditPlugin.INSTANCE,
				PalladioComponentModelEditPlugin.INSTANCE,
				ProbabilityFunctionEditPlugin.INSTANCE,
				StoexEditPlugin.INSTANCE,
				UnitsEditPlugin.INSTANCE,
				ModelEditPlugin.INSTANCE,
				org.dataflowanalysis.dfd.datadictionary.provider.DataDictionaryEditPlugin.INSTANCE,
				DataFlowDiagramEditPlugin.INSTANCE,
			});
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}
	
	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	public static Implementation getPlugin() {
		return plugin;
	}
	
	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class Implementation extends EclipseUIPlugin {
		/**
		 * Creates an instance.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public Implementation() {
			super();
	
			// Remember the static instance.
			//
			plugin = this;
		}
	}

}
