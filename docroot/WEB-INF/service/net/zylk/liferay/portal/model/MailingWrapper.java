package net.zylk.liferay.portal.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Mailing}.
 * </p>
 *
 * @author zylk.net
 * @see Mailing
 * @generated
 */
public class MailingWrapper implements Mailing, ModelWrapper<Mailing> {
    private Mailing _mailing;

    public MailingWrapper(Mailing mailing) {
        _mailing = mailing;
    }

    @Override
    public Class<?> getModelClass() {
        return Mailing.class;
    }

    @Override
    public String getModelClassName() {
        return Mailing.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("mailingId", getMailingId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("newsletterId", getNewsletterId());
        attributes.put("newsletterName", getNewsletterName());
        attributes.put("emailFromName", getEmailFromName());
        attributes.put("emailFromAddress", getEmailFromAddress());
        attributes.put("startDate", getStartDate());
        attributes.put("fromDate", getFromDate());
        attributes.put("emailCount", getEmailCount());
        attributes.put("status", getStatus());
        attributes.put("isScheduled", getIsScheduled());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long mailingId = (Long) attributes.get("mailingId");

        if (mailingId != null) {
            setMailingId(mailingId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long newsletterId = (Long) attributes.get("newsletterId");

        if (newsletterId != null) {
            setNewsletterId(newsletterId);
        }

        String newsletterName = (String) attributes.get("newsletterName");

        if (newsletterName != null) {
            setNewsletterName(newsletterName);
        }

        String emailFromName = (String) attributes.get("emailFromName");

        if (emailFromName != null) {
            setEmailFromName(emailFromName);
        }

        String emailFromAddress = (String) attributes.get("emailFromAddress");

        if (emailFromAddress != null) {
            setEmailFromAddress(emailFromAddress);
        }

        Date startDate = (Date) attributes.get("startDate");

        if (startDate != null) {
            setStartDate(startDate);
        }

        Date fromDate = (Date) attributes.get("fromDate");

        if (fromDate != null) {
            setFromDate(fromDate);
        }

        Integer emailCount = (Integer) attributes.get("emailCount");

        if (emailCount != null) {
            setEmailCount(emailCount);
        }

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        Boolean isScheduled = (Boolean) attributes.get("isScheduled");

        if (isScheduled != null) {
            setIsScheduled(isScheduled);
        }
    }

    /**
    * Returns the primary key of this mailing.
    *
    * @return the primary key of this mailing
    */
    @Override
    public long getPrimaryKey() {
        return _mailing.getPrimaryKey();
    }

    /**
    * Sets the primary key of this mailing.
    *
    * @param primaryKey the primary key of this mailing
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _mailing.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the mailing ID of this mailing.
    *
    * @return the mailing ID of this mailing
    */
    @Override
    public long getMailingId() {
        return _mailing.getMailingId();
    }

    /**
    * Sets the mailing ID of this mailing.
    *
    * @param mailingId the mailing ID of this mailing
    */
    @Override
    public void setMailingId(long mailingId) {
        _mailing.setMailingId(mailingId);
    }

    /**
    * Returns the company ID of this mailing.
    *
    * @return the company ID of this mailing
    */
    @Override
    public long getCompanyId() {
        return _mailing.getCompanyId();
    }

    /**
    * Sets the company ID of this mailing.
    *
    * @param companyId the company ID of this mailing
    */
    @Override
    public void setCompanyId(long companyId) {
        _mailing.setCompanyId(companyId);
    }

    /**
    * Returns the group ID of this mailing.
    *
    * @return the group ID of this mailing
    */
    @Override
    public long getGroupId() {
        return _mailing.getGroupId();
    }

    /**
    * Sets the group ID of this mailing.
    *
    * @param groupId the group ID of this mailing
    */
    @Override
    public void setGroupId(long groupId) {
        _mailing.setGroupId(groupId);
    }

    /**
    * Returns the newsletter ID of this mailing.
    *
    * @return the newsletter ID of this mailing
    */
    @Override
    public long getNewsletterId() {
        return _mailing.getNewsletterId();
    }

    /**
    * Sets the newsletter ID of this mailing.
    *
    * @param newsletterId the newsletter ID of this mailing
    */
    @Override
    public void setNewsletterId(long newsletterId) {
        _mailing.setNewsletterId(newsletterId);
    }

    /**
    * Returns the newsletter name of this mailing.
    *
    * @return the newsletter name of this mailing
    */
    @Override
    public java.lang.String getNewsletterName() {
        return _mailing.getNewsletterName();
    }

    /**
    * Sets the newsletter name of this mailing.
    *
    * @param newsletterName the newsletter name of this mailing
    */
    @Override
    public void setNewsletterName(java.lang.String newsletterName) {
        _mailing.setNewsletterName(newsletterName);
    }

    /**
    * Returns the email from name of this mailing.
    *
    * @return the email from name of this mailing
    */
    @Override
    public java.lang.String getEmailFromName() {
        return _mailing.getEmailFromName();
    }

    /**
    * Sets the email from name of this mailing.
    *
    * @param emailFromName the email from name of this mailing
    */
    @Override
    public void setEmailFromName(java.lang.String emailFromName) {
        _mailing.setEmailFromName(emailFromName);
    }

    /**
    * Returns the email from address of this mailing.
    *
    * @return the email from address of this mailing
    */
    @Override
    public java.lang.String getEmailFromAddress() {
        return _mailing.getEmailFromAddress();
    }

    /**
    * Sets the email from address of this mailing.
    *
    * @param emailFromAddress the email from address of this mailing
    */
    @Override
    public void setEmailFromAddress(java.lang.String emailFromAddress) {
        _mailing.setEmailFromAddress(emailFromAddress);
    }

    /**
    * Returns the start date of this mailing.
    *
    * @return the start date of this mailing
    */
    @Override
    public java.util.Date getStartDate() {
        return _mailing.getStartDate();
    }

    /**
    * Sets the start date of this mailing.
    *
    * @param startDate the start date of this mailing
    */
    @Override
    public void setStartDate(java.util.Date startDate) {
        _mailing.setStartDate(startDate);
    }

    /**
    * Returns the from date of this mailing.
    *
    * @return the from date of this mailing
    */
    @Override
    public java.util.Date getFromDate() {
        return _mailing.getFromDate();
    }

    /**
    * Sets the from date of this mailing.
    *
    * @param fromDate the from date of this mailing
    */
    @Override
    public void setFromDate(java.util.Date fromDate) {
        _mailing.setFromDate(fromDate);
    }

    /**
    * Returns the email count of this mailing.
    *
    * @return the email count of this mailing
    */
    @Override
    public int getEmailCount() {
        return _mailing.getEmailCount();
    }

    /**
    * Sets the email count of this mailing.
    *
    * @param emailCount the email count of this mailing
    */
    @Override
    public void setEmailCount(int emailCount) {
        _mailing.setEmailCount(emailCount);
    }

    /**
    * Returns the status of this mailing.
    *
    * @return the status of this mailing
    */
    @Override
    public int getStatus() {
        return _mailing.getStatus();
    }

    /**
    * Sets the status of this mailing.
    *
    * @param status the status of this mailing
    */
    @Override
    public void setStatus(int status) {
        _mailing.setStatus(status);
    }

    /**
    * Returns the is scheduled of this mailing.
    *
    * @return the is scheduled of this mailing
    */
    @Override
    public boolean getIsScheduled() {
        return _mailing.getIsScheduled();
    }

    /**
    * Returns <code>true</code> if this mailing is is scheduled.
    *
    * @return <code>true</code> if this mailing is is scheduled; <code>false</code> otherwise
    */
    @Override
    public boolean isIsScheduled() {
        return _mailing.isIsScheduled();
    }

    /**
    * Sets whether this mailing is is scheduled.
    *
    * @param isScheduled the is scheduled of this mailing
    */
    @Override
    public void setIsScheduled(boolean isScheduled) {
        _mailing.setIsScheduled(isScheduled);
    }

    @Override
    public boolean isNew() {
        return _mailing.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _mailing.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _mailing.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _mailing.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _mailing.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _mailing.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _mailing.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _mailing.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _mailing.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _mailing.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _mailing.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new MailingWrapper((Mailing) _mailing.clone());
    }

    @Override
    public int compareTo(Mailing mailing) {
        return _mailing.compareTo(mailing);
    }

    @Override
    public int hashCode() {
        return _mailing.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<Mailing> toCacheModel() {
        return _mailing.toCacheModel();
    }

    @Override
    public Mailing toEscapedModel() {
        return new MailingWrapper(_mailing.toEscapedModel());
    }

    @Override
    public Mailing toUnescapedModel() {
        return new MailingWrapper(_mailing.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _mailing.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _mailing.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _mailing.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof MailingWrapper)) {
            return false;
        }

        MailingWrapper mailingWrapper = (MailingWrapper) obj;

        if (Validator.equals(_mailing, mailingWrapper._mailing)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Mailing getWrappedMailing() {
        return _mailing;
    }

    @Override
    public Mailing getWrappedModel() {
        return _mailing;
    }

    @Override
    public void resetOriginalValues() {
        _mailing.resetOriginalValues();
    }
}
