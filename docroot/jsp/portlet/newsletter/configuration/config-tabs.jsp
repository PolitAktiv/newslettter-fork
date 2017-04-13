<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%
	String configTab = (String)request.getAttribute("configTab");
%>

<liferay-portlet:renderURL var="generalConfigURL" portletConfiguration="true">
	<portlet:param name="view" value="generalConfig" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="emailTemplateConfigURL" portletConfiguration="true">
	<portlet:param name="view" value="emailTemplateConfig" />
</liferay-portlet:renderURL>

<liferay-ui:tabs value="<%= configTab %>" param="tabs1" tabsValues="generalConfig,emailTemplateConfig"
	names="zylk.newsletter.configuration.tabs.general,zylk.newsletter.configuration.tabs.subscription_email"
	url0="<%= generalConfigURL %>"
	url1="<%= emailTemplateConfigURL %>"
/>
