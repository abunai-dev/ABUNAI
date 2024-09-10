package dev.abunai.confidentiality.analysis.evaluation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import dev.abunai.confidentiality.analysis.evaluation.result.ScalibilityParameter;
import dev.abunai.confidentiality.analysis.evaluation.result.ScalibilityTest;
import dev.abunai.confidentiality.analysis.evaluation.tests.CombinedUncertaintyTest;
import dev.abunai.confidentiality.analysis.evaluation.tests.PrimaryUncertaintyTest;
import dev.abunai.confidentiality.analysis.evaluation.tests.SecondaryUncertaintyTest;
import org.apache.log4j.Logger;

public class TestRunner {
	private static final int RUNS_PER_STAGE = 1;
	public static final String BASE_PATH = ".";
	
	private final Logger logger = Logger.getLogger(TestRunner.class);
	
	private List<ScalibilityTest> tests;
	private List<ScalibilityParameter> results;
	private AnalysisExecutor analysisExecutor;
	
	public TestRunner(List<ScalibilityTest> tests, AnalysisExecutor analysisExecutor) {
		this.tests = tests;
		this.results = new ArrayList<>();
		this.analysisExecutor = analysisExecutor;
	}
	
	public void runTests() {
		this.runTests(0);
	}
	
	public void runTests(int start) {
		for(int i = start; i < 8; i++) {
			for(ScalibilityTest test : this.tests) {
				logger.info("Running test with name " + test.getTestName());
				logger.info("Saving results to: " + new File(BASE_PATH).getAbsolutePath());
				this.runTest(test, i);
			}
		}
	}
	
	private void runTest(ScalibilityTest test, int index) {
		for (int j = 0; j < RUNS_PER_STAGE; j++) {
			int modelSize = test.getModelSize(index);
			String modelName = test.getTestName();
			logger.info("Running test with model " + modelName + " and size " + modelSize + ", Iteration: " + j);
			ScalibilityParameter parameter = new ScalibilityParameter(modelSize, test.getTestName());
			test.run(parameter, analysisExecutor);
			this.results.add(parameter);
			saveResults(analysisExecutor.getPrefix() + parameter.getTestName());
		}
	}
	
	private void saveResults(String testName) {
		try {
			FileOutputStream fileOutputStream
		      = new FileOutputStream(TestRunner.BASE_PATH + "/results/" + testName + ".ser");
		    ObjectOutputStream objectOutputStream 
		      = new ObjectOutputStream(fileOutputStream);
		    objectOutputStream.writeObject(this.results);
		    objectOutputStream.flush();
		    objectOutputStream.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static List<ScalibilityTest> getTests() {
		return List.of(
				new PrimaryUncertaintyTest(),
				new SecondaryUncertaintyTest(),
				new CombinedUncertaintyTest()
		);
	}
	
	public static List<ScalibilityTest> getAllTests() {
		return List.of(
				new PrimaryUncertaintyTest(),
				new SecondaryUncertaintyTest(),
				new CombinedUncertaintyTest()
		);
	}
}
