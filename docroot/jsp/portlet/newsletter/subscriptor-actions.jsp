<%@page import="net.zylk.liferay.portal.model.Subscriptor"%>

<%@ include file="/jsp/portlet/init.jsp" %>

<%
	ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Subscriptor subscriptor = (Subscriptor)row.getObject();
%>

<liferay-ui:icon-menu>
		<portlet:renderURL var="editSubscriptorURL">
			<portlet:param name="view" value="editSubscriptor" />
			<portlet:param name="subscriptorId" value="<%= String.valueOf(subscriptor.getSubscriptorId()) %>"/>
			<portlet:param name="backURL" value="<%= currentURL %>" />
		</portlet:renderURL>
	
		<liferay-ui:icon image="edit" label="edit" url="<%= editSubscriptorURL.toString() %>" />

	
		<portlet:actionURL name="removeSubscriptor" var="deleteSubscriptorURL">
			<portlet:param name="subscriptorId" value="<%= String.valueOf(subscriptor.getSubscriptorId()) %>"/>
		</portlet:actionURL>
		<liferay-ui:icon-delete url="<%= deleteSubscriptorURL.toString() %>" />
		
</liferay-ui:icon-menu>
