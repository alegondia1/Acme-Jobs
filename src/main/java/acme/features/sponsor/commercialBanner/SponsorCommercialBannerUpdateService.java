
package acme.features.sponsor.commercialBanner;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import acme.entities.commercialBanner.CommercialBanner;
import acme.entities.customizationParameters.CustomizationParameters;
import acme.entities.roles.Sponsor;
import acme.features.administrator.customization.AdministratorCustomizationParametersRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractUpdateService;

@Service
public class SponsorCommercialBannerUpdateService implements AbstractUpdateService<Sponsor, CommercialBanner> {

	//Internal State -----------------------------
	@Autowired
	SponsorCommercialBannerRepository				repository;
	@Autowired
	AdministratorCustomizationParametersRepository	spamRepository;


	@Override
	public boolean authorise(final Request<CommercialBanner> request) {
		assert request != null;

		boolean result;
		int sponsorID;
		Sponsor sponsor;

		Principal pricipal;

		sponsorID = request.getModel().getInteger("id");
		sponsor = this.repository.findSponsorByCommercialBannerId(sponsorID);

		pricipal = request.getPrincipal();
		result = sponsor.getId() == pricipal.getActiveRoleId();
		return result;

	}

	@Override
	public void bind(final Request<CommercialBanner> request, final CommercialBanner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "sponsor");

	}

	@Override
	public void unbind(final Request<CommercialBanner> request, final CommercialBanner entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "picture", "slogan", "url", "card", "sponsor.userAccount.username");
	}

	@Override
	public CommercialBanner findOne(final Request<CommercialBanner> request) {
		assert request != null;

		CommercialBanner result = new CommercialBanner();
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

	@Override
	public void validate(final Request<CommercialBanner> request, final CommercialBanner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		errors.state(request, !this.check(entity.getSlogan()), "slogan", "sponsor.banner.form.label.isspam");
		errors.state(request, !this.check(entity.getUrl()), "url", "sponsor.banner.form.label.isspam");
		errors.state(request, !this.check(entity.getPicture()), "picture", "sponsor.banner.form.label.isspam");

	}
	private Boolean check(final String data) {
		Boolean result = false;
		long count;
		CustomizationParameters customizationParameter;
		customizationParameter = this.spamRepository.find();
		Double threeshold = customizationParameter.getSpamThreshold();
		Collection<String> spamwords = customizationParameter.getSpamWords();
		count = spamwords.stream().mapToLong(X -> StringUtils.countOccurrencesOf(data, X)).sum();
		result = count >= threeshold;
		return result;
	}

	@Override
	public void update(final Request<CommercialBanner> request, final CommercialBanner entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
