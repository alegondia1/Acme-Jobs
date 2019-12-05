
package acme.features.administrator.records;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.records.Records;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorRecordsListService implements AbstractListService<Administrator, Records> {

	//Internal State -----------------------------
	@Autowired
	AdministratorRecordsRepository repository;


	// AbstractListService<administrator, Records>
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

		request.unbind(entity, model, "name", "ceo", "website");

	}

	@Override
	public Collection<Records> findMany(final Request<Records> request) {
		assert request != null;

		Collection<Records> result;
		result = this.repository.findManyAll();
		return result;
	}

}
