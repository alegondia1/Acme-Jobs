
package acme.features.authenticated.userInvolved;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messageThread.MessageThread;
import acme.entities.messageThread.UserInvolved;
import acme.features.authenticated.messageThread.AuthenticatedMessageThreadRepository;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedUserInvolvedShowService implements AbstractShowService<Authenticated, UserInvolved> {

	//Internal State -----------------------------
	@Autowired
	AuthenticatedMessageThreadRepository repository;


	@Override
	public boolean authorise(final Request<UserInvolved> request) {
		assert request != null;
		boolean result;
		int id;
		UserInvolved involved;
		MessageThread thread;
		Collection<Authenticated> authenticateds;
		Principal principal;

		id = request.getModel().getInteger("id");
		involved = this.repository.findUserInvolvedById(id);
		thread = involved.getMessageThread();
		authenticateds = this.repository.findUserByThreadId(thread.getId());
		principal = request.getPrincipal();
		result = authenticateds.stream().anyMatch(X -> X.getId() == principal.getActiveRoleId());
		return result;
	}

	@Override
	public void unbind(final Request<UserInvolved> request, final UserInvolved entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		int id;
		UserInvolved involved;
		MessageThread thread;

		id = request.getModel().getInteger("id");
		involved = this.repository.findUserInvolvedById(id);
		thread = involved.getMessageThread();
		model.setAttribute("threadTitle", thread.getTitle());
		request.unbind(entity, model, "user", "user.userAccount.username", "messageThread");
	}

	@Override
	public UserInvolved findOne(final Request<UserInvolved> request) {
		UserInvolved user;
		int id;
		id = request.getModel().getInteger("id");
		user = this.repository.findUserInvolvedById(id);
		return user;
	}

}
