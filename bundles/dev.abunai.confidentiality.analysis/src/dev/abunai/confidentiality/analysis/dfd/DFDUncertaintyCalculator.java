package dev.abunai.confidentiality.analysis.dfd;

import com.google.common.collect.Streams;
import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.core.UncertaintyUtils;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDBehaviorUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDBehaviorUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDComponentUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDComponentUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDConnectorUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDInterfaceUncertaintySource;

import org.dataflowanalysis.analysis.dfd.core.DFDTransposeFlowGraphFinder;
import org.dataflowanalysis.analysis.dfd.core.DFDVertex;
import org.dataflowanalysis.dfd.datadictionary.AbstractAssignment;
import org.dataflowanalysis.dfd.datadictionary.Behaviour;
import org.dataflowanalysis.dfd.datadictionary.Label;
import org.dataflowanalysis.dfd.datadictionary.Pin;
import org.dataflowanalysis.dfd.datadictionary.datadictionaryFactory;
import org.dataflowanalysis.dfd.dataflowdiagram.External;
import org.dataflowanalysis.dfd.dataflowdiagram.Flow;
import org.dataflowanalysis.dfd.dataflowdiagram.Node;
import org.dataflowanalysis.dfd.dataflowdiagram.Store;
import org.dataflowanalysis.dfd.dataflowdiagram.dataflowdiagramFactory;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Calculator used to determine the impact of an uncertainty state on a transpose flow graph
 */
public class DFDUncertaintyCalculator {
    private final DFDUncertaintyResourceProvider resourceProvider;

    /**
     * Create a new dfd uncertainty calculator with the given dfd uncertainty resource provider
     * @param resourceProvider DFD Uncertainty resource provider, which is used to calculate the impact on transpose flow graphs
     */
    public DFDUncertaintyCalculator(DFDUncertaintyResourceProvider resourceProvider) {
        this.resourceProvider = resourceProvider;
    }

    /**
     * Determines the alternative transpose flow graphs of the given transpose flow graph in the given uncertain state
     * @param state Uncertain state, which impacts the given transpose flow graph
     * @param uncertainTransposeFlowGraph Uncertain transpose flow graph that is affected by the uncertain state
     * @return Returns a list of all alternate transpose flow graphs after all uncertainty scenarios of the uncertain state are applied
     */
    public List<DFDUncertainTransposeFlowGraph> determineAlternativeTransposeFlowGraphs(UncertainState state, DFDUncertainTransposeFlowGraph uncertainTransposeFlowGraph) {
        if (state.getSelectedUncertaintyScenarios().isEmpty()) {
        	return List.of(uncertainTransposeFlowGraph.copy(new IdentityHashMap<>(), state));
        }

    	List<DFDUncertainTransposeFlowGraph> currentTransposeFlowGraphs = List.of(uncertainTransposeFlowGraph);
        for (UncertaintyScenario uncertaintyScenario : state.getSelectedUncertaintyScenarios()) {
            currentTransposeFlowGraphs = currentTransposeFlowGraphs.stream()
                    .flatMap(it -> this.applyUncertaintyScenario(uncertaintyScenario, state, it).stream())
                    .toList();
        }
        return currentTransposeFlowGraphs;
    }

