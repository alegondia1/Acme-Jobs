
package acme.features.employer.Ejuno;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.ejuno.Ejuno;
import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerEjunoRepository extends AbstractRepository {

	@Query("select r.ejuno from Job r where r.id=?1")
	Ejuno findOneByJobId(int id);

	@Query("select r from Job r where r.id = ?1")
	Job findOneJobByJobId(int id);

	@Query("select r from Ejuno r where r.id = ?1")
	Ejuno findOneById(int id);

	@Query("select a from Job a where a.id = ?1")
	Job findJobOneById(int id);
}
