package net.zylk.liferay.portal;

import com.liferay.portal.kernel.exception.PortalException;


public class NewsletterArticleException extends PortalException {

	public NewsletterArticleException() {
		super();
	}

	public NewsletterArticleException(String msg) {
		super(msg);
	}

	public NewsletterArticleException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NewsletterArticleException(Throwable cause) {
		super(cause);
	}

}