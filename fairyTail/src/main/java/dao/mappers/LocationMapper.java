package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.model.Location;

public class LocationMapper implements IMapResultSetIntoEntity<Location> {

	public Location map(ResultSet rs) throws SQLException {
		Location location = new Location();
		location.setCity(rs.getString("city"));
		location.setStreet(rs.getString("street"));
		return location;
	}

}
