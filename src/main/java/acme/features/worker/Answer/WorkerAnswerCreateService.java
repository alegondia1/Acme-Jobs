
package acme.features.worker.Answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.answer.Answer;
import acme.entities.application.Application;
import acme.entities.roles.Worker;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class WorkerAnswerCreateService implements AbstractCreateService<Worker, Answer> {

	//Internal State -----------------------------
	@Autowired
	WorkerAnswerRepository repository;


	@Override
	public boolean authorise(final Request<Answer> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Answer> request, final Answer entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		int id;
		id = request.getModel().getInteger("id");

		request.unbind(entity, model, "respuesta", "keylet");

		model.setAttribute("id", id);

	}

	@Override
	public void bind(final Request<Answer> request, final Answer entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public Answer instantiate(final Request<Answer> request) {
		assert request != null;
		Answer result = new Answer();
		Application application;

		int id;
		id = request.getModel().getInteger("id");

		application = this.repository.findAppOneById(id);

		result.setApplication(application);

		return result;
	}

	@Override
	public void validate(final Request<Answer> request, final Answer entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		String keylet = entity.getKeylet();

		Application application;
		int id;
		id = request.getModel().getInteger("id");
		application = this.repository.findAppOneById(id);

		if (application.getJob().getNust().getPassword() != null) {

			errors.state(request, application.getJob().getNust().getPassword().getPass().equals(keylet), "keylet", "worker.application.form.label.protec.notPass2");
		}

	}

	@Override
	public void create(final Request<Answer> request, final Answer entity) {
		assert request != null;
		assert entity != null;
		Application application;

		int id;
		id = request.getModel().getInteger("id");

		application = this.repository.findAppOneById(id);
		application.setAnswer(entity);

		this.repository.save(application);
		this.repository.save(entity);
	}

}
