package dev.abunai.confidentiality.analysis.evaluation;

import dev.abunai.confidentiality.analysis.UncertaintyAwareConfidentialityAnalysis;
import dev.abunai.confidentiality.analysis.core.UncertainFlowGraphCollection;
import dev.abunai.confidentiality.analysis.evaluation.factory.PCMModelFactory;
import dev.abunai.confidentiality.analysis.evaluation.result.ScalibilityParameter;
import dev.abunai.confidentiality.analysis.evaluation.testmodels.Activator;
import dev.abunai.confidentiality.analysis.pcm.PCMUncertaintyAwareConfidentialityAnalysisBuilder;

public class PCMAnalysisExecutor implements AnalysisExecutor {
    @Override
    public void executeAnalysis(ScalibilityParameter scalibilityParameter, PCMModelFactory modelFactory) {
        UncertaintyAwareConfidentialityAnalysis analysis = new PCMUncertaintyAwareConfidentialityAnalysisBuilder()
                .standalone()
                .modelProjectName(AnalysisUtils.TEST_MODEL_PROJECT_NAME)
                .usePluginActivator(Activator.class)
                .useCustomResourceProvider(new PCMMemoryResourceProvider(modelFactory.getResources()))
                .build();
        analysis.initializeAnalysis();
        UncertainFlowGraphCollection flowGraphs = (UncertainFlowGraphCollection) analysis.findFlowGraph();
        UncertainFlowGraphCollection uncertainFlowGraphs = flowGraphs.createUncertainFlows();
        scalibilityParameter.setResults(uncertainFlowGraphs);
    }

    @Override
    public String getPrefix() {
        return "";
    }
}
