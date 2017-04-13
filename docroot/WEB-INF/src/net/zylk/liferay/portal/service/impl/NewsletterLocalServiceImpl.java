package net.zylk.liferay.portal.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import net.zylk.liferay.portal.CancelMailingException;
import net.zylk.liferay.portal.EmptyFieldException;
import net.zylk.liferay.portal.NewsletterArticleException;
import net.zylk.liferay.portal.model.Mailing;
import net.zylk.liferay.portal.model.MailingConstants;
import net.zylk.liferay.portal.model.MailingLang;
import net.zylk.liferay.portal.model.MailingSubscriptor;
import net.zylk.liferay.portal.model.Newsletter;
import net.zylk.liferay.portal.model.NewsletterConstants;
import net.zylk.liferay.portal.model.Subscriptor;
import net.zylk.liferay.portal.model.impl.SubscriptorImpl;
import net.zylk.liferay.portal.model.util.TokensData;
import net.zylk.liferay.portal.service.base.NewsletterLocalServiceBaseImpl;
import net.zylk.liferay.portal.util.ConfigUtil;
import net.zylk.liferay.portal.util.MailHandler;
import net.zylk.liferay.portal.util.ThemeDisplayHelper;
//import net.zylk.liferay.portlet.newsletter.journal.ModifiedJournalArticleTransformer;


import net.zylk.liferay.portlet.newsletter.journal.JournalContentCustomUtil;

import org.apache.commons.lang.StringUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journalcontent.util.JournalContentUtil;

/**
 * The implementation of the newsletter local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link net.zylk.liferay.portal.service.NewsletterLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author zylk.net
 * @see net.zylk.liferay.portal.service.base.NewsletterLocalServiceBaseImpl
 * @see net.zylk.liferay.portal.service.NewsletterLocalServiceUtil
 */
public class NewsletterLocalServiceImpl extends NewsletterLocalServiceBaseImpl {
	
	
	public static Log _log = LogFactoryUtil.getLog(NewsletterLocalServiceImpl.class);
	
	
	public Newsletter addNewsletter(long companyId, long groupId, String name, String description, long categoryId,
			Map<Locale, String> subjectMap, String articleId, long articleGroupId, boolean schedulerActive, int schedulerType, Date schedulerDate)
			throws SystemException, PortalException {

		validateNewsletter(name, categoryId, subjectMap, articleId);
		
        long id = counterLocalService.increment(Newsletter.class.getName());
        Newsletter newsletter = newsletterPersistence.create(id);
        newsletter.setCompanyId(companyId);
        newsletter.setGroupId(groupId);
        newsletter.setCreateDate(new Date());
        newsletter.setModifiedDate(new Date());
        newsletter.setName(name);
        newsletter.setDescription(description);
        newsletter.setCategoryId(categoryId);
        newsletter.setSubjectMap(subjectMap);
        newsletter.setArticleId(articleId);
        newsletter.setArticleGroupId(articleGroupId);
        newsletter.setSchedulerActive(schedulerActive);
        newsletter.setSchedulerType(schedulerType);
        newsletter.setSchedulerDate(schedulerDate);
        newsletter = newsletterPersistence.update(newsletter, false);
        
        return newsletter;
	}
	
	public Newsletter editNewsletter(long newsletterId, String name, String description, long categoryId, Map<Locale, String> subjectMap,
			String articleId, long articleGroupId, boolean schedulerActive, int schedulerType, Date schedulerDate) throws SystemException,
			PortalException {
		
		validateNewsletter(name, categoryId, subjectMap, articleId);

		Newsletter newsletter = newsletterPersistence.findByPrimaryKey(newsletterId);
        newsletter.setModifiedDate(new Date());
		newsletter.setName(name);
        newsletter.setDescription(description);
        newsletter.setCategoryId(categoryId);
        newsletter.setSubjectMap(subjectMap);
        newsletter.setArticleId(articleId);
        newsletter.setArticleGroupId(articleGroupId);
        newsletter.setSchedulerActive(schedulerActive);
        newsletter.setSchedulerType(schedulerType);
        newsletter.setSchedulerDate(schedulerDate);
        newsletter = newsletterPersistence.update(newsletter, false);
        
        return newsletter;
	}
	
	private void validateNewsletter(String name, long categoryId, Map<Locale, String> subjectMap, String articleId) throws PortalException, SystemException {
		
		if (name == null || name.equals("")) {
			throw new EmptyFieldException("name can not be null");
		}
		// Validar el subjectMap??
		if (articleId == null || articleId.equals("")) {
			throw new NewsletterArticleException();
		}
	}

