<%@page import="net.zylk.liferay.portal.model.Category"%>

<%@ include file="/jsp/portlet/init.jsp" %>

<%
	ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Category category = (Category)row.getObject();
%>

<liferay-ui:icon-menu>
		<portlet:renderURL var="editCategoryURL">
			<portlet:param name="view" value="editCategory" />
			<portlet:param name="categoryId" value="<%= String.valueOf(category.getCategoryId()) %>"/>
			<portlet:param name="backURL" value="<%= currentURL %>" />
		</portlet:renderURL>
	
		<liferay-ui:icon image="edit" label="edit" url="<%= editCategoryURL.toString() %>" />

	
		<portlet:actionURL name="removeCategory" var="deleteCategoryURL">
			<portlet:param name="categoryId" value="<%= String.valueOf(category.getCategoryId()) %>"/>
		</portlet:actionURL>
		<liferay-ui:icon-delete url="<%= deleteCategoryURL.toString() %>" />
		
</liferay-ui:icon-menu>
