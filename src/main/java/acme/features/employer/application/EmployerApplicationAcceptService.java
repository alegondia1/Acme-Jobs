
package acme.features.employer.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.application.Application;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractUpdateService;

@Service
public class EmployerApplicationAcceptService implements AbstractUpdateService<Employer, Application> {

	//Internal State -----------------------------
	@Autowired
	EmployerApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		boolean result;
		int id;
		Job job;
		Employer employer;
		Principal principal;

		id = request.getModel().getInteger("id");
		job = this.repository.findJobByApplicationId(id);
		employer = job.getEmployer();
		principal = request.getPrincipal();
		result = employer.getId() == principal.getActiveRoleId();
		return result;
	}

	@Override
	public void bind(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "reference", "skills", "moment");
		request.bind(entity, errors, "statements", "qualifications", "status", "worker.userAccount.username", "job.title");

	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "skills", "moment");
		request.unbind(entity, model, "statements", "qualifications", "status", "worker.userAccount.username", "job.title");

	}

	@Override
	public void validate(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		int id;
		Application application;

		id = request.getModel().getInteger("id");
		application = this.repository.findOneById(id);
		errors.state(request, application.getStatus().equals("PENDING"), "status", "employer.application.form.label.statusnotvalid");

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

	@Override
	public void update(final Request<Application> request, final Application entity) {
		assert request != null;
		assert entity != null;
		entity.setStatus("ACCEPTED");
		this.repository.save(entity);
	}

}
