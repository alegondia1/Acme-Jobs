
package acme.features.administrator.customization;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.customizationParameters.CustomizationParameters;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorCustomizationParametersRepository extends AbstractRepository {

	@Query("select a from CustomizationParameters a where a.id = ?1")
	CustomizationParameters findOneById(int id);

	@Query("select a from CustomizationParameters a")
	CustomizationParameters find();

}
