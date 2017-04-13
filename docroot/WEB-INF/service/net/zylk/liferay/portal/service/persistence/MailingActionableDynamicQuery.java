package net.zylk.liferay.portal.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import net.zylk.liferay.portal.model.Mailing;
import net.zylk.liferay.portal.service.MailingLocalServiceUtil;

/**
 * @author zylk.net
 * @generated
 */
public abstract class MailingActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public MailingActionableDynamicQuery() throws SystemException {
        setBaseLocalService(MailingLocalServiceUtil.getService());
        setClass(Mailing.class);

        setClassLoader(net.zylk.liferay.portal.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("mailingId");
    }
}
