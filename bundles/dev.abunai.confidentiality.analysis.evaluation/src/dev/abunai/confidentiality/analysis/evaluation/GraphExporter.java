package dev.abunai.confidentiality.analysis.evaluation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

import dev.abunai.confidentiality.analysis.evaluation.result.ScalibilityParameter;
import dev.abunai.confidentiality.analysis.evaluation.result.ScalibilityTest;

public class GraphExporter {

	public void exportResults(List<ScalibilityTest> tests, AnalysisExecutor analysisExecutor) {
		tests.forEach(it -> this.exportResult(it, analysisExecutor));
	}
	
	public void exportResult(ScalibilityTest test, AnalysisExecutor analysisExecutor) {
		try {
			FileInputStream input = new FileInputStream(TestRunner.BASE_PATH + "/results/" + test.getTestName() + ".ser");
			ObjectInputStream inputObjects = new ObjectInputStream(input);
			@SuppressWarnings("unchecked")
			List<ScalibilityParameter> inputData = (ArrayList<ScalibilityParameter>) inputObjects.readObject();
			Instant timestamp = Instant.now();
			FileOutputStream output = new FileOutputStream(TestRunner.BASE_PATH + "/results/graphs/" + test.getTestName() + timestamp.toString() + ".csv");
			this.writeHeader(output);
			Collections.sort(inputData);
			for(ScalibilityParameter parameter : inputData) {
				exportParameter(parameter, output);
				output.write(System.lineSeparator().getBytes());
			}
			inputObjects.close();
			input.close();
			System.out.println("Created Graph data: " + test.getTestName());
		} catch (FileNotFoundException e) {
			System.out.println("Skipping test: " + test.getTestName());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void writeHeader(FileOutputStream file) {
		StringJoiner string = new StringJoiner(",");
		string.add("index");
		string.add("scenario_aware");
		string.add("graph_aware");
		string.add("impact_aware");
		
		try {
			file.write((string.toString() + System.lineSeparator()).getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void exportParameter(ScalibilityParameter parameter, FileOutputStream file) {
		StringJoiner string = new StringJoiner(",");
		string.add(Long.toString(parameter.getModelSize()));
		string.add(Long.toString(parameter.getScenarioAwareComplexity()));
		string.add(Long.toString(parameter.getGraphAwareComplexity()));
		string.add(Long.toString(parameter.getImpactAwareComplexity()));
		
		
		
		try {
			file.write(string.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}