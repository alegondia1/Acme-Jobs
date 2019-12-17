<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-hidden path="existRecord"/>
	<acme:form-hidden path="idAuditor"/>
	<acme:form-hidden path="statusAuditor"/>
	<acme:form-textbox code="auditor.job.form.label.title" path="title"/>
	<acme:form-moment code="auditor.job.form.label.deadline" path="deadline"/>
	<acme:form-money code="auditor.job.form.label.salary" path="salary"/>
	<acme:form-textarea code="auditor.job.form.label.reference" path="reference"/>
	<acme:form-textbox code="auditor.job.form.label.moreInfo" path="moreInfo"/>
	<acme:form-textbox code="auditor.job.form.label.employer" path="employer.userAccount.username"/>
	<acme:form-submit code="auditor.job.form.button.descriptor"
				  method="get" action="/authenticated/descriptor/show?id=${id}"/>
	<acme:form-submit code="auditor.job.form.button.auditorRecord" method="get" action="/auditor/auditor-record/list?id=${id}"/>
	<jstl:if test="${existRecord == true}">
		<jstl:if test="${statusAuditor == true}">
			<acme:form-submit code="auditor.job.form.button.auditorRecord.show" method="get" action="/auditor/auditor-record/show?id=${idAuditor}"/>
		</jstl:if>
		<jstl:if test="${statusAuditor == false}">
			<acme:form-submit code="auditor.job.form.button.auditorRecord.update" method="get" action="/auditor/auditor-record/update?id=${idAuditor}"/>
		</jstl:if>
	</jstl:if>
	<jstl:if test="${existRecord == false}">
		<acme:form-submit code="auditor.job.form.button.auditorRecord.create" method="get" action="/auditor/auditor-record/create?idjob=${id}"/>
	</jstl:if>
	<acme:form-return code="auditor.job.form.button.return"/>
</acme:form>
