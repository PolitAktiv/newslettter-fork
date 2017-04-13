package net.zylk.liferay.portal.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for MailingSubscriptor. This utility wraps
 * {@link net.zylk.liferay.portal.service.impl.MailingSubscriptorLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author zylk.net
 * @see MailingSubscriptorLocalService
 * @see net.zylk.liferay.portal.service.base.MailingSubscriptorLocalServiceBaseImpl
 * @see net.zylk.liferay.portal.service.impl.MailingSubscriptorLocalServiceImpl
 * @generated
 */
public class MailingSubscriptorLocalServiceUtil {
    private static MailingSubscriptorLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link net.zylk.liferay.portal.service.impl.MailingSubscriptorLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the mailing subscriptor to the database. Also notifies the appropriate model listeners.
    *
    * @param mailingSubscriptor the mailing subscriptor
    * @return the mailing subscriptor that was added
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.MailingSubscriptor addMailingSubscriptor(
        net.zylk.liferay.portal.model.MailingSubscriptor mailingSubscriptor)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addMailingSubscriptor(mailingSubscriptor);
    }

    /**
    * Creates a new mailing subscriptor with the primary key. Does not add the mailing subscriptor to the database.
    *
    * @param mailingSubscriptorId the primary key for the new mailing subscriptor
    * @return the new mailing subscriptor
    */
    public static net.zylk.liferay.portal.model.MailingSubscriptor createMailingSubscriptor(
        long mailingSubscriptorId) {
        return getService().createMailingSubscriptor(mailingSubscriptorId);
    }

    /**
    * Deletes the mailing subscriptor with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param mailingSubscriptorId the primary key of the mailing subscriptor
    * @return the mailing subscriptor that was removed
    * @throws PortalException if a mailing subscriptor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.MailingSubscriptor deleteMailingSubscriptor(
        long mailingSubscriptorId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteMailingSubscriptor(mailingSubscriptorId);
    }

    /**
    * Deletes the mailing subscriptor from the database. Also notifies the appropriate model listeners.
    *
    * @param mailingSubscriptor the mailing subscriptor
    * @return the mailing subscriptor that was removed
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.MailingSubscriptor deleteMailingSubscriptor(
        net.zylk.liferay.portal.model.MailingSubscriptor mailingSubscriptor)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteMailingSubscriptor(mailingSubscriptor);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.MailingSubscriptorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static net.zylk.liferay.portal.model.MailingSubscriptor fetchMailingSubscriptor(
        long mailingSubscriptorId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchMailingSubscriptor(mailingSubscriptorId);
    }

    /**
    * Returns the mailing subscriptor with the primary key.
    *
    * @param mailingSubscriptorId the primary key of the mailing subscriptor
    * @return the mailing subscriptor
    * @throws PortalException if a mailing subscriptor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.MailingSubscriptor getMailingSubscriptor(
        long mailingSubscriptorId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getMailingSubscriptor(mailingSubscriptorId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<net.zylk.liferay.portal.model.MailingSubscriptor> getMailingSubscriptors(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getMailingSubscriptors(start, end);
    }

    /**
    * Returns the number of mailing subscriptors.
    *
    * @return the number of mailing subscriptors
    * @throws SystemException if a system exception occurred
    */
    public static int getMailingSubscriptorsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getMailingSubscriptorsCount();
    }

    /**
    * Updates the mailing subscriptor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param mailingSubscriptor the mailing subscriptor
    * @return the mailing subscriptor that was updated
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.MailingSubscriptor updateMailingSubscriptor(
        net.zylk.liferay.portal.model.MailingSubscriptor mailingSubscriptor)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateMailingSubscriptor(mailingSubscriptor);
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

    public static net.zylk.liferay.portal.model.MailingSubscriptor addMailingSubscriptor(
        long mailingId, java.lang.String email, java.lang.String emailSubject,
        java.lang.String emailBody, java.lang.String tokens,
        java.lang.String name, java.lang.String surname,
        java.lang.String languageId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .addMailingSubscriptor(mailingId, email, emailSubject,
            emailBody, tokens, name, surname, languageId);
    }

    public static java.util.List<net.zylk.liferay.portal.model.MailingSubscriptor> findByMailingIdAndKeywords(
        long mailingId, java.lang.String keywords, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .findByMailingIdAndKeywords(mailingId, keywords, start, end);
    }

    public static int countByMailingIdAndKeywords(long mailingId,
        java.lang.String keywords)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().countByMailingIdAndKeywords(mailingId, keywords);
    }

    public static void clearService() {
        _service = null;
    }

    public static MailingSubscriptorLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    MailingSubscriptorLocalService.class.getName());

            if (invokableLocalService instanceof MailingSubscriptorLocalService) {
                _service = (MailingSubscriptorLocalService) invokableLocalService;
            } else {
                _service = new MailingSubscriptorLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(MailingSubscriptorLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(MailingSubscriptorLocalService service) {
    }
}
