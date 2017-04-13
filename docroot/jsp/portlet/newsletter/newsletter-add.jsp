<%@page import="net.zylk.liferay.portal.model.Newsletter"%>
<%@page import="net.zylk.liferay.portal.NewsletterArticleException"%>
<%@page import="java.text.DateFormatSymbols"%>
<%@page import="net.zylk.liferay.portal.model.NewsletterConstants"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="net.zylk.liferay.portal.model.Category"%>

<%@ include file="/jsp/portlet/init.jsp" %>


<%@ include file="/jsp/portlet/newsletter/main-tabs.jsp" %>


<%
	List<Category> categories = (List<Category>)request.getAttribute("categories");
	List<JournalArticle> articles = (List<JournalArticle>)request.getAttribute("articles");
%>


<script type="text/javascript">

	function changeSchedulerType() {
	    
	    AUI().use('node', function(Y) {
	    	
		    var type = Y.one('#<portlet:namespace/>schedulerType').get('value');
		    
		    var weekDayNode = Y.one('#zn-weekDayDiv');
		    var monthDayDiv = Y.one('#zn-monthDayDiv');
		    var selectDayDiv = Y.one('#zn-selectDayDiv');
		    
		    if (type == <%= NewsletterConstants.SCHEDULER_TYPE_DAYLY %>) {
			    weekDayNode.setStyle('display', 'none');
			    monthDayDiv.setStyle('display', 'none');
			    selectDayDiv.setStyle('display', 'none');
		    } else if (type == <%= NewsletterConstants.SCHEDULER_TYPE_WEEKLY %>) {
		    	weekDayNode.setStyle('display', 'inline');
			    monthDayDiv.setStyle('display', 'none');
			    selectDayDiv.setStyle('display', 'none');
			} else if (type == <%= NewsletterConstants.SCHEDULER_TYPE_MONTHLY %>) {
				weekDayNode.setStyle('display', 'none');
			    monthDayDiv.setStyle('display', 'inline');
			    selectDayDiv.setStyle('display', 'none');
			} else if (type == <%= NewsletterConstants.SCHEDULER_TYPE_SPECIFIC_DATE %>) {
				weekDayNode.setStyle('display', 'none');
			    monthDayDiv.setStyle('display', 'none');
			    selectDayDiv.setStyle('display', 'inline');
		    }
		    
		});
	}
	
	AUI().ready(
	    function() {
	    	changeSchedulerType();
	    }
	);

</script>

<portlet:renderURL var="backURL" >
	<portlet:param name="view" value="newsletterList" />
</portlet:renderURL>

<liferay-ui:header title="zylk.newsletter.newsletter.add.header" backURL="<%= backURL %>"/>

<liferay-ui:error exception="<%= NewsletterArticleException.class %>" message="zylk.newsletter.newsletter.error.article.empty" />

<portlet:actionURL name="addNewsletter" var="addNewsletter">
	<portlet:param name="backURL" value="<%= currentURL.toString() %>" />
</portlet:actionURL>

