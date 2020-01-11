
package acme.features.employer.Nust;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Job;
import acme.entities.nust.Nust;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerNustRepository extends AbstractRepository {

	@Query("select r.nust from Job r where r.id=?1")
	Nust findOneByJobId(int id);

	@Query("select r from Job r where r.id = ?1")
	Job findOneJobByJobId(int id);

	@Query("select r from Nust r where r.id = ?1")
	Nust findOneById(int id);

	@Query("select a from Job a where a.id = ?1")
	Job findJobOneById(int id);
}
