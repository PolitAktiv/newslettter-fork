<%@page import="net.zylk.liferay.portal.model.MailingSubscriptor"%>
<%@page import="net.zylk.liferay.portal.model.Mailing"%>

<%@ include file="/jsp/portlet/init.jsp" %>


<%@ include file="/jsp/portlet/newsletter/main-tabs.jsp" %>


<%
List<MailingSubscriptor> mailingSubscriptors = (List<MailingSubscriptor>)request.getAttribute("mailingSubscriptors");
int count = ParamUtil.getInteger(request, "count");

Format dateFormatDate = FastDateFormatFactoryUtil.getDate(locale, timeZone);
Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);
%>

<jsp:useBean id="mailing" type="net.zylk.liferay.portal.model.Mailing" scope="request" />
<jsp:useBean id="backURL" type="java.lang.String" scope="request" />
<jsp:useBean id="keywords" type="java.lang.String" scope="request" />


<liferay-ui:header title="zylk.newsletter.mailing.view.header" backURL="<%= backURL %>"/>


<b><liferay-ui:message key="name" /></b> <%= mailing.getNewsletterName() %><br/>
<b><liferay-ui:message key="date" /></b> <%= dateFormatDateTime.format(mailing.getStartDate()) %><br/>
<b><liferay-ui:message key="zylk.newsletter.mailing.view.field.date_from" /></b> <%= dateFormatDateTime.format(mailing.getFromDate()) %><br/>
<b><liferay-ui:message key="zn.general.email.from.name" /></b> <%= mailing.getEmailFromName() %><br/>
<b><liferay-ui:message key="zn.general.email.from.address" /></b> <%= mailing.getEmailFromAddress() %><br/>
<b><liferay-ui:message key="zylk.newsletter.mailing.view.field.email_count" /></b> <%= mailing.getEmailCount() %><br/>

<br/>
<div class="separator"/></div>

<portlet:renderURL var="viewListURL">
	<portlet:param name="view" value="viewMailing" />
	<portlet:param name="mailingId" value="<%= String.valueOf(mailing.getMailingId()) %>" />
</portlet:renderURL>

<aui:form action="<%= viewListURL %>" method="post">
	<aui:input name="keywords" id="keywords" size="50" type="text" value="<%= keywords %>" />
	<aui:button-row>
		<aui:button type="submit" value="search" />
	</aui:button-row>	
</aui:form>

<liferay-ui:search-container emptyResultsMessage="zn.general.list.empty">
	
	<liferay-ui:search-container-results results="<%= mailingSubscriptors %>" total="<%= count %>" />
	
	<liferay-ui:search-container-row
		className="net.zylk.liferay.portal.model.MailingSubscriptor" keyProperty="mailingSubscriptorId"
		modelVar="mailingSubscriptor">
		
		<liferay-ui:search-container-column-text name="email" value="<%= HtmlUtil.escape(mailingSubscriptor.getEmail()) %>" align="left" />
		
		<liferay-ui:search-container-column-text name="name" value="<%= HtmlUtil.escape(mailingSubscriptor.getName()) %>" align="left" />
		
		<liferay-ui:search-container-column-text name="zn.general.surname" value="<%= HtmlUtil.escape(mailingSubscriptor.getSurname()) %>" align="left" />
		
		<liferay-ui:search-container-column-jsp name="" path="/jsp/portlet/newsletter/mailing-subscriptor-actions.jsp" align="right"/>
		
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator paginate="false" />
	
</liferay-ui:search-container>
