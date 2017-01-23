package rest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Path;

@Path("/reader")
public class ReaderResources {

	 @PersistenceContext
	 EntityManager entityManager;
}
