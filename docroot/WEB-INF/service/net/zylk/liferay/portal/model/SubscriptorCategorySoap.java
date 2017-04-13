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
public class SubscriptorCategorySoap implements Serializable {
    private long _subscriptorCategoryId;
    private long _subscriptorId;
    private long _categoryId;

    public SubscriptorCategorySoap() {
    }

    public static SubscriptorCategorySoap toSoapModel(SubscriptorCategory model) {
        SubscriptorCategorySoap soapModel = new SubscriptorCategorySoap();

        soapModel.setSubscriptorCategoryId(model.getSubscriptorCategoryId());
        soapModel.setSubscriptorId(model.getSubscriptorId());
        soapModel.setCategoryId(model.getCategoryId());

        return soapModel;
    }

    public static SubscriptorCategorySoap[] toSoapModels(
        SubscriptorCategory[] models) {
        SubscriptorCategorySoap[] soapModels = new SubscriptorCategorySoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static SubscriptorCategorySoap[][] toSoapModels(
        SubscriptorCategory[][] models) {
        SubscriptorCategorySoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new SubscriptorCategorySoap[models.length][models[0].length];
        } else {
            soapModels = new SubscriptorCategorySoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static SubscriptorCategorySoap[] toSoapModels(
        List<SubscriptorCategory> models) {
        List<SubscriptorCategorySoap> soapModels = new ArrayList<SubscriptorCategorySoap>(models.size());

        for (SubscriptorCategory model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new SubscriptorCategorySoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _subscriptorCategoryId;
    }

    public void setPrimaryKey(long pk) {
        setSubscriptorCategoryId(pk);
    }

    public long getSubscriptorCategoryId() {
        return _subscriptorCategoryId;
    }

    public void setSubscriptorCategoryId(long subscriptorCategoryId) {
        _subscriptorCategoryId = subscriptorCategoryId;
    }

    public long getSubscriptorId() {
        return _subscriptorId;
    }

    public void setSubscriptorId(long subscriptorId) {
        _subscriptorId = subscriptorId;
    }

    public long getCategoryId() {
        return _categoryId;
    }

    public void setCategoryId(long categoryId) {
        _categoryId = categoryId;
    }
}
