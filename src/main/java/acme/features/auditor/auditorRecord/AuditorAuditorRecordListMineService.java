
package acme.features.auditor.auditorRecord;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditorRecord.AuditorRecord;
import acme.entities.roles.Auditor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class AuditorAuditorRecordListMineService implements AbstractListService<Auditor, AuditorRecord> {

	//Internal State -----------------------------
	@Autowired
	AuditorAuditorRecordRepository repository;


	@Override
	public boolean authorise(final Request<AuditorRecord> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<AuditorRecord> request, final AuditorRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "moment", "title", "auditor");

	}

	@Override
	public Collection<AuditorRecord> findMany(final Request<AuditorRecord> request) {
		assert request != null;

		Collection<AuditorRecord> result;
		Principal principal;

		principal = request.getPrincipal();
		result = this.repository.findManyByAuditorId(principal.getActiveRoleId());
		return result;
	}

}
