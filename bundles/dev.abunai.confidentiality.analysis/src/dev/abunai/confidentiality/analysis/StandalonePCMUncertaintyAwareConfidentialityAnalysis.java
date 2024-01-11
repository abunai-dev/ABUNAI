package dev.abunai.confidentiality.analysis;

import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintyFactory;

public class StandalonePCMUncertaintyAwareConfidentialityAnalysis {
	
	public StandalonePCMUncertaintyAwareConfidentialityAnalysis() {
		var x = UncertaintyFactory.eINSTANCE.createUncertaintySourceCollection();
		var y = UncertaintyFactory.eINSTANCE.createBehaviorUncertaintySource();
		x.getSources().add(y);
		System.out.println(x);
	}

}
