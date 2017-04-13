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

import net.zylk.liferay.portal.NoSuchCategoryException;
import net.zylk.liferay.portal.model.Category;
import net.zylk.liferay.portal.model.impl.CategoryImpl;
import net.zylk.liferay.portal.model.impl.CategoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author zylk.net
 * @see CategoryPersistence
 * @see CategoryUtil
 * @generated
 */
public class CategoryPersistenceImpl extends BasePersistenceImpl<Category>
    implements CategoryPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link CategoryUtil} to access the category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = CategoryImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryModelImpl.FINDER_CACHE_ENABLED, CategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryModelImpl.FINDER_CACHE_ENABLED, CategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYIDANDGROUPID =
        new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryModelImpl.FINDER_CACHE_ENABLED, CategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByCompanyIdAndGroupId",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID =
        new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryModelImpl.FINDER_CACHE_ENABLED, CategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByCompanyIdAndGroupId",
            new String[] { Long.class.getName(), Long.class.getName() },
            CategoryModelImpl.COMPANYID_COLUMN_BITMASK |
            CategoryModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByCompanyIdAndGroupId",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_COMPANYIDANDGROUPID_COMPANYID_2 = "category.companyId = ? AND ";
    private static final String _FINDER_COLUMN_COMPANYIDANDGROUPID_GROUPID_2 = "category.groupId = ?";
    private static final String _SQL_SELECT_CATEGORY = "SELECT category FROM Category category";
    private static final String _SQL_SELECT_CATEGORY_WHERE = "SELECT category FROM Category category WHERE ";
    private static final String _SQL_COUNT_CATEGORY = "SELECT COUNT(category) FROM Category category";
    private static final String _SQL_COUNT_CATEGORY_WHERE = "SELECT COUNT(category) FROM Category category WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "category.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Category exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Category exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(CategoryPersistenceImpl.class);
    private static Category _nullCategory = new CategoryImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Category> toCacheModel() {
                return _nullCategoryCacheModel;
            }
        };

    private static CacheModel<Category> _nullCategoryCacheModel = new CacheModel<Category>() {
            @Override
            public Category toEntityModel() {
                return _nullCategory;
            }
        };

    public CategoryPersistenceImpl() {
        setModelClass(Category.class);
    }

    /**
     * Returns all the categories where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @return the matching categories
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Category> findByCompanyIdAndGroupId(long companyId, long groupId)
        throws SystemException {
        return findByCompanyIdAndGroupId(companyId, groupId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the categories where companyId = &#63; and groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param start the lower bound of the range of categories
     * @param end the upper bound of the range of categories (not inclusive)
     * @return the range of matching categories
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Category> findByCompanyIdAndGroupId(long companyId,
        long groupId, int start, int end) throws SystemException {
        return findByCompanyIdAndGroupId(companyId, groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the categories where companyId = &#63; and groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param start the lower bound of the range of categories
     * @param end the upper bound of the range of categories (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching categories
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Category> findByCompanyIdAndGroupId(long companyId,
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

        List<Category> list = (List<Category>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Category category : list) {
                if ((companyId != category.getCompanyId()) ||
                        (groupId != category.getGroupId())) {
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

            query.append(_SQL_SELECT_CATEGORY_WHERE);

            query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_COMPANYID_2);

            query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(CategoryModelImpl.ORDER_BY_JPQL);
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
                    list = (List<Category>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Category>(list);
                } else {
                    list = (List<Category>) QueryUtil.list(q, getDialect(),
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
     * Returns the first category in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching category
     * @throws net.zylk.liferay.portal.NoSuchCategoryException if a matching category could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Category findByCompanyIdAndGroupId_First(long companyId,
        long groupId, OrderByComparator orderByComparator)
        throws NoSuchCategoryException, SystemException {
        Category category = fetchByCompanyIdAndGroupId_First(companyId,
                groupId, orderByComparator);

        if (category != null) {
            return category;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCategoryException(msg.toString());
    }

    /**
     * Returns the first category in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching category, or <code>null</code> if a matching category could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Category fetchByCompanyIdAndGroupId_First(long companyId,
        long groupId, OrderByComparator orderByComparator)
        throws SystemException {
        List<Category> list = findByCompanyIdAndGroupId(companyId, groupId, 0,
                1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last category in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching category
     * @throws net.zylk.liferay.portal.NoSuchCategoryException if a matching category could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Category findByCompanyIdAndGroupId_Last(long companyId,
        long groupId, OrderByComparator orderByComparator)
        throws NoSuchCategoryException, SystemException {
        Category category = fetchByCompanyIdAndGroupId_Last(companyId, groupId,
                orderByComparator);

        if (category != null) {
            return category;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCategoryException(msg.toString());
    }

    /**
     * Returns the last category in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching category, or <code>null</code> if a matching category could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Category fetchByCompanyIdAndGroupId_Last(long companyId,
        long groupId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByCompanyIdAndGroupId(companyId, groupId);

        if (count == 0) {
            return null;
        }

        List<Category> list = findByCompanyIdAndGroupId(companyId, groupId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the categories before and after the current category in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param categoryId the primary key of the current category
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next category
     * @throws net.zylk.liferay.portal.NoSuchCategoryException if a category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Category[] findByCompanyIdAndGroupId_PrevAndNext(long categoryId,
        long companyId, long groupId, OrderByComparator orderByComparator)
        throws NoSuchCategoryException, SystemException {
        Category category = findByPrimaryKey(categoryId);

        Session session = null;

        try {
            session = openSession();

            Category[] array = new CategoryImpl[3];

            array[0] = getByCompanyIdAndGroupId_PrevAndNext(session, category,
                    companyId, groupId, orderByComparator, true);

            array[1] = category;

            array[2] = getByCompanyIdAndGroupId_PrevAndNext(session, category,
                    companyId, groupId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Category getByCompanyIdAndGroupId_PrevAndNext(Session session,
        Category category, long companyId, long groupId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CATEGORY_WHERE);

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
            query.append(CategoryModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(category);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Category> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the categories where companyId = &#63; and groupId = &#63; from the database.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCompanyIdAndGroupId(long companyId, long groupId)
        throws SystemException {
        for (Category category : findByCompanyIdAndGroupId(companyId, groupId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(category);
        }
    }

    /**
     * Returns the number of categories where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @return the number of matching categories
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

            query.append(_SQL_COUNT_CATEGORY_WHERE);

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
     * Caches the category in the entity cache if it is enabled.
     *
     * @param category the category
     */
    @Override
    public void cacheResult(Category category) {
        EntityCacheUtil.putResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryImpl.class, category.getPrimaryKey(), category);

        category.resetOriginalValues();
    }

    /**
     * Caches the categories in the entity cache if it is enabled.
     *
     * @param categories the categories
     */
    @Override
    public void cacheResult(List<Category> categories) {
        for (Category category : categories) {
            if (EntityCacheUtil.getResult(
                        CategoryModelImpl.ENTITY_CACHE_ENABLED,
                        CategoryImpl.class, category.getPrimaryKey()) == null) {
                cacheResult(category);
            } else {
                category.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all categories.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(CategoryImpl.class.getName());
        }

        EntityCacheUtil.clearCache(CategoryImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the category.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Category category) {
        EntityCacheUtil.removeResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryImpl.class, category.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Category> categories) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Category category : categories) {
            EntityCacheUtil.removeResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
                CategoryImpl.class, category.getPrimaryKey());
        }
    }

    /**
     * Creates a new category with the primary key. Does not add the category to the database.
     *
     * @param categoryId the primary key for the new category
     * @return the new category
     */
    @Override
    public Category create(long categoryId) {
        Category category = new CategoryImpl();

        category.setNew(true);
        category.setPrimaryKey(categoryId);

        return category;
    }

    /**
     * Removes the category with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param categoryId the primary key of the category
     * @return the category that was removed
     * @throws net.zylk.liferay.portal.NoSuchCategoryException if a category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Category remove(long categoryId)
        throws NoSuchCategoryException, SystemException {
        return remove((Serializable) categoryId);
    }

    /**
     * Removes the category with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the category
     * @return the category that was removed
     * @throws net.zylk.liferay.portal.NoSuchCategoryException if a category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Category remove(Serializable primaryKey)
        throws NoSuchCategoryException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Category category = (Category) session.get(CategoryImpl.class,
                    primaryKey);

            if (category == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(category);
        } catch (NoSuchCategoryException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Category removeImpl(Category category) throws SystemException {
        category = toUnwrappedModel(category);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(category)) {
                category = (Category) session.get(CategoryImpl.class,
                        category.getPrimaryKeyObj());
            }

            if (category != null) {
                session.delete(category);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (category != null) {
            clearCache(category);
        }

        return category;
    }

    @Override
    public Category updateImpl(net.zylk.liferay.portal.model.Category category)
        throws SystemException {
        category = toUnwrappedModel(category);

        boolean isNew = category.isNew();

        CategoryModelImpl categoryModelImpl = (CategoryModelImpl) category;

        Session session = null;

        try {
            session = openSession();

            if (category.isNew()) {
                session.save(category);

                category.setNew(false);
            } else {
                session.merge(category);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !CategoryModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((categoryModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        categoryModelImpl.getOriginalCompanyId(),
                        categoryModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID,
                    args);

                args = new Object[] {
                        categoryModelImpl.getCompanyId(),
                        categoryModelImpl.getGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID,
                    args);
            }
        }

        EntityCacheUtil.putResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryImpl.class, category.getPrimaryKey(), category);

        return category;
    }

    protected Category toUnwrappedModel(Category category) {
        if (category instanceof CategoryImpl) {
            return category;
        }

        CategoryImpl categoryImpl = new CategoryImpl();

        categoryImpl.setNew(category.isNew());
        categoryImpl.setPrimaryKey(category.getPrimaryKey());

        categoryImpl.setCategoryId(category.getCategoryId());
        categoryImpl.setCompanyId(category.getCompanyId());
        categoryImpl.setGroupId(category.getGroupId());
        categoryImpl.setName(category.getName());
        categoryImpl.setDescription(category.getDescription());

        return categoryImpl;
    }

    /**
     * Returns the category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the category
     * @return the category
     * @throws net.zylk.liferay.portal.NoSuchCategoryException if a category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Category findByPrimaryKey(Serializable primaryKey)
        throws NoSuchCategoryException, SystemException {
        Category category = fetchByPrimaryKey(primaryKey);

        if (category == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return category;
    }

    /**
     * Returns the category with the primary key or throws a {@link net.zylk.liferay.portal.NoSuchCategoryException} if it could not be found.
     *
     * @param categoryId the primary key of the category
     * @return the category
     * @throws net.zylk.liferay.portal.NoSuchCategoryException if a category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Category findByPrimaryKey(long categoryId)
        throws NoSuchCategoryException, SystemException {
        return findByPrimaryKey((Serializable) categoryId);
    }

    /**
     * Returns the category with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the category
     * @return the category, or <code>null</code> if a category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Category fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Category category = (Category) EntityCacheUtil.getResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
                CategoryImpl.class, primaryKey);

        if (category == _nullCategory) {
            return null;
        }

        if (category == null) {
            Session session = null;

            try {
                session = openSession();

                category = (Category) session.get(CategoryImpl.class, primaryKey);

                if (category != null) {
                    cacheResult(category);
                } else {
                    EntityCacheUtil.putResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
                        CategoryImpl.class, primaryKey, _nullCategory);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
                    CategoryImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return category;
    }

    /**
     * Returns the category with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param categoryId the primary key of the category
     * @return the category, or <code>null</code> if a category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Category fetchByPrimaryKey(long categoryId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) categoryId);
    }

    /**
     * Returns all the categories.
     *
     * @return the categories
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Category> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the categories.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of categories
     * @param end the upper bound of the range of categories (not inclusive)
     * @return the range of categories
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Category> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the categories.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of categories
     * @param end the upper bound of the range of categories (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of categories
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Category> findAll(int start, int end,
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

        List<Category> list = (List<Category>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_CATEGORY);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_CATEGORY;

                if (pagination) {
                    sql = sql.concat(CategoryModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Category>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Category>(list);
                } else {
                    list = (List<Category>) QueryUtil.list(q, getDialect(),
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
     * Removes all the categories from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Category category : findAll()) {
            remove(category);
        }
    }

    /**
     * Returns the number of categories.
     *
     * @return the number of categories
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

                Query q = session.createQuery(_SQL_COUNT_CATEGORY);

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
     * Initializes the category persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.net.zylk.liferay.portal.model.Category")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Category>> listenersList = new ArrayList<ModelListener<Category>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Category>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(CategoryImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
