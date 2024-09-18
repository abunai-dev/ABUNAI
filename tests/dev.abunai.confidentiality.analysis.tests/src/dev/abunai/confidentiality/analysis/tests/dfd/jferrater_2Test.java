package dev.abunai.confidentiality.analysis.tests.dfd;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Paths;
import java.util.List;

import org.dataflowanalysis.analysis.dfd.core.DFDVertex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.abunai.confidentiality.analysis.UncertaintyAwareConfidentialityAnalysis;
import dev.abunai.confidentiality.analysis.core.UncertainConstraintViolation;
import dev.abunai.confidentiality.analysis.dfd.DFDUncertainFlowGraphCollection;
import dev.abunai.confidentiality.analysis.dfd.DFDUncertaintyAwareConfidentialityAnalysisBuilder;
import dev.abunai.confidentiality.analysis.testmodels.Activator;
import dev.abunai.confidentiality.analysis.tests.DFDTestBase;

public class jferrater_2Test extends DFDTestBase {
    @Override
    protected String getBaseFolder() {
        return "casestudies/TuHH";
    }
    
    @Override
    protected String getFolderName() {
        return "jferrater";
    }
    
    
    @BeforeEach
    public void setup() {
        final var dataFlowDiagramPath = Paths.get(getBaseFolder(), getFolderName(), getFilesName() + ".dataflowdiagram")
                .toString();
        final var dataDictionaryPath = Paths.get(getBaseFolder(), getFolderName(), getFilesName() + ".datadictionary")
                .toString();
        final var uncertaintyPath = Paths.get(getBaseFolder(), getFolderName(), getUncertainName() + ".uncertainty")
                .toString();

        var builder = new DFDUncertaintyAwareConfidentialityAnalysisBuilder().standalone()
                .modelProjectName(TEST_MODEL_PROJECT_NAME).usePluginActivator(Activator.class)
                .useDataDictionary(dataDictionaryPath).useDataFlowDiagram(dataFlowDiagramPath)
                .useUncertaintyModel(uncertaintyPath);

        UncertaintyAwareConfidentialityAnalysis analysis = builder.build();
        analysis.initializeAnalysis();

        this.analysis = analysis;
    }
    
    @Override
    protected String getFilesName() {
        return "jferrater_0";
    }
    protected String getUncertainName() {
        return "jferrater";
    }

    
    @Test
    public void testResults() {
        DFDUncertainFlowGraphCollection flowGraphs = (DFDUncertainFlowGraphCollection) analysis.findFlowGraph();
        DFDUncertainFlowGraphCollection uncertainFlowGraphs = flowGraphs.createUncertainFlows();
        uncertainFlowGraphs.evaluate();
        
        List<UncertainConstraintViolation> resultAuth = analysis.queryUncertainDataFlow(uncertainFlowGraphs, it -> {
            return this.retrieveNodeLabels(it).contains("internal") && !this.retrieveDataLabels(it).contains("authenticated_request");
        });
        System.out.println("Authenticated request: " + resultAuth.size());
       
        List<UncertainConstraintViolation> resultSecret = analysis.queryUncertainDataNodes(uncertainFlowGraphs, "secret_manager");
        System.out.println("Secret manager: " + resultSecret.size());
        List<UncertainConstraintViolation> resultLoginAttempts = analysis.queryUncertainDataFlow(uncertainFlowGraphs, it -> {
            return this.retrieveNodeLabels(it).contains("authorization_server") && !this.retrieveNodeLabels(it).contains("login_attempts_regulation");
        });
        System.out.println("Login Attempts: " + resultLoginAttempts.size());
        List<UncertainConstraintViolation> resultEncryptExtern = analysis.queryUncertainDataFlow(uncertainFlowGraphs, it -> {
            return this.retrieveDataLabels(it).contains("entrypoint") && !this.retrieveDataLabels(it).contains("encrypted_connection");
        });
        System.out.println("Encrypt Extern: " + resultEncryptExtern.size());
        List<UncertainConstraintViolation> resultEncryptIntern = analysis.queryUncertainDataFlow(uncertainFlowGraphs, it -> {
            return this.retrieveNodeLabels(it).contains("internal") && !this.retrieveDataLabels(it).contains("encrypted_connection");
        });
        System.out.println("Encrypt Intern: " + resultEncryptIntern.size());

    }
}
