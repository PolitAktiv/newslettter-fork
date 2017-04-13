<%@page import="net.zylk.liferay.portal.InvalidEmailException"%>
<%@page import="net.zylk.liferay.portal.EmptyCategoryListException"%>
<%@page import="net.zylk.liferay.portal.model.Category"%>

<%@ include file="/jsp/portlet/init.jsp" %>


<%
	List<Category> categories = (List<Category>)request.getAttribute("categories");
%>

<liferay-ui:error exception="<%= InvalidEmailException.class %>" message="zylk.newsletter.subscriptor.error.email.invalid" />
<liferay-ui:error exception="<%= EmptyCategoryListException.class %>" message="zylk.newsletter.subscriptor.error.categories.empty" />

<portlet:actionURL var="requestSubscriptionURL" name="requestSubscription">
	<portlet:param name="backURL" value="<%= currentURL.toString() %>" />
</portlet:actionURL>


<aui:form action="<%= requestSubscriptionURL.toString() %>" method="post" >

	<aui:fieldset>
		<aui:input name="name" type="text" size="75" >
			<aui:validator name="maxLength">75</aui:validator>
		</aui:input>
		<aui:input name="surname" label="zn.general.surname" type="text" size="75" >
			<aui:validator name="maxLength">75</aui:validator>
		</aui:input>
		<aui:input name="email" type="text" size="75" >
			<aui:validator name="required" />
			<aui:validator name="maxLength">75</aui:validator>
		</aui:input>
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
		<aui:button type="submit" value="ok" />
	</aui:button-row>
</aui:form>