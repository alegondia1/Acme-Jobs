
package acme.features.authenticated.auditorRecord;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.auditorRecord.AuditorRecord;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/auditor-record/")
public class AuthenticatedAuditorRecordController extends AbstractController<Authenticated, AuditorRecord> {

	//Internal State
	@Autowired
	AuthenticatedAuditorRecordListService	listService;
	@Autowired
	AuthenticatedAuditorRecordShowService	showService;


	//Constructors
	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.LIST, this.listService);

	}
}
