package dev.abunai.confidentiality.analysis.pcm;

import java.util.List;
import java.util.stream.Collectors;

import org.dataflowanalysis.analysis.core.AbstractVertex;
import org.dataflowanalysis.analysis.pcm.core.AbstractPCMVertex;
import org.dataflowanalysis.analysis.pcm.core.seff.SEFFPCMVertex;
import org.dataflowanalysis.analysis.pcm.core.user.CallingUserPCMVertex;
import org.dataflowanalysis.analysis.pcm.resource.PCMResourceProvider;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.allocation.AllocationContext;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.OperationSignature;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF;
import org.palladiosimulator.pcm.seff.ServiceEffectSpecification;
import org.palladiosimulator.pcm.seff.StartAction;

import dev.abunai.confidentiality.analysis.core.UncertaintyUtils;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMBehaviorUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMComponentUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInEntryLevelSystemCall;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMConnectorUncertaintySourceInExternalCall;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySourceInResource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMExternalUncertaintySourceInUsage;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMInterfaceUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMUncertaintySource;

public class PCMQueryHelper {
	private final List<? extends AbstractVertex<?>> vertices;
	private final PCMResourceProvider resourceProvider;

	/**
	 * Creates a new pcm query helper with the given list of vertices and a resource provider
	 * @param vertices List of vertices that are used in the queries
	 * @param resourceProvider Resource provider used to access the model
	 */
	public PCMQueryHelper(List<? extends AbstractVertex<?>> vertices, PCMResourceProvider resourceProvider) {
		this.vertices = vertices;
		this.resourceProvider = resourceProvider;
	}

	/**
	 * Determines whether the given uncertainty source has a target node in the list of vertices
	 * @param uncertaintySource Uncertainty source
	 * @return 	Returns true, if at least one vertex is affected by the uncertainty source.
	 * 			Otherwise, the method returns false
	 */
	public boolean hasTargetNode(PCMUncertaintySource uncertaintySource) {
		return !this.findTargetNodes(uncertaintySource).isEmpty();
	}

	/**
	 * Determines the list of targeted vertices by a given uncertainty source
	 * @param source Given uncertainty source of which the targeted nodes should be found
	 * @return Returns a list of vertices that are targeted by the given uncertainty source
	 */
	public List<? extends AbstractPCMVertex<?>> findTargetNodes(PCMUncertaintySource source) {
		if (source instanceof PCMExternalUncertaintySourceInResource castedSource) {
			return this.findTargetNodesOfExternalUncertaintyInResource(castedSource);
		} else if (source instanceof PCMExternalUncertaintySourceInUsage castedSource) {
			return this.findTargetNodesOfExternalUncertaintyInUsage(castedSource);
		} else if (source instanceof PCMBehaviorUncertaintySource castedSource) {
			return this.findTargetNodesOfBehaviourUncertainty(castedSource);
		} else if (source instanceof PCMInterfaceUncertaintySource castedSource) {
			return this.findTargetNodesOfInterfaceUncertainty(castedSource);
		} else if (source instanceof PCMConnectorUncertaintySourceInExternalCall castedSource) {
			return this.findTargetNodesOfConnectorUncertaintyInExternalCall(castedSource);
		} else if (source instanceof PCMConnectorUncertaintySourceInEntryLevelSystemCall castedSource) {
			return this.findTargetNodesOfConnectorUncertaintySourceInEntryLevelSystemCall(castedSource);
		} else if (source instanceof PCMComponentUncertaintySource castedSource) {
			return this.findTargetNodesOfComponentUncertainty(castedSource);
		} else {
			throw new IllegalArgumentException("Unsupported uncertainty source: %s."
					.formatted(UncertaintyUtils.getUncertaintySourceName(source)));
		}
	}

	/**
	 * Determines the targeted nodes of a component uncertainty
	 * @param castedSource Given uncertainty
	 * @return Returns a list of all nodes that are targeted by the uncertainty
	 */
	private List<? extends AbstractPCMVertex<?>> findTargetNodesOfComponentUncertainty(
			PCMComponentUncertaintySource castedSource) {
		return this.vertices.stream()
				.filter(SEFFPCMVertex.class::isInstance)
				.map(it -> (SEFFPCMVertex<?>) it)
				.filter(it -> it.getReferencedElement() instanceof StartAction)
				.filter(it -> it.getContext().contains(castedSource.getTarget()))
				.collect(Collectors.toList());
	}

	/**
	 * Determines the targeted nodes of a connector uncertainty in entry level system call
	 * @param castedSource Given uncertainty
	 * @return Returns a list of all nodes that are targeted by the uncertainty
	 */
	private List<? extends AbstractPCMVertex<?>> findTargetNodesOfConnectorUncertaintySourceInEntryLevelSystemCall(
			PCMConnectorUncertaintySourceInEntryLevelSystemCall castedSource) {
		return this.vertices.stream()
				.filter(it -> it.getReferencedElement().equals(castedSource.getTarget()))
				.map(it -> (AbstractPCMVertex<?>) it)
				.toList();
	}

