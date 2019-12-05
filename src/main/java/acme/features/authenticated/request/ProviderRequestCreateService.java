
package acme.features.authenticated.request;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.request.Request;
import acme.entities.roles.Provider;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractCreateService;

@Service
public class ProviderRequestCreateService implements AbstractCreateService<Provider, Request> {

	//Internal State -----------------------------
	@Autowired
	AuthenticatedRequestRepository repository;


	@Override
	public boolean authorise(final acme.framework.components.Request<Request> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final acme.framework.components.Request<Request> request, final Request entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment");

	}

	@Override
	public void unbind(final acme.framework.components.Request<Request> request, final Request entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "title", "moment", "deadline", "description", "reward");
		if (request.isMethod(HttpMethod.GET)) {
			model.setAttribute("accept", "false");
		} else {
			request.transfer(model, "accept");
		}
	}

	@Override
	public Request instantiate(final acme.framework.components.Request<Request> request) {
		Request result;
		result = new Request();
		Date fecha = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, -1);
		fecha = cal.getTime();
		result.setMoment(fecha);
		cal.add(Calendar.MONTH, 1);
		fecha = cal.getTime();
		result.setDeadline(fecha);
		result.setDescription("Descripcion");
		result.setTicker("RABCD-99999");
		result.setTitle("Titulo");
		Money reward = new Money();
		reward.setCurrency("EUR");
		reward.setAmount(1000.0);
		result.setReward(reward);
		return result;
	}

	@Override
	public void validate(final acme.framework.components.Request<Request> request, final Request entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		boolean accept = false;
		errors.state(request, entity.getReward().getCurrency().equals("EUR"), "reward", "authenticated.request.form.label.reward.error");
		Collection<String> tickers = this.repository.findManyAllTicker();
		errors.state(request, !tickers.stream().anyMatch(X -> X.equals(entity.getTicker())), "ticker", "authenticated.request.form.label.unique");
		accept = request.getModel().getBoolean("accept");

		errors.state(request, accept, "accept", "authenticated.request.form.label.accept");

	}

	@Override
	public void create(final acme.framework.components.Request<Request> request, final Request entity) {
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}
}
