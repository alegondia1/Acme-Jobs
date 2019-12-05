<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="anonymous.investorRecord.form.label.name" path="name"/>
	<acme:form-moment code="anonymous.investorRecord.form.label.sector" path="sector"/>
	<acme:form-moment code="anonymous.investorRecord.form.label.investingStatement" path="investingStatement"/>
	<acme:form-textbox code="anonymous.investorRecord.form.label.star" path="stars"/>
	
	<acme:form-return code="anonymous.offer.form.button.return"/>
</acme:form>
