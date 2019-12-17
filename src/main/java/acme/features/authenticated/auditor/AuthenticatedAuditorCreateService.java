
package acme.features.authenticated.auditor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Auditor;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedAuditorCreateService implements AbstractCreateService<Authenticated, Auditor> {

	//Internal State -----------------------------
	@Autowired
	AuthenticatedAuditorRepository repository;


	@Override
	public boolean authorise(final Request<Auditor> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Auditor> request, final Auditor entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "idUser");

	}

	@Override
	public void unbind(final Request<Auditor> request, final Auditor entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "firm", "responsibilityStatement");

	}

	@Override
	public Auditor instantiate(final Request<Auditor> request) {

		Auditor result = new Auditor();
		Principal principal = request.getPrincipal();

		Integer auditorId = principal.getAccountId();
		Auditor auditor = this.repository.findOneAuditorByUserAccountId(auditorId);
		String auditorFirm = auditor.getFirm();
		String auditorResponsibilityStatement = auditor.getResponsibilityStatement();

		result.setFirm(auditorFirm);
		result.setResponsibilityStatement(auditorResponsibilityStatement);
		result.setId(auditorId);

		return result;
	}

	@Override
	public void validate(final Request<Auditor> request, final Auditor entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<Auditor> request, final Auditor entity) {
		assert request != null;
		assert entity != null;
		this.repository.save(entity);

	}

}
