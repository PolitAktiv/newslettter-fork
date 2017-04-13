package net.zylk.liferay.portal;

import com.liferay.portal.kernel.exception.PortalException;


public class DuplicateSubscriptorException extends PortalException {

	public DuplicateSubscriptorException() {
		super();
	}

	public DuplicateSubscriptorException(String msg) {
		super(msg);
	}

	public DuplicateSubscriptorException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateSubscriptorException(Throwable cause) {
		super(cause);
	}

}