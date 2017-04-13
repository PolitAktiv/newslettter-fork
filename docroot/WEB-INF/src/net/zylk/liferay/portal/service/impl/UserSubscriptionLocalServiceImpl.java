package net.zylk.liferay.portal.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.PortletPreferences;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Ticket;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.SubscriptionSender;
import com.liferay.util.ContentUtil;

import net.zylk.liferay.portal.TicketInvalidException;
import net.zylk.liferay.portal.model.CoreConstants;
import net.zylk.liferay.portal.model.Subscriptor;
import net.zylk.liferay.portal.model.util.SubscriptionExtraInfo;
import net.zylk.liferay.portal.service.base.UserSubscriptionLocalServiceBaseImpl;
import net.zylk.liferay.portal.util.ConfigUtil;
import net.zylk.liferay.portal.util.EmailUtil;

public class UserSubscriptionLocalServiceImpl extends UserSubscriptionLocalServiceBaseImpl {
	

	private static final int TICKET_TYPE_SUBSCRIPTION = 60;
	
	public static Log _log = LogFactoryUtil.getLog(UserSubscriptionLocalServiceImpl.class);
	
	
	public void requestSubscription(long companyId, long groupId, String name, String surname, String email, String languageId, long[] categoryIds) throws SystemException, PortalException {

		EmailUtil.validateEmail(email);
	
		String url = generateSubscriptionUrl(companyId, groupId, name, surname, email, languageId, categoryIds);

		String fullName = "";
		if (name != null && !name.equals("")) {
			fullName += name;
		}
		if (surname != null && !surname.equals("")) {
			fullName += " " + surname;
		}
		
		String fromName = ConfigUtil.getValue(ConfigUtil.KEY_EMAIL_FROM_NAME, companyId, groupId);
		String fromAddress = ConfigUtil.getValue(ConfigUtil.KEY_EMAIL_FROM_ADDRESS, companyId, groupId);
		String toAddress = email;
		String toName = fullName;
		if (toName.equals("")) {
			toName = email;
		}
		
		String subject = ConfigUtil.getValue(ConfigUtil.KEY_TEMPLATE_SUBSCRIPTION_SUBJECT, companyId, groupId);
		String body = ConfigUtil.getValue(ConfigUtil.KEY_TEMPLATE_SUBSCRIPTION_BODY, companyId, groupId);
		
		// envio del email
		SubscriptionSender subscriptionSender = new SubscriptionSender();
		subscriptionSender.setBody(body);
		subscriptionSender.setCompanyId(companyId);
		subscriptionSender.setContextAttributes(
				"[$SUBSCRIPTION_URL$]", url, 
				"[$SUBSCRIPTOR_NAME$]", name,
				"[$SUBSCRIPTOR_SURNAME$]", surname,
				"[$SUBSCRIPTOR_FULLNAME$]", fullName,
				"[$SUBSCRIPTOR_EMAIL$]", email
				);
		// faltan mas "tokens" aqui: portalUrl, siteName..., aunque al poderse personalizar por site se puede configurar todo
		// a mano. Por tanto de momento lo dejo así.
		subscriptionSender.setFrom(fromAddress, fromName);
		subscriptionSender.setHtmlFormat(true);
		subscriptionSender.setMailId("zn_subscription", email + System.currentTimeMillis());
		subscriptionSender.setServiceContext(null);
		subscriptionSender.setSubject(subject);
		subscriptionSender.addRuntimeSubscribers(toAddress, toName);

		subscriptionSender.flushNotificationsAsync();
		
	}
	
