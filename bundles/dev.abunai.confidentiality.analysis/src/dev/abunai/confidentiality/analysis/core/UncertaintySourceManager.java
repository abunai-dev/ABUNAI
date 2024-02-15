package dev.abunai.confidentiality.analysis.core;

import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySourceCollection;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMUncertaintySource;

public class UncertaintySourceManager {

	private final Logger logger = Logger.getLogger(UncertaintySourceManager.class);

	private final List<UncertaintySource> validatedUncertaintySources;
	private final UncertaintySourceType uncertaintySourceType;

	public UncertaintySourceManager(UncertaintySourceCollection uncertaintySourceCollection,
			UncertaintySourceType uncertaintySourceType) {

		this.uncertaintySourceType = uncertaintySourceType;
		this.validatedUncertaintySources = this.validateUncertaintySources(uncertaintySourceCollection);
	}

	public List<UncertaintySource> getUncertaintySources() {
		return Collections.unmodifiableList(this.validatedUncertaintySources);
	}

	private List<UncertaintySource> validateUncertaintySources(
			UncertaintySourceCollection uncertaintySourceCollection) {
		logger.info("Started validating uncertainty sources.");

		validateEMFModel(uncertaintySourceCollection);

		List<UncertaintySource> uncertaintySources = uncertaintySourceCollection.getSources();
		uncertaintySources.forEach(this::validateUncertaintySourceTypes);
		uncertaintySources.forEach(this::validateScenarioProbabilities);
		uncertaintySources.forEach(this::validateDefaultScenario);
		
		// TODO: Validation should check that there is at least one action sequence for each scenario
		// There is even one of these errors in the current test cases (should be 6 instead of 4)

		logger.info("Finished validating uncertainty sources.");
		return uncertaintySources;
	}

	private void validateEMFModel(UncertaintySourceCollection uncertaintySourceCollection) {
		Diagnostic result = Diagnostician.INSTANCE.validate(uncertaintySourceCollection);

		if (!result.getChildren().isEmpty()) {
			result.getChildren().forEach(it -> logger.error(it.getMessage()));
			throw new IllegalArgumentException("EMF model validation of uncertainty sources failed.");
		}
	}

	private void validateUncertaintySourceTypes(UncertaintySource uncertaintySource) {
		String errorMessage = "Uncertainty type missmatch: Found %s uncertainty sources in a %s analysis.";

		if (uncertaintySourceType == UncertaintySourceType.DFD
				&& !(uncertaintySource instanceof DFDUncertaintySource)) {
			throw new IllegalArgumentException(errorMessage.formatted("DFD", "PCM"));
		}

		if (uncertaintySourceType == UncertaintySourceType.PCM
				&& !(uncertaintySource instanceof PCMUncertaintySource)) {
			throw new IllegalArgumentException(errorMessage.formatted("PCM", "DFD"));
		}
	}

	private void validateScenarioProbabilities(UncertaintySource uncertaintySource) {
		List<? extends UncertaintyScenario> scenarios = UncertaintyUtils.getUncertaintyScenarios(uncertaintySource);

		if (scenarios.stream().allMatch(it -> it.getProbability() == -1.0)) {
			return;
		}

		if (scenarios.stream().anyMatch(it -> it.getProbability() < 0.0)) {
			logger.warn("Mixed probabilities in %s, resetting to -1.0 (no probabilities)."
					.formatted(UncertaintyUtils.getUncertaintySourceName(uncertaintySource)));

			scenarios.forEach(it -> it.setProbability(-1.0));
			return;
		}

		Double sumOfAllProbabilities = scenarios.stream().mapToDouble(UncertaintyScenario::getProbability).sum();
		if (sumOfAllProbabilities > 1.0) {
			logger.warn("Sum of all probabilities in %s is higher than 1.0, resetting to -1.0 (no probabilities)."
					.formatted(UncertaintyUtils.getUncertaintySourceName(uncertaintySource)));

			scenarios.forEach(it -> it.setProbability(-1.0));
			return;
		}
	}

	private void validateDefaultScenario(UncertaintySource uncertaintySource) {
		List<? extends UncertaintyScenario> scenarios = UncertaintyUtils.getUncertaintyScenarios(uncertaintySource);

		if (scenarios.size() == 0) {
			logger.warn("No scenarios in %s. Creating a default scenario now."
					.formatted(UncertaintyUtils.getUncertaintySourceName(uncertaintySource)));
			UncertaintyUtils.addDefaultScenario(uncertaintySource);

		} else if (!scenarios.stream().anyMatch(it -> UncertaintyUtils.isDefaultScenario(uncertaintySource, it))) {
			logger.warn("No default scenario in %s. Creating one now."
					.formatted(UncertaintyUtils.getUncertaintySourceName(uncertaintySource)));
			UncertaintyUtils.addDefaultScenario(uncertaintySource);
		}
	}

}
