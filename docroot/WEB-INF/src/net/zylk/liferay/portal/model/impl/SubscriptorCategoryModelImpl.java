package net.zylk.liferay.portal.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import net.zylk.liferay.portal.model.SubscriptorCategory;
import net.zylk.liferay.portal.model.SubscriptorCategoryModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the SubscriptorCategory service. Represents a row in the &quot;ZN_SubscriptorCategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link net.zylk.liferay.portal.model.SubscriptorCategoryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SubscriptorCategoryImpl}.
 * </p>
 *
 * @author zylk.net
 * @see SubscriptorCategoryImpl
 * @see net.zylk.liferay.portal.model.SubscriptorCategory
 * @see net.zylk.liferay.portal.model.SubscriptorCategoryModel
 * @generated
 */
public class SubscriptorCategoryModelImpl extends BaseModelImpl<SubscriptorCategory>
    implements SubscriptorCategoryModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a subscriptor category model instance should use the {@link net.zylk.liferay.portal.model.SubscriptorCategory} interface instead.
     */
    public static final String TABLE_NAME = "ZN_SubscriptorCategory";
    public static final Object[][] TABLE_COLUMNS = {
            { "subscriptorCategoryId", Types.BIGINT },
            { "subscriptorId", Types.BIGINT },
            { "categoryId", Types.BIGINT }
        };
    public static final String TABLE_SQL_CREATE = "create table ZN_SubscriptorCategory (subscriptorCategoryId LONG not null primary key,subscriptorId LONG,categoryId LONG)";
    public static final String TABLE_SQL_DROP = "drop table ZN_SubscriptorCategory";
    public static final String ORDER_BY_JPQL = " ORDER BY subscriptorCategory.subscriptorCategoryId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY ZN_SubscriptorCategory.subscriptorCategoryId ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.net.zylk.liferay.portal.model.SubscriptorCategory"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.net.zylk.liferay.portal.model.SubscriptorCategory"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.net.zylk.liferay.portal.model.SubscriptorCategory"),
            true);
    public static long CATEGORYID_COLUMN_BITMASK = 1L;
    public static long SUBSCRIPTORID_COLUMN_BITMASK = 2L;
    public static long SUBSCRIPTORCATEGORYID_COLUMN_BITMASK = 4L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.net.zylk.liferay.portal.model.SubscriptorCategory"));
    private static ClassLoader _classLoader = SubscriptorCategory.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            SubscriptorCategory.class
        };
    private long _subscriptorCategoryId;
    private long _subscriptorId;
    private long _originalSubscriptorId;
    private boolean _setOriginalSubscriptorId;
    private long _categoryId;
    private long _originalCategoryId;
    private boolean _setOriginalCategoryId;
    private long _columnBitmask;
    private SubscriptorCategory _escapedModel;

    public SubscriptorCategoryModelImpl() {
    }

    @Override
    public long getPrimaryKey() {
        return _subscriptorCategoryId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setSubscriptorCategoryId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _subscriptorCategoryId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return SubscriptorCategory.class;
    }

    @Override
    public String getModelClassName() {
        return SubscriptorCategory.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("subscriptorCategoryId", getSubscriptorCategoryId());
        attributes.put("subscriptorId", getSubscriptorId());
        attributes.put("categoryId", getCategoryId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long subscriptorCategoryId = (Long) attributes.get(
                "subscriptorCategoryId");

        if (subscriptorCategoryId != null) {
            setSubscriptorCategoryId(subscriptorCategoryId);
        }

        Long subscriptorId = (Long) attributes.get("subscriptorId");

        if (subscriptorId != null) {
            setSubscriptorId(subscriptorId);
        }

        Long categoryId = (Long) attributes.get("categoryId");

        if (categoryId != null) {
            setCategoryId(categoryId);
        }
    }

    @Override
    public long getSubscriptorCategoryId() {
        return _subscriptorCategoryId;
    }

    @Override
    public void setSubscriptorCategoryId(long subscriptorCategoryId) {
        _subscriptorCategoryId = subscriptorCategoryId;
    }

    @Override
    public long getSubscriptorId() {
        return _subscriptorId;
    }

    @Override
    public void setSubscriptorId(long subscriptorId) {
        _columnBitmask |= SUBSCRIPTORID_COLUMN_BITMASK;

        if (!_setOriginalSubscriptorId) {
            _setOriginalSubscriptorId = true;

            _originalSubscriptorId = _subscriptorId;
        }

        _subscriptorId = subscriptorId;
    }

    public long getOriginalSubscriptorId() {
        return _originalSubscriptorId;
    }

    @Override
    public long getCategoryId() {
        return _categoryId;
    }

    @Override
    public void setCategoryId(long categoryId) {
        _columnBitmask |= CATEGORYID_COLUMN_BITMASK;

        if (!_setOriginalCategoryId) {
            _setOriginalCategoryId = true;

            _originalCategoryId = _categoryId;
        }

        _categoryId = categoryId;
    }

    public long getOriginalCategoryId() {
        return _originalCategoryId;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            SubscriptorCategory.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public SubscriptorCategory toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (SubscriptorCategory) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        SubscriptorCategoryImpl subscriptorCategoryImpl = new SubscriptorCategoryImpl();

        subscriptorCategoryImpl.setSubscriptorCategoryId(getSubscriptorCategoryId());
        subscriptorCategoryImpl.setSubscriptorId(getSubscriptorId());
        subscriptorCategoryImpl.setCategoryId(getCategoryId());

        subscriptorCategoryImpl.resetOriginalValues();

        return subscriptorCategoryImpl;
    }

    @Override
    public int compareTo(SubscriptorCategory subscriptorCategory) {
        long primaryKey = subscriptorCategory.getPrimaryKey();

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

        if (!(obj instanceof SubscriptorCategory)) {
            return false;
        }

        SubscriptorCategory subscriptorCategory = (SubscriptorCategory) obj;

        long primaryKey = subscriptorCategory.getPrimaryKey();

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
    public void resetOriginalValues() {
        SubscriptorCategoryModelImpl subscriptorCategoryModelImpl = this;

        subscriptorCategoryModelImpl._originalSubscriptorId = subscriptorCategoryModelImpl._subscriptorId;

        subscriptorCategoryModelImpl._setOriginalSubscriptorId = false;

        subscriptorCategoryModelImpl._originalCategoryId = subscriptorCategoryModelImpl._categoryId;

        subscriptorCategoryModelImpl._setOriginalCategoryId = false;

        subscriptorCategoryModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<SubscriptorCategory> toCacheModel() {
        SubscriptorCategoryCacheModel subscriptorCategoryCacheModel = new SubscriptorCategoryCacheModel();

        subscriptorCategoryCacheModel.subscriptorCategoryId = getSubscriptorCategoryId();

        subscriptorCategoryCacheModel.subscriptorId = getSubscriptorId();

        subscriptorCategoryCacheModel.categoryId = getCategoryId();

        return subscriptorCategoryCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{subscriptorCategoryId=");
        sb.append(getSubscriptorCategoryId());
        sb.append(", subscriptorId=");
        sb.append(getSubscriptorId());
        sb.append(", categoryId=");
        sb.append(getCategoryId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("net.zylk.liferay.portal.model.SubscriptorCategory");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>subscriptorCategoryId</column-name><column-value><![CDATA[");
        sb.append(getSubscriptorCategoryId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>subscriptorId</column-name><column-value><![CDATA[");
        sb.append(getSubscriptorId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>categoryId</column-name><column-value><![CDATA[");
        sb.append(getCategoryId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
