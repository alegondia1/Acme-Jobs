
package acme.features.employer.Nust;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Job;
import acme.entities.nust.Nust;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class EmployerNustCreateService implements AbstractCreateService<Employer, Nust> {

	//Internal State -----------------------------
	@Autowired
	EmployerNustRepository repository;


	@Override
	public boolean authorise(final Request<Nust> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Nust> request, final Nust entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		int id;
		id = request.getModel().getInteger("id");

		request.unbind(entity, model, "pText", "keylet");

		model.setAttribute("id", id);

	}

	@Override
	public void bind(final Request<Nust> request, final Nust entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public Nust instantiate(final Request<Nust> request) {
		assert request != null;
		Nust result = new Nust();
		Job job;

		int id;
		id = request.getModel().getInteger("id");

		job = this.repository.findJobOneById(id);

		//		result.setRespuesta("Respuesta");
		result.setJob(job);

		return result;
	}

	@Override
	public void validate(final Request<Nust> request, final Nust entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<Nust> request, final Nust entity) {
		assert request != null;
		assert entity != null;
		Job job;

		int id;
		id = request.getModel().getInteger("id");

		job = this.repository.findJobOneById(id);

		if (entity.getKeylet() == "") {
			entity.setKeylet(null);
		}
		job.setNust(entity);

		this.repository.save(job);
		this.repository.save(entity);
	}

}
