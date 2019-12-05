
package acme.features.authenticated.request;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.request.Request;
import acme.framework.components.Model;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedRequestListService implements AbstractListService<Authenticated, Request> {

	//Internal State -----------------------------
	@Autowired
	AuthenticatedRequestRepository repository;


	// AbstractListService<Authenticated, Request> interface --------------------
	@Override
	public boolean authorise(final acme.framework.components.Request<acme.entities.request.Request> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final acme.framework.components.Request<acme.entities.request.Request> request, final acme.entities.request.Request entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "title", "moment", "deadline", "description", "reward");

	}

	@Override
	public Collection<acme.entities.request.Request> findMany(final acme.framework.components.Request<acme.entities.request.Request> request) {
		assert request != null;

		Collection<Request> result;

		result = this.repository.findManyActive();

		return result;
	}

}
