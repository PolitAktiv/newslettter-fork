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
public class CategorySoap implements Serializable {
    private long _categoryId;
    private long _companyId;
    private long _groupId;
    private String _name;
    private String _description;

    public CategorySoap() {
    }

    public static CategorySoap toSoapModel(Category model) {
        CategorySoap soapModel = new CategorySoap();

        soapModel.setCategoryId(model.getCategoryId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setName(model.getName());
        soapModel.setDescription(model.getDescription());

        return soapModel;
    }

    public static CategorySoap[] toSoapModels(Category[] models) {
        CategorySoap[] soapModels = new CategorySoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static CategorySoap[][] toSoapModels(Category[][] models) {
        CategorySoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new CategorySoap[models.length][models[0].length];
        } else {
            soapModels = new CategorySoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static CategorySoap[] toSoapModels(List<Category> models) {
        List<CategorySoap> soapModels = new ArrayList<CategorySoap>(models.size());

        for (Category model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new CategorySoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _categoryId;
    }

    public void setPrimaryKey(long pk) {
        setCategoryId(pk);
    }

    public long getCategoryId() {
        return _categoryId;
    }

    public void setCategoryId(long categoryId) {
        _categoryId = categoryId;
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

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }
}
