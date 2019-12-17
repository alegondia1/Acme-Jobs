
package acme.features.worker.justification;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.justification.Justification;
import acme.entities.roles.Worker;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/worker/justification/")
public class WorkerJustificationController extends AbstractController<Worker, Justification> {

	//Internal State
	@Autowired
	WorkerJustificationShowService		showService;
	@Autowired
	WorkerJustificationListMineService	listMineService;

	@Autowired
	WorkerJustificationCreateService	createService;
	@Autowired
	WorkerJustificationUpdateService	updateService;


	//Constructors
	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addCustomCommand(CustomCommand.LIST_MINE, BasicCommand.LIST, this.listMineService);
	}
}
