package net.zylk.liferay.portal.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the Subscriptor service. Represents a row in the &quot;ZN_Subscriptor&quot; database table, with each column mapped to a property of this class.
 *
 * @author zylk.net
 * @see SubscriptorModel
 * @see net.zylk.liferay.portal.model.impl.SubscriptorImpl
 * @see net.zylk.liferay.portal.model.impl.SubscriptorModelImpl
 * @generated
 */
public interface Subscriptor extends SubscriptorModel, PersistedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this interface directly. Add methods to {@link net.zylk.liferay.portal.model.impl.SubscriptorImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */
    public java.lang.String getFullName();
}
