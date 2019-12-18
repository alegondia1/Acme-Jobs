
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
import acme.framework.services.AbstractUpdateService;

@Service
public class EmployerDescriptorUpdateService implements AbstractUpdateService<Employer, Descriptor> {

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
		result = !job.getStatus() && employer.getId() == principal.getActiveRoleId();
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
	public void validate(final Request<Descriptor> request, final Descriptor entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		Double percentaje = 0.0;
		Boolean cont = true;
		int i = 1;
		Collection<Duty> dutys = new ArrayList<Duty>();
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
						if (request.getModel().hasAttribute("id" + i)) {
							int id = request.getModel().getInteger("id" + i);
							duty.setId(id);
						}
						dutys.add(duty);

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
		request.getModel().setAttribute("dutys", dutys);
		errors.state(request, percentaje == 100.0, "dutys", "employer.descriptor.form.label.percentajemax");

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
	public Descriptor findOne(final Request<Descriptor> request) {
		assert request != null;
		Descriptor result = new Descriptor();
		int id;

		id = request.getModel().getInteger("jobid");
		result = this.repository.findOneById(id);
		return result;
	}

	@Override
	public void update(final Request<Descriptor> request, final Descriptor entity) {
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
					final int j = i;
					if (request.getModel().hasAttribute("id" + i) && entity.getDutys().stream().anyMatch(X -> X.getId() == request.getModel().getInteger("id" + j))) {
						Integer id = request.getModel().getInteger("id" + i);
						duty.setId(id);
					}
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
