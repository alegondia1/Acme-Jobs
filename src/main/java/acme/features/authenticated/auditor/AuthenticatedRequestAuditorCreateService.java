
package acme.features.authenticated.auditor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requestAuditor.RequestAuditor;
import acme.entities.roles.Auditor;
import acme.features.administrator.requestAuditor.AdministratorRequestAuditorRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedRequestAuditorCreateService implements AbstractCreateService<Administrator, RequestAuditor> {

	//Internal State -----------------------------
	@Autowired
	AdministratorRequestAuditorRepository repository;


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

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<RequestAuditor> request, final RequestAuditor entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "firm", "responsibilityStatement", "idUser");

	}

	@Override
	public RequestAuditor instantiate(final Request<RequestAuditor> request) {
		RequestAuditor result = new RequestAuditor();
		Principal principal;
		Auditor auditor;

		String auditorFirm;
		String auditorResponsibilityStatement;
		Integer auditorId;
		principal = request.getPrincipal();
		auditorId = principal.getActiveRoleId();
		auditor = this.repository.findOneAuditorByUserAccountId(auditorId);
		auditorFirm = auditor.getFirm();
		auditorResponsibilityStatement = auditor.getResponsibilityStatement();

		result.setFirm(auditorFirm);
		result.setResponsibilityStatement(auditorResponsibilityStatement);
		result.setIdUser(auditorId);

		return result;
	}

	@Override
	public void validate(final Request<RequestAuditor> request, final RequestAuditor entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<RequestAuditor> request, final RequestAuditor entity) {
		assert request != null;
		assert entity != null;
		this.repository.save(entity);

	}

}
