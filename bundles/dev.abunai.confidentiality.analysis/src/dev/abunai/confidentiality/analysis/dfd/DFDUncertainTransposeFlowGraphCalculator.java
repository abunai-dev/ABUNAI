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

import org.dataflowanalysis.analysis.core.AbstractTransposeFlowGraph;
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

public class DFDUncertainTransposeFlowGraphCalculator {
    private final List<? extends UncertaintySource> relevantUncertaintySources;
    private final DFDUncertaintyResourceProvider resourceProvider;

    public DFDUncertainTransposeFlowGraphCalculator(List<? extends  UncertaintySource> relevantUncertaintySources, DFDUncertaintyResourceProvider resourceProvider) {
        this.relevantUncertaintySources = relevantUncertaintySources;
        this.resourceProvider = resourceProvider;
    }

    public List<DFDUncertainTransposeFlowGraph> determineAlternativePartialFlowGraphs(UncertainState state, DFDUncertainTransposeFlowGraph uncertainTransposeFlowGraph) {
        if (state.getSelectedUncertaintyScenarios().isEmpty()) {
        	return List.of((DFDUncertainTransposeFlowGraph) uncertainTransposeFlowGraph.copy(new IdentityHashMap<>(), state));
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
            return List.of(applyInterfaceUncertaintyScenario(castedScenario, uncertainState, currentTransposeFlowGraph));
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

        DFDExternalUncertaintySource uncertaintySource = (DFDExternalUncertaintySource) uncertaintyScenario
                .eContainer();
        Node target = uncertaintySource.getTarget();
        Node targetCopy;

        if (target instanceof External) {
            targetCopy = dataflowdiagramFactory.eINSTANCE.createExternal();
        } else if (target instanceof org.dataflowanalysis.dfd.dataflowdiagram.Process) {
            targetCopy = dataflowdiagramFactory.eINSTANCE.createProcess();
        } else if (target instanceof Store) {
            targetCopy = dataflowdiagramFactory.eINSTANCE.createStore();
        } else {
            throw new IllegalArgumentException("Unexpected DFD node type.");
        }

        targetCopy.setEntityName(target.getEntityName());
        targetCopy.setBehaviour(target.getBehaviour());

        List<Label> filteredOldProperties = target.getProperties().stream().filter(it -> !uncertaintySource
                        .getTargetProperties().stream().map(Label::getEntityName).toList().contains(it.getEntityName()))
                .toList();

        List<Label> newPropertiesToAdd = uncertaintyScenario.getTargetProperties();
        targetCopy.getProperties()
                .addAll(Streams.concat(filteredOldProperties.stream(), newPropertiesToAdd.stream()).toList());

        Map<DFDVertex, DFDVertex> mapping = new IdentityHashMap<>();

        currentTransposeFlowGraph.getVertices().stream()
                .filter(DFDVertex.class::isInstance)
                .map(DFDVertex.class::cast)
                .filter(it -> it.getReferencedElement().equals(target))
                .forEach(it -> {
                    Map<Pin, DFDVertex> copiedPinDFDVertexMap = new HashMap<>();
                    it.getPinDFDVertexMap().keySet().forEach(key -> copiedPinDFDVertexMap.put(key, it.getPinDFDVertexMap().get(key).copy(new IdentityHashMap<>())));
                    mapping.put(it, new DFDVertex(targetCopy, copiedPinDFDVertexMap, new HashMap<>(it.getPinFlowMap())));
                });

        return (DFDUncertainTransposeFlowGraph) currentTransposeFlowGraph.copy(mapping, uncertainState);
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

        if (targetedNodes.size() < 1) {
            throw new IllegalStateException("Found no targeted nodes by behaviour uncertainty");
        }

        Behaviour resultBehaviour = datadictionaryFactory.eINSTANCE.createBehaviour();
        resultBehaviour.setEntityName(targetBehaviour.getEntityName());
        resultBehaviour.setId(targetBehaviour.getId());
        resultBehaviour.getAssignment().addAll(filteredAssignments);
        resultBehaviour.getAssignment().addAll(addedAssignments);

        Map<DFDVertex, DFDVertex> mapping = new IdentityHashMap<>();
        targetedNodes.forEach(node -> {
            Node target = node.getReferencedElement();
            Node targetCopy;

            if (target instanceof External) {
                targetCopy = dataflowdiagramFactory.eINSTANCE.createExternal();
            } else if (target instanceof org.dataflowanalysis.dfd.dataflowdiagram.Process) {
                targetCopy = dataflowdiagramFactory.eINSTANCE.createProcess();
            } else if (target instanceof Store) {
                targetCopy = dataflowdiagramFactory.eINSTANCE.createStore();
            } else {
                throw new IllegalArgumentException("Unexpected DFD node type.");
            }

            targetCopy.setEntityName(target.getEntityName());
            targetCopy.setBehaviour(resultBehaviour);

            Map<Pin, DFDVertex> copiedPinDFDVertexMap = new HashMap<>();
            node.getPinDFDVertexMap().keySet().forEach(key -> copiedPinDFDVertexMap.put(key, node.getPinDFDVertexMap().get(key).copy(new IdentityHashMap<>())));
            mapping.put(node, new DFDVertex(targetCopy, copiedPinDFDVertexMap, new HashMap<>(node.getPinFlowMap())));
        });
        
        return (DFDUncertainTransposeFlowGraph) currentTransposeFlowGraph.copy(mapping, uncertainState);
    }

    private DFDUncertainTransposeFlowGraph applyInterfaceUncertaintyScenario(DFDInterfaceUncertaintyScenario uncertaintyScenario, UncertainState uncertainState, AbstractTransposeFlowGraph currentTransposeFlowGraph) {
        DFDInterfaceUncertaintySource uncertaintySource = (DFDInterfaceUncertaintySource) uncertaintyScenario.eContainer();
        Flow targetFlow = uncertaintySource.getTargetFlow();
        Pin targetPin = uncertaintySource.getTargetInPin();
        Node targetNode = targetFlow.getDestinationNode();

        Flow replacingFlow = uncertaintyScenario.getTargetFlow();
        Pin replacingPin = uncertaintyScenario.getTargetInPin();

        if (!targetFlow.getSourceNode().equals(replacingFlow.getSourceNode())) {
            throw new IllegalArgumentException("Flows of Interface Uncertainty have different source nodes!");
        }
        if (!replacingFlow.getDestinationPin().equals(replacingPin)) {
            throw new IllegalArgumentException("Destination pins differ between in Interface Uncertainty");
        }

        Node targetCopy;
        if (targetNode instanceof External) {
            targetCopy = dataflowdiagramFactory.eINSTANCE.createExternal();
        } else if (targetNode instanceof org.dataflowanalysis.dfd.dataflowdiagram.Process) {
            targetCopy = dataflowdiagramFactory.eINSTANCE.createProcess();
        } else if (targetNode instanceof Store) {
            targetCopy = dataflowdiagramFactory.eINSTANCE.createStore();
        } else {
            throw new IllegalArgumentException("Unexpected DFD node type.");
        }

        targetCopy.setEntityName(targetNode.getEntityName());
        Behaviour modifiedBehavior = targetNode.getBehaviour();
        modifiedBehavior.getInPin().remove(targetPin);
        modifiedBehavior.getInPin().add(replacingPin);
        targetCopy.setBehaviour(modifiedBehavior);

        Map<DFDVertex, DFDVertex> mapping = new IdentityHashMap<>();

        currentTransposeFlowGraph.getVertices().stream()
                .filter(DFDVertex.class::isInstance)
                .map(DFDVertex.class::cast)
                .filter(it -> it.getReferencedElement().equals(targetNode))
                .forEach(it -> {
                    Map<Pin, DFDVertex> copiedPinDFDVertexMap = new HashMap<>();
                    Map<Pin, DFDVertex> modifiedVertexMap = new HashMap<>(it.getPinDFDVertexMap());
                    DFDVertex targetVertex = modifiedVertexMap.remove(targetPin);
                    modifiedVertexMap.put(replacingPin, targetVertex);
                    modifiedVertexMap.keySet().forEach(key -> copiedPinDFDVertexMap.put(key, modifiedVertexMap.get(key).copy(new IdentityHashMap<>())));

                    Map<Pin, Flow> modifiedPinFlowMap = new HashMap<>(it.getPinFlowMap());
                    modifiedPinFlowMap.remove(targetPin);
                    modifiedPinFlowMap.put(replacingPin, replacingFlow);
                    mapping.put(it, new DFDVertex(targetCopy, copiedPinDFDVertexMap, modifiedPinFlowMap));
                });

        DFDUncertainTransposeFlowGraph copy = new DFDUncertainTransposeFlowGraph(mapping.getOrDefault(currentTransposeFlowGraph.getSink(), (DFDVertex) currentTransposeFlowGraph.getSink()), relevantUncertaintySources, uncertainState);
        copy.getVertices().stream()
                .map(DFDVertex.class::cast)
                .forEach(it -> it.getPinDFDVertexMap().replaceAll((pin, vertex) -> {
                    return mapping.getOrDefault(vertex, vertex);
                }));

        // FIXME: Replace with once issue with pcm/dfd parallel is fixed
        // return this.copy(mapping);
        return copy;
    }


    /**
     * Theory time!!!
     * Every node downstream from the changed flow is no longer able to evaluate
     * -> Remove every node downstream starting at the destination of the target flow
     * -> Nodes removed unnecessarily will be added back in step three
     * Nodes in side branches is able to evaluate into a separate transpose flow graph
     * -> Follow node starting at the vertex of the source of the target flow upward
     * -> Each path to one node above is a tfg
     * -> Do these need to be evaluated? The violation will be found in the default case as well
     * The new node may cause multiple transpose flow graphs
     * -> The destination of the replacing flow and all down stream need to be used as a result
     * -> Take all flows with the destination node contained and search for the targeted pin
     */
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

        // DFDVertex in current transpose flow graph that matches the target
        DFDVertex targetNode = currentTransposeFlowGraph.getVertices().stream()
                .filter(DFDVertex.class::isInstance)
                .map(DFDVertex.class::cast)
                .filter(it -> it.getReferencedElement().equals(targetFlow.getSourceNode()))
                .findAny().orElseThrow();

        List<DFDUncertainTransposeFlowGraph> transposeFlowGraphsInSide = currentTransposeFlowGraph.getVertices().stream()
                .filter(DFDVertex.class::isInstance)
                .map(DFDVertex.class::cast)
                .filter(it -> it.getReferencedElement().equals(targetFlow.getDestinationNode()))
                .flatMap(it -> it.getPreviousElements().stream())
                .filter(DFDVertex.class::isInstance)
                .filter(it -> !it.equals(targetNode))
                .map(DFDVertex.class::cast)
                .map(it -> new DFDUncertainTransposeFlowGraph(it.copy(new IdentityHashMap<>()), this.relevantUncertaintySources, uncertainState))
                .toList();

        List<DFDUncertainTransposeFlowGraph> results = new ArrayList<>(transposeFlowGraphsInSide);

        // All default flow graphs that match the destination of the replacing flow
        DFDTransposeFlowGraphFinder finder = new DFDTransposeFlowGraphFinder(this.resourceProvider);
        List<DFDUncertainTransposeFlowGraph> matchingFlowGraphs = finder.findTransposeFlowGraphs(List.of(replacingFlow.getDestinationNode())).stream()
        		.map(it -> new DFDUncertainTransposeFlowGraph(it.getSink(), currentTransposeFlowGraph.getRelevantUncertaintySources(), uncertainState))
        		.toList();

        Node targetCopy;
        if (replacingFlow.getSourceNode() instanceof External) {
            targetCopy = dataflowdiagramFactory.eINSTANCE.createExternal();
        } else if (replacingFlow.getSourceNode() instanceof org.dataflowanalysis.dfd.dataflowdiagram.Process) {
            targetCopy = dataflowdiagramFactory.eINSTANCE.createProcess();
        } else if (replacingFlow.getSourceNode() instanceof Store) {
            targetCopy = dataflowdiagramFactory.eINSTANCE.createStore();
        } else {
            throw new IllegalArgumentException("Unexpected DFD node type.");
        }
        targetCopy.setEntityName(replacingFlow.getSourceNode().getEntityName());
        targetCopy.getProperties().addAll(replacingFlow.getSourceNode().getProperties());
        
        Behaviour resultBehaviour = datadictionaryFactory.eINSTANCE.createBehaviour();
        resultBehaviour.setEntityName(replacingFlow.getSourceNode().getBehaviour().getEntityName());
        resultBehaviour.setId(replacingFlow.getSourceNode().getBehaviour().getId());
        resultBehaviour.getAssignment().addAll(filteredAssignments);
        resultBehaviour.getAssignment().addAll(addedAssignments);
        targetCopy.setBehaviour(resultBehaviour);
        	
        DFDVertex destinationVertex = new DFDVertex(replacingFlow.getDestinationNode(), Map.of(replacingFlow.getDestinationPin(), targetNode), Map.of(replacingFlow.getDestinationPin(), replacingFlow));

        List<DFDUncertainTransposeFlowGraph> transposeFlowGraphsWithTarget = matchingFlowGraphs.stream()
                .map(it -> this.merge(destinationVertex, it, uncertainState))
                .map(it -> {
                	Map<DFDVertex, DFDVertex> mapping = new IdentityHashMap<>();
                	DFDVertex node = targetNode;
                	Map<Pin, DFDVertex> copiedPinDFDVertexMap = new HashMap<>();
                    node.getPinDFDVertexMap().keySet().forEach(key -> copiedPinDFDVertexMap.put(key, node.getPinDFDVertexMap().get(key).copy(new IdentityHashMap<>())));
                    mapping.put(node, new DFDVertex(targetCopy, copiedPinDFDVertexMap, new HashMap<>(node.getPinFlowMap())));
                	return (DFDUncertainTransposeFlowGraph) it.copy(mapping, uncertainState);
                })
                .toList();
        results.addAll(transposeFlowGraphsWithTarget);
        return results;
    }

