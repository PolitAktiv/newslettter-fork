<%@page import="net.zylk.liferay.portal.model.Category"%>

<%@ include file="/jsp/portlet/init.jsp" %>


<%@ include file="/jsp/portlet/newsletter/main-tabs.jsp" %>


<portlet:renderURL var="backURL" >
	<portlet:param name="view" value="categoryList" />
</portlet:renderURL>

<liferay-ui:header title="zylk.newsletter.category.add.header" backURL="<%= backURL %>"/>

<portlet:actionURL name="addCategory" var="addCategory">
	<portlet:param name="backURL" value="<%= currentURL.toString() %>" />
</portlet:actionURL>

<aui:form action="<%= addCategory.toString() %>" method="post" >

	<aui:fieldset>
		<aui:model-context model="<%= Category.class %>" />
		<aui:input label="name" name="name" size="100">
			<aui:validator name="required" />
		</aui:input>
		<aui:input name="description" type="textarea" cols="80" rows="6" />
	</aui:fieldset>
	
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>