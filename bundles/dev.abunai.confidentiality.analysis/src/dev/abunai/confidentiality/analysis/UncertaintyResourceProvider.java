package dev.abunai.confidentiality.analysis;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySourceCollection;

public interface UncertaintyResourceProvider {
	UncertaintySourceCollection getUncertaintySourceCollection();
}
