<%@page import="net.zylk.liferay.portal.model.MailingSubscriptor"%>

<%@ include file="/jsp/portlet/init.jsp" %>

<%
	ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	MailingSubscriptor mailingSubscriptor = (MailingSubscriptor)row.getObject();
%>

<liferay-ui:icon-menu>
		<portlet:resourceURL var="viewMailingSubscriptorURL">
			<portlet:param name="resourceType" value="newsletterArchive" />
			<portlet:param name="mailingSubscriptorId" value="<%= String.valueOf(mailingSubscriptor.getMailingSubscriptorId()) %>"/>	
		</portlet:resourceURL>
	
		<liferay-ui:icon image="view" label="view" url="<%= viewMailingSubscriptorURL.toString() %>" target="_blank" />
	
</liferay-ui:icon-menu>
