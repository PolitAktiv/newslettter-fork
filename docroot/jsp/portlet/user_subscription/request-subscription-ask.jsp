<%@ include file="/jsp/portlet/init.jsp" %>

<%
	String name = (String)request.getAttribute("name");
	String surname = (String)request.getAttribute("surname");
	String email = (String)request.getAttribute("email");
	String languageId = (String)request.getAttribute("languageId");
	String categoryIdsString = (String)request.getAttribute("categoryIdsString");
%>


<liferay-ui:message key="zn.user_subscription.message.update_ask"/>


<portlet:actionURL var="requestSubscriptionConfirmURL" name="requestSubscriptionConfirm">
	<portlet:param name="name" value="<%= name %>" />
	<portlet:param name="surname" value="<%= surname %>" />
	<portlet:param name="email" value="<%= email %>" />
	<portlet:param name="languageId" value="<%= languageId %>" />
	<portlet:param name="categoryIdsString" value="<%= categoryIdsString %>" />
</portlet:actionURL>

<aui:button-row>
	<aui:button type="submit" value="ok" onClick="<%= requestSubscriptionConfirmURL.toString() %>" />
</aui:button-row>