
package acme.features.employer.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.ejuno.Ejuno;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class EmployerJobShowService implements AbstractShowService<Employer, Job> {

	//Internal State -----------------------------
	@Autowired
	EmployerJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		boolean result;
		int jobId;
		Job job;
		Employer employer;
		Principal principal;

		jobId = request.getModel().getInteger("id");
		job = this.repository.findOneById(jobId);
		employer = job.getEmployer();
		principal = request.getPrincipal();
		result = job.getStatus() || !job.getStatus() && employer.getId() == principal.getActiveRoleId();
		return result;
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		if (entity.getDescriptor() != null) {
			model.setAttribute("descriptorBoolean", true);
		} else {
			model.setAttribute("descriptorBoolean", false);
		}
		if (entity.getEjuno() != null) {
			String pText = entity.getEjuno().getPText();
			model.setAttribute("pText", pText);
			String moreInfo2 = entity.getEjuno().getMoreInfo2();
			model.setAttribute("moreInfo2", moreInfo2);
		}
		Ejuno c = entity.getEjuno();
		boolean hasControlCheck;
		if (c == null) {
			hasControlCheck = false;
		} else {
			hasControlCheck = true;
		}

		model.setAttribute("hasControlCheck", hasControlCheck);
		boolean hasControlCheck2 = false;
		if (entity.getEjuno() != null) {
			if (entity.getEjuno().getPassword() != null) {
				String pass = entity.getEjuno().getPassword().getPass();
				model.setAttribute("pass", pass);
				hasControlCheck2 = true;
			}
			model.setAttribute("hasControlCheck2", hasControlCheck2);
		}
		request.unbind(entity, model, "reference", "title", "deadline");
		request.unbind(entity, model, "salary", "moreInfo", "status", "employer.userAccount.username", "descriptor");

	}

	@Override
	public Job findOne(final Request<Job> request) {
		assert request != null;

		Job result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
