package net.zylk.liferay.portal.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import net.zylk.liferay.portal.model.Subscriptor;

import java.util.List;

/**
 * The persistence utility for the subscriptor service. This utility wraps {@link SubscriptorPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author zylk.net
 * @see SubscriptorPersistence
 * @see SubscriptorPersistenceImpl
 * @generated
 */
public class SubscriptorUtil {
    private static SubscriptorPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Subscriptor subscriptor) {
        getPersistence().clearCache(subscriptor);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Subscriptor> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Subscriptor> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Subscriptor> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Subscriptor update(Subscriptor subscriptor)
        throws SystemException {
        return getPersistence().update(subscriptor);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Subscriptor update(Subscriptor subscriptor,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(subscriptor, serviceContext);
    }

    /**
    * Returns all the subscriptors where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching subscriptors
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.zylk.liferay.portal.model.Subscriptor> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid);
    }

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
    public static java.util.List<net.zylk.liferay.portal.model.Subscriptor> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
    }

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
    public static java.util.List<net.zylk.liferay.portal.model.Subscriptor> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end, orderByComparator);
    }

    /**
    * Returns the first subscriptor in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscriptor
    * @throws net.zylk.liferay.portal.NoSuchSubscriptorException if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.Subscriptor findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorException {
        return getPersistence().findByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the first subscriptor in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscriptor, or <code>null</code> if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.Subscriptor fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the last subscriptor in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscriptor
    * @throws net.zylk.liferay.portal.NoSuchSubscriptorException if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.Subscriptor findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorException {
        return getPersistence().findByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the last subscriptor in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscriptor, or <code>null</code> if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.Subscriptor fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
    }

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
    public static net.zylk.liferay.portal.model.Subscriptor[] findByUuid_PrevAndNext(
        long subscriptorId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorException {
        return getPersistence()
                   .findByUuid_PrevAndNext(subscriptorId, uuid,
            orderByComparator);
    }

    /**
    * Removes all the subscriptors where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    /**
    * Returns the number of subscriptors where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching subscriptors
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid(uuid);
    }

    /**
    * Returns the subscriptor where uuid = &#63; and groupId = &#63; or throws a {@link net.zylk.liferay.portal.NoSuchSubscriptorException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching subscriptor
    * @throws net.zylk.liferay.portal.NoSuchSubscriptorException if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.Subscriptor findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorException {
        return getPersistence().findByUUID_G(uuid, groupId);
    }

    /**
    * Returns the subscriptor where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching subscriptor, or <code>null</code> if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.Subscriptor fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId);
    }

    /**
    * Returns the subscriptor where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching subscriptor, or <code>null</code> if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.Subscriptor fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
    }

    /**
    * Removes the subscriptor where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the subscriptor that was removed
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.Subscriptor removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorException {
        return getPersistence().removeByUUID_G(uuid, groupId);
    }

    /**
    * Returns the number of subscriptors where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching subscriptors
    * @throws SystemException if a system exception occurred
    */
    public static int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUUID_G(uuid, groupId);
    }

    /**
    * Returns all the subscriptors where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching subscriptors
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.zylk.liferay.portal.model.Subscriptor> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId);
    }

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
    public static java.util.List<net.zylk.liferay.portal.model.Subscriptor> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId, start, end);
    }

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
    public static java.util.List<net.zylk.liferay.portal.model.Subscriptor> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
    }

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
    public static net.zylk.liferay.portal.model.Subscriptor findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorException {
        return getPersistence()
                   .findByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the first subscriptor in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscriptor, or <code>null</code> if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.Subscriptor fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
    }

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
    public static net.zylk.liferay.portal.model.Subscriptor findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorException {
        return getPersistence()
                   .findByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last subscriptor in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscriptor, or <code>null</code> if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.Subscriptor fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
    }

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
    public static net.zylk.liferay.portal.model.Subscriptor[] findByUuid_C_PrevAndNext(
        long subscriptorId, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorException {
        return getPersistence()
                   .findByUuid_C_PrevAndNext(subscriptorId, uuid, companyId,
            orderByComparator);
    }

    /**
    * Removes all the subscriptors where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid_C(uuid, companyId);
    }

    /**
    * Returns the number of subscriptors where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching subscriptors
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid_C(uuid, companyId);
    }

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
    public static net.zylk.liferay.portal.model.Subscriptor findByEmailAndCompanyIdAndGroupId(
        long companyId, long groupId, java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorException {
        return getPersistence()
                   .findByEmailAndCompanyIdAndGroupId(companyId, groupId, email);
    }

    /**
    * Returns the subscriptor where companyId = &#63; and groupId = &#63; and email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param email the email
    * @return the matching subscriptor, or <code>null</code> if a matching subscriptor could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.Subscriptor fetchByEmailAndCompanyIdAndGroupId(
        long companyId, long groupId, java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByEmailAndCompanyIdAndGroupId(companyId, groupId, email);
    }

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
    public static net.zylk.liferay.portal.model.Subscriptor fetchByEmailAndCompanyIdAndGroupId(
        long companyId, long groupId, java.lang.String email,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByEmailAndCompanyIdAndGroupId(companyId, groupId,
            email, retrieveFromCache);
    }

    /**
    * Removes the subscriptor where companyId = &#63; and groupId = &#63; and email = &#63; from the database.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param email the email
    * @return the subscriptor that was removed
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.Subscriptor removeByEmailAndCompanyIdAndGroupId(
        long companyId, long groupId, java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorException {
        return getPersistence()
                   .removeByEmailAndCompanyIdAndGroupId(companyId, groupId,
            email);
    }

    /**
    * Returns the number of subscriptors where companyId = &#63; and groupId = &#63; and email = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param email the email
    * @return the number of matching subscriptors
    * @throws SystemException if a system exception occurred
    */
    public static int countByEmailAndCompanyIdAndGroupId(long companyId,
        long groupId, java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByEmailAndCompanyIdAndGroupId(companyId, groupId, email);
    }

    /**
    * Caches the subscriptor in the entity cache if it is enabled.
    *
    * @param subscriptor the subscriptor
    */
    public static void cacheResult(
        net.zylk.liferay.portal.model.Subscriptor subscriptor) {
        getPersistence().cacheResult(subscriptor);
    }

    /**
    * Caches the subscriptors in the entity cache if it is enabled.
    *
    * @param subscriptors the subscriptors
    */
    public static void cacheResult(
        java.util.List<net.zylk.liferay.portal.model.Subscriptor> subscriptors) {
        getPersistence().cacheResult(subscriptors);
    }

    /**
    * Creates a new subscriptor with the primary key. Does not add the subscriptor to the database.
    *
    * @param subscriptorId the primary key for the new subscriptor
    * @return the new subscriptor
    */
    public static net.zylk.liferay.portal.model.Subscriptor create(
        long subscriptorId) {
        return getPersistence().create(subscriptorId);
    }

    /**
    * Removes the subscriptor with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param subscriptorId the primary key of the subscriptor
    * @return the subscriptor that was removed
    * @throws net.zylk.liferay.portal.NoSuchSubscriptorException if a subscriptor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.Subscriptor remove(
        long subscriptorId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorException {
        return getPersistence().remove(subscriptorId);
    }

    public static net.zylk.liferay.portal.model.Subscriptor updateImpl(
        net.zylk.liferay.portal.model.Subscriptor subscriptor)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(subscriptor);
    }

    /**
    * Returns the subscriptor with the primary key or throws a {@link net.zylk.liferay.portal.NoSuchSubscriptorException} if it could not be found.
    *
    * @param subscriptorId the primary key of the subscriptor
    * @return the subscriptor
    * @throws net.zylk.liferay.portal.NoSuchSubscriptorException if a subscriptor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.Subscriptor findByPrimaryKey(
        long subscriptorId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchSubscriptorException {
        return getPersistence().findByPrimaryKey(subscriptorId);
    }

    /**
    * Returns the subscriptor with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param subscriptorId the primary key of the subscriptor
    * @return the subscriptor, or <code>null</code> if a subscriptor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.Subscriptor fetchByPrimaryKey(
        long subscriptorId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(subscriptorId);
    }

    /**
    * Returns all the subscriptors.
    *
    * @return the subscriptors
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.zylk.liferay.portal.model.Subscriptor> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

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
    public static java.util.List<net.zylk.liferay.portal.model.Subscriptor> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<net.zylk.liferay.portal.model.Subscriptor> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the subscriptors from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of subscriptors.
    *
    * @return the number of subscriptors
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static SubscriptorPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (SubscriptorPersistence) PortletBeanLocatorUtil.locate(net.zylk.liferay.portal.service.ClpSerializer.getServletContextName(),
                    SubscriptorPersistence.class.getName());

            ReferenceRegistry.registerReference(SubscriptorUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(SubscriptorPersistence persistence) {
    }
}
