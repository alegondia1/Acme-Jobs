
package acme.features.employer.job;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.descriptor.Descriptor;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractUpdateService;

@Service
public class EmployerJobUpdateService implements AbstractUpdateService<Employer, Job> {

	//Internal State -----------------------------
	@Autowired
	EmployerJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Job> request, final Job entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "employer");

	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "title", "deadline");
		request.unbind(entity, model, "salary", "moreInfo", "status", "employer");

	}

	@Override
	public void validate(final Request<Job> request, final Job entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		Descriptor descriptor;
		int id;

		id = request.getModel().getInteger("id");
		errors.state(request, entity.getSalary().getCurrency().equals("EUR"), "salary", "employer.job.form.label.salary.error");
		Collection<Job> references = this.repository.findManyAll();
		errors.state(request, !references.stream().anyMatch(X -> X.getReference().equals(entity.getReference()) && !(X.getId() == entity.getId())), "reference", "employer.job.form.label.unique");
		descriptor = this.repository.findDescriptorByJobId(id);
		errors.state(request, descriptor != null && entity.getStatus() || !entity.getStatus(), "status", "employer.job.form.label.nodescriptor");
	}

	@Override
	public Job findOne(final Request<Job> request) {
		assert request != null;
		Job result = new Job();
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

	@Override
	public void update(final Request<Job> request, final Job entity) {
		assert request != null;
		assert entity != null;
		this.repository.save(entity);

	}

}
