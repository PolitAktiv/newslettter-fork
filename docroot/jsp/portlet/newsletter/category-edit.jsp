<%@page import="net.zylk.liferay.portal.model.Category"%>

<%@ include file="/jsp/portlet/init.jsp" %>


<%@ include file="/jsp/portlet/newsletter/main-tabs.jsp" %>


<jsp:useBean id="category" type="net.zylk.liferay.portal.model.Category" scope="request" />
<jsp:useBean id="backURL" type="java.lang.String" scope="request" />


<liferay-ui:header title="zylk.newsletter.category.edit.header" backURL="<%= backURL %>"/>

<portlet:actionURL name="editCategory" var="editCategory">
	<portlet:param name="categoryId" value="<%= String.valueOf(category.getCategoryId()) %>" />
	<portlet:param name="backURL" value="<%= currentURL.toString() %>" />
</portlet:actionURL>

<aui:form action="<%= editCategory.toString() %>" method="post" >

	<aui:fieldset>		
		<aui:model-context bean="<%= category %>" model="<%= Category.class %>"/>
		<aui:input label="name" name="name" size="100">
			<aui:validator name="required" />
		</aui:input>
		
		<aui:input name="description" type="textarea" cols="80" rows="6" value="<%= category.getDescription() %>"/>
	</aui:fieldset>
	
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>