
package acme.features.authenticated.userInvolved;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messageThread.MessageThread;
import acme.entities.messageThread.UserInvolved;
import acme.features.authenticated.messageThread.AuthenticatedMessageThreadRepository;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedUserInvolvedListService implements AbstractListService<Authenticated, UserInvolved> {

	//Internal State -----------------------------
	@Autowired
	AuthenticatedMessageThreadRepository repository;


	@Override
	public boolean authorise(final Request<UserInvolved> request) {
		assert request != null;
		boolean result;
		int threadId;
		MessageThread thread;
		Collection<Authenticated> authenticateds;
		Principal principal;

		threadId = request.getModel().getInteger("threadid");
		thread = this.repository.findOneById(threadId);
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
		int threadId;
		threadId = request.getModel().getInteger("threadid");
		model.setAttribute("threadid", threadId);
		request.unbind(entity, model, "user.userAccount.username", "messageThread");
	}

	@Override
	public Collection<UserInvolved> findMany(final Request<UserInvolved> request) {
		Collection<UserInvolved> users;
		int threadId;
		Principal principal;

		principal = request.getPrincipal();
		threadId = request.getModel().getInteger("threadid");
		users = this.repository.findUserInvolvedByThreadId(threadId);
		users = users.stream().filter(X -> X.getUser().getId() != principal.getActiveRoleId()).collect(Collectors.toCollection(ArrayList::new));
		return users;
	}

}
