package net.zylk.liferay.portal.service.impl;

import java.util.List;

import net.zylk.liferay.portal.model.MailingSubscriptor;
import net.zylk.liferay.portal.service.base.MailingSubscriptorLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


public class MailingSubscriptorLocalServiceImpl extends MailingSubscriptorLocalServiceBaseImpl {
	
	private static Log _log = LogFactoryUtil.getLog(MailingSubscriptorLocalServiceImpl.class);
	
	public MailingSubscriptor addMailingSubscriptor(long mailingId, String email, String emailSubject, String emailBody,
			String tokens, String name, String surname, String languageId) throws SystemException {

        long id = counterLocalService.increment(MailingSubscriptor.class.getName());
        MailingSubscriptor mailing = mailingSubscriptorPersistence.create(id);
        mailing.setMailingId(mailingId);
        mailing.setEmail(email);
        mailing.setEmailSubject(emailSubject);
        mailing.setEmailBody(emailBody);
        mailing.setTokens(tokens);
        mailing.setName(name);
        mailing.setSurname(surname);
        mailing.setLanguageId(languageId);
        mailing = mailingSubscriptorPersistence.update(mailing, false);
        
        return mailing;
	}
	
	public List<MailingSubscriptor> findByMailingIdAndKeywords(long mailingId, String keywords, int start, int end) throws SystemException {
		
		// esto estaria mejor en un "ExtSubscriptorPersistenceImpl", definiendo una "persistence-class" en el service.xml.
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(MailingSubscriptor.class);
		Junction junction = RestrictionsFactoryUtil.disjunction();
		junction.add(RestrictionsFactoryUtil.ilike("name", "%" + keywords + "%"));
		junction.add(RestrictionsFactoryUtil.ilike("surname", "%" + keywords + "%"));
		junction.add(RestrictionsFactoryUtil.ilike("email", "%" + keywords + "%"));
		query.add(junction);
		query.add(PropertyFactoryUtil.forName("mailingId").eq(new Long(mailingId)));
		query.addOrder(OrderFactoryUtil.asc("email"));

		List results = this.dynamicQuery(query, start, end);

		return (List<MailingSubscriptor>) results;
	}
	
	public int countByMailingIdAndKeywords(long mailingId, String keywords) throws SystemException {

		// esto estaria mejor en un "ExtSubscriptorPersistenceImpl", definiendo una "persistence-class" en el service.xml.
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(MailingSubscriptor.class);
		Junction junction = RestrictionsFactoryUtil.disjunction();
		junction.add(RestrictionsFactoryUtil.ilike("name", "%" + keywords + "%"));
		junction.add(RestrictionsFactoryUtil.ilike("surname", "%" + keywords + "%"));
		junction.add(RestrictionsFactoryUtil.ilike("email", "%" + keywords + "%"));
		query.add(junction);
		query.add(PropertyFactoryUtil.forName("mailingId").eq(new Long(mailingId)));        
        query.setProjection(ProjectionFactoryUtil.rowCount());

        List<Long> list = this.dynamicQuery(query);
		Long value = list.get(0);
		// En esta version de liferay el projection rowCount devuelve un Long (en vez de un int). Está mejor así, pero
		// lo paso a int (a pesar de la perdida de rango entre int y long) ya que el search container solo permite int, y los
		// counts autogenerados de los finders tambien devuelven int.
        return value.intValue();
	}
	
}