
package acme.features.authenticated.auditorRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditorRecord.AuditorRecord;
import acme.entities.roles.Auditor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedAuditorRecordShowService implements AbstractShowService<Authenticated, AuditorRecord> {

	//Internal State -----------------------------
	@Autowired
	AuthenticatedAuditorRecordRepository repository;


	@Override
	public boolean authorise(final Request<AuditorRecord> request) {
		assert request != null;
		boolean result;
		int auditorRecordId;
		AuditorRecord auditorRecord;
		Auditor auditor;
		Principal principal;

		auditorRecordId = request.getModel().getInteger("id");
		auditorRecord = this.repository.findOneById(auditorRecordId);
		auditor = auditorRecord.getAuditor();
		principal = request.getPrincipal();
		result = auditorRecord.getStatus() || !auditorRecord.getStatus() && auditor.getUserAccount().getId() == principal.getActiveRoleId();
		return result;
	}

	@Override
	public void unbind(final Request<AuditorRecord> request, final AuditorRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "moment", "title", "auditor", "job", "status", "body");

	}

	@Override
	public AuditorRecord findOne(final Request<AuditorRecord> request) {
		assert request != null;

		AuditorRecord result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
