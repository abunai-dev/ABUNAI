package dev.abunai.confidentiality.analysis.dfd;

import java.util.HashSet;
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

/**
 * DFD Query helper used to calculate the impacts of uncertainty sources on the given list of vertices
 */
public class DFDQueryHelper {

	private final List<? extends AbstractVertex<?>> vertices;

	/**
	 * Creates a new DFDQueryHelper with the given list of vertices
	 * @param vertices Given list of vertices that are used
	 */
	public DFDQueryHelper(List<? extends AbstractVertex<?>> vertices) {
		this.vertices = vertices;
	}

	/**
	 * Determines whether an uncertainty source impacts the list of vertices
	 * @param uncertaintySource Uncertainty source impacting the vertices
	 * @return Return true, if the list of vertices are affected by the uncertainty source.
	 * 			Otherwise, the method returns false
	 */
	public boolean hasTargetNode(DFDUncertaintySource uncertaintySource) {
		return !this.findTargetNodes(uncertaintySource).isEmpty();
	}

	/**
	 * Finds the list of nodes that are targeted by a given uncertainty source
	 * @param uncertaintySource Uncertainty source of which the targeted nodes shall be calculated
	 * @return Returns a list of all nodes that are targeted by the given uncertainty source
	 */
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
			return findTargetNodesOfComponentUncertainty(castedSource);
		} else {
			throw new IllegalArgumentException("Unsupported uncertainty source: %s."
					.formatted(UncertaintyUtils.getUncertaintySourceName(uncertaintySource)));
		}
	}

	/**
	 * Returns the targeted nodes of an external uncertainty
	 * <p/>
	 * A node is targeted by an external uncertainty, if the referenced node and properties of that node are identical
	 * @param uncertaintySource External uncertainty of which the targeted nodes shall be calculated
	 * @return Returns a list of all nodes targeted by the external uncertainty
	 */
	private List<Node> findTargetNodesOfExternalUncertainty(DFDExternalUncertaintySource uncertaintySource) {
		return vertices.stream().map(DFDVertex.class::cast)
				.map(DFDVertex::getReferencedElement)
				.filter(it -> it.equals(uncertaintySource.getTarget()))
				.filter(it -> new HashSet<>(it.getProperties()).containsAll(uncertaintySource.getTargetProperties())).toList();
	}

	/**
	 * Returns the targeted nodes of a behavior uncertainty
	 * <p/>
	 * A node is targeted by a behavior uncertainty, if the referenced nodes and assignments match
	 * @param uncertaintySource Behavior uncertainty of which the targeted nodes shall be calculated
	 * @return Returns a list of all nodes targeted by the behavior uncertainty
	 */
	private List<Node> findTargetNodesOfBehaviorUncertainty(DFDBehaviorUncertaintySource uncertaintySource) {
		return vertices.stream().map(DFDVertex.class::cast)
				.map(DFDVertex::getReferencedElement)
				.filter(it -> it.getBehavior().equals(uncertaintySource.getTarget()))
				.filter(it -> new HashSet<>(it.getBehavior().getAssignment()).containsAll(uncertaintySource.getTargetAssignments()))
				.toList();
	}

	/**
	 * Returns the targeted nodes of an interface uncertainty
	 * <p/>
	 * A node is targeted by an interface uncertainty, if the nodes input pin is the destination of the targeted flow
	 * @param uncertaintySource Interface uncertainty of which the targeted nodes shall be calculated
	 * @return Returns a list of all nodes targeted by the interface uncertainty
	 */
	private List<Node> findTargetNodesOfInterfaceUncertainty(DFDInterfaceUncertaintySource uncertaintySource) {
		return vertices.stream().map(DFDVertex.class::cast)
				.map(DFDVertex::getReferencedElement)
				.filter(it -> it.getBehavior().getInPin().contains(uncertaintySource.getTargetFlow().getDestinationPin()))
				.filter(it -> ((DataFlowDiagram) it.eContainer()).getFlows().stream()
						.filter(flow -> flow.getDestinationPin().equals(uncertaintySource.getTargetFlow().getDestinationPin()))
						.anyMatch(flow -> flow.equals(uncertaintySource.getTargetFlow())))
				.toList();
	}

	/**
	 * Returns the targeted nodes of a connector uncertainty
	 * <p/>
	 * A node is targeted by a connector uncertainty, if the targeted flow ends at the node
	 * @param uncertaintySource Connector uncertainty of which the targeted nodes shall be calculated
	 * @return Returns a list of all nodes targeted by the behavior uncertainty
	 */
	private List<Node> findTargetNodesOfConnectorUncertainty(DFDConnectorUncertaintySource uncertaintySource) {
		return vertices.stream().map(DFDVertex.class::cast)
				.map(DFDVertex::getReferencedElement)
				.filter(it -> uncertaintySource.getTargetFlow().getDestinationNode().equals(it))
				.filter(it -> new HashSet<>(uncertaintySource.getTargetFlow().getSourceNode().getBehavior().getAssignment())
						.containsAll(uncertaintySource.getTargetAssignments()))
				.toList();
	}

	/**
	 * Returns the targeted nodes of a component uncertainty
	 * <p/>
	 * A node is targeted by a component uncertainty, if the referenced nodes match
	 * @param uncertaintySource Component uncertainty of which the targeted nodes shall be calculated
	 * @return Returns a list of all nodes targeted by the component uncertainty
	 */
	private List<Node> findTargetNodesOfComponentUncertainty(DFDComponentUncertaintySource uncertaintySource) {
		return vertices.stream().map(DFDVertex.class::cast)
				.map(DFDVertex::getReferencedElement)
				.filter(it -> it.equals(uncertaintySource.getTarget()))
				.toList();
	}

}
