
package acme.features.auditor.auditorRecord;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditorRecord.AuditorRecord;
import acme.entities.jobs.Job;
import acme.entities.roles.Auditor;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class AuditorAuditorRecordCreateService implements AbstractCreateService<Auditor, AuditorRecord> {

	//Internal State -----------------------------
	@Autowired
	AuditorAuditorRecordRepository repository;


	@Override
	public boolean authorise(final Request<AuditorRecord> request) {
		assert request != null;
		boolean result;
		Principal principal;
		int idJob;
		boolean existMyRecord = false;
		principal = request.getPrincipal();
		idJob = request.getModel().getInteger("idjob");
		AuditorRecord record = this.repository.findAuditorRecordByAuditorIdAndJobId(principal.getActiveRoleId(), idJob);
		existMyRecord = record != null;
		result = !existMyRecord;
		return result;
	}

	@Override
	public void unbind(final Request<AuditorRecord> request, final AuditorRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		int idJob;
		idJob = request.getModel().getInteger("idjob");
		model.setAttribute("idjob", idJob);
		request.unbind(entity, model, "moment", "title", "auditor.userAccount.username", "job.title", "status", "body");

	}

	@Override
	public void bind(final Request<AuditorRecord> request, final AuditorRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment", "job", "auditor");

	}

	@Override
	public AuditorRecord instantiate(final Request<AuditorRecord> request) {
		assert request != null;
		AuditorRecord result = new AuditorRecord();
		Principal principal;
		int idJob;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		result.setMoment(moment);
		principal = request.getPrincipal();
		idJob = request.getModel().getInteger("idjob");
		Auditor aud = this.repository.findAuditorById(principal.getActiveRoleId());
		Job job = this.repository.findJobById(idJob);
		result.setAuditor(aud);
		result.setJob(job);
		result.setStatus(false);
		return result;
	}

	@Override
	public void validate(final Request<AuditorRecord> request, final AuditorRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<AuditorRecord> request, final AuditorRecord entity) {
		assert request != null;
		assert entity != null;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}

}
