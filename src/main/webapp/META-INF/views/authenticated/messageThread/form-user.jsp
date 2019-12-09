<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<jstl:if test="${command != 'show'}">
<acme:form>
	<acme:form-hidden path="threadid"/>
	<acme:form-textbox code="authenticated.userinvolved.form.label.username" path="username"/>

	<div class="form-group" >
	<label><acme:message code="authenticated.userinvolved.form.label.thread"/></label>
	<input readonly="readonly" type="text" class="form-control" value="${messageThread.title}"> 
	</div>
	<acme:form-submit code="authenticated.messageThread.form.button.add" action="/authenticated/user-involved/create"/>
	
	<acme:form-return code="authenticated.messageThread.form.button.return"/>
</acme:form>
</jstl:if>
<jstl:if test="${command == 'show'}">
<acme:form>
	<acme:form-textbox code="authenticated.userinvolved.form.label.username" readonly="true" path="user.userAccount.username"/>
	<div class="form-group" >
	<label><acme:message code="authenticated.userinvolved.form.label.thread"/></label>
	<input readonly="readonly" type="text" class="form-control" value="${threadTitle}"> 
	</div>
	<acme:form-submit code="authenticated.messageThread.form.button.eliminate" action="/authenticated/user-involved/delete?id=${user.id}&threadid=${messageThread.id}"/>
	<acme:form-return code="authenticated.messageThread.form.button.return"/>
</acme:form>
</jstl:if>