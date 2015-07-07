package com.andriidnikitin.appletapp.commons;

public class AppletProjectException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected AppletProjectException() {
		super();
	}

	protected AppletProjectException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	protected AppletProjectException(String message, Throwable cause) {
		super(message, cause);
	}

	protected AppletProjectException(String message) {
		super(message);
	}

	protected AppletProjectException(Throwable cause) {
		super(cause);
	}
	
	

}
