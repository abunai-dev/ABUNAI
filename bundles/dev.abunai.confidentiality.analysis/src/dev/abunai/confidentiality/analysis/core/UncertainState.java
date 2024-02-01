package dev.abunai.confidentiality.analysis.core;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;

import org.eclipse.emf.ecore.EObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySourceCollection;
import dev.abunai.confidentiality.analysis.model.uncertainty.dfd.DFDExternalUncertaintySource;

public class UncertainState {

	private final List<UncertaintySource> uncertaintiesWithOriginalScenario = new ArrayList<>();
	private final List<UncertaintySource> uncertaintiesWithAlternativeScenario = new ArrayList<>();
	private final List<UncertaintyScenario> selectedUncertaintyScenarios = new ArrayList<>();

	public UncertainState(List<UncertaintySource> involvedUncertaintySources,
			List<UncertaintyScenario> selectedScenarios) {

		registerScenariosAndCorrespondingSources(involvedUncertaintySources, selectedScenarios);
		registerRemainingSources(involvedUncertaintySources);
	}

	private void registerScenariosAndCorrespondingSources(List<UncertaintySource> involvedUncertaintySources,
			List<UncertaintyScenario> selectedScenarios) {
		for (var scenario : selectedScenarios) {
			var uncertaintySource = (UncertaintySource) scenario.eContainer();

			if (involvedUncertaintySources.contains(uncertaintySource)) {
				this.uncertaintiesWithAlternativeScenario.add(uncertaintySource);
				this.selectedUncertaintyScenarios.add(scenario);
			} else {
				throw new IllegalArgumentException(
						"All selected uncertainties must be contained in an involved uncertainty source.");
			}
		}
	}

	private void registerRemainingSources(List<UncertaintySource> involvedUncertaintySources) {
		for (var uncertaintySource : involvedUncertaintySources) {
			if (!this.uncertaintiesWithAlternativeScenario.contains(uncertaintySource)) {
				this.uncertaintiesWithOriginalScenario.add(uncertaintySource);
			}
		}
	}

	public List<UncertaintySource> getUncertaintiesWithOriginalScenario() {
		return Collections.unmodifiableList(uncertaintiesWithOriginalScenario);
	}

	public List<UncertaintySource> getUncertaintiesWithAlternativeScenario() {
		return Collections.unmodifiableList(uncertaintiesWithAlternativeScenario);
	}

	public List<UncertaintyScenario> getSelectedUncertaintyScenarios() {
		return Collections.unmodifiableList(selectedUncertaintyScenarios);
	}

	public Map<UncertaintySource, Optional<UncertaintyScenario>> getSourceToScenarioMapping() {
		Map<UncertaintySource, Optional<UncertaintyScenario>> mapping = new TreeMap<>();

		for (var scenario : this.selectedUncertaintyScenarios) {
			var source = (UncertaintySource) scenario.eContainer();
			mapping.put(source, Optional.of(scenario));
		}

		for (var source : this.uncertaintiesWithOriginalScenario) {
			mapping.put(source, Optional.empty());
		}

		return mapping;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null || getClass() != obj.getClass()) {
			return false;
		} else {
			UncertainState state = (UncertainState) obj;
			return uncertaintiesWithAlternativeScenario.equals(state.getUncertaintiesWithAlternativeScenario())
					&& uncertaintiesWithOriginalScenario.equals(state.getUncertaintiesWithOriginalScenario())
					&& selectedUncertaintyScenarios.equals(state.getSelectedUncertaintyScenarios());
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(uncertaintiesWithAlternativeScenario, uncertaintiesWithOriginalScenario,
				selectedUncertaintyScenarios);
	}

	public static List<UncertainState> createAllTheoreticallyPossibleStates(
			UncertaintySourceCollection uncertaintySourceCollection) {
		List<UncertainState> states = new ArrayList<>();

		List<List<Object>> listOfUncertaintiesAndScenarios = new ArrayList<>();
		for (var source : uncertaintySourceCollection.getSources()) {
			List<Object> possibleStates = new ArrayList<>();
			possibleStates.add(source);
			possibleStates.addAll(getUncertaintyScenarios(source));
			listOfUncertaintiesAndScenarios.add(possibleStates);
		}

		List<List<Object>> cartesianProduct = cartesianProductWithoutDuplicates(listOfUncertaintiesAndScenarios);

		for (var state : cartesianProduct) {
			var selectedUncertaintyScenarios = state.stream().filter(UncertaintyScenario.class::isInstance)
					.map(UncertaintyScenario.class::cast).toList();

			states.add(new UncertainState(uncertaintySourceCollection.getSources(), selectedUncertaintyScenarios));
		}

		return states;
	}

	private static List<List<Object>> cartesianProductWithoutDuplicates(List<List<Object>> lists) {
		List<List<Object>> result = new ArrayList<>();
		if (lists == null || lists.isEmpty()) {
			result.add(new ArrayList<>());
			return result;
		}

		List<Object> firstList = lists.get(0);
		List<List<Object>> remainingLists = cartesianProductWithoutDuplicates(lists.subList(1, lists.size()));

		for (Object element : firstList) {
			for (List<Object> remainingList : remainingLists) {
				List<Object> temp = new ArrayList<>();
				temp.add(element);
				temp.addAll(remainingList);
				if (!result.contains(temp)) { // Avoid duplicates
					result.add(temp);
				}
			}
		}

		return result;
	}

	public static List<UncertaintyScenario> getUncertaintyScenarios(UncertaintySource uncertaintySource) {
		// Blame EMF, not me
		if (uncertaintySource instanceof DFDExternalUncertaintySource s) {
			 
		}
		
		return null;
	}
}
