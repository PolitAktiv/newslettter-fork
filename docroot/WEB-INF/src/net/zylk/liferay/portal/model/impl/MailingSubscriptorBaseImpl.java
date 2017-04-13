package net.zylk.liferay.portal.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import net.zylk.liferay.portal.model.MailingSubscriptor;
import net.zylk.liferay.portal.service.MailingSubscriptorLocalServiceUtil;

/**
 * The extended model base implementation for the MailingSubscriptor service. Represents a row in the &quot;ZN_MailingSubscriptor&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MailingSubscriptorImpl}.
 * </p>
 *
 * @author zylk.net
 * @see MailingSubscriptorImpl
 * @see net.zylk.liferay.portal.model.MailingSubscriptor
 * @generated
 */
public abstract class MailingSubscriptorBaseImpl
    extends MailingSubscriptorModelImpl implements MailingSubscriptor {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a mailing subscriptor model instance should use the {@link MailingSubscriptor} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            MailingSubscriptorLocalServiceUtil.addMailingSubscriptor(this);
        } else {
            MailingSubscriptorLocalServiceUtil.updateMailingSubscriptor(this);
        }
    }
}
