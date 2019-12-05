
package acme.features.employer.job;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class EmployerJobListMineService implements AbstractListService<Employer, Job> {

	//Internal State -----------------------------
	@Autowired
	EmployerJobRepository repository;


	@Override
	public boolean authorise(final acme.framework.components.Request<Job> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final acme.framework.components.Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "title", "deadline");

	}

	@Override
	public Collection<Job> findMany(final acme.framework.components.Request<Job> request) {
		assert request != null;

		Collection<Job> result;
		Principal principal;

		principal = request.getPrincipal();
		result = this.repository.findManyByEmployerId(principal.getActiveRoleId());
		return result;
	}

}
