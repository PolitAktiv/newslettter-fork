package net.zylk.liferay.portal.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import net.zylk.liferay.portal.service.CategoryLocalServiceUtil;
import net.zylk.liferay.portal.service.ClpSerializer;
import net.zylk.liferay.portal.service.MailingLangLocalServiceUtil;
import net.zylk.liferay.portal.service.MailingLocalServiceUtil;
import net.zylk.liferay.portal.service.MailingSubscriptorLocalServiceUtil;
import net.zylk.liferay.portal.service.NewsletterLocalServiceUtil;
import net.zylk.liferay.portal.service.SubscriptorCategoryLocalServiceUtil;
import net.zylk.liferay.portal.service.SubscriptorLocalServiceUtil;
import net.zylk.liferay.portal.service.UserSubscriptionLocalServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            CategoryLocalServiceUtil.clearService();

            MailingLocalServiceUtil.clearService();

            MailingLangLocalServiceUtil.clearService();

            MailingSubscriptorLocalServiceUtil.clearService();

            NewsletterLocalServiceUtil.clearService();

            SubscriptorLocalServiceUtil.clearService();

            SubscriptorCategoryLocalServiceUtil.clearService();

            UserSubscriptionLocalServiceUtil.clearService();
        }
    }
}
