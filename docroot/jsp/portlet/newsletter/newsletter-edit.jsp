<%@page import="net.zylk.liferay.portal.NewsletterArticleException"%>
<%@page import="java.text.DateFormatSymbols"%>
<%@page import="net.zylk.liferay.portal.model.NewsletterConstants"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="net.zylk.liferay.portal.model.Category"%>
<%@page import="net.zylk.liferay.portal.model.Newsletter"%>

<%@ include file="/jsp/portlet/init.jsp" %>

<%@ include file="/jsp/portlet/newsletter/main-tabs.jsp" %>

<%
	List<Category> categories = (List<Category>)request.getAttribute("categories");
	List<JournalArticle> articles = (List<JournalArticle>)request.getAttribute("articles");
%>

<jsp:useBean id="newsletter" type="net.zylk.liferay.portal.model.Newsletter" scope="request" />
<jsp:useBean id="backURL" type="java.lang.String" scope="request" />


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


<liferay-ui:header title="zylk.newsletter.newsletter.edit.header" backURL="<%= backURL %>"/>

<liferay-ui:error exception="<%= NewsletterArticleException.class %>" message="zylk.newsletter.newsletter.error.article.empty" />

<portlet:actionURL name="editNewsletter" var="editNewsletter">
	<portlet:param name="newsletterId" value="<%= String.valueOf(newsletter.getNewsletterId()) %>" />
	<portlet:param name="backURL" value="<%= currentURL.toString() %>" />
</portlet:actionURL>