	public void remove(long newsletterId) throws SystemException, PortalException {

		newsletterPersistence.remove(newsletterId);
	}
	
	public List<Newsletter> findAll() throws SystemException {
		
		return newsletterPersistence.findAll();
	}
	
	public List<Newsletter> findByCompanyIdAndGroupId(long companyId, long groupId, int start, int end) throws SystemException {
		
		return newsletterPersistence.findByCompanyIdAndGroupId(companyId, groupId, start, end);
	}
	
	public int countByCompanyIdAndGroupId(long companyId, long groupId) throws SystemException {
		
		return newsletterPersistence.countByCompanyIdAndGroupId(companyId, groupId);
	}
	
	
	/**
	 * El themeDisplay no es necesario pero lo mantengo para pruebas.
	 */
	public String preview(long newsletterId, String languageId, ThemeDisplay themeDisplay) throws SystemException, PortalException {
		
		Newsletter newsletter = newsletterPersistence.findByPrimaryKey(newsletterId);
		
		Subscriptor subscriptorFake = new SubscriptorImpl();
		subscriptorFake.setName("John");
		subscriptorFake.setSurname("William");
		subscriptorFake.setEmail("john@gmail.com");
		
		Date startDate = new Date();
		
		Map<String,String> tokensNewsletter = calculateNewsletterTokens(newsletter, startDate);
		String body = processTemplate(newsletter, startDate, tokensNewsletter, languageId, null);
		Map<String,String> tokensSubscriptor = calculateSubscriptorTokens(newsletter, subscriptorFake, startDate);
		// el link de unsubscribe no se muestra en la pre-visualizacion.
		tokensSubscriptor.put(TokensData.KEY_UNSUBSCRIBE_URL, "");
		body = replaceTokens(body, tokensSubscriptor);
		
		return body;
	}
	
	public String viewOnline(long uuid, long mailingId) throws SystemException, PortalException {
		
		// funcion para la opcion "view online" (en un futuro)
		return null;
	}
	
	public String viewArchive(long mailingSubscriptorId) throws SystemException, PortalException {
	
		MailingSubscriptor mailingSubscriptor = mailingSubscriptorLocalService.getMailingSubscriptor(mailingSubscriptorId);
		MailingLang mailingLang = mailingLangLocalService.findByMailingIdAndLanguageId(mailingSubscriptor.getMailingId(), mailingSubscriptor.getLanguageId());
		
		TokensData tokensData = (TokensData)JSONFactoryUtil.looseDeserialize(mailingSubscriptor.getTokens(), TokensData.class);
		// el link de unsubscribe no se muestra en el visualizacion archivada.
		tokensData.getTokens().put(TokensData.KEY_UNSUBSCRIBE_URL, "");
		String body = replaceTokens(mailingLang.getEmailBodyPre(), tokensData.getTokens());
		
		return body;
	}
	
