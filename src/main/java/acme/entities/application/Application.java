
package acme.entities.application;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import acme.entities.jobs.Job;
import acme.entities.roles.Worker;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = {
	@Index(columnList = "moment"), @Index(columnList = "status"), @Index(columnList = "moment, status")
})
public class Application extends DomainEntity {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	@Column(unique = true)
	@NotBlank
	@Pattern(regexp = "^\\D{4}-\\D{4}:\\D{4}$")
	private String				reference;

	@NotBlank
	@Column(length = 1024)
	private String				skills;

	@NotBlank
	@Column(length = 1024)
	private String				qualifications;

	@NotBlank
	@Column(length = 1024)
	private String				statements;

	@NotBlank
	@Pattern(regexp = "^ACCEPTED$|PENDING$|REJECTED$")
	private String				status;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				moment;
	//Relations----------------------------
	@Valid
	@NotNull
	@ManyToOne(optional = false)
	private Worker				worker;
	@Valid
	@NotNull
	@ManyToOne(optional = false)
	private Job					job;

}
