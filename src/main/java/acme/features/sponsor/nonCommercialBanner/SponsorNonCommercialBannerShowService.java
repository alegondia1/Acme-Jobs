
package acme.features.sponsor.nonCommercialBanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.nonCommercialBanner.NonCommercialBanner;
import acme.entities.roles.Sponsor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class SponsorNonCommercialBannerShowService implements AbstractShowService<Sponsor, NonCommercialBanner> {

	//Internal State -----------------------------
	@Autowired
	SponsorNonCommercialBannerRepository repository;


	// AbstractShowService<Sponsor, Banner>
	@Override
	public boolean authorise(final Request<NonCommercialBanner> request) {
		assert request != null;
		boolean result;
		int sponsorID;
		Sponsor sponsor;

		Principal pricipal;

		sponsorID = request.getModel().getInteger("id");
		sponsor = this.repository.findSponsorByNonCommercialBannerId(sponsorID);

		pricipal = request.getPrincipal();
		result = sponsor.getId() == pricipal.getActiveRoleId();
		return result;

	}

	@Override
	public void unbind(final Request<NonCommercialBanner> request, final NonCommercialBanner entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "url", "picture", "slogan", "jingle", "sponsor");

	}

	@Override
	public NonCommercialBanner findOne(final Request<NonCommercialBanner> request) {
		assert request != null;

		NonCommercialBanner result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
