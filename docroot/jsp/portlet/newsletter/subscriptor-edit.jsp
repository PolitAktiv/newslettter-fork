<%@page import="net.zylk.liferay.portal.InvalidEmailException"%>
<%@page import="net.zylk.liferay.portal.DuplicateSubscriptorException"%>
<%@page import="net.zylk.liferay.portal.model.Category"%>
<%@page import="net.zylk.liferay.portal.model.Subscriptor"%>

<%@ include file="/jsp/portlet/init.jsp" %>


<%@ include file="/jsp/portlet/newsletter/main-tabs.jsp" %>

<%
	List<Category> categories = (List<Category>)request.getAttribute("categories");
	List<Long> categoryIds = (List<Long>)request.getAttribute("categoryIds");	
%>

<jsp:useBean id="subscriptor" type="net.zylk.liferay.portal.model.Subscriptor" scope="request" />
<jsp:useBean id="backURL" type="java.lang.String" scope="request" />


<liferay-ui:header title="zylk.newsletter.subscriptor.edit.header" backURL="<%= backURL %>"/>

<liferay-ui:error exception="<%= DuplicateSubscriptorException.class %>" message="zylk.newsletter.subscriptor.error.email.duplicate" />
<liferay-ui:error exception="<%= InvalidEmailException.class %>" message="zylk.newsletter.subscriptor.error.email.invalid" />

<portlet:actionURL name="editSubscriptor" var="editSubscriptor">
	<portlet:param name="subscriptorId" value="<%= String.valueOf(subscriptor.getSubscriptorId()) %>" />
	<portlet:param name="backURL" value="<%= currentURL.toString() %>" />
</portlet:actionURL>

<aui:form action="<%= editSubscriptor.toString() %>" method="post" >

	<aui:fieldset>		
		<aui:input name="name" type="text" size="75" value="<%= HtmlUtil.escape(subscriptor.getName()) %>" >
			<aui:validator name="maxLength">75</aui:validator>
		</aui:input>
		<aui:input name="surname" label="zn.general.surname" type="text" size="75" value="<%= HtmlUtil.escape(subscriptor.getSurname()) %>" >
			<aui:validator name="maxLength">75</aui:validator>
		</aui:input>
		<aui:input name="email" type="text" size="75" value="<%= HtmlUtil.escape(subscriptor.getEmail()) %>">
			<aui:validator name="required" />
			<aui:validator name="maxLength">75</aui:validator>
		</aui:input>
		
		
		<aui:select label="language" name="languageId">
			<%
			String languageId = subscriptor.getLanguageId();
			Locale selLocale = LocaleUtil.fromLanguageId(languageId);
	
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
				boolean selected = false;
				if (categoryIds.contains(category.getCategoryId())) {
					selected = true;
				}
		%>
				<aui:input id="<%= String.valueOf(category.getCategoryId()) %>" name="categoryIds" type="checkbox" 
					label="<%= category.getName(locale) %>" value="<%= category.getCategoryId() %>" checked="<%= selected %>">
				</aui:input>
		<%
			}
		%>
	</aui:fieldset>	
	
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>