package net.zylk.liferay.portal.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserSubscriptionLocalService}.
 *
 * @author zylk.net
 * @see UserSubscriptionLocalService
 * @generated
 */
public class UserSubscriptionLocalServiceWrapper
    implements UserSubscriptionLocalService,
        ServiceWrapper<UserSubscriptionLocalService> {
    private UserSubscriptionLocalService _userSubscriptionLocalService;

    public UserSubscriptionLocalServiceWrapper(
        UserSubscriptionLocalService userSubscriptionLocalService) {
        _userSubscriptionLocalService = userSubscriptionLocalService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _userSubscriptionLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _userSubscriptionLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _userSubscriptionLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public void requestSubscription(long companyId, long groupId,
        java.lang.String name, java.lang.String surname,
        java.lang.String email, java.lang.String languageId, long[] categoryIds)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _userSubscriptionLocalService.requestSubscription(companyId, groupId,
            name, surname, email, languageId, categoryIds);
    }

    @Override
    public net.zylk.liferay.portal.model.Subscriptor confirmSubscription(
        java.lang.String ticketKey)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _userSubscriptionLocalService.confirmSubscription(ticketKey);
    }

    @Override
    public net.zylk.liferay.portal.model.Subscriptor confirmUnsubscription(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _userSubscriptionLocalService.confirmUnsubscription(uuid);
    }

    @Override
    public java.lang.String generateUnsubscriptionUrl(long companyId,
        long groupId, java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _userSubscriptionLocalService.generateUnsubscriptionUrl(companyId,
            groupId, uuid);
    }

    @Override
    public com.liferay.portal.model.Ticket validateTicket(
        java.lang.String ticketKey) {
        return _userSubscriptionLocalService.validateTicket(ticketKey);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public UserSubscriptionLocalService getWrappedUserSubscriptionLocalService() {
        return _userSubscriptionLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedUserSubscriptionLocalService(
        UserSubscriptionLocalService userSubscriptionLocalService) {
        _userSubscriptionLocalService = userSubscriptionLocalService;
    }

    @Override
    public UserSubscriptionLocalService getWrappedService() {
        return _userSubscriptionLocalService;
    }

    @Override
    public void setWrappedService(
        UserSubscriptionLocalService userSubscriptionLocalService) {
        _userSubscriptionLocalService = userSubscriptionLocalService;
    }
}
