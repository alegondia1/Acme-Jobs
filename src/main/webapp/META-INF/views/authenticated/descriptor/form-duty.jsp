<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="authenticated.duty.form.label.title" path="title"/>
	<acme:form-textarea code="authenticated.duty.form.label.description" path="description"/>
	<acme:form-double code="authenticated.duty.form.label.percentaje" path="percentaje"/>

	<acme:form-return code="authenticated.descriptor.form.button.return"/>
</acme:form>
