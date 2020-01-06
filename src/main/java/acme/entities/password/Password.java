
package acme.entities.password;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import acme.entities.ejuno.Ejuno;
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
	private String				pass;

	@OneToOne(optional = false)
	private Ejuno				Ejuno;

}