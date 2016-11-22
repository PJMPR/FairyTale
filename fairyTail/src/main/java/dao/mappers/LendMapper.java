package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.model.Book;
import domain.model.Lend;
import domain.model.Reader;

public class LendMapper implements IMapResultSetIntoEntity<Lend> {

	public Lend map(ResultSet rs) throws SQLException {
		Lend lend = new Lend();
		lend.setId(rs.getInt("id"));
		lend.setReader((Reader) rs.getObject("READER_ID"));
		lend.setBook((Book) rs.getObject("BOOK_ID"));
		lend.setDateOfLend(rs.getDate("dateOfLend"));
		lend.setDateOfRegive(rs.getDate("dateOfRegive"));
		return null;
	}

}
