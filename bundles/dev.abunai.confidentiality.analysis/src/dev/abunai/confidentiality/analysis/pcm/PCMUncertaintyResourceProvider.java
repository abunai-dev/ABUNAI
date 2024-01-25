package dev.abunai.confidentiality.analysis.pcm;

import java.util.ArrayList;
import java.util.List;

import org.dataflowanalysis.analysis.pcm.resource.PCMURIResourceProvider;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import dev.abunai.confidentiality.analysis.UncertaintyResourceProvider;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySourceCollection;

public class PCMUncertaintyResourceProvider extends PCMURIResourceProvider implements UncertaintyResourceProvider {

	private URI uncertaintyModelURI;
	private UncertaintySourceCollection uncertaintySourceCollection;

	public PCMUncertaintyResourceProvider(URI usageModelURI, URI allocationModelURI, URI nodeCharacteristicsURI,
			URI uncertaintyModelURI) {
		super(usageModelURI, allocationModelURI, nodeCharacteristicsURI);
		this.uncertaintyModelURI = uncertaintyModelURI;
	}

	@Override
	public void loadRequiredResources() {
		super.loadRequiredResources();
		this.uncertaintySourceCollection = (UncertaintySourceCollection) this.loadModelContent(uncertaintyModelURI);
		List<Resource> loadedResources = null;
		do {
			loadedResources = new ArrayList<>(this.resources.getResources());
			loadedResources.forEach(it -> EcoreUtil.resolveAll(it));
		} while (loadedResources.size() != this.resources.getResources().size());
	}

	public UncertaintySourceCollection getUncertaintySourceCollection() {
		return this.uncertaintySourceCollection;
	}

}
