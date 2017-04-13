package net.zylk.liferay.portal.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import net.zylk.liferay.portal.model.Category;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Category in entity cache.
 *
 * @author zylk.net
 * @see Category
 * @generated
 */
public class CategoryCacheModel implements CacheModel<Category>, Externalizable {
    public long categoryId;
    public long companyId;
    public long groupId;
    public String name;
    public String description;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{categoryId=");
        sb.append(categoryId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", name=");
        sb.append(name);
        sb.append(", description=");
        sb.append(description);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Category toEntityModel() {
        CategoryImpl categoryImpl = new CategoryImpl();

        categoryImpl.setCategoryId(categoryId);
        categoryImpl.setCompanyId(companyId);
        categoryImpl.setGroupId(groupId);

        if (name == null) {
            categoryImpl.setName(StringPool.BLANK);
        } else {
            categoryImpl.setName(name);
        }

        if (description == null) {
            categoryImpl.setDescription(StringPool.BLANK);
        } else {
            categoryImpl.setDescription(description);
        }

        categoryImpl.resetOriginalValues();

        return categoryImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        categoryId = objectInput.readLong();
        companyId = objectInput.readLong();
        groupId = objectInput.readLong();
        name = objectInput.readUTF();
        description = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(categoryId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(groupId);

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
    }
}
