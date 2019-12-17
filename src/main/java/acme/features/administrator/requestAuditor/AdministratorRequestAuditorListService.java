
package acme.features.administrator.requestAuditor;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requestAuditor.RequestAuditor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorRequestAuditorListService implements AbstractListService<Administrator, RequestAuditor> {

	//Internal State -----------------------------
	@Autowired
	AdministratorRequestAuditorRepository repository;


	// AbstractListService<administrator, requestAuditor>
	@Override
	public boolean authorise(final Request<RequestAuditor> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<RequestAuditor> request, final RequestAuditor entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "idUser");

	}

	@Override
	public Collection<RequestAuditor> findMany(final Request<RequestAuditor> request) {
		assert request != null;

		Collection<RequestAuditor> result;
		result = this.repository.findManyAll();
		return result;
	}

}
