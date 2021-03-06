package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.mappers.IMapResultSetIntoEntity;
import dao.repositories.IReaderRepository;
import dao.uow.IUnitOfWork;
import domain.model.Location;
import domain.model.Reader;

public class ReaderRepository extends BaseRepository<Reader> implements IReaderRepository{

	
	private PreparedStatement getAddress;
	public ReaderRepository(Connection connection, IMapResultSetIntoEntity<Reader> mapper,IUnitOfWork uow) {
		super(connection,mapper,uow);
		try{
			getAddress = connection.prepareStatement(getAddressSql());
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	protected String createTableSql() {
		return "" + "CREATE TABLE reader("
				+ "id bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,"
				+ "firstName varchar(20)," 
				+ "lastName varchar(50)," + 
				"phoneNumber varchar(9),"+ "email varchar(20), " +"ADDRESS_ID int,"+
				"FOREIGN KEY (ADDRESS_ID) REFERENCES address(id)"+")";
	}

	@Override
	protected String tableName() {
		return "reader";
	}

	@Override
	protected String insertSql() {
		return "INSERT INTO reader(firstName, lastName,phoneNumber,email,ADDRESS_ID) VALUES (?,?,?,?,?)";
	}

	@Override
	protected String updateSql() {
		return "UPDATE reader SET (firstName, lastName,phoneNumber,email,ADDRESS_ID)=(?,?,?,?,?) WHERE id=?";
	}
	
	protected String getAddressSql()
	{
		return "SELECT * FROM reader WHERE ADDRESS_ID=?";
	}

	@Override
	protected void setUpdate(Reader entity) throws SQLException {
		update.setString(1, entity.getFirstName());
		update.setString(2, entity.getLastName());
		update.setString(3, entity.getPhoneNumber());
		update.setString(4, entity.getEmail());
		update.setInt(5, entity.getLocation().getId());
		
	}

	@Override
	protected void setInsert(Reader entity) throws SQLException {
		insert.setString(1, entity.getFirstName());
		insert.setString(2, entity.getLastName());
		insert.setString(3, entity.getPhoneNumber());
		insert.setString(4, entity.getEmail());
		insert.setInt(5, entity.getLocation().getId());
		
	}
	
	
	public List<Reader> fromAddress(Location address) {
		List<Reader> reader = new ArrayList<Reader>();
		try{
			getAddress.setObject(1, address);
			ResultSet rs = getAddress.executeQuery();
			while (rs.next()) {
				reader.add(mapper.map(rs));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return reader;
	}
}