<aui:form action="<%= addNewsletter.toString() %>" method="post" >

	<aui:fieldset>
		<aui:input name="name" type="text" size="100">
			<aui:validator name="required" />
			<aui:validator name="maxLength">255</aui:validator>
		</aui:input>
		<aui:input name="description" type="textarea" cols="80" rows="6" />
		<aui:select name="categoryId" label="zn.general.category">
			<% 
				for (Category category : categories) {
			%>
					<aui:option value="<%= category.getCategoryId() %>"><%= category.getName(locale) %></aui:option>
			<%
				}
			%>
		</aui:select>
	</aui:fieldset>
	
	<br/>
	<aui:fieldset label="content">
		<br/>
		<aui:model-context model="<%= Newsletter.class %>" />
		<aui:input name="subject" size="100">
			<aui:validator name="required" />
			<aui:validator name="maxLength">255</aui:validator>
		</aui:input>
		<aui:select name="articleKey" label="article" helpMessage="zylk.newsletter.newsletter.add.field.article.help">
			<% 
				for (JournalArticle article : articles) {
					String articleKey = article.getGroupId() + "_" + article.getArticleId();
			%>
					<aui:option value="<%= articleKey %>"><%= article.getTitle() %> (<%= article.getArticleId() %>)</aui:option>
			<%
				}
			%>
		</aui:select>
	</aui:fieldset>
	
	<%@ include file="/jsp/portlet/newsletter/newsletter-tokens.jsp" %>
	
	<br/>
	<aui:fieldset label="scheduler">
		<br/>
		<aui:input name="schedulerActive" type="checkbox" label="zylk.newsletter.newsletter.edit.scheduler.active"></aui:input>
		
		<aui:select name="schedulerType" label="zylk.newsletter.newsletter.edit.scheduler.type" onChange="javascript:changeSchedulerType();">
			<aui:option value="<%= NewsletterConstants.SCHEDULER_TYPE_DAYLY %>">
				<liferay-ui:message key="zylk.newsletter.newsletter.edit.scheduler.type.daily" />
			</aui:option>
			<aui:option value="<%= NewsletterConstants.SCHEDULER_TYPE_WEEKLY %>">
				<liferay-ui:message key="zylk.newsletter.newsletter.edit.scheduler.type.weekly" />
			</aui:option>
			<aui:option value="<%= NewsletterConstants.SCHEDULER_TYPE_MONTHLY %>">
				<liferay-ui:message key="zylk.newsletter.newsletter.edit.scheduler.type.monthly" />
			</aui:option>
			<aui:option value="<%= NewsletterConstants.SCHEDULER_TYPE_SPECIFIC_DATE %>">
				<liferay-ui:message key="zylk.newsletter.newsletter.edit.scheduler.type.specific_day" />
			</aui:option>
		</aui:select>
		
		<div id="zn-weekDayDiv" style="display: none;">
			<aui:select name="weekDay" label="zylk.newsletter.newsletter.edit.scheduler.select_day">
				<%	
					DateFormatSymbols dfs = new DateFormatSymbols(locale);
					String[] weekDays = dfs.getWeekdays();
				%>
				<aui:option value="<%= Calendar.MONDAY %>"><%= weekDays[Calendar.MONDAY] %></aui:option>
				<aui:option value="<%= Calendar.TUESDAY %>"><%= weekDays[Calendar.TUESDAY] %></aui:option>
				<aui:option value="<%= Calendar.WEDNESDAY %>"><%= weekDays[Calendar.WEDNESDAY] %></aui:option>
				<aui:option value="<%= Calendar.THURSDAY %>"><%= weekDays[Calendar.THURSDAY] %></aui:option>
				<aui:option value="<%= Calendar.FRIDAY %>"><%= weekDays[Calendar.FRIDAY] %></aui:option>
				<aui:option value="<%= Calendar.SATURDAY %>"><%= weekDays[Calendar.SATURDAY] %></aui:option>
				<aui:option value="<%= Calendar.SUNDAY %>"><%= weekDays[Calendar.SUNDAY] %></aui:option>
			</aui:select>
		</div>
		
		<div id="zn-monthDayDiv" style="display: none;">
			<aui:select name="monthDay" label="zylk.newsletter.newsletter.edit.scheduler.select_day">
				<% for (int i = 1; i <= 28; i++) { %>
					<aui:option value="<%= i %>"><%= i %></aui:option>
				<% } %>
					<aui:option value="31"><liferay-ui:message key="zn.general.month.last_day" /></aui:option>
			</aui:select>
		</div>
		
		<%
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(new Date());
		%>
		<div id="zn-selectDayDiv" style="display: none;">
			<label class="aui-field-label"><liferay-ui:message key="zylk.newsletter.newsletter.edit.scheduler.select_day" /></label>
			<liferay-ui:input-date
				dayParam="specificDateDay"
				monthParam="specificDateMonth"
				yearParam="specificDateYear"
				monthValue="<%= startCal.get(Calendar.MONTH) %>"  
				yearValue="<%= startCal.get(Calendar.YEAR) %>"
				/>
		</div>
	</aui:fieldset>
	
	<br/>
	
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>