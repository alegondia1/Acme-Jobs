<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="authenticated.records.form.label.name" path="name"/>
	<acme:form-textbox code="authenticated.records.form.label.sector" path="sector"/>
	<acme:form-textbox code="authenticated.records.form.label.ceo" path="ceo"/>
	<acme:form-textarea code="authenticated.records.form.label.description" path="description"/>
	<acme:form-url code="authenticated.records.form.label.website" path="website"/>
	<acme:form-textbox code="authenticated.records.form.label.phone" path="phone"/>
	<acme:form-textbox code="authenticated.records.form.label.mail" path="mail"/>
	<acme:form-textbox code="authenticated.records.form.label.stars" path="stars"/>
	<acme:form-textbox code="authenticated.records.form.label.incorporated" path="incorporated"/>
	
	<acme:form-return code="authenticated.records.form.button.return"/>
</acme:form>
