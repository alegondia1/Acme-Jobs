
package acme.features.authenticated.challengeTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challengeTest.ChallengeTest;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedChallengeTestShowService implements AbstractShowService<Authenticated, ChallengeTest> {

	//Internal State -----------------------------
	@Autowired
	AuthenticatedChallengeTestRepository repository;


	@Override
	public boolean authorise(final Request<ChallengeTest> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<ChallengeTest> request, final ChallengeTest entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "pText", "moreInfo2");
	}

	@Override
	public ChallengeTest findOne(final Request<ChallengeTest> request) {
		assert request != null;

		ChallengeTest result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneByJobId(id);

		return result;
	}
}
