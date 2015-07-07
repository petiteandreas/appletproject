package com.andriidnikitin.appletapp.commons;


public class AppletProjectUnableToAddException extends
		AppletProjectException {

	public AppletProjectUnableToAddException(AppletProjectPersistenceException e) {
		super(e);
	}

	public AppletProjectUnableToAddException(String string) {
		super(string);
	}

	public AppletProjectUnableToAddException(AppletProjectException e) {
		super(e);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
