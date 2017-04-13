package net.zylk.liferay.portal.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import net.zylk.liferay.portal.EmptyFieldException;
import net.zylk.liferay.portal.NoSuchCategoryException;
import net.zylk.liferay.portal.model.Category;
import net.zylk.liferay.portal.model.SubscriptorCategory;
import net.zylk.liferay.portal.service.base.CategoryLocalServiceBaseImpl;

/**
 * The implementation of the category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link net.zylk.liferay.portal.service.CategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author zylk.net
 * @see net.zylk.liferay.portal.service.base.CategoryLocalServiceBaseImpl
 * @see net.zylk.liferay.portal.service.CategoryLocalServiceUtil
 */
public class CategoryLocalServiceImpl extends CategoryLocalServiceBaseImpl {
	
	public Category addCategory(long companyId, long groupId, Map<Locale, String> nameMap, String description) throws SystemException, PortalException {

        long id = counterLocalService.increment(Category.class.getName());
        Category category = categoryPersistence.create(id);
        category.setCompanyId(companyId);
        category.setGroupId(groupId);
        category.setNameMap(nameMap);
        category.setDescription(description);
        category = categoryPersistence.update(category, false);
        
        return category;
	}
	
	public Category editCategory(long categoryId, Map<Locale, String> nameMap, String description) throws SystemException, PortalException {

        Category category = categoryPersistence.findByPrimaryKey(categoryId);
        category.setNameMap(nameMap);
        category.setDescription(description);
        category = categoryPersistence.update(category, false);
        
        return category;
	}
	
	public void remove(long categoryId) throws PortalException, SystemException {

        categoryPersistence.remove(categoryId);
        
        subscriptorCategoryLocalService.deleteByCategoryId(categoryId);
	}
	
	public List<Category> findByCompanyIdAndGroupId(long companyId, long groupId) throws SystemException {
		
		return categoryPersistence.findByCompanyIdAndGroupId(companyId, groupId);
	}
	
	public List<Category> findBySubscriptorId(long subscriptorId) throws SystemException, PortalException {
		
		// refactor to dynamicQuery? --> de momento no es necesario
		List<Category> categories = new ArrayList<Category>(); 
		
		List<SubscriptorCategory> subscriptorCategories = subscriptorCategoryPersistence.findBySubscriptorId(subscriptorId);
		for (SubscriptorCategory subscriptorCategory : subscriptorCategories) {
			Category category = categoryPersistence.findByPrimaryKey(subscriptorCategory.getCategoryId());
			categories.add(category);
		}
		
		return categories;
	}
	
}
