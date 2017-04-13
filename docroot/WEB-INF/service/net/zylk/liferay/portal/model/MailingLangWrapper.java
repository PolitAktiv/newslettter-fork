package net.zylk.liferay.portal.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MailingLang}.
 * </p>
 *
 * @author zylk.net
 * @see MailingLang
 * @generated
 */
public class MailingLangWrapper implements MailingLang,
    ModelWrapper<MailingLang> {
    private MailingLang _mailingLang;

    public MailingLangWrapper(MailingLang mailingLang) {
        _mailingLang = mailingLang;
    }

    @Override
    public Class<?> getModelClass() {
        return MailingLang.class;
    }

    @Override
    public String getModelClassName() {
        return MailingLang.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("mailingLangId", getMailingLangId());
        attributes.put("mailingId", getMailingId());
        attributes.put("languageId", getLanguageId());
        attributes.put("emailSubjectPre", getEmailSubjectPre());
        attributes.put("emailBodyPre", getEmailBodyPre());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long mailingLangId = (Long) attributes.get("mailingLangId");

        if (mailingLangId != null) {
            setMailingLangId(mailingLangId);
        }

        Long mailingId = (Long) attributes.get("mailingId");

        if (mailingId != null) {
            setMailingId(mailingId);
        }

        String languageId = (String) attributes.get("languageId");

        if (languageId != null) {
            setLanguageId(languageId);
        }

        String emailSubjectPre = (String) attributes.get("emailSubjectPre");

        if (emailSubjectPre != null) {
            setEmailSubjectPre(emailSubjectPre);
        }

        String emailBodyPre = (String) attributes.get("emailBodyPre");

        if (emailBodyPre != null) {
            setEmailBodyPre(emailBodyPre);
        }
    }

    /**
    * Returns the primary key of this mailing lang.
    *
    * @return the primary key of this mailing lang
    */
    @Override
    public long getPrimaryKey() {
        return _mailingLang.getPrimaryKey();
    }

    /**
    * Sets the primary key of this mailing lang.
    *
    * @param primaryKey the primary key of this mailing lang
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _mailingLang.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the mailing lang ID of this mailing lang.
    *
    * @return the mailing lang ID of this mailing lang
    */
    @Override
    public long getMailingLangId() {
        return _mailingLang.getMailingLangId();
    }

    /**
    * Sets the mailing lang ID of this mailing lang.
    *
    * @param mailingLangId the mailing lang ID of this mailing lang
    */
    @Override
    public void setMailingLangId(long mailingLangId) {
        _mailingLang.setMailingLangId(mailingLangId);
    }

    /**
    * Returns the mailing ID of this mailing lang.
    *
    * @return the mailing ID of this mailing lang
    */
    @Override
    public long getMailingId() {
        return _mailingLang.getMailingId();
    }

    /**
    * Sets the mailing ID of this mailing lang.
    *
    * @param mailingId the mailing ID of this mailing lang
    */
    @Override
    public void setMailingId(long mailingId) {
        _mailingLang.setMailingId(mailingId);
    }

    /**
    * Returns the language ID of this mailing lang.
    *
    * @return the language ID of this mailing lang
    */
    @Override
    public java.lang.String getLanguageId() {
        return _mailingLang.getLanguageId();
    }

    /**
    * Sets the language ID of this mailing lang.
    *
    * @param languageId the language ID of this mailing lang
    */
    @Override
    public void setLanguageId(java.lang.String languageId) {
        _mailingLang.setLanguageId(languageId);
    }

    /**
    * Returns the email subject pre of this mailing lang.
    *
    * @return the email subject pre of this mailing lang
    */
    @Override
    public java.lang.String getEmailSubjectPre() {
        return _mailingLang.getEmailSubjectPre();
    }

    /**
    * Sets the email subject pre of this mailing lang.
    *
    * @param emailSubjectPre the email subject pre of this mailing lang
    */
    @Override
    public void setEmailSubjectPre(java.lang.String emailSubjectPre) {
        _mailingLang.setEmailSubjectPre(emailSubjectPre);
    }

    /**
    * Returns the email body pre of this mailing lang.
    *
    * @return the email body pre of this mailing lang
    */
    @Override
    public java.lang.String getEmailBodyPre() {
        return _mailingLang.getEmailBodyPre();
    }

    /**
    * Sets the email body pre of this mailing lang.
    *
    * @param emailBodyPre the email body pre of this mailing lang
    */
    @Override
    public void setEmailBodyPre(java.lang.String emailBodyPre) {
        _mailingLang.setEmailBodyPre(emailBodyPre);
    }

    @Override
    public boolean isNew() {
        return _mailingLang.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _mailingLang.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _mailingLang.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _mailingLang.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _mailingLang.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _mailingLang.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _mailingLang.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _mailingLang.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _mailingLang.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _mailingLang.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _mailingLang.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new MailingLangWrapper((MailingLang) _mailingLang.clone());
    }

    @Override
    public int compareTo(MailingLang mailingLang) {
        return _mailingLang.compareTo(mailingLang);
    }

    @Override
    public int hashCode() {
        return _mailingLang.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<MailingLang> toCacheModel() {
        return _mailingLang.toCacheModel();
    }

    @Override
    public MailingLang toEscapedModel() {
        return new MailingLangWrapper(_mailingLang.toEscapedModel());
    }

    @Override
    public MailingLang toUnescapedModel() {
        return new MailingLangWrapper(_mailingLang.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _mailingLang.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _mailingLang.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _mailingLang.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof MailingLangWrapper)) {
            return false;
        }

        MailingLangWrapper mailingLangWrapper = (MailingLangWrapper) obj;

        if (Validator.equals(_mailingLang, mailingLangWrapper._mailingLang)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public MailingLang getWrappedMailingLang() {
        return _mailingLang;
    }

    @Override
    public MailingLang getWrappedModel() {
        return _mailingLang;
    }

    @Override
    public void resetOriginalValues() {
        _mailingLang.resetOriginalValues();
    }
}
