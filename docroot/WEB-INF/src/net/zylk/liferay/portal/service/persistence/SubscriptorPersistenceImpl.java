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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import net.zylk.liferay.portal.NoSuchSubscriptorException;
import net.zylk.liferay.portal.model.Subscriptor;
import net.zylk.liferay.portal.model.impl.SubscriptorImpl;
import net.zylk.liferay.portal.model.impl.SubscriptorModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the subscriptor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author zylk.net
 * @see SubscriptorPersistence
 * @see SubscriptorUtil
 * @generated
 */
public class SubscriptorPersistenceImpl extends BasePersistenceImpl<Subscriptor>
    implements SubscriptorPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link SubscriptorUtil} to access the subscriptor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = SubscriptorImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SubscriptorModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptorModelImpl.FINDER_CACHE_ENABLED, SubscriptorImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SubscriptorModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptorModelImpl.FINDER_CACHE_ENABLED, SubscriptorImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SubscriptorModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SubscriptorModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptorModelImpl.FINDER_CACHE_ENABLED, SubscriptorImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SubscriptorModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptorModelImpl.FINDER_CACHE_ENABLED, SubscriptorImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            SubscriptorModelImpl.UUID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SubscriptorModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "subscriptor.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "subscriptor.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(subscriptor.uuid IS NULL OR subscriptor.uuid = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(SubscriptorModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptorModelImpl.FINDER_CACHE_ENABLED, SubscriptorImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() },
            SubscriptorModelImpl.UUID_COLUMN_BITMASK |
            SubscriptorModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(SubscriptorModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "subscriptor.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "subscriptor.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(subscriptor.uuid IS NULL OR subscriptor.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "subscriptor.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(SubscriptorModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptorModelImpl.FINDER_CACHE_ENABLED, SubscriptorImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
        new FinderPath(SubscriptorModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptorModelImpl.FINDER_CACHE_ENABLED, SubscriptorImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() },
            SubscriptorModelImpl.UUID_COLUMN_BITMASK |
            SubscriptorModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(SubscriptorModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "subscriptor.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "subscriptor.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(subscriptor.uuid IS NULL OR subscriptor.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "subscriptor.companyId = ?";
    public static final FinderPath FINDER_PATH_FETCH_BY_EMAILANDCOMPANYIDANDGROUPID =
        new FinderPath(SubscriptorModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptorModelImpl.FINDER_CACHE_ENABLED, SubscriptorImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByEmailAndCompanyIdAndGroupId",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                String.class.getName()
            },
            SubscriptorModelImpl.COMPANYID_COLUMN_BITMASK |
            SubscriptorModelImpl.GROUPID_COLUMN_BITMASK |
            SubscriptorModelImpl.EMAIL_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_EMAILANDCOMPANYIDANDGROUPID =
        new FinderPath(SubscriptorModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByEmailAndCompanyIdAndGroupId",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                String.class.getName()
            });
    private static final String _FINDER_COLUMN_EMAILANDCOMPANYIDANDGROUPID_COMPANYID_2 =
        "subscriptor.companyId = ? AND ";
    private static final String _FINDER_COLUMN_EMAILANDCOMPANYIDANDGROUPID_GROUPID_2 =
        "subscriptor.groupId = ? AND ";
    private static final String _FINDER_COLUMN_EMAILANDCOMPANYIDANDGROUPID_EMAIL_1 =
        "subscriptor.email IS NULL";
    private static final String _FINDER_COLUMN_EMAILANDCOMPANYIDANDGROUPID_EMAIL_2 =
        "subscriptor.email = ?";
    private static final String _FINDER_COLUMN_EMAILANDCOMPANYIDANDGROUPID_EMAIL_3 =
        "(subscriptor.email IS NULL OR subscriptor.email = '')";
    private static final String _SQL_SELECT_SUBSCRIPTOR = "SELECT subscriptor FROM Subscriptor subscriptor";
    private static final String _SQL_SELECT_SUBSCRIPTOR_WHERE = "SELECT subscriptor FROM Subscriptor subscriptor WHERE ";
    private static final String _SQL_COUNT_SUBSCRIPTOR = "SELECT COUNT(subscriptor) FROM Subscriptor subscriptor";
    private static final String _SQL_COUNT_SUBSCRIPTOR_WHERE = "SELECT COUNT(subscriptor) FROM Subscriptor subscriptor WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "subscriptor.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Subscriptor exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Subscriptor exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(SubscriptorPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid"
            });
    private static Subscriptor _nullSubscriptor = new SubscriptorImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Subscriptor> toCacheModel() {
                return _nullSubscriptorCacheModel;
            }
        };

    private static CacheModel<Subscriptor> _nullSubscriptorCacheModel = new CacheModel<Subscriptor>() {
            @Override
            public Subscriptor toEntityModel() {
                return _nullSubscriptor;
            }
        };

    public SubscriptorPersistenceImpl() {
        setModelClass(Subscriptor.class);
    }

    /**
     * Returns all the subscriptors where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching subscriptors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Subscriptor> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Subscriptor> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
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
    @Override
    public List<Subscriptor> findByUuid(String uuid, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid, start, end, orderByComparator };
        }

        List<Subscriptor> list = (List<Subscriptor>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Subscriptor subscriptor : list) {
                if (!Validator.equals(uuid, subscriptor.getUuid())) {
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

            query.append(_SQL_SELECT_SUBSCRIPTOR_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(SubscriptorModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                if (!pagination) {
                    list = (List<Subscriptor>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Subscriptor>(list);
                } else {
                    list = (List<Subscriptor>) QueryUtil.list(q, getDialect(),
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
     * Returns the first subscriptor in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching subscriptor
     * @throws net.zylk.liferay.portal.NoSuchSubscriptorException if a matching subscriptor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Subscriptor findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchSubscriptorException, SystemException {
        Subscriptor subscriptor = fetchByUuid_First(uuid, orderByComparator);

        if (subscriptor != null) {
            return subscriptor;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSubscriptorException(msg.toString());
    }

    /**
     * Returns the first subscriptor in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching subscriptor, or <code>null</code> if a matching subscriptor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Subscriptor fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<Subscriptor> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Subscriptor findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchSubscriptorException, SystemException {
        Subscriptor subscriptor = fetchByUuid_Last(uuid, orderByComparator);

        if (subscriptor != null) {
            return subscriptor;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSubscriptorException(msg.toString());
    }

    /**
     * Returns the last subscriptor in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching subscriptor, or <code>null</code> if a matching subscriptor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Subscriptor fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<Subscriptor> list = findByUuid(uuid, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Subscriptor[] findByUuid_PrevAndNext(long subscriptorId,
        String uuid, OrderByComparator orderByComparator)
        throws NoSuchSubscriptorException, SystemException {
        Subscriptor subscriptor = findByPrimaryKey(subscriptorId);

        Session session = null;

        try {
            session = openSession();

            Subscriptor[] array = new SubscriptorImpl[3];

            array[0] = getByUuid_PrevAndNext(session, subscriptor, uuid,
                    orderByComparator, true);

            array[1] = subscriptor;

            array[2] = getByUuid_PrevAndNext(session, subscriptor, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Subscriptor getByUuid_PrevAndNext(Session session,
        Subscriptor subscriptor, String uuid,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SUBSCRIPTOR_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_UUID_2);
        }

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
            query.append(SubscriptorModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(subscriptor);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Subscriptor> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the subscriptors where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (Subscriptor subscriptor : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(subscriptor);
        }
    }

    /**
     * Returns the number of subscriptors where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching subscriptors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid(String uuid) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

        Object[] finderArgs = new Object[] { uuid };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SUBSCRIPTOR_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

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
     * Returns the subscriptor where uuid = &#63; and groupId = &#63; or throws a {@link net.zylk.liferay.portal.NoSuchSubscriptorException} if it could not be found.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching subscriptor
     * @throws net.zylk.liferay.portal.NoSuchSubscriptorException if a matching subscriptor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Subscriptor findByUUID_G(String uuid, long groupId)
        throws NoSuchSubscriptorException, SystemException {
        Subscriptor subscriptor = fetchByUUID_G(uuid, groupId);

        if (subscriptor == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("uuid=");
            msg.append(uuid);

            msg.append(", groupId=");
            msg.append(groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchSubscriptorException(msg.toString());
        }

        return subscriptor;
    }

    /**
     * Returns the subscriptor where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching subscriptor, or <code>null</code> if a matching subscriptor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Subscriptor fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
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
    @Override
    public Subscriptor fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result instanceof Subscriptor) {
            Subscriptor subscriptor = (Subscriptor) result;

            if (!Validator.equals(uuid, subscriptor.getUuid()) ||
                    (groupId != subscriptor.getGroupId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_SUBSCRIPTOR_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_G_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                List<Subscriptor> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    Subscriptor subscriptor = list.get(0);

                    result = subscriptor;

                    cacheResult(subscriptor);

                    if ((subscriptor.getUuid() == null) ||
                            !subscriptor.getUuid().equals(uuid) ||
                            (subscriptor.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, subscriptor);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Subscriptor) result;
        }
    }

    /**
     * Removes the subscriptor where uuid = &#63; and groupId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the subscriptor that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Subscriptor removeByUUID_G(String uuid, long groupId)
        throws NoSuchSubscriptorException, SystemException {
        Subscriptor subscriptor = findByUUID_G(uuid, groupId);

        return remove(subscriptor);
    }

    /**
     * Returns the number of subscriptors where uuid = &#63; and groupId = &#63;.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the number of matching subscriptors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUUID_G(String uuid, long groupId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

        Object[] finderArgs = new Object[] { uuid, groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_SUBSCRIPTOR_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_G_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

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
     * Returns all the subscriptors where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the matching subscriptors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Subscriptor> findByUuid_C(String uuid, long companyId)
        throws SystemException {
        return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Subscriptor> findByUuid_C(String uuid, long companyId,
        int start, int end) throws SystemException {
        return findByUuid_C(uuid, companyId, start, end, null);
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
    @Override
    public List<Subscriptor> findByUuid_C(String uuid, long companyId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
            finderArgs = new Object[] { uuid, companyId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
            finderArgs = new Object[] {
                    uuid, companyId,
                    
                    start, end, orderByComparator
                };
        }

        List<Subscriptor> list = (List<Subscriptor>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Subscriptor subscriptor : list) {
                if (!Validator.equals(uuid, subscriptor.getUuid()) ||
                        (companyId != subscriptor.getCompanyId())) {
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

            query.append(_SQL_SELECT_SUBSCRIPTOR_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_C_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(SubscriptorModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<Subscriptor>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Subscriptor>(list);
                } else {
                    list = (List<Subscriptor>) QueryUtil.list(q, getDialect(),
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
     * Returns the first subscriptor in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching subscriptor
     * @throws net.zylk.liferay.portal.NoSuchSubscriptorException if a matching subscriptor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Subscriptor findByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchSubscriptorException, SystemException {
        Subscriptor subscriptor = fetchByUuid_C_First(uuid, companyId,
                orderByComparator);

        if (subscriptor != null) {
            return subscriptor;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSubscriptorException(msg.toString());
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
    @Override
    public Subscriptor fetchByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Subscriptor> list = findByUuid_C(uuid, companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Subscriptor findByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchSubscriptorException, SystemException {
        Subscriptor subscriptor = fetchByUuid_C_Last(uuid, companyId,
                orderByComparator);

        if (subscriptor != null) {
            return subscriptor;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSubscriptorException(msg.toString());
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
    @Override
    public Subscriptor fetchByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid_C(uuid, companyId);

        if (count == 0) {
            return null;
        }

        List<Subscriptor> list = findByUuid_C(uuid, companyId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Subscriptor[] findByUuid_C_PrevAndNext(long subscriptorId,
        String uuid, long companyId, OrderByComparator orderByComparator)
        throws NoSuchSubscriptorException, SystemException {
        Subscriptor subscriptor = findByPrimaryKey(subscriptorId);

        Session session = null;

        try {
            session = openSession();

            Subscriptor[] array = new SubscriptorImpl[3];

            array[0] = getByUuid_C_PrevAndNext(session, subscriptor, uuid,
                    companyId, orderByComparator, true);

            array[1] = subscriptor;

            array[2] = getByUuid_C_PrevAndNext(session, subscriptor, uuid,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Subscriptor getByUuid_C_PrevAndNext(Session session,
        Subscriptor subscriptor, String uuid, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SUBSCRIPTOR_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_C_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_C_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_C_UUID_2);
        }

        query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
            query.append(SubscriptorModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(subscriptor);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Subscriptor> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the subscriptors where uuid = &#63; and companyId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid_C(String uuid, long companyId)
        throws SystemException {
        for (Subscriptor subscriptor : findByUuid_C(uuid, companyId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(subscriptor);
        }
    }

    /**
     * Returns the number of subscriptors where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the number of matching subscriptors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid_C(String uuid, long companyId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

        Object[] finderArgs = new Object[] { uuid, companyId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_SUBSCRIPTOR_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_C_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(companyId);

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
     * Returns the subscriptor where companyId = &#63; and groupId = &#63; and email = &#63; or throws a {@link net.zylk.liferay.portal.NoSuchSubscriptorException} if it could not be found.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param email the email
     * @return the matching subscriptor
     * @throws net.zylk.liferay.portal.NoSuchSubscriptorException if a matching subscriptor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Subscriptor findByEmailAndCompanyIdAndGroupId(long companyId,
        long groupId, String email)
        throws NoSuchSubscriptorException, SystemException {
        Subscriptor subscriptor = fetchByEmailAndCompanyIdAndGroupId(companyId,
                groupId, email);

        if (subscriptor == null) {
            StringBundler msg = new StringBundler(8);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("companyId=");
            msg.append(companyId);

            msg.append(", groupId=");
            msg.append(groupId);

            msg.append(", email=");
            msg.append(email);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchSubscriptorException(msg.toString());
        }

        return subscriptor;
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
    @Override
    public Subscriptor fetchByEmailAndCompanyIdAndGroupId(long companyId,
        long groupId, String email) throws SystemException {
        return fetchByEmailAndCompanyIdAndGroupId(companyId, groupId, email,
            true);
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
    @Override
    public Subscriptor fetchByEmailAndCompanyIdAndGroupId(long companyId,
        long groupId, String email, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { companyId, groupId, email };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMAILANDCOMPANYIDANDGROUPID,
                    finderArgs, this);
        }

        if (result instanceof Subscriptor) {
            Subscriptor subscriptor = (Subscriptor) result;

            if ((companyId != subscriptor.getCompanyId()) ||
                    (groupId != subscriptor.getGroupId()) ||
                    !Validator.equals(email, subscriptor.getEmail())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(5);

            query.append(_SQL_SELECT_SUBSCRIPTOR_WHERE);

            query.append(_FINDER_COLUMN_EMAILANDCOMPANYIDANDGROUPID_COMPANYID_2);

            query.append(_FINDER_COLUMN_EMAILANDCOMPANYIDANDGROUPID_GROUPID_2);

            boolean bindEmail = false;

            if (email == null) {
                query.append(_FINDER_COLUMN_EMAILANDCOMPANYIDANDGROUPID_EMAIL_1);
            } else if (email.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_EMAILANDCOMPANYIDANDGROUPID_EMAIL_3);
            } else {
                bindEmail = true;

                query.append(_FINDER_COLUMN_EMAILANDCOMPANYIDANDGROUPID_EMAIL_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(groupId);

                if (bindEmail) {
                    qPos.add(email);
                }

                List<Subscriptor> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILANDCOMPANYIDANDGROUPID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "SubscriptorPersistenceImpl.fetchByEmailAndCompanyIdAndGroupId(long, long, String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    Subscriptor subscriptor = list.get(0);

                    result = subscriptor;

                    cacheResult(subscriptor);

                    if ((subscriptor.getCompanyId() != companyId) ||
                            (subscriptor.getGroupId() != groupId) ||
                            (subscriptor.getEmail() == null) ||
                            !subscriptor.getEmail().equals(email)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILANDCOMPANYIDANDGROUPID,
                            finderArgs, subscriptor);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILANDCOMPANYIDANDGROUPID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Subscriptor) result;
        }
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
    @Override
    public Subscriptor removeByEmailAndCompanyIdAndGroupId(long companyId,
        long groupId, String email)
        throws NoSuchSubscriptorException, SystemException {
        Subscriptor subscriptor = findByEmailAndCompanyIdAndGroupId(companyId,
                groupId, email);

        return remove(subscriptor);
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
    @Override
    public int countByEmailAndCompanyIdAndGroupId(long companyId, long groupId,
        String email) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAILANDCOMPANYIDANDGROUPID;

        Object[] finderArgs = new Object[] { companyId, groupId, email };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_SUBSCRIPTOR_WHERE);

            query.append(_FINDER_COLUMN_EMAILANDCOMPANYIDANDGROUPID_COMPANYID_2);

            query.append(_FINDER_COLUMN_EMAILANDCOMPANYIDANDGROUPID_GROUPID_2);

            boolean bindEmail = false;

            if (email == null) {
                query.append(_FINDER_COLUMN_EMAILANDCOMPANYIDANDGROUPID_EMAIL_1);
            } else if (email.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_EMAILANDCOMPANYIDANDGROUPID_EMAIL_3);
            } else {
                bindEmail = true;

                query.append(_FINDER_COLUMN_EMAILANDCOMPANYIDANDGROUPID_EMAIL_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(groupId);

                if (bindEmail) {
                    qPos.add(email);
                }

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
     * Caches the subscriptor in the entity cache if it is enabled.
     *
     * @param subscriptor the subscriptor
     */
    @Override
    public void cacheResult(Subscriptor subscriptor) {
        EntityCacheUtil.putResult(SubscriptorModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptorImpl.class, subscriptor.getPrimaryKey(), subscriptor);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { subscriptor.getUuid(), subscriptor.getGroupId() },
            subscriptor);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILANDCOMPANYIDANDGROUPID,
            new Object[] {
                subscriptor.getCompanyId(), subscriptor.getGroupId(),
                subscriptor.getEmail()
            }, subscriptor);

        subscriptor.resetOriginalValues();
    }

    /**
     * Caches the subscriptors in the entity cache if it is enabled.
     *
     * @param subscriptors the subscriptors
     */
    @Override
    public void cacheResult(List<Subscriptor> subscriptors) {
        for (Subscriptor subscriptor : subscriptors) {
            if (EntityCacheUtil.getResult(
                        SubscriptorModelImpl.ENTITY_CACHE_ENABLED,
                        SubscriptorImpl.class, subscriptor.getPrimaryKey()) == null) {
                cacheResult(subscriptor);
            } else {
                subscriptor.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all subscriptors.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(SubscriptorImpl.class.getName());
        }

        EntityCacheUtil.clearCache(SubscriptorImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the subscriptor.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Subscriptor subscriptor) {
        EntityCacheUtil.removeResult(SubscriptorModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptorImpl.class, subscriptor.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(subscriptor);
    }

    @Override
    public void clearCache(List<Subscriptor> subscriptors) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Subscriptor subscriptor : subscriptors) {
            EntityCacheUtil.removeResult(SubscriptorModelImpl.ENTITY_CACHE_ENABLED,
                SubscriptorImpl.class, subscriptor.getPrimaryKey());

            clearUniqueFindersCache(subscriptor);
        }
    }

    protected void cacheUniqueFindersCache(Subscriptor subscriptor) {
        if (subscriptor.isNew()) {
            Object[] args = new Object[] {
                    subscriptor.getUuid(), subscriptor.getGroupId()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                subscriptor);

            args = new Object[] {
                    subscriptor.getCompanyId(), subscriptor.getGroupId(),
                    subscriptor.getEmail()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILANDCOMPANYIDANDGROUPID,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILANDCOMPANYIDANDGROUPID,
                args, subscriptor);
        } else {
            SubscriptorModelImpl subscriptorModelImpl = (SubscriptorModelImpl) subscriptor;

            if ((subscriptorModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        subscriptor.getUuid(), subscriptor.getGroupId()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                    subscriptor);
            }

            if ((subscriptorModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_EMAILANDCOMPANYIDANDGROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        subscriptor.getCompanyId(), subscriptor.getGroupId(),
                        subscriptor.getEmail()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILANDCOMPANYIDANDGROUPID,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILANDCOMPANYIDANDGROUPID,
                    args, subscriptor);
            }
        }
    }

    protected void clearUniqueFindersCache(Subscriptor subscriptor) {
        SubscriptorModelImpl subscriptorModelImpl = (SubscriptorModelImpl) subscriptor;

        Object[] args = new Object[] {
                subscriptor.getUuid(), subscriptor.getGroupId()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

        if ((subscriptorModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
            args = new Object[] {
                    subscriptorModelImpl.getOriginalUuid(),
                    subscriptorModelImpl.getOriginalGroupId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
        }

        args = new Object[] {
                subscriptor.getCompanyId(), subscriptor.getGroupId(),
                subscriptor.getEmail()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILANDCOMPANYIDANDGROUPID,
            args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILANDCOMPANYIDANDGROUPID,
            args);

        if ((subscriptorModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_EMAILANDCOMPANYIDANDGROUPID.getColumnBitmask()) != 0) {
            args = new Object[] {
                    subscriptorModelImpl.getOriginalCompanyId(),
                    subscriptorModelImpl.getOriginalGroupId(),
                    subscriptorModelImpl.getOriginalEmail()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILANDCOMPANYIDANDGROUPID,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILANDCOMPANYIDANDGROUPID,
                args);
        }
    }

    /**
     * Creates a new subscriptor with the primary key. Does not add the subscriptor to the database.
     *
     * @param subscriptorId the primary key for the new subscriptor
     * @return the new subscriptor
     */
    @Override
    public Subscriptor create(long subscriptorId) {
        Subscriptor subscriptor = new SubscriptorImpl();

        subscriptor.setNew(true);
        subscriptor.setPrimaryKey(subscriptorId);

        String uuid = PortalUUIDUtil.generate();

        subscriptor.setUuid(uuid);

        return subscriptor;
    }

    /**
     * Removes the subscriptor with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param subscriptorId the primary key of the subscriptor
     * @return the subscriptor that was removed
     * @throws net.zylk.liferay.portal.NoSuchSubscriptorException if a subscriptor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Subscriptor remove(long subscriptorId)
        throws NoSuchSubscriptorException, SystemException {
        return remove((Serializable) subscriptorId);
    }

    /**
     * Removes the subscriptor with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the subscriptor
     * @return the subscriptor that was removed
     * @throws net.zylk.liferay.portal.NoSuchSubscriptorException if a subscriptor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Subscriptor remove(Serializable primaryKey)
        throws NoSuchSubscriptorException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Subscriptor subscriptor = (Subscriptor) session.get(SubscriptorImpl.class,
                    primaryKey);

            if (subscriptor == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchSubscriptorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(subscriptor);
        } catch (NoSuchSubscriptorException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Subscriptor removeImpl(Subscriptor subscriptor)
        throws SystemException {
        subscriptor = toUnwrappedModel(subscriptor);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(subscriptor)) {
                subscriptor = (Subscriptor) session.get(SubscriptorImpl.class,
                        subscriptor.getPrimaryKeyObj());
            }

            if (subscriptor != null) {
                session.delete(subscriptor);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (subscriptor != null) {
            clearCache(subscriptor);
        }

        return subscriptor;
    }

    @Override
    public Subscriptor updateImpl(
        net.zylk.liferay.portal.model.Subscriptor subscriptor)
        throws SystemException {
        subscriptor = toUnwrappedModel(subscriptor);

        boolean isNew = subscriptor.isNew();

        SubscriptorModelImpl subscriptorModelImpl = (SubscriptorModelImpl) subscriptor;

        if (Validator.isNull(subscriptor.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            subscriptor.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (subscriptor.isNew()) {
                session.save(subscriptor);

                subscriptor.setNew(false);
            } else {
                session.merge(subscriptor);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !SubscriptorModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((subscriptorModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        subscriptorModelImpl.getOriginalUuid()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { subscriptorModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((subscriptorModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        subscriptorModelImpl.getOriginalUuid(),
                        subscriptorModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);

                args = new Object[] {
                        subscriptorModelImpl.getUuid(),
                        subscriptorModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);
            }
        }

        EntityCacheUtil.putResult(SubscriptorModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptorImpl.class, subscriptor.getPrimaryKey(), subscriptor);

        clearUniqueFindersCache(subscriptor);
        cacheUniqueFindersCache(subscriptor);

        return subscriptor;
    }

    protected Subscriptor toUnwrappedModel(Subscriptor subscriptor) {
        if (subscriptor instanceof SubscriptorImpl) {
            return subscriptor;
        }

        SubscriptorImpl subscriptorImpl = new SubscriptorImpl();

        subscriptorImpl.setNew(subscriptor.isNew());
        subscriptorImpl.setPrimaryKey(subscriptor.getPrimaryKey());

        subscriptorImpl.setUuid(subscriptor.getUuid());
        subscriptorImpl.setSubscriptorId(subscriptor.getSubscriptorId());
        subscriptorImpl.setCompanyId(subscriptor.getCompanyId());
        subscriptorImpl.setGroupId(subscriptor.getGroupId());
        subscriptorImpl.setName(subscriptor.getName());
        subscriptorImpl.setSurname(subscriptor.getSurname());
        subscriptorImpl.setEmail(subscriptor.getEmail());
        subscriptorImpl.setLanguageId(subscriptor.getLanguageId());
        subscriptorImpl.setSelfSubscribe(subscriptor.isSelfSubscribe());

        return subscriptorImpl;
    }

    /**
     * Returns the subscriptor with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the subscriptor
     * @return the subscriptor
     * @throws net.zylk.liferay.portal.NoSuchSubscriptorException if a subscriptor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Subscriptor findByPrimaryKey(Serializable primaryKey)
        throws NoSuchSubscriptorException, SystemException {
        Subscriptor subscriptor = fetchByPrimaryKey(primaryKey);

        if (subscriptor == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchSubscriptorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return subscriptor;
    }

    /**
     * Returns the subscriptor with the primary key or throws a {@link net.zylk.liferay.portal.NoSuchSubscriptorException} if it could not be found.
     *
     * @param subscriptorId the primary key of the subscriptor
     * @return the subscriptor
     * @throws net.zylk.liferay.portal.NoSuchSubscriptorException if a subscriptor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Subscriptor findByPrimaryKey(long subscriptorId)
        throws NoSuchSubscriptorException, SystemException {
        return findByPrimaryKey((Serializable) subscriptorId);
    }

    /**
     * Returns the subscriptor with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the subscriptor
     * @return the subscriptor, or <code>null</code> if a subscriptor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Subscriptor fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Subscriptor subscriptor = (Subscriptor) EntityCacheUtil.getResult(SubscriptorModelImpl.ENTITY_CACHE_ENABLED,
                SubscriptorImpl.class, primaryKey);

        if (subscriptor == _nullSubscriptor) {
            return null;
        }

        if (subscriptor == null) {
            Session session = null;

            try {
                session = openSession();

                subscriptor = (Subscriptor) session.get(SubscriptorImpl.class,
                        primaryKey);

                if (subscriptor != null) {
                    cacheResult(subscriptor);
                } else {
                    EntityCacheUtil.putResult(SubscriptorModelImpl.ENTITY_CACHE_ENABLED,
                        SubscriptorImpl.class, primaryKey, _nullSubscriptor);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(SubscriptorModelImpl.ENTITY_CACHE_ENABLED,
                    SubscriptorImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return subscriptor;
    }

    /**
     * Returns the subscriptor with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param subscriptorId the primary key of the subscriptor
     * @return the subscriptor, or <code>null</code> if a subscriptor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Subscriptor fetchByPrimaryKey(long subscriptorId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) subscriptorId);
    }

    /**
     * Returns all the subscriptors.
     *
     * @return the subscriptors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Subscriptor> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Subscriptor> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<Subscriptor> findAll(int start, int end,
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

        List<Subscriptor> list = (List<Subscriptor>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_SUBSCRIPTOR);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_SUBSCRIPTOR;

                if (pagination) {
                    sql = sql.concat(SubscriptorModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Subscriptor>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Subscriptor>(list);
                } else {
                    list = (List<Subscriptor>) QueryUtil.list(q, getDialect(),
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
     * Removes all the subscriptors from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Subscriptor subscriptor : findAll()) {
            remove(subscriptor);
        }
    }

    /**
     * Returns the number of subscriptors.
     *
     * @return the number of subscriptors
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

                Query q = session.createQuery(_SQL_COUNT_SUBSCRIPTOR);

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

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the subscriptor persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.net.zylk.liferay.portal.model.Subscriptor")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Subscriptor>> listenersList = new ArrayList<ModelListener<Subscriptor>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Subscriptor>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(SubscriptorImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
