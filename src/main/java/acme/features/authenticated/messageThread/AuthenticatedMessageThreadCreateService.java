
package acme.features.authenticated.messageThread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messageThread.Message;
import acme.entities.messageThread.MessageThread;
import acme.entities.messageThread.UserInvolved;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedMessageThreadCreateService implements AbstractCreateService<Authenticated, MessageThread> {

	//Internal State -----------------------------
	@Autowired
	AuthenticatedMessageThreadRepository repository;


	@Override
	public boolean authorise(final Request<MessageThread> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<MessageThread> request, final MessageThread entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "moment", "title", "messages");

	}

	@Override
	public void bind(final Request<MessageThread> request, final MessageThread entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment", "messages");

	}

	@Override
	public MessageThread instantiate(final Request<MessageThread> request) {
		MessageThread result = new MessageThread();
		Date moment;
		Collection<Message> messages = new ArrayList<Message>();
		moment = new Date(System.currentTimeMillis() - 1);
		result.setMoment(moment);
		result.setMessages(messages);
		result.setTitle("Titulo 1");
		return result;
	}

	@Override
	public void validate(final Request<MessageThread> request, final MessageThread entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<MessageThread> request, final MessageThread entity) {
		assert request != null;
		assert entity != null;
		Principal principal;
		Authenticated user;
		MessageThread thread;
		UserInvolved userInvolved = new UserInvolved();

		principal = request.getPrincipal();
		user = this.repository.finUserById(principal.getActiveRoleId());
		thread = this.repository.save(entity);
		userInvolved.setMessageThread(thread);
		userInvolved.setUser(user);
		this.repository.save(userInvolved);

	}

}
