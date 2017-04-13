package net.zylk.liferay.portal.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import net.zylk.liferay.portal.model.Mailing;

/**
 * The persistence interface for the mailing service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author zylk.net
 * @see MailingPersistenceImpl
 * @see MailingUtil
 * @generated
 */
public interface MailingPersistence extends BasePersistence<Mailing> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link MailingUtil} to access the mailing persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the mailings where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the matching mailings
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.zylk.liferay.portal.model.Mailing> findByCompanyIdAndGroupId(
        long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<net.zylk.liferay.portal.model.Mailing> findByCompanyIdAndGroupId(
        long companyId, long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<net.zylk.liferay.portal.model.Mailing> findByCompanyIdAndGroupId(
        long companyId, long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public net.zylk.liferay.portal.model.Mailing findByCompanyIdAndGroupId_First(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchMailingException;

    /**
    * Returns the first mailing in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching mailing, or <code>null</code> if a matching mailing could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Mailing fetchByCompanyIdAndGroupId_First(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public net.zylk.liferay.portal.model.Mailing findByCompanyIdAndGroupId_Last(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchMailingException;

    /**
    * Returns the last mailing in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching mailing, or <code>null</code> if a matching mailing could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Mailing fetchByCompanyIdAndGroupId_Last(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public net.zylk.liferay.portal.model.Mailing[] findByCompanyIdAndGroupId_PrevAndNext(
        long mailingId, long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchMailingException;

    /**
    * Removes all the mailings where companyId = &#63; and groupId = &#63; from the database.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByCompanyIdAndGroupId(long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of mailings where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the number of matching mailings
    * @throws SystemException if a system exception occurred
    */
    public int countByCompanyIdAndGroupId(long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the mailings where newsletterId = &#63;.
    *
    * @param newsletterId the newsletter ID
    * @return the matching mailings
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.zylk.liferay.portal.model.Mailing> findByNewsletterId(
        long newsletterId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<net.zylk.liferay.portal.model.Mailing> findByNewsletterId(
        long newsletterId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<net.zylk.liferay.portal.model.Mailing> findByNewsletterId(
        long newsletterId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first mailing in the ordered set where newsletterId = &#63;.
    *
    * @param newsletterId the newsletter ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching mailing
    * @throws net.zylk.liferay.portal.NoSuchMailingException if a matching mailing could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Mailing findByNewsletterId_First(
        long newsletterId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchMailingException;

    /**
    * Returns the first mailing in the ordered set where newsletterId = &#63;.
    *
    * @param newsletterId the newsletter ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching mailing, or <code>null</code> if a matching mailing could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Mailing fetchByNewsletterId_First(
        long newsletterId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last mailing in the ordered set where newsletterId = &#63;.
    *
    * @param newsletterId the newsletter ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching mailing
    * @throws net.zylk.liferay.portal.NoSuchMailingException if a matching mailing could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Mailing findByNewsletterId_Last(
        long newsletterId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchMailingException;

    /**
    * Returns the last mailing in the ordered set where newsletterId = &#63;.
    *
    * @param newsletterId the newsletter ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching mailing, or <code>null</code> if a matching mailing could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Mailing fetchByNewsletterId_Last(
        long newsletterId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public net.zylk.liferay.portal.model.Mailing[] findByNewsletterId_PrevAndNext(
        long mailingId, long newsletterId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchMailingException;

    /**
    * Removes all the mailings where newsletterId = &#63; from the database.
    *
    * @param newsletterId the newsletter ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByNewsletterId(long newsletterId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of mailings where newsletterId = &#63;.
    *
    * @param newsletterId the newsletter ID
    * @return the number of matching mailings
    * @throws SystemException if a system exception occurred
    */
    public int countByNewsletterId(long newsletterId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the mailing in the entity cache if it is enabled.
    *
    * @param mailing the mailing
    */
    public void cacheResult(net.zylk.liferay.portal.model.Mailing mailing);

    /**
    * Caches the mailings in the entity cache if it is enabled.
    *
    * @param mailings the mailings
    */
    public void cacheResult(
        java.util.List<net.zylk.liferay.portal.model.Mailing> mailings);

    /**
    * Creates a new mailing with the primary key. Does not add the mailing to the database.
    *
    * @param mailingId the primary key for the new mailing
    * @return the new mailing
    */
    public net.zylk.liferay.portal.model.Mailing create(long mailingId);

    /**
    * Removes the mailing with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param mailingId the primary key of the mailing
    * @return the mailing that was removed
    * @throws net.zylk.liferay.portal.NoSuchMailingException if a mailing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Mailing remove(long mailingId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchMailingException;

    public net.zylk.liferay.portal.model.Mailing updateImpl(
        net.zylk.liferay.portal.model.Mailing mailing)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the mailing with the primary key or throws a {@link net.zylk.liferay.portal.NoSuchMailingException} if it could not be found.
    *
    * @param mailingId the primary key of the mailing
    * @return the mailing
    * @throws net.zylk.liferay.portal.NoSuchMailingException if a mailing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Mailing findByPrimaryKey(
        long mailingId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchMailingException;

    /**
    * Returns the mailing with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param mailingId the primary key of the mailing
    * @return the mailing, or <code>null</code> if a mailing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Mailing fetchByPrimaryKey(
        long mailingId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the mailings.
    *
    * @return the mailings
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.zylk.liferay.portal.model.Mailing> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<net.zylk.liferay.portal.model.Mailing> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<net.zylk.liferay.portal.model.Mailing> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the mailings from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of mailings.
    *
    * @return the number of mailings
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