<aui:form action="<%= editNewsletter.toString() %>" method="post" >

	<aui:fieldset>		
		<aui:input name="name" type="text" size="100" value="<%= newsletter.getName() %>">
			<aui:validator name="required" />
			<aui:validator name="maxLength">255</aui:validator>
		</aui:input>
		<aui:input name="description" type="textarea" cols="80" rows="6" value="<%= newsletter.getDescription() %>"/>
		<aui:select name="categoryId" label="zn.general.category">
			<% 
				for (Category category : categories) {
					boolean selected = false;
					if (category.getCategoryId() == newsletter.getCategoryId()) {
						selected = true;
					}
			%>
					<aui:option value="<%= category.getCategoryId() %>" selected="<%= selected %>"><%= category.getName(locale) %></aui:option>
			<%
				}
			%>
		</aui:select>
	</aui:fieldset>
	
	<br/>
	<aui:fieldset label="content">
		<br/>
		<aui:model-context bean="<%= newsletter %>" model="<%= Newsletter.class %>"/>
		<aui:input name="subject" size="100">
			<aui:validator name="required" />
			<aui:validator name="maxLength">255</aui:validator>
		</aui:input>
		<aui:select name="articleKey" label="article" helpMessage="zylk.newsletter.newsletter.add.field.article.help">
			<%
				for (JournalArticle article : articles) {
					boolean selected = false;
					if (article.getArticleId().equals(newsletter.getArticleId()) && article.getGroupId() == newsletter.getArticleGroupId()) {
						selected = true;
					}
					String articleKey = article.getGroupId() + "_" + article.getArticleId();
			%>
					<aui:option value="<%= articleKey %>" selected="<%= selected %>"><%= article.getTitle() %> (<%= article.getArticleId() %>)</aui:option>
			<%
				}
			%>
		</aui:select>
	</aui:fieldset>
	
	<%@ include file="/jsp/portlet/newsletter/newsletter-tokens.jsp" %>
	
	<br/>
	<aui:fieldset label="scheduler">
		<br/>
		<aui:input name="schedulerActive" type="checkbox" label="zylk.newsletter.newsletter.edit.scheduler.active" checked="<%= newsletter.getSchedulerActive() %>"></aui:input>
		
		<aui:select name="schedulerType" label="zylk.newsletter.newsletter.edit.scheduler.type" onChange="javascript:changeSchedulerType();">
			
			<aui:option value="<%= NewsletterConstants.SCHEDULER_TYPE_DAYLY %>" 
				selected="<%= newsletter.getSchedulerType() == NewsletterConstants.SCHEDULER_TYPE_DAYLY ? true : false %>">
					<liferay-ui:message key="zylk.newsletter.newsletter.edit.scheduler.type.daily" />
			</aui:option>
			<aui:option value="<%= NewsletterConstants.SCHEDULER_TYPE_WEEKLY %>" 
				selected="<%= newsletter.getSchedulerType() == NewsletterConstants.SCHEDULER_TYPE_WEEKLY ? true : false %>">
					<liferay-ui:message key="zylk.newsletter.newsletter.edit.scheduler.type.weekly" />
			</aui:option>
			<aui:option value="<%= NewsletterConstants.SCHEDULER_TYPE_MONTHLY %>" 
				selected="<%= newsletter.getSchedulerType() == NewsletterConstants.SCHEDULER_TYPE_MONTHLY ? true : false %>">
					<liferay-ui:message key="zylk.newsletter.newsletter.edit.scheduler.type.monthly" />
			</aui:option>
			<aui:option value="<%= NewsletterConstants.SCHEDULER_TYPE_SPECIFIC_DATE %>" 
				selected="<%= newsletter.getSchedulerType() == NewsletterConstants.SCHEDULER_TYPE_SPECIFIC_DATE ? true : false %>">
					<liferay-ui:message key="zylk.newsletter.newsletter.edit.scheduler.type.specific_day" />
			</aui:option>
		</aui:select>
		
		<div id="zn-weekDayDiv" style="display: none;">
			<aui:select name="weekDay" label="zylk.newsletter.newsletter.edit.scheduler.select_day">
				<%
					int weekDay = 1;
					if (newsletter.getSchedulerType() == NewsletterConstants.SCHEDULER_TYPE_WEEKLY) {
						Calendar calendar = new GregorianCalendar();
						calendar.setTime(newsletter.getSchedulerDate());
						weekDay = calendar.get(Calendar.DAY_OF_WEEK);
					}
					
					DateFormatSymbols dfs = new DateFormatSymbols(locale);
					String[] weekDays = dfs.getWeekdays();
				%>
				<aui:option value="<%= Calendar.MONDAY %>" 
					selected="<%= (newsletter.getSchedulerType() == NewsletterConstants.SCHEDULER_TYPE_WEEKLY && weekDay == Calendar.MONDAY) ? true : false %>">
						<%= weekDays[Calendar.MONDAY] %>
				</aui:option>
				<aui:option value="<%= Calendar.TUESDAY %>" 
					selected="<%= (newsletter.getSchedulerType() == NewsletterConstants.SCHEDULER_TYPE_WEEKLY && weekDay == Calendar.TUESDAY) ? true : false %>">
						<%= weekDays[Calendar.TUESDAY] %>
				</aui:option>
				<aui:option value="<%= Calendar.WEDNESDAY %>"
					selected="<%= (newsletter.getSchedulerType() == NewsletterConstants.SCHEDULER_TYPE_WEEKLY && weekDay == Calendar.WEDNESDAY) ? true : false %>">
						<%= weekDays[Calendar.WEDNESDAY] %>
				</aui:option>
				<aui:option value="<%= Calendar.THURSDAY %>"
					selected="<%= (newsletter.getSchedulerType() == NewsletterConstants.SCHEDULER_TYPE_WEEKLY && weekDay == Calendar.THURSDAY) ? true : false %>">
						<%= weekDays[Calendar.THURSDAY] %>
				</aui:option>
				<aui:option value="<%= Calendar.FRIDAY %>"
					selected="<%= (newsletter.getSchedulerType() == NewsletterConstants.SCHEDULER_TYPE_WEEKLY && weekDay == Calendar.FRIDAY) ? true : false %>">
						<%= weekDays[Calendar.FRIDAY] %>
				</aui:option>
				<aui:option value="<%= Calendar.SATURDAY %>"
					selected="<%= (newsletter.getSchedulerType() == NewsletterConstants.SCHEDULER_TYPE_WEEKLY && weekDay == Calendar.SATURDAY) ? true : false %>">
						<%= weekDays[Calendar.SATURDAY] %>
				</aui:option>
				<aui:option value="<%= Calendar.SUNDAY %>"
					selected="<%= (newsletter.getSchedulerType() == NewsletterConstants.SCHEDULER_TYPE_WEEKLY && weekDay == Calendar.SUNDAY) ? true : false %>">
						<%= weekDays[Calendar.SUNDAY] %>
				</aui:option>
			</aui:select>
		</div>
		
		<div id="zn-monthDayDiv" style="display: none;">
			<aui:select name="monthDay" label="zylk.newsletter.newsletter.edit.scheduler.select_day">
				<%
					int monthDay = 1;
					if (newsletter.getSchedulerType() == NewsletterConstants.SCHEDULER_TYPE_MONTHLY) {
						Calendar calendar = new GregorianCalendar();
						calendar.setTime(newsletter.getSchedulerDate());
						monthDay = calendar.get(Calendar.DAY_OF_MONTH);
					}
					
					for (int i = 1; i <= 28; i++) { %>
						<aui:option value="<%= i %>" 
							selected="<%= (newsletter.getSchedulerType() == NewsletterConstants.SCHEDULER_TYPE_MONTHLY && monthDay == i) ? true : false %>"><%= i %></aui:option>
				<% 
					}
				%>
				<aui:option value="31" selected="<%= (newsletter.getSchedulerType() == NewsletterConstants.SCHEDULER_TYPE_MONTHLY && monthDay == 31) ? true : false %>">
					<liferay-ui:message key="zn.general.month.last_day" />
				</aui:option>
			</aui:select>
		</div>
		
		<%
		Calendar startCal = Calendar.getInstance();
		if (newsletter.getSchedulerType() == NewsletterConstants.SCHEDULER_TYPE_SPECIFIC_DATE) {
			startCal.setTime(newsletter.getSchedulerDate());
		} else {
			startCal.setTime(new Date());
		}
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