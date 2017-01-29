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


@Path("/book")
@Stateless
public class BookResource {

	
	
	 @PersistenceContext
	 EntityManager entityManager;
	 
	 @GET
	  @Produces(MediaType.APPLICATION_JSON)
	    public Response getAll(){
	    	List<Book> result = new ArrayList<Book>();
	    	for(Book b: entityManager.createNamedQuery("book.all",Book.class).getResultList())
	    	{
	        	result.add(b);
	        }

	       
	        return Response.ok(new GenericEntity<List<Book>>(result){}).build();
	    }
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response Add(Book book)
	 {
		 entityManager.persist(book);
		 return Response.ok(book.getId()).build();	
	 }
	 
	 
	 @GET
	    @Path("/{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response get(@PathParam("id") int id) {
	        Book result = entityManager
	                .createNamedQuery("book.id", Book.class)
	                .setParameter("bookId", id)
	                .getSingleResult();
	        if (result == null) {
	            return Response.status(404).build();
	        }
	        return Response.ok(result).build();
	    }
}
