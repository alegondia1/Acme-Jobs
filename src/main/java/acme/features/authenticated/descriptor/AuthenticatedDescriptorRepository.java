
package acme.features.authenticated.descriptor;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.descriptor.Descriptor;
import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedDescriptorRepository extends AbstractRepository {

	@Query("select r.descriptor from Job r where r.id=?1")
	Descriptor findOneById(int id);
	@Query("select r.descriptor from Job r where r.employer.id=?1")
	Collection<Descriptor> findManyByEmployerId(int id);
	@Query("select r from Job r where r.descriptor.id=?1")
	Job findJobByDescriptorId(int descriptorId);
	@Query("select r from Job r where r.id=?1")
	Job findJobById(int jobId);
	@Query("select r.descriptor from Job r where r.id=?1")
	Descriptor findOneByJobId(int id);

}
