
package acme.features.auditor.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditorRecord.AuditorRecord;
import acme.entities.jobs.Job;
import acme.entities.roles.Auditor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class AuditorJobShowService implements AbstractShowService<Auditor, Job> {

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
		Principal principal;
		boolean existMyRecord = false;
		principal = request.getPrincipal();
		AuditorRecord record = this.repository.findAuditorRecordByAuditorIdAndJobId(principal.getActiveRoleId(), entity.getId());
		if (record != null) {
			existMyRecord = true;
			model.setAttribute("idAuditor", record.getId());
			model.setAttribute("statusAuditor", record.getStatus());
		}
		model.setAttribute("existRecord", existMyRecord);
		request.unbind(entity, model, "reference", "title", "deadline");
		request.unbind(entity, model, "salary", "moreInfo", "status", "id", "employer.userAccount.username");

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
