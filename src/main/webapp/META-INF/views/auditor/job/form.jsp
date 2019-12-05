<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="auditor.job.form.label.title" path="title"/>
	<acme:form-moment code="auditor.job.form.label.deadline" path="deadline"/>
	<acme:form-money code="auditor.job.form.label.salary" path="salary"/>
	<acme:form-textarea code="auditor.job.form.label.reference" path="reference"/>
	<acme:form-textbox code="auditor.job.form.label.moreInfo" path="moreInfo"/>
	<div class="form-group" >
	<label><acme:message code="auditor.job.form.label.employer"/></label>
	<input readonly="readonly" type="text" class="form-control" value="${employer.userAccount.username}"> 
	</div>
	<acme:form-submit code="auditor.job.form.button.descriptor"
				  method="get" action="/authenticated/descriptor/show?id=${id}"/>
	<acme:form-submit code="auditor.job.form.button.auditorRecord" method="get" action="/auditor/auditor-record/list?id=${id}"/>
	<acme:form-return code="auditor.job.form.button.return"/>
</acme:form>
