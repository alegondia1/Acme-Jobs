
package acme.features.authenticated.request;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.request.Request;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedRequestRepository extends AbstractRepository {

	@Query("select r from Request r where r.id = ?1")
	Request findOneById(int id);

	@Query("select r from Request r")
	Collection<Request> findManyAll();

	@Query("select r from Request r where r.deadline > current_date()")
	Collection<Request> findManyActive();

	@Query("select r.ticker from Request r")
	Collection<String> findManyAllTicker();
}
