
package acme.features.authenticated.requestAuditor;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.requestAuditor.RequestAuditor;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/authenticated/requestAuditor/")
public class AuthenticatedRequestAuditorController extends AbstractController<Administrator, RequestAuditor> {

	//Internal State
	@Autowired
	AuthenticatedRequestAuditorCreateService createService;


	//Constructors

	@PostConstruct
	private void initialise() {

		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}
}
