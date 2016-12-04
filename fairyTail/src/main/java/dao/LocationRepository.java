package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.mappers.IMapResultSetIntoEntity;
import dao.repositories.ILocationRepository;
import dao.uow.IUnitOfWork;
import domain.model.Location;

public class LocationRepository extends BaseRepository<Location> implements ILocationRepository{

	private PreparedStatement getCity;
	private PreparedStatement getStreet;
	
	protected LocationRepository(Connection connection, IMapResultSetIntoEntity<Location> mapper,IUnitOfWork uow) {
		super(connection, mapper,uow);
		try{
			getCity = connection.prepareStatement(getCitySql());
			getStreet = connection.prepareStatement(getStreetSql());
		}catch(SQLException e)
		{
			e.printStackTrace();
		}

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

	protected String getCitySql()
	{
		return "SELECT * FROM location WHERE city=?";
	}
	protected String getStreetSql()
	{
		return "SELECT * FROM location WHERE street=?";
	}
	@Override
	protected String tableName() {
		
		return "location";
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

	public List<Location> fromCity(String city) {
		List<Location> result = new ArrayList<Location>();
		try {
			getCity.setString(1, city);		
			ResultSet rs = getCity.executeQuery();
			while (rs.next()) {
				result.add(mapper.map(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public List<Location> fromStreet(String street) {
		List<Location> result = new ArrayList<Location>();
		try {
			getStreet.setString(1, street);	
			ResultSet rs = getStreet.executeQuery();
			while (rs.next()) {
				result.add(mapper.map(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return result;
	}

}
