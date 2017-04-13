package net.zylk.liferay.portal;

import com.liferay.portal.kernel.exception.PortalException;


public class CancelMailingException extends PortalException {

	public CancelMailingException() {
		super();
	}

	public CancelMailingException(String msg) {
		super(msg);
	}

	public CancelMailingException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public CancelMailingException(Throwable cause) {
		super(cause);
	}

}