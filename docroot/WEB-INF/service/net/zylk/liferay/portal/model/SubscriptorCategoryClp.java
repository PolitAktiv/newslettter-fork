package net.zylk.liferay.portal.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import net.zylk.liferay.portal.service.ClpSerializer;
import net.zylk.liferay.portal.service.SubscriptorCategoryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class SubscriptorCategoryClp extends BaseModelImpl<SubscriptorCategory>
    implements SubscriptorCategory {
    private long _subscriptorCategoryId;
    private long _subscriptorId;
    private long _categoryId;
    private BaseModel<?> _subscriptorCategoryRemoteModel;

    public SubscriptorCategoryClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return SubscriptorCategory.class;
    }

    @Override
    public String getModelClassName() {
        return SubscriptorCategory.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _subscriptorCategoryId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setSubscriptorCategoryId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _subscriptorCategoryId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("subscriptorCategoryId", getSubscriptorCategoryId());
        attributes.put("subscriptorId", getSubscriptorId());
        attributes.put("categoryId", getCategoryId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long subscriptorCategoryId = (Long) attributes.get(
                "subscriptorCategoryId");

        if (subscriptorCategoryId != null) {
            setSubscriptorCategoryId(subscriptorCategoryId);
        }

        Long subscriptorId = (Long) attributes.get("subscriptorId");

        if (subscriptorId != null) {
            setSubscriptorId(subscriptorId);
        }

        Long categoryId = (Long) attributes.get("categoryId");

        if (categoryId != null) {
            setCategoryId(categoryId);
        }
    }

    @Override
    public long getSubscriptorCategoryId() {
        return _subscriptorCategoryId;
    }

    @Override
    public void setSubscriptorCategoryId(long subscriptorCategoryId) {
        _subscriptorCategoryId = subscriptorCategoryId;

        if (_subscriptorCategoryRemoteModel != null) {
            try {
                Class<?> clazz = _subscriptorCategoryRemoteModel.getClass();

                Method method = clazz.getMethod("setSubscriptorCategoryId",
                        long.class);

                method.invoke(_subscriptorCategoryRemoteModel,
                    subscriptorCategoryId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getSubscriptorId() {
        return _subscriptorId;
    }

    @Override
    public void setSubscriptorId(long subscriptorId) {
        _subscriptorId = subscriptorId;

        if (_subscriptorCategoryRemoteModel != null) {
            try {
                Class<?> clazz = _subscriptorCategoryRemoteModel.getClass();

                Method method = clazz.getMethod("setSubscriptorId", long.class);

                method.invoke(_subscriptorCategoryRemoteModel, subscriptorId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCategoryId() {
        return _categoryId;
    }

    @Override
    public void setCategoryId(long categoryId) {
        _categoryId = categoryId;

        if (_subscriptorCategoryRemoteModel != null) {
            try {
                Class<?> clazz = _subscriptorCategoryRemoteModel.getClass();

                Method method = clazz.getMethod("setCategoryId", long.class);

                method.invoke(_subscriptorCategoryRemoteModel, categoryId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getSubscriptorCategoryRemoteModel() {
        return _subscriptorCategoryRemoteModel;
    }

    public void setSubscriptorCategoryRemoteModel(
        BaseModel<?> subscriptorCategoryRemoteModel) {
        _subscriptorCategoryRemoteModel = subscriptorCategoryRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _subscriptorCategoryRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_subscriptorCategoryRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            SubscriptorCategoryLocalServiceUtil.addSubscriptorCategory(this);
        } else {
            SubscriptorCategoryLocalServiceUtil.updateSubscriptorCategory(this);
        }
    }

    @Override
    public SubscriptorCategory toEscapedModel() {
        return (SubscriptorCategory) ProxyUtil.newProxyInstance(SubscriptorCategory.class.getClassLoader(),
            new Class[] { SubscriptorCategory.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        SubscriptorCategoryClp clone = new SubscriptorCategoryClp();

        clone.setSubscriptorCategoryId(getSubscriptorCategoryId());
        clone.setSubscriptorId(getSubscriptorId());
        clone.setCategoryId(getCategoryId());

        return clone;
    }

    @Override
    public int compareTo(SubscriptorCategory subscriptorCategory) {
        long primaryKey = subscriptorCategory.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof SubscriptorCategoryClp)) {
            return false;
        }

        SubscriptorCategoryClp subscriptorCategory = (SubscriptorCategoryClp) obj;

        long primaryKey = subscriptorCategory.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{subscriptorCategoryId=");
        sb.append(getSubscriptorCategoryId());
        sb.append(", subscriptorId=");
        sb.append(getSubscriptorId());
        sb.append(", categoryId=");
        sb.append(getCategoryId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("net.zylk.liferay.portal.model.SubscriptorCategory");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>subscriptorCategoryId</column-name><column-value><![CDATA[");
        sb.append(getSubscriptorCategoryId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>subscriptorId</column-name><column-value><![CDATA[");
        sb.append(getSubscriptorId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>categoryId</column-name><column-value><![CDATA[");
        sb.append(getCategoryId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
