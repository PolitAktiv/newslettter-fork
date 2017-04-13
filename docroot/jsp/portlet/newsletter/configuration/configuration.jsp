<%@page import="net.zylk.liferay.portal.model.CoreConstants"%>
<%@page import="net.zylk.liferay.portal.util.ConfigUtil"%>
<%@page import="net.zylk.liferay.portal.InvalidEmailException"%>

<%@ include file="/jsp/portlet/init.jsp" %>

<%
	renderRequest.setAttribute("configTab", "generalConfig");
%>

<%@ include file="/jsp/portlet/newsletter/configuration/config-tabs.jsp" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>


<%
	// Como parece que en la 6.2 no funcionan bien las preferencias por site (owned-by-group) las cargamos de forma explicita. 
	//String portletResource = ParamUtil.getString(renderRequest, "portletResource");
	//PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);
	
	long companyId = themeDisplay.getCompanyId();
	long ownerId = themeDisplay.getScopeGroupId();
	int ownerType = PortletKeys.PREFS_OWNER_TYPE_GROUP;
	long plidBlank = 0;
	String portletId = CoreConstants.PORTLET_ID_ADMIN;
	PortletPreferences preferences = PortletPreferencesLocalServiceUtil.getPreferences(companyId, ownerId, ownerType, plidBlank,
			portletId);

	String portalBaseUrl = preferences.getValue(ConfigUtil.KEY_PORTAL_BASE_URL, StringPool.BLANK);
	String emailFromName = preferences.getValue(ConfigUtil.KEY_EMAIL_FROM_NAME, StringPool.BLANK);
	String emailFromAddress = preferences.getValue(ConfigUtil.KEY_EMAIL_FROM_ADDRESS, StringPool.BLANK);
%>

<liferay-ui:error exception="<%= InvalidEmailException.class %>" message="zylk.newsletter.subscriptor.error.email.invalid" />


<liferay-ui:message key="zylk.newsletter.configuration.info" />


<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL.toString() %>" method="post" >

	<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<input name="<portlet:namespace />actionType" type="hidden" value="saveGeneralConfig" />
	
	<aui:fieldset>
		<aui:input name="portalBaseUrl" type="text" label="zn.general.portal.base_url" 
			helpMessage="zylk.newsletter.configuration.general.default.tooltip" size="75" value="<%= portalBaseUrl %>" />
		<aui:input name="emailFromName" type="text" label="zn.general.email.from.name" 
			helpMessage="zylk.newsletter.configuration.general.default.tooltip" size="75" value="<%= emailFromName %>" />
		<aui:input name="emailFromAddress" type="text" label="zn.general.email.from.address" 
			helpMessage="zylk.newsletter.configuration.general.default.tooltip" size="75" value="<%= emailFromAddress %>" />
	</aui:fieldset> 
	
	<br/>
	
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>
