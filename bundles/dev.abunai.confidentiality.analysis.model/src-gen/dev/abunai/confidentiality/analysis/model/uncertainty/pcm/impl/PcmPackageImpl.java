/**
 */
package dev.abunai.confidentiality.analysis.model.uncertainty.pcm.impl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;

import de.uka.ipd.sdq.stoex.StoexPackage;

import de.uka.ipd.sdq.units.UnitsPackage;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage;

import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DfdPackage;

import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.impl.DfdPackageImpl;

import dev.abunai.confidentiality.analysis.model.uncertainty.impl.UncertaintyPackageImpl;

import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMBehaviorUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMBehaviorUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMComponentUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMComponentUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintyScenarioInEntryLevelSystemCall;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintyScenarioInExternalCall;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInEntryLevelSystemCall;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInExternalCall;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintyScenarioInResource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintyScenarioInUsage;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySourceInResource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySourceInUsage;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMInterfaceUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMInterfaceUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmFactory;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage;

import org.dataflowanalysis.dfd.datadictionary.datadictionaryPackage;

import org.dataflowanalysis.dfd.dataflowdiagram.dataflowdiagramPackage;

import org.dataflowanalysis.pcm.extension.dictionary.DataDictionary.DataDictionaryPackage;

import org.dataflowanalysis.pcm.extension.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage;

import org.dataflowanalysis.pcm.extension.model.confidentiality.ConfidentialityPackage;

import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.NodeCharacteristicsPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.palladiosimulator.pcm.core.composition.CompositionPackage;

import org.palladiosimulator.pcm.repository.RepositoryPackage;

import org.palladiosimulator.pcm.seff.SeffPackage;

