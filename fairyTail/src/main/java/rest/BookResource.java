package rest;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.model.Book;

@Path("/people")
public class BookResource {

	 @PersistenceContext
	 EntityManager entityManager;
	 
	 @GET
	  @Produces(MediaType.APPLICATION_JSON)
	    public List<Book> getAll(){
	    	List<Book> result = new ArrayList<Book>();
	        System.out.println("zaczynam pobierac dane");
	    	for(Book b: entityManager.createNamedQuery("person.all",Book.class).getResultList()){
	        	
	        	result.add(b);

	            System.out.println("zapisuje osobe "+ b.getName());
	        }

	        System.out.println("koncze");
	        return result;
	    }
}
