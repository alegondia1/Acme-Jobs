<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="worker.job.form.label.title" path="title"/>
	<acme:form-moment code="worker.job.form.label.deadline" path="deadline"/>
	<acme:form-money code="worker.job.form.label.salary" path="salary"/>
	<acme:form-textarea code="worker.job.form.label.reference" path="reference"/>
	<acme:form-textbox code="worker.job.form.label.moreInfo" path="moreInfo"/>
	<acme:form-checkbox code="worker.job.form.label.status" path="status"/>
	
	<acme:check-access test="${hasControlCheck}">
	<acme:form-textbox code="worker.job.form.label.pText" path="pText"/>
	<acme:form-textbox code="worker.job.form.label.moreInfo2" path="moreInfo2"/>
	</acme:check-access>
	<acme:check-access test="${hasControlCheck2}">
	<acme:form-textbox code="worker.job.form.label.pass" path="pass"/>
	</acme:check-access>
	
	<div class="form-group" >
	<label><acme:message code="worker.job.form.label.employer"/></label>
	<input readonly="readonly" type="text" class="form-control" value="${employer.userAccount.username}"> 
	</div>
		<acme:form-submit code="worker.job.form.button.descriptor"
				  method="get" action="/authenticated/descriptor/show?id=${id}"/>
	<acme:form-submit code="worker.job.form.button.auditorRecord" method="get" action="/authenticated/auditor-record/list?id=${id}"/>
	<acme:form-submit code="worker.job.form.button.application" method="get" action="/worker/application/create?jobid=${id}"/>
	
	<acme:check-access test="${!hasControlCheck}">
	<acme:form-submit code="worker.job.form.button.ejuno" method="get" action="/worker/ejuno/create?id=${id}"/>
	</acme:check-access>
	<acme:check-access test="${hasControlCheck}">
	<acme:check-access test="${!hasControlCheck2}">
	<acme:form-submit code="worker.job.form.button.password" method="get" action="/worker/password/create?id=${id}"/>
	</acme:check-access>
	</acme:check-access>
	
	<acme:form-return code="worker.job.form.button.return"/>
</acme:form>
