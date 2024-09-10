package dev.abunai.confidentiality.analysis.evaluation.factory.builder.dataflow;

import java.util.Optional;

import org.dataflowanalysis.pcm.extension.dictionary.characterized.DataDictionaryCharacterized.EnumCharacteristicType;
import org.dataflowanalysis.pcm.extension.dictionary.characterized.DataDictionaryCharacterized.Literal;
import org.dataflowanalysis.pcm.extension.dictionary.characterized.DataDictionaryCharacterized.expressions.ExpressionsFactory;
import org.dataflowanalysis.pcm.extension.dictionary.characterized.DataDictionaryCharacterized.expressions.Term;
import org.dataflowanalysis.pcm.extension.model.confidentiality.ConfidentialityFactory;
import org.dataflowanalysis.pcm.extension.model.confidentiality.ConfidentialityVariableCharacterisation;
import org.dataflowanalysis.pcm.extension.model.confidentiality.expression.ExpressionFactory;
import org.dataflowanalysis.pcm.extension.model.confidentiality.expression.LhsEnumCharacteristicReference;
import org.palladiosimulator.pcm.parameter.ParameterFactory;
import org.palladiosimulator.pcm.parameter.VariableUsage;
import org.palladiosimulator.pcm.repository.OperationRequiredRole;
import org.palladiosimulator.pcm.repository.OperationSignature;
import org.palladiosimulator.pcm.seff.ExternalCallAction;

public class SEFFCallBuilder {
	private SEFFBuilder builder;
	private ExternalCallAction call;
	
	private SEFFCallBuilder(ExternalCallAction call, SEFFBuilder builder) {
		this.call = call;
		this.builder = builder;
	}
	
	public static SEFFCallBuilder builder(ExternalCallAction call, SEFFBuilder builder) {
		return new SEFFCallBuilder(call, builder);
	}

	public SEFFCallBuilder setCallee(OperationRequiredRole requiredRole, OperationSignature signature) {
		this.call.setRole_ExternalService(requiredRole);
		this.call.setCalledService_ExternalService(signature);
		return this;
	}
	
	public SEFFCallBuilder addInputCharacteristic(EnumCharacteristicType characteristicType, Optional<String> characteristicValue) {
		Literal literal = null;
		if (characteristicValue.isPresent()) {
			literal = characteristicType.getType().getLiterals().stream()
					.filter(it -> it.getName().equalsIgnoreCase(characteristicValue.get()))
					.findAny().orElseThrow(() -> new IllegalArgumentException("Unknown characteristic value"));
		}
		
		VariableUsage usage = ParameterFactory.eINSTANCE.createVariableUsage();
		ConfidentialityVariableCharacterisation characterisation = ConfidentialityFactory.eINSTANCE.createConfidentialityVariableCharacterisation();
		usage.setCallAction__VariableUsage(call);
		characterisation.setVariableUsage_VariableCharacterisation(usage);
		LhsEnumCharacteristicReference lhs = ExpressionFactory.eINSTANCE.createLhsEnumCharacteristicReference();
 		lhs.setCharacteristicType(characteristicType);
		lhs.setLiteral(literal);
		characterisation.setLhs(lhs);
		Term term = ExpressionsFactory.eINSTANCE.createTrue();
		characterisation.setRhs(term);
		return this;
	}
	
	public SEFFCallBuilder addOutputCharacteristic(EnumCharacteristicType characteristicType, Optional<String> characteristicValue) {
		Literal literal = null;
		if (characteristicValue.isPresent()) {
			literal = characteristicType.getType().getLiterals().stream()
					.filter(it -> it.getName().equalsIgnoreCase(characteristicValue.get()))
					.findAny().orElseThrow(() -> new IllegalArgumentException("Unknown characteristic value"));
		}
		VariableUsage usage = ParameterFactory.eINSTANCE.createVariableUsage();
		ConfidentialityVariableCharacterisation characterisation = ConfidentialityFactory.eINSTANCE.createConfidentialityVariableCharacterisation();
		usage.setCallReturnAction__VariableUsage(call);
		characterisation.setVariableUsage_VariableCharacterisation(usage);
		LhsEnumCharacteristicReference lhs = ExpressionFactory.eINSTANCE.createLhsEnumCharacteristicReference();
 		lhs.setCharacteristicType(characteristicType);
		lhs.setLiteral(literal);
		characterisation.setLhs(lhs);
		Term term = ExpressionsFactory.eINSTANCE.createTrue();
		characterisation.setRhs(term);
		return this;
	}
	
	public SEFFBuilder buildCall() {
		return this.builder;
	}
}
