
package acme.features.administrator.dashboard;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select count(a) from Announcement a")
	Double findNumberAnnouncement();

	@Query("select count(c) from Records c")
	Double findNumberCompanyRecord();

	@Query("select count(i) from InvestorRecord i")
	Double findNumberInvestorRecord();

	@Query("select min(r.reward.amount) from Request r")
	Double findMinRewardRequest();

	@Query("select max(r.reward.amount) from Request r")
	Double findMaxRewardRequest();

	@Query("select avg(r.reward.amount) from Request r")
	Double findAvgRewardRequest();

	@Query("select min(r.reward.amount) from Offer r")
	Double findMinRewardOffer();

	@Query("select max(r.reward.amount) from Offer r")
	Double findMaxRewardOffer();

	@Query("select avg(r.reward.amount) from Offer r")
	Double findAvgRewardOffer();

	@Query("select sqrt(sum(r.reward.amount*r.reward.amount)/count(r)-(avg(r.reward.amount)*avg(r.reward.amount))) from Offer r")
	Double findDesvRewardOffer();

	@Query("select sqrt(sum(r.reward.amount*r.reward.amount)/count(r)-(avg(r.reward.amount)*avg(r.reward.amount))) from Request r")
	Double findDesvRewardRequest();

	@Query("select i.sector,count(i) from InvestorRecord i group by i.sector")
	Object[][] findInvestorGroupBySector();

	@Query("select i.sector,count(i) from Records i group by i.sector")
	Object[][] findCompanyGroupBySector();

	//////////////////////////D04//////////////////////////////////

	@Query("select avg(select count(j) from Job j where j.employer.id = r.id) from Employer r")
	Double findAvgNumJobPerEmmployer();

	@Query("select avg(select avg(select count(a) from Application a where a.job.id = j.id) from Job j where j.employer.id = r.id) from Employer r")
	Double findAvgNumApplPerEmmployer();

	@Query("select avg(select count(a) from Application a where a.worker.id = r.id) from Worker r")
	Double findAvgNumApplPerWorker();

	@Query("select j.status,count(j) from Job j group by j.status")
	Object[][] findRatioJobGroupbyStatus();

	@Query("select a.status,count(a) from Application a group by a.status")
	Object[][] findRatioAppGroupbyStatus();

	@Query("select count(a) from Application a where a.status='PENDING' and a.moment BETWEEN ?1 AND ?2")
	Integer findPendingAppBetween(Date from, Date to);

	@Query("select count(a) from Application a where a.status='ACCEPTED' and a.moment BETWEEN ?1 AND ?2")
	Integer findAcceptedAppBetween(Date from, Date to);

	@Query("select count(a) from Application a where a.status='REJECTED' and a.moment BETWEEN ?1 AND ?2")
	Integer findRejectedAppBetween(Date from, Date to);
}
