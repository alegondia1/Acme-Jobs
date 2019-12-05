
package acme.features.authenticated.auditorRecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditorRecord.AuditorRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedAuditorRecordRepository extends AbstractRepository {

	@Query("select a from AuditorRecord a where a.id = ?1")
	AuditorRecord findOneById(int id);

	@Query("select a from AuditorRecord a where a.job.id = ?1 and a.status = true")
	Collection<AuditorRecord> findManyByJobId(int id);

	@Query("select a from AuditorRecord a where a.auditor.id = ?1")
	Collection<AuditorRecord> findManyByAuditorId(int id);
}
