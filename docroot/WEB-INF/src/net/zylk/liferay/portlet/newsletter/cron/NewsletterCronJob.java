package net.zylk.liferay.portlet.newsletter.cron;

import java.util.Date;
import java.util.List;

import net.zylk.liferay.portal.model.Newsletter;
import net.zylk.liferay.portal.service.MailingLocalServiceUtil;
import net.zylk.liferay.portal.service.NewsletterLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

public class NewsletterCronJob implements MessageListener {

	private static Log _log = LogFactoryUtil.getLog(NewsletterCronJob.class);

	public void receive(Message message) throws MessageListenerException {

		try {
			
			_log.info("scheduler starts...");
			
			// TODO solo las activas?
			List<Newsletter> newsletters = NewsletterLocalServiceUtil.findAll();

			for (Newsletter newsletter : newsletters) {

				Date sendDate = MailingLocalServiceUtil.isExecutionRequired(newsletter);

				if (sendDate != null) {
					_log.info("needsExecution true");
					NewsletterLocalServiceUtil.send(newsletter.getNewsletterId(), sendDate, true);
				}
			}

			_log.info("scheduler executed");

		} catch (SystemException e) {
			throw new MessageListenerException(e);
		} catch (PortalException e) {
			throw new MessageListenerException(e);
		}
		
	}
	

}
