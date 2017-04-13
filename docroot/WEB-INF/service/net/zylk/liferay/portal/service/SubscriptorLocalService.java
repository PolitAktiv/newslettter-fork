package net.zylk.liferay.portal.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for Subscriptor. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author zylk.net
 * @see SubscriptorLocalServiceUtil
 * @see net.zylk.liferay.portal.service.base.SubscriptorLocalServiceBaseImpl
 * @see net.zylk.liferay.portal.service.impl.SubscriptorLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface SubscriptorLocalService extends BaseLocalService,
    InvokableLocalService, PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link SubscriptorLocalServiceUtil} to access the subscriptor local service. Add custom service methods to {@link net.zylk.liferay.portal.service.impl.SubscriptorLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the subscriptor to the database. Also notifies the appropriate model listeners.
    *
    * @param subscriptor the subscriptor
    * @return the subscriptor that was added
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Subscriptor addSubscriptor(
        net.zylk.liferay.portal.model.Subscriptor subscriptor)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new subscriptor with the primary key. Does not add the subscriptor to the database.
    *
    * @param subscriptorId the primary key for the new subscriptor
    * @return the new subscriptor
    */
    public net.zylk.liferay.portal.model.Subscriptor createSubscriptor(
        long subscriptorId);

    /**
    * Deletes the subscriptor with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param subscriptorId the primary key of the subscriptor
    * @return the subscriptor that was removed
    * @throws PortalException if a subscriptor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Subscriptor deleteSubscriptor(
        long subscriptorId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the subscriptor from the database. Also notifies the appropriate model listeners.
    *
    * @param subscriptor the subscriptor
    * @return the subscriptor that was removed
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Subscriptor deleteSubscriptor(
        net.zylk.liferay.portal.model.Subscriptor subscriptor)
        throws com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

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
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public net.zylk.liferay.portal.model.Subscriptor fetchSubscriptor(
        long subscriptorId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the subscriptor with the matching UUID and company.
    *
    * @param uuid the subscriptor's UUID
    * @param companyId the primary key of the company
    * @return the matching subscriptor, or <code>null</code> if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public net.zylk.liferay.portal.model.Subscriptor fetchSubscriptorByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the subscriptor matching the UUID and group.
    *
    * @param uuid the subscriptor's UUID
    * @param groupId the primary key of the group
    * @return the matching subscriptor, or <code>null</code> if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public net.zylk.liferay.portal.model.Subscriptor fetchSubscriptorByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the subscriptor with the primary key.
    *
    * @param subscriptorId the primary key of the subscriptor
    * @return the subscriptor
    * @throws PortalException if a subscriptor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public net.zylk.liferay.portal.model.Subscriptor getSubscriptor(
        long subscriptorId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the subscriptor with the matching UUID and company.
    *
    * @param uuid the subscriptor's UUID
    * @param companyId the primary key of the company
    * @return the matching subscriptor
    * @throws PortalException if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public net.zylk.liferay.portal.model.Subscriptor getSubscriptorByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the subscriptor matching the UUID and group.
    *
    * @param uuid the subscriptor's UUID
    * @param groupId the primary key of the group
    * @return the matching subscriptor
    * @throws PortalException if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public net.zylk.liferay.portal.model.Subscriptor getSubscriptorByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<net.zylk.liferay.portal.model.Subscriptor> getSubscriptors(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of subscriptors.
    *
    * @return the number of subscriptors
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getSubscriptorsCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the subscriptor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param subscriptor the subscriptor
    * @return the subscriptor that was updated
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Subscriptor updateSubscriptor(
        net.zylk.liferay.portal.model.Subscriptor subscriptor)
        throws com.liferay.portal.kernel.exception.SystemException;

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

    public net.zylk.liferay.portal.model.Subscriptor addSubscriptor(
        long companyId, long groupId, java.lang.String name,
        java.lang.String surname, java.lang.String email,
        java.lang.String languageId, long[] categoryIds, boolean selfSubscribe)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public net.zylk.liferay.portal.model.Subscriptor editSubscriptor(
        long subscriptorId, java.lang.String name, java.lang.String surname,
        java.lang.String email, java.lang.String languageId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public net.zylk.liferay.portal.model.Subscriptor editSubscriptor(
        long subscriptorId, java.lang.String name, java.lang.String surname,
        java.lang.String email, java.lang.String languageId, long[] categoryIds)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public void importSubscriptor(long companyId, long groupId,
        java.io.InputStream csvFile, long[] categoryIds)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public void remove(long subscriptorId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<net.zylk.liferay.portal.model.Subscriptor> findByKeywords(
        long companyId, long groupId, java.lang.String keywords, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    public int countByKeywords(long companyId, long groupId,
        java.lang.String keywords)
        throws com.liferay.portal.kernel.exception.SystemException;

    public int countByCategoryId(long categoryId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<net.zylk.liferay.portal.model.Subscriptor> findByCategoryId(
        long categoryId, int start, int end)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public net.zylk.liferay.portal.model.Subscriptor findByEmailAndCompanyIdAndGroupId(
        long companyId, long groupId, java.lang.String email)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public net.zylk.liferay.portal.model.Subscriptor findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;
}
