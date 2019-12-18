<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<jstl:if test="${command != 'create'}">
<acme:form>
	<acme:form-textbox readonly="true" code="authenticated.messageThread.form.label.title" path="title"/>
	<acme:form-moment readonly="true" code="authenticated.messageThread.form.label.moment" path="moment"/>
	<label><acme:message code="authenticated.message.list"/></label>
	<table id="list" class="table table-striped table-condensed table-hover nowrap w-100">
	<thead>
	<tr>
    	<th><acme:message code="authenticated.message.list.label.title"/></th>
    	<th><acme:message code="authenticated.message.list.label.moment"/></th>
  	</tr>
  	</thead>
  	<tbody>
	<jstl:forEach var="entry" items="${messages}">
	<tr onclick="location.href='../authenticated/message/show?id=${entry.id}&threadid=${id}'">
		<td><acme:message code="${entry.title}"/></td>
		<td><acme:message code="${entry.moment}"/></td>
	</tr>
	</jstl:forEach>
	</tbody>
	</table>
	
	<acme:form-submit code="authenticated.messageThread.form.button.exit" action="/authenticated/user-involved/delete?id=-1&threadid=${id}"/>
	<acme:form-submit code="authenticated.messageThread.form.button.add" method="get" action="/authenticated/user-involved/create?threadid=${id}"/>
	<acme:form-submit code="authenticated.messageThread.form.button.list" method="get" action="/authenticated/user-involved/list?threadid=${id}"/>
	<acme:form-submit code="authenticated.messageThread.form.button.newmessage" method="get" action="/authenticated/message/create?threadid=${id}"/>
	<acme:form-return code="authenticated.messageThread.form.button.return"/>
</acme:form>
</jstl:if>
<jstl:if test="${command == 'create'}">
<acme:form>
	<acme:form-textbox code="authenticated.messageThread.form.label.title" path="title"/>
	
	<acme:form-submit test="${command == 'create'}" code="authenticated.messageThread.form.button.create" action="/authenticated/message-thread/create"/>
	<acme:form-return code="authenticated.messageThread.form.button.return"/>
</acme:form>
</jstl:if>