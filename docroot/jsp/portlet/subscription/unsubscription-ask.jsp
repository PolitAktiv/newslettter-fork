<%@ include file="/jsp/portlet/init.jsp" %>


<%
	String uuid = (String)request.getAttribute("uuid");
%>


<liferay-ui:message key="zn.subscription.unsubscription.message.ask" />


<portlet:actionURL var="confirmUnsubscriptionURL" name="confirmUnsubscription">
	<portlet:param name="uuid" value="<%= uuid %>" />
</portlet:actionURL>

<aui:button-row>
	<aui:button type="submit" value="ok" onClick="<%= confirmUnsubscriptionURL.toString() %>" />
</aui:button-row>