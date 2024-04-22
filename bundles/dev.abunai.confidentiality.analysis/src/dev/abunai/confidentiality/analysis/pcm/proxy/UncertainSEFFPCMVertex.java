package dev.abunai.confidentiality.analysis.pcm.proxy;

import org.dataflowanalysis.analysis.core.CharacteristicValue;
import org.dataflowanalysis.analysis.pcm.core.AbstractPCMVertex;
import org.dataflowanalysis.analysis.pcm.core.PCMVertexCharacteristicsCalculator;
import org.dataflowanalysis.analysis.pcm.core.seff.SEFFPCMVertex;
import org.dataflowanalysis.analysis.resource.ResourceProvider;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.AbstractAssignee;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.Assignments;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.NodeCharacteristicsFactory;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.Parameter;
import org.palladiosimulator.pcm.seff.AbstractAction;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class UncertainSEFFPCMVertex<T extends AbstractAction> extends SEFFPCMVertex<T> {
    private final List<AbstractAssignee> addedAssignees;

    public UncertainSEFFPCMVertex(T element, List<? extends AbstractPCMVertex<?>> previousElements, Deque<AssemblyContext> context, List<Parameter> parameter, ResourceProvider resourceProvider, List<AbstractAssignee> addedAssignees) {
        super(element, previousElements, context, parameter, resourceProvider);
        this.addedAssignees = addedAssignees;
    }

    @Override
    protected List<CharacteristicValue> getVertexCharacteristics() {
        List<CharacteristicValue> vertexCharacteristics = new ArrayList<>(super.getVertexCharacteristics());

        Assignments assignments = NodeCharacteristicsFactory.eINSTANCE.createAssignments();
        assignments.getAssignee().addAll(addedAssignees);

        PCMVertexCharacteristicsCalculator vertexCharacteristicsCalculator = new PCMVertexCharacteristicsCalculator(this.resourceProvider);
        vertexCharacteristics.addAll(vertexCharacteristicsCalculator.getNodeCharacteristics(this.referencedElement, this.context, assignments));
        return vertexCharacteristics;
    }
}
