
package acme.features.sponsor.commercialBanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.commercialBanner.CommercialBanner;
import acme.entities.roles.Sponsor;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/sponsor/commercial-banner/")
public class SponsorCommercialBannerController extends AbstractController<Sponsor, CommercialBanner> {

	//Internal State
	@Autowired
	SponsorCommercialBannerShowService		showService;
	@Autowired
	SponsorCommercialBannerUpdateService	updateService;
	@Autowired
	SponsorCommercialBannerDeleteService	deleteService;
	@Autowired
	SponsorCommercialBannerCreateService	createService;

	@Autowired
	SponsorCommercialBannerListMineService	listMineService;
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
