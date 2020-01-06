
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

	private String				pass;

	@OneToOne(optional = false)
	private Ejuno				Ejuno;

}
