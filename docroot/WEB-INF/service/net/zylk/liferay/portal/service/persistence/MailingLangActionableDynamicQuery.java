package net.zylk.liferay.portal.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import net.zylk.liferay.portal.model.MailingLang;
import net.zylk.liferay.portal.service.MailingLangLocalServiceUtil;

/**
 * @author zylk.net
 * @generated
 */
public abstract class MailingLangActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public MailingLangActionableDynamicQuery() throws SystemException {
        setBaseLocalService(MailingLangLocalServiceUtil.getService());
        setClass(MailingLang.class);

        setClassLoader(net.zylk.liferay.portal.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("mailingLangId");
    }
}
