
package acme.features.sponsor.nonCommercialBanner;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.nonCommercialBanner.NonCommercialBanner;
import acme.entities.roles.Sponsor;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface SponsorNonCommercialBannerRepository extends AbstractRepository {

	@Query("select a from NonCommercialBanner a where a.id = ?1")
	NonCommercialBanner findOneById(int id);

	@Query("select a from NonCommercialBanner a where a.sponsor.id = ?1")
	Collection<NonCommercialBanner> findManyAll(int id);

	@Query("select r from Sponsor r where r.id = ?1")
	Sponsor findSponsorById(int id);

	@Query("select r.sponsor from NonCommercialBanner r where r.id = ?1")
	Sponsor findSponsorByNonCommercialBannerId(int id);

}
