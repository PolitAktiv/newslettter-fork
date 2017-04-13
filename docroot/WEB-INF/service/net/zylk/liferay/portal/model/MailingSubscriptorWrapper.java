package net.zylk.liferay.portal.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MailingSubscriptor}.
 * </p>
 *
 * @author zylk.net
 * @see MailingSubscriptor
 * @generated
 */
public class MailingSubscriptorWrapper implements MailingSubscriptor,
    ModelWrapper<MailingSubscriptor> {
    private MailingSubscriptor _mailingSubscriptor;

    public MailingSubscriptorWrapper(MailingSubscriptor mailingSubscriptor) {
        _mailingSubscriptor = mailingSubscriptor;
    }

    @Override
    public Class<?> getModelClass() {
        return MailingSubscriptor.class;
    }

    @Override
    public String getModelClassName() {
        return MailingSubscriptor.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("mailingSubscriptorId", getMailingSubscriptorId());
        attributes.put("mailingId", getMailingId());
        attributes.put("email", getEmail());
        attributes.put("name", getName());
        attributes.put("surname", getSurname());
        attributes.put("languageId", getLanguageId());
        attributes.put("emailSubject", getEmailSubject());
        attributes.put("emailBody", getEmailBody());
        attributes.put("tokens", getTokens());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long mailingSubscriptorId = (Long) attributes.get(
                "mailingSubscriptorId");

        if (mailingSubscriptorId != null) {
            setMailingSubscriptorId(mailingSubscriptorId);
        }

        Long mailingId = (Long) attributes.get("mailingId");

        if (mailingId != null) {
            setMailingId(mailingId);
        }

        String email = (String) attributes.get("email");

        if (email != null) {
            setEmail(email);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String surname = (String) attributes.get("surname");

        if (surname != null) {
            setSurname(surname);
        }

        String languageId = (String) attributes.get("languageId");

        if (languageId != null) {
            setLanguageId(languageId);
        }

        String emailSubject = (String) attributes.get("emailSubject");

        if (emailSubject != null) {
            setEmailSubject(emailSubject);
        }

        String emailBody = (String) attributes.get("emailBody");

        if (emailBody != null) {
            setEmailBody(emailBody);
        }

        String tokens = (String) attributes.get("tokens");

        if (tokens != null) {
            setTokens(tokens);
        }
    }

    /**
    * Returns the primary key of this mailing subscriptor.
    *
    * @return the primary key of this mailing subscriptor
    */
    @Override
    public long getPrimaryKey() {
        return _mailingSubscriptor.getPrimaryKey();
    }

    /**
    * Sets the primary key of this mailing subscriptor.
    *
    * @param primaryKey the primary key of this mailing subscriptor
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _mailingSubscriptor.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the mailing subscriptor ID of this mailing subscriptor.
    *
    * @return the mailing subscriptor ID of this mailing subscriptor
    */
    @Override
    public long getMailingSubscriptorId() {
        return _mailingSubscriptor.getMailingSubscriptorId();
    }

    /**
    * Sets the mailing subscriptor ID of this mailing subscriptor.
    *
    * @param mailingSubscriptorId the mailing subscriptor ID of this mailing subscriptor
    */
    @Override
    public void setMailingSubscriptorId(long mailingSubscriptorId) {
        _mailingSubscriptor.setMailingSubscriptorId(mailingSubscriptorId);
    }

    /**
    * Returns the mailing ID of this mailing subscriptor.
    *
    * @return the mailing ID of this mailing subscriptor
    */
    @Override
    public long getMailingId() {
        return _mailingSubscriptor.getMailingId();
    }

    /**
    * Sets the mailing ID of this mailing subscriptor.
    *
    * @param mailingId the mailing ID of this mailing subscriptor
    */
    @Override
    public void setMailingId(long mailingId) {
        _mailingSubscriptor.setMailingId(mailingId);
    }

    /**
    * Returns the email of this mailing subscriptor.
    *
    * @return the email of this mailing subscriptor
    */
    @Override
    public java.lang.String getEmail() {
        return _mailingSubscriptor.getEmail();
    }

    /**
    * Sets the email of this mailing subscriptor.
    *
    * @param email the email of this mailing subscriptor
    */
    @Override
    public void setEmail(java.lang.String email) {
        _mailingSubscriptor.setEmail(email);
    }

    /**
    * Returns the name of this mailing subscriptor.
    *
    * @return the name of this mailing subscriptor
    */
    @Override
    public java.lang.String getName() {
        return _mailingSubscriptor.getName();
    }

    /**
    * Sets the name of this mailing subscriptor.
    *
    * @param name the name of this mailing subscriptor
    */
    @Override
    public void setName(java.lang.String name) {
        _mailingSubscriptor.setName(name);
    }

    /**
    * Returns the surname of this mailing subscriptor.
    *
    * @return the surname of this mailing subscriptor
    */
    @Override
    public java.lang.String getSurname() {
        return _mailingSubscriptor.getSurname();
    }

    /**
    * Sets the surname of this mailing subscriptor.
    *
    * @param surname the surname of this mailing subscriptor
    */
    @Override
    public void setSurname(java.lang.String surname) {
        _mailingSubscriptor.setSurname(surname);
    }

    /**
    * Returns the language ID of this mailing subscriptor.
    *
    * @return the language ID of this mailing subscriptor
    */
    @Override
    public java.lang.String getLanguageId() {
        return _mailingSubscriptor.getLanguageId();
    }

    /**
    * Sets the language ID of this mailing subscriptor.
    *
    * @param languageId the language ID of this mailing subscriptor
    */
    @Override
    public void setLanguageId(java.lang.String languageId) {
        _mailingSubscriptor.setLanguageId(languageId);
    }

    /**
    * Returns the email subject of this mailing subscriptor.
    *
    * @return the email subject of this mailing subscriptor
    */
    @Override
    public java.lang.String getEmailSubject() {
        return _mailingSubscriptor.getEmailSubject();
    }

    /**
    * Sets the email subject of this mailing subscriptor.
    *
    * @param emailSubject the email subject of this mailing subscriptor
    */
    @Override
    public void setEmailSubject(java.lang.String emailSubject) {
        _mailingSubscriptor.setEmailSubject(emailSubject);
    }

    /**
    * Returns the email body of this mailing subscriptor.
    *
    * @return the email body of this mailing subscriptor
    */
    @Override
    public java.lang.String getEmailBody() {
        return _mailingSubscriptor.getEmailBody();
    }

    /**
    * Sets the email body of this mailing subscriptor.
    *
    * @param emailBody the email body of this mailing subscriptor
    */
    @Override
    public void setEmailBody(java.lang.String emailBody) {
        _mailingSubscriptor.setEmailBody(emailBody);
    }

    /**
    * Returns the tokens of this mailing subscriptor.
    *
    * @return the tokens of this mailing subscriptor
    */
    @Override
    public java.lang.String getTokens() {
        return _mailingSubscriptor.getTokens();
    }

    /**
    * Sets the tokens of this mailing subscriptor.
    *
    * @param tokens the tokens of this mailing subscriptor
    */
    @Override
    public void setTokens(java.lang.String tokens) {
        _mailingSubscriptor.setTokens(tokens);
    }

    @Override
    public boolean isNew() {
        return _mailingSubscriptor.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _mailingSubscriptor.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _mailingSubscriptor.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _mailingSubscriptor.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _mailingSubscriptor.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _mailingSubscriptor.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _mailingSubscriptor.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _mailingSubscriptor.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _mailingSubscriptor.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _mailingSubscriptor.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _mailingSubscriptor.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new MailingSubscriptorWrapper((MailingSubscriptor) _mailingSubscriptor.clone());
    }

    @Override
    public int compareTo(MailingSubscriptor mailingSubscriptor) {
        return _mailingSubscriptor.compareTo(mailingSubscriptor);
    }

    @Override
    public int hashCode() {
        return _mailingSubscriptor.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<MailingSubscriptor> toCacheModel() {
        return _mailingSubscriptor.toCacheModel();
    }

    @Override
    public MailingSubscriptor toEscapedModel() {
        return new MailingSubscriptorWrapper(_mailingSubscriptor.toEscapedModel());
    }

    @Override
    public MailingSubscriptor toUnescapedModel() {
        return new MailingSubscriptorWrapper(_mailingSubscriptor.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _mailingSubscriptor.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _mailingSubscriptor.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _mailingSubscriptor.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof MailingSubscriptorWrapper)) {
            return false;
        }

        MailingSubscriptorWrapper mailingSubscriptorWrapper = (MailingSubscriptorWrapper) obj;

        if (Validator.equals(_mailingSubscriptor,
                    mailingSubscriptorWrapper._mailingSubscriptor)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public MailingSubscriptor getWrappedMailingSubscriptor() {
        return _mailingSubscriptor;
    }

    @Override
    public MailingSubscriptor getWrappedModel() {
        return _mailingSubscriptor;
    }

    @Override
    public void resetOriginalValues() {
        _mailingSubscriptor.resetOriginalValues();
    }
}
