package net.zylk.liferay.portlet.subscription.controller;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import net.zylk.liferay.portal.TicketInvalidException;
import net.zylk.liferay.portal.model.Subscriptor;
import net.zylk.liferay.portal.service.SubscriptorLocalServiceUtil;
import net.zylk.liferay.portal.service.UserSubscriptionLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class SubscriptionPortlet extends MVCPortlet {

	public static Log _log = LogFactoryUtil.getLog(SubscriptionPortlet.class);
	
	public static final String viewJsp = "/jsp/portlet/subscription/view.jsp";
	public static final String subscriptionOkJsp = "/jsp/portlet/subscription/subscription-ok.jsp";
	public static final String subscriptionErrorJsp = "/jsp/portlet/subscription/subscription-error.jsp";
	public static final String unsubscriptionAskJsp = "/jsp/portlet/subscription/unsubscription-ask.jsp";
	public static final String unsubscriptionOkJsp = "/jsp/portlet/subscription/unsubscription-ok.jsp";
	public static final String unsubscriptionErrorJsp = "/jsp/portlet/subscription/unsubscription-error.jsp";


	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		try {
			String view = ParamUtil.getString(renderRequest, "view");
			renderRequest.setAttribute("view", view);
			
			if (view == null || view.equals("")) {
				doViewDefault(renderRequest, renderResponse);
			} else if (view.equals("subscriptionOk")) {
				doViewSubscriptionOk(renderRequest, renderResponse);
			} else if (view.equals("subscriptionError")) {
				doViewSubscriptionError(renderRequest, renderResponse);
			} else if (view.equals("unsubscriptionAsk")) {
				doViewUnsubscriptionAsk(renderRequest, renderResponse);
			} else if (view.equals("unsubscriptionOk")) {
				doViewUnsubscriptorOk(renderRequest, renderResponse);
			}
			
		} catch (PortalException e) {
			throw new PortletException(e);
		} catch (SystemException e) {
			throw new PortletException(e);
		}
	}

	public void doViewDefault(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException, SystemException, PortalException {
		
		include(viewJsp, renderRequest, renderResponse);
	}
	
	public void doViewSubscriptionOk(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException, SystemException, PortalException {

		include(subscriptionOkJsp, renderRequest, renderResponse);
	}
	
	public void doViewSubscriptionError(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException, SystemException, PortalException {

		include(subscriptionErrorJsp, renderRequest, renderResponse);
	}
	
	public void doViewUnsubscriptionAsk(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException, SystemException, PortalException {

		String uuid = ParamUtil.getString(renderRequest, "uuid");
		Subscriptor subscriptor = SubscriptorLocalServiceUtil.findByUuid(uuid);
		
		if (subscriptor != null) {
			
			renderRequest.setAttribute("uuid", uuid);
			
			include(unsubscriptionAskJsp, renderRequest, renderResponse);
		
		} else {
			include(unsubscriptionErrorJsp, renderRequest, renderResponse);
		}
	}
	
	public void doViewUnsubscriptorOk(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException, SystemException, PortalException {

		include(unsubscriptionOkJsp, renderRequest, renderResponse);
	}

	@ProcessAction(name = "confirmSubscription")
    public void confirmSubscription(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		
		try {
			String ticketKey = ParamUtil.getString(actionRequest, "ticketKey");

			try {
				Subscriptor subscriptor = UserSubscriptionLocalServiceUtil.confirmSubscription(ticketKey);
				actionResponse.setRenderParameter("view", "subscriptionOk");
				
			} catch (TicketInvalidException e) {
				
				actionResponse.setRenderParameter("view", "subscriptionError");
			}
			
		} catch (PortalException e) {
            throw new PortletException(e);
		} catch (SystemException e) {
			throw new PortletException(e);
		}
	}
	
	@ProcessAction(name = "confirmUnsubscription")
    public void confirmUnsubscription(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		
		try {
			String uuid = ParamUtil.getString(actionRequest, "uuid");

			UserSubscriptionLocalServiceUtil.confirmUnsubscription(uuid);
			
			actionResponse.setRenderParameter("view", "unsubscriptionOk");
			
		} catch (PortalException e) {
            throw new PortletException(e);
		} catch (SystemException e) {
			throw new PortletException(e);
		}
	}
	
}




