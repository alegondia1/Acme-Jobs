
package acme.features.authenticated.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challengeTest.ChallengeTest;
import acme.entities.jobs.Job;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedJobShowService implements AbstractShowService<Authenticated, Job> {

	//Internal State -----------------------------
	@Autowired
	AuthenticatedJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		if (entity.getChallengeTest() != null) {
			String pText = entity.getChallengeTest().getPText();
			model.setAttribute("pText", pText);
			String moreInfo2 = entity.getChallengeTest().getMoreInfo2();
			model.setAttribute("moreInfo2", moreInfo2);
		}
		ChallengeTest c = entity.getChallengeTest();
		boolean hasControlCheck;
		if (c == null) {
			hasControlCheck = false;
		} else {
			hasControlCheck = true;
		}

		model.setAttribute("hasControlCheck", hasControlCheck);

		request.unbind(entity, model, "reference", "title", "deadline");
		request.unbind(entity, model, "salary", "moreInfo", "status", "employer");

	}

	@Override
	public Job findOne(final Request<Job> request) {
		assert request != null;

		Job result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
