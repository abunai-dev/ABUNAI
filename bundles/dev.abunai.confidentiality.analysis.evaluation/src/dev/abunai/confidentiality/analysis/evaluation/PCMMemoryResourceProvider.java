package dev.abunai.confidentiality.analysis.evaluation;

import java.util.List;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyPackage;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySourceCollection;
import dev.abunai.confidentiality.analysis.pcm.PCMUncertaintyResourceProvider;
import org.eclipse.emf.ecore.resource.Resource;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.allocation.AllocationPackage;
import org.palladiosimulator.pcm.usagemodel.UsageModel;
import org.palladiosimulator.pcm.usagemodel.UsagemodelPackage;

public class PCMMemoryResourceProvider extends PCMUncertaintyResourceProvider {
    public PCMMemoryResourceProvider(List<Resource> resources) {
        super(null, null, null, null);
        this.resources.getResources().addAll(resources);
    }

    @Override
    public UsageModel getUsageModel() {
        for (Resource resource : this.resources.getResources()) {
            if (this.isTargetInResource(UsagemodelPackage.eINSTANCE.getUsageModel(),
                    resource)) {
                return (UsageModel) resource.getContents().get(0);
            }
        }
        throw new IllegalStateException("Resources do not contain a usage model");
    }

    @Override
    public Allocation getAllocation() {
        for (Resource resource : this.resources.getResources()) {
            if (this.isTargetInResource(AllocationPackage.eINSTANCE.getAllocation(),
                    resource)) {
                return (Allocation) resource.getContents().get(0);
            }
        }
        throw new IllegalStateException("Resources do not contain a allocation");
    }

    @Override
    public UncertaintySourceCollection getUncertaintySourceCollection() {
        for (Resource resource : this.resources.getResources()) {
            if (this.isTargetInResource(UncertaintyPackage.eINSTANCE.getUncertaintySourceCollection(),
                    resource)) {
                return (UncertaintySourceCollection) resource.getContents().get(0);
            }
        }
        throw new IllegalStateException("Resources do not contain a allocation");
    }

    @Override
    public void loadRequiredResources() {

    }
}
