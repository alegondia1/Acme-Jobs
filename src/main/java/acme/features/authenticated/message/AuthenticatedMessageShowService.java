
package acme.features.authenticated.message;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messageThread.Message;
import acme.entities.messageThread.MessageThread;
import acme.features.authenticated.messageThread.AuthenticatedMessageThreadRepository;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedMessageShowService implements AbstractShowService<Authenticated, Message> {

	//Internal State -----------------------------
	@Autowired
	AuthenticatedMessageThreadRepository repository;


	@Override
	public boolean authorise(final Request<Message> request) {
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
	public void unbind(final Request<Message> request, final Message entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		int threadId;
		threadId = request.getModel().getInteger("threadid");
		model.setAttribute("threadid", threadId);
		request.unbind(entity, model, "moment", "title", "body", "tags", "user");

	}

	@Override
	public Message findOne(final Request<Message> request) {
		assert request != null;

		Message result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneMessageById(id);

		return result;
	}

}
