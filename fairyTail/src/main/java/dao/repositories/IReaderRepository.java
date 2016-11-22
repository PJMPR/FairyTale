package dao.repositories;

import java.util.List;

import domain.model.Location;
import domain.model.Reader;

public interface IReaderRepository  extends IRepository<Reader>{

	public List<Reader> fromAddress (Location address);
	
}
