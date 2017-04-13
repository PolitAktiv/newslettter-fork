package net.zylk.liferay.portal.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import net.zylk.liferay.portal.model.Subscriptor;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Subscriptor in entity cache.
 *
 * @author zylk.net
 * @see Subscriptor
 * @generated
 */
public class SubscriptorCacheModel implements CacheModel<Subscriptor>,
    Externalizable {
    public String uuid;
    public long subscriptorId;
    public long companyId;
    public long groupId;
    public String name;
    public String surname;
    public String email;
    public String languageId;
    public boolean selfSubscribe;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", subscriptorId=");
        sb.append(subscriptorId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", name=");
        sb.append(name);
        sb.append(", surname=");
        sb.append(surname);
        sb.append(", email=");
        sb.append(email);
        sb.append(", languageId=");
        sb.append(languageId);
        sb.append(", selfSubscribe=");
        sb.append(selfSubscribe);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Subscriptor toEntityModel() {
        SubscriptorImpl subscriptorImpl = new SubscriptorImpl();

        if (uuid == null) {
            subscriptorImpl.setUuid(StringPool.BLANK);
        } else {
            subscriptorImpl.setUuid(uuid);
        }

        subscriptorImpl.setSubscriptorId(subscriptorId);
        subscriptorImpl.setCompanyId(companyId);
        subscriptorImpl.setGroupId(groupId);

        if (name == null) {
            subscriptorImpl.setName(StringPool.BLANK);
        } else {
            subscriptorImpl.setName(name);
        }

        if (surname == null) {
            subscriptorImpl.setSurname(StringPool.BLANK);
        } else {
            subscriptorImpl.setSurname(surname);
        }

        if (email == null) {
            subscriptorImpl.setEmail(StringPool.BLANK);
        } else {
            subscriptorImpl.setEmail(email);
        }

        if (languageId == null) {
            subscriptorImpl.setLanguageId(StringPool.BLANK);
        } else {
            subscriptorImpl.setLanguageId(languageId);
        }

        subscriptorImpl.setSelfSubscribe(selfSubscribe);

        subscriptorImpl.resetOriginalValues();

        return subscriptorImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        subscriptorId = objectInput.readLong();
        companyId = objectInput.readLong();
        groupId = objectInput.readLong();
        name = objectInput.readUTF();
        surname = objectInput.readUTF();
        email = objectInput.readUTF();
        languageId = objectInput.readUTF();
        selfSubscribe = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(subscriptorId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(groupId);

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

        if (email == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(email);
        }

        if (languageId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(languageId);
        }

        objectOutput.writeBoolean(selfSubscribe);
    }
}
