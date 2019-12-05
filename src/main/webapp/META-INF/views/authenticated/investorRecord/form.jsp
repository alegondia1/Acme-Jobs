<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="authenticated.investorRecord.form.label.name" path="name"/>
	<acme:form-textbox code="authenticated.investorRecord.form.label.sector" path="sector"/>
	<acme:form-double code="authenticated.investorRecord.form.label.investingStatement" path="investingStatement"/>
	<acme:form-textbox code="authenticated.investorRecord.form.label.star" path="stars"/>
	
	<acme:form-return code="authenticated.investorRecord.form.button.return"/>
</acme:form>
