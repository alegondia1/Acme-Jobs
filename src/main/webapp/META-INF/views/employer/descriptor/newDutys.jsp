<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<label><acme:print value="---------------------${count}----------------------"/></label><br>
		<label><acme:message code="employer.duty.list.label.title"/></label>
		<input id="title${count}" name="title${count}" value="<acme:print value="${entry.title}"/>" type="text" class="form-control"/>
		<label><acme:message code="employer.duty.list.label.percentaje"/></label>
		<input id="percentaje${count}" name="percentaje${count}" value="<acme:print value="${entry.percentaje}"/>" placeholder="${MessageHelper.getMessage('default.placeholder.double')}" type="text" class="form-control"/>
		<label><acme:message code="employer.duty.list.label.description"/></label>
		<input id="description${count}" name="description${count}" value="<acme:print value="${entry.description}"/>" type="text" class="form-control"/>
		<jstl:set var="count" value="${count + 1}" scope="page"/>
