package net.zylk.liferay.portal.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MailingSubscriptorLocalService}.
 *
 * @author zylk.net
 * @see MailingSubscriptorLocalService
 * @generated
 */
public class MailingSubscriptorLocalServiceWrapper
    implements MailingSubscriptorLocalService,
        ServiceWrapper<MailingSubscriptorLocalService> {
    private MailingSubscriptorLocalService _mailingSubscriptorLocalService;

    public MailingSubscriptorLocalServiceWrapper(
        MailingSubscriptorLocalService mailingSubscriptorLocalService) {
        _mailingSubscriptorLocalService = mailingSubscriptorLocalService;
    }

    /**
    * Adds the mailing subscriptor to the database. Also notifies the appropriate model listeners.
    *
    * @param mailingSubscriptor the mailing subscriptor
    * @return the mailing subscriptor that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.MailingSubscriptor addMailingSubscriptor(
        net.zylk.liferay.portal.model.MailingSubscriptor mailingSubscriptor)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mailingSubscriptorLocalService.addMailingSubscriptor(mailingSubscriptor);
    }

    /**
    * Creates a new mailing subscriptor with the primary key. Does not add the mailing subscriptor to the database.
    *
    * @param mailingSubscriptorId the primary key for the new mailing subscriptor
    * @return the new mailing subscriptor
    */
    @Override
    public net.zylk.liferay.portal.model.MailingSubscriptor createMailingSubscriptor(
        long mailingSubscriptorId) {
        return _mailingSubscriptorLocalService.createMailingSubscriptor(mailingSubscriptorId);
    }

    /**
    * Deletes the mailing subscriptor with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param mailingSubscriptorId the primary key of the mailing subscriptor
    * @return the mailing subscriptor that was removed
    * @throws PortalException if a mailing subscriptor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.MailingSubscriptor deleteMailingSubscriptor(
        long mailingSubscriptorId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _mailingSubscriptorLocalService.deleteMailingSubscriptor(mailingSubscriptorId);
    }

    /**
    * Deletes the mailing subscriptor from the database. Also notifies the appropriate model listeners.
    *
    * @param mailingSubscriptor the mailing subscriptor
    * @return the mailing subscriptor that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.MailingSubscriptor deleteMailingSubscriptor(
        net.zylk.liferay.portal.model.MailingSubscriptor mailingSubscriptor)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mailingSubscriptorLocalService.deleteMailingSubscriptor(mailingSubscriptor);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _mailingSubscriptorLocalService.dynamicQuery();
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
        return _mailingSubscriptorLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.MailingSubscriptorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _mailingSubscriptorLocalService.dynamicQuery(dynamicQuery,
            start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.MailingSubscriptorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _mailingSubscriptorLocalService.dynamicQuery(dynamicQuery,
            start, end, orderByComparator);
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
        return _mailingSubscriptorLocalService.dynamicQueryCount(dynamicQuery);
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
        return _mailingSubscriptorLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public net.zylk.liferay.portal.model.MailingSubscriptor fetchMailingSubscriptor(
        long mailingSubscriptorId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mailingSubscriptorLocalService.fetchMailingSubscriptor(mailingSubscriptorId);
    }

    /**
    * Returns the mailing subscriptor with the primary key.
    *
    * @param mailingSubscriptorId the primary key of the mailing subscriptor
    * @return the mailing subscriptor
    * @throws PortalException if a mailing subscriptor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.MailingSubscriptor getMailingSubscriptor(
        long mailingSubscriptorId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _mailingSubscriptorLocalService.getMailingSubscriptor(mailingSubscriptorId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _mailingSubscriptorLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the mailing subscriptors.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.MailingSubscriptorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of mailing subscriptors
    * @param end the upper bound of the range of mailing subscriptors (not inclusive)
    * @return the range of mailing subscriptors
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<net.zylk.liferay.portal.model.MailingSubscriptor> getMailingSubscriptors(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mailingSubscriptorLocalService.getMailingSubscriptors(start, end);
    }

    /**
    * Returns the number of mailing subscriptors.
    *
    * @return the number of mailing subscriptors
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getMailingSubscriptorsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mailingSubscriptorLocalService.getMailingSubscriptorsCount();
    }

    /**
    * Updates the mailing subscriptor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param mailingSubscriptor the mailing subscriptor
    * @return the mailing subscriptor that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.MailingSubscriptor updateMailingSubscriptor(
        net.zylk.liferay.portal.model.MailingSubscriptor mailingSubscriptor)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mailingSubscriptorLocalService.updateMailingSubscriptor(mailingSubscriptor);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _mailingSubscriptorLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _mailingSubscriptorLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _mailingSubscriptorLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public net.zylk.liferay.portal.model.MailingSubscriptor addMailingSubscriptor(
        long mailingId, java.lang.String email, java.lang.String emailSubject,
        java.lang.String emailBody, java.lang.String tokens,
        java.lang.String name, java.lang.String surname,
        java.lang.String languageId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mailingSubscriptorLocalService.addMailingSubscriptor(mailingId,
            email, emailSubject, emailBody, tokens, name, surname, languageId);
    }

    @Override
    public java.util.List<net.zylk.liferay.portal.model.MailingSubscriptor> findByMailingIdAndKeywords(
        long mailingId, java.lang.String keywords, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mailingSubscriptorLocalService.findByMailingIdAndKeywords(mailingId,
            keywords, start, end);
    }

    @Override
    public int countByMailingIdAndKeywords(long mailingId,
        java.lang.String keywords)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mailingSubscriptorLocalService.countByMailingIdAndKeywords(mailingId,
            keywords);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public MailingSubscriptorLocalService getWrappedMailingSubscriptorLocalService() {
        return _mailingSubscriptorLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedMailingSubscriptorLocalService(
        MailingSubscriptorLocalService mailingSubscriptorLocalService) {
        _mailingSubscriptorLocalService = mailingSubscriptorLocalService;
    }

    @Override
    public MailingSubscriptorLocalService getWrappedService() {
        return _mailingSubscriptorLocalService;
    }

    @Override
    public void setWrappedService(
        MailingSubscriptorLocalService mailingSubscriptorLocalService) {
        _mailingSubscriptorLocalService = mailingSubscriptorLocalService;
    }
}
