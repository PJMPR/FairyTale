package dao.repositories;

import java.util.List;

import domain.model.EnumDictionary;

public interface IEnumDictionaryRepository {


	public List<EnumDictionary> withDictionaryName(String enumName);
	public List<EnumDictionary> getEnumValues(String enumName, String stringKey);
	public List<EnumDictionary> getEnumValues(String enumName, int intKey);
}
