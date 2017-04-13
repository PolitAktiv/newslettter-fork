package net.zylk.liferay.portal.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SubscriptorCategory}.
 * </p>
 *
 * @author zylk.net
 * @see SubscriptorCategory
 * @generated
 */
public class SubscriptorCategoryWrapper implements SubscriptorCategory,
    ModelWrapper<SubscriptorCategory> {
    private SubscriptorCategory _subscriptorCategory;

    public SubscriptorCategoryWrapper(SubscriptorCategory subscriptorCategory) {
        _subscriptorCategory = subscriptorCategory;
    }

    @Override
    public Class<?> getModelClass() {
        return SubscriptorCategory.class;
    }

    @Override
    public String getModelClassName() {
        return SubscriptorCategory.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("subscriptorCategoryId", getSubscriptorCategoryId());
        attributes.put("subscriptorId", getSubscriptorId());
        attributes.put("categoryId", getCategoryId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long subscriptorCategoryId = (Long) attributes.get(
                "subscriptorCategoryId");

        if (subscriptorCategoryId != null) {
            setSubscriptorCategoryId(subscriptorCategoryId);
        }

        Long subscriptorId = (Long) attributes.get("subscriptorId");

        if (subscriptorId != null) {
            setSubscriptorId(subscriptorId);
        }

        Long categoryId = (Long) attributes.get("categoryId");

        if (categoryId != null) {
            setCategoryId(categoryId);
        }
    }

    /**
    * Returns the primary key of this subscriptor category.
    *
    * @return the primary key of this subscriptor category
    */
    @Override
    public long getPrimaryKey() {
        return _subscriptorCategory.getPrimaryKey();
    }

    /**
    * Sets the primary key of this subscriptor category.
    *
    * @param primaryKey the primary key of this subscriptor category
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _subscriptorCategory.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the subscriptor category ID of this subscriptor category.
    *
    * @return the subscriptor category ID of this subscriptor category
    */
    @Override
    public long getSubscriptorCategoryId() {
        return _subscriptorCategory.getSubscriptorCategoryId();
    }

    /**
    * Sets the subscriptor category ID of this subscriptor category.
    *
    * @param subscriptorCategoryId the subscriptor category ID of this subscriptor category
    */
    @Override
    public void setSubscriptorCategoryId(long subscriptorCategoryId) {
        _subscriptorCategory.setSubscriptorCategoryId(subscriptorCategoryId);
    }

    /**
    * Returns the subscriptor ID of this subscriptor category.
    *
    * @return the subscriptor ID of this subscriptor category
    */
    @Override
    public long getSubscriptorId() {
        return _subscriptorCategory.getSubscriptorId();
    }

    /**
    * Sets the subscriptor ID of this subscriptor category.
    *
    * @param subscriptorId the subscriptor ID of this subscriptor category
    */
    @Override
    public void setSubscriptorId(long subscriptorId) {
        _subscriptorCategory.setSubscriptorId(subscriptorId);
    }

    /**
    * Returns the category ID of this subscriptor category.
    *
    * @return the category ID of this subscriptor category
    */
    @Override
    public long getCategoryId() {
        return _subscriptorCategory.getCategoryId();
    }

    /**
    * Sets the category ID of this subscriptor category.
    *
    * @param categoryId the category ID of this subscriptor category
    */
    @Override
    public void setCategoryId(long categoryId) {
        _subscriptorCategory.setCategoryId(categoryId);
    }

    @Override
    public boolean isNew() {
        return _subscriptorCategory.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _subscriptorCategory.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _subscriptorCategory.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _subscriptorCategory.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _subscriptorCategory.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _subscriptorCategory.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _subscriptorCategory.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _subscriptorCategory.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _subscriptorCategory.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _subscriptorCategory.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _subscriptorCategory.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new SubscriptorCategoryWrapper((SubscriptorCategory) _subscriptorCategory.clone());
    }

    @Override
    public int compareTo(SubscriptorCategory subscriptorCategory) {
        return _subscriptorCategory.compareTo(subscriptorCategory);
    }

    @Override
    public int hashCode() {
        return _subscriptorCategory.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<SubscriptorCategory> toCacheModel() {
        return _subscriptorCategory.toCacheModel();
    }

    @Override
    public SubscriptorCategory toEscapedModel() {
        return new SubscriptorCategoryWrapper(_subscriptorCategory.toEscapedModel());
    }

    @Override
    public SubscriptorCategory toUnescapedModel() {
        return new SubscriptorCategoryWrapper(_subscriptorCategory.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _subscriptorCategory.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _subscriptorCategory.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _subscriptorCategory.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof SubscriptorCategoryWrapper)) {
            return false;
        }

        SubscriptorCategoryWrapper subscriptorCategoryWrapper = (SubscriptorCategoryWrapper) obj;

        if (Validator.equals(_subscriptorCategory,
                    subscriptorCategoryWrapper._subscriptorCategory)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public SubscriptorCategory getWrappedSubscriptorCategory() {
        return _subscriptorCategory;
    }

    @Override
    public SubscriptorCategory getWrappedModel() {
        return _subscriptorCategory;
    }

    @Override
    public void resetOriginalValues() {
        _subscriptorCategory.resetOriginalValues();
    }
}
