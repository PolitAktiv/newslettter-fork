package net.zylk.liferay.portal.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import net.zylk.liferay.portal.model.Mailing;
import net.zylk.liferay.portal.model.MailingConstants;
import net.zylk.liferay.portal.model.Newsletter;
import net.zylk.liferay.portal.model.NewsletterConstants;
import net.zylk.liferay.portal.service.MailingLocalServiceUtil;
import net.zylk.liferay.portal.service.base.MailingLocalServiceBaseImpl;
import net.zylk.liferay.portal.util.CoreProps;
import net.zylk.liferay.portal.util.DateFormatUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the mailing local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link net.zylk.liferay.portal.service.MailingLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author zylk.net
 * @see net.zylk.liferay.portal.service.base.MailingLocalServiceBaseImpl
 * @see net.zylk.liferay.portal.service.MailingLocalServiceUtil
 */
public class MailingLocalServiceImpl extends MailingLocalServiceBaseImpl {
	
	private static Log _log = LogFactoryUtil.getLog(MailingLocalServiceImpl.class);
	
	public Mailing startMailing(long companyId, long groupId, long newsletterId, String newsletterName, String emailFromName,
			String emailFromAddress, Date startDate, Date fromDate, boolean isScheduled) throws SystemException {

        long id = counterLocalService.increment(Mailing.class.getName());
        Mailing mailing = mailingPersistence.create(id);
        mailing.setCompanyId(companyId);
        mailing.setGroupId(groupId);
        mailing.setNewsletterId(newsletterId);
        mailing.setNewsletterName(newsletterName);
        mailing.setEmailFromName(emailFromName);
        mailing.setEmailFromAddress(emailFromAddress);
        mailing.setStartDate(startDate);
        mailing.setFromDate(fromDate);
        mailing.setEmailCount(0);
        mailing.setIsScheduled(isScheduled);
        mailing.setStatus(MailingConstants.STATUS_EXECUTING);
        mailing = mailingPersistence.update(mailing, false);
        
        return mailing;
	}
	
	public Mailing endMailing(long mailingId, int status, int emailCount) throws SystemException, PortalException {

		Mailing mailing = mailingPersistence.findByPrimaryKey(mailingId);
        mailing.setEmailCount(emailCount);
        mailing.setStatus(status);
        mailing = mailingPersistence.update(mailing, false);
        
        return mailing;
	}
	
	
	
	/**
	 * Comprueba si la newsletter necesita ser enviada en este instante. Y en tal caso devuelve un Date.
	 * Si no necesita ser enviada devuelve null. 
	 * 
	 * @param newsletter
	 * @return
	 * @throws SystemException
	 */
	public Date isExecutionRequired(Newsletter newsletter) throws SystemException {

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		if (newsletter.getSchedulerActive()) {
			
			Date sendDate = calculateSendDate(newsletter);
			
			if (sendDate != null) {
				_log.info("comprobando la ejecucion correspondiente a la fecha: " + dateFormat.format(sendDate));
			
				Date lastExecutionDate = getLastExecutionDate(newsletter.getNewsletterId());
				
				if (lastExecutionDate == null) {
					_log.info("no hay ninguna ejecucion previa");
					_log.info("es necesario enviar la newsletter con id: " + newsletter.getNewsletterId());
					return sendDate;
					
				} else {
					_log.info("ultima ejecucion realizada: " + dateFormat.format(lastExecutionDate));
					if (lastExecutionDate.compareTo(sendDate) < 0) {
						// si no se ha enviado otra en ese periodo se envia
						_log.info("es necesario enviar la newsletter con id: " + newsletter.getNewsletterId());
						return sendDate;
					}
				}
			}
		}
		
		_log.info("no es necesario enviar la newsletter con id: " + newsletter.getNewsletterId());
		return null;
	}
	
	/**
	 * 
	 * Devuelve la fecha de la ultima ejecucion realizada.
	 * 
	 * @param newsletterId
	 * @return  
	 * @throws SystemException
	 */
	private Date getLastExecutionDate(long newsletterId) throws SystemException {

		// TODO obtener solo 1 resultado
		List<Mailing> mailings = MailingLocalServiceUtil.findByNewsletterId(newsletterId);

		if (mailings != null && mailings.size() > 0) {
			Mailing mailing = mailings.get(0); // el ultimo
			
			return mailing.getStartDate();
			
		} else {
			return null;
		}

	}
	
