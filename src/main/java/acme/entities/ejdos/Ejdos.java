
package acme.entities.ejdos;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import acme.entities.application.Application;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Ejdos extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	String						respuesta;

	String						xxxx;

	@Length(min = 5)
	String						protec;

	@OneToOne(optional = false)
	private Application			application;

}
