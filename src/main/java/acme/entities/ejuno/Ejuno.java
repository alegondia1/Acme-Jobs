
package acme.entities.ejuno;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import acme.entities.jobs.Job;
import acme.entities.password.Password;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Ejuno extends DomainEntity {

	//Serialisation identifier-----------------------------

	private static final long	serialVersionUID	= 1L;

	//Attributes---------------------------------------

	@NotBlank
	@Length(min = 1, max = 10)
	private String				pText;

	private String				moreInfo2;

	@OneToOne(optional = false)
	private Job					Job;

	@Valid
	@OneToOne(mappedBy = "Ejuno")
	private Password			password;

}
