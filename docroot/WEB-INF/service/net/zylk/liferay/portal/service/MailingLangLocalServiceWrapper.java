package net.zylk.liferay.portal.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MailingLangLocalService}.
 *
 * @author zylk.net
 * @see MailingLangLocalService
 * @generated
 */
public class MailingLangLocalServiceWrapper implements MailingLangLocalService,
    ServiceWrapper<MailingLangLocalService> {
    private MailingLangLocalService _mailingLangLocalService;

    public MailingLangLocalServiceWrapper(
        MailingLangLocalService mailingLangLocalService) {
        _mailingLangLocalService = mailingLangLocalService;
    }

    /**
    * Adds the mailing lang to the database. Also notifies the appropriate model listeners.
    *
    * @param mailingLang the mailing lang
    * @return the mailing lang that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.MailingLang addMailingLang(
        net.zylk.liferay.portal.model.MailingLang mailingLang)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mailingLangLocalService.addMailingLang(mailingLang);
    }

    /**
    * Creates a new mailing lang with the primary key. Does not add the mailing lang to the database.
    *
    * @param mailingLangId the primary key for the new mailing lang
    * @return the new mailing lang
    */
    @Override
    public net.zylk.liferay.portal.model.MailingLang createMailingLang(
        long mailingLangId) {
        return _mailingLangLocalService.createMailingLang(mailingLangId);
    }

    /**
    * Deletes the mailing lang with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param mailingLangId the primary key of the mailing lang
    * @return the mailing lang that was removed
    * @throws PortalException if a mailing lang with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.MailingLang deleteMailingLang(
        long mailingLangId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _mailingLangLocalService.deleteMailingLang(mailingLangId);
    }

    /**
    * Deletes the mailing lang from the database. Also notifies the appropriate model listeners.
    *
    * @param mailingLang the mailing lang
    * @return the mailing lang that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.MailingLang deleteMailingLang(
        net.zylk.liferay.portal.model.MailingLang mailingLang)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mailingLangLocalService.deleteMailingLang(mailingLang);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _mailingLangLocalService.dynamicQuery();
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
        return _mailingLangLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.MailingLangModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _mailingLangLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.MailingLangModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _mailingLangLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _mailingLangLocalService.dynamicQueryCount(dynamicQuery);
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
        return _mailingLangLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public net.zylk.liferay.portal.model.MailingLang fetchMailingLang(
        long mailingLangId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mailingLangLocalService.fetchMailingLang(mailingLangId);
    }

    /**
    * Returns the mailing lang with the primary key.
    *
    * @param mailingLangId the primary key of the mailing lang
    * @return the mailing lang
    * @throws PortalException if a mailing lang with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.MailingLang getMailingLang(
        long mailingLangId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _mailingLangLocalService.getMailingLang(mailingLangId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _mailingLangLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the mailing langs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.MailingLangModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of mailing langs
    * @param end the upper bound of the range of mailing langs (not inclusive)
    * @return the range of mailing langs
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<net.zylk.liferay.portal.model.MailingLang> getMailingLangs(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mailingLangLocalService.getMailingLangs(start, end);
    }

    /**
    * Returns the number of mailing langs.
    *
    * @return the number of mailing langs
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getMailingLangsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mailingLangLocalService.getMailingLangsCount();
    }

    /**
    * Updates the mailing lang in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param mailingLang the mailing lang
    * @return the mailing lang that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.zylk.liferay.portal.model.MailingLang updateMailingLang(
        net.zylk.liferay.portal.model.MailingLang mailingLang)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mailingLangLocalService.updateMailingLang(mailingLang);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _mailingLangLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _mailingLangLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _mailingLangLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public net.zylk.liferay.portal.model.MailingLang addMailingLang(
        long mailingId, java.lang.String languageId,
        java.lang.String emailSubjectPre, java.lang.String emailBodyPre)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mailingLangLocalService.addMailingLang(mailingId, languageId,
            emailSubjectPre, emailBodyPre);
    }

    @Override
    public net.zylk.liferay.portal.model.MailingLang findByMailingIdAndLanguageId(
        long mailingId, java.lang.String languageId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mailingLangLocalService.findByMailingIdAndLanguageId(mailingId,
            languageId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public MailingLangLocalService getWrappedMailingLangLocalService() {
        return _mailingLangLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedMailingLangLocalService(
        MailingLangLocalService mailingLangLocalService) {
        _mailingLangLocalService = mailingLangLocalService;
    }

    @Override
    public MailingLangLocalService getWrappedService() {
        return _mailingLangLocalService;
    }

    @Override
    public void setWrappedService(
        MailingLangLocalService mailingLangLocalService) {
        _mailingLangLocalService = mailingLangLocalService;
    }
}
