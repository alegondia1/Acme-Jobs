
package acme.features.authenticated.message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import acme.entities.customizationParameters.CustomizationParameters;
import acme.entities.messageThread.Message;
import acme.entities.messageThread.MessageThread;
import acme.features.administrator.customization.AdministratorCustomizationParametersRepository;
import acme.features.authenticated.messageThread.AuthenticatedMessageThreadRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedMessageCreateService implements AbstractCreateService<Authenticated, Message> {

	//Internal State -----------------------------
	@Autowired
	AuthenticatedMessageThreadRepository			repository;
	@Autowired
	AdministratorCustomizationParametersRepository	spamRepository;


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
	public void bind(final Request<Message> request, final Message entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment", "user");
	}

	@Override
	public void unbind(final Request<Message> request, final Message entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		int threadId;
		threadId = request.getModel().getInteger("threadid");
		model.setAttribute("threadid", threadId);
		model.setAttribute("tagss", "");
		model.setAttribute("accept", "false");
		request.unbind(entity, model, "moment", "title", "body", "tags", "user");

	}

	@Override
	public Message instantiate(final Request<Message> request) {
		Message result = new Message();
		Date moment;
		Authenticated auth;
		Principal principal;
		principal = request.getPrincipal();
		Collection<String> tags = new ArrayList<String>();

		auth = this.repository.findUSerById(principal.getActiveRoleId());
		moment = new Date(System.currentTimeMillis() - 1);
		result.setMoment(moment);
		result.setTitle("Titulo 1");
		result.setUser(auth);
		result.setTags(tags);
		return result;
	}

	@Override
	public void validate(final Request<Message> request, final Message entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		boolean accept = false;
		accept = request.getModel().getBoolean("accept");

		errors.state(request, accept, "accept", "authenticated.message.form.label.accept");
		errors.state(request, !this.check(entity.getTitle()), "title", "authenticated.message.form.label.isspam");
		errors.state(request, !this.check(entity.getBody()), "body", "authenticated.message.form.label.isspam");
		errors.state(request, !this.check(request.getModel().getString("tagss")), "tagss", "authenticated.message.form.label.isspam");
	}

	private Boolean check(final String data) {
		Boolean result = false;
		long count;
		CustomizationParameters customizationParameter;
		customizationParameter = this.spamRepository.find();
		Double threeshold = customizationParameter.getSpamThreshold();
		Collection<String> spamwords = customizationParameter.getSpamWords();
		count = spamwords.stream().mapToLong(X -> StringUtils.countOccurrencesOf(data, X)).sum();
		result = count >= threeshold;
		return result;
	}

	@Override
	public void create(final Request<Message> request, final Message entity) {
		assert request != null;
		assert entity != null;
		Collection<String> tags;
		Message message;
		Date moment;
		Authenticated auth;
		String tagss;
		Principal principal;
		int threadId;
		MessageThread thread;
		principal = request.getPrincipal();

		auth = this.repository.findUSerById(principal.getActiveRoleId());
		tagss = request.getModel().getString("tagss");
		tags = Arrays.asList(tagss.replace(" ", "").split(":"));
		entity.setTags(tags);
		entity.setUser(auth);
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		message = this.repository.save(entity);

		threadId = request.getModel().getInteger("threadid");
		thread = this.repository.findOneById(threadId);
		Collection<Message> messages = thread.getMessages();
		messages.add(message);
		thread.setMessages(messages);
		this.repository.save(thread);
	}

}
