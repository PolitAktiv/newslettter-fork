<%@page import="net.zylk.liferay.portal.model.CoreConstants"%>
<%@page import="net.zylk.liferay.portal.util.ConfigUtil"%>
<%@page import="net.zylk.liferay.portal.InvalidEmailException"%>

<%@ include file="/jsp/portlet/init.jsp" %>

<%
	renderRequest.setAttribute("configTab", "emailTemplateConfig");
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
	
	String templateSubscriptionSubject = preferences.getValue(ConfigUtil.KEY_TEMPLATE_SUBSCRIPTION_SUBJECT, "");
	if (templateSubscriptionSubject == null || templateSubscriptionSubject.equals("")) {
		templateSubscriptionSubject = ConfigUtil.getDefaultValue(ConfigUtil.KEY_TEMPLATE_SUBSCRIPTION_SUBJECT,
				themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId());
	}
	
	String templateSubscriptionBody = preferences.getValue(ConfigUtil.KEY_TEMPLATE_SUBSCRIPTION_BODY, "");
	if (templateSubscriptionBody == null || templateSubscriptionBody.equals("")) {
		templateSubscriptionBody = ConfigUtil.getDefaultValue(ConfigUtil.KEY_TEMPLATE_SUBSCRIPTION_BODY,
				themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId());
	}
%>

<liferay-ui:message key="zylk.newsletter.configuration.info" />


<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL.toString() %>" method="post" >

	<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<input name="<portlet:namespace />actionType" type="hidden" value="saveEmailTemplateConfig" /> 
	
	<aui:fieldset>
		<aui:input name="templateSubscriptionSubject" type="text" label="subject" size="100" value="<%= templateSubscriptionSubject %>" />
		<aui:input name="templateSubscriptionBody" type="textarea" cols="115" rows="12" label="body" value="<%= templateSubscriptionBody %>" />
	</aui:fieldset> 
	
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>

<br/>

<div class="definition-of-terms">
	<h4><liferay-ui:message key="definition-of-terms" /></h4>
	<dl>
		<dt>
			[$SUBSCRIPTOR_NAME$]
		</dt>
		<dd>
			<liferay-ui:message key="zylk.newsletter.configuration.template.token.name.description" />
		</dd>
		<dt>
			[$SUBSCRIPTOR_SURNAME$]
		</dt>
		<dd>
			<liferay-ui:message key="zylk.newsletter.configuration.template.token.surname.description" />
		</dd>
		<dt>
			[$SUBSCRIPTOR_FULLNAME$]
		</dt>
		<dd>
			<liferay-ui:message key="zylk.newsletter.configuration.template.token.fullname.description" />
		</dd>
		<dt>
			[$SUBSCRIPTOR_EMAIL$]
		</dt>
		<dd>
			<liferay-ui:message key="zylk.newsletter.configuration.template.token.email.description" />
		</dd>
		<dt>
			[$SUBSCRIPTION_URL$]
		</dt>
		<dd>
			<liferay-ui:message key="zylk.newsletter.configuration.template.token.url.description" />
		</dd>
	</dl>
</div>
