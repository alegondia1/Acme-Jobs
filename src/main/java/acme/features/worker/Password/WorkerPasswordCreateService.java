
package acme.features.worker.Password;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.ejuno.Ejuno;
import acme.entities.password.Password;
import acme.entities.roles.Worker;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class WorkerPasswordCreateService implements AbstractCreateService<Worker, Password> {

	//Internal State -----------------------------
	@Autowired
	WorkerPasswordRepository repository;


	@Override
	public boolean authorise(final Request<Password> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Password> request, final Password entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		int id;
		id = request.getModel().getInteger("id");

		request.unbind(entity, model, "pass");

		model.setAttribute("id", id);

	}

	@Override
	public void bind(final Request<Password> request, final Password entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public Password instantiate(final Request<Password> request) {
		assert request != null;
		Password result = new Password();
		Ejuno ejuno;

		int id;
		id = request.getModel().getInteger("id");

		ejuno = this.repository.findEjunoByJobId(id);

		//		result.setRespuesta("Respuesta");
		result.setEjuno(ejuno);

		return result;
	}

	@Override
	public void validate(final Request<Password> request, final Password entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		String protec = entity.getPass();

		errors.state(request, this.have3(protec), "errorvalidate", "worker.password.form.label.notpass");
	}

	private boolean have3(final String str) {
		if (str == null || str == "") {
			return true;
		}
		Integer let = 0;
		Integer num = 0;
		Integer sim = 0;
		char clave;
		for (int i = 0; i < str.length(); i++) {
			clave = str.charAt(i);
			String clav = String.valueOf(clave);
			if (clav.matches("[A-Z]") || clav.matches("[a-z]")) {
				let++;
			} else if (clav.matches("[0-9]")) {
				num++;
			} else {
				sim++;
			}

		}

		if (let >= 3 && num >= 3 && sim >= 2) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public void create(final Request<Password> request, final Password entity) {
		assert request != null;
		assert entity != null;
		Ejuno ejuno;

		int id;
		id = request.getModel().getInteger("id");

		ejuno = this.repository.findEjunoByJobId(id);
		ejuno.setPassword(entity);

		this.repository.save(ejuno);
		this.repository.save(entity);
	}

}
