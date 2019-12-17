
package acme.features.administrator.requestAuditor;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.requestAuditor.RequestAuditor;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/request-auditor/")
public class AdministratorRequestAuditorController extends AbstractController<Administrator, RequestAuditor> {

	//Internal State
	@Autowired
	AdministratorRequestAuditorListService		listService;
	@Autowired
	AdministratorRequestAuditorShowService		showService;
	@Autowired
	AdministratorRequestAuditorDeleteService	deleteService;


	//Constructors

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
	}
}
