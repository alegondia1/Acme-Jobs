
package acme.features.worker.justification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.justification.Justification;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class WorkerJustificationShowService implements AbstractShowService<Worker, Justification> {

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

		request.unbind(entity, model, "reason", "application");

	}

	@Override
	public Justification findOne(final Request<Justification> request) {
		assert request != null;

		Justification result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findJustificationByApplicationId(id);

		return result;
	}

}
