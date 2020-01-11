
package acme.entities.password;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import acme.entities.nust.Nust;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Password extends DomainEntity {

	//Serialisation identifier-----------------------------

	private static final long	serialVersionUID	= 1L;

	//Attributes---------------------------------------
	//@Pattern(regexp = "(^(?=.*[a-zA-Z] {3,})(?=.*[0-9] {3,})(?=.*\\p{P}{2,}).{8,}$)?", message = "The pass must contain atleas 3 letters, 3 digits and 2 symbols")
	//@Pattern(regexp = "(^(?=.*\\d{2,})(?=.*\\p{P}{2,})(?=.*[A-z]{2,})\\S{8,}$)?")
	private String				pass;

	@OneToOne(optional = false)
	private Nust				Nust;

}
