package net.zylk.liferay.portal.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import net.zylk.liferay.portal.model.Mailing;

import java.util.List;

/**
 * The persistence utility for the mailing service. This utility wraps {@link MailingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author zylk.net
 * @see MailingPersistence
 * @see MailingPersistenceImpl
 * @generated
 */
public class MailingUtil {
    private static MailingPersistence _persistence;

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
    public static void clearCache(Mailing mailing) {
        getPersistence().clearCache(mailing);
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
    public static List<Mailing> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Mailing> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Mailing> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Mailing update(Mailing mailing) throws SystemException {
        return getPersistence().update(mailing);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Mailing update(Mailing mailing, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(mailing, serviceContext);
    }

    /**
    * Returns all the mailings where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the matching mailings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.zylk.liferay.portal.model.Mailing> findByCompanyIdAndGroupId(
        long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyIdAndGroupId(companyId, groupId);
    }

    /**
    * Returns a range of all the mailings where companyId = &#63; and groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.MailingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param start the lower bound of the range of mailings
    * @param end the upper bound of the range of mailings (not inclusive)
    * @return the range of matching mailings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.zylk.liferay.portal.model.Mailing> findByCompanyIdAndGroupId(
        long companyId, long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyIdAndGroupId(companyId, groupId, start, end);
    }

    /**
    * Returns an ordered range of all the mailings where companyId = &#63; and groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.MailingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param start the lower bound of the range of mailings
    * @param end the upper bound of the range of mailings (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching mailings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.zylk.liferay.portal.model.Mailing> findByCompanyIdAndGroupId(
        long companyId, long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyIdAndGroupId(companyId, groupId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first mailing in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching mailing
    * @throws net.zylk.liferay.portal.NoSuchMailingException if a matching mailing could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.Mailing findByCompanyIdAndGroupId_First(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchMailingException {
        return getPersistence()
                   .findByCompanyIdAndGroupId_First(companyId, groupId,
            orderByComparator);
    }

    /**
    * Returns the first mailing in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching mailing, or <code>null</code> if a matching mailing could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.Mailing fetchByCompanyIdAndGroupId_First(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyIdAndGroupId_First(companyId, groupId,
            orderByComparator);
    }

    /**
    * Returns the last mailing in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching mailing
    * @throws net.zylk.liferay.portal.NoSuchMailingException if a matching mailing could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.Mailing findByCompanyIdAndGroupId_Last(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchMailingException {
        return getPersistence()
                   .findByCompanyIdAndGroupId_Last(companyId, groupId,
            orderByComparator);
    }

    /**
    * Returns the last mailing in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching mailing, or <code>null</code> if a matching mailing could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.Mailing fetchByCompanyIdAndGroupId_Last(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyIdAndGroupId_Last(companyId, groupId,
            orderByComparator);
    }

    /**
    * Returns the mailings before and after the current mailing in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param mailingId the primary key of the current mailing
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next mailing
    * @throws net.zylk.liferay.portal.NoSuchMailingException if a mailing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.Mailing[] findByCompanyIdAndGroupId_PrevAndNext(
        long mailingId, long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchMailingException {
        return getPersistence()
                   .findByCompanyIdAndGroupId_PrevAndNext(mailingId, companyId,
            groupId, orderByComparator);
    }

    /**
    * Removes all the mailings where companyId = &#63; and groupId = &#63; from the database.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCompanyIdAndGroupId(long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCompanyIdAndGroupId(companyId, groupId);
    }

    /**
    * Returns the number of mailings where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the number of matching mailings
    * @throws SystemException if a system exception occurred
    */
    public static int countByCompanyIdAndGroupId(long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCompanyIdAndGroupId(companyId, groupId);
    }

    /**
    * Returns all the mailings where newsletterId = &#63;.
    *
    * @param newsletterId the newsletter ID
    * @return the matching mailings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.zylk.liferay.portal.model.Mailing> findByNewsletterId(
        long newsletterId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByNewsletterId(newsletterId);
    }

    /**
    * Returns a range of all the mailings where newsletterId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.MailingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param newsletterId the newsletter ID
    * @param start the lower bound of the range of mailings
    * @param end the upper bound of the range of mailings (not inclusive)
    * @return the range of matching mailings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.zylk.liferay.portal.model.Mailing> findByNewsletterId(
        long newsletterId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByNewsletterId(newsletterId, start, end);
    }

    /**
    * Returns an ordered range of all the mailings where newsletterId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.MailingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param newsletterId the newsletter ID
    * @param start the lower bound of the range of mailings
    * @param end the upper bound of the range of mailings (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching mailings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.zylk.liferay.portal.model.Mailing> findByNewsletterId(
        long newsletterId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByNewsletterId(newsletterId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first mailing in the ordered set where newsletterId = &#63;.
    *
    * @param newsletterId the newsletter ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching mailing
    * @throws net.zylk.liferay.portal.NoSuchMailingException if a matching mailing could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.Mailing findByNewsletterId_First(
        long newsletterId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchMailingException {
        return getPersistence()
                   .findByNewsletterId_First(newsletterId, orderByComparator);
    }

    /**
    * Returns the first mailing in the ordered set where newsletterId = &#63;.
    *
    * @param newsletterId the newsletter ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching mailing, or <code>null</code> if a matching mailing could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.Mailing fetchByNewsletterId_First(
        long newsletterId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByNewsletterId_First(newsletterId, orderByComparator);
    }

    /**
    * Returns the last mailing in the ordered set where newsletterId = &#63;.
    *
    * @param newsletterId the newsletter ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching mailing
    * @throws net.zylk.liferay.portal.NoSuchMailingException if a matching mailing could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.Mailing findByNewsletterId_Last(
        long newsletterId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchMailingException {
        return getPersistence()
                   .findByNewsletterId_Last(newsletterId, orderByComparator);
    }

    /**
    * Returns the last mailing in the ordered set where newsletterId = &#63;.
    *
    * @param newsletterId the newsletter ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching mailing, or <code>null</code> if a matching mailing could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.Mailing fetchByNewsletterId_Last(
        long newsletterId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByNewsletterId_Last(newsletterId, orderByComparator);
    }

    /**
    * Returns the mailings before and after the current mailing in the ordered set where newsletterId = &#63;.
    *
    * @param mailingId the primary key of the current mailing
    * @param newsletterId the newsletter ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next mailing
    * @throws net.zylk.liferay.portal.NoSuchMailingException if a mailing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.Mailing[] findByNewsletterId_PrevAndNext(
        long mailingId, long newsletterId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchMailingException {
        return getPersistence()
                   .findByNewsletterId_PrevAndNext(mailingId, newsletterId,
            orderByComparator);
    }

    /**
    * Removes all the mailings where newsletterId = &#63; from the database.
    *
    * @param newsletterId the newsletter ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByNewsletterId(long newsletterId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByNewsletterId(newsletterId);
    }

    /**
    * Returns the number of mailings where newsletterId = &#63;.
    *
    * @param newsletterId the newsletter ID
    * @return the number of matching mailings
    * @throws SystemException if a system exception occurred
    */
    public static int countByNewsletterId(long newsletterId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByNewsletterId(newsletterId);
    }

    /**
    * Caches the mailing in the entity cache if it is enabled.
    *
    * @param mailing the mailing
    */
    public static void cacheResult(
        net.zylk.liferay.portal.model.Mailing mailing) {
        getPersistence().cacheResult(mailing);
    }

    /**
    * Caches the mailings in the entity cache if it is enabled.
    *
    * @param mailings the mailings
    */
    public static void cacheResult(
        java.util.List<net.zylk.liferay.portal.model.Mailing> mailings) {
        getPersistence().cacheResult(mailings);
    }

    /**
    * Creates a new mailing with the primary key. Does not add the mailing to the database.
    *
    * @param mailingId the primary key for the new mailing
    * @return the new mailing
    */
    public static net.zylk.liferay.portal.model.Mailing create(long mailingId) {
        return getPersistence().create(mailingId);
    }

    /**
    * Removes the mailing with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param mailingId the primary key of the mailing
    * @return the mailing that was removed
    * @throws net.zylk.liferay.portal.NoSuchMailingException if a mailing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.Mailing remove(long mailingId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchMailingException {
        return getPersistence().remove(mailingId);
    }

    public static net.zylk.liferay.portal.model.Mailing updateImpl(
        net.zylk.liferay.portal.model.Mailing mailing)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(mailing);
    }

    /**
    * Returns the mailing with the primary key or throws a {@link net.zylk.liferay.portal.NoSuchMailingException} if it could not be found.
    *
    * @param mailingId the primary key of the mailing
    * @return the mailing
    * @throws net.zylk.liferay.portal.NoSuchMailingException if a mailing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.Mailing findByPrimaryKey(
        long mailingId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchMailingException {
        return getPersistence().findByPrimaryKey(mailingId);
    }

    /**
    * Returns the mailing with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param mailingId the primary key of the mailing
    * @return the mailing, or <code>null</code> if a mailing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.Mailing fetchByPrimaryKey(
        long mailingId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(mailingId);
    }

    /**
    * Returns all the mailings.
    *
    * @return the mailings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.zylk.liferay.portal.model.Mailing> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<net.zylk.liferay.portal.model.Mailing> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the mailings.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.MailingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of mailings
    * @param end the upper bound of the range of mailings (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of mailings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.zylk.liferay.portal.model.Mailing> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the mailings from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of mailings.
    *
    * @return the number of mailings
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static MailingPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (MailingPersistence) PortletBeanLocatorUtil.locate(net.zylk.liferay.portal.service.ClpSerializer.getServletContextName(),
                    MailingPersistence.class.getName());

            ReferenceRegistry.registerReference(MailingUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(MailingPersistence persistence) {
    }
}
