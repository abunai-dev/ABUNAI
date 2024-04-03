package dev.abunai.confidentiality.analysis.dfd;

import java.util.*;

import org.dataflowanalysis.analysis.core.AbstractTransposeFlowGraph;
import org.dataflowanalysis.analysis.core.AbstractVertex;
import org.dataflowanalysis.analysis.dfd.core.DFDTransposeFlowGraph;
import org.dataflowanalysis.analysis.dfd.core.DFDVertex;
import org.dataflowanalysis.analysis.resource.ResourceProvider;
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

import com.google.common.collect.Streams;

import dev.abunai.confidentiality.analysis.core.UncertainTransposeFlowGraph;
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
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDUncertaintySource;

public class DFDUncertainTransposeFlowGraph extends DFDTransposeFlowGraph implements UncertainTransposeFlowGraph {
	private final Optional<UncertainState> uncertainState;
	private final List<? extends UncertaintySource> relevantUncertaintySources;

	public DFDUncertainTransposeFlowGraph(AbstractVertex<?> sink,
										  List<? extends UncertaintySource> relevantUncertaintySources) {
		super(sink);
		this.uncertainState = Optional.empty();
		this.relevantUncertaintySources = relevantUncertaintySources;
	}
	
	public DFDUncertainTransposeFlowGraph(AbstractVertex<?> sink,
										  List<? extends UncertaintySource> relevantUncertaintySources, UncertainState uncertainState) {
		super(sink);
		this.uncertainState = Optional.of(uncertainState);
		this.relevantUncertaintySources = relevantUncertaintySources;
	}
	
	@Override
	public List<? extends DFDVertex> getImpactSet(ResourceProvider resourceProvider) {
		DFDQueryHelper dfdQueryHelper = new DFDQueryHelper(this.getVertices());
		
		List<Node> targetNodes = this.relevantUncertaintySources.stream()
				.map(it -> dfdQueryHelper.findTargetNodes((DFDUncertaintySource) it))
				.flatMap(List::stream)
				.toList();

		List<DFDVertex> longestAffectedElementList = super.getVertices().stream()
				.map(DFDVertex.class::cast)
				.dropWhile(it -> !targetNodes.contains(it.getReferencedElement()))
				.toList();
		// OLD CODE: new DFDActionSequence((List<AbstractActionSequenceElement<?>>) longestAffectedElementList);
		return longestAffectedElementList;
	}

	@Override
	public AbstractTransposeFlowGraph evaluate() {
        DFDVertex newSink = ((DFDVertex) sink).clone();
        newSink.unify(new HashSet<>());
        newSink.evaluateDataFlow();
        return new DFDUncertainTransposeFlowGraph(newSink,relevantUncertaintySources, uncertainState.get());
	}
	
	@Override
	public List<DFDUncertainTransposeFlowGraph> determineAlternativePartialFlowGraphs() {
		List<UncertainState> states = UncertainState.createAllUncertainStates(this.relevantUncertaintySources);
		List<DFDUncertainTransposeFlowGraph> alternatePartialFlowGraphs = new ArrayList<>();
		
		for (UncertainState state : states) {
			alternatePartialFlowGraphs.add(this.applyUncertaintyScenarios(state));
		}
		return alternatePartialFlowGraphs;
	}
	
	private DFDUncertainTransposeFlowGraph applyUncertaintyScenarios(UncertainState state) {
		DFDUncertainTransposeFlowGraph currentTransposeFlowGraph = this;
		for (UncertaintyScenario uncertaintyScenario : state.getSelectedUncertaintyScenarios()) {
			currentTransposeFlowGraph = this.applyUncertaintyScenario(uncertaintyScenario, state, currentTransposeFlowGraph);
		}
		return currentTransposeFlowGraph;
	}

	private DFDUncertainTransposeFlowGraph applyUncertaintyScenario(UncertaintyScenario uncertaintyScenario,
																	UncertainState uncertainState, DFDUncertainTransposeFlowGraph currentTransposeFlowGraph) {
		if (uncertaintyScenario instanceof DFDExternalUncertaintyScenario castedScenario) {
			return applyExternalUncertaintyScenario(castedScenario, uncertainState, currentTransposeFlowGraph);
		} else if (uncertaintyScenario instanceof DFDBehaviorUncertaintyScenario castedScenario) {
			return applyBehaviorUncertaintyScenario(castedScenario, uncertainState, currentTransposeFlowGraph);
		} else if (uncertaintyScenario instanceof DFDInterfaceUncertaintyScenario castedScenario) {
			return applyInterfaceUncertaintyScenario(castedScenario, uncertainState, currentTransposeFlowGraph);
		} else if (uncertaintyScenario instanceof DFDConnectorUncertaintyScenario castedScenario) {
			return applyConnectorUncertaintyScenario(castedScenario, uncertainState, currentTransposeFlowGraph);
		} else if (uncertaintyScenario instanceof DFDComponentUncertaintyScenario castedScenario) {
			return applyComponentUncertaintyScenario(castedScenario, uncertainState, currentTransposeFlowGraph);
		} else {
			throw new IllegalArgumentException("Unexpected DFD uncertainty scenario: %s"
					.formatted(UncertaintyUtils.getUncertaintyScenarioName(uncertaintyScenario)));
		}
	}

