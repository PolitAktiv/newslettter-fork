package net.zylk.liferay.portal.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SubscriptorLocalService}.
 *
 * @author zylk.net
 * @see SubscriptorLocalService
 * @generated
 */
public class SubscriptorLocalServiceWrapper implements SubscriptorLocalService,
    ServiceWrapper<SubscriptorLocalService> {
    private SubscriptorLocalService _subscriptorLocalService;

    public SubscriptorLocalServiceWrapper(
        SubscriptorLocalService subscriptorLocalService) {
        _subscriptorLocalService = subscriptorLocalService;
    }

    /**
    * Adds the subscriptor to the database. Also notifies the appropriate model listeners.
    *
    * @param subscriptor the subscriptor
    * @return the subscriptor that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.Subscriptor addSubscriptor(
        net.zylk.liferay.portal.model.Subscriptor subscriptor)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _subscriptorLocalService.addSubscriptor(subscriptor);
    }

    /**
    * Creates a new subscriptor with the primary key. Does not add the subscriptor to the database.
    *
    * @param subscriptorId the primary key for the new subscriptor
    * @return the new subscriptor
    */
    @Override
    public net.zylk.liferay.portal.model.Subscriptor createSubscriptor(
        long subscriptorId) {
        return _subscriptorLocalService.createSubscriptor(subscriptorId);
    }

    /**
    * Deletes the subscriptor with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param subscriptorId the primary key of the subscriptor
    * @return the subscriptor that was removed
    * @throws PortalException if a subscriptor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.Subscriptor deleteSubscriptor(
        long subscriptorId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _subscriptorLocalService.deleteSubscriptor(subscriptorId);
    }

    /**
    * Deletes the subscriptor from the database. Also notifies the appropriate model listeners.
    *
    * @param subscriptor the subscriptor
    * @return the subscriptor that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.Subscriptor deleteSubscriptor(
        net.zylk.liferay.portal.model.Subscriptor subscriptor)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _subscriptorLocalService.deleteSubscriptor(subscriptor);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _subscriptorLocalService.dynamicQuery();
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
        return _subscriptorLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.SubscriptorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _subscriptorLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.SubscriptorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _subscriptorLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _subscriptorLocalService.dynamicQueryCount(dynamicQuery);
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
        return _subscriptorLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public net.zylk.liferay.portal.model.Subscriptor fetchSubscriptor(
        long subscriptorId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _subscriptorLocalService.fetchSubscriptor(subscriptorId);
    }

    /**
    * Returns the subscriptor with the matching UUID and company.
    *
    * @param uuid the subscriptor's UUID
    * @param companyId the primary key of the company
    * @return the matching subscriptor, or <code>null</code> if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.Subscriptor fetchSubscriptorByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _subscriptorLocalService.fetchSubscriptorByUuidAndCompanyId(uuid,
            companyId);
    }

    /**
    * Returns the subscriptor matching the UUID and group.
    *
    * @param uuid the subscriptor's UUID
    * @param groupId the primary key of the group
    * @return the matching subscriptor, or <code>null</code> if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.Subscriptor fetchSubscriptorByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _subscriptorLocalService.fetchSubscriptorByUuidAndGroupId(uuid,
            groupId);
    }

    /**
    * Returns the subscriptor with the primary key.
    *
    * @param subscriptorId the primary key of the subscriptor
    * @return the subscriptor
    * @throws PortalException if a subscriptor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.Subscriptor getSubscriptor(
        long subscriptorId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _subscriptorLocalService.getSubscriptor(subscriptorId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _subscriptorLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns the subscriptor with the matching UUID and company.
    *
    * @param uuid the subscriptor's UUID
    * @param companyId the primary key of the company
    * @return the matching subscriptor
    * @throws PortalException if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.Subscriptor getSubscriptorByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _subscriptorLocalService.getSubscriptorByUuidAndCompanyId(uuid,
            companyId);
    }

    /**
    * Returns the subscriptor matching the UUID and group.
    *
    * @param uuid the subscriptor's UUID
    * @param groupId the primary key of the group
    * @return the matching subscriptor
    * @throws PortalException if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.Subscriptor getSubscriptorByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _subscriptorLocalService.getSubscriptorByUuidAndGroupId(uuid,
            groupId);
    }

    /**
    * Returns a range of all the subscriptors.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.SubscriptorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of subscriptors
    * @param end the upper bound of the range of subscriptors (not inclusive)
    * @return the range of subscriptors
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<net.zylk.liferay.portal.model.Subscriptor> getSubscriptors(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _subscriptorLocalService.getSubscriptors(start, end);
    }

    /**
    * Returns the number of subscriptors.
    *
    * @return the number of subscriptors
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getSubscriptorsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _subscriptorLocalService.getSubscriptorsCount();
    }

    /**
    * Updates the subscriptor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param subscriptor the subscriptor
    * @return the subscriptor that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.Subscriptor updateSubscriptor(
        net.zylk.liferay.portal.model.Subscriptor subscriptor)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _subscriptorLocalService.updateSubscriptor(subscriptor);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _subscriptorLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _subscriptorLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _subscriptorLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public net.zylk.liferay.portal.model.Subscriptor addSubscriptor(
        long companyId, long groupId, java.lang.String name,
        java.lang.String surname, java.lang.String email,
        java.lang.String languageId, long[] categoryIds, boolean selfSubscribe)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _subscriptorLocalService.addSubscriptor(companyId, groupId,
            name, surname, email, languageId, categoryIds, selfSubscribe);
    }

    @Override
    public net.zylk.liferay.portal.model.Subscriptor editSubscriptor(
        long subscriptorId, java.lang.String name, java.lang.String surname,
        java.lang.String email, java.lang.String languageId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _subscriptorLocalService.editSubscriptor(subscriptorId, name,
            surname, email, languageId);
    }

    @Override
    public net.zylk.liferay.portal.model.Subscriptor editSubscriptor(
        long subscriptorId, java.lang.String name, java.lang.String surname,
        java.lang.String email, java.lang.String languageId, long[] categoryIds)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _subscriptorLocalService.editSubscriptor(subscriptorId, name,
            surname, email, languageId, categoryIds);
    }

    @Override
    public void importSubscriptor(long companyId, long groupId,
        java.io.InputStream csvFile, long[] categoryIds)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _subscriptorLocalService.importSubscriptor(companyId, groupId, csvFile,
            categoryIds);
    }

    @Override
    public void remove(long subscriptorId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _subscriptorLocalService.remove(subscriptorId);
    }

    @Override
    public java.util.List<net.zylk.liferay.portal.model.Subscriptor> findByKeywords(
        long companyId, long groupId, java.lang.String keywords, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _subscriptorLocalService.findByKeywords(companyId, groupId,
            keywords, start, end);
    }

    @Override
    public int countByKeywords(long companyId, long groupId,
        java.lang.String keywords)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _subscriptorLocalService.countByKeywords(companyId, groupId,
            keywords);
    }

    @Override
    public int countByCategoryId(long categoryId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _subscriptorLocalService.countByCategoryId(categoryId);
    }

    @Override
    public java.util.List<net.zylk.liferay.portal.model.Subscriptor> findByCategoryId(
        long categoryId, int start, int end)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _subscriptorLocalService.findByCategoryId(categoryId, start, end);
    }

    @Override
    public net.zylk.liferay.portal.model.Subscriptor findByEmailAndCompanyIdAndGroupId(
        long companyId, long groupId, java.lang.String email)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _subscriptorLocalService.findByEmailAndCompanyIdAndGroupId(companyId,
            groupId, email);
    }

    @Override
    public net.zylk.liferay.portal.model.Subscriptor findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _subscriptorLocalService.findByUuid(uuid);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public SubscriptorLocalService getWrappedSubscriptorLocalService() {
        return _subscriptorLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedSubscriptorLocalService(
        SubscriptorLocalService subscriptorLocalService) {
        _subscriptorLocalService = subscriptorLocalService;
    }

    @Override
    public SubscriptorLocalService getWrappedService() {
        return _subscriptorLocalService;
    }

    @Override
    public void setWrappedService(
        SubscriptorLocalService subscriptorLocalService) {
        _subscriptorLocalService = subscriptorLocalService;
    }
}
