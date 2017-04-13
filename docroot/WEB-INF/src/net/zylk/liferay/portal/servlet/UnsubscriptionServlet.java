package net.zylk.liferay.portal.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.zylk.liferay.portal.model.CoreConstants;
import net.zylk.liferay.portal.model.Subscriptor;
import net.zylk.liferay.portal.model.util.SubscriptionExtraInfo;
import net.zylk.liferay.portal.service.SubscriptorLocalServiceUtil;
import net.zylk.liferay.portal.util.ConfigUtil;
import net.zylk.liferay.portal.util.ThemeDisplayHelper;
import net.zylk.liferay.portlet.subscription.util.SubscriptionPortletUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Ticket;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.TicketLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

/**
 * url de jemeplo:
 * 
 * /delegate/unsubscription?ticketKey=2323w23
 *
 */
public class UnsubscriptionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static Log _log = LogFactoryUtil.getLog(UnsubscriptionServlet.class);

	
	public void init() throws ServletException {
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {			
			_log.info("pasando por el unsubscription Servlet");
		
			String uuid = ParamUtil.getString(request, "uuid");
			long companyId = ParamUtil.getLong(request, "companyId");
			long groupId = ParamUtil.getLong(request, "groupId");
			Group group = GroupLocalServiceUtil.getGroup(groupId);
			Layout layout = SubscriptionPortletUtil.getPortletLayout(companyId, groupId);	
			
			// Obtencion del language
			String languagePath = "";
			Subscriptor subscriptor = SubscriptorLocalServiceUtil.findByUuid(uuid);
			if (subscriptor != null) {
				String languageId = subscriptor.getLanguageId();
				String[] languageIdParts = StringUtil.split(languageId, CharPool.UNDERLINE);
				String languageCode = languageIdParts[0];
				languagePath = "/" + languageCode;
			}
			
			String url = "";
			
			// 1- en caso que tenga virtualHost no habria que añadir esto? y el idioma? (sin themeDisplay no es sencillo). De
			// todas formas creo que liferay hace un redirect así que esta ok.
//			String portalUrl = ConfigUtil.getValue(ConfigUtil.KEY_PORTAL_BASE_URL, companyId, groupId);
//			String portalUrl = PortalUtil.getPortalURL(request);
			
			url += PortalUtil.getPortalURL(request);
			// TODO tener en cuenta la configuracion del i18n de liferay, para utilizar el prefijo en la url o las cookies
			url += languagePath;
			if (layout.getLayoutSet().isPrivateLayout()) {
				url += PortalUtil.getPathFriendlyURLPrivateGroup();
			} else {
				url += PortalUtil.getPathFriendlyURLPublic();
			}
			url += group.getFriendlyURL();
			url += layout.getFriendlyURL();

			// 2- pruebas con themeDisplay
//			ThemeDisplay themeDisplay = ThemeDisplayHelper.create(request);
//			String layoutUrl = PortalUtil.getLayoutURL(layout, themeDisplay);
//			url += layoutUrl;
			
			
			url += "/-/subscription/unsubscribe?";
			url += "_" + CoreConstants.PORTLET_ID_SUBSCRIPTION + "_uuid=" + uuid;
			
			_log.info("redirigiendo a la url: " + url);	
			
			response.sendRedirect(url);
		
		} catch (SystemException e) {
			throw new ServletException(e);
		} catch (PortalException e) {
			throw new ServletException(e);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}

}