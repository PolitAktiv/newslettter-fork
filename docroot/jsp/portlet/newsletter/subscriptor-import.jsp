<%@page import="net.zylk.liferay.portal.ImportException"%>
<%@page import="net.zylk.liferay.portal.model.Category"%>
<%@page import="net.zylk.liferay.portal.model.Subscriptor"%>

<%@ include file="/jsp/portlet/init.jsp" %>


<%@ include file="/jsp/portlet/newsletter/main-tabs.jsp" %>

<%
	List<Category> categories = (List<Category>)request.getAttribute("categories");
%>


<portlet:renderURL var="backURL" >
	<portlet:param name="view" value="subscriptorList" />
</portlet:renderURL>

<liferay-ui:header title="zylk.newsletter.subscriptor.import.header" backURL="<%= backURL %>"/>

<%
	String errorDetails = LanguageUtil.format(pageContext, "zn.general.error.import", renderRequest.getAttribute("errorDetails")); 
%>
<liferay-ui:error key="error-import" message="<%= errorDetails %>" />


<portlet:actionURL name="importSubscriptor" var="importSubscriptor">
	<portlet:param name="backURL" value="<%= currentURL.toString() %>" />
</portlet:actionURL>


<liferay-ui:message key="zylk.newsletter.subscriptor.import.help" />

<br/><br/>
		
<b><liferay-ui:message key="zn.general.text.example" />:</b>
<div>
John,William,john@gmail.com,en_US,<br/>
Helen,Carter,helen@gmail.com,en_US,<br/>
Peter,Wilhelm,peter@gmail.com,es_ES,<br/>
</div>

<br/>

<aui:form action="<%= importSubscriptor.toString() %>" method="post" enctype="multipart/form-data" >

	<aui:fieldset>
		
		<aui:input label="file" name="csvFile" type="file" >
			<aui:validator name="required" />
		</aui:input>
		
		<label class="aui-field-label"><liferay-ui:message key="zn.general.categories" /></label>
		<% 
			for (Category category : categories) {
		%>
				<aui:input id="<%= String.valueOf(category.getCategoryId()) %>" name="categoryIds" type="checkbox"
					label="<%= category.getName(locale) %>" value="<%= category.getCategoryId() %>" checked="true">
				</aui:input>
		<%
			}
		%>
	</aui:fieldset>	
	
	<aui:button-row>
		<aui:button type="submit" value="zn.general.text.import" />
	</aui:button-row>
</aui:form>

