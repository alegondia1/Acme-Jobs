
package acme.features.worker.Ejdos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.application.Application;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface WorkerEjdosRepository extends AbstractRepository {

	@Query("select a from Application a where a.id = ?1")
	Application findAppOneById(int id);

	@Query("select a.application from Ejdos a where a.id = ?1")
	Application findAppByEjdosId(int id);

}
