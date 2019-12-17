
package acme.features.worker.application;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.application.Application;
import acme.entities.jobs.Job;
import acme.entities.roles.Worker;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class WorkerApplicationCreateService implements AbstractCreateService<Worker, Application> {

	//Internal State -----------------------------
	@Autowired
	WorkerApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		int jobid;
		jobid = request.getModel().getInteger("jobid");
		model.setAttribute("jobid", jobid);
		model.setAttribute("referenceapp", "XXXX");
		request.unbind(entity, model, "reference", "skills", "moment");
		request.unbind(entity, model, "statements", "qualifications", "status", "worker.userAccount.username", "job.title");

	}

	@Override
	public void bind(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "job", "worker", "status", "moment");
	}

	@Override
	public Application instantiate(final Request<Application> request) {
		assert request != null;
		Date moment;
		Job job;
		Worker worker;
		Application result = new Application();
		int jobid;
		Principal principal;

		principal = request.getPrincipal();
		worker = this.repository.findWorkerById(principal.getActiveRoleId());
		jobid = request.getModel().getInteger("jobid");
		job = this.repository.findJobById(jobid);
		moment = new Date(System.currentTimeMillis() - 1);
		result.setJob(job);
		result.setWorker(worker);
		result.setReference(job.getReference() + ":AAAA");
		result.setStatus("PENDING");
		result.setMoment(moment);
		return result;
	}

	@Override
	public void validate(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		int jobid;
		String referenceApp;
		Principal principal;

		Collection<String> references = this.repository.findAllReferences();
		principal = request.getPrincipal();
		jobid = request.getModel().getInteger("jobid");
		Collection<Application> apps = this.repository.findApplicationsByJobId(jobid);
		referenceApp = request.getModel().getString("referenceapp");
		errors.state(request, !apps.stream().anyMatch(X -> X.getWorker().getId() == principal.getActiveRoleId()), "referenceapp", "worker.application.form.label.already");
		errors.state(request, this.isLetter(referenceApp) && referenceApp.length() == 4, "referenceapp", "worker.application.form.label.notreference");
		String reference = this.repository.findJobById(jobid).getReference() + ":" + referenceApp;
		errors.state(request, !references.contains(reference), "referenceapp", "worker.application.form.label.notunique");
	}

	private boolean isLetter(final String str) {
		if (str == null) {
			return false;
		}
		return str.chars().allMatch(X -> Character.isLetter(X));

	}

	@Override
	public void create(final Request<Application> request, final Application entity) {
		assert request != null;
		assert entity != null;
		Date moment;
		Job job;
		Worker worker;
		int jobid;
		Principal principal;

		principal = request.getPrincipal();
		worker = this.repository.findWorkerById(principal.getActiveRoleId());
		jobid = request.getModel().getInteger("jobid");
		job = this.repository.findJobById(jobid);
		String referenceApp = request.getModel().getString("referenceapp");
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setJob(job);
		entity.setWorker(worker);
		entity.setReference(job.getReference() + ":" + referenceApp);
		entity.setStatus("PENDING");
		entity.setMoment(moment);
		this.repository.save(entity);
	}

}
