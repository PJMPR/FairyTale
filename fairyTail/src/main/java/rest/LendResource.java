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


import domain.model.Book;
import domain.model.Lend;
import rest.dto.LendDto;

@Path("/lend")
@Stateless
public class LendResource {

	
	
	 @PersistenceContext
	 EntityManager entityManager;
	 
	 
	 @GET
	  @Produces(MediaType.APPLICATION_JSON)
	    public Response getAll(){
	    	List<Lend> result = new ArrayList<Lend>();
	    	for(Lend l: entityManager.createNamedQuery("lend.all",Lend.class).getResultList())
	    	{
	        	result.add(l);
	        }
	        return Response.ok(new GenericEntity<List<Lend>>(result){}).build();
	    }
	 
	 @GET
	    @Path("/{id}/book")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getLend(@PathParam("id") int id) {
	        Book result = entityManager
	                .createNamedQuery("lend.bookId", Book.class)
	                .setParameter("bookId", id)
	                .getSingleResult();
	        if (result == null) {
	            return Response.status(404).build();
	        }
	        return Response.ok(result).build();
	    }
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response Add(Lend lend)
	 {
		 entityManager.persist(lend);
		 return Response.ok(lend.getId()).build();	
	 }
	 
	 @GET
	    @Path("/{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response get(@PathParam("id") int id) {
	        Lend result = entityManager
	                .createNamedQuery("lend.id", Lend.class)
	                .setParameter("id", id)
	                .getSingleResult();
	        if (result == null) {
	            return Response.status(404).build();
	        }
	        return Response.ok(result).build();
	    }
}
