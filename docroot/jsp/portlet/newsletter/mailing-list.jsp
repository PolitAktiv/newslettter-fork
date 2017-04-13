<%@page import="net.zylk.liferay.portal.model.MailingConstants"%>
<%@page import="java.util.List"%>
<%@page import="net.zylk.liferay.portal.model.Mailing"%>

<%@ include file="/jsp/portlet/init.jsp" %>

<%
	List<Mailing> mailings = (List<Mailing>)request.getAttribute("mailings");
	int count = ParamUtil.getInteger(request, "count");
	
	Format dateFormatDate = FastDateFormatFactoryUtil.getDate(locale, timeZone);
	Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);
%>

<%@ include file="/jsp/portlet/newsletter/main-tabs.jsp" %>


<liferay-ui:header title="zylk.newsletter.mailing.list.header" />


<liferay-ui:search-container emptyResultsMessage="zn.general.list.empty">
	
	<liferay-ui:search-container-results results="<%= mailings %>" total="<%= count %>" />
	
	<liferay-ui:search-container-row
		className="net.zylk.liferay.portal.model.Mailing" keyProperty="mailingId"
		modelVar="mailing">
		
		<liferay-ui:search-container-column-text align="left" cssClass="zn-col-icon">
			<%
			String imageTitle = LanguageUtil.get(pageContext, "zylk.newsletter.mailing.view.field.scheduled.false.info");
			String image = request.getContextPath() + "/images/manual.png";
			if (mailing.isIsScheduled() ) {
				imageTitle = LanguageUtil.get(pageContext, "zylk.newsletter.mailing.view.field.scheduled.true.info");
				image = request.getContextPath() + "/images/clock.png";
			}
			%>
			<img alt="<%= imageTitle %>" title="<%= imageTitle %>" src="<%= image %>" height="16" width="16"/>	
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text align="left" cssClass="zn-col-icon">
			<%
			String imageTitle = LanguageUtil.get(pageContext, "zylk.newsletter.mailing.view.field.status.ok.info");
			String image = request.getContextPath() + "/images/mailing-ok.png";
			if (mailing.getStatus() == MailingConstants.STATUS_EXECUTING) {
				imageTitle = LanguageUtil.get(pageContext, "zylk.newsletter.mailing.view.field.status.executing.info");
				image = request.getContextPath() + "/images/mailing-executing.png";
			} else if (mailing.getStatus() == MailingConstants.STATUS_CANCELED) {
				imageTitle = LanguageUtil.get(pageContext, "zylk.newsletter.mailing.view.field.status.canceled.info");
				image = request.getContextPath() + "/images/mailing-canceled.png";
			}
			%>
			<img alt="<%= imageTitle %>" title="<%= imageTitle %>" src="<%= image %>" height="16" width="16"/>	
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="name" value="<%= mailing.getNewsletterName() %>" align="left" />
		
		<liferay-ui:search-container-column-text name="date" value="<%= dateFormatDateTime.format(mailing.getStartDate()) %>" align="left" />
		
		<liferay-ui:search-container-column-text name="zylk.newsletter.mailing.view.field.email_count" value="<%= String.valueOf(mailing.getEmailCount()) %>" align="left" />
		
		<liferay-ui:search-container-column-jsp name="" path="/jsp/portlet/newsletter/mailing-actions.jsp" align="right"/>
		
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator paginate="false" />
	
</liferay-ui:search-container>






