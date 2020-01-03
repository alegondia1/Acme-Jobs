
package acme.features.authenticated.challengeTest;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.challengeTest.ChallengeTest;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/challengeTest/")
public class AuthenticatedChallengeTestController extends AbstractController<Authenticated, ChallengeTest> {

	//Internal State
	@Autowired
	AuthenticatedChallengeTestShowService showService;


	//Constructors
	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);

	}
}