    public DFDUncertainTransposeFlowGraph merge(DFDVertex destinationVertex, DFDUncertainTransposeFlowGraph followingTransposeFlowGraph, UncertainState uncertainState) {
        DFDVertex correspondingRealVertex = followingTransposeFlowGraph.getVertices().stream()
                .filter(DFDVertex.class::isInstance)
                .map(DFDVertex.class::cast)
                .filter(it -> it.getReferencedElement().equals(destinationVertex.getReferencedElement()))
                .findFirst().orElseThrow();

        destinationVertex.getPinDFDVertexMap().keySet().stream()
                .forEach(pin -> {
                    correspondingRealVertex.getPinDFDVertexMap().put(pin, destinationVertex.getPinDFDVertexMap().get(pin));
                    correspondingRealVertex.getPinFlowMap().put(pin, destinationVertex.getPinFlowMap().get(pin));
                });
        Map<DFDVertex, DFDVertex> mapping = Map.of(correspondingRealVertex, destinationVertex);
        return (DFDUncertainTransposeFlowGraph) followingTransposeFlowGraph.copy(mapping, uncertainState);
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
                .forEach(it -> {
                    Map<Pin, DFDVertex> copiedPinDFDVertexMap = new HashMap<>();
                    it.getPinDFDVertexMap().keySet().forEach(key -> copiedPinDFDVertexMap.put(key, it.getPinDFDVertexMap().get(key).copy(new IdentityHashMap<>())));
                    mapping.put(it, new DFDVertex(replacingNode, copiedPinDFDVertexMap, new HashMap<>(it.getPinFlowMap())));
                });

        return (DFDUncertainTransposeFlowGraph) currentTransposeFlowGraph.copy(mapping, uncertainState);
    }
}
