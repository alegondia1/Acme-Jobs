
package acme.entities.customizationParameters;

import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CustomizationParameters extends DomainEntity {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	@NotNull
	@ElementCollection(fetch = FetchType.EAGER)
	private Collection<String>	spamWords;

	@Max(1)
	@Min(0)
	@NotNull
	private Double				spamThreshold;
}
