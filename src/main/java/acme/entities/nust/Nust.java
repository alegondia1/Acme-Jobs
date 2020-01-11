
package acme.entities.nust;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.jobs.Job;
import acme.entities.password.Password;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Nust extends DomainEntity {

	//Serialisation identifier-----------------------------

	private static final long	serialVersionUID	= 1L;

	//Attributes---------------------------------------

	@NotBlank
	@Length(max = 256)
	private String				pText;
	@URL
	private String				keylet;

	@OneToOne(optional = false)
	private Job					Job;

	@Valid
	@OneToOne(mappedBy = "Nust")
	private Password			password;

}
