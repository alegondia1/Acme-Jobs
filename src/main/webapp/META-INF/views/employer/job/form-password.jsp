<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="employer.job.form.label.password.pass" path="pass"/>
	

	
	
	
	<acme:form-submit test="${command == 'create'}" code="employer.job.form.button.create" action="/employer/password/create?id=${id}"/>
	<acme:form-return code="employer.application.form.button.return"/>
</acme:form>