<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="employer.job.form.label.ejuno.pText" path="pText"/>
	<acme:form-textbox code="employer.job.form.label.ejuno.moreInfo2" path="moreInfo2"/>

	
	
	
	<acme:form-submit test="${command == 'create'}" code="employer.job.form.button.createEjuno" action="/employer/ejuno/create?id=${id}"/>
	<acme:form-return code="employer.application.form.button.return"/>
</acme:form>