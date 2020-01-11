<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="worker.application.form.label.answer.respuesta" path="respuesta"/>
	<acme:form-textbox code="worker.application.form.label.answer.keylet" path="keylet"/>


	
	
	
	<acme:form-submit test="${command == 'create'}" code="worker.application.form.button.createAnswer" action="/worker/answer/create?id=${id}"/>
	<acme:form-return code="worker.application.form.button.return"/>
</acme:form>