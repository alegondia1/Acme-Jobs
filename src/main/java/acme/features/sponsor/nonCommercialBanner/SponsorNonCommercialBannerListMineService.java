
package acme.features.sponsor.nonCommercialBanner;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.nonCommercialBanner.NonCommercialBanner;
import acme.entities.roles.Sponsor;
import acme.framework.components.Model;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class SponsorNonCommercialBannerListMineService implements AbstractListService<Sponsor, NonCommercialBanner> {

	//Internal State -----------------------------
	@Autowired
	SponsorNonCommercialBannerRepository repository;


	@Override
	public boolean authorise(final acme.framework.components.Request<NonCommercialBanner> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final acme.framework.components.Request<NonCommercialBanner> request, final NonCommercialBanner entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "picture", "slogan", "url", "jingle", "sponsor");

	}

	@Override
	public Collection<NonCommercialBanner> findMany(final acme.framework.components.Request<NonCommercialBanner> request) {
		assert request != null;

		Collection<NonCommercialBanner> result;
		Principal principal;

		principal = request.getPrincipal();
		result = this.repository.findManyAll(principal.getActiveRoleId());
		return result;
	}

}
