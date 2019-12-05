
package acme.features.anonymous.records;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.records.Records;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractShowService;

@Service
public class AnonymousRecordsShowService implements AbstractShowService<Anonymous, Records> {

	//Internal State -----------------------------
	@Autowired
	AnonymousRecordsRepository repository;


	// AbstractShowService<Anonymous, Announcement>
	@Override
	public boolean authorise(final Request<Records> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Records> request, final Records entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "sector", "ceo", "description", "website", "phone", "mail", "stars", "incorporated");

	}

	@Override
	public Records findOne(final Request<Records> request) {
		assert request != null;

		Records result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
