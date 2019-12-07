
package acme.features.worker.justification;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.justification.Justification;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface WorkerJustificationRepository extends AbstractRepository {

	@Query("select a from Justification a where a.id = ?1")
	Justification findOneById(int id);

	@Query("select a from Justification a where a.application.id = ?1")
	Justification findJustificationByApplicationId(int id);
}
