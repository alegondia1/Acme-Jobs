
package acme.features.worker.justification;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.justification.Justification;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class WorkerJustificationListMineService implements AbstractListService<Worker, Justification> {

	//Internal State -----------------------------
	@Autowired
	WorkerJustificationRepository repository;


	@Override
	public boolean authorise(final Request<Justification> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Justification> request, final Justification entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "reason");
	}

	@Override
	public Collection<Justification> findMany(final Request<Justification> request) {
		assert request != null;

		Collection<Justification> result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findManyByJustificationId(id);
		return result;
	}

}
