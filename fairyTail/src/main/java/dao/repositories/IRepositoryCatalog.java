package dao.repositories;

public interface IRepositoryCatalog {

	public IBookRepository Book();
	public IEnumDictionaryRepository EnumDictionary();
	public IReaderRepository Reader();
	public ILocationRepository Location();
	public ILendRepository Lend();
	public void save();
}
