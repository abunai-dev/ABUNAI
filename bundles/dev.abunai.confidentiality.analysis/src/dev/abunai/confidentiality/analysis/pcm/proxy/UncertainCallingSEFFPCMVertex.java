package dev.abunai.confidentiality.analysis.pcm.proxy;

import org.dataflowanalysis.analysis.core.CharacteristicValue;
import org.dataflowanalysis.analysis.pcm.core.AbstractPCMVertex;
import org.dataflowanalysis.analysis.pcm.core.PCMVertexCharacteristicsCalculator;
import org.dataflowanalysis.analysis.pcm.core.seff.CallingSEFFPCMVertex;
import org.dataflowanalysis.analysis.resource.ResourceProvider;
import org.dataflowanalysis.pcm.extension.nodecharacteristics.nodecharacteristics.AbstractAssignee;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.Parameter;
import org.palladiosimulator.pcm.seff.ExternalCallAction;

import java.util.Deque;
import java.util.List;
import java.util.Map;

public class UncertainCallingSEFFPCMVertex extends CallingSEFFPCMVertex {
    private final Map<AbstractAssignee, AbstractAssignee> assignmentMapping;

    public UncertainCallingSEFFPCMVertex(ExternalCallAction element, List<? extends AbstractPCMVertex<?>> previousElements, Deque<AssemblyContext> context, List<Parameter> parameter, boolean isCalling, ResourceProvider resourceProvider, Map<AbstractAssignee, AbstractAssignee> assignmentMapping) {
        super(element, previousElements, context, parameter, isCalling, resourceProvider);
        this.assignmentMapping = assignmentMapping;
    }

    @Override
    protected List<CharacteristicValue> getVertexCharacteristics() {
        PCMVertexCharacteristicsCalculator vertexCharacteristicsCalculator = new PCMVertexCharacteristicsCalculator(this.resourceProvider);
        return vertexCharacteristicsCalculator.getVertexCharacteristics(this.referencedElement, this.context, assignmentMapping);
    }
}
