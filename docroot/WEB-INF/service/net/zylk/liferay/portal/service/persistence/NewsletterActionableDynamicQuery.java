package net.zylk.liferay.portal.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import net.zylk.liferay.portal.model.Newsletter;
import net.zylk.liferay.portal.service.NewsletterLocalServiceUtil;

/**
 * @author zylk.net
 * @generated
 */
public abstract class NewsletterActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public NewsletterActionableDynamicQuery() throws SystemException {
        setBaseLocalService(NewsletterLocalServiceUtil.getService());
        setClass(Newsletter.class);

        setClassLoader(net.zylk.liferay.portal.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("newsletterId");
    }
}
