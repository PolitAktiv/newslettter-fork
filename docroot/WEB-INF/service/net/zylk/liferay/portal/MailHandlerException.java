package net.zylk.liferay.portal;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author zylk.net
 */
public class MailHandlerException extends PortalException {

	public MailHandlerException() {
		super();
	}

	public MailHandlerException(String msg) {
		super(msg);
	}

	public MailHandlerException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public MailHandlerException(Throwable cause) {
		super(cause);
	}

}