package net.zylk.liferay.portal.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import net.zylk.liferay.portal.model.Newsletter;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Newsletter in entity cache.
 *
 * @author zylk.net
 * @see Newsletter
 * @generated
 */
public class NewsletterCacheModel implements CacheModel<Newsletter>,
    Externalizable {
    public long newsletterId;
    public long companyId;
    public long groupId;
    public long createDate;
    public long modifiedDate;
    public String name;
    public String description;
    public long categoryId;
    public String subject;
    public String articleId;
    public long articleGroupId;
    public boolean schedulerActive;
    public int schedulerType;
    public long schedulerDate;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(29);

        sb.append("{newsletterId=");
        sb.append(newsletterId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", name=");
        sb.append(name);
        sb.append(", description=");
        sb.append(description);
        sb.append(", categoryId=");
        sb.append(categoryId);
        sb.append(", subject=");
        sb.append(subject);
        sb.append(", articleId=");
        sb.append(articleId);
        sb.append(", articleGroupId=");
        sb.append(articleGroupId);
        sb.append(", schedulerActive=");
        sb.append(schedulerActive);
        sb.append(", schedulerType=");
        sb.append(schedulerType);
        sb.append(", schedulerDate=");
        sb.append(schedulerDate);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Newsletter toEntityModel() {
        NewsletterImpl newsletterImpl = new NewsletterImpl();

        newsletterImpl.setNewsletterId(newsletterId);
        newsletterImpl.setCompanyId(companyId);
        newsletterImpl.setGroupId(groupId);

        if (createDate == Long.MIN_VALUE) {
            newsletterImpl.setCreateDate(null);
        } else {
            newsletterImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            newsletterImpl.setModifiedDate(null);
        } else {
            newsletterImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (name == null) {
            newsletterImpl.setName(StringPool.BLANK);
        } else {
            newsletterImpl.setName(name);
        }

        if (description == null) {
            newsletterImpl.setDescription(StringPool.BLANK);
        } else {
            newsletterImpl.setDescription(description);
        }

        newsletterImpl.setCategoryId(categoryId);

        if (subject == null) {
            newsletterImpl.setSubject(StringPool.BLANK);
        } else {
            newsletterImpl.setSubject(subject);
        }

        if (articleId == null) {
            newsletterImpl.setArticleId(StringPool.BLANK);
        } else {
            newsletterImpl.setArticleId(articleId);
        }

        newsletterImpl.setArticleGroupId(articleGroupId);
        newsletterImpl.setSchedulerActive(schedulerActive);
        newsletterImpl.setSchedulerType(schedulerType);

        if (schedulerDate == Long.MIN_VALUE) {
            newsletterImpl.setSchedulerDate(null);
        } else {
            newsletterImpl.setSchedulerDate(new Date(schedulerDate));
        }

        newsletterImpl.resetOriginalValues();

        return newsletterImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        newsletterId = objectInput.readLong();
        companyId = objectInput.readLong();
        groupId = objectInput.readLong();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        name = objectInput.readUTF();
        description = objectInput.readUTF();
        categoryId = objectInput.readLong();
        subject = objectInput.readUTF();
        articleId = objectInput.readUTF();
        articleGroupId = objectInput.readLong();
        schedulerActive = objectInput.readBoolean();
        schedulerType = objectInput.readInt();
        schedulerDate = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(newsletterId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        objectOutput.writeLong(categoryId);

        if (subject == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(subject);
        }

        if (articleId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(articleId);
        }

        objectOutput.writeLong(articleGroupId);
        objectOutput.writeBoolean(schedulerActive);
        objectOutput.writeInt(schedulerType);
        objectOutput.writeLong(schedulerDate);
    }
}
