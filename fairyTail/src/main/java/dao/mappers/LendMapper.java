package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.model.Lend;


public class LendMapper implements IMapResultSetIntoEntity<Lend> {

	public Lend map(ResultSet rs) throws SQLException {
		Lend lend = new Lend();
		lend.setId(rs.getInt("id"));
		lend.setDateOfLend(rs.getDate("dateOfLend"));
		lend.setDateOfRegive(rs.getDate("dateOfRegive"));
		return lend;
	}

}
