
package acme.entities.requestAuditor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import acme.framework.entities.DomainEntity;
import acme.framework.entities.UserAccount;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RequestAuditor extends DomainEntity {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				firm;

	@NotBlank
	private String				responsibilityStatement;

	@Valid
	@OneToOne(optional = true)
	private UserAccount			user;

}
