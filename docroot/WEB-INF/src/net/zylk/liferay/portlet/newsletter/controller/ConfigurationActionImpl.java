package net.zylk.liferay.portlet.newsletter.controller;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import net.zylk.liferay.portal.InvalidEmailException;
import net.zylk.liferay.portal.model.CoreConstants;
import net.zylk.liferay.portal.util.ConfigUtil;
import net.zylk.liferay.portal.util.EmailUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class ConfigurationActionImpl implements ConfigurationAction {
	
	private static Log _log = LogFactoryUtil.getLog(ConfigurationActionImpl.class);

	public String render(PortletConfig config, RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
		
		String view = ParamUtil.getString(renderRequest, "view");
		
		if (view == null || view.equals("")) {
		
			return "/jsp/portlet/newsletter/configuration/configuration.jsp";
			
		} else if (view.equals("emailTemplateConfig")) {
			
			return "/jsp/portlet/newsletter/configuration/email-template.jsp";
		}
		
		return "/jsp/portlet/newsletter/configuration/configuration.jsp";
	}
	
	public void processAction(PortletConfig config, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		String actionType = ParamUtil.getString(actionRequest, "actionType");
		
		if (actionType != null && actionType.equals("saveGeneralConfig")) {
		
			saveGeneralConfig(config, actionRequest, actionResponse);			
			
		} else if (actionType != null && actionType.equals("saveEmailTemplateConfig")) {
			
			saveEmailTemplateConfig(config, actionRequest, actionResponse);						
		}
		
	}
	
	public void saveGeneralConfig(PortletConfig config, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String portalBaseUrl = ParamUtil.getString(actionRequest, "portalBaseUrl");
		String emailFromName = ParamUtil.getString(actionRequest, "emailFromName");
		String emailFromAddress = ParamUtil.getString(actionRequest, "emailFromAddress");

		try {
			if (emailFromAddress != null && !emailFromAddress.equals("")) {
				EmailUtil.validateEmail(emailFromAddress);
			}

			// Como parece que en la 6.2 no funcionan bien las preferencias por site (owned-by-group) las cargamos de forma explicita.
			// 1
//			String portletResource = ParamUtil.getString(actionRequest, "portletResource");
//			PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
			// 2
//	        PortletPreferences prefs = actionRequest.getPreferences();
			
			// 3
			long companyId = themeDisplay.getCompanyId();
			long ownerId = themeDisplay.getScopeGroupId();
			int ownerType = PortletKeys.PREFS_OWNER_TYPE_GROUP;
			long plid = 0;
			String portletId = CoreConstants.PORTLET_ID_ADMIN;
			PortletPreferences prefs = PortletPreferencesLocalServiceUtil.getPreferences(companyId, ownerId, ownerType, plid,
					portletId);

			prefs.setValue(ConfigUtil.KEY_PORTAL_BASE_URL, portalBaseUrl);
			prefs.setValue(ConfigUtil.KEY_EMAIL_FROM_NAME, emailFromName);
			prefs.setValue(ConfigUtil.KEY_EMAIL_FROM_ADDRESS, emailFromAddress);
	
			prefs.store();
	
			SessionMessages.add(actionRequest, config.getPortletName() + ".doConfigure");
			
			String successMessage = ParamUtil.getString(actionRequest, "successMessage");
			SessionMessages.add(actionRequest, "request_processed", successMessage);
			
			actionResponse.setRenderParameter("view", "generalConfig");
			
		}  catch (InvalidEmailException e) {
			
			SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			SessionErrors.add(actionRequest, e.getClass().getName(), e);
		}
	}
	
	public void saveEmailTemplateConfig(PortletConfig config, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String templateSubscriptionBody = ParamUtil.getString(actionRequest, "templateSubscriptionBody");
		String templateSubscriptionSubject = ParamUtil.getString(actionRequest, "templateSubscriptionSubject");
	
		// Como parece que en la 6.2 no funcionan bien las preferencias por site (owned-by-group) las cargamos de forma explicita.
//		String portletResource = ParamUtil.getString(actionRequest, "portletResource");
//		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
		
		long companyId = themeDisplay.getCompanyId();
		long ownerId = themeDisplay.getScopeGroupId();
		int ownerType = PortletKeys.PREFS_OWNER_TYPE_GROUP;
		long plid = 0;
		String portletId = CoreConstants.PORTLET_ID_ADMIN;
		PortletPreferences prefs = PortletPreferencesLocalServiceUtil.getPreferences(companyId, ownerId, ownerType, plid,
				portletId);

		prefs.setValue(ConfigUtil.KEY_TEMPLATE_SUBSCRIPTION_BODY, templateSubscriptionBody);
		prefs.setValue(ConfigUtil.KEY_TEMPLATE_SUBSCRIPTION_SUBJECT, templateSubscriptionSubject);

		prefs.store();

		SessionMessages.add(actionRequest, config.getPortletName() + ".doConfigure");
		
		String successMessage = ParamUtil.getString(actionRequest, "successMessage");
		SessionMessages.add(actionRequest, "request_processed", successMessage);
		
		actionResponse.setRenderParameter("view", "emailTemplateConfig");
	}

}
