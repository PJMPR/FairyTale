package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.model.Reader;


public class ReaderMapper implements IMapResultSetIntoEntity<Reader>{

	public Reader map(ResultSet rs) throws SQLException {
		Reader reader = new Reader();
		reader.setId(rs.getInt("id"));
		reader.setFirstName(rs.getString("firstName"));
		reader.setLastName(rs.getString("lastName"));
		reader.setPhoneNumber(rs.getString("phoneNumber"));
		reader.setEmail(rs.getString("email"));
		return reader;
	}

}
