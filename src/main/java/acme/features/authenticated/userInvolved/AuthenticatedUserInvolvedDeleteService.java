
package acme.features.authenticated.userInvolved;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messageThread.Message;
import acme.entities.messageThread.MessageThread;
import acme.entities.messageThread.UserInvolved;
import acme.features.authenticated.messageThread.AuthenticatedMessageThreadRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractDeleteService;

@Service
public class AuthenticatedUserInvolvedDeleteService implements AbstractDeleteService<Authenticated, UserInvolved> {

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

		request.unbind(entity, model, "user", "messageThread");
	}

	@Override
	public UserInvolved findOne(final Request<UserInvolved> request) {
		assert request != null;
		UserInvolved result = new UserInvolved();
		Collection<UserInvolved> users = new ArrayList<UserInvolved>();
		int id;
		int threadId;
		Principal principal;

		threadId = request.getModel().getInteger("threadid");
		id = request.getModel().getInteger("id");
		if (id == -1) {
			principal = request.getPrincipal();
			id = principal.getActiveRoleId();
		}
		users = this.repository.findUserInvolvedByThreadId(threadId);
		final int idUser = id;
		result = users.stream().filter(X -> X.getUser().getId() == idUser).findFirst().get();
		return result;
	}

	@Override
	public void validate(final Request<UserInvolved> request, final UserInvolved entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void delete(final Request<UserInvolved> request, final UserInvolved entity) {
		assert request != null;
		assert entity != null;
		this.repository.delete(entity);
		int threadId;
		threadId = request.getModel().getInteger("threadid");
		if (this.repository.findUserInvolvedByThreadId(threadId).isEmpty()) {
			MessageThread thread = this.repository.findOneById(threadId);
			thread.getMessages().size();
			for (Message e : thread.getMessages()) {
				this.repository.delete(e);
			}
			this.repository.delete(thread);
		}
	}

}
