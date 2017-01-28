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

import domain.model.Lend;
import domain.model.Reader;
import rest.dto.LendDto;
import rest.dto.ReaderDto;

@Path("/lend")
public class LendResource {

	
	Mapper mapper = new DozerBeanMapper();
	 @PersistenceContext
	 EntityManager entityManager;
	 
	 
	 @GET
	  @Produces(MediaType.APPLICATION_JSON)
	    public Response getAll(){
	    	List<LendDto> result = new ArrayList<LendDto>();
	    	for(Lend b: entityManager.createNamedQuery("lend.all",Lend.class).getResultList())
	    	{
	        	result.add(mapper.map(b,LendDto.class));
	        }

	       
	        return Response.ok(new GenericEntity<List<LendDto>>(result){}).build();
	    }
}
