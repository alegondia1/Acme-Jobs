
package acme.features.administrator.requestAuditor;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.requestAuditor.RequestAuditor;
import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorRequestAuditorRepository extends AbstractRepository {

	@Query("select p from RequestAuditor p where p.user.id = ?1")
	RequestAuditor findOneRequestAuditorByUserAccountId(int id);

	@Query("select ua from UserAccount ua where ua.id = ?1")
	UserAccount findOneUserAccountById(int id);

	@Query("select p from RequestAuditor p where p.id = ?1")
	RequestAuditor findOneById(int id);

	@Query("select p from RequestAuditor p")
	Collection<RequestAuditor> findManyAll();

}