	/**
	 * Determines the targeted nodes of a connector uncertainty in an external call
	 * @param castedSource Given uncertainty
	 * @return Returns a list of all nodes that are targeted by the uncertainty
	 */
	private List<? extends AbstractPCMVertex<?>> findTargetNodesOfConnectorUncertaintyInExternalCall(
			PCMConnectorUncertaintySourceInExternalCall castedSource) {
		return this.vertices.stream()
				.filter(it -> it.getReferencedElement().equals(castedSource.getTarget()))
				.map(it -> (AbstractPCMVertex<?>) it)
				.toList();
	}

	/**
	 * Determines the targeted nodes of an interface uncertainty
	 * @param castedSource Given uncertainty
	 * @return Returns a list of all nodes that are targeted by the uncertainty
	 */
	private List<? extends AbstractPCMVertex<?>> findTargetNodesOfInterfaceUncertainty(
			PCMInterfaceUncertaintySource castedSource) {
		return this.vertices.stream()
				.filter(it -> it instanceof SEFFPCMVertex<?>)
				.map(it -> (SEFFPCMVertex<?>) it)
				.filter(it -> it.getReferencedElement() instanceof StartAction)
				.filter(it -> it.getReferencedElement().eContainer() instanceof ResourceDemandingSEFF)
				.filter(it -> this.implementsInterface(it, castedSource.getTarget()))
				.toList();
	}

	/**
	 * Determines whether a vertex calls against the given signature
	 * @param vertex Vertex that is checked
	 * @param signature Signature that is called against
	 * @return 	Returns true, if the vertex calls against that signature.
	 * 			Otherwise, the method returns false
	 */
	private boolean implementsInterface(SEFFPCMVertex<?> vertex, OperationSignature signature) {
		if (!(vertex.getReferencedElement().eContainer() instanceof ServiceEffectSpecification seff)) {
			return false;
		}
		return signature.equals(seff.getDescribedService__SEFF());
	}


	/**
	 * Determines the targeted nodes of a behavior uncertainty
	 * @param castedSource Given uncertainty
	 * @return Returns a list of all nodes that are targeted by the uncertainty
	 */
	private List<? extends AbstractPCMVertex<?>> findTargetNodesOfBehaviourUncertainty(
			PCMBehaviorUncertaintySource castedSource) {
		return this.vertices.stream()
				.filter(it -> it.getReferencedElement().equals(castedSource.getTarget()))
				.map(it -> (AbstractPCMVertex<?>) it)
				.toList();
	}

	/**
	 * Determines the targeted nodes of an external uncertainty in the usage scenario
	 * @param castedSource Given uncertainty
	 * @return Returns a list of all nodes that are targeted by the uncertainty
	 */
	private List<? extends AbstractPCMVertex<?>> findTargetNodesOfExternalUncertaintyInUsage(
			PCMExternalUncertaintySourceInUsage castedSource) {
		return this.vertices.stream()
				.filter(CallingUserPCMVertex.class::isInstance)
				.map(CallingUserPCMVertex.class::cast)
				.filter(it -> it.getReferencedElement().getScenarioBehaviour_AbstractUserAction().getUsageScenario_SenarioBehaviour() != null)
				.filter(it -> it.getReferencedElement().getScenarioBehaviour_AbstractUserAction().getUsageScenario_SenarioBehaviour().equals(castedSource.getTarget().getUsagescenario()))
				.toList();
	}

	/**
	 * Determines the targeted nodes of an external uncertainty in the resource environment
	 * @param castedSource Given uncertainty
	 * @return Returns a list of all nodes that are targeted by the uncertainty
	 */
	private List<? extends AbstractPCMVertex<?>> findTargetNodesOfExternalUncertaintyInResource(
			PCMExternalUncertaintySourceInResource castedSource) {
		return this.vertices.stream()
				.filter(it -> it instanceof SEFFPCMVertex<?>)
				.map(it -> (SEFFPCMVertex<?>) it)
				.filter(it -> it.getContext().stream().anyMatch(this.getDeployedContexts(castedSource.getTarget().getResourcecontainer())::contains))
				.toList();
	}

	/**
	 * Determines all assembly contexts of the given resource container
	 * @param resourceContainer Given resource container of which the assembly context should be calculated
	 * @return Returns a list of all deployed assembly contexts of a resource container
	 */
	private List<AssemblyContext> getDeployedContexts(ResourceContainer resourceContainer) {
		Allocation allocation = this.resourceProvider.getAllocation();
		return allocation.getAllocationContexts_Allocation().stream()
				.filter(it -> it.getResourceContainer_AllocationContext().equals(resourceContainer))
				.map(AllocationContext::getAssemblyContext_AllocationContext)
				.toList();
	}
}
