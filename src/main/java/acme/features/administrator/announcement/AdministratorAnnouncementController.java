
package acme.features.administrator.announcement;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.announcement.Announcement;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/announcement/")
public class AdministratorAnnouncementController extends AbstractController<Administrator, Announcement> {

	//Internal State
	@Autowired
	AdministratorAnnouncementListService	listService;
	@Autowired
	AdministratorAnnouncementShowService	showService;
	@Autowired
	AdministratorAnnouncementUpdateService	updateService;
	@Autowired
	AdministratorAnnouncementDeleteService	deleteService;
	@Autowired
	AdministratorAnnouncementCreateService	createService;
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