import org.palladiosimulator.pcm.usagemodel.UsagemodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PcmPackageImpl extends EPackageImpl implements PcmPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmUncertaintySourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmExternalUncertaintySourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmExternalUncertaintySourceInResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmExternalUncertaintySourceInUsageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmExternalUncertaintyScenarioInResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmExternalUncertaintyScenarioInUsageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmBehaviorUncertaintySourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmBehaviorUncertaintyScenarioEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmInterfaceUncertaintySourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmInterfaceUncertaintyScenarioEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmConnectorUncertaintySourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmConnectorUncertaintySourceInExternalCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmConnectorUncertaintySourceInEntryLevelSystemCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmConnectorUncertaintyScenarioInExternalCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmConnectorUncertaintyScenarioInEntryLevelSystemCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmComponentUncertaintySourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmComponentUncertaintyScenarioEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PcmPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PcmPackageImpl() {
		super(eNS_URI, PcmFactory.eINSTANCE);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link PcmPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PcmPackage init() {
		if (isInited) return (PcmPackage)EPackage.Registry.INSTANCE.getEPackage(PcmPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredPcmPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		PcmPackageImpl thePcmPackage = registeredPcmPackage instanceof PcmPackageImpl ? (PcmPackageImpl)registeredPcmPackage : new PcmPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		DataDictionaryPackage.eINSTANCE.eClass();
		DataDictionaryCharacterizedPackage.eINSTANCE.eClass();
		ConfidentialityPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		IdentifierPackage.eINSTANCE.eClass();
		NodeCharacteristicsPackage.eINSTANCE.eClass();
		org.palladiosimulator.pcm.PcmPackage.eINSTANCE.eClass();
		ProbfunctionPackage.eINSTANCE.eClass();
		StoexPackage.eINSTANCE.eClass();
		UnitsPackage.eINSTANCE.eClass();
		tools.mdsd.modelingfoundations.identifier.IdentifierPackage.eINSTANCE.eClass();
		datadictionaryPackage.eINSTANCE.eClass();
		dataflowdiagramPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(UncertaintyPackage.eNS_URI);
		UncertaintyPackageImpl theUncertaintyPackage = (UncertaintyPackageImpl)(registeredPackage instanceof UncertaintyPackageImpl ? registeredPackage : UncertaintyPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(DfdPackage.eNS_URI);
		DfdPackageImpl theDfdPackage = (DfdPackageImpl)(registeredPackage instanceof DfdPackageImpl ? registeredPackage : DfdPackage.eINSTANCE);

		// Create package meta-data objects
		thePcmPackage.createPackageContents();
		theUncertaintyPackage.createPackageContents();
		theDfdPackage.createPackageContents();

		// Initialize created meta-data
		thePcmPackage.initializePackageContents();
		theUncertaintyPackage.initializePackageContents();
		theDfdPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePcmPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PcmPackage.eNS_URI, thePcmPackage);
		return thePcmPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMUncertaintySource() {
		return pcmUncertaintySourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMExternalUncertaintySource() {
		return pcmExternalUncertaintySourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMExternalUncertaintySourceInResource() {
		return pcmExternalUncertaintySourceInResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMExternalUncertaintySourceInResource_Target() {
		return (EReference)pcmExternalUncertaintySourceInResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMExternalUncertaintySourceInResource_Scenarios() {
		return (EReference)pcmExternalUncertaintySourceInResourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMExternalUncertaintySourceInUsage() {
		return pcmExternalUncertaintySourceInUsageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMExternalUncertaintySourceInUsage_Target() {
		return (EReference)pcmExternalUncertaintySourceInUsageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMExternalUncertaintySourceInUsage_Scenarios() {
		return (EReference)pcmExternalUncertaintySourceInUsageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMExternalUncertaintyScenarioInResource() {
		return pcmExternalUncertaintyScenarioInResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMExternalUncertaintyScenarioInResource_Target() {
		return (EReference)pcmExternalUncertaintyScenarioInResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMExternalUncertaintyScenarioInUsage() {
		return pcmExternalUncertaintyScenarioInUsageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMExternalUncertaintyScenarioInUsage_Target() {
		return (EReference)pcmExternalUncertaintyScenarioInUsageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMBehaviorUncertaintySource() {
		return pcmBehaviorUncertaintySourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMBehaviorUncertaintySource_Target() {
		return (EReference)pcmBehaviorUncertaintySourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMBehaviorUncertaintySource_Scenarios() {
		return (EReference)pcmBehaviorUncertaintySourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMBehaviorUncertaintyScenario() {
		return pcmBehaviorUncertaintyScenarioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMBehaviorUncertaintyScenario_Target() {
		return (EReference)pcmBehaviorUncertaintyScenarioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMInterfaceUncertaintySource() {
		return pcmInterfaceUncertaintySourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMInterfaceUncertaintySource_Target() {
		return (EReference)pcmInterfaceUncertaintySourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMInterfaceUncertaintySource_Scenarios() {
		return (EReference)pcmInterfaceUncertaintySourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMInterfaceUncertaintyScenario() {
		return pcmInterfaceUncertaintyScenarioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMInterfaceUncertaintyScenario_Target() {
		return (EReference)pcmInterfaceUncertaintyScenarioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMConnectorUncertaintySource() {
		return pcmConnectorUncertaintySourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMConnectorUncertaintySourceInExternalCall() {
		return pcmConnectorUncertaintySourceInExternalCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMConnectorUncertaintySourceInExternalCall_Target() {
		return (EReference)pcmConnectorUncertaintySourceInExternalCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMConnectorUncertaintySourceInExternalCall_Scenarios() {
		return (EReference)pcmConnectorUncertaintySourceInExternalCallEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMConnectorUncertaintySourceInEntryLevelSystemCall() {
		return pcmConnectorUncertaintySourceInEntryLevelSystemCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMConnectorUncertaintySourceInEntryLevelSystemCall_Target() {
		return (EReference)pcmConnectorUncertaintySourceInEntryLevelSystemCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMConnectorUncertaintySourceInEntryLevelSystemCall_Scenarios() {
		return (EReference)pcmConnectorUncertaintySourceInEntryLevelSystemCallEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMConnectorUncertaintyScenarioInExternalCall() {
		return pcmConnectorUncertaintyScenarioInExternalCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMConnectorUncertaintyScenarioInExternalCall_Target() {
		return (EReference)pcmConnectorUncertaintyScenarioInExternalCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMConnectorUncertaintyScenarioInEntryLevelSystemCall() {
		return pcmConnectorUncertaintyScenarioInEntryLevelSystemCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMConnectorUncertaintyScenarioInEntryLevelSystemCall_Target() {
		return (EReference)pcmConnectorUncertaintyScenarioInEntryLevelSystemCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMComponentUncertaintySource() {
		return pcmComponentUncertaintySourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMComponentUncertaintySource_Target() {
		return (EReference)pcmComponentUncertaintySourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMComponentUncertaintySource_Scenarios() {
		return (EReference)pcmComponentUncertaintySourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMComponentUncertaintyScenario() {
		return pcmComponentUncertaintyScenarioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMComponentUncertaintyScenario_Target() {
		return (EReference)pcmComponentUncertaintyScenarioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PcmFactory getPcmFactory() {
		return (PcmFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		pcmUncertaintySourceEClass = createEClass(PCM_UNCERTAINTY_SOURCE);

		pcmExternalUncertaintySourceEClass = createEClass(PCM_EXTERNAL_UNCERTAINTY_SOURCE);

		pcmExternalUncertaintySourceInResourceEClass = createEClass(PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE);
		createEReference(pcmExternalUncertaintySourceInResourceEClass, PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE__TARGET);
		createEReference(pcmExternalUncertaintySourceInResourceEClass, PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_RESOURCE__SCENARIOS);

		pcmExternalUncertaintySourceInUsageEClass = createEClass(PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE);
		createEReference(pcmExternalUncertaintySourceInUsageEClass, PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__TARGET);
		createEReference(pcmExternalUncertaintySourceInUsageEClass, PCM_EXTERNAL_UNCERTAINTY_SOURCE_IN_USAGE__SCENARIOS);

		pcmExternalUncertaintyScenarioInResourceEClass = createEClass(PCM_EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE);
		createEReference(pcmExternalUncertaintyScenarioInResourceEClass, PCM_EXTERNAL_UNCERTAINTY_SCENARIO_IN_RESOURCE__TARGET);

		pcmExternalUncertaintyScenarioInUsageEClass = createEClass(PCM_EXTERNAL_UNCERTAINTY_SCENARIO_IN_USAGE);
		createEReference(pcmExternalUncertaintyScenarioInUsageEClass, PCM_EXTERNAL_UNCERTAINTY_SCENARIO_IN_USAGE__TARGET);

		pcmBehaviorUncertaintySourceEClass = createEClass(PCM_BEHAVIOR_UNCERTAINTY_SOURCE);
		createEReference(pcmBehaviorUncertaintySourceEClass, PCM_BEHAVIOR_UNCERTAINTY_SOURCE__TARGET);
		createEReference(pcmBehaviorUncertaintySourceEClass, PCM_BEHAVIOR_UNCERTAINTY_SOURCE__SCENARIOS);

		pcmBehaviorUncertaintyScenarioEClass = createEClass(PCM_BEHAVIOR_UNCERTAINTY_SCENARIO);
		createEReference(pcmBehaviorUncertaintyScenarioEClass, PCM_BEHAVIOR_UNCERTAINTY_SCENARIO__TARGET);

		pcmInterfaceUncertaintySourceEClass = createEClass(PCM_INTERFACE_UNCERTAINTY_SOURCE);
		createEReference(pcmInterfaceUncertaintySourceEClass, PCM_INTERFACE_UNCERTAINTY_SOURCE__TARGET);
		createEReference(pcmInterfaceUncertaintySourceEClass, PCM_INTERFACE_UNCERTAINTY_SOURCE__SCENARIOS);

		pcmInterfaceUncertaintyScenarioEClass = createEClass(PCM_INTERFACE_UNCERTAINTY_SCENARIO);
		createEReference(pcmInterfaceUncertaintyScenarioEClass, PCM_INTERFACE_UNCERTAINTY_SCENARIO__TARGET);

		pcmConnectorUncertaintySourceEClass = createEClass(PCM_CONNECTOR_UNCERTAINTY_SOURCE);

		pcmConnectorUncertaintySourceInExternalCallEClass = createEClass(PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL);
		createEReference(pcmConnectorUncertaintySourceInExternalCallEClass, PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL__TARGET);
		createEReference(pcmConnectorUncertaintySourceInExternalCallEClass, PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_EXTERNAL_CALL__SCENARIOS);

		pcmConnectorUncertaintySourceInEntryLevelSystemCallEClass = createEClass(PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL);
		createEReference(pcmConnectorUncertaintySourceInEntryLevelSystemCallEClass, PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL__TARGET);
		createEReference(pcmConnectorUncertaintySourceInEntryLevelSystemCallEClass, PCM_CONNECTOR_UNCERTAINTY_SOURCE_IN_ENTRY_LEVEL_SYSTEM_CALL__SCENARIOS);

		pcmConnectorUncertaintyScenarioInExternalCallEClass = createEClass(PCM_CONNECTOR_UNCERTAINTY_SCENARIO_IN_EXTERNAL_CALL);
		createEReference(pcmConnectorUncertaintyScenarioInExternalCallEClass, PCM_CONNECTOR_UNCERTAINTY_SCENARIO_IN_EXTERNAL_CALL__TARGET);

		pcmConnectorUncertaintyScenarioInEntryLevelSystemCallEClass = createEClass(PCM_CONNECTOR_UNCERTAINTY_SCENARIO_IN_ENTRY_LEVEL_SYSTEM_CALL);
		createEReference(pcmConnectorUncertaintyScenarioInEntryLevelSystemCallEClass, PCM_CONNECTOR_UNCERTAINTY_SCENARIO_IN_ENTRY_LEVEL_SYSTEM_CALL__TARGET);

		pcmComponentUncertaintySourceEClass = createEClass(PCM_COMPONENT_UNCERTAINTY_SOURCE);
		createEReference(pcmComponentUncertaintySourceEClass, PCM_COMPONENT_UNCERTAINTY_SOURCE__TARGET);
		createEReference(pcmComponentUncertaintySourceEClass, PCM_COMPONENT_UNCERTAINTY_SOURCE__SCENARIOS);

		pcmComponentUncertaintyScenarioEClass = createEClass(PCM_COMPONENT_UNCERTAINTY_SCENARIO);
		createEReference(pcmComponentUncertaintyScenarioEClass, PCM_COMPONENT_UNCERTAINTY_SCENARIO__TARGET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		UncertaintyPackage theUncertaintyPackage = (UncertaintyPackage)EPackage.Registry.INSTANCE.getEPackage(UncertaintyPackage.eNS_URI);
		NodeCharacteristicsPackage theNodeCharacteristicsPackage = (NodeCharacteristicsPackage)EPackage.Registry.INSTANCE.getEPackage(NodeCharacteristicsPackage.eNS_URI);
		SeffPackage theSeffPackage = (SeffPackage)EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI);
		RepositoryPackage theRepositoryPackage = (RepositoryPackage)EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI);
		UsagemodelPackage theUsagemodelPackage = (UsagemodelPackage)EPackage.Registry.INSTANCE.getEPackage(UsagemodelPackage.eNS_URI);
		CompositionPackage theCompositionPackage = (CompositionPackage)EPackage.Registry.INSTANCE.getEPackage(CompositionPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		pcmUncertaintySourceEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintySource());
		pcmExternalUncertaintySourceEClass.getESuperTypes().add(this.getPCMUncertaintySource());
		pcmExternalUncertaintySourceInResourceEClass.getESuperTypes().add(this.getPCMExternalUncertaintySource());
		pcmExternalUncertaintySourceInUsageEClass.getESuperTypes().add(this.getPCMExternalUncertaintySource());
		pcmExternalUncertaintyScenarioInResourceEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintyScenario());
		pcmExternalUncertaintyScenarioInUsageEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintyScenario());
		pcmBehaviorUncertaintySourceEClass.getESuperTypes().add(this.getPCMUncertaintySource());
		pcmBehaviorUncertaintyScenarioEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintyScenario());
		pcmInterfaceUncertaintySourceEClass.getESuperTypes().add(this.getPCMUncertaintySource());
		pcmInterfaceUncertaintyScenarioEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintyScenario());
		pcmConnectorUncertaintySourceEClass.getESuperTypes().add(this.getPCMUncertaintySource());
		pcmConnectorUncertaintySourceInExternalCallEClass.getESuperTypes().add(this.getPCMConnectorUncertaintySource());
		pcmConnectorUncertaintySourceInEntryLevelSystemCallEClass.getESuperTypes().add(this.getPCMConnectorUncertaintySource());
		pcmConnectorUncertaintyScenarioInExternalCallEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintyScenario());
		pcmConnectorUncertaintyScenarioInEntryLevelSystemCallEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintyScenario());
		pcmComponentUncertaintySourceEClass.getESuperTypes().add(this.getPCMUncertaintySource());
		pcmComponentUncertaintyScenarioEClass.getESuperTypes().add(theUncertaintyPackage.getUncertaintyScenario());

		// Initialize classes, features, and operations; add parameters
		initEClass(pcmUncertaintySourceEClass, PCMUncertaintySource.class, "PCMUncertaintySource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pcmExternalUncertaintySourceEClass, PCMExternalUncertaintySource.class, "PCMExternalUncertaintySource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pcmExternalUncertaintySourceInResourceEClass, PCMExternalUncertaintySourceInResource.class, "PCMExternalUncertaintySourceInResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCMExternalUncertaintySourceInResource_Target(), theNodeCharacteristicsPackage.getResourceAssignee(), null, "target", null, 1, 1, PCMExternalUncertaintySourceInResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPCMExternalUncertaintySourceInResource_Scenarios(), this.getPCMExternalUncertaintyScenarioInResource(), null, "scenarios", null, 0, -1, PCMExternalUncertaintySourceInResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pcmExternalUncertaintySourceInUsageEClass, PCMExternalUncertaintySourceInUsage.class, "PCMExternalUncertaintySourceInUsage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCMExternalUncertaintySourceInUsage_Target(), theNodeCharacteristicsPackage.getUsageAssignee(), null, "target", null, 1, 1, PCMExternalUncertaintySourceInUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPCMExternalUncertaintySourceInUsage_Scenarios(), this.getPCMExternalUncertaintyScenarioInUsage(), null, "scenarios", null, 0, -1, PCMExternalUncertaintySourceInUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pcmExternalUncertaintyScenarioInResourceEClass, PCMExternalUncertaintyScenarioInResource.class, "PCMExternalUncertaintyScenarioInResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCMExternalUncertaintyScenarioInResource_Target(), theNodeCharacteristicsPackage.getResourceAssignee(), null, "target", null, 1, 1, PCMExternalUncertaintyScenarioInResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pcmExternalUncertaintyScenarioInUsageEClass, PCMExternalUncertaintyScenarioInUsage.class, "PCMExternalUncertaintyScenarioInUsage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCMExternalUncertaintyScenarioInUsage_Target(), theNodeCharacteristicsPackage.getUsageAssignee(), null, "target", null, 1, 1, PCMExternalUncertaintyScenarioInUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pcmBehaviorUncertaintySourceEClass, PCMBehaviorUncertaintySource.class, "PCMBehaviorUncertaintySource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCMBehaviorUncertaintySource_Target(), theSeffPackage.getSetVariableAction(), null, "target", null, 1, 1, PCMBehaviorUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPCMBehaviorUncertaintySource_Scenarios(), this.getPCMBehaviorUncertaintyScenario(), null, "scenarios", null, 0, -1, PCMBehaviorUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pcmBehaviorUncertaintyScenarioEClass, PCMBehaviorUncertaintyScenario.class, "PCMBehaviorUncertaintyScenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCMBehaviorUncertaintyScenario_Target(), theSeffPackage.getSetVariableAction(), null, "target", null, 1, 1, PCMBehaviorUncertaintyScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pcmInterfaceUncertaintySourceEClass, PCMInterfaceUncertaintySource.class, "PCMInterfaceUncertaintySource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCMInterfaceUncertaintySource_Target(), theRepositoryPackage.getOperationSignature(), null, "target", null, 1, 1, PCMInterfaceUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPCMInterfaceUncertaintySource_Scenarios(), this.getPCMInterfaceUncertaintyScenario(), null, "scenarios", null, 0, -1, PCMInterfaceUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pcmInterfaceUncertaintyScenarioEClass, PCMInterfaceUncertaintyScenario.class, "PCMInterfaceUncertaintyScenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCMInterfaceUncertaintyScenario_Target(), theRepositoryPackage.getOperationSignature(), null, "target", null, 1, 1, PCMInterfaceUncertaintyScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pcmConnectorUncertaintySourceEClass, PCMConnectorUncertaintySource.class, "PCMConnectorUncertaintySource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pcmConnectorUncertaintySourceInExternalCallEClass, PCMConnectorUncertaintySourceInExternalCall.class, "PCMConnectorUncertaintySourceInExternalCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCMConnectorUncertaintySourceInExternalCall_Target(), theSeffPackage.getExternalCallAction(), null, "target", null, 1, 1, PCMConnectorUncertaintySourceInExternalCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPCMConnectorUncertaintySourceInExternalCall_Scenarios(), this.getPCMConnectorUncertaintyScenarioInExternalCall(), null, "scenarios", null, 0, -1, PCMConnectorUncertaintySourceInExternalCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pcmConnectorUncertaintySourceInEntryLevelSystemCallEClass, PCMConnectorUncertaintySourceInEntryLevelSystemCall.class, "PCMConnectorUncertaintySourceInEntryLevelSystemCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCMConnectorUncertaintySourceInEntryLevelSystemCall_Target(), theUsagemodelPackage.getEntryLevelSystemCall(), null, "target", null, 1, 1, PCMConnectorUncertaintySourceInEntryLevelSystemCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPCMConnectorUncertaintySourceInEntryLevelSystemCall_Scenarios(), this.getPCMConnectorUncertaintyScenarioInEntryLevelSystemCall(), null, "scenarios", null, 0, -1, PCMConnectorUncertaintySourceInEntryLevelSystemCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pcmConnectorUncertaintyScenarioInExternalCallEClass, PCMConnectorUncertaintyScenarioInExternalCall.class, "PCMConnectorUncertaintyScenarioInExternalCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCMConnectorUncertaintyScenarioInExternalCall_Target(), theSeffPackage.getExternalCallAction(), null, "target", null, 1, 1, PCMConnectorUncertaintyScenarioInExternalCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pcmConnectorUncertaintyScenarioInEntryLevelSystemCallEClass, PCMConnectorUncertaintyScenarioInEntryLevelSystemCall.class, "PCMConnectorUncertaintyScenarioInEntryLevelSystemCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCMConnectorUncertaintyScenarioInEntryLevelSystemCall_Target(), theUsagemodelPackage.getEntryLevelSystemCall(), null, "target", null, 1, 1, PCMConnectorUncertaintyScenarioInEntryLevelSystemCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pcmComponentUncertaintySourceEClass, PCMComponentUncertaintySource.class, "PCMComponentUncertaintySource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCMComponentUncertaintySource_Target(), theCompositionPackage.getAssemblyContext(), null, "target", null, 1, 1, PCMComponentUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPCMComponentUncertaintySource_Scenarios(), this.getPCMComponentUncertaintyScenario(), null, "scenarios", null, 0, -1, PCMComponentUncertaintySource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pcmComponentUncertaintyScenarioEClass, PCMComponentUncertaintyScenario.class, "PCMComponentUncertaintyScenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCMComponentUncertaintyScenario_Target(), theCompositionPackage.getAssemblyContext(), null, "target", null, 1, 1, PCMComponentUncertaintyScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //PcmPackageImpl
