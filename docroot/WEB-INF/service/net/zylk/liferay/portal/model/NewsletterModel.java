package net.zylk.liferay.portal.model;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the Newsletter service. Represents a row in the &quot;ZN_Newsletter&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link net.zylk.liferay.portal.model.impl.NewsletterModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link net.zylk.liferay.portal.model.impl.NewsletterImpl}.
 * </p>
 *
 * @author zylk.net
 * @see Newsletter
 * @see net.zylk.liferay.portal.model.impl.NewsletterImpl
 * @see net.zylk.liferay.portal.model.impl.NewsletterModelImpl
 * @generated
 */
public interface NewsletterModel extends BaseModel<Newsletter> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a newsletter model instance should use the {@link Newsletter} interface instead.
     */

    /**
     * Returns the primary key of this newsletter.
     *
     * @return the primary key of this newsletter
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this newsletter.
     *
     * @param primaryKey the primary key of this newsletter
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the newsletter ID of this newsletter.
     *
     * @return the newsletter ID of this newsletter
     */
    public long getNewsletterId();

    /**
     * Sets the newsletter ID of this newsletter.
     *
     * @param newsletterId the newsletter ID of this newsletter
     */
    public void setNewsletterId(long newsletterId);

    /**
     * Returns the company ID of this newsletter.
     *
     * @return the company ID of this newsletter
     */
    public long getCompanyId();

    /**
     * Sets the company ID of this newsletter.
     *
     * @param companyId the company ID of this newsletter
     */
    public void setCompanyId(long companyId);

    /**
     * Returns the group ID of this newsletter.
     *
     * @return the group ID of this newsletter
     */
    public long getGroupId();

    /**
     * Sets the group ID of this newsletter.
     *
     * @param groupId the group ID of this newsletter
     */
    public void setGroupId(long groupId);

    /**
     * Returns the create date of this newsletter.
     *
     * @return the create date of this newsletter
     */
    public Date getCreateDate();

    /**
     * Sets the create date of this newsletter.
     *
     * @param createDate the create date of this newsletter
     */
    public void setCreateDate(Date createDate);

    /**
     * Returns the modified date of this newsletter.
     *
     * @return the modified date of this newsletter
     */
    public Date getModifiedDate();

    /**
     * Sets the modified date of this newsletter.
     *
     * @param modifiedDate the modified date of this newsletter
     */
    public void setModifiedDate(Date modifiedDate);

    /**
     * Returns the name of this newsletter.
     *
     * @return the name of this newsletter
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this newsletter.
     *
     * @param name the name of this newsletter
     */
    public void setName(String name);

    /**
     * Returns the description of this newsletter.
     *
     * @return the description of this newsletter
     */
    @AutoEscape
    public String getDescription();

    /**
     * Sets the description of this newsletter.
     *
     * @param description the description of this newsletter
     */
    public void setDescription(String description);

    /**
     * Returns the category ID of this newsletter.
     *
     * @return the category ID of this newsletter
     */
    public long getCategoryId();

    /**
     * Sets the category ID of this newsletter.
     *
     * @param categoryId the category ID of this newsletter
     */
    public void setCategoryId(long categoryId);

    /**
     * Returns the subject of this newsletter.
     *
     * @return the subject of this newsletter
     */
    public String getSubject();

    /**
     * Returns the localized subject of this newsletter in the language. Uses the default language if no localization exists for the requested language.
     *
     * @param locale the locale of the language
     * @return the localized subject of this newsletter
     */
    @AutoEscape
    public String getSubject(Locale locale);

    /**
     * Returns the localized subject of this newsletter in the language, optionally using the default language if no localization exists for the requested language.
     *
     * @param locale the local of the language
     * @param useDefault whether to use the default language if no localization exists for the requested language
     * @return the localized subject of this newsletter. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
     */
    @AutoEscape
    public String getSubject(Locale locale, boolean useDefault);

    /**
     * Returns the localized subject of this newsletter in the language. Uses the default language if no localization exists for the requested language.
     *
     * @param languageId the ID of the language
     * @return the localized subject of this newsletter
     */
    @AutoEscape
    public String getSubject(String languageId);

    /**
     * Returns the localized subject of this newsletter in the language, optionally using the default language if no localization exists for the requested language.
     *
     * @param languageId the ID of the language
     * @param useDefault whether to use the default language if no localization exists for the requested language
     * @return the localized subject of this newsletter
     */
    @AutoEscape
    public String getSubject(String languageId, boolean useDefault);

    @AutoEscape
    public String getSubjectCurrentLanguageId();

    @AutoEscape
    public String getSubjectCurrentValue();

    /**
     * Returns a map of the locales and localized subjects of this newsletter.
     *
     * @return the locales and localized subjects of this newsletter
     */
    public Map<Locale, String> getSubjectMap();

    /**
     * Sets the subject of this newsletter.
     *
     * @param subject the subject of this newsletter
     */
    public void setSubject(String subject);

    /**
     * Sets the localized subject of this newsletter in the language.
     *
     * @param subject the localized subject of this newsletter
     * @param locale the locale of the language
     */
    public void setSubject(String subject, Locale locale);

    /**
     * Sets the localized subject of this newsletter in the language, and sets the default locale.
     *
     * @param subject the localized subject of this newsletter
     * @param locale the locale of the language
     * @param defaultLocale the default locale
     */
    public void setSubject(String subject, Locale locale, Locale defaultLocale);

    public void setSubjectCurrentLanguageId(String languageId);

    /**
     * Sets the localized subjects of this newsletter from the map of locales and localized subjects.
     *
     * @param subjectMap the locales and localized subjects of this newsletter
     */
    public void setSubjectMap(Map<Locale, String> subjectMap);

    /**
     * Sets the localized subjects of this newsletter from the map of locales and localized subjects, and sets the default locale.
     *
     * @param subjectMap the locales and localized subjects of this newsletter
     * @param defaultLocale the default locale
     */
    public void setSubjectMap(Map<Locale, String> subjectMap,
        Locale defaultLocale);

    /**
     * Returns the article ID of this newsletter.
     *
     * @return the article ID of this newsletter
     */
    @AutoEscape
    public String getArticleId();

    /**
     * Sets the article ID of this newsletter.
     *
     * @param articleId the article ID of this newsletter
     */
    public void setArticleId(String articleId);

    /**
     * Returns the article group ID of this newsletter.
     *
     * @return the article group ID of this newsletter
     */
    public long getArticleGroupId();

    /**
     * Sets the article group ID of this newsletter.
     *
     * @param articleGroupId the article group ID of this newsletter
     */
    public void setArticleGroupId(long articleGroupId);

    /**
     * Returns the scheduler active of this newsletter.
     *
     * @return the scheduler active of this newsletter
     */
    public boolean getSchedulerActive();

    /**
     * Returns <code>true</code> if this newsletter is scheduler active.
     *
     * @return <code>true</code> if this newsletter is scheduler active; <code>false</code> otherwise
     */
    public boolean isSchedulerActive();

    /**
     * Sets whether this newsletter is scheduler active.
     *
     * @param schedulerActive the scheduler active of this newsletter
     */
    public void setSchedulerActive(boolean schedulerActive);

    /**
     * Returns the scheduler type of this newsletter.
     *
     * @return the scheduler type of this newsletter
     */
    public int getSchedulerType();

    /**
     * Sets the scheduler type of this newsletter.
     *
     * @param schedulerType the scheduler type of this newsletter
     */
    public void setSchedulerType(int schedulerType);

    /**
     * Returns the scheduler date of this newsletter.
     *
     * @return the scheduler date of this newsletter
     */
    public Date getSchedulerDate();

    /**
     * Sets the scheduler date of this newsletter.
     *
     * @param schedulerDate the scheduler date of this newsletter
     */
    public void setSchedulerDate(Date schedulerDate);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    public String[] getAvailableLanguageIds();

    public String getDefaultLanguageId();

    public void prepareLocalizedFieldsForImport() throws LocaleException;

    public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
        throws LocaleException;

    @Override
    public Object clone();

    @Override
    public int compareTo(Newsletter newsletter);

    @Override
    public int hashCode();

    @Override
    public CacheModel<Newsletter> toCacheModel();

    @Override
    public Newsletter toEscapedModel();

    @Override
    public Newsletter toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
