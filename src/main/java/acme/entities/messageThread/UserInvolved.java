
package acme.entities.messageThread;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import acme.framework.entities.Authenticated;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserInvolved extends DomainEntity {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	//Relations
	@Valid
	@NotNull
	@ManyToOne(optional = false)
	private MessageThread		messageThread;

	@Valid
	@NotNull
	@ManyToOne(optional = false)
	private Authenticated		user;

}
