package dev.abunai.confidentiality.analysis.tests.dfd;

import org.junit.jupiter.api.Test;

import dev.abunai.confidentiality.analysis.tests.DFDTestBase;

public class OnlineShopTest extends DFDTestBase {

	@Override
	protected String getFolderName() {
		return "UncertainOnlineShopDFDsimple";
	}

	@Override
	protected String getFilesName() {
		return "onlineshop";
	}

	@Override
	protected String getBaseFolder() {
		return "models";
	}

	@Test
	void testAnalysis() {
		var sourceCollection = analysis.getUncertaintySourceCollection();
		System.out.println(sourceCollection.getSources().size());

		sourceCollection.getSources().forEach(source -> System.out.println(source.getClass().getSimpleName()));

		var evaluatedSequences = analysis.evaluateDataFlows(analysis.findAllSequences());
		System.out.println(evaluatedSequences.size());
	}

}
