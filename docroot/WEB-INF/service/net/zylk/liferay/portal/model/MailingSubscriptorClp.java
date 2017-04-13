package net.zylk.liferay.portal.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import net.zylk.liferay.portal.service.ClpSerializer;
import net.zylk.liferay.portal.service.MailingSubscriptorLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class MailingSubscriptorClp extends BaseModelImpl<MailingSubscriptor>
    implements MailingSubscriptor {
    private long _mailingSubscriptorId;
    private long _mailingId;
    private String _email;
    private String _name;
    private String _surname;
    private String _languageId;
    private String _emailSubject;
    private String _emailBody;
    private String _tokens;
    private BaseModel<?> _mailingSubscriptorRemoteModel;

    public MailingSubscriptorClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return MailingSubscriptor.class;
    }

    @Override
    public String getModelClassName() {
        return MailingSubscriptor.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _mailingSubscriptorId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setMailingSubscriptorId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _mailingSubscriptorId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("mailingSubscriptorId", getMailingSubscriptorId());
        attributes.put("mailingId", getMailingId());
        attributes.put("email", getEmail());
        attributes.put("name", getName());
        attributes.put("surname", getSurname());
        attributes.put("languageId", getLanguageId());
        attributes.put("emailSubject", getEmailSubject());
        attributes.put("emailBody", getEmailBody());
        attributes.put("tokens", getTokens());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long mailingSubscriptorId = (Long) attributes.get(
                "mailingSubscriptorId");

        if (mailingSubscriptorId != null) {
            setMailingSubscriptorId(mailingSubscriptorId);
        }

        Long mailingId = (Long) attributes.get("mailingId");

        if (mailingId != null) {
            setMailingId(mailingId);
        }

        String email = (String) attributes.get("email");

        if (email != null) {
            setEmail(email);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String surname = (String) attributes.get("surname");

        if (surname != null) {
            setSurname(surname);
        }

        String languageId = (String) attributes.get("languageId");

        if (languageId != null) {
            setLanguageId(languageId);
        }

        String emailSubject = (String) attributes.get("emailSubject");

        if (emailSubject != null) {
            setEmailSubject(emailSubject);
        }

        String emailBody = (String) attributes.get("emailBody");

        if (emailBody != null) {
            setEmailBody(emailBody);
        }

        String tokens = (String) attributes.get("tokens");

        if (tokens != null) {
            setTokens(tokens);
        }
    }

    @Override
    public long getMailingSubscriptorId() {
        return _mailingSubscriptorId;
    }

    @Override
    public void setMailingSubscriptorId(long mailingSubscriptorId) {
        _mailingSubscriptorId = mailingSubscriptorId;

        if (_mailingSubscriptorRemoteModel != null) {
            try {
                Class<?> clazz = _mailingSubscriptorRemoteModel.getClass();

                Method method = clazz.getMethod("setMailingSubscriptorId",
                        long.class);

                method.invoke(_mailingSubscriptorRemoteModel,
                    mailingSubscriptorId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getMailingId() {
        return _mailingId;
    }

    @Override
    public void setMailingId(long mailingId) {
        _mailingId = mailingId;

        if (_mailingSubscriptorRemoteModel != null) {
            try {
                Class<?> clazz = _mailingSubscriptorRemoteModel.getClass();

                Method method = clazz.getMethod("setMailingId", long.class);

                method.invoke(_mailingSubscriptorRemoteModel, mailingId);
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

        if (_mailingSubscriptorRemoteModel != null) {
            try {
                Class<?> clazz = _mailingSubscriptorRemoteModel.getClass();

                Method method = clazz.getMethod("setEmail", String.class);

                method.invoke(_mailingSubscriptorRemoteModel, email);
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

        if (_mailingSubscriptorRemoteModel != null) {
            try {
                Class<?> clazz = _mailingSubscriptorRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_mailingSubscriptorRemoteModel, name);
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

        if (_mailingSubscriptorRemoteModel != null) {
            try {
                Class<?> clazz = _mailingSubscriptorRemoteModel.getClass();

                Method method = clazz.getMethod("setSurname", String.class);

                method.invoke(_mailingSubscriptorRemoteModel, surname);
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

        if (_mailingSubscriptorRemoteModel != null) {
            try {
                Class<?> clazz = _mailingSubscriptorRemoteModel.getClass();

                Method method = clazz.getMethod("setLanguageId", String.class);

                method.invoke(_mailingSubscriptorRemoteModel, languageId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEmailSubject() {
        return _emailSubject;
    }

    @Override
    public void setEmailSubject(String emailSubject) {
        _emailSubject = emailSubject;

        if (_mailingSubscriptorRemoteModel != null) {
            try {
                Class<?> clazz = _mailingSubscriptorRemoteModel.getClass();

                Method method = clazz.getMethod("setEmailSubject", String.class);

                method.invoke(_mailingSubscriptorRemoteModel, emailSubject);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEmailBody() {
        return _emailBody;
    }

    @Override
    public void setEmailBody(String emailBody) {
        _emailBody = emailBody;

        if (_mailingSubscriptorRemoteModel != null) {
            try {
                Class<?> clazz = _mailingSubscriptorRemoteModel.getClass();

                Method method = clazz.getMethod("setEmailBody", String.class);

                method.invoke(_mailingSubscriptorRemoteModel, emailBody);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTokens() {
        return _tokens;
    }

    @Override
    public void setTokens(String tokens) {
        _tokens = tokens;

        if (_mailingSubscriptorRemoteModel != null) {
            try {
                Class<?> clazz = _mailingSubscriptorRemoteModel.getClass();

                Method method = clazz.getMethod("setTokens", String.class);

                method.invoke(_mailingSubscriptorRemoteModel, tokens);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getMailingSubscriptorRemoteModel() {
        return _mailingSubscriptorRemoteModel;
    }

    public void setMailingSubscriptorRemoteModel(
        BaseModel<?> mailingSubscriptorRemoteModel) {
        _mailingSubscriptorRemoteModel = mailingSubscriptorRemoteModel;
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

        Class<?> remoteModelClass = _mailingSubscriptorRemoteModel.getClass();

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

        Object returnValue = method.invoke(_mailingSubscriptorRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            MailingSubscriptorLocalServiceUtil.addMailingSubscriptor(this);
        } else {
            MailingSubscriptorLocalServiceUtil.updateMailingSubscriptor(this);
        }
    }

    @Override
    public MailingSubscriptor toEscapedModel() {
        return (MailingSubscriptor) ProxyUtil.newProxyInstance(MailingSubscriptor.class.getClassLoader(),
            new Class[] { MailingSubscriptor.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        MailingSubscriptorClp clone = new MailingSubscriptorClp();

        clone.setMailingSubscriptorId(getMailingSubscriptorId());
        clone.setMailingId(getMailingId());
        clone.setEmail(getEmail());
        clone.setName(getName());
        clone.setSurname(getSurname());
        clone.setLanguageId(getLanguageId());
        clone.setEmailSubject(getEmailSubject());
        clone.setEmailBody(getEmailBody());
        clone.setTokens(getTokens());

        return clone;
    }

    @Override
    public int compareTo(MailingSubscriptor mailingSubscriptor) {
        long primaryKey = mailingSubscriptor.getPrimaryKey();

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

        if (!(obj instanceof MailingSubscriptorClp)) {
            return false;
        }

        MailingSubscriptorClp mailingSubscriptor = (MailingSubscriptorClp) obj;

        long primaryKey = mailingSubscriptor.getPrimaryKey();

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

        sb.append("{mailingSubscriptorId=");
        sb.append(getMailingSubscriptorId());
        sb.append(", mailingId=");
        sb.append(getMailingId());
        sb.append(", email=");
        sb.append(getEmail());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", surname=");
        sb.append(getSurname());
        sb.append(", languageId=");
        sb.append(getLanguageId());
        sb.append(", emailSubject=");
        sb.append(getEmailSubject());
        sb.append(", emailBody=");
        sb.append(getEmailBody());
        sb.append(", tokens=");
        sb.append(getTokens());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(31);

        sb.append("<model><model-name>");
        sb.append("net.zylk.liferay.portal.model.MailingSubscriptor");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>mailingSubscriptorId</column-name><column-value><![CDATA[");
        sb.append(getMailingSubscriptorId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>mailingId</column-name><column-value><![CDATA[");
        sb.append(getMailingId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>email</column-name><column-value><![CDATA[");
        sb.append(getEmail());
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
            "<column><column-name>languageId</column-name><column-value><![CDATA[");
        sb.append(getLanguageId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>emailSubject</column-name><column-value><![CDATA[");
        sb.append(getEmailSubject());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>emailBody</column-name><column-value><![CDATA[");
        sb.append(getEmailBody());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tokens</column-name><column-value><![CDATA[");
        sb.append(getTokens());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
