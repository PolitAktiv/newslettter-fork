package net.zylk.liferay.portal.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Subscriptor}.
 * </p>
 *
 * @author zylk.net
 * @see Subscriptor
 * @generated
 */
public class SubscriptorWrapper implements Subscriptor,
    ModelWrapper<Subscriptor> {
    private Subscriptor _subscriptor;

    public SubscriptorWrapper(Subscriptor subscriptor) {
        _subscriptor = subscriptor;
    }

    @Override
    public Class<?> getModelClass() {
        return Subscriptor.class;
    }

    @Override
    public String getModelClassName() {
        return Subscriptor.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("subscriptorId", getSubscriptorId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("name", getName());
        attributes.put("surname", getSurname());
        attributes.put("email", getEmail());
        attributes.put("languageId", getLanguageId());
        attributes.put("selfSubscribe", getSelfSubscribe());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long subscriptorId = (Long) attributes.get("subscriptorId");

        if (subscriptorId != null) {
            setSubscriptorId(subscriptorId);
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

        String surname = (String) attributes.get("surname");

        if (surname != null) {
            setSurname(surname);
        }

        String email = (String) attributes.get("email");

        if (email != null) {
            setEmail(email);
        }

        String languageId = (String) attributes.get("languageId");

        if (languageId != null) {
            setLanguageId(languageId);
        }

        Boolean selfSubscribe = (Boolean) attributes.get("selfSubscribe");

        if (selfSubscribe != null) {
            setSelfSubscribe(selfSubscribe);
        }
    }

    /**
    * Returns the primary key of this subscriptor.
    *
    * @return the primary key of this subscriptor
    */
    @Override
    public long getPrimaryKey() {
        return _subscriptor.getPrimaryKey();
    }

    /**
    * Sets the primary key of this subscriptor.
    *
    * @param primaryKey the primary key of this subscriptor
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _subscriptor.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this subscriptor.
    *
    * @return the uuid of this subscriptor
    */
    @Override
    public java.lang.String getUuid() {
        return _subscriptor.getUuid();
    }

    /**
    * Sets the uuid of this subscriptor.
    *
    * @param uuid the uuid of this subscriptor
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _subscriptor.setUuid(uuid);
    }

    /**
    * Returns the subscriptor ID of this subscriptor.
    *
    * @return the subscriptor ID of this subscriptor
    */
    @Override
    public long getSubscriptorId() {
        return _subscriptor.getSubscriptorId();
    }

    /**
    * Sets the subscriptor ID of this subscriptor.
    *
    * @param subscriptorId the subscriptor ID of this subscriptor
    */
    @Override
    public void setSubscriptorId(long subscriptorId) {
        _subscriptor.setSubscriptorId(subscriptorId);
    }

    /**
    * Returns the company ID of this subscriptor.
    *
    * @return the company ID of this subscriptor
    */
    @Override
    public long getCompanyId() {
        return _subscriptor.getCompanyId();
    }

    /**
    * Sets the company ID of this subscriptor.
    *
    * @param companyId the company ID of this subscriptor
    */
    @Override
    public void setCompanyId(long companyId) {
        _subscriptor.setCompanyId(companyId);
    }

    /**
    * Returns the group ID of this subscriptor.
    *
    * @return the group ID of this subscriptor
    */
    @Override
    public long getGroupId() {
        return _subscriptor.getGroupId();
    }

    /**
    * Sets the group ID of this subscriptor.
    *
    * @param groupId the group ID of this subscriptor
    */
    @Override
    public void setGroupId(long groupId) {
        _subscriptor.setGroupId(groupId);
    }

    /**
    * Returns the name of this subscriptor.
    *
    * @return the name of this subscriptor
    */
    @Override
    public java.lang.String getName() {
        return _subscriptor.getName();
    }

    /**
    * Sets the name of this subscriptor.
    *
    * @param name the name of this subscriptor
    */
    @Override
    public void setName(java.lang.String name) {
        _subscriptor.setName(name);
    }

    /**
    * Returns the surname of this subscriptor.
    *
    * @return the surname of this subscriptor
    */
    @Override
    public java.lang.String getSurname() {
        return _subscriptor.getSurname();
    }

    /**
    * Sets the surname of this subscriptor.
    *
    * @param surname the surname of this subscriptor
    */
    @Override
    public void setSurname(java.lang.String surname) {
        _subscriptor.setSurname(surname);
    }

    /**
    * Returns the email of this subscriptor.
    *
    * @return the email of this subscriptor
    */
    @Override
    public java.lang.String getEmail() {
        return _subscriptor.getEmail();
    }

    /**
    * Sets the email of this subscriptor.
    *
    * @param email the email of this subscriptor
    */
    @Override
    public void setEmail(java.lang.String email) {
        _subscriptor.setEmail(email);
    }

    /**
    * Returns the language ID of this subscriptor.
    *
    * @return the language ID of this subscriptor
    */
    @Override
    public java.lang.String getLanguageId() {
        return _subscriptor.getLanguageId();
    }

    /**
    * Sets the language ID of this subscriptor.
    *
    * @param languageId the language ID of this subscriptor
    */
    @Override
    public void setLanguageId(java.lang.String languageId) {
        _subscriptor.setLanguageId(languageId);
    }

    /**
    * Returns the self subscribe of this subscriptor.
    *
    * @return the self subscribe of this subscriptor
    */
    @Override
    public boolean getSelfSubscribe() {
        return _subscriptor.getSelfSubscribe();
    }

    /**
    * Returns <code>true</code> if this subscriptor is self subscribe.
    *
    * @return <code>true</code> if this subscriptor is self subscribe; <code>false</code> otherwise
    */
    @Override
    public boolean isSelfSubscribe() {
        return _subscriptor.isSelfSubscribe();
    }

    /**
    * Sets whether this subscriptor is self subscribe.
    *
    * @param selfSubscribe the self subscribe of this subscriptor
    */
    @Override
    public void setSelfSubscribe(boolean selfSubscribe) {
        _subscriptor.setSelfSubscribe(selfSubscribe);
    }

    @Override
    public boolean isNew() {
        return _subscriptor.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _subscriptor.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _subscriptor.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _subscriptor.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _subscriptor.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _subscriptor.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _subscriptor.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _subscriptor.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _subscriptor.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _subscriptor.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _subscriptor.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new SubscriptorWrapper((Subscriptor) _subscriptor.clone());
    }

    @Override
    public int compareTo(Subscriptor subscriptor) {
        return _subscriptor.compareTo(subscriptor);
    }

    @Override
    public int hashCode() {
        return _subscriptor.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<Subscriptor> toCacheModel() {
        return _subscriptor.toCacheModel();
    }

    @Override
    public Subscriptor toEscapedModel() {
        return new SubscriptorWrapper(_subscriptor.toEscapedModel());
    }

    @Override
    public Subscriptor toUnescapedModel() {
        return new SubscriptorWrapper(_subscriptor.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _subscriptor.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _subscriptor.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _subscriptor.persist();
    }

    @Override
    public java.lang.String getFullName() {
        return _subscriptor.getFullName();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof SubscriptorWrapper)) {
            return false;
        }

        SubscriptorWrapper subscriptorWrapper = (SubscriptorWrapper) obj;

        if (Validator.equals(_subscriptor, subscriptorWrapper._subscriptor)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Subscriptor getWrappedSubscriptor() {
        return _subscriptor;
    }

    @Override
    public Subscriptor getWrappedModel() {
        return _subscriptor;
    }

    @Override
    public void resetOriginalValues() {
        _subscriptor.resetOriginalValues();
    }
}
