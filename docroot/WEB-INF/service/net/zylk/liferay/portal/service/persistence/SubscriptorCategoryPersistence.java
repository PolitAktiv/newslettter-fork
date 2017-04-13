package net.zylk.liferay.portal.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import net.zylk.liferay.portal.model.SubscriptorCategory;

/**
 * The persistence interface for the subscriptor category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author zylk.net
 * @see SubscriptorCategoryPersistenceImpl
 * @see SubscriptorCategoryUtil
 * @generated
 */
public interface SubscriptorCategoryPersistence extends BasePersistence<SubscriptorCategory> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link SubscriptorCategoryUtil} to access the subscriptor category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the subscriptor categories where subscriptorId = &#63;.
    *
    * @param subscriptorId the subscriptor ID
    * @return the matching subscriptor categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.zylk.liferay.portal.model.SubscriptorCategory> findBySubscriptorId(
        long subscriptorId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<net.zylk.liferay.portal.model.SubscriptorCategory> findBySubscriptorId(
        long subscriptorId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<net.zylk.liferay.portal.model.SubscriptorCategory> findBySubscriptorId(
        long subscriptorId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first subscriptor category in the ordered set where subscriptorId = &#63;.
    *
    * @param subscriptorId the subscriptor ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscriptor category
    * @throws net.zylk.liferay.portal.NoSuchSubscriptorCategoryException if a matching subscriptor category could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.SubscriptorCategory findBySubscriptorId_First(
        long subscriptorId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorCategoryException;

    /**
    * Returns the first subscriptor category in the ordered set where subscriptorId = &#63;.
    *
    * @param subscriptorId the subscriptor ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscriptor category, or <code>null</code> if a matching subscriptor category could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.SubscriptorCategory fetchBySubscriptorId_First(
        long subscriptorId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last subscriptor category in the ordered set where subscriptorId = &#63;.
    *
    * @param subscriptorId the subscriptor ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscriptor category
    * @throws net.zylk.liferay.portal.NoSuchSubscriptorCategoryException if a matching subscriptor category could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.SubscriptorCategory findBySubscriptorId_Last(
        long subscriptorId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorCategoryException;

    /**
    * Returns the last subscriptor category in the ordered set where subscriptorId = &#63;.
    *
    * @param subscriptorId the subscriptor ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscriptor category, or <code>null</code> if a matching subscriptor category could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.SubscriptorCategory fetchBySubscriptorId_Last(
        long subscriptorId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public net.zylk.liferay.portal.model.SubscriptorCategory[] findBySubscriptorId_PrevAndNext(
        long subscriptorCategoryId, long subscriptorId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorCategoryException;

    /**
    * Removes all the subscriptor categories where subscriptorId = &#63; from the database.
    *
    * @param subscriptorId the subscriptor ID
    * @throws SystemException if a system exception occurred
    */
    public void removeBySubscriptorId(long subscriptorId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of subscriptor categories where subscriptorId = &#63;.
    *
    * @param subscriptorId the subscriptor ID
    * @return the number of matching subscriptor categories
    * @throws SystemException if a system exception occurred
    */
    public int countBySubscriptorId(long subscriptorId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the subscriptor categories where categoryId = &#63;.
    *
    * @param categoryId the category ID
    * @return the matching subscriptor categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.zylk.liferay.portal.model.SubscriptorCategory> findByCategoryId(
        long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<net.zylk.liferay.portal.model.SubscriptorCategory> findByCategoryId(
        long categoryId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<net.zylk.liferay.portal.model.SubscriptorCategory> findByCategoryId(
        long categoryId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first subscriptor category in the ordered set where categoryId = &#63;.
    *
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscriptor category
    * @throws net.zylk.liferay.portal.NoSuchSubscriptorCategoryException if a matching subscriptor category could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.SubscriptorCategory findByCategoryId_First(
        long categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorCategoryException;

    /**
    * Returns the first subscriptor category in the ordered set where categoryId = &#63;.
    *
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscriptor category, or <code>null</code> if a matching subscriptor category could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.SubscriptorCategory fetchByCategoryId_First(
        long categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last subscriptor category in the ordered set where categoryId = &#63;.
    *
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscriptor category
    * @throws net.zylk.liferay.portal.NoSuchSubscriptorCategoryException if a matching subscriptor category could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.SubscriptorCategory findByCategoryId_Last(
        long categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorCategoryException;

    /**
    * Returns the last subscriptor category in the ordered set where categoryId = &#63;.
    *
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscriptor category, or <code>null</code> if a matching subscriptor category could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.SubscriptorCategory fetchByCategoryId_Last(
        long categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public net.zylk.liferay.portal.model.SubscriptorCategory[] findByCategoryId_PrevAndNext(
        long subscriptorCategoryId, long categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorCategoryException;

    /**
    * Removes all the subscriptor categories where categoryId = &#63; from the database.
    *
    * @param categoryId the category ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByCategoryId(long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of subscriptor categories where categoryId = &#63;.
    *
    * @param categoryId the category ID
    * @return the number of matching subscriptor categories
    * @throws SystemException if a system exception occurred
    */
    public int countByCategoryId(long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the subscriptor category where subscriptorId = &#63; and categoryId = &#63; or throws a {@link net.zylk.liferay.portal.NoSuchSubscriptorCategoryException} if it could not be found.
    *
    * @param subscriptorId the subscriptor ID
    * @param categoryId the category ID
    * @return the matching subscriptor category
    * @throws net.zylk.liferay.portal.NoSuchSubscriptorCategoryException if a matching subscriptor category could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.SubscriptorCategory findBySubscriptorIdAndCategoryId(
        long subscriptorId, long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorCategoryException;

    /**
    * Returns the subscriptor category where subscriptorId = &#63; and categoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param subscriptorId the subscriptor ID
    * @param categoryId the category ID
    * @return the matching subscriptor category, or <code>null</code> if a matching subscriptor category could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.SubscriptorCategory fetchBySubscriptorIdAndCategoryId(
        long subscriptorId, long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the subscriptor category where subscriptorId = &#63; and categoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param subscriptorId the subscriptor ID
    * @param categoryId the category ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching subscriptor category, or <code>null</code> if a matching subscriptor category could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.SubscriptorCategory fetchBySubscriptorIdAndCategoryId(
        long subscriptorId, long categoryId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the subscriptor category where subscriptorId = &#63; and categoryId = &#63; from the database.
    *
    * @param subscriptorId the subscriptor ID
    * @param categoryId the category ID
    * @return the subscriptor category that was removed
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.SubscriptorCategory removeBySubscriptorIdAndCategoryId(
        long subscriptorId, long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorCategoryException;

    /**
    * Returns the number of subscriptor categories where subscriptorId = &#63; and categoryId = &#63;.
    *
    * @param subscriptorId the subscriptor ID
    * @param categoryId the category ID
    * @return the number of matching subscriptor categories
    * @throws SystemException if a system exception occurred
    */
    public int countBySubscriptorIdAndCategoryId(long subscriptorId,
        long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the subscriptor category in the entity cache if it is enabled.
    *
    * @param subscriptorCategory the subscriptor category
    */
    public void cacheResult(
        net.zylk.liferay.portal.model.SubscriptorCategory subscriptorCategory);

    /**
    * Caches the subscriptor categories in the entity cache if it is enabled.
    *
    * @param subscriptorCategories the subscriptor categories
    */
    public void cacheResult(
        java.util.List<net.zylk.liferay.portal.model.SubscriptorCategory> subscriptorCategories);

    /**
    * Creates a new subscriptor category with the primary key. Does not add the subscriptor category to the database.
    *
    * @param subscriptorCategoryId the primary key for the new subscriptor category
    * @return the new subscriptor category
    */
    public net.zylk.liferay.portal.model.SubscriptorCategory create(
        long subscriptorCategoryId);

    /**
    * Removes the subscriptor category with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param subscriptorCategoryId the primary key of the subscriptor category
    * @return the subscriptor category that was removed
    * @throws net.zylk.liferay.portal.NoSuchSubscriptorCategoryException if a subscriptor category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.SubscriptorCategory remove(
        long subscriptorCategoryId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorCategoryException;

    public net.zylk.liferay.portal.model.SubscriptorCategory updateImpl(
        net.zylk.liferay.portal.model.SubscriptorCategory subscriptorCategory)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the subscriptor category with the primary key or throws a {@link net.zylk.liferay.portal.NoSuchSubscriptorCategoryException} if it could not be found.
    *
    * @param subscriptorCategoryId the primary key of the subscriptor category
    * @return the subscriptor category
    * @throws net.zylk.liferay.portal.NoSuchSubscriptorCategoryException if a subscriptor category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.SubscriptorCategory findByPrimaryKey(
        long subscriptorCategoryId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorCategoryException;

    /**
    * Returns the subscriptor category with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param subscriptorCategoryId the primary key of the subscriptor category
    * @return the subscriptor category, or <code>null</code> if a subscriptor category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.SubscriptorCategory fetchByPrimaryKey(
        long subscriptorCategoryId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the subscriptor categories.
    *
    * @return the subscriptor categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.zylk.liferay.portal.model.SubscriptorCategory> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<net.zylk.liferay.portal.model.SubscriptorCategory> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<net.zylk.liferay.portal.model.SubscriptorCategory> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the subscriptor categories from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of subscriptor categories.
    *
    * @return the number of subscriptor categories
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
