<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%
	String mainTab = (String)request.getAttribute("mainTab");
%>

<portlet:renderURL var="categoryListURL">
	<portlet:param name="view" value="categoryList" />
</portlet:renderURL>

<portlet:renderURL var="subscriptorListURL">
	<portlet:param name="view" value="subscriptorList" />
</portlet:renderURL>

<portlet:renderURL var="newsletterListURL">
	<portlet:param name="view" value="newsletterList" />
</portlet:renderURL>

<portlet:renderURL var="mailingListURL">
	<portlet:param name="view" value="mailingList" />
</portlet:renderURL>

<portlet:renderURL var="configurationURL">
	<portlet:param name="view" value="configuration" />
</portlet:renderURL>

<liferay-ui:tabs value="<%= mainTab %>" param="tabs1" tabsValues="categoryList,subscriptorList,newsletterList,mailingList"
	names="zylk.newsletter.main.tab.categories,zylk.newsletter.main.tab.subscritors,zylk.newsletter.main.tab.newsletters,zylk.newsletter.main.tab.mailing"
	url0="<%= categoryListURL %>"
	url1="<%= subscriptorListURL %>"
	url2="<%= newsletterListURL %>"
	url3="<%= mailingListURL %>"
/>
