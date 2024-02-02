package dev.abunai.confidentiality.analysis.core;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyScenario;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;

public class UncertainState {

	private final List<? extends UncertaintyScenario> selectedScenarios;

	public UncertainState(List<? extends UncertaintyScenario> selectedScenarios) {
		this.selectedScenarios = selectedScenarios;
	}

	public UncertainState(UncertaintyScenario... selectedScenarios) {
		this(List.of(selectedScenarios));
	}

	public List<UncertaintySource> getUncertaintySources() {
		List<UncertaintySource> sources = selectedScenarios.stream().map(EObject::eContainer)
				.map(UncertaintySource.class::cast).toList();
		return Collections.unmodifiableList(sources);
	}

	public List<? extends UncertaintyScenario> getSelectedUncertaintyScenarios() {
		return Collections.unmodifiableList(selectedScenarios);
	}

	public Map<UncertaintySource, UncertaintyScenario> getSourceToScenarioMapping() {
		Map<UncertaintySource, UncertaintyScenario> mapping = new HashMap<>();

		for (var scenario : this.selectedScenarios) {
			var source = (UncertaintySource) scenario.eContainer();
			mapping.put(source, scenario);
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
				.map(it -> UncertaintyUtils.getUncertaintyScenarioName(it)).collect(Collectors.joining(", "));

		return "[%s]".formatted(scenarioNames);
	}

	public static List<UncertainState> createAllUncertainStates(List<UncertaintySource> uncertaintySources) {

		List<List<UncertaintyScenario>> listOfAllScenarioLists = new ArrayList<>();
		for (UncertaintySource source : uncertaintySources) {
			List<UncertaintyScenario> allScenarios = UncertaintyUtils.getUncertaintyScenarios(source).stream()
					.map(UncertaintyScenario.class::cast).toList();
			listOfAllScenarioLists.add(allScenarios);
		}

		List<List<UncertaintyScenario>> cartesianProduct = cartesianProduct(listOfAllScenarioLists);
		return cartesianProduct.stream().map(it -> new UncertainState(it)).toList();
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
