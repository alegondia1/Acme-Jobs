
package acme.features.worker.justification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.justification.Justification;
import acme.entities.roles.Worker;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class WorkerJustificationCreateService implements AbstractCreateService<Worker, Justification> {

	//Internal State -----------------------------
	@Autowired
	WorkerJustificationRepository repository;


	@Override
	public boolean authorise(final Request<Justification> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Justification> request, final Justification entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Justification> request, final Justification entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reason");

	}

	@Override
	public Justification instantiate(final Request<Justification> request) {
		Justification result = new Justification();
		result.setReason("Razon");
		return result;
	}

	@Override
	public void validate(final Request<Justification> request, final Justification entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<Justification> request, final Justification entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
