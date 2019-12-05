<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<acme:form>
	<acme:form-textbox code="authenticated.messageThread.form.label.title" path="title"/>
	<acme:form-moment code="authenticated.messageThread.form.label.moment" path="moment"/>
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
	<tr onclick="location.href='../acme-jobs/authenticated/message/show?id=${entry.id}'">
		<td><acme:message code="${entry.title}"/></td>
		<td><acme:message code="${entry.moment}"/></td>
	</tr>
	</jstl:forEach>
	</tbody>
	</table>
	<acme:form-return code="authenticated.messageThread.form.button.return"/>
</acme:form>