	public void send(long newsletterId, Date startDate, boolean isScheduled) throws SystemException, PortalException {
	
		Newsletter newsletter = newsletterPersistence.findByPrimaryKey(newsletterId);
	
		Date fromDate = calculateFromDate(newsletter, startDate);
		
		String mailFromName = ConfigUtil.getValue(ConfigUtil.KEY_EMAIL_FROM_NAME, newsletter.getCompanyId(), newsletter.getGroupId());
		String mailFromAddress = ConfigUtil.getValue(ConfigUtil.KEY_EMAIL_FROM_ADDRESS, newsletter.getCompanyId(), newsletter.getGroupId());
		
		Map<String,String> tokensNewsletter = calculateNewsletterTokens(newsletter, startDate);
		
		Mailing mailing = mailingLocalService.startMailing(newsletter.getCompanyId(), newsletter.getGroupId(), newsletterId,
				newsletter.getName(), mailFromName, mailFromAddress, startDate, fromDate, isScheduled);
		
		int totalSubscriptors = subscriptorLocalService.countByCategoryId(newsletter.getCategoryId());
		_log.debug("totalSubscriptors: " + totalSubscriptors);
		
		int emailCount = 0;
		
		MailHandler mailHandler = new MailHandler();
		mailHandler.openConnection();
		
		try {
			Map<String, String> langBodyMap = new HashMap<String, String>();
			
			// La query se hace en bloques de 10000 porque en las custom querys el start y end parecen obligatorios. 
			// Y ademas por tema de rendmiento tiene que estar hecho asi (ya que puede llegar a haber muchos suscriptores).
			int DELTA = 10000;
			int start = 0;
			int end = start + DELTA;
			if (end > totalSubscriptors) {
				end = totalSubscriptors;
			}
			_log.debug("start init: " + start);
			_log.debug("end init: " + end);
			
			while (start < totalSubscriptors) {
				
				List<Subscriptor> subscriptors = subscriptorLocalService.findByCategoryId(newsletter.getCategoryId(), start, end);
				
				start = start + DELTA;
				end = start + DELTA;
				if (end > totalSubscriptors) {
					end = totalSubscriptors;
				}
				_log.debug("start loop: " + start);
				_log.debug("end loop: " + end);
				
				for (Subscriptor subscriptor : subscriptors) {
					
					String bodyPre = langBodyMap.get(subscriptor.getLanguageId());
					if (bodyPre == null) {
						bodyPre = processTemplate(newsletter, startDate, tokensNewsletter, subscriptor.getLanguageId(), null);
						mailingLangLocalService.addMailingLang(mailing.getMailingId(), subscriptor.getLanguageId(), newsletter.getSubject(subscriptor.getLanguageId()), bodyPre);
						langBodyMap.put(subscriptor.getLanguageId(), bodyPre);
					}
					
					Map<String,String> tokens = calculateSubscriptorTokens(newsletter, subscriptor, startDate);
					tokens.putAll(tokensNewsletter);
					String body = replaceTokens(bodyPre, tokens);
					String subject = replaceTokens(newsletter.getSubject(subscriptor.getLanguageId()), tokens);
					
					String toName;
					if (subscriptor.getFullName() != null && !subscriptor.getFullName().equals("")) {
						toName = subscriptor.getFullName();
					} else {
						toName = subscriptor.getEmail();
					}
					// envio del correo
					mailHandler.send(subject, body, mailFromAddress, mailFromName, subscriptor.getEmail(), toName);
		
					TokensData tokensData = new TokensData();
					tokensData.setTokens(tokens);
					String tokensString = JSONFactoryUtil.looseSerialize(tokensData);
					mailingSubscriptorLocalService.addMailingSubscriptor(mailing.getMailingId(), subscriptor.getEmail(), subject, body,
							tokensString, subscriptor.getName(), subscriptor.getSurname(), subscriptor.getLanguageId());
					
					emailCount++;
				}
				
			}
			
			mailingLocalService.endMailing(mailing.getMailingId(), MailingConstants.STATUS_FINISHED, emailCount);
			
		} catch (CancelMailingException e) {
			_log.warn("el envio de la newsletter ha sido cancelado");
			mailingLocalService.endMailing(mailing.getMailingId(), MailingConstants.STATUS_CANCELED, emailCount);
		}

		mailHandler.closeConnection();
		
	}
	
	// TODO QUITAR DE AQUI EL THEMEDISPLAY! de momento lo dejo para pruebas
	private String processTemplate(Newsletter newsletter, Date startDate, Map<String, String> tokens, String languageId,
			ThemeDisplay themeDisplay) throws SystemException, PortalException {
		
		long start = System.currentTimeMillis();
		
		long groupId = newsletter.getGroupId();
		String articleId = newsletter.getArticleId();
		long articleGroupId = newsletter.getArticleGroupId();
		String templateId = null;
		
		JournalArticle journalArticle = JournalArticleLocalServiceUtil.getArticle(articleGroupId, articleId);
		if (journalArticle.isTemplateDriven()) {
			templateId = journalArticle.getTemplateId();
		}
		
		themeDisplay = ThemeDisplayHelper.create(newsletter.getCompanyId(), groupId, languageId);
//		ThemeDisplayHelper.print(themeDisplay);
		
		String viewMode = null;
		
		// Mod-engine
		// 6.1 (ya no existe)
//		String body = ModifiedJournalArticleTransformer.getArticleContent(articleGroupId, articleId, templateId, tokens, themeDisplay);
		// 6.2
		String body = JournalContentCustomUtil.getArticleContent(articleGroupId, articleId, viewMode, null, languageId, themeDisplay, tokens);
		

		// Engine original de liferay (para pruebas)
		// modo 1
//		String body = JournalContentUtil.getContent(articleGroupId, articleId, viewMode, languageId, themeDisplay);
		
		// modo 2
//		JournalArticleDisplay jad = JournalContentUtil.getDisplay(articleGroupId, articleId, templateId, viewMode, languageId, themeDisplay);
//		String body = "";
//		if (jad != null) {
//			body = jad.getContent();
//		}

		long end = System.currentTimeMillis();
		_log.info("Plantilla procesada en (ms): " + (end-start));
		
		if (StringUtils.isBlank(body) || body.contains("@" + TokensData.KEY_CANCEL_MAILING + "@")) {
			throw new CancelMailingException();
		}
		
		return body;
	}
	
	
	private Map<String,String> calculateNewsletterTokens(Newsletter newsletter, Date startDate) {
		
		Map<String, String> tokens = new HashMap<String, String>();
		
		// calcular fromDate
		Calendar startCal = new GregorianCalendar();
		startCal.setTime(startDate);
		Date fromDate = calculateFromDate(newsletter, startDate);
		
		tokens.put(TokensData.KEY_START_DATE_MS, String.valueOf(startDate.getTime()));
		if (fromDate != null) {
			tokens.put(TokensData.KEY_FROM_DATE_MS, String.valueOf(fromDate.getTime()));
		}
		
		return tokens;
	}
	
