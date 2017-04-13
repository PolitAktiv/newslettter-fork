package net.zylk.liferay.portal.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author zylk.net
 * @generated
 */
public class MailingSubscriptorSoap implements Serializable {
    private long _mailingSubscriptorId;
    private long _mailingId;
    private String _email;
    private String _name;
    private String _surname;
    private String _languageId;
    private String _emailSubject;
    private String _emailBody;
    private String _tokens;

    public MailingSubscriptorSoap() {
    }

    public static MailingSubscriptorSoap toSoapModel(MailingSubscriptor model) {
        MailingSubscriptorSoap soapModel = new MailingSubscriptorSoap();

        soapModel.setMailingSubscriptorId(model.getMailingSubscriptorId());
        soapModel.setMailingId(model.getMailingId());
        soapModel.setEmail(model.getEmail());
        soapModel.setName(model.getName());
        soapModel.setSurname(model.getSurname());
        soapModel.setLanguageId(model.getLanguageId());
        soapModel.setEmailSubject(model.getEmailSubject());
        soapModel.setEmailBody(model.getEmailBody());
        soapModel.setTokens(model.getTokens());

        return soapModel;
    }

    public static MailingSubscriptorSoap[] toSoapModels(
        MailingSubscriptor[] models) {
        MailingSubscriptorSoap[] soapModels = new MailingSubscriptorSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static MailingSubscriptorSoap[][] toSoapModels(
        MailingSubscriptor[][] models) {
        MailingSubscriptorSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new MailingSubscriptorSoap[models.length][models[0].length];
        } else {
            soapModels = new MailingSubscriptorSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static MailingSubscriptorSoap[] toSoapModels(
        List<MailingSubscriptor> models) {
        List<MailingSubscriptorSoap> soapModels = new ArrayList<MailingSubscriptorSoap>(models.size());

        for (MailingSubscriptor model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new MailingSubscriptorSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _mailingSubscriptorId;
    }

    public void setPrimaryKey(long pk) {
        setMailingSubscriptorId(pk);
    }

    public long getMailingSubscriptorId() {
        return _mailingSubscriptorId;
    }

    public void setMailingSubscriptorId(long mailingSubscriptorId) {
        _mailingSubscriptorId = mailingSubscriptorId;
    }

    public long getMailingId() {
        return _mailingId;
    }

    public void setMailingId(long mailingId) {
        _mailingId = mailingId;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getSurname() {
        return _surname;
    }

    public void setSurname(String surname) {
        _surname = surname;
    }

    public String getLanguageId() {
        return _languageId;
    }

    public void setLanguageId(String languageId) {
        _languageId = languageId;
    }

    public String getEmailSubject() {
        return _emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        _emailSubject = emailSubject;
    }

    public String getEmailBody() {
        return _emailBody;
    }

    public void setEmailBody(String emailBody) {
        _emailBody = emailBody;
    }

    public String getTokens() {
        return _tokens;
    }

    public void setTokens(String tokens) {
        _tokens = tokens;
    }
}
