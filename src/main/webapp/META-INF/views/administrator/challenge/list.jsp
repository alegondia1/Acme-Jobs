<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list readonly = "false">
	<acme:list-column code="administrator.challenge.list.label.title" path="title" width="15%"/>
	<acme:list-column code="administrator.challenge.list.label.deadline" path="deadline" width="15%"/>
	<acme:list-column code="administrator.challenge.list.label.description" path="description" width="10%"/>
	<acme:list-column code="administrator.challenge.list.label.goalBronze" path="goalBronze" width="10%"/>
	<acme:list-column code="administrator.challenge.list.label.rewardBronze" path="rewardBronze" width="10%"/>
	<acme:list-column code="administrator.challenge.list.label.goalSilver" path="goalSilver" width="10%"/>
	<acme:list-column code="administrator.challenge.list.label.rewardSilver" path="rewardSilver" width="10%"/>
	<acme:list-column code="administrator.challenge.list.label.goalGold" path="goalGold" width="10%"/>
	<acme:list-column code="administrator.challenge.list.label.rewardGold" path="rewardGold" width="10%"/>
</acme:list>