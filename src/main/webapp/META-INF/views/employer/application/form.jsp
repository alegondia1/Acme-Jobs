<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="employer.application.form.label.reference" path="reference"/>
	<acme:form-moment code="employer.application.form.label.moment" path="moment"/>
	<acme:form-textarea code="employer.application.form.label.skills" path="skills"/>
	<acme:form-textarea code="employer.application.form.label.qualifications" path="qualifications"/>
	<acme:form-textarea code="employer.application.form.label.statements" path="statements"/>
	<acme:form-textbox code="employer.application.form.label.status" path="status"/>
	<div class="form-group" >
	<label><acme:message code="employer.application.form.label.worker"/></label>
	<input readonly="readonly" type="text" class="form-control" value="${worker.userAccount.username}"> 
	</div>
	<div class="form-group" >
	<label><acme:message code="employer.application.form.label.job"/></label>
	<input readonly="readonly" type="text" class="form-control" value="${job.title}"> 
	</div>

	<acme:form-return code="employer.application.form.button.return"/>
</acme:form>
