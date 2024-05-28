package dev.abunai.confidentiality.analysis.pcm.proxy;

import org.dataflowanalysis.analysis.core.CharacteristicValue;
import org.dataflowanalysis.analysis.pcm.core.AbstractPCMVertex;
import org.dataflowanalysis.analysis.pcm.core.PCMVertexCharacteristicsCalculator;
import org.dataflowanalysis.analysis.pcm.core.user.CallingUserPCMVertex;
import org.dataflowanalysis.analysis.resource.ResourceProvider;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.AbstractAssignee;
import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;

import java.util.List;
import java.util.Map;

public class UncertainCallingUserPCMVertex extends CallingUserPCMVertex {
    private final Map<AbstractAssignee, AbstractAssignee> assignmentMapping;

    public UncertainCallingUserPCMVertex(EntryLevelSystemCall element, List<? extends AbstractPCMVertex<?>> previousElements, boolean isCalling, ResourceProvider resourceProvider, Map<AbstractAssignee, AbstractAssignee> assignmentMapping) {
        super(element, previousElements, isCalling, resourceProvider);
        this.assignmentMapping = assignmentMapping;
    }

    @Override
    protected List<CharacteristicValue> getVertexCharacteristics() {
        PCMVertexCharacteristicsCalculator vertexCharacteristicsCalculator = new PCMVertexCharacteristicsCalculator(this.resourceProvider);
        return vertexCharacteristicsCalculator.getVertexCharacteristics(this.referencedElement, this.context, assignmentMapping);
    }
}
