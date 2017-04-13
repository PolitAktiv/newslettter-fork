package net.zylk.liferay.portal;

import com.liferay.portal.kernel.exception.PortalException;


public class ImportException extends PortalException {

	public ImportException() {
		super();
	}

	public ImportException(String msg) {
		super(msg);
	}

	public ImportException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ImportException(Throwable cause) {
		super(cause);
	}

}