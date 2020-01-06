
package acme.features.worker.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.application.Application;
import acme.entities.ejdos.Ejdos;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class WorkerApplicationShowService implements AbstractShowService<Worker, Application> {

	//Internal State -----------------------------
	@Autowired
	WorkerApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		if (entity.getEjdos() != null) {
			String respuesta = entity.getEjdos().getRespuesta();
			model.setAttribute("respuesta", respuesta);
			if (entity.getEjdos().getProtec() != null) {
				String protec = entity.getEjdos().getProtec();
				model.setAttribute("protec", protec);
			} else {
				String protec = "No password";
				model.setAttribute("protec", protec);
			}
		}

		Ejdos c = entity.getEjdos();
		boolean hasControlCheck;
		if (c == null) {
			hasControlCheck = false;
		} else {
			hasControlCheck = true;
		}

		model.setAttribute("hasControlCheck", hasControlCheck);

		request.unbind(entity, model, "reference", "skills", "moment");
		request.unbind(entity, model, "statements", "qualifications", "status", "worker.userAccount.username", "job.title");

	}

	@Override
	public Application findOne(final Request<Application> request) {
		assert request != null;

		Application result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
