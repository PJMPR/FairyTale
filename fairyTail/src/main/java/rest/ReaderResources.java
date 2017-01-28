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
import domain.model.Reader;
import rest.dto.BookDto;
import rest.dto.ReaderDto;

@Path("/reader")
public class ReaderResources {

	 Mapper mapper = new DozerBeanMapper();
	 @PersistenceContext
	 EntityManager entityManager;
	 
	 @GET
	  @Produces(MediaType.APPLICATION_JSON)
	    public Response getAll(){
	    	List<ReaderDto> result = new ArrayList<ReaderDto>();
	    	for(Reader b: entityManager.createNamedQuery("reader.all",Reader.class).getResultList())
	    	{
	        	result.add(mapper.map(b,ReaderDto.class));
	        }

	       
	        return Response.ok(new GenericEntity<List<ReaderDto>>(result){}).build();
	    }
}