    /**
     * Apply a given uncertainty scenario extracted from the uncertainty state on a given transpose flow graph
     * @param uncertaintyScenario Uncertainty scenario which is applied on the transpose flow graph
     * @param uncertainState Uncertainty state containing the uncertainty scenario
     * @param currentTransposeFlowGraph Transpose flow graph to which the uncertainty scenario is applied
     * @return Returns a list of all transpose flow graphs that result from the application of the uncertainty scenario
     */
    private List<DFDUncertainTransposeFlowGraph> applyUncertaintyScenario(UncertaintyScenario uncertaintyScenario,
                                                                          UncertainState uncertainState, DFDUncertainTransposeFlowGraph currentTransposeFlowGraph) {
        if (uncertaintyScenario instanceof DFDExternalUncertaintyScenario castedScenario) {
            return List.of(applyExternalUncertaintyScenario(castedScenario, uncertainState, currentTransposeFlowGraph));
        } else if (uncertaintyScenario instanceof DFDBehaviorUncertaintyScenario castedScenario) {
            return List.of(applyBehaviorUncertaintyScenario(castedScenario, uncertainState, currentTransposeFlowGraph));
        } else if (uncertaintyScenario instanceof DFDInterfaceUncertaintyScenario castedScenario) {
            return applyInterfaceUncertaintyScenario(castedScenario, uncertainState, currentTransposeFlowGraph);
        } else if (uncertaintyScenario instanceof DFDConnectorUncertaintyScenario castedScenario) {
            return applyConnectorUncertaintyScenario(castedScenario, uncertainState, currentTransposeFlowGraph);
        } else if (uncertaintyScenario instanceof DFDComponentUncertaintyScenario castedScenario) {
            return List.of(applyComponentUncertaintyScenario(castedScenario, uncertainState, currentTransposeFlowGraph));
        } else {
            throw new IllegalArgumentException("Unexpected DFD uncertainty scenario: %s"
                    .formatted(UncertaintyUtils.getUncertaintyScenarioName(uncertaintyScenario)));
        }
    }

    /**
     * Apply an external uncertainty scenario on the transpose flow graph
     * @param uncertaintyScenario Uncertainty scenario that is applied to the transpose flow graph
     * @param uncertainState Uncertain state containing the uncertainty scenario
     * @param currentTransposeFlowGraph Transpose flow graph to which the uncertainty scenario is applied
     * @return Returns the transpose flow graph resulting from the application of the external uncertainty
     */
    private DFDUncertainTransposeFlowGraph applyExternalUncertaintyScenario(DFDExternalUncertaintyScenario uncertaintyScenario,
                                                                            UncertainState uncertainState, DFDUncertainTransposeFlowGraph currentTransposeFlowGraph) {

        DFDExternalUncertaintySource uncertaintySource = (DFDExternalUncertaintySource) uncertaintyScenario.eContainer();

        Node target = uncertaintySource.getTarget();
        List<Label> filteredOldProperties = target.getProperties().stream()
                .filter(it -> !uncertaintySource.getTargetProperties().stream().map(Label::getEntityName).toList().contains(it.getEntityName()))
                .toList();
        List<Label> newPropertiesToAdd = uncertaintyScenario.getTargetProperties();

        Node replacingNode = this.copyNode(target);
        replacingNode.getProperties().clear();
        replacingNode.getProperties()
                .addAll(Streams.concat(filteredOldProperties.stream(), newPropertiesToAdd.stream()).toList());

        Map<DFDVertex, DFDVertex> mapping = new IdentityHashMap<>();
        currentTransposeFlowGraph.getVertices().stream()
                .filter(DFDVertex.class::isInstance)
                .map(DFDVertex.class::cast)
                .filter(it -> it.getReferencedElement().equals(target))
                .forEach(it -> mapping.put(it, copyVertex(it, replacingNode)));

        return currentTransposeFlowGraph.copy(mapping, uncertainState);
    }

