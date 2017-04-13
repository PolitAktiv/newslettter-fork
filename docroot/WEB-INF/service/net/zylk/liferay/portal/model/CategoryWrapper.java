package net.zylk.liferay.portal.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Category}.
 * </p>
 *
 * @author zylk.net
 * @see Category
 * @generated
 */
public class CategoryWrapper implements Category, ModelWrapper<Category> {
    private Category _category;

    public CategoryWrapper(Category category) {
        _category = category;
    }

    @Override
    public Class<?> getModelClass() {
        return Category.class;
    }

    @Override
    public String getModelClassName() {
        return Category.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("categoryId", getCategoryId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("name", getName());
        attributes.put("description", getDescription());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long categoryId = (Long) attributes.get("categoryId");

        if (categoryId != null) {
            setCategoryId(categoryId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }
    }

    /**
    * Returns the primary key of this category.
    *
    * @return the primary key of this category
    */
    @Override
    public long getPrimaryKey() {
        return _category.getPrimaryKey();
    }

    /**
    * Sets the primary key of this category.
    *
    * @param primaryKey the primary key of this category
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _category.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the category ID of this category.
    *
    * @return the category ID of this category
    */
    @Override
    public long getCategoryId() {
        return _category.getCategoryId();
    }

    /**
    * Sets the category ID of this category.
    *
    * @param categoryId the category ID of this category
    */
    @Override
    public void setCategoryId(long categoryId) {
        _category.setCategoryId(categoryId);
    }

    /**
    * Returns the company ID of this category.
    *
    * @return the company ID of this category
    */
    @Override
    public long getCompanyId() {
        return _category.getCompanyId();
    }

    /**
    * Sets the company ID of this category.
    *
    * @param companyId the company ID of this category
    */
    @Override
    public void setCompanyId(long companyId) {
        _category.setCompanyId(companyId);
    }

    /**
    * Returns the group ID of this category.
    *
    * @return the group ID of this category
    */
    @Override
    public long getGroupId() {
        return _category.getGroupId();
    }

    /**
    * Sets the group ID of this category.
    *
    * @param groupId the group ID of this category
    */
    @Override
    public void setGroupId(long groupId) {
        _category.setGroupId(groupId);
    }

    /**
    * Returns the name of this category.
    *
    * @return the name of this category
    */
    @Override
    public java.lang.String getName() {
        return _category.getName();
    }

    /**
    * Returns the localized name of this category in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param locale the locale of the language
    * @return the localized name of this category
    */
    @Override
    public java.lang.String getName(java.util.Locale locale) {
        return _category.getName(locale);
    }

    /**
    * Returns the localized name of this category in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param locale the local of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized name of this category. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
    */
    @Override
    public java.lang.String getName(java.util.Locale locale, boolean useDefault) {
        return _category.getName(locale, useDefault);
    }

    /**
    * Returns the localized name of this category in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @return the localized name of this category
    */
    @Override
    public java.lang.String getName(java.lang.String languageId) {
        return _category.getName(languageId);
    }

    /**
    * Returns the localized name of this category in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized name of this category
    */
    @Override
    public java.lang.String getName(java.lang.String languageId,
        boolean useDefault) {
        return _category.getName(languageId, useDefault);
    }

    @Override
    public java.lang.String getNameCurrentLanguageId() {
        return _category.getNameCurrentLanguageId();
    }

    @Override
    public java.lang.String getNameCurrentValue() {
        return _category.getNameCurrentValue();
    }

    /**
    * Returns a map of the locales and localized names of this category.
    *
    * @return the locales and localized names of this category
    */
    @Override
    public java.util.Map<java.util.Locale, java.lang.String> getNameMap() {
        return _category.getNameMap();
    }

    /**
    * Sets the name of this category.
    *
    * @param name the name of this category
    */
    @Override
    public void setName(java.lang.String name) {
        _category.setName(name);
    }

    /**
    * Sets the localized name of this category in the language.
    *
    * @param name the localized name of this category
    * @param locale the locale of the language
    */
    @Override
    public void setName(java.lang.String name, java.util.Locale locale) {
        _category.setName(name, locale);
    }

    /**
    * Sets the localized name of this category in the language, and sets the default locale.
    *
    * @param name the localized name of this category
    * @param locale the locale of the language
    * @param defaultLocale the default locale
    */
    @Override
    public void setName(java.lang.String name, java.util.Locale locale,
        java.util.Locale defaultLocale) {
        _category.setName(name, locale, defaultLocale);
    }

    @Override
    public void setNameCurrentLanguageId(java.lang.String languageId) {
        _category.setNameCurrentLanguageId(languageId);
    }

    /**
    * Sets the localized names of this category from the map of locales and localized names.
    *
    * @param nameMap the locales and localized names of this category
    */
    @Override
    public void setNameMap(
        java.util.Map<java.util.Locale, java.lang.String> nameMap) {
        _category.setNameMap(nameMap);
    }

    /**
    * Sets the localized names of this category from the map of locales and localized names, and sets the default locale.
    *
    * @param nameMap the locales and localized names of this category
    * @param defaultLocale the default locale
    */
    @Override
    public void setNameMap(
        java.util.Map<java.util.Locale, java.lang.String> nameMap,
        java.util.Locale defaultLocale) {
        _category.setNameMap(nameMap, defaultLocale);
    }

    /**
    * Returns the description of this category.
    *
    * @return the description of this category
    */
    @Override
    public java.lang.String getDescription() {
        return _category.getDescription();
    }

    /**
    * Sets the description of this category.
    *
    * @param description the description of this category
    */
    @Override
    public void setDescription(java.lang.String description) {
        _category.setDescription(description);
    }

    @Override
    public boolean isNew() {
        return _category.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _category.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _category.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _category.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _category.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _category.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _category.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _category.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _category.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _category.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _category.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.String[] getAvailableLanguageIds() {
        return _category.getAvailableLanguageIds();
    }

    @Override
    public java.lang.String getDefaultLanguageId() {
        return _category.getDefaultLanguageId();
    }

    @Override
    public void prepareLocalizedFieldsForImport()
        throws com.liferay.portal.LocaleException {
        _category.prepareLocalizedFieldsForImport();
    }

    @Override
    public void prepareLocalizedFieldsForImport(
        java.util.Locale defaultImportLocale)
        throws com.liferay.portal.LocaleException {
        _category.prepareLocalizedFieldsForImport(defaultImportLocale);
    }

    @Override
    public java.lang.Object clone() {
        return new CategoryWrapper((Category) _category.clone());
    }

    @Override
    public int compareTo(Category category) {
        return _category.compareTo(category);
    }

    @Override
    public int hashCode() {
        return _category.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<Category> toCacheModel() {
        return _category.toCacheModel();
    }

    @Override
    public Category toEscapedModel() {
        return new CategoryWrapper(_category.toEscapedModel());
    }

    @Override
    public Category toUnescapedModel() {
        return new CategoryWrapper(_category.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _category.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _category.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _category.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CategoryWrapper)) {
            return false;
        }

        CategoryWrapper categoryWrapper = (CategoryWrapper) obj;

        if (Validator.equals(_category, categoryWrapper._category)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Category getWrappedCategory() {
        return _category;
    }

    @Override
    public Category getWrappedModel() {
        return _category;
    }

    @Override
    public void resetOriginalValues() {
        _category.resetOriginalValues();
    }
}
