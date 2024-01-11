package dev.abunai.confidentiality.analysis.tests;

import org.junit.jupiter.api.Test;

import dev.abunai.confidentiality.analysis.AnalysisMockup;
import dev.abunai.confidentiality.analysis.StandalonePCMUncertaintyAwareConfidentialityAnalysis;

public class AnalysisMockupTest {
	
	@Test
	public void testAnalysisMockup(){
		new AnalysisMockup("World");
		new StandalonePCMUncertaintyAwareConfidentialityAnalysis();
	}

}
