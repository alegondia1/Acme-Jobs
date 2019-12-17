
package acme.features.auditor.job;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Job;
import acme.entities.roles.Auditor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class AuditorJobListService implements AbstractListService<Auditor, Job> {

	//Internal State -----------------------------
	@Autowired
	AuditorJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "title", "deadline");

	}

	@Override
	public Collection<Job> findMany(final Request<Job> request) {
		assert request != null;

		Collection<Job> result;
		Principal principal;
		String mode;

		mode = request.getModel().getString("mode");
		principal = request.getPrincipal();
		if (mode.equals("mine")) {
			result = this.repository.findManyJobByAuditorId(principal.getActiveRoleId());
		} else if (mode.equals("other")) {
			Collection<Job> jobs = this.repository.findManyJob();
			Collection<Job> myJobs = this.repository.findManyJobByAuditorId(principal.getActiveRoleId());
			jobs.removeAll(myJobs);
			result = jobs;

		} else {
			result = new ArrayList<Job>();
		}
		return result;
	}

}
