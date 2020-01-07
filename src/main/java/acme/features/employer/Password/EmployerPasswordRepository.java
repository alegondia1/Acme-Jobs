
package acme.features.employer.Password;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.ejuno.Ejuno;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerPasswordRepository extends AbstractRepository {

	@Query("select a from Ejuno a where a.id = ?1")
	Ejuno findEjunoOneById(int id);

	@Query("select a.ejuno from Job a where a.id = ?1")
	Ejuno findEjunoByJobId(int id);

}
