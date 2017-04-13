package net.zylk.liferay.portal.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import net.zylk.liferay.portal.model.Category;
import net.zylk.liferay.portal.service.CategoryLocalServiceUtil;

/**
 * The extended model base implementation for the Category service. Represents a row in the &quot;ZN_Category&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CategoryImpl}.
 * </p>
 *
 * @author zylk.net
 * @see CategoryImpl
 * @see net.zylk.liferay.portal.model.Category
 * @generated
 */
public abstract class CategoryBaseImpl extends CategoryModelImpl
    implements Category {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a category model instance should use the {@link Category} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            CategoryLocalServiceUtil.addCategory(this);
        } else {
            CategoryLocalServiceUtil.updateCategory(this);
        }
    }
}