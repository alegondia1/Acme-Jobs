<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<script src="/META-INF/resources/libraries/chart.js/2.7.2/js/chart.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var data = {
				labels : [
				<jstl:forEach var="entry" items="${investorGroupBySector}">
				  	"<jstl:out value="${entry.key}"/>",
				</jstl:forEach>
				],
				datasets : [{
						data : [
							<jstl:forEach var="entry" items="${investorGroupBySector}">
							  	<jstl:out value="${entry.value}"/>,
							</jstl:forEach>
						]
					}]
		};
		var options = {
			scales :{
				yAxes : [
					{
						ticks : {
							suggestedMin : 0.0,
							suggestedMax : 1.0
						}
					}
				]
			},
			legend : {
				display : false
			}
		};
		var canvas, context;
		
		canvas = document.getElementById("canvas");
		context = canvas.getContext("2d");
		new Chart(context, {
					type: "bar",
					data : data,
					options : options
				});
	});
		

</script>

<script type="text/javascript">
	$(document).ready(function(){
		var data = {
				labels : [
				<jstl:forEach var="entry" items="${companyGroupBySector}">
				  	"<jstl:out value="${entry.key}"/>",
				</jstl:forEach>
				],
				datasets : [{
						data : [
							<jstl:forEach var="entry" items="${companyGroupBySector}">
							  	<jstl:out value="${entry.value}"/>,
							</jstl:forEach>
						]
					}]
		};
		var options = {
			scales :{
				yAxes : [
					{
						ticks : {
							suggestedMin : 0.0,
							suggestedMax : 1.0
						}
					}
				]
			},
			legend : {
				display : false
			}
		};
		var canvas, context;
		
		canvas = document.getElementById("canvas2");
		context = canvas.getContext("2d");
		new Chart(context, {
					type: "bar",
					data : data,
					options : options
				});
	});
		

</script>
<script type="text/javascript">
	$(document).ready(function(){
		var data = {
				labels : [
					<jstl:forEach var="entry" items="${ratioJobGroupbyStatus}">
					<jstl:if test="${entry.key == true}">
				  	"Published",
				  	</jstl:if>
				  	<jstl:if test="${entry.key == false}">
				  	"Draft",
				  	</jstl:if>
					</jstl:forEach>
				],
				datasets : [{
						data : [
							<jstl:forEach var="entry" items="${ratioJobGroupbyStatus}">
							  	<jstl:out value="${entry.value}"/>,
							</jstl:forEach>
						]
					}]
		};
		var options = {
			scales :{
				yAxes : [
					{
						ticks : {
							suggestedMin : 0.0,
							suggestedMax : 1.0
						}
					}
				]
			},
			legend : {
				display : false
			}
		};
		var canvas, context;
		
		canvas = document.getElementById("canvas3");
		context = canvas.getContext("2d");
		new Chart(context, {
					type: "bar",
					data : data,
					options : options
				});
	});
		

</script>
<script type="text/javascript">
	$(document).ready(function(){
		var data = {
				labels : [
					<jstl:forEach var="entry" items="${ratioAppGroupbyStatus}">
				  	"<jstl:out value="${entry.key}"/>",
					</jstl:forEach>
				],
				datasets : [{
						data : [
							<jstl:forEach var="entry" items="${ratioAppGroupbyStatus}">
							  	<jstl:out value="${entry.value}"/>,
							</jstl:forEach>
						]
					}]
		};
		var options = {
			scales :{
				yAxes : [
					{
						ticks : {
							suggestedMin : 0.0,
							suggestedMax : 1.0
						}
					}
				]
			},
			legend : {
				display : false
			}
		};
		var canvas, context;
		
		canvas = document.getElementById("canvas4");
		context = canvas.getContext("2d");
		new Chart(context, {
					type: "bar",
					data : data,
					options : options
				});
	});
		

</script>
<script type="text/javascript">
	$(document).ready(function(){
		var data = {
				labels : [
					<jstl:forEach var="entry" items="${pendingApplicationsPerDay}">
				  	"<jstl:out value="${entry.key}"/>",
					</jstl:forEach>
				],
				datasets : [{
						data : [
							<jstl:forEach var="entry" items="${pendingApplicationsPerDay}">
							  	<jstl:out value="${entry.value}"/>,
							</jstl:forEach>
						]
					}]
		};
		var options = {
			scales :{
				yAxes : [
					{
						ticks : {
							suggestedMin : 0.0,
							suggestedMax : 1.0
						}
					}
				]
			},
			legend : {
				display : false
			}
		};
		var canvas, context;
		
		canvas = document.getElementById("canvas5");
		context = canvas.getContext("2d");
		new Chart(context, {
					type: "line",
					data : data,
					options : options
				});
	});
		

