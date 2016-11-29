package dao.repositories;

import java.util.List;

import domain.model.Location;
import domain.model.Reader;

public interface IReaderRepository  extends IRepository<Reader>{

 List<Reader> fromAddress (Location address);
	
}
