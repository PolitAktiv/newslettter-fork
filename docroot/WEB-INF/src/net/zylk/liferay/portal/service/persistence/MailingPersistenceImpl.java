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

import net.zylk.liferay.portal.NoSuchMailingException;
import net.zylk.liferay.portal.model.Mailing;
import net.zylk.liferay.portal.model.impl.MailingImpl;
import net.zylk.liferay.portal.model.impl.MailingModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the mailing service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author zylk.net
 * @see MailingPersistence
 * @see MailingUtil
 * @generated
 */
public class MailingPersistenceImpl extends BasePersistenceImpl<Mailing>
    implements MailingPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link MailingUtil} to access the mailing persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = MailingImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MailingModelImpl.ENTITY_CACHE_ENABLED,
            MailingModelImpl.FINDER_CACHE_ENABLED, MailingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MailingModelImpl.ENTITY_CACHE_ENABLED,
            MailingModelImpl.FINDER_CACHE_ENABLED, MailingImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MailingModelImpl.ENTITY_CACHE_ENABLED,
            MailingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYIDANDGROUPID =
        new FinderPath(MailingModelImpl.ENTITY_CACHE_ENABLED,
            MailingModelImpl.FINDER_CACHE_ENABLED, MailingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByCompanyIdAndGroupId",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID =
        new FinderPath(MailingModelImpl.ENTITY_CACHE_ENABLED,
            MailingModelImpl.FINDER_CACHE_ENABLED, MailingImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByCompanyIdAndGroupId",
            new String[] { Long.class.getName(), Long.class.getName() },
            MailingModelImpl.COMPANYID_COLUMN_BITMASK |
            MailingModelImpl.GROUPID_COLUMN_BITMASK |
            MailingModelImpl.STARTDATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID = new FinderPath(MailingModelImpl.ENTITY_CACHE_ENABLED,
            MailingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByCompanyIdAndGroupId",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_COMPANYIDANDGROUPID_COMPANYID_2 = "mailing.companyId = ? AND ";
    private static final String _FINDER_COLUMN_COMPANYIDANDGROUPID_GROUPID_2 = "mailing.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NEWSLETTERID =
        new FinderPath(MailingModelImpl.ENTITY_CACHE_ENABLED,
            MailingModelImpl.FINDER_CACHE_ENABLED, MailingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNewsletterId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NEWSLETTERID =
        new FinderPath(MailingModelImpl.ENTITY_CACHE_ENABLED,
            MailingModelImpl.FINDER_CACHE_ENABLED, MailingImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNewsletterId",
            new String[] { Long.class.getName() },
            MailingModelImpl.NEWSLETTERID_COLUMN_BITMASK |
            MailingModelImpl.STARTDATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_NEWSLETTERID = new FinderPath(MailingModelImpl.ENTITY_CACHE_ENABLED,
            MailingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNewsletterId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_NEWSLETTERID_NEWSLETTERID_2 = "mailing.newsletterId = ?";
    private static final String _SQL_SELECT_MAILING = "SELECT mailing FROM Mailing mailing";
    private static final String _SQL_SELECT_MAILING_WHERE = "SELECT mailing FROM Mailing mailing WHERE ";
    private static final String _SQL_COUNT_MAILING = "SELECT COUNT(mailing) FROM Mailing mailing";
    private static final String _SQL_COUNT_MAILING_WHERE = "SELECT COUNT(mailing) FROM Mailing mailing WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "mailing.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Mailing exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Mailing exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(MailingPersistenceImpl.class);
    private static Mailing _nullMailing = new MailingImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Mailing> toCacheModel() {
                return _nullMailingCacheModel;
            }
        };

    private static CacheModel<Mailing> _nullMailingCacheModel = new CacheModel<Mailing>() {
            @Override
            public Mailing toEntityModel() {
                return _nullMailing;
            }
        };

    public MailingPersistenceImpl() {
        setModelClass(Mailing.class);
    }

    /**
     * Returns all the mailings where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @return the matching mailings
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Mailing> findByCompanyIdAndGroupId(long companyId, long groupId)
        throws SystemException {
        return findByCompanyIdAndGroupId(companyId, groupId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Mailing> findByCompanyIdAndGroupId(long companyId,
        long groupId, int start, int end) throws SystemException {
        return findByCompanyIdAndGroupId(companyId, groupId, start, end, null);
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
    @Override
    public List<Mailing> findByCompanyIdAndGroupId(long companyId,
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

        List<Mailing> list = (List<Mailing>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Mailing mailing : list) {
                if ((companyId != mailing.getCompanyId()) ||
                        (groupId != mailing.getGroupId())) {
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

            query.append(_SQL_SELECT_MAILING_WHERE);

            query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_COMPANYID_2);

            query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(MailingModelImpl.ORDER_BY_JPQL);
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
                    list = (List<Mailing>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Mailing>(list);
                } else {
                    list = (List<Mailing>) QueryUtil.list(q, getDialect(),
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
     * Returns the first mailing in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching mailing
     * @throws net.zylk.liferay.portal.NoSuchMailingException if a matching mailing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Mailing findByCompanyIdAndGroupId_First(long companyId,
        long groupId, OrderByComparator orderByComparator)
        throws NoSuchMailingException, SystemException {
        Mailing mailing = fetchByCompanyIdAndGroupId_First(companyId, groupId,
                orderByComparator);

        if (mailing != null) {
            return mailing;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMailingException(msg.toString());
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
    @Override
    public Mailing fetchByCompanyIdAndGroupId_First(long companyId,
        long groupId, OrderByComparator orderByComparator)
        throws SystemException {
        List<Mailing> list = findByCompanyIdAndGroupId(companyId, groupId, 0,
                1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Mailing findByCompanyIdAndGroupId_Last(long companyId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchMailingException, SystemException {
        Mailing mailing = fetchByCompanyIdAndGroupId_Last(companyId, groupId,
                orderByComparator);

        if (mailing != null) {
            return mailing;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMailingException(msg.toString());
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
    @Override
    public Mailing fetchByCompanyIdAndGroupId_Last(long companyId,
        long groupId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByCompanyIdAndGroupId(companyId, groupId);

        if (count == 0) {
            return null;
        }

        List<Mailing> list = findByCompanyIdAndGroupId(companyId, groupId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Mailing[] findByCompanyIdAndGroupId_PrevAndNext(long mailingId,
        long companyId, long groupId, OrderByComparator orderByComparator)
        throws NoSuchMailingException, SystemException {
        Mailing mailing = findByPrimaryKey(mailingId);

        Session session = null;

        try {
            session = openSession();

            Mailing[] array = new MailingImpl[3];

            array[0] = getByCompanyIdAndGroupId_PrevAndNext(session, mailing,
                    companyId, groupId, orderByComparator, true);

            array[1] = mailing;

            array[2] = getByCompanyIdAndGroupId_PrevAndNext(session, mailing,
                    companyId, groupId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Mailing getByCompanyIdAndGroupId_PrevAndNext(Session session,
        Mailing mailing, long companyId, long groupId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_MAILING_WHERE);

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
            query.append(MailingModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(mailing);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Mailing> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the mailings where companyId = &#63; and groupId = &#63; from the database.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCompanyIdAndGroupId(long companyId, long groupId)
        throws SystemException {
        for (Mailing mailing : findByCompanyIdAndGroupId(companyId, groupId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(mailing);
        }
    }

    /**
     * Returns the number of mailings where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @return the number of matching mailings
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

            query.append(_SQL_COUNT_MAILING_WHERE);

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
     * Returns all the mailings where newsletterId = &#63;.
     *
     * @param newsletterId the newsletter ID
     * @return the matching mailings
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Mailing> findByNewsletterId(long newsletterId)
        throws SystemException {
        return findByNewsletterId(newsletterId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Mailing> findByNewsletterId(long newsletterId, int start,
        int end) throws SystemException {
        return findByNewsletterId(newsletterId, start, end, null);
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
    @Override
    public List<Mailing> findByNewsletterId(long newsletterId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NEWSLETTERID;
            finderArgs = new Object[] { newsletterId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NEWSLETTERID;
            finderArgs = new Object[] {
                    newsletterId,
                    
                    start, end, orderByComparator
                };
        }

        List<Mailing> list = (List<Mailing>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Mailing mailing : list) {
                if ((newsletterId != mailing.getNewsletterId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_MAILING_WHERE);

            query.append(_FINDER_COLUMN_NEWSLETTERID_NEWSLETTERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(MailingModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(newsletterId);

                if (!pagination) {
                    list = (List<Mailing>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Mailing>(list);
                } else {
                    list = (List<Mailing>) QueryUtil.list(q, getDialect(),
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
     * Returns the first mailing in the ordered set where newsletterId = &#63;.
     *
     * @param newsletterId the newsletter ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching mailing
     * @throws net.zylk.liferay.portal.NoSuchMailingException if a matching mailing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Mailing findByNewsletterId_First(long newsletterId,
        OrderByComparator orderByComparator)
        throws NoSuchMailingException, SystemException {
        Mailing mailing = fetchByNewsletterId_First(newsletterId,
                orderByComparator);

        if (mailing != null) {
            return mailing;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("newsletterId=");
        msg.append(newsletterId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMailingException(msg.toString());
    }

    /**
     * Returns the first mailing in the ordered set where newsletterId = &#63;.
     *
     * @param newsletterId the newsletter ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching mailing, or <code>null</code> if a matching mailing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Mailing fetchByNewsletterId_First(long newsletterId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Mailing> list = findByNewsletterId(newsletterId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Mailing findByNewsletterId_Last(long newsletterId,
        OrderByComparator orderByComparator)
        throws NoSuchMailingException, SystemException {
        Mailing mailing = fetchByNewsletterId_Last(newsletterId,
                orderByComparator);

        if (mailing != null) {
            return mailing;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("newsletterId=");
        msg.append(newsletterId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMailingException(msg.toString());
    }

    /**
     * Returns the last mailing in the ordered set where newsletterId = &#63;.
     *
     * @param newsletterId the newsletter ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching mailing, or <code>null</code> if a matching mailing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Mailing fetchByNewsletterId_Last(long newsletterId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByNewsletterId(newsletterId);

        if (count == 0) {
            return null;
        }

        List<Mailing> list = findByNewsletterId(newsletterId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Mailing[] findByNewsletterId_PrevAndNext(long mailingId,
        long newsletterId, OrderByComparator orderByComparator)
        throws NoSuchMailingException, SystemException {
        Mailing mailing = findByPrimaryKey(mailingId);

        Session session = null;

        try {
            session = openSession();

            Mailing[] array = new MailingImpl[3];

            array[0] = getByNewsletterId_PrevAndNext(session, mailing,
                    newsletterId, orderByComparator, true);

            array[1] = mailing;

            array[2] = getByNewsletterId_PrevAndNext(session, mailing,
                    newsletterId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Mailing getByNewsletterId_PrevAndNext(Session session,
        Mailing mailing, long newsletterId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_MAILING_WHERE);

        query.append(_FINDER_COLUMN_NEWSLETTERID_NEWSLETTERID_2);

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
            query.append(MailingModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(newsletterId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(mailing);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Mailing> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the mailings where newsletterId = &#63; from the database.
     *
     * @param newsletterId the newsletter ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByNewsletterId(long newsletterId)
        throws SystemException {
        for (Mailing mailing : findByNewsletterId(newsletterId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(mailing);
        }
    }

    /**
     * Returns the number of mailings where newsletterId = &#63;.
     *
     * @param newsletterId the newsletter ID
     * @return the number of matching mailings
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByNewsletterId(long newsletterId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_NEWSLETTERID;

        Object[] finderArgs = new Object[] { newsletterId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_MAILING_WHERE);

            query.append(_FINDER_COLUMN_NEWSLETTERID_NEWSLETTERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(newsletterId);

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
     * Caches the mailing in the entity cache if it is enabled.
     *
     * @param mailing the mailing
     */
    @Override
    public void cacheResult(Mailing mailing) {
        EntityCacheUtil.putResult(MailingModelImpl.ENTITY_CACHE_ENABLED,
            MailingImpl.class, mailing.getPrimaryKey(), mailing);

        mailing.resetOriginalValues();
    }

    /**
     * Caches the mailings in the entity cache if it is enabled.
     *
     * @param mailings the mailings
     */
    @Override
    public void cacheResult(List<Mailing> mailings) {
        for (Mailing mailing : mailings) {
            if (EntityCacheUtil.getResult(
                        MailingModelImpl.ENTITY_CACHE_ENABLED,
                        MailingImpl.class, mailing.getPrimaryKey()) == null) {
                cacheResult(mailing);
            } else {
                mailing.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all mailings.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(MailingImpl.class.getName());
        }

        EntityCacheUtil.clearCache(MailingImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the mailing.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Mailing mailing) {
        EntityCacheUtil.removeResult(MailingModelImpl.ENTITY_CACHE_ENABLED,
            MailingImpl.class, mailing.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Mailing> mailings) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Mailing mailing : mailings) {
            EntityCacheUtil.removeResult(MailingModelImpl.ENTITY_CACHE_ENABLED,
                MailingImpl.class, mailing.getPrimaryKey());
        }
    }

    /**
     * Creates a new mailing with the primary key. Does not add the mailing to the database.
     *
     * @param mailingId the primary key for the new mailing
     * @return the new mailing
     */
    @Override
    public Mailing create(long mailingId) {
        Mailing mailing = new MailingImpl();

        mailing.setNew(true);
        mailing.setPrimaryKey(mailingId);

        return mailing;
    }

    /**
     * Removes the mailing with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param mailingId the primary key of the mailing
     * @return the mailing that was removed
     * @throws net.zylk.liferay.portal.NoSuchMailingException if a mailing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Mailing remove(long mailingId)
        throws NoSuchMailingException, SystemException {
        return remove((Serializable) mailingId);
    }

    /**
     * Removes the mailing with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the mailing
     * @return the mailing that was removed
     * @throws net.zylk.liferay.portal.NoSuchMailingException if a mailing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Mailing remove(Serializable primaryKey)
        throws NoSuchMailingException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Mailing mailing = (Mailing) session.get(MailingImpl.class,
                    primaryKey);

            if (mailing == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchMailingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(mailing);
        } catch (NoSuchMailingException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Mailing removeImpl(Mailing mailing) throws SystemException {
        mailing = toUnwrappedModel(mailing);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(mailing)) {
                mailing = (Mailing) session.get(MailingImpl.class,
                        mailing.getPrimaryKeyObj());
            }

            if (mailing != null) {
                session.delete(mailing);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (mailing != null) {
            clearCache(mailing);
        }

        return mailing;
    }

    @Override
    public Mailing updateImpl(net.zylk.liferay.portal.model.Mailing mailing)
        throws SystemException {
        mailing = toUnwrappedModel(mailing);

        boolean isNew = mailing.isNew();

        MailingModelImpl mailingModelImpl = (MailingModelImpl) mailing;

        Session session = null;

        try {
            session = openSession();

            if (mailing.isNew()) {
                session.save(mailing);

                mailing.setNew(false);
            } else {
                session.merge(mailing);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !MailingModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((mailingModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        mailingModelImpl.getOriginalCompanyId(),
                        mailingModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID,
                    args);

                args = new Object[] {
                        mailingModelImpl.getCompanyId(),
                        mailingModelImpl.getGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID,
                    args);
            }

            if ((mailingModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NEWSLETTERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        mailingModelImpl.getOriginalNewsletterId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NEWSLETTERID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NEWSLETTERID,
                    args);

                args = new Object[] { mailingModelImpl.getNewsletterId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NEWSLETTERID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NEWSLETTERID,
                    args);
            }
        }

        EntityCacheUtil.putResult(MailingModelImpl.ENTITY_CACHE_ENABLED,
            MailingImpl.class, mailing.getPrimaryKey(), mailing);

        return mailing;
    }

    protected Mailing toUnwrappedModel(Mailing mailing) {
        if (mailing instanceof MailingImpl) {
            return mailing;
        }

        MailingImpl mailingImpl = new MailingImpl();

        mailingImpl.setNew(mailing.isNew());
        mailingImpl.setPrimaryKey(mailing.getPrimaryKey());

        mailingImpl.setMailingId(mailing.getMailingId());
        mailingImpl.setCompanyId(mailing.getCompanyId());
        mailingImpl.setGroupId(mailing.getGroupId());
        mailingImpl.setNewsletterId(mailing.getNewsletterId());
        mailingImpl.setNewsletterName(mailing.getNewsletterName());
        mailingImpl.setEmailFromName(mailing.getEmailFromName());
        mailingImpl.setEmailFromAddress(mailing.getEmailFromAddress());
        mailingImpl.setStartDate(mailing.getStartDate());
        mailingImpl.setFromDate(mailing.getFromDate());
        mailingImpl.setEmailCount(mailing.getEmailCount());
        mailingImpl.setStatus(mailing.getStatus());
        mailingImpl.setIsScheduled(mailing.isIsScheduled());

        return mailingImpl;
    }

    /**
     * Returns the mailing with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the mailing
     * @return the mailing
     * @throws net.zylk.liferay.portal.NoSuchMailingException if a mailing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Mailing findByPrimaryKey(Serializable primaryKey)
        throws NoSuchMailingException, SystemException {
        Mailing mailing = fetchByPrimaryKey(primaryKey);

        if (mailing == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchMailingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return mailing;
    }

    /**
     * Returns the mailing with the primary key or throws a {@link net.zylk.liferay.portal.NoSuchMailingException} if it could not be found.
     *
     * @param mailingId the primary key of the mailing
     * @return the mailing
     * @throws net.zylk.liferay.portal.NoSuchMailingException if a mailing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Mailing findByPrimaryKey(long mailingId)
        throws NoSuchMailingException, SystemException {
        return findByPrimaryKey((Serializable) mailingId);
    }

    /**
     * Returns the mailing with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the mailing
     * @return the mailing, or <code>null</code> if a mailing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Mailing fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Mailing mailing = (Mailing) EntityCacheUtil.getResult(MailingModelImpl.ENTITY_CACHE_ENABLED,
                MailingImpl.class, primaryKey);

        if (mailing == _nullMailing) {
            return null;
        }

        if (mailing == null) {
            Session session = null;

            try {
                session = openSession();

                mailing = (Mailing) session.get(MailingImpl.class, primaryKey);

                if (mailing != null) {
                    cacheResult(mailing);
                } else {
                    EntityCacheUtil.putResult(MailingModelImpl.ENTITY_CACHE_ENABLED,
                        MailingImpl.class, primaryKey, _nullMailing);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(MailingModelImpl.ENTITY_CACHE_ENABLED,
                    MailingImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return mailing;
    }

    /**
     * Returns the mailing with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param mailingId the primary key of the mailing
     * @return the mailing, or <code>null</code> if a mailing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Mailing fetchByPrimaryKey(long mailingId) throws SystemException {
        return fetchByPrimaryKey((Serializable) mailingId);
    }

    /**
     * Returns all the mailings.
     *
     * @return the mailings
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Mailing> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Mailing> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<Mailing> findAll(int start, int end,
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

        List<Mailing> list = (List<Mailing>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_MAILING);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_MAILING;

                if (pagination) {
                    sql = sql.concat(MailingModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Mailing>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Mailing>(list);
                } else {
                    list = (List<Mailing>) QueryUtil.list(q, getDialect(),
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
     * Removes all the mailings from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Mailing mailing : findAll()) {
            remove(mailing);
        }
    }

    /**
     * Returns the number of mailings.
     *
     * @return the number of mailings
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

                Query q = session.createQuery(_SQL_COUNT_MAILING);

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
     * Initializes the mailing persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.net.zylk.liferay.portal.model.Mailing")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Mailing>> listenersList = new ArrayList<ModelListener<Mailing>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Mailing>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(MailingImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
