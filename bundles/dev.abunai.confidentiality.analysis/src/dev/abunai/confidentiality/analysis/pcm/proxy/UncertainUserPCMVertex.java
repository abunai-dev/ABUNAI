package dev.abunai.confidentiality.analysis.pcm.proxy;

import org.dataflowanalysis.analysis.core.CharacteristicValue;
import org.dataflowanalysis.analysis.pcm.core.AbstractPCMVertex;
import org.dataflowanalysis.analysis.pcm.core.PCMVertexCharacteristicsCalculator;
import org.dataflowanalysis.analysis.pcm.core.user.UserPCMVertex;
import org.dataflowanalysis.analysis.resource.ResourceProvider;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.AbstractAssignee;
import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UncertainUserPCMVertex<T extends AbstractUserAction> extends UserPCMVertex<T> {
    private final Map<AbstractAssignee, AbstractAssignee> assignmentMapping;

    public UncertainUserPCMVertex(T element, ResourceProvider resourceProvider, Map<AbstractAssignee, AbstractAssignee> assignmentMapping) {
        super(element, resourceProvider);
        this.assignmentMapping = assignmentMapping;
    }

    public UncertainUserPCMVertex(T element, List<? extends AbstractPCMVertex<?>> previousElements, ResourceProvider resourceProvider, Map<AbstractAssignee, AbstractAssignee> assignmentMapping) {
        super(element, previousElements, resourceProvider);
        this.assignmentMapping = assignmentMapping;
    }

    @Override
    protected List<CharacteristicValue> getVertexCharacteristics() {
       PCMVertexCharacteristicsCalculator vertexCharacteristicsCalculator = new PCMVertexCharacteristicsCalculator(this.resourceProvider);
       return vertexCharacteristicsCalculator.getNodeCharacteristics(this.referencedElement, this.context, assignmentMapping);
    }
}
