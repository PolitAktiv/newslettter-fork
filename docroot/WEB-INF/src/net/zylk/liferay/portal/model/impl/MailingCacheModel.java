package net.zylk.liferay.portal.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import net.zylk.liferay.portal.model.Mailing;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Mailing in entity cache.
 *
 * @author zylk.net
 * @see Mailing
 * @generated
 */
public class MailingCacheModel implements CacheModel<Mailing>, Externalizable {
    public long mailingId;
    public long companyId;
    public long groupId;
    public long newsletterId;
    public String newsletterName;
    public String emailFromName;
    public String emailFromAddress;
    public long startDate;
    public long fromDate;
    public int emailCount;
    public int status;
    public boolean isScheduled;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(25);

        sb.append("{mailingId=");
        sb.append(mailingId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", newsletterId=");
        sb.append(newsletterId);
        sb.append(", newsletterName=");
        sb.append(newsletterName);
        sb.append(", emailFromName=");
        sb.append(emailFromName);
        sb.append(", emailFromAddress=");
        sb.append(emailFromAddress);
        sb.append(", startDate=");
        sb.append(startDate);
        sb.append(", fromDate=");
        sb.append(fromDate);
        sb.append(", emailCount=");
        sb.append(emailCount);
        sb.append(", status=");
        sb.append(status);
        sb.append(", isScheduled=");
        sb.append(isScheduled);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Mailing toEntityModel() {
        MailingImpl mailingImpl = new MailingImpl();

        mailingImpl.setMailingId(mailingId);
        mailingImpl.setCompanyId(companyId);
        mailingImpl.setGroupId(groupId);
        mailingImpl.setNewsletterId(newsletterId);

        if (newsletterName == null) {
            mailingImpl.setNewsletterName(StringPool.BLANK);
        } else {
            mailingImpl.setNewsletterName(newsletterName);
        }

        if (emailFromName == null) {
            mailingImpl.setEmailFromName(StringPool.BLANK);
        } else {
            mailingImpl.setEmailFromName(emailFromName);
        }

        if (emailFromAddress == null) {
            mailingImpl.setEmailFromAddress(StringPool.BLANK);
        } else {
            mailingImpl.setEmailFromAddress(emailFromAddress);
        }

        if (startDate == Long.MIN_VALUE) {
            mailingImpl.setStartDate(null);
        } else {
            mailingImpl.setStartDate(new Date(startDate));
        }

        if (fromDate == Long.MIN_VALUE) {
            mailingImpl.setFromDate(null);
        } else {
            mailingImpl.setFromDate(new Date(fromDate));
        }

        mailingImpl.setEmailCount(emailCount);
        mailingImpl.setStatus(status);
        mailingImpl.setIsScheduled(isScheduled);

        mailingImpl.resetOriginalValues();

        return mailingImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        mailingId = objectInput.readLong();
        companyId = objectInput.readLong();
        groupId = objectInput.readLong();
        newsletterId = objectInput.readLong();
        newsletterName = objectInput.readUTF();
        emailFromName = objectInput.readUTF();
        emailFromAddress = objectInput.readUTF();
        startDate = objectInput.readLong();
        fromDate = objectInput.readLong();
        emailCount = objectInput.readInt();
        status = objectInput.readInt();
        isScheduled = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(mailingId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(newsletterId);

        if (newsletterName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(newsletterName);
        }

        if (emailFromName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(emailFromName);
        }

        if (emailFromAddress == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(emailFromAddress);
        }

        objectOutput.writeLong(startDate);
        objectOutput.writeLong(fromDate);
        objectOutput.writeInt(emailCount);
        objectOutput.writeInt(status);
        objectOutput.writeBoolean(isScheduled);
    }
}
