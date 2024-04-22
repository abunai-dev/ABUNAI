package dev.abunai.confidentiality.analysis.pcm.proxy;

import org.dataflowanalysis.analysis.core.CharacteristicValue;
import org.dataflowanalysis.analysis.pcm.core.AbstractPCMVertex;
import org.dataflowanalysis.analysis.pcm.core.PCMVertexCharacteristicsCalculator;
import org.dataflowanalysis.analysis.pcm.core.user.UserPCMVertex;
import org.dataflowanalysis.analysis.resource.ResourceProvider;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.AbstractAssignee;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.Assignments;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.NodeCharacteristicsFactory;
import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;

import java.util.ArrayList;
import java.util.List;

public class UncertainUserPCMVertex<T extends AbstractUserAction> extends UserPCMVertex<T> {
    private final List<AbstractAssignee> addedAssignees;

    public UncertainUserPCMVertex(T element, ResourceProvider resourceProvider, List<AbstractAssignee> addedAssignees) {
        super(element, resourceProvider);
        this.addedAssignees = addedAssignees;
    }

    public UncertainUserPCMVertex(T element, List<? extends AbstractPCMVertex<?>> previousElements, ResourceProvider resourceProvider, List<AbstractAssignee> addedAssignees) {
        super(element, previousElements, resourceProvider);
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
