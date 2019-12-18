<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<script>
	var el = document.getElementById("count");
	var xyz = jQuery.url.param("count");
	el.value = xyz;
</script>

<input id="count" type="hidden" value="" />
<jstl:set var="count" value='<%=request.getParameter("count")%>' scope="page" />
<label><acme:print value="---------------------${count}----------------------"/></label><br>
		<label><acme:message code="employer.duty.list.label.title"/></label>
		<input id="title${count}" name="title${count}" value="<acme:print value="${entry.title}"/>" type="text" class="form-control"/>
		<label><acme:message code="employer.duty.list.label.percentaje"/></label>
		<input id="percentaje${count}" name="percentaje${count}" value="<acme:print value="${entry.percentaje}"/>" placeholder="${MessageHelper.getMessage('default.placeholder.double')}" type="text" class="form-control"/>
		<label><acme:message code="employer.duty.list.label.description"/></label>
		<input id="description${count}" name="description${count}" value="<acme:print value="${entry.description}"/>" type="text" class="form-control"/>

