<%@page import="net.zylk.liferay.portal.InvalidEmailException"%>
<%@page import="net.zylk.liferay.portal.DuplicateSubscriptorException"%>
<%@page import="net.zylk.liferay.portal.model.Category"%>

<%@ include file="/jsp/portlet/init.jsp" %>


<%@ include file="/jsp/portlet/newsletter/main-tabs.jsp" %>



<%
	List<Category> categories = (List<Category>)request.getAttribute("categories");
%>

<portlet:renderURL var="backURL" >
	<portlet:param name="view" value="subscriptorList" />
</portlet:renderURL>

<liferay-ui:header title="zylk.newsletter.subscriptor.add.header" backURL="<%= backURL %>"/>

<liferay-ui:error exception="<%= DuplicateSubscriptorException.class %>" message="zylk.newsletter.subscriptor.error.email.duplicate" />
<liferay-ui:error exception="<%= InvalidEmailException.class %>" message="zylk.newsletter.subscriptor.error.email.invalid" />

<portlet:actionURL name="addSubscriptor" var="addSubscriptor">
	<portlet:param name="backURL" value="<%= currentURL.toString() %>" />
</portlet:actionURL>

<aui:form action="<%= addSubscriptor.toString() %>" method="post" >

	<aui:fieldset>
		<aui:input name="name" type="text" size="75" >
			<aui:validator name="maxLength">75</aui:validator>
		</aui:input>
		<aui:input name="surname" label="zn.general.surname" type="text" size="75" >
			<aui:validator name="maxLength">75</aui:validator>
		</aui:input>
		<aui:input name="email" type="text" size="75">
			<aui:validator name="required" />
			<aui:validator name="maxLength">75</aui:validator>
		</aui:input>
		
		<aui:select label="language" name="languageId">
			<%	
			Locale selLocale = LocaleUtil.getDefault();
			Locale[] locales = LanguageUtil.getAvailableLocales();
			Locale languageLocale = locale;
	
			for (Locale curLocale : locales) {
				// esto para el portlet publico
				boolean i18nLanguageSensitive = false;
				if (i18nLanguageSensitive) {
					languageLocale = curLocale;
				}
			%>
				<aui:option label="<%= curLocale.getDisplayName(languageLocale) %>" lang="<%= LocaleUtil.toW3cLanguageId(languageLocale) %>" 
					selected="<%= (selLocale.getLanguage().equals(curLocale.getLanguage()) && selLocale.getCountry().equals(curLocale.getCountry())) %>" 
					value="<%= LocaleUtil.toLanguageId(curLocale) %>" />
			<%
			}
			%>
		</aui:select>
		
		<label class="aui-field-label"><liferay-ui:message key="zn.general.categories" /></label>
		<% 
			for (Category category : categories) {
		%>
				<aui:input id="<%= String.valueOf(category.getCategoryId()) %>" name="categoryIds" type="checkbox" 
					label="<%= category.getName(locale) %>" value="<%= category.getCategoryId() %>" checked="true" >
				</aui:input>
		<%
			}
		%>
	</aui:fieldset>	
	
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>