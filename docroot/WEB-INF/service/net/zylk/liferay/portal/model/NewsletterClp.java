package net.zylk.liferay.portal.model;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import net.zylk.liferay.portal.service.ClpSerializer;
import net.zylk.liferay.portal.service.NewsletterLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class NewsletterClp extends BaseModelImpl<Newsletter>
    implements Newsletter {
    private long _newsletterId;
    private long _companyId;
    private long _groupId;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private String _description;
    private long _categoryId;
    private String _subject;
    private String _subjectCurrentLanguageId;
    private String _articleId;
    private long _articleGroupId;
    private boolean _schedulerActive;
    private int _schedulerType;
    private Date _schedulerDate;
    private BaseModel<?> _newsletterRemoteModel;

    public NewsletterClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Newsletter.class;
    }

    @Override
    public String getModelClassName() {
        return Newsletter.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _newsletterId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setNewsletterId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _newsletterId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("newsletterId", getNewsletterId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("categoryId", getCategoryId());
        attributes.put("subject", getSubject());
        attributes.put("articleId", getArticleId());
        attributes.put("articleGroupId", getArticleGroupId());
        attributes.put("schedulerActive", getSchedulerActive());
        attributes.put("schedulerType", getSchedulerType());
        attributes.put("schedulerDate", getSchedulerDate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long newsletterId = (Long) attributes.get("newsletterId");

        if (newsletterId != null) {
            setNewsletterId(newsletterId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        Long categoryId = (Long) attributes.get("categoryId");

        if (categoryId != null) {
            setCategoryId(categoryId);
        }

        String subject = (String) attributes.get("subject");

        if (subject != null) {
            setSubject(subject);
        }

        String articleId = (String) attributes.get("articleId");

        if (articleId != null) {
            setArticleId(articleId);
        }

        Long articleGroupId = (Long) attributes.get("articleGroupId");

        if (articleGroupId != null) {
            setArticleGroupId(articleGroupId);
        }

        Boolean schedulerActive = (Boolean) attributes.get("schedulerActive");

        if (schedulerActive != null) {
            setSchedulerActive(schedulerActive);
        }

        Integer schedulerType = (Integer) attributes.get("schedulerType");

        if (schedulerType != null) {
            setSchedulerType(schedulerType);
        }

        Date schedulerDate = (Date) attributes.get("schedulerDate");

        if (schedulerDate != null) {
            setSchedulerDate(schedulerDate);
        }
    }

    @Override
    public long getNewsletterId() {
        return _newsletterId;
    }

    @Override
    public void setNewsletterId(long newsletterId) {
        _newsletterId = newsletterId;

        if (_newsletterRemoteModel != null) {
            try {
                Class<?> clazz = _newsletterRemoteModel.getClass();

                Method method = clazz.getMethod("setNewsletterId", long.class);

                method.invoke(_newsletterRemoteModel, newsletterId);
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

        if (_newsletterRemoteModel != null) {
            try {
                Class<?> clazz = _newsletterRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_newsletterRemoteModel, companyId);
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

        if (_newsletterRemoteModel != null) {
            try {
                Class<?> clazz = _newsletterRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_newsletterRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_newsletterRemoteModel != null) {
            try {
                Class<?> clazz = _newsletterRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_newsletterRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;

        if (_newsletterRemoteModel != null) {
            try {
                Class<?> clazz = _newsletterRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_newsletterRemoteModel, modifiedDate);
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

        if (_newsletterRemoteModel != null) {
            try {
                Class<?> clazz = _newsletterRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_newsletterRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description = description;

        if (_newsletterRemoteModel != null) {
            try {
                Class<?> clazz = _newsletterRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_newsletterRemoteModel, description);
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

        if (_newsletterRemoteModel != null) {
            try {
                Class<?> clazz = _newsletterRemoteModel.getClass();

                Method method = clazz.getMethod("setCategoryId", long.class);

                method.invoke(_newsletterRemoteModel, categoryId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSubject() {
        return _subject;
    }

    @Override
    public String getSubject(Locale locale) {
        String languageId = LocaleUtil.toLanguageId(locale);

        return getSubject(languageId);
    }

    @Override
    public String getSubject(Locale locale, boolean useDefault) {
        String languageId = LocaleUtil.toLanguageId(locale);

        return getSubject(languageId, useDefault);
    }

    @Override
    public String getSubject(String languageId) {
        return LocalizationUtil.getLocalization(getSubject(), languageId);
    }

    @Override
    public String getSubject(String languageId, boolean useDefault) {
        return LocalizationUtil.getLocalization(getSubject(), languageId,
            useDefault);
    }

    @Override
    public String getSubjectCurrentLanguageId() {
        return _subjectCurrentLanguageId;
    }

    @Override
    public String getSubjectCurrentValue() {
        Locale locale = getLocale(_subjectCurrentLanguageId);

        return getSubject(locale);
    }

    @Override
    public Map<Locale, String> getSubjectMap() {
        return LocalizationUtil.getLocalizationMap(getSubject());
    }

    @Override
    public void setSubject(String subject) {
        _subject = subject;

        if (_newsletterRemoteModel != null) {
            try {
                Class<?> clazz = _newsletterRemoteModel.getClass();

                Method method = clazz.getMethod("setSubject", String.class);

                method.invoke(_newsletterRemoteModel, subject);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public void setSubject(String subject, Locale locale) {
        setSubject(subject, locale, LocaleUtil.getDefault());
    }

    @Override
    public void setSubject(String subject, Locale locale, Locale defaultLocale) {
        String languageId = LocaleUtil.toLanguageId(locale);
        String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

        if (Validator.isNotNull(subject)) {
            setSubject(LocalizationUtil.updateLocalization(getSubject(),
                    "Subject", subject, languageId, defaultLanguageId));
        } else {
            setSubject(LocalizationUtil.removeLocalization(getSubject(),
                    "Subject", languageId));
        }
    }

    @Override
    public void setSubjectCurrentLanguageId(String languageId) {
        _subjectCurrentLanguageId = languageId;
    }

    @Override
    public void setSubjectMap(Map<Locale, String> subjectMap) {
        setSubjectMap(subjectMap, LocaleUtil.getDefault());
    }

    @Override
    public void setSubjectMap(Map<Locale, String> subjectMap,
        Locale defaultLocale) {
        if (subjectMap == null) {
            return;
        }

        ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        try {
            if (contextClassLoader != portalClassLoader) {
                currentThread.setContextClassLoader(portalClassLoader);
            }

            setSubject(LocalizationUtil.updateLocalization(subjectMap,
                    getSubject(), "Subject",
                    LocaleUtil.toLanguageId(defaultLocale)));
        } finally {
            if (contextClassLoader != portalClassLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    @Override
    public String getArticleId() {
        return _articleId;
    }

    @Override
    public void setArticleId(String articleId) {
        _articleId = articleId;

        if (_newsletterRemoteModel != null) {
            try {
                Class<?> clazz = _newsletterRemoteModel.getClass();

                Method method = clazz.getMethod("setArticleId", String.class);

                method.invoke(_newsletterRemoteModel, articleId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getArticleGroupId() {
        return _articleGroupId;
    }

    @Override
    public void setArticleGroupId(long articleGroupId) {
        _articleGroupId = articleGroupId;

        if (_newsletterRemoteModel != null) {
            try {
                Class<?> clazz = _newsletterRemoteModel.getClass();

                Method method = clazz.getMethod("setArticleGroupId", long.class);

                method.invoke(_newsletterRemoteModel, articleGroupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getSchedulerActive() {
        return _schedulerActive;
    }

    @Override
    public boolean isSchedulerActive() {
        return _schedulerActive;
    }

    @Override
    public void setSchedulerActive(boolean schedulerActive) {
        _schedulerActive = schedulerActive;

        if (_newsletterRemoteModel != null) {
            try {
                Class<?> clazz = _newsletterRemoteModel.getClass();

                Method method = clazz.getMethod("setSchedulerActive",
                        boolean.class);

                method.invoke(_newsletterRemoteModel, schedulerActive);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getSchedulerType() {
        return _schedulerType;
    }

    @Override
    public void setSchedulerType(int schedulerType) {
        _schedulerType = schedulerType;

        if (_newsletterRemoteModel != null) {
            try {
                Class<?> clazz = _newsletterRemoteModel.getClass();

                Method method = clazz.getMethod("setSchedulerType", int.class);

                method.invoke(_newsletterRemoteModel, schedulerType);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getSchedulerDate() {
        return _schedulerDate;
    }

    @Override
    public void setSchedulerDate(Date schedulerDate) {
        _schedulerDate = schedulerDate;

        if (_newsletterRemoteModel != null) {
            try {
                Class<?> clazz = _newsletterRemoteModel.getClass();

                Method method = clazz.getMethod("setSchedulerDate", Date.class);

                method.invoke(_newsletterRemoteModel, schedulerDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getNewsletterRemoteModel() {
        return _newsletterRemoteModel;
    }

    public void setNewsletterRemoteModel(BaseModel<?> newsletterRemoteModel) {
        _newsletterRemoteModel = newsletterRemoteModel;
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

        Class<?> remoteModelClass = _newsletterRemoteModel.getClass();

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

        Object returnValue = method.invoke(_newsletterRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            NewsletterLocalServiceUtil.addNewsletter(this);
        } else {
            NewsletterLocalServiceUtil.updateNewsletter(this);
        }
    }

    @Override
    public String[] getAvailableLanguageIds() {
        Set<String> availableLanguageIds = new TreeSet<String>();

        Map<Locale, String> subjectMap = getSubjectMap();

        for (Map.Entry<Locale, String> entry : subjectMap.entrySet()) {
            Locale locale = entry.getKey();
            String value = entry.getValue();

            if (Validator.isNotNull(value)) {
                availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
            }
        }

        return availableLanguageIds.toArray(new String[availableLanguageIds.size()]);
    }

    @Override
    public String getDefaultLanguageId() {
        String xml = getSubject();

        if (xml == null) {
            return StringPool.BLANK;
        }

        return LocalizationUtil.getDefaultLanguageId(xml);
    }

    @Override
    public void prepareLocalizedFieldsForImport() throws LocaleException {
        prepareLocalizedFieldsForImport(null);
    }

    @Override
    @SuppressWarnings("unused")
    public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
        throws LocaleException {
        Locale defaultLocale = LocaleUtil.getDefault();

        String modelDefaultLanguageId = getDefaultLanguageId();

        String subject = getSubject(defaultLocale);

        if (Validator.isNull(subject)) {
            setSubject(getSubject(modelDefaultLanguageId), defaultLocale);
        } else {
            setSubject(getSubject(defaultLocale), defaultLocale, defaultLocale);
        }
    }

    @Override
    public Newsletter toEscapedModel() {
        return (Newsletter) ProxyUtil.newProxyInstance(Newsletter.class.getClassLoader(),
            new Class[] { Newsletter.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        NewsletterClp clone = new NewsletterClp();

        clone.setNewsletterId(getNewsletterId());
        clone.setCompanyId(getCompanyId());
        clone.setGroupId(getGroupId());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setName(getName());
        clone.setDescription(getDescription());
        clone.setCategoryId(getCategoryId());
        clone.setSubject(getSubject());
        clone.setArticleId(getArticleId());
        clone.setArticleGroupId(getArticleGroupId());
        clone.setSchedulerActive(getSchedulerActive());
        clone.setSchedulerType(getSchedulerType());
        clone.setSchedulerDate(getSchedulerDate());

        return clone;
    }

    @Override
    public int compareTo(Newsletter newsletter) {
        long primaryKey = newsletter.getPrimaryKey();

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

        if (!(obj instanceof NewsletterClp)) {
            return false;
        }

        NewsletterClp newsletter = (NewsletterClp) obj;

        long primaryKey = newsletter.getPrimaryKey();

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
        StringBundler sb = new StringBundler(29);

        sb.append("{newsletterId=");
        sb.append(getNewsletterId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", categoryId=");
        sb.append(getCategoryId());
        sb.append(", subject=");
        sb.append(getSubject());
        sb.append(", articleId=");
        sb.append(getArticleId());
        sb.append(", articleGroupId=");
        sb.append(getArticleGroupId());
        sb.append(", schedulerActive=");
        sb.append(getSchedulerActive());
        sb.append(", schedulerType=");
        sb.append(getSchedulerType());
        sb.append(", schedulerDate=");
        sb.append(getSchedulerDate());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(46);

        sb.append("<model><model-name>");
        sb.append("net.zylk.liferay.portal.model.Newsletter");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>newsletterId</column-name><column-value><![CDATA[");
        sb.append(getNewsletterId());
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
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>categoryId</column-name><column-value><![CDATA[");
        sb.append(getCategoryId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>subject</column-name><column-value><![CDATA[");
        sb.append(getSubject());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>articleId</column-name><column-value><![CDATA[");
        sb.append(getArticleId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>articleGroupId</column-name><column-value><![CDATA[");
        sb.append(getArticleGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>schedulerActive</column-name><column-value><![CDATA[");
        sb.append(getSchedulerActive());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>schedulerType</column-name><column-value><![CDATA[");
        sb.append(getSchedulerType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>schedulerDate</column-name><column-value><![CDATA[");
        sb.append(getSchedulerDate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
