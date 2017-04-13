package net.zylk.liferay.portal.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service interface for UserSubscription. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author zylk.net
 * @see UserSubscriptionLocalServiceUtil
 * @see net.zylk.liferay.portal.service.base.UserSubscriptionLocalServiceBaseImpl
 * @see net.zylk.liferay.portal.service.impl.UserSubscriptionLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface UserSubscriptionLocalService extends BaseLocalService,
    InvokableLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link UserSubscriptionLocalServiceUtil} to access the user subscription local service. Add custom service methods to {@link net.zylk.liferay.portal.service.impl.UserSubscriptionLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    public void requestSubscription(long companyId, long groupId,
        java.lang.String name, java.lang.String surname,
        java.lang.String email, java.lang.String languageId, long[] categoryIds)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public net.zylk.liferay.portal.model.Subscriptor confirmSubscription(
        java.lang.String ticketKey)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public net.zylk.liferay.portal.model.Subscriptor confirmUnsubscription(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public java.lang.String generateUnsubscriptionUrl(long companyId,
        long groupId, java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.portal.model.Ticket validateTicket(
        java.lang.String ticketKey);
}
