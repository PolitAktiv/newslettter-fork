<%@page import="net.zylk.liferay.portal.model.Subscriptor"%>
<%@page import="java.util.List"%>

<%@ include file="/jsp/portlet/init.jsp" %>

<%@ include file="/jsp/portlet/newsletter/main-tabs.jsp" %>


<%
	List<Subscriptor> subscriptors = (List<Subscriptor>)request.getAttribute("subscriptors");
	int count = ParamUtil.getInteger(request, "count");
%>
<jsp:useBean id="keywords" type="java.lang.String" scope="request" />


<liferay-ui:header title="zylk.newsletter.subscriptor.list.header" />


<portlet:renderURL var="viewListURL">
	<portlet:param name="view" value="subscriptorList" />
</portlet:renderURL>

<aui:form action="<%= viewListURL %>" method="post">
	<aui:input name="keywords" id="keywords" size="50" type="text" value="<%= keywords %>" />
	<aui:button-row>
		<aui:button type="submit" value="search" />
	</aui:button-row>	
</aui:form>

<div class="separator"/></div>


<portlet:renderURL var="addSubscriptorURL" >
	<portlet:param name="view" value="addSubscriptor" />
</portlet:renderURL>

<portlet:renderURL var="importSubscriptorURL" >
	<portlet:param name="view" value="importSubscriptor" />
</portlet:renderURL>

<aui:button-row>
	<aui:button name="" type="submit" value="zylk.newsletter.subscriptor.list.button.add" onClick="<%= addSubscriptorURL.toString() %>" />
	<aui:button name="" type="submit" value="zylk.newsletter.subscriptor.list.button.import" onClick="<%= importSubscriptorURL.toString() %>" />
</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="zn.general.list.empty">
	
	<liferay-ui:search-container-results results="<%= subscriptors %>" total="<%= count %>" />
	
	<liferay-ui:search-container-row
		className="net.zylk.liferay.portal.model.Subscriptor" keyProperty="subscriptorId"
		modelVar="subscriptor">
		
		<liferay-ui:search-container-column-text name="" align="left" cssClass="zn-col-icon">
			<%
			String imageTitle = LanguageUtil.get(pageContext, "zylk.newsletter.subscriptor.field.self_subscribe.false.info");
			String image = request.getContextPath() + "/images/edit-user.png";
			if (subscriptor.getSelfSubscribe()) {
				imageTitle = LanguageUtil.get(pageContext, "zylk.newsletter.subscriptor.field.self_subscribe.true.info");
				image = request.getContextPath() + "/images/request.png";
			}
			%>
			<img alt="<%= imageTitle %>" title="<%= imageTitle %>" src="<%= image %>" height="16" width="16"/>	
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="name" value="<%= HtmlUtil.escape(subscriptor.getName()) %>" align="left" />
		<liferay-ui:search-container-column-text name="zn.general.surname" value="<%= HtmlUtil.escape(subscriptor.getSurname()) %>" align="left" />
		<liferay-ui:search-container-column-text name="email" value="<%= HtmlUtil.escape(subscriptor.getEmail()) %>" align="left" />
		
		<liferay-ui:search-container-column-jsp name="" path="/jsp/portlet/newsletter/subscriptor-actions.jsp" align="right"/>
		
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator paginate="false"/>
	
</liferay-ui:search-container>



