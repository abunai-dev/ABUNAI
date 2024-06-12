package dev.abunai.confidentiality.analysis.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySourceCollection;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDUncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.pcm.PCMUncertaintySource;

/**
 * This class manages the uncertainty sources contained in the model
 */
public class UncertaintySourceManager {

	private final Logger logger = Logger.getLogger(UncertaintySourceManager.class);

	private final List<UncertaintySource> validatedUncertaintySources;
	private final UncertaintySourceType uncertaintySourceType;
	private final Optional<String> stringFilter;
	private final Optional<List<Integer>> indices;

	/**
	 * Create a new uncertainty source manager with the given uncertainty source collection model element and the type of uncertainty sources (e.g. PCM or DFD)
	 * @param uncertaintySourceCollection Uncertainty source collection model element, which contains the uncertainty sources
	 * @param uncertaintySourceType Uncertainty source type (e.g. PCM or DFD)
	 */
	public UncertaintySourceManager(UncertaintySourceCollection uncertaintySourceCollection,
			UncertaintySourceType uncertaintySourceType) {

		this.uncertaintySourceType = uncertaintySourceType;
		this.validatedUncertaintySources = this.validateUncertaintySources(uncertaintySourceCollection);
		this.stringFilter = Optional.empty();
		this.indices = Optional.empty();
	}

	/**
	 * Create a new uncertainty source manager with the given uncertainty source collection model element and the type of uncertainty sources (e.g. PCM or DFD)
	 * @param uncertaintySourceCollection Uncertainty source collection model element, which contains the uncertainty sources
	 * @param uncertaintySourceType Uncertainty source type (e.g. PCM or DFD)
	 * @param filter String filter that the uncertainty source name must contain
	 */
	public UncertaintySourceManager(UncertaintySourceCollection uncertaintySourceCollection,
									UncertaintySourceType uncertaintySourceType, Optional<String> filter, Optional<List<Integer>> indices) {

		this.uncertaintySourceType = uncertaintySourceType;
		this.validatedUncertaintySources = this.validateUncertaintySources(uncertaintySourceCollection);
		this.stringFilter = filter;
		this.indices = indices;
	}

	/**
	 * Returns a list of all uncertainty sources contained in the uncertainty source collection
	 * @return Returns a list of all uncertainty sources in the model
	 */
	public List<UncertaintySource> getUncertaintySources() {
		if (this.stringFilter.isPresent()) {
			return this.validatedUncertaintySources.stream()
					.filter(it -> it.getEntityName().contains(this.stringFilter.get()))
					.collect(Collectors.toUnmodifiableList());
		}
		if (this.indices.isPresent()) {
			List<UncertaintySource> result = new ArrayList<>();
			for (int index : this.indices.get()) {
				result.add(this.validatedUncertaintySources.get(index));
			}
			return Collections.unmodifiableList(result);
		}
		return Collections.unmodifiableList(this.validatedUncertaintySources);
	}

	/**
	 * Validate the uncertainty sources contained in the uncertainty source collection
	 * @param uncertaintySourceCollection Model element containing the uncertainty sources that should be validated
	 * @return Returns a list of all validated uncertainty sources
	 */
	private List<UncertaintySource> validateUncertaintySources(
			UncertaintySourceCollection uncertaintySourceCollection) {
		logger.info("Started validating uncertainty sources.");

		validateEMFModel(uncertaintySourceCollection);

		List<UncertaintySource> uncertaintySources = uncertaintySourceCollection.getSources();
		uncertaintySources.forEach(this::validateUncertaintySourceTypes);
		uncertaintySources.forEach(this::validateScenarioProbabilities);
		uncertaintySources.forEach(this::validateDefaultScenario);

		logger.info("Finished validating uncertainty sources.");
		return uncertaintySources;
	}

	/**
	 * Validates the emf model of the given uncertainty source collection
	 * @param uncertaintySourceCollection Uncertainty source collection that should be validated
	 */
	private void validateEMFModel(UncertaintySourceCollection uncertaintySourceCollection) {
		Diagnostic result = Diagnostician.INSTANCE.validate(uncertaintySourceCollection);

		if (!result.getChildren().isEmpty()) {
			result.getChildren().forEach(it -> logger.error(it.getMessage()));
			throw new IllegalArgumentException("EMF model validation of uncertainty sources failed.");
		}
	}

	/**
	 * Validate the given uncertainty source type whether it conforms to the uncertainty source type stored
	 * @param uncertaintySource Given uncertainty source type that should be validated
	 */
	private void validateUncertaintySourceTypes(UncertaintySource uncertaintySource) {
		String errorMessage = "Uncertainty type mismatch: Found %s uncertainty sources in a %s analysis.";

		if (uncertaintySourceType == UncertaintySourceType.DFD
				&& !(uncertaintySource instanceof DFDUncertaintySource)) {
			throw new IllegalArgumentException(errorMessage.formatted("DFD", "PCM"));
		}

		if (uncertaintySourceType == UncertaintySourceType.PCM
				&& !(uncertaintySource instanceof PCMUncertaintySource)) {
			throw new IllegalArgumentException(errorMessage.formatted("PCM", "DFD"));
		}
	}

	/**
	 * Validates the probabilities of an uncertainty source with its given uncertainty scenarios
	 * @param uncertaintySource Uncertainty source that should be validated
	 */
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

		double sumOfAllProbabilities = scenarios.stream().mapToDouble(UncertaintyScenario::getProbability).sum();
		if (sumOfAllProbabilities > 1.0) {
			logger.warn("Sum of all probabilities in %s is higher than 1.0, resetting to -1.0 (no probabilities)."
					.formatted(UncertaintyUtils.getUncertaintySourceName(uncertaintySource)));

			scenarios.forEach(it -> it.setProbability(-1.0));
        }
	}

	/**
	 * Validates the default scenario of the uncertainty source
	 * @param uncertaintySource Given uncertainty source of which the default scenario should be validated
	 */
	private void validateDefaultScenario(UncertaintySource uncertaintySource) {
		List<? extends UncertaintyScenario> scenarios = UncertaintyUtils.getUncertaintyScenarios(uncertaintySource);

		if (scenarios.isEmpty()) {
			logger.warn("No scenarios in %s. Creating a default scenario now."
					.formatted(UncertaintyUtils.getUncertaintySourceName(uncertaintySource)));
			UncertaintyUtils.addDefaultScenario(uncertaintySource);

		} else if (scenarios.stream().noneMatch(it -> UncertaintyUtils.isDefaultScenario(uncertaintySource, it))) {
			logger.warn("No default scenario in %s. Creating one now."
					.formatted(UncertaintyUtils.getUncertaintySourceName(uncertaintySource)));
			UncertaintyUtils.addDefaultScenario(uncertaintySource);
		}
	}

}
