<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="authenticated.descriptor.form.label.description" path="description"/>
	<label><acme:message code="authenticated.descriptor.dutys"/></label>
	<table id="list" class="table table-striped table-condensed table-hover nowrap w-100">
	<thead>
	<tr>
    	<th><acme:message code="authenticated.duty.list.label.title"/></th>
    	<th><acme:message code="authenticated.duty.list.label.percentaje"/></th>
  	</tr>
  	</thead>
  	<tbody>
	<jstl:forEach var="entry" items="${dutys}">
	<tr onclick="location.href='../acme-jobs/authenticated/duty/show?id=${entry.id}'">
		<td><acme:message code="${entry.title}"/></td>
		<td><acme:message code="${entry.percentaje}"/></td>
	</tr>
	</jstl:forEach>
	</tbody>
	</table>

	<acme:form-return code="authenticated.descriptor.form.button.return"/>
</acme:form>
