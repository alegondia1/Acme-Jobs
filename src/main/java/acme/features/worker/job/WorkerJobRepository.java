
package acme.features.worker.job;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface WorkerJobRepository extends AbstractRepository {

	@Query("select r from Job r where r.id = ?1")
	Job findOneById(int id);

	@Query("select r from Job r where r.employer.id = ?1")
	Collection<Job> findManyByEmployerId(int id);

	@Query("select r from Job r where r.status = true and r.deadline > CURRENT_DATE")
	Collection<Job> findManyActive();
}
