
package acme.features.authenticated.challengeTest;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.challengeTest.ChallengeTest;
import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedChallengeTestRepository extends AbstractRepository {

	@Query("select r.challengeTest from Job r where r.id=?1")
	ChallengeTest findOneByJobId(int id);

	@Query("select r from Job r where r.id = ?1")
	Job findOneJobByJobId(int id);

	@Query("select r from ChallengeTest r where r.id = ?1")
	ChallengeTest findOneById(int id);
}
