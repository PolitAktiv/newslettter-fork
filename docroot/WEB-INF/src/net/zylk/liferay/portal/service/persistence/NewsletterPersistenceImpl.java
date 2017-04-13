package net.zylk.liferay.portal.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import net.zylk.liferay.portal.NoSuchNewsletterException;
import net.zylk.liferay.portal.model.Newsletter;
import net.zylk.liferay.portal.model.impl.NewsletterImpl;
import net.zylk.liferay.portal.model.impl.NewsletterModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the newsletter service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author zylk.net
 * @see NewsletterPersistence
 * @see NewsletterUtil
 * @generated
 */
public class NewsletterPersistenceImpl extends BasePersistenceImpl<Newsletter>
    implements NewsletterPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link NewsletterUtil} to access the newsletter persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = NewsletterImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterModelImpl.FINDER_CACHE_ENABLED, NewsletterImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterModelImpl.FINDER_CACHE_ENABLED, NewsletterImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYIDANDGROUPID =
        new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterModelImpl.FINDER_CACHE_ENABLED, NewsletterImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByCompanyIdAndGroupId",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID =
        new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterModelImpl.FINDER_CACHE_ENABLED, NewsletterImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByCompanyIdAndGroupId",
            new String[] { Long.class.getName(), Long.class.getName() },
            NewsletterModelImpl.COMPANYID_COLUMN_BITMASK |
            NewsletterModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID = new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByCompanyIdAndGroupId",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_COMPANYIDANDGROUPID_COMPANYID_2 = "newsletter.companyId = ? AND ";
    private static final String _FINDER_COLUMN_COMPANYIDANDGROUPID_GROUPID_2 = "newsletter.groupId = ?";
    private static final String _SQL_SELECT_NEWSLETTER = "SELECT newsletter FROM Newsletter newsletter";
    private static final String _SQL_SELECT_NEWSLETTER_WHERE = "SELECT newsletter FROM Newsletter newsletter WHERE ";
    private static final String _SQL_COUNT_NEWSLETTER = "SELECT COUNT(newsletter) FROM Newsletter newsletter";
    private static final String _SQL_COUNT_NEWSLETTER_WHERE = "SELECT COUNT(newsletter) FROM Newsletter newsletter WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "newsletter.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Newsletter exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Newsletter exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(NewsletterPersistenceImpl.class);
    private static Newsletter _nullNewsletter = new NewsletterImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Newsletter> toCacheModel() {
                return _nullNewsletterCacheModel;
            }
        };

    private static CacheModel<Newsletter> _nullNewsletterCacheModel = new CacheModel<Newsletter>() {
            @Override
            public Newsletter toEntityModel() {
                return _nullNewsletter;
            }
        };

    public NewsletterPersistenceImpl() {
        setModelClass(Newsletter.class);
    }

    /**
     * Returns all the newsletters where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @return the matching newsletters
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Newsletter> findByCompanyIdAndGroupId(long companyId,
        long groupId) throws SystemException {
        return findByCompanyIdAndGroupId(companyId, groupId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Newsletter> findByCompanyIdAndGroupId(long companyId,
        long groupId, int start, int end) throws SystemException {
        return findByCompanyIdAndGroupId(companyId, groupId, start, end, null);
    }

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
    @Override
    public List<Newsletter> findByCompanyIdAndGroupId(long companyId,
        long groupId, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID;
            finderArgs = new Object[] { companyId, groupId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYIDANDGROUPID;
            finderArgs = new Object[] {
                    companyId, groupId,
                    
                    start, end, orderByComparator
                };
        }

        List<Newsletter> list = (List<Newsletter>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Newsletter newsletter : list) {
                if ((companyId != newsletter.getCompanyId()) ||
                        (groupId != newsletter.getGroupId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_NEWSLETTER_WHERE);

            query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_COMPANYID_2);

            query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(NewsletterModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(groupId);

                if (!pagination) {
                    list = (List<Newsletter>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Newsletter>(list);
                } else {
                    list = (List<Newsletter>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

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
    @Override
    public Newsletter findByCompanyIdAndGroupId_First(long companyId,
        long groupId, OrderByComparator orderByComparator)
        throws NoSuchNewsletterException, SystemException {
        Newsletter newsletter = fetchByCompanyIdAndGroupId_First(companyId,
                groupId, orderByComparator);

        if (newsletter != null) {
            return newsletter;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchNewsletterException(msg.toString());
    }

    /**
     * Returns the first newsletter in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching newsletter, or <code>null</code> if a matching newsletter could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Newsletter fetchByCompanyIdAndGroupId_First(long companyId,
        long groupId, OrderByComparator orderByComparator)
        throws SystemException {
        List<Newsletter> list = findByCompanyIdAndGroupId(companyId, groupId,
                0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public Newsletter findByCompanyIdAndGroupId_Last(long companyId,
        long groupId, OrderByComparator orderByComparator)
        throws NoSuchNewsletterException, SystemException {
        Newsletter newsletter = fetchByCompanyIdAndGroupId_Last(companyId,
                groupId, orderByComparator);

        if (newsletter != null) {
            return newsletter;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchNewsletterException(msg.toString());
    }

    /**
     * Returns the last newsletter in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching newsletter, or <code>null</code> if a matching newsletter could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Newsletter fetchByCompanyIdAndGroupId_Last(long companyId,
        long groupId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByCompanyIdAndGroupId(companyId, groupId);

        if (count == 0) {
            return null;
        }

        List<Newsletter> list = findByCompanyIdAndGroupId(companyId, groupId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public Newsletter[] findByCompanyIdAndGroupId_PrevAndNext(
        long newsletterId, long companyId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchNewsletterException, SystemException {
        Newsletter newsletter = findByPrimaryKey(newsletterId);

        Session session = null;

        try {
            session = openSession();

            Newsletter[] array = new NewsletterImpl[3];

            array[0] = getByCompanyIdAndGroupId_PrevAndNext(session,
                    newsletter, companyId, groupId, orderByComparator, true);

            array[1] = newsletter;

            array[2] = getByCompanyIdAndGroupId_PrevAndNext(session,
                    newsletter, companyId, groupId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Newsletter getByCompanyIdAndGroupId_PrevAndNext(Session session,
        Newsletter newsletter, long companyId, long groupId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_NEWSLETTER_WHERE);

        query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_COMPANYID_2);

        query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_GROUPID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(NewsletterModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(newsletter);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Newsletter> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the newsletters where companyId = &#63; and groupId = &#63; from the database.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCompanyIdAndGroupId(long companyId, long groupId)
        throws SystemException {
        for (Newsletter newsletter : findByCompanyIdAndGroupId(companyId,
                groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(newsletter);
        }
    }

    /**
     * Returns the number of newsletters where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @return the number of matching newsletters
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCompanyIdAndGroupId(long companyId, long groupId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID;

        Object[] finderArgs = new Object[] { companyId, groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_NEWSLETTER_WHERE);

            query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_COMPANYID_2);

            query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(groupId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the newsletter in the entity cache if it is enabled.
     *
     * @param newsletter the newsletter
     */
    @Override
    public void cacheResult(Newsletter newsletter) {
        EntityCacheUtil.putResult(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterImpl.class, newsletter.getPrimaryKey(), newsletter);

        newsletter.resetOriginalValues();
    }

    /**
     * Caches the newsletters in the entity cache if it is enabled.
     *
     * @param newsletters the newsletters
     */
    @Override
    public void cacheResult(List<Newsletter> newsletters) {
        for (Newsletter newsletter : newsletters) {
            if (EntityCacheUtil.getResult(
                        NewsletterModelImpl.ENTITY_CACHE_ENABLED,
                        NewsletterImpl.class, newsletter.getPrimaryKey()) == null) {
                cacheResult(newsletter);
            } else {
                newsletter.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all newsletters.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(NewsletterImpl.class.getName());
        }

        EntityCacheUtil.clearCache(NewsletterImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the newsletter.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Newsletter newsletter) {
        EntityCacheUtil.removeResult(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterImpl.class, newsletter.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Newsletter> newsletters) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Newsletter newsletter : newsletters) {
            EntityCacheUtil.removeResult(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
                NewsletterImpl.class, newsletter.getPrimaryKey());
        }
    }

    /**
     * Creates a new newsletter with the primary key. Does not add the newsletter to the database.
     *
     * @param newsletterId the primary key for the new newsletter
     * @return the new newsletter
     */
    @Override
    public Newsletter create(long newsletterId) {
        Newsletter newsletter = new NewsletterImpl();

        newsletter.setNew(true);
        newsletter.setPrimaryKey(newsletterId);

        return newsletter;
    }

    /**
     * Removes the newsletter with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param newsletterId the primary key of the newsletter
     * @return the newsletter that was removed
     * @throws net.zylk.liferay.portal.NoSuchNewsletterException if a newsletter with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Newsletter remove(long newsletterId)
        throws NoSuchNewsletterException, SystemException {
        return remove((Serializable) newsletterId);
    }

    /**
     * Removes the newsletter with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the newsletter
     * @return the newsletter that was removed
     * @throws net.zylk.liferay.portal.NoSuchNewsletterException if a newsletter with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Newsletter remove(Serializable primaryKey)
        throws NoSuchNewsletterException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Newsletter newsletter = (Newsletter) session.get(NewsletterImpl.class,
                    primaryKey);

            if (newsletter == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchNewsletterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(newsletter);
        } catch (NoSuchNewsletterException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Newsletter removeImpl(Newsletter newsletter)
        throws SystemException {
        newsletter = toUnwrappedModel(newsletter);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(newsletter)) {
                newsletter = (Newsletter) session.get(NewsletterImpl.class,
                        newsletter.getPrimaryKeyObj());
            }

            if (newsletter != null) {
                session.delete(newsletter);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (newsletter != null) {
            clearCache(newsletter);
        }

        return newsletter;
    }

    @Override
    public Newsletter updateImpl(
        net.zylk.liferay.portal.model.Newsletter newsletter)
        throws SystemException {
        newsletter = toUnwrappedModel(newsletter);

        boolean isNew = newsletter.isNew();

        NewsletterModelImpl newsletterModelImpl = (NewsletterModelImpl) newsletter;

        Session session = null;

        try {
            session = openSession();

            if (newsletter.isNew()) {
                session.save(newsletter);

                newsletter.setNew(false);
            } else {
                session.merge(newsletter);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !NewsletterModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((newsletterModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        newsletterModelImpl.getOriginalCompanyId(),
                        newsletterModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID,
                    args);

                args = new Object[] {
                        newsletterModelImpl.getCompanyId(),
                        newsletterModelImpl.getGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID,
                    args);
            }
        }

        EntityCacheUtil.putResult(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterImpl.class, newsletter.getPrimaryKey(), newsletter);

        return newsletter;
    }

    protected Newsletter toUnwrappedModel(Newsletter newsletter) {
        if (newsletter instanceof NewsletterImpl) {
            return newsletter;
        }

        NewsletterImpl newsletterImpl = new NewsletterImpl();

        newsletterImpl.setNew(newsletter.isNew());
        newsletterImpl.setPrimaryKey(newsletter.getPrimaryKey());

        newsletterImpl.setNewsletterId(newsletter.getNewsletterId());
        newsletterImpl.setCompanyId(newsletter.getCompanyId());
        newsletterImpl.setGroupId(newsletter.getGroupId());
        newsletterImpl.setCreateDate(newsletter.getCreateDate());
        newsletterImpl.setModifiedDate(newsletter.getModifiedDate());
        newsletterImpl.setName(newsletter.getName());
        newsletterImpl.setDescription(newsletter.getDescription());
        newsletterImpl.setCategoryId(newsletter.getCategoryId());
        newsletterImpl.setSubject(newsletter.getSubject());
        newsletterImpl.setArticleId(newsletter.getArticleId());
        newsletterImpl.setArticleGroupId(newsletter.getArticleGroupId());
        newsletterImpl.setSchedulerActive(newsletter.isSchedulerActive());
        newsletterImpl.setSchedulerType(newsletter.getSchedulerType());
        newsletterImpl.setSchedulerDate(newsletter.getSchedulerDate());

        return newsletterImpl;
    }

    /**
     * Returns the newsletter with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the newsletter
     * @return the newsletter
     * @throws net.zylk.liferay.portal.NoSuchNewsletterException if a newsletter with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Newsletter findByPrimaryKey(Serializable primaryKey)
        throws NoSuchNewsletterException, SystemException {
        Newsletter newsletter = fetchByPrimaryKey(primaryKey);

        if (newsletter == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchNewsletterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return newsletter;
    }

    /**
     * Returns the newsletter with the primary key or throws a {@link net.zylk.liferay.portal.NoSuchNewsletterException} if it could not be found.
     *
     * @param newsletterId the primary key of the newsletter
     * @return the newsletter
     * @throws net.zylk.liferay.portal.NoSuchNewsletterException if a newsletter with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Newsletter findByPrimaryKey(long newsletterId)
        throws NoSuchNewsletterException, SystemException {
        return findByPrimaryKey((Serializable) newsletterId);
    }

    /**
     * Returns the newsletter with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the newsletter
     * @return the newsletter, or <code>null</code> if a newsletter with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Newsletter fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Newsletter newsletter = (Newsletter) EntityCacheUtil.getResult(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
                NewsletterImpl.class, primaryKey);

        if (newsletter == _nullNewsletter) {
            return null;
        }

        if (newsletter == null) {
            Session session = null;

            try {
                session = openSession();

                newsletter = (Newsletter) session.get(NewsletterImpl.class,
                        primaryKey);

                if (newsletter != null) {
                    cacheResult(newsletter);
                } else {
                    EntityCacheUtil.putResult(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
                        NewsletterImpl.class, primaryKey, _nullNewsletter);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
                    NewsletterImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return newsletter;
    }

    /**
     * Returns the newsletter with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param newsletterId the primary key of the newsletter
     * @return the newsletter, or <code>null</code> if a newsletter with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Newsletter fetchByPrimaryKey(long newsletterId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) newsletterId);
    }

    /**
     * Returns all the newsletters.
     *
     * @return the newsletters
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Newsletter> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Newsletter> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

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
    @Override
    public List<Newsletter> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Newsletter> list = (List<Newsletter>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_NEWSLETTER);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_NEWSLETTER;

                if (pagination) {
                    sql = sql.concat(NewsletterModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Newsletter>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Newsletter>(list);
                } else {
                    list = (List<Newsletter>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the newsletters from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Newsletter newsletter : findAll()) {
            remove(newsletter);
        }
    }

    /**
     * Returns the number of newsletters.
     *
     * @return the number of newsletters
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_NEWSLETTER);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the newsletter persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.net.zylk.liferay.portal.model.Newsletter")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Newsletter>> listenersList = new ArrayList<ModelListener<Newsletter>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Newsletter>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(NewsletterImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
