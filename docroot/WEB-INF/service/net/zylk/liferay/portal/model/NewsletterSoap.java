package net.zylk.liferay.portal.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author zylk.net
 * @generated
 */
public class NewsletterSoap implements Serializable {
    private long _newsletterId;
    private long _companyId;
    private long _groupId;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private String _description;
    private long _categoryId;
    private String _subject;
    private String _articleId;
    private long _articleGroupId;
    private boolean _schedulerActive;
    private int _schedulerType;
    private Date _schedulerDate;

    public NewsletterSoap() {
    }

    public static NewsletterSoap toSoapModel(Newsletter model) {
        NewsletterSoap soapModel = new NewsletterSoap();

        soapModel.setNewsletterId(model.getNewsletterId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setName(model.getName());
        soapModel.setDescription(model.getDescription());
        soapModel.setCategoryId(model.getCategoryId());
        soapModel.setSubject(model.getSubject());
        soapModel.setArticleId(model.getArticleId());
        soapModel.setArticleGroupId(model.getArticleGroupId());
        soapModel.setSchedulerActive(model.getSchedulerActive());
        soapModel.setSchedulerType(model.getSchedulerType());
        soapModel.setSchedulerDate(model.getSchedulerDate());

        return soapModel;
    }

    public static NewsletterSoap[] toSoapModels(Newsletter[] models) {
        NewsletterSoap[] soapModels = new NewsletterSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static NewsletterSoap[][] toSoapModels(Newsletter[][] models) {
        NewsletterSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new NewsletterSoap[models.length][models[0].length];
        } else {
            soapModels = new NewsletterSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static NewsletterSoap[] toSoapModels(List<Newsletter> models) {
        List<NewsletterSoap> soapModels = new ArrayList<NewsletterSoap>(models.size());

        for (Newsletter model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new NewsletterSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _newsletterId;
    }

    public void setPrimaryKey(long pk) {
        setNewsletterId(pk);
    }

    public long getNewsletterId() {
        return _newsletterId;
    }

    public void setNewsletterId(long newsletterId) {
        _newsletterId = newsletterId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public long getCategoryId() {
        return _categoryId;
    }

    public void setCategoryId(long categoryId) {
        _categoryId = categoryId;
    }

    public String getSubject() {
        return _subject;
    }

    public void setSubject(String subject) {
        _subject = subject;
    }

    public String getArticleId() {
        return _articleId;
    }

    public void setArticleId(String articleId) {
        _articleId = articleId;
    }

    public long getArticleGroupId() {
        return _articleGroupId;
    }

    public void setArticleGroupId(long articleGroupId) {
        _articleGroupId = articleGroupId;
    }

    public boolean getSchedulerActive() {
        return _schedulerActive;
    }

    public boolean isSchedulerActive() {
        return _schedulerActive;
    }

    public void setSchedulerActive(boolean schedulerActive) {
        _schedulerActive = schedulerActive;
    }

    public int getSchedulerType() {
        return _schedulerType;
    }

    public void setSchedulerType(int schedulerType) {
        _schedulerType = schedulerType;
    }

    public Date getSchedulerDate() {
        return _schedulerDate;
    }

    public void setSchedulerDate(Date schedulerDate) {
        _schedulerDate = schedulerDate;
    }
}
