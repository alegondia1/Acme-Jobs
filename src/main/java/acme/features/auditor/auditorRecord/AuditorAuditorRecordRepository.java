
package acme.features.auditor.auditorRecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditorRecord.AuditorRecord;
import acme.entities.jobs.Job;
import acme.entities.roles.Auditor;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorAuditorRecordRepository extends AbstractRepository {

	@Query("select a from AuditorRecord a where a.id = ?1")
	AuditorRecord findOneById(int id);

	@Query("select a from AuditorRecord a where a.job.id = ?1 and a.status = true")
	Collection<AuditorRecord> findManyByJobId(int id);

	@Query("select a from AuditorRecord a where a.auditor.id = ?1")
	Collection<AuditorRecord> findManyByAuditorId(int id);

	@Query("select a from Auditor a where a.id = ?1")
	Auditor findOneAuditorById(int id);

	@Query("select j from Job j where j.id= ?1")
	Job findOneJobById(int id);
}
