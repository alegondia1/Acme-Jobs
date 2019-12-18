<%--
- menu.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java" import="acme.framework.helpers.PrincipalHelper,acme.entities.roles.Provider,acme.entities.roles.Consumer"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>
		<%-- COLOCAR EN ESTE MENU TODO LO QUE PUEDA VER UN USUARIO ANONIMO --%>
		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.anonymous.favourite-link" action="http://www.google.com/"/>
			<acme:menu-suboption code="master.menu.anonymous.announcement" action="/anonymous/announcement/list"/>    
			<acme:menu-suboption code="master.menu.anonymous.records" action="/anonymous/records/list"/>
			<acme:menu-suboption code="master.menu.anonymous.starsCR" action="/anonymous/starsCR/list"/>
			<acme:menu-suboption code="master.menu.anonymous.investorRecord" action="/anonymous/investor-record/list"/>
			<acme:menu-suboption code="master.menu.anonymous.investorRecordStars" action="/anonymous/investor-recordStars/list"/>
		</acme:menu-option>

		<%-- COLOCAR EN ESTE MENU TODO LO QUE PUEDA VER UN ADMINISTRADOR --%>
		<acme:menu-option code="master.menu.administrator" access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.administrator.user-accounts" action="/administrator/user-account/list"/>
			<acme:menu-suboption code="master.menu.administrator.announcement.create" action="/administrator/announcement/create"/>
			<acme:menu-suboption code="master.menu.administrator.announcement" action="/administrator/announcement/list"/>
			<acme:menu-suboption code="master.menu.administrator.challenge.create" action="/administrator/challenge/create"/>
			<acme:menu-suboption code="master.menu.administrator.challenge" action="/administrator/challenge/list"/>
			<acme:menu-suboption code="master.menu.administrator.records.create" action="/administrator/records/create"/>
			<acme:menu-suboption code="master.menu.administrator.records" action="/administrator/records/list"/>
	<%-- 	<acme:menu-suboption code="master.menu.administrator.commercialBanner.create" action="/administrator/commercial-banner/create"/>
			<acme:menu-suboption code="master.menu.administrator.commercialBanner" action="/administrator/commercial-banner/list"/>
			<acme:menu-suboption code="master.menu.administrator.nonCommercialBanner.create" action="/administrator/non-commercial-banner/create"/>
			<acme:menu-suboption code="master.menu.administrator.nonCommercialBanner" action="/administrator/non-commercial-banner/list"/>--%>
			<acme:menu-suboption code="master.menu.administrator.customizationParameters.create" action="/administrator/customization-parameters/create"/>
			<acme:menu-suboption code="master.menu.administrator.customizationParameters" action="/administrator/customization-parameters/show"/>
			<acme:menu-suboption code="master.menu.administrator.investorRecord.create" action="/administrator/investor-record/create"/>
			<acme:menu-suboption code="master.menu.administrator.investorRecord" action="/administrator/investor-record/list"/>
			<acme:menu-suboption code="master.menu.administrator.requestAuditor" action="/administrator/request-auditor/list"/>
			<acme:menu-suboption code="master.menu.administrator.dashboard" action="/administrator/dashboard/show-data"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.shutdown" action="/master/shutdown"/>
		</acme:menu-option>
		<%-- COLOCAR EN ESTE MENU TODO LO QUE PUEDA VER UN PROVIDER --%>
		<acme:menu-option code="master.menu.provider" access="hasRole('Provider')">
			<acme:menu-suboption code="master.menu.provider.favourite-link" action="http://www.example.com/"/>
			<acme:menu-suboption code="master.menu.provider.request.create" action="/provider/request/create"/>
		</acme:menu-option>
		<%-- COLOCAR EN ESTE MENU TODO LO QUE PUEDA VER UN CONSUMER --%>
		<acme:menu-option code="master.menu.consumer" access="hasRole('Consumer')">
			<acme:menu-suboption code="master.menu.consumer.favourite-link" action="http://www.example.com/"/>
			<acme:menu-suboption code="master.menu.consumer.offer.create" action="/consumer/offer/create"/>
		</acme:menu-option>
		<%-- COLOCAR EN ESTE MENU TODO LO QUE PUEDA VER UN EMPLOYER --%>
		<acme:menu-option code="master.menu.employer" access="hasRole('Employer')">
			<acme:menu-suboption code="master.menu.employer.job.listmine" action="/employer/job/list-mine"/>
			<acme:menu-suboption code="master.menu.employer.job.create" action="/employer/job/create"/>
			<acme:menu-suboption code="master.menu.employer.application.listmine" action="/employer/application/list-mine"/>
		</acme:menu-option>
		
		<%-- COLOCAR EN ESTE MENU TODO LO QUE PUEDA VER UN SPONSOR --%>
		<acme:menu-option code="master.menu.sponsor" access="hasRole('Sponsor')">
			
			<acme:menu-suboption code="master.menu.sponsor.commercialBanner.create" action="/sponsor/commercial-banner/create"/>
			<acme:menu-suboption code="master.menu.sponsor.commercialBanner" action="/sponsor/commercial-banner/list-mine"/>
			<acme:menu-suboption code="master.menu.sponsor.nonCommercialBanner.create" action="/sponsor/non-commercial-banner/create"/>
			<acme:menu-suboption code="master.menu.sponsor.nonCommercialBanner" action="/sponsor/non-commercial-banner/list-mine"/>
		</acme:menu-option>

		<%-- COLOCAR EN ESTE MENU TODO LO QUE PUEDA VER UN WORKER --%>
		<acme:menu-option code="master.menu.worker" access="hasRole('Worker')">
			<acme:menu-suboption code="master.menu.worker.aplication.listmine" action="/worker/application/list-mine"/>
			<acme:menu-suboption code="master.menu.worker.job.list" action="/worker/job/list"/>
		</acme:menu-option>
		<%-- COLOCAR EN ESTE MENU TODO LO QUE PUEDA VER UN AUDITOR --%>
		<acme:menu-option code="master.menu.auditor" access="hasRole('Auditor')">
			<acme:menu-suboption code="master.menu.auditor.auditorRecord.list" action="/auditor/auditor-record/list-mine"/>
			<acme:menu-suboption code="master.menu.auditor.job.listmine" action="/auditor/job/list?mode=mine"/>
			<acme:menu-suboption code="master.menu.auditor.job.listother" action="/auditor/job/list?mode=other"/>
		</acme:menu-option>

		<%-- COLOCAR EN ESTE MENU TODO LO QUE PUEDA VER UN USUARIO AUTENTIFICADO --%>
		<acme:menu-option code="master.menu.isAutentificated" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.announcement" action="/authenticated/announcement/list"/>
			<acme:menu-suboption code="master.menu.user-account.offer" action="/authenticated/offer/list"/>
      <acme:menu-suboption code="master.menu.authenticated.challenges" action="/authenticated/challenge/list"/>
			<acme:menu-suboption code="master.menu.user-account.records" action="/authenticated/records/list"/>
			<acme:menu-suboption code="master.menu.user-account.investorRecord" action="/authenticated/investor-record/list"/>
			<acme:menu-suboption code="master.menu.user-account.request" action="/authenticated/request/list"/>
			<acme:menu-suboption code="master.menu.user-account.job.list" action="/authenticated/job/list"/>
			<acme:menu-suboption code="master.menu.user-account.messageThreads" action="/authenticated/message-thread/list"/>
			<acme:menu-suboption code="master.menu.user-account.messageThreads.create" action="/authenticated/message-thread/create"/>
		</acme:menu-option>
	</acme:menu-left>

	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()"/>
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()"/>

		<acme:menu-option code="master.menu.user-account" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.general-data" action="/authenticated/user-account/update"/>
			<acme:menu-suboption code="master.menu.user-account.become-provider" action="/authenticated/provider/create" access="!hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.user-account.provider" action="/authenticated/provider/update" access="hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.user-account.become-consumer" action="/authenticated/consumer/create" access="!hasRole('Consumer')"/>
			<acme:menu-suboption code="master.menu.user-account.consumer" action="/authenticated/consumer/update" access="hasRole('Consumer')"/>
			<acme:menu-suboption code="master.menu.user-account.become-employer" action="/authenticated/employer/create" access="!hasRole('Employer')"/>
			<acme:menu-suboption code="master.menu.user-account.employer" action="/authenticated/employer/update" access="hasRole('Employer')"/>
			<acme:menu-suboption code="master.menu.user-account.become-worker" action="/authenticated/worker/create" access="!hasRole('Worker')"/>
			<acme:menu-suboption code="master.menu.user-account.worker" action="/authenticated/worker/update" access="hasRole('Worker')"/>
			<acme:menu-suboption code="master.menu.user-account.become-auditor" action="/authenticated/request-auditor/create" access="!hasRole('Auditor')"/>		
			<acme:menu-suboption code="master.menu.user-account.auditor" action="/authenticated/auditor/update" access="hasRole('Auditor')"/>	
			<acme:menu-suboption code="master.menu.user-account.become-sponsor" action="/authenticated/sponsor/create" access="!hasRole('Sponsor')"/>		
			<acme:menu-suboption code="master.menu.user-account.sponsor" action="/authenticated/sponsor/update" access="hasRole('Sponsor')"/>	
		</acme:menu-option>

		<acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated()"/>
	</acme:menu-right>
</acme:menu-bar>
