package net.zylk.liferay.portal.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import net.zylk.liferay.portal.model.Subscriptor;
import net.zylk.liferay.portal.model.SubscriptorModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Subscriptor service. Represents a row in the &quot;ZN_Subscriptor&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link net.zylk.liferay.portal.model.SubscriptorModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SubscriptorImpl}.
 * </p>
 *
 * @author zylk.net
 * @see SubscriptorImpl
 * @see net.zylk.liferay.portal.model.Subscriptor
 * @see net.zylk.liferay.portal.model.SubscriptorModel
 * @generated
 */
public class SubscriptorModelImpl extends BaseModelImpl<Subscriptor>
    implements SubscriptorModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a subscriptor model instance should use the {@link net.zylk.liferay.portal.model.Subscriptor} interface instead.
     */
    public static final String TABLE_NAME = "ZN_Subscriptor";
    public static final Object[][] TABLE_COLUMNS = {
            { "uuid_", Types.VARCHAR },
            { "subscriptorId", Types.BIGINT },
            { "companyId", Types.BIGINT },
            { "groupId", Types.BIGINT },
            { "name", Types.VARCHAR },
            { "surname", Types.VARCHAR },
            { "email", Types.VARCHAR },
            { "languageId", Types.VARCHAR },
            { "selfSubscribe", Types.BOOLEAN }
        };
    public static final String TABLE_SQL_CREATE = "create table ZN_Subscriptor (uuid_ VARCHAR(75) null,subscriptorId LONG not null primary key,companyId LONG,groupId LONG,name VARCHAR(75) null,surname VARCHAR(75) null,email VARCHAR(75) null,languageId VARCHAR(75) null,selfSubscribe BOOLEAN)";
    public static final String TABLE_SQL_DROP = "drop table ZN_Subscriptor";
    public static final String ORDER_BY_JPQL = " ORDER BY subscriptor.subscriptorId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY ZN_Subscriptor.subscriptorId ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.net.zylk.liferay.portal.model.Subscriptor"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.net.zylk.liferay.portal.model.Subscriptor"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.net.zylk.liferay.portal.model.Subscriptor"),
            true);
    public static long COMPANYID_COLUMN_BITMASK = 1L;
    public static long EMAIL_COLUMN_BITMASK = 2L;
    public static long GROUPID_COLUMN_BITMASK = 4L;
    public static long UUID_COLUMN_BITMASK = 8L;
    public static long SUBSCRIPTORID_COLUMN_BITMASK = 16L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.net.zylk.liferay.portal.model.Subscriptor"));
    private static ClassLoader _classLoader = Subscriptor.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            Subscriptor.class
        };
    private String _uuid;
    private String _originalUuid;
    private long _subscriptorId;
    private long _companyId;
    private long _originalCompanyId;
    private boolean _setOriginalCompanyId;
    private long _groupId;
    private long _originalGroupId;
    private boolean _setOriginalGroupId;
    private String _name;
    private String _surname;
    private String _email;
    private String _originalEmail;
    private String _languageId;
    private boolean _selfSubscribe;
    private long _columnBitmask;
    private Subscriptor _escapedModel;

    public SubscriptorModelImpl() {
    }

    @Override
    public long getPrimaryKey() {
        return _subscriptorId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setSubscriptorId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _subscriptorId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return Subscriptor.class;
    }

    @Override
    public String getModelClassName() {
        return Subscriptor.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("subscriptorId", getSubscriptorId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("name", getName());
        attributes.put("surname", getSurname());
        attributes.put("email", getEmail());
        attributes.put("languageId", getLanguageId());
        attributes.put("selfSubscribe", getSelfSubscribe());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long subscriptorId = (Long) attributes.get("subscriptorId");

        if (subscriptorId != null) {
            setSubscriptorId(subscriptorId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String surname = (String) attributes.get("surname");

        if (surname != null) {
            setSurname(surname);
        }

        String email = (String) attributes.get("email");

        if (email != null) {
            setEmail(email);
        }

        String languageId = (String) attributes.get("languageId");

        if (languageId != null) {
            setLanguageId(languageId);
        }

        Boolean selfSubscribe = (Boolean) attributes.get("selfSubscribe");

        if (selfSubscribe != null) {
            setSelfSubscribe(selfSubscribe);
        }
    }

    @Override
    public String getUuid() {
        if (_uuid == null) {
            return StringPool.BLANK;
        } else {
            return _uuid;
        }
    }

    @Override
    public void setUuid(String uuid) {
        if (_originalUuid == null) {
            _originalUuid = _uuid;
        }

        _uuid = uuid;
    }

    public String getOriginalUuid() {
        return GetterUtil.getString(_originalUuid);
    }

    @Override
    public long getSubscriptorId() {
        return _subscriptorId;
    }

    @Override
    public void setSubscriptorId(long subscriptorId) {
        _subscriptorId = subscriptorId;
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _columnBitmask |= COMPANYID_COLUMN_BITMASK;

        if (!_setOriginalCompanyId) {
            _setOriginalCompanyId = true;

            _originalCompanyId = _companyId;
        }

        _companyId = companyId;
    }

    public long getOriginalCompanyId() {
        return _originalCompanyId;
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _columnBitmask |= GROUPID_COLUMN_BITMASK;

        if (!_setOriginalGroupId) {
            _setOriginalGroupId = true;

            _originalGroupId = _groupId;
        }

        _groupId = groupId;
    }

    public long getOriginalGroupId() {
        return _originalGroupId;
    }

    @Override
    public String getName() {
        if (_name == null) {
            return StringPool.BLANK;
        } else {
            return _name;
        }
    }

    @Override
    public void setName(String name) {
        _name = name;
    }

    @Override
    public String getSurname() {
        if (_surname == null) {
            return StringPool.BLANK;
        } else {
            return _surname;
        }
    }

    @Override
    public void setSurname(String surname) {
        _surname = surname;
    }

    @Override
    public String getEmail() {
        if (_email == null) {
            return StringPool.BLANK;
        } else {
            return _email;
        }
    }

    @Override
    public void setEmail(String email) {
        _columnBitmask |= EMAIL_COLUMN_BITMASK;

        if (_originalEmail == null) {
            _originalEmail = _email;
        }

        _email = email;
    }

    public String getOriginalEmail() {
        return GetterUtil.getString(_originalEmail);
    }

    @Override
    public String getLanguageId() {
        if (_languageId == null) {
            return StringPool.BLANK;
        } else {
            return _languageId;
        }
    }

    @Override
    public void setLanguageId(String languageId) {
        _languageId = languageId;
    }

    @Override
    public boolean getSelfSubscribe() {
        return _selfSubscribe;
    }

    @Override
    public boolean isSelfSubscribe() {
        return _selfSubscribe;
    }

    @Override
    public void setSelfSubscribe(boolean selfSubscribe) {
        _selfSubscribe = selfSubscribe;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
            Subscriptor.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public Subscriptor toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (Subscriptor) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        SubscriptorImpl subscriptorImpl = new SubscriptorImpl();

        subscriptorImpl.setUuid(getUuid());
        subscriptorImpl.setSubscriptorId(getSubscriptorId());
        subscriptorImpl.setCompanyId(getCompanyId());
        subscriptorImpl.setGroupId(getGroupId());
        subscriptorImpl.setName(getName());
        subscriptorImpl.setSurname(getSurname());
        subscriptorImpl.setEmail(getEmail());
        subscriptorImpl.setLanguageId(getLanguageId());
        subscriptorImpl.setSelfSubscribe(getSelfSubscribe());

        subscriptorImpl.resetOriginalValues();

        return subscriptorImpl;
    }

    @Override
    public int compareTo(Subscriptor subscriptor) {
        long primaryKey = subscriptor.getPrimaryKey();

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

        if (!(obj instanceof Subscriptor)) {
            return false;
        }

        Subscriptor subscriptor = (Subscriptor) obj;

        long primaryKey = subscriptor.getPrimaryKey();

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
        SubscriptorModelImpl subscriptorModelImpl = this;

        subscriptorModelImpl._originalUuid = subscriptorModelImpl._uuid;

        subscriptorModelImpl._originalCompanyId = subscriptorModelImpl._companyId;

        subscriptorModelImpl._setOriginalCompanyId = false;

        subscriptorModelImpl._originalGroupId = subscriptorModelImpl._groupId;

        subscriptorModelImpl._setOriginalGroupId = false;

        subscriptorModelImpl._originalEmail = subscriptorModelImpl._email;

        subscriptorModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<Subscriptor> toCacheModel() {
        SubscriptorCacheModel subscriptorCacheModel = new SubscriptorCacheModel();

        subscriptorCacheModel.uuid = getUuid();

        String uuid = subscriptorCacheModel.uuid;

        if ((uuid != null) && (uuid.length() == 0)) {
            subscriptorCacheModel.uuid = null;
        }

        subscriptorCacheModel.subscriptorId = getSubscriptorId();

        subscriptorCacheModel.companyId = getCompanyId();

        subscriptorCacheModel.groupId = getGroupId();

        subscriptorCacheModel.name = getName();

        String name = subscriptorCacheModel.name;

        if ((name != null) && (name.length() == 0)) {
            subscriptorCacheModel.name = null;
        }

        subscriptorCacheModel.surname = getSurname();

        String surname = subscriptorCacheModel.surname;

        if ((surname != null) && (surname.length() == 0)) {
            subscriptorCacheModel.surname = null;
        }

        subscriptorCacheModel.email = getEmail();

        String email = subscriptorCacheModel.email;

        if ((email != null) && (email.length() == 0)) {
            subscriptorCacheModel.email = null;
        }

        subscriptorCacheModel.languageId = getLanguageId();

        String languageId = subscriptorCacheModel.languageId;

        if ((languageId != null) && (languageId.length() == 0)) {
            subscriptorCacheModel.languageId = null;
        }

        subscriptorCacheModel.selfSubscribe = getSelfSubscribe();

        return subscriptorCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", subscriptorId=");
        sb.append(getSubscriptorId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", surname=");
        sb.append(getSurname());
        sb.append(", email=");
        sb.append(getEmail());
        sb.append(", languageId=");
        sb.append(getLanguageId());
        sb.append(", selfSubscribe=");
        sb.append(getSelfSubscribe());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(31);

        sb.append("<model><model-name>");
        sb.append("net.zylk.liferay.portal.model.Subscriptor");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>subscriptorId</column-name><column-value><![CDATA[");
        sb.append(getSubscriptorId());
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
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>surname</column-name><column-value><![CDATA[");
        sb.append(getSurname());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>email</column-name><column-value><![CDATA[");
        sb.append(getEmail());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>languageId</column-name><column-value><![CDATA[");
        sb.append(getLanguageId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>selfSubscribe</column-name><column-value><![CDATA[");
        sb.append(getSelfSubscribe());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
