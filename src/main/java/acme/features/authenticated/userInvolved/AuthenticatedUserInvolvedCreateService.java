
package acme.features.authenticated.userInvolved;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messageThread.MessageThread;
import acme.entities.messageThread.UserInvolved;
import acme.features.authenticated.messageThread.AuthenticatedMessageThreadRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedUserInvolvedCreateService implements AbstractCreateService<Authenticated, UserInvolved> {

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
	public void bind(final Request<UserInvolved> request, final UserInvolved entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "user", "messageThread");

	}

	@Override
	public void unbind(final Request<UserInvolved> request, final UserInvolved entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		int threadId;
		threadId = request.getModel().getInteger("threadid");
		model.setAttribute("threadid", threadId);
		model.setAttribute("username", "usuario");
		request.unbind(entity, model, "user", "messageThread");
	}

	@Override
	public void validate(final Request<UserInvolved> request, final UserInvolved entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		Authenticated authenticated;
		Collection<Authenticated> users;
		String username;
		int threadId;

		threadId = request.getModel().getInteger("threadid");
		users = this.repository.findUserByThreadId(threadId);
		username = request.getModel().getString("username");
		authenticated = this.repository.findUserByUsername(username);
		errors.state(request, !users.stream().anyMatch(X -> X.getUserAccount().getUsername().equals(username)), "username", "authenticated.userinvolved.form.label.duplicate");
		errors.state(request, authenticated != null, "username", "authenticated.userinvolved.form.label.error");

	}

	@Override
	public UserInvolved instantiate(final Request<UserInvolved> request) {
		int threadId;
		MessageThread thread;
		UserInvolved result = new UserInvolved();
		Principal principal;
		Authenticated auth;

		principal = request.getPrincipal();
		threadId = request.getModel().getInteger("threadid");
		auth = this.repository.findUSerById(principal.getActiveRoleId());
		thread = this.repository.findOneById(threadId);
		result.setMessageThread(thread);
		result.setUser(auth);

		return result;
	}

	@Override
	public void create(final Request<UserInvolved> request, final UserInvolved entity) {
		Authenticated authenticated;
		String username;
		int threadId;
		MessageThread thread;

		threadId = request.getModel().getInteger("threadid");
		thread = this.repository.findOneById(threadId);
		entity.setMessageThread(thread);
		username = request.getModel().getString("username");
		authenticated = this.repository.findUserByUsername(username);
		entity.setUser(authenticated);
		this.repository.save(entity);

	}

}
