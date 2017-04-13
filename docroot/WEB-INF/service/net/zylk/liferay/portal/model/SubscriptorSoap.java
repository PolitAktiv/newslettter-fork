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
public class SubscriptorSoap implements Serializable {
    private String _uuid;
    private long _subscriptorId;
    private long _companyId;
    private long _groupId;
    private String _name;
    private String _surname;
    private String _email;
    private String _languageId;
    private boolean _selfSubscribe;

    public SubscriptorSoap() {
    }

    public static SubscriptorSoap toSoapModel(Subscriptor model) {
        SubscriptorSoap soapModel = new SubscriptorSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setSubscriptorId(model.getSubscriptorId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setName(model.getName());
        soapModel.setSurname(model.getSurname());
        soapModel.setEmail(model.getEmail());
        soapModel.setLanguageId(model.getLanguageId());
        soapModel.setSelfSubscribe(model.getSelfSubscribe());

        return soapModel;
    }

    public static SubscriptorSoap[] toSoapModels(Subscriptor[] models) {
        SubscriptorSoap[] soapModels = new SubscriptorSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static SubscriptorSoap[][] toSoapModels(Subscriptor[][] models) {
        SubscriptorSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new SubscriptorSoap[models.length][models[0].length];
        } else {
            soapModels = new SubscriptorSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static SubscriptorSoap[] toSoapModels(List<Subscriptor> models) {
        List<SubscriptorSoap> soapModels = new ArrayList<SubscriptorSoap>(models.size());

        for (Subscriptor model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new SubscriptorSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _subscriptorId;
    }

    public void setPrimaryKey(long pk) {
        setSubscriptorId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getSubscriptorId() {
        return _subscriptorId;
    }

    public void setSubscriptorId(long subscriptorId) {
        _subscriptorId = subscriptorId;
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

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public String getLanguageId() {
        return _languageId;
    }

    public void setLanguageId(String languageId) {
        _languageId = languageId;
    }

    public boolean getSelfSubscribe() {
        return _selfSubscribe;
    }

    public boolean isSelfSubscribe() {
        return _selfSubscribe;
    }

    public void setSelfSubscribe(boolean selfSubscribe) {
        _selfSubscribe = selfSubscribe;
    }
}
