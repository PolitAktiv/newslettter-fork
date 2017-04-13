package net.zylk.liferay.portal.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import net.zylk.liferay.portal.model.MailingSubscriptor;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing MailingSubscriptor in entity cache.
 *
 * @author zylk.net
 * @see MailingSubscriptor
 * @generated
 */
public class MailingSubscriptorCacheModel implements CacheModel<MailingSubscriptor>,
    Externalizable {
    public long mailingSubscriptorId;
    public long mailingId;
    public String email;
    public String name;
    public String surname;
    public String languageId;
    public String emailSubject;
    public String emailBody;
    public String tokens;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{mailingSubscriptorId=");
        sb.append(mailingSubscriptorId);
        sb.append(", mailingId=");
        sb.append(mailingId);
        sb.append(", email=");
        sb.append(email);
        sb.append(", name=");
        sb.append(name);
        sb.append(", surname=");
        sb.append(surname);
        sb.append(", languageId=");
        sb.append(languageId);
        sb.append(", emailSubject=");
        sb.append(emailSubject);
        sb.append(", emailBody=");
        sb.append(emailBody);
        sb.append(", tokens=");
        sb.append(tokens);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public MailingSubscriptor toEntityModel() {
        MailingSubscriptorImpl mailingSubscriptorImpl = new MailingSubscriptorImpl();

        mailingSubscriptorImpl.setMailingSubscriptorId(mailingSubscriptorId);
        mailingSubscriptorImpl.setMailingId(mailingId);

        if (email == null) {
            mailingSubscriptorImpl.setEmail(StringPool.BLANK);
        } else {
            mailingSubscriptorImpl.setEmail(email);
        }

        if (name == null) {
            mailingSubscriptorImpl.setName(StringPool.BLANK);
        } else {
            mailingSubscriptorImpl.setName(name);
        }

        if (surname == null) {
            mailingSubscriptorImpl.setSurname(StringPool.BLANK);
        } else {
            mailingSubscriptorImpl.setSurname(surname);
        }

        if (languageId == null) {
            mailingSubscriptorImpl.setLanguageId(StringPool.BLANK);
        } else {
            mailingSubscriptorImpl.setLanguageId(languageId);
        }

        if (emailSubject == null) {
            mailingSubscriptorImpl.setEmailSubject(StringPool.BLANK);
        } else {
            mailingSubscriptorImpl.setEmailSubject(emailSubject);
        }

        if (emailBody == null) {
            mailingSubscriptorImpl.setEmailBody(StringPool.BLANK);
        } else {
            mailingSubscriptorImpl.setEmailBody(emailBody);
        }

        if (tokens == null) {
            mailingSubscriptorImpl.setTokens(StringPool.BLANK);
        } else {
            mailingSubscriptorImpl.setTokens(tokens);
        }

        mailingSubscriptorImpl.resetOriginalValues();

        return mailingSubscriptorImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        mailingSubscriptorId = objectInput.readLong();
        mailingId = objectInput.readLong();
        email = objectInput.readUTF();
        name = objectInput.readUTF();
        surname = objectInput.readUTF();
        languageId = objectInput.readUTF();
        emailSubject = objectInput.readUTF();
        emailBody = objectInput.readUTF();
        tokens = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(mailingSubscriptorId);
        objectOutput.writeLong(mailingId);

        if (email == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(email);
        }

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (surname == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(surname);
        }

        if (languageId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(languageId);
        }

        if (emailSubject == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(emailSubject);
        }

        if (emailBody == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(emailBody);
        }

        if (tokens == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(tokens);
        }
    }
}
