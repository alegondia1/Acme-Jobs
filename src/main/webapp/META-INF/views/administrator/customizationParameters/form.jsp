<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<jstl:if test="${command != 'create'}">
<acme:form>
	<table id="list" class="table table-striped table-condensed table-hover nowrap w-100">
	<thead>
	<tr>
    	<th><acme:message code="administrator.customization.form.label.spamWords"/></th>
    	<th><label>Delete</label></th> 
  	</tr>
  	</thead>
  	<tbody>
	<jstl:forEach var="entry" items="${spamWords}">
	<tr>
		<td><acme:message code="${entry}"/></td>
		<td><acme:form-submit code="administrator.customization.form.button.delete" action="/administrator/customization-parameters/delete?spamword=${entry}&id=${id}"/></td>
	</tr>
	</jstl:forEach>
	</tbody>
	</table>
	<acme:form-double code="administrator.customization.form.label.spamThreshold" readonly="true" path="spamThreshold"/>
	
	<acme:form-return code="administrator.customization.form.button.return"/>
</acme:form>
</jstl:if>
<jstl:if test="${command == 'create'}">
<acme:form>
	<acme:form-textbox code="administrator.customization.form.label.add" path="newSpamWord"/>
	
	<acme:form-submit test="${command == 'create'}" code="administrator.customization.form.button.create" action="/administrator/customization-parameters/create"/>
	<acme:form-return code="administrator.customization.form.button.return"/>
</acme:form>
</jstl:if>
