<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-hidden path="idjob"/>
	<acme:form-textbox code="auditor.auditorRecord.form.label.title" path="title"/>
	<jstl:if test="${command == 'show'}">
	<acme:form-moment code="auditor.auditorRecord.form.label.moment" readonly="true" path="moment"/>
	</jstl:if>
	<acme:form-textarea code="auditor.auditorRecord.form.label.body" path="body"/>
	<acme:form-textbox code="auditor.auditorRecord.form.label.username" readonly="true" path="auditor.userAccount.username"/>
	<acme:form-textbox code="auditor.auditorRecord.form.label.job" readonly="true" path="job.title"/>
	<jstl:if test="${command != 'show'}">
	<acme:form-checkbox code="auditor.auditorRecord.form.label.status" path="status"/>
	</jstl:if>
	<acme:form-submit test="${command == 'create'}" code="auditor.auditorRecord.form.button.create" action="/auditor/auditor-record/create"/>
	<acme:form-submit test="${command == 'update'}" code="auditor.auditorRecord.form.button.update" action="/auditor/auditor-record/update"/>
	
	<acme:form-return code="auditor.auditorRecord.form.button.return"/>
</acme:form>
