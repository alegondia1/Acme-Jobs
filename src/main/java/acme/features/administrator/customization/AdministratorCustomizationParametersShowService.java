
package acme.features.administrator.customization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.customizationParameters.CustomizationParameters;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorCustomizationParametersShowService implements AbstractShowService<Administrator, CustomizationParameters> {

	//Internal State -----------------------------
	@Autowired
	AdministratorCustomizationParametersRepository repository;


	// AbstractShowService<Administrator, CustomizationParameters>

	@Override
	public boolean authorise(final Request<CustomizationParameters> request) {
		assert request != null;
		return true;
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
		result = this.repository.find();

		return result;
	}

}
