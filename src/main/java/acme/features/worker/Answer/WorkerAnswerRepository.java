
package acme.features.worker.Answer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.application.Application;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface WorkerAnswerRepository extends AbstractRepository {

	@Query("select a from Application a where a.id = ?1")
	Application findAppOneById(int id);

	@Query("select a.application from Answer a where a.id = ?1")
	Application findAppByAnswerId(int id);

}
