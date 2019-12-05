<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="auditor.auditorRecord.form.label.title" path="title"/>
	<acme:form-moment code="auditor.auditorRecord.form.label.moment" path="moment"/>
	<acme:form-textarea code="auditor.auditorRecord.form.label.body" path="body"/>
	<div class="form-group" >
	<label><acme:message code="auditor.auditorRecord.form.label.username"/></label>
	<input readonly="readonly" type="text" class="form-control" value="${auditor.userAccount.username}"> 
	</div>
	<div class="form-group" >
	<label><acme:message code="auditor.auditorRecord.form.label.job"/></label>
	<input readonly="readonly" type="text" class="form-control" value="${job.title}"> 
	</div>
	<acme:form-return code="auditor.auditorRecord.form.button.return"/>
</acme:form>
