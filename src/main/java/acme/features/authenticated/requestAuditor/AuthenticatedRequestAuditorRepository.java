
package acme.features.authenticated.requestAuditor;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.requestAuditor.RequestAuditor;
import acme.entities.roles.Auditor;
import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedRequestAuditorRepository extends AbstractRepository {

	@Query("select r from UserAccount r where r.id = ?1")
	UserAccount findOneById(int id);

	@Query("select r from RequestAuditor r")
	Collection<RequestAuditor> findManyAll();

	@Query("select a from Auditor a where a.userAccount.id = ?1")
	Auditor findOneAuditorByUserAccountId(int id);

}
