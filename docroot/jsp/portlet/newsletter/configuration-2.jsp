<%@ include file="/jsp/portlet/init.jsp" %>

<%@ include file="/jsp/portlet/newsletter/main-tabs.jsp" %>


<%
	PortletPreferences preferences = (PortletPreferences)request.getAttribute("preferences");

	String emailFromName = preferences.getValue("emailFromName", StringPool.BLANK);
	String emailFromAddress = preferences.getValue("emailFromAddress", StringPool.BLANK);
%>

<liferay-ui:header title="configuration" />

<liferay-ui:message key="zylk.newsletter.configuration.info" />


<portlet:actionURL name="editConfiguration" var="editConfigurationURL">
</portlet:actionURL>

<aui:form action="<%= editConfigurationURL.toString() %>" method="post" >

	<aui:fieldset>
		<aui:input name="emailFromName" type="text" label="zn.general.email.from.name" size="50" value="<%= emailFromName %>" />
		<aui:input name="emailFromAddress" type="text" label="zn.general.email.from.address" size="50" value="<%= emailFromAddress %>" />
	</aui:fieldset>
	
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>
