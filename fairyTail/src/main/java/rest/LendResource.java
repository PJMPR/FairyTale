package rest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Path;

@Path("/lend")
public class LendResource {

	 @PersistenceContext
	 EntityManager entityManager;
}
