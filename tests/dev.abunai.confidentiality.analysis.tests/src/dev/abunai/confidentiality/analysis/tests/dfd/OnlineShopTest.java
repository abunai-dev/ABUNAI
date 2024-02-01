package dev.abunai.confidentiality.analysis.tests.dfd;

import org.junit.jupiter.api.Test;
import dev.abunai.confidentiality.analysis.core.UncertaintyUtils;
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
		var sourceCollection = analysis.getUncertaintySources();
		System.out.println(sourceCollection.size());

		sourceCollection.forEach(source -> System.out.println(source.getClass().getSimpleName()));

		var evaluatedSequences = analysis.evaluateDataFlows(analysis.findAllSequences());
		System.out.println(evaluatedSequences.size());
		System.out.println(UncertaintyUtils.getUncertaintySourceName(sourceCollection.get(0)));
	}

}
