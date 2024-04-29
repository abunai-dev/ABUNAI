package dev.abunai.confidentiality.analysis.core;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import com.google.common.collect.Streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;

/**
 * This class represents an uncertain state of a transpose flow graph.
 * An uncertain state contains a list of selected scenarios that apply to the given uncertain state
 */
public class UncertainState {
	private final List<? extends UncertaintyScenario> selectedScenarios;

	/**
	 * Create a new uncertain state with a given list of selected scenarios
	 * @param selectedScenarios List of uncertainty scenarios that were selected for the uncertain state
	 */
	public UncertainState(List<? extends UncertaintyScenario> selectedScenarios) {
		this.selectedScenarios = selectedScenarios;
	}

	/**
	 * Create a new uncertain state with a given list of selected scenarios
	 * @param selectedScenarios List of uncertainty scenarios that were selected for the uncertain state
	 */
	public UncertainState(UncertaintyScenario... selectedScenarios) {
		this(List.of(selectedScenarios));
	}

	/**
	 * Returns a list of all uncertainty sources that the selected scenarios are part of
	 * @return Returns a list of all applied uncertainty sources
	 */
	public List<UncertaintySource> getUncertaintySources() {
        return selectedScenarios.stream().map(EObject::eContainer)
				.map(UncertaintySource.class::cast)
				.toList();
	}

	/**
	 * Returns a list of all uncertainty scenarios that were selected by the uncertain state
	 * @return Returns a list of all selected uncertainty scenarios
	 */
	public List<? extends UncertaintyScenario> getSelectedUncertaintyScenarios() {
		return Collections.unmodifiableList(selectedScenarios);
	}

	/**
	 * Returns the mapping between applied uncertainty scenarios and their uncertainty sources
	 * @return Returns the mapping between uncertainty scenarios and uncertainty sources
	 */
	public Map<UncertaintySource, UncertaintyScenario> getSourceToScenarioMapping() {
		Map<UncertaintySource, UncertaintyScenario> mapping = new HashMap<>();

		for (UncertaintyScenario scenario : this.selectedScenarios) {
			UncertaintySource source = (UncertaintySource) scenario.eContainer();
			mapping.put(source, scenario);
		}

		return mapping;
	}

	/**
	 * Fills the uncertain state with scenarios for all uncertainty sources in the given list.
	 * Should an uncertainty source miss an uncertainty scenario for an uncertainty source, a default one will be created
	 * @param uncertaintySources List of uncertainty sources that the uncertain state should cover
	 * @return Returns a new uncertain state that covers all given uncertainty sources
	 */
	public UncertainState fillWithDefaultScenarios(List<UncertaintySource> uncertaintySources) {
		List<UncertaintySource> alreadyContainedUncertaintySources = selectedScenarios.stream().map(EObject::eContainer)
				.map(UncertaintySource.class::cast).toList();

		List<UncertaintyScenario> additionalDefaultScenarios = new ArrayList<>();

		for (UncertaintySource source : uncertaintySources) {
			if (!alreadyContainedUncertaintySources.contains(source)) {

				List<? extends UncertaintyScenario> defaultScenarios = UncertaintyUtils.getUncertaintyScenarios(source)
						.stream().filter(it -> UncertaintyUtils.isDefaultScenario(source, it)).toList();

				if (defaultScenarios.size() != 1) {
					throw new IllegalArgumentException("More than one or zero default scenarios found in %s."
							.formatted(UncertaintyUtils.getUncertaintySourceName(source)));
				} else {
					additionalDefaultScenarios.add(defaultScenarios.get(0));
				}
			}
		}

		return new UncertainState(
				Streams.concat(selectedScenarios.stream(), additionalDefaultScenarios.stream()).toList());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null || getClass() != obj.getClass()) {
			return false;
		} else {
			UncertainState state = (UncertainState) obj;
			return state.getSelectedUncertaintyScenarios().containsAll(this.getSelectedUncertaintyScenarios())
					&& this.getSelectedUncertaintyScenarios().containsAll(state.getSelectedUncertaintyScenarios());
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(selectedScenarios);
	}

	@Override
	public String toString() {
		String scenarioNames = this.getSelectedUncertaintyScenarios().stream()
				.map(UncertaintyUtils::getUncertaintyScenarioName).collect(Collectors.joining(", "));

		return "[%s]".formatted(scenarioNames);
	}

	public static long calculateNumberOfAllUncertainStates(List<? extends UncertaintySource> uncertaintySources) {
		return uncertaintySources.stream().map(UncertaintyUtils::getUncertaintyScenarios).mapToLong(List::size)
				.reduce(1L, Math::multiplyExact);
	}

	/**
	 * Returns a list of all uncertain states that can be created with the list of given uncertainty sources
	 * @param relevantUncertaintySources List of uncertainty sources that are considered
	 * @return Returns a list of all uncertain states created by the list of uncertainty sources
	 */
	public static List<UncertainState> createAllUncertainStates(
			List<? extends UncertaintySource> relevantUncertaintySources) {
		List<List<UncertaintyScenario>> listOfAllScenarioLists = new ArrayList<>();
		for (UncertaintySource source : relevantUncertaintySources) {
			List<UncertaintyScenario> allScenarios = UncertaintyUtils.getUncertaintyScenarios(source).stream()
					.map(UncertaintyScenario.class::cast).toList();
			listOfAllScenarioLists.add(allScenarios);
		}

		List<List<UncertaintyScenario>> cartesianProduct = cartesianProduct(listOfAllScenarioLists);
		return cartesianProduct.stream().map(UncertainState::new).toList();
	}

	private static <T> List<List<T>> cartesianProduct(List<List<T>> lists) {
		List<List<T>> result = new ArrayList<>();
		if (lists == null || lists.isEmpty()) {
			result.add(new ArrayList<>());
			return result;
		}

		List<T> firstList = lists.get(0);
		List<List<T>> remainingLists = cartesianProduct(lists.subList(1, lists.size()));

		for (T element : firstList) {
			for (List<T> remainingList : remainingLists) {
				List<T> temp = new ArrayList<>();
				temp.add(element);
				temp.addAll(remainingList);
				result.add(temp);
			}
		}

		return result;
	}

}
