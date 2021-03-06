package net.zylk.liferay.portal.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link NewsletterLocalService}.
 *
 * @author zylk.net
 * @see NewsletterLocalService
 * @generated
 */
public class NewsletterLocalServiceWrapper implements NewsletterLocalService,
    ServiceWrapper<NewsletterLocalService> {
    private NewsletterLocalService _newsletterLocalService;

    public NewsletterLocalServiceWrapper(
        NewsletterLocalService newsletterLocalService) {
        _newsletterLocalService = newsletterLocalService;
    }

    /**
    * Adds the newsletter to the database. Also notifies the appropriate model listeners.
    *
    * @param newsletter the newsletter
    * @return the newsletter that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.Newsletter addNewsletter(
        net.zylk.liferay.portal.model.Newsletter newsletter)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.addNewsletter(newsletter);
    }

    /**
    * Creates a new newsletter with the primary key. Does not add the newsletter to the database.
    *
    * @param newsletterId the primary key for the new newsletter
    * @return the new newsletter
    */
    @Override
    public net.zylk.liferay.portal.model.Newsletter createNewsletter(
        long newsletterId) {
        return _newsletterLocalService.createNewsletter(newsletterId);
    }

    /**
    * Deletes the newsletter with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param newsletterId the primary key of the newsletter
    * @return the newsletter that was removed
    * @throws PortalException if a newsletter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.Newsletter deleteNewsletter(
        long newsletterId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.deleteNewsletter(newsletterId);
    }

    /**
    * Deletes the newsletter from the database. Also notifies the appropriate model listeners.
    *
    * @param newsletter the newsletter
    * @return the newsletter that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.Newsletter deleteNewsletter(
        net.zylk.liferay.portal.model.Newsletter newsletter)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.deleteNewsletter(newsletter);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _newsletterLocalService.dynamicQuery();
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
        return _newsletterLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _newsletterLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _newsletterLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _newsletterLocalService.dynamicQueryCount(dynamicQuery);
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
        return _newsletterLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public net.zylk.liferay.portal.model.Newsletter fetchNewsletter(
        long newsletterId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.fetchNewsletter(newsletterId);
    }

    /**
    * Returns the newsletter with the primary key.
    *
    * @param newsletterId the primary key of the newsletter
    * @return the newsletter
    * @throws PortalException if a newsletter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.Newsletter getNewsletter(
        long newsletterId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.getNewsletter(newsletterId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the newsletters.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of newsletters
    * @param end the upper bound of the range of newsletters (not inclusive)
    * @return the range of newsletters
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<net.zylk.liferay.portal.model.Newsletter> getNewsletters(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.getNewsletters(start, end);
    }

    /**
    * Returns the number of newsletters.
    *
    * @return the number of newsletters
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getNewslettersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.getNewslettersCount();
    }

    /**
    * Updates the newsletter in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param newsletter the newsletter
    * @return the newsletter that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.Newsletter updateNewsletter(
        net.zylk.liferay.portal.model.Newsletter newsletter)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.updateNewsletter(newsletter);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _newsletterLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _newsletterLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _newsletterLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public net.zylk.liferay.portal.model.Newsletter addNewsletter(
        long companyId, long groupId, java.lang.String name,
        java.lang.String description, long categoryId,
        java.util.Map<java.util.Locale, java.lang.String> subjectMap,
        java.lang.String articleId, long articleGroupId,
        boolean schedulerActive, int schedulerType, java.util.Date schedulerDate)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.addNewsletter(companyId, groupId, name,
            description, categoryId, subjectMap, articleId, articleGroupId,
            schedulerActive, schedulerType, schedulerDate);
    }

    @Override
    public net.zylk.liferay.portal.model.Newsletter editNewsletter(
        long newsletterId, java.lang.String name, java.lang.String description,
        long categoryId,
        java.util.Map<java.util.Locale, java.lang.String> subjectMap,
        java.lang.String articleId, long articleGroupId,
        boolean schedulerActive, int schedulerType, java.util.Date schedulerDate)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.editNewsletter(newsletterId, name,
            description, categoryId, subjectMap, articleId, articleGroupId,
            schedulerActive, schedulerType, schedulerDate);
    }

    @Override
    public void remove(long newsletterId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _newsletterLocalService.remove(newsletterId);
    }

    @Override
    public java.util.List<net.zylk.liferay.portal.model.Newsletter> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.findAll();
    }

    @Override
    public java.util.List<net.zylk.liferay.portal.model.Newsletter> findByCompanyIdAndGroupId(
        long companyId, long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.findByCompanyIdAndGroupId(companyId,
            groupId, start, end);
    }

    @Override
    public int countByCompanyIdAndGroupId(long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.countByCompanyIdAndGroupId(companyId,
            groupId);
    }

    /**
    * El themeDisplay no es necesario pero lo mantengo para pruebas.
    */
    @Override
    public java.lang.String preview(long newsletterId,
        java.lang.String languageId,
        com.liferay.portal.theme.ThemeDisplay themeDisplay)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.preview(newsletterId, languageId,
            themeDisplay);
    }

    @Override
    public java.lang.String viewOnline(long uuid, long mailingId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.viewOnline(uuid, mailingId);
    }

    @Override
    public java.lang.String viewArchive(long mailingSubscriptorId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.viewArchive(mailingSubscriptorId);
    }

    @Override
    public void send(long newsletterId, java.util.Date startDate,
        boolean isScheduled)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _newsletterLocalService.send(newsletterId, startDate, isScheduled);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public NewsletterLocalService getWrappedNewsletterLocalService() {
        return _newsletterLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedNewsletterLocalService(
        NewsletterLocalService newsletterLocalService) {
        _newsletterLocalService = newsletterLocalService;
    }

    @Override
    public NewsletterLocalService getWrappedService() {
        return _newsletterLocalService;
    }

    @Override
    public void setWrappedService(NewsletterLocalService newsletterLocalService) {
        _newsletterLocalService = newsletterLocalService;
    }
}
