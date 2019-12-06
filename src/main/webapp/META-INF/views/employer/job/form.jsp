<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="employer.job.form.label.title" path="title"/>
	<acme:form-moment code="employer.job.form.label.deadline" path="deadline"/>
	<acme:form-money code="employer.job.form.label.salary" path="salary"/>
	<acme:form-textbox code="employer.job.form.label.reference" path="reference"/>
	<acme:form-textbox code="employer.job.form.label.moreInfo" path="moreInfo"/>
	<jstl:if test="${command != 'create'}">
	<acme:form-checkbox code="employer.job.form.label.status" path="status"/>
	</jstl:if>
	<div class="form-group" >
	<label><acme:message code="employer.job.form.label.employer"/></label>
	<input readonly="readonly" type="text" class="form-control" value="${employer.userAccount.username}"> 
	</div>
	<acme:form-submit test="${command != 'create' && status==true && command != 'update'}" code="employer.job.form.button.descriptor" method="get" action="/employer/descriptor/show?id=${id}"/>
	<acme:form-submit test="${command != 'create' && status==true && command != 'update'}" code="employer.job.form.button.auditorRecord" method="get" action="/authenticated/auditor-record/list?id=${id}"/>
	<acme:form-submit test="${command != 'create' && status==true && command != 'update'}" code="employer.job.form.button.application" method="get" action="/employer/application/list?id=${id}"/>
	
	<acme:form-submit test="${command == 'show' && status==false}" code="employer.job.form.button.update" action="/employer/job/update"/>
	<acme:form-submit test="${command == 'show'}" code="employer.job.form.button.delete" action="/employer/job/delete"/>
	<acme:form-submit test="${command == 'create'}" code="employer.job.form.button.create" action="/employer/job/create"/>
	<acme:form-submit test="${command == 'update'}" code="employer.job.form.button.update" action="/employer/job/update"/>
	<acme:form-submit test="${command == 'delete'}" code="employer.job.form.button.delete" action="/employer/job/delete"/>
	<acme:form-return code="employer.job.form.button.return"/>
</acme:form>
