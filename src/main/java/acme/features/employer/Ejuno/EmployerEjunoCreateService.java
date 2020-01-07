
package acme.features.employer.Ejuno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.ejuno.Ejuno;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class EmployerEjunoCreateService implements AbstractCreateService<Employer, Ejuno> {

	//Internal State -----------------------------
	@Autowired
	EmployerEjunoRepository repository;


	@Override
	public boolean authorise(final Request<Ejuno> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Ejuno> request, final Ejuno entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		int id;
		id = request.getModel().getInteger("id");

		request.unbind(entity, model, "pText", "moreInfo2");

		model.setAttribute("id", id);

	}

	@Override
	public void bind(final Request<Ejuno> request, final Ejuno entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public Ejuno instantiate(final Request<Ejuno> request) {
		assert request != null;
		Ejuno result = new Ejuno();
		Job job;

		int id;
		id = request.getModel().getInteger("id");

		job = this.repository.findJobOneById(id);

		//		result.setRespuesta("Respuesta");
		result.setJob(job);

		return result;
	}

	@Override
	public void validate(final Request<Ejuno> request, final Ejuno entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<Ejuno> request, final Ejuno entity) {
		assert request != null;
		assert entity != null;
		Job job;

		int id;
		id = request.getModel().getInteger("id");

		job = this.repository.findJobOneById(id);
		job.setEjuno(entity);

		this.repository.save(job);
		this.repository.save(entity);
	}

}