    /**
     * Apply a behavior uncertainty scenario on the transpose flow graph
     * @param uncertaintyScenario Uncertainty scenario that is applied to the transpose flow graph
     * @param uncertainState Uncertain state containing the uncertainty scenario
     * @param currentTransposeFlowGraph Transpose flow graph to which the uncertainty scenario is applied
     * @return Returns the transpose flow graph resulting from the application of the behavior uncertainty
     */
    private DFDUncertainTransposeFlowGraph applyBehaviorUncertaintyScenario(DFDBehaviorUncertaintyScenario uncertaintyScenario, UncertainState uncertainState, DFDUncertainTransposeFlowGraph currentTransposeFlowGraph) {
        DFDBehaviorUncertaintySource uncertaintySource = (DFDBehaviorUncertaintySource) uncertaintyScenario.eContainer();
        Behaviour targetBehaviour = uncertaintySource.getTarget();
        List<AbstractAssignment> targetedAssignments = uncertaintySource.getTargetAssignments();

        List<AbstractAssignment> filteredAssignments = targetBehaviour.getAssignment().stream()
                .filter(it -> !(targetedAssignments.contains(it)))
                .toList();
        List<AbstractAssignment> addedAssignments = uncertaintyScenario.getTargetAssignments();

        List<DFDVertex> targetedNodes = currentTransposeFlowGraph.getVertices().stream()
                .filter(DFDVertex.class::isInstance)
                .map(DFDVertex.class::cast)
                .filter(it -> it.getReferencedElement().getBehaviour().equals(targetBehaviour))
                .toList();

        if (targetedNodes.isEmpty()) {
            throw new IllegalStateException("Found no targeted nodes by behaviour uncertainty");
        }

        Behaviour replacingBehavior = this.copyBehavior(targetBehaviour, Stream.concat(filteredAssignments.stream(), addedAssignments.stream()).toList());

        Map<DFDVertex, DFDVertex> mapping = new IdentityHashMap<>();
        targetedNodes.forEach(vertex -> {
            Node targetedNode = vertex.getReferencedElement();
            Node replacingNode = this.copyNode(targetedNode);

            replacingNode.setBehaviour(replacingBehavior);
            mapping.put(vertex, this.copyVertex(vertex, replacingNode));
        });
        
        return currentTransposeFlowGraph.copy(mapping, uncertainState);
    }

    /**
     * Apply an interface uncertainty scenario on the transpose flow graph
     * @param uncertaintyScenario Uncertainty scenario that is applied to the transpose flow graph
     * @param uncertainState Uncertain state containing the uncertainty scenario
     * @param currentTransposeFlowGraph Transpose flow graph to which the uncertainty scenario is applied
     * @return Returns the transpose flow graph resulting from the application of the interface uncertainty
     */
    private List<DFDUncertainTransposeFlowGraph> applyInterfaceUncertaintyScenario(DFDInterfaceUncertaintyScenario uncertaintyScenario, UncertainState uncertainState, DFDUncertainTransposeFlowGraph currentTransposeFlowGraph) {
        DFDInterfaceUncertaintySource uncertaintySource = (DFDInterfaceUncertaintySource) uncertaintyScenario.eContainer();
        Flow targetFlow = uncertaintySource.getTargetFlow();

        Pin replacingPin = uncertaintyScenario.getTargetInPin();
        Node replacingNode = uncertaintyScenario.getTargetNode();
        
        return this.replaceFlow(targetFlow, replacingNode, replacingPin, currentTransposeFlowGraph, uncertainState, it -> it);
    }

