package net.zylk.liferay.portal.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import net.zylk.liferay.portal.model.Subscriptor;
import net.zylk.liferay.portal.service.SubscriptorLocalServiceUtil;

/**
 * @author zylk.net
 * @generated
 */
public abstract class SubscriptorActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public SubscriptorActionableDynamicQuery() throws SystemException {
        setBaseLocalService(SubscriptorLocalServiceUtil.getService());
        setClass(Subscriptor.class);

        setClassLoader(net.zylk.liferay.portal.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("subscriptorId");
    }
}
