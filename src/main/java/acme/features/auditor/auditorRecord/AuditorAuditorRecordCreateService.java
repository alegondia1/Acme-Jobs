
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
		return true;
	}

	@Override
	public void bind(final Request<AuditorRecord> request, final AuditorRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment");

	}

	@Override
	public void unbind(final Request<AuditorRecord> request, final AuditorRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "moment", "body", "status", "auditor", "job");

	}

	@Override
	public AuditorRecord instantiate(final Request<AuditorRecord> request) {
		Principal principal = request.getPrincipal();
		AuditorRecord result = new AuditorRecord();

		Integer auditorId = principal.getActiveRoleId();
		Integer jobId = request.getModel().getInteger("jobId");
		Auditor auditor = this.repository.findOneAuditorById(auditorId);
		Job job = this.repository.findOneJobById(jobId);

		result.setStatus(true);
		result.setAuditor(auditor);
		result.setJob(job);
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
