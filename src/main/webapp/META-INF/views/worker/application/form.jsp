<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-hidden path="jobid"/>
	<jstl:if test="${command == 'create'}">
	<acme:form-textbox code="worker.application.form.label.reference" path="referenceapp"/>
	</jstl:if>
	<jstl:if test="${command != 'create'}">
	<acme:form-moment code="worker.application.form.label.moment" readonly="true" path="moment"/>
	<acme:form-moment code="worker.application.form.label.reference" readonly="true" path="reference"/>
	</jstl:if>
	<acme:form-textarea code="worker.application.form.label.skills" path="skills"/>
	<acme:form-textarea code="worker.application.form.label.qualifications" path="qualifications"/>
	<acme:form-textarea code="worker.application.form.label.statements" path="statements"/>
	<jstl:if test="${command != 'create'}">
	<acme:form-textbox code="worker.application.form.label.status" path="status"/>
	</jstl:if>
	<acme:form-textbox code="worker.application.form.label.worker" readonly="true" path="worker.userAccount.username"/>
	<acme:form-textbox code="worker.application.form.label.job" readonly="true" path="job.title"/>
	
	<acme:form-submit test="${command != 'create' && status == 'REJECTED'}" code="worker.application.form.label.button.justification" method="get" action="/worker/justification/show?id=${id}"/>
	<acme:form-submit test="${command == 'create'}" code="worker.application.form.label.button.create" action="/worker/application/create"/>
	<acme:form-return code="worker.application.form.button.return"/>
</acme:form>
