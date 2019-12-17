<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-hidden path="idapp"/>
	<acme:form-textarea code="employer.application.form.label.justification.reason" path="reason"/>
	<acme:form-textbox code="employer.application.form.label.justification.application" readonly="true" path="application.reference"/>
	
	<acme:form-submit test="${command == 'create'}" code="employer.application.form.label.justification.create" action="/employer/justification/create"/>
	<acme:form-return code="employer.application.form.button.return"/>
</acme:form>