package net.zylk.liferay.portal.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for MailingLang. This utility wraps
 * {@link net.zylk.liferay.portal.service.impl.MailingLangLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author zylk.net
 * @see MailingLangLocalService
 * @see net.zylk.liferay.portal.service.base.MailingLangLocalServiceBaseImpl
 * @see net.zylk.liferay.portal.service.impl.MailingLangLocalServiceImpl
 * @generated
 */
public class MailingLangLocalServiceUtil {
    private static MailingLangLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link net.zylk.liferay.portal.service.impl.MailingLangLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the mailing lang to the database. Also notifies the appropriate model listeners.
    *
    * @param mailingLang the mailing lang
    * @return the mailing lang that was added
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.MailingLang addMailingLang(
        net.zylk.liferay.portal.model.MailingLang mailingLang)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addMailingLang(mailingLang);
    }

    /**
    * Creates a new mailing lang with the primary key. Does not add the mailing lang to the database.
    *
    * @param mailingLangId the primary key for the new mailing lang
    * @return the new mailing lang
    */
    public static net.zylk.liferay.portal.model.MailingLang createMailingLang(
        long mailingLangId) {
        return getService().createMailingLang(mailingLangId);
    }

    /**
    * Deletes the mailing lang with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param mailingLangId the primary key of the mailing lang
    * @return the mailing lang that was removed
    * @throws PortalException if a mailing lang with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.MailingLang deleteMailingLang(
        long mailingLangId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteMailingLang(mailingLangId);
    }

    /**
    * Deletes the mailing lang from the database. Also notifies the appropriate model listeners.
    *
    * @param mailingLang the mailing lang
    * @return the mailing lang that was removed
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.MailingLang deleteMailingLang(
        net.zylk.liferay.portal.model.MailingLang mailingLang)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteMailingLang(mailingLang);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.MailingLangModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static net.zylk.liferay.portal.model.MailingLang fetchMailingLang(
        long mailingLangId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchMailingLang(mailingLangId);
    }

    /**
    * Returns the mailing lang with the primary key.
    *
    * @param mailingLangId the primary key of the mailing lang
    * @return the mailing lang
    * @throws PortalException if a mailing lang with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.MailingLang getMailingLang(
        long mailingLangId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getMailingLang(mailingLangId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<net.zylk.liferay.portal.model.MailingLang> getMailingLangs(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getMailingLangs(start, end);
    }

    /**
    * Returns the number of mailing langs.
    *
    * @return the number of mailing langs
    * @throws SystemException if a system exception occurred
    */
    public static int getMailingLangsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getMailingLangsCount();
    }

    /**
    * Updates the mailing lang in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param mailingLang the mailing lang
    * @return the mailing lang that was updated
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.MailingLang updateMailingLang(
        net.zylk.liferay.portal.model.MailingLang mailingLang)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateMailingLang(mailingLang);
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

    public static net.zylk.liferay.portal.model.MailingLang addMailingLang(
        long mailingId, java.lang.String languageId,
        java.lang.String emailSubjectPre, java.lang.String emailBodyPre)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .addMailingLang(mailingId, languageId, emailSubjectPre,
            emailBodyPre);
    }

    public static net.zylk.liferay.portal.model.MailingLang findByMailingIdAndLanguageId(
        long mailingId, java.lang.String languageId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByMailingIdAndLanguageId(mailingId, languageId);
    }

    public static void clearService() {
        _service = null;
    }

    public static MailingLangLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    MailingLangLocalService.class.getName());

            if (invokableLocalService instanceof MailingLangLocalService) {
                _service = (MailingLangLocalService) invokableLocalService;
            } else {
                _service = new MailingLangLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(MailingLangLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(MailingLangLocalService service) {
    }
}
