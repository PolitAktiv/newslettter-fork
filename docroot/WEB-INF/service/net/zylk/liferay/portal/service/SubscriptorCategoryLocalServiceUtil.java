package net.zylk.liferay.portal.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SubscriptorCategory. This utility wraps
 * {@link net.zylk.liferay.portal.service.impl.SubscriptorCategoryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author zylk.net
 * @see SubscriptorCategoryLocalService
 * @see net.zylk.liferay.portal.service.base.SubscriptorCategoryLocalServiceBaseImpl
 * @see net.zylk.liferay.portal.service.impl.SubscriptorCategoryLocalServiceImpl
 * @generated
 */
public class SubscriptorCategoryLocalServiceUtil {
    private static SubscriptorCategoryLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link net.zylk.liferay.portal.service.impl.SubscriptorCategoryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the subscriptor category to the database. Also notifies the appropriate model listeners.
    *
    * @param subscriptorCategory the subscriptor category
    * @return the subscriptor category that was added
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.SubscriptorCategory addSubscriptorCategory(
        net.zylk.liferay.portal.model.SubscriptorCategory subscriptorCategory)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addSubscriptorCategory(subscriptorCategory);
    }

    /**
    * Creates a new subscriptor category with the primary key. Does not add the subscriptor category to the database.
    *
    * @param subscriptorCategoryId the primary key for the new subscriptor category
    * @return the new subscriptor category
    */
    public static net.zylk.liferay.portal.model.SubscriptorCategory createSubscriptorCategory(
        long subscriptorCategoryId) {
        return getService().createSubscriptorCategory(subscriptorCategoryId);
    }

    /**
    * Deletes the subscriptor category with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param subscriptorCategoryId the primary key of the subscriptor category
    * @return the subscriptor category that was removed
    * @throws PortalException if a subscriptor category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.SubscriptorCategory deleteSubscriptorCategory(
        long subscriptorCategoryId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteSubscriptorCategory(subscriptorCategoryId);
    }

    /**
    * Deletes the subscriptor category from the database. Also notifies the appropriate model listeners.
    *
    * @param subscriptorCategory the subscriptor category
    * @return the subscriptor category that was removed
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.SubscriptorCategory deleteSubscriptorCategory(
        net.zylk.liferay.portal.model.SubscriptorCategory subscriptorCategory)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteSubscriptorCategory(subscriptorCategory);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.SubscriptorCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.SubscriptorCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static net.zylk.liferay.portal.model.SubscriptorCategory fetchSubscriptorCategory(
        long subscriptorCategoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchSubscriptorCategory(subscriptorCategoryId);
    }

    /**
    * Returns the subscriptor category with the primary key.
    *
    * @param subscriptorCategoryId the primary key of the subscriptor category
    * @return the subscriptor category
    * @throws PortalException if a subscriptor category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.SubscriptorCategory getSubscriptorCategory(
        long subscriptorCategoryId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getSubscriptorCategory(subscriptorCategoryId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<net.zylk.liferay.portal.model.SubscriptorCategory> getSubscriptorCategories(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getSubscriptorCategories(start, end);
    }

    /**
    * Returns the number of subscriptor categories.
    *
    * @return the number of subscriptor categories
    * @throws SystemException if a system exception occurred
    */
    public static int getSubscriptorCategoriesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getSubscriptorCategoriesCount();
    }

    /**
    * Updates the subscriptor category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param subscriptorCategory the subscriptor category
    * @return the subscriptor category that was updated
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.SubscriptorCategory updateSubscriptorCategory(
        net.zylk.liferay.portal.model.SubscriptorCategory subscriptorCategory)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateSubscriptorCategory(subscriptorCategory);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static void editSubscriptorCategory(long subscriptorId,
        long[] categoryIds)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().editSubscriptorCategory(subscriptorId, categoryIds);
    }

    public static void deleteBySubscriptorId(long subscriptorId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().deleteBySubscriptorId(subscriptorId);
    }

    public static void deleteByCategoryId(long categoryId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().deleteByCategoryId(categoryId);
    }

    public static void clearService() {
        _service = null;
    }

    public static SubscriptorCategoryLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    SubscriptorCategoryLocalService.class.getName());

            if (invokableLocalService instanceof SubscriptorCategoryLocalService) {
                _service = (SubscriptorCategoryLocalService) invokableLocalService;
            } else {
                _service = new SubscriptorCategoryLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(SubscriptorCategoryLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(SubscriptorCategoryLocalService service) {
    }
}
