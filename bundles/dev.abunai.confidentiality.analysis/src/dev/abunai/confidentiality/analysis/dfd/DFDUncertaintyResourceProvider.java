package dev.abunai.confidentiality.analysis.dfd;

import java.util.ArrayList;
import java.util.List;

import org.dataflowanalysis.analysis.dfd.resource.DFDURIResourceProvider;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import dev.abunai.confidentiality.analysis.UncertaintyResourceProvider;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySourceCollection;

/**
 * Resource provider for a dfd model with uncertainty resources
 */
public class DFDUncertaintyResourceProvider extends DFDURIResourceProvider implements UncertaintyResourceProvider {

	private final URI uncertaintyModelURI;
	private UncertaintySourceCollection uncertaintySourceCollection;

	public DFDUncertaintyResourceProvider(URI dataFlowDiagramURI, URI dataDictionaryURI, URI uncertaintyModelURI) {
		super(dataFlowDiagramURI, dataDictionaryURI);
		this.uncertaintyModelURI = uncertaintyModelURI;
	}

	@Override
	public void loadRequiredResources() {
		super.loadRequiredResources();
		this.uncertaintySourceCollection = (UncertaintySourceCollection) this.loadModelContent(uncertaintyModelURI);
		List<Resource> loadedResources;
		do {
			loadedResources = new ArrayList<>(this.resources.getResources());
			loadedResources.forEach(EcoreUtil::resolveAll);
		} while (loadedResources.size() != this.resources.getResources().size());
	}

	@Override
	public UncertaintySourceCollection getUncertaintySourceCollection() {
		return this.uncertaintySourceCollection;
	}
}
