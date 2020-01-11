
package acme.features.employer.Password;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.nust.Nust;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerPasswordRepository extends AbstractRepository {

	@Query("select a from Nust a where a.id = ?1")
	Nust findNustOneById(int id);

	@Query("select a.nust from Job a where a.id = ?1")
	Nust findNustByJobId(int id);

}
