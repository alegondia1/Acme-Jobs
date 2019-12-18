<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<jstl:if test="${command == 'show' && status==true}">
<acme:form>
	<acme:form-hidden path="jobid"/>
	<acme:form-hidden path="status"/>
	<acme:form-textbox code="employer.descriptor.form.label.description" readonly="true" path="description"/>
	<label><acme:message code="employer.descriptor.dutys"/></label>
	<table id="list" class="table table-striped table-condensed table-hover nowrap w-100">
	<thead>
	<tr>
    	<th><acme:message code="employer.duty.list.label.title"/></th>
    	<th><acme:message code="employer.duty.list.label.percentaje"/></th>
  	</tr>
  	</thead>
  	<tbody>
	<jstl:forEach var="entry" items="${dutys}">
	<tr onclick="location.href='../employer/duty/show?id=${entry.id}'">
		<td><acme:message code="${entry.title}"/></td>
		<td><acme:message code="${entry.percentaje}"/></td>
	</tr>
	</jstl:forEach>
	</tbody>
	</table>
	<acme:form-errors path="dutys"/>	

	<acme:form-return code="employer.descriptor.form.button.return"/>
</acme:form>
</jstl:if>

<jstl:if test="${command == 'show' && status==false || command == 'create' || command == 'update'  && status==false}">
<acme:form>
	<acme:form-hidden path="jobid"/>
	<acme:form-hidden path="status"/>
	<acme:form-textbox code="employer.descriptor.form.label.description" path="description"/>
	<label><acme:message code="employer.descriptor.dutys"/></label><br>
	<button class="btn btn-primary" onclick="include();" type="button"><acme:message code="employer.descriptor.adddutys"/></button><br>
	<jstl:set var="count" value="1" scope="page" />
	<jstl:forEach var="entry" items="${dutys}">
		<label><acme:print value="---------------------${count}----------------------"/></label><br>
		<label><acme:message code="employer.duty.list.label.title"/></label>
		<input id="id${count}" name="id${count}" type="hidden" value="${entry.id}" />
		<input id="title${count}" name="title${count}" value="<acme:print value="${entry.title}"/>" type="text" class="form-control"/>
		<label><acme:message code="employer.duty.list.label.percentaje"/></label>
		<input id="percentaje${count}" name="percentaje${count}" value="<acme:print value="${entry.percentaje}"/>" placeholder="${MessageHelper.getMessage('default.placeholder.double')}" type="text" class="form-control"/>
		<label><acme:message code="employer.duty.list.label.description"/></label>
		<input id="description${count}" name="description${count}" value="<acme:print value="${entry.description}"/>" type="text" class="form-control"/>
		<jstl:set var="count" value="${count + 1}" scope="page"/>
	</jstl:forEach><br>
	<input id="count" type="hidden" value="${count}" />
	<div id="form_sample">
	</div>
	<acme:form-errors path="dutys"/>	
	
	<acme:form-submit test="${command == 'show' && status==false}" code="employer.descriptor.form.button.update" action="/employer/descriptor/update?jobid=${jobid}"/>
	<acme:form-submit test="${command == 'create'}" code="employer.descriptor.form.button.create" action="/employer/descriptor/create?jobid=${jobid}"/>
	<acme:form-submit test="${command == 'update'}" code="employer.descriptor.form.button.update" action="/employer/descriptor/update?jobid=${jobid}"/>
	
	<acme:form-return code="employer.descriptor.form.button.return"/>
</acme:form>
</jstl:if>
<script>
function include(){
	var el = document.getElementById("count");
	var html =  '../acme-jobs/images/newDutys.jsp?count='+ el.value;
	$('#form_sample').append($("<div>").load(html));
	el.value = parseInt(el.value)+1;
	
}
</script>
