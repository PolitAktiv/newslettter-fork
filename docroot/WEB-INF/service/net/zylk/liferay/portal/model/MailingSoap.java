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
public class MailingSoap implements Serializable {
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

    public MailingSoap() {
    }

    public static MailingSoap toSoapModel(Mailing model) {
        MailingSoap soapModel = new MailingSoap();

        soapModel.setMailingId(model.getMailingId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setNewsletterId(model.getNewsletterId());
        soapModel.setNewsletterName(model.getNewsletterName());
        soapModel.setEmailFromName(model.getEmailFromName());
        soapModel.setEmailFromAddress(model.getEmailFromAddress());
        soapModel.setStartDate(model.getStartDate());
        soapModel.setFromDate(model.getFromDate());
        soapModel.setEmailCount(model.getEmailCount());
        soapModel.setStatus(model.getStatus());
        soapModel.setIsScheduled(model.getIsScheduled());

        return soapModel;
    }

    public static MailingSoap[] toSoapModels(Mailing[] models) {
        MailingSoap[] soapModels = new MailingSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static MailingSoap[][] toSoapModels(Mailing[][] models) {
        MailingSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new MailingSoap[models.length][models[0].length];
        } else {
            soapModels = new MailingSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static MailingSoap[] toSoapModels(List<Mailing> models) {
        List<MailingSoap> soapModels = new ArrayList<MailingSoap>(models.size());

        for (Mailing model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new MailingSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _mailingId;
    }

    public void setPrimaryKey(long pk) {
        setMailingId(pk);
    }

    public long getMailingId() {
        return _mailingId;
    }

    public void setMailingId(long mailingId) {
        _mailingId = mailingId;
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

    public long getNewsletterId() {
        return _newsletterId;
    }

    public void setNewsletterId(long newsletterId) {
        _newsletterId = newsletterId;
    }

    public String getNewsletterName() {
        return _newsletterName;
    }

    public void setNewsletterName(String newsletterName) {
        _newsletterName = newsletterName;
    }

    public String getEmailFromName() {
        return _emailFromName;
    }

    public void setEmailFromName(String emailFromName) {
        _emailFromName = emailFromName;
    }

    public String getEmailFromAddress() {
        return _emailFromAddress;
    }

    public void setEmailFromAddress(String emailFromAddress) {
        _emailFromAddress = emailFromAddress;
    }

    public Date getStartDate() {
        return _startDate;
    }

    public void setStartDate(Date startDate) {
        _startDate = startDate;
    }

    public Date getFromDate() {
        return _fromDate;
    }

    public void setFromDate(Date fromDate) {
        _fromDate = fromDate;
    }

    public int getEmailCount() {
        return _emailCount;
    }

    public void setEmailCount(int emailCount) {
        _emailCount = emailCount;
    }

    public int getStatus() {
        return _status;
    }

    public void setStatus(int status) {
        _status = status;
    }

    public boolean getIsScheduled() {
        return _isScheduled;
    }

    public boolean isIsScheduled() {
        return _isScheduled;
    }

    public void setIsScheduled(boolean isScheduled) {
        _isScheduled = isScheduled;
    }
}
