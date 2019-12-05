
package acme.features.administrator.commercialBanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.commercialBanner.CommercialBanner;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/commercial-banner/")
public class AdministratorCommercialBannerController extends AbstractController<Administrator, CommercialBanner> {

	//Internal State
	@Autowired
	AdministratorCommercialBannerListService	listService;
	@Autowired
	AdministratorCommercialBannerShowService	showService;
	@Autowired
	AdministratorCommercialBannerUpdateService	updateService;
	@Autowired
	AdministratorCommercialBannerDeleteService	deleteService;
	@Autowired
	AdministratorCommercialBannerCreateService	createService;
	//Constructors


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
	}
}
