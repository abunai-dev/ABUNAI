package dev.abunai.confidentiality.analysis.dfd;

import com.google.common.collect.Streams;
import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.core.UncertaintyUtils;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class DFDUncertaintyCalculator {
    private final List<? extends UncertaintySource> relevantUncertaintySources;
    private final DFDUncertaintyResourceProvider resourceProvider;

    public DFDUncertaintyCalculator(List<? extends  UncertaintySource> relevantUncertaintySources, DFDUncertaintyResourceProvider resourceProvider) {
        this.relevantUncertaintySources = relevantUncertaintySources;
        this.resourceProvider = resourceProvider;
    }

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

    private List<DFDUncertainTransposeFlowGraph> applyInterfaceUncertaintyScenario(DFDInterfaceUncertaintyScenario uncertaintyScenario, UncertainState uncertainState, DFDUncertainTransposeFlowGraph currentTransposeFlowGraph) {
        DFDInterfaceUncertaintySource uncertaintySource = (DFDInterfaceUncertaintySource) uncertaintyScenario.eContainer();
        Flow targetFlow = uncertaintySource.getTargetFlow();
        Pin targetPin = uncertaintySource.getTargetInPin();

        Flow replacingFlow = uncertaintyScenario.getTargetFlow();
        Pin replacingPin = uncertaintyScenario.getTargetInPin();

        if (!targetFlow.getSourceNode().equals(replacingFlow.getSourceNode())) {
            throw new IllegalArgumentException("Flows of Interface Uncertainty have different source nodes!");
        }
        if (!replacingFlow.getDestinationPin().equals(replacingPin)) {
            throw new IllegalArgumentException("Destination pins differ between in Interface Uncertainty");
        }
        
        DFDVertex commonVertex = currentTransposeFlowGraph.getVertices().stream()
        		.filter(DFDVertex.class::isInstance)
        		.map(DFDVertex.class::cast)
        		.filter(it -> it.getReferencedElement().equals(replacingFlow.getSourceNode()))
        		.findAny().orElseThrow();
        
        DFDTransposeFlowGraphFinder finder = new DFDTransposeFlowGraphFinder(resourceProvider);
        List<DFDUncertainTransposeFlowGraph> followingFlowGraphs = finder.findTransposeFlowGraphs(List.of(replacingFlow.getDestinationNode())).stream()
        		.map(it -> new DFDUncertainTransposeFlowGraph(it.getSink(), currentTransposeFlowGraph.getRelevantUncertaintySources(), uncertainState))
        		.toList();
        
        followingFlowGraphs.stream()
        	.map(it -> it.getVertices().stream()
                    .filter(vertex -> vertex.getReferencedElement().equals(replacingFlow.getDestinationNode()))
                    .findAny().orElseThrow())
        	.filter(DFDVertex.class::isInstance)
        	.map(DFDVertex.class::cast)
        	.forEach(vertex -> {
        		vertex.getPinFlowMap().remove(targetPin);
        		vertex.getPinFlowMap().put(replacingPin, replacingFlow);
        		vertex.getPinDFDVertexMap().remove(targetPin);
        		vertex.getPinDFDVertexMap().put(replacingPin, commonVertex.copy(new IdentityHashMap<>()));
        	});

        return followingFlowGraphs;
    }

    private List<DFDUncertainTransposeFlowGraph> applyConnectorUncertaintyScenario(DFDConnectorUncertaintyScenario uncertaintyScenario, UncertainState uncertainState, DFDUncertainTransposeFlowGraph currentTransposeFlowGraph) {
        DFDConnectorUncertaintySource uncertaintySource = (DFDConnectorUncertaintySource) uncertaintyScenario.eContainer();
        Flow targetFlow = uncertaintySource.getTargetFlow();
        Flow replacingFlow = uncertaintyScenario.getTargetFlow();
        
        List<AbstractAssignment> targetedAssignments = uncertaintySource.getTargetAssignments();
        List<AbstractAssignment> filteredAssignments = replacingFlow.getDestinationNode().getBehaviour().getAssignment().stream()
                .filter(it -> !(targetedAssignments.contains(it)))
                .toList();
        List<AbstractAssignment> addedAssignments = uncertaintyScenario.getTargetAssignments();

        if (!targetFlow.getSourceNode().equals(replacingFlow.getSourceNode())) {
            throw new IllegalArgumentException("Source of Flows in Connector Uncertainty are different");
        }

        DFDVertex targetNode = currentTransposeFlowGraph.getVertices().stream()
                .filter(DFDVertex.class::isInstance)
                .map(DFDVertex.class::cast)
                .filter(it -> it.getReferencedElement().equals(targetFlow.getSourceNode()))
                .findAny().orElseThrow();

        //List<DFDUncertainTransposeFlowGraph> transposeFlowGraphsInSide = this.determineSideFlowGraphs(uncertainState, currentTransposeFlowGraph, targetFlow, targetNode);
        List<DFDUncertainTransposeFlowGraph> results = new ArrayList<>(/*transposeFlowGraphsInSide*/);

        // All default flow graphs that match the destination of the replacing flow
        DFDTransposeFlowGraphFinder finder = new DFDTransposeFlowGraphFinder(this.resourceProvider);
        List<DFDUncertainTransposeFlowGraph> matchingFlowGraphs = finder.findTransposeFlowGraphs(List.of(replacingFlow.getDestinationNode())).stream()
        		.map(it -> new DFDUncertainTransposeFlowGraph(it.getSink(), currentTransposeFlowGraph.getRelevantUncertaintySources(), uncertainState))
        		.toList();

        Node targetCopy = this.copyNode(replacingFlow.getSourceNode());
        
        Behaviour targetBehavior = this.copyBehavior(replacingFlow.getSourceNode().getBehaviour(), Stream.concat(filteredAssignments.stream(), addedAssignments.stream()).toList());
        targetCopy.setBehaviour(targetBehavior);
        	
        DFDVertex destinationVertex = new DFDVertex(replacingFlow.getDestinationNode(), Map.of(replacingFlow.getDestinationPin(), targetNode), Map.of(replacingFlow.getDestinationPin(), replacingFlow));

        List<DFDUncertainTransposeFlowGraph> transposeFlowGraphsWithTarget = matchingFlowGraphs.stream()
                .map(it -> this.merge(destinationVertex, it, uncertainState))
                .map(it -> it.copy(Map.of(targetNode, this.copyVertex(targetNode, targetCopy)), uncertainState))
                .toList();
        results.addAll(transposeFlowGraphsWithTarget);
        return results;
    }

    private List<DFDUncertainTransposeFlowGraph> determineSideFlowGraphs(UncertainState uncertainState, DFDUncertainTransposeFlowGraph currentTransposeFlowGraph, Flow targetFlow, DFDVertex targetNode) {
        return currentTransposeFlowGraph.getVertices().stream()
                .filter(DFDVertex.class::isInstance)
                .map(DFDVertex.class::cast)
                .filter(it -> it.getReferencedElement().equals(targetFlow.getDestinationNode()))
                .flatMap(it -> it.getPreviousElements().stream())
                .filter(DFDVertex.class::isInstance)
                .filter(it -> !it.equals(targetNode))
                .map(DFDVertex.class::cast)
                .map(it -> new DFDUncertainTransposeFlowGraph(it.copy(new IdentityHashMap<>()), this.relevantUncertaintySources, uncertainState))
                .toList();
    }

    public DFDUncertainTransposeFlowGraph merge(DFDVertex destinationVertex, DFDUncertainTransposeFlowGraph followingTransposeFlowGraph, UncertainState uncertainState) {
        DFDVertex correspondingRealVertex = followingTransposeFlowGraph.getVertices().stream()
                .filter(DFDVertex.class::isInstance)
                .map(DFDVertex.class::cast)
                .filter(it -> it.getReferencedElement().equals(destinationVertex.getReferencedElement()))
                .findFirst().orElseThrow();

        destinationVertex.getPinDFDVertexMap().keySet()
                .forEach(pin -> {
                    correspondingRealVertex.getPinDFDVertexMap().put(pin, destinationVertex.getPinDFDVertexMap().get(pin));
                    correspondingRealVertex.getPinFlowMap().put(pin, destinationVertex.getPinFlowMap().get(pin));
                });
        Map<DFDVertex, DFDVertex> mapping = Map.of(correspondingRealVertex, destinationVertex);
        return followingTransposeFlowGraph.copy(mapping, uncertainState);
    }
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

    private Behaviour copyBehavior(Behaviour behaviour, List<AbstractAssignment> assignments) {
        Behaviour copy = datadictionaryFactory.eINSTANCE.createBehaviour();
        copy.setEntityName(behaviour.getEntityName());
        copy.setId(behaviour.getId());
        copy.getAssignment().addAll(assignments);
        return copy;
    }

    private DFDVertex copyVertex(DFDVertex vertex, Node replacingNode) {
        Map<Pin, DFDVertex> copiedPinDFDVertexMap = new HashMap<>();
        vertex.getPinDFDVertexMap().keySet().forEach(key -> copiedPinDFDVertexMap.put(key, vertex.getPinDFDVertexMap().get(key).copy(new IdentityHashMap<>())));
        return new DFDVertex(replacingNode, copiedPinDFDVertexMap, new HashMap<>(vertex.getPinFlowMap()));
    }
}