package dao;

import java.sql.Connection;

import dao.mappers.BookMapper;
import dao.mappers.EnumDictionaryMapper;
import dao.mappers.LendMapper;
import dao.mappers.LocationMapper;
import dao.mappers.ReaderMapper;
import dao.repositories.IBookRepository;
import dao.repositories.IEnumDictionaryRepository;
import dao.repositories.ILendRepository;
import dao.repositories.ILocationRepository;
import dao.repositories.IReaderRepository;
import dao.repositories.IRepositoryCatalog;
import dao.uow.IUnitOfWork;

public class RepositoryCatalog implements IRepositoryCatalog {

	private Connection connection;
	private IUnitOfWork uow;

	public RepositoryCatalog(Connection connection,IUnitOfWork uow)
	{
		this.connection = connection;
		this.uow = uow;
	}
	public IBookRepository Book() {
		return new BookRepository(connection, new BookMapper(), uow);

	}

	public IEnumDictionaryRepository EnumDictionary() {
		return new EnumDictionaryRepository(connection, new EnumDictionaryMapper(), uow);

	}

	public IReaderRepository Reader() {
		return new ReaderRepository(connection, new ReaderMapper(), uow);

	}

	public ILocationRepository Location() {
		return new LocationRepository(connection, new LocationMapper(), uow);

	}

	public ILendRepository Lend() {
		return new LendRepository(connection, new LendMapper(), uow);

	}
	public void save() {
		       uow.saveChanges();
	}


}