    /**
     * This method replaces the targeted flow in the given transpose flow graph
     * with a new flow with the given node and pin as destination.
     * Furthermore, the uncertainty state is applied to the resulting transpose flow graphs.
     * Each node that is targeted can be modified via the mapping function
     * @param targetFlow Targeted flow in the transpose flow graph
     * @param replacingNode Destination node of the replacing flow
     * @param replacingPin Destination pin of the replacing flow
     * @param currentTransposeFlowGraph Transpose flow graph in which the flow is replaced
     * @param uncertainState Uncertain state of the resulting uncertain transpose flow graphs
     * @param mapping Mapping function used to manipulate the targeted nodes
     * @return Returns a list of all transpose flow graphs resulting from the replaced flow
     */
    private List<DFDUncertainTransposeFlowGraph> replaceFlow(Flow targetFlow, Node replacingNode, Pin replacingPin, DFDUncertainTransposeFlowGraph currentTransposeFlowGraph, UncertainState uncertainState, Function<Node, Node> mapping) {
        DFDVertex commonVertex = currentTransposeFlowGraph.getVertices().stream()
                .filter(DFDVertex.class::isInstance)
                .map(DFDVertex.class::cast)
                .filter(it -> it.getReferencedElement().equals(targetFlow.getSourceNode()))
                .findAny().orElseThrow();

        Map<Pin, DFDVertex> copiedPinDFDVertexMap = new HashMap<>();
        commonVertex.getPinDFDVertexMap().keySet()
                .forEach(key -> copiedPinDFDVertexMap.put(key, commonVertex.getPinDFDVertexMap().get(key).copy(new IdentityHashMap<>())));
        DFDVertex copiedVertex = new DFDVertex(mapping.apply(commonVertex.getReferencedElement()), copiedPinDFDVertexMap, new HashMap<>(commonVertex.getPinFlowMap()));

        DFDTransposeFlowGraphFinder finder = new DFDTransposeFlowGraphFinder(resourceProvider);
        List<DFDUncertainTransposeFlowGraph> followingFlowGraphs = finder.findTransposeFlowGraphs(List.of(replacingNode)).stream()
                .map(it -> new DFDUncertainTransposeFlowGraph(it.getSink(), currentTransposeFlowGraph.getRelevantUncertaintySources(), uncertainState))
                .toList();

        Flow replacingFlow = dataflowdiagramFactory.eINSTANCE.createFlow();
        replacingFlow.setSourceNode(targetFlow.getSourceNode());
        replacingFlow.setSourcePin(targetFlow.getSourcePin());
        replacingFlow.setDestinationNode(replacingNode);
        replacingFlow.setDestinationPin(replacingPin);

        followingFlowGraphs.stream()
                .map(it -> it.getVertices().stream()
                        .filter(vertex -> vertex.getReferencedElement().equals(replacingNode))
                        .findAny().orElseThrow())
                .filter(DFDVertex.class::isInstance)
                .map(DFDVertex.class::cast)
                .forEach(vertex -> {
                    vertex.getPinFlowMap().remove(targetFlow.getDestinationPin());
                    vertex.getPinFlowMap().put(replacingPin, replacingFlow);
                    vertex.getPinDFDVertexMap().remove(targetFlow.getDestinationPin());
                    vertex.getPinDFDVertexMap().put(replacingPin, copiedVertex.copy(new IdentityHashMap<>()));
                });

        return followingFlowGraphs;
    }

    /**
     * Apply a connector uncertainty scenario on the transpose flow graph
     * @param uncertaintyScenario Uncertainty scenario that is applied to the transpose flow graph
     * @param uncertainState Uncertain state containing the uncertainty scenario
     * @param currentTransposeFlowGraph Transpose flow graph to which the uncertainty scenario is applied
     * @return Returns the transpose flow graph resulting from the application of the connector uncertainty
     */
    private List<DFDUncertainTransposeFlowGraph> applyConnectorUncertaintyScenario(DFDConnectorUncertaintyScenario uncertaintyScenario, UncertainState uncertainState, DFDUncertainTransposeFlowGraph currentTransposeFlowGraph) {
        DFDConnectorUncertaintySource uncertaintySource = (DFDConnectorUncertaintySource) uncertaintyScenario.eContainer();
        Flow targetFlow = uncertaintySource.getTargetFlow();

        Node replacingNode = uncertaintyScenario.getTargetNode();
        Pin replacingPin = uncertaintyScenario.getTargetPin();
        
        List<AbstractAssignment> targetedAssignments = uncertaintySource.getTargetAssignments();
        List<AbstractAssignment> filteredAssignments = targetFlow.getSourceNode().getBehaviour().getAssignment().stream()
                .filter(it -> !(targetedAssignments.contains(it)))
                .toList();
        List<AbstractAssignment> addedAssignments = uncertaintyScenario.getTargetAssignments();

        return this.replaceFlow(targetFlow, replacingNode, replacingPin, currentTransposeFlowGraph, uncertainState, node -> {
            Behaviour targetBehavior = this.copyBehavior(targetFlow.getSourceNode().getBehaviour(), Stream.concat(filteredAssignments.stream(), addedAssignments.stream()).toList());
            node.setBehaviour(targetBehavior);
            return node;
        });
    }

