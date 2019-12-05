
package acme.features.authenticated.auditorRecord;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditorRecord.AuditorRecord;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedAuditorRecordListService implements AbstractListService<Authenticated, AuditorRecord> {

	//Internal State -----------------------------
	@Autowired
	AuthenticatedAuditorRecordRepository repository;


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
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findManyByJobId(id);
		return result;
	}

}
