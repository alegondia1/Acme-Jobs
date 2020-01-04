<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="worker.application.form.label.ejdos.respuesta" path="respuesta"/>
	<acme:form-textbox code="worker.application.form.label.ejdos.xxxx" path="xxxx"/>
	<acme:form-textbox code="worker.application.form.label.ejdos.protec" path="protec"/>

	
	
	
	<acme:form-submit test="${command == 'create'}" code="worker.application.form.button.create" action="/worker/ejdos/create?id=${id}"/>
	<acme:form-return code="worker.application.form.button.return"/>
</acme:form>