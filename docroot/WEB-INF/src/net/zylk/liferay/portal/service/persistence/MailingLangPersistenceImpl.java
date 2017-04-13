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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import net.zylk.liferay.portal.NoSuchMailingLangException;
import net.zylk.liferay.portal.model.MailingLang;
import net.zylk.liferay.portal.model.impl.MailingLangImpl;
import net.zylk.liferay.portal.model.impl.MailingLangModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the mailing lang service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author zylk.net
 * @see MailingLangPersistence
 * @see MailingLangUtil
 * @generated
 */
public class MailingLangPersistenceImpl extends BasePersistenceImpl<MailingLang>
    implements MailingLangPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link MailingLangUtil} to access the mailing lang persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = MailingLangImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MailingLangModelImpl.ENTITY_CACHE_ENABLED,
            MailingLangModelImpl.FINDER_CACHE_ENABLED, MailingLangImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MailingLangModelImpl.ENTITY_CACHE_ENABLED,
            MailingLangModelImpl.FINDER_CACHE_ENABLED, MailingLangImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MailingLangModelImpl.ENTITY_CACHE_ENABLED,
            MailingLangModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_MAILINGIDANDLANGUAGEID = new FinderPath(MailingLangModelImpl.ENTITY_CACHE_ENABLED,
            MailingLangModelImpl.FINDER_CACHE_ENABLED, MailingLangImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByMailingIdAndLanguageId",
            new String[] { Long.class.getName(), String.class.getName() },
            MailingLangModelImpl.MAILINGID_COLUMN_BITMASK |
            MailingLangModelImpl.LANGUAGEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_MAILINGIDANDLANGUAGEID = new FinderPath(MailingLangModelImpl.ENTITY_CACHE_ENABLED,
            MailingLangModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByMailingIdAndLanguageId",
            new String[] { Long.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_MAILINGIDANDLANGUAGEID_MAILINGID_2 =
        "mailingLang.mailingId = ? AND ";
    private static final String _FINDER_COLUMN_MAILINGIDANDLANGUAGEID_LANGUAGEID_1 =
        "mailingLang.languageId IS NULL";
    private static final String _FINDER_COLUMN_MAILINGIDANDLANGUAGEID_LANGUAGEID_2 =
        "mailingLang.languageId = ?";
    private static final String _FINDER_COLUMN_MAILINGIDANDLANGUAGEID_LANGUAGEID_3 =
        "(mailingLang.languageId IS NULL OR mailingLang.languageId = '')";
    private static final String _SQL_SELECT_MAILINGLANG = "SELECT mailingLang FROM MailingLang mailingLang";
    private static final String _SQL_SELECT_MAILINGLANG_WHERE = "SELECT mailingLang FROM MailingLang mailingLang WHERE ";
    private static final String _SQL_COUNT_MAILINGLANG = "SELECT COUNT(mailingLang) FROM MailingLang mailingLang";
    private static final String _SQL_COUNT_MAILINGLANG_WHERE = "SELECT COUNT(mailingLang) FROM MailingLang mailingLang WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "mailingLang.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MailingLang exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MailingLang exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(MailingLangPersistenceImpl.class);
    private static MailingLang _nullMailingLang = new MailingLangImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<MailingLang> toCacheModel() {
                return _nullMailingLangCacheModel;
            }
        };

    private static CacheModel<MailingLang> _nullMailingLangCacheModel = new CacheModel<MailingLang>() {
            @Override
            public MailingLang toEntityModel() {
                return _nullMailingLang;
            }
        };

    public MailingLangPersistenceImpl() {
        setModelClass(MailingLang.class);
    }

    /**
     * Returns the mailing lang where mailingId = &#63; and languageId = &#63; or throws a {@link net.zylk.liferay.portal.NoSuchMailingLangException} if it could not be found.
     *
     * @param mailingId the mailing ID
     * @param languageId the language ID
     * @return the matching mailing lang
     * @throws net.zylk.liferay.portal.NoSuchMailingLangException if a matching mailing lang could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MailingLang findByMailingIdAndLanguageId(long mailingId,
        String languageId) throws NoSuchMailingLangException, SystemException {
        MailingLang mailingLang = fetchByMailingIdAndLanguageId(mailingId,
                languageId);

        if (mailingLang == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("mailingId=");
            msg.append(mailingId);

            msg.append(", languageId=");
            msg.append(languageId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchMailingLangException(msg.toString());
        }

        return mailingLang;
    }

    /**
     * Returns the mailing lang where mailingId = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param mailingId the mailing ID
     * @param languageId the language ID
     * @return the matching mailing lang, or <code>null</code> if a matching mailing lang could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MailingLang fetchByMailingIdAndLanguageId(long mailingId,
        String languageId) throws SystemException {
        return fetchByMailingIdAndLanguageId(mailingId, languageId, true);
    }

    /**
     * Returns the mailing lang where mailingId = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param mailingId the mailing ID
     * @param languageId the language ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching mailing lang, or <code>null</code> if a matching mailing lang could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MailingLang fetchByMailingIdAndLanguageId(long mailingId,
        String languageId, boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { mailingId, languageId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MAILINGIDANDLANGUAGEID,
                    finderArgs, this);
        }

        if (result instanceof MailingLang) {
            MailingLang mailingLang = (MailingLang) result;

            if ((mailingId != mailingLang.getMailingId()) ||
                    !Validator.equals(languageId, mailingLang.getLanguageId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_MAILINGLANG_WHERE);

            query.append(_FINDER_COLUMN_MAILINGIDANDLANGUAGEID_MAILINGID_2);

            boolean bindLanguageId = false;

            if (languageId == null) {
                query.append(_FINDER_COLUMN_MAILINGIDANDLANGUAGEID_LANGUAGEID_1);
            } else if (languageId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_MAILINGIDANDLANGUAGEID_LANGUAGEID_3);
            } else {
                bindLanguageId = true;

                query.append(_FINDER_COLUMN_MAILINGIDANDLANGUAGEID_LANGUAGEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(mailingId);

                if (bindLanguageId) {
                    qPos.add(languageId);
                }

                List<MailingLang> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MAILINGIDANDLANGUAGEID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "MailingLangPersistenceImpl.fetchByMailingIdAndLanguageId(long, String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    MailingLang mailingLang = list.get(0);

                    result = mailingLang;

                    cacheResult(mailingLang);

                    if ((mailingLang.getMailingId() != mailingId) ||
                            (mailingLang.getLanguageId() == null) ||
                            !mailingLang.getLanguageId().equals(languageId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MAILINGIDANDLANGUAGEID,
                            finderArgs, mailingLang);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MAILINGIDANDLANGUAGEID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (MailingLang) result;
        }
    }

    /**
     * Removes the mailing lang where mailingId = &#63; and languageId = &#63; from the database.
     *
     * @param mailingId the mailing ID
     * @param languageId the language ID
     * @return the mailing lang that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MailingLang removeByMailingIdAndLanguageId(long mailingId,
        String languageId) throws NoSuchMailingLangException, SystemException {
        MailingLang mailingLang = findByMailingIdAndLanguageId(mailingId,
                languageId);

        return remove(mailingLang);
    }

    /**
     * Returns the number of mailing langs where mailingId = &#63; and languageId = &#63;.
     *
     * @param mailingId the mailing ID
     * @param languageId the language ID
     * @return the number of matching mailing langs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByMailingIdAndLanguageId(long mailingId, String languageId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_MAILINGIDANDLANGUAGEID;

        Object[] finderArgs = new Object[] { mailingId, languageId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_MAILINGLANG_WHERE);

            query.append(_FINDER_COLUMN_MAILINGIDANDLANGUAGEID_MAILINGID_2);

            boolean bindLanguageId = false;

            if (languageId == null) {
                query.append(_FINDER_COLUMN_MAILINGIDANDLANGUAGEID_LANGUAGEID_1);
            } else if (languageId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_MAILINGIDANDLANGUAGEID_LANGUAGEID_3);
            } else {
                bindLanguageId = true;

                query.append(_FINDER_COLUMN_MAILINGIDANDLANGUAGEID_LANGUAGEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(mailingId);

                if (bindLanguageId) {
                    qPos.add(languageId);
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
     * Caches the mailing lang in the entity cache if it is enabled.
     *
     * @param mailingLang the mailing lang
     */
    @Override
    public void cacheResult(MailingLang mailingLang) {
        EntityCacheUtil.putResult(MailingLangModelImpl.ENTITY_CACHE_ENABLED,
            MailingLangImpl.class, mailingLang.getPrimaryKey(), mailingLang);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MAILINGIDANDLANGUAGEID,
            new Object[] { mailingLang.getMailingId(), mailingLang.getLanguageId() },
            mailingLang);

        mailingLang.resetOriginalValues();
    }

    /**
     * Caches the mailing langs in the entity cache if it is enabled.
     *
     * @param mailingLangs the mailing langs
     */
    @Override
    public void cacheResult(List<MailingLang> mailingLangs) {
        for (MailingLang mailingLang : mailingLangs) {
            if (EntityCacheUtil.getResult(
                        MailingLangModelImpl.ENTITY_CACHE_ENABLED,
                        MailingLangImpl.class, mailingLang.getPrimaryKey()) == null) {
                cacheResult(mailingLang);
            } else {
                mailingLang.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all mailing langs.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(MailingLangImpl.class.getName());
        }

        EntityCacheUtil.clearCache(MailingLangImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the mailing lang.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(MailingLang mailingLang) {
        EntityCacheUtil.removeResult(MailingLangModelImpl.ENTITY_CACHE_ENABLED,
            MailingLangImpl.class, mailingLang.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(mailingLang);
    }

    @Override
    public void clearCache(List<MailingLang> mailingLangs) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (MailingLang mailingLang : mailingLangs) {
            EntityCacheUtil.removeResult(MailingLangModelImpl.ENTITY_CACHE_ENABLED,
                MailingLangImpl.class, mailingLang.getPrimaryKey());

            clearUniqueFindersCache(mailingLang);
        }
    }

    protected void cacheUniqueFindersCache(MailingLang mailingLang) {
        if (mailingLang.isNew()) {
            Object[] args = new Object[] {
                    mailingLang.getMailingId(), mailingLang.getLanguageId()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MAILINGIDANDLANGUAGEID,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MAILINGIDANDLANGUAGEID,
                args, mailingLang);
        } else {
            MailingLangModelImpl mailingLangModelImpl = (MailingLangModelImpl) mailingLang;

            if ((mailingLangModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_MAILINGIDANDLANGUAGEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        mailingLang.getMailingId(), mailingLang.getLanguageId()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MAILINGIDANDLANGUAGEID,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MAILINGIDANDLANGUAGEID,
                    args, mailingLang);
            }
        }
    }

    protected void clearUniqueFindersCache(MailingLang mailingLang) {
        MailingLangModelImpl mailingLangModelImpl = (MailingLangModelImpl) mailingLang;

        Object[] args = new Object[] {
                mailingLang.getMailingId(), mailingLang.getLanguageId()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MAILINGIDANDLANGUAGEID,
            args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MAILINGIDANDLANGUAGEID,
            args);

        if ((mailingLangModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_MAILINGIDANDLANGUAGEID.getColumnBitmask()) != 0) {
            args = new Object[] {
                    mailingLangModelImpl.getOriginalMailingId(),
                    mailingLangModelImpl.getOriginalLanguageId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MAILINGIDANDLANGUAGEID,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MAILINGIDANDLANGUAGEID,
                args);
        }
    }

    /**
     * Creates a new mailing lang with the primary key. Does not add the mailing lang to the database.
     *
     * @param mailingLangId the primary key for the new mailing lang
     * @return the new mailing lang
     */
    @Override
    public MailingLang create(long mailingLangId) {
        MailingLang mailingLang = new MailingLangImpl();

        mailingLang.setNew(true);
        mailingLang.setPrimaryKey(mailingLangId);

        return mailingLang;
    }

    /**
     * Removes the mailing lang with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param mailingLangId the primary key of the mailing lang
     * @return the mailing lang that was removed
     * @throws net.zylk.liferay.portal.NoSuchMailingLangException if a mailing lang with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MailingLang remove(long mailingLangId)
        throws NoSuchMailingLangException, SystemException {
        return remove((Serializable) mailingLangId);
    }

    /**
     * Removes the mailing lang with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the mailing lang
     * @return the mailing lang that was removed
     * @throws net.zylk.liferay.portal.NoSuchMailingLangException if a mailing lang with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MailingLang remove(Serializable primaryKey)
        throws NoSuchMailingLangException, SystemException {
        Session session = null;

        try {
            session = openSession();

            MailingLang mailingLang = (MailingLang) session.get(MailingLangImpl.class,
                    primaryKey);

            if (mailingLang == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchMailingLangException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(mailingLang);
        } catch (NoSuchMailingLangException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected MailingLang removeImpl(MailingLang mailingLang)
        throws SystemException {
        mailingLang = toUnwrappedModel(mailingLang);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(mailingLang)) {
                mailingLang = (MailingLang) session.get(MailingLangImpl.class,
                        mailingLang.getPrimaryKeyObj());
            }

            if (mailingLang != null) {
                session.delete(mailingLang);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (mailingLang != null) {
            clearCache(mailingLang);
        }

        return mailingLang;
    }

    @Override
    public MailingLang updateImpl(
        net.zylk.liferay.portal.model.MailingLang mailingLang)
        throws SystemException {
        mailingLang = toUnwrappedModel(mailingLang);

        boolean isNew = mailingLang.isNew();

        Session session = null;

        try {
            session = openSession();

            if (mailingLang.isNew()) {
                session.save(mailingLang);

                mailingLang.setNew(false);
            } else {
                session.merge(mailingLang);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !MailingLangModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(MailingLangModelImpl.ENTITY_CACHE_ENABLED,
            MailingLangImpl.class, mailingLang.getPrimaryKey(), mailingLang);

        clearUniqueFindersCache(mailingLang);
        cacheUniqueFindersCache(mailingLang);

        return mailingLang;
    }

    protected MailingLang toUnwrappedModel(MailingLang mailingLang) {
        if (mailingLang instanceof MailingLangImpl) {
            return mailingLang;
        }

        MailingLangImpl mailingLangImpl = new MailingLangImpl();

        mailingLangImpl.setNew(mailingLang.isNew());
        mailingLangImpl.setPrimaryKey(mailingLang.getPrimaryKey());

        mailingLangImpl.setMailingLangId(mailingLang.getMailingLangId());
        mailingLangImpl.setMailingId(mailingLang.getMailingId());
        mailingLangImpl.setLanguageId(mailingLang.getLanguageId());
        mailingLangImpl.setEmailSubjectPre(mailingLang.getEmailSubjectPre());
        mailingLangImpl.setEmailBodyPre(mailingLang.getEmailBodyPre());

        return mailingLangImpl;
    }

    /**
     * Returns the mailing lang with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the mailing lang
     * @return the mailing lang
     * @throws net.zylk.liferay.portal.NoSuchMailingLangException if a mailing lang with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MailingLang findByPrimaryKey(Serializable primaryKey)
        throws NoSuchMailingLangException, SystemException {
        MailingLang mailingLang = fetchByPrimaryKey(primaryKey);

        if (mailingLang == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchMailingLangException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return mailingLang;
    }

    /**
     * Returns the mailing lang with the primary key or throws a {@link net.zylk.liferay.portal.NoSuchMailingLangException} if it could not be found.
     *
     * @param mailingLangId the primary key of the mailing lang
     * @return the mailing lang
     * @throws net.zylk.liferay.portal.NoSuchMailingLangException if a mailing lang with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MailingLang findByPrimaryKey(long mailingLangId)
        throws NoSuchMailingLangException, SystemException {
        return findByPrimaryKey((Serializable) mailingLangId);
    }

    /**
     * Returns the mailing lang with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the mailing lang
     * @return the mailing lang, or <code>null</code> if a mailing lang with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MailingLang fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        MailingLang mailingLang = (MailingLang) EntityCacheUtil.getResult(MailingLangModelImpl.ENTITY_CACHE_ENABLED,
                MailingLangImpl.class, primaryKey);

        if (mailingLang == _nullMailingLang) {
            return null;
        }

        if (mailingLang == null) {
            Session session = null;

            try {
                session = openSession();

                mailingLang = (MailingLang) session.get(MailingLangImpl.class,
                        primaryKey);

                if (mailingLang != null) {
                    cacheResult(mailingLang);
                } else {
                    EntityCacheUtil.putResult(MailingLangModelImpl.ENTITY_CACHE_ENABLED,
                        MailingLangImpl.class, primaryKey, _nullMailingLang);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(MailingLangModelImpl.ENTITY_CACHE_ENABLED,
                    MailingLangImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return mailingLang;
    }

    /**
     * Returns the mailing lang with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param mailingLangId the primary key of the mailing lang
     * @return the mailing lang, or <code>null</code> if a mailing lang with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public MailingLang fetchByPrimaryKey(long mailingLangId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) mailingLangId);
    }

    /**
     * Returns all the mailing langs.
     *
     * @return the mailing langs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<MailingLang> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the mailing langs.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.MailingLangModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of mailing langs
     * @param end the upper bound of the range of mailing langs (not inclusive)
     * @return the range of mailing langs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<MailingLang> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the mailing langs.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.MailingLangModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of mailing langs
     * @param end the upper bound of the range of mailing langs (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of mailing langs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<MailingLang> findAll(int start, int end,
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

        List<MailingLang> list = (List<MailingLang>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_MAILINGLANG);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_MAILINGLANG;

                if (pagination) {
                    sql = sql.concat(MailingLangModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<MailingLang>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<MailingLang>(list);
                } else {
                    list = (List<MailingLang>) QueryUtil.list(q, getDialect(),
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
     * Removes all the mailing langs from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (MailingLang mailingLang : findAll()) {
            remove(mailingLang);
        }
    }

    /**
     * Returns the number of mailing langs.
     *
     * @return the number of mailing langs
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

                Query q = session.createQuery(_SQL_COUNT_MAILINGLANG);

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
     * Initializes the mailing lang persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.net.zylk.liferay.portal.model.MailingLang")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<MailingLang>> listenersList = new ArrayList<ModelListener<MailingLang>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<MailingLang>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(MailingLangImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