	private Map<String,String> calculateSubscriptorTokens(Newsletter newsletter, Subscriptor subscriptor, Date startDate) throws SystemException {
		
		Map<String, String> tokens = new HashMap<String, String>();
		
		// calcular fromDate
		Calendar startCal = new GregorianCalendar();
		startCal.setTime(startDate);
		Date fromDate = calculateFromDate(newsletter, startDate);
		
		String unsubscriptionUrl = userSubscriptionLocalService.generateUnsubscriptionUrl(newsletter.getCompanyId(), newsletter.getGroupId(), subscriptor.getUuid());
		
		tokens.put(TokensData.KEY_SUBSCRIPTOR_NAME, subscriptor.getName());
		tokens.put(TokensData.KEY_SUBSCRIPTOR_SURNAME, subscriptor.getSurname());
		tokens.put(TokensData.KEY_SUBSCRIPTOR_FULLNAME, subscriptor.getFullName());
		tokens.put(TokensData.KEY_SUBSCRIPTOR_EMAIL, subscriptor.getEmail());
		tokens.put(TokensData.KEY_UNSUBSCRIBE_URL, unsubscriptionUrl);
		tokens.put(TokensData.KEY_START_DATE_MS, String.valueOf(startDate.getTime()));
		if (fromDate != null) {
			tokens.put(TokensData.KEY_FROM_DATE_MS, String.valueOf(fromDate.getTime()));
		}
		
		return tokens;
	}

	private String replaceTokens(String text, Map<String,String> tokens) {
		
		for (String key : tokens.keySet()) {
			text = text.replace("@" + key + "@", tokens.get(key));
		}
		
		return text;
	}
	
	private Date calculateFromDate(Newsletter newsletter, Date startDate) {
		
		Calendar startCal = new GregorianCalendar();
		startCal.setTime(startDate);
		
		Calendar schedulerConfigCal = new GregorianCalendar();
		schedulerConfigCal.setTime(newsletter.getSchedulerDate());
		
		Date fromDate = null;
		
		if (newsletter.getSchedulerType() == NewsletterConstants.SCHEDULER_TYPE_DAYLY) {
			
			Calendar fromCal = new GregorianCalendar();
			fromCal.setTime(startDate);
			fromCal.add(Calendar.DAY_OF_MONTH, -1);
			fromDate = fromCal.getTime();
			
		} else if (newsletter.getSchedulerType() == NewsletterConstants.SCHEDULER_TYPE_WEEKLY) {
				
			Calendar fromCal = new GregorianCalendar();
			fromCal.setTime(startDate);
			fromCal.add(Calendar.DAY_OF_MONTH, -7);
			fromDate = fromCal.getTime();
				
		} else if (newsletter.getSchedulerType() == NewsletterConstants.SCHEDULER_TYPE_MONTHLY) {
		
			Calendar fromCal = new GregorianCalendar();
			fromCal.setTime(startDate);
			fromCal.add(Calendar.MONTH, -1);
			if (schedulerConfigCal.get(Calendar.DAY_OF_MONTH) == 31) {
				// si esta configurado como ultimo dia del mes hay que ajustarlo
				fromCal.set(Calendar.DAY_OF_MONTH, fromCal.getActualMaximum(Calendar.DAY_OF_MONTH));
			}
			fromDate = fromCal.getTime();
		}
		
		return fromDate;
	}
	
}

