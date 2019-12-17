<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<jstl:if test="${command == 'show' && status==true || command == 'delete'  && status==true }">
<acme:form>
	<acme:form-textbox code="employer.job.form.label.title" readonly="true" path="title"/>
	<acme:form-moment code="employer.job.form.label.deadline" readonly="true" path="deadline"/>
	<acme:form-money code="employer.job.form.label.salary" readonly="true" path="salary"/>
	<acme:form-textbox code="employer.job.form.label.reference" readonly="true" path="reference"/>
	<acme:form-textbox code="employer.job.form.label.moreInfo" readonly="true" path="moreInfo"/>
	<jstl:if test="${command != 'create'}">
	<acme:form-checkbox code="employer.job.form.label.status" readonly="true" path="status"/>
	</jstl:if>
	<acme:form-textbox code="employer.job.form.label.employer" readonly="true" path="employer.userAccount.username"/>

	<acme:form-submit test="${command != 'create' && status==true && command != 'update' || descriptor != null}" code="employer.job.form.button.descriptor" method="get" action="/employer/descriptor/show?jobid=${id}"/>
	<acme:form-submit test="${command != 'create' && status==true && command != 'update'}" code="employer.job.form.button.auditorRecord" method="get" action="/authenticated/auditor-record/list?id=${id}"/>
	<acme:form-submit test="${command != 'create' && status==true && command != 'update'}" code="employer.job.form.button.application" method="get" action="/employer/application/list?id=${id}"/>
	
	<acme:form-submit test="${command == 'show'}" code="employer.job.form.button.delete" action="/employer/job/delete"/>
	<acme:form-submit test="${command == 'create'}" code="employer.job.form.button.create" action="/employer/job/create"/>
	<acme:form-submit test="${command == 'update'}" code="employer.job.form.button.update" action="/employer/job/update"/>
	<acme:form-submit test="${command == 'delete'}" code="employer.job.form.button.delete" action="/employer/job/delete"/>
	<acme:form-return code="employer.job.form.button.return"/>
</acme:form>
</jstl:if>
<jstl:if test="${command == 'show' && status==false || command == 'create'||  command == 'delete'  && status==false || command == 'update'}">
<acme:form>
	<acme:form-hidden path="descriptorBoolean"/>
	<acme:form-textbox code="employer.job.form.label.title" path="title"/>
	<acme:form-moment code="employer.job.form.label.deadline" path="deadline"/>
	<acme:form-money code="employer.job.form.label.salary" path="salary"/>
	<acme:form-textbox code="employer.job.form.label.reference" path="reference"/>
	<acme:form-textbox code="employer.job.form.label.moreInfo" path="moreInfo"/>
	<jstl:if test="${command != 'create'}">
	<acme:form-checkbox code="employer.job.form.label.status" path="status"/>
	</jstl:if>
	<acme:form-textbox code="employer.job.form.label.employer" readonly="true" path="employer.userAccount.username"/>

	<acme:form-submit test="${command != 'create' && command != 'delete' && descriptor == null && descriptorBoolean==false}" code="employer.job.form.button.descriptor.create" method="get" action="/employer/descriptor/create?jobid=${id}"/>
	<acme:form-submit test="${command != 'create' && status==true && command != 'update' || descriptor != null  || descriptorBoolean==true}" code="employer.job.form.button.descriptor" method="get" action="/employer/descriptor/show?jobid=${id}"/>
	<acme:form-submit test="${command != 'create' && status==true && command != 'update'}" code="employer.job.form.button.auditorRecord" method="get" action="/authenticated/auditor-record/list?id=${id}"/>
	<acme:form-submit test="${command != 'create' && status==true && command != 'update'}" code="employer.job.form.button.application" method="get" action="/employer/application/list?id=${id}"/>
	
	<acme:form-submit test="${command == 'show' && status==false}" code="employer.job.form.button.update" action="/employer/job/update"/>
	<acme:form-submit test="${command == 'show'}" code="employer.job.form.button.delete" action="/employer/job/delete"/>
	<acme:form-submit test="${command == 'create'}" code="employer.job.form.button.create" action="/employer/job/create"/>
	<acme:form-submit test="${command == 'update'}" code="employer.job.form.button.update" action="/employer/job/update"/>
	<acme:form-submit test="${command == 'delete'}" code="employer.job.form.button.delete" action="/employer/job/delete"/>
	<acme:form-return code="employer.job.form.button.return"/>
</acme:form>
</jstl:if>