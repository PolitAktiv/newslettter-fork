package net.zylk.liferay.portal.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import net.zylk.liferay.portal.service.ClpSerializer;
import net.zylk.liferay.portal.service.MailingLangLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class MailingLangClp extends BaseModelImpl<MailingLang>
    implements MailingLang {
    private long _mailingLangId;
    private long _mailingId;
    private String _languageId;
    private String _emailSubjectPre;
    private String _emailBodyPre;
    private BaseModel<?> _mailingLangRemoteModel;

    public MailingLangClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return MailingLang.class;
    }

    @Override
    public String getModelClassName() {
        return MailingLang.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _mailingLangId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setMailingLangId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _mailingLangId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("mailingLangId", getMailingLangId());
        attributes.put("mailingId", getMailingId());
        attributes.put("languageId", getLanguageId());
        attributes.put("emailSubjectPre", getEmailSubjectPre());
        attributes.put("emailBodyPre", getEmailBodyPre());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long mailingLangId = (Long) attributes.get("mailingLangId");

        if (mailingLangId != null) {
            setMailingLangId(mailingLangId);
        }

        Long mailingId = (Long) attributes.get("mailingId");

        if (mailingId != null) {
            setMailingId(mailingId);
        }

        String languageId = (String) attributes.get("languageId");

        if (languageId != null) {
            setLanguageId(languageId);
        }

        String emailSubjectPre = (String) attributes.get("emailSubjectPre");

        if (emailSubjectPre != null) {
            setEmailSubjectPre(emailSubjectPre);
        }

        String emailBodyPre = (String) attributes.get("emailBodyPre");

        if (emailBodyPre != null) {
            setEmailBodyPre(emailBodyPre);
        }
    }

    @Override
    public long getMailingLangId() {
        return _mailingLangId;
    }

    @Override
    public void setMailingLangId(long mailingLangId) {
        _mailingLangId = mailingLangId;

        if (_mailingLangRemoteModel != null) {
            try {
                Class<?> clazz = _mailingLangRemoteModel.getClass();

                Method method = clazz.getMethod("setMailingLangId", long.class);

                method.invoke(_mailingLangRemoteModel, mailingLangId);
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

        if (_mailingLangRemoteModel != null) {
            try {
                Class<?> clazz = _mailingLangRemoteModel.getClass();

                Method method = clazz.getMethod("setMailingId", long.class);

                method.invoke(_mailingLangRemoteModel, mailingId);
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

        if (_mailingLangRemoteModel != null) {
            try {
                Class<?> clazz = _mailingLangRemoteModel.getClass();

                Method method = clazz.getMethod("setLanguageId", String.class);

                method.invoke(_mailingLangRemoteModel, languageId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEmailSubjectPre() {
        return _emailSubjectPre;
    }

    @Override
    public void setEmailSubjectPre(String emailSubjectPre) {
        _emailSubjectPre = emailSubjectPre;

        if (_mailingLangRemoteModel != null) {
            try {
                Class<?> clazz = _mailingLangRemoteModel.getClass();

                Method method = clazz.getMethod("setEmailSubjectPre",
                        String.class);

                method.invoke(_mailingLangRemoteModel, emailSubjectPre);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEmailBodyPre() {
        return _emailBodyPre;
    }

    @Override
    public void setEmailBodyPre(String emailBodyPre) {
        _emailBodyPre = emailBodyPre;

        if (_mailingLangRemoteModel != null) {
            try {
                Class<?> clazz = _mailingLangRemoteModel.getClass();

                Method method = clazz.getMethod("setEmailBodyPre", String.class);

                method.invoke(_mailingLangRemoteModel, emailBodyPre);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getMailingLangRemoteModel() {
        return _mailingLangRemoteModel;
    }

    public void setMailingLangRemoteModel(BaseModel<?> mailingLangRemoteModel) {
        _mailingLangRemoteModel = mailingLangRemoteModel;
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

        Class<?> remoteModelClass = _mailingLangRemoteModel.getClass();

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

        Object returnValue = method.invoke(_mailingLangRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            MailingLangLocalServiceUtil.addMailingLang(this);
        } else {
            MailingLangLocalServiceUtil.updateMailingLang(this);
        }
    }

    @Override
    public MailingLang toEscapedModel() {
        return (MailingLang) ProxyUtil.newProxyInstance(MailingLang.class.getClassLoader(),
            new Class[] { MailingLang.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        MailingLangClp clone = new MailingLangClp();

        clone.setMailingLangId(getMailingLangId());
        clone.setMailingId(getMailingId());
        clone.setLanguageId(getLanguageId());
        clone.setEmailSubjectPre(getEmailSubjectPre());
        clone.setEmailBodyPre(getEmailBodyPre());

        return clone;
    }

    @Override
    public int compareTo(MailingLang mailingLang) {
        long primaryKey = mailingLang.getPrimaryKey();

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

        if (!(obj instanceof MailingLangClp)) {
            return false;
        }

        MailingLangClp mailingLang = (MailingLangClp) obj;

        long primaryKey = mailingLang.getPrimaryKey();

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
        StringBundler sb = new StringBundler(11);

        sb.append("{mailingLangId=");
        sb.append(getMailingLangId());
        sb.append(", mailingId=");
        sb.append(getMailingId());
        sb.append(", languageId=");
        sb.append(getLanguageId());
        sb.append(", emailSubjectPre=");
        sb.append(getEmailSubjectPre());
        sb.append(", emailBodyPre=");
        sb.append(getEmailBodyPre());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("net.zylk.liferay.portal.model.MailingLang");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>mailingLangId</column-name><column-value><![CDATA[");
        sb.append(getMailingLangId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>mailingId</column-name><column-value><![CDATA[");
        sb.append(getMailingId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>languageId</column-name><column-value><![CDATA[");
        sb.append(getLanguageId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>emailSubjectPre</column-name><column-value><![CDATA[");
        sb.append(getEmailSubjectPre());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>emailBodyPre</column-name><column-value><![CDATA[");
        sb.append(getEmailBodyPre());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
