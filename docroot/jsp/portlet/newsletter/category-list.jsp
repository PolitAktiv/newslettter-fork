<%@page import="java.util.List"%>
<%@page import="net.zylk.liferay.portal.model.Category"%>

<%@ include file="/jsp/portlet/init.jsp" %>

<%
	List<Category> categories = (List<Category>)request.getAttribute("categories");
	int count = ParamUtil.getInteger(request, "count");
%>

<%@ include file="/jsp/portlet/newsletter/main-tabs.jsp" %>


<liferay-ui:header title="zylk.newsletter.category.list.header" />


<portlet:renderURL var="addCategoryURL" >
	<portlet:param name="view" value="addCategory" />
</portlet:renderURL>

<aui:button-row>
	<aui:button name="" type="submit" value="zylk.newsletter.category.list.button.add" onClick="<%= addCategoryURL.toString() %>" />
</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="zn.general.list.empty">
	
	<liferay-ui:search-container-results results="<%= categories %>" total="<%= count %>" />
	
	<liferay-ui:search-container-row
		className="net.zylk.liferay.portal.model.Category" keyProperty="categoryId"
		modelVar="category">
		
		<liferay-ui:search-container-column-text name="name" value="<%= category.getName(locale) %>" align="left" />
		
		<liferay-ui:search-container-column-jsp name="" path="/jsp/portlet/newsletter/category-actions.jsp" align="right"/>
		
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator paginate="false" />
	
</liferay-ui:search-container>






