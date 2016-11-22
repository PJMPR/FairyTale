package dao.repositories;

import java.util.List;

import domain.model.Location;


public interface ILocationRepository extends IRepository<Location>{
	public List<Location> fromCity(String city);
	
	public List<Location> fromStreet(String street);
}
