package net.zylk.liferay.portal.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import net.zylk.liferay.portal.service.ClpSerializer;
import net.zylk.liferay.portal.service.MailingLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class MailingClp extends BaseModelImpl<Mailing> implements Mailing {
    private long _mailingId;
    private long _companyId;
    private long _groupId;
    private long _newsletterId;
    private String _newsletterName;
    private String _emailFromName;
    private String _emailFromAddress;
    private Date _startDate;
    private Date _fromDate;
    private int _emailCount;
    private int _status;
    private boolean _isScheduled;
    private BaseModel<?> _mailingRemoteModel;

    public MailingClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Mailing.class;
    }

    @Override
    public String getModelClassName() {
        return Mailing.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _mailingId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setMailingId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _mailingId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("mailingId", getMailingId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("newsletterId", getNewsletterId());
        attributes.put("newsletterName", getNewsletterName());
        attributes.put("emailFromName", getEmailFromName());
        attributes.put("emailFromAddress", getEmailFromAddress());
        attributes.put("startDate", getStartDate());
        attributes.put("fromDate", getFromDate());
        attributes.put("emailCount", getEmailCount());
        attributes.put("status", getStatus());
        attributes.put("isScheduled", getIsScheduled());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long mailingId = (Long) attributes.get("mailingId");

        if (mailingId != null) {
            setMailingId(mailingId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long newsletterId = (Long) attributes.get("newsletterId");

        if (newsletterId != null) {
            setNewsletterId(newsletterId);
        }

        String newsletterName = (String) attributes.get("newsletterName");

        if (newsletterName != null) {
            setNewsletterName(newsletterName);
        }

        String emailFromName = (String) attributes.get("emailFromName");

        if (emailFromName != null) {
            setEmailFromName(emailFromName);
        }

        String emailFromAddress = (String) attributes.get("emailFromAddress");

        if (emailFromAddress != null) {
            setEmailFromAddress(emailFromAddress);
        }

        Date startDate = (Date) attributes.get("startDate");

        if (startDate != null) {
            setStartDate(startDate);
        }

        Date fromDate = (Date) attributes.get("fromDate");

        if (fromDate != null) {
            setFromDate(fromDate);
        }

        Integer emailCount = (Integer) attributes.get("emailCount");

        if (emailCount != null) {
            setEmailCount(emailCount);
        }

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        Boolean isScheduled = (Boolean) attributes.get("isScheduled");

        if (isScheduled != null) {
            setIsScheduled(isScheduled);
        }
    }

    @Override
    public long getMailingId() {
        return _mailingId;
    }

    @Override
    public void setMailingId(long mailingId) {
        _mailingId = mailingId;

        if (_mailingRemoteModel != null) {
            try {
                Class<?> clazz = _mailingRemoteModel.getClass();

                Method method = clazz.getMethod("setMailingId", long.class);

                method.invoke(_mailingRemoteModel, mailingId);
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

        if (_mailingRemoteModel != null) {
            try {
                Class<?> clazz = _mailingRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_mailingRemoteModel, companyId);
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

        if (_mailingRemoteModel != null) {
            try {
                Class<?> clazz = _mailingRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_mailingRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getNewsletterId() {
        return _newsletterId;
    }

    @Override
    public void setNewsletterId(long newsletterId) {
        _newsletterId = newsletterId;

        if (_mailingRemoteModel != null) {
            try {
                Class<?> clazz = _mailingRemoteModel.getClass();

                Method method = clazz.getMethod("setNewsletterId", long.class);

                method.invoke(_mailingRemoteModel, newsletterId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getNewsletterName() {
        return _newsletterName;
    }

    @Override
    public void setNewsletterName(String newsletterName) {
        _newsletterName = newsletterName;

        if (_mailingRemoteModel != null) {
            try {
                Class<?> clazz = _mailingRemoteModel.getClass();

                Method method = clazz.getMethod("setNewsletterName",
                        String.class);

                method.invoke(_mailingRemoteModel, newsletterName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEmailFromName() {
        return _emailFromName;
    }

    @Override
    public void setEmailFromName(String emailFromName) {
        _emailFromName = emailFromName;

        if (_mailingRemoteModel != null) {
            try {
                Class<?> clazz = _mailingRemoteModel.getClass();

                Method method = clazz.getMethod("setEmailFromName", String.class);

                method.invoke(_mailingRemoteModel, emailFromName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEmailFromAddress() {
        return _emailFromAddress;
    }

    @Override
    public void setEmailFromAddress(String emailFromAddress) {
        _emailFromAddress = emailFromAddress;

        if (_mailingRemoteModel != null) {
            try {
                Class<?> clazz = _mailingRemoteModel.getClass();

                Method method = clazz.getMethod("setEmailFromAddress",
                        String.class);

                method.invoke(_mailingRemoteModel, emailFromAddress);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getStartDate() {
        return _startDate;
    }

    @Override
    public void setStartDate(Date startDate) {
        _startDate = startDate;

        if (_mailingRemoteModel != null) {
            try {
                Class<?> clazz = _mailingRemoteModel.getClass();

                Method method = clazz.getMethod("setStartDate", Date.class);

                method.invoke(_mailingRemoteModel, startDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getFromDate() {
        return _fromDate;
    }

    @Override
    public void setFromDate(Date fromDate) {
        _fromDate = fromDate;

        if (_mailingRemoteModel != null) {
            try {
                Class<?> clazz = _mailingRemoteModel.getClass();

                Method method = clazz.getMethod("setFromDate", Date.class);

                method.invoke(_mailingRemoteModel, fromDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getEmailCount() {
        return _emailCount;
    }

    @Override
    public void setEmailCount(int emailCount) {
        _emailCount = emailCount;

        if (_mailingRemoteModel != null) {
            try {
                Class<?> clazz = _mailingRemoteModel.getClass();

                Method method = clazz.getMethod("setEmailCount", int.class);

                method.invoke(_mailingRemoteModel, emailCount);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getStatus() {
        return _status;
    }

    @Override
    public void setStatus(int status) {
        _status = status;

        if (_mailingRemoteModel != null) {
            try {
                Class<?> clazz = _mailingRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", int.class);

                method.invoke(_mailingRemoteModel, status);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getIsScheduled() {
        return _isScheduled;
    }

    @Override
    public boolean isIsScheduled() {
        return _isScheduled;
    }

    @Override
    public void setIsScheduled(boolean isScheduled) {
        _isScheduled = isScheduled;

        if (_mailingRemoteModel != null) {
            try {
                Class<?> clazz = _mailingRemoteModel.getClass();

                Method method = clazz.getMethod("setIsScheduled", boolean.class);

                method.invoke(_mailingRemoteModel, isScheduled);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getMailingRemoteModel() {
        return _mailingRemoteModel;
    }

    public void setMailingRemoteModel(BaseModel<?> mailingRemoteModel) {
        _mailingRemoteModel = mailingRemoteModel;
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

        Class<?> remoteModelClass = _mailingRemoteModel.getClass();

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

        Object returnValue = method.invoke(_mailingRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            MailingLocalServiceUtil.addMailing(this);
        } else {
            MailingLocalServiceUtil.updateMailing(this);
        }
    }

    @Override
    public Mailing toEscapedModel() {
        return (Mailing) ProxyUtil.newProxyInstance(Mailing.class.getClassLoader(),
            new Class[] { Mailing.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        MailingClp clone = new MailingClp();

        clone.setMailingId(getMailingId());
        clone.setCompanyId(getCompanyId());
        clone.setGroupId(getGroupId());
        clone.setNewsletterId(getNewsletterId());
        clone.setNewsletterName(getNewsletterName());
        clone.setEmailFromName(getEmailFromName());
        clone.setEmailFromAddress(getEmailFromAddress());
        clone.setStartDate(getStartDate());
        clone.setFromDate(getFromDate());
        clone.setEmailCount(getEmailCount());
        clone.setStatus(getStatus());
        clone.setIsScheduled(getIsScheduled());

        return clone;
    }

    @Override
    public int compareTo(Mailing mailing) {
        int value = 0;

        value = DateUtil.compareTo(getStartDate(), mailing.getStartDate());

        value = value * -1;

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof MailingClp)) {
            return false;
        }

        MailingClp mailing = (MailingClp) obj;

        long primaryKey = mailing.getPrimaryKey();

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
        StringBundler sb = new StringBundler(25);

        sb.append("{mailingId=");
        sb.append(getMailingId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", newsletterId=");
        sb.append(getNewsletterId());
        sb.append(", newsletterName=");
        sb.append(getNewsletterName());
        sb.append(", emailFromName=");
        sb.append(getEmailFromName());
        sb.append(", emailFromAddress=");
        sb.append(getEmailFromAddress());
        sb.append(", startDate=");
        sb.append(getStartDate());
        sb.append(", fromDate=");
        sb.append(getFromDate());
        sb.append(", emailCount=");
        sb.append(getEmailCount());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append(", isScheduled=");
        sb.append(getIsScheduled());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(40);

        sb.append("<model><model-name>");
        sb.append("net.zylk.liferay.portal.model.Mailing");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>mailingId</column-name><column-value><![CDATA[");
        sb.append(getMailingId());
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
            "<column><column-name>newsletterId</column-name><column-value><![CDATA[");
        sb.append(getNewsletterId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>newsletterName</column-name><column-value><![CDATA[");
        sb.append(getNewsletterName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>emailFromName</column-name><column-value><![CDATA[");
        sb.append(getEmailFromName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>emailFromAddress</column-name><column-value><![CDATA[");
        sb.append(getEmailFromAddress());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>startDate</column-name><column-value><![CDATA[");
        sb.append(getStartDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fromDate</column-name><column-value><![CDATA[");
        sb.append(getFromDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>emailCount</column-name><column-value><![CDATA[");
        sb.append(getEmailCount());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>isScheduled</column-name><column-value><![CDATA[");
        sb.append(getIsScheduled());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
