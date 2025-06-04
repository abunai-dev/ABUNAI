package dev.abunai.confidentiality.analysis.tests;

import java.nio.file.Paths;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.resource.ResourceProvider;
import org.eclipse.core.runtime.Plugin;
import org.junit.jupiter.api.BeforeEach;
import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.repository.Repository;
import org.palladiosimulator.pcm.repository.RepositoryComponent;
import org.palladiosimulator.pcm.repository.RepositoryPackage;

import dev.abunai.confidentiality.analysis.UncertaintyAwareConfidentialityAnalysis;
import dev.abunai.confidentiality.analysis.core.UncertainConstraintViolation;
import dev.abunai.confidentiality.analysis.core.UncertainState;
import dev.abunai.confidentiality.analysis.core.UncertaintyUtils;
import dev.abunai.confidentiality.analysis.model.uncertainty.UncertaintySource;
import dev.abunai.confidentiality.analysis.pcm.PCMUncertainFlowGraphCollection;
import dev.abunai.confidentiality.analysis.pcm.PCMUncertaintyAwareConfidentialityAnalysisBuilder;
import dev.abunai.confidentiality.analysis.pcm.PCMUncertaintyResourceProvider;
import dev.abunai.confidentiality.analysis.testmodels.Activator;

public abstract class PCMTestBase extends TestBase {
	private Logger logger = Logger.getLogger(PCMTestBase.class);

	@Override
	protected String getBaseFolder() {
		return "models/pcm";
	}

	protected Class<? extends Plugin> getActivator() {
		return Activator.class;
	}

	protected String getModelProjectName() {
		return TEST_MODEL_PROJECT_NAME;
	}

	@BeforeEach
	public void setup() {
		final var usageModelPath = Paths.get(getBaseFolder(), getFolderName(), getFilesName() + ".usagemodel")
				.toString();
		final var allocationPath = Paths.get(getBaseFolder(), getFolderName(), getFilesName() + ".allocation")
				.toString();
		final var nodeCharacteristicsPath = Paths
				.get(getBaseFolder(), getFolderName(), getFilesName() + ".nodecharacteristics").toString();
		final var uncertaintyPath = Paths.get(getBaseFolder(), getFolderName(), getFilesName() + ".uncertainty")
				.toString();

		var builder = new PCMUncertaintyAwareConfidentialityAnalysisBuilder().standalone()
				.modelProjectName(getModelProjectName()).usePluginActivator(getActivator())
				.useUsageModel(usageModelPath).useAllocationModel(allocationPath).useUncertaintyModel(uncertaintyPath)
				.useNodeCharacteristicsModel(nodeCharacteristicsPath);

		UncertaintyAwareConfidentialityAnalysis analysis = builder.build();
		analysis.initializeAnalysis();
		this.analysis = analysis;
	}
	
	protected void printMetrics(String name, ResourceProvider resourceProvider, PCMUncertainFlowGraphCollection flowGraphCollection,  PCMUncertainFlowGraphCollection uncertainFlowGraphs, List<UncertainConstraintViolation> violations) {
		if (!(resourceProvider instanceof PCMUncertaintyResourceProvider pcmUncertaintyResourceProvider)) {
			logger.error("Resource provider is not an pcm uncertainty resource provider");
			throw new IllegalStateException();
		}
		Repository repository = (Repository) pcmUncertaintyResourceProvider.lookupToplevelElement(RepositoryPackage.eINSTANCE.getRepository()).get(0);
		List<RepositoryComponent> components = repository.getComponents__Repository();
		int numberComponents = components.size();
		int numberSEFFs = components.stream()
				.filter(BasicComponent.class::isInstance)
				.map(BasicComponent.class::cast)
				.map(it -> it.getServiceEffectSpecifications__BasicComponent().size())
				.reduce(0, (a,b) -> a+b);
		int numberTFGs = flowGraphCollection.getTransposeFlowGraphs().size();
		int numberVertices = flowGraphCollection.getTransposeFlowGraphs().stream()
				.map(it -> it.getVertices().size())
				.reduce(0, (a,b) -> a+b);
		int numberUncertainties = pcmUncertaintyResourceProvider.getUncertaintySourceCollection().getSources().size();
		int numberViolations = violations.size();
		StringJoiner violatingContextsBuilder = new StringJoiner(",\n");
		for (UncertainConstraintViolation violation : violations) {
			UncertainState state = violation.uncertainState();
			String scenarioNames = state.getSelectedUncertaintyScenarios().stream()
					.map(it -> {
						UncertaintySource source = (UncertaintySource) it.eContainer();
						if (UncertaintyUtils.isDefaultScenario(source, it)) {
							return source.getEntityName() + "-Default";
						}
						return it.getEntityName();
					})
					.collect(Collectors.joining(", "));
			String violatingNodes = violation.violations().stream()
					.map(it -> it.toString())
					.collect(Collectors.joining(", "));
			violatingContextsBuilder.add("[" + scenarioNames + "] --(" + violation.violations().size() + ")--> {" + violatingNodes + "}");
		}
		String violatingContexts = "[\n" + violatingContextsBuilder.toString() + "]";
		
		logger.info("-------- Results of Test Model " + name + "--------");
		logger.info("Number of Components: " + numberComponents);
		logger.info("Number of SEFFs: " + numberSEFFs);
		logger.info("Number of TFGs: " + numberTFGs);
		logger.info("Number of Vertices: " + numberVertices);
		logger.info("Number of Uncertainties: " + numberUncertainties);
		logger.info("Number of Violations: " + numberViolations);
		logger.info("Violating Uncertain States: " + violatingContexts);
		logger.info("-------------------------------" + "-".repeat(name.length()) + "--------");
	}
}
