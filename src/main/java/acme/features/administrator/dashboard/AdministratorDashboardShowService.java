
package acme.features.administrator.dashboard;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {

	//Internal State -----------------------------
	@Autowired
	AdministratorDashboardRepository repository;


	// AbstractShowService<Administrator, Dashboard>

	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "numberAnnouncement", "numberCompanyRecord", "numberInvestorRecord", "minRewardRequest", "maxRewardRequest", "avgRewardRequest", "desvRewardRequest", "minRewardOffer", "maxRewardOffer", "avgRewardOffer",
			"desvRewardOffer", "investorGroupBySector", "companyGroupBySector", "avgNumJobsPerEmmployer", "avgNumApplPerEmmployer", "avgNumApplPerWorker", "ratioJobGroupbyStatus", "ratioAppGroupbyStatus", "pendingApplicationsPerDay",
			"acceptedApplicationsPerDay", "rejectedApplicationsPerDay");

	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		assert request != null;

		Dashboard result = new Dashboard();
		result.setNumberAnnouncement(this.repository.findNumberAnnouncement());
		result.setNumberCompanyRecord(this.repository.findNumberCompanyRecord());
		result.setNumberInvestorRecord(this.repository.findNumberInvestorRecord());
		result.setMinRewardRequest(this.repository.findMinRewardRequest());
		result.setMaxRewardRequest(this.repository.findMaxRewardRequest());
		result.setAvgRewardRequest(this.repository.findAvgRewardRequest());
		result.setDesvRewardRequest(this.repository.findDesvRewardRequest());
		result.setMinRewardOffer(this.repository.findMinRewardOffer());
		result.setMaxRewardOffer(this.repository.findMaxRewardOffer());
		result.setAvgRewardOffer(this.repository.findAvgRewardOffer());
		result.setDesvRewardOffer(this.repository.findDesvRewardOffer());

		Map<String, Integer> investorGroupBySector = new HashMap<String, Integer>();
		Map<String, Integer> companyGroupBySector = new HashMap<String, Integer>();
		Object[][] invO = this.repository.findInvestorGroupBySector();
		Object[][] conO = this.repository.findCompanyGroupBySector();
		for (Object[] obj : invO) {
			investorGroupBySector.put(obj[0].toString(), new Integer(obj[1].toString()));
		}
		for (Object[] obj : conO) {
			companyGroupBySector.put(obj[0].toString(), new Integer(obj[1].toString()));
		}

		result.setInvestorGroupBySector(investorGroupBySector);
		result.setCompanyGroupBySector(companyGroupBySector);

		/////////////////////D04///////////////////////////
		result.setAvgNumJobsPerEmmployer(this.repository.findAvgNumJobPerEmmployer());
		result.setAvgNumApplPerEmmployer(this.repository.findAvgNumApplPerEmmployer());
		result.setAvgNumApplPerWorker(this.repository.findAvgNumApplPerWorker());

		Map<Boolean, Integer> ratioJobGroupbyStatus = new HashMap<Boolean, Integer>();
		Map<String, Integer> ratioAppGroupbyStatus = new HashMap<String, Integer>();
		Object[][] ratioJobs = this.repository.findRatioJobGroupbyStatus();
		Object[][] ratioApps = this.repository.findRatioAppGroupbyStatus();
		for (Object[] obj : ratioJobs) {
			ratioJobGroupbyStatus.put(new Boolean(obj[0].toString()), new Integer(obj[1].toString()));
		}
		for (Object[] obj : ratioApps) {
			ratioAppGroupbyStatus.put(obj[0].toString(), new Integer(obj[1].toString()));
		}
		result.setRatioJobGroupbyStatus(ratioJobGroupbyStatus);
		result.setRatioAppGroupbyStatus(ratioAppGroupbyStatus);

		/////////////////////D05///////////////////////////
		Map<String, Integer> pendingApplicationsPerDay = new HashMap<String, Integer>();
		Map<String, Integer> acceptedApplicationsPerDay = new HashMap<String, Integer>();
		Map<String, Integer> rejectedApplicationsPerDay = new HashMap<String, Integer>();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		for (int i = 0; i < 28; i++) {
			Date from = new Date();
			Date to = new Date();
			Calendar hasta = Calendar.getInstance();
			hasta.add(Calendar.DAY_OF_YEAR, -i);
			Calendar desde = Calendar.getInstance();
			desde.add(Calendar.DAY_OF_YEAR, -(i + 1));
			from = desde.getTime();
			to = hasta.getTime();
			pendingApplicationsPerDay.put(dateFormat.format(to), this.repository.findPendingAppBetween(from, to));
			acceptedApplicationsPerDay.put(dateFormat.format(to), this.repository.findAcceptedAppBetween(from, to));
			rejectedApplicationsPerDay.put(dateFormat.format(to), this.repository.findRejectedAppBetween(from, to));
		}
		result.setPendingApplicationsPerDay(pendingApplicationsPerDay);
		result.setAcceptedApplicationsPerDay(acceptedApplicationsPerDay);
		result.setRejectedApplicationsPerDay(rejectedApplicationsPerDay);
		return result;
	}

}
