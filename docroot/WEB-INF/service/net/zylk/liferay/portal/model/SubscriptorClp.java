package net.zylk.liferay.portal.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import net.zylk.liferay.portal.service.ClpSerializer;
import net.zylk.liferay.portal.service.SubscriptorLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class SubscriptorClp extends BaseModelImpl<Subscriptor>
    implements Subscriptor {
    private String _uuid;
    private long _subscriptorId;
    private long _companyId;
    private long _groupId;
    private String _name;
    private String _surname;
    private String _email;
    private String _languageId;
    private boolean _selfSubscribe;
    private BaseModel<?> _subscriptorRemoteModel;

    public SubscriptorClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Subscriptor.class;
    }

    @Override
    public String getModelClassName() {
        return Subscriptor.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _subscriptorId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setSubscriptorId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _subscriptorId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("subscriptorId", getSubscriptorId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("name", getName());
        attributes.put("surname", getSurname());
        attributes.put("email", getEmail());
        attributes.put("languageId", getLanguageId());
        attributes.put("selfSubscribe", getSelfSubscribe());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long subscriptorId = (Long) attributes.get("subscriptorId");

        if (subscriptorId != null) {
            setSubscriptorId(subscriptorId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String surname = (String) attributes.get("surname");

        if (surname != null) {
            setSurname(surname);
        }

        String email = (String) attributes.get("email");

        if (email != null) {
            setEmail(email);
        }

        String languageId = (String) attributes.get("languageId");

        if (languageId != null) {
            setLanguageId(languageId);
        }

        Boolean selfSubscribe = (Boolean) attributes.get("selfSubscribe");

        if (selfSubscribe != null) {
            setSelfSubscribe(selfSubscribe);
        }
    }

    @Override
    public String getUuid() {
        return _uuid;
    }

    @Override
    public void setUuid(String uuid) {
        _uuid = uuid;

        if (_subscriptorRemoteModel != null) {
            try {
                Class<?> clazz = _subscriptorRemoteModel.getClass();

                Method method = clazz.getMethod("setUuid", String.class);

                method.invoke(_subscriptorRemoteModel, uuid);
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

        if (_subscriptorRemoteModel != null) {
            try {
                Class<?> clazz = _subscriptorRemoteModel.getClass();

                Method method = clazz.getMethod("setSubscriptorId", long.class);

                method.invoke(_subscriptorRemoteModel, subscriptorId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_subscriptorRemoteModel != null) {
            try {
                Class<?> clazz = _subscriptorRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_subscriptorRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_subscriptorRemoteModel != null) {
            try {
                Class<?> clazz = _subscriptorRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_subscriptorRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;

        if (_subscriptorRemoteModel != null) {
            try {
                Class<?> clazz = _subscriptorRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_subscriptorRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSurname() {
        return _surname;
    }

    @Override
    public void setSurname(String surname) {
        _surname = surname;

        if (_subscriptorRemoteModel != null) {
            try {
                Class<?> clazz = _subscriptorRemoteModel.getClass();

                Method method = clazz.getMethod("setSurname", String.class);

                method.invoke(_subscriptorRemoteModel, surname);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEmail() {
        return _email;
    }

    @Override
    public void setEmail(String email) {
        _email = email;

        if (_subscriptorRemoteModel != null) {
            try {
                Class<?> clazz = _subscriptorRemoteModel.getClass();

                Method method = clazz.getMethod("setEmail", String.class);

                method.invoke(_subscriptorRemoteModel, email);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getLanguageId() {
        return _languageId;
    }

    @Override
    public void setLanguageId(String languageId) {
        _languageId = languageId;

        if (_subscriptorRemoteModel != null) {
            try {
                Class<?> clazz = _subscriptorRemoteModel.getClass();

                Method method = clazz.getMethod("setLanguageId", String.class);

                method.invoke(_subscriptorRemoteModel, languageId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getSelfSubscribe() {
        return _selfSubscribe;
    }

    @Override
    public boolean isSelfSubscribe() {
        return _selfSubscribe;
    }

    @Override
    public void setSelfSubscribe(boolean selfSubscribe) {
        _selfSubscribe = selfSubscribe;

        if (_subscriptorRemoteModel != null) {
            try {
                Class<?> clazz = _subscriptorRemoteModel.getClass();

                Method method = clazz.getMethod("setSelfSubscribe",
                        boolean.class);

                method.invoke(_subscriptorRemoteModel, selfSubscribe);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public java.lang.String getFullName() {
        try {
            String methodName = "getFullName";

            Class<?>[] parameterTypes = new Class<?>[] {  };

            Object[] parameterValues = new Object[] {  };

            java.lang.String returnObj = (java.lang.String) invokeOnRemoteModel(methodName,
                    parameterTypes, parameterValues);

            return returnObj;
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    public BaseModel<?> getSubscriptorRemoteModel() {
        return _subscriptorRemoteModel;
    }

    public void setSubscriptorRemoteModel(BaseModel<?> subscriptorRemoteModel) {
        _subscriptorRemoteModel = subscriptorRemoteModel;
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

        Class<?> remoteModelClass = _subscriptorRemoteModel.getClass();

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

        Object returnValue = method.invoke(_subscriptorRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            SubscriptorLocalServiceUtil.addSubscriptor(this);
        } else {
            SubscriptorLocalServiceUtil.updateSubscriptor(this);
        }
    }

    @Override
    public Subscriptor toEscapedModel() {
        return (Subscriptor) ProxyUtil.newProxyInstance(Subscriptor.class.getClassLoader(),
            new Class[] { Subscriptor.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        SubscriptorClp clone = new SubscriptorClp();

        clone.setUuid(getUuid());
        clone.setSubscriptorId(getSubscriptorId());
        clone.setCompanyId(getCompanyId());
        clone.setGroupId(getGroupId());
        clone.setName(getName());
        clone.setSurname(getSurname());
        clone.setEmail(getEmail());
        clone.setLanguageId(getLanguageId());
        clone.setSelfSubscribe(getSelfSubscribe());

        return clone;
    }

    @Override
    public int compareTo(Subscriptor subscriptor) {
        long primaryKey = subscriptor.getPrimaryKey();

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

        if (!(obj instanceof SubscriptorClp)) {
            return false;
        }

        SubscriptorClp subscriptor = (SubscriptorClp) obj;

        long primaryKey = subscriptor.getPrimaryKey();

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
        StringBundler sb = new StringBundler(19);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", subscriptorId=");
        sb.append(getSubscriptorId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", surname=");
        sb.append(getSurname());
        sb.append(", email=");
        sb.append(getEmail());
        sb.append(", languageId=");
        sb.append(getLanguageId());
        sb.append(", selfSubscribe=");
        sb.append(getSelfSubscribe());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(31);

        sb.append("<model><model-name>");
        sb.append("net.zylk.liferay.portal.model.Subscriptor");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>subscriptorId</column-name><column-value><![CDATA[");
        sb.append(getSubscriptorId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>surname</column-name><column-value><![CDATA[");
        sb.append(getSurname());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>email</column-name><column-value><![CDATA[");
        sb.append(getEmail());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>languageId</column-name><column-value><![CDATA[");
        sb.append(getLanguageId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>selfSubscribe</column-name><column-value><![CDATA[");
        sb.append(getSelfSubscribe());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
