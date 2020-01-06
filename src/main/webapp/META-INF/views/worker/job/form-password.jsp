<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="worker.job.form.label.password.pass" path="pass"/>
	

	
	
	
	<acme:form-submit test="${command == 'create'}" code="worker.job.form.button.create" action="/worker/password/create?id=${id}"/>
	<acme:form-return code="worker.application.form.button.return"/>
</acme:form>