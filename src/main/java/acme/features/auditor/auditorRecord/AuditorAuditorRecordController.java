
package acme.features.auditor.auditorRecord;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.auditorRecord.AuditorRecord;
import acme.entities.roles.Auditor;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/auditor/auditor-record/")
public class AuditorAuditorRecordController extends AbstractController<Auditor, AuditorRecord> {

	//Internal State
	@Autowired
	AuditorAuditorRecordListService		listService;
	@Autowired
	AuditorAuditorRecordListMineService	listMineService;
	@Autowired
	AuditorAuditorRecordShowService		showService;
	@Autowired
	AuditorAuditorRecordCreateService	createService;
	@Autowired
	AuditorAuditorRecordUpdateService	updateService;


	//Constructors
	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addCustomCommand(CustomCommand.LIST_MINE, BasicCommand.LIST, this.listMineService);

	}
}
