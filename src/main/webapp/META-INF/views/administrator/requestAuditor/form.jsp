<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>

	<acme:form-textbox code="administrator.requestAuditor.form.label.firm" path="firm"/>
	<acme:form-url code="administrator.requestAuditor.form.label.responsibilityStatement" path="responsibilityStatement"/>
	<acme:form-textarea code="administrator.requestAuditor.form.label.idUser" path="idUser"/>
	
	<acme:form-submit test="${command == 'show'}" code="administrator.requestAuditor.form.button.update" action="/administrator/requestAuditor/update"/>
	<acme:form-submit test="${command == 'show'}" code="administrator.requestAuditor.form.button.delete" action="/administrator/requestAuditor/delete"/>
	<acme:form-submit test="${command == 'create'}" code="administrator.requestAuditor.form.button.create" action="/administrator/requestAuditor/create"/>
	<acme:form-submit test="${command == 'update'}" code="administrator.requestAuditor.form.button.update" action="/administrator/requestAuditor/update"/>
	<acme:form-submit test="${command == 'delete'}" code="administrator.requestAuditor.form.button.delete" action="/administrator/requestAuditor/delete"/>
	<acme:form-return code="administrator.requestAuditor.form.button.return"/>

</acme:form>
