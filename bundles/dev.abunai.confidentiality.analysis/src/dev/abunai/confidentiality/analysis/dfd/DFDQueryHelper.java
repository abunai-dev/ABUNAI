package dev.abunai.confidentiality.analysis.dfd;

import java.util.List;

import org.dataflowanalysis.analysis.core.AbstractVertex;
import org.dataflowanalysis.analysis.dfd.core.DFDVertex;
import org.dataflowanalysis.dfd.dataflowdiagram.DataFlowDiagram;
import org.dataflowanalysis.dfd.dataflowdiagram.Node;

import dev.abunai.confidentiality.analysis.core.UncertaintyUtils;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDBehaviorUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDComponentUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDUncertaintySource;

public class DFDQueryHelper {

	private final List<? extends AbstractVertex<?>> vertices;

	public DFDQueryHelper(List<? extends AbstractVertex<?>> vertices) {
		this.vertices = vertices;
	}

	public boolean hasTargetNode(DFDUncertaintySource uncertaintySource) {
		return this.findTargetNodes(uncertaintySource).size() > 0;
	}

	public List<Node> findTargetNodes(DFDUncertaintySource uncertaintySource) {
		if (uncertaintySource instanceof DFDExternalUncertaintySource castedSource) {
			return findTargetNodesOfExternalUncertainty(castedSource);
		} else if (uncertaintySource instanceof DFDBehaviorUncertaintySource castedSource) {
			return findTargetNodesOfBehaviorUncertainty(castedSource);
		} else if (uncertaintySource instanceof DFDInterfaceUncertaintySource castedSource) {
			return findTargetNodesOfInterfaceUncertainty(castedSource);
		} else if (uncertaintySource instanceof DFDConnectorUncertaintySource castedSource) {
			return findTargetNodesOfConnectorUncertainty(castedSource);
		} else if (uncertaintySource instanceof DFDComponentUncertaintySource castedSource) {
			return findTargetNodesofComponentUncertainty(castedSource);
		} else {
			throw new IllegalArgumentException("Unsupported uncertainty source: %s."
					.formatted(UncertaintyUtils.getUncertaintySourceName(uncertaintySource)));
		}
	}

	private List<Node> findTargetNodesOfExternalUncertainty(DFDExternalUncertaintySource uncertaintySource) {
		return vertices.stream().map(DFDVertex.class::cast)
				.map(DFDVertex::getReferencedElement)
				.filter(it -> it.equals(uncertaintySource.getTarget()))
				.filter(it -> it.getProperties().containsAll(uncertaintySource.getTargetProperties())).toList();
	}

	private List<Node> findTargetNodesOfBehaviorUncertainty(DFDBehaviorUncertaintySource uncertaintySource) {
		return vertices.stream().map(DFDVertex.class::cast)
				.map(DFDVertex::getReferencedElement)
				.filter(it -> it.getBehaviour().equals(uncertaintySource.getTarget()))
				.filter(it -> it.getBehaviour().getAssignment().containsAll(uncertaintySource.getTargetAssignments()))
				.toList();
	}

	private List<Node> findTargetNodesOfInterfaceUncertainty(DFDInterfaceUncertaintySource uncertaintySource) {
		return vertices.stream().map(DFDVertex.class::cast)
				.map(DFDVertex::getReferencedElement)
				.filter(it -> it.getBehaviour().getInPin().contains(uncertaintySource.getTargetInPin()))
				.filter(it -> ((DataFlowDiagram) it.eContainer()).getFlows().stream()
						.filter(flow -> flow.getDestinationPin().equals(uncertaintySource.getTargetInPin()))
						.anyMatch(flow -> flow.equals(uncertaintySource.getTargetFlow())))
				.toList();
	}

	private List<Node> findTargetNodesOfConnectorUncertainty(DFDConnectorUncertaintySource uncertaintySource) {
		return vertices.stream().map(DFDVertex.class::cast)
				.map(DFDVertex::getReferencedElement)
				.filter(it -> uncertaintySource.getTargetFlow().getDestinationNode().equals(it))
				.filter(it -> uncertaintySource.getTargetFlow().getSourceNode().getBehaviour().getAssignment()
						.containsAll(uncertaintySource.getTargetAssignments()))
				.toList();
	}

	private List<Node> findTargetNodesofComponentUncertainty(DFDComponentUncertaintySource uncertaintySource) {
		return vertices.stream().map(DFDVertex.class::cast)
				.map(DFDVertex::getReferencedElement)
				.filter(it -> it.equals(uncertaintySource.getTarget()))
				.toList();
	}

}