	public Subscriptor confirmSubscription(String ticketKey) throws SystemException, PortalException {

		Ticket ticket = validateTicket(ticketKey);
		if (ticket != null) {
			long companyId = ticket.getCompanyId();
			
			SubscriptionExtraInfo subscriptionExtraInfo = (SubscriptionExtraInfo)JSONFactoryUtil.looseDeserialize(ticket.getExtraInfo(), SubscriptionExtraInfo.class);
			long groupId = subscriptionExtraInfo.getGroupId();
			String email = subscriptionExtraInfo.getEmail();
			String name = subscriptionExtraInfo.getName();
			String surname = subscriptionExtraInfo.getSurname();
			String languageId = subscriptionExtraInfo.getLanguageId();
			long[] categoryIds = subscriptionExtraInfo.getCategories();
			
			Subscriptor subscriptor = subscriptorLocalService.findByEmailAndCompanyIdAndGroupId(companyId, groupId, email);
			
			if (subscriptor == null) { // nuevo subscriptor (email)
				
				subscriptor = subscriptorLocalService.addSubscriptor(companyId, groupId, name, surname, email, languageId, categoryIds, true);
				
			} else { // update datos
				
				subscriptor = subscriptorLocalService.editSubscriptor(subscriptor.getSubscriptorId(), name, surname, email, languageId, categoryIds);
			}
			
			ticketLocalService.deleteTicket(ticket.getTicketId());
			
			return subscriptor;
			
		} else {
			throw new TicketInvalidException();
		}
	}
	
	public Subscriptor confirmUnsubscription(String uuid) throws SystemException, PortalException {

		Subscriptor subscriptor = subscriptorLocalService.findByUuid(uuid);
		
		subscriptorLocalService.remove(subscriptor.getSubscriptorId());
		
		return subscriptor;
	}
	
	private String generateSubscriptionUrl(long companyId, long groupId, String name, String surname, String email, String languageId, long[] categoryIds) throws SystemException, PortalException {

		// crear ticket
		SubscriptionExtraInfo subscriptionExtraInfo = new SubscriptionExtraInfo();
		subscriptionExtraInfo.setGroupId(groupId);
		subscriptionExtraInfo.setEmail(email);
		subscriptionExtraInfo.setName(name);
		subscriptionExtraInfo.setSurname(surname);
		subscriptionExtraInfo.setLanguageId(languageId);
		subscriptionExtraInfo.setCategories(categoryIds);
		String extraInfo = JSONFactoryUtil.looseSerialize(subscriptionExtraInfo);
		
		String className = null;
		long classPK = 0;
		int type = TICKET_TYPE_SUBSCRIPTION;
		Date expirationDate = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(expirationDate);
        cal.add(Calendar.MONTH, 3);
        expirationDate = cal.getTime();
        ServiceContext serviceContext = null;
			
		Ticket ticket = ticketLocalService.addTicket(companyId, className, classPK, type, extraInfo, expirationDate, serviceContext);
		
		// create portalURL from company
		Company company = CompanyLocalServiceUtil.getCompany(companyId);
		String portalUrl = PortalUtil.getPortalURL(company.getVirtualHostname(), PortalUtil.getPortalPort(true), true);
		
		//String portalUrl = ConfigUtil.getValue(ConfigUtil.KEY_PORTAL_BASE_URL, companyId, groupId);
		String url = portalUrl + "/delegate/subscription?ticketKey=" + ticket.getKey() + "&groupId=" + groupId + "&companyId=" + companyId;

		return url;
	}
	
	public String generateUnsubscriptionUrl(long companyId, long groupId, String uuid) throws SystemException {
		

		// create portalURL from company
		Company company = null;
		try {
			company = CompanyLocalServiceUtil.getCompany(companyId);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		String portalUrl = PortalUtil.getPortalURL(company.getVirtualHostname(), PortalUtil.getPortalPort(true), true);
		
		//String portalUrl = ConfigUtil.getValue(ConfigUtil.KEY_PORTAL_BASE_URL, companyId, groupId);
		String url = portalUrl + "/delegate/unsubscription?uuid=" + uuid + "&groupId=" + groupId + "&companyId=" + companyId;
		
		return url;
	}
	
	public Ticket validateTicket(String ticketKey) {

		try {
			Ticket ticket = ticketLocalService.getTicket(ticketKey);
			if (!ticket.isExpired()) {
				return ticket;
			} else {
				ticketLocalService.deleteTicket(ticket);
				return null;
			}
		} catch (Exception e) {
			return null;
		}

	}
	
	
}