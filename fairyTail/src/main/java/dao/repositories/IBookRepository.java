package dao.repositories;

import java.util.List;

import domain.model.Book;

public interface IBookRepository extends IRepository<Book> {

	public List<Book> author (String author);
	
	public List<Book> withName (String name);
	
	
}
