<%@page import="net.zylk.liferay.portal.model.Newsletter"%>

<%@ include file="/jsp/portlet/init.jsp" %>

<%
	ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Newsletter newsletter = (Newsletter)row.getObject();
	
	String confirmSendLabel = LanguageUtil.get(pageContext, "zylk.newsletter.newsletter.action.send.ask");
%>

<liferay-ui:icon-menu>
		<portlet:renderURL var="editNewsletterURL">
			<portlet:param name="view" value="editNewsletter" />
			<portlet:param name="newsletterId" value="<%= String.valueOf(newsletter.getNewsletterId()) %>"/>
			<portlet:param name="backURL" value="<%= currentURL %>" />
		</portlet:renderURL>
	
		<liferay-ui:icon image="edit" label="edit" url="<%= editNewsletterURL.toString() %>" />

		<portlet:resourceURL var="previewNewsletterURL">
			<portlet:param name="resourceType" value="newsletterPreview"/>
			<portlet:param name="newsletterId" value="<%= String.valueOf(newsletter.getNewsletterId()) %>"/>
		</portlet:resourceURL>
		<liferay-ui:icon image="preview" label="preview" url="<%= previewNewsletterURL.toString() %>" target="_blank"/>


		<portlet:actionURL name="sendNewsletter" var="sendNewsletterURL">
			<portlet:param name="newsletterId" value="<%= String.valueOf(newsletter.getNewsletterId()) %>"/>
		</portlet:actionURL>
		<%
	    	String confirmSend = "javascript: confirmar('" + confirmSendLabel + "', '" + sendNewsletterURL.toString() + "');";
	    	String imageSend = request.getContextPath() + "/images/newsletter-send.png";
		%>	
		<liferay-ui:icon src="<%= imageSend %>" message="zylk.newsletter.newsletter.action.send.button" url="<%= confirmSend %>" />

	
		<portlet:actionURL name="removeNewsletter" var="deleteNewsletterURL">
			<portlet:param name="newsletterId" value="<%= String.valueOf(newsletter.getNewsletterId()) %>"/>
		</portlet:actionURL>
		<liferay-ui:icon-delete url="<%= deleteNewsletterURL.toString() %>" />
		
</liferay-ui:icon-menu>