	/**
	 * Calcula la ultima fecha de activación, a partir de la configuracion del scheduler.
	 * 
	 * @param newsletter
	 * @param now
	 * @return 
	 * @throws SystemException
	 */
	private Date calculateSendDate(Newsletter newsletter) throws SystemException {
		
		Calendar nowCal = new GregorianCalendar();
		Date now = new Date();
		nowCal.setTime(now);
		
		Date schedulerConfigDate = newsletter.getSchedulerDate();
		Calendar schedulerConfigCal = new GregorianCalendar();
		schedulerConfigCal.setTime(schedulerConfigDate);
		
		Date modifiedDate = newsletter.getModifiedDate();
		Calendar modifiedCal = new GregorianCalendar();
		modifiedCal.setTime(modifiedDate);
		
		// borrar lo siguiente cuando se añada hora/min en la configuracion de cada newsletter.
		// ahora se esta almacenando 0/0/0/0 (hora/min/sec/ms) así que seteo unicamente hora y mins.
		try {
			String sendHour = CoreProps.get(CoreProps.KEY_SCHEDULER_SEND_TIME);
			Date sendHourDate = DateFormatUtil.parseDefaultTimeZone(sendHour);
			Calendar sendHourCal = new GregorianCalendar();
			sendHourCal.setTime(sendHourDate);
			schedulerConfigCal.set(Calendar.HOUR_OF_DAY, sendHourCal.get(Calendar.HOUR_OF_DAY));
			schedulerConfigCal.set(Calendar.MINUTE, sendHourCal.get(Calendar.MINUTE));
			
			DateFormat dateFormat = new SimpleDateFormat("HH:mm");
			_log.warn("hora de envio configurada: " + dateFormat.format(schedulerConfigCal.getTime()));
			
		} catch (ParseException e) {
			// se queda con la hora 0/0/0/0
			_log.warn("error parsing " + CoreProps.KEY_SCHEDULER_SEND_TIME, e);
		}
		//

		if (newsletter.getSchedulerType() == NewsletterConstants.SCHEDULER_TYPE_DAYLY) {
	
			Calendar pastCal = new GregorianCalendar();
			pastCal.setTime(now);
			
			pastCal.set(Calendar.HOUR_OF_DAY, schedulerConfigCal.get(Calendar.HOUR_OF_DAY));
			pastCal.set(Calendar.MINUTE, schedulerConfigCal.get(Calendar.MINUTE));
			pastCal.set(Calendar.SECOND, schedulerConfigCal.get(Calendar.SECOND));
			pastCal.set(Calendar.MILLISECOND, schedulerConfigCal.get(Calendar.MILLISECOND));
			
			if (pastCal.after(nowCal)) { // si es posterior a hoy -> se le quita 1 dia
				pastCal.add(Calendar.DAY_OF_MONTH, -1);
			}

			if (pastCal.after(modifiedCal)) {
				// tiene que ser posterior a la fecha de modificacion
				return pastCal.getTime();
			}
			
		} else if (newsletter.getSchedulerType() == NewsletterConstants.SCHEDULER_TYPE_WEEKLY) {
			
			Calendar pastCal = new GregorianCalendar();
			pastCal.setTime(now);
			
			pastCal.set(Calendar.HOUR_OF_DAY, schedulerConfigCal.get(Calendar.HOUR_OF_DAY));
			pastCal.set(Calendar.MINUTE, schedulerConfigCal.get(Calendar.MINUTE));
			pastCal.set(Calendar.SECOND, schedulerConfigCal.get(Calendar.SECOND));
			pastCal.set(Calendar.MILLISECOND, schedulerConfigCal.get(Calendar.MILLISECOND));
			
			pastCal.set(Calendar.DAY_OF_WEEK, schedulerConfigCal.get(Calendar.DAY_OF_WEEK));
			
			if (pastCal.after(nowCal)) { // si es posterior a hoy -> se le quita 1 semana
				pastCal.add(Calendar.DAY_OF_MONTH, -7);
			}
			
			if (pastCal.after(modifiedCal)) {
				// tiene que ser posterior a la fecha de modificacion
				return pastCal.getTime();
			}
			
		} else if (newsletter.getSchedulerType() == NewsletterConstants.SCHEDULER_TYPE_MONTHLY) {
			
			Calendar pastCal = new GregorianCalendar();
			pastCal.setTime(now);
			
			pastCal.set(Calendar.HOUR_OF_DAY, schedulerConfigCal.get(Calendar.HOUR_OF_DAY));
			pastCal.set(Calendar.MINUTE, schedulerConfigCal.get(Calendar.MINUTE));
			pastCal.set(Calendar.SECOND, schedulerConfigCal.get(Calendar.SECOND));
			pastCal.set(Calendar.MILLISECOND, schedulerConfigCal.get(Calendar.MILLISECOND));
			
			if (schedulerConfigCal.get(Calendar.DAY_OF_MONTH) == 31) { // configuracion a ultimo dia del mes
				pastCal.set(Calendar.DAY_OF_MONTH, pastCal.getActualMaximum(Calendar.DAY_OF_MONTH));
			} else {
				pastCal.set(Calendar.DAY_OF_MONTH, schedulerConfigCal.get(Calendar.DAY_OF_MONTH));
			}
			
			if (pastCal.after(nowCal)) { // si es posterior a hoy -> se le quita 1 mes
 
				pastCal.add(Calendar.MONTH, -1);

				if (schedulerConfigCal.get(Calendar.DAY_OF_MONTH) == 31) {
					// si esta configurado como ultimo dia del mes hay que ajustarlo
					pastCal.set(Calendar.DAY_OF_MONTH, pastCal.getActualMaximum(Calendar.DAY_OF_MONTH));
				}
			}
			
			if (pastCal.after(modifiedCal)) {
				// tiene que ser posterior a la fecha de modificacion
				return pastCal.getTime();
			}
			
		} else if (newsletter.getSchedulerType() == NewsletterConstants.SCHEDULER_TYPE_SPECIFIC_DATE) {

			if (schedulerConfigCal.before(nowCal)) { // solo se devuelve si la fecha es pasada
				return schedulerConfigCal.getTime();
			}
			// aqui tiene sentido comprobar tambien la fecha de modificacion?
		}
		
		return null;
		
	}
	
	public List<Mailing> findByCompanyIdAndGroupId(long companyId, long groupId, int start, int end) throws SystemException {
		
		return mailingPersistence.findByCompanyIdAndGroupId(companyId, groupId, start, end);
	}
	
	public int countByCompanyIdAndGroupId(long companyId, long groupId) throws SystemException {
		
		return mailingPersistence.countByCompanyIdAndGroupId(companyId, groupId);
	}
	
	public List<Mailing> findByNewsletterId(long newsletterId) throws SystemException {
		
		return mailingPersistence.findByNewsletterId(newsletterId);
	}
	
}