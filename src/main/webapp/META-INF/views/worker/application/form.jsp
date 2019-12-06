<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="worker.application.form.label.reference" path="reference"/>
	<acme:form-moment code="worker.application.form.label.moment" path="moment"/>
	<acme:form-textarea code="worker.application.form.label.skills" path="skills"/>
	<acme:form-textarea code="worker.application.form.label.qualifications" path="qualifications"/>
	<acme:form-textarea code="worker.application.form.label.statements" path="statements"/>
	<acme:form-textbox code="worker.application.form.label.status" path="status"/>
	<div class="form-group" >
	<label><acme:message code="worker.application.form.label.worker"/></label>
	<input readonly="readonly" type="text" class="form-control" value="${worker.userAccount.username}"> 
	</div>
	<div class="form-group" >
	<label><acme:message code="worker.application.form.label.job"/></label>
	<input readonly="readonly" type="text" class="form-control" value="${job.title}"> 
	</div>
	<acme:form-submit test="${status == 'REJECTED'}" code="worker.application.form.label.button.justification" method="get" action="/worker/justification/show?id=${id}"/>
	<acme:form-return code="worker.application.form.button.return"/>
</acme:form>
