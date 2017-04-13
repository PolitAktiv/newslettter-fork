package net.zylk.liferay.portal.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import net.zylk.liferay.portal.model.MailingSubscriptor;
import net.zylk.liferay.portal.service.MailingSubscriptorLocalServiceUtil;

/**
 * @author zylk.net
 * @generated
 */
public abstract class MailingSubscriptorActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public MailingSubscriptorActionableDynamicQuery() throws SystemException {
        setBaseLocalService(MailingSubscriptorLocalServiceUtil.getService());
        setClass(MailingSubscriptor.class);

        setClassLoader(net.zylk.liferay.portal.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("mailingSubscriptorId");
    }
}
