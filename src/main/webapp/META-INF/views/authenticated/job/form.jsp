<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="authenticated.job.form.label.title" path="title"/>
	<acme:form-moment code="authenticated.job.form.label.deadline" path="deadline"/>
	<acme:form-money code="authenticated.job.form.label.salary" path="salary"/>
	<acme:form-textarea code="authenticated.job.form.label.reference" path="reference"/>
	<acme:form-textbox code="authenticated.job.form.label.moreInfo" path="moreInfo"/>
	<acme:form-checkbox code="authenticated.job.form.label.status" path="status"/>
	<div class="form-group" >
	<label><acme:message code="authenticated.job.form.label.employer"/></label>
	<input readonly="readonly" type="text" class="form-control" value="${employer.userAccount.username}"> 
	</div>
		<acme:form-submit code="authenticated.job.form.button.descriptor"
				  method="get" action="/authenticated/descriptor/show?id=${id}"/>
	<acme:form-submit code="authenticated.job.form.button.auditorRecord" method="get" action="/authenticated/auditor-record/list?id=${id}"/>
	<acme:form-return code="authenticated.job.form.button.return"/>
</acme:form>
