package net.zylk.liferay.portal.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import net.zylk.liferay.portal.model.Mailing;
import net.zylk.liferay.portal.service.MailingLocalServiceUtil;

/**
 * The extended model base implementation for the Mailing service. Represents a row in the &quot;ZN_Mailing&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MailingImpl}.
 * </p>
 *
 * @author zylk.net
 * @see MailingImpl
 * @see net.zylk.liferay.portal.model.Mailing
 * @generated
 */
public abstract class MailingBaseImpl extends MailingModelImpl
    implements Mailing {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a mailing model instance should use the {@link Mailing} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            MailingLocalServiceUtil.addMailing(this);
        } else {
            MailingLocalServiceUtil.updateMailing(this);
        }
    }
}
