package net.zylk.liferay.portal.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import net.zylk.liferay.portal.NoSuchMailingSubscriptorException;
import net.zylk.liferay.portal.model.MailingSubscriptor;
import net.zylk.liferay.portal.model.impl.MailingSubscriptorImpl;
import net.zylk.liferay.portal.model.impl.MailingSubscriptorModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the mailing subscriptor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author zylk.net
 * @see MailingSubscriptorPersistence
 * @see MailingSubscriptorUtil
 * @generated
 */
public class MailingSubscriptorPersistenceImpl extends BasePersistenceImpl<MailingSubscriptor>
    implements MailingSubscriptorPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link MailingSubscriptorUtil} to access the mailing subscriptor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = MailingSubscriptorImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MailingSubscriptorModelImpl.ENTITY_CACHE_ENABLED,
            MailingSubscriptorModelImpl.FINDER_CACHE_ENABLED,
            MailingSubscriptorImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MailingSubscriptorModelImpl.ENTITY_CACHE_ENABLED,
            MailingSubscriptorModelImpl.FINDER_CACHE_ENABLED,
            MailingSubscriptorImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MailingSubscriptorModelImpl.ENTITY_CACHE_ENABLED,
            MailingSubscriptorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_MAILINGSUBSCRIPTOR = "SELECT mailingSubscriptor FROM MailingSubscriptor mailingSubscriptor";
    private static final String _SQL_COUNT_MAILINGSUBSCRIPTOR = "SELECT COUNT(mailingSubscriptor) FROM MailingSubscriptor mailingSubscriptor";
    private static final String _ORDER_BY_ENTITY_ALIAS = "mailingSubscriptor.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MailingSubscriptor exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(MailingSubscriptorPersistenceImpl.class);
    private static MailingSubscriptor _nullMailingSubscriptor = new MailingSubscriptorImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<MailingSubscriptor> toCacheModel() {
                return _nullMailingSubscriptorCacheModel;
            }
        };

    private static CacheModel<MailingSubscriptor> _nullMailingSubscriptorCacheModel =
        new CacheModel<MailingSubscriptor>() {
            @Override
            public MailingSubscriptor toEntityModel() {
                return _nullMailingSubscriptor;
            }
        };

    public MailingSubscriptorPersistenceImpl() {
        setModelClass(MailingSubscriptor.class);
    }

    /**
     * Caches the mailing subscriptor in the entity cache if it is enabled.
     *
     * @param mailingSubscriptor the mailing subscriptor
     */
    @Override
    public void cacheResult(MailingSubscriptor mailingSubscriptor) {
        EntityCacheUtil.putResult(MailingSubscriptorModelImpl.ENTITY_CACHE_ENABLED,
            MailingSubscriptorImpl.class, mailingSubscriptor.getPrimaryKey(),
            mailingSubscriptor);

        mailingSubscriptor.resetOriginalValues();
    }

    /**
     * Caches the mailing subscriptors in the entity cache if it is enabled.
     *
     * @param mailingSubscriptors the mailing subscriptors
     */
    @Override
    public void cacheResult(List<MailingSubscriptor> mailingSubscriptors) {
        for (MailingSubscriptor mailingSubscriptor : mailingSubscriptors) {
            if (EntityCacheUtil.getResult(
                        MailingSubscriptorModelImpl.ENTITY_CACHE_ENABLED,
                        MailingSubscriptorImpl.class,
                        mailingSubscriptor.getPrimaryKey()) == null) {
                cacheResult(mailingSubscriptor);
            } else {
                mailingSubscriptor.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all mailing subscriptors.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(MailingSubscriptorImpl.class.getName());
        }

        EntityCacheUtil.clearCache(MailingSubscriptorImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the mailing subscriptor.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(MailingSubscriptor mailingSubscriptor) {
        EntityCacheUtil.removeResult(MailingSubscriptorModelImpl.ENTITY_CACHE_ENABLED,
            MailingSubscriptorImpl.class, mailingSubscriptor.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<MailingSubscriptor> mailingSubscriptors) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (MailingSubscriptor mailingSubscriptor : mailingSubscriptors) {
            EntityCacheUtil.removeResult(MailingSubscriptorModelImpl.ENTITY_CACHE_ENABLED,
                MailingSubscriptorImpl.class, mailingSubscriptor.getPrimaryKey());
        }
    }

    /**
     * Creates a new mailing subscriptor with the primary key. Does not add the mailing subscriptor to the database.
     *
     * @param mailingSubscriptorId the primary key for the new mailing subscriptor
     * @return the new mailing subscriptor
     */
    @Override
    public MailingSubscriptor create(long mailingSubscriptorId) {
        MailingSubscriptor mailingSubscriptor = new MailingSubscriptorImpl();

        mailingSubscriptor.setNew(true);
        mailingSubscriptor.setPrimaryKey(mailingSubscriptorId);

        return mailingSubscriptor;
    }

    /**
     * Removes the mailing subscriptor with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param mailingSubscriptorId the primary key of the mailing subscriptor
     * @return the mailing subscriptor that was removed
     * @throws net.zylk.liferay.portal.NoSuchMailingSubscriptorException if a mailing subscriptor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MailingSubscriptor remove(long mailingSubscriptorId)
        throws NoSuchMailingSubscriptorException, SystemException {
        return remove((Serializable) mailingSubscriptorId);
    }

    /**
     * Removes the mailing subscriptor with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the mailing subscriptor
     * @return the mailing subscriptor that was removed
     * @throws net.zylk.liferay.portal.NoSuchMailingSubscriptorException if a mailing subscriptor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MailingSubscriptor remove(Serializable primaryKey)
        throws NoSuchMailingSubscriptorException, SystemException {
        Session session = null;

        try {
            session = openSession();

            MailingSubscriptor mailingSubscriptor = (MailingSubscriptor) session.get(MailingSubscriptorImpl.class,
                    primaryKey);

            if (mailingSubscriptor == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchMailingSubscriptorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(mailingSubscriptor);
        } catch (NoSuchMailingSubscriptorException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected MailingSubscriptor removeImpl(
        MailingSubscriptor mailingSubscriptor) throws SystemException {
        mailingSubscriptor = toUnwrappedModel(mailingSubscriptor);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(mailingSubscriptor)) {
                mailingSubscriptor = (MailingSubscriptor) session.get(MailingSubscriptorImpl.class,
                        mailingSubscriptor.getPrimaryKeyObj());
            }

            if (mailingSubscriptor != null) {
                session.delete(mailingSubscriptor);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (mailingSubscriptor != null) {
            clearCache(mailingSubscriptor);
        }

        return mailingSubscriptor;
    }

    @Override
    public MailingSubscriptor updateImpl(
        net.zylk.liferay.portal.model.MailingSubscriptor mailingSubscriptor)
        throws SystemException {
        mailingSubscriptor = toUnwrappedModel(mailingSubscriptor);

        boolean isNew = mailingSubscriptor.isNew();

        Session session = null;

        try {
            session = openSession();

            if (mailingSubscriptor.isNew()) {
                session.save(mailingSubscriptor);

                mailingSubscriptor.setNew(false);
            } else {
                session.merge(mailingSubscriptor);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(MailingSubscriptorModelImpl.ENTITY_CACHE_ENABLED,
            MailingSubscriptorImpl.class, mailingSubscriptor.getPrimaryKey(),
            mailingSubscriptor);

        return mailingSubscriptor;
    }

    protected MailingSubscriptor toUnwrappedModel(
        MailingSubscriptor mailingSubscriptor) {
        if (mailingSubscriptor instanceof MailingSubscriptorImpl) {
            return mailingSubscriptor;
        }

        MailingSubscriptorImpl mailingSubscriptorImpl = new MailingSubscriptorImpl();

        mailingSubscriptorImpl.setNew(mailingSubscriptor.isNew());
        mailingSubscriptorImpl.setPrimaryKey(mailingSubscriptor.getPrimaryKey());

        mailingSubscriptorImpl.setMailingSubscriptorId(mailingSubscriptor.getMailingSubscriptorId());
        mailingSubscriptorImpl.setMailingId(mailingSubscriptor.getMailingId());
        mailingSubscriptorImpl.setEmail(mailingSubscriptor.getEmail());
        mailingSubscriptorImpl.setName(mailingSubscriptor.getName());
        mailingSubscriptorImpl.setSurname(mailingSubscriptor.getSurname());
        mailingSubscriptorImpl.setLanguageId(mailingSubscriptor.getLanguageId());
        mailingSubscriptorImpl.setEmailSubject(mailingSubscriptor.getEmailSubject());
        mailingSubscriptorImpl.setEmailBody(mailingSubscriptor.getEmailBody());
        mailingSubscriptorImpl.setTokens(mailingSubscriptor.getTokens());

        return mailingSubscriptorImpl;
    }

    /**
     * Returns the mailing subscriptor with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the mailing subscriptor
     * @return the mailing subscriptor
     * @throws net.zylk.liferay.portal.NoSuchMailingSubscriptorException if a mailing subscriptor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MailingSubscriptor findByPrimaryKey(Serializable primaryKey)
        throws NoSuchMailingSubscriptorException, SystemException {
        MailingSubscriptor mailingSubscriptor = fetchByPrimaryKey(primaryKey);

        if (mailingSubscriptor == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchMailingSubscriptorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return mailingSubscriptor;
    }

    /**
     * Returns the mailing subscriptor with the primary key or throws a {@link net.zylk.liferay.portal.NoSuchMailingSubscriptorException} if it could not be found.
     *
     * @param mailingSubscriptorId the primary key of the mailing subscriptor
     * @return the mailing subscriptor
     * @throws net.zylk.liferay.portal.NoSuchMailingSubscriptorException if a mailing subscriptor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MailingSubscriptor findByPrimaryKey(long mailingSubscriptorId)
        throws NoSuchMailingSubscriptorException, SystemException {
        return findByPrimaryKey((Serializable) mailingSubscriptorId);
    }

    /**
     * Returns the mailing subscriptor with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the mailing subscriptor
     * @return the mailing subscriptor, or <code>null</code> if a mailing subscriptor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MailingSubscriptor fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        MailingSubscriptor mailingSubscriptor = (MailingSubscriptor) EntityCacheUtil.getResult(MailingSubscriptorModelImpl.ENTITY_CACHE_ENABLED,
                MailingSubscriptorImpl.class, primaryKey);

        if (mailingSubscriptor == _nullMailingSubscriptor) {
            return null;
        }

        if (mailingSubscriptor == null) {
            Session session = null;

            try {
                session = openSession();

                mailingSubscriptor = (MailingSubscriptor) session.get(MailingSubscriptorImpl.class,
                        primaryKey);

                if (mailingSubscriptor != null) {
                    cacheResult(mailingSubscriptor);
                } else {
                    EntityCacheUtil.putResult(MailingSubscriptorModelImpl.ENTITY_CACHE_ENABLED,
                        MailingSubscriptorImpl.class, primaryKey,
                        _nullMailingSubscriptor);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(MailingSubscriptorModelImpl.ENTITY_CACHE_ENABLED,
                    MailingSubscriptorImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return mailingSubscriptor;
    }

    /**
     * Returns the mailing subscriptor with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param mailingSubscriptorId the primary key of the mailing subscriptor
     * @return the mailing subscriptor, or <code>null</code> if a mailing subscriptor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MailingSubscriptor fetchByPrimaryKey(long mailingSubscriptorId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) mailingSubscriptorId);
    }

    /**
     * Returns all the mailing subscriptors.
     *
     * @return the mailing subscriptors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<MailingSubscriptor> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the mailing subscriptors.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.MailingSubscriptorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of mailing subscriptors
     * @param end the upper bound of the range of mailing subscriptors (not inclusive)
     * @return the range of mailing subscriptors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<MailingSubscriptor> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the mailing subscriptors.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.MailingSubscriptorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of mailing subscriptors
     * @param end the upper bound of the range of mailing subscriptors (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of mailing subscriptors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<MailingSubscriptor> findAll(int start, int end,
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

        List<MailingSubscriptor> list = (List<MailingSubscriptor>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_MAILINGSUBSCRIPTOR);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_MAILINGSUBSCRIPTOR;

                if (pagination) {
                    sql = sql.concat(MailingSubscriptorModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<MailingSubscriptor>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<MailingSubscriptor>(list);
                } else {
                    list = (List<MailingSubscriptor>) QueryUtil.list(q,
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
     * Removes all the mailing subscriptors from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (MailingSubscriptor mailingSubscriptor : findAll()) {
            remove(mailingSubscriptor);
        }
    }

    /**
     * Returns the number of mailing subscriptors.
     *
     * @return the number of mailing subscriptors
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

                Query q = session.createQuery(_SQL_COUNT_MAILINGSUBSCRIPTOR);

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
     * Initializes the mailing subscriptor persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.net.zylk.liferay.portal.model.MailingSubscriptor")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<MailingSubscriptor>> listenersList = new ArrayList<ModelListener<MailingSubscriptor>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<MailingSubscriptor>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(MailingSubscriptorImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
