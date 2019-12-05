<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="administrator.records.form.label.name" path="name"/>
	<acme:form-moment code="administrator.records.form.label.ceo" path="ceo"/>
		<acme:form-textbox code="administrator.records.form.label.sector" path="sector"/>
	<acme:form-textarea code="administrator.records.form.label.description" path="description"/>
	<acme:form-url code="administrator.records.form.label.website" path="website"/>
	<acme:form-textbox code="administrator.records.form.label.phone" path="phone"/>
	<acme:form-textbox code="administrator.records.form.label.mail" path="mail"/>
	<acme:form-textbox code="administrator.records.form.label.stars" path="stars"/>
	<acme:form-textbox code="administrator.records.form.label.incorporated" path="incorporated"/>
	
	
	<acme:form-submit test="${command == 'show'}" code="administrator.records.form.button.update" action="/administrator/records/update"/>
	<acme:form-submit test="${command == 'show'}" code="administrator.records.form.button.delete" action="/administrator/records/delete"/>
	<acme:form-submit test="${command == 'create'}" code="administrator.records.form.button.create" action="/administrator/records/create"/>
	<acme:form-submit test="${command == 'update'}" code="administrator.records.form.button.update" action="/administrator/records/update"/>
	<acme:form-submit test="${command == 'delete'}" code="administrator.records.form.button.delete" action="/administrator/records/delete"/>
	
	<acme:form-return code="anonymous.records.form.button.return"/>
</acme:form>
