package dao;

import java.sql.Connection;
import java.sql.SQLException;

import dao.mappers.IMapResultSetIntoEntity;
import domain.model.Location;

public class LocationRepository extends BaseRepository<Location>{

	protected LocationRepository(Connection connection, IMapResultSetIntoEntity<Location> mapper) {
		super(connection, mapper);

	}

	@Override
	protected String insertSql() {
		return "INSERT INTO location(city,street) VALUES (?,?)";
	}

	@Override
	protected String updateSql() {
		return "UPDATE location SET(city,street)=(?,?) WHERE id=?";
	}

	@Override
	protected String createTableSql() {
		return "" + "CREATE TABLE location("
				+ "id bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,"
				+ "city varchar(20)," + "street varchar(50)"  
				+")";
	}

	@Override
	protected String tableName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setUpdate(Location entity) throws SQLException {
		update.setString(1, entity.getCity());
		update.setString(2, entity.getStreet());
		
		
	}

	@Override
	protected void setInsert(Location entity) throws SQLException {
		insert.setString(1, entity.getCity());
		insert.setString(2, entity.getStreet());
		
	}

}