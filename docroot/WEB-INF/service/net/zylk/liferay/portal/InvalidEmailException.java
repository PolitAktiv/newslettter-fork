package net.zylk.liferay.portal;

import com.liferay.portal.kernel.exception.PortalException;


public class InvalidEmailException extends PortalException {

	public InvalidEmailException() {
		super();
	}

	public InvalidEmailException(String msg) {
		super(msg);
	}

	public InvalidEmailException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public InvalidEmailException(Throwable cause) {
		super(cause);
	}

}