<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="anonymous.starsCR.form.label.name" path="name"/>
	<acme:form-textbox code="anonymous.starsCR.form.label.sector" path="sector"/>
	<acme:form-textbox code="anonymous.starsCR.form.label.ceo" path="ceo"/>
	<acme:form-textarea code="anonymous.starsCR.form.label.description" path="description"/>
	<acme:form-url code="anonymous.starsCR.form.label.website" path="website"/>
	<acme:form-textbox code="anonymous.starsCR.form.label.phone" path="phone"/>
	<acme:form-textbox code="anonymous.starsCR.form.label.mail" path="mail"/>
	<acme:form-textbox code="anonymous.starsCR.form.label.stars" path="stars"/>
	<acme:form-textbox code="anonymous.starsCR.form.label.incorporated" path="incorporated"/>
	
	<acme:form-return code="anonymous.starsCR.form.button.return"/>
</acme:form>
