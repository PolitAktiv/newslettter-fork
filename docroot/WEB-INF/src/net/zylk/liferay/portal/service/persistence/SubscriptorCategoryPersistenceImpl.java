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

import net.zylk.liferay.portal.NoSuchSubscriptorCategoryException;
import net.zylk.liferay.portal.model.SubscriptorCategory;
import net.zylk.liferay.portal.model.impl.SubscriptorCategoryImpl;
import net.zylk.liferay.portal.model.impl.SubscriptorCategoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the subscriptor category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author zylk.net
 * @see SubscriptorCategoryPersistence
 * @see SubscriptorCategoryUtil
 * @generated
 */
public class SubscriptorCategoryPersistenceImpl extends BasePersistenceImpl<SubscriptorCategory>
    implements SubscriptorCategoryPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link SubscriptorCategoryUtil} to access the subscriptor category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = SubscriptorCategoryImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SubscriptorCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptorCategoryModelImpl.FINDER_CACHE_ENABLED,
            SubscriptorCategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SubscriptorCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptorCategoryModelImpl.FINDER_CACHE_ENABLED,
            SubscriptorCategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SubscriptorCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptorCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SUBSCRIPTORID =
        new FinderPath(SubscriptorCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptorCategoryModelImpl.FINDER_CACHE_ENABLED,
            SubscriptorCategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySubscriptorId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBSCRIPTORID =
        new FinderPath(SubscriptorCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptorCategoryModelImpl.FINDER_CACHE_ENABLED,
            SubscriptorCategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySubscriptorId",
            new String[] { Long.class.getName() },
            SubscriptorCategoryModelImpl.SUBSCRIPTORID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SUBSCRIPTORID = new FinderPath(SubscriptorCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptorCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySubscriptorId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_SUBSCRIPTORID_SUBSCRIPTORID_2 = "subscriptorCategory.subscriptorId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYID =
        new FinderPath(SubscriptorCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptorCategoryModelImpl.FINDER_CACHE_ENABLED,
            SubscriptorCategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategoryId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID =
        new FinderPath(SubscriptorCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptorCategoryModelImpl.FINDER_CACHE_ENABLED,
            SubscriptorCategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategoryId",
            new String[] { Long.class.getName() },
            SubscriptorCategoryModelImpl.CATEGORYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYID = new FinderPath(SubscriptorCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptorCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategoryId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_CATEGORYID_CATEGORYID_2 = "subscriptorCategory.categoryId = ?";
    public static final FinderPath FINDER_PATH_FETCH_BY_SUBSCRIPTORIDANDCATEGORYID =
        new FinderPath(SubscriptorCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptorCategoryModelImpl.FINDER_CACHE_ENABLED,
            SubscriptorCategoryImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchBySubscriptorIdAndCategoryId",
            new String[] { Long.class.getName(), Long.class.getName() },
            SubscriptorCategoryModelImpl.SUBSCRIPTORID_COLUMN_BITMASK |
            SubscriptorCategoryModelImpl.CATEGORYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SUBSCRIPTORIDANDCATEGORYID =
        new FinderPath(SubscriptorCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptorCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countBySubscriptorIdAndCategoryId",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_SUBSCRIPTORIDANDCATEGORYID_SUBSCRIPTORID_2 =
        "subscriptorCategory.subscriptorId = ? AND ";
    private static final String _FINDER_COLUMN_SUBSCRIPTORIDANDCATEGORYID_CATEGORYID_2 =
        "subscriptorCategory.categoryId = ?";
    private static final String _SQL_SELECT_SUBSCRIPTORCATEGORY = "SELECT subscriptorCategory FROM SubscriptorCategory subscriptorCategory";
    private static final String _SQL_SELECT_SUBSCRIPTORCATEGORY_WHERE = "SELECT subscriptorCategory FROM SubscriptorCategory subscriptorCategory WHERE ";
    private static final String _SQL_COUNT_SUBSCRIPTORCATEGORY = "SELECT COUNT(subscriptorCategory) FROM SubscriptorCategory subscriptorCategory";
    private static final String _SQL_COUNT_SUBSCRIPTORCATEGORY_WHERE = "SELECT COUNT(subscriptorCategory) FROM SubscriptorCategory subscriptorCategory WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "subscriptorCategory.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SubscriptorCategory exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SubscriptorCategory exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(SubscriptorCategoryPersistenceImpl.class);
    private static SubscriptorCategory _nullSubscriptorCategory = new SubscriptorCategoryImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<SubscriptorCategory> toCacheModel() {
                return _nullSubscriptorCategoryCacheModel;
            }
        };

    private static CacheModel<SubscriptorCategory> _nullSubscriptorCategoryCacheModel =
        new CacheModel<SubscriptorCategory>() {
            @Override
            public SubscriptorCategory toEntityModel() {
                return _nullSubscriptorCategory;
            }
        };

    public SubscriptorCategoryPersistenceImpl() {
        setModelClass(SubscriptorCategory.class);
    }

    /**
     * Returns all the subscriptor categories where subscriptorId = &#63;.
     *
     * @param subscriptorId the subscriptor ID
     * @return the matching subscriptor categories
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SubscriptorCategory> findBySubscriptorId(long subscriptorId)
        throws SystemException {
        return findBySubscriptorId(subscriptorId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the subscriptor categories where subscriptorId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.SubscriptorCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param subscriptorId the subscriptor ID
     * @param start the lower bound of the range of subscriptor categories
     * @param end the upper bound of the range of subscriptor categories (not inclusive)
     * @return the range of matching subscriptor categories
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SubscriptorCategory> findBySubscriptorId(long subscriptorId,
        int start, int end) throws SystemException {
        return findBySubscriptorId(subscriptorId, start, end, null);
    }

    /**
     * Returns an ordered range of all the subscriptor categories where subscriptorId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.SubscriptorCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param subscriptorId the subscriptor ID
     * @param start the lower bound of the range of subscriptor categories
     * @param end the upper bound of the range of subscriptor categories (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching subscriptor categories
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SubscriptorCategory> findBySubscriptorId(long subscriptorId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBSCRIPTORID;
            finderArgs = new Object[] { subscriptorId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SUBSCRIPTORID;
            finderArgs = new Object[] {
                    subscriptorId,
                    
                    start, end, orderByComparator
                };
        }

        List<SubscriptorCategory> list = (List<SubscriptorCategory>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (SubscriptorCategory subscriptorCategory : list) {
                if ((subscriptorId != subscriptorCategory.getSubscriptorId())) {
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

            query.append(_SQL_SELECT_SUBSCRIPTORCATEGORY_WHERE);

            query.append(_FINDER_COLUMN_SUBSCRIPTORID_SUBSCRIPTORID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(SubscriptorCategoryModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(subscriptorId);

                if (!pagination) {
                    list = (List<SubscriptorCategory>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<SubscriptorCategory>(list);
                } else {
                    list = (List<SubscriptorCategory>) QueryUtil.list(q,
                            getDialect(), start, end);
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
     * Returns the first subscriptor category in the ordered set where subscriptorId = &#63;.
     *
     * @param subscriptorId the subscriptor ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching subscriptor category
     * @throws net.zylk.liferay.portal.NoSuchSubscriptorCategoryException if a matching subscriptor category could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SubscriptorCategory findBySubscriptorId_First(long subscriptorId,
        OrderByComparator orderByComparator)
        throws NoSuchSubscriptorCategoryException, SystemException {
        SubscriptorCategory subscriptorCategory = fetchBySubscriptorId_First(subscriptorId,
                orderByComparator);

        if (subscriptorCategory != null) {
            return subscriptorCategory;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("subscriptorId=");
        msg.append(subscriptorId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSubscriptorCategoryException(msg.toString());
    }

    /**
     * Returns the first subscriptor category in the ordered set where subscriptorId = &#63;.
     *
     * @param subscriptorId the subscriptor ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching subscriptor category, or <code>null</code> if a matching subscriptor category could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SubscriptorCategory fetchBySubscriptorId_First(long subscriptorId,
        OrderByComparator orderByComparator) throws SystemException {
        List<SubscriptorCategory> list = findBySubscriptorId(subscriptorId, 0,
                1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last subscriptor category in the ordered set where subscriptorId = &#63;.
     *
     * @param subscriptorId the subscriptor ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching subscriptor category
     * @throws net.zylk.liferay.portal.NoSuchSubscriptorCategoryException if a matching subscriptor category could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SubscriptorCategory findBySubscriptorId_Last(long subscriptorId,
        OrderByComparator orderByComparator)
        throws NoSuchSubscriptorCategoryException, SystemException {
        SubscriptorCategory subscriptorCategory = fetchBySubscriptorId_Last(subscriptorId,
                orderByComparator);

        if (subscriptorCategory != null) {
            return subscriptorCategory;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("subscriptorId=");
        msg.append(subscriptorId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSubscriptorCategoryException(msg.toString());
    }

    /**
     * Returns the last subscriptor category in the ordered set where subscriptorId = &#63;.
     *
     * @param subscriptorId the subscriptor ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching subscriptor category, or <code>null</code> if a matching subscriptor category could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SubscriptorCategory fetchBySubscriptorId_Last(long subscriptorId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBySubscriptorId(subscriptorId);

        if (count == 0) {
            return null;
        }

        List<SubscriptorCategory> list = findBySubscriptorId(subscriptorId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the subscriptor categories before and after the current subscriptor category in the ordered set where subscriptorId = &#63;.
     *
     * @param subscriptorCategoryId the primary key of the current subscriptor category
     * @param subscriptorId the subscriptor ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next subscriptor category
     * @throws net.zylk.liferay.portal.NoSuchSubscriptorCategoryException if a subscriptor category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SubscriptorCategory[] findBySubscriptorId_PrevAndNext(
        long subscriptorCategoryId, long subscriptorId,
        OrderByComparator orderByComparator)
        throws NoSuchSubscriptorCategoryException, SystemException {
        SubscriptorCategory subscriptorCategory = findByPrimaryKey(subscriptorCategoryId);

        Session session = null;

        try {
            session = openSession();

            SubscriptorCategory[] array = new SubscriptorCategoryImpl[3];

            array[0] = getBySubscriptorId_PrevAndNext(session,
                    subscriptorCategory, subscriptorId, orderByComparator, true);

            array[1] = subscriptorCategory;

            array[2] = getBySubscriptorId_PrevAndNext(session,
                    subscriptorCategory, subscriptorId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected SubscriptorCategory getBySubscriptorId_PrevAndNext(
        Session session, SubscriptorCategory subscriptorCategory,
        long subscriptorId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SUBSCRIPTORCATEGORY_WHERE);

        query.append(_FINDER_COLUMN_SUBSCRIPTORID_SUBSCRIPTORID_2);

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
            query.append(SubscriptorCategoryModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(subscriptorId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(subscriptorCategory);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<SubscriptorCategory> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the subscriptor categories where subscriptorId = &#63; from the database.
     *
     * @param subscriptorId the subscriptor ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBySubscriptorId(long subscriptorId)
        throws SystemException {
        for (SubscriptorCategory subscriptorCategory : findBySubscriptorId(
                subscriptorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(subscriptorCategory);
        }
    }

    /**
     * Returns the number of subscriptor categories where subscriptorId = &#63;.
     *
     * @param subscriptorId the subscriptor ID
     * @return the number of matching subscriptor categories
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBySubscriptorId(long subscriptorId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_SUBSCRIPTORID;

        Object[] finderArgs = new Object[] { subscriptorId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SUBSCRIPTORCATEGORY_WHERE);

            query.append(_FINDER_COLUMN_SUBSCRIPTORID_SUBSCRIPTORID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(subscriptorId);

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
     * Returns all the subscriptor categories where categoryId = &#63;.
     *
     * @param categoryId the category ID
     * @return the matching subscriptor categories
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SubscriptorCategory> findByCategoryId(long categoryId)
        throws SystemException {
        return findByCategoryId(categoryId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the subscriptor categories where categoryId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.SubscriptorCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param categoryId the category ID
     * @param start the lower bound of the range of subscriptor categories
     * @param end the upper bound of the range of subscriptor categories (not inclusive)
     * @return the range of matching subscriptor categories
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SubscriptorCategory> findByCategoryId(long categoryId,
        int start, int end) throws SystemException {
        return findByCategoryId(categoryId, start, end, null);
    }

    /**
     * Returns an ordered range of all the subscriptor categories where categoryId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.SubscriptorCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param categoryId the category ID
     * @param start the lower bound of the range of subscriptor categories
     * @param end the upper bound of the range of subscriptor categories (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching subscriptor categories
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SubscriptorCategory> findByCategoryId(long categoryId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID;
            finderArgs = new Object[] { categoryId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYID;
            finderArgs = new Object[] { categoryId, start, end, orderByComparator };
        }

        List<SubscriptorCategory> list = (List<SubscriptorCategory>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (SubscriptorCategory subscriptorCategory : list) {
                if ((categoryId != subscriptorCategory.getCategoryId())) {
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

            query.append(_SQL_SELECT_SUBSCRIPTORCATEGORY_WHERE);

            query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(SubscriptorCategoryModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(categoryId);

                if (!pagination) {
                    list = (List<SubscriptorCategory>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<SubscriptorCategory>(list);
                } else {
                    list = (List<SubscriptorCategory>) QueryUtil.list(q,
                            getDialect(), start, end);
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
     * Returns the first subscriptor category in the ordered set where categoryId = &#63;.
     *
     * @param categoryId the category ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching subscriptor category
     * @throws net.zylk.liferay.portal.NoSuchSubscriptorCategoryException if a matching subscriptor category could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SubscriptorCategory findByCategoryId_First(long categoryId,
        OrderByComparator orderByComparator)
        throws NoSuchSubscriptorCategoryException, SystemException {
        SubscriptorCategory subscriptorCategory = fetchByCategoryId_First(categoryId,
                orderByComparator);

        if (subscriptorCategory != null) {
            return subscriptorCategory;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("categoryId=");
        msg.append(categoryId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSubscriptorCategoryException(msg.toString());
    }

    /**
     * Returns the first subscriptor category in the ordered set where categoryId = &#63;.
     *
     * @param categoryId the category ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching subscriptor category, or <code>null</code> if a matching subscriptor category could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SubscriptorCategory fetchByCategoryId_First(long categoryId,
        OrderByComparator orderByComparator) throws SystemException {
        List<SubscriptorCategory> list = findByCategoryId(categoryId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last subscriptor category in the ordered set where categoryId = &#63;.
     *
     * @param categoryId the category ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching subscriptor category
     * @throws net.zylk.liferay.portal.NoSuchSubscriptorCategoryException if a matching subscriptor category could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SubscriptorCategory findByCategoryId_Last(long categoryId,
        OrderByComparator orderByComparator)
        throws NoSuchSubscriptorCategoryException, SystemException {
        SubscriptorCategory subscriptorCategory = fetchByCategoryId_Last(categoryId,
                orderByComparator);

        if (subscriptorCategory != null) {
            return subscriptorCategory;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("categoryId=");
        msg.append(categoryId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSubscriptorCategoryException(msg.toString());
    }

    /**
     * Returns the last subscriptor category in the ordered set where categoryId = &#63;.
     *
     * @param categoryId the category ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching subscriptor category, or <code>null</code> if a matching subscriptor category could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SubscriptorCategory fetchByCategoryId_Last(long categoryId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCategoryId(categoryId);

        if (count == 0) {
            return null;
        }

        List<SubscriptorCategory> list = findByCategoryId(categoryId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the subscriptor categories before and after the current subscriptor category in the ordered set where categoryId = &#63;.
     *
     * @param subscriptorCategoryId the primary key of the current subscriptor category
     * @param categoryId the category ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next subscriptor category
     * @throws net.zylk.liferay.portal.NoSuchSubscriptorCategoryException if a subscriptor category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SubscriptorCategory[] findByCategoryId_PrevAndNext(
        long subscriptorCategoryId, long categoryId,
        OrderByComparator orderByComparator)
        throws NoSuchSubscriptorCategoryException, SystemException {
        SubscriptorCategory subscriptorCategory = findByPrimaryKey(subscriptorCategoryId);

        Session session = null;

        try {
            session = openSession();

            SubscriptorCategory[] array = new SubscriptorCategoryImpl[3];

            array[0] = getByCategoryId_PrevAndNext(session,
                    subscriptorCategory, categoryId, orderByComparator, true);

            array[1] = subscriptorCategory;

            array[2] = getByCategoryId_PrevAndNext(session,
                    subscriptorCategory, categoryId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected SubscriptorCategory getByCategoryId_PrevAndNext(Session session,
        SubscriptorCategory subscriptorCategory, long categoryId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SUBSCRIPTORCATEGORY_WHERE);

        query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

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
            query.append(SubscriptorCategoryModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(categoryId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(subscriptorCategory);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<SubscriptorCategory> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the subscriptor categories where categoryId = &#63; from the database.
     *
     * @param categoryId the category ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCategoryId(long categoryId) throws SystemException {
        for (SubscriptorCategory subscriptorCategory : findByCategoryId(
                categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(subscriptorCategory);
        }
    }

    /**
     * Returns the number of subscriptor categories where categoryId = &#63;.
     *
     * @param categoryId the category ID
     * @return the number of matching subscriptor categories
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCategoryId(long categoryId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORYID;

        Object[] finderArgs = new Object[] { categoryId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SUBSCRIPTORCATEGORY_WHERE);

            query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(categoryId);

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
     * Returns the subscriptor category where subscriptorId = &#63; and categoryId = &#63; or throws a {@link net.zylk.liferay.portal.NoSuchSubscriptorCategoryException} if it could not be found.
     *
     * @param subscriptorId the subscriptor ID
     * @param categoryId the category ID
     * @return the matching subscriptor category
     * @throws net.zylk.liferay.portal.NoSuchSubscriptorCategoryException if a matching subscriptor category could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SubscriptorCategory findBySubscriptorIdAndCategoryId(
        long subscriptorId, long categoryId)
        throws NoSuchSubscriptorCategoryException, SystemException {
        SubscriptorCategory subscriptorCategory = fetchBySubscriptorIdAndCategoryId(subscriptorId,
                categoryId);

        if (subscriptorCategory == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("subscriptorId=");
            msg.append(subscriptorId);

            msg.append(", categoryId=");
            msg.append(categoryId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchSubscriptorCategoryException(msg.toString());
        }

        return subscriptorCategory;
    }

    /**
     * Returns the subscriptor category where subscriptorId = &#63; and categoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param subscriptorId the subscriptor ID
     * @param categoryId the category ID
     * @return the matching subscriptor category, or <code>null</code> if a matching subscriptor category could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SubscriptorCategory fetchBySubscriptorIdAndCategoryId(
        long subscriptorId, long categoryId) throws SystemException {
        return fetchBySubscriptorIdAndCategoryId(subscriptorId, categoryId, true);
    }

    /**
     * Returns the subscriptor category where subscriptorId = &#63; and categoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param subscriptorId the subscriptor ID
     * @param categoryId the category ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching subscriptor category, or <code>null</code> if a matching subscriptor category could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SubscriptorCategory fetchBySubscriptorIdAndCategoryId(
        long subscriptorId, long categoryId, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { subscriptorId, categoryId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SUBSCRIPTORIDANDCATEGORYID,
                    finderArgs, this);
        }

        if (result instanceof SubscriptorCategory) {
            SubscriptorCategory subscriptorCategory = (SubscriptorCategory) result;

            if ((subscriptorId != subscriptorCategory.getSubscriptorId()) ||
                    (categoryId != subscriptorCategory.getCategoryId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_SUBSCRIPTORCATEGORY_WHERE);

            query.append(_FINDER_COLUMN_SUBSCRIPTORIDANDCATEGORYID_SUBSCRIPTORID_2);

            query.append(_FINDER_COLUMN_SUBSCRIPTORIDANDCATEGORYID_CATEGORYID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(subscriptorId);

                qPos.add(categoryId);

                List<SubscriptorCategory> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SUBSCRIPTORIDANDCATEGORYID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "SubscriptorCategoryPersistenceImpl.fetchBySubscriptorIdAndCategoryId(long, long, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    SubscriptorCategory subscriptorCategory = list.get(0);

                    result = subscriptorCategory;

                    cacheResult(subscriptorCategory);

                    if ((subscriptorCategory.getSubscriptorId() != subscriptorId) ||
                            (subscriptorCategory.getCategoryId() != categoryId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SUBSCRIPTORIDANDCATEGORYID,
                            finderArgs, subscriptorCategory);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SUBSCRIPTORIDANDCATEGORYID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (SubscriptorCategory) result;
        }
    }

    /**
     * Removes the subscriptor category where subscriptorId = &#63; and categoryId = &#63; from the database.
     *
     * @param subscriptorId the subscriptor ID
     * @param categoryId the category ID
     * @return the subscriptor category that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SubscriptorCategory removeBySubscriptorIdAndCategoryId(
        long subscriptorId, long categoryId)
        throws NoSuchSubscriptorCategoryException, SystemException {
        SubscriptorCategory subscriptorCategory = findBySubscriptorIdAndCategoryId(subscriptorId,
                categoryId);

        return remove(subscriptorCategory);
    }

    /**
     * Returns the number of subscriptor categories where subscriptorId = &#63; and categoryId = &#63;.
     *
     * @param subscriptorId the subscriptor ID
     * @param categoryId the category ID
     * @return the number of matching subscriptor categories
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBySubscriptorIdAndCategoryId(long subscriptorId,
        long categoryId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_SUBSCRIPTORIDANDCATEGORYID;

        Object[] finderArgs = new Object[] { subscriptorId, categoryId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_SUBSCRIPTORCATEGORY_WHERE);

            query.append(_FINDER_COLUMN_SUBSCRIPTORIDANDCATEGORYID_SUBSCRIPTORID_2);

            query.append(_FINDER_COLUMN_SUBSCRIPTORIDANDCATEGORYID_CATEGORYID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(subscriptorId);

                qPos.add(categoryId);

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
     * Caches the subscriptor category in the entity cache if it is enabled.
     *
     * @param subscriptorCategory the subscriptor category
     */
    @Override
    public void cacheResult(SubscriptorCategory subscriptorCategory) {
        EntityCacheUtil.putResult(SubscriptorCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptorCategoryImpl.class, subscriptorCategory.getPrimaryKey(),
            subscriptorCategory);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SUBSCRIPTORIDANDCATEGORYID,
            new Object[] {
                subscriptorCategory.getSubscriptorId(),
                subscriptorCategory.getCategoryId()
            }, subscriptorCategory);

        subscriptorCategory.resetOriginalValues();
    }

    /**
     * Caches the subscriptor categories in the entity cache if it is enabled.
     *
     * @param subscriptorCategories the subscriptor categories
     */
    @Override
    public void cacheResult(List<SubscriptorCategory> subscriptorCategories) {
        for (SubscriptorCategory subscriptorCategory : subscriptorCategories) {
            if (EntityCacheUtil.getResult(
                        SubscriptorCategoryModelImpl.ENTITY_CACHE_ENABLED,
                        SubscriptorCategoryImpl.class,
                        subscriptorCategory.getPrimaryKey()) == null) {
                cacheResult(subscriptorCategory);
            } else {
                subscriptorCategory.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all subscriptor categories.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(SubscriptorCategoryImpl.class.getName());
        }

        EntityCacheUtil.clearCache(SubscriptorCategoryImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the subscriptor category.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(SubscriptorCategory subscriptorCategory) {
        EntityCacheUtil.removeResult(SubscriptorCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptorCategoryImpl.class, subscriptorCategory.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(subscriptorCategory);
    }

    @Override
    public void clearCache(List<SubscriptorCategory> subscriptorCategories) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (SubscriptorCategory subscriptorCategory : subscriptorCategories) {
            EntityCacheUtil.removeResult(SubscriptorCategoryModelImpl.ENTITY_CACHE_ENABLED,
                SubscriptorCategoryImpl.class,
                subscriptorCategory.getPrimaryKey());

            clearUniqueFindersCache(subscriptorCategory);
        }
    }

    protected void cacheUniqueFindersCache(
        SubscriptorCategory subscriptorCategory) {
        if (subscriptorCategory.isNew()) {
            Object[] args = new Object[] {
                    subscriptorCategory.getSubscriptorId(),
                    subscriptorCategory.getCategoryId()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SUBSCRIPTORIDANDCATEGORYID,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SUBSCRIPTORIDANDCATEGORYID,
                args, subscriptorCategory);
        } else {
            SubscriptorCategoryModelImpl subscriptorCategoryModelImpl = (SubscriptorCategoryModelImpl) subscriptorCategory;

            if ((subscriptorCategoryModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_SUBSCRIPTORIDANDCATEGORYID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        subscriptorCategory.getSubscriptorId(),
                        subscriptorCategory.getCategoryId()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SUBSCRIPTORIDANDCATEGORYID,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SUBSCRIPTORIDANDCATEGORYID,
                    args, subscriptorCategory);
            }
        }
    }

    protected void clearUniqueFindersCache(
        SubscriptorCategory subscriptorCategory) {
        SubscriptorCategoryModelImpl subscriptorCategoryModelImpl = (SubscriptorCategoryModelImpl) subscriptorCategory;

        Object[] args = new Object[] {
                subscriptorCategory.getSubscriptorId(),
                subscriptorCategory.getCategoryId()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SUBSCRIPTORIDANDCATEGORYID,
            args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SUBSCRIPTORIDANDCATEGORYID,
            args);

        if ((subscriptorCategoryModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_SUBSCRIPTORIDANDCATEGORYID.getColumnBitmask()) != 0) {
            args = new Object[] {
                    subscriptorCategoryModelImpl.getOriginalSubscriptorId(),
                    subscriptorCategoryModelImpl.getOriginalCategoryId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SUBSCRIPTORIDANDCATEGORYID,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SUBSCRIPTORIDANDCATEGORYID,
                args);
        }
    }

    /**
     * Creates a new subscriptor category with the primary key. Does not add the subscriptor category to the database.
     *
     * @param subscriptorCategoryId the primary key for the new subscriptor category
     * @return the new subscriptor category
     */
    @Override
    public SubscriptorCategory create(long subscriptorCategoryId) {
        SubscriptorCategory subscriptorCategory = new SubscriptorCategoryImpl();

        subscriptorCategory.setNew(true);
        subscriptorCategory.setPrimaryKey(subscriptorCategoryId);

        return subscriptorCategory;
    }

    /**
     * Removes the subscriptor category with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param subscriptorCategoryId the primary key of the subscriptor category
     * @return the subscriptor category that was removed
     * @throws net.zylk.liferay.portal.NoSuchSubscriptorCategoryException if a subscriptor category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SubscriptorCategory remove(long subscriptorCategoryId)
        throws NoSuchSubscriptorCategoryException, SystemException {
        return remove((Serializable) subscriptorCategoryId);
    }

    /**
     * Removes the subscriptor category with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the subscriptor category
     * @return the subscriptor category that was removed
     * @throws net.zylk.liferay.portal.NoSuchSubscriptorCategoryException if a subscriptor category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SubscriptorCategory remove(Serializable primaryKey)
        throws NoSuchSubscriptorCategoryException, SystemException {
        Session session = null;

        try {
            session = openSession();

            SubscriptorCategory subscriptorCategory = (SubscriptorCategory) session.get(SubscriptorCategoryImpl.class,
                    primaryKey);

            if (subscriptorCategory == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchSubscriptorCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(subscriptorCategory);
        } catch (NoSuchSubscriptorCategoryException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected SubscriptorCategory removeImpl(
        SubscriptorCategory subscriptorCategory) throws SystemException {
        subscriptorCategory = toUnwrappedModel(subscriptorCategory);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(subscriptorCategory)) {
                subscriptorCategory = (SubscriptorCategory) session.get(SubscriptorCategoryImpl.class,
                        subscriptorCategory.getPrimaryKeyObj());
            }

            if (subscriptorCategory != null) {
                session.delete(subscriptorCategory);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (subscriptorCategory != null) {
            clearCache(subscriptorCategory);
        }

        return subscriptorCategory;
    }

    @Override
    public SubscriptorCategory updateImpl(
        net.zylk.liferay.portal.model.SubscriptorCategory subscriptorCategory)
        throws SystemException {
        subscriptorCategory = toUnwrappedModel(subscriptorCategory);

        boolean isNew = subscriptorCategory.isNew();

        SubscriptorCategoryModelImpl subscriptorCategoryModelImpl = (SubscriptorCategoryModelImpl) subscriptorCategory;

        Session session = null;

        try {
            session = openSession();

            if (subscriptorCategory.isNew()) {
                session.save(subscriptorCategory);

                subscriptorCategory.setNew(false);
            } else {
                session.merge(subscriptorCategory);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !SubscriptorCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((subscriptorCategoryModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBSCRIPTORID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        subscriptorCategoryModelImpl.getOriginalSubscriptorId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SUBSCRIPTORID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBSCRIPTORID,
                    args);

                args = new Object[] {
                        subscriptorCategoryModelImpl.getSubscriptorId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SUBSCRIPTORID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBSCRIPTORID,
                    args);
            }

            if ((subscriptorCategoryModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        subscriptorCategoryModelImpl.getOriginalCategoryId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID,
                    args);

                args = new Object[] { subscriptorCategoryModelImpl.getCategoryId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID,
                    args);
            }
        }

        EntityCacheUtil.putResult(SubscriptorCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptorCategoryImpl.class, subscriptorCategory.getPrimaryKey(),
            subscriptorCategory);

        clearUniqueFindersCache(subscriptorCategory);
        cacheUniqueFindersCache(subscriptorCategory);

        return subscriptorCategory;
    }

    protected SubscriptorCategory toUnwrappedModel(
        SubscriptorCategory subscriptorCategory) {
        if (subscriptorCategory instanceof SubscriptorCategoryImpl) {
            return subscriptorCategory;
        }

        SubscriptorCategoryImpl subscriptorCategoryImpl = new SubscriptorCategoryImpl();

        subscriptorCategoryImpl.setNew(subscriptorCategory.isNew());
        subscriptorCategoryImpl.setPrimaryKey(subscriptorCategory.getPrimaryKey());

        subscriptorCategoryImpl.setSubscriptorCategoryId(subscriptorCategory.getSubscriptorCategoryId());
        subscriptorCategoryImpl.setSubscriptorId(subscriptorCategory.getSubscriptorId());
        subscriptorCategoryImpl.setCategoryId(subscriptorCategory.getCategoryId());

        return subscriptorCategoryImpl;
    }

    /**
     * Returns the subscriptor category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the subscriptor category
     * @return the subscriptor category
     * @throws net.zylk.liferay.portal.NoSuchSubscriptorCategoryException if a subscriptor category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SubscriptorCategory findByPrimaryKey(Serializable primaryKey)
        throws NoSuchSubscriptorCategoryException, SystemException {
        SubscriptorCategory subscriptorCategory = fetchByPrimaryKey(primaryKey);

        if (subscriptorCategory == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchSubscriptorCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return subscriptorCategory;
    }

    /**
     * Returns the subscriptor category with the primary key or throws a {@link net.zylk.liferay.portal.NoSuchSubscriptorCategoryException} if it could not be found.
     *
     * @param subscriptorCategoryId the primary key of the subscriptor category
     * @return the subscriptor category
     * @throws net.zylk.liferay.portal.NoSuchSubscriptorCategoryException if a subscriptor category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SubscriptorCategory findByPrimaryKey(long subscriptorCategoryId)
        throws NoSuchSubscriptorCategoryException, SystemException {
        return findByPrimaryKey((Serializable) subscriptorCategoryId);
    }

    /**
     * Returns the subscriptor category with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the subscriptor category
     * @return the subscriptor category, or <code>null</code> if a subscriptor category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SubscriptorCategory fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        SubscriptorCategory subscriptorCategory = (SubscriptorCategory) EntityCacheUtil.getResult(SubscriptorCategoryModelImpl.ENTITY_CACHE_ENABLED,
                SubscriptorCategoryImpl.class, primaryKey);

        if (subscriptorCategory == _nullSubscriptorCategory) {
            return null;
        }

        if (subscriptorCategory == null) {
            Session session = null;

            try {
                session = openSession();

                subscriptorCategory = (SubscriptorCategory) session.get(SubscriptorCategoryImpl.class,
                        primaryKey);

                if (subscriptorCategory != null) {
                    cacheResult(subscriptorCategory);
                } else {
                    EntityCacheUtil.putResult(SubscriptorCategoryModelImpl.ENTITY_CACHE_ENABLED,
                        SubscriptorCategoryImpl.class, primaryKey,
                        _nullSubscriptorCategory);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(SubscriptorCategoryModelImpl.ENTITY_CACHE_ENABLED,
                    SubscriptorCategoryImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return subscriptorCategory;
    }

    /**
     * Returns the subscriptor category with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param subscriptorCategoryId the primary key of the subscriptor category
     * @return the subscriptor category, or <code>null</code> if a subscriptor category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SubscriptorCategory fetchByPrimaryKey(long subscriptorCategoryId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) subscriptorCategoryId);
    }

    /**
     * Returns all the subscriptor categories.
     *
     * @return the subscriptor categories
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SubscriptorCategory> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the subscriptor categories.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.SubscriptorCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of subscriptor categories
     * @param end the upper bound of the range of subscriptor categories (not inclusive)
     * @return the range of subscriptor categories
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SubscriptorCategory> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the subscriptor categories.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.SubscriptorCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of subscriptor categories
     * @param end the upper bound of the range of subscriptor categories (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of subscriptor categories
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SubscriptorCategory> findAll(int start, int end,
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

        List<SubscriptorCategory> list = (List<SubscriptorCategory>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_SUBSCRIPTORCATEGORY);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_SUBSCRIPTORCATEGORY;

                if (pagination) {
                    sql = sql.concat(SubscriptorCategoryModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<SubscriptorCategory>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<SubscriptorCategory>(list);
                } else {
                    list = (List<SubscriptorCategory>) QueryUtil.list(q,
                            getDialect(), start, end);
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
     * Removes all the subscriptor categories from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (SubscriptorCategory subscriptorCategory : findAll()) {
            remove(subscriptorCategory);
        }
    }

    /**
     * Returns the number of subscriptor categories.
     *
     * @return the number of subscriptor categories
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

                Query q = session.createQuery(_SQL_COUNT_SUBSCRIPTORCATEGORY);

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
     * Initializes the subscriptor category persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.net.zylk.liferay.portal.model.SubscriptorCategory")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<SubscriptorCategory>> listenersList = new ArrayList<ModelListener<SubscriptorCategory>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<SubscriptorCategory>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(SubscriptorCategoryImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
