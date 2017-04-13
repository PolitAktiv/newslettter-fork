package net.zylk.liferay.portal.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import net.zylk.liferay.portal.model.SubscriptorCategory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SubscriptorCategory in entity cache.
 *
 * @author zylk.net
 * @see SubscriptorCategory
 * @generated
 */
public class SubscriptorCategoryCacheModel implements CacheModel<SubscriptorCategory>,
    Externalizable {
    public long subscriptorCategoryId;
    public long subscriptorId;
    public long categoryId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{subscriptorCategoryId=");
        sb.append(subscriptorCategoryId);
        sb.append(", subscriptorId=");
        sb.append(subscriptorId);
        sb.append(", categoryId=");
        sb.append(categoryId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public SubscriptorCategory toEntityModel() {
        SubscriptorCategoryImpl subscriptorCategoryImpl = new SubscriptorCategoryImpl();

        subscriptorCategoryImpl.setSubscriptorCategoryId(subscriptorCategoryId);
        subscriptorCategoryImpl.setSubscriptorId(subscriptorId);
        subscriptorCategoryImpl.setCategoryId(categoryId);

        subscriptorCategoryImpl.resetOriginalValues();

        return subscriptorCategoryImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        subscriptorCategoryId = objectInput.readLong();
        subscriptorId = objectInput.readLong();
        categoryId = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(subscriptorCategoryId);
        objectOutput.writeLong(subscriptorId);
        objectOutput.writeLong(categoryId);
    }
}
