
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
import acme.framework.services.AbstractCreateService;

@Service
public class SponsorCommercialBannerCreateService implements AbstractCreateService<Sponsor, CommercialBanner> {

	//Internal State ----------------------------
	@Autowired
	SponsorCommercialBannerRepository				repository;
	@Autowired
	AdministratorCustomizationParametersRepository	spamRepository;


	@Override
	public boolean authorise(final Request<CommercialBanner> request) {
		assert request != null;
		return true;
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

		request.unbind(entity, model, "url", "picture", "slogan", "card", "sponsor.userAccount.username");

	}

	@Override
	public CommercialBanner instantiate(final Request<CommercialBanner> request) {
		CommercialBanner result = new CommercialBanner();
		Principal principal;
		Sponsor sponsor;

		int sponsorID;
		String sponsorCC;
		principal = request.getPrincipal();
		sponsorID = principal.getActiveRoleId();
		sponsor = this.repository.findSponsorById(sponsorID);
		sponsorCC = sponsor.getCreditCard();

		result.setPicture("https://www.url-de-ejemplo.com");
		result.setSlogan("Texto de ejemplo");
		result.setUrl("https://www.url-de-ejemplo.com");
		result.setCard(sponsorCC);
		result.setSponsor(sponsor);
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
	public void create(final Request<CommercialBanner> request, final CommercialBanner entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
