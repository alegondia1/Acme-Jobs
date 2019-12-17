
package acme.features.authenticated.userInvolved;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.messageThread.UserInvolved;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/user-involved/")
public class AuthenticatedUserInvolvedController extends AbstractController<Authenticated, UserInvolved> {

	//Internal State
	@Autowired
	AuthenticatedUserInvolvedDeleteService	deleteService;
	@Autowired
	AuthenticatedUserInvolvedCreateService	createService;
	@Autowired
	AuthenticatedUserInvolvedListService	listService;
	@Autowired
	AuthenticatedUserInvolvedShowService	showService;


	//Constructors
	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}
}
