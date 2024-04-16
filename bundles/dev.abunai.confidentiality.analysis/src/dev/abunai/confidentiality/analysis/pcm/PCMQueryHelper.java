package dev.abunai.confidentiality.analysis.pcm;

import java.util.List;
import java.util.stream.Collectors;

import org.dataflowanalysis.analysis.core.AbstractVertex;
import org.dataflowanalysis.analysis.pcm.core.AbstractPCMVertex;
import org.dataflowanalysis.analysis.pcm.core.seff.SEFFPCMVertex;
import org.dataflowanalysis.analysis.pcm.core.user.CallingUserPCMVertex;
import org.dataflowanalysis.analysis.pcm.resource.PCMResourceProvider;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.repository.OperationSignature;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF;
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
	private List<? extends AbstractVertex<?>> vertices;
	private PCMResourceProvider resourceProvider;
	
	public PCMQueryHelper(List<? extends AbstractVertex<?>> vertices, PCMResourceProvider resourceProvider) {
		this.vertices = vertices;
		this.resourceProvider = resourceProvider;
	}

	public boolean hasTargetNode(PCMUncertaintySource uncertaintySource) {
		return this.findTargetNodes(uncertaintySource).size() > 0;
	}
	
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

	private List<? extends AbstractPCMVertex<?>> findTargetNodesOfComponentUncertainty(
			PCMComponentUncertaintySource castedSource) {
		return this.vertices.stream()
				.filter(SEFFPCMVertex.class::isInstance)
				.map(it -> (SEFFPCMVertex<?>) it)
				.filter(it -> it.getReferencedElement() instanceof StartAction)
				.filter(it -> it.getContext().contains(castedSource.getTarget()))
				.collect(Collectors.toList());
	}

	private List<? extends AbstractPCMVertex<?>> findTargetNodesOfConnectorUncertaintySourceInEntryLevelSystemCall(
			PCMConnectorUncertaintySourceInEntryLevelSystemCall castedSource) {
		return this.vertices.stream()
				.filter(it -> it.getReferencedElement().equals(castedSource.getTarget()))
				.map(it -> (AbstractPCMVertex<?>) it)
				.toList();
	}

	private List<? extends AbstractPCMVertex<?>> findTargetNodesOfConnectorUncertaintyInExternalCall(
			PCMConnectorUncertaintySourceInExternalCall castedSource) {
		return this.vertices.stream()
				.filter(it -> it.getReferencedElement().equals(castedSource.getTarget()))
				.map(it -> (AbstractPCMVertex<?>) it)
				.toList();
	}

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
	
	private boolean implementsInterface(SEFFPCMVertex<?> vertex, OperationSignature signature) {
		if (!(vertex.getReferencedElement().eContainer() instanceof ResourceDemandingSEFF seff)) {
			return false;
		}
		// TODO: Correct?
		return signature.getInterface__OperationSignature().getSignatures__OperationInterface().contains(seff.getDescribedService__SEFF());
	}

	private List<? extends AbstractPCMVertex<?>> findTargetNodesOfBehaviourUncertainty(
			PCMBehaviorUncertaintySource castedSource) {
		return this.vertices.stream()
				.filter(it -> it.getReferencedElement().equals(castedSource.getTarget()))
				.map(it -> (AbstractPCMVertex<?>) it)
				.toList();
	}

	private List<? extends AbstractPCMVertex<?>> findTargetNodesOfExternalUncertaintyInUsage(
			PCMExternalUncertaintySourceInUsage castedSource) {
		return this.vertices.stream()
				.filter(CallingUserPCMVertex.class::isInstance)
				.map(CallingUserPCMVertex.class::cast)
				.filter(it -> it.getReferencedElement().getScenarioBehaviour_AbstractUserAction().getUsageScenario_SenarioBehaviour().equals(castedSource.getTarget().getUsagescenario()))
				.toList();
	}

	private List<? extends AbstractPCMVertex<?>> findTargetNodesOfExternalUncertaintyInResource(
			PCMExternalUncertaintySourceInResource castedSource) {
		return this.vertices.stream()
				.filter(it -> it instanceof SEFFPCMVertex<?>)
				.map(it -> (SEFFPCMVertex<?>) it)
				.filter(it -> it.getContext().stream().anyMatch(this.getDeployedContexts(castedSource.getTarget().getResourcecontainer())::contains))
				.toList();
	}
	
	private List<?> getDeployedContexts(ResourceContainer resourceContainer) {
		Allocation allocation = this.resourceProvider.getAllocation();
		return allocation.getAllocationContexts_Allocation().stream()
				.filter(it -> it.getResourceContainer_AllocationContext().equals(resourceContainer))
				.map(it -> it.getAssemblyContext_AllocationContext())
				.toList();
	}
}
