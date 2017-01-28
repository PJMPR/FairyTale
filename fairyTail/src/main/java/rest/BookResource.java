package rest;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import domain.model.Book;
import rest.dto.BookDto;

@Path("/book")
public class BookResource {

	Mapper mapper = new DozerBeanMapper();
	
	 @PersistenceContext
	 EntityManager entityManager;
	 
	 @GET
	  @Produces(MediaType.APPLICATION_JSON)
	    public Response getAll(){
	    	List<BookDto> result = new ArrayList<BookDto>();
	    	for(Book b: entityManager.createNamedQuery("book.all",Book.class).getResultList())
	    	{
	        	result.add(mapper.map(b,BookDto.class));
	        }

	       
	        return Response.ok(new GenericEntity<List<BookDto>>(result){}).build();
	    }
}
