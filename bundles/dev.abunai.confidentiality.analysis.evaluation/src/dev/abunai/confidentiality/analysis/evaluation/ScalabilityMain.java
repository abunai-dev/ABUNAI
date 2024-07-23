package dev.abunai.confidentiality.analysis.evaluation;

public class ScalabilityMain {
    private static AnalysisExecutor analysisExecutor = new PCMAnalysisExecutor();

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("-export")) {
            ResultExporter exporter = new ResultExporter();
            exporter.exportResults(TestRunner.getAllTests(), analysisExecutor);
        } else if (args.length > 1 && args[0].equalsIgnoreCase("-start")) {
            int start = Integer.parseInt(args[1]);
            TestRunner runner = new TestRunner(TestRunner.getTests(), analysisExecutor);
            runner.runTests(start);
        } else {
            TestRunner runner = new TestRunner(TestRunner.getTests(), analysisExecutor);
            runner.runTests();
        }
    }
}
