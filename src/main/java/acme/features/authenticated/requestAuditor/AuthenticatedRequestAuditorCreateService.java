/*
 * AuditorRequestAuditorCreateService.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.authenticated.requestAuditor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requestAuditor.RequestAuditor;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.entities.UserAccount;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedRequestAuditorCreateService implements AbstractCreateService<Authenticated, RequestAuditor> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuthenticatedRequestAuditorRepository repository;


	// AbstractCreateService<Authenticated, RequestAuditor> interface ---------------

	@Override
	public boolean authorise(final Request<RequestAuditor> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<RequestAuditor> request, final RequestAuditor entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "user");
	}

	@Override
	public void unbind(final Request<RequestAuditor> request, final RequestAuditor entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "firm", "responsibilityStatement", "user.username");
	}

	@Override
	public RequestAuditor instantiate(final Request<RequestAuditor> request) {
		assert request != null;

		RequestAuditor result;
		Principal principal;
		UserAccount user;
		int userAccountId;

		principal = request.getPrincipal();
		userAccountId = principal.getAccountId();
		user = this.repository.findOneUserAccountById(userAccountId);
		result = new RequestAuditor();
		result.setUser(user);

		return result;
	}

	@Override
	public void validate(final Request<RequestAuditor> request, final RequestAuditor entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		Principal principal;
		int userAccountId;

		principal = request.getPrincipal();
		userAccountId = principal.getAccountId();
		errors.state(request, this.repository.findOneRequestAuditorByUserAccountId(userAccountId) == null, "firm", "authenticated.requestAuditor.form.label.alreadyExist");

	}

	@Override
	public void create(final Request<RequestAuditor> request, final RequestAuditor entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
