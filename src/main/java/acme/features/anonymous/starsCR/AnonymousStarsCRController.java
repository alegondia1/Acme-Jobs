
package acme.features.anonymous.starsCR;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.records.Records;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/starsCR/")
public class AnonymousStarsCRController extends AbstractController<Anonymous, Records> {

	//Internal State
	@Autowired
	AnonymousStarsCRListService	listService;
	@Autowired
	AnonymousStarsCRShowService	showService;
	//Constructors


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}
}
