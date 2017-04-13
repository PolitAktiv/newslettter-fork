package net.zylk.liferay.portlet.user_subscription.controller;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import net.zylk.liferay.portal.EmptyCategoryListException;
import net.zylk.liferay.portal.InvalidEmailException;
import net.zylk.liferay.portal.model.Category;
import net.zylk.liferay.portal.model.Subscriptor;
import net.zylk.liferay.portal.service.CategoryLocalServiceUtil;
import net.zylk.liferay.portal.service.SubscriptorLocalServiceUtil;
import net.zylk.liferay.portal.service.UserSubscriptionLocalServiceUtil;
import net.zylk.liferay.portal.util.EmailUtil;
import net.zylk.liferay.portal.util.ThemeDisplayHelper;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class UserSubscriptionPortlet extends MVCPortlet {

	public static Log _log = LogFactoryUtil.getLog(UserSubscriptionPortlet.class);

	
	public static final String requestSubscriptionJsp = "/jsp/portlet/user_subscription/request-subscription.jsp";
	public static final String requestSubscriptionOkJsp = "/jsp/portlet/user_subscription/request-subscription-ok.jsp";
	public static final String requestSubscriptionAskJsp = "/jsp/portlet/user_subscription/request-subscription-ask.jsp";

	
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		try {
			String view = ParamUtil.getString(renderRequest, "view");
			renderRequest.setAttribute("view", view);
			
			if (view == null || view.equals("")) {
				doViewRequestSubscription(renderRequest, renderResponse);
			} else if (view.equals("addSubscriptor")) {
				doViewRequestSubscription(renderRequest, renderResponse);
			} else if (view.equals("addSubscriptorAsk")) {
				doViewRequestSubscriptionAsk(renderRequest, renderResponse);
			} else if (view.equals("addSubscriptorOk")) {
				doViewRequestSubscriptionOk(renderRequest, renderResponse);
			}
			
		} catch (PortalException e) {
			throw new PortletException(e);
		} catch (SystemException e) {
			throw new PortletException(e);
		}
	}

	
	public void doViewRequestSubscription(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException, SystemException, PortalException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
//		ThemeDisplayHelper.print(themeDisplay);
		
		String name = ParamUtil.getString(renderRequest, "name");
		String surname = ParamUtil.getString(renderRequest, "surname");
		String email = ParamUtil.getString(renderRequest, "email");
		
		List<Category> categories = CategoryLocalServiceUtil.findByCompanyIdAndGroupId(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId());
		renderRequest.setAttribute("categories", categories);
		
		renderRequest.setAttribute("name", name);
		renderRequest.setAttribute("surname", surname);
		renderRequest.setAttribute("email", email);
		
		include(requestSubscriptionJsp, renderRequest, renderResponse);
	}
	
	public void doViewRequestSubscriptionAsk(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException, SystemException, PortalException {

		String name = ParamUtil.getString(renderRequest, "name");
		String surname = ParamUtil.getString(renderRequest, "surname");
		String email = ParamUtil.getString(renderRequest, "email");
		String languageId = ParamUtil.getString(renderRequest, "languageId");
		String categoryIdsString = ParamUtil.getString(renderRequest, "categoryIdsString");
		
		renderRequest.setAttribute("name", name);
		renderRequest.setAttribute("surname", surname);
		renderRequest.setAttribute("email", email);
		renderRequest.setAttribute("languageId", languageId);
		renderRequest.setAttribute("categoryIdsString", categoryIdsString);
		
		include(requestSubscriptionAskJsp, renderRequest, renderResponse);
	}
	
	public void doViewRequestSubscriptionOk(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException, SystemException, PortalException {

		include(requestSubscriptionOkJsp, renderRequest, renderResponse);
	}
	
	@ProcessAction(name = "requestSubscription")
    public void requestSubscription(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			String name = ParamUtil.getString(actionRequest, "name");
			String surname = ParamUtil.getString(actionRequest, "surname");
			String email = ParamUtil.getString(actionRequest, "email");
			long[] categoryIds = ParamUtil.getLongValues(actionRequest, "categoryIdsCheckbox");
			
			// TODO un select a la UI??
			String languageId = themeDisplay.getLanguageId();
			
			try {
				
				// validacion email
				EmailUtil.validateEmail(email);
				
				// validacion categorias
				if (categoryIds == null || categoryIds.length == 0) {
					throw new EmptyCategoryListException();
				}
				
				Subscriptor subscriptor = SubscriptorLocalServiceUtil.findByEmailAndCompanyIdAndGroupId(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), email);
				
				if (subscriptor == null) {
		            
					UserSubscriptionLocalServiceUtil.requestSubscription(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), name, surname, email, languageId, categoryIds);
					actionResponse.setRenderParameter("view", "addSubscriptorOk");
					
				} else {
	
					String categoryIdsString = StringUtils.join(ArrayUtils.toObject(categoryIds), ",");
					
					actionResponse.setRenderParameter("categoryIdsString", categoryIdsString);
					actionResponse.setRenderParameter("name", name);
					actionResponse.setRenderParameter("surname", surname);
					actionResponse.setRenderParameter("email", email);
					actionResponse.setRenderParameter("languageId", languageId);
					
					actionResponse.setRenderParameter("view", "addSubscriptorAsk");
				}
				
			}  catch (InvalidEmailException e) {
					
				SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				SessionErrors.add(actionRequest, e.getClass().getName(), e);
				
				actionResponse.setRenderParameter("view", "addSubscriptor");
				actionResponse.setRenderParameter("name", name);
				actionResponse.setRenderParameter("surname", surname);
				actionResponse.setRenderParameter("email", email);
				
			} catch (EmptyCategoryListException e) {
				
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
	
	@ProcessAction(name = "requestSubscriptionConfirm")
    public void requestSubscriptionConfirm(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			String name = ParamUtil.getString(actionRequest, "name");
			String surname = ParamUtil.getString(actionRequest, "surname");
			String email = ParamUtil.getString(actionRequest, "email");
			String categoryIdsString = ParamUtil.getString(actionRequest, "categoryIdsString");
			String languageId = ParamUtil.getString(actionRequest, "languageId");
			
			String[] s = StringUtil.split(categoryIdsString, ",");
			long[] categoryIds = new long[s.length];
			for (int i = 0; i < s.length; i++) {
				categoryIds[i] = Long.valueOf(s[i]);
			}
			
	        UserSubscriptionLocalServiceUtil.requestSubscription(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), name, surname, email, languageId, categoryIds);
			
	        actionResponse.setRenderParameter("view", "addSubscriptorOk");
	        
		} catch (SystemException e) {
            throw new PortletException(e);
		} catch (PortalException e) {
			throw new PortletException(e);
		}
	}
	
}




