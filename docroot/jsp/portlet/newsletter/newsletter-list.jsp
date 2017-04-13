<%@page import="java.text.DateFormatSymbols"%>
<%@page import="net.zylk.liferay.portal.model.NewsletterConstants"%>
<%@page import="java.util.List"%>
<%@page import="net.zylk.liferay.portal.model.Newsletter"%>

<%@ include file="/jsp/portlet/init.jsp" %>

<%
	List<Newsletter> newsletters = (List<Newsletter>)request.getAttribute("newsletters");
	int count = ParamUtil.getInteger(request, "count");
	
	Format dateFormatDateTime = FastDateFormatFactoryUtil.getDate(locale, timeZone);
%>

<%@ include file="/jsp/portlet/newsletter/main-tabs.jsp" %>


<liferay-ui:header title="zylk.newsletter.newsletter.list.header" />


<portlet:renderURL var="addNewsletterURL" >
	<portlet:param name="view" value="addNewsletter" />
</portlet:renderURL>

<aui:button-row>
	<aui:button name="" type="submit" value="zylk.newsletter.newsletter.list.button.add" onClick="<%= addNewsletterURL.toString() %>" />
</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="zn.general.list.empty">
	
	<liferay-ui:search-container-results results="<%= newsletters %>" total="<%= count %>" />
	
	<liferay-ui:search-container-row
		className="net.zylk.liferay.portal.model.Newsletter" keyProperty="newsletterId"
		modelVar="newsletter">
		
		<liferay-ui:search-container-column-text name="" align="left" cssClass="zn-col-icon">
			<%
			String imageTitle = LanguageUtil.get(pageContext, "zylk.newsletter.newsletter.edit.scheduler.active.false.info");
			String image = request.getContextPath() + "/images/pause.png";
			if (newsletter.getSchedulerActive()) {
				imageTitle = LanguageUtil.get(pageContext, "zylk.newsletter.newsletter.edit.scheduler.active.true.info");
				image = request.getContextPath() + "/images/play.png";
			}
			%>
			<img alt="<%= imageTitle %>" title="<%= imageTitle %>" src="<%= image %>" height="16" width="16"/>	
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="name" value="<%= newsletter.getName() %>" align="left" />
		
		<%
			DateFormatSymbols dfs = new DateFormatSymbols(locale);
			String[] weekDays = dfs.getWeekdays();
		
			String schedulerTypeLabel = "";
			if (newsletter.getSchedulerType() == NewsletterConstants.SCHEDULER_TYPE_DAYLY) {
				
				schedulerTypeLabel = LanguageUtil.get(pageContext, "zylk.newsletter.newsletter.edit.scheduler.type.daily");
				
			} else if (newsletter.getSchedulerType() == NewsletterConstants.SCHEDULER_TYPE_WEEKLY) {
				
				schedulerTypeLabel = LanguageUtil.get(pageContext, "zylk.newsletter.newsletter.edit.scheduler.type.weekly");
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(newsletter.getSchedulerDate());
				schedulerTypeLabel += " (" + weekDays[calendar.get(Calendar.DAY_OF_WEEK)]  + ")";
				
			} else if (newsletter.getSchedulerType() == NewsletterConstants.SCHEDULER_TYPE_MONTHLY) {
				
				schedulerTypeLabel = LanguageUtil.get(pageContext, "zylk.newsletter.newsletter.edit.scheduler.type.monthly");
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(newsletter.getSchedulerDate());
				if (calendar.get(Calendar.DAY_OF_MONTH) == 31) {
					schedulerTypeLabel += " (" + LanguageUtil.get(pageContext, "zn.general.month.last_day") + ")";
				} else {
					schedulerTypeLabel += " (" + calendar.get(Calendar.DAY_OF_MONTH) + ")";
				}
				
			} else if (newsletter.getSchedulerType() == NewsletterConstants.SCHEDULER_TYPE_SPECIFIC_DATE) {
				
				schedulerTypeLabel = LanguageUtil.get(pageContext, "zylk.newsletter.newsletter.edit.scheduler.type.specific_day");
				schedulerTypeLabel += " (" + dateFormatDateTime.format(newsletter.getSchedulerDate()) + ")";
			}
		%>
		<liferay-ui:search-container-column-text name="scheduler" value="<%= schedulerTypeLabel %>" align="left" />
		
		<liferay-ui:search-container-column-jsp name="" path="/jsp/portlet/newsletter/newsletter-actions.jsp" align="right"/>
		
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator paginate="false" />
	
</liferay-ui:search-container>






