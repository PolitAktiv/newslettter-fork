package net.zylk.liferay.portal.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import net.zylk.liferay.portal.model.SubscriptorCategory;
import net.zylk.liferay.portal.service.SubscriptorCategoryLocalServiceUtil;

/**
 * @author zylk.net
 * @generated
 */
public abstract class SubscriptorCategoryActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public SubscriptorCategoryActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(SubscriptorCategoryLocalServiceUtil.getService());
        setClass(SubscriptorCategory.class);

        setClassLoader(net.zylk.liferay.portal.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("subscriptorCategoryId");
    }
}
