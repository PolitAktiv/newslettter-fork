package net.zylk.liferay.portal.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import net.zylk.liferay.portal.model.SubscriptorCategory;

import java.util.List;

/**
 * The persistence utility for the subscriptor category service. This utility wraps {@link SubscriptorCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author zylk.net
 * @see SubscriptorCategoryPersistence
 * @see SubscriptorCategoryPersistenceImpl
 * @generated
 */
public class SubscriptorCategoryUtil {
    private static SubscriptorCategoryPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(SubscriptorCategory subscriptorCategory) {
        getPersistence().clearCache(subscriptorCategory);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<SubscriptorCategory> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<SubscriptorCategory> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<SubscriptorCategory> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static SubscriptorCategory update(
        SubscriptorCategory subscriptorCategory) throws SystemException {
        return getPersistence().update(subscriptorCategory);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static SubscriptorCategory update(
        SubscriptorCategory subscriptorCategory, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(subscriptorCategory, serviceContext);
    }

    /**
    * Returns all the subscriptor categories where subscriptorId = &#63;.
    *
    * @param subscriptorId the subscriptor ID
    * @return the matching subscriptor categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.zylk.liferay.portal.model.SubscriptorCategory> findBySubscriptorId(
        long subscriptorId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBySubscriptorId(subscriptorId);
    }

    /**
    * Returns a range of all the subscriptor categories where subscriptorId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.SubscriptorCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param subscriptorId the subscriptor ID
    * @param start the lower bound of the range of subscriptor categories
    * @param end the upper bound of the range of subscriptor categories (not inclusive)
    * @return the range of matching subscriptor categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.zylk.liferay.portal.model.SubscriptorCategory> findBySubscriptorId(
        long subscriptorId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBySubscriptorId(subscriptorId, start, end);
    }

    /**
    * Returns an ordered range of all the subscriptor categories where subscriptorId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.SubscriptorCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param subscriptorId the subscriptor ID
    * @param start the lower bound of the range of subscriptor categories
    * @param end the upper bound of the range of subscriptor categories (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching subscriptor categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.zylk.liferay.portal.model.SubscriptorCategory> findBySubscriptorId(
        long subscriptorId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySubscriptorId(subscriptorId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first subscriptor category in the ordered set where subscriptorId = &#63;.
    *
    * @param subscriptorId the subscriptor ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscriptor category
    * @throws net.zylk.liferay.portal.NoSuchSubscriptorCategoryException if a matching subscriptor category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.SubscriptorCategory findBySubscriptorId_First(
        long subscriptorId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorCategoryException {
        return getPersistence()
                   .findBySubscriptorId_First(subscriptorId, orderByComparator);
    }

    /**
    * Returns the first subscriptor category in the ordered set where subscriptorId = &#63;.
    *
    * @param subscriptorId the subscriptor ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscriptor category, or <code>null</code> if a matching subscriptor category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.SubscriptorCategory fetchBySubscriptorId_First(
        long subscriptorId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBySubscriptorId_First(subscriptorId, orderByComparator);
    }

    /**
    * Returns the last subscriptor category in the ordered set where subscriptorId = &#63;.
    *
    * @param subscriptorId the subscriptor ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscriptor category
    * @throws net.zylk.liferay.portal.NoSuchSubscriptorCategoryException if a matching subscriptor category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.SubscriptorCategory findBySubscriptorId_Last(
        long subscriptorId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorCategoryException {
        return getPersistence()
                   .findBySubscriptorId_Last(subscriptorId, orderByComparator);
    }

    /**
    * Returns the last subscriptor category in the ordered set where subscriptorId = &#63;.
    *
    * @param subscriptorId the subscriptor ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscriptor category, or <code>null</code> if a matching subscriptor category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.SubscriptorCategory fetchBySubscriptorId_Last(
        long subscriptorId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBySubscriptorId_Last(subscriptorId, orderByComparator);
    }

    /**
    * Returns the subscriptor categories before and after the current subscriptor category in the ordered set where subscriptorId = &#63;.
    *
    * @param subscriptorCategoryId the primary key of the current subscriptor category
    * @param subscriptorId the subscriptor ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next subscriptor category
    * @throws net.zylk.liferay.portal.NoSuchSubscriptorCategoryException if a subscriptor category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.SubscriptorCategory[] findBySubscriptorId_PrevAndNext(
        long subscriptorCategoryId, long subscriptorId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorCategoryException {
        return getPersistence()
                   .findBySubscriptorId_PrevAndNext(subscriptorCategoryId,
            subscriptorId, orderByComparator);
    }

    /**
    * Removes all the subscriptor categories where subscriptorId = &#63; from the database.
    *
    * @param subscriptorId the subscriptor ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeBySubscriptorId(long subscriptorId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBySubscriptorId(subscriptorId);
    }

    /**
    * Returns the number of subscriptor categories where subscriptorId = &#63;.
    *
    * @param subscriptorId the subscriptor ID
    * @return the number of matching subscriptor categories
    * @throws SystemException if a system exception occurred
    */
    public static int countBySubscriptorId(long subscriptorId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBySubscriptorId(subscriptorId);
    }

    /**
    * Returns all the subscriptor categories where categoryId = &#63;.
    *
    * @param categoryId the category ID
    * @return the matching subscriptor categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.zylk.liferay.portal.model.SubscriptorCategory> findByCategoryId(
        long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCategoryId(categoryId);
    }

    /**
    * Returns a range of all the subscriptor categories where categoryId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.SubscriptorCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param categoryId the category ID
    * @param start the lower bound of the range of subscriptor categories
    * @param end the upper bound of the range of subscriptor categories (not inclusive)
    * @return the range of matching subscriptor categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.zylk.liferay.portal.model.SubscriptorCategory> findByCategoryId(
        long categoryId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCategoryId(categoryId, start, end);
    }

    /**
    * Returns an ordered range of all the subscriptor categories where categoryId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.SubscriptorCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param categoryId the category ID
    * @param start the lower bound of the range of subscriptor categories
    * @param end the upper bound of the range of subscriptor categories (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching subscriptor categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.zylk.liferay.portal.model.SubscriptorCategory> findByCategoryId(
        long categoryId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCategoryId(categoryId, start, end, orderByComparator);
    }

    /**
    * Returns the first subscriptor category in the ordered set where categoryId = &#63;.
    *
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscriptor category
    * @throws net.zylk.liferay.portal.NoSuchSubscriptorCategoryException if a matching subscriptor category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.SubscriptorCategory findByCategoryId_First(
        long categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorCategoryException {
        return getPersistence()
                   .findByCategoryId_First(categoryId, orderByComparator);
    }

    /**
    * Returns the first subscriptor category in the ordered set where categoryId = &#63;.
    *
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscriptor category, or <code>null</code> if a matching subscriptor category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.SubscriptorCategory fetchByCategoryId_First(
        long categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCategoryId_First(categoryId, orderByComparator);
    }

    /**
    * Returns the last subscriptor category in the ordered set where categoryId = &#63;.
    *
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscriptor category
    * @throws net.zylk.liferay.portal.NoSuchSubscriptorCategoryException if a matching subscriptor category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.SubscriptorCategory findByCategoryId_Last(
        long categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorCategoryException {
        return getPersistence()
                   .findByCategoryId_Last(categoryId, orderByComparator);
    }

    /**
    * Returns the last subscriptor category in the ordered set where categoryId = &#63;.
    *
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscriptor category, or <code>null</code> if a matching subscriptor category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.SubscriptorCategory fetchByCategoryId_Last(
        long categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCategoryId_Last(categoryId, orderByComparator);
    }

    /**
    * Returns the subscriptor categories before and after the current subscriptor category in the ordered set where categoryId = &#63;.
    *
    * @param subscriptorCategoryId the primary key of the current subscriptor category
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next subscriptor category
    * @throws net.zylk.liferay.portal.NoSuchSubscriptorCategoryException if a subscriptor category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.SubscriptorCategory[] findByCategoryId_PrevAndNext(
        long subscriptorCategoryId, long categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorCategoryException {
        return getPersistence()
                   .findByCategoryId_PrevAndNext(subscriptorCategoryId,
            categoryId, orderByComparator);
    }

    /**
    * Removes all the subscriptor categories where categoryId = &#63; from the database.
    *
    * @param categoryId the category ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCategoryId(long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCategoryId(categoryId);
    }

    /**
    * Returns the number of subscriptor categories where categoryId = &#63;.
    *
    * @param categoryId the category ID
    * @return the number of matching subscriptor categories
    * @throws SystemException if a system exception occurred
    */
    public static int countByCategoryId(long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCategoryId(categoryId);
    }

    /**
    * Returns the subscriptor category where subscriptorId = &#63; and categoryId = &#63; or throws a {@link net.zylk.liferay.portal.NoSuchSubscriptorCategoryException} if it could not be found.
    *
    * @param subscriptorId the subscriptor ID
    * @param categoryId the category ID
    * @return the matching subscriptor category
    * @throws net.zylk.liferay.portal.NoSuchSubscriptorCategoryException if a matching subscriptor category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.SubscriptorCategory findBySubscriptorIdAndCategoryId(
        long subscriptorId, long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorCategoryException {
        return getPersistence()
                   .findBySubscriptorIdAndCategoryId(subscriptorId, categoryId);
    }

    /**
    * Returns the subscriptor category where subscriptorId = &#63; and categoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param subscriptorId the subscriptor ID
    * @param categoryId the category ID
    * @return the matching subscriptor category, or <code>null</code> if a matching subscriptor category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.SubscriptorCategory fetchBySubscriptorIdAndCategoryId(
        long subscriptorId, long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBySubscriptorIdAndCategoryId(subscriptorId, categoryId);
    }

    /**
    * Returns the subscriptor category where subscriptorId = &#63; and categoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param subscriptorId the subscriptor ID
    * @param categoryId the category ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching subscriptor category, or <code>null</code> if a matching subscriptor category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.SubscriptorCategory fetchBySubscriptorIdAndCategoryId(
        long subscriptorId, long categoryId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBySubscriptorIdAndCategoryId(subscriptorId,
            categoryId, retrieveFromCache);
    }

    /**
    * Removes the subscriptor category where subscriptorId = &#63; and categoryId = &#63; from the database.
    *
    * @param subscriptorId the subscriptor ID
    * @param categoryId the category ID
    * @return the subscriptor category that was removed
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.SubscriptorCategory removeBySubscriptorIdAndCategoryId(
        long subscriptorId, long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorCategoryException {
        return getPersistence()
                   .removeBySubscriptorIdAndCategoryId(subscriptorId, categoryId);
    }

    /**
    * Returns the number of subscriptor categories where subscriptorId = &#63; and categoryId = &#63;.
    *
    * @param subscriptorId the subscriptor ID
    * @param categoryId the category ID
    * @return the number of matching subscriptor categories
    * @throws SystemException if a system exception occurred
    */
    public static int countBySubscriptorIdAndCategoryId(long subscriptorId,
        long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countBySubscriptorIdAndCategoryId(subscriptorId, categoryId);
    }

    /**
    * Caches the subscriptor category in the entity cache if it is enabled.
    *
    * @param subscriptorCategory the subscriptor category
    */
    public static void cacheResult(
        net.zylk.liferay.portal.model.SubscriptorCategory subscriptorCategory) {
        getPersistence().cacheResult(subscriptorCategory);
    }

    /**
    * Caches the subscriptor categories in the entity cache if it is enabled.
    *
    * @param subscriptorCategories the subscriptor categories
    */
    public static void cacheResult(
        java.util.List<net.zylk.liferay.portal.model.SubscriptorCategory> subscriptorCategories) {
        getPersistence().cacheResult(subscriptorCategories);
    }

    /**
    * Creates a new subscriptor category with the primary key. Does not add the subscriptor category to the database.
    *
    * @param subscriptorCategoryId the primary key for the new subscriptor category
    * @return the new subscriptor category
    */
    public static net.zylk.liferay.portal.model.SubscriptorCategory create(
        long subscriptorCategoryId) {
        return getPersistence().create(subscriptorCategoryId);
    }

    /**
    * Removes the subscriptor category with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param subscriptorCategoryId the primary key of the subscriptor category
    * @return the subscriptor category that was removed
    * @throws net.zylk.liferay.portal.NoSuchSubscriptorCategoryException if a subscriptor category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.SubscriptorCategory remove(
        long subscriptorCategoryId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorCategoryException {
        return getPersistence().remove(subscriptorCategoryId);
    }

    public static net.zylk.liferay.portal.model.SubscriptorCategory updateImpl(
        net.zylk.liferay.portal.model.SubscriptorCategory subscriptorCategory)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(subscriptorCategory);
    }

    /**
    * Returns the subscriptor category with the primary key or throws a {@link net.zylk.liferay.portal.NoSuchSubscriptorCategoryException} if it could not be found.
    *
    * @param subscriptorCategoryId the primary key of the subscriptor category
    * @return the subscriptor category
    * @throws net.zylk.liferay.portal.NoSuchSubscriptorCategoryException if a subscriptor category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.SubscriptorCategory findByPrimaryKey(
        long subscriptorCategoryId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorCategoryException {
        return getPersistence().findByPrimaryKey(subscriptorCategoryId);
    }

    /**
    * Returns the subscriptor category with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param subscriptorCategoryId the primary key of the subscriptor category
    * @return the subscriptor category, or <code>null</code> if a subscriptor category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.SubscriptorCategory fetchByPrimaryKey(
        long subscriptorCategoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(subscriptorCategoryId);
    }

    /**
    * Returns all the subscriptor categories.
    *
    * @return the subscriptor categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.zylk.liferay.portal.model.SubscriptorCategory> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the subscriptor categories.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.SubscriptorCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of subscriptor categories
    * @param end the upper bound of the range of subscriptor categories (not inclusive)
    * @return the range of subscriptor categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.zylk.liferay.portal.model.SubscriptorCategory> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the subscriptor categories.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.SubscriptorCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of subscriptor categories
    * @param end the upper bound of the range of subscriptor categories (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of subscriptor categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.zylk.liferay.portal.model.SubscriptorCategory> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the subscriptor categories from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of subscriptor categories.
    *
    * @return the number of subscriptor categories
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static SubscriptorCategoryPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (SubscriptorCategoryPersistence) PortletBeanLocatorUtil.locate(net.zylk.liferay.portal.service.ClpSerializer.getServletContextName(),
                    SubscriptorCategoryPersistence.class.getName());

            ReferenceRegistry.registerReference(SubscriptorCategoryUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(SubscriptorCategoryPersistence persistence) {
    }
}
