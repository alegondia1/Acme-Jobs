
package acme.features.worker.Ejdos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.application.Application;
import acme.entities.ejdos.Ejdos;
import acme.entities.roles.Worker;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class WorkerEjdosCreateService implements AbstractCreateService<Worker, Ejdos> {

	//Internal State -----------------------------
	@Autowired
	WorkerEjdosRepository repository;


	@Override
	public boolean authorise(final Request<Ejdos> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Ejdos> request, final Ejdos entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		int id;
		id = request.getModel().getInteger("id");

		request.unbind(entity, model, "respuesta", "protec");

		model.setAttribute("id", id);

	}

	@Override
	public void bind(final Request<Ejdos> request, final Ejdos entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public Ejdos instantiate(final Request<Ejdos> request) {
		assert request != null;
		Ejdos result = new Ejdos();
		Application application;

		int id;
		id = request.getModel().getInteger("id");

		application = this.repository.findAppOneById(id);

		//		result.setRespuesta("Respuesta");
		result.setApplication(application);

		return result;
	}

	@Override
	public void validate(final Request<Ejdos> request, final Ejdos entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		String protec = entity.getProtec();

		Application application;
		int id;
		id = request.getModel().getInteger("id");
		application = this.repository.findAppOneById(id);

		if (application.getJob().getEjuno().getPassword() != null) {

			errors.state(request, application.getJob().getEjuno().getPassword().getPass().equals(protec), "errorPass", "worker.application.form.label.notPass2");
		}

	}

	@Override
	public void create(final Request<Ejdos> request, final Ejdos entity) {
		assert request != null;
		assert entity != null;
		Application application;

		int id;
		id = request.getModel().getInteger("id");

		application = this.repository.findAppOneById(id);
		application.setEjdos(entity);

		this.repository.save(application);
		this.repository.save(entity);
	}

}
