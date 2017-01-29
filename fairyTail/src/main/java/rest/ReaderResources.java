package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import domain.model.Reader;


@Path("/reader")
@Stateless
public class ReaderResources {

	
	 @PersistenceContext
	 EntityManager entityManager;
	 
	 @GET
	  @Produces(MediaType.APPLICATION_JSON)
	    public Response getAll(){
	    	List<Reader> result = new ArrayList<Reader>();
	    	for(Reader r: entityManager.createNamedQuery("reader.all",Reader.class).getResultList())
	    	{
	        	result.add(r);
	        }

	       
	        return Response.ok(new GenericEntity<List<Reader>>(result){}).build();
	    }
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response Add(Reader reader)
	 {
		 entityManager.persist(reader);
		 return Response.ok(reader.getId()).build();	
	 }
	 
	    @GET
	    @Path("/{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response get(@PathParam("id") int id) {
	        Reader result = entityManager.createNamedQuery("person.id", Reader.class)
	                .setParameter("id", id)
	                .getSingleResult();
	        if (result == null) {
	            return Response.status(404).build();
	        }
	        return Response.ok(result).build();
	    }
}
