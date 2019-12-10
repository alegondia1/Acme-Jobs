
package acme.forms;

import java.io.Serializable;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable {

	/**
	 *
	 */
	private static final long		serialVersionUID	= 1L;

	//Atributes
	private Double					numberAnnouncement;
	private Double					numberCompanyRecord;
	private Double					numberInvestorRecord;
	private Double					minRewardRequest;
	private Double					maxRewardRequest;
	private Double					avgRewardRequest;
	private Double					desvRewardRequest;
	private Double					minRewardOffer;
	private Double					maxRewardOffer;
	private Double					avgRewardOffer;
	private Double					desvRewardOffer;

	private Map<String, Integer>	investorGroupBySector;
	private Map<String, Integer>	companyGroupBySector;

	//D04
	private Double					avgNumJobsPerEmmployer;
	private Double					avgNumApplPerEmmployer;
	private Double					avgNumApplPerWorker;

	private Map<Boolean, Integer>	ratioJobGroupbyStatus;
	private Map<String, Integer>	ratioAppGroupbyStatus;

	//D05

	private Map<String, Integer>	pendingApplicationsPerDay;
	private Map<String, Integer>	acceptedApplicationsPerDay;
	private Map<String, Integer>	rejectedApplicationsPerDay;
}
