package net.zylk.liferay.portal.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MailingLocalService}.
 *
 * @author zylk.net
 * @see MailingLocalService
 * @generated
 */
public class MailingLocalServiceWrapper implements MailingLocalService,
    ServiceWrapper<MailingLocalService> {
    private MailingLocalService _mailingLocalService;

    public MailingLocalServiceWrapper(MailingLocalService mailingLocalService) {
        _mailingLocalService = mailingLocalService;
    }

    /**
    * Adds the mailing to the database. Also notifies the appropriate model listeners.
    *
    * @param mailing the mailing
    * @return the mailing that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.Mailing addMailing(
        net.zylk.liferay.portal.model.Mailing mailing)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mailingLocalService.addMailing(mailing);
    }

    /**
    * Creates a new mailing with the primary key. Does not add the mailing to the database.
    *
    * @param mailingId the primary key for the new mailing
    * @return the new mailing
    */
    @Override
    public net.zylk.liferay.portal.model.Mailing createMailing(long mailingId) {
        return _mailingLocalService.createMailing(mailingId);
    }

    /**
    * Deletes the mailing with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param mailingId the primary key of the mailing
    * @return the mailing that was removed
    * @throws PortalException if a mailing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.Mailing deleteMailing(long mailingId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _mailingLocalService.deleteMailing(mailingId);
    }

    /**
    * Deletes the mailing from the database. Also notifies the appropriate model listeners.
    *
    * @param mailing the mailing
    * @return the mailing that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.Mailing deleteMailing(
        net.zylk.liferay.portal.model.Mailing mailing)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mailingLocalService.deleteMailing(mailing);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _mailingLocalService.dynamicQuery();
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
        return _mailingLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.MailingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _mailingLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.MailingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _mailingLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _mailingLocalService.dynamicQueryCount(dynamicQuery);
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
        return _mailingLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public net.zylk.liferay.portal.model.Mailing fetchMailing(long mailingId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mailingLocalService.fetchMailing(mailingId);
    }

    /**
    * Returns the mailing with the primary key.
    *
    * @param mailingId the primary key of the mailing
    * @return the mailing
    * @throws PortalException if a mailing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.Mailing getMailing(long mailingId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _mailingLocalService.getMailing(mailingId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _mailingLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the mailings.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.MailingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of mailings
    * @param end the upper bound of the range of mailings (not inclusive)
    * @return the range of mailings
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<net.zylk.liferay.portal.model.Mailing> getMailings(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mailingLocalService.getMailings(start, end);
    }

    /**
    * Returns the number of mailings.
    *
    * @return the number of mailings
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getMailingsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mailingLocalService.getMailingsCount();
    }

    /**
    * Updates the mailing in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param mailing the mailing
    * @return the mailing that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.Mailing updateMailing(
        net.zylk.liferay.portal.model.Mailing mailing)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mailingLocalService.updateMailing(mailing);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _mailingLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _mailingLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _mailingLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public net.zylk.liferay.portal.model.Mailing startMailing(long companyId,
        long groupId, long newsletterId, java.lang.String newsletterName,
        java.lang.String emailFromName, java.lang.String emailFromAddress,
        java.util.Date startDate, java.util.Date fromDate, boolean isScheduled)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mailingLocalService.startMailing(companyId, groupId,
            newsletterId, newsletterName, emailFromName, emailFromAddress,
            startDate, fromDate, isScheduled);
    }

    @Override
    public net.zylk.liferay.portal.model.Mailing endMailing(long mailingId,
        int status, int emailCount)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _mailingLocalService.endMailing(mailingId, status, emailCount);
    }

    /**
    * Comprueba si la newsletter necesita ser enviada en este instante. Y en tal caso devuelve un Date.
    * Si no necesita ser enviada devuelve null.
    *
    * @param newsletter
    * @return
    * @throws SystemException
    */
    @Override
    public java.util.Date isExecutionRequired(
        net.zylk.liferay.portal.model.Newsletter newsletter)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mailingLocalService.isExecutionRequired(newsletter);
    }

    @Override
    public java.util.List<net.zylk.liferay.portal.model.Mailing> findByCompanyIdAndGroupId(
        long companyId, long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mailingLocalService.findByCompanyIdAndGroupId(companyId,
            groupId, start, end);
    }

    @Override
    public int countByCompanyIdAndGroupId(long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mailingLocalService.countByCompanyIdAndGroupId(companyId,
            groupId);
    }

    @Override
    public java.util.List<net.zylk.liferay.portal.model.Mailing> findByNewsletterId(
        long newsletterId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mailingLocalService.findByNewsletterId(newsletterId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public MailingLocalService getWrappedMailingLocalService() {
        return _mailingLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedMailingLocalService(
        MailingLocalService mailingLocalService) {
        _mailingLocalService = mailingLocalService;
    }

    @Override
    public MailingLocalService getWrappedService() {
        return _mailingLocalService;
    }

    @Override
    public void setWrappedService(MailingLocalService mailingLocalService) {
        _mailingLocalService = mailingLocalService;
    }
}
