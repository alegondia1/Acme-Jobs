
package acme.features.auditor.job;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditorRecord.AuditorRecord;
import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorJobRepository extends AbstractRepository {

	@Query("select r from Job r where r.id = ?1")
	Job findOneById(int id);

	@Query("select r from Job r where r.employer.id = ?1")
	Collection<Job> findManyByEmployerId(int id);

	@Query("select a.job from AuditorRecord a where a.auditor.id = ?1 and a.job.status = true and a.job.deadline > CURRENT_DATE")
	Collection<Job> findManyJobByAuditorId(int id);

	@Query("select a from Job a where a.status = true and a.deadline > CURRENT_DATE")
	Collection<Job> findManyJob();

	@Query("select r from AuditorRecord r where r.auditor.id = ?1 and r.job.id = ?2")
	AuditorRecord findAuditorRecordByAuditorIdAndJobId(int activeRoleId, int idJob);
}
