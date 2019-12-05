<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<acme:form>
	<acme:form-textbox code="authenticated.message.form.label.title" path="title"/>
	<acme:form-moment code="authenticated.message.form.label.moment" path="moment"/>
	<acme:form-textarea code="authenticated.message.form.label.body" path="body"/>
	<table id="list" class="table table-striped table-condensed table-hover nowrap w-100">
	<thead>
	<tr>
    	<th><acme:message code="authenticated.message.form.label.tags"/></th>
  	</tr>
  	</thead>
  	<tbody>
	<jstl:forEach var="entry" items="${tags}">
	<tr>
		<td><acme:message code="${entry}"/></td>
	</tr>
	</jstl:forEach>
	</tbody>
	</table>
	<div class="form-group" >
	<label><acme:message code="authenticated.message.form.label.user"/></label>
	<input readonly="readonly" type="text" class="form-control" value="${user.userAccount.username}"> 
	</div>
	
	<acme:form-return code="authenticated.messageThread.form.button.return"/>
</acme:form>
