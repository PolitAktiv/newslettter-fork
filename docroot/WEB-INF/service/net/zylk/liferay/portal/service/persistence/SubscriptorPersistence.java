package net.zylk.liferay.portal.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import net.zylk.liferay.portal.model.Subscriptor;

/**
 * The persistence interface for the subscriptor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author zylk.net
 * @see SubscriptorPersistenceImpl
 * @see SubscriptorUtil
 * @generated
 */
public interface SubscriptorPersistence extends BasePersistence<Subscriptor> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link SubscriptorUtil} to access the subscriptor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the subscriptors where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching subscriptors
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.zylk.liferay.portal.model.Subscriptor> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the subscriptors where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.SubscriptorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of subscriptors
    * @param end the upper bound of the range of subscriptors (not inclusive)
    * @return the range of matching subscriptors
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.zylk.liferay.portal.model.Subscriptor> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the subscriptors where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.SubscriptorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of subscriptors
    * @param end the upper bound of the range of subscriptors (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching subscriptors
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.zylk.liferay.portal.model.Subscriptor> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first subscriptor in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscriptor
    * @throws net.zylk.liferay.portal.NoSuchSubscriptorException if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Subscriptor findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorException;

    /**
    * Returns the first subscriptor in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscriptor, or <code>null</code> if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Subscriptor fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last subscriptor in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscriptor
    * @throws net.zylk.liferay.portal.NoSuchSubscriptorException if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Subscriptor findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorException;

    /**
    * Returns the last subscriptor in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscriptor, or <code>null</code> if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Subscriptor fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the subscriptors before and after the current subscriptor in the ordered set where uuid = &#63;.
    *
    * @param subscriptorId the primary key of the current subscriptor
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next subscriptor
    * @throws net.zylk.liferay.portal.NoSuchSubscriptorException if a subscriptor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Subscriptor[] findByUuid_PrevAndNext(
        long subscriptorId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorException;

    /**
    * Removes all the subscriptors where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of subscriptors where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching subscriptors
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the subscriptor where uuid = &#63; and groupId = &#63; or throws a {@link net.zylk.liferay.portal.NoSuchSubscriptorException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching subscriptor
    * @throws net.zylk.liferay.portal.NoSuchSubscriptorException if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Subscriptor findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorException;

    /**
    * Returns the subscriptor where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching subscriptor, or <code>null</code> if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Subscriptor fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the subscriptor where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching subscriptor, or <code>null</code> if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Subscriptor fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the subscriptor where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the subscriptor that was removed
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Subscriptor removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorException;

    /**
    * Returns the number of subscriptors where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching subscriptors
    * @throws SystemException if a system exception occurred
    */
    public int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the subscriptors where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching subscriptors
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.zylk.liferay.portal.model.Subscriptor> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the subscriptors where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.SubscriptorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of subscriptors
    * @param end the upper bound of the range of subscriptors (not inclusive)
    * @return the range of matching subscriptors
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.zylk.liferay.portal.model.Subscriptor> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the subscriptors where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.SubscriptorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of subscriptors
    * @param end the upper bound of the range of subscriptors (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching subscriptors
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.zylk.liferay.portal.model.Subscriptor> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first subscriptor in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscriptor
    * @throws net.zylk.liferay.portal.NoSuchSubscriptorException if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Subscriptor findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorException;

    /**
    * Returns the first subscriptor in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscriptor, or <code>null</code> if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Subscriptor fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last subscriptor in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscriptor
    * @throws net.zylk.liferay.portal.NoSuchSubscriptorException if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Subscriptor findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorException;

    /**
    * Returns the last subscriptor in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscriptor, or <code>null</code> if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Subscriptor fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the subscriptors before and after the current subscriptor in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param subscriptorId the primary key of the current subscriptor
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next subscriptor
    * @throws net.zylk.liferay.portal.NoSuchSubscriptorException if a subscriptor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Subscriptor[] findByUuid_C_PrevAndNext(
        long subscriptorId, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorException;

    /**
    * Removes all the subscriptors where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of subscriptors where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching subscriptors
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the subscriptor where companyId = &#63; and groupId = &#63; and email = &#63; or throws a {@link net.zylk.liferay.portal.NoSuchSubscriptorException} if it could not be found.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param email the email
    * @return the matching subscriptor
    * @throws net.zylk.liferay.portal.NoSuchSubscriptorException if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Subscriptor findByEmailAndCompanyIdAndGroupId(
        long companyId, long groupId, java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorException;

    /**
    * Returns the subscriptor where companyId = &#63; and groupId = &#63; and email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param email the email
    * @return the matching subscriptor, or <code>null</code> if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Subscriptor fetchByEmailAndCompanyIdAndGroupId(
        long companyId, long groupId, java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the subscriptor where companyId = &#63; and groupId = &#63; and email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param email the email
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching subscriptor, or <code>null</code> if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Subscriptor fetchByEmailAndCompanyIdAndGroupId(
        long companyId, long groupId, java.lang.String email,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the subscriptor where companyId = &#63; and groupId = &#63; and email = &#63; from the database.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param email the email
    * @return the subscriptor that was removed
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Subscriptor removeByEmailAndCompanyIdAndGroupId(
        long companyId, long groupId, java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorException;

    /**
    * Returns the number of subscriptors where companyId = &#63; and groupId = &#63; and email = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param email the email
    * @return the number of matching subscriptors
    * @throws SystemException if a system exception occurred
    */
    public int countByEmailAndCompanyIdAndGroupId(long companyId, long groupId,
        java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the subscriptor in the entity cache if it is enabled.
    *
    * @param subscriptor the subscriptor
    */
    public void cacheResult(
        net.zylk.liferay.portal.model.Subscriptor subscriptor);

    /**
    * Caches the subscriptors in the entity cache if it is enabled.
    *
    * @param subscriptors the subscriptors
    */
    public void cacheResult(
        java.util.List<net.zylk.liferay.portal.model.Subscriptor> subscriptors);

    /**
    * Creates a new subscriptor with the primary key. Does not add the subscriptor to the database.
    *
    * @param subscriptorId the primary key for the new subscriptor
    * @return the new subscriptor
    */
    public net.zylk.liferay.portal.model.Subscriptor create(long subscriptorId);

    /**
    * Removes the subscriptor with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param subscriptorId the primary key of the subscriptor
    * @return the subscriptor that was removed
    * @throws net.zylk.liferay.portal.NoSuchSubscriptorException if a subscriptor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Subscriptor remove(long subscriptorId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorException;

    public net.zylk.liferay.portal.model.Subscriptor updateImpl(
        net.zylk.liferay.portal.model.Subscriptor subscriptor)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the subscriptor with the primary key or throws a {@link net.zylk.liferay.portal.NoSuchSubscriptorException} if it could not be found.
    *
    * @param subscriptorId the primary key of the subscriptor
    * @return the subscriptor
    * @throws net.zylk.liferay.portal.NoSuchSubscriptorException if a subscriptor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Subscriptor findByPrimaryKey(
        long subscriptorId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorException;

    /**
    * Returns the subscriptor with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param subscriptorId the primary key of the subscriptor
    * @return the subscriptor, or <code>null</code> if a subscriptor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Subscriptor fetchByPrimaryKey(
        long subscriptorId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the subscriptors.
    *
    * @return the subscriptors
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.zylk.liferay.portal.model.Subscriptor> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<net.zylk.liferay.portal.model.Subscriptor> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the subscriptors.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.SubscriptorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of subscriptors
    * @param end the upper bound of the range of subscriptors (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of subscriptors
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.zylk.liferay.portal.model.Subscriptor> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the subscriptors from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of subscriptors.
    *
    * @return the number of subscriptors
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
