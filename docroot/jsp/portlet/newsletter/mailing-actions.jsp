<%@page import="net.zylk.liferay.portal.model.Mailing"%>

<%@ include file="/jsp/portlet/init.jsp" %>

<%
	ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Mailing mailing = (Mailing)row.getObject();
%>

<liferay-ui:icon-menu>
		<portlet:renderURL var="viewMailingURL">
			<portlet:param name="view" value="viewMailing" />
			<portlet:param name="mailingId" value="<%= String.valueOf(mailing.getMailingId()) %>"/>
			<portlet:param name="backURL" value="<%= currentURL %>" />
		</portlet:renderURL>
	
		<liferay-ui:icon image="view" label="view" url="<%= viewMailingURL.toString() %>" />
	
</liferay-ui:icon-menu>
