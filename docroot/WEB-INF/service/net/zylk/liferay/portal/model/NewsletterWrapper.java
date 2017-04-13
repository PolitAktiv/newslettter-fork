package net.zylk.liferay.portal.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Newsletter}.
 * </p>
 *
 * @author zylk.net
 * @see Newsletter
 * @generated
 */
public class NewsletterWrapper implements Newsletter, ModelWrapper<Newsletter> {
    private Newsletter _newsletter;

    public NewsletterWrapper(Newsletter newsletter) {
        _newsletter = newsletter;
    }

    @Override
    public Class<?> getModelClass() {
        return Newsletter.class;
    }

    @Override
    public String getModelClassName() {
        return Newsletter.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("newsletterId", getNewsletterId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("categoryId", getCategoryId());
        attributes.put("subject", getSubject());
        attributes.put("articleId", getArticleId());
        attributes.put("articleGroupId", getArticleGroupId());
        attributes.put("schedulerActive", getSchedulerActive());
        attributes.put("schedulerType", getSchedulerType());
        attributes.put("schedulerDate", getSchedulerDate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long newsletterId = (Long) attributes.get("newsletterId");

        if (newsletterId != null) {
            setNewsletterId(newsletterId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        Long categoryId = (Long) attributes.get("categoryId");

        if (categoryId != null) {
            setCategoryId(categoryId);
        }

        String subject = (String) attributes.get("subject");

        if (subject != null) {
            setSubject(subject);
        }

        String articleId = (String) attributes.get("articleId");

        if (articleId != null) {
            setArticleId(articleId);
        }

        Long articleGroupId = (Long) attributes.get("articleGroupId");

        if (articleGroupId != null) {
            setArticleGroupId(articleGroupId);
        }

        Boolean schedulerActive = (Boolean) attributes.get("schedulerActive");

        if (schedulerActive != null) {
            setSchedulerActive(schedulerActive);
        }

        Integer schedulerType = (Integer) attributes.get("schedulerType");

        if (schedulerType != null) {
            setSchedulerType(schedulerType);
        }

        Date schedulerDate = (Date) attributes.get("schedulerDate");

        if (schedulerDate != null) {
            setSchedulerDate(schedulerDate);
        }
    }

    /**
    * Returns the primary key of this newsletter.
    *
    * @return the primary key of this newsletter
    */
    @Override
    public long getPrimaryKey() {
        return _newsletter.getPrimaryKey();
    }

    /**
    * Sets the primary key of this newsletter.
    *
    * @param primaryKey the primary key of this newsletter
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _newsletter.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the newsletter ID of this newsletter.
    *
    * @return the newsletter ID of this newsletter
    */
    @Override
    public long getNewsletterId() {
        return _newsletter.getNewsletterId();
    }

    /**
    * Sets the newsletter ID of this newsletter.
    *
    * @param newsletterId the newsletter ID of this newsletter
    */
    @Override
    public void setNewsletterId(long newsletterId) {
        _newsletter.setNewsletterId(newsletterId);
    }

    /**
    * Returns the company ID of this newsletter.
    *
    * @return the company ID of this newsletter
    */
    @Override
    public long getCompanyId() {
        return _newsletter.getCompanyId();
    }

    /**
    * Sets the company ID of this newsletter.
    *
    * @param companyId the company ID of this newsletter
    */
    @Override
    public void setCompanyId(long companyId) {
        _newsletter.setCompanyId(companyId);
    }

    /**
    * Returns the group ID of this newsletter.
    *
    * @return the group ID of this newsletter
    */
    @Override
    public long getGroupId() {
        return _newsletter.getGroupId();
    }

    /**
    * Sets the group ID of this newsletter.
    *
    * @param groupId the group ID of this newsletter
    */
    @Override
    public void setGroupId(long groupId) {
        _newsletter.setGroupId(groupId);
    }

    /**
    * Returns the create date of this newsletter.
    *
    * @return the create date of this newsletter
    */
    @Override
    public java.util.Date getCreateDate() {
        return _newsletter.getCreateDate();
    }

    /**
    * Sets the create date of this newsletter.
    *
    * @param createDate the create date of this newsletter
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _newsletter.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this newsletter.
    *
    * @return the modified date of this newsletter
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _newsletter.getModifiedDate();
    }

    /**
    * Sets the modified date of this newsletter.
    *
    * @param modifiedDate the modified date of this newsletter
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _newsletter.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the name of this newsletter.
    *
    * @return the name of this newsletter
    */
    @Override
    public java.lang.String getName() {
        return _newsletter.getName();
    }

    /**
    * Sets the name of this newsletter.
    *
    * @param name the name of this newsletter
    */
    @Override
    public void setName(java.lang.String name) {
        _newsletter.setName(name);
    }

    /**
    * Returns the description of this newsletter.
    *
    * @return the description of this newsletter
    */
    @Override
    public java.lang.String getDescription() {
        return _newsletter.getDescription();
    }

    /**
    * Sets the description of this newsletter.
    *
    * @param description the description of this newsletter
    */
    @Override
    public void setDescription(java.lang.String description) {
        _newsletter.setDescription(description);
    }

    /**
    * Returns the category ID of this newsletter.
    *
    * @return the category ID of this newsletter
    */
    @Override
    public long getCategoryId() {
        return _newsletter.getCategoryId();
    }

    /**
    * Sets the category ID of this newsletter.
    *
    * @param categoryId the category ID of this newsletter
    */
    @Override
    public void setCategoryId(long categoryId) {
        _newsletter.setCategoryId(categoryId);
    }

    /**
    * Returns the subject of this newsletter.
    *
    * @return the subject of this newsletter
    */
    @Override
    public java.lang.String getSubject() {
        return _newsletter.getSubject();
    }

    /**
    * Returns the localized subject of this newsletter in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param locale the locale of the language
    * @return the localized subject of this newsletter
    */
    @Override
    public java.lang.String getSubject(java.util.Locale locale) {
        return _newsletter.getSubject(locale);
    }

    /**
    * Returns the localized subject of this newsletter in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param locale the local of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized subject of this newsletter. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
    */
    @Override
    public java.lang.String getSubject(java.util.Locale locale,
        boolean useDefault) {
        return _newsletter.getSubject(locale, useDefault);
    }

    /**
    * Returns the localized subject of this newsletter in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @return the localized subject of this newsletter
    */
    @Override
    public java.lang.String getSubject(java.lang.String languageId) {
        return _newsletter.getSubject(languageId);
    }

    /**
    * Returns the localized subject of this newsletter in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized subject of this newsletter
    */
    @Override
    public java.lang.String getSubject(java.lang.String languageId,
        boolean useDefault) {
        return _newsletter.getSubject(languageId, useDefault);
    }

    @Override
    public java.lang.String getSubjectCurrentLanguageId() {
        return _newsletter.getSubjectCurrentLanguageId();
    }

    @Override
    public java.lang.String getSubjectCurrentValue() {
        return _newsletter.getSubjectCurrentValue();
    }

    /**
    * Returns a map of the locales and localized subjects of this newsletter.
    *
    * @return the locales and localized subjects of this newsletter
    */
    @Override
    public java.util.Map<java.util.Locale, java.lang.String> getSubjectMap() {
        return _newsletter.getSubjectMap();
    }

    /**
    * Sets the subject of this newsletter.
    *
    * @param subject the subject of this newsletter
    */
    @Override
    public void setSubject(java.lang.String subject) {
        _newsletter.setSubject(subject);
    }

    /**
    * Sets the localized subject of this newsletter in the language.
    *
    * @param subject the localized subject of this newsletter
    * @param locale the locale of the language
    */
    @Override
    public void setSubject(java.lang.String subject, java.util.Locale locale) {
        _newsletter.setSubject(subject, locale);
    }

    /**
    * Sets the localized subject of this newsletter in the language, and sets the default locale.
    *
    * @param subject the localized subject of this newsletter
    * @param locale the locale of the language
    * @param defaultLocale the default locale
    */
    @Override
    public void setSubject(java.lang.String subject, java.util.Locale locale,
        java.util.Locale defaultLocale) {
        _newsletter.setSubject(subject, locale, defaultLocale);
    }

    @Override
    public void setSubjectCurrentLanguageId(java.lang.String languageId) {
        _newsletter.setSubjectCurrentLanguageId(languageId);
    }

    /**
    * Sets the localized subjects of this newsletter from the map of locales and localized subjects.
    *
    * @param subjectMap the locales and localized subjects of this newsletter
    */
    @Override
    public void setSubjectMap(
        java.util.Map<java.util.Locale, java.lang.String> subjectMap) {
        _newsletter.setSubjectMap(subjectMap);
    }

    /**
    * Sets the localized subjects of this newsletter from the map of locales and localized subjects, and sets the default locale.
    *
    * @param subjectMap the locales and localized subjects of this newsletter
    * @param defaultLocale the default locale
    */
    @Override
    public void setSubjectMap(
        java.util.Map<java.util.Locale, java.lang.String> subjectMap,
        java.util.Locale defaultLocale) {
        _newsletter.setSubjectMap(subjectMap, defaultLocale);
    }

    /**
    * Returns the article ID of this newsletter.
    *
    * @return the article ID of this newsletter
    */
    @Override
    public java.lang.String getArticleId() {
        return _newsletter.getArticleId();
    }

    /**
    * Sets the article ID of this newsletter.
    *
    * @param articleId the article ID of this newsletter
    */
    @Override
    public void setArticleId(java.lang.String articleId) {
        _newsletter.setArticleId(articleId);
    }

    /**
    * Returns the article group ID of this newsletter.
    *
    * @return the article group ID of this newsletter
    */
    @Override
    public long getArticleGroupId() {
        return _newsletter.getArticleGroupId();
    }

    /**
    * Sets the article group ID of this newsletter.
    *
    * @param articleGroupId the article group ID of this newsletter
    */
    @Override
    public void setArticleGroupId(long articleGroupId) {
        _newsletter.setArticleGroupId(articleGroupId);
    }

    /**
    * Returns the scheduler active of this newsletter.
    *
    * @return the scheduler active of this newsletter
    */
    @Override
    public boolean getSchedulerActive() {
        return _newsletter.getSchedulerActive();
    }

    /**
    * Returns <code>true</code> if this newsletter is scheduler active.
    *
    * @return <code>true</code> if this newsletter is scheduler active; <code>false</code> otherwise
    */
    @Override
    public boolean isSchedulerActive() {
        return _newsletter.isSchedulerActive();
    }

    /**
    * Sets whether this newsletter is scheduler active.
    *
    * @param schedulerActive the scheduler active of this newsletter
    */
    @Override
    public void setSchedulerActive(boolean schedulerActive) {
        _newsletter.setSchedulerActive(schedulerActive);
    }

    /**
    * Returns the scheduler type of this newsletter.
    *
    * @return the scheduler type of this newsletter
    */
    @Override
    public int getSchedulerType() {
        return _newsletter.getSchedulerType();
    }

    /**
    * Sets the scheduler type of this newsletter.
    *
    * @param schedulerType the scheduler type of this newsletter
    */
    @Override
    public void setSchedulerType(int schedulerType) {
        _newsletter.setSchedulerType(schedulerType);
    }

    /**
    * Returns the scheduler date of this newsletter.
    *
    * @return the scheduler date of this newsletter
    */
    @Override
    public java.util.Date getSchedulerDate() {
        return _newsletter.getSchedulerDate();
    }

    /**
    * Sets the scheduler date of this newsletter.
    *
    * @param schedulerDate the scheduler date of this newsletter
    */
    @Override
    public void setSchedulerDate(java.util.Date schedulerDate) {
        _newsletter.setSchedulerDate(schedulerDate);
    }

    @Override
    public boolean isNew() {
        return _newsletter.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _newsletter.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _newsletter.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _newsletter.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _newsletter.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _newsletter.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _newsletter.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _newsletter.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _newsletter.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _newsletter.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _newsletter.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.String[] getAvailableLanguageIds() {
        return _newsletter.getAvailableLanguageIds();
    }

    @Override
    public java.lang.String getDefaultLanguageId() {
        return _newsletter.getDefaultLanguageId();
    }

    @Override
    public void prepareLocalizedFieldsForImport()
        throws com.liferay.portal.LocaleException {
        _newsletter.prepareLocalizedFieldsForImport();
    }

    @Override
    public void prepareLocalizedFieldsForImport(
        java.util.Locale defaultImportLocale)
        throws com.liferay.portal.LocaleException {
        _newsletter.prepareLocalizedFieldsForImport(defaultImportLocale);
    }

    @Override
    public java.lang.Object clone() {
        return new NewsletterWrapper((Newsletter) _newsletter.clone());
    }

    @Override
    public int compareTo(Newsletter newsletter) {
        return _newsletter.compareTo(newsletter);
    }

    @Override
    public int hashCode() {
        return _newsletter.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<Newsletter> toCacheModel() {
        return _newsletter.toCacheModel();
    }

    @Override
    public Newsletter toEscapedModel() {
        return new NewsletterWrapper(_newsletter.toEscapedModel());
    }

    @Override
    public Newsletter toUnescapedModel() {
        return new NewsletterWrapper(_newsletter.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _newsletter.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _newsletter.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _newsletter.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof NewsletterWrapper)) {
            return false;
        }

        NewsletterWrapper newsletterWrapper = (NewsletterWrapper) obj;

        if (Validator.equals(_newsletter, newsletterWrapper._newsletter)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Newsletter getWrappedNewsletter() {
        return _newsletter;
    }

    @Override
    public Newsletter getWrappedModel() {
        return _newsletter;
    }

    @Override
    public void resetOriginalValues() {
        _newsletter.resetOriginalValues();
    }
}
