
package acme.features.authenticated.dutys;

import org.springframework.data.jpa.repository.Query;

import acme.entities.dutys.Duty;
import acme.framework.repositories.AbstractRepository;

public interface AuthenticatedDutysRepository extends AbstractRepository {

	@Query("select r from Duty r where r.id = ?1")
	Duty findOneById(int id);

}
