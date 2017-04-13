package net.zylk.liferay.portal.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CategoryLocalService}.
 *
 * @author zylk.net
 * @see CategoryLocalService
 * @generated
 */
public class CategoryLocalServiceWrapper implements CategoryLocalService,
    ServiceWrapper<CategoryLocalService> {
    private CategoryLocalService _categoryLocalService;

    public CategoryLocalServiceWrapper(
        CategoryLocalService categoryLocalService) {
        _categoryLocalService = categoryLocalService;
    }

    /**
    * Adds the category to the database. Also notifies the appropriate model listeners.
    *
    * @param category the category
    * @return the category that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.Category addCategory(
        net.zylk.liferay.portal.model.Category category)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.addCategory(category);
    }

    /**
    * Creates a new category with the primary key. Does not add the category to the database.
    *
    * @param categoryId the primary key for the new category
    * @return the new category
    */
    @Override
    public net.zylk.liferay.portal.model.Category createCategory(
        long categoryId) {
        return _categoryLocalService.createCategory(categoryId);
    }

    /**
    * Deletes the category with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param categoryId the primary key of the category
    * @return the category that was removed
    * @throws PortalException if a category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.Category deleteCategory(
        long categoryId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.deleteCategory(categoryId);
    }

    /**
    * Deletes the category from the database. Also notifies the appropriate model listeners.
    *
    * @param category the category
    * @return the category that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.Category deleteCategory(
        net.zylk.liferay.portal.model.Category category)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.deleteCategory(category);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _categoryLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public net.zylk.liferay.portal.model.Category fetchCategory(long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.fetchCategory(categoryId);
    }

    /**
    * Returns the category with the primary key.
    *
    * @param categoryId the primary key of the category
    * @return the category
    * @throws PortalException if a category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.Category getCategory(long categoryId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.getCategory(categoryId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the categories.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of categories
    * @param end the upper bound of the range of categories (not inclusive)
    * @return the range of categories
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<net.zylk.liferay.portal.model.Category> getCategories(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.getCategories(start, end);
    }

    /**
    * Returns the number of categories.
    *
    * @return the number of categories
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getCategoriesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.getCategoriesCount();
    }

    /**
    * Updates the category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param category the category
    * @return the category that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.Category updateCategory(
        net.zylk.liferay.portal.model.Category category)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.updateCategory(category);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _categoryLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _categoryLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _categoryLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public net.zylk.liferay.portal.model.Category addCategory(long companyId,
        long groupId,
        java.util.Map<java.util.Locale, java.lang.String> nameMap,
        java.lang.String description)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.addCategory(companyId, groupId, nameMap,
            description);
    }

    @Override
    public net.zylk.liferay.portal.model.Category editCategory(
        long categoryId,
        java.util.Map<java.util.Locale, java.lang.String> nameMap,
        java.lang.String description)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.editCategory(categoryId, nameMap,
            description);
    }

    @Override
    public void remove(long categoryId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _categoryLocalService.remove(categoryId);
    }

    @Override
    public java.util.List<net.zylk.liferay.portal.model.Category> findByCompanyIdAndGroupId(
        long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.findByCompanyIdAndGroupId(companyId,
            groupId);
    }

    @Override
    public java.util.List<net.zylk.liferay.portal.model.Category> findBySubscriptorId(
        long subscriptorId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.findBySubscriptorId(subscriptorId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public CategoryLocalService getWrappedCategoryLocalService() {
        return _categoryLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedCategoryLocalService(
        CategoryLocalService categoryLocalService) {
        _categoryLocalService = categoryLocalService;
    }

    @Override
    public CategoryLocalService getWrappedService() {
        return _categoryLocalService;
    }

    @Override
    public void setWrappedService(CategoryLocalService categoryLocalService) {
        _categoryLocalService = categoryLocalService;
    }
}
