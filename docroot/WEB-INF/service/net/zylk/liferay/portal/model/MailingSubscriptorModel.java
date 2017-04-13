package net.zylk.liferay.portal.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the MailingSubscriptor service. Represents a row in the &quot;ZN_MailingSubscriptor&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link net.zylk.liferay.portal.model.impl.MailingSubscriptorModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link net.zylk.liferay.portal.model.impl.MailingSubscriptorImpl}.
 * </p>
 *
 * @author zylk.net
 * @see MailingSubscriptor
 * @see net.zylk.liferay.portal.model.impl.MailingSubscriptorImpl
 * @see net.zylk.liferay.portal.model.impl.MailingSubscriptorModelImpl
 * @generated
 */
public interface MailingSubscriptorModel extends BaseModel<MailingSubscriptor> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a mailing subscriptor model instance should use the {@link MailingSubscriptor} interface instead.
     */

    /**
     * Returns the primary key of this mailing subscriptor.
     *
     * @return the primary key of this mailing subscriptor
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this mailing subscriptor.
     *
     * @param primaryKey the primary key of this mailing subscriptor
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the mailing subscriptor ID of this mailing subscriptor.
     *
     * @return the mailing subscriptor ID of this mailing subscriptor
     */
    public long getMailingSubscriptorId();

    /**
     * Sets the mailing subscriptor ID of this mailing subscriptor.
     *
     * @param mailingSubscriptorId the mailing subscriptor ID of this mailing subscriptor
     */
    public void setMailingSubscriptorId(long mailingSubscriptorId);

    /**
     * Returns the mailing ID of this mailing subscriptor.
     *
     * @return the mailing ID of this mailing subscriptor
     */
    public long getMailingId();

    /**
     * Sets the mailing ID of this mailing subscriptor.
     *
     * @param mailingId the mailing ID of this mailing subscriptor
     */
    public void setMailingId(long mailingId);

    /**
     * Returns the email of this mailing subscriptor.
     *
     * @return the email of this mailing subscriptor
     */
    @AutoEscape
    public String getEmail();

    /**
     * Sets the email of this mailing subscriptor.
     *
     * @param email the email of this mailing subscriptor
     */
    public void setEmail(String email);

    /**
     * Returns the name of this mailing subscriptor.
     *
     * @return the name of this mailing subscriptor
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this mailing subscriptor.
     *
     * @param name the name of this mailing subscriptor
     */
    public void setName(String name);

    /**
     * Returns the surname of this mailing subscriptor.
     *
     * @return the surname of this mailing subscriptor
     */
    @AutoEscape
    public String getSurname();

    /**
     * Sets the surname of this mailing subscriptor.
     *
     * @param surname the surname of this mailing subscriptor
     */
    public void setSurname(String surname);

    /**
     * Returns the language ID of this mailing subscriptor.
     *
     * @return the language ID of this mailing subscriptor
     */
    @AutoEscape
    public String getLanguageId();

    /**
     * Sets the language ID of this mailing subscriptor.
     *
     * @param languageId the language ID of this mailing subscriptor
     */
    public void setLanguageId(String languageId);

    /**
     * Returns the email subject of this mailing subscriptor.
     *
     * @return the email subject of this mailing subscriptor
     */
    @AutoEscape
    public String getEmailSubject();

    /**
     * Sets the email subject of this mailing subscriptor.
     *
     * @param emailSubject the email subject of this mailing subscriptor
     */
    public void setEmailSubject(String emailSubject);

    /**
     * Returns the email body of this mailing subscriptor.
     *
     * @return the email body of this mailing subscriptor
     */
    @AutoEscape
    public String getEmailBody();

    /**
     * Sets the email body of this mailing subscriptor.
     *
     * @param emailBody the email body of this mailing subscriptor
     */
    public void setEmailBody(String emailBody);

    /**
     * Returns the tokens of this mailing subscriptor.
     *
     * @return the tokens of this mailing subscriptor
     */
    @AutoEscape
    public String getTokens();

    /**
     * Sets the tokens of this mailing subscriptor.
     *
     * @param tokens the tokens of this mailing subscriptor
     */
    public void setTokens(String tokens);

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

    @Override
    public Object clone();

    @Override
    public int compareTo(MailingSubscriptor mailingSubscriptor);

    @Override
    public int hashCode();

    @Override
    public CacheModel<MailingSubscriptor> toCacheModel();

    @Override
    public MailingSubscriptor toEscapedModel();

    @Override
    public MailingSubscriptor toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