	private DFDUncertainTransposeFlowGraph applyExternalUncertaintyScenario(DFDExternalUncertaintyScenario uncertaintyScenario,
																			UncertainState uncertainState, AbstractTransposeFlowGraph currentTransposeFlowGraph) {

		DFDExternalUncertaintySource uncertaintySource = (DFDExternalUncertaintySource) uncertaintyScenario
				.eContainer();
		Node target = uncertaintySource.getTarget();
		Node targetCopy;

		if (target instanceof External) {
			targetCopy = dataflowdiagramFactory.eINSTANCE.createExternal();
		} else if (target instanceof Process) {
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
		        it.getPinDFDVertexMap().keySet().forEach(key -> copiedPinDFDVertexMap.put(key, it.getPinDFDVertexMap().get(key).clone()));
				mapping.put(it, new DFDVertex(targetCopy, copiedPinDFDVertexMap, new HashMap<>(it.getPinFlowMap())));
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

	private DFDUncertainTransposeFlowGraph applyBehaviorUncertaintyScenario(DFDBehaviorUncertaintyScenario uncertaintyScenario, UncertainState uncertainState, AbstractTransposeFlowGraph currentTransposeFlowGraph) {
		DFDBehaviorUncertaintySource uncertaintySource = (DFDBehaviorUncertaintySource) uncertaintyScenario;
		Behaviour targetBehaviour = uncertaintySource.getTarget();
		List<AbstractAssignment> targetedAssignments = uncertaintySource.getTargetAssignments();
		
		List<AbstractAssignment> filteredAssignments = targetBehaviour.getAssignment().stream()
				.filter(it -> !(targetedAssignments.contains(it)))
				.toList();
		List<AbstractAssignment> addedAssignments = uncertaintyScenario.getTargetAssignments();
		
		Behaviour resultBehaviour = datadictionaryFactory.eINSTANCE.createBehaviour();
		resultBehaviour.setEntityName(targetBehaviour.getEntityName());
		resultBehaviour.setId(targetBehaviour.getId());
		resultBehaviour.getAssignment().addAll(filteredAssignments);
		resultBehaviour.getAssignment().addAll(addedAssignments);
		
		List<DFDVertex> targetedNodes = currentTransposeFlowGraph.getVertices().stream()
				.filter(DFDVertex.class::isInstance)
				.map(DFDVertex.class::cast)
				.filter(it -> it.getReferencedElement().getBehaviour().equals(targetBehaviour))
				.toList();
		
		if (targetedNodes.size() < 1) {
			throw new IllegalStateException("Found no targeted nodes by behaviour uncertainty");
		}
		
		Map<DFDVertex, DFDVertex> mapping = new IdentityHashMap<>();
		targetedNodes.forEach(node -> {
			Node target = node.getReferencedElement();
			Node targetCopy;

			if (target instanceof External) {
				targetCopy = dataflowdiagramFactory.eINSTANCE.createExternal();
			} else if (target instanceof Process) {
				targetCopy = dataflowdiagramFactory.eINSTANCE.createProcess();
			} else if (target instanceof Store) {
				targetCopy = dataflowdiagramFactory.eINSTANCE.createStore();
			} else {
				throw new IllegalArgumentException("Unexpected DFD node type.");
			}

			targetCopy.setEntityName(target.getEntityName());
			targetCopy.setBehaviour(target.getBehaviour());
			
			Map<Pin, DFDVertex> copiedPinDFDVertexMap = new HashMap<>();
	        node.getPinDFDVertexMap().keySet().forEach(key -> copiedPinDFDVertexMap.put(key, node.getPinDFDVertexMap().get(key).clone()));
			mapping.put(node, new DFDVertex(targetCopy, copiedPinDFDVertexMap, new HashMap<>(node.getPinFlowMap())));
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

	private DFDUncertainTransposeFlowGraph applyInterfaceUncertaintyScenario(DFDInterfaceUncertaintyScenario uncertaintyScenario, UncertainState uncertainState, AbstractTransposeFlowGraph currentTransposeFlowGraph) {
		DFDInterfaceUncertaintySource uncertaintySource = (DFDInterfaceUncertaintySource) uncertaintyScenario.eContainer();
		Flow targetFlow = uncertaintySource.getTargetFlow();
		Pin targetPin = uncertaintySource.getTargetInPin();
		Node targetNode = (Node) targetPin.eContainer().eContainer();
		
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
		} else if (targetNode instanceof Process) {
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
					modifiedVertexMap.keySet().forEach(key -> copiedPinDFDVertexMap.put(key, modifiedVertexMap.get(key).clone()));

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

	private DFDUncertainTransposeFlowGraph applyConnectorUncertaintyScenario(DFDConnectorUncertaintyScenario uncertaintyScenario, UncertainState uncertainState, AbstractTransposeFlowGraph currentTransposeFlowGraph) {
		DFDConnectorUncertaintySource uncertaintySource = (DFDConnectorUncertaintySource) uncertaintyScenario.eContainer();
		Flow targetFlow = uncertaintySource.getTargetFlow();
		List<AbstractAssignment> targetAssignments = uncertaintySource.getTargetAssignments();
		
		Flow replacingFlow = uncertaintyScenario.getTargetFlow();
		List<AbstractAssignment> replacingAssignments = uncertaintyScenario.getTargetAssignments();
		
		// TODO Auto-generated method stub
		throw new IllegalStateException("Not yet supported uncertainty type.");
	}

	private DFDUncertainTransposeFlowGraph applyComponentUncertaintyScenario(DFDComponentUncertaintyScenario uncertaintyScenario, UncertainState uncertainState, AbstractTransposeFlowGraph currentTransposeFlowGraph) {
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
		        it.getPinDFDVertexMap().keySet().forEach(key -> copiedPinDFDVertexMap.put(key, it.getPinDFDVertexMap().get(key).clone()));
				mapping.put(it, new DFDVertex(replacingNode, copiedPinDFDVertexMap, new HashMap<>(it.getPinFlowMap())));
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

	@Override
	public List<? extends UncertaintySource> getRelevantUncertaintySources() {
		return this.relevantUncertaintySources;
	}

	@Override
	public UncertainState getUncertainState() {
		return this.uncertainState.orElseThrow();
	}
}
