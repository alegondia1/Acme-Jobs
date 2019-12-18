
package acme.features.employer.descriptor;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.descriptor.Descriptor;
import acme.entities.dutys.Duty;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.features.employer.dutys.EmployerDutysRepository;
import acme.features.employer.job.EmployerJobRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class EmployerDescriptorCreateService implements AbstractCreateService<Employer, Descriptor> {

	//Internal State -----------------------------
	@Autowired
	EmployerDescriptorRepository	repository;
	@Autowired
	EmployerJobRepository			jobRepository;
	@Autowired
	EmployerDutysRepository			dutyRepository;


	@Override
	public boolean authorise(final Request<Descriptor> request) {
		assert request != null;

		boolean result;
		int jobId;
		Job job;
		Employer employer;
		Principal principal;

		jobId = request.getModel().getInteger("jobid");
		job = this.repository.findJobById(jobId);
		employer = job.getEmployer();
		principal = request.getPrincipal();
		result = job.getDescriptor() == null && !job.getStatus() && employer.getId() == principal.getActiveRoleId();
		return result;
	}

	@Override
	public void unbind(final Request<Descriptor> request, final Descriptor entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		int jobId = request.getModel().getInteger("jobid");
		model.setAttribute("jobid", jobId);
		request.unbind(entity, model, "description", "dutys");

	}

	@Override
	public void bind(final Request<Descriptor> request, final Descriptor entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public Descriptor instantiate(final Request<Descriptor> request) {
		Descriptor descriptor = new Descriptor();
		Collection<Duty> dutys = new ArrayList<Duty>();
		descriptor.setDescription("Description");
		descriptor.setDutys(dutys);
		return descriptor;
	}

	@Override
	public void validate(final Request<Descriptor> request, final Descriptor entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		int jobId;
		Job job;
		Double percentaje = 0.0;
		Boolean cont = true;
		int i = 1;
		while (cont) {
			if (request.getModel().hasAttribute("percentaje" + i)) {
				String title = request.getModel().getString("title" + i);
				String description = request.getModel().getString("description" + i);
				if (!(title.isEmpty() || description.isEmpty())) {
					if (this.isNumeric(request.getModel().getAttribute("percentaje" + i).toString().replace(",", "."))) {
						Double perc = Double.parseDouble(request.getModel().getAttribute("percentaje" + i).toString().replace(",", "."));
						if (perc < 0) {
							errors.state(request, false, "dutys", "employer.descriptor.form.label.negative");
						}
						percentaje = percentaje + perc;
						Duty duty = new Duty();
						duty.setDescription(description);
						duty.setPercentaje(perc);
						duty.setTitle(title);
						Collection<Duty> dutys = entity.getDutys();
						dutys.add(duty);
						request.getModel().setAttribute("dutys", dutys);
					} else {
						errors.state(request, false, "dutys", "employer.descriptor.form.label.percentajenumber");
						cont = false;
					}
				}
			} else {
				cont = false;
			}
			i = i + 1;
		}
		errors.state(request, percentaje == 100.0, "dutys", "employer.descriptor.form.label.percentajemax");

		jobId = request.getModel().getInteger("jobid");
		job = this.repository.findJobById(jobId);
		errors.state(request, job.getDescriptor() == null, "description", "employer.descriptor.form.label.alradyhasdescriptor");

	}

	private boolean isNumeric(final String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			@SuppressWarnings("unused")
			double d = Double.parseDouble(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	@Override
	public void create(final Request<Descriptor> request, final Descriptor entity) {
		assert request != null;
		assert entity != null;
		int jobId;
		Job job;
		Boolean cont = true;
		int i = 1;
		Collection<Duty> dutys = new ArrayList<Duty>();
		while (cont) {
			Duty duty = new Duty();
			if (request.getModel().hasAttribute("percentaje" + i)) {
				String title = request.getModel().getString("title" + i);
				String description = request.getModel().getString("description" + i);
				if (!(title.isEmpty() || description.isEmpty())) {
					Double percentaje = Double.parseDouble(request.getModel().getAttribute("percentaje" + i).toString().replace(",", "."));
					duty.setTitle(title);
					duty.setDescription(description);
					duty.setPercentaje(percentaje);
					Duty addDuty = this.dutyRepository.save(duty);
					dutys.add(addDuty);
				}
			} else {
				cont = false;
			}
			i = i + 1;
		}
		entity.setDutys(dutys);
		Descriptor descriptor = this.repository.save(entity);
		jobId = request.getModel().getInteger("jobid");
		job = this.repository.findJobById(jobId);
		job.setDescriptor(descriptor);
		this.jobRepository.save(job);

	}

}
