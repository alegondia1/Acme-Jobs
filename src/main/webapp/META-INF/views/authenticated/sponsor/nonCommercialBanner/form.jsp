<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="sponsor.nonCommercialBanner.form.label.url" path="url"/>
	<acme:form-textbox code="sponsor.nonCommercialBanner.form.label.picture" path="picture"/>
	<acme:form-textbox code="sponsor.nonCommercialBanner.form.label.slogan" path="slogan"/>
	<acme:form-textbox code="sponsor.nonCommercialBanner.form.label.jingle" path="jingle"/>
	<div class="form-group" >
	<label><acme:message code="sponsor.commercialBanner.form.label.username"/></label>
	<input readonly="readonly" type="text" class="form-control" value="${sponsor.userAccount.username}"> 
	</div>
    <acme:form-submit test="${command == 'show'}" code="sponsor.nonCommercialBanner.form.button.update" action="/sponsor/non-commercial-banner/update"/>
	<acme:form-submit test="${command == 'show'}" code="sponsor.nonCommercialBanner.form.button.delete" action="/sponsor/non-commercial-banner/delete"/>
	<acme:form-submit test="${command == 'create'}" code="sponsor.nonCommercialBanner.form.button.create" action="/sponsor/non-commercial-banner/create"/>
	<acme:form-submit test="${command == 'update'}" code="sponsor.nonCommercialBanner.form.button.update" action="/sponsor/non-commercial-banner/update"/>
	<acme:form-submit test="${command == 'delete'}" code="sponsor.nonCommercialBanner.form.button.delete" action="/sponsor/non-commercial-banner/delete"/>
	
	
	<acme:form-return code="sponsor.nonCommercialBanner.form.button.return"/>
</acme:form>
