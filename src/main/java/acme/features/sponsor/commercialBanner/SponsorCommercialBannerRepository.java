
package acme.features.sponsor.commercialBanner;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.commercialBanner.CommercialBanner;
import acme.entities.roles.Sponsor;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface SponsorCommercialBannerRepository extends AbstractRepository {

	@Query("select a from CommercialBanner a where a.id = ?1")
	CommercialBanner findOneById(int id);

	@Query("select a from CommercialBanner a where a.sponsor.id = ?1")
	Collection<CommercialBanner> findManyAll(int id);

	@Query("select r from Sponsor r where r.id = ?1")
	Sponsor findSponsorById(int id);

	@Query("select r.sponsor from CommercialBanner r where r.id = ?1")
	Sponsor findSponsorByCommercialBannerId(int id);

}
