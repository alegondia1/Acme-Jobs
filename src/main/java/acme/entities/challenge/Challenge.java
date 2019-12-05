
package acme.entities.challenge;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Challenge extends DomainEntity {

	//Serialisation identifier-----------------------------

	private static final long	serialVersionUID	= 1L;

	//Attributes---------------------------------------

	@NotBlank
	private String				title;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date				deadline;

	@NotBlank
	@Column(length = 1024)
	private String				description;

	@NotBlank
	private String				goalBronze;

	@NotBlank
	private String				rewardBronze;

	@NotBlank
	private String				goalSilver;

	@NotBlank
	private String				rewardSilver;

	@NotBlank
	private String				goalGold;

	@NotBlank
	private String				rewardGold;

	//Derived attributes-----------------------------------

	//Relationships----------------------------------------

}
