package dev.abunai.confidentiality.analysis.pcm.proxy;

import org.dataflowanalysis.analysis.core.CharacteristicValue;
import org.dataflowanalysis.analysis.pcm.core.AbstractPCMVertex;
import org.dataflowanalysis.analysis.pcm.core.PCMVertexCharacteristicsCalculator;
import org.dataflowanalysis.analysis.pcm.core.user.CallingUserPCMVertex;
import org.dataflowanalysis.analysis.resource.ResourceProvider;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.AbstractAssignee;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.Assignments;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.NodeCharacteristicsFactory;
import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;

import java.util.ArrayList;
import java.util.List;

public class UncertainCallingUserPCMVertex extends CallingUserPCMVertex {
    private final List<AbstractAssignee> addedAssignees;

    public UncertainCallingUserPCMVertex(EntryLevelSystemCall element, List<? extends AbstractPCMVertex<?>> previousElements, boolean isCalling, ResourceProvider resourceProvider, List<AbstractAssignee> addedAssignees) {
        super(element, previousElements, isCalling, resourceProvider);
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
