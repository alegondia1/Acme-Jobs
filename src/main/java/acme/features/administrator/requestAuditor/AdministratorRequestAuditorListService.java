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

package acme.features.administrator.requestAuditor;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requestAuditor.RequestAuditor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorRequestAuditorListService implements AbstractListService<Administrator, RequestAuditor> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AdministratorRequestAuditorRepository repository;


	// AbstractCreateService<administrator, RequestAuditor> interface ---------------

	@Override
	public boolean authorise(final Request<RequestAuditor> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<RequestAuditor> request, final RequestAuditor entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "firm", "responsibilityStatement", "user.username");
	}

	@Override
	public Collection<RequestAuditor> findMany(final Request<RequestAuditor> request) {
		assert request != null;

		Collection<RequestAuditor> result;
		result = this.repository.findManyAll();

		return result;
	}

}
