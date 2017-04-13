package net.zylk.liferay.portal;

import com.liferay.portal.kernel.exception.PortalException;


public class EmptyCategoryListException extends PortalException {

	public EmptyCategoryListException() {
		super();
	}

	public EmptyCategoryListException(String msg) {
		super(msg);
	}

	public EmptyCategoryListException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public EmptyCategoryListException(Throwable cause) {
		super(cause);
	}

}