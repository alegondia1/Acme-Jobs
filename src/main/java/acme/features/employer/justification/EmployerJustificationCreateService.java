
package acme.features.employer.justification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.application.Application;
import acme.entities.jobs.Job;
import acme.entities.justification.Justification;
import acme.entities.roles.Employer;
import acme.features.employer.application.EmployerApplicationRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class EmployerJustificationCreateService implements AbstractCreateService<Employer, Justification> {

	//Internal State -----------------------------
	@Autowired
	EmployerApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Justification> request) {
		boolean result;
		int id;
		Job job;
		Employer employer;
		Principal principal;

		id = request.getModel().getInteger("idapp");
		job = this.repository.findJobByApplicationId(id);
		employer = job.getEmployer();
		principal = request.getPrincipal();
		result = employer.getId() == principal.getActiveRoleId();
		return result;
	}

	@Override
	public void bind(final Request<Justification> request, final Justification entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "application");
	}

	@Override
	public void unbind(final Request<Justification> request, final Justification entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		int id;
		id = request.getModel().getInteger("idapp");
		model.setAttribute("idapp", id);
		request.unbind(entity, model, "reason", "application.reference");

	}

	@Override
	public Justification instantiate(final Request<Justification> request) {
		assert request != null;
		Justification result = new Justification();
		int id;
		Application application;

		id = request.getModel().getInteger("idapp");
		application = this.repository.findOneById(id);
		result.setApplication(application);
		return result;
	}

	@Override
	public void validate(final Request<Justification> request, final Justification entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		int id;
		Application application;

		id = request.getModel().getInteger("idapp");
		application = this.repository.findOneById(id);
		errors.state(request, application.getStatus().equals("PENDING"), "reason", "employer.application.form.label.statusnotvalid");

	}

	@Override
	public void create(final Request<Justification> request, final Justification entity) {
		assert request != null;
		assert entity != null;
		Justification result = new Justification();
		int id;
		Application application;

		id = request.getModel().getInteger("idapp");
		application = this.repository.findOneById(id);
		application.setStatus("REJECTED");
		Application app = this.repository.save(application);
		result.setApplication(app);
		this.repository.save(entity);

	}

}