    /**
     * Apply a component uncertainty scenario on the transpose flow graph
     * @param uncertaintyScenario Uncertainty scenario that is applied to the transpose flow graph
     * @param uncertainState Uncertain state containing the uncertainty scenario
     * @param currentTransposeFlowGraph Transpose flow graph to which the uncertainty scenario is applied
     * @return Returns the transpose flow graph resulting from the application of the component uncertainty
     */
    private DFDUncertainTransposeFlowGraph applyComponentUncertaintyScenario(DFDComponentUncertaintyScenario uncertaintyScenario, UncertainState uncertainState, DFDUncertainTransposeFlowGraph currentTransposeFlowGraph) {
        DFDComponentUncertaintySource uncertaintySource = (DFDComponentUncertaintySource) uncertaintyScenario.eContainer();
        Node targetedNode = uncertaintySource.getTarget();
        Node replacingNode = uncertaintyScenario.getTarget();

        Map<DFDVertex, DFDVertex> mapping = new IdentityHashMap<>();

        currentTransposeFlowGraph.getVertices().stream()
                .filter(DFDVertex.class::isInstance)
                .map(DFDVertex.class::cast)
                .filter(it -> it.getReferencedElement().equals(targetedNode))
                .forEach(it -> mapping.put(it, this.copyVertex(it, replacingNode)));

        return currentTransposeFlowGraph.copy(mapping, uncertainState);
    }

    /**
     * Copies the given node
     * @param node Node that should be copied
     * @return Returns a new copied node
     */
    private Node copyNode(Node node) {
        Node copy;
        if (node instanceof External) {
            copy = dataflowdiagramFactory.eINSTANCE.createExternal();
        } else if (node instanceof org.dataflowanalysis.dfd.dataflowdiagram.Process) {
            copy = dataflowdiagramFactory.eINSTANCE.createProcess();
        } else if (node instanceof Store) {
            copy = dataflowdiagramFactory.eINSTANCE.createStore();
        } else {
            throw new IllegalArgumentException("Unexpected DFD node type.");
        }
        copy.setEntityName(node.getEntityName());
        copy.setBehaviour(node.getBehaviour());
        copy.getProperties().addAll(node.getProperties());
        return copy;
    }

    /**
     * Copies the given behavior with the given list of new assignments
     * @param behaviour Behavior that should be copied
     * @param assignments List of assignments of the new behavior
     * @return Returns a new behavior with the copied name and id of the given behavior and the given list of assignments
     */
    private Behaviour copyBehavior(Behaviour behaviour, List<AbstractAssignment> assignments) {
        Behaviour copy = datadictionaryFactory.eINSTANCE.createBehaviour();
        copy.setEntityName(behaviour.getEntityName());
        copy.setId(behaviour.getId());
        copy.getAssignment().addAll(assignments);
        return copy;
    }

    /**
     * Copies the dfd vertex with the given replacing node
     * @param vertex DFD vertex of which the pin to vertex and pin to flow map should be copied
     * @param replacingNode Referenced node by the new dfd vertex
     * @return Returns a new dfd vertex with the given node and maps of the given vertex
     */
    private DFDVertex copyVertex(DFDVertex vertex, Node replacingNode) {
        Map<Pin, DFDVertex> copiedPinDFDVertexMap = new HashMap<>();
        vertex.getPinDFDVertexMap().keySet().forEach(key -> copiedPinDFDVertexMap.put(key, vertex.getPinDFDVertexMap().get(key).copy(new IdentityHashMap<>())));
        return new DFDVertex(replacingNode, copiedPinDFDVertexMap, new HashMap<>(vertex.getPinFlowMap()));
    }
}