</script>
<script type="text/javascript">
	$(document).ready(function(){
		var data = {
				labels : [
					<jstl:forEach var="entry" items="${acceptedApplicationsPerDay}">
				  	"<jstl:out value="${entry.key}"/>",
					</jstl:forEach>
				],
				datasets : [{
						data : [
							<jstl:forEach var="entry" items="${acceptedApplicationsPerDay}">
							  	<jstl:out value="${entry.value}"/>,
							</jstl:forEach>
						]
					}]
		};
		var options = {
			scales :{
				yAxes : [
					{
						ticks : {
							suggestedMin : 0.0,
							suggestedMax : 1.0
						}
					}
				]
			},
			legend : {
				display : false
			}
		};
		var canvas, context;
		
		canvas = document.getElementById("canvas6");
		context = canvas.getContext("2d");
		new Chart(context, {
					type: "line",
					data : data,
					options : options
				});
	});
		

</script>
<script type="text/javascript">
	$(document).ready(function(){
		var data = {
				labels : [
					<jstl:forEach var="entry" items="${rejectedApplicationsPerDay}">
				  	"<jstl:out value="${entry.key}"/>",
					</jstl:forEach>
				],
				datasets : [{
						data : [
							<jstl:forEach var="entry" items="${rejectedApplicationsPerDay}">
							  	<jstl:out value="${entry.value}"/>,
							</jstl:forEach>
						]
					}]
		};
		var options = {
			scales :{
				yAxes : [
					{
						ticks : {
							suggestedMin : 0.0,
							suggestedMax : 1.0
						}
					}
				]
			},
			legend : {
				display : false
			}
		};
		var canvas, context;
		
		canvas = document.getElementById("canvas7");
		context = canvas.getContext("2d");
		new Chart(context, {
					type: "line",
					data : data,
					options : options
				});
	});
		

</script>
<h2>D05</h2>
<div>
	<h2><acme:message code="administrator.dashboard.form.label.pendingApplicationsPerDay"/></h2>
	<canvas id="canvas5"></canvas>
</div>
<div>
	<h2><acme:message code="administrator.dashboard.form.label.acceptedApplicationsPerDay"/></h2>
	<canvas id="canvas6"></canvas>
</div>
<div>
	<h2><acme:message code="administrator.dashboard.form.label.rejectedApplicationsPerDay"/></h2>
	<canvas id="canvas7"></canvas>
</div>
<h2>D04</h2>
<acme:form>
	<acme:form-double code="administrator.dashboard.form.label.avgNumJobsPerEmmployer" readonly="true" path="avgNumJobsPerEmmployer"/>
	<acme:form-double code="administrator.dashboard.form.label.avgNumApplPerEmmployer" readonly="true" path="avgNumApplPerEmmployer"/>
	<acme:form-double code="administrator.dashboard.form.label.avgNumApplPerWorker" readonly="true" path="avgNumApplPerWorker"/>
</acme:form>
<div>
	<h2><acme:message code="administrator.dashboard.form.label.ratioJobGroupbyStatus"/></h2>
	<canvas id="canvas3"></canvas>
</div>
<div>
	<h2><acme:message code="administrator.dashboard.form.label.ratioAppGroupbyStatus"/></h2>
	<canvas id="canvas4"></canvas>
</div>
<h2>D02</h2>
<acme:form>
	<acme:form-double code="administrator.dashboard.form.label.numAnnouncement" readonly="true" path="numberAnnouncement"/>
	<acme:form-double code="administrator.dashboard.form.label.numInvestorRecord" readonly="true" path="numberInvestorRecord"/>
	<acme:form-double code="administrator.dashboard.form.label.numCompanyRecord" readonly="true" path="numberCompanyRecord"/>
	<acme:form-double code="administrator.dashboard.form.label.minRewardRequest" readonly="true" path="minRewardRequest"/>
	<acme:form-double code="administrator.dashboard.form.label.maxRewardRequest" readonly="true" path="maxRewardRequest"/>
	<acme:form-double code="administrator.dashboard.form.label.avgRewardRequest" readonly="true" path="avgRewardRequest"/>
	<acme:form-double code="administrator.dashboard.form.label.desvRewardRequest" readonly="true" path="desvRewardRequest"/>
	<acme:form-double code="administrator.dashboard.form.label.minRewardOffer" readonly="true" path="minRewardOffer"/>
	<acme:form-double code="administrator.dashboard.form.label.maxRewardOffer" readonly="true" path="maxRewardOffer"/>
	<acme:form-double code="administrator.dashboard.form.label.avgRewardOffer" readonly="true" path="avgRewardOffer"/>
	<acme:form-double code="administrator.dashboard.form.label.desvRewardOffer" readonly="true" path="desvRewardOffer"/>
		
</acme:form>
<div>
	<h2><acme:message code="administrator.dashboard.form.label.investorGroupBySector"/></h2>
	<canvas id="canvas"></canvas>
</div>
<div>
	<h2><acme:message code="administrator.dashboard.form.label.companyGroupBySector"/></h2>
	<canvas id="canvas2"></canvas>
</div>
<acme:form>
<acme:form-return code="administrator.dashboard.form.button.return"/>
</acme:form>
