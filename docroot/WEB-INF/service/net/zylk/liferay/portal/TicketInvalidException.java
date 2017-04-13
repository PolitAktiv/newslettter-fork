package net.zylk.liferay.portal;

import com.liferay.portal.kernel.exception.PortalException;


public class TicketInvalidException extends PortalException {

	public TicketInvalidException() {
		super();
	}

	public TicketInvalidException(String msg) {
		super(msg);
	}

	public TicketInvalidException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public TicketInvalidException(Throwable cause) {
		super(cause);
	}

}