package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.model.Book;

public class BookMapper implements IMapResultSetIntoEntity<Book> {

	public Book map(ResultSet rs) throws SQLException {
		Book book = new Book();
		book.setId(rs.getInt("id"));
		book.setName(rs.getString("name"));
		book.setAuthor(rs.getString("author"));
		book.setDateOfReleased(rs.getDate("dateOfReleased"));
		book.setPublisher(rs.getString("publisher"));
		book.setPageCount(rs.getInt("pageCount"));
		return book;
	}

}
