
package acme.features.employer.job;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.application.Application;
import acme.entities.descriptor.Descriptor;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerJobRepository extends AbstractRepository {

	@Query("select r from Job r where r.id = ?1")
	Job findOneById(int id);

	@Query("select r from Employer r where r.id = ?1")
	Employer findEmployerById(int id);

	@Query("select r from Job r where r.employer.id = ?1")
	Collection<Job> findManyByEmployerId(int id);

	@Query("select o.reference from Job o")
	Collection<String> findManyAllReference();

	@Query("select r.descriptor from Job r where r.id = ?1")
	Descriptor findDescriptorByJobId(int id);

	@Query("select r from Application r where r.job.id = ?1")
	Collection<Application> findApplicationsByJobId(int id);

	@Query("select r from Job r")
	Collection<Job> findManyAll();
}
