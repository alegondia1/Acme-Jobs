
package acme.features.sponsor.nonCommercialBanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.nonCommercialBanner.NonCommercialBanner;
import acme.entities.roles.Sponsor;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/sponsor/non-commercial-banner/")
public class SponsorNonCommercialBannerController extends AbstractController<Sponsor, NonCommercialBanner> {

	//Internal State

	@Autowired
	SponsorNonCommercialBannerShowService		showService;
	@Autowired
	SponsorNonCommercialBannerUpdateService		updateService;
	@Autowired
	SponsorNonCommercialBannerDeleteService		deleteService;
	@Autowired
	SponsorNonCommercialBannerCreateService		createService;

	@Autowired
	SponsorNonCommercialBannerListMineService	listMineService;
	//Constructors


	@PostConstruct
	private void initialise() {

		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
		super.addCustomCommand(CustomCommand.LIST_MINE, BasicCommand.LIST, this.listMineService);
	}
}
