
package acme.features.sponsor.commercialBanner;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.commercialBanner.CommercialBanner;
import acme.entities.roles.Sponsor;
import acme.framework.components.Model;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class SponsorCommercialBannerListMineService implements AbstractListService<Sponsor, CommercialBanner> {

	//Internal State -----------------------------
	@Autowired
	SponsorCommercialBannerRepository repository;


	@Override
	public boolean authorise(final acme.framework.components.Request<CommercialBanner> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final acme.framework.components.Request<CommercialBanner> request, final CommercialBanner entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "url", "picture", "slogan", "card", "sponsor");

	}

	@Override
	public Collection<CommercialBanner> findMany(final acme.framework.components.Request<CommercialBanner> request) {
		assert request != null;

		Collection<CommercialBanner> result;
		Principal principal;

		principal = request.getPrincipal();
		result = this.repository.findManyAll(principal.getActiveRoleId());
		return result;
	}

}
