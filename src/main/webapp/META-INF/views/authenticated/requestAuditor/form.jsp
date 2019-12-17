<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textarea code="authenticated.requestAuditor.requestAuditor.form.label.responsibilityStatement" path="responsibilityStatement"/>
	<acme:form-textbox code="authenticated.requestAuditor.requestAuditor.form.label.firm" path="firm"/>
	
	<acme:form-submit test="${command == 'create'}" code="authenticated.requestAuditor.requestAuditor.form.button.create" action="/authenticated/request-auditor/create"/>
	<acme:form-return code="authenticated.requestAuditor.requestAuditor.form.button.return"/>
</acme:form>
