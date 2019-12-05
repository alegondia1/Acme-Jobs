
package acme.features.authenticated.offer;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.offer.Offer;
import acme.entities.roles.Consumer;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractCreateService;

@Service
public class ConsumerOfferCreateService implements AbstractCreateService<Consumer, Offer> {

	//Internal State -----------------------------
	@Autowired
	AuthenticatedOfferRepository repository;


	@Override
	public boolean authorise(final Request<Offer> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Offer> request, final Offer entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment");

	}

	@Override
	public void unbind(final Request<Offer> request, final Offer entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "moment", "deadline", "title", "reward", "text");
		if (request.isMethod(HttpMethod.GET)) {
			model.setAttribute("accept", "false");
		} else {
			request.transfer(model, "accept");
		}
	}

	@Override
	public Offer instantiate(final Request<Offer> request) {
		Offer result;
		result = new Offer();
		Date fecha = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, -1);
		fecha = cal.getTime();
		result.setMoment(fecha);
		cal.add(Calendar.MONTH, 1);
		fecha = cal.getTime();
		result.setDeadline(fecha);
		result.setText("Texto");
		result.setTicker("OFFFF-99999");
		result.setTitle("Titulo");
		Money reward = new Money();
		reward.setCurrency("EUR");
		reward.setAmount(1000.0);
		result.setReward(reward);
		return result;
	}

	@Override
	public void validate(final Request<Offer> request, final Offer entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		boolean accept = false;
		errors.state(request, entity.getReward().getCurrency().equals("EUR"), "reward", "authenticated.offer.form.label.reward.error");
		Collection<String> tickers = this.repository.findManyAllTicker();
		errors.state(request, !tickers.stream().anyMatch(X -> X.equals(entity.getTicker())), "ticker", "authenticated.offer.form.label.unique");
		accept = request.getModel().getBoolean("accept");

		errors.state(request, accept, "accept", "authenticated.offer.form.label.accept");

	}

	@Override
	public void create(final Request<Offer> request, final Offer entity) {
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}

}
