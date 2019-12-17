
package acme.features.employer.job;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.datatypes.Money;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class EmployerJobCreateService implements AbstractCreateService<Employer, Job> {

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
		request.unbind(entity, model, "salary", "moreInfo", "status", "employer.userAccount.username", "descriptor");

	}

	@Override
	public Job instantiate(final Request<Job> request) {
		Job result = new Job();
		Employer employer;
		Principal principal;
		Date fecha = new Date();
		Calendar cal = Calendar.getInstance();
		principal = request.getPrincipal();
		int id;

		id = principal.getActiveRoleId();
		employer = this.repository.findEmployerById(id);
		result.setEmployer(employer);
		Money salary = new Money();
		salary.setCurrency("EUR");
		salary.setAmount(1000.0);
		result.setSalary(salary);
		fecha = cal.getTime();
		cal.add(Calendar.MONTH, 1);
		fecha = cal.getTime();
		result.setDeadline(fecha);
		result.setReference("AAAA-BBBB");
		result.setStatus(false);
		return result;
	}

	@Override
	public void validate(final Request<Job> request, final Job entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		if (entity.getSalary() != null) {
			errors.state(request, entity.getSalary().getAmount() >= 0, "salary", "employer.job.form.label.salary.negative");
			errors.state(request, entity.getSalary().getCurrency().equals("EUR"), "salary", "employer.job.form.label.salary.error");
		}
		Collection<String> references = this.repository.findManyAllReference();
		errors.state(request, !references.stream().anyMatch(X -> X.equals(entity.getReference())), "reference", "employer.job.form.label.unique");
		Date moment = new Date(System.currentTimeMillis());
		if (entity.getDeadline() != null) {
			errors.state(request, entity.getDeadline().after(moment), "deadline", "employer.job.form.label.future");
		}
	}

	@Override
	public void create(final Request<Job> request, final Job entity) {
		assert request != null;
		assert entity != null;
		entity.setStatus(false);
		this.repository.save(entity);

	}

}
