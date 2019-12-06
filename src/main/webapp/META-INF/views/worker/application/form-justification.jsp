<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="worker.application.form.label.justification.reason" path="reason"/>
	
	<div class="form-group" >
	<label><acme:message code="worker.application.form.label.app"/></label>
	<input readonly="readonly" type="text" class="form-control" value="${application.reference}"> 
	</div>
	<acme:form-return code="worker.application.form.button.return"/>
</acme:form>