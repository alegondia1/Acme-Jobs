
package acme.features.administrator.customization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.customizationParameters.CustomizationParameters;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractDeleteService;

@Service
public class AdministratorCustomizationParametersDeleteService implements AbstractDeleteService<Administrator, CustomizationParameters> {

	//Internal State -----------------------------
	@Autowired
	AdministratorCustomizationParametersRepository repository;


	@Override
	public boolean authorise(final Request<CustomizationParameters> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<CustomizationParameters> request, final CustomizationParameters entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "spamThreshold");

	}

	@Override
	public void unbind(final Request<CustomizationParameters> request, final CustomizationParameters entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "spamWords", "spamThreshold");
	}

	@Override
	public CustomizationParameters findOne(final Request<CustomizationParameters> request) {
		assert request != null;
		CustomizationParameters result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

	@Override
	public void validate(final Request<CustomizationParameters> request, final CustomizationParameters entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void delete(final Request<CustomizationParameters> request, final CustomizationParameters entity) {
		assert request != null;
		assert entity != null;
		String spamword;
		spamword = request.getModel().getString("spamword");

		if (entity.getSpamWords().contains(spamword)) {
			entity.getSpamWords().remove(spamword);
			this.repository.save(entity);
		}

	}

}
