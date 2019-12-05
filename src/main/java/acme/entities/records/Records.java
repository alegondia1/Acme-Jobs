
package acme.entities.records;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Records extends DomainEntity {

	// Serialisation identifier

	private static final long	serialVersionUID	= 1L;

	//Attributes

	@NotBlank
	private String				name;

	@NotBlank
	private String				sector;

	@NotBlank
	private String				ceo;

	@NotBlank
	@Column(length = 1024)
	private String				description;

	@NotBlank
	@URL
	private String				website;

	@NotBlank
	@Pattern(regexp = "(\\+\\d{1,3}\\s)?(\\(\\d{1,4}\\)\\s)?\\d{6,10}")
	private String				phone;

	@Email
	@NotBlank
	private String				mail;

	@Range(min = 0, max = 5)
	private Double				stars;

	private Boolean				incorporated;

}
