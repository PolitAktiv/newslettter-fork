package net.zylk.liferay.portal.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import net.zylk.liferay.portal.model.Category;
import net.zylk.liferay.portal.service.CategoryLocalServiceUtil;

/**
 * @author zylk.net
 * @generated
 */
public abstract class CategoryActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public CategoryActionableDynamicQuery() throws SystemException {
        setBaseLocalService(CategoryLocalServiceUtil.getService());
        setClass(Category.class);

        setClassLoader(net.zylk.liferay.portal.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("categoryId");
    }
}
