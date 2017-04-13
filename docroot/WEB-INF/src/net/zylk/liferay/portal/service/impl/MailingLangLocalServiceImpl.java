package net.zylk.liferay.portal.service.impl;

import net.zylk.liferay.portal.NoSuchMailingLangException;
import net.zylk.liferay.portal.model.MailingLang;
import net.zylk.liferay.portal.service.base.MailingLangLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;



public class MailingLangLocalServiceImpl extends MailingLangLocalServiceBaseImpl {

	private static Log _log = LogFactoryUtil.getLog(MailingLangLocalServiceImpl.class);
	
	public MailingLang addMailingLang(long mailingId, String languageId, String emailSubjectPre, String emailBodyPre) throws SystemException {

        long id = counterLocalService.increment(MailingLang.class.getName());
        MailingLang mailingLang = mailingLangPersistence.create(id);
        mailingLang.setMailingId(mailingId);
        mailingLang.setLanguageId(languageId);
        mailingLang.setEmailSubjectPre(emailSubjectPre);
        mailingLang.setEmailBodyPre(emailBodyPre);
        mailingLang = mailingLangPersistence.update(mailingLang, false);
        
        return mailingLang;
	}
	
	public MailingLang findByMailingIdAndLanguageId(long mailingId, String languageId) throws SystemException {
		
		try {
			return mailingLangPersistence.findByMailingIdAndLanguageId(mailingId, languageId);
			
		} catch (NoSuchMailingLangException e) {
			return null;
		}
		
	}
	
}

