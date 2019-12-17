<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="employer.application.form.label.reference" readonly="true" path="reference"/>
	<acme:form-moment code="employer.application.form.label.moment" readonly="true" path="moment"/>
	<acme:form-textarea code="employer.application.form.label.skills" readonly="true" path="skills"/>
	<acme:form-textarea code="employer.application.form.label.qualifications" readonly="true" path="qualifications"/>
	<acme:form-textarea code="employer.application.form.label.statements" readonly="true" path="statements"/>
	<acme:form-textbox code="employer.application.form.label.status" readonly="true" path="status"/>
	<acme:form-textbox code="employer.application.form.label.worker" readonly="true" path="worker.userAccount.username"/>
	<acme:form-textbox code="employer.application.form.label.job" readonly="true" path="job.title"/>

	<acme:form-submit test="${status == 'PENDING'}" code="employer.application.form.button.accept" action="/employer/application/accept?id=${id}"/>
	<acme:form-submit test="${status == 'PENDING'}" code="employer.application.form.button.reject" method="get" action="/employer/justification/create?idapp=${id}"/>
	<acme:form-return code="employer.application.form.button.return"/>
</acme:form>
