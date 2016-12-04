package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.model.Book;
import domain.model.Category;

public class BookMapper implements IMapResultSetIntoEntity<Book> {

	public Book map(ResultSet rs) throws SQLException {
		Book book = new Book();
		book.setId(rs.getInt("id"));
		book.setName(rs.getString("name"));
		book.setAuthor(rs.getString("author"));
		book.setCategory(Category.valueOf(rs.getString("category")));
		book.setDateOfReleased(rs.getDate("dateOfReleased"));
		book.setPublisher(rs.getString("publisher"));
		book.setPageCount(rs.getInt("pageCount"));
		return book;
	}

}
