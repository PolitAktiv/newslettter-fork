package net.zylk.liferay.portlet.newsletter.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import net.zylk.liferay.portal.DuplicateSubscriptorException;
import net.zylk.liferay.portal.EmptyFieldException;
import net.zylk.liferay.portal.ImportException;
import net.zylk.liferay.portal.InvalidEmailException;
import net.zylk.liferay.portal.NewsletterArticleException;
import net.zylk.liferay.portal.model.Category;
import net.zylk.liferay.portal.model.Mailing;
import net.zylk.liferay.portal.model.MailingSubscriptor;
import net.zylk.liferay.portal.model.Newsletter;
import net.zylk.liferay.portal.model.NewsletterConstants;
import net.zylk.liferay.portal.model.Subscriptor;
import net.zylk.liferay.portal.service.CategoryLocalServiceUtil;
import net.zylk.liferay.portal.service.MailingLocalServiceUtil;
import net.zylk.liferay.portal.service.MailingSubscriptorLocalServiceUtil;
import net.zylk.liferay.portal.service.NewsletterLocalServiceUtil;
import net.zylk.liferay.portal.service.SubscriptorLocalServiceUtil;

import org.apache.commons.io.IOUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.NoSuchTagException;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.liferay.portlet.asset.service.persistence.AssetEntryQuery;
import com.liferay.portlet.journal.NoSuchArticleException;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class NewsletterPortlet extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(NewsletterPortlet.class);

	// Limits the results of subscribers being shown
	private static final int LIMIT_RESULTS = 10000; 
	private static final int LIMIT_RESULTS_MAX = 10000; 
	//private static final int LIMIT_RESULTS = SubscriptorLocalServiceUtil.getSubscriptorsCount(); 
	//private static final int LIMIT_RESULTS_MAX = SubscriptorLocalServiceUtil.getSubscriptorsCount(); 

	private static final String categoryListJsp = "/jsp/portlet/newsletter/category-list.jsp";
	private static final String categoryAddJsp = "/jsp/portlet/newsletter/category-add.jsp";
	private static final String categoryEditJsp = "/jsp/portlet/newsletter/category-edit.jsp";
	
	private static final String subscriptorListJsp = "/jsp/portlet/newsletter/subscriptor-list.jsp";
	private static final String subscriptorAddJsp = "/jsp/portlet/newsletter/subscriptor-add.jsp";
	private static final String subscriptorEditJsp = "/jsp/portlet/newsletter/subscriptor-edit.jsp";
	private static final String subscriptorImportJsp = "/jsp/portlet/newsletter/subscriptor-import.jsp";
	
	private static final String newsletterListJsp = "/jsp/portlet/newsletter/newsletter-list.jsp";
	private static final String newsletterAddJsp = "/jsp/portlet/newsletter/newsletter-add.jsp";
	private static final String newsletterEditJsp = "/jsp/portlet/newsletter/newsletter-edit.jsp";

	private static final String mailingListJsp = "/jsp/portlet/newsletter/mailing-list.jsp";
	private static final String mailingViewJsp = "/jsp/portlet/newsletter/mailing-view.jsp";
	
	private static final String configurationViewJsp = "/jsp/portlet/newsletter/configuration-2.jsp";
	

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		try {
			String view = ParamUtil.getString(renderRequest, "view");
			renderRequest.setAttribute("view", view); // se utiliza en el navigation.jsp
			
			if (view == null || view.equals("")) {
				doViewCategoryList(renderRequest, renderResponse);
			} else if (view.equals("categoryList")) {
				doViewCategoryList(renderRequest, renderResponse);
			} else if (view.equals("addCategory")) {
				doViewAddCategory(renderRequest, renderResponse);
			} else if (view.equals("editCategory")) {
				doViewEditCategory(renderRequest, renderResponse);
			} else if (view.equals("subscriptorList")) {
				doViewSubscriptorList(renderRequest, renderResponse);
			} else if (view.equals("addSubscriptor")) {
				doViewAddSubscriptor(renderRequest, renderResponse);
			} else if (view.equals("editSubscriptor")) {
				doViewEditSubscriptor(renderRequest, renderResponse);
			} else if (view.equals("importSubscriptor")) {
				doViewImportSubscriptor(renderRequest, renderResponse);
			} else if (view.equals("newsletterList")) {
				doViewNewsletterList(renderRequest, renderResponse);
			} else if (view.equals("addNewsletter")) {
				doViewAddNewsletter(renderRequest, renderResponse);
			} else if (view.equals("editNewsletter")) {
				doViewEditNewsletter(renderRequest, renderResponse);
			} else if (view.equals("mailingList")) {
				doViewMailingList(renderRequest, renderResponse);
			} else if (view.equals("viewMailing")) {
				doViewViewMailing(renderRequest, renderResponse);
			} else if (view.equals("configuration")) {
				doViewConfiguration(renderRequest, renderResponse);
			}
		} catch (PortalException e) {
			throw new PortletException(e);
		} catch (SystemException e) {
			throw new PortletException(e);
		}
	}

	
	/* CATEGORY */
	
	public void doViewCategoryList(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException, SystemException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		List<Category> categories = CategoryLocalServiceUtil.findByCompanyIdAndGroupId(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId());
		
		renderRequest.setAttribute("categories", categories);
		renderRequest.setAttribute("count", categories.size());
		
		renderRequest.setAttribute("mainTab", "categoryList");
		
		include(categoryListJsp, renderRequest, renderResponse);
	}

	public void doViewAddCategory(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException, SystemException, PortalException {

		renderRequest.setAttribute("mainTab", "categoryList");
		
		include(categoryAddJsp, renderRequest, renderResponse);
	}
	
	public void doViewEditCategory(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException, SystemException, PortalException {

		long categoryId = ParamUtil.getLong(renderRequest, "categoryId");
		Category category = CategoryLocalServiceUtil.getCategory(categoryId);
		renderRequest.setAttribute("category", category);
		
		String backURL = ParamUtil.getString(renderRequest, "backURL");
		renderRequest.setAttribute("backURL", backURL);
		
		renderRequest.setAttribute("mainTab", "categoryList");
		
		include(categoryEditJsp, renderRequest, renderResponse);
	}
	
	@ProcessAction(name = "addCategory")
    public void addCategory(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(actionRequest, "name");
			String description = ParamUtil.getString(actionRequest, "description");
			
			CategoryLocalServiceUtil.addCategory(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), nameMap, description);
			
			actionResponse.setRenderParameter("view", "categoryList");
			
		} catch (SystemException e) {
            throw new PortletException(e);
		} catch (PortalException e) {
			throw new PortletException(e);
		}
	}

	@ProcessAction(name = "editCategory")
    public void editCategory(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		
		try {
			long categoryId = ParamUtil.getLong(actionRequest, "categoryId");
			Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(actionRequest, "name");
			String description = ParamUtil.getString(actionRequest, "description");
			
			CategoryLocalServiceUtil.editCategory(categoryId, nameMap, description);
			// TODO deberia ir al backUrl (al listado pero con estado?)
			actionResponse.setRenderParameter("view", "categoryList");
			
		} catch (SystemException e) {
            throw new PortletException(e);
		} catch (PortalException e) {
			throw new PortletException(e);
		}
	}
	
	@ProcessAction(name = "removeCategory")
    public void removeCategory(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		
		try {
			long categoryId = ParamUtil.getLong(actionRequest, "categoryId");
			
			CategoryLocalServiceUtil.remove(categoryId);
			
			actionResponse.setRenderParameter("view", "categoryList");
			
		} catch (SystemException e) {
            throw new PortletException(e);
		} catch (PortalException e) {
			throw new PortletException(e);
		}
	}
	
	/* SUBSCRIPTOR */
	
	public void doViewSubscriptorList(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException, SystemException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		
		List<Subscriptor> subscriptors = SubscriptorLocalServiceUtil.findByKeywords(themeDisplay.getCompanyId(),
				themeDisplay.getScopeGroupId(), keywords, 0, LIMIT_RESULTS);
		int count = SubscriptorLocalServiceUtil.countByKeywords(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(),
				keywords);
		
		renderRequest.setAttribute("subscriptors", subscriptors);
		renderRequest.setAttribute("count", count);
		renderRequest.setAttribute("keywords", keywords);
		
		renderRequest.setAttribute("mainTab", "subscriptorList");
		
		include(subscriptorListJsp, renderRequest, renderResponse);
		
		// with paging
		
		/*
		PortletURL portletURL = renderResponse.createRenderURL();
	    SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 20, portletURL, null, null);
	    Model[] subscriptorResults = (Model[]) request.getAttribute("subscriptorResults");
	    Integer count = (Integer)request.getAttribute("count");
	    String keywords = (String)request.getAttribute("keywords");
	    List<Subscriptor> list = new ArrayList<Subscriptor>();
	    if(subscriptorResults != null){
	        for(Model subscriptor : subscriptorResults){
	            list.add((Subscriptor)subscriptor);
	        }
	    }
	    searchContainer.setResults(list);
	    if(count != null)
	       searchContainer.setTotal(count);
	    List<String> headerNames = new ArrayList<String>();
	    headerNames.add("Name");
	    headerNames.add("Nachname");
	    headerNames.add("E-Mail");
	    searchContainer.setHeaderNames(headerNames);
	    List resultRows = searchContainer.getResultRows();
	    for(int i=0; i<list.size(); i++){
	        Subscriptor subscriptor = (Subscriptor)list.get(i);
	        ResultRow row = new ResultRow(subscriptor, subscriptor.getName(), i);
	        row.addText(subscriptor.getSurname());
	        row.addText(subscriptor.getName());
	        row.addText(subscriptor.getEmail());
	        resultRows.add(row);
	    }    
	    */
	}
	
	public void doViewAddSubscriptor(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException, SystemException, PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		List<Category> categories = CategoryLocalServiceUtil.findByCompanyIdAndGroupId(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId());
		renderRequest.setAttribute("categories", categories);
		
		renderRequest.setAttribute("mainTab", "subscriptorList");
		
		include(subscriptorAddJsp, renderRequest, renderResponse);
	}
	
	public void doViewEditSubscriptor(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException, SystemException, PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long subscriptorId = ParamUtil.getLong(renderRequest, "subscriptorId");
		Subscriptor subscriptor = SubscriptorLocalServiceUtil.getSubscriptor(subscriptorId);
		renderRequest.setAttribute("subscriptor", subscriptor);
		
		List<Category> categories = CategoryLocalServiceUtil.findByCompanyIdAndGroupId(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId());
		renderRequest.setAttribute("categories", categories);
		
		List<Category> subscriptorCategories = CategoryLocalServiceUtil.findBySubscriptorId(subscriptorId);
		List<Long> categoryIds = new ArrayList<Long>();
		for (Category category : subscriptorCategories) {
			categoryIds.add(category.getCategoryId());
		}
		renderRequest.setAttribute("categoryIds", categoryIds);
		
		String backURL = ParamUtil.getString(renderRequest, "backURL");
		renderRequest.setAttribute("backURL", backURL);
		
		renderRequest.setAttribute("mainTab", "subscriptorList");
		
		include(subscriptorEditJsp, renderRequest, renderResponse);
	}
	
	public void doViewImportSubscriptor(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException, SystemException, PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String errorDetails = ParamUtil.getString(renderRequest, "errorDetails");
		
		List<Category> categories = CategoryLocalServiceUtil.findByCompanyIdAndGroupId(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId());
		
		renderRequest.setAttribute("categories", categories);
		renderRequest.setAttribute("mainTab", "subscriptorList");
		renderRequest.setAttribute("errorDetails", errorDetails);
		
		include(subscriptorImportJsp, renderRequest, renderResponse);
	}
	
	@ProcessAction(name = "addSubscriptor")
    public void addSubscriptor(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			String name = ParamUtil.getString(actionRequest, "name");
			String surname = ParamUtil.getString(actionRequest, "surname");
			String email = ParamUtil.getString(actionRequest, "email");
			String languageId = ParamUtil.getString(actionRequest, "languageId");
			long[] categoryIds = ParamUtil.getLongValues(actionRequest, "categoryIdsCheckbox");
			
			try {
				SubscriptorLocalServiceUtil.addSubscriptor(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), name, surname, email, languageId, categoryIds, false);
				actionResponse.setRenderParameter("view", "subscriptorList");
				
			} catch (DuplicateSubscriptorException e) {
				
				SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				SessionErrors.add(actionRequest, e.getClass().getName(), e);
				actionResponse.setRenderParameter("view", "addSubscriptor");
				
				actionResponse.setRenderParameter("name", name);
				actionResponse.setRenderParameter("surname", surname);
				actionResponse.setRenderParameter("email", email);
				
			}  catch (InvalidEmailException e) {

				SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				SessionErrors.add(actionRequest, e.getClass().getName(), e);
				actionResponse.setRenderParameter("view", "addSubscriptor");
				
				actionResponse.setRenderParameter("name", name);
				actionResponse.setRenderParameter("surname", surname);
				actionResponse.setRenderParameter("email", email);
			}
			
		} catch (SystemException e) {
            throw new PortletException(e);
		} catch (PortalException e) {
			throw new PortletException(e);
		}
	}
	
	@ProcessAction(name = "editSubscriptor")
    public void editSubscriptor(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		
		try {
			long subscriptorId = ParamUtil.getLong(actionRequest, "subscriptorId");
			String name = ParamUtil.getString(actionRequest, "name");
			String surname = ParamUtil.getString(actionRequest, "surname");
			String email = ParamUtil.getString(actionRequest, "email");
			String languageId = ParamUtil.getString(actionRequest, "languageId");
			long[] categoryIds = ParamUtil.getLongValues(actionRequest, "categoryIdsCheckbox");
			
			try {
				SubscriptorLocalServiceUtil.editSubscriptor(subscriptorId, name, surname, email, languageId, categoryIds);	
				// TODO deberia ir al backUrl (al listado pero con estado?)
				actionResponse.setRenderParameter("view", "subscriptorList");
				
			} catch (DuplicateSubscriptorException e) {
				
				SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				SessionErrors.add(actionRequest, e.getClass().getName(), e);
				actionResponse.setRenderParameter("view", "editSubscriptor");
				actionResponse.setRenderParameter("subscriptorId", String.valueOf(subscriptorId));
				
				actionResponse.setRenderParameter("name", name);
				actionResponse.setRenderParameter("surname", surname);
				actionResponse.setRenderParameter("email", email);
				
			}  catch (InvalidEmailException e) {

				SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				SessionErrors.add(actionRequest, e.getClass().getName(), e);
				actionResponse.setRenderParameter("view", "editSubscriptor");
				actionResponse.setRenderParameter("subscriptorId", String.valueOf(subscriptorId));
				
				actionResponse.setRenderParameter("name", name);
				actionResponse.setRenderParameter("surname", surname);
				actionResponse.setRenderParameter("email", email);
			}
			
		} catch (SystemException e) {
            throw new PortletException(e);
		} catch (PortalException e) {
			throw new PortletException(e);
		}
	}
	
	@ProcessAction(name = "removeSubscriptor")
    public void removeSubscriptor(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		
		try {
			long subscriptorId = ParamUtil.getLong(actionRequest, "subscriptorId");
			
			SubscriptorLocalServiceUtil.remove(subscriptorId);
			
			actionResponse.setRenderParameter("view", "subscriptorList");
			
		} catch (SystemException e) {
            throw new PortletException(e);
		} catch (PortalException e) {
			throw new PortletException(e);
		}
	}
	
	@ProcessAction(name = "importSubscriptor")
    public void importSubscriptor(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			
			long[] categoryIds = ParamUtil.getLongValues(uploadRequest, "categoryIdsCheckbox");
			
			InputStream is = uploadRequest.getFileAsStream("csvFile");
				
			try {
				SubscriptorLocalServiceUtil.importSubscriptor(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), is, categoryIds);	
				// TODO deberia ir al backUrl (al listado pero con estado?)
				actionResponse.setRenderParameter("view", "subscriptorList");
				
				SessionMessages.add(actionRequest, "request_processed");
			
			} catch (ImportException e) {
				
				_log.error("import error", e);
				SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				SessionErrors.add(actionRequest, "error-import");
				actionResponse.setRenderParameter("errorDetails", e.getMessage());
				actionResponse.setRenderParameter("view", "importSubscriptor");
			}

		} catch (SystemException e) {
            throw new PortletException(e);
		} catch (PortalException e) {
			throw new PortletException(e);
		}
	}
	
	/* NESWLETTER */
	
	public void doViewNewsletterList(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException, SystemException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		List<Newsletter> newsletters = NewsletterLocalServiceUtil.findByCompanyIdAndGroupId(themeDisplay.getCompanyId(),
				themeDisplay.getScopeGroupId(), 0, LIMIT_RESULTS_MAX);
		int count = NewsletterLocalServiceUtil.countByCompanyIdAndGroupId(themeDisplay.getCompanyId(),
				themeDisplay.getScopeGroupId());
				
		renderRequest.setAttribute("newsletters", newsletters);
		renderRequest.setAttribute("count", count); 
		
		renderRequest.setAttribute("mainTab", "newsletterList");
		
		include(newsletterListJsp, renderRequest, renderResponse);
	}
	
	public void doViewAddNewsletter(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException, SystemException, PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		List<Category> categories = CategoryLocalServiceUtil.findByCompanyIdAndGroupId(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId());
		renderRequest.setAttribute("categories", categories);
		
		List<JournalArticle> articles = getArticles(themeDisplay);
		renderRequest.setAttribute("articles", articles);
		
		renderRequest.setAttribute("mainTab", "newsletterList");
		
		include(newsletterAddJsp, renderRequest, renderResponse);
	}
	
	public void doViewEditNewsletter(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException, SystemException, PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long newsletterId = ParamUtil.getLong(renderRequest, "newsletterId");
		Newsletter newsletter = NewsletterLocalServiceUtil.getNewsletter(newsletterId);
		renderRequest.setAttribute("newsletter", newsletter);
		
		List<Category> categories = CategoryLocalServiceUtil.findByCompanyIdAndGroupId(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId());
		renderRequest.setAttribute("categories", categories);

		List<JournalArticle> articles = getArticles(themeDisplay);
		renderRequest.setAttribute("articles", articles);
		
		String backURL = ParamUtil.getString(renderRequest, "backURL");
		renderRequest.setAttribute("backURL", backURL);
		
		renderRequest.setAttribute("mainTab", "newsletterList");
		
		include(newsletterEditJsp, renderRequest, renderResponse);
	}
	
	@ProcessAction(name = "addNewsletter")
    public void addNewsletter(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			String name = ParamUtil.getString(actionRequest, "name");
			String description = ParamUtil.getString(actionRequest, "description");
			long categoryId = ParamUtil.getLong(actionRequest, "categoryId");
			Map<Locale, String> subjectMap = LocalizationUtil.getLocalizationMap(actionRequest, "subject");
			String articleKey = ParamUtil.getString(actionRequest, "articleKey");
			boolean schedulerActive = ParamUtil.getBoolean(actionRequest, "schedulerActive");
			int schedulerType = ParamUtil.getInteger(actionRequest, "schedulerType");
			
			String articleId = "";
			long articleGroupId = 0;
			if (articleKey != null && !articleKey.equals("")) {
				String[] values = articleKey.split("_", 2);
				articleGroupId = Long.valueOf(values[0]);
				articleId = values[1];
			}
			
			Date shedulerDate = null;
			// Las fechas se inicializan a "2014/01/01 00:00:00", y luego dependiendo del tipo se modifican unicamente algunos
			// campos (el resto es indiferente). En un futuro se podra configurar tambien la hora.
			if (schedulerType == NewsletterConstants.SCHEDULER_TYPE_DAYLY) {
			
				Calendar calendar = new GregorianCalendar();
				calendar.set(Calendar.YEAR, 2014);
				calendar.set(Calendar.MONTH, 0);
				calendar.set(Calendar.DAY_OF_MONTH, 1);
				calendar.set(Calendar.HOUR_OF_DAY, 0);
				calendar.set(Calendar.MINUTE, 0);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				
				shedulerDate = calendar.getTime(); 
			
			} else if (schedulerType == NewsletterConstants.SCHEDULER_TYPE_WEEKLY) {
				
				int weekDay = ParamUtil.getInteger(actionRequest, "weekDay");
				
				Calendar calendar = new GregorianCalendar();
				calendar.set(Calendar.YEAR, 2014);
				calendar.set(Calendar.MONTH, 0);
				calendar.set(Calendar.DAY_OF_WEEK, weekDay);
				calendar.set(Calendar.HOUR_OF_DAY, 0);
				calendar.set(Calendar.MINUTE, 0);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				
				shedulerDate = calendar.getTime(); 
				
			} else if (schedulerType == NewsletterConstants.SCHEDULER_TYPE_MONTHLY) {
				
				int monthDay = ParamUtil.getInteger(actionRequest, "monthDay");
				
				Calendar calendar = new GregorianCalendar();
				calendar.set(Calendar.YEAR, 2014);
				calendar.set(Calendar.MONTH, 0);
				calendar.set(Calendar.DAY_OF_MONTH, monthDay);
				calendar.set(Calendar.HOUR_OF_DAY, 0);
				calendar.set(Calendar.MINUTE, 0);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				
				shedulerDate = calendar.getTime();
				
			} else if (schedulerType == NewsletterConstants.SCHEDULER_TYPE_SPECIFIC_DATE) {
				
				int specificDateDay = ParamUtil.getInteger(actionRequest, "specificDateDay");
				int specificDateMonth = ParamUtil.getInteger(actionRequest, "specificDateMonth");
				int specificDateYear = ParamUtil.getInteger(actionRequest, "specificDateYear");
				
				Calendar calendar = new GregorianCalendar();
				calendar.set(Calendar.YEAR, specificDateYear);
				calendar.set(Calendar.MONTH, specificDateMonth);
				calendar.set(Calendar.DAY_OF_MONTH, specificDateDay);
				calendar.set(Calendar.HOUR_OF_DAY, 0);
				calendar.set(Calendar.MINUTE, 0);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				
				shedulerDate = calendar.getTime();
			}
			
			try {
				NewsletterLocalServiceUtil.addNewsletter(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), name,
						description, categoryId, subjectMap, articleId, articleGroupId, schedulerActive, schedulerType,
						shedulerDate);
				
				actionResponse.setRenderParameter("view", "newsletterList");
				
			} catch (NewsletterArticleException e) {
				
				SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				SessionErrors.add(actionRequest, e.getClass().getName(), e);
				actionResponse.setRenderParameter("view", "addNewsletter");
			}
			
		} catch (SystemException e) {
            throw new PortletException(e);
		} catch (PortalException e) {
			throw new PortletException(e);
		}
	}
	
	@ProcessAction(name = "editNewsletter")
    public void editNewsletter(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		
		try {
			long newsletterId = ParamUtil.getLong(actionRequest, "newsletterId");
			String name = ParamUtil.getString(actionRequest, "name");
			String description = ParamUtil.getString(actionRequest, "description");
			long categoryId = ParamUtil.getLong(actionRequest, "categoryId");
			Map<Locale, String> subjectMap = LocalizationUtil.getLocalizationMap(actionRequest, "subject");
			String articleKey = ParamUtil.getString(actionRequest, "articleKey");
			boolean schedulerActive = ParamUtil.getBoolean(actionRequest, "schedulerActive");
			int schedulerType = ParamUtil.getInteger(actionRequest, "schedulerType");
			
			String articleId = "";
			long articleGroupId = 0;
			if (articleKey != null && !articleKey.equals("")) {
				String[] values = articleKey.split("_", 2);
				articleGroupId = Long.valueOf(values[0]);
				articleId = values[1];
			}
			
			Date shedulerDate = null;
			// Las fechas se inicializan a "2014/01/01 00:00:00", y luego dependiendo del tipo se modifican unicamente algunos
			// campos (el resto es indiferente). En un futuro se podra configurar tambien la hora.
			if (schedulerType == NewsletterConstants.SCHEDULER_TYPE_DAYLY) {

				Calendar calendar = new GregorianCalendar();
				calendar.setTime(new Date());
				calendar.set(Calendar.YEAR, 2014);
				calendar.set(Calendar.MONTH, 0);
				calendar.set(Calendar.DAY_OF_MONTH, 1);
				calendar.set(Calendar.HOUR_OF_DAY, 0);
				calendar.set(Calendar.MINUTE, 0);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				
				shedulerDate = calendar.getTime(); 
			
			} else if (schedulerType == NewsletterConstants.SCHEDULER_TYPE_WEEKLY) {
				
				int weekDay = ParamUtil.getInteger(actionRequest, "weekDay");
				
				Calendar calendar = new GregorianCalendar();
				calendar.set(Calendar.YEAR, 2014);
				calendar.set(Calendar.MONTH, 0);
				calendar.set(Calendar.DAY_OF_WEEK, weekDay);
				calendar.set(Calendar.HOUR_OF_DAY, 0);
				calendar.set(Calendar.MINUTE, 0);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				
				shedulerDate = calendar.getTime(); 
				
			} else if (schedulerType == NewsletterConstants.SCHEDULER_TYPE_MONTHLY) {
				
				int monthDay = ParamUtil.getInteger(actionRequest, "monthDay");
				
				Calendar calendar = new GregorianCalendar();
				calendar.set(Calendar.YEAR, 2014);
				calendar.set(Calendar.MONTH, 0);
				calendar.set(Calendar.DAY_OF_MONTH, monthDay);
				calendar.set(Calendar.HOUR_OF_DAY, 0);
				calendar.set(Calendar.MINUTE, 0);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				
				shedulerDate = calendar.getTime();
				
			} else if (schedulerType == NewsletterConstants.SCHEDULER_TYPE_SPECIFIC_DATE) {
				
				int specificDateDay = ParamUtil.getInteger(actionRequest, "specificDateDay");
				int specificDateMonth = ParamUtil.getInteger(actionRequest, "specificDateMonth");
				int specificDateYear = ParamUtil.getInteger(actionRequest, "specificDateYear");
				
				Calendar calendar = new GregorianCalendar();
				calendar.set(Calendar.YEAR, specificDateYear);
				calendar.set(Calendar.MONTH, specificDateMonth);
				calendar.set(Calendar.DAY_OF_MONTH, specificDateDay);
				calendar.set(Calendar.HOUR_OF_DAY, 0);
				calendar.set(Calendar.MINUTE, 0);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				
				shedulerDate = calendar.getTime();
			}
			
			try {
				NewsletterLocalServiceUtil.editNewsletter(newsletterId, name, description, categoryId, subjectMap, articleId,
						articleGroupId, schedulerActive, schedulerType, shedulerDate);
				
				// TODO deberia ir al backUrl (al listado pero con estado?)
				actionResponse.setRenderParameter("view", "newsletterList");
				
			} catch (NewsletterArticleException e) {
				
				SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				SessionErrors.add(actionRequest, e.getClass().getName(), e);
				actionResponse.setRenderParameter("view", "editNewsletter");
				actionResponse.setRenderParameter("newsletterId", String.valueOf(newsletterId));
			}
			
		} catch (SystemException e) {
            throw new PortletException(e);
		} catch (PortalException e) {
			throw new PortletException(e);
		}
	}
	
	@ProcessAction(name = "sendNewsletter")
    public void sendNewsletter(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		
		try {
			long newsletterId = ParamUtil.getLong(actionRequest, "newsletterId");
			
			// TODO aqui habria que usar el bus para no bloquear la UI
//			Message m = new Message();
//			MessageBusUtil.sendMessage("AAA", m);
			
			Date now = new Date();
			NewsletterLocalServiceUtil.send(newsletterId, now, false);
			
			actionResponse.setRenderParameter("view", "newsletterList");
			
		} catch (SystemException e) {
            throw new PortletException(e);
		} catch (PortalException e) {
			throw new PortletException(e);
		}
	}
	
	@ProcessAction(name = "removeNewsletter")
    public void removeNewsletter(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		
		try {
			long newsletterId = ParamUtil.getLong(actionRequest, "newsletterId");
			
			NewsletterLocalServiceUtil.remove(newsletterId);
			
			actionResponse.setRenderParameter("view", "newsletterList");
			
		} catch (SystemException e) {
            throw new PortletException(e);
		} catch (PortalException e) {
			throw new PortletException(e);
		}
	}
	
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {

		try {
			
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
				
			String resourceType = ParamUtil.getString(resourceRequest, "resourceType");
			
			if (resourceType != null && resourceType.equals("newsletterPreview")) {
				
				long newsletterId = ParamUtil.getLong(resourceRequest, "newsletterId");
				String body = NewsletterLocalServiceUtil.preview(newsletterId, themeDisplay.getLanguageId(), themeDisplay);				
				resourceResponse.setContentType("text/html");
				IOUtils.write(body, resourceResponse.getPortletOutputStream());

			} else if (resourceType != null && resourceType.equals("newsletterArchive")) {
				
				long mailingSubscriptorId = ParamUtil.getLong(resourceRequest, "mailingSubscriptorId");
				String body = NewsletterLocalServiceUtil.viewArchive(mailingSubscriptorId);				
				resourceResponse.setContentType("text/html");
				IOUtils.write(body, resourceResponse.getPortletOutputStream());
				
			} else {
				throw new PortletException("Unknown resource type");	
			}
			
		} catch (SystemException e) {
			throw new PortletException(e);
		} catch (PortalException e) {
			throw new PortletException(e);
		}
	}
	
	
	/* MAILING */
	
	public void doViewMailingList(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException, SystemException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		List<Mailing> mailings = MailingLocalServiceUtil.findByCompanyIdAndGroupId(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), 0, LIMIT_RESULTS_MAX);
		int count = MailingLocalServiceUtil.countByCompanyIdAndGroupId(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId());
		
		renderRequest.setAttribute("mailings", mailings);
		renderRequest.setAttribute("count", count);
		
		renderRequest.setAttribute("mainTab", "mailingList");
		
		include(mailingListJsp, renderRequest, renderResponse);
	}

	
	public void doViewViewMailing(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException, SystemException, PortalException {

		long mailingId = ParamUtil.getLong(renderRequest, "mailingId");
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		
		Mailing mailing = MailingLocalServiceUtil.getMailing(mailingId);
		renderRequest.setAttribute("mailing", mailing);
		
		List<MailingSubscriptor> mailingSubscriptors = MailingSubscriptorLocalServiceUtil.findByMailingIdAndKeywords(mailingId, keywords, 0, LIMIT_RESULTS);
		int count = MailingSubscriptorLocalServiceUtil.countByMailingIdAndKeywords(mailingId, keywords);
		
		renderRequest.setAttribute("mailingSubscriptors", mailingSubscriptors);
		renderRequest.setAttribute("count", count);
		renderRequest.setAttribute("keywords", keywords);
		
		String backURL = ParamUtil.getString(renderRequest, "backURL");
		renderRequest.setAttribute("backURL", backURL);
		
		renderRequest.setAttribute("mainTab", "mailingList");
		
		include(mailingViewJsp, renderRequest, renderResponse);
	}
	
	/* CONFIGURATION */
	
	// El "themeDisplay.getPortletDisplay().getPortletSetup()" está mal, eran pruebas. Para obtener las preferencias correctas (en
	// nuestro caso van por groupId) en el ConfigurationActionImpl.java se hace así:
	// "PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);"
	//
	// De momento no lo borro por si en algun momento es interesante pasar la UI a las pestañas,
	// o bien hacer una logica distinta para cada propiedad (dependiendo de si se gestiona por groupId, companyId...)
	
	public void doViewConfiguration(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException, SystemException, PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	
	
		PortletPreferences preferences = themeDisplay.getPortletDisplay().getPortletSetup();
		
		Enumeration<String> names = preferences.getNames();
		
		while (names.hasMoreElements()) {			
			String key = names.nextElement();
			String value = preferences.getValue(key, "");
			_log.info("prefs: " + key + " = " + value);
		}

		renderRequest.setAttribute("preferences", preferences);
		
		renderRequest.setAttribute("mainTab", "configuration");
		
		include(configurationViewJsp, renderRequest, renderResponse);
	}
	
	// pruebas CONFIGURATION
	@ProcessAction(name = "editConfiguration")
    public void editConfiguration(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	
		String emailFromName = ParamUtil.getString(actionRequest, "emailFromName");
		String emailFromAddress = ParamUtil.getString(actionRequest, "emailFromAddress");

		PortletPreferences preferences = themeDisplay.getPortletDisplay().getPortletSetup();
		
//        preferences.setValue("emailFromName", emailFromName);
//        preferences.setValue("emailFromAddress", emailFromAddress);
//        preferences.store();
		
		actionResponse.setRenderParameter("view", "configuration");		
	}
	
	
	/* UTIL */
	private List<JournalArticle> getArticles(ThemeDisplay themeDisplay) throws PortalException, SystemException {
		
		// TODO filtrar articulos, por groupId, companyId, tag, category, articleType, estructuras?
		List<JournalArticle> articles = new ArrayList<JournalArticle>();
		
		String tagName = NewsletterConstants.JOURNAL_ARTICLE_TAG_NAME;
		
		List<Long> tagIdsList = new ArrayList<Long>(); 
		try {
			AssetTag assetTag = AssetTagLocalServiceUtil.getTag(themeDisplay.getScopeGroupId(), tagName);
			tagIdsList.add(assetTag.getTagId());
		} catch (NoSuchTagException e) {
			_log.warn("tag newsletter not created");
		}
		try {
			AssetTag assetTagGlobal = AssetTagLocalServiceUtil.getTag(themeDisplay.getCompany().getGroupId(), tagName);
			tagIdsList.add(assetTagGlobal.getTagId());
		} catch (NoSuchTagException e) {
			_log.warn("global tag newsletter not created");
		}
		
		long[] tagIds = new long[tagIdsList.size()];
		for (int i = 0; i < tagIdsList.size(); i++) {
			tagIds[i] = tagIdsList.get(i);
		}
		
		AssetEntryQuery query = new AssetEntryQuery();
		query.setAnyTagIds(tagIds);
		query.setClassName(JournalArticle.class.getName());
		
		List<AssetEntry> assetEntries = AssetEntryLocalServiceUtil.getEntries(query);
		for (AssetEntry assetEntry : assetEntries) {
			try {
				JournalArticle article = JournalArticleLocalServiceUtil.getLatestArticle(assetEntry.getClassPK(), WorkflowConstants.STATUS_APPROVED);
					if (article != null) {
						articles.add(article);
					} else {
						_log.warn("no approved article found");
					}
			} catch (NoSuchArticleException e) {
				_log.warn("no approved article found");
			}
					
		}
		
		return articles;
	}
	
}