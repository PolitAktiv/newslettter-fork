package net.zylk.liferay.portal.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import net.zylk.liferay.portal.model.Newsletter;

/**
 * The persistence interface for the newsletter service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author zylk.net
 * @see NewsletterPersistenceImpl
 * @see NewsletterUtil
 * @generated
 */
public interface NewsletterPersistence extends BasePersistence<Newsletter> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link NewsletterUtil} to access the newsletter persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the newsletters where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the matching newsletters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.zylk.liferay.portal.model.Newsletter> findByCompanyIdAndGroupId(
        long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the newsletters where companyId = &#63; and groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param start the lower bound of the range of newsletters
    * @param end the upper bound of the range of newsletters (not inclusive)
    * @return the range of matching newsletters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.zylk.liferay.portal.model.Newsletter> findByCompanyIdAndGroupId(
        long companyId, long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the newsletters where companyId = &#63; and groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param start the lower bound of the range of newsletters
    * @param end the upper bound of the range of newsletters (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching newsletters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.zylk.liferay.portal.model.Newsletter> findByCompanyIdAndGroupId(
        long companyId, long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first newsletter in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching newsletter
    * @throws net.zylk.liferay.portal.NoSuchNewsletterException if a matching newsletter could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Newsletter findByCompanyIdAndGroupId_First(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchNewsletterException;

    /**
    * Returns the first newsletter in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching newsletter, or <code>null</code> if a matching newsletter could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Newsletter fetchByCompanyIdAndGroupId_First(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last newsletter in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching newsletter
    * @throws net.zylk.liferay.portal.NoSuchNewsletterException if a matching newsletter could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Newsletter findByCompanyIdAndGroupId_Last(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchNewsletterException;

    /**
    * Returns the last newsletter in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching newsletter, or <code>null</code> if a matching newsletter could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Newsletter fetchByCompanyIdAndGroupId_Last(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the newsletters before and after the current newsletter in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param newsletterId the primary key of the current newsletter
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next newsletter
    * @throws net.zylk.liferay.portal.NoSuchNewsletterException if a newsletter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Newsletter[] findByCompanyIdAndGroupId_PrevAndNext(
        long newsletterId, long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchNewsletterException;

    /**
    * Removes all the newsletters where companyId = &#63; and groupId = &#63; from the database.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByCompanyIdAndGroupId(long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of newsletters where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the number of matching newsletters
    * @throws SystemException if a system exception occurred
    */
    public int countByCompanyIdAndGroupId(long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the newsletter in the entity cache if it is enabled.
    *
    * @param newsletter the newsletter
    */
    public void cacheResult(net.zylk.liferay.portal.model.Newsletter newsletter);

    /**
    * Caches the newsletters in the entity cache if it is enabled.
    *
    * @param newsletters the newsletters
    */
    public void cacheResult(
        java.util.List<net.zylk.liferay.portal.model.Newsletter> newsletters);

    /**
    * Creates a new newsletter with the primary key. Does not add the newsletter to the database.
    *
    * @param newsletterId the primary key for the new newsletter
    * @return the new newsletter
    */
    public net.zylk.liferay.portal.model.Newsletter create(long newsletterId);

    /**
    * Removes the newsletter with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param newsletterId the primary key of the newsletter
    * @return the newsletter that was removed
    * @throws net.zylk.liferay.portal.NoSuchNewsletterException if a newsletter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Newsletter remove(long newsletterId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchNewsletterException;

    public net.zylk.liferay.portal.model.Newsletter updateImpl(
        net.zylk.liferay.portal.model.Newsletter newsletter)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the newsletter with the primary key or throws a {@link net.zylk.liferay.portal.NoSuchNewsletterException} if it could not be found.
    *
    * @param newsletterId the primary key of the newsletter
    * @return the newsletter
    * @throws net.zylk.liferay.portal.NoSuchNewsletterException if a newsletter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Newsletter findByPrimaryKey(
        long newsletterId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchNewsletterException;

    /**
    * Returns the newsletter with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param newsletterId the primary key of the newsletter
    * @return the newsletter, or <code>null</code> if a newsletter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.Newsletter fetchByPrimaryKey(
        long newsletterId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the newsletters.
    *
    * @return the newsletters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.zylk.liferay.portal.model.Newsletter> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the newsletters.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of newsletters
    * @param end the upper bound of the range of newsletters (not inclusive)
    * @return the range of newsletters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.zylk.liferay.portal.model.Newsletter> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the newsletters.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of newsletters
    * @param end the upper bound of the range of newsletters (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of newsletters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.zylk.liferay.portal.model.Newsletter> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the newsletters from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of newsletters.
    *
    * @return the number of newsletters
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
