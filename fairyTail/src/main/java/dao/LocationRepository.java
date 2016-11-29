package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.mappers.IMapResultSetIntoEntity;
import dao.repositories.ILocationRepository;
import dao.uow.IUnitOfWork;
import domain.model.Location;

public class LocationRepository extends BaseRepository<Location> implements ILocationRepository{

	protected LocationRepository(Connection connection, IMapResultSetIntoEntity<Location> mapper,IUnitOfWork uow) {
		super(connection, mapper,uow);

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

	public List<Location> fromCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Location> fromStreet(String street) {
		// TODO Auto-generated method stub
		return null;
	}

}
