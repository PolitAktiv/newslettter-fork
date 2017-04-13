package net.zylk.liferay.portal.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import net.zylk.liferay.portal.model.MailingLang;

/**
 * The persistence interface for the mailing lang service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author zylk.net
 * @see MailingLangPersistenceImpl
 * @see MailingLangUtil
 * @generated
 */
public interface MailingLangPersistence extends BasePersistence<MailingLang> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link MailingLangUtil} to access the mailing lang persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the mailing lang where mailingId = &#63; and languageId = &#63; or throws a {@link net.zylk.liferay.portal.NoSuchMailingLangException} if it could not be found.
    *
    * @param mailingId the mailing ID
    * @param languageId the language ID
    * @return the matching mailing lang
    * @throws net.zylk.liferay.portal.NoSuchMailingLangException if a matching mailing lang could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.MailingLang findByMailingIdAndLanguageId(
        long mailingId, java.lang.String languageId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchMailingLangException;

    /**
    * Returns the mailing lang where mailingId = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param mailingId the mailing ID
    * @param languageId the language ID
    * @return the matching mailing lang, or <code>null</code> if a matching mailing lang could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.MailingLang fetchByMailingIdAndLanguageId(
        long mailingId, java.lang.String languageId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the mailing lang where mailingId = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param mailingId the mailing ID
    * @param languageId the language ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching mailing lang, or <code>null</code> if a matching mailing lang could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.MailingLang fetchByMailingIdAndLanguageId(
        long mailingId, java.lang.String languageId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the mailing lang where mailingId = &#63; and languageId = &#63; from the database.
    *
    * @param mailingId the mailing ID
    * @param languageId the language ID
    * @return the mailing lang that was removed
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.MailingLang removeByMailingIdAndLanguageId(
        long mailingId, java.lang.String languageId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchMailingLangException;

    /**
    * Returns the number of mailing langs where mailingId = &#63; and languageId = &#63;.
    *
    * @param mailingId the mailing ID
    * @param languageId the language ID
    * @return the number of matching mailing langs
    * @throws SystemException if a system exception occurred
    */
    public int countByMailingIdAndLanguageId(long mailingId,
        java.lang.String languageId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the mailing lang in the entity cache if it is enabled.
    *
    * @param mailingLang the mailing lang
    */
    public void cacheResult(
        net.zylk.liferay.portal.model.MailingLang mailingLang);

    /**
    * Caches the mailing langs in the entity cache if it is enabled.
    *
    * @param mailingLangs the mailing langs
    */
    public void cacheResult(
        java.util.List<net.zylk.liferay.portal.model.MailingLang> mailingLangs);

    /**
    * Creates a new mailing lang with the primary key. Does not add the mailing lang to the database.
    *
    * @param mailingLangId the primary key for the new mailing lang
    * @return the new mailing lang
    */
    public net.zylk.liferay.portal.model.MailingLang create(long mailingLangId);

    /**
    * Removes the mailing lang with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param mailingLangId the primary key of the mailing lang
    * @return the mailing lang that was removed
    * @throws net.zylk.liferay.portal.NoSuchMailingLangException if a mailing lang with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.MailingLang remove(long mailingLangId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchMailingLangException;

    public net.zylk.liferay.portal.model.MailingLang updateImpl(
        net.zylk.liferay.portal.model.MailingLang mailingLang)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the mailing lang with the primary key or throws a {@link net.zylk.liferay.portal.NoSuchMailingLangException} if it could not be found.
    *
    * @param mailingLangId the primary key of the mailing lang
    * @return the mailing lang
    * @throws net.zylk.liferay.portal.NoSuchMailingLangException if a mailing lang with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.MailingLang findByPrimaryKey(
        long mailingLangId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchMailingLangException;

    /**
    * Returns the mailing lang with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param mailingLangId the primary key of the mailing lang
    * @return the mailing lang, or <code>null</code> if a mailing lang with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.zylk.liferay.portal.model.MailingLang fetchByPrimaryKey(
        long mailingLangId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the mailing langs.
    *
    * @return the mailing langs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.zylk.liferay.portal.model.MailingLang> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<net.zylk.liferay.portal.model.MailingLang> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<net.zylk.liferay.portal.model.MailingLang> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the mailing langs from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of mailing langs.
    *
    * @return the number of mailing langs
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
