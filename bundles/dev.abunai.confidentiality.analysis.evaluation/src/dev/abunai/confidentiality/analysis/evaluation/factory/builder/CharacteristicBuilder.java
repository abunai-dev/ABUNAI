package dev.abunai.confidentiality.analysis.evaluation.factory.builder;

import java.util.UUID;

import org.dataflowanalysis.pcm.extension.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedFactory;
import org.dataflowanalysis.pcm.extension.dictionary.characterized.DataDictionaryCharacterized.EnumCharacteristicType;
import org.dataflowanalysis.pcm.extension.dictionary.characterized.DataDictionaryCharacterized.Enumeration;
import org.dataflowanalysis.pcm.extension.dictionary.characterized.DataDictionaryCharacterized.Literal;
import org.dataflowanalysis.pcm.extension.model.confidentiality.dictionary.PCMDataDictionary;

public class CharacteristicBuilder {
	private PCMDataDictionary dictionary;
	private EnumCharacteristicType characteristicType;
	private Enumeration enumeration;
	
	private CharacteristicBuilder(PCMDataDictionary dictionary) {
		this.dictionary = dictionary;
		this.characteristicType = DataDictionaryCharacterizedFactory.eINSTANCE.createEnumCharacteristicType();
		this.characteristicType.setId(UUID.randomUUID().toString());
		this.enumeration = DataDictionaryCharacterizedFactory.eINSTANCE.createEnumeration();
		this.enumeration.setId(UUID.randomUUID().toString());
		this.characteristicType.setType(enumeration);
		this.dictionary.getCharacteristicTypes().add(characteristicType);
		this.dictionary.getCharacteristicEnumerations().add(enumeration);
	}
	
	public static CharacteristicBuilder builder(PCMDataDictionary dictionary) {
		return new CharacteristicBuilder(dictionary);
	}
	
	public CharacteristicBuilder setName(String name) {
		this.characteristicType.setName(name);
		this.enumeration.setName(name);
		return this;
	}
	
	public CharacteristicBuilder addCharacteristicValue(String name) {
		Literal literal = DataDictionaryCharacterizedFactory.eINSTANCE.createLiteral();
		literal.setId(UUID.randomUUID().toString());
		literal.setName(name);
		literal.setEnum(enumeration);
		return this;
	}
	
	public EnumCharacteristicType build() {
		return this.characteristicType;
	}
}
