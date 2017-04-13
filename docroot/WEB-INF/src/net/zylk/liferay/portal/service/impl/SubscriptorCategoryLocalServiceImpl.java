package net.zylk.liferay.portal.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import net.zylk.liferay.portal.model.SubscriptorCategory;
import net.zylk.liferay.portal.service.base.SubscriptorCategoryLocalServiceBaseImpl;

/**
 * The implementation of the subscriptor category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link net.zylk.liferay.portal.service.SubscriptorCategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author zylk.net
 * @see net.zylk.liferay.portal.service.base.SubscriptorCategoryLocalServiceBaseImpl
 * @see net.zylk.liferay.portal.service.SubscriptorCategoryLocalServiceUtil
 */
public class SubscriptorCategoryLocalServiceImpl extends SubscriptorCategoryLocalServiceBaseImpl {
	
	//
	// Este servicio es unicamente para uso interno. Es para gestionar la relacion "n-m" entre Category y Subscriptor.
	//
	
	public void editSubscriptorCategory(long subscriptorId, long[] categoryIds) throws SystemException, PortalException {
		
		// delete all old subscriptorCategories
        List<SubscriptorCategory> subscriptorCategories = subscriptorCategoryPersistence.findBySubscriptorId(subscriptorId);
        for (SubscriptorCategory subscriptorCategory : subscriptorCategories) {
        	subscriptorCategoryPersistence.remove(subscriptorCategory.getSubscriptorCategoryId());
		}
        // create new subscriptorCategories
        for (Long categoryId : categoryIds) {
        	addSubscriptorCategory(subscriptorId, categoryId);
		}
	}
	
	
	public void deleteBySubscriptorId(long subscriptorId) throws SystemException, PortalException {
		
		List<SubscriptorCategory> subscriptorCategories = subscriptorCategoryPersistence.findBySubscriptorId(subscriptorId);
		for (SubscriptorCategory subscriptorCategory : subscriptorCategories) {
			subscriptorCategoryPersistence.remove(subscriptorCategory.getSubscriptorCategoryId());
		}
		
	}
	
	public void deleteByCategoryId(long categoryId) throws SystemException, PortalException {
		
		List<SubscriptorCategory> subscriptorCategories = subscriptorCategoryPersistence.findByCategoryId(categoryId);
		for (SubscriptorCategory subscriptorCategory : subscriptorCategories) {
			subscriptorCategoryPersistence.remove(subscriptorCategory.getSubscriptorCategoryId());
		}
	}
	
	private void addSubscriptorCategory(long subscriptorId, long categoryId) throws SystemException {
		
    	long subscriptorCategoryId = counterLocalService.increment(SubscriptorCategory.class.getName());
    	SubscriptorCategory subscriptorCategory = subscriptorCategoryPersistence.create(subscriptorCategoryId);
    	subscriptorCategory.setSubscriptorId(subscriptorId);
    	subscriptorCategory.setCategoryId(categoryId);
    	subscriptorCategory = subscriptorCategoryPersistence.update(subscriptorCategory, false);
	}

}

