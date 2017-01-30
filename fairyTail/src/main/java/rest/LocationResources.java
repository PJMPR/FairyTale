package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domain.model.Location;

@Path("/location")
@Stateless
public class LocationResources {

	 @PersistenceContext
	 EntityManager entityManager;
	 
	 @GET
	  @Produces(MediaType.APPLICATION_JSON)
	    public Response getAll(){
	    	List<Location> result = new ArrayList<Location>();
	    	for(Location r: entityManager.createNamedQuery("location.all",Location.class).getResultList())
	    	{
	        	result.add(r);
	        }

	       
	        return Response.ok(new GenericEntity<List<Location>>(result){}).build();
	    }
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response Add(Location location)
	 {
		 entityManager.persist(location);
		 return Response.ok(location.getId()).build();	
	 }
}
